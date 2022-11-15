package renfe.com.controller;


import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import renfe.com.dto.LoginDTO;
import renfe.com.dto.UserDTO;
import renfe.com.dto.UserOptionDTO;
import renfe.com.dto.UserRoleDTO;
import renfe.com.dto.UserSubOptionDTO;
import renfe.com.service.ArproService;
import renfe.com.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping(value = "/login")
	public UserDTO login(@RequestBody LoginDTO login) {

		// CHECK LDAP USER
		if (userService.checkLdapAccess(login.getUsername(), login.getPassword())) {
			if (userService.checkArproAccess(login.getUsername())) {
				// Get options and user data
				UserDTO user = userService.getUserData(login.getUsername());
				return user;
			}
		}
		return null;

	}
	
	@GetMapping(value = "/get-user-suboption-roles")
	public List<UserRoleDTO> getUserSubOptionRoles(String idUsuario, String option, String subOption) {
		return userService.getSubOptionRoles(idUsuario, option, subOption);
	}
	
}
