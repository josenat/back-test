package renfe.com.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg208RepErrInact;
import renfe.com.repository.Tbasg208RepErrInactRepositoryCustom;

public class Tbasg208RepErrInactRepositoryImpl implements Tbasg208RepErrInactRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public int insertRepErrInact(Tbasg208RepErrInact bean) {

		String sqlString = "INSERT INTO PASG.TBASG208_REP_ERR_INACT (CDGO_ERROR, DESG_MATRICULA, DESG_MEDIDABAJA, "
				+ "				FCHA_BAJA, DESG_USUACT, FCHA_ACT)" + "		VALUES (?, ?, ?, ?, ?, CURRENT_DATE)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg208RepErrInact.class);
		sqlquery.setParameter(1, bean.getCdgoError());
		sqlquery.setParameter(2, bean.getDesgMatricula());
		sqlquery.setParameter(3, bean.getDesgMedidabaja());
		sqlquery.setParameter(4, bean.getFchaBaja());
		sqlquery.setParameter(5, bean.getDesgUsuact());
		return sqlquery.executeUpdate();
	}

}
