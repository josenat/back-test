package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg194DocInfrArtActiva;
import renfe.com.repository.Tbasg194DocInfrArtActivaRepositoryCustom;

public class Tbasg194DocInfrArtActivaRepositoryImpl implements Tbasg194DocInfrArtActivaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg194DocInfrArtActiva> getDocInfrArtActivaList() {

		String sqlString = "SELECT " + "		    CDGO_ARTICULO, " + "		    DESG_ARTICULO, "
				+ "		    DESG_TIPOPERSONAL, " + "		    DESG_USUACT, " + "		    FCHA_ACT, "
				+ "		    MRCA_ACTIVO " + "		FROM " + "		    PASG.TBASG194_DOC_INFR_ART_ACTIVA;";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg194DocInfrArtActiva.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg194DocInfrArtActiva> getDocInfrArtActivaByCdgoArticulo(String cdgoArticulo) {

		String sqlString = "SELECT " + "		    CDGO_ARTICULO, " + "		    DESG_ARTICULO, "
				+ "		    DESG_TIPOPERSONAL, " + "		    DESG_USUACT, " + "		    FCHA_ACT, "
				+ "		    MRCA_ACTIVO " + "		FROM " + "		    PASG.TBASG194_DOC_INFR_ART_ACTIVA"
				+ "		WHERE CDGO_ARTICULO = :value;";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg194DocInfrArtActiva.class);
		sqlquery.setParameter("value", cdgoArticulo);
		return sqlquery.getResultList();
	}

}
