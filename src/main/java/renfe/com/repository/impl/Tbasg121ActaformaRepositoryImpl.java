package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.dto.GetActaFormaDTO;
import renfe.com.dto.GetActasPersonaOrderByCdgoActaFormDTO;
import renfe.com.dto.GetCdgoActaFormByTitUltimoDTO;
import renfe.com.dto.GetEstadosMasExpDTO;
import org.springframework.transaction.annotation.Transactional;

import renfe.com.dto.GetActaformaResultDTO;
import renfe.com.model.entity.Tbasg121Actaforma;
import renfe.com.repository.Tbasg121ActaformaRepositoryCustom;

public class Tbasg121ActaformaRepositoryImpl implements Tbasg121ActaformaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg121Actaforma> getExpiredActaForma(String fchaCurso) {

		String sqlString = "SELECT DISTINCT ACTA.*"
				+ "		FROM PASG.TBASG121_ACTAFORMA ACTA INNER JOIN PASG.TBASG146_ACTAINCAL CURSO"
				+ "        								  ON ACTA.CDGO_ACTAFORM = CURSO.CDGO_ACTAFORM " + "		"
				+ "		    	    " + "		" + "		WHERE CURSO.MRCA_ACTIVO = 'S'"
				+ "		AND ACTA.MRCA_ACTIVO = 'S' " + "		AND (CURSO.FCHA_CURSO + 3 YEARS) < :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg121Actaforma.class);
		sqlquery.setParameter("value", fchaCurso);
		return sqlquery.getResultList();
	}

	public List<Tbasg121Actaforma> getNoExpiredActaFormaByCdgoExpedient(String cdgoExpedient, String fchaCurso) {

		String sqlString = "SELECT DISTINCT ACTA.*"
				+ "		FROM PASG.TBASG121_ACTAFORMA ACTA INNER JOIN PASG.TBASG146_ACTAINCAL CURSO"
				+ "			ON ACTA.CDGO_ACTAFORM = CURSO.CDGO_ACTAFORM "
				+ "		WHERE CDGO_EXPEDIENT = :cdgoExpedient " + "			AND CURSO.MRCA_ACTIVO = 'S'"
				+ "			AND ACTA.MRCA_ACTIVO = 'S' " + "			AND (CURSO.FCHA_CURSO + 3 YEARS) >= :fecha";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg121Actaforma.class);
		sqlquery.setParameter("cdgoExpedient", cdgoExpedient);
		sqlquery.setParameter("fecha", fchaCurso);
		return sqlquery.getResultList();
	}

	public List<Tbasg121Actaforma> getNoExpiredActaFormaByCdgoTit(String cdgoTit, String fchaCurso) {

		String sqlString = "SELECT DISTINCT ACTA.*"
				+ "		FROM PASG.TBASG121_ACTAFORMA ACTA INNER JOIN PASG.TBASG146_ACTAINCAL CURSO"
				+ "			ON ACTA.CDGO_ACTAFORM = CURSO.CDGO_ACTAFORM " + "		WHERE CDGO_TIT = :cdgoTit"
				+ "			AND CURSO.MRCA_ACTIVO = 'S'" + "			AND ACTA.MRCA_ACTIVO = 'S' "
				+ "			AND (CURSO.FCHA_CURSO + 3 YEARS) >= :fecha";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg121Actaforma.class);
		sqlquery.setParameter("cdgoTit", cdgoTit);
		sqlquery.setParameter("fecha", fchaCurso);
		return sqlquery.getResultList();
	}

	public List<Tbasg121Actaforma> getActaForma(String cdgoActaform) {

		String sqlString = "SELECT * FROM PASG.TBASG121_ACTAFORMA WHERE CDGO_ACTAFORM = :value AND MRCA_ACTIVO ='S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg121Actaforma.class);
		sqlquery.setParameter("value", cdgoActaform);
		return sqlquery.getResultList();
	}

	public List<Tbasg121Actaforma> getActaFormaByCod(String cdgoActaform) {

		String sqlString = "SELECT * FROM PASG.TBASG121_ACTAFORMA WHERE CDGO_ACTAFORM = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg121Actaforma.class);
		sqlquery.setParameter("value", cdgoActaform);
		return sqlquery.getResultList();
	}

	public List<Tbasg121Actaforma> getActasFormaByCods() {

		String sqlString = "SELECT * FROM PASG.TBASG121_ACTAFORMA" + "			"
				+ "		ORDER BY CDGO_ACTAFORM ASC, DESG_DESCCURSO ASC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg121Actaforma.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg121Actaforma> getActaFormaList() {

		String sqlString = "SELECT * FROM PASG.TBASG121_ACTAFORMA";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg121Actaforma.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg121Actaforma> getActaFormaExpediente(String cdgoExpedient) {

		String sqlString = "SELECT * FROM PASG.TBASG121_ACTAFORMA WHERE CDGO_EXPEDIENT = :value AND MRCA_ACTIVO ='S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg121Actaforma.class);
		sqlquery.setParameter("value", cdgoExpedient);
		return sqlquery.getResultList();
	}

	public List<GetActaFormaDTO> getHistoricActaFormaPersona(Integer cdgoExpedient) {

		String sqlString = "    SELECT RTRIM(AF.CDGO_CURSO) AS CDGO_CURSO, RTRIM(AF.DESG_DESCCURSO) AS DESC_CURSO, RTRIM(AF.DESG_OBSERVA) AS OBSERVACIONES, CF.DESG_NOMBRE AS CENTRO_FORMA, " +
				"   AC.DESG_TIPOCURSO, CA.DESG_NOMBRE AS CALIFICACION, CONCAT(RTRIM(IT.DESG_NOMBRE),CONCAT(' ',CONCAT(RTRIM(IT.DESG_APELL1),CONCAT(' ', RTRIM(IT.DESG_APELL2))))) AS INSTRUCTOR, " +
				"   AC.FCHA_CURSO, 0 AS TITULO FROM PASG.TBASG121_ACTAFORMA AF " +
				"   INNER JOIN PASG.TBASG146_ACTAINCAL AC ON AF.CDGO_ACTAFORM = AC.CDGO_ACTAFORM " +
				"   INNER JOIN PASG.TBASG115_CALIFICAC CA ON AC.CDGO_CALIFI = CA.CDGO_CALIFI " +
				"  LEFT JOIN PASG.TBASG120_CENTFORMA CF ON AF.CDGO_CENTROFOR = CF.CDGO_CENTROFOR " +
				"   LEFT JOIN PASG.TBASG122_INSTRU IT ON AC.CDGO_IDINSTRU = IT.CDGO_NIF WHERE AF.CDGO_EXPEDIENT = :value " +
				"           UNION " +
				"           SELECT RTRIM(AF.CDGO_CURSO) AS CDGO_CURSO, RTRIM(AF.DESG_DESCCURSO) AS DESC_CURSO, RTRIM(AF.DESG_OBSERVA) AS OBSERVACIONES, CF.DESG_NOMBRE AS CENTRO_FORMA, " +
				"   AC.DESG_TIPOCURSO, CA.DESG_NOMBRE AS CALIFICACION, CONCAT(RTRIM(IT.DESG_NOMBRE),CONCAT(' ',CONCAT(RTRIM(IT.DESG_APELL1),CONCAT(' ', RTRIM(IT.DESG_APELL2))))) AS INSTRUCTOR, " +
				" AC.FCHA_CURSO, 1 AS TITULO FROM PASG.TBASG104_EXPEDIENT EX " +
				" INNER JOIN PASG.TBASG102_TITULOCON TC ON EX.CDGO_PERSONA = TC.CDGO_PERSONA " +
				" INNER JOIN PASG.TBASG121_ACTAFORMA AF ON TC.CDGO_TIT = AF.CDGO_TIT " +
				" INNER JOIN PASG.TBASG146_ACTAINCAL AC ON AF.CDGO_ACTAFORM = AC.CDGO_ACTAFORM " +
				" INNER JOIN PASG.TBASG115_CALIFICAC CA ON AC.CDGO_CALIFI = CA.CDGO_CALIFI " +
				" LEFT JOIN PASG.TBASG120_CENTFORMA CF ON AF.CDGO_CENTROFOR = CF.CDGO_CENTROFOR " +
				" LEFT JOIN PASG.TBASG122_INSTRU IT ON AC.CDGO_IDINSTRU = IT.CDGO_NIF WHERE EX.CDGO_EXPEDIENT = :value  ";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoExpedient);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetActaFormaDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetActaFormaDTO historiactaforma = new GetActaFormaDTO();

			historiactaforma.setCdgoCurso((String)object[0]);
			historiactaforma.setDescCurso((String)object[1]);
			historiactaforma.setObserva((String)object[2]);
			historiactaforma.setCentroFor((String)object[3]);
			historiactaforma.setTipoCurso((String)object[4]);
			historiactaforma.setCalifi((String)object[5]);
			historiactaforma.setInstructor((String)object[6]);
			historiactaforma.setFecCurso((Date)object[7]);
			historiactaforma.setTitulo((Integer)object[8]);

			resultadosDevueltos.add(historiactaforma);
		}
		return resultadosDevueltos;
	}

	public List<GetActaFormaDTO> getLastActaForma(Integer cdgoExpedient) {

		String sqlString = "  SELECT RTRIM(AF.CDGO_CURSO) AS CDGO_CURSO, RTRIM(AF.DESG_DESCCURSO) AS DESC_CURSO, RTRIM(AF.DESG_OBSERVA) AS OBSERVACIONES, CF.DESG_NOMBRE AS CENTRO_FORMA, " +
				" AC.DESG_TIPOCURSO, CA.DESG_NOMBRE AS CALIFICACION, CONCAT(RTRIM(IT.DESG_NOMBRE),CONCAT(' ',CONCAT(RTRIM(IT.DESG_APELL1),CONCAT(' ', RTRIM(IT.DESG_APELL2))))) AS INSTRUCTOR, " +
				" AC.FCHA_CURSO, 0 AS TITULO FROM PASG.TBASG121_ACTAFORMA AF " +
				" INNER JOIN PASG.TBASG146_ACTAINCAL AC ON AF.CDGO_ACTAFORM = AC.CDGO_ACTAFORM " +
				" INNER JOIN PASG.TBASG115_CALIFICAC CA ON AC.CDGO_CALIFI = CA.CDGO_CALIFI " +
				" LEFT JOIN PASG.TBASG120_CENTFORMA CF ON AF.CDGO_CENTROFOR = CF.CDGO_CENTROFOR " +
				" LEFT JOIN PASG.TBASG122_INSTRU IT ON AC.CDGO_IDINSTRU = IT.CDGO_NIF " +
				"    WHERE AF.CDGO_EXPEDIENT = :value AND AC.MRCA_ACTIVO = 'S' AND AF.MRCA_ACTIVO = 'S' " +
				" AND AC.FCHA_CURSO = (SELECT MAX(B.FCHA_CURSO) FROM PASG.TBASG121_ACTAFORMA A " +
				" INNER JOIN PASG.TBASG146_ACTAINCAL B ON A.CDGO_ACTAFORM = B.CDGO_ACTAFORM WHERE AF.CDGO_EXPEDIENT = A.CDGO_EXPEDIENT) " +
				"   UNION " +
				"     SELECT RTRIM(AF.CDGO_CURSO) AS CDGO_CURSO, RTRIM(AF.DESG_DESCCURSO) AS DESC_CURSO, RTRIM(AF.DESG_OBSERVA) AS OBSERVACIONES, CF.DESG_NOMBRE AS CENTRO_FORMA, " +
				" AC.DESG_TIPOCURSO, CA.DESG_NOMBRE AS CALIFICACION, CONCAT(RTRIM(IT.DESG_NOMBRE),CONCAT(' ',CONCAT(RTRIM(IT.DESG_APELL1),CONCAT(' ', RTRIM(IT.DESG_APELL2))))) AS INSTRUCTOR, " +
				" AC.FCHA_CURSO, 1 AS TITULO FROM PASG.TBASG104_EXPEDIENT EX " +
				" INNER JOIN PASG.TBASG102_TITULOCON TC ON EX.CDGO_PERSONA = TC.CDGO_PERSONA " +
				" INNER JOIN PASG.TBASG121_ACTAFORMA AF ON TC.CDGO_TIT = AF.CDGO_TIT " +
				" INNER JOIN PASG.TBASG146_ACTAINCAL AC ON AF.CDGO_ACTAFORM = AC.CDGO_ACTAFORM " +
				" INNER JOIN PASG.TBASG115_CALIFICAC CA ON AC.CDGO_CALIFI = CA.CDGO_CALIFI " +
				" LEFT JOIN PASG.TBASG120_CENTFORMA CF ON AF.CDGO_CENTROFOR = CF.CDGO_CENTROFOR " +
				" LEFT JOIN PASG.TBASG122_INSTRU IT ON AC.CDGO_IDINSTRU = IT.CDGO_NIF " +
				"  WHERE EX.CDGO_EXPEDIENT = :value AND TC.MRCA_ACTIVO = 'S' AND AC.MRCA_ACTIVO = 'S' AND AF.MRCA_ACTIVO = 'S' " +
				" AND AC.FCHA_CURSO = (SELECT MAX(B.FCHA_CURSO) FROM PASG.TBASG121_ACTAFORMA A " +
				" INNER JOIN PASG.TBASG146_ACTAINCAL B ON A.CDGO_ACTAFORM = B.CDGO_ACTAFORM WHERE AF.CDGO_TIT = A.CDGO_TIT)  ";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoExpedient);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetActaFormaDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetActaFormaDTO historiactaforma = new GetActaFormaDTO();

			historiactaforma.setCdgoCurso((String)object[0]);
			historiactaforma.setDescCurso((String)object[1]);
			historiactaforma.setObserva((String)object[2]);
			historiactaforma.setCentroFor((String)object[3]);
			historiactaforma.setTipoCurso((String)object[4]);
			historiactaforma.setCalifi((String)object[5]);
			historiactaforma.setInstructor((String)object[6]);
			historiactaforma.setFecCurso((Date)object[7]);
			historiactaforma.setTitulo((Integer)object[8]);

			resultadosDevueltos.add(historiactaforma);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg121Actaforma> getActaFormaCount() {

		String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG121_ACTAFORMA";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg121Actaforma.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg121Actaforma> getActasExpediente(String cdgoExpedient) {

		String sqlString = "SELECT A.CDGO_ACTAFORM, A.CDGO_EXPEDIENT, A.CDGO_TIT, RTRIM(A.CDGO_CURSO) AS CDGO_CURSO, RTRIM(A.DESG_DESCCURSO) AS DESG_DESCCURSO, "
				+ "		      RTRIM(A.DESG_OBSERVA) AS DESG_OBSERVA, A.CDGO_CENTROFOR, B.DESG_TIPOCURSO, B.CDGO_CALIFI, B.CDGO_IDINSTRU, B.FCHA_CURSO"
				+ "			FROM PASG.TBASG121_ACTAFORMA A, PASG.TBASG146_ACTAINCAL B"
				+ "		    WHERE A.CDGO_ACTAFORM = B.CDGO_ACTAFORM" + "		        AND A.CDGO_EXPEDIENT = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg121Actaforma.class);
		sqlquery.setParameter("value", cdgoExpedient);
		return sqlquery.getResultList();
	}

	public List<Tbasg121Actaforma> getCdgoActaFormByExpUltimo(String cdgoExpedient) {

		String sqlString = "SELECT DISTINCT F.CDGO_ACTAFORM" + "		FROM PASG.TBASG121_ACTAFORMA F "
				+ "		INNER JOIN PASG.TBASG146_ACTAINCAL C ON F.CDGO_ACTAFORM = C.CDGO_ACTAFORM "
				+ "		WHERE F.CDGO_EXPEDIENT = :value" + "		    AND F.MRCA_ACTIVO = 'S'"
				+ "		    AND C.MRCA_ACTIVO = 'S'"
				+ "		    AND C.FCHA_CURSO = (SELECT MAX(FCHA_CURSO) FROM PASG.TBASG146_ACTAINCAL "
				+ "		                        WHERE CDGO_ACTAFORM IN (SELECT CDGO_ACTAFORM FROM PASG.TBASG121_ACTAFORMA "
				+ "		                                                WHERE CDGO_EXPEDIENT = :value AND MRCA_ACTIVO = 'S'))	"
				+ "		FETCH FIRST 1 ROWS ONLY";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoExpedient);
		List<Object> resultados = sqlquery.getResultList();
		List<Tbasg121Actaforma> resultadosDevueltos = new ArrayList<>();
		for (Object object : resultados) {
			Tbasg121Actaforma actaForma = new Tbasg121Actaforma();

			actaForma.setCdgoActaform((Integer)object);

			resultadosDevueltos.add(actaForma);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg121Actaforma> getCdgosActasFormsByExpsUltimo() {

		String sqlString = "SELECT DISTINCT " + "			F.CDGO_ACTAFORM, F.CDGO_EXPEDIENT" + "		FROM "
				+ "			PASG.TBASG121_ACTAFORMA F "
				+ "			INNER JOIN PASG.TBASG146_ACTAINCAL C ON F.CDGO_ACTAFORM = C.CDGO_ACTAFORM";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg121Actaforma.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg121Actaforma> getActaFormaByExp(String cdgoExpedient) {

		String sqlString = "SELECT * FROM PASG.TBASG121_ACTAFORMA" + "		WHERE" + "		    CDGO_EXPEDIENT = :value"
				+ "		    AND MRCA_ACTIVO = 'S';";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg121Actaforma.class);
		sqlquery.setParameter("value", cdgoExpedient);
		return sqlquery.getResultList();
	}

	public List<Tbasg121Actaforma> getActaFormaByTit(String cdgoTit) {

		String sqlString = "SELECT * FROM PASG.TBASG121_ACTAFORMA" + "		WHERE" + "		    CDGO_TIT = :value"
				+ "		    AND MRCA_ACTIVO = 'S';";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg121Actaforma.class);
		sqlquery.setParameter("value", cdgoTit);
		return sqlquery.getResultList();
	}

	public List<Tbasg121Actaforma> getExistActaExpediente(String cdgoActaform, String cdgoExpedient) {

		String sqlString = "select count(*) as value from PASG.TBASG121_ACTAFORMA"
				+ "		    WHERE CDGO_ACTAFORM = :cdgoActa" + "        		AND CDGO_EXPEDIENT = :cdgoExpediente";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg121Actaforma.class);
		sqlquery.setParameter("cdgoActa", cdgoActaform);
		sqlquery.setParameter("cdgoExpediente", cdgoExpedient);
		return sqlquery.getResultList();
	}

	public List<Tbasg121Actaforma> getExistActaAcreditacion(String cdgoActaform, String cdgoAcredita) {

		String sqlString = "select count(*) as value from PASG.TBASG121_ACTAFORMA"
				+ "		    WHERE CDGO_ACTAFORM = :cdgoActa" + "        		AND CDGO_ACREDITA = :cdgoAcreditacion";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg121Actaforma.class);
		sqlquery.setParameter("cdgoActa", cdgoActaform);
		sqlquery.setParameter("cdgoAcreditacion", cdgoAcredita);
		return sqlquery.getResultList();
	}

	public List<Tbasg121Actaforma> getExistActaAcre(Tbasg121Actaforma bean) {

		String sqlString = "select * from PASG.TBASG121_ACTAFORMA"
				+ "		    WHERE CDGO_ACREDITA = :cdgoAcreditacion";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("cdgoAcreditacion", bean.getCdgoAcredita());
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg121Actaforma> resultadosDevueltos = new ArrayList<>();
			for (Object[] object : resultados) {
				Tbasg121Actaforma actaForma = new Tbasg121Actaforma();
					
				actaForma.setCdgoActaform((Integer)object[0]);
				actaForma.setCdgoAcredita((Integer)object[10]);
					
				resultadosDevueltos.add(actaForma);
			}
			return resultadosDevueltos;
	}

	public List<GetCdgoActaFormByTitUltimoDTO> getCdgoActaFormByTitUltimo(Integer cdgoTit) {

		String sqlString = "SELECT DISTINCT F.CDGO_ACTAFORM" + "		FROM PASG.TBASG121_ACTAFORMA F "
				+ "		INNER JOIN PASG.TBASG146_ACTAINCAL C ON F.CDGO_ACTAFORM = C.CDGO_ACTAFORM "
				+ "		WHERE F.CDGO_TIT = :value" + "		    AND F.MRCA_ACTIVO = 'S'"
				+ "		    AND C.MRCA_ACTIVO = 'S'"
				+ "		    AND C.FCHA_CURSO = (SELECT MAX(FCHA_CURSO) FROM PASG.TBASG146_ACTAINCAL "
				+ "		                        WHERE CDGO_ACTAFORM IN (SELECT CDGO_ACTAFORM FROM PASG.TBASG121_ACTAFORMA "
				+ "		                                                WHERE CDGO_TIT = :value AND MRCA_ACTIVO = 'S'));";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoTit);
		
		List<Object> resultados = sqlquery.getResultList();
		List<GetCdgoActaFormByTitUltimoDTO> resultadosDevueltos = new ArrayList<GetCdgoActaFormByTitUltimoDTO>();
		for (Object object : resultados) {
			GetCdgoActaFormByTitUltimoDTO miClase = new GetCdgoActaFormByTitUltimoDTO();
			miClase.setCdgoActaform((Integer)object);
			resultadosDevueltos.add(miClase);
		}
		return resultadosDevueltos;
	}
	
	public List<GetActasPersonaOrderByCdgoActaFormDTO> getActasPersonaOrderByCdgoActaForm(Integer cdgoPersona, Integer cdgoExpediente) {

		String sqlString =
				"SELECT A.CDGO_ACTAFORM AS CDGO_ACTAFORM, A.CDGO_EXPEDIENT AS CODIGO, RTRIM(A.CDGO_CURSO) AS CDGO_CURSO, RTRIM(A.DESG_DESCCURSO) AS DESG_DESCCURSO, " +
		      	"RTRIM(A.DESG_OBSERVA) AS DESG_OBSERVA, A.CDGO_CENTROFOR, " +
				"B.DESG_TIPOCURSO, B.CDGO_CALIFI, RTRIM(B.CDGO_IDINSTRU) AS CDGO_IDINSTRU, B.FCHA_CURSO, 0 AS TITULO, RTRIM(B.CDGO_IDEXA) AS CDGO_IDEXA " + 
		      "FROM PASG.TBASG100_PERSONA P, PASG.TBASG104_EXPEDIENT E, PASG.TBASG121_ACTAFORMA A, " + 
		         "PASG.TBASG146_ACTAINCAL B " + 
		      "WHERE P.CDGO_PERSONA = E.CDGO_PERSONA " + 
		        "AND E.CDGO_EXPEDIENT = A.CDGO_EXPEDIENT " +
		        "AND B.CDGO_ACTAFORM = A.CDGO_ACTAFORM " +
		        "AND P.CDGO_PERSONA = :cdgoPersona " +
		        "AND E.CDGO_EXPEDIENT = :cdgoExpediente " +
			"UNION ALL " +
			"SELECT A.CDGO_ACTAFORM AS CDGO_ACTAFORM, A.CDGO_TIT as CODIGO, RTRIM(A.CDGO_CURSO) AS CDGO_CURSO, " +
			    "RTRIM(A.DESG_DESCCURSO) AS DESG_DESCCURSO,  RTRIM(A.DESG_OBSERVA) AS DESG_OBSERVA, A.CDGO_CENTROFOR, " +
			    "B.DESG_TIPOCURSO, B.CDGO_CALIFI, RTRIM(B.CDGO_IDINSTRU) AS CDGO_IDINSTRU, B.FCHA_CURSO, 1 AS TITULO, RTRIM(B.CDGO_IDEXA) AS CDGO_IDEXA " +
			   "FROM PASG.TBASG100_PERSONA P, PASG.TBASG102_TITULOCON T, PASG.TBASG121_ACTAFORMA A, " +
			        "PASG.TBASG146_ACTAINCAL B " +
			   "WHERE P.CDGO_PERSONA = T.CDGO_PERSONA " +
			      "AND T.CDGO_TIT = A.CDGO_TIT " +
			      "AND B.CDGO_ACTAFORM = A.CDGO_ACTAFORM " +
			      "AND P.CDGO_PERSONA = :cdgoPersona " + 
			      "AND A.CDGO_EXPEDIENT = :cdgoExpediente " +
			"UNION ALL " +
			"SELECT A.CDGO_ACTAFORM AS CDGO_ACTAFORM, C.CDGO_ACREDITA as CODIGO, RTRIM(A.CDGO_CURSO) AS CDGO_CURSO, RTRIM(A.DESG_DESCCURSO) AS DESG_DESCCURSO, " +
		      	"RTRIM(A.DESG_OBSERVA) AS DESG_OBSERVA, A.CDGO_CENTROFOR, " +
				"B.DESG_TIPOCURSO, B.CDGO_CALIFI, RTRIM(B.CDGO_IDINSTRU) AS CDGO_IDINSTRU, B.FCHA_CURSO, 2 AS TITULO, RTRIM(B.CDGO_IDEXA) AS CDGO_IDEXA " +
		      "FROM PASG.TBASG100_PERSONA P, PASG.TBASG267_EXPED_ACRED C, PASG.TBASG121_ACTAFORMA A, " +
		         "PASG.TBASG146_ACTAINCAL B " +
		      "WHERE P.CDGO_PERSONA = C.CDGO_PERSONA " +
		        "AND C.CDGO_ACREDITA = A.CDGO_ACREDITA " +
		        "AND B.CDGO_ACTAFORM = A.CDGO_ACTAFORM " +
			    "AND P.CDGO_PERSONA = :cdgoPersona " +
			    "AND A.CDGO_EXPEDIENT = :cdgoExpediente " +
			"ORDER BY CDGO_ACTAFORM ASC, DESG_DESCCURSO ASC ";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("cdgoPersona", cdgoPersona);
		sqlquery.setParameter("cdgoExpediente", cdgoExpediente);
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetActasPersonaOrderByCdgoActaFormDTO> resultadosDevueltos = new ArrayList<>();

		for (Object[] object : resultados) {
			GetActasPersonaOrderByCdgoActaFormDTO formacion = new GetActasPersonaOrderByCdgoActaFormDTO();
				
			formacion.setCdgoActaForm((Integer)object[0]);
			formacion.setCdgoExpediente((Integer)object[1]);
			formacion.setCdgoCurso((String)object[2]);
			formacion.setDesgDesccurso((String)object[3]);
			formacion.setDesgObserva((String)object[4]);
			formacion.setCdgoCentroFor((Integer)object[5]);
			formacion.setDesgTipoCurso((String)object[6]);
			formacion.setCdgoCalifi((Integer)object[7]);
			formacion.setCdgoIdInstru((String)object[8]);
			formacion.setFchaCurso((Date)object[9]);
			formacion.setTitulo((Integer)object[10]);
			formacion.setCdgoIdexa((String)object[11]);

			resultadosDevueltos.add(formacion);
		}
		return resultadosDevueltos;
	}

	@Transactional
	public int insertActaForma(Tbasg121Actaforma bean) {
		int result = 0;

		String sqlString = 
			" INSERT INTO PASG.TBASG121_ACTAFORMA (CDGO_EXPEDIENT, CDGO_TIT, CDGO_CURSO, DESG_DESCCURSO, " +
			"    DESG_OBSERVA, CDGO_CENTROFOR, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO, CDGO_ACREDITA)        " +
			" VALUES (:cdgoExpedient, :cdgoTit, :cdgoCurso, :descCurso, :observa, :cdgoCentroFor, :usuAct, CURRENT_DATE, :activo, :cdgoAcredita) ";

		Query sqlquery = em.createNativeQuery(sqlString,Tbasg121Actaforma.class);

		sqlquery.setParameter("cdgoExpedient", bean.getCdgoExpedient());
		sqlquery.setParameter("cdgoTit", bean.getCdgoTit());
		sqlquery.setParameter("cdgoCurso", bean.getCdgoCurso());
		sqlquery.setParameter("descCurso", bean.getDesgDesccurso());
		sqlquery.setParameter("observa", bean.getDesgObserva());
		sqlquery.setParameter("cdgoCentroFor", bean.getCdgoCentrofor());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("activo", bean.getMrcaActivo());
		sqlquery.setParameter("cdgoAcredita", bean.getCdgoAcredita());

		result = sqlquery.executeUpdate();
		if (result > 0) {
			sqlString = " SELECT IDENTITY_VAL_LOCAL() AS identity_val FROM SYSIBM.SYSDUMMY1 ";
			sqlquery = em.createNativeQuery(sqlString);	
			
			List<BigDecimal> results = sqlquery.getResultList();
	  
			BigDecimal res = null;
			for (BigDecimal item : results) {
			  res = item;
			}
	  
			result = res.intValue();
		}

		return result;
	}

	public int updateActaForma(String cdgoCurso,String descCurso, String descObserva, Integer cdgoCentrofor, String descUsuact, String mrcaActivo, Integer cdgoActaform) {

		String sqlString = "UPDATE PASG.TBASG121_ACTAFORMA SET " + "			CDGO_CURSO = ?, "
				+ "			DESG_DESCCURSO = ?, " + "			DESG_OBSERVA = ?," + "			CDGO_CENTROFOR = ?, "
				+ "			DESG_USUACT = ?, " + "			FCHA_ACT = CURRENT_DATE, " + "			MRCA_ACTIVO = ?"
				+ "		WHERE CDGO_ACTAFORM = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg121Actaforma.class);
		sqlquery.setParameter(1, cdgoCurso);
		sqlquery.setParameter(2, descCurso);
		sqlquery.setParameter(3, descObserva);
		sqlquery.setParameter(4, cdgoCentrofor);
		sqlquery.setParameter(5, descUsuact);
		sqlquery.setParameter(6, mrcaActivo);
		sqlquery.setParameter(7, cdgoActaform);
		return sqlquery.executeUpdate();
	}

	public int updateActaFormaMantenimiento(Tbasg121Actaforma bean) {

		String sqlString = "UPDATE PASG.TBASG121_ACTAFORMA SET " + "			CDGO_EXPEDIENT = ?,"
				+ "			CDGO_TIT = ?," + "			CDGO_CURSO = ?, " + "			DESG_DESCCURSO = ?, "
				+ "			DESG_OBSERVA = ?," + "			CDGO_CENTROFOR = ?, " + "			DESG_USUACT = ?, "
				+ "			FCHA_ACT = CURRENT_DATE 			" + "		WHERE CDGO_ACTAFORM = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg121Actaforma.class);
		sqlquery.setParameter(1, bean.getCdgoExpedient());
		sqlquery.setParameter(2, bean.getCdgoTit());
		sqlquery.setParameter(3, bean.getCdgoCurso());
		sqlquery.setParameter(4, bean.getDesgDesccurso());
		sqlquery.setParameter(5, bean.getDesgObserva());
		sqlquery.setParameter(6, bean.getCdgoCentrofor());
		sqlquery.setParameter(7, bean.getDesgUsuact());
		sqlquery.setParameter(8, bean.getCdgoActaform());
		return sqlquery.executeUpdate();
	}

	public int inactiveByCdgoActaForma(String usuAct, Integer cdgoActaform) {

		String sqlString = "UPDATE PASG.TBASG121_ACTAFORMA SET" + "			DESG_USUACT = :usuAct, "
				+ "			FCHA_ACT = CURRENT_DATE, " + "			MRCA_ACTIVO = 'N'"
				+ "		WHERE CDGO_ACTAFORM = :cdgoActaForm";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg121Actaforma.class);
		sqlquery.setParameter("usuAct", usuAct);
		sqlquery.setParameter("cdgoActaForm", cdgoActaform);
		return sqlquery.executeUpdate();
	}

	public int deleteActaForma(Tbasg121Actaforma bean) {

		String sqlString = "DELETE FROM PASG.TBASG121_ACTAFORMA	WHERE CDGO_ACTAFORM = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg121Actaforma.class);
		sqlquery.setParameter("value", bean.getCdgoActaform());
		return sqlquery.executeUpdate();
	}

	public List<Tbasg121Actaforma> getCdgoActaFchaCursoList(String cdgoExpedient) {

		String sqlString = "SELECT A.CDGO_ACTAFORM, B.FCHA_CURSO"
				+ "		FROM PASG.TBASG121_ACTAFORMA A INNER JOIN PASG.TBASG146_ACTAINCAL B"
				+ "    		ON A.CDGO_ACTAFORM = B.CDGO_ACTAFORM" + "		WHERE A.CDGO_EXPEDIENT = :value"
				+ "		ORDER BY B.FCHA_CURSO DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg121Actaforma.class);
		sqlquery.setParameter("value", cdgoExpedient);
		return sqlquery.getResultList();
	}

}
