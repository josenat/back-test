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


import org.springframework.transaction.annotation.Transactional;

import renfe.com.dto.GetDatosAcreditacionesDTO;
import renfe.com.dto.GetExpeAcreTipoValidezReciclajeDTO;
import renfe.com.dto.GetfindListAcreditaByCdgoPerDTO;
import renfe.com.model.dto.Tbasg267PlanningAccredDTO;
import renfe.com.model.dto.Tbasg267PlanningAccredParamDTO;
import renfe.com.model.entity.Tbasg201ErrSalud;
import renfe.com.model.entity.Tbasg267ExpedAcred;
import renfe.com.repository.Tbasg267ExpedAcredRepositoryCustom;

public class Tbasg267ExpedAcredRepositoryImpl implements Tbasg267ExpedAcredRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


	public List<GetDatosAcreditacionesDTO> getDatosAcreditaciones(String cdgoPersona) {
		//TBASG125_EMPRESA   CDGO_EMPRESA
		String sqlString = "SELECT DISTINCT EXP.CDGO_ACREDITA,TIPO.DESG_ACREDITA,PU.DESG_PUERTO,LI.DESG_LINEA,ESTAC.DESG_NOMLARGO,EMP.DESG_NOMBRE,       "
				+ "			EXP.FCHA_ACT, EXP.CDGO_ESTACION,  TIES.DESG_ESTADO,AF.DESG_DESCCURSO, AIC.FCHA_CURSO, EST.FCHA_ACT AS FCHA_ESTADO_ACRE  "
				+ "         ,EXP.MRCA_ACTIVO, EXP.DESG_OBSERVA, EMP.CDGO_EMPRESA, EXP.FCHA_CADUC, CERTIFICADO.FCHA_PROXREV, CERTIFICADO.DESG_CALIFI"

				+ "         FROM PASG.TBASG267_EXPED_ACRED EXP  "
				+ "			INNER JOIN PASG.TBASG262_TIPO_ACREDITA TIPO ON EXP.CDGO_TIPOACREDITA = TIPO.CDGO_TIPOACR     "
				+ "            INNER JOIN PASG.TBASG266_ESTADO_ACRE EST ON EXP.CDGO_ACREDITA = EST.CDGO_ACREDITA  "
				+ "            INNER JOIN PASG.TBASG263_TIPO_ESTADO TIES ON EST.CDGO_ESTADO = TIES.CDGO_ESTADO"
				+ "            LEFT JOIN PASG.TBASG121_ACTAFORMA AF ON EXP.CDGO_ACREDITA=AF.CDGO_ACREDITA"
				+ "            LEFT JOIN PASG.TBASG146_ACTAINCAL AIC ON AF.CDGO_ACTAFORM=AIC.CDGO_ACTAFORM"
				+ "            LEFT JOIN PASG.TBASG264_AMBITO_PUERT PU ON EXP.CDGO_PUERTO=PU.CDGO_PUERTO"
				+ "            LEFT JOIN PASG.TBASG265_AMBITO_LINEA LI ON EXP.CDGO_LINEA=LI.CDGO_LINEA"
				+ "            LEFT JOIN PASG.TBASG128_ESTACLINE ESTAC ON EXP.CDGO_ESTACION = ESTAC.CDGO_ESTACION"
				+ "            INNER JOIN PASG.TBASG125_EMPRESA EMP ON EXP.CDGO_EMPRESA=EMP.CDGO_EMPRESA"
				+ "			   LEFT JOIN( SELECT "
				+ "            		CERT.CDGO_PERSONA,"
				+ "            		PSI.CDGO_PSICAMB_FOM,"
				+ "            		CERT.FCHA_PROXREV  AS FCHA_PROXREV,"
				+ "            		CALIFI.DESG_NOMBRE AS DESG_CALIFI"
				+ "        	   FROM PASG.TBASG101_CERTPSIC CERT"
				+ "        	   INNER JOIN"
				+ "            	PASG.TBASG109_PSICOAMBI PSI ON CERT.CDGO_PSICAMB = PSI.CDGO_PSICAMB"
				+ "        	   INNER JOIN"
				+ "            	PASG.TBASG115_CALIFICAC CALIFI ON CALIFI.CDGO_CALIFI = CERT.CDGO_CALIFI"
				+ "        	  WHERE"
				+ "            	CERT.mrca_activo = 'S') AS CERTIFICADO"
				+ "			  ON CERTIFICADO.CDGO_PERSONA = EXP.CDGO_PERSONA AND CERTIFICADO.CDGO_PSICAMB_FOM = EXP.CDGO_TIPOACREDITA"
				+ "            WHERE  EXP.CDGO_PERSONA = :value   "
				+ "            AND EST.FCHA_ESTADO IN (SELECT (MAX(FCHA_ESTADO)) FROM PASG.TBASG266_ESTADO_ACRE ESTADO WHERE ESTADO.CDGO_ACREDITA=EXP.CDGO_ACREDITA)  "
				+ "            AND (AIC.FCHA_CURSO IN (SELECT (MAX(FCHA_CURSO)) FROM PASG.TBASG146_ACTAINCAL CURSO WHERE CURSO.CDGO_ACTAFORM=AF.CDGO_ACTAFORM) OR AIC.FCHA_CURSO IS NULL)"
				+ "            AND (AF.CDGO_ACTAFORM IN (SELECT (MAX(CDGO_ACTAFORM)) FROM PASG.TBASG121_ACTAFORMA ACTA WHERE ACTA.CDGO_ACREDITA=AF.CDGO_ACREDITA) OR AF.CDGO_ACTAFORM IS NULL)"
				+ "	      	ORDER BY EXP.CDGO_ACREDITA DESC";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetDatosAcreditacionesDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetDatosAcreditacionesDTO data = new GetDatosAcreditacionesDTO();
			
			data.setCdgoAcredita((Integer)object[0]);
			data.setDesgAcredita((String)object[1]);
			data.setDesgPuerto((String)object[2]);
			data.setDesgLinea((String)object[3]);
			data.setDesgNomlargo((String)object[4]);
			data.setDesgNombre((String)object[5]);
			data.setFchaAct((Date) object[6]);
			data.setCdgoEstacion((String)object[7]);
			data.setDesgEstado((String)object[8]);
			data.setDesgDesccurso((String)object[9]);
			data.setFchaCurso((Date) object[10]); 
			data.setFchaEstadoAcre((Date) object[11]); 
			data.setMrcaActivo(String.valueOf((Character) object[12]));
			data.setDesgObserva((String)object[13]);
			data.setCdgoEmpresa((Integer)object[14]);
			data.setFchaCaduc((Date)object[15]);
			data.setFchaCaducPsico((Date)object[16]);
			data.setCalificacion((String)object[17]);

			resultadosDevueltos.add(data);
		}
		return resultadosDevueltos;
	}

	public List<GetfindListAcreditaByCdgoPerDTO> findListAcreditaByCdgoPer(Integer cdgoPersona) {

		String sqlString = "SELECT DISTINCT EXP.CDGO_ACREDITA,TIPO.DESG_ACREDITA,PUERTO.DESG_PUERTO,LINEA.DESG_LINEA,ESTAC.DESG_NOMLARGO,       "
				+ "			EXP.FCHA_ACT,TIES.DESG_ESTADO"
				+ "				FROM PASG.TBASG267_EXPED_ACRED EXP             "
				+ "				INNER JOIN PASG.TBASG262_TIPO_ACREDITA TIPO ON EXP.CDGO_TIPOACREDITA = TIPO.CDGO_TIPOACR      "
				+ "				INNER JOIN PASG.TBASG266_ESTADO_ACRE EST ON EXP.CDGO_ACREDITA = EST.CDGO_ACREDITA   "
				+ "				INNER JOIN PASG.TBASG263_TIPO_ESTADO TIES ON EST.CDGO_ESTADO = TIES.CDGO_ESTADO"
				+ "				LEFT OUTER JOIN PASG.TBASG264_AMBITO_PUERT PUERTO ON EXP.CDGO_PUERTO =  PUERTO.CDGO_PUERTO       "
				+ "				LEFT OUTER JOIN PASG.TBASG265_AMBITO_LINEA  LINEA ON  EXP.CDGO_LINEA = LINEA.CDGO_LINEA       "
				+ "				LEFT OUTER JOIN PASG.TBASG127_LINEAS  LIN ON  EXP.CDGO_LINEA = LIN.CDGO_LINEA         "
				+ "				LEFT OUTER JOIN PASG.TBASG128_ESTACLINE ESTAC  ON  EXP.CDGO_ESTACION = ESTAC.CDGO_ESTACION      "
				+ "				INNER JOIN PASG.TBASG100_PERSONA PERSON ON EXP.CDGO_PERSONA = PERSON.CDGO_PERSONA "
				+ "				WHERE EXP.CDGO_PERSONA = :value"
				+ "				AND EST.FCHA_ESTADO	IN (SELECT MAX(FCHA_ESTADO)"
				+ "										FROM PASG.TBASG266_ESTADO_ACRE ESTACRE"
				+ "										WHERE "
				+ "											ESTACRE.CDGO_ACREDITA=EST.CDGO_ACREDITA"
				+ "											AND ESTACRE.MRCA_ACTIVO = 'S' )		 "
				+ "				ORDER BY EXP.CDGO_ACREDITA DESC";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetfindListAcreditaByCdgoPerDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetfindListAcreditaByCdgoPerDTO acredita = new GetfindListAcreditaByCdgoPerDTO();
	
			acredita.setCdgoAcredita((Integer) object[0]);
			acredita.setDesgAcredita((String)object[1]);
			acredita.setDesgPuerto((String)object[2]);
			acredita.setDesgLinea((String)object[3]);
			acredita.setDesgNomLargo((String)object[4]);
			acredita.setFchaAct((Date)object[5]);
			acredita.setDesgEstado((String)object[6]);

			resultadosDevueltos.add(acredita);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg267PlanningAccredDTO> findDataPlanificacionAcreditaciones(Tbasg267PlanningAccredParamDTO bean) {

		String sqlString = 
			"  SELECT DISTINCT EXP.CDGO_ACREDITA AS CODACRE, PERSON.DESG_NOMBRE AS NOMBRE, PERSON.DESG_APELL1 AS APELLID1, "
        	+" PERSON.DESG_APELL2 AS APELLID2, PERSON.DESG_NIFPAS AS NIF, PERSON.DESG_MATRICULA AS MATRICULA, TIPO.DESG_ACREDITA AS TIPO, "
			+" TIPES.DESG_ESTADO AS ESTADO, EXP.FCHA_CADUC AS FECHACADUC, AA.DESG_NOMBRE AS DESG_AREACT, AT.DESG_NOMBRE AS DESG_ARETER,  "
			+" CC.DESG_NOMBRE AS DESG_CENTCONT, E.DESG_NOMBRE AS DESG_EMPRESA, PERSON.CDGO_PERSONA AS CDGO_PERSON, EXP.CDGO_TIPOACREDITA AS TIPOACRE, "
        	+" EXP.FCHA_ACREDITA AS FECACRE, PSICO.FCHA_PROXREV AS FECPROX, AIC.FCHA_CURSO AS FECCURSO "
    	
			+" FROM PASG.TBASG267_EXPED_ACRED EXP INNER JOIN PASG.TBASG100_PERSONA PERSON ON EXP.CDGO_PERSONA = PERSON.CDGO_PERSONA "
			+" LEFT JOIN PASG.TBASG262_TIPO_ACREDITA TIPO ON EXP.CDGO_TIPOACREDITA = TIPO.CDGO_TIPOACR "
			+" INNER JOIN PASG.TBASG266_ESTADO_ACRE ESTADO ON EXP.CDGO_ACREDITA = ESTADO.CDGO_ACREDITA "
			+" INNER JOIN PASG.TBASG263_TIPO_ESTADO TIPES ON ESTADO.CDGO_ESTADO = TIPES.CDGO_ESTADO "
	    	+" LEFT JOIN PASG.TBASG121_ACTAFORMA ACT ON EXP.CDGO_ACREDITA = ACT.CDGO_ACREDITA "
        	+" LEFT JOIN PASG.TBASG146_ACTAINCAL AIC ON ACT.CDGO_ACTAFORM = AIC.CDGO_ACTAFORM "
        	+" LEFT JOIN PASG.TBASG115_CALIFICAC CAL ON AIC.CDGO_CALIFI = CAL.CDGO_CALIFI "
        	+" LEFT JOIN PASG.TBASG101_CERTPSIC PSICO ON PERSON.CDGO_PERSONA = PSICO.CDGO_PERSONA "
			+" LEFT JOIN PASG.TBASG105_AREACTIVI AA ON (PERSON.CDGO_AREACT = AA.CDGO_AREACT)  "
			+" LEFT JOIN PASG.TBASG141_ARETER AT ON (PERSON.CDGO_ARETER = AT.CDGO_ARETER)  "
			+" LEFT JOIN PASG.TBASG132_CENTCONT CC ON (PERSON.CDGO_CENTCONT = CC.CDGO_CENTCONT)  "
			+" LEFT JOIN PASG.TBASG152_PERSEMP PERSEMP ON (PERSEMP.CDGO_PERSONA = PERSON.CDGO_PERSONA) "
			+" LEFT JOIN PASG.TBASG125_EMPRESA E ON (PERSEMP.CDGO_EMPRESA = E.CDGO_EMPRESA)  "
	    	
			+" WHERE PERSON.CDGO_PERSONA = EXP.CDGO_PERSONA  "
			+" AND (PSICO.FCHA_RECONOC IN (SELECT(MAX(FCHA_RECONOC)) FROM PASG.TBASG101_CERTPSIC CERTIF WHERE CERTIF.CDGO_PERSONA=PERSON.CDGO_PERSONA) OR PSICO.FCHA_RECONOC IS NULL) "
        	+" AND (ESTADO.FCHA_ESTADO IN (SELECT MAX(FCHA_ESTADO) FROM PASG.TBASG266_ESTADO_ACRE ESTAD WHERE ESTAD.CDGO_ACREDITA = EXP.CDGO_ACREDITA)) "
        	+" AND (PSICO.FCHA_PROXREV IN (SELECT(MAX(FCHA_PROXREV)) FROM PASG.TBASG101_CERTPSIC CERTIF WHERE CERTIF.CDGO_PERSONA=PERSON.CDGO_PERSONA) OR PSICO.FCHA_PROXREV IS NULL) ";		

		if (Objects.nonNull(bean.getIsShowFit())) { 
			if ("S".equals(bean.getIsShowFit())) {
				sqlString += " AND AIC.CDGO_CALIFI IN (8) "; 
			}
		} 
	   
		if (Objects.nonNull(bean.getActivityAreaId()))        sqlString += " AND PERSON.CDGO_AREACT = :activityAreaId "; 
			  
		if (Objects.nonNull(bean.getTerritorialAreaId()))     sqlString += " AND PERSON.CDGO_ARETER = :territorialAreaId "; 

		if (Objects.nonNull(bean.getAccountingCenterId()))    sqlString += " AND PERSON.CDGO_CENTCONT = :accountingCenterId "; 						
			
		if (Objects.nonNull(bean.getDocumentId()))            sqlString += " AND PERSON.DESG_NIFPAS LIKE :documentId "; 	
	
		if (Objects.nonNull(bean.getTuitionDesc()))           sqlString += " AND PERSON.DESG_MATRICULA LIKE :tuitionDesc ";
		
		if (Objects.nonNull(bean.getFirstName()))             sqlString += " AND PERSON.DESG_NOMBRE LIKE :firstName ";	
		
		if (Objects.nonNull(bean.getLastName()))              sqlString += " AND PERSON.DESG_APELL1 LIKE :lastName ";
		
		if (Objects.nonNull(bean.getSecondName()))            sqlString += " AND PERSON.DESG_APELL2 LIKE :secondName ";
				
		if (Objects.nonNull(bean.getAccreTypeId()))           sqlString += " AND EXP.CDGO_TIPOACREDITA = :accreTypeId ";

		if (Objects.nonNull(bean.getAccredStatusId()))        sqlString += " AND TIPES.CDGO_ESTADO = :accredStatusId ";

		if (Objects.nonNull(bean.getPersonalOption())) {
			if ("RENFE".equals(bean.getPersonalOption())) {
				sqlString += " AND PERSON.DESG_MATRICULA != '' AND PERSON.DESG_MATRICULA IS NOT NULL ";

			} else if ("EXTERNO".equals(bean.getPersonalOption())) {
				sqlString += " AND (PERSON.DESG_MATRICULA = '' OR PERSON.DESG_MATRICULA IS NULL) ";

				if (Objects.nonNull(bean.getCompanyId())) {
					sqlString += " AND A.CDGO_EMPRESA = :companyId ";
				}

			} else if ("AMBOS".equals(bean.getPersonalOption())) {
				if (Objects.nonNull(bean.getCompanyId())) {
					sqlString += " AND ( (PERSON.DESG_MATRICULA != '' AND PERSON.DESG_MATRICULA IS NOT NULL) OR A.CDGO_EMPRESA = :companyId ) ";
				
				} else {
					sqlString += " AND (PERSON.DESG_MATRICULA != '' AND PERSON.DESG_MATRICULA IS NOT NULL) ";
				} 
			}				
		}       
		
		sqlString += " ORDER BY EXP.CDGO_ACREDITA DESC ";		

		Query sqlquery = em.createNativeQuery(sqlString);


		if (Objects.nonNull(bean.getActivityAreaId())) sqlquery.setParameter("activityAreaId", bean.getActivityAreaId());

		if (Objects.nonNull(bean.getTerritorialAreaId())) sqlquery.setParameter("territorialAreaId", bean.getTerritorialAreaId());

		if (Objects.nonNull(bean.getDocumentId())) sqlquery.setParameter("documentId", "%" + bean.getDocumentId() + "%");

		if (Objects.nonNull(bean.getTuitionDesc())) sqlquery.setParameter("tuitionDesc", "%" + bean.getTuitionDesc() + "%");
		
		if (Objects.nonNull(bean.getFirstName())) sqlquery.setParameter("firstName", "%" + bean.getFirstName() + "%");	
		
		if (Objects.nonNull(bean.getLastName())) sqlquery.setParameter("lastName", "%" + bean.getLastName() + "%");
		
		if (Objects.nonNull(bean.getSecondName())) sqlquery.setParameter("secondName", "%" + bean.getSecondName() + "%");

		if (Objects.nonNull(bean.getAccreTypeId())) sqlquery.setParameter("accreTypeId", bean.getAccreTypeId());

		if (Objects.nonNull(bean.getAccredStatusId())) sqlquery.setParameter("accredStatusId", bean.getAccredStatusId());

		if (Objects.nonNull(bean.getCompanyId())) sqlquery.setParameter("companyId", bean.getCompanyId());

		List<Object[]> results = sqlquery.getResultList();

		List<Tbasg267PlanningAccredDTO> resultList = new ArrayList<>();
  
		for (Object[] item : results) {
		  Tbasg267PlanningAccredDTO row = new Tbasg267PlanningAccredDTO();
		  row.setCodigoAcre((Integer) item[0]);
		  row.setNombre((String) item[1]);
		  row.setApellid1((String) item[2]);
		  row.setApellid2((String) item[3]);
		  row.setNif((String) item[4]);
		  row.setMatricula((String) item[5]);
		  row.setTipo((String) item[6]);
		  row.setEstado((String) item[7]);
		  row.setFechaCaduc(this.convertToString(item[8])); 
		  row.setDesgAreact((String) item[9]);
		  row.setDesgAreter((String) item[10]);
		  row.setDesgCentcont((String) item[11]);
		  row.setDesgEmpresa((String) item[12]);
		  row.setCdgoPerson((Integer) item[13]);
		  row.setTipoAcre((String) item[14]);
		  row.setFechaAcre(this.convertToString(item[15])); 
		  row.setFechaProx(this.convertToString(item[16])); 
		  row.setFechaCurso(this.convertToString(item[17])); 

		  resultList.add(row);
		}
  
		return resultList;
	}

	public List<Tbasg267ExpedAcred> getAcreditacionesPersonaList(String cdgoPersona) {

		String sqlString = "SELECT CDGO_ACREDITA FROM PASG.TBASG267_EXPED_ACRED WHERE CDGO_PERSONA = " + cdgoPersona + " ORDER BY 1 DESC";
		Query sqlquery = em.createNativeQuery(sqlString);
		
		List<Integer> resultados = sqlquery.getResultList();
		List<Tbasg267ExpedAcred> resultadosDevueltos = new ArrayList<>();
		for (Integer item : resultados) {
			Tbasg267ExpedAcred data = new Tbasg267ExpedAcred();
			
			data.setCdgoAcredita(item);
			//data.setCdgoEmpresa((Integer)item[1]);
			//data.setCdgoEstacion((String)item[2]);
			//data.setCdgoPersona((Integer)item[3]);
			//data.setDesgObserva((String)item[4]);
			//data.setDesgUsuact((String)item[5]);
			//data.setFchaAcredita((Date)item[6]);
			//data.setFchaAct((Date)item[7]);
			//data.setFchaCaduc((Date)item[8]);
			//data.setMrcaActivo((String)item[9]);

			resultadosDevueltos.add(data);
		}

		return resultadosDevueltos;
	}

	public List<Tbasg267ExpedAcred> getAcreditacionesPersonaListCount(String cdgoPersona) {

		String sqlString = "SELECT COUNT(*) FROM PASG.TBASG267_EXPED_ACRED WHERE CDGO_PERSONA = :codPersona";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg267ExpedAcred.class);
		sqlquery.setParameter("codPersona", cdgoPersona);
		return sqlquery.getResultList();
	}

	public List<Tbasg267ExpedAcred> getAcreditacion(String cdgoAcredita) {

		String sqlString = "SELECT CDGO_ACREDITA,FCHA_ACREDITA,CDGO_PERSONA,CDGO_EMPRESA,CDGO_TIPOACREDITA,"
				+ "			       CDGO_PUERTO,CDGO_LINEA,CDGO_ESTACION,DESG_OBSERVA,DESG_USUACT,"
				+ "			       FCHA_ACT,FCHA_CADUC,MRCA_ACTIVO  FROM PASG.TBASG267_EXPED_ACRED"
				+ "			 WHERE CDGO_ACREDITA = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg267ExpedAcred.class);
		sqlquery.setParameter("value", cdgoAcredita);
		return sqlquery.getResultList();
	}

	public List<Tbasg267ExpedAcred> getAcreditacionesDeLaPersona(String cdgoPersona) {

		String sqlString = "SELECT CDGO_ACREDITA,FCHA_ACREDITA,CDGO_PERSONA,CDGO_EMPRESA,CDGO_TIPOACREDITA,"
				+ "			       CDGO_PUERTO,CDGO_LINEA,CDGO_ESTACION,DESG_OBSERVA,DESG_USUACT,"
				+ "			       FCHA_ACT,FCHA_CADUC,MRCA_ACTIVO  FROM PASG.TBASG267_EXPED_ACRED"
				+ "			 WHERE CDGO_PERSONA = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg267ExpedAcred.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}
	
	public List<Tbasg267ExpedAcred> getUltimaAcreditacion() {

		String sqlString = "SELECT CDGO_ACREDITA FROM PASG.TBASG267_EXPED_ACRED WHERE CDGO_ACREDITA = (SELECT MAX(CDGO_ACREDITA) FROM PASG.TBASG267_EXPED_ACRED)";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object> resultados = sqlquery.getResultList();
		List<Tbasg267ExpedAcred> resultadosDevueltos = new ArrayList<>();
		for (Object object : resultados) {
			Tbasg267ExpedAcred expeAcre = new Tbasg267ExpedAcred();
			
			expeAcre.setCdgoAcredita((Integer)object);

			resultadosDevueltos.add(expeAcre);
		}
		return resultadosDevueltos;
	}

	public int insertAcreditacion(Tbasg267ExpedAcred bean) {

		String sqlString = "INSERT INTO  PASG.TBASG267_EXPED_ACRED (FCHA_ACREDITA,CDGO_PERSONA,CDGO_EMPRESA,CDGO_TIPOACREDITA,CDGO_PUERTO,CDGO_LINEA,CDGO_ESTACION,DESG_OBSERVA,DESG_USUACT,FCHA_ACT,MRCA_ACTIVO,FCHA_CADUC)"
				+ "		VALUES (CURRENT_DATE, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE, 'S', ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg267ExpedAcred.class);
		sqlquery.setParameter(1, bean.getCdgoPersona());
		sqlquery.setParameter(2, bean.getCdgoEmpresa());
		sqlquery.setParameter(3, bean.getCdgoTipoacredita());
		sqlquery.setParameter(4, bean.getCdgoPuerto());
		sqlquery.setParameter(5, bean.getCdgoLinea());
		sqlquery.setParameter(6, bean.getCdgoEstacion());
		sqlquery.setParameter(7, bean.getDesgObserva());
		sqlquery.setParameter(8, bean.getDesgUsuact());
		sqlquery.setParameter(9, bean.getFchaCaduc());
		return sqlquery.executeUpdate();
	}
	
	public int updateAcreditacion(Tbasg267ExpedAcred bean) {

		String sqlString = "UPDATE PASG.TBASG267_EXPED_ACRED SET" + " CDGO_EMPRESA= :cdgoEmpresa, CDGO_TIPOACREDITA= :cdgoTipoacredita, CDGO_PUERTO= :cdgoPuerto, CDGO_LINEA= :cdgoLinea, CDGO_ESTACION= :cdgoEstacion, FCHA_CADUC = :fchaCaduc "
				+ "		WHERE CDGO_ACREDITA = :cdgoAcredita";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg267ExpedAcred.class);
		sqlquery.setParameter("cdgoAcredita", bean.getCdgoAcredita());
		sqlquery.setParameter("cdgoEmpresa", bean.getCdgoEmpresa());
		sqlquery.setParameter("cdgoTipoacredita", bean.getCdgoTipoacredita());
		sqlquery.setParameter("cdgoPuerto", bean.getCdgoPuerto());
		sqlquery.setParameter("cdgoLinea", bean.getCdgoLinea());
		sqlquery.setParameter("cdgoEstacion", bean.getCdgoEstacion());
		sqlquery.setParameter("fchaCaduc", bean.getFchaCaduc());
		return sqlquery.executeUpdate();
	}

	@Transactional
	public int updateAcreditacionMantenimiento(GetDatosAcreditacionesDTO bean) {
		int result = 0;
		if (Objects.nonNull(bean.getCdgoAcredita())) {
			String sqlString = "UPDATE PASG.TBASG267_EXPED_ACRED SET FCHA_ACT=CURRENT_DATE ";

			if (Objects.nonNull(bean.getMrcaActivo())) sqlString += ", MRCA_ACTIVO= :mrcaActivo ";

			if (Objects.nonNull(bean.getCdgoEmpresa())) sqlString += ", CDGO_EMPRESA= :cdgoEmpresa ";

			if (Objects.nonNull(bean.getDesgObserva())) sqlString += ", DESG_OBSERVA= :desgObserva ";

			sqlString += " WHERE CDGO_ACREDITA = :cdgoAcredita ";			


			Query sqlquery = em.createNativeQuery(sqlString, Tbasg267ExpedAcred.class);

			if (Objects.nonNull(bean.getMrcaActivo())) sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
			
			if (Objects.nonNull(bean.getCdgoEmpresa())) sqlquery.setParameter("cdgoEmpresa", bean.getCdgoEmpresa());

			if (Objects.nonNull(bean.getDesgObserva())) sqlquery.setParameter("desgObserva", bean.getDesgObserva());

			sqlquery.setParameter("cdgoAcredita", bean.getCdgoAcredita());

			result = sqlquery.executeUpdate();
		}

		return result;
	}

	public List<Tbasg267ExpedAcred> getAcrePersonaObject(String cdgoAcredita) {

		String sqlString = "SELECT" + "			ACRE.CDGO_ACREDITA," + "			ACRE.CDGO_TIPOACREDITA,"
				+ "			ACRE.DESG_OBSERVA," + "			PER.DESG_NOMBRE AS DESG_PERSONA,"
				+ "			PER.DESG_APELL1," + "			PER.DESG_APELL2," + "			PER.DESG_MATRICULA,"
				+ "			PER.DESG_NIFPAS" + "		FROM PASG.TBASG267_EXPED_ACRED ACRE,PASG.TBASG100_PERSONA PER"
				+ "			WHERE PER.CDGO_PERSONA = ACRE.CDGO_PERSONA"
				+ "			AND ACRE.CDGO_ACREDITA =  :cdgoAcreditacion";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg267ExpedAcred.class);
		sqlquery.setParameter("cdgoAcreditacion", cdgoAcredita);
		return sqlquery.getResultList();
	}
	
	public List<GetExpeAcreTipoValidezReciclajeDTO> getExpeAcreTipoValidezReciclaje(Integer cdgoAcredita) {

		String sqlString = " SELECT E.CDGO_ACREDITA, T.CDGO_TIPOACR, T.VALIDEZ_RECICLAJE FROM PASG.TBASG267_EXPED_ACRED E INNER JOIN PASG.TBASG262_TIPO_ACREDITA T "
				+ "ON E.CDGO_TIPOACREDITA  = T.CDGO_TIPOACR WHERE E.CDGO_ACREDITA = :cdgoAcreditacion ";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("cdgoAcreditacion", cdgoAcredita);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetExpeAcreTipoValidezReciclajeDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetExpeAcreTipoValidezReciclajeDTO expeAcreTiValiReci = new GetExpeAcreTipoValidezReciclajeDTO();

			expeAcreTiValiReci.setCdgoAcredita((Integer) object[0]);
			expeAcreTiValiReci.setCdgoTipoAcr((String)object[1]);
			expeAcreTiValiReci.setValidezReciclaje((Integer) object[2]);

			resultadosDevueltos.add(expeAcreTiValiReci);
		}
		return resultadosDevueltos;
	}

	public <T> String convertToString(T value) {
		return value != null ? value.toString() : null;
	}

	public List<Tbasg267ExpedAcred> getExpeAcredValPersona(Integer cdgoPersona) {

		String sqlString = " SELECT CDGO_ACREDITA, CDGO_TIPOACREDITA, CDGO_EMPRESA, CDGO_PUERTO, CDGO_LINEA, CDGO_ESTACION FROM PASG.TBASG267_EXPED_ACRED WHERE CDGO_PERSONA  = :value ";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg267ExpedAcred> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg267ExpedAcred expeAcre = new Tbasg267ExpedAcred();
			
			expeAcre.setCdgoAcredita((Integer)object[0]);
			expeAcre.setCdgoTipoacredita((String) object[1]);
			expeAcre.setCdgoEmpresa((Integer)object[2]);
			expeAcre.setCdgoPuerto((String)object[3]);
			expeAcre.setCdgoLinea((String)object[4]);
			expeAcre.setCdgoEstacion((String)object[5]);

			resultadosDevueltos.add(expeAcre);
		}
		return resultadosDevueltos;
	}
	
	public List<Tbasg267ExpedAcred> getExpeCdgoAcredita(Integer cdgoAcredita) {

		String sqlString = " SELECT CDGO_ACREDITA, CDGO_TIPOACREDITA, CDGO_EMPRESA, CDGO_PUERTO, CDGO_LINEA, CDGO_ESTACION, FCHA_CADUC FROM PASG.TBASG267_EXPED_ACRED WHERE CDGO_ACREDITA  = :value ";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoAcredita);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg267ExpedAcred> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg267ExpedAcred expeAcre = new Tbasg267ExpedAcred();
			
			expeAcre.setCdgoAcredita((Integer)object[0]);
			expeAcre.setCdgoTipoacredita((String) object[1]);
			expeAcre.setCdgoEmpresa((Integer)object[2]);
			expeAcre.setCdgoPuerto((String)object[3]);
			expeAcre.setCdgoLinea((String)object[4]);
			expeAcre.setCdgoEstacion((String)object[5]);
			expeAcre.setFchaCaduc((Date) object[6]);

			resultadosDevueltos.add(expeAcre);
		}
		return resultadosDevueltos;
	}
	
}
