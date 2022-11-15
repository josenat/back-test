package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg154OpTarjeta;
import renfe.com.repository.Tbasg154OpTarjetaRepositoryCustom;

public class Tbasg154OpTarjetaRepositoryImpl implements Tbasg154OpTarjetaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg154OpTarjeta> getOperacion(String cdgoNumserie) {

		String sqlString = "SELECT * " + "	 FROM PASG.TBASG154_OP_TARJETA WHERE CDGO_NUMSERIE = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg154OpTarjeta.class);
		sqlquery.setParameter("value", cdgoNumserie);
		return sqlquery.getResultList();
	}

	public int insertOperTarjeta(Tbasg154OpTarjeta bean) {

		String sqlString = "INSERT INTO PASG.TBASG154_OP_TARJETA (CDGO_NUMSERIE, DESG_OPERACION, FCHA_OPERACION, DESG_USUARIO, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, ?, CURRENT_TIMESTAMP, ?,CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg154OpTarjeta.class);
		sqlquery.setParameter(1, bean.getCdgoNumserie());
		sqlquery.setParameter(2, bean.getDesgOperacion());
		sqlquery.setParameter(3, bean.getTbasg154optarjetapk().getFchaOperacion());
		sqlquery.setParameter(4, bean.getDesgUsuact());
		sqlquery.setParameter(5, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

}
