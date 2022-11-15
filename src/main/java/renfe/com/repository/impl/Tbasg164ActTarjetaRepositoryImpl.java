package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg164ActTarjeta;
import renfe.com.repository.Tbasg164ActTarjetaRepositoryCustom;

public class Tbasg164ActTarjetaRepositoryImpl implements Tbasg164ActTarjetaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg164ActTarjeta> getTarjetaActualizar(String cdgoNumserie) {

		String sqlString = "SELECT CDGO_NUMSERIE " + "			FROM PASG.TBASG164_ACT_TARJETA "
				+ "			WHERE CDGO_NUMSERIE = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg164ActTarjeta.class);
		sqlquery.setParameter("value", cdgoNumserie);
		return sqlquery.getResultList();
	}

	public int insertActTarjeta(Tbasg164ActTarjeta bean) {

		String sqlString = "INSERT INTO PASG.TBASG164_ACT_TARJETA "
				+ "    			( CDGO_NUMSERIE, DESG_USUACT, FCHA_ACT ) " + "		VALUES  ( ? , ? , CURRENT_DATE )";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg164ActTarjeta.class);
		sqlquery.setParameter(1, bean.getCdgoNumserie());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		return sqlquery.executeUpdate();
	}

}
