package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg100Persona;
import renfe.com.model.entity.Tbasg258SocPersona;
import renfe.com.repository.Tbasg258SocPersonaRepositoryCustom;

public class Tbasg258SocPersonaRepositoryImpl implements Tbasg258SocPersonaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg258SocPersona> findByCdgoPersona(Integer cdgoPersona) {

		String sqlString = "SELECT * FROM PASG.TBASG258_SOC_PERSONA WHERE CDGO_PERSONA = :cdgoPersona";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("cdgoPersona", cdgoPersona);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg258SocPersona> resultadosDevueltos = new ArrayList<Tbasg258SocPersona>();
		for (Object[] object : resultados) {
			Tbasg258SocPersona sociedad = new Tbasg258SocPersona();
			sociedad.setIdSocpersona((Integer)object[0]);
			sociedad.setCdgoPersona((Integer)object[1]);
			sociedad.setCdgoSociedad((String)object[2]);
			sociedad.setFchaAlta((Date) object[3]);
			sociedad.setFchaBaja((Date) object[4]);
			resultadosDevueltos.add(sociedad);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg258SocPersona> findByCdgoPersonaActivo(String cdgoPersona) {

		String sqlString = "SELECT * FROM PASG.TBASG258_SOC_PERSONA "
				+ "		WHERE CDGO_PERSONA = :value AND FCHA_BAJA IS NULL";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg258SocPersona.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}

	public List<Tbasg258SocPersona> findByCdgoPersonaInActivo(String cdgoPersona) {

		String sqlString = "SELECT * FROM PASG.TBASG258_SOC_PERSONA "
				+ "		WHERE CDGO_PERSONA = :value AND FCHA_BAJA IS NOT NULL";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg258SocPersona.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}

	public int insertSocPersona(Integer cdgoPersona, String cdgoSociedad, Date fechAlta, Date fechBaja) {

		String sqlString = "INSERT INTO PASG.TBASG258_SOC_PERSONA (CDGO_PERSONA,CDGO_SOCIEDAD,FCHA_ALTA,FCHA_BAJA)"
				+ "	    VALUES (?, ?, ?, ?)";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter(1, cdgoPersona);
		sqlquery.setParameter(2, cdgoSociedad);
		sqlquery.setParameter(3, fechAlta);
		sqlquery.setParameter(4, fechBaja);
		return sqlquery.executeUpdate();
	}

	public int updateSocPersona(Integer idSocPersona, String cdgoSociedad, Date fechAlta, Date fechBaja) {

		String sqlString = "UPDATE PASG.TBASG258_SOC_PERSONA " + "	    SET CDGO_SOCIEDAD = ?,"
				+ "	    	 FCHA_ALTA     = ?," + "	          FCHA_BAJA		= ?"
				+ "	    WHERE ID_SOCPERSONA = ?";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter(1, cdgoSociedad);
		sqlquery.setParameter(2, fechAlta);
		sqlquery.setParameter(3, fechBaja);
		sqlquery.setParameter(4, idSocPersona);
		return sqlquery.executeUpdate();
	}

}
