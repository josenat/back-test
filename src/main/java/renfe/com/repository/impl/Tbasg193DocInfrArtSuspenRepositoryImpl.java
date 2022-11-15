package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg193DocInfrArtSuspen;
import renfe.com.repository.Tbasg193DocInfrArtSuspenRepositoryCustom;

public class Tbasg193DocInfrArtSuspenRepositoryImpl implements Tbasg193DocInfrArtSuspenRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg193DocInfrArtSuspen> getDocInfrArtSuspenList() {

		String sqlString = "SELECT " + "		    CDGO_ARTICULO, " + "		    DESG_ARTICULO, "
				+ "		    DESG_TIPOPERSONAL, " + "		    DESG_USUACT, " + "		    FCHA_ACT, "
				+ "		    MRCA_ACTIVO " + "		FROM " + "		    PASG.TBASG193_DOC_INFR_ART_SUSPEN";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg193DocInfrArtSuspen.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg193DocInfrArtSuspen> getDocInfrArtSuspenByCdgoArticulo(String cdgoArticulo) {

		String sqlString = "SELECT " + "		    CDGO_ARTICULO, " + "		    DESG_ARTICULO, "
				+ "		    DESG_TIPOPERSONAL, " + "		    DESG_USUACT, " + "		    FCHA_ACT, "
				+ "		    MRCA_ACTIVO " + "		FROM " + "		    PASG.TBASG193_DOC_INFR_ART_SUSPEN"
				+ "		WHERE CDGO_ARTICULO = :value;";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg193DocInfrArtSuspen.class);
		sqlquery.setParameter("value", cdgoArticulo);
		return sqlquery.getResultList();
	}

}
