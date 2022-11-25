package renfe.com.repository.impl;

import java.sql.Date;
import java.text.DateFormat;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import renfe.com.dto.GetActasActivasPersonaDTO;
import renfe.com.dto.GetActasNoActivasPersonaDTO;
import renfe.com.dto.GetDatosPersonaAcreditaDTO;
import renfe.com.dto.GetErrListParam;
import renfe.com.dto.GetExpStatusFilterParametersDTO;

import renfe.com.dto.GetFechaProxRecicTitConDTO;
import renfe.com.dto.GetFechaProxRecicTitConNoMarcaDTO;
import renfe.com.dto.GetFindPersonaAltasBajasDTO;
import renfe.com.dto.GetMaxEstadoExpListDTO;

import renfe.com.dto.GetMaxEstadoHabilitaListDTO;
import renfe.com.dto.GetMaxEstadoProxRevListDTO;
import renfe.com.dto.GetPerByEstadoListResultDTO;

import renfe.com.dto.GetTituloConListAuxDTO;
import renfe.com.dto.SetExpedientesPersonaListDTO;
import renfe.com.dto.GetPersonaCertificadosIdiomasListDTO;
import renfe.com.dto.GetPersonaEmpresaInformeDTO;
import renfe.com.dto.GetPersonaEstadoListDTO;
import renfe.com.dto.SetMaxEstadoHabilitaList;
import renfe.com.dto.SetPersonaCertificadosIdiomasList;
import renfe.com.dto.SetPersonaEstadoList;
import renfe.com.dto.setMaxEstadoProxRevList;
import renfe.com.model.dto.ActasPersonaDto;
import renfe.com.model.dto.RequisitosMinimosDto;
import renfe.com.model.dto.Tbasg100PersonaDto;
import renfe.com.model.dto.Tbasg905OrganizationChartDto;
import renfe.com.model.entity.Tbasg100Persona;
import renfe.com.repository.Tbasg100PersonaRepositoryCustom;
import renfe.com.util.Util;

