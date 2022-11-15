package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg177DocOrdenActiDato;
import renfe.com.repository.Tbasg177DocOrdenActiDatoRepositoryCustom;

public class Tbasg177DocOrdenActiDatoRepositoryImpl implements Tbasg177DocOrdenActiDatoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg177DocOrdenActiDato> getDocOrdenActiDatoActiveList(String cdgoReferenciadoc) {

		String sqlString = "SELECT D.CDGO_REFERENCIADOC, D.CDGO_CLAVE, D.DESG_VALOR, D.DESG_USUACT, D.FCHA_ACT, D.MRCA_ACTIVO"
				+ "		FROM PASG.TBASG177_DOC_ORDEN_ACTI_DATO D" + "		WHERE D.MRCA_ACTIVO = 'S'"
				+ "		      AND D.CDGO_REFERENCIADOC = :cdgoReferenciaDoc" + "		ORDER BY D.CDGO_CLAVE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg177DocOrdenActiDato.class);
		sqlquery.setParameter("cdgoReferenciaDoc", cdgoReferenciadoc);
		return sqlquery.getResultList();
	}

	public List<Tbasg177DocOrdenActiDato> getDocOrdenActiDatoList(String cdgoReferenciadoc) {

		String sqlString = "SELECT D.CDGO_REFERENCIADOC, D.CDGO_CLAVE, D.DESG_VALOR, D.DESG_USUACT, D.FCHA_ACT, D.MRCA_ACTIVO"
				+ "		FROM PASG.TBASG177_DOC_ORDEN_ACTI_DATO D"
				+ "		WHERE D.CDGO_REFERENCIADOC = :cdgoReferenciaDoc" + "		ORDER BY D.CDGO_CLAVE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg177DocOrdenActiDato.class);
		sqlquery.setParameter("cdgoReferenciaDoc", cdgoReferenciadoc);
		return sqlquery.getResultList();
	}

	public List<Tbasg177DocOrdenActiDato> getDocOrdenActiDato(String cdgoReferenciadoc, String cdgoClave) {

		String sqlString = "SELECT D.CDGO_REFERENCIADOC, D.CDGO_CLAVE, D.DESG_VALOR, D.DESG_USUACT, D.FCHA_ACT, D.MRCA_ACTIVO"
				+ "		FROM PASG.TBASG177_DOC_ORDEN_ACTI_DATO D"
				+ "		WHERE D.CDGO_REFERENCIADOC = :cdgoReferenciaDoc"
				+ "			  AND D.CDGO_CLAVE = :cdgoClave";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg177DocOrdenActiDato.class);
		sqlquery.setParameter("cdgoReferenciaDoc", cdgoReferenciadoc);
		sqlquery.setParameter("cdgoClave", cdgoClave);
		return sqlquery.getResultList();
	}

	public int insertDocOrdenActiDato(Tbasg177DocOrdenActiDato bean) {

		String sqlString = "INSERT INTO PASG.TBASG177_DOC_ORDEN_ACTI_DATO "
				+ "			(CDGO_REFERENCIADOC, CDGO_CLAVE, DESG_VALOR, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, ?, ?, CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg177DocOrdenActiDato.class);
		sqlquery.setParameter(1, bean.getTbasg177docordenactidatopk().getCdgoReferenciadoc());
		sqlquery.setParameter(2, bean.getTbasg177docordenactidatopk().getCdgoClave());
		sqlquery.setParameter(3, bean.getDesgValor());
		sqlquery.setParameter(4, bean.getDesgUsuact());
		sqlquery.setParameter(5, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateDocOrdenActiDato(Tbasg177DocOrdenActiDato bean) {

		String sqlString = "UPDATE PASG.TBASG177_DOC_ORDEN_ACTI_DATO SET " + "			DESG_VALOR = ?, "
				+ "			DESG_USUACT = ?, " + "			FCHA_ACT = CURRENT_DATE, " + "			MRCA_ACTIVO = ?"
				+ "		WHERE CDGO_REFERENCIADOC = ? AND CDGO_CLAVE = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg177DocOrdenActiDato.class);
		sqlquery.setParameter(1, bean.getDesgValor());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getMrcaActivo());
		sqlquery.setParameter(4, bean.getTbasg177docordenactidatopk().getCdgoReferenciadoc());
		sqlquery.setParameter(5, bean.getTbasg177docordenactidatopk().getCdgoClave());
		return sqlquery.executeUpdate();
	}

}
