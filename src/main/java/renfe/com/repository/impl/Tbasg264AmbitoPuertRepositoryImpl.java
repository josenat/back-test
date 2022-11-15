package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg264AmbitoPuert;
import renfe.com.model.entity.Tbasg265AmbitoLinea;
import renfe.com.repository.Tbasg264AmbitoPuertRepositoryCustom;

public class Tbasg264AmbitoPuertRepositoryImpl implements Tbasg264AmbitoPuertRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg264AmbitoPuert> getListaAmbitoPuertosActiv() {

		String sqlString = "SELECT CDGO_PUERTO,DESG_PUERTO FROM PASG.TBASG264_AMBITO_PUERT WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_PUERTO";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg264AmbitoPuert> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg264AmbitoPuert ambitoPuerto = new Tbasg264AmbitoPuert();
			
			ambitoPuerto.setCdgoPuerto((String)object[0]);
			ambitoPuerto.setDesgPuerto((String)object[1]);

			resultadosDevueltos.add(ambitoPuerto);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg264AmbitoPuert> getDescTipoAmbitoPuertos(String cdgoPuerto) {

		String sqlString = "SELECT  DESG_PUERTO FROM PASG.TBASG264_AMBITO_PUERT WHERE CDGO_PUERTO = :value AND MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg264AmbitoPuert.class);
		sqlquery.setParameter("value", cdgoPuerto);
		return sqlquery.getResultList();
	}

	public List<Tbasg264AmbitoPuert> getAmbitoPuertoCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG264_AMBITO_PUERT";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg264AmbitoPuert.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg264AmbitoPuert> getMaxAmbitoPuerto() {

		String sqlString = "SELECT MAX(INT(CDGO_PUERTO))as value FROM PASG.TBASG264_AMBITO_PUERT";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg264AmbitoPuert.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg264AmbitoPuert> getAmbitoPuertoListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG264_AMBITO_PUERT ORDER BY CDGO_PUERTO";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg264AmbitoPuert> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg264AmbitoPuert ambitoPuerto = new Tbasg264AmbitoPuert();
			
			ambitoPuerto.setCdgoPuerto((String)object[0]);
			ambitoPuerto.setDesgPuerto((String)object[1]);
			ambitoPuerto.setDesgUsuact((String)object[2]);
			ambitoPuerto.setFchaAct((Date) object[3]);
			ambitoPuerto.setMrcaActivo(String.valueOf((Character) object[4]));

			resultadosDevueltos.add(ambitoPuerto);
		}
		return resultadosDevueltos;
	}
	
	public List<Tbasg264AmbitoPuert> getCdgoPuertAutoInc() {

		String sqlString = "SELECT MAX(CDGO_PUERTO) FROM PASG.TBASG264_AMBITO_PUERT";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object> resultados = sqlquery.getResultList();
		List<Tbasg264AmbitoPuert> resultadosDevueltos = new ArrayList<>();
		for (Object object : resultados) {
			Tbasg264AmbitoPuert ambitoPuerto = new Tbasg264AmbitoPuert();
			
			ambitoPuerto.setCdgoPuerto((String)object);

			resultadosDevueltos.add(ambitoPuerto);
		}
		return resultadosDevueltos;
		
	}

	public List<Tbasg264AmbitoPuert> getAmbitoPuertoListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG264_AMBITO_PUERT ORDER BY CDGO_PUERTO DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg264AmbitoPuert.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg264AmbitoPuert> getAmbitoPuerto(String cdgoPuerto) {

		String sqlString = "SELECT * FROM PASG.TBASG264_AMBITO_PUERT WHERE CDGO_PUERTO=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg264AmbitoPuert.class);
		sqlquery.setParameter("value", cdgoPuerto);
		return sqlquery.getResultList();
	}

	public List<Tbasg264AmbitoPuert> getAmbitoPuertoByNombre(String desgPuerto) {

		String sqlString = "SELECT CDGO_PUERTO FROM PASG.TBASG264_AMBITO_PUERT WHERE DESG_PUERTO=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg264AmbitoPuert.class);
		sqlquery.setParameter("value", desgPuerto);
		return sqlquery.getResultList();
	}

	public List<Tbasg264AmbitoPuert> getAmbitoPuertoListActive() {

		String sqlString = "SELECT * FROM PASG.TBASG264_AMBITO_PUERT WHERE MRCA_ACTIVO='S' ORDER BY DESG_PUERTO";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg264AmbitoPuert.class);

		return sqlquery.getResultList();
	}

	public int insertAmbitoPuerto(Tbasg264AmbitoPuert bean) {

		String sqlString = "INSERT INTO PASG.TBASG264_AMBITO_PUERT (CDGO_PUERTO,DESG_PUERTO, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, ?,CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg264AmbitoPuert.class);
		sqlquery.setParameter(1, bean.getCdgoPuerto());
		sqlquery.setParameter(2, bean.getDesgPuerto());
		sqlquery.setParameter(3, bean.getDesgUsuact());
		sqlquery.setParameter(4, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateAmbitoPuerto(Tbasg264AmbitoPuert bean) {

		String sqlString = "UPDATE PASG.TBASG264_AMBITO_PUERT	SET DESG_PUERTO = :desgPuerto, DESG_USUACT=:usuAct,FCHA_ACT=CURRENT_DATE WHERE CDGO_PUERTO=:cdgoPuerto";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg264AmbitoPuert.class);
		sqlquery.setParameter("desgPuerto", bean.getDesgPuerto());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoPuerto", bean.getCdgoPuerto());
		return sqlquery.executeUpdate();
	}
	
	public int estadoAmbitoPuerto(Tbasg264AmbitoPuert bean) {

		String sqlString = "UPDATE PASG.TBASG264_AMBITO_PUERT	SET MRCA_ACTIVO = :mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_PUERTO=:cdgoPuerto";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg264AmbitoPuert.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoPuerto", bean.getCdgoPuerto());
		return sqlquery.executeUpdate();
	}

}
