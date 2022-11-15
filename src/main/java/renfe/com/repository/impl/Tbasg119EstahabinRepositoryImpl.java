package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg119Estahabin;
import renfe.com.repository.Tbasg119EstahabinRepositoryCustom;

public class Tbasg119EstahabinRepositoryImpl implements Tbasg119EstahabinRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg119Estahabin> findEstaHabInByCdgoAlc(String cdgoAlchabinf) {

		String sqlString = "SELECT * FROM PASG.TBASG119_ESTAHABIN WHERE CDGO_ALCHABINF = :value AND MRCA_ACTIVO = 'S'"
				+ "		ORDER BY FCHA_ESTADO DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg119Estahabin.class);
		sqlquery.setParameter("value", cdgoAlchabinf);
		return sqlquery.getResultList();
	}

	public int insertEstaHabIn(Integer cdgoAlchabinf, Integer cdgoEstado, String desgUsuact, String mrcaActivo) {

		String sqlString = "INSERT INTO PASG.TBASG119_ESTAHABIN (CDGO_ALCHABINF, CDGO_ESTADO, FCHA_ESTADO, DESG_USUACT,FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, CURRENT_TIMESTAMP, ?,CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg119Estahabin.class);
		sqlquery.setParameter(1, cdgoAlchabinf);
		sqlquery.setParameter(2, cdgoEstado);
		sqlquery.setParameter(3, desgUsuact);
		sqlquery.setParameter(4, mrcaActivo);
		return sqlquery.executeUpdate();
	}

}
