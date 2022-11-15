package renfe.com.repository.impl;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.slf4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import renfe.com.dto.GetInfractionListDTO;
import renfe.com.dto.GetInfractionParametersDTO;
import renfe.com.model.entity.Tbasg103Infracper;
import renfe.com.repository.Tbasg103InfracperRepositoryCustom;

public class Tbasg103InfracperRepositoryImpl implements Tbasg103InfracperRepositoryCustom {

	protected Logger logger;

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg103Infracper> getInfracPersonaListAscendente(String cdgoPersona) {

		String sqlString = "SELECT"
				+ "		I.CDGO_INFRPER, I.CDGO_PERSONA, I.CDGO_TIPINFR, I.CDGO_SANCION, I.CDGO_GRADO, T.DESG_NOMBRE AS TIPOINFRA, I.FCHA_FHINFR, G.DESG_NOMBRE AS GRADO,"
				+ "		S.DESG_NOMBRE AS SANCION, I.FCHA_DESDE, I.FCHA_HASTA, I.MRCA_ACTIVO, I.DESG_USUACT, I.FCHA_ACT"
				+ "		" + "		FROM" + "		PASG.TBASG103_INFRACPER I," + "		PASG.TBASG112_TIPOINFRA T,"
				+ "		PASG.TBASG113_SANCION   S," + "		PASG.TBASG114_GRADOINCI G" + "		" + "		WHERE"
				+ "		I.CDGO_TIPINFR = T.CDGO_TIPINFR" + "		AND I.CDGO_SANCION = S.CDGO_SANCION"
				+ "		AND I.CDGO_GRADO = G.CDGO_GRADO" + "		AND T.MRCA_ACTIVO = 'S'"
				+ "		AND S.MRCA_ACTIVO = 'S'" + "		AND G.MRCA_ACTIVO = 'S'"
				+ "		AND I.CDGO_PERSONA = :value" + "		ORDER BY T.DESG_NOMBRE ASC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg103Infracper.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}

	public List<Tbasg103Infracper> getInfracPersonaListDescendente(String cdgoPersona) {

		String sqlString = "SELECT"
				+ "		I.CDGO_INFRPER, I.CDGO_PERSONA, I.CDGO_TIPINFR, I.CDGO_SANCION, I.CDGO_GRADO, T.DESG_NOMBRE AS TIPOINFRA, I.FCHA_FHINFR, G.DESG_NOMBRE AS GRADO,"
				+ "		S.DESG_NOMBRE AS SANCION, I.FCHA_DESDE, I.FCHA_HASTA, I.MRCA_ACTIVO, I.DESG_USUACT, I.FCHA_ACT"
				+ "		" + "		FROM" + "		PASG.TBASG103_INFRACPER I," + "		PASG.TBASG112_TIPOINFRA T,"
				+ "		PASG.TBASG113_SANCION   S," + "		PASG.TBASG114_GRADOINCI G" + "		" + "		WHERE"
				+ "		I.CDGO_TIPINFR = T.CDGO_TIPINFR" + "		AND I.CDGO_SANCION = S.CDGO_SANCION"
				+ "		AND I.CDGO_GRADO = G.CDGO_GRADO" + "		AND T.MRCA_ACTIVO = 'S'"
				+ "		AND S.MRCA_ACTIVO = 'S'" + "		AND G.MRCA_ACTIVO = 'S'"
				+ "		AND I.CDGO_PERSONA = :value" + "		ORDER BY T.DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg103Infracper.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}

	public List<Tbasg103Infracper> getInfracPersonaActiveListAscendente(String cdgoPersona) {

		String sqlString = "SELECT"
				+ "		I.CDGO_INFRPER, I.CDGO_PERSONA, I.CDGO_TIPINFR, I.CDGO_SANCION, I.CDGO_GRADO, T.DESG_NOMBRE AS TIPOINFRA, I.FCHA_FHINFR, G.DESG_NOMBRE AS GRADO,"
				+ "		S.DESG_NOMBRE AS SANCION, I.FCHA_DESDE, I.FCHA_HASTA, I.MRCA_ACTIVO, I.DESG_USUACT, I.FCHA_ACT"
				+ "		" + "		FROM" + "		PASG.TBASG103_INFRACPER I," + "		PASG.TBASG112_TIPOINFRA T,"
				+ "		PASG.TBASG113_SANCION   S," + "		PASG.TBASG114_GRADOINCI G" + "		" + "		WHERE"
				+ "		I.CDGO_TIPINFR = T.CDGO_TIPINFR" + "		AND I.CDGO_SANCION = S.CDGO_SANCION"
				+ "		AND I.CDGO_GRADO = G.CDGO_GRADO" + "		AND T.MRCA_ACTIVO = 'S'"
				+ "		AND S.MRCA_ACTIVO = 'S'" + "		AND G.MRCA_ACTIVO = 'S'"
				+ "		AND I.CDGO_PERSONA = :value" + "		AND I.MRCA_ACTIVO = 'S'"
				+ "		ORDER BY T.DESG_NOMBRE ASC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg103Infracper.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}

	public List<Tbasg103Infracper> getInfracPersonaActiveListDescendente(String cdgoPersona) {

		String sqlString = "SELECT"
				+ "		I.CDGO_INFRPER, I.CDGO_PERSONA, I.CDGO_TIPINFR, I.CDGO_SANCION, I.CDGO_GRADO, T.DESG_NOMBRE AS TIPOINFRA, I.FCHA_FHINFR, G.DESG_NOMBRE AS GRADO,"
				+ "		S.DESG_NOMBRE AS SANCION, I.FCHA_DESDE, I.FCHA_HASTA, I.MRCA_ACTIVO, I.DESG_USUACT, I.FCHA_ACT"
				+ "		" + "		FROM" + "		PASG.TBASG103_INFRACPER I," + "		PASG.TBASG112_TIPOINFRA T,"
				+ "		PASG.TBASG113_SANCION   S," + "		PASG.TBASG114_GRADOINCI G" + "		" + "		WHERE"
				+ "		I.CDGO_TIPINFR = T.CDGO_TIPINFR" + "		AND I.CDGO_SANCION = S.CDGO_SANCION"
				+ "		AND I.CDGO_GRADO = G.CDGO_GRADO" + "		AND T.MRCA_ACTIVO = 'S'"
				+ "		AND S.MRCA_ACTIVO = 'S'" + "		AND G.MRCA_ACTIVO = 'S'"
				+ "		AND I.CDGO_PERSONA = :value" + "		AND I.MRCA_ACTIVO = 'S'"
				+ "		ORDER BY T.DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg103Infracper.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}

	public List<Tbasg103Infracper> getInfracPersonaCount(String cdgoPersona) {

		String sqlString = "SELECT COUNT(*) as value " + "" + "		FROM" + "		PASG.TBASG103_INFRACPER I,"
				+ "		PASG.TBASG112_TIPOINFRA T," + "		PASG.TBASG113_SANCION   S,"
				+ "		PASG.TBASG114_GRADOINCI G" + "		" + "		WHERE" + "		I.CDGO_TIPINFR = T.CDGO_TIPINFR"
				+ "		AND I.CDGO_SANCION = S.CDGO_SANCION" + "		AND I.CDGO_GRADO = G.CDGO_GRADO"
				+ "		AND T.MRCA_ACTIVO = 'S'" + "		AND S.MRCA_ACTIVO = 'S'" + "		AND G.MRCA_ACTIVO = 'S'"
				+ "		AND I.CDGO_PERSONA = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg103Infracper.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}

	public List<GetInfractionListDTO> getInfracPerList(GetInfractionParametersDTO params) {

		String sqlString =
			"SELECT "
			+ "		I.*, T.DESG_NOMBRE AS TIPOINFRA, G.DESG_NOMBRE AS GRADO, S.DESG_NOMBRE AS SANCION, A.DESG_NOMBRE AS AREACTIVIDAD, "
			+ "		P.DESG_NIFPAS AS NIFPAS, P.DESG_NOMBRE AS NOMBRE, P.DESG_APELL1 AS APELLIDO1, P.DESG_APELL2 AS APELLIDO2, "
			+ "		P.DESG_MATRICULA AS MATRICULA "
			+ "FROM "
			+ "		PASG.TBASG103_INFRACPER I, "
			+ "		PASG.TBASG112_TIPOINFRA T, "
			+ "		PASG.TBASG113_SANCION   S, "
			+ "		PASG.TBASG114_GRADOINCI G, "
			+ "		PASG.TBASG100_PERSONA   P, "
			+ "		PASG.TBASG105_AREACTIVI A "
			+ " WHERE "
			+ "		I.CDGO_TIPINFR = T.CDGO_TIPINFR   AND "
			+ "		I.CDGO_SANCION = S.CDGO_SANCION   AND "
			+ "		I.CDGO_GRADO   = G.CDGO_GRADO     AND "
			+ "		I.CDGO_PERSONA = P.CDGO_PERSONA	  AND "
			+ "		P.CDGO_AREACT  = A.CDGO_AREACT    AND "
			+ "		I.MRCA_ACTIVO  = 'S'              AND "
			+ "		P.MRCA_ACTIVO  = 'S' ";
		
		if (Objects.nonNull(params.getCdgoReferenciaDoc()))     sqlString += " AND I.CDGO_REFERENCIADOC = :cdgoReferenciaDoc ";	
		
		if (Objects.nonNull(params.getNifPas()))                sqlString += " AND P.DESG_NIFPAS LIKE :nifPas ";
		
		if (Objects.nonNull(params.getMatricula()))             sqlString += " AND P.DESG_MATRICULA LIKE :matricula ";
		
		if (Objects.nonNull(params.getNombre()))                sqlString += " AND P.DESG_NOMBRE LIKE :nombre ";	
		
		if (Objects.nonNull(params.getApellido1()))             sqlString += " AND P.DESG_APELL1 LIKE :apellido1 ";
		
		if (Objects.nonNull(params.getApellido2()))             sqlString += " AND P.DESG_APELL2 LIKE :apellido2 ";
		
		if (Objects.nonNull(params.getCdgoAreAct()))            sqlString += " AND P.CDGO_AREACT = :cdgoAreAct ";
		
		if (Objects.nonNull(params.getCdgoAreTerr()))           sqlString += " AND P.CDGO_ARETER = :cdgoAreTerr ";
		
		if (Objects.nonNull(params.getCdgoCentroCont()))        sqlString += " AND P.CDGO_CENTCONT = :cdgoCentroCont ";
		
		//if (Objects.nonNull(params.getListAreAct()))            sqlString += " AND (P.CDGO_AREACT IN (:listAreAct) OR P.CDGO_AREACT IS NULL)";

		//if (Objects.nonNull(params.getListAreTer()))            sqlString += " AND (P.CDGO_ARETER IN (:listAreTer) OR P.CDGO_ARETER IS NULL)";		
		
		if (Objects.nonNull(params.getCdgoTipInfr()))           sqlString += " AND T.CDGO_TIPINFR = :cdgoTipInfr ";

		if (Objects.nonNull(params.getCdgoGrado()))             sqlString += " AND G.CDGO_GRADO = :cdgoGrado"; 

		if (Objects.nonNull(params.getCdgoSancion()))           sqlString += " AND S.CDGO_SANCION = :cdgoSancion";

		if (Objects.nonNull(params.getFchaDesdeInfra()))        sqlString += " AND I.FCHA_FHINFR >= :fchaDesdeInfra";

		if (Objects.nonNull(params.getFchaHastaInfra()))        sqlString += " AND I.FCHA_FHINFR <= :fchaHastaInfra";
		
		if (Objects.nonNull(params.getFchaDesdeIniSanc()))      sqlString += " AND I.FCHA_DESDE >= :fchaDesdeIniSanc"; 

		if (Objects.nonNull(params.getFchaHastaIniSanc()))      sqlString += " AND I.FCHA_DESDE <= :fchaHastaIniSanc";

		if (Objects.nonNull(params.getFchaDesdeFinSanc()))      sqlString += " AND I.FCHA_HASTA >= :fchaDesdeFinSanc";

		if (Objects.nonNull(params.getFchaHastaFinSanc()))      sqlString += " AND I.FCHA_HASTA <= :fchaHastaFinSanc";


		Query sqlquery = em.createNativeQuery(sqlString);

		if (Objects.nonNull(params.getCdgoReferenciaDoc()))     sqlquery.setParameter("cdgoReferenciaDoc", params.getCdgoReferenciaDoc());	
		
		if (Objects.nonNull(params.getNifPas()))                sqlquery.setParameter("nifPas",     "%" + params.getNifPas() + "%");
		
		if (Objects.nonNull(params.getMatricula()))             sqlquery.setParameter("matricula",  "%" + params.getMatricula() + "%");
		
		if (Objects.nonNull(params.getNombre()))                sqlquery.setParameter("nombre",     "%" + params.getNombre() + "%");	
		
		if (Objects.nonNull(params.getApellido1()))             sqlquery.setParameter("apellido1",  "%" + params.getApellido1() + "%");
		
		if (Objects.nonNull(params.getApellido2()))             sqlquery.setParameter("apellido2",  "%" + params.getApellido2() + "%");
		
		if (Objects.nonNull(params.getCdgoAreAct()))            sqlquery.setParameter("cdgoAreAct",       params.getCdgoAreAct());
		
		if (Objects.nonNull(params.getCdgoAreTerr()))           sqlquery.setParameter("cdgoAreTerr",      params.getCdgoAreTerr());
		
		if (Objects.nonNull(params.getCdgoCentroCont()))        sqlquery.setParameter("cdgoCentroCont",   params.getCdgoCentroCont());
		
		//if (Objects.nonNull(params.getListAreAct()))            sqlquery.setParameter("listAreAct",             params.getListAreAct());

		//if (Objects.nonNull(params.getListAreTer()))            sqlquery.setParameter("listAreTer",             params.getListAreTer());		
		
		if (Objects.nonNull(params.getCdgoTipInfr()))           sqlquery.setParameter("cdgoTipInfr",      params.getCdgoTipInfr());		
		
		if (Objects.nonNull(params.getCdgoGrado()))             sqlquery.setParameter("cdgoGrado",        params.getCdgoGrado());

		if (Objects.nonNull(params.getCdgoSancion()))           sqlquery.setParameter("cdgoSancion",      params.getCdgoSancion());

		if (Objects.nonNull(params.getFchaDesdeInfra()))        sqlquery.setParameter("fchaDesdeInfra",   params.getFchaDesdeInfra());

		if (Objects.nonNull(params.getFchaHastaInfra()))        sqlquery.setParameter("fchaHastaInfra",   params.getFchaHastaInfra()); 
		
		if (Objects.nonNull(params.getFchaDesdeIniSanc()))      sqlquery.setParameter("fchaDesdeIniSanc", params.getFchaDesdeIniSanc());

		if (Objects.nonNull(params.getFchaHastaIniSanc()))      sqlquery.setParameter("fchaHastaIniSanc", params.getFchaHastaIniSanc());

		if (Objects.nonNull(params.getFchaDesdeFinSanc()))      sqlquery.setParameter("fchaDesdeFinSanc", params.getFchaDesdeFinSanc());

		if (Objects.nonNull(params.getFchaHastaFinSanc()))      sqlquery.setParameter("fchaHastaFinSanc", params.getFchaHastaFinSanc()); 
		

		List<Object[]> resultListQuery        = sqlquery.getResultList();
		List<GetInfractionListDTO> resultList = new ArrayList<>();
		for (Object[] object : resultListQuery) {			
			GetInfractionListDTO infractionList = new GetInfractionListDTO();        
			infractionList.setCdgoInfrper((Integer)object[0]);  
			infractionList.setCdgoPersona((Integer)object[1]); 
			infractionList.setFchaFhinfr((Date)object[2]);  
			infractionList.setDesgMedidasadop(this.convertToString(object[3])); 
			infractionList.setFchaHasta((Date)object[4]); 
			infractionList.setFchaDesde((Date)object[5]); 
			infractionList.setCdgoTipinfr((Integer)object[6]); 
			infractionList.setCdgoSancion((Integer)object[7]); 
			infractionList.setCdgoGrado((Integer)object[8]); 
			infractionList.setDesgUsuact(this.convertToString(object[9])); 						
			infractionList.setFchaAct((Date)object[10]);  
			infractionList.setMrcaActivo(this.convertToString(object[11])); 
			infractionList.setCdgoReferenciadoc((Integer)object[12]); 
			infractionList.setTipoInfra(this.convertToString(object[13]));  
			infractionList.setGrado(this.convertToString(object[14]));  
			infractionList.setSancion(this.convertToString(object[15])); 
			infractionList.setAreActividad(this.convertToString(object[16])); 
			infractionList.setNifpas(this.convertToString(object[17])); 
			infractionList.setNombre(this.convertToString(object[18])); 
			infractionList.setApellido1(this.convertToString(object[19])); 
			infractionList.setApellido2(this.convertToString(object[20])); 						
			infractionList.setMatricula(this.convertToString(object[21]));

			resultList.add(infractionList);
		}

		return resultList;

	}

	public List<Tbasg103Infracper> getInfracPerCount() {

		String sqlString = "SELECT COUNT(*) AS value"
				+ "		FROM PASG.TBASG103_INFRACPER I, PASG.TBASG112_TIPOINFRA T, PASG.TBASG113_SANCION S, PASG.TBASG114_GRADOINCI G, "
				+ "			PASG.TBASG100_PERSONA P, PASG.TBASG105_AREACTIVI A"
				+ "		WHERE I.CDGO_TIPINFR = T.CDGO_TIPINFR" + "		AND I.CDGO_SANCION = S.CDGO_SANCION"
				+ "		AND I.CDGO_GRADO = G.CDGO_GRADO" + "		AND I.CDGO_PERSONA = P.CDGO_PERSONA	"
				+ "		AND P.CDGO_AREACT = A.CDGO_AREACT" + "		AND I.MRCA_ACTIVO = 'S'"
				+ "		AND P.MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg103Infracper.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg103Infracper> getInfracPerView(String cdgoInfrper) {

		String sqlString = "SELECT I.*, T.DESG_NOMBRE AS TIPOINFRA, G.DESG_NOMBRE AS GRADO, S.DESG_NOMBRE AS SANCION, A.DESG_NOMBRE AS AREACTIVIDAD,"
				+ "			P.DESG_NIFPAS AS NIFPAS, P.DESG_NOMBRE AS NOMBRE, P.DESG_APELL1 AS APELLIDO1, P.DESG_APELL2 AS APELLIDO2, "
				+ "			P.DESG_MATRICULA AS MATRICULA"
				+ "		FROM PASG.TBASG103_INFRACPER I, PASG.TBASG112_TIPOINFRA T, PASG.TBASG113_SANCION S, PASG.TBASG114_GRADOINCI G, "
				+ "			PASG.TBASG100_PERSONA P, PASG.TBASG105_AREACTIVI A"
				+ "		WHERE I.CDGO_TIPINFR = T.CDGO_TIPINFR" + "		AND I.CDGO_SANCION = S.CDGO_SANCION"
				+ "		AND I.CDGO_GRADO = G.CDGO_GRADO" + "		AND I.CDGO_PERSONA = P.CDGO_PERSONA	"
				+ "		AND P.CDGO_AREACT = A.CDGO_AREACT" + "		AND I.MRCA_ACTIVO = 'S'"
				+ "		AND P.MRCA_ACTIVO = 'S'" + "		AND I.CDGO_INFRPER=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg103Infracper.class);
		sqlquery.setParameter("value", cdgoInfrper);
		return sqlquery.getResultList();
	}

	public List<Tbasg103Infracper> getInfracPersona(String cdgoInfrper) {

		String sqlString = "SELECT * FROM PASG.TBASG103_INFRACPER WHERE CDGO_INFRPER=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg103Infracper.class);
		sqlquery.setParameter("value", cdgoInfrper);
		return sqlquery.getResultList();
	}

	@Transactional
	public int insertInfracPersona(GetInfractionParametersDTO bean) {
		int result = 0;
		if (Objects.nonNull(bean.getCdgoPersona())) {
			String sqlString = 
					"   INSERT INTO PASG.TBASG103_INFRACPER (" + " CDGO_PERSONA,"
					+ "			FCHA_FHINFR," + "			DESG_MEDIDASADOP," + " FCHA_DESDE,"
					+ "			FCHA_HASTA," + "			CDGO_TIPINFR," + "	   CDGO_SANCION,"
					+ "			CDGO_GRADO," + "			DESG_USUACT," + "	   FCHA_ACT, MRCA_ACTIVO)"
					+ "  VALUES (:cdgoPersona, :infractionDate, :desgMedidasAdop, :sanctionStartDate, :sanctionEndDate, "
					+ "         :cdgoTipInfr, :cdgoSancion, :cdgoGrado, :desgUsuAct, CURRENT_DATE, 'S')";

			Query sqlquery = em.createNativeQuery(sqlString, Tbasg103Infracper.class);

			sqlquery.setParameter("cdgoPersona", bean.getCdgoPersona());

			if (Objects.nonNull(bean.getInfractionDate())) {
				sqlquery.setParameter("infractionDate", bean.getInfractionDate());
			} else { 
				sqlquery.setParameter("infractionDate", null);
			}

			if (Objects.nonNull(bean.getDesgMedidasAdop())) {
				sqlquery.setParameter("desgMedidasAdop", bean.getDesgMedidasAdop());
			} else { 
				sqlquery.setParameter("desgMedidasAdop", null);
			}

			if (Objects.nonNull(bean.getSanctionStartDate())) {
				sqlquery.setParameter("sanctionStartDate", bean.getSanctionStartDate());
			} else { 
				sqlquery.setParameter("sanctionStartDate", null);
			}

			if (Objects.nonNull(bean.getSanctionEndDate())) {
				sqlquery.setParameter("sanctionEndDate", bean.getSanctionEndDate());
			} else { 
				sqlquery.setParameter("sanctionEndDate", null);
			}

			if (Objects.nonNull(bean.getCdgoTipInfr())) {
				sqlquery.setParameter("cdgoTipInfr", bean.getCdgoTipInfr());
			} else { 
				sqlquery.setParameter("cdgoTipInfr", null);
			}

			if (Objects.nonNull(bean.getCdgoSancion())) {
				sqlquery.setParameter("cdgoSancion", bean.getCdgoSancion());
			} else {
				sqlquery.setParameter("cdgoSancion", null);				
			}
 
 			if (Objects.nonNull(bean.getCdgoGrado())) {
				sqlquery.setParameter("cdgoGrado", bean.getCdgoGrado());
			} else {
				sqlquery.setParameter("cdgoGrado", null);	
			}

			if (Objects.nonNull(bean.getDesgUsuAct())) {
				sqlquery.setParameter("desgUsuAct", bean.getDesgUsuAct());
			} else {
				sqlquery.setParameter("desgUsuAct", null);	
			}

			result = sqlquery.executeUpdate(); 
		}

		return result;
	}

	@Transactional
	public int updateInfracPersona(GetInfractionParametersDTO bean) {
		int result = 0;
		if (Objects.nonNull(bean.getCdgoInfrper())) {		 
			String sqlString = " UPDATE PASG.TBASG103_INFRACPER " 		
				+ " SET FCHA_FHINFR= :fchaFhinfr, DESG_MEDIDASADOP= :desgMedidasadop, FCHA_DESDE= :fchaDesde, FCHA_HASTA= :fchaHasta, "
				+ "	CDGO_TIPINFR= :cdgoTipinfr, CDGO_SANCION= :cdgoSancion, CDGO_GRADO= :cdgoGrado, DESG_USUACT= :desgUsuact, FCHA_ACT= CURRENT_DATE "
				+ "	WHERE CDGO_INFRPER= :cdgoInfrper"; 			

			Query sqlquery = em.createNativeQuery(sqlString);

			sqlquery.setParameter("cdgoInfrper", bean.getCdgoInfrper()); 

			if (Objects.nonNull(bean.getFchaFhinfr())) {
				sqlquery.setParameter("fchaFhinfr", bean.getFchaFhinfr());
			} else { 
				sqlquery.setParameter("fchaFhinfr", null);
			}  

			if (Objects.nonNull(bean.getDesgMedidasadop())) {
				sqlquery.setParameter("desgMedidasadop", bean.getDesgMedidasadop());
			} else { 
				sqlquery.setParameter("desgMedidasadop", null);
			}

			if (Objects.nonNull(bean.getFchaDesde())) {
				sqlquery.setParameter("fchaDesde", bean.getFchaDesde());
			} else { 
				sqlquery.setParameter("fchaDesde", null);
			}

			if (Objects.nonNull(bean.getFchaHasta())) {
				sqlquery.setParameter("fchaHasta", bean.getFchaHasta());
			} else { 
				sqlquery.setParameter("fchaHasta", null);
			}

			if (Objects.nonNull(bean.getCdgoTipinfr())) {
				sqlquery.setParameter("cdgoTipinfr", bean.getCdgoTipinfr());
			} else { 
				sqlquery.setParameter("cdgoTipinfr", null);
			}

			if (Objects.nonNull(bean.getCdgoSancion())) {
				sqlquery.setParameter("cdgoSancion", bean.getCdgoSancion());
			} else {
				sqlquery.setParameter("cdgoSancion", null);				
			}

			if (Objects.nonNull(bean.getCdgoGrado())) {
				sqlquery.setParameter("cdgoGrado", bean.getCdgoGrado());
			} else {
				sqlquery.setParameter("cdgoGrado", null);	
			}

			if (Objects.nonNull(bean.getDesgUsuact())) {
				sqlquery.setParameter("desgUsuact", bean.getDesgUsuact());
			} else {
				sqlquery.setParameter("desgUsuact", null);	
			}

			result = sqlquery.executeUpdate();
		}

		return result;
	}

	@Transactional
	public int deleteInfracPersona(GetInfractionParametersDTO bean) {
		int result = 0;
		try {
			String sqlString = 
				  " UPDATE PASG.TBASG103_INFRACPER "
				+ "	SET MRCA_ACTIVO= 'N', DESG_USUACT= :usuAct, FCHA_ACT= CURRENT_DATE "
				+ "	WHERE CDGO_INFRPER= :cdgoInfrper ";

			Query sqlquery = em.createNativeQuery(sqlString);

			sqlquery.setParameter("usuAct", bean.getDesgUsuAct());
			sqlquery.setParameter("cdgoInfrper", bean.getCdgoInfrper());

			result = sqlquery.executeUpdate();
			
		} catch (Exception e) {
			logger.debug("---> Error al intentar eliminar la infraccion {}", bean.getCdgoInfrper());
		}

		return result;
	}

	public int updateInfrPerRefDoc(Tbasg103Infracper bean) {

		String sqlString = "UPDATE PASG.TBASG103_INFRACPER" + "			SET " + "			CDGO_REFERENCIADOC=?,"
				+ "			DESG_USUACT=?," + "			FCHA_ACT=CURRENT_DATE" + "		WHERE CDGO_INFRPER=?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg103Infracper.class);
		sqlquery.setParameter(1, bean.getCdgoReferenciadoc());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getCdgoInfrper());
		return sqlquery.executeUpdate();
	}

	public <T> String convertToString(T value) {
        return value != null ? value.toString() : null;          
    }	

}
