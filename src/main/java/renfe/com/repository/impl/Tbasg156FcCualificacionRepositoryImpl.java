package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.dto.GetFcCualificacionListAscCdgoCategoriaDTO;
import renfe.com.model.dto.Tbasg156FcCualificacionDto;
import renfe.com.model.entity.Tbasg141Areter;
import renfe.com.model.entity.Tbasg155FcCategoria;

import renfe.com.model.entity.Tbasg156FcCualificacion;
import renfe.com.repository.Tbasg156FcCualificacionRepositoryCustom;

public class Tbasg156FcCualificacionRepositoryImpl implements Tbasg156FcCualificacionRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg156FcCualificacion> getFcCualificacion(String cdgoCategoria, String cdgoCualificacion) {

		String sqlString = "SELECT * FROM PASG.TBASG156_FC_CUALIFICACION "
				+ "			WHERE CDGO_CATEGORIA=:cdgoCategoria "
				+ "			AND CDGO_CUALIFICACION=:cdgoCualificacion";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg156FcCualificacion.class);
		sqlquery.setParameter("cdgoCategoria", cdgoCategoria);
		sqlquery.setParameter("cdgoCualificacion", cdgoCualificacion);
		return sqlquery.getResultList();
	}

	public List<Tbasg156FcCualificacion> getFcCualificacionView(String cdgoCategoria, String cdgoCualificacion) {

		String sqlString = "SELECT A.*, B.DESG_DESCRIPCION AS DESG_NOMBRECATEGORIA FROM PASG.TBASG156_FC_CUALIFICACION A, PASG.TBASG155_FC_CATEGORIA B"
				+ "		WHERE A.CDGO_CATEGORIA = :cdgoCategoria "
				+ "		AND A.CDGO_CUALIFICACION = :cdgoCualificacion"
				+ "		AND A.CDGO_CATEGORIA = B.CDGO_CATEGORIA";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg156FcCualificacion.class);
		sqlquery.setParameter("cdgoCategoria", cdgoCategoria);
		sqlquery.setParameter("cdgoCualificacion", cdgoCualificacion);
		return sqlquery.getResultList();
	}

	public List<Tbasg156FcCualificacion> getFcCualificacionListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG156_FC_CUALIFICACION ORDER BY DESG_NOMBRE ASC, CDGO_CUALIFICACION ASC";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg156FcCualificacion> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg156FcCualificacion cualificacion = new Tbasg156FcCualificacion();

			cualificacion.setCdgoCualificacion((Integer)object[0]);
			cualificacion.setCdgoCategoria((Integer)object[1]);
			cualificacion.setDesgNombre((String)object[2]);
			cualificacion.setDesgDescripcion((String)object[3]);
			cualificacion.setDesgUsuact((String)object[4]);
			cualificacion.setFchaAct((Date)object[5]);
			cualificacion.setMrcaActivo((char)object[6]);

			resultadosDevueltos.add(cualificacion);
		}
		return resultadosDevueltos;
	}
	
	public List<GetFcCualificacionListAscCdgoCategoriaDTO> getFcCualificacionListAscCdgoCategoria(Integer cdgoCategoria) {

		String sqlString = "SELECT A.*, B.DESG_DESCRIPCION AS DESG_NOMBRECATEGORIA FROM PASG.TBASG156_FC_CUALIFICACION A INNER JOIN PASG.TBASG155_FC_CATEGORIA B ON A.CDGO_CATEGORIA = B.CDGO_CATEGORIA "
				+ " WHERE A.CDGO_CATEGORIA = B.CDGO_CATEGORIA	AND	A.CDGO_CATEGORIA = :value ORDER BY A.DESG_NOMBRE, A.CDGO_CUALIFICACION";
		Query sqlquery = em.createNativeQuery(sqlString);
		
		sqlquery.setParameter("value", cdgoCategoria);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetFcCualificacionListAscCdgoCategoriaDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetFcCualificacionListAscCdgoCategoriaDTO cualificacion = new GetFcCualificacionListAscCdgoCategoriaDTO();

			cualificacion.setCdgoCualificacion((Integer)object[0]);
			cualificacion.setCdgoCategoria((Integer)object[1]);
			cualificacion.setDesgNombre((String)object[2]);
			cualificacion.setDesgDescripcion((String)object[3]);
			cualificacion.setDesgUsuact((String)object[4]);
			cualificacion.setFchaAct((Date)object[5]);
			cualificacion.setMrcaActivo(String.valueOf((Character)object[6]));
			cualificacion.setDesgNombreCategoria((String)object[7]);

			resultadosDevueltos.add(cualificacion);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg156FcCualificacion> getFcCualificacionListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG156_FC_CUALIFICACION ORDER BY DESG_NOMBRE DESC, CDGO_CUALIFICACION DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg156FcCualificacion.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg156FcCualificacion> getFcCualificacionListAscendenteView(String cdgoCategoria) {

		String sqlString = "SELECT A.*, B.DESG_DESCRIPCION AS DESG_NOMBRECATEGORIA FROM PASG.TBASG156_FC_CUALIFICACION A, PASG.TBASG155_FC_CATEGORIA B"
				+ "		WHERE A.CDGO_CATEGORIA = B.CDGO_CATEGORIA " + "		AND	A.CDGO_CATEGORIA = :value "
				+ "		ORDER BY A.DESG_NOMBRE, A.CDGO_CUALIFICACION";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg156FcCualificacion.class);
		sqlquery.setParameter("value", cdgoCategoria);
		return sqlquery.getResultList();
	}

	public List<Tbasg156FcCualificacion> getFcCualificacionListDescendenteView(String cdgoCategoria) {

		String sqlString = "SELECT A.*, B.DESG_DESCRIPCION AS DESG_NOMBRECATEGORIA FROM PASG.TBASG156_FC_CUALIFICACION A, PASG.TBASG155_FC_CATEGORIA B"
				+ "		WHERE A.CDGO_CATEGORIA = B.CDGO_CATEGORIA " + "		AND	A.CDGO_CATEGORIA = :value "
				+ "		ORDER BY A.DESG_NOMBRE DESC, A.CDGO_CUALIFICACION DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg156FcCualificacion.class);
		sqlquery.setParameter("value", cdgoCategoria);
		return sqlquery.getResultList();
	}

	public List<Tbasg156FcCualificacion> getFcCualificacionCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG156_FC_CUALIFICACION";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg156FcCualificacion.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg156FcCualificacion> getFcCualificacionViewCount(String cdgoCategoria) {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG156_FC_CUALIFICACION A, PASG.TBASG155_FC_CATEGORIA B"
				+ "		WHERE A.CDGO_CATEGORIA = :value AND A.CDGO_CATEGORIA = B.CDGO_CATEGORIA";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg156FcCualificacion.class);
		sqlquery.setParameter("value", cdgoCategoria);
		return sqlquery.getResultList();
	}

	public List<Tbasg156FcCualificacion> getFcCualificacionListActive() {

		String sqlString = "SELECT * FROM PASG.TBASG156_FC_CUALIFICACION WHERE MRCA_ACTIVO='S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg156FcCualificacion.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg156FcCualificacion> getFcCualificacionListOrderByCategoria() {

		String sqlString = "SELECT * FROM PASG.TBASG156_FC_CUALIFICACION WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg156FcCualificacion> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg156FcCualificacion area = new Tbasg156FcCualificacion();
			area.setCdgoCualificacion((int)object[0]);
			area.setCdgoCategoria((int)object[1]);
			area.setDesgNombre((String)object[2]);
			area.setDesgDescripcion((String)object[3]);
			area.setDesgUsuact((String)object[4]);
			area.setFchaAct((Date)object[5]);
			area.setMrcaActivo((char)object[6]);
			resultadosDevueltos.add(area);
	}
		return resultadosDevueltos;
	}
	public List<Tbasg156FcCualificacionDto> getCualiForName(String desgDescripcion) {

		String sqlString = "SELECT CDGO_CUALIFICACION FROM PASG.TBASG156_FC_CUALIFICACION WHERE DESG_DESCRIPCION LIKE :desgDescripcion";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("desgDescripcion", "%"+ desgDescripcion +"%");
		List<Integer> results = sqlquery.getResultList();
		List<Tbasg156FcCualificacionDto> resultList = new ArrayList<>();
		for (Integer item : results) {
		  Tbasg156FcCualificacionDto cualificacion = new Tbasg156FcCualificacionDto();
		  cualificacion.setCdgoCualificacion(item);
		  resultList.add(cualificacion);
		}
		return resultList;		
	}

	public int insertFcCualificacion(Tbasg156FcCualificacion bean) {

		String sqlString = "INSERT INTO PASG.TBASG156_FC_CUALIFICACION (CDGO_CATEGORIA, DESG_NOMBRE, DESG_DESCRIPCION, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO) VALUES (?,?,?,?,CURRENT_DATE,?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg156FcCualificacion.class);
		sqlquery.setParameter(1, bean.getCdgoCategoria());
		sqlquery.setParameter(2, bean.getDesgNombre());
		sqlquery.setParameter(3, bean.getDesgDescripcion());
		sqlquery.setParameter(4, bean.getDesgUsuact());
		sqlquery.setParameter(5, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateFcCualificacion(Tbasg156FcCualificacion bean) {

		String sqlString = "UPDATE PASG.TBASG156_FC_CUALIFICACION SET DESG_NOMBRE=:nombre, DESG_DESCRIPCION=:descripcion, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_CUALIFICACION=:cdgoCualificacion";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg156FcCualificacion.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("descripcion", bean.getDesgDescripcion());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoCualificacion", bean.getCdgoCualificacion());
		return sqlquery.executeUpdate();
	}
	
	public int estadoFcCualificacion(Tbasg156FcCualificacion bean) {

		String sqlString = "UPDATE PASG.TBASG156_FC_CUALIFICACION SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_CUALIFICACION=:cdgoCualificacion";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg156FcCualificacion.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoCualificacion", bean.getCdgoCualificacion());
		return sqlquery.executeUpdate();
	}

	public int deleteFcCualificacion(Tbasg156FcCualificacion bean) {

		String sqlString = "UPDATE PASG.TBASG156_FC_CUALIFICACION SET MRCA_ACTIVO='N', DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg156FcCualificacion.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		return sqlquery.executeUpdate();
	}

	public int reactiveFcCualificacion(Tbasg156FcCualificacion bean) {

		String sqlString = "UPDATE PASG.TBASG156_FC_CUALIFICACION SET MRCA_ACTIVO='S', DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg156FcCualificacion.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		return sqlquery.executeUpdate();
	}

}
