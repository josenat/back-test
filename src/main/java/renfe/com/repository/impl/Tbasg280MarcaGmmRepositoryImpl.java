package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg280MarcaGmm;
import renfe.com.repository.Tbasg280MarcaGmmRepositoryCustom;

public class Tbasg280MarcaGmmRepositoryImpl implements Tbasg280MarcaGmmRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg280MarcaGmm> getASG280(String desgMatricula) {

		String sqlString = "SELECT *" + "				FROM " + "					PASG.TBASG280_MARCA_GMM"
				+ "				WHERE" + "					DESG_MATRICULA=:matricula AND FCHA_ACT=CURRENT_DATE;";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg280MarcaGmm.class);
		sqlquery.setParameter("matricula", desgMatricula);
		return sqlquery.getResultList();
	}

	public int insertFicheroASG280(Tbasg280MarcaGmm bean) {

		String sqlString = "INSERT INTO PASG.TBASG280_MARCA_GMM"
				+ "		(DESG_MATRICULA, MRCA_ESTADO, DESG_USUACT, FCHA_ACT, MRCA_GRABADO_GMM, FCHA_GRABADO_GMM)"
				+ "		VALUES (:matricula, 'I', :desgUsuact, CURRENT_DATE, 'N', NULL);";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg280MarcaGmm.class);
		sqlquery.setParameter("matricula", bean.getTbasg280marcagmmpk().getDesgMatricula());
		sqlquery.setParameter("desgUsuact", bean.getDesgUsuact());
		return sqlquery.executeUpdate();
	}

}
