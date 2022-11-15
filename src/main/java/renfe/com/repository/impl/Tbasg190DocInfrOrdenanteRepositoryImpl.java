package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg190DocInfrOrdenante;
import renfe.com.repository.Tbasg190DocInfrOrdenanteRepositoryCustom;

public class Tbasg190DocInfrOrdenanteRepositoryImpl implements Tbasg190DocInfrOrdenanteRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg190DocInfrOrdenante> getDocInfrOrdenanteList() {

		String sqlString = "SELECT " + "		    CDGO_ORDENANTE, " + "		    DESG_DEPARTAMENTO, "
				+ "		    DESG_INICIALESDEPT, " + "		    DESG_NOMBRE, " + "		    DESG_CARGO, "
				+ "		    DESG_TELEFONO, " + "		    DESG_FAX, " + "		    DESG_USUACT, "
				+ "		    FCHA_ACT, " + "		    MRCA_ACTIVO " + "		FROM "
				+ "		    PASG.TBASG190_DOC_INFR_ORDENANTE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg190DocInfrOrdenante.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg190DocInfrOrdenante> getDocInfrOrdenanteByCdgoOrdenante(String cdgoOrdenante) {

		String sqlString = "SELECT " + "		    CDGO_ORDENANTE, " + "		    DESG_DEPARTAMENTO, "
				+ "		    DESG_INICIALESDEPT, " + "		    DESG_NOMBRE, " + "		    DESG_CARGO, "
				+ "		    DESG_TELEFONO, " + "		    DESG_FAX, " + "		    DESG_USUACT, "
				+ "		    FCHA_ACT, " + "		    MRCA_ACTIVO " + "		FROM "
				+ "		    PASG.TBASG190_DOC_INFR_ORDENANTE" + "		WHERE CDGO_ORDENANTE = :value;";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg190DocInfrOrdenante.class);
		sqlquery.setParameter("value", cdgoOrdenante);
		return sqlquery.getResultList();
	}

}
