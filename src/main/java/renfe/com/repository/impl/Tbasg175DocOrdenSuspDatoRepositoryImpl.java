package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg175DocOrdenSuspDato;
import renfe.com.repository.Tbasg175DocOrdenSuspDatoRepositoryCustom;

public class Tbasg175DocOrdenSuspDatoRepositoryImpl implements Tbasg175DocOrdenSuspDatoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg175DocOrdenSuspDato> getDocOrdenSuspDatoActiveList(String cdgoReferenciadoc) {

		String sqlString = "SELECT D.CDGO_REFERENCIADOC, D.CDGO_CLAVE, D.DESG_VALOR, D.DESG_USUACT, D.FCHA_ACT, D.MRCA_ACTIVO"
				+ "		FROM PASG.TBASG175_DOC_ORDEN_SUSP_DATO D" + "		WHERE D.MRCA_ACTIVO = 'S'"
				+ "		      AND D.CDGO_REFERENCIADOC = :cdgoReferenciaDoc" + "		ORDER BY D.CDGO_CLAVE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg175DocOrdenSuspDato.class);
		sqlquery.setParameter("cdgoReferenciaDoc", cdgoReferenciadoc);
		return sqlquery.getResultList();
	}

	public List<Tbasg175DocOrdenSuspDato> getDocOrdenSuspDatoList(String cdgoReferenciadoc) {

		String sqlString = "SELECT D.CDGO_REFERENCIADOC, D.CDGO_CLAVE, D.DESG_VALOR, D.DESG_USUACT, D.FCHA_ACT, D.MRCA_ACTIVO"
				+ "		FROM PASG.TBASG175_DOC_ORDEN_SUSP_DATO D"
				+ "		WHERE D.CDGO_REFERENCIADOC = :cdgoReferenciaDoc" + "		ORDER BY D.CDGO_CLAVE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg175DocOrdenSuspDato.class);
		sqlquery.setParameter("cdgoReferenciaDoc", cdgoReferenciadoc);
		return sqlquery.getResultList();
	}

	public List<Tbasg175DocOrdenSuspDato> getDocOrdenSuspDato(String cdgoReferenciadoc, String cdgoClave) {

		String sqlString = "SELECT D.CDGO_REFERENCIADOC, D.CDGO_CLAVE, D.DESG_VALOR, D.DESG_USUACT, D.FCHA_ACT, D.MRCA_ACTIVO"
				+ "		FROM PASG.TBASG175_DOC_ORDEN_SUSP_DATO D"
				+ "		WHERE D.CDGO_REFERENCIADOC = :cdgoReferenciaDoc"
				+ "			  AND D.CDGO_CLAVE = :cdgoClave";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg175DocOrdenSuspDato.class);
		sqlquery.setParameter("cdgoReferenciaDoc", cdgoReferenciadoc);
		sqlquery.setParameter("cdgoClave", cdgoClave);
		return sqlquery.getResultList();
	}

	public int insertDocOrdenSuspDato(Tbasg175DocOrdenSuspDato bean) {

		String sqlString = "INSERT INTO PASG.TBASG175_DOC_ORDEN_SUSP_DATO "
				+ "			(CDGO_REFERENCIADOC, CDGO_CLAVE, DESG_VALOR, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, ?, ?, CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg175DocOrdenSuspDato.class);
		sqlquery.setParameter(1, bean.getTbasg175docordensuspdatopk().getCdgoReferenciadoc());
		sqlquery.setParameter(2, bean.getTbasg175docordensuspdatopk().getCdgoClave());
		sqlquery.setParameter(3, bean.getDesgValor());
		sqlquery.setParameter(4, bean.getDesgUsuact());
		sqlquery.setParameter(5, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateDocOrdenSuspDato(Tbasg175DocOrdenSuspDato bean) {

		String sqlString = "UPDATE PASG.TBASG175_DOC_ORDEN_SUSP_DATO SET " + "			DESG_VALOR = ?, "
				+ "			DESG_USUACT = ?, " + "			FCHA_ACT = CURRENT_DATE, " + "			MRCA_ACTIVO = ?"
				+ "		WHERE CDGO_REFERENCIADOC = ? AND CDGO_CLAVE = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg175DocOrdenSuspDato.class);
		sqlquery.setParameter(1, bean.getDesgValor());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getMrcaActivo());
		sqlquery.setParameter(4, bean.getTbasg175docordensuspdatopk().getCdgoReferenciadoc());
		sqlquery.setParameter(5, bean.getTbasg175docordensuspdatopk().getCdgoClave());
		return sqlquery.executeUpdate();
	}

}
