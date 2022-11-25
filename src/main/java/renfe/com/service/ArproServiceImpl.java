package renfe.com.service;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Service;

import renfe.com.dto.SubOptionLevelDTO;
import renfe.com.dto.UserDTO;
import renfe.com.dto.UserOptionDTO;
import renfe.com.dto.UserRoleDTO;
import renfe.com.dto.UserSubOptionDTO;

@Service
public class ArproServiceImpl implements ArproService {
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean checkAccess(String user) {
		String sqlString = "SELECT\r\n" + "    count(DISTINCT(TBAP0000.CDGO_APLICACION))\r\n" + "FROM\r\n"
				+ "    PAP0.TBAP0000_APLICAC TBAP0000\r\n" + "INNER JOIN\r\n" + "    PAP0.TBAP0006_PROCESO TBAP0006\r\n"
				+ "ON\r\n" + "    TBAP0006.CDGO_APLICACION=TBAP0000.CDGO_APLICACION\r\n"
				+ "AND TBAP0006.MRCA_ACTIVO='S'\r\n" + "INNER JOIN\r\n" + "    PAP0.TBAP0004_USUNIVROL TBAP0004\r\n"
				+ "ON\r\n" + "    TBAP0004.CDGO_PROCESO=TBAP0006.CDGO_PROCESO\r\n" + "INNER JOIN\r\n"
				+ "    PAP0.TBAP0002_USUARIO TBAP0002\r\n" + "ON\r\n"
				+ "    TBAP0002.CDGO_USUARIO=TBAP0004.CDGO_USUARIO\r\n" + "WHERE\r\n"
				+ "    TBAP0002.CDGO_USUARIO=:value\r\n" + "AND TBAP0000.CDGO_APLICACION='ASG'\r\n"
				+ "AND TBAP0000.MRCA_ACTIVO = 'S'";

		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", user);
		int occ = (int) sqlquery.getSingleResult();
		return (occ > 0);
	}

	@Override
	public UserDTO getUserDetails(String iduser) {
		UserDTO user = new UserDTO();
		String sqlString = "SELECT\r\n" + "    TBAP0002.CDGO_CENCONTABLE,\r\n" + "    TBAP0002.CDGO_ESTADO,\r\n"
				+ "    TBAP0002.CDGO_MATRICULA,\r\n" + "    TBAP0002.CDGO_UNE,\r\n" + "    TBAP0002.DESG_CARGO,\r\n"
				+ "    TBAP0002.DESG_MAIL,\r\n" + "    TBAP0002.DESG_USUARIO,\r\n" + "    TBAP0002.CDGO_NIVEL,\r\n" 
				+ "    TBAP0031.CDGO_ROL\r\n"
				+ "FROM\r\n" + "    PAP0.TBAP0002_USUARIO TBAP0002\r\n"
				+ "	INNER JOIN PAP0.TBAP0031_USUA_APLI TBAP0031\r\n"
				+ "	ON TBAP0002.CDGO_USUARIO=TBAP0031.CDGO_USUARIO\r\n"
				+ "    INNER JOIN PAP0.TBAP0006_PROCESO TBAP0006 \r\n"
				+ "	ON TBAP0006.CDGO_PROCESO=TBAP0031.CDGO_PROCESO\r\n"
				+ "    INNER JOIN PAP0.TBAP0007_SUBPROC TBAP0007 \r\n"
				+ "	ON TBAP0007.CDGO_PROCESO=TBAP0031.CDGO_PROCESO\r\n"
				+ "	AND TBAP0007.CDGO_SUBPROCESO=TBAP0031.CDGO_SUBPROCESO\r\n"
				+ "    INNER JOIN PAP0.TBAP0011_ROL TBAP0011 \r\n"
				+ "	ON TBAP0011.CDGO_PROCESO=TBAP0031.CDGO_PROCESO\r\n"
				+ "	AND TBAP0011.CDGO_SUBPROCESO=TBAP0031.CDGO_SUBPROCESO\r\n"
				+ "	AND TBAP0011.CDGO_ROL=TBAP0031.CDGO_ROL\r\n" + "	INNER JOIN PAP0.TBAP0015_VISTA TBAP0015 \r\n"
				+ "	ON TBAP0011.CDGO_VISTA=TBAP0015.CDGO_VISTA\r\n" + "    \r\n" + "WHERE\r\n"
				+ " TBAP0002.CDGO_USUARIO=:value\r\n" + "AND TBAP0002.MRCA_ACTIVA='S'\r\n"
				+ "AND TBAP0031.CDGO_APLICACION='ASG'\r\n" + "AND TBAP0031.MRCA_ACTIVA='S'";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", iduser);
		Object[] res = (Object[]) sqlquery.getSingleResult();
		if (res != null) {
			user = mapperQueryUserDetails(res);
		}
		return user;
	}

