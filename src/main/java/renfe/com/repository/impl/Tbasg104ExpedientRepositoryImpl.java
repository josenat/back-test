package renfe.com.repository.impl;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.apache.catalina.util.ToStringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

import renfe.com.dto.*;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import renfe.com.dto.DataGetExpedientesPersonaListDTO;
import renfe.com.dto.GetCertsPsicByPersListDTO;
import renfe.com.dto.GetEstadoListDTO;
import renfe.com.dto.MultivalueCts;
import renfe.com.dto.ParamExpedientesPersonaListDTO;
import renfe.com.dto.SetMaxEstadoHabilitaList;
import renfe.com.model.dto.Tbasg104ExpedientDto;
import renfe.com.model.entity.Tbasg104Expedient;
import renfe.com.model.entity.Tbasg128Estacline;
import renfe.com.model.entity.Tbasg129Entornos;
import renfe.com.model.entity.Tbasg131Alcanceot;
import renfe.com.model.entity.Tbasg133Serie;
import renfe.com.model.entity.Tbasg137Especiali;
import renfe.com.model.entity.Tbasg257Alcanauxcab;
import renfe.com.repository.Tbasg104ExpedientRepositoryCustom;
import renfe.com.repository.Tbasg129EntornosRepository;
import org.springframework.transaction.annotation.Transactional;

