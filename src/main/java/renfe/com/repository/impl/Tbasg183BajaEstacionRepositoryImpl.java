package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg183BajaEstacion;
import renfe.com.repository.Tbasg183BajaEstacionRepositoryCustom;

public class Tbasg183BajaEstacionRepositoryImpl implements Tbasg183BajaEstacionRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg183BajaEstacion> getBajaEstacion(String cdgoEstacion, String cdgoLinea) {

		String sqlString = "SELECT * FROM PASG.TBASG183_BAJA_ESTACION WHERE CDGO_ESTACION=:cdgoEstacion AND CDGO_LINEA=:cdgoLinea";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg183BajaEstacion.class);
		sqlquery.setParameter("cdgoEstacion", cdgoEstacion);
		sqlquery.setParameter("cdgoLinea", cdgoLinea);
		return sqlquery.getResultList();
	}

	public int insertBajaEstacion(Tbasg183BajaEstacion bean) {

		String sqlString = "INSERT INTO PASG.TBASG183_BAJA_ESTACION (CDGO_ESTACION, CDGO_LINEA, DESG_USUACT, FCHA_ACT, DESG_SOPORTEDOC)"
				+ "            VALUES (?, ?, ?, CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg183BajaEstacion.class);
		sqlquery.setParameter(1, bean.getTbasg183bajaestacionpk().getCdgoEstacion());
		sqlquery.setParameter(2, bean.getTbasg183bajaestacionpk().getCdgoLinea());
		sqlquery.setParameter(3, bean.getDesgUsuact());
		sqlquery.setParameter(4, bean.getDesgSoportedoc());
		return sqlquery.executeUpdate();
	}

}
