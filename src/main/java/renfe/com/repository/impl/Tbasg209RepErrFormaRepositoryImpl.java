package renfe.com.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg209RepErrForma;
import renfe.com.repository.Tbasg209RepErrFormaRepositoryCustom;

public class Tbasg209RepErrFormaRepositoryImpl implements Tbasg209RepErrFormaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public int insertRepErrForma(Tbasg209RepErrForma bean) {

		String sqlString = "INSERT INTO PASG.TBASG209_REP_ERR_FORMA (CDGO_ERROR, CDGO_SOLICITUD, CDGO_SAPCENTFORM, DESG_CIF,"
				+ "				CDGO_ACTO, DESG_DESCACTO, FCHA_TEORICO, DESG_TE_NOMINSTR, DESG_TE_APELLINSTR1,"
				+ "				DESG_TE_APELLINSTR2, DESG_TE_NIFINSTR, CDGO_TE_CALIFI, FCHA_PRACTICO, DESG_PR_NOMINSTR, "
				+ "				DESG_PR_APELLINSTR1, DESG_PR_APELLINSTR2, DESG_PR_NIFINSTR, CDGO_PR_CALIFI, FCHA_TEORIPRAC, "
				+ "				DESG_TP_NOMINSTR, DESG_TP_APELLINSTR1, DESG_TP_APELLINSTR2, DESG_TP_NIFINSTR, CDGO_TP_CALIFI, "
				+ "				FCHA_RECICLAJE, DESG_RE_NOMINSTR, DESG_RE_APELLINSTR1, DESG_RE_APELLINSTR2, DESG_RE_NIFINSTR, "
				+ "				DESG_OBSERVACIONES, DESG_USUACT, FCHA_ACT)"
				+ "		VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
				+ "				?, CURRENT_DATE)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg209RepErrForma.class);
		sqlquery.setParameter(1, bean.getCdgoError());
		sqlquery.setParameter(2, bean.getCdgoSolicitud());
		sqlquery.setParameter(3, bean.getCdgoSapcentform());
		sqlquery.setParameter(4, bean.getDesgCif());
		sqlquery.setParameter(5, bean.getCdgoActo());
		sqlquery.setParameter(6, bean.getDesgDescacto());
		sqlquery.setParameter(7, bean.getFchaTeorico());
		sqlquery.setParameter(8, bean.getDesgTeNominstr());
		sqlquery.setParameter(9, bean.getDesgTeApellinstr1());
		sqlquery.setParameter(10, bean.getDesgTeApellinstr2());
		sqlquery.setParameter(11, bean.getDesgTeNifinstr());
		sqlquery.setParameter(12, bean.getCdgoTeCalifi());
		sqlquery.setParameter(13, bean.getFchaPractico());
		sqlquery.setParameter(14, bean.getDesgPrNominstr());
		sqlquery.setParameter(15, bean.getDesgPrApellinstr1());
		sqlquery.setParameter(16, bean.getDesgPrApellinstr2());
		sqlquery.setParameter(17, bean.getDesgPrNifinstr());
		sqlquery.setParameter(18, bean.getCdgoPrCalifi());
		sqlquery.setParameter(19, bean.getFchaTeoriprac());
		sqlquery.setParameter(20, bean.getDesgTpNominstr());
		sqlquery.setParameter(21, bean.getDesgTpApellinstr1());
		sqlquery.setParameter(22, bean.getDesgTpApellinstr2());
		sqlquery.setParameter(23, bean.getDesgTpNifinstr());
		sqlquery.setParameter(24, bean.getCdgoTpCalifi());
		sqlquery.setParameter(25, bean.getFchaReciclaje());
		sqlquery.setParameter(26, bean.getDesgReNominstr());
		sqlquery.setParameter(27, bean.getDesgReApellinstr1());
		sqlquery.setParameter(28, bean.getDesgReApellinstr2());
		sqlquery.setParameter(29, bean.getDesgReNifinstr());
		sqlquery.setParameter(30, bean.getDesgObservaciones());
		sqlquery.setParameter(31, bean.getDesgUsuact());
		return sqlquery.executeUpdate();
	}

}