public class Tbasg104ExpedientRepositoryImpl implements Tbasg104ExpedientRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private Tbasg131AlcanceotRepositoryImpl tbasg131AlcanceotRepositoryImpl;
	@Autowired
	private Tbasg257AlcanauxcabRepositoryImpl tbasg257AlcanauxcabRepositoryImpl;
	@Autowired
	private Tbasg137EspecialiRepositoryImpl tbasg137EspecialiRepositoryImpl;
	@Autowired
	private Tbasg129EntornosRepositoryImpl tbasg129EntornosRepositoryImpl;
	@Autowired
	private Tbasg128EstaclineRepositoryImpl tbasg128EstaclineRepositoryImpl;
	@Autowired
	private Tbasg133SerieRepositoryImpl tbasg133SerieRepositoryImpl;
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(Tbasg104ExpedientRepositoryImpl.class);

	public List<Tbasg104Expedient> getTramosPersona(String cdgoPersona, String cdgoEmpresa, String cdgoTipohab,
			String cdgoEntorno) {

		String sqlString = "SELECT A.* "
				+ "		    from PASG.TBASG104_EXPEDIENT E, PASG.TBASG126_ALCHABINF I, PASG.TBASG145_ALCHAESTA A"
				+ "		    WHERE E.CDGO_EXPEDIENT = I.CDGO_EXPEDIENT"
				+ "		        AND I.CDGO_ALCHABINF = A.CDGO_ALCHABINF		      "
				+ "		        AND E.DESG_TIPOINFRAESTRUC = 'T'" + "		        AND E.CDGO_PERSONA = :cdgoPersona"
				+ "		        AND E.CDGO_EMPRESA = :cdgoEmpresa" + "		        AND E.CDGO_TIPOHAB = :cdgoTipoHab"
				+ "		        AND E.CDGO_ENTORNO = :cdgoEntorno";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg104Expedient.class);
		sqlquery.setParameter("cdgoPersona", cdgoPersona);
		sqlquery.setParameter("cdgoEmpresa", cdgoEmpresa);
		sqlquery.setParameter("cdgoTipoHab", cdgoTipohab);
		sqlquery.setParameter("cdgoEntorno", cdgoEntorno);
		return sqlquery.getResultList();
	}

	public List<Tbasg104Expedient> getTramosPersonaSinTramo(String cdgoPersona, String cdgoEmpresa, String cdgoTipohab,
			String cdgoEntorno) {

		String sqlString = "SELECT A.* "
				+ "		    from PASG.TBASG104_EXPEDIENT E, PASG.TBASG126_ALCHABINF I, PASG.TBASG145_ALCHAESTA A, PASG.TBASG118_ESTADOEXP B"
				+ "		    WHERE E.CDGO_EXPEDIENT = I.CDGO_EXPEDIENT"
				+ "		        AND I.CDGO_ALCHABINF = A.CDGO_ALCHABINF	"
				+ "				AND B.CDGO_EXPEDIENT = E.CDGO_EXPEDIENT" + "				AND B.CDGO_ESTADO != 4"
				+ "				AND A.MRCA_ACTIVO = 'S'" + "		        AND I.MRCA_ACTIVO = 'S'"
				+ "	 	    	AND E.MRCA_ACTIVO = 'S'" + "		        AND E.CDGO_PERSONA = :cdgoPersona"
				+ "		        AND E.CDGO_EMPRESA = :cdgoEmpresa" + "		        AND E.CDGO_TIPOHAB = :cdgoTipoHab"
				+ "		        AND E.CDGO_ENTORNO = :cdgoEntorno";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg104Expedient.class);
		sqlquery.setParameter("cdgoPersona", cdgoPersona);
		sqlquery.setParameter("cdgoEmpresa", cdgoEmpresa);
		sqlquery.setParameter("cdgoTipoHab", cdgoTipohab);
		sqlquery.setParameter("cdgoEntorno", cdgoEntorno);
		return sqlquery.getResultList();
	}

	public List<Tbasg104Expedient> getFchaProxRevList(String cdgoExpedient) {

		String sqlString = "SELECT C.FCHA_PROXREV" + "		FROM PASG.TBASG104_EXPEDIENT E "
				+ "			INNER JOIN PASG.TBASG101_CERTPSIC C ON E.CDGO_PERSONA = C.CDGO_PERSONA"
				+ "		WHERE E.CDGO_EXPEDIENT = :value" + "			AND E.MRCA_ACTIVO = 'S'"
				+ "			AND C.MRCA_ACTIVO = 'S'" + "		ORDER BY C.FCHA_PROXREV DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg104Expedient.class);
		sqlquery.setParameter("value", cdgoExpedient);
		return sqlquery.getResultList();
	}
	
	public List<GetExpeTipoValidezReciclajeDTO> getExpeTipoValidezReciclaje(Integer cdgoExpedient) {


		String sqlString = " SELECT E.CDGO_EXPEDIENT, T.CDGO_TIPOHAB, T.VALIDEZ_RECICLAJE FROM PASG.TBASG104_EXPEDIENT E INNER JOIN PASG.TBASG123_TIPOHABIL T "
				+ "ON E.CDGO_TIPOHAB = T.CDGO_TIPOHAB  WHERE E.CDGO_EXPEDIENT = :cdgoExpediente";
		
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("cdgoExpediente", cdgoExpedient);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetExpeTipoValidezReciclajeDTO> resultadosDevueltos = new ArrayList<>();

		for (Object[] object : resultados) {
			GetExpeTipoValidezReciclajeDTO expeValidez = new GetExpeTipoValidezReciclajeDTO();

			expeValidez.setCdgoExpedient((Integer) object[0]);
			expeValidez.setCdgoTipoHab((Integer)object[1]);
			expeValidez.setValidezReciclaje((Integer)object[2]);

			resultadosDevueltos.add(expeValidez);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg104Expedient> getFchaProxCursoList(String cdgoExpedient) {

		String sqlString = "SELECT C.FCHA_CURSO + 3 YEAR AS FCHA_PROX_CURSO" + "		FROM PASG.TBASG104_EXPEDIENT E"
				+ "			INNER JOIN PASG.TBASG121_ACTAFORMA A ON E.CDGO_EXPEDIENT = A.CDGO_EXPEDIENT"
				+ "			INNER JOIN PASG.TBASG146_ACTAINCAL C ON A.CDGO_ACTAFORM = C.CDGO_ACTAFORM"
				+ "		WHERE E.CDGO_EXPEDIENT = :value" + "			AND E.MRCA_ACTIVO = 'S'"
				+ "			AND A.MRCA_ACTIVO = 'S'" + "			AND C.MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg104Expedient.class);
		sqlquery.setParameter("value", cdgoExpedient);
		return sqlquery.getResultList();
	}

	public List<Tbasg104Expedient> getMaxEstadoExpListCount() {

		String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG104_EXPEDIENT";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg104Expedient.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg104Expedient> getPreviousEstadoExpList(String cdgoExpedient) {

		String sqlString = "SELECT" + "					B.CDGO_ESTADO"
				+ "					FROM PASG.TBASG104_EXPEDIENT A, PASG.TBASG118_ESTADOEXP B, PASG.TBASG100_PERSONA C"
				+ "					WHERE A.CDGO_EXPEDIENT = B.CDGO_EXPEDIENT"
				+ "					AND A.CDGO_PERSONA = C.CDGO_PERSONA"
				+ "					AND B.CDGO_EXPEDIENT = :value"
				+ "					AND B.FCHA_ESTADO <> '1988-08-01-00.00.00.000'"
				+ "					ORDER BY B.FCHA_ESTADO DESC" + "					FETCH FIRST 2 ROWS ONLY";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg104Expedient.class);
		sqlquery.setParameter("value", cdgoExpedient);
		return sqlquery.getResultList();
	}
	
	public List<GetExpByCdgoPersonaAndCdgoExpedientDTO> getExpByCdgoPersonaAndCdgoExpedient(Integer cdgoPersona, Integer cdgoExpediente) {

		String sqlString = "SELECT E.CDGO_EXPEDIENT,"
				+ " E.CDGO_TIPOHAB, T.DESG_NOMBRE as DESC_TIPOHAB,"
				+ " E.CDGO_AMBITOS, A.DESG_NOMBRE as DESC_AMBITOS,"
				+ " E.CDGO_ENTORNO, N.DESG_NOMCORTO as DESC_ENTORNO,"
				+ " E.CDGO_SERIE, S.DESG_NOMBRE as DESC_SERIE,"
				+ " E.CDGO_PERSONA, E.DESG_OBSERVA, E.MRCA_ACTIVO, X.DESG_NOMBRE as DESC_EMPRESA, E.FCHA_EXPEDIENTE"
				+ " FROM PASG.TBASG104_EXPEDIENT E"
				+ " INNER JOIN PASG.TBASG123_TIPOHABIL T ON E.CDGO_TIPOHAB = T.CDGO_TIPOHAB"
				+ " INNER JOIN PASG.TBASG124_AMBITOS A ON E.CDGO_AMBITOS = A.CDGO_AMBITOS"
				+ " INNER JOIN PASG.TBASG125_EMPRESA X ON E.CDGO_EMPRESA = X.CDGO_EMPRESA"
				+ " LEFT JOIN PASG.TBASG129_ENTORNOS N ON E.CDGO_ENTORNO = N.CDGO_ENTORNO"
				+ " LEFT JOIN PASG.TBASG133_SERIE S  ON E.CDGO_SERIE = S.CDGO_SERIE"
				+ " WHERE E.CDGO_PERSONA = :cdgoPersona AND E.CDGO_EXPEDIENT = :cdgoExpediente";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("cdgoPersona", cdgoPersona);
		sqlquery.setParameter("cdgoExpediente", cdgoExpediente);
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetExpByCdgoPersonaAndCdgoExpedientDTO> resultadosDevueltos = new ArrayList<>();

		for (Object[] object : resultados) {
			GetExpByCdgoPersonaAndCdgoExpedientDTO expediente = new GetExpByCdgoPersonaAndCdgoExpedientDTO();
				
			expediente.setCdgoExpedient((Integer)object[0]);
			expediente.setCdgoTipoHabi((Integer)object[1]);
			expediente.setDescTipoHabi((String)object[2]);
			expediente.setCdgoAmbitos((Integer)object[3]);
			expediente.setDescAmbitos((String)object[4]);
			expediente.setCdgoEntorno((Integer)object[5]);
			expediente.setDescEntorno((String)object[6]);
			expediente.setCdgoSerie((Integer)object[7]);
			expediente.setDescSerie((String)object[8]);
			expediente.setCdgoPersona((Integer)object[9]);
			expediente.setDesgObserva((String)object[10]);
			expediente.setMrcaActivo((Character)object[11]);
			expediente.setDescEmpresa((String)object[12]);
			expediente.setFchaExpediente((Date)object[13]);

			resultadosDevueltos.add(expediente);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg104Expedient> getExpPersonaObject(String cdgoExpedient) {

		String sqlString = "SELECT" + "					A.CDGO_EXPEDIENT," + "					A.CDGO_TIPOHAB,"
				+ "					A.DESG_OBSERVA," + "					B.DESG_NOMBRE AS DESG_PERSONA,"
				+ "					B.DESG_APELL1," + "					B.DESG_APELL2,"
				+ "					B.DESG_MATRICULA," + "					B.DESG_NIFPAS"
				+ "					FROM PASG.TBASG104_EXPEDIENT A,PASG.TBASG100_PERSONA B"
				+ "					WHERE A.CDGO_PERSONA = B.CDGO_PERSONA"
				+ "					AND A.CDGO_EXPEDIENT =  :cdgoExpediente";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg104Expedient.class);
		sqlquery.setParameter("cdgoExpediente", cdgoExpedient);
		return sqlquery.getResultList();
	}

	public List<Tbasg104Expedient> getHistoricosEstadosExp(String cdgoExpedient) {

		String sqlString = "SELECT "
				+ "		    X.CDGO_EXPEDIENT, E.DESG_NOMBRE, S.FCHA_ESTADO AS FECHA, S.DESG_USUACT " + "		    "
				+ "		FROM " + "		    PASG.TBASG104_EXPEDIENT X "
				+ "		    INNER JOIN PASG.TBASG118_ESTADOEXP S ON X.CDGO_EXPEDIENT = S.CDGO_EXPEDIENT "
				+ "		    LEFT JOIN PASG.TBASG116_ESTADOS E ON E.CDGO_ESTADO = S.CDGO_ESTADO " + "		WHERE "
				+ "		    X.CDGO_EXPEDIENT = :value" + "		" + "		ORDER BY FECHA DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg104Expedient.class);
		sqlquery.setParameter("value", cdgoExpedient);
		return sqlquery.getResultList();
	}

	public List<Tbasg104Expedient> getMaqByLineasEstacionesList(/** FIXME revisar tipo */
	Object cdgoLinea) {

		String sqlString = "select a.cdgo_persona,p.desg_nifpas,p.DESG_MATRICULA,p.DESG_NOMBRE,p.DESG_APELL1,p.DESG_APELL2,c.CDGO_LINEA as LINEA,  "
				+ "		 c.CDGO_ORIGEN as EST_ORIGEN,c.CDGO_DESTINO as EST_DESTINO     "
				+ "		from pasg.TBASG104_EXPEDIENT a," + "		    pasg.TBASG126_ALCHABINF b,"
				+ "		    pasg.TBASG145_ALCHAESTA c, " + "		    pasg.TBASG100_PERSONA p   "
				+ "		where a.cdgo_expedient = b.cdgo_expedient and       "
				+ "		  b.CDGO_ALCHABINF = c.CDGO_ALCHABINF and         a.cdgo_persona = p.cdgo_persona         AND a.CDGO_TIPOHAB = 1  "
				+ "		 and a.mrca_activo = 'S' and c.cdgo_linea = :cdgolinea and a.DESG_TIPOINFRAESTRUC <> '' and    "
				+ "		b.CDGO_ALCHABINF in" + "		(select distinct a.CDGO_ALCHABINF"
				+ "		from  pasg.TBASG145_ALCHAESTA a, pasg.TBASG128_ESTACLINE b"
				+ "		where a.cdgo_linea = b.cdgo_linea and a.cdgo_linea = :cdgolinea and (a.cdgo_origen = b.cdgo_estacion or a.cdgo_destino = b.cdgo_estacion)"
				+ "		and b.cdgo_orden between :ordenestacorigen  and :ordenestacdestino)"
				+ "		order by a.cdgo_persona";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg104Expedient.class);
		sqlquery.setParameter("cdgolinea", cdgoLinea);
		return sqlquery.getResultList();
	}

	public List<Tbasg104Expedient> getCdgoPersonaByExp(Integer cdgoExpedient) {

		String sqlString = "SELECT CDGO_PERSONA" + "		FROM " + "		    PASG.TBASG104_EXPEDIENT"
				+ "		WHERE " + "		    CDGO_EXPEDIENT = :value" + "		    AND MRCA_ACTIVO = 'S';";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoExpedient);

		List<Object> resultados = sqlquery.getResultList();
		List<Tbasg104Expedient> resultadosDevueltos = new ArrayList<Tbasg104Expedient>();
		for (Object object : resultados) {
			Tbasg104Expedient expedient = new Tbasg104Expedient();
			expedient.setCdgoPersona((Integer)object);
			resultadosDevueltos.add(expedient);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg104Expedient> getExpediente(Integer cdgoExpedient) {

		String sqlString = "SELECT * FROM PASG.TBASG104_EXPEDIENT WHERE CDGO_EXPEDIENT = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoExpedient);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg104Expedient> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			
			Tbasg104Expedient expe = new Tbasg104Expedient();

			expe.setCdgoExpedient(Long.valueOf((int)object[0]));
			expe.setFchaExpediente((Date) object[1]);
			expe.setCdgoPersona((Integer) object[2]);
			expe.setCdgoEmpresa((Integer) object[3]);
			expe.setCdgoTipohab((Integer) object[4]);
			expe.setCdgoAmbitos((Integer) object[5]);
			expe.setCdgoAlcanceot((Integer) object[6]);
			expe.setCdgoEspec((Integer) object[7]);
			expe.setCdgoAlcanceambito((Integer) object[8]);
			expe.setDesgTipoinfraestruc(String.valueOf((Character) object[9]));
			expe.setCdgoEntorno((Integer) object[10]);
			expe.setCdgoLinea((String) object[11]);
			expe.setCdgoSerie((String) object[12]);
			expe.setCdgoSubSerie((String) object[13]);
			expe.setDesgObserva((String) object[14]);
			expe.setDesgUsuact((String) object[15]);
			expe.setFchaAct((Date) object[16]);
			expe.setMrcaActivo(String.valueOf((Character) object[17]));
			expe.setDesgAviso((String) object[18]);
			expe.setCdgoAlcanauxcab((Integer) object[19]);
			expe.setCdgoSociotor((String) object[20]);
			expe.setDesgObservaExt((String) object[21]);

			resultadosDevueltos.add(expe);
		}
		return resultadosDevueltos;
		
	}

	public List<Tbasg104Expedient> getExpedientesByCdgoExp(List<Integer> cdgoExpedient) {

		String sqlString = "SELECT * FROM PASG.TBASG104_EXPEDIENT" + "	WHERE ";
		
		if(cdgoExpedient != null) {
			
			sqlString = sqlString + " CDGO_EXPEDIENT IN ( " + cdgoExpedient.get(0);
			
			for(int i = 1; i < cdgoExpedient.size(); i++) {
				sqlString = sqlString + " ," + cdgoExpedient.get(i);
			}
			
			sqlString = sqlString + " )";		
		}

		sqlString = sqlString + " ORDER BY CDGO_EXPEDIENT ";
		
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg104Expedient> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg104Expedient expe = new Tbasg104Expedient();

			expe.setCdgoExpedient(Long.valueOf((int)object[0]));
			expe.setFchaExpediente((Date) object[1]);
			expe.setCdgoPersona((Integer) object[2]);
			expe.setCdgoEmpresa((Integer) object[3]);
			expe.setCdgoTipohab((Integer) object[4]);
			expe.setCdgoAmbitos((Integer) object[5]);
			expe.setCdgoAlcanceot((Integer) object[6]);
			expe.setCdgoEspec((Integer) object[7]);
			expe.setCdgoAlcanceambito((Integer) object[8]);
			expe.setDesgTipoinfraestruc(String.valueOf((Character) object[9]));
			expe.setCdgoEntorno((Integer) object[10]);
			expe.setCdgoLinea((String) object[11]);
			expe.setCdgoSerie((String) object[12]);
			expe.setCdgoSubSerie((String) object[13]);
			expe.setDesgObserva((String) object[14]);
			expe.setDesgUsuact((String) object[15]);
			expe.setFchaAct((Date) object[16]);
			expe.setMrcaActivo(String.valueOf((Character) object[17]));
			expe.setDesgAviso((String) object[18]);
			expe.setCdgoAlcanauxcab((Integer) object[19]);
			expe.setCdgoSociotor((String) object[20]);
			expe.setDesgObservaExt((String) object[21]);
  
			resultadosDevueltos.add(expe);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg104Expedient> getExpedientesPersona(String cdgoPersona) {

		String sqlString = "SELECT * FROM PASG.TBASG104_EXPEDIENT WHERE CDGO_PERSONA = :value AND MRCA_ACTIVO ='S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg104Expedient.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}

	public List<Tbasg104Expedient> getExpedientesPersonaTodo(String cdgoPersona) {

		String sqlString = "SELECT * FROM PASG.TBASG104_EXPEDIENT WHERE CDGO_PERSONA = :value "
				+ "		ORDER BY MRCA_ACTIVO DESC, CDGO_EXPEDIENT DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg104Expedient.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}


	public List<GetExpedientesPersonaDTO> getExpedientesPersonaParam(GetExpedientesPersonaParam filter) {

		String sqlString = " SELECT EX.CDGO_EXPEDIENT, EX.FCHA_EXPEDIENTE, UPPER(RTRIM(EM.DESG_NOMBRE)) AS EMPRESA, " +
				" EX.CDGO_TIPOHAB, UPPER(RTRIM(TH.DESG_NOMBRE)) AS TIPO_HABILITA, EX.CDGO_AMBITOS, EX.CDGO_ALCANCEOT, " +
				" EX.CDGO_ALCANCEAMBITO, EX.CDGO_ENTORNO, EX.CDGO_LINEA, EX.CDGO_SERIE, EX.CDGO_SUBSERIE, " +
				" EX.CDGO_ESPEC, UPPER(RTRIM(S.DESG_NOMBRE)) AS ESTADO, EE.FCHA_ESTADO, EX.DESG_OBSERVA, " +
				" EX.DESG_TIPOINFRAESTRUC " +
				" FROM PASG.TBASG104_EXPEDIENT EX " +
				" INNER JOIN PASG.TBASG118_ESTADOEXP EE ON EX.CDGO_EXPEDIENT = EE.CDGO_EXPEDIENT " +
				" INNER JOIN PASG.TBASG116_ESTADOS S ON EE.CDGO_ESTADO = S.CDGO_ESTADO " +
				" INNER JOIN PASG.TBASG123_TIPOHABIL TH ON EX.CDGO_TIPOHAB = TH.CDGO_TIPOHAB " +
				" LEFT JOIN PASG.TBASG125_EMPRESA EM ON EX.CDGO_EMPRESA = EM.CDGO_EMPRESA " +
				" WHERE EX.CDGO_PERSONA = :cdgoPersona AND EE.FCHA_ESTADO IN ( " +
				" SELECT MAX(FCHA_ESTADO) FROM PASG.TBASG118_ESTADOEXP WHERE CDGO_EXPEDIENT = EE.CDGO_EXPEDIENT ";

		if(filter.getIndHistoric()==null){
			sqlString = sqlString + " AND MRCA_ACTIVO ='S' ";
		}

		sqlString = sqlString + ")";


		//DINAMYC
		if(filter.getIndHistoric()==null){
			sqlString = sqlString + " AND EX.MRCA_ACTIVO ='S' ";
		}

		if (Objects.nonNull(filter.getCodTipoHabil())){
			sqlString = sqlString + " AND EX.CDGO_TIPOHAB = :codTipoHabil ";

			if(BigInteger.valueOf(1).equals(filter.getCodTipoHabil())){

				if(Objects.nonNull(filter.getTipoInfra())){

					if("E".equals(filter.getTipoInfra())){
						sqlString = sqlString + " AND EX.DESG_TIPOINFRAESTRUC = 'E' OR EX.DESG_TIPOINFRAESTRUC = 'T' ";
					}

					if("L".equals(filter.getTipoInfra())){
						sqlString = sqlString + " AND EX.DESG_TIPOINFRAESTRUC = 'L' ";
					}
				}
			}
		}

		if (StringUtils.isNotBlank(filter.getCodAlcanceHab())){
			if(Objects.nonNull(filter.getCodTipoHabil())){
				if(BigInteger.valueOf(1).equals(filter.getCodTipoHabil())){
					if(Objects.nonNull(filter.getTipoInfra())){
						if("E".equals(filter.getTipoInfra())){
							sqlString = sqlString + " AND EX.CDGO_ENTORNO = :codAlcanceHab ";
						}
						if("L".equals(filter.getTipoInfra())){
							sqlString = sqlString + " AND EX.CDGO_LINEA = :codAlcanceHab ";
						}
					}
				}
				if(BigInteger.valueOf(2).equals(filter.getCodTipoHabil())){
					sqlString = sqlString + " AND EX.CDGO_SERIE = :codAlcanceHab ";
				}

				if(BigInteger.valueOf(3).equals(filter.getCodTipoHabil())){
					sqlString = sqlString + " AND EX.CDGO_ALCANCEOT = :codAlcanceHab ";
				}

				if(BigInteger.valueOf(4).equals(filter.getCodTipoHabil())){
					sqlString = sqlString + " AND EX.CDGO_ESPEC = :codAlcanceHab ";
				}

				if(BigInteger.valueOf(5).equals(filter.getCodTipoHabil())){
					sqlString = sqlString + " AND EX.CDGO_ALCANCEAMBITO = :codAlcanceHab ";
				}
			}
		}

		if(Objects.nonNull(filter.getCodEstado())){
			sqlString = sqlString + " AND EE.CDGO_ESTADO = :codEstado ";
		}

		Query sqlquery = em.createNativeQuery(sqlString);


		if(filter!=null) {

			sqlquery.setParameter("cdgoPersona",   filter.getCdgoPersona());

			if(Objects.nonNull(filter.getCodTipoHabil())) {
				sqlquery.setParameter("codTipoHabil", filter.getCodTipoHabil());
			}

			if(StringUtils.isNotBlank(filter.getCodAlcanceHab())) {
				sqlquery.setParameter("codAlcanceHab", filter.getCodAlcanceHab());
			}

			if(Objects.nonNull(filter.getCodEstado())) {
				sqlquery.setParameter("codEstado", filter.getCodEstado());
			}

		}

		List<Object[]> resultados     = sqlquery.getResultList();

		List<GetExpedientesPersonaDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetExpedientesPersonaDTO expedientPersona = new GetExpedientesPersonaDTO();

			expedientPersona.setCdgoExpediente((Integer) object[0]);
			expedientPersona.setFchaExpediente((Date) object[1]);
			expedientPersona.setEmpresa((String) object[2]);
			expedientPersona.setCdgoTipoHab((Integer) object[3]);
			expedientPersona.setTipoHabilita((String) object[4]);
			expedientPersona.setCdgoAmbitos((Integer) object[5]);
			expedientPersona.setCdgoAlcanceOt((Integer) object[6]);
			expedientPersona.setCdgoAcanceAmbito((Integer) object[7]);
			expedientPersona.setCdgoEntorno((Integer) object[8]);
			expedientPersona.setCdgoLinea((String) object[9]);
			expedientPersona.setCdgoSerie((String) object[10]);
			expedientPersona.setCdgoSubSerie((String) object[11]);
			expedientPersona.setCdgoEspec((Integer) object[12]);
			expedientPersona.setEstado((String) object[13]);
			expedientPersona.setFchaEstado((Date) object[14]);
			expedientPersona.setDesgObserva((String) object[15]);
			expedientPersona.setDesgTipoInfraestruc(String.valueOf((Character) object[16]));

			resultadosDevueltos.add(expedientPersona);
		}

		return resultadosDevueltos;
	}
	
	public List<DataGetExpedientesPersonaListDTO> getExpedientesPersonaList(ParamExpedientesPersonaListDTO filtro) {
		
		String sqlString = "SELECT B.CDGO_EXPEDIENT, B.CDGO_ESTADO, UPPER(RTRIM(E.DESG_NOMBRE)) AS ESTADO, B.FCHA_ESTADO, "
				+ "			UPPER(RTRIM(D.DESG_NOMBRE)) AS TIPO_HABILITA, A.CDGO_ALCANCEOT, A.CDGO_ESPEC, A.CDGO_ALCANCEAMBITO, "
				+ "			A.DESG_TIPOINFRAESTRUC, A.CDGO_ENTORNO, A.CDGO_LINEA, UPPER(RTRIM(A.CDGO_SERIE)) AS CDGO_SERIE, "
				+ "			UPPER(RTRIM(A.CDGO_SUBSERIE)) AS CDGO_SUBSERIE, A.DESG_AVISO, "
				+ "            UPPER(RTRIM(C.DESG_NOMBRE)) AS AMBITO," + "            C.CDGO_AMBITOS AS CODAMB,"
				+ "            A.CDGO_TIPOHAB AS CODHBL," + "			A.CDGO_ALCANCEAMBITO AS CODALC,"
				+ "            UPPER(RTRIM(F.DESG_NOMBRE)) AS EMPRESA,"
				+ "            FO.CDGO_ESTADO AS CDGO_ESTADO_CURSO, EFO.DESG_NOMBRE AS DESG_NOMBRE_CURSO,"
				+ "            A.CDGO_ALCANAUXCAB, (SELECT MAX(AIC.FCHA_CURSO) FROM PASG.TBASG121_ACTAFORMA AF,PASG.TBASG146_ACTAINCAL AIC"
				+ "                        WHERE AIC.CDGO_ACTAFORM = AF.CDGO_ACTAFORM AND"
				+ "                              AF.CDGO_EXPEDIENT = A.CDGO_EXPEDIENT AND"
				+ "                              AF.MRCA_ACTIVO ='S') AS FCHA_CURSO,"
				+ "            A.CDGO_SOCIOTOR,S.DESC_SOCIEDAD" + ", A.DESG_OBSERVA, A.MRCA_ACTIVO "
				+ "            , F.CDGO_EMPRESA "				
				+ " 		FROM " + "			PASG.TBASG104_EXPEDIENT A"
				+ "" + "	  INNER JOIN PASG.TBASG118_ESTADOEXP B ON B.CDGO_EXPEDIENT = A.CDGO_EXPEDIENT "
				+ "			  INNER JOIN PASG.TBASG124_AMBITOS C ON C.CDGO_AMBITOS = A.CDGO_AMBITOS"
				+ "			  INNER JOIN PASG.TBASG123_TIPOHABIL D ON D.CDGO_TIPOHAB = A.CDGO_TIPOHAB"
				+ "			  INNER JOIN PASG.TBASG116_ESTADOS E ON E.CDGO_ESTADO = B.CDGO_ESTADO"
				+ "			  INNER JOIN PASG.TBASG125_EMPRESA F ON F.CDGO_EMPRESA = A.CDGO_EMPRESA"
				+ "			  INNER JOIN PASG.TBASG261_SOCIEDADES S ON S.CDGO_SOCIEDAD = A.CDGO_SOCIOTOR"
				+ "			  LEFT JOIN PASG.TBASG197_FORMACION FO ON FO.CDGO_EXPEDIENT = A.CDGO_EXPEDIENT"
				+ "			  LEFT JOIN PASG.TBASG116_ESTADOS EFO ON EFO.CDGO_ESTADO = FO.CDGO_ESTADO" + "	WHERE	";
		
		sqlString = sqlString + "	A.MRCA_ACTIVO ='S' AND B.FCHA_ESTADO IN (SELECT MAX(EX.FCHA_ESTADO) FROM PASG.TBASG118_ESTADOEXP EX "
				+ "				           WHERE EX.CDGO_EXPEDIENT = B.CDGO_EXPEDIENT AND EX.MRCA_ACTIVO = 'S') AND (FO.CDGO_SOLICITUD IN ( "
				+ "					       SELECT MAX(FO2.CDGO_SOLICITUD) as CDGO_SOLICITUD FROM PASG.TBASG197_FORMACION FO2 WHERE FO2.CDGO_EXPEDIENT = FO.CDGO_EXPEDIENT) "
				+ "        		           OR FO.CDGO_SOLICITUD IS NULL) ";
		
		if(filtro!=null) {
		
		if(Objects.nonNull(filtro.getCdgoPersona())) { 
			
			sqlString = sqlString + " AND A.CDGO_PERSONA = :cdgoPersona " ; 
			} 
		
		if(Objects.nonNull(filtro.getCdgoTipoHab())) { 
			sqlString = sqlString + " AND A.CDGO_TIPOHAB = :tipoHabil " ; 
			} 
		
		if(Objects.nonNull(filtro.getCdgoEmpresa())) { 
			sqlString = sqlString + " AND A.CDGO_EMPRESA = :empresa " ; 
			}
		
		if(Objects.nonNull(filtro.getCdgoEstado())) { 
			sqlString = sqlString + " AND B.CDGO_ESTADO = :estado " ; 
			}		
		
		if(Objects.nonNull(filtro.getCdgoEstado())) { 
			sqlString = sqlString + " AND (B.CDGO_ESTADO = :estadoOtorgao " ; 
			
		if(Objects.nonNull(filtro.getFchaDesde())) { 
			sqlString = sqlString + " B.FCHA_ESTADO >= :fecOtorDesde " ; 
			} 
		
		if(Objects.nonNull(filtro.getFchaHasta())) { 
			sqlString = sqlString + " B.FCHA_ESTADO <= :fecOtorHasta) " ; 
			}	
		}
		
		}
		
		sqlString = sqlString + "	ORDER BY A.CDGO_EXPEDIENT DESC";		
		
		Query sqlquery = em.createNativeQuery(sqlString);	
		
		if(filtro!=null) {

		if(Objects.nonNull(filtro.getCdgoPersona())) { 
			sqlquery.setParameter("cdgoPersona", filtro.getCdgoPersona()); 
		}
		
		if(Objects.nonNull(filtro.getCdgoTipoHab())) { 
			sqlquery.setParameter("tipoHabil", filtro.getCdgoTipoHab()); 
		}
		
		if(Objects.nonNull(filtro.getCdgoEmpresa())) { 
			sqlquery.setParameter("empresa", filtro.getCdgoEmpresa()); 
		}
		
		if(Objects.nonNull(filtro.getCdgoEstado())) { 
			sqlquery.setParameter("estado", filtro.getCdgoEstado()); 
		}
				
		if(Objects.nonNull(filtro.getCdgoEstado())) { 
			sqlquery.setParameter("estadoOtorgao", filtro.getCdgoEstado()); 	
		
			if(Objects.nonNull(filtro.getFchaDesde())) { 
				sqlquery.setParameter("fecOtorDesde", filtro.getFchaDesde()); 
			}
			
			if(Objects.nonNull(filtro.getFchaHasta())) { 
				sqlquery.setParameter("fecOtorHasta", filtro.getFchaHasta()); 
			}
		}
		
		}

	
		List<Object[]> resultados = sqlquery.getResultList();
		List<DataGetExpedientesPersonaListDTO> resultadosDevueltos = new ArrayList<>();
		
		for (Object[] object : resultados) {
			DataGetExpedientesPersonaListDTO data = new DataGetExpedientesPersonaListDTO();
						
			data.setCdgoExpedient((Integer) object[0]);
			data.setCdgoEstado((Integer) object[1]);
			data.setDesgNombreEstado((String)object[2]);

            Date fchaEstado = new Date(((Timestamp) object[3]).getTime());  
			data.setFchaEstado(fchaEstado);

			data.setDesgNombreTipoHabilita((String) object[4]);
			data.setCdgoAlcanceOt((Integer) object[5]);
			data.setCdgoEspec((Integer) object[6]);
			data.setDesgTipoInfraestruc(String.valueOf((Character) object[8]));			
			data.setCdgoEntorno((Integer) object[9]);
			data.setCdgoLinea((String) object[10]);
			data.setCdgoSerie((String) object[11]);
			data.setDesgAviso((String) object[13]);
			data.setDesgNombreAmbito((String) object[14]);
			data.setCdgoAmbitos((Integer) object[15]);
			data.setCdgoTipoHab((Integer) object[16]);
			data.setDesgNombreEmpresa((String) object[18]);
			data.setCdgoAlcanauxcab((Integer) object[21]);
			data.setFchaCurso((Date) object[22]);
			data.setCdgoSociotor((String) object[23]);
			data.setDesgSociedad((String) object[24]);
			data.setDesgObserva((String) object[25]); 
			data.setMrcaActivo(String.valueOf((Character) object[26])); 			
			data.setDescripAlcanse(this.getDescripAlcanseExpediente( object[5], object[21], object[6], object[9], object[10], object[11] ));
			data.setCdgoEmpresa((Integer) object[27]);
			
			resultadosDevueltos.add(data);
		}
		return resultadosDevueltos;
		
	}
	
	public List<DataGetExpedientesPersonaListDTO> getExpedientesFiltro(ParamExpedientesPersonaListDTO filtro) {
		
		String sqlString = "SELECT B.CDGO_EXPEDIENT, B.CDGO_ESTADO, UPPER(RTRIM(E.DESG_NOMBRE)) AS ESTADO, B.FCHA_ESTADO, "
				+ "			UPPER(RTRIM(D.DESG_NOMBRE)) AS TIPO_HABILITA, A.CDGO_ALCANCEOT, A.CDGO_ESPEC, A.CDGO_ALCANCEAMBITO, "
				+ "			A.DESG_TIPOINFRAESTRUC, A.CDGO_ENTORNO, A.CDGO_LINEA, UPPER(RTRIM(A.CDGO_SERIE)) AS CDGO_SERIE, "
				+ "			UPPER(RTRIM(A.CDGO_SUBSERIE)) AS CDGO_SUBSERIE, A.DESG_AVISO, "
				+ "            UPPER(RTRIM(C.DESG_NOMBRE)) AS AMBITO," + "            C.CDGO_AMBITOS AS CODAMB,"
				+ "            A.CDGO_TIPOHAB AS CODHBL," + "			A.CDGO_ALCANCEAMBITO AS CODALC,"
				+ "            UPPER(RTRIM(F.DESG_NOMBRE)) AS EMPRESA,"
				+ "            FO.CDGO_ESTADO AS CDGO_ESTADO_CURSO, EFO.DESG_NOMBRE AS DESG_NOMBRE_CURSO,"
				+ "            A.CDGO_ALCANAUXCAB, (SELECT MAX(AIC.FCHA_CURSO) FROM PASG.TBASG121_ACTAFORMA AF,PASG.TBASG146_ACTAINCAL AIC"
				+ "                        WHERE AIC.CDGO_ACTAFORM = AF.CDGO_ACTAFORM AND"
				+ "                              AF.CDGO_EXPEDIENT = A.CDGO_EXPEDIENT "
				+ "                              ) AS FCHA_CURSO,"
				+ "            A.CDGO_SOCIOTOR,S.DESC_SOCIEDAD" + ", A.DESG_OBSERVA, A.MRCA_ACTIVO "
				+ "            , F.CDGO_EMPRESA "				
				+ " 		FROM " + "			PASG.TBASG104_EXPEDIENT A"
				+ "" + "	  INNER JOIN PASG.TBASG118_ESTADOEXP B ON B.CDGO_EXPEDIENT = A.CDGO_EXPEDIENT "
				+ "			  INNER JOIN PASG.TBASG124_AMBITOS C ON C.CDGO_AMBITOS = A.CDGO_AMBITOS"
				+ "			  INNER JOIN PASG.TBASG123_TIPOHABIL D ON D.CDGO_TIPOHAB = A.CDGO_TIPOHAB"
				+ "			  INNER JOIN PASG.TBASG116_ESTADOS E ON E.CDGO_ESTADO = B.CDGO_ESTADO"
				+ "			  INNER JOIN PASG.TBASG125_EMPRESA F ON F.CDGO_EMPRESA = A.CDGO_EMPRESA"
				+ "			  INNER JOIN PASG.TBASG261_SOCIEDADES S ON S.CDGO_SOCIEDAD = A.CDGO_SOCIOTOR"
				+ "			  LEFT JOIN PASG.TBASG197_FORMACION FO ON FO.CDGO_EXPEDIENT = A.CDGO_EXPEDIENT"
				+ "			  LEFT JOIN PASG.TBASG116_ESTADOS EFO ON EFO.CDGO_ESTADO = FO.CDGO_ESTADO" + "	WHERE	";
		
		sqlString = sqlString + "	A.MRCA_ACTIVO ='S' AND B.FCHA_ESTADO IN (SELECT MAX(EX.FCHA_ESTADO) FROM PASG.TBASG118_ESTADOEXP EX "
				+ "				           WHERE EX.CDGO_EXPEDIENT = B.CDGO_EXPEDIENT) AND (FO.CDGO_SOLICITUD IN ( "
				+ "					       SELECT MAX(FO2.CDGO_SOLICITUD) as CDGO_SOLICITUD FROM PASG.TBASG197_FORMACION FO2 WHERE FO2.CDGO_EXPEDIENT = FO.CDGO_EXPEDIENT) "
				+ "        		           OR FO.CDGO_SOLICITUD IS NULL) ";
		
		if(filtro!=null) {
		
		if(Objects.nonNull(filtro.getCdgoPersona())) { 
			
			sqlString = sqlString + " AND A.CDGO_PERSONA = :cdgoPersona " ; 
			} 
		
		if(Objects.nonNull(filtro.getCdgoTipoHab())) { 
			sqlString = sqlString + " AND A.CDGO_TIPOHAB = :tipoHabil " ; 
			} 
		
		if(Objects.nonNull(filtro.getCdgoEmpresa())) { 
			sqlString = sqlString + " AND A.CDGO_EMPRESA = :empresa " ; 
			}
		
		if(Objects.nonNull(filtro.getCdgoEstado())) { 
			sqlString = sqlString + " AND B.CDGO_ESTADO = :estado " ; 
			}		
		
		if(Objects.nonNull(filtro.getCdgoEstado())) { 
			sqlString = sqlString + " AND (B.CDGO_ESTADO = :estadoOtorgao " ; 
			
		if(Objects.nonNull(filtro.getFchaDesde())) { 
			sqlString = sqlString + " B.FCHA_ESTADO >= :fecOtorDesde " ; 
			} 
		
		if(Objects.nonNull(filtro.getFchaHasta())) { 
			sqlString = sqlString + " B.FCHA_ESTADO <= :fecOtorHasta) " ; 
			}	
		}
		
		}
		
		sqlString = sqlString + "	ORDER BY A.CDGO_EXPEDIENT DESC";		
		
		Query sqlquery = em.createNativeQuery(sqlString);	
		
		if(filtro!=null) {

		if(Objects.nonNull(filtro.getCdgoPersona())) { 
			sqlquery.setParameter("cdgoPersona", filtro.getCdgoPersona()); 
		}
		
		if(Objects.nonNull(filtro.getCdgoTipoHab())) { 
			sqlquery.setParameter("tipoHabil", filtro.getCdgoTipoHab()); 
		}
		
		if(Objects.nonNull(filtro.getCdgoEmpresa())) { 
			sqlquery.setParameter("empresa", filtro.getCdgoEmpresa()); 
		}
		
		if(Objects.nonNull(filtro.getCdgoEstado())) { 
			sqlquery.setParameter("estado", filtro.getCdgoEstado()); 
		}
				
		if(Objects.nonNull(filtro.getCdgoEstado())) { 
			sqlquery.setParameter("estadoOtorgao", filtro.getCdgoEstado()); 	
		
			if(Objects.nonNull(filtro.getFchaDesde())) { 
				sqlquery.setParameter("fecOtorDesde", filtro.getFchaDesde()); 
			}
			
			if(Objects.nonNull(filtro.getFchaHasta())) { 
				sqlquery.setParameter("fecOtorHasta", filtro.getFchaHasta()); 
			}
		}
		
		}

	
		List<Object[]> resultados = sqlquery.getResultList();
		List<DataGetExpedientesPersonaListDTO> resultadosDevueltos = new ArrayList<>();
		
		for (Object[] object : resultados) {
			DataGetExpedientesPersonaListDTO data = new DataGetExpedientesPersonaListDTO();
						
			data.setCdgoExpedient((Integer) object[0]);
			data.setCdgoEstado((Integer) object[1]);
			data.setDesgNombreEstado((String)object[2]);

            Date fchaEstado = new Date(((Timestamp) object[3]).getTime());  
			data.setFchaEstado(fchaEstado);

			data.setDesgNombreTipoHabilita((String) object[4]);
			data.setCdgoAlcanceOt((Integer) object[5]);
			data.setCdgoEspec((Integer) object[6]);
			data.setDesgTipoInfraestruc(String.valueOf((Character) object[8]));			
			data.setCdgoEntorno((Integer) object[9]);
			data.setCdgoLinea((String) object[10]);
			data.setCdgoSerie((String) object[11]);
			data.setDesgAviso((String) object[13]);
			data.setDesgNombreAmbito((String) object[14]);
			data.setCdgoAmbitos((Integer) object[15]);
			data.setCdgoTipoHab((Integer) object[16]);
			data.setDesgNombreEmpresa((String) object[18]);
			data.setCdgoAlcanauxcab((Integer) object[21]);
			data.setFchaCurso((Date) object[22]);
			data.setCdgoSociotor((String) object[23]);
			data.setDesgSociedad((String) object[24]);
			data.setDesgObserva((String) object[25]); 
			data.setMrcaActivo(String.valueOf((Character) object[26])); 			
			data.setDescripAlcanse(this.getDescripAlcanseExpediente( object[5], object[21], object[6], object[9], object[10], object[11] ));
			data.setCdgoEmpresa((Integer) object[27]);
			
			resultadosDevueltos.add(data);
		}
		return resultadosDevueltos;
		
	}
	

	public List<Tbasg104Expedient> getExpedientesPersonaListCount(String cdgoPersona) {
		String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG104_EXPEDIENT WHERE CDGO_PERSONA = :codPersona";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg104Expedient.class);
		sqlquery.setParameter("codPersona", cdgoPersona);
		return sqlquery.getResultList();
	}

	@Transactional
	public int getExistHabilitacion(Tbasg104ExpedientDto bean) {
		String sqlString = "SELECT COUNT(*) AS VALUE "
			+ "	FROM PASG.TBASG104_EXPEDIENT A, PASG.TBASG118_ESTADOEXP B "
			+ "	WHERE "
			+ "	A.CDGO_EXPEDIENT = B.CDGO_EXPEDIENT "
			+ "	AND B.FCHA_ESTADO = (SELECT MAX(FCHA_ESTADO) FROM PASG.TBASG118_ESTADOEXP WHERE CDGO_EXPEDIENT = B.CDGO_EXPEDIENT AND MRCA_ACTIVO = 'S') " 
			+ "	AND B.CDGO_ESTADO != 4  "
			+ "	AND B.MRCA_ACTIVO = 'S' "
			+ "	AND A.MRCA_ACTIVO = 'S' "
			+ "	AND A.CDGO_PERSONA = :cdgoPersona "
			+ "	AND A.CDGO_EMPRESA = :cdgoEmpresa "
			+ "	AND A.CDGO_TIPOHAB = :cdgoTipoHab ";

		if (Objects.nonNull(bean.getCdgoSerie())) {
			sqlString += " AND A.CDGO_SERIE = :Serie ";

			if (Objects.nonNull(bean.getCdgoSubserie())) {
				sqlString += " AND A.CDGO_SUBSERIE = :Subserie ";
			} else {
				sqlString += " AND A.CDGO_SUBSERIE IS NULL ";
			}		
		}
	
		if (Objects.nonNull(bean.getCdgoAlcanceot())) {
			sqlString += " AND A.CDGO_ALCANCEOT = :AuxOpTren ";	
		}

		if (Objects.nonNull(bean.getCdgoEspec())) {
			sqlString += " AND A.CDGO_ESPEC = :Cargador ";	
		}
		
		if (Objects.nonNull(bean.getAlcance())) {			 
			if ("L".equals(bean.getAlcance())) {
				if (Objects.nonNull(bean.getCdgoLinea())) {
					sqlString += " AND A.CDGO_LINEA = :cdgoLinea ";
				}				

			} else if ("E".equals(bean.getAlcance())) { 
				if (Objects.nonNull(bean.getCdgoEntorno())) {
					sqlString += " AND A.CDGO_ENTORNO = :cdgoEntorno ";
				}				
			}						
		}
	
		if (Objects.nonNull(bean.getCdgoAlcanceambito())) {
			sqlString += " AND A.CDGO_ALCANCEAMBITO = :AlcancesOVM ";	
		}		
	
		if (Objects.nonNull(bean.getCdgoAmbitos())) {
			sqlString += " AND A.CDGO_AMBITOS = :Ambito ";	
		}

	
		Query sqlquery = em.createNativeQuery(sqlString);

	
		if (Objects.nonNull(bean.getCdgoPersona())) {
			sqlquery.setParameter("cdgoPersona", bean.getCdgoPersona());
		}

		if (Objects.nonNull(bean.getCdgoEmpresa())) {
			sqlquery.setParameter("cdgoEmpresa", bean.getCdgoEmpresa());
		}

		if (Objects.nonNull(bean.getCdgoTipohab())) {
			sqlquery.setParameter("cdgoTipoHab", bean.getCdgoTipohab());
		}

		if (Objects.nonNull(bean.getCdgoSerie())) {
			sqlquery.setParameter("Serie", bean.getCdgoSerie());

			if (Objects.nonNull(bean.getCdgoSubserie())) {
				sqlquery.setParameter("Subserie", bean.getCdgoSubserie());
			} 	
		}
	
		if (Objects.nonNull(bean.getCdgoAlcanceot())) {
			sqlquery.setParameter("AuxOpTren", bean.getCdgoAlcanceot());
		}

		if (Objects.nonNull(bean.getCdgoEspec())) {
			sqlquery.setParameter("Cargador", bean.getCdgoEspec());
		}
		
		if (Objects.nonNull(bean.getAlcance())) {			 
			if ("L".equals(bean.getAlcance())) {
				if (Objects.nonNull(bean.getCdgoLinea())) {
					sqlquery.setParameter("cdgoLinea", bean.getCdgoLinea());
				}				

			} else if ("E".equals(bean.getAlcance())) { 
				if (Objects.nonNull(bean.getCdgoEntorno())) {
					sqlquery.setParameter("cdgoEntorno", bean.getCdgoEntorno());
				}				
			}						
		}
	
		if (Objects.nonNull(bean.getCdgoAlcanceambito())) {
			sqlquery.setParameter("AlcancesOVM", bean.getCdgoAlcanceambito());
		}		
	
		if (Objects.nonNull(bean.getCdgoAmbitos())) {	
			sqlquery.setParameter("Ambito", bean.getCdgoAmbitos());
		}				

		System.out.println("---> CONSULTA LANZADA: "+sqlString);

		List<Integer> results = sqlquery.getResultList();
		int count = 0;
  
		for (Integer item : results) {
		  count = (int) item;
		}
  
		return count;		
	}

	public List<GetExpedientesPersonaLtDTO> getExpedientesPersonaListCod(String cdgoPersona, Integer cdgoEstado) {

		String sqlString = "SELECT B.CDGO_EXPEDIENT, B.CDGO_ESTADO, UPPER(RTRIM(E.DESG_NOMBRE)) AS ESTADO, B.FCHA_ESTADO, "
				+ "	    	D.CDGO_TIPOHAB, A.CDGO_ALCANCEOT, A.CDGO_ESPEC, A.CDGO_ALCANCEAMBITO, A.DESG_TIPOINFRAESTRUC, "
				+ "	    	A.CDGO_ENTORNO, A.CDGO_LINEA, UPPER(RTRIM(A.CDGO_SERIE)) AS CDGO_SERIE, "
				+ "	    	UPPER(RTRIM(A.CDGO_SUBSERIE)) AS CDGO_SUBSERIE, UPPER(RTRIM(C.DESG_NOMBRE)) AS AMBITO, "
				+ "	    	UPPER(RTRIM(F.DESG_NOMBRE)) AS EMPRESA,	MAX(G.FCHA_CURSO) AS FCHA_INI_VALIDEZ,"
				+ "	        MAX(G.FCHA_CURSO) + 3 YEARS AS FCHA_FIN_VALIDEZ ,A.CDGO_SOCIOTOR, S.DESC_SOCIEDAD"
				+ "		 FROM PASG.TBASG104_EXPEDIENT A    		"
				+ "			LEFT OUTER JOIN PASG.TBASG121_ACTAFORMA H ON (H.CDGO_EXPEDIENT = A.CDGO_EXPEDIENT and H.MRCA_ACTIVO = 'S')"
				+ "		    LEFT OUTER JOIN PASG.TBASG146_ACTAINCAL G ON (G.CDGO_ACTAFORM = H.CDGO_ACTAFORM and G.MRCA_ACTIVO = 'S')"
				+ "		    LEFT OUTER JOIN PASG.TBASG261_SOCIEDADES S ON (A.CDGO_SOCIOTOR = S.CDGO_SOCIEDAD and S.MRCA_ACTIVO = 'S')"
				+ "		    INNER JOIN PASG.TBASG118_ESTADOEXP B ON (B.CDGO_EXPEDIENT = A.CDGO_EXPEDIENT)      "
				+ "		    INNER JOIN PASG.TBASG116_ESTADOS E ON (E.CDGO_ESTADO = B.CDGO_ESTADO)      "
				+ "		    INNER JOIN PASG.TBASG124_AMBITOS C ON (C.CDGO_AMBITOS = A.CDGO_AMBITOS)      "
				+ "		    INNER JOIN PASG.TBASG123_TIPOHABIL D ON (A.CDGO_TIPOHAB = D.CDGO_TIPOHAB)"
				+ "		    INNER JOIN PASG.TBASG125_EMPRESA F ON (A.CDGO_EMPRESA = F.CDGO_EMPRESA)" 
				+ "   WHERE A.MRCA_ACTIVO = 'S' AND B.FCHA_ESTADO IN (SELECT MAX(FCHA_ESTADO) FROM PASG.TBASG118_ESTADOEXP  WHERE B.CDGO_EXPEDIENT = CDGO_EXPEDIENT AND MRCA_ACTIVO = 'S') ";
		
		if(Objects.nonNull(cdgoPersona)) {
			sqlString = sqlString + " AND A.CDGO_PERSONA = :cdgoPersona " ;
			}
			
		if(Objects.nonNull(cdgoEstado)) {
			sqlString = sqlString + " B.CDGO_ESTADO = :cdgoEstado " ;
			}
		
		sqlString = sqlString + " AND B.CDGO_ESTADO IN (5, 7, 9, 13, 14, 15) ";
		
		sqlString = sqlString + " GROUP BY B.CDGO_EXPEDIENT,  B.CDGO_ESTADO, E.DESG_NOMBRE, B.FCHA_ESTADO, "
				+ "			D.CDGO_TIPOHAB, A.CDGO_ALCANCEOT, A.CDGO_ESPEC, A.CDGO_ALCANCEAMBITO, A.DESG_TIPOINFRAESTRUC, "
				+ "			A.CDGO_ENTORNO, A.CDGO_LINEA, A.CDGO_SERIE, A.CDGO_SUBSERIE, C.DESG_NOMBRE, F.DESG_NOMBRE , A.CDGO_SOCIOTOR, S.DESC_SOCIEDAD "
				+ "			ORDER BY A.CDGO_SOCIOTOR, CDGO_TIPOHAB ";
		
		Query sqlquery = em.createNativeQuery(sqlString);

		if(Objects.nonNull(cdgoPersona)) {
			sqlquery.setParameter("cdgoPersona", cdgoPersona);
			}

		if(Objects.nonNull(cdgoEstado)) {
			sqlquery.setParameter("tipoHabil", cdgoEstado);
			}

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetExpedientesPersonaLtDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetExpedientesPersonaLtDTO expediente = new GetExpedientesPersonaLtDTO();

			expediente.setCdgoExpedient((Integer) object[0]);
			expediente.setCdgoEstado((Integer) object[1]);
			expediente.setDesgNombreEstado((String) object[2]);
			expediente.setFchaEstado((Date) object[3]);
			expediente.setCdgoTipoHab((Integer) object[4]);
			expediente.setCdgoAlcanceOt((Integer) object[5]);
			expediente.setCdgoEspec((Integer) object[6]);
			expediente.setCdgoAlcanceAmbito((Integer) object[7]);
			expediente.setDesgTipoInfraestruc(String.valueOf((Character) object[8]));
			expediente.setCdgoEntorno((Integer) object[9]);
			expediente.setCdgoLinea((String) object[10]);
			expediente.setCdgoSerie((String) object[11]);
			expediente.setCdgoSubSerie((String) object[12]); 
			expediente.setDesgNombreAmbito((String) object[13]);
			expediente.setDesgNombreEmpresa((String) object[14]);
			expediente.setFchaIniValidez((Date) object[15]);
			expediente.setFchaFinValidez((Date) object[16]);
			expediente.setCdgoSociotor((String) object[17]);
			expediente.setDescSociedad((String) object[18]);

			resultadosDevueltos.add(expediente);
		}
		return resultadosDevueltos;
	}

	public List<GetExpedientesPersonaLtDTO> getExpedientesPersonaListCodUserBaja(String cdgoPersona) {

		String sqlString = "SELECT B.CDGO_EXPEDIENT, B.CDGO_ESTADO, UPPER(RTRIM(E.DESG_NOMBRE)) AS ESTADO, B.FCHA_ESTADO, "
				+ "	    	D.CDGO_TIPOHAB, A.CDGO_ALCANCEOT, A.CDGO_ESPEC, A.CDGO_ALCANCEAMBITO, A.DESG_TIPOINFRAESTRUC, "
				+ "	    	A.CDGO_ENTORNO, A.CDGO_LINEA, UPPER(RTRIM(A.CDGO_SERIE)) AS CDGO_SERIE, "
				+ "	    	UPPER(RTRIM(A.CDGO_SUBSERIE)) AS CDGO_SUBSERIE, UPPER(RTRIM(C.DESG_NOMBRE)) AS AMBITO, "
				+ "	    	UPPER(RTRIM(F.DESG_NOMBRE)) AS EMPRESA,	MAX(G.FCHA_CURSO) AS FCHA_INI_VALIDEZ,"
				+ "	        MAX(G.FCHA_CURSO) + 3 YEARS AS FCHA_FIN_VALIDEZ ,A.CDGO_SOCIOTOR, S.DESC_SOCIEDAD"
				+ "		 FROM PASG.TBASG104_EXPEDIENT A    		"
				+ "			LEFT OUTER JOIN PASG.TBASG121_ACTAFORMA H ON (H.CDGO_EXPEDIENT = A.CDGO_EXPEDIENT)"
				+ "		    LEFT OUTER JOIN PASG.TBASG146_ACTAINCAL G ON (G.CDGO_ACTAFORM = H.CDGO_ACTAFORM)"
				+ "		    LEFT OUTER JOIN PASG.TBASG261_SOCIEDADES S ON (A.CDGO_SOCIOTOR = S.CDGO_SOCIEDAD)"
				+ "		    INNER JOIN PASG.TBASG118_ESTADOEXP B ON (B.CDGO_EXPEDIENT = A.CDGO_EXPEDIENT)      "
				+ "		    INNER JOIN PASG.TBASG116_ESTADOS E ON (E.CDGO_ESTADO = B.CDGO_ESTADO)      "
				+ "		    INNER JOIN PASG.TBASG124_AMBITOS C ON (C.CDGO_AMBITOS = A.CDGO_AMBITOS)      "
				+ "		    INNER JOIN PASG.TBASG123_TIPOHABIL D ON (A.CDGO_TIPOHAB = D.CDGO_TIPOHAB)"
				+ "		    INNER JOIN PASG.TBASG125_EMPRESA F ON (A.CDGO_EMPRESA = F.CDGO_EMPRESA)" 
				+ "  WHERE B.FCHA_ESTADO IN ( SELECT MAX(FCHA_ESTADO) FROM PASG.TBASG118_ESTADOEXP  WHERE B.CDGO_EXPEDIENT = CDGO_EXPEDIENT) AND A.CDGO_PERSONA = :value "
				+ "		GROUP BY B.CDGO_EXPEDIENT,  B.CDGO_ESTADO, E.DESG_NOMBRE, B.FCHA_ESTADO, "
				+ "    		D.CDGO_TIPOHAB, A.CDGO_ALCANCEOT, A.CDGO_ESPEC, A.CDGO_ALCANCEAMBITO, A.DESG_TIPOINFRAESTRUC, "
				+ "	    	A.CDGO_ENTORNO, A.CDGO_LINEA, A.CDGO_SERIE, A.CDGO_SUBSERIE, C.DESG_NOMBRE, F.DESG_NOMBRE , A.CDGO_SOCIOTOR, S.DESC_SOCIEDAD"
				+ "		ORDER BY A.CDGO_SOCIOTOR, CDGO_TIPOHAB";
		
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetExpedientesPersonaLtDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetExpedientesPersonaLtDTO userbaja = new GetExpedientesPersonaLtDTO();

			userbaja.setCdgoExpedient((Integer) object[0]);
			userbaja.setCdgoEstado((Integer) object[1]);
			userbaja.setDesgNombreEstado((String) object[2]);
			userbaja.setFchaEstado((Date) object[3]);
			userbaja.setCdgoTipoHab((Integer) object[4]);
			userbaja.setCdgoAlcanceOt((Integer) object[5]);
			userbaja.setCdgoEspec((Integer) object[6]);
			userbaja.setCdgoAlcanceAmbito((Integer) object[7]);
			userbaja.setDesgTipoInfraestruc(String.valueOf((Character) object[8]));
			userbaja.setCdgoEntorno((Integer) object[9]);
			userbaja.setCdgoLinea((String) object[10]);
			userbaja.setCdgoSerie((String) object[11]);
			userbaja.setCdgoSubSerie((String) object[12]); 
			userbaja.setDesgNombreAmbito((String) object[13]);
			userbaja.setDesgNombreEmpresa((String) object[14]);
			userbaja.setFchaIniValidez((Date) object[15]);
			userbaja.setFchaFinValidez((Date) object[16]);
			userbaja.setCdgoSociotor((String) object[17]);
			userbaja.setDescSociedad((String) object[18]);

			resultadosDevueltos.add(userbaja);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg104Expedient> findExpedientByCdgoPersonaAndTipoHab(String cdgoPersona, List<Integer>listaCodigosHab) {

		String sqlString = "SELECT * " 
				+ "		FROM PASG.TBASG104_EXPEDIENT " 
				+ "		WHERE "
				+ "			CDGO_PERSONA = :cdgoPersona " 
				+ "			AND MRCA_ACTIVO = 'S'"
				+ " 		AND CDGO_TIPOHAB IN (:listaCodigosHab)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg104Expedient.class);
		sqlquery.setParameter("cdgoPersona", cdgoPersona);
		sqlquery.setParameter("listaCodigosHab", listaCodigosHab);
		return sqlquery.getResultList();
	}

	public List<GetFindFchaExpedienteOtorgadoParaAotDTO> findFchaExpedienteParaAOT(Integer cdgoPersona, Integer cdgoTipohab,
			Integer cdgoAlcanceot) {

		String sqlString = " SELECT * FROM PASG.TBASG104_EXPEDIENT WHERE CDGO_PERSONA = :cdgoPersona AND MRCA_ACTIVO = 'S'\r\n"
				+ "AND CDGO_TIPOHAB = :cdgoTipoHab AND CDGO_ALCANCEOT = :cdgoAlcanceOT ";
		
		Query sqlquery = em.createNativeQuery(sqlString);
		
		sqlquery.setParameter("cdgoPersona", cdgoPersona);
		sqlquery.setParameter("cdgoTipoHab", cdgoTipohab);
		sqlquery.setParameter("cdgoAlcanceOT", cdgoAlcanceot);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetFindFchaExpedienteOtorgadoParaAotDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetFindFchaExpedienteOtorgadoParaAotDTO expe = new GetFindFchaExpedienteOtorgadoParaAotDTO();

			expe.setCdgoExpedient((Integer) object[0]);
			expe.setFchaExpediente((Date) object[1]);
			expe.setCdgoPersona((Integer) object[2]);
			expe.setCdgoEmpresa((Integer) object[3]);
			expe.setCdgoTipohab((Integer) object[4]);
			expe.setCdgoAmbitos((Integer) object[5]);
			expe.setCdgoAlcanceot((Integer) object[6]);
			expe.setCdgoEspec((Integer) object[7]);
			expe.setCdgoAlcanceambito((Integer) object[8]);
			expe.setDesgTipoinfraestruc(String.valueOf((Character) object[9]));
			expe.setCdgoEntorno((Integer) object[10]);
			expe.setCdgoLinea((String) object[11]);
			expe.setCdgoSerie((String) object[12]);
			expe.setCdgoSubSerie((String) object[13]);
			expe.setDesgObserva((String) object[14]);
			expe.setDesgUsuact((String) object[15]);
			expe.setFchaAct((Date) object[16]);
			expe.setMrcaActivo(String.valueOf((Character) object[17]));
			expe.setDesgAviso((String) object[18]);
			expe.setCdgoAlcanauxcab((Integer) object[19]);
			expe.setCdgoSociotor((String) object[20]);
			expe.setDesgObservaExt((String) object[21]);		

			resultadosDevueltos.add(expe);
		}
		return resultadosDevueltos;
	
	}

	public List<GetFindFchaExpedienteOtorgadoParaAotDTO> findFchaExpedienteOtorgadoParaAOT(Integer cdgoPersona, Integer cdgoTipohab,
			Integer cdgoAlcanceot) {

		String sqlString = " SELECT EXP.CDGO_EXPEDIENT AS CDGO_EXPEDIENTT, EXP.FCHA_EXPEDIENTE, EXP.CDGO_PERSONA, EXP.CDGO_EMPRESA, EXP.CDGO_TIPOHAB, EXP.CDGO_AMBITOS, EXP.CDGO_ALCANCEOT,\r\n"
				+ "EXP.CDGO_ESPEC, EXP.CDGO_ALCANCEAMBITO, EXP.DESG_TIPOINFRAESTRUC, EXP.CDGO_ENTORNO, EXP.CDGO_LINEA, EXP.CDGO_SERIE, EXP.CDGO_SUBSERIE, EXP.DESG_OBSERVA,\r\n"
				+ "EXP.DESG_USUACT AS DESG_USUACTT, EXP.FCHA_ACT AS FCHA_ACTT, EXP.MRCA_ACTIVO AS MRCA_ACTIVOO, EXP.DESG_AVISO, EXP.CDGO_ALCANAUXCAB, EXP.CDGO_SOCIOTOR,\r\n"
				+ "EXP.DESG_OBSERVA_EXT  FROM PASG.TBASG104_EXPEDIENT EXP INNER JOIN PASG.TBASG118_ESTADOEXP EST ON EXP.CDGO_EXPEDIENT = EST.CDGO_EXPEDIENT\r\n"
				+ "WHERE EXP.CDGO_PERSONA = :cdgoPersona	AND EXP.MRCA_ACTIVO = 'S'AND EXP.CDGO_TIPOHAB = :cdgoTipoHab AND EXP.CDGO_ALCANCEOT = :cdgoAlcanceOT\r\n"
				+ "AND EST.CDGO_ESTADO = 9	AND EST.FCHA_ESTADO = (SELECT MAX(EX2.FCHA_ESTADO) FROM PASG.TBASG118_ESTADOEXP EX2\r\n"
				+ "WHERE EX2.CDGO_EXPEDIENT = EST.CDGO_EXPEDIENT AND EX2.CDGO_ESTADO = 9) ";
		
		Query sqlquery = em.createNativeQuery(sqlString);
		
		sqlquery.setParameter("cdgoPersona", cdgoPersona);
		sqlquery.setParameter("cdgoTipoHab", cdgoTipohab);
		sqlquery.setParameter("cdgoAlcanceOT", cdgoAlcanceot);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetFindFchaExpedienteOtorgadoParaAotDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetFindFchaExpedienteOtorgadoParaAotDTO expe = new GetFindFchaExpedienteOtorgadoParaAotDTO();

			expe.setCdgoExpedient((Integer) object[0]);
			expe.setFchaExpediente((Date) object[1]);
			expe.setCdgoPersona((Integer) object[2]);
			expe.setCdgoEmpresa((Integer) object[3]);
			expe.setCdgoTipohab((Integer) object[4]);
			expe.setCdgoAmbitos((Integer) object[5]);
			expe.setCdgoAlcanceot((Integer) object[6]);
			expe.setCdgoEspec((Integer) object[7]);
			expe.setCdgoAlcanceambito((Integer) object[8]);
			expe.setDesgTipoinfraestruc(String.valueOf((Character) object[9]));
			expe.setCdgoEntorno((Integer) object[10]);
			expe.setCdgoLinea((String) object[11]);
			expe.setCdgoSerie((String) object[12]);
			expe.setCdgoSubSerie((String) object[13]);
			expe.setDesgObserva((String) object[14]);
			expe.setDesgUsuact((String) object[15]);
			expe.setFchaAct((Date) object[16]);
			expe.setMrcaActivo(String.valueOf((Character) object[17]));
			expe.setDesgAviso((String) object[18]);
			expe.setCdgoAlcanauxcab((Integer) object[19]);
			expe.setCdgoSociotor((String) object[20]);
			expe.setDesgObservaExt((String) object[21]);
			
			//expe.setCdgoExpedientEstado((Integer) object[22]);
			//expe.setCdgoEstado((Integer) object[23]);
			//expe.setFchaEstado((Date) object[24]);
			//expe.setDesgUsuactEstado((String) object[25]);
			//expe.setFchaActEstado((Date) object[26]);
			//expe.setMrcaActivoEstado(String.valueOf((Character) object[27]));
  
			resultadosDevueltos.add(expe);
		}
		return resultadosDevueltos;
	}

	public List<GetfindFchaHabilitacionParaAotDTO> findFchaHabilitacionParaAOT(Integer cdgoExpedient) {

		String sqlString = " SELECT MAX(G.FCHA_CURSO) FCHA_CURSO  FROM PASG.TBASG104_EXPEDIENT EXP INNER JOIN PASG.TBASG118_ESTADOEXP EST ON EXP.CDGO_EXPEDIENT = EST.CDGO_EXPEDIENT "
				+ "LEFT OUTER JOIN PASG.TBASG121_ACTAFORMA H ON (H.CDGO_EXPEDIENT = EXP.CDGO_EXPEDIENT and H.MRCA_ACTIVO = 'S')   "
				+ "LEFT OUTER JOIN PASG.TBASG146_ACTAINCAL G ON (G.CDGO_ACTAFORM = H.CDGO_ACTAFORM and G.MRCA_ACTIVO = 'S')  "
				+ "WHERE EXP.CDGO_EXPEDIENT = :value AND EST.CDGO_ESTADO IN (5, 7, 9, 13, 14, 15)    AND EST.FCHA_ESTADO = (SELECT MAX(EX2.FCHA_ESTADO)  "
				+ "FROM PASG.TBASG118_ESTADOEXP EX2 WHERE EX2.CDGO_EXPEDIENT = EST.CDGO_EXPEDIENT AND EX2.CDGO_ESTADO IN (5, 7, 9, 13, 14, 15)) ";
		
		Query sqlquery = em.createNativeQuery(sqlString);
		
		sqlquery.setParameter("value", cdgoExpedient);

		List<Object> resultados = sqlquery.getResultList();
		List<GetfindFchaHabilitacionParaAotDTO> resultadosDevueltos = new ArrayList<>();
		for (Object object : resultados) {
			GetfindFchaHabilitacionParaAotDTO fchaaot = new GetfindFchaHabilitacionParaAotDTO();

			fchaaot.setFchaCurso((Date) object);

			resultadosDevueltos.add(fchaaot);
		}
		return resultadosDevueltos;
	}
	
	public List<GetFechaFinValidezDTO> getFechaFinValidez(Integer cdgoExpedient) {

		String sqlString = " SELECT MAX(G.FCHA_CURSO) + 3 YEARS AS FCHA_FIN_VALIDEZ FROM PASG.TBASG104_EXPEDIENT A    "
				+ "LEFT OUTER JOIN PASG.TBASG121_ACTAFORMA H ON H.CDGO_EXPEDIENT = A.CDGO_EXPEDIENT "
				+ "LEFT OUTER JOIN PASG.TBASG146_ACTAINCAL G ON G.CDGO_ACTAFORM = H.CDGO_ACTAFORM "
				+ "WHERE A.CDGO_EXPEDIENT =  :value GROUP BY A.CDGO_EXPEDIENT ";
		
		Query sqlquery = em.createNativeQuery(sqlString);
		
		sqlquery.setParameter("value", cdgoExpedient);

		List<Object> resultados = sqlquery.getResultList();
		List<GetFechaFinValidezDTO> resultadosDevueltos = new ArrayList<>();
		for (Object object : resultados) {
			GetFechaFinValidezDTO fchafinvalidez = new GetFechaFinValidezDTO();

			fchafinvalidez.setFchaFinValidez((Date) object);

			resultadosDevueltos.add(fchafinvalidez);
		}
		return resultadosDevueltos;
	}
	
	public List<GetFechaFinValidezDTO> getFechaFinValidez2(Integer cdgoExpedient) {

		String sqlString = " SELECT MAX(G.FCHA_CURSO) + 2 YEARS AS FCHA_FIN_VALIDEZ FROM PASG.TBASG104_EXPEDIENT A    "
				+ "LEFT OUTER JOIN PASG.TBASG121_ACTAFORMA H ON H.CDGO_EXPEDIENT = A.CDGO_EXPEDIENT "
				+ "LEFT OUTER JOIN PASG.TBASG146_ACTAINCAL G ON G.CDGO_ACTAFORM = H.CDGO_ACTAFORM "
				+ "WHERE A.CDGO_EXPEDIENT =  :value GROUP BY A.CDGO_EXPEDIENT ";
		
		Query sqlquery = em.createNativeQuery(sqlString);
		
		sqlquery.setParameter("value", cdgoExpedient);

		List<Object> resultados = sqlquery.getResultList();
		List<GetFechaFinValidezDTO> resultadosDevueltos = new ArrayList<>();
		for (Object object : resultados) {
			GetFechaFinValidezDTO fchafinvalidez = new GetFechaFinValidezDTO();

			fchafinvalidez.setFchaFinValidez((Date) object);

			resultadosDevueltos.add(fchafinvalidez);
		}
		return resultadosDevueltos;
	}
	
	public List<GetFechaFinValidezDTO> getFechaFinValidez3(Integer cdgoExpedient) {

		String sqlString = " SELECT MAX(G.FCHA_CURSO) AS FCHA_FIN_VALIDEZ FROM PASG.TBASG104_EXPEDIENT A    "
				+ "LEFT OUTER JOIN PASG.TBASG121_ACTAFORMA H ON H.CDGO_EXPEDIENT = A.CDGO_EXPEDIENT "
				+ "LEFT OUTER JOIN PASG.TBASG146_ACTAINCAL G ON G.CDGO_ACTAFORM = H.CDGO_ACTAFORM "
				+ "WHERE A.CDGO_EXPEDIENT =  :value GROUP BY A.CDGO_EXPEDIENT ";
		
		Query sqlquery = em.createNativeQuery(sqlString);
		
		sqlquery.setParameter("value", cdgoExpedient);

		List<Object> resultados = sqlquery.getResultList();
		List<GetFechaFinValidezDTO> resultadosDevueltos = new ArrayList<>();
		for (Object object : resultados) {
			GetFechaFinValidezDTO fchafinvalidez = new GetFechaFinValidezDTO();

			fchafinvalidez.setFchaFinValidez((Date) object);

			resultadosDevueltos.add(fchafinvalidez);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg104Expedient> findExpedientByCdgoPersonaAndLinea(String cdgoPersona, String cdgoTipohab) {

		String sqlString = "SELECT EXPEDIENT.CDGO_EXPEDIENT,EXPEDIENT.DESG_TIPOINFRAESTRUC, EXPEDIENT.CDGO_LINEA"
				+ "			FROM PASG.TBASG104_EXPEDIENT EXPEDIENT, PASG.TBASG118_ESTADOEXP ESTADOEXP"
				+ "			 WHERE EXPEDIENT.MRCA_ACTIVO ='S' AND (EXPEDIENT.CDGO_LINEA IS NOT NULL OR EXPEDIENT.CDGO_ENTORNO IS NOT NULl) "
				+ "			 AND EXPEDIENT.CDGO_PERSONA = :cdgoPersona"
				+ "			 AND EXPEDIENT.CDGO_TIPOHAB = :tipoHabilitacion"
				+ "			 AND EXPEDIENT.CDGO_EXPEDIENT = ESTADOEXP.CDGO_EXPEDIENT"
				+ "			 AND ESTADOEXP.MRCA_ACTIVO ='S'"
				+ "			 AND ESTADOEXP.CDGO_ESTADO IN (5, 7, 9, 13, 14, 15)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg104Expedient.class);
		sqlquery.setParameter("cdgoPersona", cdgoPersona);
		sqlquery.setParameter("tipoHabilitacion", cdgoTipohab);
		return sqlquery.getResultList();
	}

	public List<Tbasg104Expedient> getObservaExt(String cdgoPersona) {

		String sqlString = "SELECT * " + "		 FROM PASG.TBASG104_EXPEDIENT " + "		 WHERE CDGO_PERSONA=:value "
				+ "		 ORDER BY FCHA_EXPEDIENTE DESC " + "		 FETCH FIRST 3 ROWS ONLY ";
		
		Query sqlquery = em.createNativeQuery(sqlString);
		
		sqlquery.setParameter("value", cdgoPersona);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg104Expedient> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg104Expedient expe = new Tbasg104Expedient();

			expe.setCdgoExpedient(Long.valueOf((int)object[0]));
			expe.setFchaExpediente((Date) object[1]);
			expe.setCdgoPersona((Integer) object[2]);
			expe.setCdgoEmpresa((Integer) object[3]);
			expe.setCdgoTipohab((Integer) object[4]);
			expe.setCdgoAmbitos((Integer) object[5]);
			expe.setCdgoAlcanceot((Integer) object[6]);
			expe.setCdgoEspec((Integer) object[7]);
			expe.setCdgoAlcanceambito((Integer) object[8]);
			expe.setDesgTipoinfraestruc(String.valueOf((Character) object[9]));
			expe.setCdgoEntorno((Integer) object[10]);
			expe.setCdgoLinea((String) object[11]);
			expe.setCdgoSerie((String) object[12]);
			expe.setCdgoSubSerie((String) object[13]);
			expe.setDesgObserva((String) object[14]);
			expe.setDesgUsuact((String) object[15]);
			expe.setFchaAct((Date) object[16]);
			expe.setMrcaActivo(String.valueOf((Character) object[17]));
			expe.setDesgAviso((String) object[18]);
			expe.setCdgoAlcanauxcab((Integer) object[19]);
			expe.setCdgoSociotor((String) object[20]);
			expe.setDesgObservaExt((String) object[21]);

			resultadosDevueltos.add(expe);
		}
		return resultadosDevueltos;
	}

	@Transactional
	public int insertExpediente(Tbasg104ExpedientDto bean) {
		int result      = 0;
		boolean isValid = true;

		if (Objects.isNull(bean.getCdgoPersona())) {			
			logger.error("--> Error updateExpedient: 'cdgoPersona' es requerido");
			isValid = false;
		}

		if (Objects.isNull(bean.getCdgoEmpresa())) {			
			logger.error("--> Error updateExpedient: 'cdgoEmpresa' es requerido");
			isValid = false;
		}
		
		if (Objects.isNull(bean.getCdgoTipohab())) {			
			logger.error("--> Error updateExpedient: 'cdgoTipohab' es requerido");
			isValid = false;
		}		
		
		if (Objects.isNull(bean.getCdgoAmbitos())) {			
			logger.error("--> Error updateExpedient: 'cdgoAmbitos' es requerido");
			isValid = false;
		}		
		
		if (Objects.isNull(bean.getCdgoSociotor())) {			
			logger.error("--> Error updateExpedient: 'cdgoSociotor' es requerido");
			isValid = false;
		}					
		
		if (isValid) {
			String sqlString = "INSERT INTO PASG.TBASG104_EXPEDIENT "
				+ " (FCHA_EXPEDIENTE, CDGO_PERSONA, CDGO_EMPRESA, CDGO_TIPOHAB, CDGO_AMBITOS, CDGO_ALCANCEOT, CDGO_ESPEC, "
				+ "	CDGO_ALCANCEAMBITO, DESG_TIPOINFRAESTRUC, CDGO_ENTORNO, CDGO_LINEA, CDGO_SERIE, CDGO_SUBSERIE, "
				+ "	DESG_OBSERVA, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO, CDGO_ALCANAUXCAB, CDGO_SOCIOTOR) "				
				+ "	VALUES (CURRENT_DATE, :cdgoPersona, :cdgoEmpresa, :cdgoTipohab, :cdgoAmbitos, :cdgoAlcanceot, :cdgoEspec, "
				+ " :cdgoAlcanceambito, :desgTipoinfraestruc, :cdgoEntorno, :cdgoLinea, :cdgoSerie, :cdgoSubserie, :desgObserva, "
				+ " :desgUsuact, CURRENT_DATE, :mrcaActivo, :cdgoAlcanauxcab, :cdgoSociotor) ";

			Query sqlquery = em.createNativeQuery(sqlString);

			sqlquery.setParameter("cdgoPersona", bean.getCdgoPersona());

			sqlquery.setParameter("cdgoEmpresa", bean.getCdgoEmpresa());

			sqlquery.setParameter("cdgoTipohab", bean.getCdgoTipohab());

			sqlquery.setParameter("cdgoAmbitos", bean.getCdgoAmbitos());

			sqlquery.setParameter("cdgoSociotor", bean.getCdgoSociotor());	

			if (Objects.nonNull(bean.getCdgoAlcanceambito())) {
				sqlquery.setParameter("cdgoAlcanceambito", bean.getCdgoAlcanceambito());
			} else { 
				sqlquery.setParameter("cdgoAlcanceambito", null);
			}  

			if (Objects.nonNull(bean.getCdgoAlcanceot())) {
				sqlquery.setParameter("cdgoAlcanceot", bean.getCdgoAlcanceot());
			} else { 
				sqlquery.setParameter("cdgoAlcanceot", null);
			}  

			if (Objects.nonNull(bean.getCdgoEspec())) {
				sqlquery.setParameter("cdgoEspec", bean.getCdgoEspec());
			} else { 
				sqlquery.setParameter("cdgoEspec", null);
			}  

			if (Objects.nonNull(bean.getDesgTipoinfraestruc())) {
				sqlquery.setParameter("desgTipoinfraestruc", bean.getDesgTipoinfraestruc());
			} else { 
				sqlquery.setParameter("desgTipoinfraestruc", null);
			}  

			if (Objects.nonNull(bean.getCdgoEntorno())) {
				sqlquery.setParameter("cdgoEntorno", bean.getCdgoEntorno());
			} else { 
				sqlquery.setParameter("cdgoEntorno", null);
			}  

			if (Objects.nonNull(bean.getCdgoLinea())) {
				sqlquery.setParameter("cdgoLinea", bean.getCdgoLinea());
			} else { 
				sqlquery.setParameter("cdgoLinea", null);
			}  

			if (Objects.nonNull(bean.getCdgoSerie())) {
				sqlquery.setParameter("cdgoSerie", bean.getCdgoSerie());
			} else { 
				sqlquery.setParameter("cdgoSerie", null);
			}  

			if (Objects.nonNull(bean.getCdgoSubserie())) {
				sqlquery.setParameter("cdgoSubserie", bean.getCdgoSubserie());
			} else { 
				sqlquery.setParameter("cdgoSubserie", null);
			}  

			if (Objects.nonNull(bean.getDesgObserva())) {
				sqlquery.setParameter("desgObserva", bean.getDesgObserva());
			} else { 
				sqlquery.setParameter("desgObserva", null);
			}  

			if (Objects.nonNull(bean.getDesgUsuact())) {
				sqlquery.setParameter("desgUsuact", bean.getDesgUsuact());
			} else { 
				sqlquery.setParameter("desgUsuact", null);
			}  

			if (Objects.nonNull(bean.getMrcaActivo())) {
				sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
			} else { 
				sqlquery.setParameter("mrcaActivo", null);
			}  

			if (Objects.nonNull(bean.getCdgoAlcanauxcab())) {
				sqlquery.setParameter("cdgoAlcanauxcab", bean.getCdgoAlcanauxcab());
			} else { 
				sqlquery.setParameter("cdgoAlcanauxcab", null);
			}  	
		
			try {				
				if (sqlquery.executeUpdate() > 0) {
					logger.debug("--> Success insertExpediente");

					sqlString = " SELECT IDENTITY_VAL_LOCAL() AS identity_val FROM SYSIBM.SYSDUMMY1 ";
					sqlquery = em.createNativeQuery(sqlString);	
					
					List<BigDecimal> results = sqlquery.getResultList();
			  
					BigDecimal res = null;
					for (BigDecimal item : results) {
					  res = item;
					}
			  
					result = res.intValue();

					logger.debug("--> insertExpediente ID: {}", result);
				}

			} catch (Exception e) {
				logger.error("--> Error insertExpediente:", e);
			}	
		} 

		return result;
	}
	
	public int updateExpedientExt(String descObservaExt, String descObserva, Character marcaActivo, String descUsuact, Integer cdgoPersona, Integer cdgoExpediente) {
		
		String sqlString = 
		"UPDATE PASG.TBASG104_EXPEDIENT " + 
			"SET " +
			"DESG_OBSERVA_EXT = ?, " +
			"DESG_OBSERVA = ?, " +
			"MRCA_ACTIVO = ?, " +
			"FCHA_ACT = CURRENT_DATE, " +
			"DESG_USUACT = ? " +
		"WHERE CDGO_PERSONA = ? " +
		"AND CDGO_EXPEDIENT = ? ";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg104Expedient.class);
		sqlquery.setParameter(1, descObservaExt);
		sqlquery.setParameter(2, descObserva);
		sqlquery.setParameter(3, marcaActivo);
		sqlquery.setParameter(4, descUsuact);
		sqlquery.setParameter(5, cdgoPersona);
		sqlquery.setParameter(6, cdgoExpediente);
		
		return sqlquery.executeUpdate();
	}

	@Transactional
	public int updateExpedient(Tbasg104ExpedientDto bean) {
		int result = 0;
		if (Objects.nonNull(bean.getCdgoExpedient())) {
			String sqlString = " UPDATE PASG.TBASG104_EXPEDIENT "
				+ " SET CDGO_ALCANCEOT=:cdgoAlcanceot, CDGO_ESPEC=:cdgoEspec, CDGO_ALCANCEAMBITO=:cdgoAlcanceambito, DESG_TIPOINFRAESTRUC=:desgTipoinfraestruc, CDGO_ENTORNO=:cdgoEntorno, CDGO_LINEA=:cdgoLinea, CDGO_SERIE=:cdgoSerie, "
				+ " CDGO_SUBSERIE=:cdgoSubserie, DESG_OBSERVA=:desgObserva, DESG_USUACT=:desgUsuact, FCHA_ACT=CURRENT_DATE, MRCA_ACTIVO=:mrcaActivo, CDGO_ALCANAUXCAB=:cdgoAlcanauxcab "
				+ " WHERE CDGO_EXPEDIENT=:cdgoExpedient ";

			Query sqlquery = em.createNativeQuery(sqlString);

			if (Objects.nonNull(bean.getCdgoAlcanceot())) {
				sqlquery.setParameter("cdgoAlcanceot", bean.getCdgoAlcanceot());
			} else { 
				sqlquery.setParameter("cdgoAlcanceot", null);
			}  

			if (Objects.nonNull(bean.getCdgoEspec())) {
				sqlquery.setParameter("cdgoEspec", bean.getCdgoEspec());
			} else { 
				sqlquery.setParameter("cdgoEspec", null);
			}  

			if (Objects.nonNull(bean.getCdgoAlcanceambito())) {
				sqlquery.setParameter("cdgoAlcanceambito", bean.getCdgoAlcanceambito());
			} else { 
				sqlquery.setParameter("cdgoAlcanceambito", null);
			}  	
			
			if (Objects.nonNull(bean.getDesgTipoinfraestruc())) {
				sqlquery.setParameter("desgTipoinfraestruc", bean.getDesgTipoinfraestruc());
			} else { 
				sqlquery.setParameter("desgTipoinfraestruc", null);
			}  					

			if (Objects.nonNull(bean.getCdgoEntorno())) {
				sqlquery.setParameter("cdgoEntorno", bean.getCdgoEntorno());
			} else { 
				sqlquery.setParameter("cdgoEntorno", null);
			}  	
			
			if (Objects.nonNull(bean.getCdgoLinea())) {
				sqlquery.setParameter("cdgoLinea", bean.getCdgoLinea());
			} else { 
				sqlquery.setParameter("cdgoLinea", null);
			}  										

			if (Objects.nonNull(bean.getCdgoSerie())) {
				sqlquery.setParameter("cdgoSerie", bean.getCdgoSerie());	
			} else { 
				sqlquery.setParameter("cdgoSerie", null);
			}  				

			if (Objects.nonNull(bean.getCdgoSubserie())) {
				sqlquery.setParameter("cdgoSubserie", bean.getCdgoSubserie());
			} else { 
				sqlquery.setParameter("cdgoSubserie", null);
			}  	

			if (Objects.nonNull(bean.getDesgObserva())) {
				sqlquery.setParameter("desgObserva", bean.getDesgObserva());
			} else { 
				sqlquery.setParameter("desgObserva", null);
			}	

			if (Objects.nonNull(bean.getDesgUsuact())) {
				sqlquery.setParameter("desgUsuact", bean.getDesgUsuact());
			} else { 
				sqlquery.setParameter("desgUsuact", null);
			}			

			if (Objects.nonNull(bean.getMrcaActivo())) {
				sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
			} else { 
				sqlquery.setParameter("mrcaActivo", null);
			}	
			
			if (Objects.nonNull(bean.getCdgoAlcanauxcab())) {
				sqlquery.setParameter("cdgoAlcanauxcab", bean.getCdgoAlcanauxcab());
			} else { 
				sqlquery.setParameter("cdgoAlcanauxcab", null);
			}	
			
			sqlquery.setParameter("cdgoExpedient", bean.getCdgoExpedient());							

			try {
				result = sqlquery.executeUpdate();
			} catch (Exception e) {
				logger.error("--> Error updateExpedient:", e);
			}	

		} else {
			logger.error("--> Error updateExpedient: 'cdgoExpedient' es requerido");
		}

		return result;
	}

	public int updateExpedientMantenimiento(Tbasg104Expedient bean) {

		String sqlString = "UPDATE PASG.TBASG104_EXPEDIENT SET CDGO_ALCANCEOT=?, CDGO_ESPEC=?,"
				+ "			CDGO_ALCANCEAMBITO=?, DESG_TIPOINFRAESTRUC =?, CDGO_ENTORNO=?, CDGO_LINEA=?, CDGO_SERIE=?, "
				+ "			CDGO_SUBSERIE=?, DESG_OBSERVA=?, CDGO_EMPRESA=?, DESG_USUACT=?, FCHA_ACT=CURRENT_DATE, MRCA_ACTIVO=?,CDGO_ALCANAUXCAB=?"
				+ "		 WHERE CDGO_EXPEDIENT = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg104Expedient.class);
		sqlquery.setParameter(1, bean.getCdgoAlcanceot());
		sqlquery.setParameter(2, bean.getCdgoEspec());
		sqlquery.setParameter(3, bean.getCdgoAlcanceambito());
		sqlquery.setParameter(4, bean.getDesgTipoinfraestruc());
		sqlquery.setParameter(5, bean.getCdgoEntorno());
		sqlquery.setParameter(6, bean.getCdgoLinea());
		sqlquery.setParameter(7, bean.getCdgoSerie());
		//sqlquery.setParameter(8, bean.getCdgoSubserie());
		sqlquery.setParameter(9, bean.getDesgObserva());
		sqlquery.setParameter(10, bean.getCdgoEmpresa());
		sqlquery.setParameter(11, bean.getDesgUsuact());
		sqlquery.setParameter(12, bean.getMrcaActivo());
		sqlquery.setParameter(13, bean.getCdgoAlcanauxcab());
		sqlquery.setParameter(14, bean.getCdgoExpedient());
		return sqlquery.executeUpdate();
	}

	public int updateExpedientB(Tbasg104Expedient bean) {

		String sqlString = "UPDATE PASG.TBASG104_EXPEDIENT SET CDGO_AMBITOS=?, CDGO_ALCANCEOT=?, CDGO_ESPEC=?,"
				+ "			CDGO_ALCANCEAMBITO=?, DESG_TIPOINFRAESTRUC =?, CDGO_ENTORNO=?, CDGO_LINEA=?, CDGO_SERIE=?, "
				+ "			CDGO_SUBSERIE=?, DESG_OBSERVA=?, DESG_USUACT=?, FCHA_ACT=CURRENT_DATE, MRCA_ACTIVO=?,CDGO_ALCANAUXCAB=?"
				+ "		 WHERE CDGO_EXPEDIENT = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg104Expedient.class);
		sqlquery.setParameter(1, bean.getCdgoAmbitos());
		sqlquery.setParameter(2, bean.getCdgoAlcanceot());
		sqlquery.setParameter(3, bean.getCdgoEspec());
		sqlquery.setParameter(4, bean.getCdgoAlcanceambito());
		sqlquery.setParameter(5, bean.getDesgTipoinfraestruc());
		sqlquery.setParameter(6, bean.getCdgoEntorno());
		sqlquery.setParameter(7, bean.getCdgoLinea());
		sqlquery.setParameter(8, bean.getCdgoSerie());
		//sqlquery.setParameter(9, bean.getCdgoSubserie());
		sqlquery.setParameter(10, bean.getDesgObserva());
		sqlquery.setParameter(11, bean.getDesgUsuact());
		sqlquery.setParameter(12, bean.getMrcaActivo());
		sqlquery.setParameter(13, bean.getCdgoAlcanauxcab());
		sqlquery.setParameter(14, bean.getCdgoExpedient());
		return sqlquery.executeUpdate();
	}

	public int deleteExpedient(Tbasg104Expedient bean) {

		String sqlString = "UPDATE PASG.TBASG104_EXPEDIENT SET MRCA_ACTIVO='N', DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE  WHERE CDGO_EXPEDIENT=:cdgoExpediente";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg104Expedient.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoExpediente", bean.getCdgoExpedient());
		return sqlquery.executeUpdate();
	}
	
	public int updateEmpresaExpedient(Tbasg104Expedient bean) {

		String sqlString = "UPDATE PASG.TBASG104_EXPEDIENT SET CDGO_EMPRESA=:cdgoEmpresa, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE  WHERE CDGO_EXPEDIENT=:cdgoExpediente";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg104Expedient.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoEmpresa", bean.getCdgoEmpresa());
		sqlquery.setParameter("cdgoExpediente", bean.getCdgoExpedient());
		return sqlquery.executeUpdate();
	}

	public List<Tbasg104Expedient> getMaxEstadoExpCount() {

		String sqlString = "SELECT COUNT(*) as value"
				+ "		FROM PASG.TBASG104_EXPEDIENT A, PASG.TBASG118_ESTADOEXP B, PASG.TBASG100_PERSONA C						 "
				+ "		WHERE A.CDGO_EXPEDIENT = B.CDGO_EXPEDIENT" + "		AND B.FCHA_ESTADO IN ("
				+ "					SELECT MAX(FCHA_ESTADO)" + "					FROM PASG.TBASG118_ESTADOEXP"
				+ "					WHERE CDGO_EXPEDIENT = B.CDGO_EXPEDIENT"
				+ "					AND MRCA_ACTIVO = 'S'" + "		)" + "		AND A.CDGO_PERSONA = C.CDGO_PERSONA";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg104Expedient.class);

		return sqlquery.getResultList();
	}

	public List<GetEstadoListDTO> getEstadoList(SetMaxEstadoHabilitaList mapPending) {
		
		StringBuilder strSetEstadoList = new StringBuilder();
		// FIXME adaptar las definiciones
		String sqlString = "SELECT E.CDGO_EXPEDIENT, S.CDGO_ESTADO, S.DESG_NOMBRE"
				+ " FROM  PASG.TBASG104_EXPEDIENT E, PASG.TBASG118_ESTADOEXP T, PASG.TBASG116_ESTADOS S WHERE T.FCHA_ESTADO IN (SELECT MAX(FCHA_ESTADO) "
				
				+ " FROM PASG.TBASG118_ESTADOEXP "
				+ " WHERE MRCA_ACTIVO = 'S' AND CDGO_EXPEDIENT = T.CDGO_EXPEDIENT) AND E.CDGO_EXPEDIENT = T.CDGO_EXPEDIENT AND T.CDGO_ESTADO = S.CDGO_ESTADO "
				+ " AND E.MRCA_ACTIVO = 'S' AND T.MRCA_ACTIVO = 'S' AND S.MRCA_ACTIVO = 'S' ";
		
		strSetEstadoList.append(sqlString);
		System.out.println("----------------------");
		System.out.println(strSetEstadoList.toString());
		System.out.println("----------------------");
			
		if(mapPending.getCdgoExpedient() != null) {
			strSetEstadoList.append(" AND E.CDGO_EXPEDIENT IN (0," + mapPending.getCdgoExpedient().get(0));
			
			for(int i = 1; i < mapPending.getCdgoExpedient().size(); i++) {
				strSetEstadoList.append(", " + mapPending.getCdgoExpedient().get(i));
			}
			
			strSetEstadoList.append(")");
		}
		
		if(mapPending.getCdgoTipohab() != null) {
			strSetEstadoList.append(" AND T.CDGO_ESTADO IN (" + mapPending.getCdgoTipohab().get(0));
			
			for(int i = 1; i < mapPending.getCdgoTipohab().size(); i++) {
				strSetEstadoList.append(", " + mapPending.getCdgoTipohab().get(i));
			}
			
			strSetEstadoList.append(")");
		}

		strSetEstadoList.append(" AND T.CDGO_ESTADO NOT IN (" + MultivalueCts.T116_ESTADOS_ABIERTO + ", " + MultivalueCts.T116_ESTADOS_CERRADO + ", " 
				+ MultivalueCts.T116_ESTADOS_VIGENTE + ", " + MultivalueCts.T116_ESTADOS_CONFIRMADO + ", " 
				+ MultivalueCts.T116_ESTADOS_PENDIENTE_CONFIRMAR + ", " + MultivalueCts.T116_ESTADOS_PROPUESTA_OTORGAMIENTO + ", " 
				+ MultivalueCts.T116_ESTADOS_PROPUESTA_RESOLUCION + ", " + MultivalueCts.T116_ESTADOS_PENDIENTE_REVOCAR + ", " 
				+ MultivalueCts.T116_ESTADOS_REVOCADO + ", " + MultivalueCts.T116_ESTADOS_TRAMITACION + ")");
		
		System.out.println("----------------------");
		System.out.println(strSetEstadoList.toString());
		System.out.println("----------------------");
		
		strSetEstadoList.append(" GROUP BY E.CDGO_EXPEDIENT, S.CDGO_ESTADO, S.DESG_NOMBRE");
		
		System.out.println("----------------------");
		System.out.println(strSetEstadoList.toString());
		System.out.println("----------------------");
		
		Query sqlquery = em.createNativeQuery(strSetEstadoList.toString()); 
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetEstadoListDTO> resultadosDevueltos = new ArrayList<>();
		
		for(Object[] object : resultados) {
			GetEstadoListDTO data = new GetEstadoListDTO();
			if(object[0]!=null) {
				data.setCdgoExpedient((Integer)object[0]);
			}
			if(object[1]!=null) {
				data.setCdgoEstado((Integer)object[1]);
			}
			if(object[2]!=null) {
				data.setDesgNombre((String)object[2]);
			}
			resultadosDevueltos.add(data);
			
		}
		return resultadosDevueltos;
	}
	
	public <T> String getDescripAlcanseExpediente(T cdgoAlcanceOt, T cdgoAuxCab, T cdgoEspec, T cdgoEntorno,
			T cdgoLinea, T cdgoSerie) {
		
		List<Tbasg131Alcanceot> cdgoAlcanceOtLista = this.tbasg131AlcanceotRepositoryImpl.getAlcanceOtNombre(this.convertirToString(cdgoAlcanceOt));
		List<Tbasg257Alcanauxcab> cdgoAuxCabLista = this.tbasg257AlcanauxcabRepositoryImpl.getAuxCabNombre(this.convertirToString(cdgoAuxCab));
		List<Tbasg137Especiali> cdgoEspecLista = this.tbasg137EspecialiRepositoryImpl.getEspecialiNombre(this.convertirToString(cdgoEspec));
		List<Tbasg129Entornos> cdgoEntornoLista = this.tbasg129EntornosRepositoryImpl.getEntornosNombre(this.convertirToString(cdgoEntorno));
		List<Tbasg128Estacline> cdgoLineaLista = this.tbasg128EstaclineRepositoryImpl.getEstacLineNombre(this.convertirToString(cdgoLinea));
		List<Tbasg133Serie> cdgoSerieLista = this.tbasg133SerieRepositoryImpl.getSerieNombre(this.convertirToString(cdgoSerie));
		
		if( CollectionUtils.isNotEmpty(cdgoAlcanceOtLista) && cdgoAlcanceOtLista.get(0) != null ){
			return cdgoAlcanceOtLista.get(0).getDesgNombre();
		}
		if(CollectionUtils.isNotEmpty(cdgoAuxCabLista) && cdgoAuxCabLista.get(0) != null ){
			return cdgoAuxCabLista.get(0).getDesgNombre();
		}
		if(CollectionUtils.isNotEmpty(cdgoEspecLista) && cdgoEspecLista.get(0) != null ){
			return cdgoEspecLista.get(0).getDesgNombre();
		}
		if(CollectionUtils.isNotEmpty(cdgoEntornoLista) && cdgoEntornoLista.get(0) != null ) {
			return "Entorno: " + cdgoEntornoLista.get(0).getDesgNomcorto();
		}
		if(CollectionUtils.isNotEmpty(cdgoLineaLista) && cdgoLineaLista.get(0) != null ) {
			return cdgoLineaLista.get(0).getDesgNomcorto();
		}
		if(CollectionUtils.isNotEmpty(cdgoSerieLista) && cdgoSerieLista.get(0) != null ) {
			return cdgoSerieLista.get(0).getDesgNombre();
		}

		return null;
		
	}
	
	
	public <T> String convertirToString(T value) {
		
		return value != null ? value.toString():null;
		
	}

}