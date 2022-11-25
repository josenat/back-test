package renfe.com.service;

import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Service;

import renfe.com.dto.SubOptionLevelDTO;
import renfe.com.dto.UserDTO;
import renfe.com.dto.UserOptionDTO;
import renfe.com.dto.UserRoleDTO;
import renfe.com.dto.UserSubOptionDTO;

@Service
public interface ArproService {
	public UserDTO getUserDetails(String idUser);

	public List<UserOptionDTO> getUserOptions(String idUser);

	public List<UserSubOptionDTO> getUserSubOption(String idUser, String idProceso);

	public List<UserRoleDTO> getUserOptionRoles(String idUser, String idOption, String subOption);

	public boolean checkAccess(String user);
	
	public int getNumeroNivelesUsuarioRol(String user, String cdgoProceso, String cdgoSubproceso, String cdgoRolmaster);
	
	public List<SubOptionLevelDTO> getSubOptionLevels(String iduser, String option, String suboption, String role);
	
}
