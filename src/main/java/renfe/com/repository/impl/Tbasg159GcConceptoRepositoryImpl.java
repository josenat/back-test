package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg159GcConcepto;
import renfe.com.repository.Tbasg159GcConceptoRepositoryCustom;

public class Tbasg159GcConceptoRepositoryImpl implements Tbasg159GcConceptoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg159GcConcepto> getGcConceptosActiveList() {

		String sqlString = "SELECT * FROM PASG.TBASG159_GC_CONCEPTO " + "		WHERE MRCA_ACTIVO='S' "
				+ "		ORDER BY CDGO_CATEGORIA, CDGO_ORDEN";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg159GcConcepto.class);

		return sqlquery.getResultList();
	}

}
