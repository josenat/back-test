package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg169TipoAnotacion;
import renfe.com.repository.Tbasg169TipoAnotacionRepositoryCustom;

public class Tbasg169TipoAnotacionRepositoryImpl implements Tbasg169TipoAnotacionRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg169TipoAnotacion> getTipoAnotacionInspectorActiveList() {

		String sqlString = "SELECT * FROM PASG.TBASG169_TIPO_ANOTACION WHERE MRCA_ACTIVO = 'S' ORDER BY CDGO_TIPOANOTACION;";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg169TipoAnotacion.class);

		return sqlquery.getResultList();
	}

}
