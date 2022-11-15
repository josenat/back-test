package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg181BajaLinea;
import renfe.com.repository.Tbasg181BajaLineaRepositoryCustom;

public class Tbasg181BajaLineaRepositoryImpl implements Tbasg181BajaLineaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg181BajaLinea> getBajaLinea(String cdgoLinea) {

		String sqlString = "SELECT * FROM PASG.TBASG181_BAJA_LINEA WHERE CDGO_LINEA=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg181BajaLinea.class);
		sqlquery.setParameter("value", cdgoLinea);
		return sqlquery.getResultList();
	}

	public int insertBajaLinea(Tbasg181BajaLinea bean) {

		String sqlString = "INSERT INTO PASG.TBASG181_BAJA_LINEA (CDGO_LINEA, DESG_SOPORTEDOC, DESG_USUACT, FCHA_ACT)"
				+ "		VALUES (?, ?, ?, CURRENT_DATE)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg181BajaLinea.class);
		sqlquery.setParameter(1, bean.getCdgoLinea());
		sqlquery.setParameter(2, bean.getDesgSoportedoc());
		sqlquery.setParameter(3, bean.getDesgUsuact());
		return sqlquery.executeUpdate();
	}

}
