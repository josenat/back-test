package renfe.com.service;

import renfe.com.dto.UserDTO;

public interface LDAPService {
	/**
	 * Autenticación del usuario contra RDA con perfiles
	 * @param strUser
	 * @param strPassword
	 * @return
	 */
	public boolean login(String strUser, String strPassword);
	
}
