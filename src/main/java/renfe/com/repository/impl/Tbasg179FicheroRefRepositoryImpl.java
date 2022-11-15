package renfe.com.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg179FicheroRef;
import renfe.com.repository.Tbasg179FicheroRefRepositoryCustom;

public class Tbasg179FicheroRefRepositoryImpl implements Tbasg179FicheroRefRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg179FicheroRef> getFicheroRefList() {
		
		List <Tbasg179FicheroRef> resultadosDevueltos = new ArrayList<>();

		String sqlString = "SELECT CDGO_FICHERO, FCHA_FICHERO, DESG_FICHERO "
				+ "		FROM PASG.TBASG179_FICHERO_REF; ";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg179FicheroRef.class);
		resultadosDevueltos = sqlquery.getResultList();

		return resultadosDevueltos;
	}

	public List<Tbasg179FicheroRef> getFicheroRefListByFecha() {

		String sqlString = "SELECT CDGO_FICHERO, FCHA_FICHERO, DESG_FICHERO " + "		FROM PASG.TBASG179_FICHERO_REF"
				+ "		" + "		" + "		;";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg179FicheroRef.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg179FicheroRef> getFicheroRefListByFechaAsc() {

		String sqlString = "SELECT CDGO_FICHERO, FCHA_FICHERO, DESG_FICHERO " + "		FROM PASG.TBASG179_FICHERO_REF"
				+ "		" + "		ORDER BY FCHA_FICHERO ASC;";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg179FicheroRef.class);

		return sqlquery.getResultList();
	}

}