	@Override
	public List<UserOptionDTO> getUserOptions(String idUser) {
		List<UserOptionDTO> res = new ArrayList<UserOptionDTO>();
		String sqlString = "SELECT DISTINCT\r\n" + "    TBAP0006.CDGO_PROCESO,\r\n" + "    TBAP0006.DESG_PROCESO,\r\n"
				+ "    TBAP0006.DESG_AYUDA\r\n, TBAP0006.CDGO_ORDEN\r\n" + "FROM\r\n"
				+ "    PAP0.TBAP0006_PROCESO TBAP0006\r\n" + "INNER JOIN\r\n" + "    PAP0.TBAP0007_SUBPROC TBAP0007\r\n"
				+ "ON\r\n" + "    TBAP0006.CDGO_PROCESO=TBAP0007.CDGO_PROCESO\r\n" + "INNER JOIN\r\n"
				+ "    PAP0.TBAP0004_USUNIVROL TBAP0004\r\n" + "ON\r\n"
				+ "    TBAP0006.CDGO_PROCESO=TBAP0004.CDGO_PROCESO\r\n" + "WHERE\r\n"
				+ "    TBAP0006.CDGO_APLICACION='ASG'\r\n" + "AND TBAP0006.MRCA_VISIBLE='S'\r\n"
				+ "AND TBAP0006.MRCA_ACTIVO='S'\r\n" + "AND TBAP0007.MRCA_ACTIVO='S'\r\n"
				+ "AND TBAP0007.MRCA_VISIBLE='S'\r\n" + "AND TBAP0004.CDGO_USUARIO=:value order by TBAP0006.CDGO_ORDEN";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", idUser);
		List obj = sqlquery.getResultList();
		if (obj != null) {
			res = mapperQueryUserOption(obj);
		}
		return res;
	}

