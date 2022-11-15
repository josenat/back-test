package renfe.com.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg206RepErrSalud;
import renfe.com.repository.Tbasg206RepErrSaludRepositoryCustom;

public class Tbasg206RepErrSaludRepositoryImpl implements Tbasg206RepErrSaludRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public int insertRepErrSalud(Tbasg206RepErrSalud bean) {

		String sqlString = " INSERT INTO PASG.TBASG206_REP_ERR_SALUD "
				+ "(CDGO_ERROR, DESG_MATRICULA, DESG_NIFPAS, DESG_NOMBRE, DESG_APELL1, DESG_APELL2, DESG_MOTIVOREV, DESG_CALIFIC, DESG_NUMCOLEGIADO, DESG_NOMBREFACULT, DESG_APELL1FACULT, DESG_APELL2FACULT, MRCA_CORRECVISU, MRCA_PROTEAUDI, DESG_CENTROMED, FCHA_RECONOC, FCHA_VALIDEZCERT, FCHA_PROXREV, DESG_AMBITOVALCERT, DESG_USUACT, FCHA_ACT) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE) ";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg206RepErrSalud.class);
		sqlquery.setParameter(1, bean.getCdgoError());
		sqlquery.setParameter(2, bean.getDesgMatricula());
		sqlquery.setParameter(3, bean.getDesgNifpas());
		sqlquery.setParameter(4, bean.getDesgNombre());
		sqlquery.setParameter(5, bean.getDesgApell1());
		sqlquery.setParameter(6, bean.getDesgApell2());
		sqlquery.setParameter(7, bean.getDesgMotivorev());
		sqlquery.setParameter(8, bean.getDesgCalific());
		sqlquery.setParameter(9, bean.getDesgNumcolegiado());
		sqlquery.setParameter(10, bean.getDesgNombrefacult());
		sqlquery.setParameter(11, bean.getDesgApell1Facult());
		sqlquery.setParameter(12, bean.getDesgApell2Facult());
		sqlquery.setParameter(13, bean.getMrcaCorrecvisu());
		sqlquery.setParameter(14, bean.getMrcaProteaudi());
		sqlquery.setParameter(15, bean.getDesgCentromed());
		sqlquery.setParameter(16, bean.getFchaReconoc());
		sqlquery.setParameter(17, bean.getFchaValidezcert());
		sqlquery.setParameter(18, bean.getFchaProxrev());
		sqlquery.setParameter(19, bean.getDesgAmbitovalcert());
		sqlquery.setParameter(20, bean.getDesgUsuact());
		return sqlquery.executeUpdate();
	}

}
