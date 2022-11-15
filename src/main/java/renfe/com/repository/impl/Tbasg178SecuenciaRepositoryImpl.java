package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg178Secuencia;
import renfe.com.repository.Tbasg178SecuenciaRepositoryCustom;

public class Tbasg178SecuenciaRepositoryImpl implements Tbasg178SecuenciaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg178Secuencia> getSequence(String entityName) {

		String sqlString = "SELECT NEXT_ID" + "		FROM PASG.TBASG178_SECUENCIA" + "		WHERE ENTITY_NAME = :value"
				+ "		FOR UPDATE OF NEXT_ID;";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg178Secuencia.class);
		sqlquery.setParameter("value", entityName);
		return sqlquery.getResultList();
	}

	public int updateSequence(Tbasg178Secuencia bean) {

		String sqlString = "UPDATE PASG.TBASG178_SECUENCIA" + "		SET NEXT_ID = ?" + "		WHERE ENTITY_NAME = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg178Secuencia.class);
		sqlquery.setParameter(1, bean.getNextId());
		sqlquery.setParameter(2, bean.getEntityName());
		return sqlquery.executeUpdate();
	}

}
