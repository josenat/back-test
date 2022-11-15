package renfe.com.repository.impl;


import java.util.ArrayList;
import java.sql.Date;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Objects;


import org.springframework.data.repository.query.Param;

import renfe.com.dto.CountGetTramosDTO;
import renfe.com.dto.GetActasActivasPersonaDTO;
import renfe.com.dto.GetActasNoActivasPersonaDTO;
import renfe.com.dto.GetEstadosMasExpDTO;
import renfe.com.dto.GetFechaExpFiltradaDTO;
import renfe.com.dto.GetFechaOtorgamientoDTO;
import renfe.com.dto.GetMaxEntornosExpCodListDTO;
import renfe.com.dto.GetMaxEntornosExpListCodigosDTO;
import renfe.com.dto.GetMaxEstaHabInListDTO;
import renfe.com.dto.GetTramoListByCdgoExpDTO;
import renfe.com.dto.GetTramosOrderByCodLineaDTO;
import renfe.com.dto.ParamCountGetTramos;
import renfe.com.model.dto.GetExpedientesPersonaCursoListDTO;

import renfe.com.model.entity.Tbasg118Estadoexp;
import renfe.com.model.entity.Tbasg118EstadoexpPK;
import renfe.com.repository.Tbasg118EstadoexpRepositoryCustom;

