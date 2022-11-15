package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg192DocInfrGerenciaterr;
import renfe.com.repository.Tbasg192DocInfrGerenciaterrRepositoryCustom;

public class Tbasg192DocInfrGerenciaterrRepositoryImpl implements Tbasg192DocInfrGerenciaterrRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg192DocInfrGerenciaterr> getDocInfrGerenciaTerrList() {

		String sqlString = "SELECT " + "		    CDGO_GERENCIA, " + "			DESG_ZONA, "
				+ "		    DESG_NOMBRE, " + "		    DESG_RESPONSABLE, " + "		    DESG_DIRECCION, "
				+ "		    DESG_USUACT, " + "		    FCHA_ACT, " + "		    MRCA_ACTIVO " + "		FROM "
				+ "		    PASG.TBASG192_DOC_INFR_GERENCIATERR";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg192DocInfrGerenciaterr.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg192DocInfrGerenciaterr> getDocInfrGerenciaTerrByCdgoGerencia(String cdgoGerencia) {

		String sqlString = "SELECT " + "		    CDGO_GERENCIA, " + "			DESG_ZONA, "
				+ "		    DESG_NOMBRE, " + "		    DESG_RESPONSABLE, " + "		    DESG_DIRECCION, "
				+ "		    DESG_USUACT, " + "		    FCHA_ACT, " + "		    MRCA_ACTIVO " + "		FROM "
				+ "		    PASG.TBASG192_DOC_INFR_GERENCIATERR" + "		WHERE CDGO_GERENCIA = :value;";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg192DocInfrGerenciaterr.class);
		sqlquery.setParameter("value", cdgoGerencia);
		return sqlquery.getResultList();
	}

}
