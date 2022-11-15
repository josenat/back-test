package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.dto.GetUsuarioExternoListAscendenteDTO;
import renfe.com.model.entity.Tbasg220UsuariosExternos;
import renfe.com.repository.Tbasg220UsuariosExternosRepositoryCustom;

public class Tbasg220UsuariosExternosRepositoryImpl implements Tbasg220UsuariosExternosRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg220UsuariosExternos> getEmpresasDeUsuario(String t220CdgoUsuario) {

		String sqlString = "SELECT T220_CDGO_EMPRESA FROM PASG.TBASG220_USUARIOS_EXTERNOS WHERE T220_CDGO_USUARIO=:value AND T220_MRCA_ACTIVO='S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg220UsuariosExternos.class);
		sqlquery.setParameter("value", t220CdgoUsuario);
		return sqlquery.getResultList();
	}

	public List<Tbasg220UsuariosExternos> getUsuarioExternoCount() {

		String sqlString = "SELECT COUNT(1) as value FROM PASG.TBASG220_USUARIOS_EXTERNOS";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg220UsuariosExternos.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg220UsuariosExternos> getEmpresaDeUsuarioCount(String t220CdgoUsuario) {

		String sqlString = "SELECT COUNT(1) as value FROM PASG.TBASG220_USUARIOS_EXTERNOS WHERE T220_CDGO_USUARIO=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg220UsuariosExternos.class);
		sqlquery.setParameter("value", t220CdgoUsuario);
		return sqlquery.getResultList();
	}

	public List<GetUsuarioExternoListAscendenteDTO> getUsuarioExternoListAscendente() {

		String sqlString = "SELECT U.*, E.DESG_NOMBRE FROM PASG.TBASG220_USUARIOS_EXTERNOS U INNER JOIN PASG.TBASG125_EMPRESA E "
				+ "ON U.T220_CDGO_EMPRESA = E.CDGO_EMPRESA ORDER BY U.T220_CDGO_USU_EXT ";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetUsuarioExternoListAscendenteDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetUsuarioExternoListAscendenteDTO usuexternos = new GetUsuarioExternoListAscendenteDTO();
			
			usuexternos.setT220CdgoUsuExt((Integer)object[0]);
			usuexternos.setT220CdgoUsuario((String)object[1]);
			usuexternos.setT220CdgoEmpresa((Integer)object[2]);
			usuexternos.setT220MrcaActivo(String.valueOf((java.lang.Character) object[3]));
			usuexternos.setT220DesgUsuact((String)object[4]);
			usuexternos.setT220FchaAct((java.util.Date) object[5]);
			usuexternos.setDesgNombreEmpresa((String)object[6]);

			resultadosDevueltos.add(usuexternos);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg220UsuariosExternos> getUsuarioExternoListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG220_USUARIOS_EXTERNOS ORDER BY T220_CDGO_USU_EXT DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg220UsuariosExternos.class);

		return sqlquery.getResultList();
	}

	/*public List<Tbasg220UsuariosExternos> getUsuarioExternoListActiveAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG220_USUARIOS_EXTERNOS WHERE T220_MRCA_ACTIVO='S' ORDER BY T220_CDGO_USUARIO";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg220UsuariosExternos.class);

		return sqlquery.getResultList();
	}*/
	
	public List<Tbasg220UsuariosExternos> getUsuarioExternoListActiveAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG220_USUARIOS_EXTERNOS WHERE T220_MRCA_ACTIVO='S' ORDER BY T220_CDGO_USUARIO";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg220UsuariosExternos> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg220UsuariosExternos usuexternos = new Tbasg220UsuariosExternos();

			usuexternos.setT220CdgoUsuExt(Long.valueOf((int)object[0]));
			usuexternos.setT220CdgoUsuario((String)object[1]);
			usuexternos.setT220CdgoEmpresa((Integer)object[2]);
			usuexternos.setT220MrcaActivo(String.valueOf((java.lang.Character) object[3]));
			usuexternos.setT220DesgUsuact((String)object[4]);
			usuexternos.setT220FchaAct((Date) object[5]);

			resultadosDevueltos.add(usuexternos);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg220UsuariosExternos> getUsuarioExternoListActiveDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG220_USUARIOS_EXTERNOS WHERE T220_MRCA_ACTIVO='S' ORDER BY T220_CDGO_USUARIO DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg220UsuariosExternos.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg220UsuariosExternos> getUsuarioExterno(String t220CdgoUsuExt) {

		String sqlString = "SELECT * FROM PASG.TBASG220_USUARIOS_EXTERNOS WHERE T220_CDGO_USU_EXT=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg220UsuariosExternos.class);
		sqlquery.setParameter("value", t220CdgoUsuExt);
		return sqlquery.getResultList();
	}

	public int insertUsuarioExterno(Tbasg220UsuariosExternos bean) {

		String sqlString = "INSERT INTO PASG.TBASG220_USUARIOS_EXTERNOS (T220_CDGO_USUARIO, T220_CDGO_EMPRESA, T220_MRCA_ACTIVO, T220_DESG_USUACT, T220_FCHA_ACT) VALUES (upper(?),?,?,?,CURRENT_DATE);";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg220UsuariosExternos.class);
		sqlquery.setParameter(1, bean.getT220CdgoUsuario());
		sqlquery.setParameter(2, bean.getT220CdgoEmpresa());
		sqlquery.setParameter(3, bean.getT220MrcaActivo());
		sqlquery.setParameter(4, bean.getT220DesgUsuact());
		return sqlquery.executeUpdate();
	}

	public int updateUsuarioExterno(Tbasg220UsuariosExternos bean) {

		String sqlString = "UPDATE PASG.TBASG220_USUARIOS_EXTERNOS SET T220_CDGO_USUARIO=upper(:cdgoUsuExterno), T220_CDGO_EMPRESA=:cdgoEmpresa, T220_DESG_USUACT=:desgUsuact, T220_FCHA_ACT=CURRENT_DATE WHERE T220_CDGO_USU_EXT=:cdgoUE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg220UsuariosExternos.class);
		sqlquery.setParameter("cdgoUsuExterno", bean.getT220CdgoUsuario());
		sqlquery.setParameter("cdgoEmpresa", bean.getT220CdgoEmpresa());
		sqlquery.setParameter("desgUsuact", bean.getT220DesgUsuact());
		sqlquery.setParameter("cdgoUE", bean.getT220CdgoUsuExt());
		return sqlquery.executeUpdate();
	}
	
	public int estadoUsuarioExterno(Tbasg220UsuariosExternos bean) {

		String sqlString = "UPDATE PASG.TBASG220_USUARIOS_EXTERNOS SET T220_MRCA_ACTIVO=:mrcaActivo, T220_DESG_USUACT=:desgUsuact, T220_FCHA_ACT=CURRENT_DATE WHERE T220_CDGO_USU_EXT=:cdgoUE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg220UsuariosExternos.class);
		sqlquery.setParameter("mrcaActivo", bean.getT220MrcaActivo());
		sqlquery.setParameter("desgUsuact", bean.getT220DesgUsuact());
		sqlquery.setParameter("cdgoUE", bean.getT220CdgoUsuExt());
		return sqlquery.executeUpdate();
	}

}
