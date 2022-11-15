package renfe.com.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg149Fdconfhab;
import renfe.com.repository.Tbasg149FdconfhabRepositoryCustom;

public class Tbasg149FdconfhabRepositoryImpl implements Tbasg149FdconfhabRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public int insertFdConfHab(Tbasg149Fdconfhab bean) {

		String sqlString = "INSERT INTO PASG.TBASG149_FDCONFHAB (CDGO_EXPEDIENT, DESG_TEXTO, DESG_TXTENCRIPTADO, DESG_USUARIO, FCHA_FIRMA)"
				+ "		VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg149Fdconfhab.class);
		sqlquery.setParameter(1, bean.getCdgoExpedient());
		sqlquery.setParameter(2, bean.getDesgTexto());
		sqlquery.setParameter(3, bean.getDesgTxtencriptado());
		sqlquery.setParameter(4, bean.getDesgUsuario());
		return sqlquery.executeUpdate();
	}

}
