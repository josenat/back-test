package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg176DocOrdenActiClave;
import renfe.com.repository.Tbasg176DocOrdenActiClaveRepositoryCustom;

public class Tbasg176DocOrdenActiClaveRepositoryImpl implements Tbasg176DocOrdenActiClaveRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg176DocOrdenActiClave> getDocOrdenActiClaveActiveList() {

		String sqlString = "SELECT D.CDGO_CLAVE, D.DESG_DESCRIPCION, D.DESG_USUACT, D.FCHA_ACT, D.MRCA_ACTIVO"
				+ "		FROM PASG.TBASG176_DOC_ORDEN_ACTI_CLAVE D" + "		WHERE D.MRCA_ACTIVO = 'S'"
				+ "		ORDER BY D.CDGO_CLAVE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg176DocOrdenActiClave.class);

		return sqlquery.getResultList();
	}

}