	@Override
	public List<UserSubOptionDTO> getUserSubOption(String idUser, String idProceso) {
		List<UserSubOptionDTO> res = new ArrayList<UserSubOptionDTO>();
		String sqlString = "SELECT\r\n" + "    distinct\r\n" + "    TBAP0007.CDGO_SUBPROCESO,\r\n"
				+ "    TBAP0007.DESG_SUBPROCESO,\r\n" + "    TBAP0007.DESG_AYUDA,\r\n" + "    TBAP0007.CDGO_ENTIDAD,\r\n TBAP0007.CDGO_ORDEN\r\n"
				+ "FROM\r\n" + "    PAP0.TBAP0007_SUBPROC TBAP0007\r\n" + "INNER JOIN\r\n"
				+ "    PAP0.TBAP0004_USUNIVROL TBAP0004\r\n" + "ON\r\n"
				+ "    TBAP0007.CDGO_SUBPROCESO = TBAP0004.CDGO_SUBPROCESO\r\n"
				+ "AND TBAP0007.CDGO_PROCESO = TBAP0004.CDGO_PROCESO\r\n" + "WHERE\r\n"
				+ "    TBAP0007.MRCA_ACTIVO='S'\r\n" + "AND TBAP0007.MRCA_VISIBLE='S'\r\n"
				+ "AND TBAP0007.CDGO_PROCESO = :cdgoProceso\r\n" + "AND TBAP0004.CDGO_USUARIO=:idUsuario order by TBAP0007.CDGO_ORDEN";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("idUsuario", idUser);
		sqlquery.setParameter("cdgoProceso", idProceso);

		List<Object[]> obj = sqlquery.getResultList();
		if (obj != null) {
			res = mapperQueryUserSubOption(obj);
		}
		return res;
	}
	@Override
	public List<SubOptionLevelDTO> getSubOptionLevels(String iduser, String option, String suboption, String role){
		System.out.println(iduser+","+option+","+suboption+","+role);
		List<SubOptionLevelDTO> res = new ArrayList<SubOptionLevelDTO>();
		String sqlString = "SELECT DISTINCT\r\n"
				+ "    TBAP0004.CDGO_NIVEL,\r\n"
				+ "    TBAP0003.DESG_VALONIVEL,\r\n"
				+ "    TBAP0003.CDGO_MASCARA,\r\n"
				+ "    TBAP0004.MRCA_AMBITOHIJOS\r\n"
				+ "FROM\r\n"
				+ "    PAP0.TBAP0004_USUNIVROL TBAP0004,\r\n"
				+ "    PAP0.TBAP0011_ROL TBAP0011,\r\n"
				+ "    PAP0.TBAP0003_NIVEL TBAP0003\r\n"
				+ "WHERE\r\n"
				+ "    TBAP0011.CDGO_PROCESO=TBAP0004.CDGO_PROCESO\r\n"
				+ "AND TBAP0011.CDGO_SUBPROCESO=TBAP0004.CDGO_SUBPROCESO\r\n"
				+ "AND TBAP0011.CDGO_ROL=TBAP0004.CDGO_ROL\r\n"
				+ "AND TBAP0004.CDGO_NIVEL=TBAP0003.CDGO_NIVEL\r\n"
				+ "AND TBAP0004.CDGO_PROCESO=:option\r\n"
				+ "AND TBAP0004.CDGO_SUBPROCESO=:suboption\r\n"
				+ "AND TBAP0011.CDGO_ROLMASTER=:role\r\n"
				+ "AND TBAP0004.CDGO_USUARIO=:user\r\n"
				+ "AND TBAP0011.MRCA_ACTIVO='S'\r\n"
				+ "AND TBAP0003.MRCA_ACTIVO='S'";
				
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("user", iduser);
		sqlquery.setParameter("option", option);
		sqlquery.setParameter("suboption", suboption);
		sqlquery.setParameter("role", role);


		List<Object[]> obj = sqlquery.getResultList();
		if (obj != null) {
			res = mapperQuerySubOptionLevel(obj);
		}
		return res;	
	}
	@Override
	public List<UserRoleDTO> getUserOptionRoles(String idUser, String idOption, String subOption) {
		List<UserRoleDTO> res = new ArrayList<UserRoleDTO>();
		String sqlString = "SELECT\r\n"
				+ "    DISTINCT\r\n"
				+ "    TBAP0011.DESG_ROL,\r\n"
				+ "    TBAP0011.CDGO_ROLMASTER\r\n"
				+ "FROM\r\n"
				+ "    PAP0.TBAP0011_ROL TBAP0011\r\n"
				+ "INNER JOIN\r\n"
				+ "    PAP0.TBAP0015_VISTA TBAP0015\r\n"
				+ "ON\r\n"
				+ "    TBAP0015.CDGO_VISTA = TBAP0011.CDGO_VISTA\r\n"
				+ "INNER JOIN\r\n"
				+ "    PAP0.TBAP0004_USUNIVROL TBAP0004\r\n"
				+ "ON\r\n"
				+ "    TBAP0011.CDGO_ROL=TBAP0004.CDGO_ROL \r\n"
				+ "    AND TBAP0011.CDGO_SUBPROCESO = TBAP0004.CDGO_SUBPROCESO\r\n"
				+ "    AND TBAP0011.CDGO_PROCESO = TBAP0004.CDGO_PROCESO\r\n"
				+ "\r\n"
				+ "WHERE\r\n"
				+ "    TBAP0015.MRCA_ACTIVA='S'\r\n"
				+ "AND TBAP0011.MRCA_ACTIVO='S'\r\n"
				+ "\r\n"
				+ "AND TBAP0004.CDGO_USUARIO=:cdgoUsuario\r\n"
				+ "AND TBAP0011.CDGO_PROCESO=:cdgoProceso\r\n"
				+ "AND TBAP0011.CDGO_SUBPROCESO= :cdgoSubproceso";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("cdgoUsuario", idUser);
		sqlquery.setParameter("cdgoProceso", idOption);
		sqlquery.setParameter("cdgoSubproceso", subOption);

		List<Object[]> obj = sqlquery.getResultList();
		if (obj != null) {
			res = mapperQueryUserOptionRoles(obj);
		}
		return res;	
	}
	@Override
	public int getNumeroNivelesUsuarioRol(String user, String cdgoProceso, String cdgoSubproceso,
		String cdgoRolmaster) {
		String sqlString = "SELECT\r\n"
				+ "    COUNT(*) AS CTE_COUNT\r\n"
				+ "FROM PAP0.TBAP0004_USUNIVROL TBAP0004, PAP0.TBAP0011_ROL TBAP0011 WHERE TBAP0011.CDGO_PROCESO=\r\n"
				+ "TBAP0004.CDGO_PROCESO\r\n"
				+ "AND\r\n"
				+ "TBAP0011.CDGO_SUBPROCESO=TBAP0004.CDGO_SUBPROCESO\r\n"
				+ "AND\r\n"
				+ "TBAP0011.CDGO_ROL=TBAP0004.CDGO_ROL\r\n"
				+ "AND\r\n"
				+ "TBAP0004.CDGO_USUARIO= :cdgoUsuario\r\n"
				+ "AND\r\n"
				+ "TBAP0004.CDGO_PROCESO= :cdgoProceso\r\n"
				+ "AND\r\n"
				+ "TBAP0004.CDGO_SUBPROCESO= :cdgoSubproceso\r\n"
				+ "AND\r\n"
				+ "TBAP0011.CDGO_ROLMASTER= :cdgoRolmaster\r\n"
				+ "AND\r\n"
				+ "TBAP0011.MRCA_ACTIVO='S'";

		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("cdgoUsuario", user);
		sqlquery.setParameter("cdgoProceso", cdgoProceso);
		sqlquery.setParameter("cdgoSubproceso", cdgoSubproceso);
		sqlquery.setParameter("cdgoRolmaster", cdgoRolmaster);

		int result = (int) sqlquery.getSingleResult();
		return result;
	}
	private UserDTO mapperQueryUserDetails(Object[] res) {
		UserDTO user = new UserDTO();
		user.setCdgoCencontable(String.valueOf(res[0]).trim());
		user.setCdgoEstado(String.valueOf(res[1]).trim());
		user.setCdgoMatricula(String.valueOf(res[2]).trim());
		user.setCdgoUne(String.valueOf(res[3]).trim());
		user.setDesgCargo(String.valueOf(res[4]).trim());
		user.setDesgMail(String.valueOf(res[5]).trim());
		user.setDesgUsuario(String.valueOf(res[6]).trim());
		user.setCdgoNivel(String.valueOf(res[7]).trim());
		user.setCdgoRol(String.valueOf(res[8]).trim());
		return user;
	}

