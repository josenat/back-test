package renfe.com.repository.impl;

import java.sql.Date;
import java.text.DateFormat;
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
import org.springframework.transaction.annotation.Transactional;

import renfe.com.dto.GetCertPsicPersonaInactivosListDTO;
import renfe.com.dto.GetCertpsicCdgoPersonaDTO;

import renfe.com.dto.GetRelHabPsicByCdgoCertPsicDTO;
import renfe.com.dto.GetCertpsichistResultDTO;
import renfe.com.model.dto.Tbasg101CertpsicDto;

import renfe.com.dto.GetCertsPsicByPersListDTO;
import renfe.com.dto.GetPersonaCertificadosIdiomasListDTO;
import renfe.com.model.entity.Tbasg100Persona;

import renfe.com.model.entity.Tbasg101Certpsic;
import renfe.com.repository.Tbasg101CertpsicRepositoryCustom;

public class Tbasg101CertpsicRepositoryImpl implements Tbasg101CertpsicRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(Tbasg100PersonaRepositoryImpl.class);


	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public List<GetCertpsicCdgoPersonaDTO> getCertpsicCdgoPersona(Integer cdgoPersona) {	
		
		String sqlString = "SELECT C.CDGO_CERTPSIC, C.CDGO_PERSONA, C.FCHA_RECONOC, C.FCHA_PROXREV, C.MRCA_ACTIVO,"
					+ "			C.CDGO_MOTIVO, P.DESG_NOMBRE AS DESC_MOTIVO, C.CDGO_CALIFI, F.DESG_NOMBRE AS DESC_CALIFI, "
					+ "			C.CDGO_PSICAMB, A.DESG_NOMBRE AS DESC_PSICAMB, C.CDGO_CENMED, M.DESG_NOMBRE AS DESC_CENMED, "
					+ "			FA.DESG_NOMBRE AS PERS_NOMBRE, FA.DESG_APELL1 AS PERS_APELL1, FA.DESG_APELL2 AS PERS_APELL2 "
				+ "		    FROM  PASG.TBASG101_CERTPSIC C "
				+ "				INNER JOIN PASG.TBASG110_PSICOMOTI P ON C.CDGO_MOTIVO = P.CDGO_MOTIVO "	
				+ "		        INNER JOIN PASG.TBASG115_CALIFICAC F ON C.CDGO_CALIFI = F.CDGO_CALIFI "
				+ "		        INNER JOIN PASG.TBASG109_PSICOAMBI A ON C.CDGO_PSICAMB = A.CDGO_PSICAMB "
				+ "		        INNER JOIN PASG.TBASG108_CENTMEDIC M ON C.CDGO_CENMED = M.CDGO_CENMED "
				+ "		        INNER JOIN PASG.TBASG100_PERSONA S ON C.CDGO_PERSONA = S.CDGO_PERSONA "
				+ "		        INNER JOIN PASG.TBASG111_FACULTATI FA ON C.CDGO_FACULT = FA.CDGO_FACULT "
				+ "		    WHERE C.CDGO_PERSONA = :cdgoPersona "
				+ "		        AND C.MRCA_ACTIVO = 'S'";

		Query sqlquery = em.createNativeQuery(sqlString, GetCertpsicCdgoPersonaDTO.class);
		sqlquery.setParameter("cdgoPersona", cdgoPersona);
		return sqlquery.getResultList();
	}
	
	public int updatePsicoBajas(Integer cdgoCertpsic) {

		String sqlString = "UPDATE PASG.TBASG101_CERTPSIC SET MRCA_ACTIVO = 'N', DESG_USUACT = 'SCEXUV3', FCHA_ACT = CURRENT_DATE WHERE CDGO_CERTPSIC = :cdgoCertpsic";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("cdgoCertpsic", cdgoCertpsic);
		return sqlquery.executeUpdate();
	}
	
	
	public List<Tbasg101Certpsic> getExpiredCertPsic(String fchaProxrev) {

		String sqlString = "SELECT * FROM PASG.TBASG101_CERTPSIC " + "		" + "		" + "		"
				+ "		WHERE MRCA_ACTIVO = 'S' AND FCHA_PROXREV < :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg101Certpsic.class);
		sqlquery.setParameter("value", fchaProxrev);
		return sqlquery.getResultList();
	}

	public List<Tbasg101Certpsic> getNoExpiredCertPsicByCdgoPersona(String cdgoPersona, String fchaProxrev) {

		String sqlString = "SELECT * FROM PASG.TBASG101_CERTPSIC " + "		WHERE CDGO_PERSONA = :cdgoPersona "
				+ "		AND MRCA_ACTIVO = 'S' AND FCHA_PROXREV >= :fecha";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg101Certpsic.class);
		sqlquery.setParameter("cdgoPersona", cdgoPersona);
		sqlquery.setParameter("fecha", fchaProxrev);
		return sqlquery.getResultList();
	}

	public List<Tbasg101Certpsic> getCertPsic(String cdgoCertpsic) {

		String sqlString = "SELECT * FROM PASG.TBASG101_CERTPSIC WHERE CDGO_CERTPSIC = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg101Certpsic.class);
		sqlquery.setParameter("value", cdgoCertpsic);
		return sqlquery.getResultList();
	}
	
	public List<Tbasg101Certpsic> getCertPsicByCdgoPersonaAndCdgoPsicoAmb(String cdgoPersona, Integer cdgoPsicoAmb) {

		String sqlString = "SELECT * FROM PASG.TBASG101_CERTPSIC WHERE CDGO_PERSONA = :cdgoPersona AND CDGO_PSICAMB = :cdgoPsicoamb";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg101Certpsic.class);
		sqlquery.setParameter("cdgoPersona", cdgoPersona);
		sqlquery.setParameter("cdgoPsicoamb", cdgoPsicoAmb);
		return sqlquery.getResultList();
	}

	public List<GetCertpsichistResultDTO> getHistoricCertPsicPersona(String cdgoPersona) {
		
		String sqlString = "SELECT A.CDGO_CERTPSIC, A.FCHA_RECONOC, UPPER(RTRIM(B.DESG_NOMBRE)) AS MOTIVO, A.FCHA_PROXREV, A.CDGO_DEOBS,"
				+ "				A.MRCA_CORRVISUAL, A.MRCA_PROTAUD, UPPER(RTRIM(C.DESG_NOMBRE)) AS CALIFICACION,A.CADUCADO_ILT, "
				+ "				UPPER(RTRIM(D.DESG_NOMBRE)) AS AMBITO, "
				+ "				UPPER(RTRIM(E.DESG_NOMBRE)) AS CENTRO, UPPER(RTRIM(F.DESG_NOMBRE)) AS NOM_FACULT, "
				+ "		        UPPER(RTRIM(F.DESG_APELL1)) AS APE1_FACULT, UPPER(RTRIM(F.DESG_APELL2)) AS APE2_FACULT"
				+ "		    FROM PASG.TBASG101_CERTPSIC A, PASG.TBASG110_PSICOMOTI B, PASG.TBASG115_CALIFICAC C, "
				+ "		        PASG.TBASG109_PSICOAMBI D, PASG.TBASG108_CENTMEDIC E, PASG.TBASG111_FACULTATI F"
				+ "		    WHERE A.CDGO_MOTIVO = B.CDGO_MOTIVO" + "		        AND A.CDGO_CALIFI = C.CDGO_CALIFI"
				+ "		        AND A.CDGO_PSICAMB = D.CDGO_PSICAMB"
				+ "		        AND A.CDGO_CENMED = E.CDGO_CENMED" + "		        AND A.CDGO_FACULT = F.CDGO_FACULT "
				+ "		        AND CDGO_PERSONA = :cdgoPersona" + "			ORDER BY A.FCHA_RECONOC ASC";

		Query sqlquery = em.createNativeQuery(sqlString);

		sqlquery.setParameter("cdgoPersona", cdgoPersona);

		List<Object[]> results = sqlquery.getResultList();
		List<GetCertpsichistResultDTO> resultList = new ArrayList<>();
		for (Object[] object : results) {
			GetCertpsichistResultDTO data = new GetCertpsichistResultDTO();
			data.setCdgoCertPsic(Long.valueOf((int)object[0]));
			data.setFchaReconoc((Date) object[1]);
			data.setMotivo((String) object[2]);
			data.setFchaProxRev((Date) object[3]);
			data.setObservaciones((String) object[4]);
			data.setCorrVisual(String.valueOf((Character) object[5]));
			data.setProtAud(String.valueOf((Character) object[6]));
			data.setCalificacion((String) object[7]);
			data.setCaducILT(String.valueOf((Character) object[8]));
			data.setAmbito((String) object[9]);
			data.setCentro((String) object[10]);
			data.setNomFacult((String) object[11]);
			data.setApe1Facult((String) object[12]);
			data.setApe2Facult((String) object[13]);
			
			resultList.add(data);
		}

		return resultList;		
	}

	public List<Tbasg101Certpsic> getHistoricCertPsicPersonaInfSer(Integer cdgoPersona) {

		String sqlString = "SELECT * FROM PASG.TBASG101_CERTPSIC WHERE CDGO_PERSONA = :value ORDER BY FCHA_RECONOC DESC, FCHA_ACT DESC";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg101Certpsic> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg101Certpsic certpsic = new Tbasg101Certpsic();

			certpsic.setCdgoCertpsic((Integer)object[0]);
			certpsic.setCdgoPersona((Integer)object[1]);
			certpsic.setFchaProxrev((Date) object[2]);
			certpsic.setFchaReconoc((Date) object[3]);
			certpsic.setCdgoDeobs((String)object[4]);
			certpsic.setFchaLimtemp((Date) object[5]);
			certpsic.setMrcaCorrvisual(String.valueOf((java.lang.Character) object[6]));
			certpsic.setMrcaProtaud(String.valueOf((java.lang.Character) object[7]));
			certpsic.setCdgoCenmed(String.valueOf((Integer) object[8]));
			certpsic.setCdgoMotivo(String.valueOf((Integer) object[9]));
			certpsic.setCdgoPsicamb((Integer) object[10]);
			certpsic.setCdgoFacult(String.valueOf((Integer) object[11]));
			certpsic.setCdgoCalifi(String.valueOf((Integer) object[12]));
			certpsic.setDesgUsuact((String)object[13]);
			certpsic.setFchaAct((Date) object[14]);
			certpsic.setMrcaActivo(String.valueOf((java.lang.Character) object[15]));
			certpsic.setCaducadoIlt(String.valueOf((java.lang.Character) object[16]));

			resultadosDevueltos.add(certpsic);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg101Certpsic> getActiveCertPsicWithMaxFchaReconoc(Integer cdgoPersona) {

		String sqlString = "SELECT * FROM PASG.TBASG101_CERTPSIC WHERE CDGO_PERSONA = :value AND MRCA_ACTIVO = 'S' ORDER BY FCHA_RECONOC DESC, FCHA_ACT DESC";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg101Certpsic> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg101Certpsic certpsic = new Tbasg101Certpsic();

			certpsic.setCdgoCertpsic((Integer)object[0]);
			certpsic.setCdgoPersona((Integer)object[1]);
			certpsic.setFchaProxrev((Date) object[2]);
			certpsic.setFchaReconoc((Date) object[3]);
			certpsic.setCdgoDeobs((String)object[4]);
			certpsic.setFchaLimtemp((Date) object[5]);
			certpsic.setMrcaCorrvisual(String.valueOf((java.lang.Character) object[6]));
			certpsic.setMrcaProtaud(String.valueOf((java.lang.Character) object[7]));
			certpsic.setCdgoCenmed(String.valueOf((Integer) object[8]));
			certpsic.setCdgoMotivo(String.valueOf((Integer) object[9]));
			certpsic.setCdgoPsicamb((Integer) object[10]);
			certpsic.setCdgoFacult(String.valueOf((Integer) object[11]));
			certpsic.setCdgoCalifi(String.valueOf((Integer) object[12]));
			certpsic.setDesgUsuact((String)object[13]);
			certpsic.setFchaAct((Date) object[14]);
			certpsic.setMrcaActivo(String.valueOf((java.lang.Character) object[15]));
			certpsic.setCaducadoIlt(String.valueOf((java.lang.Character) object[16]));

			resultadosDevueltos.add(certpsic);
		}
		return resultadosDevueltos;
	}
	
	/*public List<Tbasg101Certpsic> getCertPsicWithMaxFchaRec(String cdgoPersona) {

		String sqlString = "SELECT * " + "		FROM PASG.TBASG101_CERTPSIC " + "		WHERE CDGO_PERSONA = :value"
				+ "		AND MRCA_ACTIVO = 'S'" + "		AND FCHA_RECONOC = (SELECT MAX(FCHA_RECONOC) "
				+ "		                    FROM PASG.TBASG101_CERTPSIC "
				+ "		                    WHERE CDGO_PERSONA = :value"
				+ "		                    AND MRCA_ACTIVO = 'S')               " + "		ORDER BY FCHA_ACT DESC";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg101Certpsic> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg101Certpsic certpsic = new Tbasg101Certpsic();
			
			certpsic.setCdgoCertpsic((Integer)object[0]);
			certpsic.setCdgoPersona((Integer)object[1]);
			certpsic.setFchaProxrev((Date) object[2]);
			certpsic.setFchaReconoc((Date) object[3]);
			certpsic.setCdgoDeobs((String)object[4]);
			certpsic.setFchaLimtemp((Date) object[5]);
			certpsic.setMrcaCorrvisual(String.valueOf((java.lang.Character) object[6]));
			certpsic.setMrcaProtaud(String.valueOf((java.lang.Character) object[7]));
			certpsic.setCdgoCenmed(String.valueOf((Integer) object[8]));
			certpsic.setCdgoMotivo(String.valueOf((Integer) object[9]));
			certpsic.setCdgoPsicamb(String.valueOf((Integer) object[10]));
			certpsic.setCdgoFacult(String.valueOf((Integer) object[11]));
			certpsic.setCdgoCalifi(String.valueOf((Integer) object[12]));
			certpsic.setDesgUsuact((String)object[13]);
			certpsic.setFchaAct((Date) object[14]);
			certpsic.setMrcaActivo(String.valueOf((java.lang.Character) object[15]));
			certpsic.setCaducadoIlt(String.valueOf((java.lang.Character) object[16]));

			resultadosDevueltos.add(certpsic);
		}
		return resultadosDevueltos;
	}*/
	
	public List<Tbasg101Certpsic> getCertPsicWithMaxFchaRec(String cdgoPersona) {

		String sqlString = " SELECT * FROM PASG.TBASG101_CERTPSIC WHERE CDGO_PERSONA = :value "
				+ "AND MRCA_ACTIVO = 'S'	ORDER BY FCHA_ACT DESC ";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg101Certpsic> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg101Certpsic certpsic = new Tbasg101Certpsic();
			
			certpsic.setCdgoCertpsic((Integer)object[0]);
			certpsic.setCdgoPersona((Integer)object[1]);
			certpsic.setFchaProxrev((Date) object[2]);
			certpsic.setFchaReconoc((Date) object[3]);
			certpsic.setCdgoDeobs((String)object[4]);
			certpsic.setFchaLimtemp((Date) object[5]);
			certpsic.setMrcaCorrvisual(String.valueOf((java.lang.Character) object[6]));
			certpsic.setMrcaProtaud(String.valueOf((java.lang.Character) object[7]));
			certpsic.setCdgoCenmed(String.valueOf((Integer) object[8]));
			certpsic.setCdgoMotivo(String.valueOf((Integer) object[9]));
			certpsic.setCdgoPsicamb((Integer) object[10]);
			certpsic.setCdgoFacult(String.valueOf((Integer) object[11]));
			certpsic.setCdgoCalifi(String.valueOf((Integer) object[12]));
			certpsic.setDesgUsuact((String)object[13]);
			certpsic.setFchaAct((Date) object[14]);
			certpsic.setMrcaActivo(String.valueOf((java.lang.Character) object[15]));
			certpsic.setCaducadoIlt(String.valueOf((java.lang.Character) object[16]));

			resultadosDevueltos.add(certpsic);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg101Certpsic> getCertPsicActiveList(String cdgoPersona) {

		String sqlString = "SELECT * FROM PASG.TBASG101_CERTPSIC "
				+ "		WHERE CDGO_PERSONA = :value AND MRCA_ACTIVO ='S'" + "		ORDER BY FCHA_RECONOC DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg101Certpsic.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}

	public List<Tbasg101Certpsic> getActiveCertPsicWithMaxFchaProxRev(String cdgoPersona) {

		String sqlString = "SELECT * FROM PASG.TBASG101_CERTPSIC "
				+ "		WHERE CDGO_PERSONA = :value AND MRCA_ACTIVO ='S' "
				+ "		AND FCHA_PROXREV = (SELECT max(FCHA_PROXREV) FROM PASG.TBASG101_CERTPSIC "
				+ "		                    WHERE CDGO_PERSONA = :value AND MRCA_ACTIVO ='S')"
				+ "		ORDER BY FCHA_ACT DESC FETCH FIRST 1 ROWS ONLY";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg101Certpsic> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg101Certpsic certpsic = new Tbasg101Certpsic();

			certpsic.setCdgoCertpsic((Integer)object[0]);
			certpsic.setCdgoPersona((Integer)object[1]);
			certpsic.setFchaProxrev((Date) object[2]);
			certpsic.setFchaReconoc((Date) object[3]);
			certpsic.setCdgoDeobs((String)object[4]);
			certpsic.setFchaLimtemp((Date) object[5]);
			certpsic.setMrcaCorrvisual(String.valueOf((java.lang.Character) object[6]));
			certpsic.setMrcaProtaud(String.valueOf((java.lang.Character) object[7]));
			certpsic.setCdgoCenmed(String.valueOf((Integer) object[8]));
			certpsic.setCdgoMotivo(String.valueOf((Integer) object[9]));
			certpsic.setCdgoPsicamb((Integer) object[10]);
			certpsic.setCdgoFacult(String.valueOf((Integer) object[11]));
			certpsic.setCdgoCalifi(String.valueOf((Integer) object[12]));
			certpsic.setDesgUsuact((String)object[13]);
			certpsic.setFchaAct((Date) object[14]);
			certpsic.setMrcaActivo(String.valueOf((java.lang.Character) object[15]));
			certpsic.setCaducadoIlt(String.valueOf((java.lang.Character) object[16]));

			resultadosDevueltos.add(certpsic);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg101Certpsic> getCertPsicWithFchaProxRevActiveList(String cdgoPersona) {

		String sqlString = "SELECT * FROM PASG.TBASG101_CERTPSIC "
				+ "		WHERE CDGO_PERSONA = :value AND MRCA_ACTIVO ='S' " + "		ORDER BY FCHA_PROXREV DESC";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg101Certpsic> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg101Certpsic certpsic = new Tbasg101Certpsic();

			certpsic.setCdgoCertpsic((Integer)object[0]);
			certpsic.setCdgoPersona((Integer)object[1]);
			certpsic.setFchaProxrev((Date) object[2]);
			certpsic.setFchaReconoc((Date) object[3]);
			certpsic.setCdgoDeobs((String)object[4]);
			certpsic.setFchaLimtemp((Date) object[5]);
			certpsic.setMrcaCorrvisual(String.valueOf((java.lang.Character) object[6]));
			certpsic.setMrcaProtaud(String.valueOf((java.lang.Character) object[7]));
			certpsic.setCdgoCenmed(String.valueOf((Integer) object[8]));
			certpsic.setCdgoMotivo(String.valueOf((Integer) object[9]));
			certpsic.setCdgoPsicamb((Integer) object[10]);
			certpsic.setCdgoFacult(String.valueOf((Integer) object[11]));
			certpsic.setCdgoCalifi(String.valueOf((Integer) object[12]));
			certpsic.setDesgUsuact((String)object[13]);
			certpsic.setFchaAct((Date) object[14]);
			certpsic.setMrcaActivo(String.valueOf((java.lang.Character) object[15]));
			certpsic.setCaducadoIlt(String.valueOf((java.lang.Character) object[16]));

			resultadosDevueltos.add(certpsic);
		}
		return resultadosDevueltos;
	}

	
	public List<Tbasg101Certpsic> getCertPsicPersonaActivosList(String cdgoPersona) {

		String sqlString = "SELECT "
				+ "		    A.CDGO_CERTPSIC, A.FCHA_RECONOC, UPPER(RTRIM(B.DESG_NOMBRE)) AS MOTIVO, A.FCHA_PROXREV, A.CDGO_DEOBS,"
				+ "		    A.MRCA_CORRVISUAL, A.MRCA_PROTAUD, UPPER(RTRIM(C.DESG_NOMBRE)) AS CALIFICACION, UPPER(RTRIM(D.DESG_NOMBRE)) AS AMBITO, "
				+ "		    UPPER(RTRIM(E.DESG_NOMBRE)) AS CENTRO, UPPER(RTRIM(F.DESG_NOMBRE)) AS NOM_FACULT, "
				+ "		    UPPER(RTRIM(F.DESG_APELL1)) AS APE1_FACULT, UPPER(RTRIM(F.DESG_APELL2)) AS APE2_FACULT,"
				+ "			A.CDGO_MOTIVO, A.CDGO_CALIFI, A.CDGO_PSICAMB, A.CDGO_CENMED, A.CDGO_FACULT "
				+ "		FROM " + "		    PASG.TBASG101_CERTPSIC A "
				+ "		    INNER JOIN PASG.TBASG110_PSICOMOTI B ON B.CDGO_MOTIVO = A.CDGO_MOTIVO"
				+ "		    INNER JOIN PASG.TBASG115_CALIFICAC C ON C.CDGO_CALIFI = A.CDGO_CALIFI "
				+ "		    INNER JOIN PASG.TBASG109_PSICOAMBI D ON D.CDGO_PSICAMB = A.CDGO_PSICAMB"
				+ "		    INNER JOIN PASG.TBASG108_CENTMEDIC E ON E.CDGO_CENMED = A.CDGO_CENMED"
				+ "		    INNER JOIN PASG.TBASG111_FACULTATI F ON F.CDGO_FACULT = A.CDGO_FACULT" + "		WHERE "
				+ "		    A.CDGO_PERSONA = :value" + "		    AND A.MRCA_ACTIVO = 'S'" + "		  "
				+ "		ORDER BY A.FCHA_RECONOC DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg101Certpsic.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}
	
	public List<GetCertPsicPersonaInactivosListDTO> getCertPsicPersonaInactivosList(String cdgoPersona) {

		String sqlString = "SELECT "
				+ "		    A.CDGO_CERTPSIC, A.FCHA_RECONOC, UPPER(RTRIM(B.DESG_NOMBRE)) AS MOTIVO, A.FCHA_PROXREV, A.CDGO_DEOBS, "
				+ "		   	A.MRCA_CORRVISUAL, A.MRCA_PROTAUD, UPPER(RTRIM(C.DESG_NOMBRE)) AS CALIFICACION, A.CADUCADO_ILT, "
				+ "		   	UPPER(RTRIM(D.DESG_NOMBRE)) AS AMBITO, "
				+ "		    UPPER(RTRIM(E.DESG_NOMBRE)) AS CENTRO, UPPER(RTRIM(F.DESG_NOMBRE)) AS NOM_FACULT, "
				+ "		    UPPER(RTRIM(F.DESG_APELL1)) AS APE1_FACULT, UPPER(RTRIM(F.DESG_APELL2)) AS APE2_FACULT"
				+ "		FROM " + "		    PASG.TBASG101_CERTPSIC A "
				+ "		    INNER JOIN PASG.TBASG110_PSICOMOTI B ON B.CDGO_MOTIVO = A.CDGO_MOTIVO"
				+ "		    INNER JOIN PASG.TBASG115_CALIFICAC C ON C.CDGO_CALIFI = A.CDGO_CALIFI "
				+ "		    INNER JOIN PASG.TBASG109_PSICOAMBI D ON D.CDGO_PSICAMB = A.CDGO_PSICAMB"
				+ "		    INNER JOIN PASG.TBASG108_CENTMEDIC E ON E.CDGO_CENMED = A.CDGO_CENMED"
				+ "		    INNER JOIN PASG.TBASG111_FACULTATI F ON F.CDGO_FACULT = A.CDGO_FACULT" + "		WHERE "
				+ "		    A.CDGO_PERSONA = :value" + "		    AND A.MRCA_ACTIVO = 'N'"
				+ "		ORDER BY A.FCHA_RECONOC DESC";

		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetCertPsicPersonaInactivosListDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetCertPsicPersonaInactivosListDTO data = new GetCertPsicPersonaInactivosListDTO();

			data.setCdgoCertpsic(Long.valueOf((int)object[0]));
			data.setFchaReconocCertpsic((Date) object[1]);
			data.setDesgNombrePsicomoti((String) object[2]);
			data.setFchaProxrevCertpsic((Date) object[3]);
			data.setCdgoDeobsCertpsic((String) object[4]);
			data.setMrcaCorrvisualCertpsic(String.valueOf((java.lang.Character) object[5]));
			data.setMrcaProtaudCertpsic(String.valueOf((java.lang.Character) object[6]));
			data.setDesgNombreCalificac((String) object[7]);
			data.setCaducadoIltCertpsic((String) object[8]);
			data.setDesgNombrePsicoambi((String) object[9]);
			data.setDesgNombreCentmedic((String) object[10]);
			data.setDesgNombreFacultati((String) object[11]);
			data.setDesgApell1Facultati((String) object[12]);
			data.setDesgApell2Facultati((String) object[13]);
			
			resultadosDevueltos.add(data);
		}

		return resultadosDevueltos;
	}

	public List<Tbasg101Certpsic> getCertPsicByPerOrderByPsicAmb(String cdgoPersona) {

		String sqlString = "SELECT CDGO_CERTPSIC, CDGO_PERSONA, CDGO_PSICAMB " + "		FROM "
				+ "		    PASG.TBASG101_CERTPSIC" + "		WHERE" + "		    CDGO_PERSONA = :value"
				+ "		    AND MRCA_ACTIVO = 'S'" + "		ORDER BY CDGO_PSICAMB;";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg101Certpsic> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg101Certpsic certpsic = new Tbasg101Certpsic();

			certpsic.setCdgoCertpsic((Integer)object[0]);
			certpsic.setCdgoPersona((Integer)object[1]);
			certpsic.setCdgoPsicamb((Integer)object[2]);
			

			resultadosDevueltos.add(certpsic);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg101Certpsic> getCertPsicByExpOrderByPsicAmb(String cdgoExpedient) {

		String sqlString = "SELECT C.CDGO_CERTPSIC, C.CDGO_PERSONA, C.CDGO_PSICAMB " + "		FROM "
				+ "		    PASG.TBASG101_CERTPSIC C"
				+ "		    INNER JOIN PASG.TBASG104_EXPEDIENT X ON X.CDGO_PERSONA = C.CDGO_PERSONA" + "		WHERE"
				+ "		    X.CDGO_EXPEDIENT= :value" + "		    AND C.MRCA_ACTIVO = 'S'"
				+ "		    AND X.MRCA_ACTIVO = 'S'" + "		ORDER BY CDGO_PSICAMB;";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg101Certpsic.class);
		sqlquery.setParameter("value", cdgoExpedient);
		return sqlquery.getResultList();
	}

	public List<Tbasg101Certpsic> getCertPsicByPerOrderPsicAmbFchaProxRev(String cdgoPersona) {

		String sqlString = "SELECT * " + "		FROM " + "		    PASG.TBASG101_CERTPSIC C" + "		WHERE "
				+ "		    C.CDGO_PERSONA = :value"
				+ "		ORDER BY C.CDGO_PSICAMB, C.MRCA_ACTIVO DESC, C.FCHA_PROXREV DESC;";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg101Certpsic.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}

	public List<Tbasg101Certpsic> getFchaProxRevAOTByCdgoPersona(String cdgoPersona) {

		String sqlString = "SELECT FCHA_PROXREV" + "		FROM " + "			PASG.TBASG101_CERTPSIC" + "		WHERE"
				+ "			CDGO_PERSONA = :cdgoPersona" + "			AND CDGO_PSICAMB IN (1, 2, 3, 4, 5, 8, 9, 10)"
				+ "			AND MRCA_ACTIVO = 'S'" + "		ORDER BY FCHA_PROXREV ASC";
		
		Query sqlquery = em.createNativeQuery(sqlString);
		
		sqlquery.setParameter("cdgoPersona", cdgoPersona);
		
		List<Object> resultados = sqlquery.getResultList();
		List<Tbasg101Certpsic> resultadosDevueltos = new ArrayList<Tbasg101Certpsic>();
		for (Object object : resultados) {
			Tbasg101Certpsic certpsic = new Tbasg101Certpsic();
			
			certpsic.setFchaProxrev((Date) object);
			
			resultadosDevueltos.add(certpsic);
		}
		return resultadosDevueltos;
	}

	public int insertCertPsic(Tbasg101Certpsic bean) {

		String sqlString = "INSERT INTO PASG.TBASG101_CERTPSIC (CDGO_PERSONA, FCHA_PROXREV, FCHA_RECONOC, CDGO_DEOBS, "
				+ "				FCHA_LIMTEMP, MRCA_CORRVISUAL, MRCA_PROTAUD, CDGO_CENMED, CDGO_MOTIVO, CDGO_PSICAMB, "
				+ "				CDGO_FACULT, CDGO_CALIFI, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)		"
				+ "			VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg101Certpsic.class);
		sqlquery.setParameter(1, bean.getCdgoPersona());
		sqlquery.setParameter(2, bean.getFchaProxrev());
		sqlquery.setParameter(3, bean.getFchaReconoc());
		sqlquery.setParameter(4, bean.getCdgoDeobs());
		sqlquery.setParameter(5, bean.getFchaLimtemp());
		sqlquery.setParameter(6, bean.getMrcaCorrvisual());
		sqlquery.setParameter(7, bean.getMrcaProtaud());
		sqlquery.setParameter(8, bean.getCdgoCenmed());
		sqlquery.setParameter(9, bean.getCdgoMotivo());
		sqlquery.setParameter(10, bean.getCdgoPsicamb());
		sqlquery.setParameter(11, bean.getCdgoFacult());
		sqlquery.setParameter(12, bean.getCdgoCalifi());
		sqlquery.setParameter(13, bean.getDesgUsuact());
		sqlquery.setParameter(14, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	@Transactional
	public int updateCertPsic(Tbasg101CertpsicDto bean) {
		int result = 0;
		if (Objects.nonNull(bean.getCdgoCertpsic()) && Objects.nonNull(bean.getCdgoPersona())) {
			String sqlString = "UPDATE PASG.TBASG101_CERTPSIC SET CDGO_PERSONA = :cdgoPersona ";			
			 
			if (Objects.nonNull(bean.getFchaProxrev()))    sqlString += ", FCHA_PROXREV = :fchaProxrev ";

			if (Objects.nonNull(bean.getFchaReconoc()))    sqlString += ", FCHA_RECONOC = :fchaReconoc ";

			if (Objects.nonNull(bean.getCdgoDeobs()))      sqlString += ", CDGO_DEOBS = :cdgoDeobs ";

			if (Objects.nonNull(bean.getFchaLimtemp()))    sqlString += ", FCHA_LIMTEMP = :fchaLimtemp ";

			if (Objects.nonNull(bean.getMrcaCorrvisual())) sqlString += ", MRCA_CORRVISUAL = :mrcaCorrvisua ";

			if (Objects.nonNull(bean.getMrcaProtaud()))    sqlString += ", MRCA_PROTAUD = :mrcaProtaud ";

			if (Objects.nonNull(bean.getCdgoCenmed()))     sqlString += ", CDGO_CENMED = :cdgoCenmed ";

			if (Objects.nonNull(bean.getCdgoMotivo()))     sqlString += ", CDGO_MOTIVO = :cdgoMotivo ";

			if (Objects.nonNull(bean.getCdgoPsicamb()))    sqlString += ", CDGO_PSICAMB = :cdgoPsicamb ";

			if (Objects.nonNull(bean.getCdgoFacult()))     sqlString += ", CDGO_FACULT = :cdgoFacult ";

			if (Objects.nonNull(bean.getCdgoCalifi()))     sqlString += ", CDGO_CALIFI = :cdgoCalifi ";

			if (Objects.nonNull(bean.getDesgUsuact()))     sqlString += ", DESG_USUACT = :desgUsuact ";

			if (Objects.nonNull(bean.getMrcaActivo()))     sqlString += ", MRCA_ACTIVO = :mrcaActivo ";

			sqlString += " WHERE CDGO_CERTPSIC = :cdgoCertpsic ";

			
			Query sqlquery = em.createNativeQuery(sqlString, Tbasg101Certpsic.class);
			
			sqlquery.setParameter("cdgoPersona", bean.getCdgoPersona());

			if (Objects.nonNull(bean.getFchaProxrev()))    sqlquery.setParameter("fchaProxrev", dateFormat.format(bean.getFchaProxrev()));

			if (Objects.nonNull(bean.getFchaReconoc()))    sqlquery.setParameter("fchaReconoc", dateFormat.format(bean.getFchaReconoc()));

			if (Objects.nonNull(bean.getCdgoDeobs()))      sqlquery.setParameter("cdgoDeobs", bean.getCdgoDeobs());

			if (Objects.nonNull(bean.getFchaLimtemp()))    sqlquery.setParameter("fchaLimtemp", dateFormat.format(bean.getFchaLimtemp()));

			if (Objects.nonNull(bean.getMrcaCorrvisual())) sqlquery.setParameter("mrcaCorrvisua", bean.getMrcaCorrvisual());

			if (Objects.nonNull(bean.getMrcaProtaud()))    sqlquery.setParameter("mrcaProtaud", bean.getMrcaProtaud());

			if (Objects.nonNull(bean.getCdgoCenmed()))     sqlquery.setParameter("cdgoCenmed", bean.getCdgoCenmed());

			if (Objects.nonNull(bean.getCdgoMotivo()))     sqlquery.setParameter("cdgoMotivo", bean.getCdgoMotivo());

			if (Objects.nonNull(bean.getCdgoPsicamb()))    sqlquery.setParameter("cdgoPsicamb", bean.getCdgoPsicamb());

			if (Objects.nonNull(bean.getCdgoFacult()))     sqlquery.setParameter("cdgoFacult", bean.getCdgoFacult());

			if (Objects.nonNull(bean.getCdgoCalifi()))     sqlquery.setParameter("cdgoCalifi", bean.getCdgoCalifi());

			if (Objects.nonNull(bean.getDesgUsuact()))     sqlquery.setParameter("desgUsuact", bean.getDesgUsuact());

			if (Objects.nonNull(bean.getMrcaActivo()))     sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());

			sqlquery.setParameter("cdgoCertpsic", bean.getCdgoCertpsic());

			result = sqlquery.executeUpdate();   
		}

		return result;
	}

	public int inactiveByCdgoCertPsic(Tbasg101Certpsic bean) {

		String sqlString = "UPDATE PASG.TBASG101_CERTPSIC SET" + "			DESG_USUACT = :usuAct, "
				+ "			FCHA_ACT = CURRENT_DATE, " + "			MRCA_ACTIVO = 'N'"
				+ "		WHERE CDGO_CERTPSIC = :cdgoCertPsic";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg101Certpsic.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoCertPsic", bean.getCdgoCertpsic());
		return sqlquery.executeUpdate();
	}

	public int desactivaCertPsicByPsicAmb(Tbasg101Certpsic bean) {

		String sqlString = "UPDATE " + "		    PASG.TBASG101_CERTPSIC " + "		SET "
				+ "			DESG_USUACT = :usuAct, " + "			FCHA_ACT = CURRENT_DATE, "
				+ "		    MRCA_ACTIVO = 'N' " + "		WHERE " + "		    CDGO_PERSONA = :cdgoPersona"
				+ "		    AND CDGO_PSICAMB = :cdgoPsicAmb";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg101Certpsic.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoPersona", bean.getCdgoPersona());
		sqlquery.setParameter("cdgoPsicAmb", bean.getCdgoPsicamb());
		return sqlquery.executeUpdate();
	}
	
	public int desactivaCertPsicByPsicAmbRepetido(Tbasg101Certpsic bean) {

		String sqlString = " UPDATE  PASG.TBASG101_CERTPSIC 	SET FCHA_ACT = CURRENT_DATE, "
				+ "	 MRCA_ACTIVO = 'N'	WHERE	CDGO_CERTPSIC  = :cdgoCertpsic ";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg101Certpsic.class);
		sqlquery.setParameter("cdgoCertpsic", bean.getCdgoCertpsic());
		return sqlquery.executeUpdate();
	}

	public List<Tbasg101Certpsic> getCertPsicByPerList(String cdgoPersona) {

		String sqlString = "SELECT" + "		    C.MRCA_ACTIVO," + "		    C.FCHA_PROXREV,"
				+ "		    C.CDGO_PSICAMB, " + "		    P.DESG_NOMBRE" + "		FROM"
				+ "		    PASG.TBASG101_CERTPSIC C"
				+ "		    LEFT JOIN PASG.TBASG109_PSICOAMBI P ON (P.CDGO_PSICAMB = C.CDGO_PSICAMB)" + "		WHERE"
				+ "		    C.CDGO_PERSONA = :value" + "		    AND C.FCHA_PROXREV IS NOT NULL"
				+ "		    AND C.CDGO_CALIFI <> 3"
				+ "		ORDER BY C.CDGO_PSICAMB ASC, C.MRCA_ACTIVO DESC, C.FCHA_PROXREV DESC;";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg101Certpsic.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}

	public List<GetRelHabPsicByCdgoCertPsicDTO> getRelHabPsicByCdgoCertPsic(Integer cdgoCertpsic) {

		String sqlString = "SELECT C.CDGO_CERTPSIC, C.CDGO_PSICAMB, T.CDGO_TIPOHAB, T.DESG_NOMBRE"
				+ "		FROM PASG.TBASG101_CERTPSIC C "
				+ "			INNER JOIN PASG.TBASG180_REL_HAB_PSIC R ON C.CDGO_PSICAMB = R.CDGO_PSICAMB "
				+ "			INNER JOIN PASG.TBASG123_TIPOHABIL T ON R.CDGO_TIPOHAB = T.CDGO_TIPOHAB"
				+ "		WHERE C.CDGO_CERTPSIC = :value" + "		ORDER BY T.CDGO_TIPOHAB";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoCertpsic);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetRelHabPsicByCdgoCertPsicDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetRelHabPsicByCdgoCertPsicDTO relhabpsic = new GetRelHabPsicByCdgoCertPsicDTO();

			relhabpsic.setCdgoCertPsic((Integer)object[0]);
			relhabpsic.setCdgoPsicAmb((Integer)object[1]);
			relhabpsic.setCdgoTipoHab((Integer)object[2]);
			relhabpsic.setDesgNombre((String)object[3]);

			resultadosDevueltos.add(relhabpsic);
		}
		return resultadosDevueltos;
	}

	public <T> String convertToString(T value) {
        return value != null ? value.toString() : null;          
    }
	
	public List<GetCertsPsicByPersListDTO>getCertsPsicByPersList(List<Integer> mapPending){
		
		StringBuilder strGetCertsPsicByPersList = new StringBuilder();
		
		String sqlString = "SELECT C.CDGO_PERSONA, C.MRCA_ACTIVO, C.FCHA_PROXREV, C.CDGO_PSICAMB, P.DESG_NOMBRE"
				+ " FROM PASG.TBASG101_CERTPSIC C "
				+ "INNER JOIN PASG.TBASG100_PERSONA PE ON PE.CDGO_PERSONA = C.CDGO_PERSONA "
				+ "LEFT JOIN PASG.TBASG109_PSICOAMBI P ON (P.CDGO_PSICAMB = C.CDGO_PSICAMB) "
				+ "WHERE 1=1";
		
		strGetCertsPsicByPersList.append(sqlString);
		System.out.println("----------------------");
		System.out.println(strGetCertsPsicByPersList.toString());
		System.out.println("----------------------");
		
		if(mapPending!=null) {
			strGetCertsPsicByPersList.append(" AND C.CDGO_PERSONA IN (" + mapPending.get(0));
			
			for(int i = 1; i < mapPending.size(); i++) {
				strGetCertsPsicByPersList.append(", " + mapPending.get(i));
			}
			strGetCertsPsicByPersList.append(") AND C.FCHA_PROXREV IS NOT NULL AND C.CDGO_CALIFI <> 3");
		}
		
		System.out.println("----------------------");
		System.out.println(strGetCertsPsicByPersList.toString());
		System.out.println("----------------------");
		
		strGetCertsPsicByPersList.append(" ORDER BY PE.DESG_APELL1 ASC, PE.DESG_APELL2 ASC, C.CDGO_PERSONA ASC, C.CDGO_PSICAMB ASC, C.MRCA_ACTIVO DESC, "
				+ "C.FCHA_PROXREV DESC");
		
		System.out.println("----------------------");
		System.out.println(strGetCertsPsicByPersList.toString());
		System.out.println("----------------------");
		
		Query sqlquery = em.createNativeQuery(strGetCertsPsicByPersList.toString()); 
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetCertsPsicByPersListDTO> resultadosDevueltos = new ArrayList<>();
		
		for(Object[] object : resultados) {
			GetCertsPsicByPersListDTO data = new GetCertsPsicByPersListDTO();
			if(object[0]!=null) {
				data.setCdgoPersona((Integer)object[0]);
			}
			if(object[1]!=null) {
				data.setMrcaActivo((char)object[1]);
			}
			if(object[2]!=null) {
				data.setFchaProxrev((Date)object[2]);
			}
			if(object[3]!=null) {
				data.setCdgoPsicamb((Integer)object[3]);
			}
			if(object[4]!=null) {
				data.setDesgNombre((String)object[4]);
			}
			resultadosDevueltos.add(data);
			
		}
		return resultadosDevueltos;
	}

}

