package renfe.com.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public boolean checkLdapAccess(String username, String password) {
		boolean res = false;
		try {
			res = ldapService.login(username, password);
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
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
		return arproService.getUserOptionRoles(iduser, option, suboption);
	}
	
	@Override
	public UserDTO getUserData(String iduser) {
		UserDTO user = null;
		try {
			user = arproService.getUserDetails(iduser);
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
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
					option.setSubOption(subOptions);
//					for(UserSubOptionDTO suboption: subOptions) {
//						List<UserRoleDTO> rolesSubOption = arproService.getUserOptionRoles(iduser, option.getCdgoProceso(), suboption.getCdgoSubproceso());
//						//String user, String cdgoProceso, String cdgoSubproceso, String cdgoRolmaster
//						for(UserRoleDTO rol : rolesSubOption) {
//							arproService.getNumeroNivelesUsuarioRol(user.getCdgoUsuario(), option.getCdgoProceso(), suboption.getCdgoSubproceso(),rol.getCdgoRolmaster());							
//						}
//						suboption.setRoles(rolesSubOption);
//					}
				}
			}
		}
		return user;
	}
	

}