	private List<UserOptionDTO> mapperQueryUserOption(List<Object[]> objArr) {
		List<UserOptionDTO> array = new ArrayList<UserOptionDTO>();
		for (Object[] obj : objArr) {
			UserOptionDTO userOption = new UserOptionDTO();
			userOption.setCdgoProceso(String.valueOf(obj[0]).trim());
			userOption.setDesgProceso(String.valueOf(obj[1]).trim());
			userOption.setDesgAyuda(String.valueOf(obj[2]).trim());
			array.add(userOption);
		}
		return array;
	}

	private List<UserRoleDTO> mapperQueryUserOptionRoles(List<Object[]> objArr) {
		List<UserRoleDTO> array = new ArrayList<UserRoleDTO>();
		for (Object[] obj : objArr) {
			UserRoleDTO userRole = new UserRoleDTO();
			userRole.setDesgRol(String.valueOf(obj[0]).trim());
			userRole.setCdgoRolmaster(String.valueOf(obj[1]).trim());
			array.add(userRole);
		}
		return array;
	}
	private List<SubOptionLevelDTO> mapperQuerySubOptionLevel(List<Object[]> objArr) {
		List<SubOptionLevelDTO> array = new ArrayList<SubOptionLevelDTO>();
		for (Object[] obj : objArr) {
			SubOptionLevelDTO userRole = new SubOptionLevelDTO();
			userRole.setCdgoNivel(String.valueOf(obj[0]).trim());
			userRole.setDesgValorNivel(String.valueOf(obj[1]).trim());
			userRole.setCdgoMascara(String.valueOf(obj[2]).trim());
			userRole.setMrcaAmbitoHijos(String.valueOf(obj[3]).trim());
			
			array.add(userRole);
		}
		return array;
	}
	private List<UserSubOptionDTO> mapperQueryUserSubOption(List<Object[]> objArr) {
		List<UserSubOptionDTO> array = new ArrayList<UserSubOptionDTO>();
		for (Object[] obj : objArr) {
			UserSubOptionDTO userSubOption = new UserSubOptionDTO();
			userSubOption.setCdgoSubproceso(String.valueOf(obj[0]).trim());
			userSubOption.setDesgSubproceso(String.valueOf(obj[1]).trim());
			userSubOption.setDesgAyuda(String.valueOf(obj[2]).trim());
			userSubOption.setCdgoEntidad(String.valueOf(obj[3]).trim());
			array.add(userSubOption);
		}
		return array;
	}
	
	
}
