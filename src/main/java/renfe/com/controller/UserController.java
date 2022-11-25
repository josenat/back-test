package renfe.com.controller;


import java.security.Principal;
import java.util.List;
import java.util.Vector;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import renfe.com.dto.LoginDTO;
import renfe.com.dto.SubOptionLevelDTO;
import renfe.com.dto.TokenDTO;
import renfe.com.dto.UserDTO;
import renfe.com.dto.UserOptionDTO;
import renfe.com.dto.UserRoleDTO;
import renfe.com.dto.UserSubOptionDTO;
import renfe.com.model.dto.Tbasg100PersonaDto;
import renfe.com.service.ArproService;
import renfe.com.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/asg/api/user")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	protected Logger logger;
	
	@PostMapping(value = "/login")
	public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO login) {
		// CHECK LDAP USER
		TokenDTO dto = new TokenDTO();
		
		
		logger.debug("Login request ");
		
		try {
			if (userService.checkLdapAccess(login.getUsername(), login.getPassword())) {
				if (userService.checkArproAccess(login.getUsername())) {
					// Get options and user data
					dto.setToken(userService.getJWTToken(login.getUsername()));
					return new ResponseEntity<>(dto, HttpStatus.OK);
				}
			}			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return new ResponseEntity<>(dto, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
	}
	
	@GetMapping(value = "/get-user-data")
	public ResponseEntity<UserDTO> getUserData(Principal principal) {
		UserDTO dto = null;
		try {
			dto = userService.getUserData(principal.getName());
			if(dto!=null) {
				return new ResponseEntity<>(dto, HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
		return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/get-user-suboption-roles")
	public ResponseEntity<List<UserRoleDTO>>  getUserSubOptionRoles(Principal principal, String option, String subOption) {
		List<UserRoleDTO> dto = userService.getSubOptionRoles(principal.getName(), option, subOption);
		if(dto!=null) {
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
		return new ResponseEntity<>(dto, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
	}
	
	@GetMapping(value = "/get-suboption-roles-levels")
	public ResponseEntity<List<SubOptionLevelDTO>> getSuboptionRolesLevels(Principal principal, String option, String subOption, String rol) {
		System.out.println(principal.getName()+","+option+","+subOption+","+rol);

		List<SubOptionLevelDTO> dto = userService.getSubOptionLevels(principal.getName(), option, subOption,rol);
		if(dto!=null) {
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
		return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
	}
	
	
}
