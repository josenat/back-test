package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg158GcCategoria;
import renfe.com.repository.Tbasg158GcCategoriaRepositoryCustom;

public class Tbasg158GcCategoriaRepositoryImpl implements Tbasg158GcCategoriaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg158GcCategoria> getGcCategoriasActiveList() {

		String sqlString = "SELECT * FROM PASG.TBASG158_GC_CATEGORIA WHERE MRCA_ACTIVO='S' ORDER BY CDGO_ORDEN";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg158GcCategoria.class);

		return sqlquery.getResultList();
	}

}
