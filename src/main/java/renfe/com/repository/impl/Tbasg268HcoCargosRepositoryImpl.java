package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg268HcoCargos;
import renfe.com.model.entity.Tbasg268HcoCargosPK;
import renfe.com.repository.Tbasg268HcoCargosRepositoryCustom;

public class Tbasg268HcoCargosRepositoryImpl implements Tbasg268HcoCargosRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg268HcoCargos> findByCdgoPersona(String cdgoPersona) {

		String sqlString = "SELECT * FROM PASG.TBASG268_HCO_CARGOS WHERE CDGO_PERSONA = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg268HcoCargos.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}

	public List<Tbasg268HcoCargos> findByCdgoPersonaCargo(String cdgoPersona) {

		String sqlString = "SELECT * FROM PASG.TBASG268_HCO_CARGOS WHERE CDGO_PERSONA = :value AND FCHA_FIN IS NULL";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg268HcoCargos.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}

	public List<Tbasg268HcoCargos> findCdgoCargoBeginningK(String cdgoPersona) {

		String sqlString = "SELECT * FROM PASG.TBASG268_HCO_CARGOS WHERE CDGO_PERSONA = :cdgoPersona AND CDGO_CARGO LIKE 'K%'";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("cdgoPersona", cdgoPersona);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg268HcoCargos> resultadosDevueltos = new ArrayList<Tbasg268HcoCargos>();
		for (Object[] object : resultados) {
			Tbasg268HcoCargos cargo = new Tbasg268HcoCargos();
			Tbasg268HcoCargosPK cargoPK = new Tbasg268HcoCargosPK();
			cargoPK.setCdgoPersona((String)object[0]);
			cargo.setCdgoCargo((String)object[1]);
			cargoPK.setFchaInicio((Date)object[2]);
			cargo.setFchaFin((Date)object[3]);
			cargo.setDesgUsuact((String)object[4]);
			cargo.setFchaAct((Date)object[5]);
			cargo.setTbasg268HcoCargosPK(cargoPK);
			resultadosDevueltos.add(cargo);
		}
		return resultadosDevueltos;
	}

	public int insertHstoCargos(String cdgoPersona, Date fchaInicio, Date fchaFin, String desgUsuact, String cdgoCargo) {

		String sqlString = "INSERT INTO PASG.TBASG268_HCO_CARGOS (CDGO_PERSONA,FCHA_INICIO,FCHA_FIN,DESG_USUACT,FCHA_ACT,CDGO_CARGO)"
				+ "	    VALUES (?, ?, ?, ?, CURRENT_DATE,?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg268HcoCargos.class);
		sqlquery.setParameter(1, cdgoPersona);
		sqlquery.setParameter(2, fchaInicio);
		sqlquery.setParameter(3, fchaFin);
		sqlquery.setParameter(4, desgUsuact);
		sqlquery.setParameter(5, cdgoCargo);
		return sqlquery.executeUpdate();
	}

	public int updateHstoCargos(String cdgoCargo, Date fchaFin, String desgUsuact, String cdgoPersona, Date fchaInicio) {

		String sqlString = "UPDATE PASG.TBASG268_HCO_CARGOS " + "	    SET  CDGO_CARGO = ?,"
				+ "	    	FCHA_FIN = ?," + "	    	DESG_USUACT = ?," + "	    	FCHA_ACT = CURRENT_DATE"
				+ "	    WHERE CDGO_PERSONA  = ? AND" + "	    	FCHA_INICIO = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg268HcoCargos.class);
		sqlquery.setParameter(1, cdgoCargo);
		sqlquery.setParameter(2, fchaFin);
		sqlquery.setParameter(3, desgUsuact);
		sqlquery.setParameter(4, cdgoPersona);
		sqlquery.setParameter(5, fchaInicio);
		return sqlquery.executeUpdate();
	}

	public int deleteHstoCargos(Tbasg268HcoCargos bean) {

		String sqlString = "DELETE FROM PASG.TBASG268_HCO_CARGOS WHERE CDGO_PERSONA = ? AND  CDGO_CARGO = ? AND FCHA_INICIO = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg268HcoCargos.class);
		//sqlquery.setParameter(1, bean.getCdgoPersona());
		sqlquery.setParameter(2, bean.getCdgoCargo());
		//sqlquery.setParameter(3, bean.getFchaInicio());
		return sqlquery.executeUpdate();
	}

}