import org.springframework.transaction.annotation.Transactional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Tbasg100PersonaRepositoryImpl implements Tbasg100PersonaRepositoryCustom {

	private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@PersistenceContext
	private EntityManager em;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(Tbasg100PersonaRepositoryImpl.class);

	public List<Tbasg100Persona> getCertpsicCdgoPersona(Integer cdgoPersona) {

		String sqlString = "SELECT NEW renfe.com.model.entity.Tbasg100Persona (P.tbasg101Certpsic.cdgoCertpsic, P.tbasg101Certpsic.cdgoPersona, P.tbasg101Certpsic.fchaReconoc, P.tbasg101Certpsic.fchaProxrev, P.tbasg101Certpsic.mrcaActivo,"
				+ "			P.tbasg101Certpsic.tbasg110Psicomoti.cdgoMotivo, P.tbasg101Certpsic.tbasg110Psicomoti.desgNombre, P.tbasg101Certpsic.tbasg115Calificac.cdgoCalifi, P.tbasg101Certpsic.tbasg115Calificac.desgNombre, "
				+ "			P.tbasg101Certpsic.tbasg109Psicoambi.cdgoPsicamb, P.tbasg101Certpsic.tbasg109Psicoambi.desgNombre, P.tbasg101Certpsic.tbasg108Centmedic.cdgoCenmed, P.tbasg101Certpsic.tbasg108Centmedic.desgNombre, "
				+ "			P.tbasg101Certpsic.tbasg111Facultati.desgNombre, P.tbasg101Certpsic.tbasg111Facultati.desgApell1, P.tbasg101Certpsic.tbasg111Facultati.desgApell2 )"
				+ "		    FROM Tbasg100Persona P INNER JOIN P.tbasg101Certpsic C ON P.tbasg101Certpsic.cdgoCertpsic = C.cdgoCertpsic "
				+ "		        INNER JOIN P.tbasg101Certpsic.tbasg108Centmedic SA ON P.tbasg101Certpsic.tbasg108Centmedic.cdgoCenmed = SA.cdgoCenmed "
				+ "		        INNER JOIN P.tbasg101Certpsic.tbasg109Psicoambi A ON P.tbasg101Certpsic.tbasg109Psicoambi.cdgoPsicamb = A.cdgoPsicamb "
				+ "		        INNER JOIN P.tbasg101Certpsic.tbasg110Psicomoti M ON P.tbasg101Certpsic.tbasg110Psicomoti.cdgoMotivo = M.cdgoMotivo "
				+ "		        INNER JOIN P.tbasg101Certpsic.tbasg111Facultati F ON P.tbasg101Certpsic.tbasg111Facultati.cdgoFacult = F.cdgoFacult "
				+ "		        INNER JOIN P.tbasg101Certpsic.tbasg115Calificac CA ON P.tbasg101Certpsic.tbasg115Calificac.cdgoCalifi = CA.cdgoCalifi "
				+ "		    WHERE P.cdgoPersona = :cdgoPersona "
				+ "		        AND P.tbasg101Certpsic.mrcaActivo = 'S'";

		TypedQuery<Tbasg100Persona> sqlquery = em.createQuery(sqlString, Tbasg100Persona.class);
		sqlquery.setParameter("cdgoPersona", cdgoPersona);
		return sqlquery.getResultList();
	}

	public List<Tbasg100Persona> getAcreditacionesCaducadas() {

		String sqlString = "SELECT PERSON.DESG_NOMBRE AS NOMBRE," + "		       PERSON.DESG_APELL1 AS APELLID1, "
				+ "		       PERSON.DESG_APELL2 AS APELLID2, " + "		       PERSON.CDGO_TIPODOC AS TIPO_DOC,"
				+ "		       PERSON.DESG_NIFPAS AS NIF," + "		       EXP.CDGO_TIPOACREDITA AS COD_ACRE,"
				+ "		       TIPO.DESG_ACREDITA AS DESG_ACREDITA,"
				+ "		       EXP.CDGO_PERSONA AS COD_PERSONA, " + "		       EXP.CDGO_EMPRESA AS COD_EMPRES, "
				+ "		       EXP.FCHA_ACREDITA AS FEC_ACRED, " + "		       EXP.FCHA_CADUC AS FEC_CADUC, "
				+ "		       EXP.CDGO_LINEA AS COD_LINEA, " + "		       EXP.CDGO_PUERTO AS COD_PUERTO, "
				+ "		       EXP.CDGO_ESTACION AS COD_ESTACION," + "		       EMPRES.DESG_EMAIL AS MAIL "
				+ "		FROM PASG.TBASG100_PERSONA PERSON "
				+ "		INNER JOIN PASG.TBASG267_EXPED_ACRED EXP ON EXP.CDGO_PERSONA = PERSON.CDGO_PERSONA  "
				+ "		INNER JOIN PASG.TBASG125_EMPRESA EMPRES ON EMPRES.CDGO_EMPRESA = EXP.CDGO_EMPRESA"
				+ "		INNER JOIN PASG.TBASG262_TIPO_ACREDITA TIPO ON EXP.CDGO_TIPOACREDITA = TIPO.CDGO_TIPOACR"
				+ "		WHERE EXP.FCHA_CADUC  <=  CURRENT_DATE ORDER BY EXP.CDGO_EMPRESA";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg100Persona.class);

		return sqlquery.getResultList();
	}

	public List<ActasPersonaDto> getActasPersona(String cdgoPersona) {
		String sqlString = "SELECT A.CDGO_ACTAFORM, A.CDGO_EXPEDIENT as CODIGO, RTRIM(A.CDGO_CURSO) AS CDGO_CURSO, RTRIM(A.DESG_DESCCURSO) AS DESG_DESCCURSO, "
				+ "	      	RTRIM(A.DESG_OBSERVA) AS DESG_OBSERVA, A.CDGO_CENTROFOR, "
				+ "			B.DESG_TIPOCURSO, B.CDGO_CALIFI, RTRIM(B.CDGO_IDINSTRU) AS CDGO_IDINSTRU, B.FCHA_CURSO, 0 AS TITULO, RTRIM(B.CDGO_IDEXA) AS CDGO_IDEXA"
				+ "	      FROM PASG.TBASG100_PERSONA P, PASG.TBASG104_EXPEDIENT E, PASG.TBASG121_ACTAFORMA A, "
				+ "	         PASG.TBASG146_ACTAINCAL B" + "	      WHERE P.CDGO_PERSONA = E.CDGO_PERSONA"
				+ "	        AND E.CDGO_EXPEDIENT = A.CDGO_EXPEDIENT        "
				+ "	        AND B.CDGO_ACTAFORM = A.CDGO_ACTAFORM" + "	        AND P.CDGO_PERSONA = :value"
				+ "		UNION ALL"
				+ "		SELECT A.CDGO_ACTAFORM, A.CDGO_TIT as CODIGO, RTRIM(A.CDGO_CURSO) AS CDGO_CURSO, "
				+ "		    RTRIM(A.DESG_DESCCURSO) AS DESG_DESCCURSO,  RTRIM(A.DESG_OBSERVA) AS DESG_OBSERVA, A.CDGO_CENTROFOR, "
				+ "		    B.DESG_TIPOCURSO, B.CDGO_CALIFI, RTRIM(B.CDGO_IDINSTRU) AS CDGO_IDINSTRU, B.FCHA_CURSO, 1 AS TITULO, RTRIM(B.CDGO_IDEXA) AS CDGO_IDEXA"
				+ "		   FROM PASG.TBASG100_PERSONA P, PASG.TBASG102_TITULOCON T, PASG.TBASG121_ACTAFORMA A,"
				+ "		        PASG.TBASG146_ACTAINCAL B" + "		   WHERE P.CDGO_PERSONA = T.CDGO_PERSONA"
				+ "		      AND T.CDGO_TIT = A.CDGO_TIT" + "		      AND B.CDGO_ACTAFORM = A.CDGO_ACTAFORM"
				+ "		      AND P.CDGO_PERSONA = :value" + "		"
				+ "		ORDER BY CODIGO ASC, DESG_DESCCURSO ASC";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);

		List<Object[]> resultados = sqlquery.getResultList();
		List<ActasPersonaDto> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			ActasPersonaDto dto = new ActasPersonaDto();
			dto.setCdgoActaForm((Integer) object[0]);
			dto.setCodigo((Integer) object[1]);
			dto.setCdgoCurso(Util.quitarEspacios(object[2]));
			dto.setDesgDesccurso(Util.quitarEspacios(object[3]));
			dto.setDesgObserva(Util.quitarEspacios(object[4]));
			dto.setCdgoCentroFor((Integer) object[5]);
			dto.setDesgTipoCurso(Util.quitarEspacios(object[6]));
			dto.setCdgoCalifi((Integer) object[7]);
			dto.setCdgoIndinstr(Util.quitarEspacios(object[8]));
			dto.setFchaCurso((Date) object[9]);
			dto.setTitulo((Integer) object[10]);
			dto.setCdgoIdexa(Util.quitarEspacios(object[11]));
			dto.setCdgoExpedient(dto.getCodigo());

			resultadosDevueltos.add(dto);
		}
		return resultadosDevueltos;

	}

	public List<Tbasg100Persona> getActasPersonaOrderByCdgoActaForm(String cdgoPersona) {

		String sqlString = "SELECT A.CDGO_ACTAFORM AS CDGO_ACTAFORM, A.CDGO_EXPEDIENT as CODIGO, RTRIM(A.CDGO_CURSO) AS CDGO_CURSO, RTRIM(A.DESG_DESCCURSO) AS DESG_DESCCURSO, "
				+ "	      	RTRIM(A.DESG_OBSERVA) AS DESG_OBSERVA, A.CDGO_CENTROFOR, "
				+ "			B.DESG_TIPOCURSO, B.CDGO_CALIFI, RTRIM(B.CDGO_IDINSTRU) AS CDGO_IDINSTRU, B.FCHA_CURSO, 0 AS TITULO, RTRIM(B.CDGO_IDEXA) AS CDGO_IDEXA"
				+ "	      FROM PASG.TBASG100_PERSONA P, PASG.TBASG104_EXPEDIENT E, PASG.TBASG121_ACTAFORMA A, "
				+ "	         PASG.TBASG146_ACTAINCAL B" + "	      WHERE P.CDGO_PERSONA = E.CDGO_PERSONA"
				+ "	        AND E.CDGO_EXPEDIENT = A.CDGO_EXPEDIENT        "
				+ "	        AND B.CDGO_ACTAFORM = A.CDGO_ACTAFORM" + "	        AND P.CDGO_PERSONA = :value"
				+ "		UNION ALL"
				+ "		SELECT A.CDGO_ACTAFORM AS CDGO_ACTAFORM, A.CDGO_TIT as CODIGO, RTRIM(A.CDGO_CURSO) AS CDGO_CURSO, "
				+ "		    RTRIM(A.DESG_DESCCURSO) AS DESG_DESCCURSO,  RTRIM(A.DESG_OBSERVA) AS DESG_OBSERVA, A.CDGO_CENTROFOR, "
				+ "		    B.DESG_TIPOCURSO, B.CDGO_CALIFI, RTRIM(B.CDGO_IDINSTRU) AS CDGO_IDINSTRU, B.FCHA_CURSO, 1 AS TITULO, RTRIM(B.CDGO_IDEXA) AS CDGO_IDEXA"
				+ "		   FROM PASG.TBASG100_PERSONA P, PASG.TBASG102_TITULOCON T, PASG.TBASG121_ACTAFORMA A,"
				+ "		        PASG.TBASG146_ACTAINCAL B" + "		   WHERE P.CDGO_PERSONA = T.CDGO_PERSONA"
				+ "		      AND T.CDGO_TIT = A.CDGO_TIT" + "		      AND B.CDGO_ACTAFORM = A.CDGO_ACTAFORM"
				+ "		      AND P.CDGO_PERSONA = :value" + "		UNION ALL"
				+ "		SELECT A.CDGO_ACTAFORM AS CDGO_ACTAFORM, C.CDGO_ACREDITA as CODIGO, RTRIM(A.CDGO_CURSO) AS CDGO_CURSO, RTRIM(A.DESG_DESCCURSO) AS DESG_DESCCURSO, "
				+ "	      	RTRIM(A.DESG_OBSERVA) AS DESG_OBSERVA, A.CDGO_CENTROFOR, "
				+ "			B.DESG_TIPOCURSO, B.CDGO_CALIFI, RTRIM(B.CDGO_IDINSTRU) AS CDGO_IDINSTRU, B.FCHA_CURSO, 2 AS TITULO, RTRIM(B.CDGO_IDEXA) AS CDGO_IDEXA"
				+ "	      FROM PASG.TBASG100_PERSONA P, PASG.TBASG267_EXPED_ACRED C, PASG.TBASG121_ACTAFORMA A, "
				+ "	         PASG.TBASG146_ACTAINCAL B" + "	      WHERE P.CDGO_PERSONA = C.CDGO_PERSONA"
				+ "	        AND C.CDGO_ACREDITA = A.CDGO_ACREDITA" + "	        AND B.CDGO_ACTAFORM = A.CDGO_ACTAFORM"
				+ "		    AND P.CDGO_PERSONA = :value" + "		ORDER BY CDGO_ACTAFORM ASC, DESG_DESCCURSO ASC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg100Persona.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}

	public List<GetTituloConListAuxDTO> getTituloConListAux(Integer cdgoPersona) {

		String sqlString = " SELECT T.CDGO_TIT, T.CDGO_PERSONA, T.FCHA_OTORGADO, T.DESG_TIPTIT, E.DESG_NOMBRE AS ESTADO, ET.CDGO_ESTADO, ET.FCHA_ESTADO,   "
				+ " P.DESG_NIFPAS, P.DESG_MATRICULA, P.DESG_NOMBRE AS DESG_PERSONA, P.DESG_APELL1, P.DESG_APELL2, "
				+ " CASE WHEN MAX(AC.FCHA_CURSO) > '2015-04-20' THEN MAX(AC.FCHA_CURSO) + 2 YEARS ELSE "
				+ " MAX(AC.FCHA_CURSO) + 3 YEARS END AS FCHA_CURSOINC FROM PASG.TBASG100_PERSONA P "
				+ " INNER JOIN PASG.TBASG102_TITULOCON T ON T.CDGO_PERSONA = P.CDGO_PERSONA "
				+ " INNER JOIN PASG.TBASG117_ESTADOTIT ET ON ET.CDGO_TIT = T.CDGO_TIT "
				+ " INNER JOIN PASG.TBASG116_ESTADOS E ON E.CDGO_ESTADO = ET.CDGO_ESTADO "
				+ " LEFT JOIN PASG.TBASG121_ACTAFORMA AF ON AF.CDGO_TIT = T.CDGO_TIT "
				+ " LEFT JOIN PASG.TBASG146_ACTAINCAL AC ON AC.CDGO_ACTAFORM = AF.CDGO_ACTAFORM "
				+ " LEFT JOIN PASG.TBASG104_EXPEDIENT EX ON P.CDGO_PERSONA=EX.CDGO_PERSONA "
				+ " WHERE ET.FCHA_ESTADO = (SELECT MAX(FCHA_ESTADO) FROM PASG.TBASG117_ESTADOTIT "
				+ "    WHERE CDGO_TIT = ET.CDGO_TIT AND MRCA_ACTIVO ='S') AND P.MRCA_ACTIVO = 'S'  AND T.MRCA_ACTIVO = 'S'   "
				+ " AND ET.MRCA_ACTIVO = 'S' AND P.CDGO_PERSONA = :value "
				+ " GROUP BY T.CDGO_TIT, T.CDGO_PERSONA, T.FCHA_OTORGADO, T.DESG_TIPTIT, E.DESG_NOMBRE, ET.CDGO_ESTADO, ET.FCHA_ESTADO,  "
				+ " P.DESG_NIFPAS, P.DESG_MATRICULA, P.DESG_NOMBRE, P.DESG_APELL1, P.DESG_APELL2 ";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetTituloConListAuxDTO> resultadosDevueltos = new ArrayList<>();

		for (Object[] object : resultados) {
			GetTituloConListAuxDTO conlistaux = new GetTituloConListAuxDTO();

			conlistaux.setCdgoTit((Integer) object[0]);
			conlistaux.setCdgoPersona((Integer) object[1]);
			conlistaux.setFchaOtorgado((Date) object[2]);
			conlistaux.setDesgTiptit(Util.quitarEspacios(object[3]));
			conlistaux.setEstado(Util.quitarEspacios(object[4]));
			conlistaux.setCdgoEstado((Integer) object[5]);
			conlistaux.setFchaEstado((Date) object[6]);
			conlistaux.setDesgNifPas(Util.quitarEspacios(object[7]));
			conlistaux.setDesgMatricula(Util.quitarEspacios(object[8]));
			conlistaux.setDesgPersona(Util.quitarEspacios(object[9]));
			conlistaux.setDesgApell1(Util.quitarEspacios(object[10]));
			conlistaux.setDesgApell2(Util.quitarEspacios(object[11]));
			conlistaux.setFchaCursoInc((Date) object[12]);

			resultadosDevueltos.add(conlistaux);
		}
		return resultadosDevueltos;
	}

	public List<GetActasActivasPersonaDTO> getActasActivasPersona(String cdgoPersona) {
		String sqlString = "SELECT "
				+ "		    'EXPE' AS TIPO, A.CDGO_ACTAFORM, A.CDGO_EXPEDIENT as CODIGO, RTRIM(A.CDGO_CURSO) AS CDGO_CURSO, RTRIM(A.DESG_DESCCURSO) AS DESG_DESCCURSO, "
				+ "		    RTRIM(A.DESG_OBSERVA) AS DESG_OBSERVA, A.CDGO_CENTROFOR, "
				+ "		    B.DESG_TIPOCURSO, B.CDGO_CALIFI, RTRIM(B.CDGO_IDINSTRU) AS CDGO_IDINSTRU, B.FCHA_CURSO, 0 AS TITULO, RTRIM(B.CDGO_IDEXA) AS CDGO_IDEXAA, RTRIM(B.CDGO_IDEXA) AS CDGO_IDEXA"

				+ "         ,A.CDGO_TIT "

				+ "		FROM " + "		    PASG.TBASG100_PERSONA P"
				+ "		    INNER JOIN PASG.TBASG104_EXPEDIENT E ON E.CDGO_PERSONA = P.CDGO_PERSONA"
				+ "		    INNER JOIN PASG.TBASG121_ACTAFORMA A ON A.CDGO_EXPEDIENT = E.CDGO_EXPEDIENT"
				+ "		    INNER JOIN PASG.TBASG146_ACTAINCAL B ON B.CDGO_ACTAFORM = A.CDGO_ACTAFORM" + ""
				+ "		WHERE " + "		    P.CDGO_PERSONA = :value" + "		    AND A.MRCA_ACTIVO = 'S'"
				+ "		    AND B.MRCA_ACTIVO = 'S'" + "			UNION ALL" + "	SELECT "
				+ "		   'LIC' AS TIPO, A.CDGO_ACTAFORM, A.CDGO_TIT as CODIGO, RTRIM(A.CDGO_CURSO) AS CDGO_CURSO, "
				+ "		    RTRIM(A.DESG_DESCCURSO) AS DESG_DESCCURSO,  RTRIM(A.DESG_OBSERVA) AS DESG_OBSERVA, A.CDGO_CENTROFOR, "
				+ "		    B.DESG_TIPOCURSO, B.CDGO_CALIFI, RTRIM(B.CDGO_IDINSTRU) AS CDGO_IDINSTRU, B.FCHA_CURSO, 1 AS TITULO, RTRIM(B.CDGO_IDEXA) AS CDGO_IDEXA, RTRIM(B.CDGO_IDEXA) AS CDGO_IDEXA"

				+ "         ,A.CDGO_TIT "

				+ "		FROM " + "		    PASG.TBASG100_PERSONA P"
				+ "		    INNER JOIN PASG.TBASG102_TITULOCON T ON T.CDGO_PERSONA = P.CDGO_PERSONA"
				+ "		    INNER JOIN PASG.TBASG121_ACTAFORMA A ON A.CDGO_TIT = T.CDGO_TIT"
				+ "		    INNER JOIN PASG.TBASG146_ACTAINCAL B ON B.CDGO_ACTAFORM = A.CDGO_ACTAFORM" + "			"
				+ "		WHERE " + "		    P.CDGO_PERSONA = :value" + "		    AND A.MRCA_ACTIVO = 'S'"
				+ "		    AND B.MRCA_ACTIVO = 'S'" + "		    UNION ALL" + "	SELECT "
				+ "		    'ACRE' AS TIPO, A.CDGO_ACTAFORM, D.CDGO_ACREDITA as CODIGO, RTRIM(A.CDGO_CURSO) AS CDGO_CURSO, RTRIM(A.DESG_DESCCURSO) AS DESG_DESCCURSO, "
				+ "		    RTRIM(A.DESG_OBSERVA) AS DESG_OBSERVA, A.CDGO_CENTROFOR, "
				+ "		    B.DESG_TIPOCURSO, B.CDGO_CALIFI, RTRIM(B.CDGO_IDINSTRU) AS CDGO_IDINSTRU, B.FCHA_CURSO, 0 AS TITULO, RTRIM(B.CDGO_IDEXA) AS CDGO_IDEXA, RTRIM(B.CDGO_IDEXA) AS CDGO_IDEXA"

				+ "         ,A.CDGO_TIT "

				+ "		FROM " + "		    PASG.TBASG100_PERSONA P"
				+ "		    INNER JOIN PASG.TBASG267_EXPED_ACRED D ON D.CDGO_PERSONA = P.CDGO_PERSONA"
				+ "		    INNER JOIN PASG.TBASG121_ACTAFORMA A ON A.CDGO_ACREDITA = D.CDGO_ACREDITA"
				+ "		    INNER JOIN PASG.TBASG146_ACTAINCAL B ON B.CDGO_ACTAFORM = A.CDGO_ACTAFORM" + "	"
				+ "		WHERE " + "		    P.CDGO_PERSONA = :value" + "		    AND A.MRCA_ACTIVO = 'S'"
				+ "		    AND B.MRCA_ACTIVO = 'S'	    " + "		    " + "			"
				+ "		ORDER BY CODIGO ASC, DESG_DESCCURSO ASC;";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetActasActivasPersonaDTO> resultadosDevueltos = new ArrayList<>();

		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

		for (Object[] object : resultados) {
			GetActasActivasPersonaDTO persona = new GetActasActivasPersonaDTO();

			persona.setCdgoActaForm((Integer) object[1]);

			if ("EXPE".equals((String) object[0])) {
				persona.setCdgoExpedient((Integer) object[2]);
			} else if ("ACRE".equals(((String) object[0]).trim())) {
				persona.setCdgoAcredita((Integer) object[2]);
			} else if ("LIC".equals(((String) object[0]).trim())) {
				persona.setCdgoExpedient((Integer) object[2]);
			}

			persona.setCdgoCurso(Util.quitarEspacios(object[3]));
			persona.setDesgDesccurso(Util.quitarEspacios(object[4]));
			persona.setDesgObserva(Util.quitarEspacios(object[5]));
			persona.setCdgoCentroFor((Integer) object[6]);
			persona.setDesgTipocurso(Util.quitarEspacios(object[7]));
			persona.setCdgoCalifi((Integer) object[8]);
			persona.setCdgo_idInstru(Util.quitarEspacios(object[9]));
			persona.setCdgo_idExa(Util.quitarEspacios(object[12]));
			persona.setCdgoTit((Integer) object[14]);

			if (Objects.nonNull(object[10])) { 
				persona.setFchaCurso((String) dateFormat.format(object[10]));
			}			

			resultadosDevueltos.add(persona);
		}
		return resultadosDevueltos;
	}

	public List<GetActasNoActivasPersonaDTO> getActasNoActivasPersona(String cdgoPersona) {

		String sqlString = "SELECT "
				+ "		    'EXPE' AS TIPO,  A.CDGO_ACTAFORM, A.CDGO_EXPEDIENT as CODIGO, RTRIM(A.CDGO_CURSO) AS CDGO_CURSO, RTRIM(A.DESG_DESCCURSO) AS DESG_DESCCURSO, "
				+ "		    RTRIM(A.DESG_OBSERVA) AS DESG_OBSERVA, A.CDGO_CENTROFOR, "
				+ "		    B.DESG_TIPOCURSO, B.CDGO_CALIFI, RTRIM(B.CDGO_IDINSTRU) AS CDGO_IDINSTRU, B.FCHA_CURSO, 0 AS TITULO, RTRIM(B.CDGO_IDEXA) AS CDGO_IDEXA"
				+ "		FROM " + "		    PASG.TBASG100_PERSONA P"
				+ "		    INNER JOIN PASG.TBASG104_EXPEDIENT E ON E.CDGO_PERSONA = P.CDGO_PERSONA"
				+ "		    INNER JOIN PASG.TBASG121_ACTAFORMA A ON A.CDGO_EXPEDIENT = E.CDGO_EXPEDIENT"
				+ "		    INNER JOIN PASG.TBASG146_ACTAINCAL B ON B.CDGO_ACTAFORM = A.CDGO_ACTAFORM" + "		WHERE "
				+ "		    P.CDGO_PERSONA = :value" + "		    AND A.MRCA_ACTIVO = 'N'"
				+ "		    AND B.MRCA_ACTIVO = 'N'" + "		    " + "		UNION ALL" + "		" + "		SELECT "
				+ "		     'LIC' AS TIPO, A.CDGO_ACTAFORM, A.CDGO_TIT as CODIGO, RTRIM(A.CDGO_CURSO) AS CDGO_CURSO, "
				+ "		    RTRIM(A.DESG_DESCCURSO) AS DESG_DESCCURSO,  RTRIM(A.DESG_OBSERVA) AS DESG_OBSERVA, A.CDGO_CENTROFOR, "
				+ "		    B.DESG_TIPOCURSO, B.CDGO_CALIFI, RTRIM(B.CDGO_IDINSTRU) AS CDGO_IDINSTRU, B.FCHA_CURSO, 1 AS TITULO, RTRIM(B.CDGO_IDEXA) AS CDGO_IDEXA"
				+ "		FROM " + "		    PASG.TBASG100_PERSONA P"
				+ "		    INNER JOIN PASG.TBASG102_TITULOCON T ON T.CDGO_PERSONA = P.CDGO_PERSONA"
				+ "		    INNER JOIN PASG.TBASG121_ACTAFORMA A ON A.CDGO_TIT = T.CDGO_TIT"
				+ "		    INNER JOIN PASG.TBASG146_ACTAINCAL B ON B.CDGO_ACTAFORM = A.CDGO_ACTAFORM" + "		WHERE "
				+ "		    P.CDGO_PERSONA = :value" + "		    AND A.MRCA_ACTIVO = 'N'"
				+ "		    AND B.MRCA_ACTIVO = 'N'" + "		    " + "		UNION ALL" + "		" + "		SELECT "
				+ "		    'ACRE' AS TIPO, A.CDGO_ACTAFORM, D.CDGO_ACREDITA as CODIGO, RTRIM(A.CDGO_CURSO) AS CDGO_CURSO, RTRIM(A.DESG_DESCCURSO) AS DESG_DESCCURSO, "
				+ "		    RTRIM(A.DESG_OBSERVA) AS DESG_OBSERVA, A.CDGO_CENTROFOR, "
				+ "		    B.DESG_TIPOCURSO, B.CDGO_CALIFI, RTRIM(B.CDGO_IDINSTRU) AS CDGO_IDINSTRU, B.FCHA_CURSO, 0 AS TITULO, RTRIM(B.CDGO_IDEXA) AS CDGO_IDEXA"
				+ "		FROM " + "		    PASG.TBASG100_PERSONA P"
				+ "		    INNER JOIN PASG.TBASG267_EXPED_ACRED D ON D.CDGO_PERSONA = P.CDGO_PERSONA"
				+ "		    INNER JOIN PASG.TBASG121_ACTAFORMA A ON A.CDGO_ACREDITA = D.CDGO_ACREDITA"
				+ "		    INNER JOIN PASG.TBASG146_ACTAINCAL B ON B.CDGO_ACTAFORM = A.CDGO_ACTAFORM" + "		WHERE "
				+ "		    P.CDGO_PERSONA = :value" + "		    AND A.MRCA_ACTIVO = 'N'"
				+ "		    AND B.MRCA_ACTIVO = 'N'		    " + "		"
				+ "		ORDER BY CODIGO ASC, DESG_DESCCURSO ASC;";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetActasNoActivasPersonaDTO> resultadosDevueltos = new ArrayList<>();

		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

		for (Object[] object : resultados) {
			GetActasNoActivasPersonaDTO persona = new GetActasNoActivasPersonaDTO();
			
			if ("EXPE".equals((String) object[0])) {
				persona.setCdgoExpedient((Integer) object[2]);
				persona.setDesgTipocurso(Util.quitarEspacios(object[7]));
			} else if ("ACRE".equals(((String) object[0]).trim())) {
				persona.setCdgoAcredita((Integer) object[2]);
				persona.setDesgTipocurso(Util.quitarEspacios(object[7]));
			} else if ("LIC".equals(((String) object[0]).trim())) {
				persona.setDesgTipocurso("LIC");
			}

			persona.setCdgoActaForm((Integer) object[1]);
			//persona.setCdgoExpedient((Integer) object[2]);
			persona.setCdgoCurso(Util.quitarEspacios(object[3]));
			persona.setDesgDesccurso(Util.quitarEspacios(object[4]));
			persona.setCdgoCentroFor((Integer) object[6]);
			//persona.setDesgTipocurso(Util.quitarEspacios(object[7]));
			persona.setCdgoCalifi((Integer) object[8]);
			persona.setCdgo_idInstru(Util.quitarEspacios(object[9]));
			persona.setCdgo_idExa(Util.quitarEspacios(object[12]));
			persona.setFchaCurso((String) dateFormat.format(object[10]));

			resultadosDevueltos.add(persona);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg100Persona> getExaminForName(String desgApell1) {

		String sqlString = "SELECT DESG_NIFPAS FROM PASG.TBASG100_PERSONA WHERE DESG_APELL1 || DESG_APELL2 || DESG_NOMBRE LIKE :value AND MRCA_EXAMINADOR = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg100Persona.class);
		sqlquery.setParameter("value", desgApell1);
		return sqlquery.getResultList();
	}

	public List<GetMaxEstadoExpListDTO> getMaxEstadoExpList(GetExpStatusFilterParametersDTO filter) {

		String sqlString = "SELECT DISTINCT EX.CDGO_EXPEDIENT,	EE.CDGO_ESTADO, EE.FCHA_ESTADO, "
				+ "		P.CDGO_PERSONA, S.DESG_NOMBRE AS ESTADO, TH.DESG_NOMBRE AS TIPO_HABILITA, "
				+ " 	P.DESG_NOMBRE AS DESG_PERSONA, P.DESG_APELL1, P.DESG_APELL2, P.DESG_MATRICULA, P.DESG_NIFPAS, "
				+ " 	EX.CDGO_TIPOHAB, EX.CDGO_ALCANCEOT,	EX.CDGO_ESPEC, EX.CDGO_ALCANCEAMBITO, EX.DESG_TIPOINFRAESTRUC, "
				+ " 	EX.CDGO_ENTORNO, EX.CDGO_LINEA,EX.MRCA_REVISION, EX.CDGO_SERIE, EX.CDGO_SUBSERIE, EX.DESG_OBSERVA, SOC.DESC_SOCIEDAD "
				+ " 	FROM PASG.TBASG100_PERSONA P "
				+ " 	INNER JOIN PASG.TBASG104_EXPEDIENT EX ON P.CDGO_PERSONA = EX.CDGO_PERSONA "
				+ " 	INNER JOIN PASG.TBASG118_ESTADOEXP EE ON EX.CDGO_EXPEDIENT = EE.CDGO_EXPEDIENT "
				+ " 	INNER JOIN PASG.TBASG116_ESTADOS S ON EE.CDGO_ESTADO = S.CDGO_ESTADO "
				+ " 	INNER JOIN PASG.TBASG123_TIPOHABIL TH ON EX.CDGO_TIPOHAB = TH.CDGO_TIPOHAB "
				+ " 	INNER JOIN PASG.TBASG261_SOCIEDADES SOC ON SOC.CDGO_SOCIEDAD = EX.CDGO_SOCIOTOR "
				+ "	WHERE  P.MRCA_ACTIVO = 'S' "
				+ " 	AND EX.MRCA_ACTIVO = 'S' " + " 	AND EE.MRCA_ACTIVO = 'S' " + " 	AND S.MRCA_ACTIVO = 'S' "
				+ " 	AND EE.FCHA_ESTADO = (SELECT MAX(FCHA_ESTADO) FROM PASG.TBASG118_ESTADOEXP WHERE CDGO_EXPEDIENT = EE.CDGO_EXPEDIENT AND MRCA_ACTIVO = 'S')"
				+ "		AND EE.CDGO_ESTADO NOT IN (2,6,19) ";

		if (Objects.nonNull(filter.getStatusId()))
			sqlString += " AND EE.CDGO_ESTADO = :statusId ";

		if (Objects.nonNull(filter.getDocumentId()))
			sqlString += " AND P.DESG_NIFPAS LIKE :documentId ";

		if (Objects.nonNull(filter.getTuitionDesc()))
			sqlString += " AND P.DESG_MATRICULA LIKE :tuitionDesc ";

		if (Objects.nonNull(filter.getFirstName()))
			sqlString += " AND P.DESG_NOMBRE LIKE :firstName ";

		if (Objects.nonNull(filter.getLastName()))
			sqlString += " AND P.DESG_APELL1 LIKE :lastName ";

		if (Objects.nonNull(filter.getSecondName()))
			sqlString += " AND P.DESG_APELL2 LIKE :secondName ";

		if (Objects.nonNull(filter.getActivityAreaId())) {
			sqlString += " AND P.CDGO_AREACT = :activityAreaId ";
		}

		if (Objects.nonNull(filter.getTerritorialAreaId()))
			sqlString += " AND P.CDGO_ARETER = :territorialAreaId ";

		if (Objects.nonNull(filter.getAccountingCenterId()))
			sqlString += " AND P.CDGO_CENTCONT = :accountingCenterId ";

		if (Objects.nonNull(filter.getAuthTypeId()))
			sqlString += " AND EX.CDGO_TIPOHAB = :authTypeId ";

		if (Objects.nonNull(filter.getExpedientId()))
			sqlString += " AND EX.CDGO_EXPEDIENT = :expedientId ";

		if (Objects.nonNull(filter.getCdgoEstadoRevocado()))
			sqlString += " AND EE.CDGO_ESTADO != :cdgoEstadoRevocado";

		if (Objects.nonNull(filter.getCdgoEstadoCerrado()))
			sqlString += " AND EE.CDGO_ESTADO != :cdgoEstadoCerrado";

		if (Objects.nonNull(filter.getCdgoEstadoTramitacion()))
			sqlString += " AND EE.CDGO_ESTADO != :cdgoEstadoTramitacion";

		if (Objects.nonNull(filter.getCdgoEstadoVigente()))
			sqlString += " AND EE.CDGO_ESTADO != :cdgoEstadoVigente";

		if (Objects.nonNull(filter.getSocietyId())) {
			sqlString += " AND SOC.CDGO_SOCIEDAD = :societyId ";
		} else {
			sqlString += " AND SOC.CDGO_SOCIEDAD IN ('1000','1500')";
		}

		Query sqlquery = em.createNativeQuery(sqlString);

		if (Objects.nonNull(filter.getStatusId()))
			sqlquery.setParameter("statusId", filter.getStatusId());

		if (Objects.nonNull(filter.getDocumentId()))
			sqlquery.setParameter("documentId", "%" + filter.getDocumentId() + "%");

		if (Objects.nonNull(filter.getTuitionDesc()))
			sqlquery.setParameter("tuitionDesc", "%" + filter.getTuitionDesc() + "%");

		if (Objects.nonNull(filter.getFirstName()))
			sqlquery.setParameter("firstName", "%" + filter.getFirstName() + "%");

		if (Objects.nonNull(filter.getLastName()))
			sqlquery.setParameter("lastName", "%" + filter.getLastName() + "%");

		if (Objects.nonNull(filter.getSecondName()))
			sqlquery.setParameter("secondName", "%" + filter.getSecondName() + "%");

		if (Objects.nonNull(filter.getSocietyId()))
			sqlquery.setParameter("societyId", filter.getSocietyId());

		if (Objects.nonNull(filter.getActivityAreaId()))
			sqlquery.setParameter("activityAreaId", filter.getActivityAreaId());

		if (Objects.nonNull(filter.getTerritorialAreaId()))
			sqlquery.setParameter("territorialAreaId", filter.getTerritorialAreaId());

		if (Objects.nonNull(filter.getAccountingCenterId()))
			sqlquery.setParameter("accountingCenterId", filter.getAccountingCenterId());

		if (Objects.nonNull(filter.getAuthTypeId()))
			sqlquery.setParameter("authTypeId", filter.getAuthTypeId());

		if (Objects.nonNull(filter.getExpedientId()))
			sqlquery.setParameter("expedientId", filter.getExpedientId());

		if (Objects.nonNull(filter.getCdgoEstadoRevocado()))
			sqlquery.setParameter("cdgoEstadoRevocado", filter.getCdgoEstadoRevocado());

		if (Objects.nonNull(filter.getCdgoEstadoCerrado()))
			sqlquery.setParameter("cdgoEstadoCerrado", filter.getCdgoEstadoCerrado());

		if (Objects.nonNull(filter.getCdgoEstadoTramitacion()))
			sqlquery.setParameter("cdgoEstadoTramitacion", filter.getCdgoEstadoTramitacion());

		if (Objects.nonNull(filter.getCdgoEstadoVigente()))
			sqlquery.setParameter("cdgoEstadoVigente", filter.getCdgoEstadoVigente());

		System.out.println("CONSULTA LANZADA: " + sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetMaxEstadoExpListDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetMaxEstadoExpListDTO expedientStatus = new GetMaxEstadoExpListDTO();
			expedientStatus.setCdgoExpedient((Integer) object[0]);
			expedientStatus.setCdgoEstado((Integer) object[1]);
			expedientStatus.setFchaEstado((Timestamp) object[2]);
			expedientStatus.setCdgoPersona((Integer) object[3]);
			expedientStatus.setEstado(Util.quitarEspacios(this.convertToString(object[4])));
			expedientStatus.setTipoHabilita(Util.quitarEspacios(this.convertToString(object[5])));
			expedientStatus.setDesgPersona(Util.quitarEspacios(this.convertToString(object[6])));
			expedientStatus.setDesgApell1(Util.quitarEspacios(this.convertToString(object[7])));
			expedientStatus.setDesgApell2(Util.quitarEspacios(this.convertToString(object[8])));
			expedientStatus.setDesgMatricula(Util.quitarEspacios(this.convertToString(object[9])));
			expedientStatus.setDesgNifPass(Util.quitarEspacios(this.convertToString(object[10])));
			expedientStatus.setCdgoTipoHab((Integer) object[11]);
			expedientStatus.setCdgoAlcanceOt((Integer) object[12]);
			expedientStatus.setCdgoEspec((Integer) object[13]);
			expedientStatus.setCdgoAlcanceAmbito((Integer) object[14]);
			expedientStatus.setDesgTipoInfraEstruc(Util.quitarEspacios(this.convertToString(object[15])));
			expedientStatus.setCdgoEntorno((Integer) object[16]);
			expedientStatus.setCdgoLinea(Util.quitarEspacios(this.convertToString(object[17])));
			expedientStatus.setMrcaRevision(Util.quitarEspacios(this.convertToString(object[18])));
			expedientStatus.setCdgoSerie(Util.quitarEspacios(this.convertToString(object[19])));
			expedientStatus.setCdgoSubSerie(Util.quitarEspacios(this.convertToString(object[20])));
			expedientStatus.setDesgObserva(Util.quitarEspacios(this.convertToString(object[21])));
			expedientStatus.setDescSociedad(Util.quitarEspacios(this.convertToString(object[22])));
			

			resultadosDevueltos.add(expedientStatus);
		}

		return resultadosDevueltos;
	}

	public List<Tbasg100Persona> getReportList() {

		String sqlString = "SELECT DISTINCT"
				+ "		    P.CDGO_PERSONA, P.DESG_NOMBRE AS DESG_PERSONA, P.DESG_APELL1, P.DESG_APELL2, P.DESG_NIFPAS, "
				+ "		    X.CDGO_EXPEDIENT, I.DESG_NOMBRE AS TIPO_HABILITA, M.DESG_NOMBRE AS EMPRESA,"
				+ "		    X.CDGO_ALCANCEOT, X.CDGO_ESPEC, X.CDGO_ALCANCEAMBITO, X.CDGO_ENTORNO, X.CDGO_LINEA,"
				+ "		    X.CDGO_SERIE, X.CDGO_SUBSERIE, H.FCHA_PROXREV, G.FCHA_CURSO + 3 YEARS AS FCHA_CURSOINC,"
				+ "		    CAL.DESG_NOMBRE AS CALIFICACION, X.CDGO_TIPOHAB	    		" + "		FROM "
				+ "			PASG.TBASG100_PERSONA P    "
				+ "		    INNER JOIN PASG.TBASG104_EXPEDIENT X ON X.CDGO_PERSONA = P.CDGO_PERSONA"
				+ "		    INNER JOIN PASG.TBASG118_ESTADOEXP D ON D.CDGO_EXPEDIENT = X.CDGO_EXPEDIENT"
				+ "		    INNER JOIN PASG.TBASG116_ESTADOS E ON E.CDGO_ESTADO = D.CDGO_ESTADO    "
				+ "		    INNER JOIN PASG.TBASG123_TIPOHABIL I ON X.CDGO_TIPOHAB = I.CDGO_TIPOHAB"
				+ "		    INNER JOIN PASG.TBASG125_EMPRESA M ON M.CDGO_EMPRESA = X.CDGO_EMPRESA    		"
				+ "		    LEFT JOIN PASG.TBASG101_CERTPSIC H ON P.CDGO_PERSONA = H.CDGO_PERSONA"
				+ "		    LEFT JOIN PASG.TBASG115_CALIFICAC CAL ON H.CDGO_CALIFI = CAL.CDGO_CALIFI    "
				+ "		    LEFT JOIN PASG.TBASG121_ACTAFORMA AC ON AC.CDGO_EXPEDIENT = X.CDGO_EXPEDIENT"
				+ "		    LEFT JOIN PASG.TBASG146_ACTAINCAL G ON AC.CDGO_ACTAFORM = G.CDGO_ACTAFORM		"
				+ "			" + "		WHERE 		" + "			X.MRCA_ACTIVO = 'S'"
				+ "			AND D.MRCA_ACTIVO = 'S'" + "			AND E.MRCA_ACTIVO = 'S'					"
				+ "			AND D.FCHA_ESTADO IN (SELECT MAX(FCHA_ESTADO) "
				+ "						FROM PASG.TBASG118_ESTADOEXP"
				+ "						WHERE CDGO_EXPEDIENT = D.CDGO_EXPEDIENT AND MRCA_ACTIVO = 'S')"
				+ "			AND (H.FCHA_PROXREV IS NULL "
				+ "					 OR H.FCHA_PROXREV IN (SELECT MAX(FCHA_PROXREV)"
				+ "											FROM PASG.TBASG101_CERTPSIC "
				+ "											" + "											"
				+ "											WHERE CDGO_PERSONA = H.CDGO_PERSONA))";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg100Persona.class);

		return sqlquery.getResultList();
	}

	public List<GetPerByEstadoListResultDTO> getPerByEstadoList() {

		String sqlString = "SELECT DISTINCT     "
				+ "			P.CDGO_PERSONA, P.DESG_NIFPAS, P.DESG_MATRICULA, P.DESG_NOMBRE, P.DESG_APELL1, P.DESG_APELL2,     "
				+ "			P.CDGO_AREACT, P.CDGO_ARETER, P.CDGO_CENTCONT, ARE_A.DESG_NOMBRE AS AREACTNAME, "
				+ "			ARE_T.DESG_NOMBRE AS ARETERNAME, CC.DESG_NOMBRE AS CENTCONTNAME " + "		FROM "
				+ "			PASG.TBASG100_PERSONA P     "
				+ "			INNER JOIN PASG.TBASG104_EXPEDIENT E ON P.CDGO_PERSONA = E.CDGO_PERSONA    "
				+ "			INNER JOIN PASG.TBASG118_ESTADOEXP EE ON E.CDGO_EXPEDIENT = EE.CDGO_EXPEDIENT    "
				+ "			INNER JOIN PASG.TBASG116_ESTADOS S ON EE.CDGO_ESTADO = S.CDGO_ESTADO    "
				+ "			LEFT JOIN PASG.TBASG105_AREACTIVI ARE_A ON P.CDGO_AREACT = ARE_A.CDGO_AREACT    "
				+ "			LEFT JOIN PASG.TBASG132_CENTCONT CC ON P.CDGO_CENTCONT = CC.CDGO_CENTCONT    "
				+ "			LEFT JOIN PASG.TBASG141_ARETER ARE_T ON P.CDGO_ARETER = ARE_T.CDGO_ARETER    		"
				+ "		WHERE " + "			P.MRCA_ACTIVO = 'S' 									"
				+ "			AND E.MRCA_ACTIVO = 'S' " + "			AND EE.MRCA_ACTIVO = 'S' "
				+ "			AND S.MRCA_ACTIVO = 'S' 			"
				+ "			AND EE.FCHA_ESTADO = (SELECT MAX(FCHA_ESTADO) "
				+ "			                        FROM PASG.TBASG118_ESTADOEXP "
				+ "			                        WHERE CDGO_EXPEDIENT = EE.CDGO_EXPEDIENT AND MRCA_ACTIVO = 'S')		         				"
				+ "" + "	    " + "			" + "			" + "			" + "			" + "			"
				+ "			" + "			"
				+ "																					" + "			"
				+ "			" + "			" + "			" + "			" + "			"
				+ "																" + "			ORDER BY DESG_APELL1";
		Query sqlquery = em.createNativeQuery(sqlString, GetPerByEstadoListResultDTO.class);
		return sqlquery.getResultList();
	}

	public List<Tbasg100Persona> getReportHistoricoList() {

		String sqlString = "SELECT DISTINCT"
				+ "		P.CDGO_PERSONA, P.DESG_NOMBRE AS DESG_PERSONA, P.DESG_APELL1, P.DESG_APELL2, P.DESG_NIFPAS, P.DESG_MATRICULA,"
				+ "		X.CDGO_EXPEDIENT, X.CDGO_ALCANCEOT, X.CDGO_ALCANCEAMBITO, X.CDGO_SERIE, X.CDGO_SUBSERIE, X.CDGO_ENTORNO, "
				+ "		X.CDGO_LINEA, X.CDGO_ESPEC, X.CDGO_TIPOHAB, X.CDGO_AMBITOS, X.CDGO_SOCIOTOR, "
				+ "		I.DESG_NOMBRE AS TIPO_HABILITA, " + "		M.DESG_NOMBRE AS EMPRESA, "
				+ "		A.DESG_NOMBRE AS AMBITO, " + "		E.DESG_NOMBRE AS ESTADO" + "" + "		FROM "
				+ "			PASG.TBASG100_PERSONA P    "
				+ "		    LEFT JOIN PASG.TBASG104_EXPEDIENT X ON X.CDGO_PERSONA = P.CDGO_PERSONA"
				+ "		    LEFT JOIN PASG.TBASG118_ESTADOEXP D ON D.CDGO_EXPEDIENT = X.CDGO_EXPEDIENT"
				+ "		    LEFT JOIN PASG.TBASG116_ESTADOS E ON E.CDGO_ESTADO = D.CDGO_ESTADO    "
				+ "		    LEFT JOIN PASG.TBASG123_TIPOHABIL I ON X.CDGO_TIPOHAB = I.CDGO_TIPOHAB"
				+ "		    LEFT JOIN PASG.TBASG125_EMPRESA M ON M.CDGO_EMPRESA = X.CDGO_EMPRESA 	    "
				+ "			LEFT JOIN PASG.TBASG124_AMBITOS A ON A.CDGO_AMBITOS = X.CDGO_AMBITOS"
				+ "		WHERE 		" + "			X.MRCA_ACTIVO = 'S'" + "			AND D.MRCA_ACTIVO = 'S'"
				+ "			AND E.MRCA_ACTIVO = 'S'					"
				+ "			AND D.FCHA_ESTADO IN (SELECT MAX(FCHA_ESTADO) "
				+ "						FROM PASG.TBASG118_ESTADOEXP"
				+ "						WHERE CDGO_EXPEDIENT = D.CDGO_EXPEDIENT AND MRCA_ACTIVO = 'S')";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg100Persona.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg100Persona> getMaqByTramosList() {

		String sqlString = "SELECT DISTINCT     "
				+ "			P.CDGO_PERSONA, P.DESG_NIFPAS, P.DESG_MATRICULA, P.DESG_NOMBRE, P.DESG_APELL1, P.DESG_APELL2, "
				+ "			ENT.DESG_NOMENTORNO" + "		FROM " + "			PASG.TBASG100_PERSONA P     "
				+ "            INNER JOIN PASG.TBASG145_ALCHAESTA ALC_A ON B.CDGO_ALCHABINF = ALC_A.CDGO_ALCHABINF   "
				+ "			INNER JOIN PASG.TBASG126_ALCHABINF B ON B.CDGO_EXPEDIENT = E.CDGO_EXPEDIENT "
				+ "			INNER JOIN PASG.TBASG104_EXPEDIENT E ON P.CDGO_PERSONA = E.CDGO_PERSONA    "
				+ "			INNER JOIN PASG.TBASG129_ENTORNOS ENT ON ENT.CDGO_ENTORNO = E.CDGO_ENTORNO"
				+ "			   		           " + "		  		" + "		WHERE "
				+ "			P.MRCA_ACTIVO = 'S' 									"
				+ "			AND E.MRCA_ACTIVO = 'S' " + "			" + "				         				" + ""
				+ "	    " + "																"
				+ "		ORDER BY DESG_APELL1";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg100Persona.class);

		return sqlquery.getResultList();
	}

	public List<GetFechaProxRecicTitConDTO> getFechaProxRecicTitCon(String cdgoPersona) {

		String sqlString = "SELECT " + "			        CASE "
				+ "			        WHEN MAX(AC.FCHA_CURSO) > '2015-04-20' THEN"
				+ "				MAX(AC.FCHA_CURSO) + 2 YEARS " + "				ELSE"
				+ "				MAX(AC.FCHA_CURSO) + 3 YEARS " + "				END AS FCHA_CURSOINC"
				+ "			FROM " + "				PASG.TBASG100_PERSONA P"
				+ "				INNER JOIN PASG.TBASG102_TITULOCON T ON T.CDGO_PERSONA = P.CDGO_PERSONA"
				+ "				INNER JOIN PASG.TBASG117_ESTADOTIT ET ON ET.CDGO_TIT = T.CDGO_TIT"
				+ "				INNER JOIN PASG.TBASG116_ESTADOS E ON E.CDGO_ESTADO = ET.CDGO_ESTADO"
				+ "				LEFT JOIN PASG.TBASG121_ACTAFORMA AF ON AF.CDGO_TIT = T.CDGO_TIT"
				+ "				LEFT JOIN PASG.TBASG146_ACTAINCAL AC ON AC.CDGO_ACTAFORM = AF.CDGO_ACTAFORM"
				+ "				LEFT JOIN PASG.TBASG104_EXPEDIENT EX ON P.CDGO_PERSONA=EX.CDGO_PERSONA"
				+ "			WHERE ET.FCHA_ESTADO = (SELECT MAX(FCHA_ESTADO)"
				+ "				                         FROM PASG.TBASG117_ESTADOTIT"
				+ "				                         WHERE CDGO_TIT = ET.CDGO_TIT"
				+ "										 AND MRCA_ACTIVO ='S')"
				+ "			AND P.MRCA_ACTIVO = 'S'        " + "			AND T.MRCA_ACTIVO = 'S'      "
				+ "			AND ET.MRCA_ACTIVO = 'S'" + "			AND EX.CDGO_PERSONA=:value"
				+ "			AND AF.MRCA_ACTIVO = 'S'" + "			AND AC.MRCA_ACTIVO = 'S'"
				+ "			AND ET.CDGO_ESTADO IN (3, 4, 5, 6, 7) " + "			AND EX.CDGO_TIPOHAB = '2'";

		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);

		List<Object> resultados = sqlquery.getResultList();
		List<GetFechaProxRecicTitConDTO> resultadosDevueltos = new ArrayList<>();
		for (Object object : resultados) {
			GetFechaProxRecicTitConDTO persona = new GetFechaProxRecicTitConDTO();

			persona.setFchaCursoInc((Date) object);

			resultadosDevueltos.add(persona);
		}
		return resultadosDevueltos;
	}

	public List<GetFechaProxRecicTitConDTO> getFechaProxRecicTitConByMatricula(String idMatricula) {

		String sqlString = "SELECT " + "			        CASE "
				+ "			        WHEN MAX(AC.FCHA_CURSO) > '2015-04-20' THEN"
				+ "				MAX(AC.FCHA_CURSO) + 2 YEARS " + "				ELSE"
				+ "				MAX(AC.FCHA_CURSO) + 3 YEARS " + "				END AS FCHA_CURSOINC"
				+ "			FROM " + "				PASG.TBASG100_PERSONA P"
				+ "				INNER JOIN PASG.TBASG102_TITULOCON T ON T.CDGO_PERSONA = P.CDGO_PERSONA"
				+ "				INNER JOIN PASG.TBASG117_ESTADOTIT ET ON ET.CDGO_TIT = T.CDGO_TIT"
				+ "				INNER JOIN PASG.TBASG116_ESTADOS E ON E.CDGO_ESTADO = ET.CDGO_ESTADO"
				+ "				LEFT JOIN PASG.TBASG121_ACTAFORMA AF ON AF.CDGO_TIT = T.CDGO_TIT"
				+ "				LEFT JOIN PASG.TBASG146_ACTAINCAL AC ON AC.CDGO_ACTAFORM = AF.CDGO_ACTAFORM"
				+ "				LEFT JOIN PASG.TBASG104_EXPEDIENT EX ON P.CDGO_PERSONA=EX.CDGO_PERSONA"
				+ "			WHERE ET.FCHA_ESTADO = (SELECT MAX(FCHA_ESTADO)"
				+ "				                         FROM PASG.TBASG117_ESTADOTIT"
				+ "				                         WHERE CDGO_TIT = ET.CDGO_TIT"
				+ "										 AND MRCA_ACTIVO ='S')"
				+ "			AND P.MRCA_ACTIVO = 'S'        " + "			AND T.MRCA_ACTIVO = 'S'      "
				+ "			AND ET.MRCA_ACTIVO = 'S'" + "			AND P.DESG_MATRICULA=:value"
				+ "			AND AF.MRCA_ACTIVO = 'S'" + "			AND AC.MRCA_ACTIVO = 'S'"
				+ "			AND ET.CDGO_ESTADO IN (3, 4, 5, 6, 7) " + "			AND EX.CDGO_TIPOHAB = '2'";

		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", idMatricula);

		List<Object> resultados = sqlquery.getResultList();
		List<GetFechaProxRecicTitConDTO> resultadosDevueltos = new ArrayList<>();
		for (Object object : resultados) {
			GetFechaProxRecicTitConDTO persona = new GetFechaProxRecicTitConDTO();

			persona.setFchaCursoInc((Date) object);

			resultadosDevueltos.add(persona);
		}
		return resultadosDevueltos;
	}

	public List<GetFechaProxRecicTitConNoMarcaDTO> getFechaProxRecicTitConNoMarca(String cdgoPersona) {

		String sqlString = "SELECT " + "			        CASE "
				+ "			        WHEN MAX(AC.FCHA_CURSO) > '2015-04-20' THEN"
				+ "				MAX(AC.FCHA_CURSO) + 2 YEARS " + "				ELSE"
				+ "				MAX(AC.FCHA_CURSO) + 3 YEARS " + "				END AS FCHA_CURSOINC"
				+ "			FROM " + "				PASG.TBASG100_PERSONA P"
				+ "				INNER JOIN PASG.TBASG102_TITULOCON T ON T.CDGO_PERSONA = P.CDGO_PERSONA"
				+ "				INNER JOIN PASG.TBASG117_ESTADOTIT ET ON ET.CDGO_TIT = T.CDGO_TIT"
				+ "				INNER JOIN PASG.TBASG116_ESTADOS E ON E.CDGO_ESTADO = ET.CDGO_ESTADO"
				+ "				LEFT JOIN PASG.TBASG121_ACTAFORMA AF ON AF.CDGO_TIT = T.CDGO_TIT"
				+ "				LEFT JOIN PASG.TBASG146_ACTAINCAL AC ON AC.CDGO_ACTAFORM = AF.CDGO_ACTAFORM"
				+ "				LEFT JOIN PASG.TBASG104_EXPEDIENT EX ON P.CDGO_PERSONA=EX.CDGO_PERSONA"
				+ "			WHERE ET.FCHA_ESTADO = (SELECT MAX(FCHA_ESTADO)"
				+ "				                         FROM PASG.TBASG117_ESTADOTIT"
				+ "				                         WHERE CDGO_TIT = ET.CDGO_TIT"
				+ "										 )" + "			AND P.MRCA_ACTIVO = 'S'        "
				+ "			AND EX.CDGO_PERSONA=:value" + "			AND ET.CDGO_ESTADO IN (3, 4, 5, 6, 7) "
				+ "			AND EX.CDGO_TIPOHAB = '2'";

		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);

		List<Object> resultados = sqlquery.getResultList();
		List<GetFechaProxRecicTitConNoMarcaDTO> resultadosDevueltos = new ArrayList<>();
		for (Object object : resultados) {
			GetFechaProxRecicTitConNoMarcaDTO persona = new GetFechaProxRecicTitConNoMarcaDTO();

			persona.setFchaCursoInc((Date) object);

			resultadosDevueltos.add(persona);
		}
		return resultadosDevueltos;
	}

	public List<GetFechaProxRecicTitConNoMarcaDTO> getFechaProxRecicTitConNoMarcaS(String cdgoPersona) {

		String sqlString = "SELECT " + "			        CASE "
				+ "			        WHEN MAX(AC.FCHA_CURSO) > '2015-04-20' THEN"
				+ "				MAX(AC.FCHA_CURSO) + 2 YEARS " + "				ELSE"
				+ "				MAX(AC.FCHA_CURSO) + 3 YEARS " + "				END AS FCHA_CURSOINC"
				+ "			FROM " + "				PASG.TBASG100_PERSONA P"
				+ "				INNER JOIN PASG.TBASG102_TITULOCON T ON T.CDGO_PERSONA = P.CDGO_PERSONA"
				+ "				INNER JOIN PASG.TBASG117_ESTADOTIT ET ON ET.CDGO_TIT = T.CDGO_TIT"
				+ "				INNER JOIN PASG.TBASG116_ESTADOS E ON E.CDGO_ESTADO = ET.CDGO_ESTADO"
				+ "				LEFT JOIN PASG.TBASG121_ACTAFORMA AF ON AF.CDGO_TIT = T.CDGO_TIT"
				+ "				LEFT JOIN PASG.TBASG146_ACTAINCAL AC ON AC.CDGO_ACTAFORM = AF.CDGO_ACTAFORM"
				+ "				LEFT JOIN PASG.TBASG104_EXPEDIENT EX ON P.CDGO_PERSONA=EX.CDGO_PERSONA"
				+ "			WHERE ET.FCHA_ESTADO = (SELECT MAX(FCHA_ESTADO)"
				+ "				                         FROM PASG.TBASG117_ESTADOTIT"
				+ "				                         WHERE CDGO_TIT = ET.CDGO_TIT"
				+ "										 )" + "			AND EX.CDGO_PERSONA=:value"
				+ "			AND ET.CDGO_ESTADO IN (3, 4, 5, 6, 7) " + "			AND EX.CDGO_TIPOHAB = '1'";

		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);

		List<Object> resultados = sqlquery.getResultList();
		List<GetFechaProxRecicTitConNoMarcaDTO> resultadosDevueltos = new ArrayList<>();
		for (Object object : resultados) {
			GetFechaProxRecicTitConNoMarcaDTO persona = new GetFechaProxRecicTitConNoMarcaDTO();

			persona.setFchaCursoInc((Date) object);

			resultadosDevueltos.add(persona);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg100Persona> getPersonaExaminador(String cdgoNif) {

		String sqlString = "SELECT CDGO_PERSONA,DESG_NIFPAS,DESG_NOMBRE,DESG_APELL1,DESG_APELL2,MRCA_FORMADOR,MRCA_EXAMINADOR,MRCA_ACTIVO "
				+ "		FROM PASG.TBASG100_PERSONA P"
				+ "		INNER JOIN PASG.TBASG122_INSTRU INS ON P.DESG_NIFPAS=INS.CDGO_NIF"
				+ "		WHERE INS.CDGO_NIF = :value " + "		AND MRCA_EXAMINADOR=\"S\"";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg100Persona.class);
		sqlquery.setParameter("value", cdgoNif);
		return sqlquery.getResultList();
	}

	public List<Tbasg100Persona> getPersonaInstructor(String cdgoNif) {

		String sqlString = "SELECT NEW renfe.com.model.entity.Tbasg100Persona(P.cdgoPersona, P.tbasg122Instru.desgApell1) "
				+ "		FROM Tbasg100Persona as P"
				+ "		INNER JOIN P.tbasg122Instru as INS ON P.desgNifpas=INS.cdgoNif"
				+ "		WHERE INS.cdgoNif = :value " + "		AND INS.mrcaInstructor='S'";

		TypedQuery<Tbasg100Persona> sqlquery = em.createQuery(sqlString, Tbasg100Persona.class);
		sqlquery.setParameter("value", cdgoNif);
		return sqlquery.getResultList();
	}

	/*
	 * public List<Tbasg100Persona> getPersonaInstructor(String cdgoNif) {
	 * 
	 * String sqlString =
	 * "SELECT CDGO_PERSONA,DESG_NIFPAS,DESG_NOMBRE,DESG_APELL1,DESG_APELL2,MRCA_FORMADOR,MRCA_EXAMINADOR,MRCA_ACTIVO "
	 * + "		FROM PASG.TBASG100_PERSONA P" +
	 * "		INNER JOIN PASG.TBASG122_INSTRU INS ON P.DESG_NIFPAS=INS.CDGO_NIF" +
	 * "		WHERE INS.CDGO_NIF = :value " +
	 * "		AND INS.MRCA_INSTRUCTOR=\"S\""; Query sqlquery =
	 * em.createNativeQuery(sqlString, Tbasg100Persona.class);
	 * sqlquery.setParameter("value", cdgoNif); return sqlquery.getResultList(); }
	 */

	public List<GetPersonaEstadoListDTO> getPersonaEstadoList(SetPersonaEstadoList mapPending) {

		StringBuilder strGetPersonaEstadoList = new StringBuilder();
		String sqlString = "SELECT C.DESG_NIFPAS, C.DESG_NOMBRE AS DESG_PERSONA, C.DESG_APELL1, C.DESG_APELL2, C.CDGO_PERSONA, C.DESG_MATRICULA, C.CDGO_AREACT,	"
				+ " C.CDGO_ARETER, C.CDGO_CENTCONT, AA.DESG_NOMBRE AS DESG_AREACT, AT.DESG_NOMBRE AS DESG_ARETER, CC.DESG_NOMBRE AS DESG_CENTCONT,"
				+ " E.DESG_NOMBRE AS DESG_EMPRESA FROM PASG.TBASG100_PERSONA C"
				+ " LEFT JOIN PASG.TBASG105_AREACTIVI AA ON (C.CDGO_AREACT = AA.CDGO_AREACT) "
				+ "	LEFT JOIN PASG.TBASG141_ARETER AT ON (C.CDGO_ARETER = AT.CDGO_ARETER) "
				+ "	LEFT JOIN PASG.TBASG132_CENTCONT CC ON (C.CDGO_CENTCONT = CC.CDGO_CENTCONT) "
				+ "	LEFT JOIN PASG.TBASG104_EXPEDIENT A ON (A.CDGO_PERSONA = C.CDGO_PERSONA) 		"
				+ "	LEFT JOIN PASG.TBASG152_PERSEMP PE ON (PE.CDGO_PERSONA = C.CDGO_PERSONA) 		"
				+ "	LEFT JOIN PASG.TBASG125_EMPRESA E ON (PE.CDGO_EMPRESA = E.CDGO_EMPRESA)" + "		     "
				+ "	LEFT JOIN PASG.TBASG118_ESTADOEXP EE ON (A.CDGO_EXPEDIENT = EE.CDGO_EXPEDIENT) "
				+ "	WHERE A.MRCA_ACTIVO = 'S' AND C.MRCA_ACTIVO = 'S' AND EE.FCHA_ESTADO IN "
				+ " (SELECT MAX(FCHA_ESTADO) FROM PASG.TBASG118_ESTADOEXP WHERE CDGO_EXPEDIENT = EE.CDGO_EXPEDIENT AND MRCA_ACTIVO ='S') AND EE.CDGO_ESTADO <> 4";

		strGetPersonaEstadoList.append(sqlString);
		System.out.println("----------------------");
		System.out.println(strGetPersonaEstadoList.toString());
		System.out.println("----------------------");

		if (mapPending != null) {
			if (mapPending.getCdgoTipoHab() != null) {

				strGetPersonaEstadoList.append(" AND A.CDGO_TIPOHAB IN (" + mapPending.getCdgoTipoHab().get(0));

				for (int i = 1; i < mapPending.getCdgoTipoHab().size(); i++) {
					strGetPersonaEstadoList.append(" ," + mapPending.getCdgoTipoHab().get(i));
				}

				strGetPersonaEstadoList.append(" )");
			}

			if (mapPending.getCdgoAreAct() != null) {

				strGetPersonaEstadoList.append(" AND C.CDGO_AREACT IN (" + mapPending.getCdgoAreAct().get(0));

				for (int i = 1; i < mapPending.getCdgoAreAct().size(); i++) {
					strGetPersonaEstadoList.append(" ," + mapPending.getCdgoAreAct().get(i));
				}

				strGetPersonaEstadoList.append(" )");
			}

			if (mapPending.getCdgoAreTerr() != null) {
				strGetPersonaEstadoList.append(" AND C.CDGO_ARETER = " + mapPending.getCdgoAreTerr());
			}

			if (mapPending.getCdgoCentCont() != null) {
				strGetPersonaEstadoList.append(" AND C.CDGO_CENTCONT LIKE '%" + mapPending.getCdgoCentCont() + "%'");
			}

			if (mapPending.getDni() != null) {
				strGetPersonaEstadoList.append(" AND C.DESG_NIFPAS LIKE '%" + mapPending.getDni() + "%'");
			}

			if (mapPending.getDesgMatricula() != null) {
				strGetPersonaEstadoList.append(" AND C.DESG_MATRICULA LIKE '%" + mapPending.getDesgMatricula() + "%'");
			}

			if (mapPending.getNombre() != null) {
				strGetPersonaEstadoList.append(" AND C.DESG_NOMBRE LIKE '%" + mapPending.getNombre() + "%'");
			}

			if (mapPending.getDesgApell1() != null) {
				strGetPersonaEstadoList.append(" AND C.DESG_APELL1 LIKE '%" + mapPending.getDesgApell1() + "%'");
			}

			if (mapPending.getDesgApell2() != null) {
				strGetPersonaEstadoList.append(" AND C.DESG_APELL2 LIKE '%" + mapPending.getDesgApell2() + "%'");
			}

			if (mapPending.getPersonal() != null) {
				if (mapPending.getPersonal().equals("RENFE")) {
					strGetPersonaEstadoList.append(" AND C.DESG_MATRICULA != '' AND C.DESG_MATRICULA IS NOT NULL");
				}

				if (mapPending.getPersonal().equals("EXT")) {
					strGetPersonaEstadoList.append(" AND (C.DESG_MATRICULA = '' OR C.DESG_MATRICULA IS NULL)");

					if (mapPending.getEmpresa() != null) {
						strGetPersonaEstadoList.append(" AND PE.CDGO_EMPRESA = " + mapPending.getEmpresa());
					}
				}

				if (mapPending.getPersonal().equals("AMBOS")) {
					if (mapPending.getEmpresa() != null) {
						strGetPersonaEstadoList.append(
								" AND ((C.DESG_MATRICULA != '' AND C.DESG_MATRICULA IS NOT NULL) OR PE.CDGO_EMPRESA = "
										+ mapPending.getEmpresa() + ")");
					}
				}
			}

		}

		System.out.println("----------------------");
		System.out.println(strGetPersonaEstadoList.toString());
		System.out.println("----------------------");

		strGetPersonaEstadoList.append(
				" GROUP BY C.CDGO_PERSONA, C.DESG_NIFPAS, C.DESG_NOMBRE, C.DESG_APELL1, C.DESG_APELL2, C.CDGO_PERSONA, C.DESG_MATRICULA,"
						+ " C.CDGO_AREACT, C.CDGO_ARETER, C.CDGO_CENTCONT, AA.DESG_NOMBRE, AT.DESG_NOMBRE, CC.DESG_NOMBRE, E.DESG_NOMBRE");

		if (mapPending.getColumnOrden() != null) {
			if (mapPending.getColumnOrden().equals("APELL1")) {
				if (mapPending.getCdgoOrden().equals("A")) {
					strGetPersonaEstadoList
							.append(" ORDER BY C.DESG_APELL1 ASC, C.DESG_APELL2 ASC, C.CDGO_PERSONA ASC");
				}

				if (mapPending.getCdgoOrden().equals("D")) {
					strGetPersonaEstadoList
							.append(" ORDER BY C.DESG_APELL1 DESC, C.DESG_APELL2 DESC, C.CDGO_PERSONA DESC");
				}
			}

			if (mapPending.getColumnOrden().equals("FCHA_PROXREV")) {
				strGetPersonaEstadoList.append(" ORDER BY C.DESG_APELL1 ASC, C.DESG_APELL2 ASC, C.CDGO_PERSONA ASC");
			}
		}

		System.out.println("----------------------");
		System.out.println(strGetPersonaEstadoList.toString());
		System.out.println("----------------------");

		Query sqlquery = em.createNativeQuery(strGetPersonaEstadoList.toString());

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetPersonaEstadoListDTO> resultadosDevueltos = new ArrayList<>();

		for (Object[] object : resultados) {
			GetPersonaEstadoListDTO data = new GetPersonaEstadoListDTO();
			if (object[0] != null) {
				data.setDesgNifpas(Util.quitarEspacios(object[0]));
			}
			if (object[1] != null) {
				data.setDesgPersona(Util.quitarEspacios(object[1]));
			}
			if (object[2] != null) {
				data.setDesgApell1(Util.quitarEspacios(object[2]));
			}
			if (object[3] != null) {
				data.setDesgApell2(Util.quitarEspacios(object[3]));
			}
			if (object[4] != null) {
				data.setCdgoPersona((Integer) object[4]);
			}
			if (object[5] != null) {
				data.setDesgMatricula(Util.quitarEspacios(object[5]));
			}
			if (object[6] != null) {
				data.setCdgoAreAct((Integer) object[6]);
			}
			if (object[7] != null) {
				data.setCdgoAreTerr((Integer) object[7]);
			}
			if (object[8] != null) {
				data.setCdgoCentroCont(Util.quitarEspacios(object[8]));
			}
			if (object[9] != null) {
				data.setDesgAreAct(Util.quitarEspacios(object[9]));
			}
			if (object[10] != null) {
				data.setDesgAreTerr(Util.quitarEspacios(object[10]));
			}
			if (object[11] != null) {
				data.setDesgCentroCont(Util.quitarEspacios(object[11]));
			}
			if (object[12] != null) {
				data.setDesgEmpresa(Util.quitarEspacios(object[12]));
			}

			resultadosDevueltos.add(data);

		}

		return resultadosDevueltos;
	}

	public List<Tbasg100Persona> getMaxEstadoHabilitaCount() {

		String sqlString = "SELECT Count(*) AS value" + "		FROM"
				+ "		    PASG.TBASG100_PERSONA C, 			" + "		    PASG.TBASG104_EXPEDIENT A,"
				+ "			PASG.TBASG121_ACTAFORMA F" + "			"
				+ "			LEFT OUTER JOIN PASG.TBASG146_ACTAINCAL G ON (G.CDGO_ACTAFORM = F.CDGO_ACTAFORM and G.MRCA_ACTIVO = 'S')"
				+ "						" + "		WHERE  " + "			F.CDGO_EXPEDIENT = A.CDGO_EXPEDIENT"
				+ "			AND A.CDGO_PERSONA = C.CDGO_PERSONA" + "			AND A.MRCA_ACTIVO = 'S'"
				+ "			AND C.MRCA_ACTIVO = 'S'" + "		    AND G.MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg100Persona.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg100Persona> getMaxEstadoProxRevListCount() {

		String sqlString = "SELECT COUNT(*)" + "			FROM " + "			    PASG.TBASG100_PERSONA C, "
				+ "			    PASG.TBASG101_CERTPSIC H," + "			    PASG.TBASG104_EXPEDIENT A "
				+ "					" + "	" + "			WHERE  " + "				A.CDGO_PERSONA = C.CDGO_PERSONA"
				+ "			    AND H.FCHA_PROXREV IS NOT NULL" + "	            AND C.CDGO_PERSONA = H.CDGO_PERSONA"
				+ "	            AND H.CDGO_CALIFI <> 3" + "				AND A.MRCA_ACTIVO = 'S'	            "
				+ "				AND C.MRCA_ACTIVO = 'S'" + "	" + "			" + "" + "			GROUP BY "
				+ "				C.DESG_NIFPAS," + "				C.DESG_NOMBRE," + "				C.DESG_APELL1,"
				+ "				C.DESG_APELL2," + "				C.CDGO_PERSONA," + "				C.DESG_MATRICULA,"
				+ "				H.MRCA_ACTIVO," + "				H.FCHA_PROXREV";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg100Persona.class);

		return sqlquery.getResultList();
	}

	public List<GetMaxEstadoProxRevListDTO> getMaxEstadoProxRevList(setMaxEstadoProxRevList mapPending) {

		StringBuilder strGetMaxEstadoProxRevList = new StringBuilder();

		String sqlString = "SELECT C.DESG_NIFPAS, C.DESG_NOMBRE AS DESG_PERSONA, C.DESG_APELL1, C.DESG_APELL2, C.CDGO_PERSONA, C.DESG_MATRICULA,"
				+ " H.MRCA_ACTIVO, H.FCHA_PROXREV, H.CDGO_PSICAMB, PS.DESG_NOMBRE, C.CDGO_AREACT, C.CDGO_ARETER, C.CDGO_CENTCONT,"
				+ " AA.DESG_NOMBRE AS DESG_AREACT, AT.DESG_NOMBRE AS DESG_ARETER, CC.DESG_NOMBRE AS DESG_CENTCONT, E.DESG_NOMBRE AS DESG_EMPRESA"

				+ " FROM PASG.TBASG100_PERSONA C"
				+ " LEFT JOIN PASG.TBASG105_AREACTIVI AA ON (C.CDGO_AREACT = AA.CDGO_AREACT)"
				+ "	LEFT JOIN PASG.TBASG141_ARETER AT ON (C.CDGO_ARETER = AT.CDGO_ARETER)"
				+ "	LEFT JOIN PASG.TBASG132_CENTCONT CC ON (C.CDGO_CENTCONT = CC.CDGO_CENTCONT),"
				+ "	PASG.TBASG101_CERTPSIC H," + "	PASG.TBASG104_EXPEDIENT A"
				+ "	LEFT JOIN PASG.TBASG125_EMPRESA E ON (A.CDGO_EMPRESA = E.CDGO_EMPRESA)"
				+ " LEFT JOIN PASG.TBASG118_ESTADOEXP EE ON (A.CDGO_EXPEDIENT = EE.CDGO_EXPEDIENT)"
				+ "	LEFT JOIN PASG.TBASG109_PSICOAMBI PS ON (PS.CDGO_PSICAMB = H.CDGO_PSICAMB)"

				+ " WHERE A.CDGO_PERSONA = C.CDGO_PERSONA AND H.FCHA_PROXREV IS NOT NULL AND C.CDGO_PERSONA = H.CDGO_PERSONA"
				+ " AND H.CDGO_CALIFI <> 3 AND A.MRCA_ACTIVO = 'S' AND C.MRCA_ACTIVO = 'S'"
				+ "	AND EE.FCHA_ESTADO IN (SELECT MAX(FCHA_ESTADO) FROM PASG.TBASG118_ESTADOEXP"
				+ "	WHERE CDGO_EXPEDIENT = EE.CDGO_EXPEDIENT AND MRCA_ACTIVO ='S') AND EE.CDGO_ESTADO <> 4";

		strGetMaxEstadoProxRevList.append(sqlString);
		System.out.println("----------------------");
		System.out.println(strGetMaxEstadoProxRevList.toString());
		System.out.println("----------------------");

		if (mapPending != null) {

			if (mapPending.getCdgoAreAct() != null) {

				strGetMaxEstadoProxRevList.append(" AND C.CDGO_AREACT IN (" + mapPending.getCdgoAreAct().get(0));

				for (int i = 1; i < mapPending.getCdgoAreAct().size(); i++) {
					strGetMaxEstadoProxRevList.append(" ," + mapPending.getCdgoAreAct().get(i));
				}

				strGetMaxEstadoProxRevList.append(" )");
			}

			if (mapPending.getCdgoAreTerr() != null) {
				strGetMaxEstadoProxRevList.append(" AND C.CDGO_ARETER = " + mapPending.getCdgoAreTerr());
			}

			if (mapPending.getCdgoCentroCont() != null) {
				strGetMaxEstadoProxRevList.append(" AND C.CDGO_CENTCONT = " + mapPending.getCdgoCentroCont());
			}

			if (mapPending.getSociedad() != null) {
				strGetMaxEstadoProxRevList.append(" AND A.CDGO_SOCIOTOR = " + mapPending.getSociedad());
			}

			if (mapPending.getDni() != null) {
				strGetMaxEstadoProxRevList.append(" AND C.DESG_NIFPAS LIKE '%" + mapPending.getDni() + "%'");
			}

			if (mapPending.getMatricula() != null) {
				strGetMaxEstadoProxRevList.append(" AND C.DESG_MATRICULA LIKE '%" + mapPending.getMatricula() + "%'");
			}

			if (mapPending.getNombre() != null) {
				strGetMaxEstadoProxRevList.append(" AND C.DESG_NOMBRE LIKE '%" + mapPending.getNombre() + "%'");
			}

			if (mapPending.getApell1() != null) {
				strGetMaxEstadoProxRevList.append(" AND C.DESG_APELL1 LIKE '%" + mapPending.getApell1() + "%'");
			}

			if (mapPending.getApell2() != null) {
				strGetMaxEstadoProxRevList.append(" AND C.DESG_APELL2 LIKE '%" + mapPending.getApell2() + "%'");
			}

			if (mapPending.getPersonal() != null) {
				if (mapPending.getPersonal().equals("RENFE")) {
					strGetMaxEstadoProxRevList.append(" AND C.DESG_MATRICULA != '' AND C.DESG_MATRICULA IS NOT NULL");
				}

				if (mapPending.getPersonal().equals("EXT")) {
					strGetMaxEstadoProxRevList.append(" AND (C.DESG_MATRICULA = '' OR C.DESG_MATRICULA IS NULL)");

					if (mapPending.getEmpresa() != null) {
						strGetMaxEstadoProxRevList.append(" AND A.CDGO_EMPRESA = " + mapPending.getEmpresa());
					}
				}

				if (mapPending.getPersonal().equals("AMBOS")) {
					if (mapPending.getEmpresa() != null) {
						strGetMaxEstadoProxRevList.append(
								" AND (C.DESG_MATRICULA != '' AND C.DESG_MATRICULA IS NOT NULL) OR A.CDGO_EMPRESA = = "
										+ mapPending.getEmpresa());
					}
				}
			}
		}

		System.out.println("----------------------");
		System.out.println(strGetMaxEstadoProxRevList.toString());
		System.out.println("----------------------");

		strGetMaxEstadoProxRevList.append(
				" GROUP BY C.DESG_NIFPAS, C.DESG_NOMBRE, C.DESG_APELL1, C.DESG_APELL2, C.CDGO_PERSONA, C.DESG_MATRICULA, H.MRCA_ACTIVO, H.FCHA_PROXREV,"
						+ " H.CDGO_PSICAMB, PS.DESG_NOMBRE, C.CDGO_AREACT, C.CDGO_ARETER, C.CDGO_CENTCONT, AA.DESG_NOMBRE, AT.DESG_NOMBRE, CC.DESG_NOMBRE, E.DESG_NOMBRE");

		if (mapPending.getColumnOrden() != null) {
			if (mapPending.getColumnOrden().equals("APELL1")) {
				if (mapPending.getCdgoOrden().equals("A")) {
					strGetMaxEstadoProxRevList.append(
							" ORDER BY C.DESG_APELL1 ASC, C.DESG_APELL2 ASC, C.CDGO_PERSONA ASC, H.CDGO_PSICAMB ASC, H.MRCA_ACTIVO DESC");
				}

				if (mapPending.getCdgoOrden().equals("D")) {
					strGetMaxEstadoProxRevList.append(
							" ORDER BY C.DESG_APELL1 DESC, C.DESG_APELL2 DESC, C.CDGO_PERSONA ASC, H.CDGO_PSICAMB ASC, H.MRCA_ACTIVO DESC");
				}
			}

			if (mapPending.getColumnOrden().equals("FCHA_PROXREV")) {
				strGetMaxEstadoProxRevList.append(" ORDER BY CDGO_PERSONA ASC");
			}
		}

		System.out.println("----------------------");
		System.out.println(strGetMaxEstadoProxRevList.toString());
		System.out.println("----------------------");

		Query sqlquery = em.createNativeQuery(strGetMaxEstadoProxRevList.toString());

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetMaxEstadoProxRevListDTO> resultadosDevueltos = new ArrayList<>();

		for (Object[] object : resultados) {
			GetMaxEstadoProxRevListDTO data = new GetMaxEstadoProxRevListDTO();
			if (object[0] != null) {
				data.setDesgNifpas(Util.quitarEspacios(object[0]));
			}
			if (object[1] != null) {
				data.setDesgPersona(Util.quitarEspacios(object[1]));
			}
			if (object[2] != null) {
				data.setDesgApell1(Util.quitarEspacios(object[2]));
			}
			if (object[3] != null) {
				data.setDesgApell2(Util.quitarEspacios(object[3]));
			}
			if (object[4] != null) {
				data.setCdgoPersona((Integer) object[4]);
			}
			if (object[5] != null) {
				data.setDesgMatricula(Util.quitarEspacios(object[5]));
			}
			if (object[6] != null) {
				data.setMrcaActivo(Util.quitarEspacios(object[6]));
			}
			if (object[7] != null) {
				data.setFchaProxrev((Date) object[7]);
			}
			if (object[8] != null) {
				data.setCdgoPsicamb((Integer) object[8]);
			}
			if (object[9] != null) {
				data.setDesgNombre(Util.quitarEspacios(object[9]));
			}
			if (object[10] != null) {
				data.setCdgoAreAct((Integer) object[10]);
			}
			if (object[11] != null) {
				data.setCdgoAreTer((Integer) object[11]);
			}
			if (object[12] != null) {
				data.setCdgoCentCont(Util.quitarEspacios(object[12]));
			}
			if (object[13] != null) {
				data.setDesgAreAct(Util.quitarEspacios(object[13]));
			}
			if (object[14] != null) {
				data.setDesgAreTer(Util.quitarEspacios(object[14]));
			}
			if (object[15] != null) {
				data.setDesgCentCont(Util.quitarEspacios(object[15]));
			}
			if (object[16] != null) {
				data.setDesgEmpresa(Util.quitarEspacios(object[16]));
			}

			resultadosDevueltos.add(data);

		}

		return resultadosDevueltos;
	}

	public List<GetPersonaCertificadosIdiomasListDTO> getPersonaCertificadosIdiomasList(
			SetPersonaCertificadosIdiomasList mapPending) {

		StringBuilder strGetPersonaCertificadosIdiomasList = new StringBuilder();

		String sqlString = "SELECT C.DESG_NIFPAS, C.DESG_NOMBRE AS DESG_PERSONA, C.DESG_APELL1, C.DESG_APELL2, C.CDGO_PERSONA, C.DESG_MATRICULA, C.CDGO_AREACT, C.CDGO_ARETER,"
				+ " C.CDGO_CENTCONT, AA.DESG_NOMBRE AS DESG_AREACT, AT.DESG_NOMBRE AS DESG_ARETER, CC.DESG_NOMBRE AS DESG_CENTCONT, E.DESG_NOMBRE AS DESG_EMPRESA, "
				+ " FC.CDGO_CATEGORIA, FC.CDGO_CUALIFICACION, CA.DESG_DESCRIPCION, CU.DESG_NOMBRE, FC.FCHA_EXPEDICION "

				+ " FROM PASG.TBASG100_PERSONA C"
				+ " INNER JOIN PASG.TBASG105_AREACTIVI AA ON (C.CDGO_AREACT = AA.CDGO_AREACT) "
				+ " INNER JOIN PASG.TBASG141_ARETER AT ON (C.CDGO_ARETER = AT.CDGO_ARETER) "
				+ "	INNER JOIN PASG.TBASG132_CENTCONT CC ON (C.CDGO_CENTCONT = CC.CDGO_CENTCONT) "
				+ " INNER JOIN PASG.TBASG104_EXPEDIENT A ON (A.CDGO_PERSONA = C.CDGO_PERSONA) 		"
				+ "	INNER JOIN PASG.TBASG125_EMPRESA E ON (A.CDGO_EMPRESA = E.CDGO_EMPRESA) "
				+ "	INNER JOIN PASG.TBASG118_ESTADOEXP EE ON (A.CDGO_EXPEDIENT = EE.CDGO_EXPEDIENT) "
				+ "	INNER JOIN PASG.TBASG157_FORMAC_COMPLEMEN FC ON (C.CDGO_PERSONA = FC.CDGO_PERSONA)"
				+ "	INNER JOIN PASG.TBASG156_FC_CUALIFICACION CU ON (FC.CDGO_CUALIFICACION = CU.CDGO_CUALIFICACION)"
				+ "	INNER JOIN PASG.TBASG155_FC_CATEGORIA CA ON (CU.CDGO_CATEGORIA = CA.CDGO_CATEGORIA)"

				+ " WHERE A.MRCA_ACTIVO = 'S' AND C.MRCA_ACTIVO = 'S' AND EE.FCHA_ESTADO IN "
				+ " (SELECT MAX(FCHA_ESTADO) FROM PASG.TBASG118_ESTADOEXP WHERE CDGO_EXPEDIENT = EE.CDGO_EXPEDIENT AND MRCA_ACTIVO ='S')"
				+ " AND EE.CDGO_ESTADO <> 4 ";

		strGetPersonaCertificadosIdiomasList.append(sqlString);
		System.out.println("----------------------");
		System.out.println(strGetPersonaCertificadosIdiomasList.toString());
		System.out.println("----------------------");

		if (mapPending != null) {
			if (mapPending.getCdgoCategoría() != null) {
				strGetPersonaCertificadosIdiomasList
						.append(" AND FC.CDGO_CATEGORIA = " + mapPending.getCdgoCategoría());
			}

			if (mapPending.getCdgoCualificacion() != null) {
				strGetPersonaCertificadosIdiomasList
						.append(" AND FC.CDGO_CUALIFICACION = " + mapPending.getCdgoCualificacion());
			}

			if (mapPending.getCdgoTipoHab() != null) {
				strGetPersonaCertificadosIdiomasList
						.append(" AND A.CDGO_TIPOHAB IN (" + mapPending.getCdgoTipoHab().get(0));
				for (int i = 1; i < mapPending.getCdgoTipoHab().size(); i++) {
					strGetPersonaCertificadosIdiomasList.append(", " + mapPending.getCdgoTipoHab().get(i));
				}
				strGetPersonaCertificadosIdiomasList.append(" )");
			}

			if (mapPending.getCdgoAreAct() != null) {
				strGetPersonaCertificadosIdiomasList
						.append(" AND C.CDGO_AREACT IN (" + mapPending.getCdgoAreAct().get(0));
				for (int i = 1; i < mapPending.getCdgoAreAct().size(); i++) {
					strGetPersonaCertificadosIdiomasList.append(", " + mapPending.getCdgoAreAct().get(i));
				}
				strGetPersonaCertificadosIdiomasList.append(" )");
			}

			if (mapPending.getCdgoAreTerr() != null) {
				strGetPersonaCertificadosIdiomasList.append(" AND C.CDGO_ARETER = " + mapPending.getCdgoAreTerr());
			}

			if (mapPending.getCdgoSociedad() != null) {
				strGetPersonaCertificadosIdiomasList.append(" AND A.CDGO_SOCIOTOR = " + mapPending.getCdgoSociedad());
			}

			if (mapPending.getCdgoCentCont() != null) {
				strGetPersonaCertificadosIdiomasList
						.append(" AND C.CDGO_CENTCONT LIKE '%" + mapPending.getCdgoCentCont() + "%'");
			}

			if (mapPending.getDesgDni() != null) {
				strGetPersonaCertificadosIdiomasList
						.append(" AND C.DESG_NIFPAS LIKE '%" + mapPending.getDesgDni() + "%'");
			}

			if (mapPending.getDesgMatricula() != null) {
				strGetPersonaCertificadosIdiomasList
						.append(" AND C.DESG_MATRICULA LIKE '%" + mapPending.getDesgMatricula() + "%'");
			}

			if (mapPending.getNombre() != null) {
				strGetPersonaCertificadosIdiomasList
						.append(" AND C.DESG_NOMBRE LIKE '%" + mapPending.getNombre() + "%'");
			}

			if (mapPending.getDesgApell1() != null) {
				strGetPersonaCertificadosIdiomasList
						.append(" AND C.DESG_APELL1 LIKE '%" + mapPending.getDesgApell1() + "%'");
			}

			if (mapPending.getDesgApell2() != null) {
				strGetPersonaCertificadosIdiomasList
						.append(" AND C.DESG_APELL2 LIKE '%" + mapPending.getDesgApell2() + "%'");
			}

			if (mapPending.getPersonal() != null) {
				if (mapPending.getPersonal().equals("RENFE")) {
					strGetPersonaCertificadosIdiomasList
							.append(" AND C.DESG_MATRICULA != '' AND C.DESG_MATRICULA IS NOT NULL");
				}

				if (mapPending.getPersonal().equals("EXT")) {
					strGetPersonaCertificadosIdiomasList
							.append(" AND (C.DESG_MATRICULA = '' OR C.DESG_MATRICULA IS NULL)");

					if (mapPending.getEmpresa() != null) {
						strGetPersonaCertificadosIdiomasList.append(" AND A.CDGO_EMPRESA = " + mapPending.getEmpresa());
					}
				}

				if (mapPending.getPersonal().equals("AMBOS")) {
					strGetPersonaCertificadosIdiomasList
							.append(" AND ( (C.DESG_MATRICULA != '' AND C.DESG_MATRICULA IS NOT NULL)");
					if (mapPending.getEmpresa() != null) {
						strGetPersonaCertificadosIdiomasList.append(" OR A.CDGO_EMPRESA = " + mapPending.getEmpresa());
					}
					strGetPersonaCertificadosIdiomasList.append(" )");
				}
			}
		}

		strGetPersonaCertificadosIdiomasList
				.append(" GROUP BY C.CDGO_PERSONA, C.DESG_NIFPAS, C.DESG_NOMBRE, C.DESG_APELL1, C.DESG_APELL2,"
						+ " C.CDGO_PERSONA, C.DESG_MATRICULA, C.CDGO_AREACT, C.CDGO_ARETER, C.CDGO_CENTCONT, AA.DESG_NOMBRE, AT.DESG_NOMBRE,"
						+ "	CC.DESG_NOMBRE, E.DESG_NOMBRE, FC.CDGO_CATEGORIA, FC.CDGO_CUALIFICACION, CA.DESG_DESCRIPCION, CU.DESG_NOMBRE, FC.FCHA_EXPEDICION");

		System.out.println("----------------------");
		System.out.println(strGetPersonaCertificadosIdiomasList.toString());
		System.out.println("----------------------");

		Query sqlquery = em.createNativeQuery(strGetPersonaCertificadosIdiomasList.toString());

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetPersonaCertificadosIdiomasListDTO> resultadosDevueltos = new ArrayList<>();

		for (Object[] object : resultados) {
			GetPersonaCertificadosIdiomasListDTO data = new GetPersonaCertificadosIdiomasListDTO();
			if (object[0] != null) {
				data.setDesgNifpas(Util.quitarEspacios(object[0]));
			}
			if (object[1] != null) {
				data.setDesgPersona(Util.quitarEspacios(object[1]));
			}
			if (object[2] != null) {
				data.setDesgApell1(Util.quitarEspacios(object[2]));
			}
			if (object[3] != null) {
				data.setDesgApell2(Util.quitarEspacios(object[3]));
			}
			if (object[4] != null) {
				data.setCdgoPersona((Integer) object[4]);
			}
			if (object[5] != null) {
				data.setDesgMatricula(Util.quitarEspacios(object[5]));
			}
			if (object[6] != null) {
				data.setCdgoAreAct((Integer) object[6]);
			}
			if (object[7] != null) {
				data.setCdgoAreTerr((Integer) object[7]);
			}
			if (object[8] != null) {
				data.setCdgoCentroCont(Util.quitarEspacios(object[8]));
			}
			if (object[9] != null) {
				data.setDesgAreAct(Util.quitarEspacios(object[9]));
			}
			if (object[10] != null) {
				data.setDesgAreTerr(Util.quitarEspacios(object[10]));
			}
			if (object[11] != null) {
				data.setDesgCentroCont(Util.quitarEspacios(object[11]));
			}
			if (object[12] != null) {
				data.setDesgEmpresa(Util.quitarEspacios(object[12]));
			}
			if (object[13] != null) {
				data.setCdgoCategoria((Integer) object[13]);
			}
			if (object[14] != null) {
				data.setCdgoCualificacion((Integer) object[14]);
			}
			if (object[15] != null) {
				data.setDesgDescripcion(Util.quitarEspacios(object[15]));
			}
			if (object[16] != null) {
				data.setDesgNombre(Util.quitarEspacios(object[16]));
			}
			if (object[17] != null) {
				data.setFchaExpedicion((Date) object[17]);
			}

			resultadosDevueltos.add(data);

		}

		return resultadosDevueltos;

	}

	public List<Tbasg100Persona> getPersonaAllList(SetExpedientesPersonaListDTO filter) {
		StringBuilder strGetExpedientesPersonaListDTO = new StringBuilder();

		String sqlString = "SELECT DISTINCT "
				+ "			P.CDGO_PERSONA, P.DESG_NIFPAS, P.DESG_MATRICULA, P.DESG_NOMBRE, P.DESG_APELL1, P.DESG_APELL2, P.CDGO_TIPOVIA, "
				+ "			P.DESG_VIA, P.DESG_NUMVIA, P.DESG_PLANTA, P.DESG_PUERTA, P.DESG_ESCALERA, P.DESG_MUNICIPIO, "
				+ "			P.CDGO_PROVINCIA, P.CDGO_NACION, P.DESG_CODPOSTAL, P.FCHA_NACIMIENTO, P.CDGO_CARGO, P.CDGO_CENTCONT, "
				+ "			P.CDGO_AREACT, P.FCHA_CONTRATO, P.CDGO_ESTUDIO, P.DESG_ESTUDIEQUIV, P.DESG_CERTCASTELL, "
				+ "			P.MRCA_FORMADOR, P.DESG_USUACT, P.FCHA_ACT, P.MRCA_ACTIVO, P.FCHA_ANTIG_CARGO, P.DESG_LUGARNACIMIENTO,"
				+ "			P.CDGO_TIPODOC, P.CDGO_ARETER, A.DESG_NOMBRE AS DESC_AREA_ACT, P.DESG_EIN,P.DIAS_ILT "
				+ "		FROM " + "			PASG.TBASG100_PERSONA P"
				+ "			LEFT JOIN PASG.TBASG104_EXPEDIENT E ON P.CDGO_PERSONA = E.CDGO_PERSONA"
				+ "			LEFT JOIN PASG.TBASG118_ESTADOEXP S ON E.CDGO_EXPEDIENT = S.CDGO_EXPEDIENT"
				+ "			LEFT JOIN PASG.TBASG105_AREACTIVI A ON P.CDGO_AREACT = A.CDGO_AREACT"
				+ "			LEFT JOIN PASG.TBASG267_EXPED_ACRED F ON P.CDGO_PERSONA = F.CDGO_PERSONA"
				+ "			LEFT JOIN PASG.TBASG266_ESTADO_ACRE G ON F.CDGO_ACREDITA = G.CDGO_ACREDITA" + "			"
				+ "			LEFT JOIN PASG.TBASG261_SOCIEDADES T  ON T.CDGO_SOCIEDAD=E.CDGO_SOCIOTOR"
				+ "			WHERE 1=1 ";

		strGetExpedientesPersonaListDTO.append(sqlString);
		System.out.println("----------------------");
		System.out.println(strGetExpedientesPersonaListDTO.toString());
		System.out.println("----------------------");
		if (filter != null) {

			if (!"".equals(filter.getDesgNifpas()) && filter.getDesgNifpas() != null) {
				strGetExpedientesPersonaListDTO.append(" AND P.DESG_NIFPAS LIKE '%'||:nifPas||'%'");
			}

			if (!"".equals(filter.getDesgMatricula()) && filter.getDesgMatricula() != null) {
				strGetExpedientesPersonaListDTO.append(" AND P.DESG_MATRICULA LIKE '%'||:matricula||'%'");
			}

			if (!"".equals(filter.getDesgNombre()) && filter.getDesgNombre() != null) {
				strGetExpedientesPersonaListDTO.append(" AND P.DESG_NOMBRE LIKE '%'||:nombre||'%'");
			}

			if (!"".equals(filter.getDesgApell1()) && filter.getDesgApell1() != null) {
				strGetExpedientesPersonaListDTO.append(" AND P.DESG_APELL1 LIKE '%'||:apellido1||'%'");
			}

			if (!"".equals(filter.getDesgApell2()) && filter.getDesgApell2() != null) {
				strGetExpedientesPersonaListDTO.append(" AND P.DESG_APELL2 LIKE '%'||:apellido2||'%'");
			}
			/*
			 * Aqui faltarian las fechas
			 */

			if (filter.getCdgoAreact() != null) {
				strGetExpedientesPersonaListDTO.append(" AND P.CDGO_AREACT = :cdgoAreAct");
			}

			if (filter.getCdgoAreter() != null) {
				strGetExpedientesPersonaListDTO.append(" AND P.CDGO_ARETER = :cdgoAreTerr");
			}

			if (filter.getCdgoCentcont() != null) {
				strGetExpedientesPersonaListDTO.append(" AND P.CDGO_CENTCONT = :cdgoCentroCont");
			}

			if (!"".equals(filter.getMrcaActivo()) && filter.getMrcaActivo() != null) {
				strGetExpedientesPersonaListDTO.append(" AND P.MRCA_ACTIVO = 'N'");
			}

			if (!"".equals(filter.getMrcaActivo()) && filter.getMrcaActivo() == null) {
				strGetExpedientesPersonaListDTO.append(" AND P.MRCA_ACTIVO = 'S'");
			}

			if (filter.getCdgoEmpresa() != null) {

				if (filter.getCdgoTipoHab() == null) {
					if (filter.getCdgoEstadoHab() == null) {
						strGetExpedientesPersonaListDTO.append(" AND E.MRCA_ACTIVO = 'S'");
					}
				}
			}

			if (filter.getCdgoTipoHab() != null) {
				if (filter.getCdgoEstadoHab() == null) {
					strGetExpedientesPersonaListDTO.append(" AND E.MRCA_ACTIVO = 'S'");
				}
			}

			if (filter.getCdgoEstadoHab() != null) {
				strGetExpedientesPersonaListDTO.append(" AND E.MRCA_ACTIVO = 'S'");
			}

			if (filter.getPersonal() != null) {
				if ("RENFE".equals(filter.getPersonal())) {
					strGetExpedientesPersonaListDTO
							.append(" AND P.DESG_MATRICULA != '' AND P.DESG_MATRICULA IS NOT NULL");
				}
//				

				if ("AMBOS".equals(filter.getPersonal())) {

					if (filter.getCdgoEmpresa() != null && filter.getCdgoEmpresa().length != 0) {

						Integer array[] = filter.getCdgoEmpresa();
						strGetExpedientesPersonaListDTO.append(" AND E.CDGO_EMPRESA IN (" + array[0] + "");
						for (int i = 1; i < filter.getCdgoEmpresa().length; i++) {
							int cdgo = array[i];
							strGetExpedientesPersonaListDTO.append("," + cdgo + "");
						}

						strGetExpedientesPersonaListDTO
								.append(") OR P.DESG_MATRICULA != '' AND P.DESG_MATRICULA IS NOT NULL ");

					}
					if (filter.getCdgoEmpresa() != null && filter.getCdgoEmpresa().length == 0) {
						strGetExpedientesPersonaListDTO
								.append(" AND P.DESG_MATRICULA != '' AND P.DESG_MATRICULA IS NOT NULL");

					}
				}

				if ("EXT".equals(filter.getPersonal())) {
					strGetExpedientesPersonaListDTO.append(" AND (P.DESG_MATRICULA = '' OR P.DESG_MATRICULA IS NULL)");

					if (filter.getCdgoEmpresa() != null && filter.getCdgoEmpresa().length != 0) {

						Integer array[] = filter.getCdgoEmpresa();
						strGetExpedientesPersonaListDTO.append(" AND E.CDGO_EMPRESA IN (" + array[0] + "");
						for (int i = 1; i < filter.getCdgoEmpresa().length; i++) {
							int cdgo = array[i];
							strGetExpedientesPersonaListDTO.append("," + cdgo + "");
						}
						strGetExpedientesPersonaListDTO.append(")");
					}
				}
			}

			if (filter.getCdgoTipoHab() != null) {
				strGetExpedientesPersonaListDTO.append(" AND E.CDGO_TIPOHAB = :cdgoTipoHab");
			}

			if (filter.getCdgoTipoAcre() != null) {
				strGetExpedientesPersonaListDTO.append(" AND F.CDGO_ACREDITA = :cdgoTipoAcre");
			}

			if (filter.getCdgoEstadoHab() != null) {
				strGetExpedientesPersonaListDTO.append(" AND S.CDGO_ESTADO = :cdgoEstHab  \n"
						+ "							AND S.FCHA_ESTADO = (SELECT MAX(FCHA_ESTADO) AS FCHA_ESTADO\n"
						+ "							                      FROM PASG.TBASG118_ESTADOEXP\n"
						+ "							                      WHERE S.CDGO_EXPEDIENT = CDGO_EXPEDIENT AND MRCA_ACTIVO = 'S')");
			}

			if (filter.getCdgoEstadoAcre() != null) {
				strGetExpedientesPersonaListDTO.append(" AND G.CDGO_ESTADO = :cdgoEstAcre  \n"
						+ "									  AND G.FCHA_ESTADO = (SELECT MAX(FCHA_ESTADO) AS FCHA_ESTADO\n"
						+ "				                      FROM PASG.TBASG266_ESTADO_ACRE\n"
						+ "				                      WHERE G.CDGO_ACREDITA = CDGO_ACREDITA AND MRCA_ACTIVO = 'S')");
			}

		}
		//strGetExpedientesPersonaListDTO.append(" FETCH FIRST 50 ROWS ONLY");
		System.out.println("----------------------");
		System.out.println(strGetExpedientesPersonaListDTO.toString());
		System.out.println("----------------------");

		Query sqlquery = em.createNativeQuery(strGetExpedientesPersonaListDTO.toString());

		if (filter != null) {

			if (!"".equals(filter.getDesgNifpas()) && filter.getDesgNifpas() != null) {
				sqlquery.setParameter("nifPas", filter.getDesgNifpas());
			}

			if (!"".equals(filter.getDesgMatricula()) && filter.getDesgMatricula() != null) {
				sqlquery.setParameter("matricula", filter.getDesgMatricula());
			}

			if (!"".equals(filter.getDesgNombre()) && filter.getDesgNombre() != null) {
				sqlquery.setParameter("nombre", filter.getDesgNombre());
			}

			if (!"".equals(filter.getDesgApell1()) && filter.getDesgApell1() != null) {
				sqlquery.setParameter("apellido1", filter.getDesgApell1());
			}

			if (!"".equals(filter.getDesgApell2()) && filter.getDesgApell2() != null) {
				sqlquery.setParameter("apellido2", filter.getDesgApell2());
			}

			if (filter.getCdgoAreact() != null) {
				sqlquery.setParameter("cdgoAreAct", filter.getCdgoAreact());
			}

			if (filter.getCdgoAreter() != null) {
				sqlquery.setParameter("cdgoAreTerr", filter.getCdgoAreter());
			}

			if (filter.getCdgoCentcont() != null) {
				sqlquery.setParameter("cdgoCentroCont", filter.getCdgoCentcont());
			}

			if (filter.getCdgoTipoHab() != null) {
				sqlquery.setParameter("cdgoTipoHab", filter.getCdgoTipoHab());
			}

			if (filter.getCdgoEstadoHab() != null) {
				sqlquery.setParameter("cdgoEstHab", filter.getCdgoEstadoHab());
			}

			if (filter.getCdgoTipoAcre() != null) {
				sqlquery.setParameter("cdgoTipoAcre", filter.getCdgoTipoAcre());
			}

			if (filter.getCdgoEstadoAcre() != null) {
				sqlquery.setParameter("cdgoEstAcre", filter.getCdgoEstadoAcre());
			}

		}
		System.out.println("Quey Final-----------" + strGetExpedientesPersonaListDTO.toString());
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg100Persona> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg100Persona persona = new Tbasg100Persona();

			persona.setCdgoPersona(Integer.valueOf((int) object[0]));
			persona.setDesgNifpas(Util.quitarEspacios(object[1]));
			persona.setDesgNombre(Util.quitarEspacios(object[3]));
			persona.setDesgApell1(Util.quitarEspacios(object[4]));
			persona.setDesgApell2(Util.quitarEspacios(object[5]));
			persona.setDesgMatricula(Util.quitarEspacios(object[2]));
			persona.setFchaNacimiento((Date) object[16]);
			persona.setCdgoAreact((Integer) object[19]);
			// persona.setCdgoAreter((Integer) object[31]);
			// persona.setDescAreaAct((String) object[32]);

			resultadosDevueltos.add(persona);
		}
		System.out.println("Resultados devueltos:\n" + resultadosDevueltos.toString());
		return resultadosDevueltos;

	}

	public List<Tbasg100Persona> getPersonaBySociedadesList() {

		String sqlString = "SELECT DISTINCT "
				+ "			P.CDGO_PERSONA, P.DESG_NIFPAS, P.DESG_MATRICULA, P.DESG_NOMBRE, P.DESG_APELL1, P.DESG_APELL2, P.CDGO_TIPOVIA, "
				+ "			P.DESG_VIA, P.DESG_NUMVIA, P.DESG_PLANTA, P.DESG_PUERTA, P.DESG_ESCALERA, P.DESG_MUNICIPIO, "
				+ "			P.CDGO_PROVINCIA, P.CDGO_NACION, P.DESG_CODPOSTAL, P.FCHA_NACIMIENTO, P.CDGO_CARGO, P.CDGO_CENTCONT, "
				+ "			P.CDGO_AREACT, P.FCHA_CONTRATO, P.CDGO_ESTUDIO, P.DESG_ESTUDIEQUIV, P.DESG_CERTCASTELL, "
				+ "			P.MRCA_FORMADOR, P.DESG_USUACT, P.FCHA_ACT, P.MRCA_ACTIVO, P.FCHA_ANTIG_CARGO, P.DESG_LUGARNACIMIENTO,"
				+ "			P.CDGO_TIPODOC, P.CDGO_ARETER, A.DESG_NOMBRE AS DESC_AREA_ACT" + "		FROM "
				+ "			PASG.TBASG100_PERSONA P"
				+ "			LEFT JOIN PASG.TBASG104_EXPEDIENT E ON P.CDGO_PERSONA = E.CDGO_PERSONA"
				+ "			LEFT JOIN PASG.TBASG118_ESTADOEXP S ON E.CDGO_EXPEDIENT = S.CDGO_EXPEDIENT"
				+ "			LEFT JOIN PASG.TBASG105_AREACTIVI A ON P.CDGO_AREACT = A.CDGO_AREACT";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg100Persona.class);

		return sqlquery.getResultList();
	}
	


	public List<Tbasg100Persona> findPersonaByNifPas(String desgNifpas) {
		Util util = new Util();

		String sqlString = "SELECT * FROM PASG.TBASG100_PERSONA WHERE DESG_NIFPAS = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", desgNifpas);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg100Persona> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg100Persona persona = new Tbasg100Persona();

			persona.setCdgoPersona((Integer) object[0]);
			persona.setDesgNifpas(Util.quitarEspacios(object[1]));
			persona.setDesgMatricula(Util.quitarEspacios(object[2]));
			persona.setDesgNombre(Util.quitarEspacios(object[3]));
			persona.setDesgApell1(Util.quitarEspacios(object[4]));
			persona.setDesgApell2(Util.quitarEspacios(object[5]));
			persona.setCdgoTipovia((Integer) object[6]);
			persona.setDesgVia(Util.quitarEspacios(object[7]));
			persona.setDesgNumvia(Util.quitarEspacios(object[8]));
			persona.setDesgPlanta(Util.quitarEspacios(object[9]));
			persona.setDesgPuerta(Util.quitarEspacios(object[10]));
			persona.setDesgEscalera(Util.quitarEspacios(object[11]));
			persona.setDesgMunicipio(Util.quitarEspacios(object[12]));
			persona.setCdgoProvincia((Integer) object[13]);
			persona.setCdgoNacion((Integer) object[14]);
			persona.setDesgCodpostal(Util.quitarEspacios(object[15]));
			persona.setFchaNacimiento((java.sql.Date) object[16]);
			persona.setCdgoCargo(Util.quitarEspacios(object[17]));
			persona.setCdgoCentcontDesuso((Integer) object[18]);
			persona.setCdgoAreact((Integer) object[19]);
			persona.setFchaContrato((java.sql.Date) object[20]);
			persona.setCdgoEstudio((Integer) object[21]);
			persona.setDesgEstudiequiv(Util.quitarEspacios(object[22]));
			persona.setDesgCertcastell(Util.quitarEspacios(object[23]));
			persona.setMrcaFormador(String.valueOf((Character) object[24]));
			persona.setDesgUsuact(Util.quitarEspacios(object[25]));
			persona.setFchaAct((java.sql.Date) object[26]);
			persona.setMrcaActivo(String.valueOf((Character) object[27]));
			persona.setCdgoTipodoc((Integer) object[28]);
			persona.setCdgoAreter((Integer) object[29]);
			persona.setFchaAntigCargo((java.sql.Date) object[30]);
			persona.setDesgLugarnacimiento(Util.quitarEspacios(object[31]));
			persona.setCdgoCentcont(Util.quitarEspacios(object[32]));
			persona.setMrcaExaminador(String.valueOf((Character) object[33]));
			persona.setDiasIlt((Integer) object[34]);
			persona.setDesgEin(Util.quitarEspacios(object[35]));
			persona.setDescAreaAct(Util.quitarEspacios(object[36]));

			resultadosDevueltos.add(persona);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg100Persona> findPersonaByMatricula(String desgMatricula) {

		String sqlString = "SELECT * FROM PASG.TBASG100_PERSONA WHERE DESG_MATRICULA = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", desgMatricula);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg100Persona> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg100Persona persona = new Tbasg100Persona();

			persona.setCdgoPersona((Integer) object[0]);
			persona.setDesgNifpas(Util.quitarEspacios(object[1]));
			persona.setDesgMatricula(Util.quitarEspacios(object[2]));
			persona.setDesgNombre(Util.quitarEspacios(object[3]));
			persona.setDesgApell1(Util.quitarEspacios(object[4]));
			persona.setDesgApell2(Util.quitarEspacios(object[5]));
			persona.setCdgoTipovia((Integer) object[6]);
			persona.setDesgVia(Util.quitarEspacios(object[7]));
			persona.setDesgNumvia(Util.quitarEspacios(object[8]));
			persona.setDesgPlanta(Util.quitarEspacios(object[9]));
			persona.setDesgPuerta(Util.quitarEspacios(object[10]));
			persona.setDesgEscalera(Util.quitarEspacios(object[11]));
			persona.setDesgMunicipio(Util.quitarEspacios(object[12]));
			persona.setCdgoProvincia((Integer) object[13]);
			persona.setCdgoNacion((Integer) object[14]);
			persona.setDesgCodpostal(Util.quitarEspacios(object[15]));
			persona.setFchaNacimiento((java.sql.Date) object[16]);
			persona.setCdgoCargo(Util.quitarEspacios(object[17]));
			persona.setCdgoCentcontDesuso((Integer) object[18]);
			persona.setCdgoAreact((Integer) object[19]);
			persona.setFchaContrato((java.sql.Date) object[20]);
			persona.setCdgoEstudio((Integer) object[21]);
			persona.setDesgEstudiequiv(Util.quitarEspacios(object[22]));
			persona.setDesgCertcastell(Util.quitarEspacios(object[23]));
			persona.setMrcaFormador(String.valueOf((Character) object[24]));
			persona.setDesgUsuact(Util.quitarEspacios(object[25]));
			persona.setFchaAct((java.sql.Date) object[26]);
			persona.setMrcaActivo(String.valueOf((Character) object[27]));
			persona.setCdgoTipodoc((Integer) object[28]);
			persona.setCdgoAreter((Integer) object[29]);
			persona.setFchaAntigCargo((java.sql.Date) object[30]);
			persona.setDesgLugarnacimiento(Util.quitarEspacios(object[31]));
			persona.setCdgoCentcont(Util.quitarEspacios(object[32]));
			persona.setMrcaExaminador(String.valueOf((Character) object[33]));
			persona.setDiasIlt((Integer) object[34]);
			persona.setDesgEin(Util.quitarEspacios(object[35]));
			persona.setDescAreaAct(Util.quitarEspacios(object[36]));

			resultadosDevueltos.add(persona);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg100Persona> getPersona(String cdgoPersona) {

		String sqlString = "SELECT P.*, A.DESG_NOMBRE AS DESC_AREA_AC, I.MRCA_INSTRUCTOR AS IS_TRAINER, I.MRCA_EXAMINADOR AS IS_EXAMINER "
				+ " FROM PASG.TBASG100_PERSONA P "
				+ " INNER JOIN PASG.TBASG105_AREACTIVI A ON P.CDGO_AREACT = A.CDGO_AREACT "
				+ " LEFT JOIN PASG.TBASG122_INSTRU I ON I.CDGO_NIF = P.DESG_NIFPAS " + " WHERE P.CDGO_PERSONA = :value";

		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg100Persona> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg100Persona persona = new Tbasg100Persona();
			persona.setCdgoPersona((Integer) object[0]);
			persona.setDesgNifpas(((String) object[1]).trim());
			//persona.setDesgMatricula(((String) object[2]).trim());
			persona.setDesgMatricula(Util.quitarEspacios(object[2]));
			persona.setDesgNombre(Util.quitarEspacios(object[3]));
			persona.setDesgApell1(Util.quitarEspacios(object[4]));
			persona.setDesgApell2(Util.quitarEspacios(object[5]));
			persona.setCdgoTipovia((Integer) object[6]);
			persona.setDesgVia(Util.quitarEspacios(object[7]));
			persona.setDesgNumvia(Util.quitarEspacios(object[8]));
			persona.setDesgPlanta(Util.quitarEspacios(object[9]));
			persona.setDesgPuerta(Util.quitarEspacios(object[10]));
			persona.setDesgEscalera(Util.quitarEspacios(object[11]));
			persona.setDesgMunicipio(Util.quitarEspacios(object[12]));
			persona.setCdgoProvincia((Integer) object[13]);
			persona.setCdgoNacion((Integer) object[14]);
			persona.setDesgCodpostal(Util.quitarEspacios(object[15]));
			persona.setFchaNacimiento((java.sql.Date) object[16]);
			persona.setCdgoCargo(Util.quitarEspacios(object[17]));
			persona.setCdgoCentcontDesuso((Integer) object[18]);
			persona.setCdgoAreact((Integer) object[19]);
			persona.setFchaContrato((java.sql.Date) object[20]);
			persona.setCdgoEstudio((Integer) object[21]);
			persona.setDesgEstudiequiv(Util.quitarEspacios(object[22]));
			persona.setDesgCertcastell(Util.quitarEspacios(object[23]));
			persona.setMrcaFormador(String.valueOf((Character) object[38]));
			persona.setDesgUsuact(Util.quitarEspacios(object[25]));
			persona.setFchaAct((java.sql.Date) object[26]);
			persona.setMrcaActivo(String.valueOf((Character) object[27]));
			persona.setCdgoTipodoc((Integer) object[28]);
			persona.setCdgoAreter((Integer) object[29]);
			persona.setFchaAntigCargo((java.sql.Date) object[30]);
			persona.setDesgLugarnacimiento(Util.quitarEspacios(object[31]));
			persona.setCdgoCentcont(Util.quitarEspacios(object[32]));
			persona.setMrcaExaminador(String.valueOf((Character) object[39]));
			persona.setDiasIlt((Integer) object[34]);
			persona.setDesgEin(Util.quitarEspacios(object[35]));
			persona.setDescAreaAct(Util.quitarEspacios(object[36]));
			// persona.setDesgCodpostal((String)object[37]);

			resultadosDevueltos.add(persona);
		}

		return resultadosDevueltos;
	}

	public List<Tbasg100Persona> getPersonaByMatricula(String idMatricula) {

		String sqlString = "SELECT p.*, A.DESG_NOMBRE AS DESC_AREA_AC FROM PASG.TBASG100_PERSONA p, PASG.TBASG105_AREACTIVI A "
				+ "			WHERE p.CDGO_AREACT = A.CDGO_AREACT AND p.DESG_MATRICULA = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", idMatricula);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg100Persona> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg100Persona persona = new Tbasg100Persona();
			// logger.info("object0 {}, object1 {}, object2 {} ",object[0], object[19],
			// object[29]);

			persona.setCdgoPersona((Integer) object[0]);
			persona.setDesgNifpas(Util.quitarEspacios(object[1]));
			persona.setDesgMatricula(Util.quitarEspacios(object[2]));
			persona.setDesgNombre(Util.quitarEspacios(object[3]));
			persona.setDesgApell1(Util.quitarEspacios(object[4]));
			persona.setDesgApell2(Util.quitarEspacios(object[5]));
			persona.setCdgoTipovia((Integer) object[6]);
			persona.setDesgVia(Util.quitarEspacios(object[7]));
			persona.setDesgNumvia(Util.quitarEspacios(object[8]));
			persona.setDesgPlanta(Util.quitarEspacios(object[9]));
			persona.setDesgPuerta(Util.quitarEspacios(object[10]));
			persona.setDesgEscalera(Util.quitarEspacios(object[11]));
			persona.setDesgMunicipio(Util.quitarEspacios(object[12]));
			persona.setCdgoProvincia((Integer) object[13]);
			persona.setCdgoNacion((Integer) object[14]);
			persona.setDesgCodpostal(Util.quitarEspacios(object[15]));
			persona.setFchaNacimiento((java.sql.Date) object[16]);
			persona.setCdgoCargo(Util.quitarEspacios(object[17]));
			persona.setCdgoCentcontDesuso((Integer) object[18]);
			persona.setCdgoAreact((Integer) object[19]);
			persona.setFchaContrato((java.sql.Date) object[20]);
			persona.setCdgoEstudio((Integer) object[21]);
			persona.setDesgEstudiequiv(Util.quitarEspacios(object[22]));
			persona.setDesgCertcastell(Util.quitarEspacios(object[23]));
			persona.setMrcaFormador(String.valueOf((Character) object[24]));
			persona.setDesgUsuact(Util.quitarEspacios(object[25]));
			persona.setFchaAct((java.sql.Date) object[26]);
			persona.setMrcaActivo(String.valueOf((Character) object[27]));
			persona.setCdgoTipodoc((Integer) object[28]);
			persona.setCdgoAreter((Integer) object[29]);
			persona.setFchaAntigCargo((java.sql.Date) object[30]);
			persona.setDesgLugarnacimiento(Util.quitarEspacios(object[31]));
			persona.setCdgoCentcont(Util.quitarEspacios(object[32]));
			persona.setMrcaExaminador(String.valueOf((Character) object[33]));

			persona.setDiasIlt((Integer) object[34]);
			persona.setDesgEin(Util.quitarEspacios(object[35]));
			persona.setDescAreaAct(Util.quitarEspacios(object[36]));
			persona.setDesgCodpostal(Util.quitarEspacios(object[37]));

			resultadosDevueltos.add(persona);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg100Persona> geCdgoPersona(String desgNifpas) {

		String sqlString = "SELECT CDGO_PERSONA FROM PASG.TBASG100_PERSONA WHERE DESG_NIFPAS = :nifPas";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("nifPas", desgNifpas);
		List<Object> resultados = sqlquery.getResultList();
		List<Tbasg100Persona> resultadosDevueltos = new ArrayList<Tbasg100Persona>();
		for (Object object : resultados) {
			Tbasg100Persona miClase = new Tbasg100Persona();
			miClase.setCdgoPersona((int) object);
			resultadosDevueltos.add(miClase);
		}
		return resultadosDevueltos;

	}

	public List<Tbasg100Persona> getDiasILT(String cdgoPersona) {

		String sqlString = "SELECT DIAS_ILT FROM PASG.TBASG100_PERSONA WHERE CDGO_PERSONA = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", Long.valueOf(cdgoPersona));
		List<Object> resultados = sqlquery.getResultList();
		List<Tbasg100Persona> resultadosDevueltos = new ArrayList<Tbasg100Persona>();
		for (Object object : resultados) {
			Tbasg100Persona persona = new Tbasg100Persona();
			persona.setDiasIlt((Integer) object);

			resultadosDevueltos.add(persona);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg100Persona> getCdgoPersonaMatricula(String desgMatricula) {

		String sqlString = "SELECT CDGO_PERSONA FROM PASG.TBASG100_PERSONA WHERE DESG_MATRICULA = :matricula";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("matricula", desgMatricula);
		List<Object> resultados = sqlquery.getResultList();
		List<Tbasg100Persona> resultadosDevueltos = new ArrayList<Tbasg100Persona>();
		for (Object object : resultados) {
			Tbasg100Persona persona = new Tbasg100Persona();

			persona.setCdgoPersona((Integer) object);

			resultadosDevueltos.add(persona);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg100Persona> existePersonaDNI(String desgNifpas) {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG100_PERSONA WHERE DESG_NIFPAS = :nifPas AND MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg100Persona.class);
		sqlquery.setParameter("nifPas", desgNifpas);
		return sqlquery.getResultList();
	}

	public List<Tbasg100Persona> existePersonaRENFEDNI(String desgNifpas) {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG100_PERSONA WHERE DESG_NIFPAS = :nifPas AND MRCA_ACTIVO = 'S' AND DESG_MATRICULA IS NOT NULL;";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg100Persona.class);
		sqlquery.setParameter("nifPas", desgNifpas);
		return sqlquery.getResultList();
	}

	public List<GetFindPersonaAltasBajasDTO> findPersonaAltas(List<Integer> codigos, String fecDesde, String fecHasta) {

		StringBuilder strListCodigos = new StringBuilder();

		String sqlString = "SELECT DISTINCT(P.DESG_NIFPAS),DOC.DESG_NOMBRE AS DESC_TIPODOC,"
				+ "			'Alta' AS ACTIVO," + "	       	S.FCHA_ALTA AS FECHA,"
				+ "	       	TIT.DESG_TIPTIT AS TITULO, E.DESG_CIF AS NIF_EMPRESA,"
				+ "	       	S.CDGO_SOCIEDAD AS CDGO_SOCIEDAD" + "		FROM PASG.TBASG100_PERSONA P ,"
				+ "		PASG.TBASG258_SOC_PERSONA S," + "		PASG.TBASG150_TIPODOC DOC,"
				+ "		PASG.TBASG102_TITULOCON TIT, " + "		PASG.TBASG125_EMPRESA E,"
				+ "		PASG.TBASG268_HCO_CARGOS CG"
				+ "		INNER JOIN PASG.TBASG261_SOCIEDADES SOC ON SOC.CDGO_SOCIEDAD = S.CDGO_SOCIEDAD" + " WHERE"
				+ " P.CDGO_TIPODOC = DOC.CDGO_TIPODOC" + " AND P.CDGO_PERSONA = S.CDGO_PERSONA"
				+ " AND P.CDGO_PERSONA = CG.CDGO_PERSONA" + " AND TIT.CDGO_PERSONA = P.CDGO_PERSONA"
				+ " AND P.MRCA_ACTIVO = 'S'" + " AND E.CDGO_EMPRESA = 1"
				+ " AND ((S.FCHA_ALTA >= CG.FCHA_INICIO AND S.FCHA_ALTA <= CG.FCHA_FIN) OR (S.FCHA_ALTA >= CG.FCHA_INICIO AND CG.FCHA_FIN IS NULL))"
				+ " AND S.FCHA_ALTA >= :fecDesde" + " AND S.FCHA_ALTA <= :fecHasta"
				+ " AND CG.CDGO_CARGO not in ('K9B')";

		strListCodigos.append(sqlString);

		if (codigos != null) {
			strListCodigos.append(" AND S.CDGO_SOCIEDAD IN (" + codigos.get(0));
			for (int i = 1; i < codigos.size(); i++) {
				strListCodigos.append("," + codigos.get(i));
			}
			strListCodigos.append(")" + "	ORDER BY S.FCHA_ALTA");
		}
		Query sqlquery = em.createNativeQuery(strListCodigos.toString());
		sqlquery.setParameter("fecDesde", fecDesde);
		sqlquery.setParameter("fecHasta", fecHasta);
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetFindPersonaAltasBajasDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetFindPersonaAltasBajasDTO persona = new GetFindPersonaAltasBajasDTO();

			persona.setDesgNifpas(Util.quitarEspacios(object[0]));
			persona.setDescTipodoc(Util.quitarEspacios(object[1]));
			persona.setActivo(Util.quitarEspacios(object[2]));
			persona.setFecha((Date) object[3]);
			persona.setTitulo(Util.quitarEspacios(object[4]));
			persona.setNifEmpresa(Util.quitarEspacios(object[5]));
			persona.setCdgoSociedad(Util.quitarEspacios(object[6]));

			resultadosDevueltos.add(persona);
		}
		return resultadosDevueltos;
	}

	public List<GetFindPersonaAltasBajasDTO> findPersonaBajas(List<Integer> codigos, String fecDesde, String fecHasta) {

		StringBuilder strListCodigos = new StringBuilder();

		String sqlString = "SELECT DISTINCT(P.DESG_NIFPAS),DOC.DESG_NOMBRE AS DESC_TIPODOC,"
				+ "			'Baja' AS ACTIVO," + "	       	S.FCHA_BAJA AS FECHA,"
				+ "	       	TIT.DESG_TIPTIT AS TITULO, E.DESG_CIF AS NIF_EMPRESA,"
				+ "	       	S.CDGO_SOCIEDAD AS CDGO_SOCIEDAD" + "		FROM PASG.TBASG100_PERSONA P ,"
				+ "		PASG.TBASG258_SOC_PERSONA S," + "		PASG.TBASG150_TIPODOC DOC,"
				+ "		PASG.TBASG102_TITULOCON TIT, " + "		PASG.TBASG125_EMPRESA E,"
				+ "		PASG.TBASG268_HCO_CARGOS CG"
				+ "		INNER JOIN PASG.TBASG261_SOCIEDADES SOC ON SOC.CDGO_SOCIEDAD = S.CDGO_SOCIEDAD" + " WHERE"
				+ " P.CDGO_TIPODOC = DOC.CDGO_TIPODOC" + " AND P.CDGO_PERSONA = S.CDGO_PERSONA"
				+ " AND P.CDGO_PERSONA = CG.CDGO_PERSONA" + " AND TIT.CDGO_PERSONA = P.CDGO_PERSONA"
				+ " AND P.MRCA_ACTIVO = 'S'" + " AND E.CDGO_EMPRESA = 1"
				+ " AND ((S.FCHA_BAJA >= CG.FCHA_INICIO AND S.FCHA_BAJA <= CG.FCHA_FIN) OR (S.FCHA_BAJA >= CG.FCHA_INICIO AND CG.FCHA_FIN IS NULL))"
				+ " AND S.FCHA_BAJA >= :fecDesde" + " AND S.FCHA_BAJA <= :fecHasta"
				+ " AND CG.CDGO_CARGO not in ('K9B')";

		strListCodigos.append(sqlString);

		if (codigos != null) {
			strListCodigos.append(" AND S.CDGO_SOCIEDAD IN (" + codigos.get(0));
			for (int i = 1; i < codigos.size(); i++) {
				strListCodigos.append("," + codigos.get(i));
			}
			strListCodigos.append(")" + "	ORDER BY S.FCHA_BAJA");
		}
		Query sqlquery = em.createNativeQuery(strListCodigos.toString());
		sqlquery.setParameter("fecDesde", fecDesde);
		sqlquery.setParameter("fecHasta", fecHasta);
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetFindPersonaAltasBajasDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetFindPersonaAltasBajasDTO persona = new GetFindPersonaAltasBajasDTO();

			persona.setDesgNifpas(Util.quitarEspacios(object[0]));
			persona.setDescTipodoc(Util.quitarEspacios(object[1]));
			persona.setActivo(Util.quitarEspacios(object[2]));
			persona.setFecha((Date) object[3]);
			persona.setTitulo(Util.quitarEspacios(object[4]));
			persona.setNifEmpresa(Util.quitarEspacios(object[5]));
			persona.setCdgoSociedad(Util.quitarEspacios(object[6]));

			resultadosDevueltos.add(persona);
		}
		return resultadosDevueltos;
	}

	public List<GetDatosPersonaAcreditaDTO> getDatosPersonaAcredita(Integer cdgoPersona) {

		String sqlString = "SELECT PER.DESG_NOMBRE,PER.DESG_APELL1,PER.DESG_APELL2,PER.DESG_NIFPAS,NAC.DESG_NOMBRE AS NACIONAL,S.DESC_SOCIEDAD"
				+ "        FROM PASG.TBASG100_PERSONA PER"
				+ "	    INNER JOIN PASG.TBASG105_AREACTIVI AREA  ON AREA.CDGO_AREACT = PER.CDGO_AREACT"
				+ "	    INNER JOIN PASG.TBASG134_NACION NAC ON PER.CDGO_NACION = NAC.CDGO_NACION"
				+ "            INNER JOIN PASG.TBASG261_SOCIEDADES S ON AREA.CDGO_SOCIEDAD = S.CDGO_SOCIEDAD"
				+ "		WHERE PER.CDGO_PERSONA = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetDatosPersonaAcreditaDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetDatosPersonaAcreditaDTO personaAcredita = new GetDatosPersonaAcreditaDTO();

			personaAcredita.setDesgNombre(Util.quitarEspacios(object[0]));
			personaAcredita.setDesgApell1(Util.quitarEspacios(object[1]));
			personaAcredita.setDesgApell2(Util.quitarEspacios(object[2]));
			personaAcredita.setDesgNifPas(Util.quitarEspacios(object[3]));
			personaAcredita.setNacional(Util.quitarEspacios(object[4]));
			personaAcredita.setDescSociedad(Util.quitarEspacios(object[5]));

			resultadosDevueltos.add(personaAcredita);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg100Persona> getPersonaFormador(String desgNifpas) {

		String sqlString = "SELECT CDGO_PERSONA,DESG_NIFPAS,DESG_NOMBRE,DESG_APELL1,DESG_APELL2,MRCA_FORMADOR,MRCA_EXAMINADOR,MRCA_ACTIVO "
				+ "		FROM PASG.TBASG100_PERSONA WHERE DESG_NIFPAS = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg100Persona.class);
		sqlquery.setParameter("value", desgNifpas);
		return sqlquery.getResultList();
	}

	public List<Tbasg100Persona> getDni(String desgMatricula) {

		String sqlString = "SELECT DESG_NIFPAS FROM PASG.TBASG100_PERSONA WHERE DESG_MATRICULA = :matricula";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("matricula", desgMatricula);
		List<Object> resultados = sqlquery.getResultList();
		List<Tbasg100Persona> resultadosDevueltos = new ArrayList<Tbasg100Persona>();
		for (Object object : resultados) {
			Tbasg100Persona persona = new Tbasg100Persona();

			persona.setDesgNifpas(Util.quitarEspacios(object));

			resultadosDevueltos.add(persona);
		}
		return resultadosDevueltos;
	}

	public int insertPersona(Tbasg100Persona bean) {

		String sqlString = "INSERT INTO PASG.TBASG100_PERSONA (DESG_NIFPAS, DESG_MATRICULA, DESG_NOMBRE, DESG_APELL1, "
				+ "		DESG_APELL2, CDGO_TIPOVIA, DESG_VIA, DESG_NUMVIA, DESG_PLANTA, DESG_PUERTA, DESG_ESCALERA, "
				+ "		DESG_MUNICIPIO,  CDGO_PROVINCIA, CDGO_NACION, DESG_CODPOSTAL, FCHA_NACIMIENTO, CDGO_CARGO, "
				+ "		CDGO_CENTCONT, CDGO_AREACT, FCHA_CONTRATO, CDGO_ESTUDIO, DESG_ESTUDIEQUIV, DESG_CERTCASTELL, "
				+ "		MRCA_FORMADOR, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO, CDGO_TIPODOC, MRCA_EXAMINADOR)"
				+ "		VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,	?, CURRENT_DATE, ?, ?, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg100Persona.class);
		sqlquery.setParameter(1, bean.getDesgNifpas());
		sqlquery.setParameter(2, bean.getDesgMatricula());
		sqlquery.setParameter(3, bean.getDesgNombre());
		sqlquery.setParameter(4, bean.getDesgApell1());
		sqlquery.setParameter(5, bean.getDesgApell2());
		sqlquery.setParameter(6, bean.getCdgoTipovia());
		sqlquery.setParameter(7, bean.getDesgVia());
		sqlquery.setParameter(8, bean.getDesgNumvia());
		sqlquery.setParameter(9, bean.getDesgPlanta());
		sqlquery.setParameter(10, bean.getDesgPuerta());
		sqlquery.setParameter(11, bean.getDesgEscalera());
		sqlquery.setParameter(12, bean.getDesgMunicipio());
		sqlquery.setParameter(13, bean.getCdgoProvincia());
		sqlquery.setParameter(14, bean.getCdgoNacion());
		sqlquery.setParameter(15, bean.getDesgCodpostal());
		sqlquery.setParameter(16, bean.getFchaNacimiento());
		sqlquery.setParameter(17, bean.getCdgoCargo());
		sqlquery.setParameter(18, bean.getCdgoCentcont());
		sqlquery.setParameter(19, bean.getCdgoAreact());
		sqlquery.setParameter(20, bean.getFchaContrato());
		sqlquery.setParameter(21, bean.getCdgoEstudio());
		sqlquery.setParameter(22, bean.getDesgEstudiequiv());
		sqlquery.setParameter(23, bean.getDesgCertcastell());
		sqlquery.setParameter(24, bean.getMrcaFormador());
		sqlquery.setParameter(25, bean.getDesgUsuact());
		sqlquery.setParameter(26, bean.getMrcaActivo());
		sqlquery.setParameter(27, bean.getCdgoTipodoc());
		sqlquery.setParameter(28, bean.getMrcaExaminador());
		
		return sqlquery.executeUpdate();
	}

	@Transactional
	public int updatePersonalAct(Tbasg100Persona bean) {

		String sqlString = "UPDATE PASG.TBASG100_PERSONA SET" + "			DESG_NIFPAS = ?, "
				+ "			DESG_MATRICULA = ?, " + "			DESG_NOMBRE = ?, " + "			DESG_APELL1 = ?, "
				+ "			DESG_APELL2 = ?, " + "			CDGO_TIPOVIA = ?," + "			DESG_VIA = ?, "
				+ "			DESG_NUMVIA = ?, " + "			DESG_PLANTA = ?, " + "			DESG_PUERTA = ?, "
				+ "			DESG_ESCALERA = ?, " + "			DESG_MUNICIPIO = ?, "
				+ "			CDGO_PROVINCIA = ?, " + "" + "" + "			DESG_CODPOSTAL = ?, "
				+ "			FCHA_NACIMIENTO = ?, " + "			CDGO_CARGO = ?, " + "			CDGO_CENTCONT = ?,"
				+ "			CDGO_AREACT = ?, " + "			FCHA_CONTRATO = ?, " + "" + "" + "" + ""
				+ "			MRCA_FORMADOR = ?,    " + "			DESG_USUACT = ?, "
				+ "			FCHA_ACT = CURRENT_DATE," + "			MRCA_ACTIVO = ?, " + "			CDGO_TIPODOC = ?"
				+ "		WHERE CDGO_PERSONA = ?";

		Query sqlquery = em.createNativeQuery(sqlString, Tbasg100Persona.class);
		sqlquery.setParameter(1, bean.getDesgNifpas().trim());
		sqlquery.setParameter(2, bean.getDesgMatricula().trim());
		sqlquery.setParameter(3, bean.getDesgNombre().trim());
		sqlquery.setParameter(4, bean.getDesgApell1().trim());
		sqlquery.setParameter(5, bean.getDesgApell2());
		sqlquery.setParameter(6, bean.getCdgoTipovia());
		sqlquery.setParameter(7, bean.getDesgVia());
		sqlquery.setParameter(8, bean.getDesgNumvia());
		sqlquery.setParameter(9, bean.getDesgPlanta());
		sqlquery.setParameter(10, bean.getDesgPuerta());
		sqlquery.setParameter(11, bean.getDesgEscalera());
		sqlquery.setParameter(12, bean.getDesgMunicipio());
		sqlquery.setParameter(13, bean.getCdgoProvincia());
		sqlquery.setParameter(14, bean.getDesgCodpostal());
		sqlquery.setParameter(15, bean.getFchaNacimiento());
		sqlquery.setParameter(16, bean.getCdgoCargo());
		sqlquery.setParameter(17, bean.getCdgoCentcont());
		sqlquery.setParameter(18, bean.getCdgoAreact());
		sqlquery.setParameter(19, bean.getFchaContrato());
		sqlquery.setParameter(20, bean.getMrcaFormador());
		sqlquery.setParameter(21, bean.getDesgUsuact());
		sqlquery.setParameter(22, bean.getMrcaActivo());
		sqlquery.setParameter(23, bean.getCdgoTipodoc());
		sqlquery.setParameter(24, bean.getCdgoPersona());

		return sqlquery.executeUpdate();
	}

	public int updatePersonaMantenimiento(Tbasg100Persona bean) {

		String sqlString = "UPDATE PASG.TBASG100_PERSONA SET" + "			DESG_NIFPAS = ?, "
				+ "			DESG_MATRICULA = ?, " + "			DESG_NOMBRE = ?, " + "			DESG_APELL1 = ?, "
				+ "			DESG_APELL2 = ?, " + "			CDGO_TIPOVIA = ?," + "			DESG_VIA = ?, "
				+ "			DESG_NUMVIA = ?, " + "			DESG_PLANTA = ?, " + "			DESG_PUERTA = ?, "
				+ "			DESG_ESCALERA = ?, " + "			DESG_MUNICIPIO = ?, "
				+ "			CDGO_PROVINCIA = ?, " + "			CDGO_NACION = ?, " + "			DESG_CODPOSTAL = ?, "
				+ "			FCHA_NACIMIENTO = ?, " + "			CDGO_CARGO = ?, " + "			CDGO_CENTCONT = ?,"
				+ "			CDGO_AREACT = ?, " + "			FCHA_CONTRATO = ?, " + "			CDGO_ESTUDIO = ?, "
				+ "			DESG_ESTUDIEQUIV = ?," + "			DESG_CERTCASTELL = ?,"
				+ "			MRCA_FORMADOR = ?,    " + "			DESG_USUACT = ?, "
				+ "			FCHA_ACT = CURRENT_DATE," + "			MRCA_ACTIVO = ?, " + "			CDGO_TIPODOC = ?"
				+ "		WHERE CDGO_PERSONA = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg100Persona.class);
		sqlquery.setParameter(1, bean.getDesgNifpas().trim());
		sqlquery.setParameter(2, bean.getDesgMatricula().trim());
		sqlquery.setParameter(3, bean.getDesgNombre().trim());
		sqlquery.setParameter(4, bean.getDesgApell1().trim());
		sqlquery.setParameter(5, bean.getDesgApell2());
		sqlquery.setParameter(6, bean.getCdgoTipovia());
		sqlquery.setParameter(7, bean.getDesgVia());
		sqlquery.setParameter(8, bean.getDesgNumvia());
		sqlquery.setParameter(9, bean.getDesgPlanta());
		sqlquery.setParameter(10, bean.getDesgPuerta());
		sqlquery.setParameter(11, bean.getDesgEscalera());
		sqlquery.setParameter(12, bean.getDesgMunicipio());
		sqlquery.setParameter(13, bean.getCdgoProvincia());
		sqlquery.setParameter(14, bean.getCdgoNacion());
		sqlquery.setParameter(15, bean.getDesgCodpostal());
		sqlquery.setParameter(16, bean.getFchaNacimiento());
		sqlquery.setParameter(17, bean.getCdgoCargo());
		sqlquery.setParameter(18, bean.getCdgoCentcont());
		sqlquery.setParameter(19, bean.getCdgoAreact());
		sqlquery.setParameter(20, bean.getFchaContrato());
		sqlquery.setParameter(21, bean.getCdgoEstudio());
		sqlquery.setParameter(22, bean.getDesgEstudiequiv());
		sqlquery.setParameter(23, bean.getDesgCertcastell());
		sqlquery.setParameter(24, bean.getMrcaFormador());
		sqlquery.setParameter(25, bean.getDesgUsuact());
		sqlquery.setParameter(26, bean.getMrcaActivo());
		sqlquery.setParameter(27, bean.getCdgoTipodoc());
		sqlquery.setParameter(28, bean.getCdgoPersona());
		return sqlquery.executeUpdate();
	}

	public int deletePersona(Tbasg100Persona bean) {

		String sqlString = "UPDATE PASG.TBASG100_PERSONA SET "
				+ "			DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE, MRCA_ACTIVO='N' "
				+ "		WHERE CDGO_PERSONA=:cdgoPersona";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg100Persona.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoPersona", bean.getCdgoPersona());
		return sqlquery.executeUpdate();
	}

	public int updateReqMinimosPersonaAct(RequisitosMinimosDto bean) {
		String sqlString = " UPDATE PASG.TBASG100_PERSONA SET "
			+ " CDGO_ESTUDIO = ?, DESG_ESTUDIEQUIV = ?, CDGO_NACION = ?, DESG_CERTCASTELL = ?, DESG_USUACT = ?, FCHA_ACT = CURRENT_DATE "
			+ " WHERE CDGO_PERSONA = ? ";

		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter(1, bean.getCdgoEstudio());
		sqlquery.setParameter(2, bean.getDesgEstudiequiv());
		sqlquery.setParameter(3, bean.getCdgoNacion());
		sqlquery.setParameter(4, bean.getDesgCertcastell());
		sqlquery.setParameter(5, bean.getDesgUsuact());
		sqlquery.setParameter(6, bean.getCdgoPersona());

		return sqlquery.executeUpdate();
	}

	public List<GetPersonaEmpresaInformeDTO> getPersonaEmpresaInforme(Integer cdgoPersona) {

		String sqlString = "SELECT EMP.DESG_NOMBRE FROM PASG.TBASG100_PERSONA PER "
				+ "                INNER JOIN PASG.TBASG152_PERSEMP  PERSEMP ON PERSEMP.CDGO_PERSONA = PER.CDGO_PERSONA"
				+ "				INNER JOIN PASG.TBASG125_EMPRESA  EMP  ON EMP.CDGO_EMPRESA = PERSEMP.CDGO_EMPRESA"
				+ "            	   WHERE PER.CDGO_PERSONA  = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);

		List<Object> resultados = sqlquery.getResultList();
		List<GetPersonaEmpresaInformeDTO> resultadosDevueltos = new ArrayList<GetPersonaEmpresaInformeDTO>();
		for (Object object : resultados) {
			GetPersonaEmpresaInformeDTO personaEmpresa = new GetPersonaEmpresaInformeDTO();

			personaEmpresa.setDesgNombre(Util.quitarEspacios(object));

			resultadosDevueltos.add(personaEmpresa);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg100Persona> getTituloConList(String cdgoEstado, String cdgoEstado_1, String cdgoEstado_2,
			String cdgoEstado_3, String cdgoEstado_4) {
		// FIXME adaptar las definiciones
		String sqlString = "SELECT "
				+ "				T.CDGO_TIT, T.CDGO_PERSONA, T.FCHA_OTORGADO, T.DESG_TIPTIT,      "
				+ "				E.DESG_NOMBRE AS ESTADO," + "				ET.CDGO_ESTADO, ET.FCHA_ESTADO,     "
				+ "				P.DESG_NIFPAS, P.DESG_MATRICULA, P.DESG_NOMBRE AS DESG_PERSONA,"
				+ "				P.DESG_APELL1, P.DESG_APELL2, " + "				CASE "
				+ "			      WHEN MAX(AC.FCHA_CURSO) > '2015-04-20' THEN "
				+ "			           MAX(AC.FCHA_CURSO) + 2 YEARS" + "			      ELSE"
				+ "				       MAX(AC.FCHA_CURSO) + 3 YEARS " + "				  END AS FCHA_CURSOINC"
				+ "			FROM " + "				PASG.TBASG100_PERSONA P"
				+ "				INNER JOIN PASG.TBASG102_TITULOCON T ON T.CDGO_PERSONA = P.CDGO_PERSONA"
				+ "				INNER JOIN PASG.TBASG117_ESTADOTIT ET ON ET.CDGO_TIT = T.CDGO_TIT"
				+ "				INNER JOIN PASG.TBASG116_ESTADOS E ON E.CDGO_ESTADO = ET.CDGO_ESTADO"
				+ "				LEFT JOIN PASG.TBASG121_ACTAFORMA AF ON AF.CDGO_TIT = T.CDGO_TIT"
				+ "				LEFT JOIN PASG.TBASG146_ACTAINCAL AC ON AC.CDGO_ACTAFORM = AF.CDGO_ACTAFORM"
				+ "				LEFT JOIN PASG.TBASG104_EXPEDIENT EX ON P.CDGO_PERSONA=EX.CDGO_PERSONA"
				+ "			WHERE ET.FCHA_ESTADO = (SELECT MAX(FCHA_ESTADO)"
				+ "				                         FROM PASG.TBASG117_ESTADOTIT"
				+ "				                         WHERE CDGO_TIT = ET.CDGO_TIT"
				+ "										 AND MRCA_ACTIVO ='S')" + "" + "" + "" + "" + ""
				+ "			AND P.MRCA_ACTIVO = 'S'        " + "			AND T.MRCA_ACTIVO = 'S'      "
				+ "			AND ET.MRCA_ACTIVO = 'S'      " + "" + ""
				+ "			AND ET.CDGO_ESTADO IN (:cdgoEstadoVigente, :cdgoEstadoRenovado, :cdgoEstadoSuspendido, :cdgoEstadoRevocado, :cdgoEstadoReactivado)"
				+ "				" + "			"
				+ "			GROUP BY T.CDGO_TIT, T.CDGO_PERSONA, T.FCHA_OTORGADO, T.DESG_TIPTIT,      "
				+ "				E.DESG_NOMBRE," + "				ET.CDGO_ESTADO, ET.FCHA_ESTADO,     "
				+ "				P.DESG_NIFPAS, P.DESG_MATRICULA, P.DESG_NOMBRE,"
				+ "				P.DESG_APELL1, P.DESG_APELL2";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg100Persona.class);
		sqlquery.setParameter("cdgoEstadoVigente", cdgoEstado);
		sqlquery.setParameter("cdgoEstadoRenovado", cdgoEstado_1);
		sqlquery.setParameter("cdgoEstadoSuspendido", cdgoEstado_2);
		sqlquery.setParameter("cdgoEstadoRevocado", cdgoEstado_3);
		sqlquery.setParameter("cdgoEstadoReactivado", cdgoEstado_4);
		return sqlquery.getResultList();
	}

	public List<Tbasg100Persona> getTituloConListCount(String cdgoEstado, String cdgoEstado_1, String cdgoEstado_2,
			String cdgoEstado_3, String cdgoEstado_4) {
		// FIXME adaptar las definiciones
		String sqlString = "SELECT COUNT(DISTINCT(T.CDGO_TIT)) as value	" + "			FROM "
				+ "				PASG.TBASG100_PERSONA P"
				+ "				INNER JOIN PASG.TBASG102_TITULOCON T ON T.CDGO_PERSONA = P.CDGO_PERSONA"
				+ "				INNER JOIN PASG.TBASG117_ESTADOTIT ET ON ET.CDGO_TIT = T.CDGO_TIT"
				+ "				INNER JOIN PASG.TBASG116_ESTADOS E ON E.CDGO_ESTADO = ET.CDGO_ESTADO"
				+ "				LEFT JOIN PASG.TBASG121_ACTAFORMA AF ON AF.CDGO_TIT = T.CDGO_TIT"
				+ "				LEFT JOIN PASG.TBASG146_ACTAINCAL AC ON AC.CDGO_ACTAFORM = AF.CDGO_ACTAFORM"
				+ "			WHERE ET.FCHA_ESTADO = (SELECT MAX(FCHA_ESTADO)"
				+ "				                         FROM PASG.TBASG117_ESTADOTIT"
				+ "				                         WHERE CDGO_TIT = ET.CDGO_TIT"
				+ "										 AND MRCA_ACTIVO ='S')" + "" + "" + "" + "" + ""
				+ "			AND P.MRCA_ACTIVO = 'S'        " + "			AND T.MRCA_ACTIVO = 'S'      "
				+ "			AND ET.MRCA_ACTIVO = 'S'      " + "" + ""
				+ "			AND ET.CDGO_ESTADO IN (:cdgoEstadoVigente, :cdgoEstadoRenovado, :cdgoEstadoSuspendido, :cdgoEstadoRevocado, :cdgoEstadoReactivado)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg100Persona.class);
		sqlquery.setParameter("cdgoEstadoVigente", cdgoEstado);
		sqlquery.setParameter("cdgoEstadoRenovado", cdgoEstado_1);
		sqlquery.setParameter("cdgoEstadoSuspendido", cdgoEstado_2);
		sqlquery.setParameter("cdgoEstadoRevocado", cdgoEstado_3);
		sqlquery.setParameter("cdgoEstadoReactivado", cdgoEstado_4);
		return sqlquery.getResultList();
	}

	public List<Tbasg100Persona> getTituloConListCountPorEstado(String cdgoEstado, String cdgoEstado_1,
			String cdgoEstado_2, String cdgoEstado_3, String cdgoEstado_4) {
		// FIXME adaptar las definiciones
		String sqlString = "SELECT COUNT(*) as value			    " + "	        FROM"
				+ "               PASG.TBASG100_PERSONA P"
				+ "			   INNER JOIN PASG.TBASG102_TITULOCON T ON T.CDGO_PERSONA = P.CDGO_PERSONA"
				+ "			   INNER JOIN PASG.TBASG117_ESTADOTIT ET ON ET.CDGO_TIT = T.CDGO_TIT"
				+ "			WHERE ET.FCHA_ESTADO = (SELECT MAX(FCHA_ESTADO)"
				+ "				                         FROM PASG.TBASG117_ESTADOTIT"
				+ "				                         WHERE CDGO_TIT = ET.CDGO_TIT"
				+ "                                         AND MRCA_ACTIVO ='S')"
				+ "			AND P.MRCA_ACTIVO = 'S'        " + "			AND T.MRCA_ACTIVO = 'S'      "
				+ "			AND ET.MRCA_ACTIVO = 'S'      "
				+ "			AND ET.CDGO_ESTADO IN (:cdgoEstadoVigente, :cdgoEstadoRenovado, :cdgoEstadoSuspendido, :cdgoEstadoRevocado, :cdgoEstadoReactivado)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg100Persona.class);
		sqlquery.setParameter("cdgoEstadoVigente", cdgoEstado);
		sqlquery.setParameter("cdgoEstadoRenovado", cdgoEstado_1);
		sqlquery.setParameter("cdgoEstadoSuspendido", cdgoEstado_2);
		sqlquery.setParameter("cdgoEstadoRevocado", cdgoEstado_3);
		sqlquery.setParameter("cdgoEstadoReactivado", cdgoEstado_4);
		return sqlquery.getResultList();
	}

	public <T> String convertToString(T value) {
		return value != null ? value.toString() : null;
	}

	@Override
	public List<GetMaxEstadoHabilitaListDTO> getMaxEstadoHabilitaList(SetMaxEstadoHabilitaList mapPending) {

		StringBuilder strGetMaxEstadoHabilitaList = new StringBuilder();

		String sqlString = "SELECT A.CDGO_EXPEDIENT, MAX(G.FCHA_CURSO) + 3 YEARS AS FCHA_CURSOINC, C.DESG_NIFPAS, C.DESG_NOMBRE AS DESG_PERSONA, C.DESG_APELL1, C.DESG_APELL2, C.CDGO_PERSONA, C.DESG_MATRICULA, A.CDGO_TIPOHAB,"
				+ "A.CDGO_ALCANCEOT, A.CDGO_ESPEC, A.CDGO_ALCANCEAMBITO, A.CDGO_ENTORNO, A.CDGO_LINEA, A.CDGO_SERIE, A.CDGO_SUBSERIE, C.CDGO_AREACT, C.CDGO_ARETER, C.CDGO_CENTCONT, AA.DESG_NOMBRE AS DESG_AREACT,"
				+ "AR.DESG_NOMBRE AS DESG_ARETER, CC.DESG_NOMBRE AS DESG_CENTCONT, E.DESG_NOMBRE AS DESG_EMPRESA"

				+ " FROM PASG.TBASG100_PERSONA C"
				+ " LEFT JOIN PASG.TBASG105_AREACTIVI AA ON (C.CDGO_AREACT = AA.CDGO_AREACT)"
				+ " LEFT JOIN PASG.TBASG141_ARETER AR ON (C.CDGO_ARETER = AR.CDGO_ARETER)"
				+ " LEFT JOIN PASG.TBASG132_CENTCONT CC ON (C.CDGO_CENTCONT = CC.CDGO_CENTCONT),"
				+ " PASG.TBASG104_EXPEDIENT A"
				+ " LEFT JOIN PASG.TBASG125_EMPRESA E ON (A.CDGO_EMPRESA = E.CDGO_EMPRESA),"
				+ " PASG.TBASG121_ACTAFORMA F"
				+ " LEFT OUTER JOIN PASG.TBASG146_ACTAINCAL G ON (G.CDGO_ACTAFORM = F.CDGO_ACTAFORM)"

				+ " WHERE F.CDGO_EXPEDIENT = A.CDGO_EXPEDIENT AND A.CDGO_PERSONA = C.CDGO_PERSONA AND A.MRCA_ACTIVO = 'S' "
				+ " AND C.MRCA_ACTIVO = 'S' AND A.CDGO_TIPOHAB NOT IN( 1 , 2 )";

		strGetMaxEstadoHabilitaList.append(sqlString);
		System.out.println("----------------------");
		System.out.println(strGetMaxEstadoHabilitaList.toString());
		System.out.println("----------------------");

		if (mapPending != null) {
			if (mapPending.getCdgoAreAct() != null) {

				strGetMaxEstadoHabilitaList.append(" AND C.CDGO_AREACT IN (" + mapPending.getCdgoAreAct().get(0));

				for (int i = 1; i < mapPending.getCdgoAreAct().size(); i++) {
					strGetMaxEstadoHabilitaList.append(" ," + mapPending.getCdgoAreAct().get(i));
				}

				strGetMaxEstadoHabilitaList.append(" )");

			}

			if (mapPending.getCdgoAreTerr() != null) {
				strGetMaxEstadoHabilitaList.append(" AND C.CDGO_ARETER = " + mapPending.getCdgoAreTerr());
			}

			if (mapPending.getCdgoCentroCont() != null) {
				strGetMaxEstadoHabilitaList.append(" AND C.CDGO_CENTCONT = " + mapPending.getCdgoCentroCont());
			}

			if (mapPending.getDni() != null) {
				strGetMaxEstadoHabilitaList.append(" AND C.DESG_NIFPAS LIKE '%" + mapPending.getDni() + "%'");
			}

			if (mapPending.getMatricula() != null) {
				strGetMaxEstadoHabilitaList.append(" AND C.DESG_MATRICULA LIKE '%" + mapPending.getMatricula() + "%'");
			}

			if (!"".equals(mapPending.getNombre()) && mapPending.getNombre() != null) {
				strGetMaxEstadoHabilitaList
						.append(" AND C.DESG_NOMBRE LIKE '%" + mapPending.getNombre().toUpperCase() + "%'");
			}

			if (mapPending.getApell1() != null) {
				strGetMaxEstadoHabilitaList
						.append(" AND C.DESG_APELL1 LIKE '%" + mapPending.getApell1().toUpperCase() + "%'");
			}

			if (mapPending.getApell2() != null) {
				strGetMaxEstadoHabilitaList
						.append(" AND  C.DESG_APELL2 LIKE '%" + mapPending.getApell2().toUpperCase() + "%'");
			}

			if (mapPending.getCdgoTipohab() != null) {

				strGetMaxEstadoHabilitaList.append(" AND A.CDGO_TIPOHAB IN (" + mapPending.getCdgoTipohab().get(0));

				for (int i = 1; i < mapPending.getCdgoTipohab().size(); i++) {
					strGetMaxEstadoHabilitaList.append(" ," + mapPending.getCdgoTipohab().get(i));
				}

				strGetMaxEstadoHabilitaList.append(" )");

			}

			if (mapPending.getSociedad() != null) {
				strGetMaxEstadoHabilitaList.append(" AND A.CDGO_SOCIOTOR = " + mapPending.getSociedad());
			}

			if (mapPending.getPersonal() != null) {
				if (mapPending.getPersonal().equals("RENFE")) {
					strGetMaxEstadoHabilitaList.append(" AND C.DESG_MATRICULA != '' AND C.DESG_MATRICULA IS NOT NULL");
				}

				if (mapPending.getPersonal().equals("EXT")) {
					strGetMaxEstadoHabilitaList.append(" AND (C.DESG_MATRICULA = '' OR C.DESG_MATRICULA IS NULL)");
					if (mapPending.getEmpresa() != null) {
						strGetMaxEstadoHabilitaList.append(" AND A.CDGO_EMPRESA = " + mapPending.getEmpresa());
					}
				}

				if (mapPending.getPersonal().equals("AMBOS")) {
					if (mapPending.getEmpresa() != null) {
						strGetMaxEstadoHabilitaList
								.append(" AND ( (C.DESG_MATRICULA != '' AND C.DESG_MATRICULA IS NOT NULL)");

						strGetMaxEstadoHabilitaList.append(" OR A.CDGO_EMPRESA = " + mapPending.getEmpresa() + ")");
					}
				}
			}

		}

		System.out.println("----------------------");
		System.out.println(strGetMaxEstadoHabilitaList.toString());
		System.out.println("----------------------");

		strGetMaxEstadoHabilitaList
				.append(" GROUP BY A.CDGO_EXPEDIENT, C.DESG_NIFPAS, C.DESG_NOMBRE, C.DESG_APELL1, C.DESG_APELL2,"
						+ "C.CDGO_PERSONA, C.DESG_MATRICULA, A.CDGO_TIPOHAB, A.CDGO_ALCANCEOT, A.CDGO_ESPEC,"
						+ "A.CDGO_ALCANCEAMBITO, A.CDGO_ENTORNO, A.CDGO_LINEA, A.CDGO_SERIE, A.CDGO_SUBSERIE, C.CDGO_AREACT,"
						+ "C.CDGO_ARETER, C.CDGO_CENTCONT, AA.DESG_NOMBRE, AR.DESG_NOMBRE, CC.DESG_NOMBRE, E.DESG_NOMBRE");

		if (mapPending.getColumOrden() != null && mapPending.getColumOrden().equals("APELLI1")) {

			if (mapPending.getCdgoOrden().equals("A")) {
				strGetMaxEstadoHabilitaList.append(" ORDER BY C.DESG_APELL1 ASC, C.DESG_APELL2 ASC");
			}

			if (mapPending.getCdgoOrden().equals("D")) {
				strGetMaxEstadoHabilitaList.append(" ORDER BY C.DESG_APELL1 DESC, C.DESG_APELL2 DESC");
			}
		}

		System.out.println("----------------------");
		System.out.println(strGetMaxEstadoHabilitaList.toString());
		System.out.println("----------------------");

		Query sqlquery = em.createNativeQuery(strGetMaxEstadoHabilitaList.toString());

		List<Object[]> resultados = sqlquery.getResultList();
		System.out.println("Pintamos los resultados de la query");
		for (Object[] object : resultados) {

			System.out.println(object + "");
		}
		List<GetMaxEstadoHabilitaListDTO> resultadosDevueltos = new ArrayList<>();
		int i = 0;
		for (Object[] object : resultados) {
			GetMaxEstadoHabilitaListDTO data = new GetMaxEstadoHabilitaListDTO();
			
		

			
			if (object[0] != null) {
				data.setCdgoExpedient((int) object[0]);
			}
			if (object[1] != null) {
				data.setFchaCursoinc((Date) object[1]);
			}
			if (object[2] != null) {
				data.setDesgNifpas(Util.quitarEspacios(object[2]));
			}
			if (object[3] != null) {
				data.setDesgPersona(Util.quitarEspacios(object[3]));
			}
			if (object[4] != null) {
				data.setDesgApell1(Util.quitarEspacios(object[4]));
			}
			if (object[5] != null) {
				data.setDesgApell2(Util.quitarEspacios(object[5]));
			}
			if (object[6] != null) {
				data.setCdgoPersona((Integer) object[6]);
			}
			if (object[7] != null) {
				data.setDesgMatricula(Util.quitarEspacios(object[7]));
			}
			if (object[8] != null) {
				data.setCdgoTipohab((Integer)object[8]);
			}
			if (object[9] != null) {
				data.setCdgoAlcanceot((Integer) object[9]);
			}
			if (object[10] != null) {
				data.setCdgoEspec((Integer) object[10]);
			}
			if (object[11] != null) {
				data.setCdgoAlcanceambito((Integer) object[11]);
			}
			if (object[12] != null) {
				data.setCdgoEntorno((Integer) object[12]);
			}
			if (object[13] != null) {
				data.setCdgoLinea(Util.quitarEspacios(object[13]));
			}
			if (object[14] != null) {
				data.setCdgoSerie(Util.quitarEspacios(object[14]));
			}
			if (object[15] != null) {
				data.setCdgoSubserie(Util.quitarEspacios(object[15]));
			}
			if (object[16] != null) {
				data.setCdgoAreAct((Integer) object[16]);
			}
			if (object[17] != null) {
				data.setCdgoAreTerr((Integer) object[17]);
			}
			if (object[18] != null) {
				data.setCdgoCentroCont(Util.quitarEspacios(object[18]));
			}
			if (object[19] != null) {
				data.setDesgAreAct(Util.quitarEspacios(object[19]));
			}
			if (object[20] != null) {
				data.setDesgAreTerr(Util.quitarEspacios(object[20]));
			}
			if (object[21] != null) {
				data.setDesgCentroCont(Util.quitarEspacios(object[21]));
			}
			if (object[22] != null) {
				data.setDesgEmpresa(Util.quitarEspacios(object[22]));
			}

			resultadosDevueltos.add(data);

		}

		return resultadosDevueltos;

	}

	public JSONObject getLeerJson(String tabla) {

		JSONObject ob = null;

		try {
			if ("TBASG105_AREACTIVI".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG105_AREACTIVI.json"), StandardCharsets.UTF_8));
			} else if ("TBASG106_PROVINCIA".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG106_PROVINCIA.json"), StandardCharsets.UTF_8));
			} else if ("TBASG107_TIPOVIA".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG107_TIPOVIA.json"), StandardCharsets.UTF_8));
			} else if ("TBASG108_CENTMEDIC".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG108_CENTMEDIC.json"), StandardCharsets.UTF_8));
			} else if ("TBASG109_PSICOAMBI".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG109_PSICOAMBI.json"), StandardCharsets.UTF_8));
			} else if ("TBASG110_PSICOMOTI".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG110_PSICOMOTI.json"), StandardCharsets.UTF_8));
			} else if ("TBASG111_FACULTATI".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG111_FACULTATI.json"), StandardCharsets.UTF_8));
			} else if ("TBASG112_TIPOINFRA".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG112_TIPOINFRA.json"), StandardCharsets.UTF_8));
			} else if ("TBASG113_SANCION".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG113_SANCION.json"), StandardCharsets.UTF_8));
			} else if ("TBASG114_GRADOINCI".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG114_GRADOINCI.json"), StandardCharsets.UTF_8));
			} else if ("TBASG115_CALIFICAC".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG115_CALIFICAC.json"), StandardCharsets.UTF_8));
			} else if ("TBASG120_CENTFORMA".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG120_CENTFORMA.json"), StandardCharsets.UTF_8));
			} else if ("TBASG122_INSTRU".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG122_INSTRU.json"), StandardCharsets.UTF_8));
			} else if ("TBASG124_AMBITOS".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG124_AMBITOS.json"), StandardCharsets.UTF_8));
			} else if ("TBASG127_LINEAS".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG127_LINEAS.json"), StandardCharsets.UTF_8));
			} else if ("TBASG128_ESTACLINE".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG128_ESTACLINE.json"), StandardCharsets.UTF_8));
			} else if ("TBASG131_ALCANCEOT".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG131_ALCANCEOT.json"), StandardCharsets.UTF_8));
			} else if ("TBASG132_CENTCONT".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG132_CENTCONT.json"), StandardCharsets.UTF_8));
			} else if ("TBASG133_SERIE".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG133_SERIE.json"), StandardCharsets.UTF_8));
			} else if ("TBASG134_NACION".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG134_NACION.json"), StandardCharsets.UTF_8));
			} else if ("TBASG135_CARGO".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG135_CARGO.json"), StandardCharsets.UTF_8));
			} else if ("TBASG136_ESTUDIO".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG136_ESTUDIO.json"), StandardCharsets.UTF_8));
			} else if ("TBASG137_ESPECIALI".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG137_ESPECIALI.json"), StandardCharsets.UTF_8));
			} else if ("TBASG141_ARETER".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG141_ARETER.json"), StandardCharsets.UTF_8));
			} else if ("TBASG142_RESP_AREA".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG142_RESP_AREA.json"), StandardCharsets.UTF_8));
			} else if ("TBASG143_CENTHGADO".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG143_CENTHGADO.json"), StandardCharsets.UTF_8));
			} else if ("TBASG147_SUBSERIE".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG147_SUBSERIE.json"), StandardCharsets.UTF_8));
			} else if ("TBASG155_FC_CATEGORIA".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG155_FC_CATEGORIA.json"), StandardCharsets.UTF_8));
			} else if ("TBASG156_FC_CUALIFICACION".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(
						new InputStreamReader(getClass().getResourceAsStream("/json/TBASG156_FC_CUALIFICACION.json"),
								StandardCharsets.UTF_8));
			} else if ("TBASG170_VEHICULO_OVM".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG170_VEHICULO_OVM.json"), StandardCharsets.UTF_8));
			} else if ("TBASG220_USUARIOS_EXTERNOS".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(
						new InputStreamReader(getClass().getResourceAsStream("/json/TBASG220_USUARIOS_EXTERNOS.json"),
								StandardCharsets.UTF_8));
			} else if ("TBASG230_DESTINATARIOS_EMAIL".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(
						new InputStreamReader(getClass().getResourceAsStream("/json/TBASG230_DESTINATARIOS_EMAIL.json"),
								StandardCharsets.UTF_8));
			} else if ("TBASG257_ALCANAUXCAB".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG257_ALCANAUXCAB.json"), StandardCharsets.UTF_8));
			} else if ("TBASG261_SOCIEDADES".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG261_SOCIEDADES.json"), StandardCharsets.UTF_8));
			} else if ("TBASG264_AMBITO_PUERT".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG264_AMBITO_PUERT.json"), StandardCharsets.UTF_8));
			} else if ("TBASG265_AMBITO_LINEA".equals(tabla)) {
				ob = (JSONObject) new JSONParser().parse(new InputStreamReader(
						getClass().getResourceAsStream("/json/TBASG265_AMBITO_LINEA.json"), StandardCharsets.UTF_8));
			} else {
				System.out.println("---El caso Seleccionado no existe---");
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		return ob;

	}

	public List<Tbasg905OrganizationChartDto> getOrganizationalChart(Integer level, String id) {

		String sqlString;
		Query sqlquery;
		List<Object[]> results;
		List<Tbasg905OrganizationChartDto> resultList = new ArrayList<>();

		switch (level) {
		case 1:
			sqlString = "SELECT "
					+ " ARE.CDGO_ARETER, ARE.CDGO_AREACT, ARE.DESG_NOMBRE, ARE.DESG_USUACT, ARE.FCHA_ACT, ARE.MRCA_ACTIVO "
					+ "	FROM PASG.TBASG141_ARETER ARE "
					+ " WHERE ARE.MRCA_ACTIVO = 'S' AND ARE.CDGO_AREACT = :cdgoAreact " + " ORDER BY ARE.CDGO_ARETER ";

			sqlquery = em.createNativeQuery(sqlString);
			if (Objects.nonNull(id))
				sqlquery.setParameter("cdgoAreact", id);
			results = sqlquery.getResultList();

			for (Object[] item : results) {
				Tbasg905OrganizationChartDto row = new Tbasg905OrganizationChartDto();
				row.setId(this.convertToString(item[0]).trim());
				row.setCdgoAreter((Integer) item[0]);
				row.setCdgoAreact((Integer) item[1]);
				row.setDesgNombre(Util.quitarEspacios(item[2]));
				row.setDesgUsuact(Util.quitarEspacios(item[3]));
				row.setFchaAct(dateFormat.format(item[4]));
				row.setMrcaActivo(String.valueOf((Character) item[5]));
				resultList.add(row);
			}

			break;

		case 2:
			sqlString = "SELECT ID_AREA FROM PDSN.TBDSNA08_AREA_REPARTO WHERE CDGO_ARETER = :cdgoAreter ";

			sqlquery = em.createNativeQuery(sqlString);
			if (Objects.nonNull(id))
				sqlquery.setParameter("cdgoAreter", id);
			List<String> deliveryAreasList = sqlquery.getResultList();
			if (!deliveryAreasList.isEmpty()) {
				String areaId = deliveryAreasList.get(0);

				sqlString = "SELECT " + " REP.ID_CENTRO, REP.ID_AREA, REP.NOMBRE_CENTRO, REP.FCHA_ALTA, REP.FCHA_BAJA "
						+ "	FROM PDSN.TBDSNA09_CENTRO_REPARTO REP " + " WHERE REP.ID_AREA = :areaId and REP.FCHA_BAJA is null"
						+ " ORDER BY REP.ID_CENTRO ";

				sqlquery = em.createNativeQuery(sqlString);
				if (Objects.nonNull(areaId))
					sqlquery.setParameter("areaId", areaId);
				results = sqlquery.getResultList();

				for (Object[] item : results) {
					Tbasg905OrganizationChartDto row = new Tbasg905OrganizationChartDto();
					row.setId(Util.quitarEspacios(item[0]));
					row.setDesgNombre(Util.quitarEspacios(item[2]));
					row.setCentroId(Util.quitarEspacios(item[0]));
					row.setIdArea(Util.quitarEspacios(item[1]));
					row.setNombreCentro(Util.quitarEspacios(item[2]));
					row.setFchaAlta(dateFormat.format(item[3]));
					resultList.add(row);
				}
			}else {
				sqlString = "SELECT * FROM PASG.TBASG100_PERSONA WHERE CDGO_ARETER = :cdgoAreter";

				sqlquery = em.createNativeQuery(sqlString);
				if (Objects.nonNull(id))
					sqlquery.setParameter("cdgoAreter", id);
				results = sqlquery.getResultList();

				for (Object[] item : results) {
					Tbasg905OrganizationChartDto row = new Tbasg905OrganizationChartDto();
					row.setId(Util.quitarEspacios(item[2]));
					row.setDesgNombre(Util.quitarEspacios(item[3]).concat(" ").concat(Util.quitarEspacios(item[4])).concat(" ").concat(Util.quitarEspacios(item[5])));
					resultList.add(row);
				}
			}
			break;

		case 3:
			sqlString = "SELECT NOMBRE FROM PDSN.TBDSNA10_MAQUINISTAS WHERE ID_CENTRO = :idCentro ";

			sqlquery = em.createNativeQuery(sqlString);
			if (Objects.nonNull(id))
				sqlquery.setParameter("idCentro", id);
			List<String> deliveryMaquinistasList = sqlquery.getResultList();
			if (!deliveryMaquinistasList.isEmpty()) {
				
				for (String item : deliveryMaquinistasList) {
					Tbasg905OrganizationChartDto row = new Tbasg905OrganizationChartDto();
					row.setDesgNombre(Util.quitarEspacios(item));
					resultList.add(row);
				}
				
			}
			break;

		case 4:

			break;

		default:
			sqlString = "SELECT "
					+ " ACT.CDGO_AREACT, ACT.DESG_NOMBRE, ACT.DESG_USUACT, ACT.FCHA_ACT, ACT.MRCA_ACTIVO, ACT.CDGO_SOCIEDAD "
					+ "	FROM PASG.TBASG105_AREACTIVI ACT " + " WHERE ACT.MRCA_ACTIVO = 'S' "
					+ " ORDER BY ACT.CDGO_AREACT ";
			sqlquery = em.createNativeQuery(sqlString);
			results = sqlquery.getResultList();

			for (Object[] item : results) {
				Tbasg905OrganizationChartDto row = new Tbasg905OrganizationChartDto();
				row.setId(this.convertToString(item[0]));
				row.setCdgoAreact((Integer) item[0]);
				row.setDesgNombre(Util.quitarEspacios(item[1]));
				row.setDesgUsuact(Util.quitarEspacios(item[2]));
				row.setFchaAct(dateFormat.format(item[3]));
				row.setMrcaActivo(String.valueOf((Character) item[4]));
				row.setCdgoSociedad(Util.quitarEspacios(item[5]));
				resultList.add(row);
			}

			break;
		}

		return resultList;
	}

	public int updateRevisionStatus(List<List<String>> expedientCodeList) {
		int result = 0;
		String sqlString;
		Query sqlquery;

		try {
			for (List<String> item : expedientCodeList) {
				String expedientCode = item.get(0);
				String isChecked = item.get(1);

				sqlString = "UPDATE PASG.TBASG104_EXPEDIENT SET MRCA_REVISION = :isChecked WHERE CDGO_EXPEDIENT = :expedientCode";
				sqlquery = em.createNativeQuery(sqlString);
				if (Objects.nonNull(expedientCode))
					sqlquery.setParameter("expedientCode", expedientCode);
				if (Objects.nonNull(isChecked))
					sqlquery.setParameter("isChecked", isChecked);

				result = sqlquery.executeUpdate();
			}

		} catch (Exception e) {
			result = 500;
		}

		return result;
	}

}
