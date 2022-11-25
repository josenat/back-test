package renfe.com.repository.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.dto.Tbasg126AlchabinfDto;
import renfe.com.model.entity.Tbasg126Alchabinf;
import renfe.com.repository.Tbasg126AlchabinfRepositoryCustom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

public class Tbasg126AlchabinfRepositoryImpl implements Tbasg126AlchabinfRepositoryCustom {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(Tbasg126AlchabinfRepositoryImpl.class);

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg126Alchabinf> findAlcHabInfByCdgoExp(Integer cdgoExpedient) {

		String sqlString = "SELECT * FROM PASG.TBASG126_ALCHABINF WHERE CDGO_EXPEDIENT =  :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoExpedient);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg126Alchabinf> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg126Alchabinf alchabinf = new Tbasg126Alchabinf();
			
			alchabinf.setCdgoAlchabinf(Long.valueOf((int)object[0]));
			alchabinf.setCdgoExpedient((Integer)object[1]);
			alchabinf.setDesgUsuact((String)object[2]);
			alchabinf.setFchaFecact((Date)object[3]);
			alchabinf.setMrcaActivo(String.valueOf((Character) object[4]));

			resultadosDevueltos.add(alchabinf);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg126Alchabinf> getAlcHabInf(String cdgoAlchabinf) {

		String sqlString = "SELECT * FROM PASG.TBASG126_ALCHABINF WHERE CDGO_ALCHABINF=:cdgoAlcHabInf";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg126Alchabinf.class);
		sqlquery.setParameter("cdgoAlcHabInf", cdgoAlchabinf);
		return sqlquery.getResultList();
	}

	@Transactional
	public int insertAlcHabInf(Tbasg126AlchabinfDto bean) {
		int result      = 0;
		boolean isValid = true;

		if (Objects.isNull(bean.getCdgoExpedient())) {
			logger.error("--> Error insertAlcHabInf: 'cdgoExpedient' es requerido");
			isValid = false;
		}

		if (Objects.isNull(bean.getDesgUsuact())) {
			logger.error("--> Error insertAlcHabInf: 'desgUsuact' es requerido");
			isValid = false;
		}

		if (Objects.isNull(bean.getMrcaActivo())) {
			logger.error("--> Error insertAlcHabInf: 'mrcaActivo' es requerido");
			isValid = false;
		}

		String sqlString = "INSERT INTO PASG.TBASG126_ALCHABINF (CDGO_EXPEDIENT, DESG_USUACT, FCHA_FECACT, MRCA_ACTIVO) VALUES (?, ?, CURRENT_DATE, ?)";

		Query sqlquery = em.createNativeQuery(sqlString);

		sqlquery.setParameter(1, bean.getCdgoExpedient());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getMrcaActivo());
		
		if (isValid) {
			try {				
				if (sqlquery.executeUpdate() > 0) {
					logger.debug("--> Success insertAlcHabInf");

					sqlString = " SELECT IDENTITY_VAL_LOCAL() AS identity_val FROM SYSIBM.SYSDUMMY1 ";
					sqlquery = em.createNativeQuery(sqlString);	
					
					List<BigDecimal> results = sqlquery.getResultList();
			
					BigDecimal res = null;
					for (BigDecimal item : results) {
						res = item;
					}
			
					result = res.intValue();

					logger.debug("--> insertAlcHabInf ID: {}", result);
				}

			} catch (Exception e) {
				logger.error("--> Error insertAlcHabInf:", e);
			}
		}			

