package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg191DocInfrDestinatario;
import renfe.com.repository.Tbasg191DocInfrDestinatarioRepositoryCustom;

public class Tbasg191DocInfrDestinatarioRepositoryImpl implements Tbasg191DocInfrDestinatarioRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg191DocInfrDestinatario> getDocInfrDestinatarioList() {

		String sqlString = "SELECT " + "		    CDGO_DESTINATARIO, " + "		    DESG_NOMBRE, "
				+ "		    DESG_NOMBREPILA, " + "		    DESG_CARGO, " + "		    DESG_DIRECCIONGNRL, "
				+ "		    DESG_USUACT, " + "		    FCHA_ACT, " + "		    MRCA_ACTIVO " + "		FROM "
				+ "		    PASG.TBASG191_DOC_INFR_DESTINATARIO";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg191DocInfrDestinatario.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg191DocInfrDestinatario> getDocInfrDestinatarioByCdgoDestinatario(String cdgoDestinatario) {

		String sqlString = "SELECT " + "		    CDGO_DESTINATARIO, " + "		    DESG_NOMBRE, "
				+ "		    DESG_NOMBREPILA, " + "		    DESG_CARGO, " + "		    DESG_DIRECCIONGNRL, "
				+ "		    DESG_USUACT, " + "		    FCHA_ACT, " + "		    MRCA_ACTIVO " + "		FROM "
				+ "		    PASG.TBASG191_DOC_INFR_DESTINATARIO	" + "		WHERE CDGO_DESTINATARIO = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg191DocInfrDestinatario.class);
		sqlquery.setParameter("value", cdgoDestinatario);
		return sqlquery.getResultList();
	}

}
