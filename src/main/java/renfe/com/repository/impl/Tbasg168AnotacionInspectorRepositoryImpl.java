package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg168AnotacionInspector;
import renfe.com.repository.Tbasg168AnotacionInspectorRepositoryCustom;

public class Tbasg168AnotacionInspectorRepositoryImpl implements Tbasg168AnotacionInspectorRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg168AnotacionInspector> getAnotacionInspectorList() {

		String sqlString = "SELECT " + "		    A.CDGO_ANOTACION AS cdgoAnotacion, "
				+ "			A.CDGO_PERSONA AS cdgoPersona, " + "			A.DESG_ANOTACION AS desgAnotacion, "
				+ "			A.CDGO_TIPOANOTACION AS cdgoTipoAnotacion, " + "			A.DESG_USUARIO AS usuario,  "
				+ "			A.FCHA_ALTA AS fchaAlta,  " + "		    AR.DESG_NOMBRE AS areAct, "
				+ "			T.DESG_OPERACION AS tipoAnotacion, " + "		    P.DESG_MATRICULA AS matricula, "
				+ "			P.DESG_NOMBRE AS nombre, " + "			P.DESG_APELL1 AS apellido1, "
				+ "			P.DESG_APELL2 AS apellido2 " + "		FROM "
				+ "		    PASG.TBASG168_ANOTACION_INSPECTOR A"
				+ "		    INNER JOIN PASG.TBASG100_PERSONA P ON P.CDGO_PERSONA = A.CDGO_PERSONA"
				+ "		    INNER JOIN PASG.TBASG105_AREACTIVI AR ON AR.CDGO_AREACT = P.CDGO_AREACT"
				+ "		    INNER JOIN PASG.TBASG169_TIPO_ANOTACION T ON T.CDGO_TIPOANOTACION = A.CDGO_TIPOANOTACION"
				+ "			LEFT JOIN PASG.TBASG104_EXPEDIENT E ON P.CDGO_PERSONA=E.CDGO_PERSONA" + "		WHERE"
				+ "		    P.MRCA_ACTIVO = 'S'" + "		    AND T.MRCA_ACTIVO = 'S'"
				+ "		    AND AR.MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg168AnotacionInspector.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg168AnotacionInspector> getAnotacionInspectorListCount() {

		String sqlString = "SELECT COUNT(*) AS value" + "		FROM " + "		    PASG.TBASG168_ANOTACION_INSPECTOR A"
				+ "		    INNER JOIN PASG.TBASG100_PERSONA P ON P.CDGO_PERSONA = A.CDGO_PERSONA"
				+ "		    INNER JOIN PASG.TBASG105_AREACTIVI AR ON AR.CDGO_AREACT = P.CDGO_AREACT"
				+ "		    INNER JOIN PASG.TBASG169_TIPO_ANOTACION T ON T.CDGO_TIPOANOTACION = A.CDGO_TIPOANOTACION"
				+ "		WHERE" + "		    P.MRCA_ACTIVO = 'S'" + "		    AND T.MRCA_ACTIVO = 'S'"
				+ "		    AND AR.MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg168AnotacionInspector.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg168AnotacionInspector> getAnotacionInspectorByCdgoAnotacion(String cdgoAnotacion) {

		String sqlString = "SELECT " + "   		    A.CDGO_ANOTACION AS cdgoAnotacion, "
				+ "			A.CDGO_PERSONA AS cdgoPersona, " + "			A.DESG_ANOTACION AS desgAnotacion, "
				+ "			A.CDGO_TIPOANOTACION AS cdgoTipoAnotacion, " + "			A.DESG_USUARIO AS usuario,  "
				+ "			A.FCHA_ALTA AS fchaAlta,  " + "		    AR.DESG_NOMBRE AS areAct, "
				+ "			T.DESG_OPERACION AS tipoAnotacion, " + "		    P.DESG_MATRICULA AS matricula, "
				+ "			P.DESG_NOMBRE AS nombre, " + "			P.DESG_APELL1 AS apellido1, "
				+ "			P.DESG_APELL2 AS apellido2 " + "		FROM "
				+ "		    PASG.TBASG168_ANOTACION_INSPECTOR A"
				+ "		    INNER JOIN PASG.TBASG100_PERSONA P ON P.CDGO_PERSONA = A.CDGO_PERSONA"
				+ "		    INNER JOIN PASG.TBASG105_AREACTIVI AR ON AR.CDGO_AREACT = P.CDGO_AREACT"
				+ "		    INNER JOIN PASG.TBASG169_TIPO_ANOTACION T ON T.CDGO_TIPOANOTACION = A.CDGO_TIPOANOTACION"
				+ "		WHERE" + "		    P.MRCA_ACTIVO = 'S'" + "		    AND T.MRCA_ACTIVO = 'S'"
				+ "		    AND AR.MRCA_ACTIVO = 'S'" + "		    AND A.CDGO_ANOTACION = :value;";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg168AnotacionInspector.class);
		sqlquery.setParameter("value", cdgoAnotacion);
		return sqlquery.getResultList();
	}

}
