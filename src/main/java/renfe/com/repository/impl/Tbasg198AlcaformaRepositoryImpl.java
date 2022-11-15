package renfe.com.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg198Alcaforma;
import renfe.com.repository.Tbasg198AlcaformaRepositoryCustom;

public class Tbasg198AlcaformaRepositoryImpl implements Tbasg198AlcaformaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public int insertAlcaForma(Tbasg198Alcaforma bean) {

		String sqlString = "INSERT INTO PASG.TBASG198_ALCAFORMA (CDGO_SOLICITUD, CDGO_LINEA, CDGO_ORIGEN, CDGO_DESTINO, "
				+ "			DESG_LINEA, DESG_ORIGEN, DESG_DESTINO, CDGO_ESTADO, DESG_USUACT, FCHA_ACT)"
				+ "		VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg198Alcaforma.class);
		sqlquery.setParameter(1, bean.getTbasg198alcaformapk().getCdgoSolicitud());
		sqlquery.setParameter(2, bean.getTbasg198alcaformapk().getCdgoLinea());
		sqlquery.setParameter(3, bean.getTbasg198alcaformapk().getCdgoOrigen());
		sqlquery.setParameter(4, bean.getTbasg198alcaformapk().getCdgoDestino());
		sqlquery.setParameter(5, bean.getDesgLinea());
		sqlquery.setParameter(6, bean.getDesgOrigen());
		sqlquery.setParameter(7, bean.getDesgDestino());
		sqlquery.setParameter(8, bean.getCdgoEstado());
		sqlquery.setParameter(9, bean.getDesgUsuact());
		return sqlquery.executeUpdate();
	}

	public int deleteAlcaForma(Tbasg198Alcaforma bean) {

		String sqlString = "DELETE FROM PASG.TBASG198_ALCAFORMA	WHERE CDGO_SOLICITUD = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg198Alcaforma.class);
		sqlquery.setParameter("value", bean.getTbasg198alcaformapk().getCdgoSolicitud());
		return sqlquery.executeUpdate();
	}

}