		return result;
	}

	public int deleteAlcHabInfByCdgoExp(Tbasg126Alchabinf bean) {

		String sqlString = "UPDATE PASG.TBASG126_ALCHABINF SET MRCA_ACTIVO='N', DESG_USUACT=:usuAct, FCHA_FECACT=CURRENT_DATE WHERE CDGO_EXPEDIENT=:cdgoExpedient";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg126Alchabinf.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoExpedient", bean.getCdgoExpedient());
		return sqlquery.executeUpdate();
	}

	public int deleteAlcHabInf(Tbasg126Alchabinf bean) {

		String sqlString = "UPDATE PASG.TBASG126_ALCHABINF SET MRCA_ACTIVO='N', DESG_USUACT=:usuAct, FCHA_FECACT=CURRENT_DATE  WHERE CDGO_ALCHABINF=:cdgoAlcHabInf";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg126Alchabinf.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoAlcHabInf", bean.getCdgoAlchabinf());
		return sqlquery.executeUpdate();
	}

	public List<Tbasg126Alchabinf> getPreviousEstaHabInList(String cdgoAlchabinf) {

		String sqlString = "SELECT" + "					C.CDGO_ESTADO 										"
				+ "					FROM PASG.TBASG126_ALCHABINF A,PASG.TBASG145_ALCHAESTA B, PASG.TBASG119_ESTAHABIN C "
				+ "					WHERE A.CDGO_ALCHABINF =   C.CDGO_ALCHABINF "
				+ "					AND A.CDGO_ALCHABINF =   B.CDGO_ALCHABINF "
				+ "					AND A.CDGO_ALCHABINF =   :value							  "
				+ "					ORDER BY C.FCHA_ESTADO DESC		" + "					FETCH FIRST 2 ROWS ONLY";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg126Alchabinf.class);
		sqlquery.setParameter("value", cdgoAlchabinf);
		return sqlquery.getResultList();
	}

	public List<Tbasg126Alchabinf> getMaxEntornosExpList(String cdgoExpedient) {

		String sqlString = "SELECT A.CDGO_EXPEDIENT, A.CDGO_ALCHABINF, RTRIM(E.DESG_NOMBRE) AS LINEA, "
				+ "		        RTRIM(F.DESG_NOMCORTO) AS ORIGEN, RTRIM(G.DESG_NOMCORTO) as DESTINO, RTRIM(D.DESG_NOMBRE) AS ESTADO"
				+ "		    FROM PASG.TBASG126_ALCHABINF A,PASG.TBASG145_ALCHAESTA B, PASG.TBASG119_ESTAHABIN C, PASG.TBASG116_ESTADOS D"
				+ "		        , PASG.TBASG127_LINEAS E, PASG.TBASG128_ESTACLINE F, PASG.TBASG128_ESTACLINE G"
				+ "		    WHERE C.CDGO_ESTADO = D.CDGO_ESTADO	" + "		        AND B.CDGO_LINEA = E.CDGO_LINEA"
				+ "		        AND F.CDGO_ESTACION = B.CDGO_ORIGEN "
				+ "		        AND E.CDGO_LINEA = F.CDGO_LINEA   "
				+ "		        AND G.CDGO_ESTACION = B.CDGO_DESTINO   "
				+ "		        AND E.CDGO_LINEA = G.CDGO_LINEA     " + "		        AND C.FCHA_ESTADO IN ("
				+ "		                SELECT MAX(FCHA_ESTADO) "
				+ "		                FROM PASG.TBASG119_ESTAHABIN"
				+ "		                WHERE CDGO_ALCHABINF = C.CDGO_ALCHABINF"
				+ "		                AND MRCA_ACTIVO = 'S'" + "		        )"
				+ "		    and B.CDGO_ALCHABINF= C.CDGO_ALCHABINF" + "		    and A.CDGO_ALCHABINF= B.CDGO_ALCHABINF"
				+ "		    AND A.CDGO_EXPEDIENT = :codExpediente" + "			and G.MRCA_ACTIVO = 'S'"
				+ "	        and F.MRCA_ACTIVO = 'S'" + "    	    and E.MRCA_ACTIVO = 'S'"
				+ "        	and D.MRCA_ACTIVO = 'S'" + "	        and C.MRCA_ACTIVO = 'S'"
				+ "    	    and B.MRCA_ACTIVO = 'S'" + "        	and A.MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg126Alchabinf.class);
		sqlquery.setParameter("codExpediente", cdgoExpedient);
		return sqlquery.getResultList();
	}

	public List<Tbasg126Alchabinf> getMaxEntornosExpListDesc(String cdgoExpedient) {

		String sqlString = "SELECT A.CDGO_EXPEDIENT, E.CDGO_LINEA, RTRIM(E.DESG_NOMBRE) AS LINEA, F.CDGO_ESTACION as CDGO_ORIGEN, "
				+ "		     RTRIM(F.DESG_NOMCORTO) AS ORIGEN, G.CDGO_ESTACION as CDGO_DESTINO, RTRIM(G.DESG_NOMCORTO) as DESTINO,"
				+ "		     D.CDGO_ESTADO ,RTRIM(D.DESG_NOMBRE) AS ESTADO"
				+ "		  FROM PASG.TBASG126_ALCHABINF A,PASG.TBASG145_ALCHAESTA B, PASG.TBASG119_ESTAHABIN C, PASG.TBASG116_ESTADOS D"
				+ "		        , PASG.TBASG127_LINEAS E, PASG.TBASG128_ESTACLINE F, PASG.TBASG128_ESTACLINE G"
				+ "		  WHERE C.CDGO_ESTADO = D.CDGO_ESTADO	" + "		        AND B.CDGO_LINEA = E.CDGO_LINEA"
				+ "		        AND F.CDGO_ESTACION = B.CDGO_ORIGEN "
				+ "		        AND E.CDGO_LINEA = F.CDGO_LINEA   "
				+ "		        AND G.CDGO_ESTACION = B.CDGO_DESTINO   "
				+ "		        AND E.CDGO_LINEA = G.CDGO_LINEA     " + "		        AND C.FCHA_ESTADO IN ("
				+ "		                SELECT MAX(FCHA_ESTADO) "
				+ "		                FROM PASG.TBASG119_ESTAHABIN"
				+ "		                WHERE CDGO_ALCHABINF = C.CDGO_ALCHABINF"
				+ "		                AND MRCA_ACTIVO = 'S'" + "		        )"
				+ "		    and B.CDGO_ALCHABINF= C.CDGO_ALCHABINF" + "		    and A.CDGO_ALCHABINF= B.CDGO_ALCHABINF"
				+ "		    AND A.CDGO_EXPEDIENT = :codExpediente" + "			and G.MRCA_ACTIVO = 'S'"
				+ "	        and F.MRCA_ACTIVO = 'S'" + "    	    and E.MRCA_ACTIVO = 'S'"
				+ "        	and D.MRCA_ACTIVO = 'S'" + "	        and C.MRCA_ACTIVO = 'S'"
				+ "    	    and B.MRCA_ACTIVO = 'S'" + "        	and A.MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg126Alchabinf.class);
		sqlquery.setParameter("codExpediente", cdgoExpedient);
		return sqlquery.getResultList();
	}

	public List<Tbasg126Alchabinf> findTramoByCodExpediente(String cdgoExpedient) {

		String sqlString = "SELECT ALCHAESTA.CDGO_LINEA AS COD_LINEA,"
				+ "        ESTACLINE1.CDGO_ESTACION AS COD_EST_ORIGEN,"
				+ "        ESTACLINE1.CDGO_ORDEN AS COD_ORDEN_ORIGEN,"
				+ "        RTRIM(ESTACLINE1.DESG_NOMLARGO) AS ORIGEN,"
				+ "        RTRIM(ESTACLINE1.DESG_NOMCORTO) AS NOMCORTOORI,"
				+ "        ESTACLINE2.CDGO_ESTACION AS COD_EST_DESTINO,"
				+ "        ESTACLINE2.CDGO_ORDEN AS COD_ORDEN_DESTINO,"
				+ "        RTRIM(ESTACLINE2.DESG_NOMLARGO) AS DESTINO,"
				+ "        RTRIM(ESTACLINE2.DESG_NOMCORTO) AS NOMCORTODEST"
				+ "		FROM PASG.TBASG126_ALCHABINF ALCHABINF"
				+ "		INNER JOIN PASG.TBASG145_ALCHAESTA ALCHAESTA ON ALCHAESTA.CDGO_ALCHABINF = ALCHABINF.CDGO_ALCHABINF"
				+ "		INNER JOIN PASG.TBASG127_LINEAS LINEAS ON LINEAS.CDGO_LINEA = ALCHAESTA.CDGO_LINEA"
				+ "		INNER JOIN PASG.TBASG128_ESTACLINE ESTACLINE1 ON (ESTACLINE1.CDGO_ESTACION = ALCHAESTA.CDGO_ORIGEN AND ESTACLINE1.CDGO_LINEA = LINEAS.CDGO_LINEA)"
				+ "		INNER JOIN PASG.TBASG128_ESTACLINE ESTACLINE2 ON (ESTACLINE2.CDGO_ESTACION = ALCHAESTA.CDGO_DESTINO AND ESTACLINE2.CDGO_LINEA = LINEAS.CDGO_LINEA)"
				+ "		  WHERE ALCHABINF.CDGO_EXPEDIENT = :cdgoExpediente" + "		  AND ALCHABINF.MRCA_ACTIVO = 'S'"
				+ "		  AND ALCHAESTA.MRCA_ACTIVO = 'S'" + "		  AND LINEAS.MRCA_ACTIVO = 'S'"
				+ "		  AND ESTACLINE1.MRCA_ACTIVO = 'S'" + "		  AND ESTACLINE2.MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg126Alchabinf.class);
		sqlquery.setParameter("cdgoExpediente", cdgoExpedient);
		return sqlquery.getResultList();
	}

}
