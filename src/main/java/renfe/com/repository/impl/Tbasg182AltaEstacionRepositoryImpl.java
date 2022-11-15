package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg182AltaEstacion;
import renfe.com.repository.Tbasg182AltaEstacionRepositoryCustom;

public class Tbasg182AltaEstacionRepositoryImpl implements Tbasg182AltaEstacionRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg182AltaEstacion> getAltaEstacion(String cdgoEstacion, String cdgoLinea) {

		String sqlString = "SELECT * FROM PASG.TBASG182_ALTA_ESTACION WHERE CDGO_ESTACION=:cdgoEstacion AND CDGO_LINEA=:cdgoLinea";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg182AltaEstacion.class);
		sqlquery.setParameter("cdgoEstacion", cdgoEstacion);
		sqlquery.setParameter("cdgoLinea", cdgoLinea);
		return sqlquery.getResultList();
	}

	public int insertAltaEstacion(Tbasg182AltaEstacion bean) {

		String sqlString = "INSERT INTO PASG.TBASG182_ALTA_ESTACION (CDGO_ESTACION, CDGO_LINEA, CDGO_PK, DESG_NOMCORTO, DESG_NOMLARGO, DESG_USUACT, FCHA_ACT, DESG_SOPORTEDOC,CDGO_ORDEN)"
				+ "            VALUES (?, ?, ?, ?, ?, ?, CURRENT_DATE, ?, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg182AltaEstacion.class);
		sqlquery.setParameter(1, bean.getTbasg182altaestacionpk().getCdgoEstacion());
		sqlquery.setParameter(2, bean.getTbasg182altaestacionpk().getCdgoLinea());
		sqlquery.setParameter(3, bean.getCdgoPk());
		sqlquery.setParameter(4, bean.getDesgNomcorto());
		sqlquery.setParameter(5, bean.getDesgNomlargo());
		sqlquery.setParameter(6, bean.getDesgUsuact());
		sqlquery.setParameter(7, bean.getDesgSoportedoc());
		sqlquery.setParameter(8, bean.getCdgoOrden());
		return sqlquery.executeUpdate();
	}

}
