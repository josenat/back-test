package renfe.com.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import renfe.com.ConfigProperties;
import renfe.com.dto.SubOptionLevelDTO;
import renfe.com.dto.UserDTO;
import renfe.com.dto.UserOptionDTO;
import renfe.com.dto.UserRoleDTO;
import renfe.com.dto.UserSubOptionDTO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	protected Logger logger;
	@Autowired
	LDAPService ldapService;
	@Autowired
	ArproService arproService;

	@PersistenceContext
	private EntityManager em;

	
	@Value("${application.tokenkey}")
	private String tokenkey;

	
	@Override
	public boolean checkLdapAccess(String username, String password) {
		boolean res = false;
		try {
			res = ldapService.login(username, password);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			res = false;
		}
		return res;
	}
	
	@Override
	public boolean checkArproAccess(String user) {
		return arproService.checkAccess(user);
	}
	
	@Override
	public List<UserRoleDTO> getSubOptionRoles( String iduser, String option, String suboption) {
		List<UserRoleDTO> result =  arproService.getUserOptionRoles(iduser, option, suboption);
		for (UserRoleDTO userRoleDTO : result) {
			ArrayList<SubOptionLevelDTO>  listLevels  = (ArrayList<SubOptionLevelDTO>) this.getSubOptionLevels(iduser, option, suboption, userRoleDTO.getCdgoRolmaster());
			userRoleDTO.setLevels(listLevels);
		}
		
		return result;
	}
	
	@Override
	public List<SubOptionLevelDTO> getSubOptionLevels(String iduser, String option, String suboption, String role) {

		return arproService.getSubOptionLevels(iduser, option, suboption, role);
	}
	
	
	@Override
	public UserDTO getUserData(String iduser) {
		UserDTO user = null;
		try {
			user = arproService.getUserDetails(iduser);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			user = null;
		}
		if (user != null) {
			// Obtengo las opciones de usuario
			user.setCdgoUsuario(iduser);
			user.setOptions(arproService.getUserOptions(iduser));
			if (user.getOptions() != null) {
				// Obtengo cada una de las sub opciones de cada opcion
				for (UserOptionDTO option : user.getOptions()) {
					List<UserSubOptionDTO> subOptions = arproService.getUserSubOption(iduser, option.getCdgoProceso());
					option.setSubOptions(subOptions);
				}
			}
			
		}
		return user;
	}
	/**
	 * Get JWT Token
	 * @param username
	 * @return
	 */
	@Override
	public String getJWTToken(String username) {
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("asgJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 
						(600000) * 6))
				.signWith(SignatureAlgorithm.HS512,
						tokenkey.getBytes()).compact();

		return "Bearer " + token;
	}
	

}
