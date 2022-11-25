package renfe.com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import renfe.com.dto.SubOptionLevelDTO;
import renfe.com.dto.UserDTO;
import renfe.com.dto.UserRoleDTO;

@Service
public interface UserService {
	
	/**
	 * Autenticación del usuario
	 * 
	 * @return UserDto
	 */
	public boolean checkLdapAccess(String user, String password);
	public boolean checkArproAccess(String user);
	public String getJWTToken(String user);
	public UserDTO getUserData(String user);
	public List<UserRoleDTO> getSubOptionRoles(String iduser, String option, String suboption);
	public List<SubOptionLevelDTO> getSubOptionLevels(String iduser, String option, String suboption, String role);

}
