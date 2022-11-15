package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg173DatoPlantDoc;
import renfe.com.repository.Tbasg173DatoPlantDocRepositoryCustom;

public class Tbasg173DatoPlantDocRepositoryImpl implements Tbasg173DatoPlantDocRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg173DatoPlantDoc> getDatoPlantDocActiveList(String cdgoDocumento) {

		String sqlString = "SELECT D.CDGO_DOCUMENTO, D.CDGO_CLAVE, D.DESG_VALOR, D.DESG_USUACT, D.FCHA_ACT, D.MRCA_ACTIVO"
				+ "		FROM PASG.TBASG173_DATO_PLANT_DOC D" + "		WHERE D.MRCA_ACTIVO = 'S'"
				+ "		      AND D.CDGO_DOCUMENTO = :cdgoDocumento" + "		ORDER BY D.CDGO_CLAVE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg173DatoPlantDoc.class);
		sqlquery.setParameter("cdgoDocumento", cdgoDocumento);
		return sqlquery.getResultList();
	}

}