public class Tbasg118EstadoexpRepositoryImpl implements Tbasg118EstadoexpRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(Tbasg118EstadoexpRepositoryImpl.class);

	public List<Tbasg118Estadoexp> getTramosExpInfr(String cdgoExpedient) {

		String sqlString = "SELECT DISTINCT " + "		    A.CDGO_ALCHABINF, "
				+ "		    LINEAS.DESG_NOMBRE AS LINEA, " + "		    ORIGEN.DESG_NOMCORTO AS ORIGEN,"
				+ "		    DESTINO.DESG_NOMCORTO AS DESTINO, " + "		    EX.CDGO_ESTADO, "
				+ "		    EX.FCHA_ESTADO" + "		FROM " + "		    PASG.TBASG118_ESTADOEXP EX"
				+ "		    INNER JOIN PASG.TBASG126_ALCHABINF A ON A.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT"
				+ "		    INNER JOIN PASG.TBASG145_ALCHAESTA B ON A.CDGO_ALCHABINF = B.CDGO_ALCHABINF "
				+ "		    INNER JOIN PASG.TBASG127_LINEAS LINEAS ON B.CDGO_LINEA = LINEAS.CDGO_LINEA "
				+ "		    INNER JOIN PASG.TBASG128_ESTACLINE ORIGEN ON (B.CDGO_LINEA = ORIGEN.CDGO_LINEA AND B.CDGO_ORIGEN = ORIGEN.CDGO_ESTACION) "
				+ "		    INNER JOIN PASG.TBASG128_ESTACLINE DESTINO ON (B.CDGO_LINEA = DESTINO.CDGO_LINEA AND B.CDGO_DESTINO = DESTINO.CDGO_ESTACION)"
				+ "		WHERE " + "		    EX.CDGO_EXPEDIENT = :value"
				+ "		    AND EX.CDGO_ESTADO NOT IN (1, 2, 4) "
				+ "		    AND EX.FCHA_ESTADO = (   SELECT MAX(FCHA_ESTADO) "
				+ "		                            FROM PASG.TBASG118_ESTADOEXP"
				+ "		                            WHERE CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT AND MRCA_ACTIVO = 'S'"
				+ "		                        )" + "		    AND EX.MRCA_ACTIVO = 'S'"
				+ "		    AND A.MRCA_ACTIVO = 'S'" + "		    AND B.MRCA_ACTIVO = 'S'"
				+ "		    AND LINEAS.MRCA_ACTIVO = 'S'" + "		    AND ORIGEN.MRCA_ACTIVO = 'S'"
				+ "		    AND DESTINO.MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg118Estadoexp.class);
		sqlquery.setParameter("value", cdgoExpedient);
		return sqlquery.getResultList();
	}

	public List<Tbasg118Estadoexp> getTramosExpInfrWithOutState(String cdgoExpedient) {

		String sqlString = "SELECT DISTINCT " + "		    A.CDGO_ALCHABINF,"
				+ "		    LINEAS.DESG_NOMBRE AS LINEA," + "		    ORIGEN.DESG_NOMCORTO AS ORIGEN,"
				+ "		    DESTINO.DESG_NOMCORTO AS DESTINO," + "		    EX.CDGO_ESTADO,"
				+ "		    EX.FCHA_ESTADO   " + "		FROM " + "		    PASG.TBASG118_ESTADOEXP EX "
				+ "		    INNER JOIN PASG.TBASG126_ALCHABINF A ON A.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT"
				+ "		    INNER JOIN PASG.TBASG145_ALCHAESTA B ON A.CDGO_ALCHABINF = B.CDGO_ALCHABINF"
				+ "		    INNER JOIN PASG.TBASG127_LINEAS LINEAS ON B.CDGO_LINEA = LINEAS.CDGO_LINEA"
				+ "		    INNER JOIN PASG.TBASG128_ESTACLINE ORIGEN ON (B.CDGO_LINEA = ORIGEN.CDGO_LINEA AND B.CDGO_ORIGEN = ORIGEN.CDGO_ESTACION)"
				+ "		    INNER JOIN PASG.TBASG128_ESTACLINE DESTINO ON (B.CDGO_LINEA = DESTINO.CDGO_LINEA AND B.CDGO_DESTINO = DESTINO.CDGO_ESTACION)"
				+ "		WHERE " + "		    EX.CDGO_EXPEDIENT = :value " + "		    AND EX.FCHA_ESTADO = ("
				+ "		                            SELECT MAX(FCHA_ESTADO) "
				+ "		                            FROM PASG.TBASG118_ESTADOEXP"
				+ "		                            WHERE CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT"
				+ "		                            AND MRCA_ACTIVO = 'S'" + "		                        )	"
				+ "		    AND EX.MRCA_ACTIVO = 'S'" + "		    AND A.MRCA_ACTIVO = 'S'"
				+ "		    AND B.MRCA_ACTIVO = 'S'" + "		    AND LINEAS.MRCA_ACTIVO = 'S'"
				+ "		    AND ORIGEN.MRCA_ACTIVO = 'S'" + "		    AND DESTINO.MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg118Estadoexp.class);
		sqlquery.setParameter("value", cdgoExpedient);
		return sqlquery.getResultList();
	}

	public List<GetMaxEstaHabInListDTO> getMaxEstaHabInList(String cdgoExpedient) {
		
		String sqlString = "SELECT " +
				"A.CDGO_EXPEDIENT AS EXPEDIENTE, " +
			    "P.DESG_APELL1, " +
			    "P.DESG_APELL2, " +
			    "P.DESG_NOMBRE, " +
			    "P.DESG_NIFPAS, " +
			    "P.DESG_MATRICULA, " +
			    "B.CDGO_LINEA AS LINEA, " +
			    "EL.DESG_NOMCORTO AS ORIGEN, " +
			    "ELL.DESG_NOMCORTO AS DESTINO, " +
			    "ES.DESG_NOMBRE AS ESTADO " +
			   
			"FROM " +
			    "PASG.TBASG118_ESTADOEXP EX " + 
			"INNER JOIN " +
			    "PASG.TBASG126_ALCHABINF A ON A.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT " +
			"INNER JOIN " +
			    "PASG.TBASG145_ALCHAESTA B ON B.CDGO_ALCHABINF = A.CDGO_ALCHABINF " +
			"INNER JOIN " +
			    "PASG.TBASG104_expedient E ON EX.CDGO_EXPEDIENT = E.CDGO_EXPEDIENT " +
			"INNER JOIN " +
			    "PASG.TBASG100_PERSONA P ON E.CDGO_PERSONA = P.CDGO_PERSONA " +
			"INNER JOIN " +
			    "PASG.TBASG128_ESTACLINE EL ON EL.CDGO_ESTACION = B.CDGO_ORIGEN AND EL.CDGO_LINEA = B.CDGO_LINEA " +
			"INNER JOIN " +
			    "PASG.TBASG128_ESTACLINE ELl ON ELL.CDGO_ESTACION = B.CDGO_DESTINO AND ELL.CDGO_LINEA = B.CDGO_LINEA " +
			"INNER JOIN " +
			   " PASG.TBASG116_ESTADOS ES ON ES.CDGO_ESTADO = EX.CDGO_ESTADO " +
			"WHERE " +
			    "A.MRCA_ACTIVO = 'S' " +
			    "AND B.MRCA_ACTIVO = 'S' " +
			    "AND EX.MRCA_ACTIVO = 'S' " +
			    "AND EX.FCHA_ESTADO = " +
			    "( " +
			        "SELECT " +
			            "MAX(FCHA_ESTADO) " +
			        "FROM " +
			            "PASG.TBASG118_ESTADOEXP " +
			        "WHERE " +
			            "CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT " +
			        "AND MRCA_ACTIVO = 'S' ) " +
			"AND EX.CDGO_EXPEDIENT = :cdgoExpediente " +
			"AND EX.CDGO_ESTADO <> 4";

		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("cdgoExpediente", cdgoExpedient);
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetMaxEstaHabInListDTO> resultadosDevueltos = new ArrayList<>();

		for (Object[] object : resultados) {
			GetMaxEstaHabInListDTO expediente = new GetMaxEstaHabInListDTO();
				
			expediente.setExpediente((Integer)object[0]);
			expediente.setApellido1((String)object[1]);
			expediente.setApellido2((String)object[2]);
			expediente.setNombre((String)object[3]);
			expediente.setNif((String)object[4]);
			expediente.setMatricula((String)object[5]);
			expediente.setLinea((String)object[6]);
			expediente.setOrigen((String)object[7]);
			expediente.setDestino((String)object[8]);
			expediente.setEstado((String)object[9]);
			
			resultadosDevueltos.add(expediente);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg118Estadoexp> findEstadoExpByCdgoExp(String cdgoExpedient) {

		String sqlString = "SELECT * FROM PASG.TBASG118_ESTADOEXP WHERE CDGO_EXPEDIENT = :value AND MRCA_ACTIVO = 'S'"
				+ "		ORDER BY FCHA_ESTADO DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg118Estadoexp.class);
		sqlquery.setParameter("value", cdgoExpedient);
		return sqlquery.getResultList();
	}

	public List<Tbasg118Estadoexp> findFechaSuspensionReactivacionExpByCdgoExp(String cdgoExpedient) {

		String sqlString = "SELECT CDGO_EXPEDIENT,CDGO_ESTADO,FCHA_ESTADO,DESG_USUACT,FCHA_ACT,MRCA_ACTIVO"
				+ " 			FROM PASG.TBASG118_ESTADOEXP WHERE CDGO_EXPEDIENT = :cdgoExpedient"
				+ "				AND CDGO_ESTADO IN('3','7','20')" + "			ORDER BY FCHA_ESTADO DESC;";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg118Estadoexp.class);
		sqlquery.setParameter("cdgoExpedient", cdgoExpedient);
		return sqlquery.getResultList();
	}

	public List<Tbasg118Estadoexp> findTodosEstadosExpsSuspSancionByCdgoExp(Integer cdgoExpediente) {

		String sqlString = "SELECT EX.* " + "		FROM" + "		    PASG.TBASG118_ESTADOEXP EX"
				+ "		    INNER JOIN PASG.TBASG104_EXPEDIENT X ON X.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT"
				+ "		WHERE " + "		    X.CDGO_PERSONA IN (" + "		        SELECT X2.CDGO_PERSONA"
				+ "		        FROM PASG.TBASG104_EXPEDIENT X2" + "		        WHERE X2.CDGO_EXPEDIENT = :cdgoExpediente"
				+ "		    )" + "		    AND X.MRCA_ACTIVO = 'S'" + "		    AND EX.MRCA_ACTIVO = 'S'"
				+ "		    AND EX.FCHA_ESTADO = (" + "		        SELECT MAX( EX2.FCHA_ESTADO )"
				+ "		        FROM PASG.TBASG118_ESTADOEXP EX2" + "		        WHERE"
				+ "		            EX2.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT"
				+ "		            AND EX2.MRCA_ACTIVO = 'S'" + "		    )" + "		    AND EX.CDGO_ESTADO = 20"
				+ "		ORDER BY EX.FCHA_ESTADO DESC;";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg118Estadoexp.class);
		sqlquery.setParameter("cdgoExpediente", cdgoExpediente);
		return sqlquery.getResultList();
	}
	
	public List<Tbasg118Estadoexp> getEstadosExp(String cdgoExpedient) {

		String sqlString = "SELECT *" + "		FROM PASG.TBASG118_ESTADOEXP" + "		WHERE CDGO_EXPEDIENT = :value"
				+ "		AND MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg118Estadoexp.class);
		sqlquery.setParameter("value", cdgoExpedient);
		return sqlquery.getResultList();
	}

	public List<GetEstadosMasExpDTO> getEstadosMasExp(String cdgoExpedient) {

		String sqlString = "SELECT X.CDGO_EXPEDIENT, X.CDGO_ESTADO, E.DESG_NOMBRE, X.FCHA_ESTADO, X.MRCA_ACTIVO" + 
		" FROM ("
			+ " SELECT CDGO_EXPEDIENT, CDGO_ESTADO, FCHA_ESTADO, MRCA_ACTIVO,"
			+ " row_number() over(partition by CDGO_ESTADO ORDER BY FCHA_ESTADO desc) rn"
			+ " FROM PASG.TBASG118_ESTADOEXP"
		+ " WHERE CDGO_EXPEDIENT= :cdgoExpedient AND MRCA_ACTIVO = 'S'"
			+ " ) X"
			+ " INNER JOIN PASG.TBASG116_ESTADOS E on E.CDGO_ESTADO=X.CDGO_ESTADO"
			+ " WHERE rn = 1 order by FCHA_ESTADO desc";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("cdgoExpedient", cdgoExpedient);
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetEstadosMasExpDTO> resultadosDevueltos = new ArrayList<>();

		for (Object[] object : resultados) {
			GetEstadosMasExpDTO estado = new GetEstadosMasExpDTO();
				
			estado.setCdgoExpedient((Integer) object[0]);
			estado.setCdgoEstado((Integer)object[1]);
			estado.setDesgNombre((String)object[2]);
			estado.setFchaEstado((java.sql.Timestamp)object[3]);
			estado.setMrcaActivo((Character)object[4]);

			resultadosDevueltos.add(estado);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg118Estadoexp> getEstadosExpMaxFecha(String cdgoExpedient) {

		String sqlString = "SELECT *" + "		FROM PASG.TBASG118_ESTADOEXP" + "		WHERE CDGO_EXPEDIENT = :value"
				+ "		  AND MRCA_ACTIVO = 'S'" + "		  AND FCHA_ESTADO = ("
				+ "		                     SELECT MAX(FCHA_ESTADO)"
				+ "		                     FROM PASG.TBASG118_ESTADOEXP"
				+ "		                     WHERE CDGO_EXPEDIENT = :value"
				+ "		                       AND MRCA_ACTIVO = 'S'" + "		                     )";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg118Estadoexp.class);
		sqlquery.setParameter("value", cdgoExpedient);
		return sqlquery.getResultList();
	}

	public List<Tbasg118Estadoexp> getEstadosExpsMaxFecha(List expedientes) {
		String sqlString = "SELECT EX.* FROM PASG.TBASG118_ESTADOEXP EX WHERE "
				+"  EX.MRCA_ACTIVO = 'S' "
				+" AND EX.FCHA_ESTADO = ( "
				+"         SELECT MAX(EX2.FCHA_ESTADO)  "
				+"         FROM PASG.TBASG118_ESTADOEXP EX2  "
				+"         WHERE EX2.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT  "
				+"         AND EX2.MRCA_ACTIVO = 'S'  "
				+" ) "
				+" AND EX.CDGO_EXPEDIENT IN :values";


		Query sqlquery = em.createNativeQuery(sqlString, Tbasg118Estadoexp.class);
		sqlquery.setParameter("values", expedientes);
		return sqlquery.getResultList();
	}

	public List<Tbasg118Estadoexp> getEstadosExpMaxFechaTodo(String cdgoExpedient) {

		String sqlString = "SELECT *" + "		FROM PASG.TBASG118_ESTADOEXP" + "		WHERE CDGO_EXPEDIENT = :value"
				+ "		  " + "		  " + "   		  " + "		  AND FCHA_ESTADO = ("
				+ "		                     SELECT MAX(FCHA_ESTADO)"
				+ "		                     FROM PASG.TBASG118_ESTADOEXP"
				+ "		                     WHERE CDGO_EXPEDIENT = :value" + "		                     )";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg118Estadoexp.class);
		sqlquery.setParameter("value", cdgoExpedient);
		return sqlquery.getResultList();
	}

	public List<Tbasg118Estadoexp> getEstadosExpsTodosMaxFecha() {

		String sqlString = "SELECT EX.*" + "		FROM PASG.TBASG118_ESTADOEXP EX";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg118Estadoexp.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg118Estadoexp> getEstadoExpList() {

		String sqlString = "SELECT * FROM PASG.TBASG118_ESTADOEXP ORDER BY CDGO_EXPEDIENT,CDGO_ESTADO";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg118Estadoexp.class);

		return sqlquery.getResultList();
	}

	public int insertEstadoExp(Integer cdgoExpediente, Integer cdgoEstado, String desgUsuact, String mrcaActivo) {

		String sqlString = "INSERT INTO PASG.TBASG118_ESTADOEXP (CDGO_EXPEDIENT, CDGO_ESTADO, FCHA_ESTADO, DESG_USUACT,FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, CURRENT_TIMESTAMP, ?,CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg118Estadoexp.class);
		sqlquery.setParameter(1, cdgoExpediente);
		sqlquery.setParameter(2, cdgoEstado);
		sqlquery.setParameter(3, desgUsuact);
		sqlquery.setParameter(4, mrcaActivo);
		return sqlquery.executeUpdate();
	}


	public int updateEstadoExpediente(Tbasg118Estadoexp bean) {

		String sqlString = "UPDATE PASG.TBASG118_ESTADOEXP" + "			SET CDGO_ESTADO    = ?,"
				+ "				FCHA_ESTADO    = CURRENT_TIMESTAMP," + "				DESG_USUACT    = ?,"
				+ "				FCHA_ACT       = CURRENT_DATE," + "				MRCA_ACTIVO    = ?"
				+ "			WHERE CDGO_EXPEDIENT = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg118Estadoexp.class);
		sqlquery.setParameter(1, bean.getTbasg118estadoexppk().getCdgoEstado());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getMrcaActivo());
		sqlquery.setParameter(4, bean.getTbasg118estadoexppk().getCdgoExpedient());
		return sqlquery.executeUpdate();
	}

	public List<GetExpedientesPersonaCursoListDTO> getExpedientesPersonaCursoList() {

		String sqlString = "SELECT B.CDGO_EXPEDIENT, B.CDGO_ESTADO, UPPER(RTRIM(E.DESG_NOMBRE)) AS ESTADO, B.FCHA_ESTADO, "
				+ "			UPPER(RTRIM(D.DESG_NOMBRE)) AS TIPO_HABILITA, A.CDGO_ALCANCEOT, A.CDGO_ESPEC, A.CDGO_ALCANCEAMBITO, "
				+ "			A.DESG_TIPOINFRAESTRUC, A.CDGO_ENTORNO, A.CDGO_LINEA, UPPER(RTRIM(A.CDGO_SERIE)) AS CDGO_SERIE, "
				+ "			UPPER(RTRIM(A.CDGO_SUBSERIE)) AS CDGO_SUBSERIE, UPPER(RTRIM(C.DESG_NOMBRE)) AS AMBITO, "
				+ "			UPPER(RTRIM(F.DESG_NOMBRE)) AS EMPRESA, G.CDGO_ESTADO AS CDGO_ESTADO_CURSO"
				+ "		 FROM PASG.TBASG118_ESTADOEXP B, PASG.TBASG124_AMBITOS C,"
				+ "		      PASG.TBASG123_TIPOHABIL D, PASG.TBASG116_ESTADOS E, PASG.TBASG125_EMPRESA F,"
				+ "			PASG.TBASG104_EXPEDIENT A LEFT OUTER JOIN PASG.TBASG197_FORMACION G ON A.CDGO_EXPEDIENT = G.CDGO_EXPEDIENT";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetExpedientesPersonaCursoListDTO> resultadosDevueltos = new ArrayList<>();
		
		for (Object[] object : resultados) {
			GetExpedientesPersonaCursoListDTO expediente = new GetExpedientesPersonaCursoListDTO();

			expediente.setCdgoExpediente((Integer)object[0]);
			expediente.setCdgoEstado((Integer)object[1]);
			expediente.setDesgNombreEstado((String)object[2]);
			expediente.setFchaEstado((Date)object[3]);

			resultadosDevueltos.add(expediente);
		}
		return resultadosDevueltos;
	}

	public List<GetMaxEntornosExpListCodigosDTO> getMaxEntornosExpListCodigos(String cdgoExpedient) {
		
		String sqlString = "SELECT  EX.CDGO_EXPEDIENT,  L.CDGO_LINEA, RTRIM(L.DESG_NOMBRE) AS LINEA, "
				+ "            ES1.CDGO_ESTACION AS CDGO_ORIGEN, RTRIM(ES1.DESG_NOMCORTO) AS ORIGEN, "
				+ "            ES2.CDGO_ESTACION AS CDGO_DESTINO, RTRIM(ES2.DESG_NOMCORTO) AS DESTINO, "
				+ "            E.CDGO_ESTADO, RTRIM(E.DESG_NOMBRE) AS ESTADO FROM PASG.TBASG118_ESTADOEXP EX "
				+ "            INNER JOIN PASG.TBASG116_ESTADOS E ON E.CDGO_ESTADO = EX.CDGO_ESTADO \r\n"
				+ "            INNER JOIN PASG.TBASG126_ALCHABINF AH ON AH.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT "
				+ "            INNER JOIN PASG.TBASG145_ALCHAESTA AL ON AL.CDGO_ALCHABINF = AH.CDGO_ALCHABINF "
				+ "            INNER JOIN PASG.TBASG127_LINEAS L ON L.CDGO_LINEA = AL.CDGO_LINEA "
				+ "            INNER JOIN PASG.TBASG128_ESTACLINE ES1 ON (ES1.CDGO_ESTACION = AL.CDGO_ORIGEN AND ES1.CDGO_LINEA = L.CDGO_LINEA) "
				+ "            INNER JOIN PASG.TBASG128_ESTACLINE ES2 ON (ES2.CDGO_ESTACION = AL.CDGO_DESTINO AND ES2.CDGO_LINEA = L.CDGO_LINEA) "
				+ "            WHERE EX.MRCA_ACTIVO = 'S' AND E.MRCA_ACTIVO = 'S' AND AH.MRCA_ACTIVO = 'S' AND AL.MRCA_ACTIVO = 'S' AND L.MRCA_ACTIVO = 'S' "
				+ "            AND ES1.MRCA_ACTIVO = 'S' AND ES2.MRCA_ACTIVO = 'S' AND EX.FCHA_ESTADO IN (SELECT MAX(FCHA_ESTADO) FROM PASG.TBASG118_ESTADOEXP "
				+ "            WHERE CDGO_EXPEDIENT = :value AND MRCA_ACTIVO = 'S') AND EX.CDGO_EXPEDIENT = :value";
		
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value",cdgoExpedient);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetMaxEntornosExpListCodigosDTO> resultadosDevueltos = new ArrayList<>();		
		
		for (Object[] object : resultados) {
			GetMaxEntornosExpListCodigosDTO data = new GetMaxEntornosExpListCodigosDTO();
			
			data.setCdgoExpedient((Integer) object[0]);
			data.setCdgoLinea((String)object[1]);
			data.setDesgNombreLinea((String)object[2]);
			data.setCdgoEstacionOrigen((String)object[3]);
			data.setDesgNomCortoOrigen((String)object[4]);
			data.setCdgoEstacionDestino((String)object[5]);
			data.setDesgNomCortoDestino((String)object[6]);
			data.setCdgoEstado((Integer) object[7]);
			data.setDesgNombreEstado((String)object[8]);

			resultadosDevueltos.add(data);
		}
		return resultadosDevueltos;
	}

	public List<GetMaxEntornosExpCodListDTO> getMaxEntornosExpCodList(Integer cdgoExpediente, Integer cdgoEstado) {

		String sqlString = "SELECT DISTINCT" + "		    L.CDGO_LINEA, "
				+ "		    ES1.CDGO_ESTACION AS COD_EST_ORIGEN, " + "		    ES1.CDGO_PK AS PK_ORIGEN, "
				+ "		    RTRIM(ES1.DESG_NOMLARGO) AS ORIGEN, " + "		    ES2.CDGO_ESTACION AS COD_EST_DESTINO, "
				+ "		    ES2.CDGO_PK AS PK_DESTINO, " + "		    RTRIM(ES2.DESG_NOMLARGO) AS DESTINO, "
				+ "		    EX.FCHA_ESTADO," + "		    EXP.CDGO_SOCIOTOR," + "		    EXP.CDGO_EXPEDIENT"
				+ "		FROM" + "		    PASG.TBASG118_ESTADOEXP EX "
				+ "		    INNER JOIN PASG.TBASG116_ESTADOS E ON E.CDGO_ESTADO = EX.CDGO_ESTADO "
				+ "		    INNER JOIN PASG.TBASG126_ALCHABINF AH ON AH.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT "
				+ "		    INNER JOIN PASG.TBASG145_ALCHAESTA AL ON AL.CDGO_ALCHABINF = AH.CDGO_ALCHABINF "
				+ "		    INNER JOIN PASG.TBASG127_LINEAS L ON L.CDGO_LINEA = AL.CDGO_LINEA "
				+ "		    INNER JOIN PASG.TBASG128_ESTACLINE ES1 ON (ES1.CDGO_ESTACION = AL.CDGO_ORIGEN AND ES1.CDGO_LINEA = L.CDGO_LINEA) "
				+ "		    INNER JOIN PASG.TBASG128_ESTACLINE ES2 ON (ES2.CDGO_ESTACION = AL.CDGO_DESTINO AND ES2.CDGO_LINEA = L.CDGO_LINEA)"
				+ "		    INNER JOIN PASG.TBASG116_ESTADOS E ON E.CDGO_ESTADO = EX.CDGO_ESTADO  "
				+ "		    INNER JOIN PASG.TBASG104_EXPEDIENT EXP ON EX.CDGO_EXPEDIENT = EXP.CDGO_EXPEDIENT WHERE";
		
		sqlString = sqlString + " EX.MRCA_ACTIVO = 'S' "
				+ "		    AND E.MRCA_ACTIVO = 'S' "
				+ "		    AND AH.MRCA_ACTIVO = 'S' "
				+ "		    AND AL.MRCA_ACTIVO = 'S' "
				+ "		    AND L.MRCA_ACTIVO = 'S' "
				+ "		    AND ES1.MRCA_ACTIVO = 'S' "
				+ "		    AND ES2.MRCA_ACTIVO = 'S' ";
		
			if(Objects.nonNull(cdgoEstado)) {

			sqlString = sqlString + " AND EX.CDGO_ESTADO = :cdgoEstado " ;
			}
			
		
		sqlString = sqlString + " AND EX.CDGO_ESTADO IN (5, 7, 9, 13, 14, 15) ";
		
		sqlString = sqlString + " AND EX.FCHA_ESTADO IN ( SELECT MAX(FCHA_ESTADO) FROM PASG.TBASG118_ESTADOEXP\r\n"
				+ "		    WHERE EX.CDGO_EXPEDIENT = CDGO_EXPEDIENT AND MRCA_ACTIVO = 'S' ) ";
		
		
		if(Objects.nonNull(cdgoExpediente)) {

			sqlString = sqlString + " AND EX.CDGO_EXPEDIENT = :cdgoExpediente " ;
			}
		
		Query sqlquery = em.createNativeQuery(sqlString);
		
		if(Objects.nonNull(cdgoEstado)) {
			sqlquery.setParameter("cdgoEstado", cdgoEstado);
			}
		
		if(Objects.nonNull(cdgoExpediente)) {
			sqlquery.setParameter("cdgoExpediente", cdgoExpediente);
			}
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetMaxEntornosExpCodListDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetMaxEntornosExpCodListDTO expe = new GetMaxEntornosExpCodListDTO();

			expe.setCdgoLinea((String) object[0]);
			expe.setCodEstOrigen((String) object[1]);
			expe.setPkOrigen(String.valueOf((java.math.BigDecimal) object[2]));
			expe.setDesgNomLargoOrigen((String) object[3]);
			expe.setCodEstacionDestino((String) object[4]);
			expe.setPkDestino(String.valueOf((java.math.BigDecimal) object[5]));
			expe.setDesgNomLargoDestino((String) object[6]);
			expe.setFchaestado((Date) object[7]);
			expe.setCdgoSociotor((String) object[8]);
			expe.setCdgoExpediente((Integer) object[9]);

			resultadosDevueltos.add(expe);
		}
		return resultadosDevueltos;
	}
	
	public List<GetTramosOrderByCodLineaDTO> getTramosOrderByCodLinea(List<Integer> cdgoExpedient) {

		String sqlString = " SELECT  L.CDGO_LINEA,  ES1.CDGO_ESTACION AS CDGO_ORIGEN, ES1.CDGO_PK AS PK_ORIGEN, RTRIM(ES1.DESG_NOMLARGO) AS ORIGEN, "
				+ "		    ES2.CDGO_ESTACION AS CDGO_DESTINO, ES2.CDGO_PK AS PK_DESTINO, RTRIM(ES2.DESG_NOMLARGO) AS DESTINO, EX.FCHA_ESTADO "
				+ "	FROM PASG.TBASG118_ESTADOEXP EX INNER JOIN PASG.TBASG104_EXPEDIENT EXP ON EXP.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT "
				+ "		    INNER JOIN PASG.TBASG116_ESTADOS E ON E.CDGO_ESTADO = EX.CDGO_ESTADO "
				+ "		    INNER JOIN PASG.TBASG126_ALCHABINF AH ON AH.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT "
				+ "		    INNER JOIN PASG.TBASG145_ALCHAESTA AL ON AL.CDGO_ALCHABINF = AH.CDGO_ALCHABINF "
				+ "		    INNER JOIN PASG.TBASG127_LINEAS L ON L.CDGO_LINEA = AL.CDGO_LINEA "
				+ "		    INNER JOIN PASG.TBASG128_ESTACLINE ES1 ON (ES1.CDGO_ESTACION = AL.CDGO_ORIGEN AND ES1.CDGO_LINEA = L.CDGO_LINEA) "
				+ "		    INNER JOIN PASG.TBASG128_ESTACLINE ES2 ON (ES2.CDGO_ESTACION = AL.CDGO_DESTINO AND ES2.CDGO_LINEA = L.CDGO_LINEA) "
				+ "	WHERE EX.MRCA_ACTIVO = 'S' AND EXP.CDGO_TIPOHAB = 1 AND EXP.DESG_TIPOINFRAESTRUC  <> 'L' AND E.MRCA_ACTIVO = 'S' "
				+ "    AND AH.MRCA_ACTIVO = 'S' AND AL.MRCA_ACTIVO = 'S' AND L.MRCA_ACTIVO = 'S' AND ES1.MRCA_ACTIVO = 'S' AND ES2.MRCA_ACTIVO = 'S' ";

		if(cdgoExpedient != null) {
			
			sqlString = sqlString + " AND EX.CDGO_EXPEDIENT IN ( " + cdgoExpedient.get(0);
			
			for(int i = 1; i < cdgoExpedient.size(); i++) {
				sqlString = sqlString + " ," + cdgoExpedient.get(i);
			}
			
			sqlString = sqlString + " )";		
		}
		
		sqlString = sqlString + " AND EX.FCHA_ESTADO =  "
				+ "			(SELECT MAX(EX2.FCHA_ESTADO) "
				+ "       			FROM PASG.TBASG118_ESTADOEXP EX2 "
				+ "            	WHERE EX2.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT "
				+ "            	AND EX2.CDGO_ESTADO IN (SELECT max(EX2.CDGO_ESTADO) "
				+ "            	FROM PASG.TBASG118_ESTADOEXP EX2 "
				+ "            	WHERE EX2.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT "
				+ "            	AND  EX2.CDGO_ESTADO IN ('7','9'))) ";	
		
		sqlString = sqlString + " ORDER BY L.CDGO_LINEA ";	
		
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetTramosOrderByCodLineaDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetTramosOrderByCodLineaDTO tramos = new GetTramosOrderByCodLineaDTO();

			tramos.setCdgoLinea((String)object[0]);
			tramos.setCdgoEstacionOrigen((String)object[1]);
			tramos.setCdgoPkOrigen(String.valueOf((java.math.BigDecimal) object[2]));
			tramos.setDesgNomLargoOrigen((String)object[3]);
			tramos.setCdgoEstacionDestino((String)object[4]);
			tramos.setCdgoPkDestino(String.valueOf((java.math.BigDecimal) object[5]));
			tramos.setDesgNomLargoDestino((String)object[6]);
			tramos.setFchaEstado((Date) object[7]);
			
			resultadosDevueltos.add(tramos);
		}
		return resultadosDevueltos;
	}
	
	public List<GetTramosOrderByCodLineaDTO> getFechasOtorgamientoPB(List<Integer> cdgoExpedient) {

		String sqlString = " SELECT  L.CDGO_LINEA, ES1.CDGO_ESTACION AS CDGO_ORIGEN, ES1.CDGO_PK AS PK_ORIGEN, RTRIM(ES1.DESG_NOMLARGO) AS ORIGEN, "
				+ "            ES2.CDGO_ESTACION AS CDGO_DESTINO, ES2.CDGO_PK AS PK_DESTINO, RTRIM(ES2.DESG_NOMLARGO) AS DESTINO, EX.FCHA_ESTADO "
				+ "	FROM PASG.TBASG118_ESTADOEXP EX INNER JOIN PASG.TBASG104_EXPEDIENT EXP ON EXP.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT "
				+ "		    INNER JOIN PASG.TBASG116_ESTADOS E ON E.CDGO_ESTADO = EX.CDGO_ESTADO "
				+ "		    INNER JOIN PASG.TBASG126_ALCHABINF AH ON AH.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT "
				+ "		    INNER JOIN PASG.TBASG145_ALCHAESTA AL ON AL.CDGO_ALCHABINF = AH.CDGO_ALCHABINF "
				+ "		    INNER JOIN PASG.TBASG127_LINEAS L ON L.CDGO_LINEA = AL.CDGO_LINEA "
				+ "		    INNER JOIN PASG.TBASG128_ESTACLINE ES1 ON (ES1.CDGO_ESTACION = AL.CDGO_ORIGEN AND ES1.CDGO_LINEA = L.CDGO_LINEA) "
				+ "		    INNER JOIN PASG.TBASG128_ESTACLINE ES2 ON (ES2.CDGO_ESTACION = AL.CDGO_DESTINO AND ES2.CDGO_LINEA = L.CDGO_LINEA) "
				+ "	WHERE EX.MRCA_ACTIVO = 'S' AND EXP.CDGO_TIPOHAB = 1 AND EXP.DESG_TIPOINFRAESTRUC  <> 'L' AND E.MRCA_ACTIVO = 'S' "
				+ "	AND AH.MRCA_ACTIVO = 'S' AND AL.MRCA_ACTIVO = 'S' AND L.MRCA_ACTIVO = 'S' AND ES1.MRCA_ACTIVO = 'S' AND ES2.MRCA_ACTIVO = 'S' ";

		if(cdgoExpedient != null) {
			
			sqlString = sqlString + " AND EX.CDGO_EXPEDIENT IN ( " + cdgoExpedient.get(0);
			
			for(int i = 1; i < cdgoExpedient.size(); i++) {
				sqlString = sqlString + " ," + cdgoExpedient.get(i);
			}
			
			sqlString = sqlString + " )";		
		}
		
		sqlString = sqlString + " AND EX.FCHA_ESTADO =  "
				+ "			(SELECT MAX(EX2.FCHA_ESTADO) "
				+ "       			FROM PASG.TBASG118_ESTADOEXP EX2 "
				+ "            	WHERE EX2.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT "
				+ "            	AND EX2.CDGO_ESTADO IN (SELECT max(EX2.CDGO_ESTADO) "
				+ "            	FROM PASG.TBASG118_ESTADOEXP EX2 "
				+ "            	WHERE EX2.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT "
				+ "            	)) ";	
		
		sqlString = sqlString + " ORDER BY L.CDGO_LINEA ";	
		
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetTramosOrderByCodLineaDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetTramosOrderByCodLineaDTO tramos = new GetTramosOrderByCodLineaDTO();
	
			tramos.setCdgoLinea((String)object[0]);
			tramos.setCdgoEstacionOrigen((String)object[1]);
			tramos.setCdgoPkOrigen(String.valueOf((java.math.BigDecimal) object[2]));
			tramos.setDesgNomLargoOrigen((String)object[3]);
			tramos.setCdgoEstacionDestino((String)object[4]);
			tramos.setCdgoPkDestino(String.valueOf((java.math.BigDecimal) object[5]));
			tramos.setDesgNomLargoDestino((String)object[6]);
			tramos.setFchaEstado((Date) object[7]);
			
			resultadosDevueltos.add(tramos);
		}
		return resultadosDevueltos;
	}
	
	public List<CountGetTramosDTO> countGetTramos(ParamCountGetTramos filtro) {

		String sqlString = " 	SELECT  COUNT(*)  FROM PASG.TBASG118_ESTADOEXP EX "
				+ "		    INNER JOIN PASG.TBASG104_EXPEDIENT EXP ON EXP.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT "
				+ "		    INNER JOIN PASG.TBASG116_ESTADOS E ON E.CDGO_ESTADO = EX.CDGO_ESTADO "
				+ "		    INNER JOIN PASG.TBASG126_ALCHABINF AH ON AH.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT "
				+ "		    INNER JOIN PASG.TBASG145_ALCHAESTA AL ON AL.CDGO_ALCHABINF = AH.CDGO_ALCHABINF "
				+ "		    INNER JOIN PASG.TBASG127_LINEAS L ON L.CDGO_LINEA = AL.CDGO_LINEA "
				+ "		    INNER JOIN PASG.TBASG128_ESTACLINE ES1 ON (ES1.CDGO_ESTACION = AL.CDGO_ORIGEN AND ES1.CDGO_LINEA = L.CDGO_LINEA) "
				+ "		    INNER JOIN PASG.TBASG128_ESTACLINE ES2 ON (ES2.CDGO_ESTACION = AL.CDGO_DESTINO AND ES2.CDGO_LINEA = L.CDGO_LINEA) "
				+ "	WHERE EX.MRCA_ACTIVO = 'S' AND EXP.CDGO_TIPOHAB = 1 AND EXP.DESG_TIPOINFRAESTRUC = 'L' AND E.MRCA_ACTIVO = 'S' AND AH.MRCA_ACTIVO = 'S' "
				+ "	       AND AL.MRCA_ACTIVO = 'S' AND L.MRCA_ACTIVO = 'S' AND ES1.MRCA_ACTIVO = 'S' AND ES2.MRCA_ACTIVO = 'S' ";

		if(filtro != null) {		
	
		if(filtro.getListaExpedientes() != null) {
			
			sqlString = sqlString + " AND EX.CDGO_EXPEDIENT IN ( " + filtro.getListaExpedientes().get(0);
			
			for(int i = 1; i < filtro.getListaExpedientes().size(); i++) {
				sqlString = sqlString + " ," + filtro.getListaExpedientes().get(i);
			}
			
			sqlString = sqlString + " )";		
		}
		
		}
		
		sqlString = sqlString + " AND EX.FCHA_ESTADO IN ( "
				+ "		  		SELECT MAX(FCHA_ESTADO) "
				+ "		  		FROM PASG.TBASG118_ESTADOEXP  "
				+ "				WHERE EX.CDGO_EXPEDIENT = CDGO_EXPEDIENT "
				+ "				AND MRCA_ACTIVO = 'S' "
				+ "AND L.CDGO_LINEA = :codLinea "
				+ "		   AND AL.CDGO_ORIGEN = :codEstacOrigen "
				+ "		   AND AL.CDGO_DESTINO = :codEstacDestino "
				+ "				) ";		
		
		Query sqlquery = em.createNativeQuery(sqlString);
		
		sqlquery.setParameter("codLinea", filtro.getCodLinea());
		sqlquery.setParameter("codEstacOrigen", filtro.getCodEstacOrigen());
		sqlquery.setParameter("codEstacDestino", filtro.getCodEstacDestino());

		List<Object> resultados = sqlquery.getResultList();
		List<CountGetTramosDTO> resultadosDevueltos = new ArrayList<>();
		for (Object object : resultados) {
			CountGetTramosDTO counttramos = new CountGetTramosDTO();
	
			counttramos.setNumeroFilas((Integer)object);
			
			resultadosDevueltos.add(counttramos);
		}
		return resultadosDevueltos;
	}

	public List<GetFechaOtorgamientoDTO> getFechaOtorgamiento(Integer cdgoExpedient) {

		String sqlString = "SELECT MAX(FCHA_ESTADO) as FCHA_OTORGAMIENTO FROM PASG.TBASG118_ESTADOEXP  "
				+ "			WHERE CDGO_EXPEDIENT = :cdgoExpedient" + "			AND CDGO_ESTADO = 9";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("cdgoExpedient", cdgoExpedient);

		List<Object> resultados = sqlquery.getResultList();
		List<GetFechaOtorgamientoDTO> resultadosDevueltos = new ArrayList<>();
		for (Object object : resultados) {
			
			GetFechaOtorgamientoDTO estadoexp = new GetFechaOtorgamientoDTO();
			
			estadoexp.setFchaOtorgamiento((Date) object);

			resultadosDevueltos.add(estadoexp);
		}
		return resultadosDevueltos;
	}

	public List<GetTramoListByCdgoExpDTO> getTramoListByCdgoExp(Integer cdgoExpedient) {

		String sqlString = "SELECT AI.CDGO_ALCHABINF, T.CDGO_LINEA, RTRIM(L.DESG_NOMBRE) AS LINEA, T.CDGO_ORIGEN, RTRIM(EO.DESG_NOMLARGO) AS ORIGEN, " +
				"    T.CDGO_DESTINO, RTRIM(ED.DESG_NOMLARGO) AS DESTINO, S.DESG_NOMBRE AS ESTADO FROM PASG.TBASG118_ESTADOEXP EX " +
				"    INNER JOIN PASG.TBASG126_ALCHABINF AI ON AI.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT " +
				"    INNER JOIN PASG.TBASG116_ESTADOS S ON EX.CDGO_ESTADO = S.CDGO_ESTADO " +
				"    INNER JOIN PASG.TBASG145_ALCHAESTA T ON AI.CDGO_ALCHABINF = T.CDGO_ALCHABINF " +
				"    INNER JOIN PASG.TBASG127_LINEAS L ON T.CDGO_LINEA = L.CDGO_LINEA " +
				"    INNER JOIN PASG.TBASG128_ESTACLINE EO ON (T.CDGO_LINEA = EO.CDGO_LINEA AND T.CDGO_ORIGEN = EO.CDGO_ESTACION) " +
				"    INNER JOIN PASG.TBASG128_ESTACLINE ED ON (T.CDGO_LINEA = ED.CDGO_LINEA AND T.CDGO_DESTINO = ED.CDGO_ESTACION) " +
				"    WHERE EX.CDGO_EXPEDIENT = :cdgoExpedient AND EX.FCHA_ESTADO = (SELECT MAX(FCHA_ESTADO) FROM PASG.TBASG118_ESTADOEXP " +
				"    WHERE CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT AND MRCA_ACTIVO = 'S');";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("cdgoExpedient", cdgoExpedient);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetTramoListByCdgoExpDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {

			GetTramoListByCdgoExpDTO tramolist = new GetTramoListByCdgoExpDTO();

			tramolist.setCdgoAlchabinf((Integer) object[0]);
			tramolist.setCdgoLinea((String) object[1]);
			tramolist.setDesgNombreLinea((String) object[2]);
			tramolist.setCdgoOrigen((String) object[3]);
			tramolist.setOrigen((String) object[4]);
			tramolist.setCdgoDestino((String) object[5]);
			tramolist.setDestino((String) object[6]);
			tramolist.setDesgNombreEstado((String) object[7]);

			resultadosDevueltos.add(tramolist);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg118Estadoexp> getFechasOtorgamiento(List<Integer> cdgoExpedient) {

		String sqlString = "SELECT EX.CDGO_EXPEDIENT, EX.FCHA_ESTADO AS FCHA_OTORGAMIENTO " + "			FROM "
				+ "				PASG.TBASG118_ESTADOEXP EX WHERE";
		
		if(cdgoExpedient != null) {
			
			sqlString = sqlString + " EX.CDGO_EXPEDIENT IN ( " + cdgoExpedient.get(0);
			
			for(int i = 1; i < cdgoExpedient.size(); i++) {
				sqlString = sqlString + " ," + cdgoExpedient.get(i);
			}
			
			sqlString = sqlString + " )";		
		}
		
		sqlString = sqlString + " AND EX.CDGO_ESTADO IN (SELECT max(EX2.CDGO_ESTADO) FROM PASG.TBASG118_ESTADOEXP EX2 "
				+ "    		      WHERE EX2.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT AND  EX2.CDGO_ESTADO IN ('7','9')) "
				+ "				  AND EX.FCHA_ESTADO = (SELECT MAX(EX2.FCHA_ESTADO) FROM PASG.TBASG118_ESTADOEXP EX2 "
				+ "				  WHERE EX2.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT AND EX2.CDGO_ESTADO IN (SELECT max(EX2.CDGO_ESTADO) "
				+ " 			  FROM PASG.TBASG118_ESTADOEXP EX2 WHERE EX2.CDGO_EXPEDIENT = EX.CDGO_EXPEDIENT AND  EX2.CDGO_ESTADO IN ('7','9')))";
		
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg118Estadoexp> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg118Estadoexp estadoexp = new Tbasg118Estadoexp();
			Tbasg118EstadoexpPK estadoexpPK = new Tbasg118EstadoexpPK();
			
			estadoexpPK.setCdgoExpedient((Integer)object[0]);
			estadoexp.setTbasg118estadoexppk(estadoexpPK);
			estadoexp.setFchaAct((Date) object[1]);

			resultadosDevueltos.add(estadoexp);
		}
		return resultadosDevueltos;
	}

	public List<GetFechaExpFiltradaDTO> getFechaExpFiltrada(String cdgoPersona) {

		String sqlString = "SELECT FCHA_ESTADO FROM PASG.TBASG118_ESTADOEXP "
				+ "		WHERE PASG.TBASG118_ESTADOEXP.CDGO_EXPEDIENT = (SELECT PASG.TBASG104_EXPEDIENT.CDGO_EXPEDIENT FROM PASG.TBASG104_EXPEDIENT"
				+ "		INNER JOIN PASG.TBASG118_ESTADOEXP"
				+ "		ON PASG.TBASG104_EXPEDIENT.cdgo_expedient = PASG.TBASG118_ESTADOEXP.cdgo_expedient"
				+ "		WHERE cdgo_persona = :value AND PASG.TBASG104_EXPEDIENT.mrca_activo = 'S' AND cdgo_tipohab = '2'"
				+ "		AND PASG.TBASG118_ESTADOEXP.cdgo_estado in ('5', '7', '9') ORDER BY PASG.TBASG104_EXPEDIENT.cdgo_expedient FETCH FIRST 1 ROW ONLY)"
				+ "		AND CDGO_ESTADO in ('5', '7', '9') order by cdgo_expedient fetch first 1 row only;";
		
		Query sqlquery = em.createNativeQuery(sqlString);

		sqlquery.setParameter("value", cdgoPersona);
		
		List<Object> resultados = sqlquery.getResultList();
		List<GetFechaExpFiltradaDTO> resultadosDevueltos = new ArrayList<GetFechaExpFiltradaDTO>();
		for (Object object : resultados) {
			GetFechaExpFiltradaDTO estadoexp = new GetFechaExpFiltradaDTO();
			estadoexp.setFchaEstado((Date) object);
			resultadosDevueltos.add(estadoexp);
		}
		return resultadosDevueltos;
	}

}
