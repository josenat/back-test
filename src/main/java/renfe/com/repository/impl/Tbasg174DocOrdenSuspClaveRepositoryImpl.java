package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg174DocOrdenSuspClave;
import renfe.com.repository.Tbasg174DocOrdenSuspClaveRepositoryCustom;

public class Tbasg174DocOrdenSuspClaveRepositoryImpl implements Tbasg174DocOrdenSuspClaveRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg174DocOrdenSuspClave> getDocOrdenSuspClaveActiveList() {

		String sqlString = "SELECT D.CDGO_CLAVE, D.DESG_DESCRIPCION, D.DESG_USUACT, D.FCHA_ACT, D.MRCA_ACTIVO"
				+ "		FROM PASG.TBASG174_DOC_ORDEN_SUSP_CLAVE D" + "		WHERE D.MRCA_ACTIVO = 'S'"
				+ "		ORDER BY D.CDGO_CLAVE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg174DocOrdenSuspClave.class);

		return sqlquery.getResultList();
	}

}
