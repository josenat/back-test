package renfe.com.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg148Fdotorhab;
import renfe.com.repository.Tbasg148FdotorhabRepositoryCustom;

public class Tbasg148FdotorhabRepositoryImpl implements Tbasg148FdotorhabRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public int insertFdOtorHab(Tbasg148Fdotorhab bean) {

		String sqlString = "INSERT INTO PASG.TBASG148_FDOTORHAB (CDGO_EXPEDIENT, DESG_TEXTO, DESG_TXTENCRIPTADO, DESG_USUARIO, FCHA_FIRMA)"
				+ "		VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg148Fdotorhab.class);
		sqlquery.setParameter(1, bean.getCdgoExpedient());
		sqlquery.setParameter(2, bean.getDesgTexto());
		sqlquery.setParameter(3, bean.getDesgTxtencriptado());
		sqlquery.setParameter(4, bean.getDesgUsuario());
		return sqlquery.executeUpdate();
	}

}
