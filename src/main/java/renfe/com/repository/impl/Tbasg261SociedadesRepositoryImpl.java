package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg123Tipohabil;
import renfe.com.model.entity.Tbasg261Sociedades;
import renfe.com.repository.Tbasg261SociedadesRepositoryCustom;

public class Tbasg261SociedadesRepositoryImpl implements Tbasg261SociedadesRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg261Sociedades> getSociedadCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG261_SOCIEDADES";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg261Sociedades.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg261Sociedades> getSociedadListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG261_SOCIEDADES ORDER BY CDGO_SOCIEDAD";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg261Sociedades> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg261Sociedades area = new Tbasg261Sociedades();
			
			area.setCdgoSociedad((String)object[0]);
			area.setDescSociedad((String)object[1]);
			area.setDesgUsuact((String)object[2]);
			area.setFchaAct((Date)object[3]);
			area.setMrcaActivo((char)object[4]);
			
			resultadosDevueltos.add(area);
		}
		return resultadosDevueltos;
		
	}

	public List<Tbasg261Sociedades> getSociedadListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG261_SOCIEDADES ORDER BY CDGO_SOCIEDAD DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg261Sociedades.class);

		return sqlquery.getResultList();
	}
	
	public List<Tbasg261Sociedades> getSociedadActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG261_SOCIEDADES WHERE MRCA_ACTIVO = 'S'  ORDER BY CDGO_SOCIEDAD ";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg261Sociedades> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg261Sociedades area = new Tbasg261Sociedades();
			
			area.setCdgoSociedad((String)object[0]);
			area.setDescSociedad((String)object[1]);
			area.setDesgUsuact((String)object[2]);
			area.setFchaAct((Date)object[3]);
			area.setMrcaActivo((char)object[4]);
			
			resultadosDevueltos.add(area);
		}
		return resultadosDevueltos;
		
	}

	public List<Tbasg261Sociedades> getSociedad(String cdgoSociedad) {

		String sqlString = "SELECT * FROM PASG.TBASG261_SOCIEDADES WHERE CDGO_SOCIEDAD=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg261Sociedades.class);
		sqlquery.setParameter("value", cdgoSociedad);
		return sqlquery.getResultList();
	}

	public List<Tbasg261Sociedades> getSociedadByNombre(String descSociedad) {

		String sqlString = "SELECT CDGO_SOCIEDAD FROM PASG.TBASG261_SOCIEDADES WHERE DESC_SOCIEDAD=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg261Sociedades.class);
		sqlquery.setParameter("value", descSociedad);
		return sqlquery.getResultList();
	}

	public List<Tbasg261Sociedades> getSociedadListActive() {

		String sqlString = "SELECT * FROM PASG.TBASG261_SOCIEDADES WHERE MRCA_ACTIVO='S' ORDER BY DESC_SOCIEDAD";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg261Sociedades.class);

		return sqlquery.getResultList();
	}

	public int insertSociedad(Tbasg261Sociedades bean) {

		String sqlString = "INSERT INTO PASG.TBASG261_SOCIEDADES (CDGO_SOCIEDAD,DESC_SOCIEDAD, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, ?,CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg261Sociedades.class);
		sqlquery.setParameter(1, bean.getCdgoSociedad());
		sqlquery.setParameter(2, bean.getDescSociedad());
		sqlquery.setParameter(3, bean.getDesgUsuact());
		sqlquery.setParameter(4, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateSociedad(Tbasg261Sociedades bean) {

		String sqlString = "UPDATE PASG.TBASG261_SOCIEDADES	SET DESC_SOCIEDAD = :nombre, DESG_USUACT=:usuAct,FCHA_ACT=CURRENT_DATE WHERE CDGO_SOCIEDAD=:cdgoSociedad";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg261Sociedades.class);
		sqlquery.setParameter("nombre", bean.getDescSociedad());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoSociedad", bean.getCdgoSociedad());
		return sqlquery.executeUpdate();
	}
	
	public int estadoSociedad(Tbasg261Sociedades bean) {

		String sqlString = "UPDATE PASG.TBASG261_SOCIEDADES	SET MRCA_ACTIVO = :mrcaActivo, DESG_USUACT=:usuAct,FCHA_ACT=CURRENT_DATE WHERE CDGO_SOCIEDAD=:cdgoSociedad";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg261Sociedades.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoSociedad", bean.getCdgoSociedad());
		return sqlquery.executeUpdate();
	}

}
