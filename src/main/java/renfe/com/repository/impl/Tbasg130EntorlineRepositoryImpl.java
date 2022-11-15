package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.dto.GetEntorLineListAscendenteCDGO_ENTORNODTO;
import renfe.com.model.entity.Tbasg129Entornos;
import renfe.com.model.entity.Tbasg130Entorline;
import renfe.com.model.entity.Tbasg130EntorlinePK;
import renfe.com.repository.Tbasg130EntorlineRepositoryCustom;

public class Tbasg130EntorlineRepositoryImpl implements Tbasg130EntorlineRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg130Entorline> getEntorLineCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG130_ENTORLINE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg130Entorline.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg130Entorline> getEntorLineCountCDGO_ENTORNO(String cdgoEntorno) {

		String sqlString = "SELECT COUNT(*) AS value" + "" + "				FROM        "
				+ "				PASG.TBASG130_ENTORLINE N," + "				PASG.TBASG128_ESTACLINE B,"
				+ "				PASG.TBASG128_ESTACLINE A," + "				PASG.TBASG127_LINEAS L"
				+ "				, PASG.TBASG129_ENTORNOS E" + "			" + "			WHERE"
				+ "				N.CDGO_LINEA    = L.CDGO_LINEA AND" + "				N.CDGO_LINEA    = B.CDGO_LINEA AND"
				+ "				N.CDGO_LINEA    = A.CDGO_LINEA AND"
				+ "				N.CDGO_ENTORNO  = E.CDGO_ENTORNO AND"
				+ "				N.CDGO_ORIGEN  = B.CDGO_ESTACION AND"
				+ "				N.CDGO_DESTINO = A.CDGO_ESTACION AND" + "				B.CDGO_LINEA = L.CDGO_LINEA AND"
				+ "				A.CDGO_LINEA = L.CDGO_LINEA AND" + "			    N.CDGO_ENTORNO = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg130Entorline.class);
		sqlquery.setParameter("value", cdgoEntorno);
		return sqlquery.getResultList();
	}

	public List<GetEntorLineListAscendenteCDGO_ENTORNODTO> getEntorLineListAscendenteCDGO_ENTORNO(String cdgoEntorno) {

		String sqlString = "SELECT N.CDGO_ENTORNO, N.CDGO_LINEA, N.CDGO_ORIGEN, N.CDGO_DESTINO, N.DESG_USUACT, N.FCHA_ACT, N.MRCA_ACTIVO, L.DESG_NOMBRE AS LINEA,"
				+ " B.DESG_NOMCORTO AS ORIGEN, E.DESG_NOMCORTO AS ENTORNO, A.DESG_NOMCORTO AS DESTINO "
				+ " FROM PASG.TBASG130_ENTORLINE N, PASG.TBASG128_ESTACLINE B, PASG.TBASG128_ESTACLINE A, PASG.TBASG127_LINEAS L, PASG.TBASG129_ENTORNOS E "
				+ " WHERE N.CDGO_LINEA = L.CDGO_LINEA AND N.CDGO_LINEA = B.CDGO_LINEA AND N.CDGO_LINEA = A.CDGO_LINEA AND"
				+ " N.CDGO_ENTORNO = E.CDGO_ENTORNO AND N.CDGO_ORIGEN = B.CDGO_ESTACION AND N.CDGO_DESTINO = A.CDGO_ESTACION AND "
				+ " B.CDGO_LINEA = L.CDGO_LINEA AND A.CDGO_LINEA = L.CDGO_LINEA AND N.CDGO_ENTORNO = " + cdgoEntorno + " ORDER BY LINEA";
		
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetEntorLineListAscendenteCDGO_ENTORNODTO> resultadosDevueltos = new ArrayList<>();
		
		for (Object[] object : resultados) {
			GetEntorLineListAscendenteCDGO_ENTORNODTO entorno = new GetEntorLineListAscendenteCDGO_ENTORNODTO();
			
			entorno.setCdgoEntorno((Integer)object[0]);
			entorno.setCdgoLinea((String)object[1]);
			entorno.setCdgoOrigen((String)object[2]);
			entorno.setCdgoDestino((String)object[3]);
			entorno.setDesgUsuact((String)object[4]);
			entorno.setFchaAct((Date)object[5]);
			entorno.setMrcaActivo((char)object[6]);
			entorno.setLinea((String)object[7]);
			entorno.setOrigen((String)object[8]);
			entorno.setEntorno((String)object[9]);
			entorno.setDestino((String)object[10]);

			resultadosDevueltos.add(entorno);
		}
		return resultadosDevueltos;

	}

	public List<Tbasg130Entorline> getEntorLineListDescendenteCDGO_ENTORNO(String cdgoEntorno) {

		String sqlString = "SELECT" + "				N.CDGO_ENTORNO," + "				N.CDGO_LINEA,"
				+ "				N.CDGO_ORIGEN," + "				N.CDGO_DESTINO," + "				N.DESG_USUACT,"
				+ "				N.FCHA_ACT," + "				N.MRCA_ACTIVO," + "				L.DESG_NOMBRE AS LINEA,"
				+ "				B.DESG_NOMCORTO AS ORIGEN," + "				E.DESG_NOMCORTO AS ENTORNO,"
				+ "				A.DESG_NOMCORTO AS DESTINO" + "				FROM        "
				+ "				PASG.TBASG130_ENTORLINE N," + "				PASG.TBASG128_ESTACLINE B,"
				+ "				PASG.TBASG128_ESTACLINE A," + "				PASG.TBASG127_LINEAS L"
				+ "				, PASG.TBASG129_ENTORNOS E" + "			" + "			WHERE"
				+ "				N.CDGO_LINEA    = L.CDGO_LINEA AND" + "				N.CDGO_LINEA    = B.CDGO_LINEA AND"
				+ "				N.CDGO_LINEA    = A.CDGO_LINEA AND"
				+ "				N.CDGO_ENTORNO  = E.CDGO_ENTORNO AND"
				+ "				N.CDGO_ORIGEN  = B.CDGO_ESTACION AND"
				+ "				N.CDGO_DESTINO = A.CDGO_ESTACION AND" + "				B.CDGO_LINEA = L.CDGO_LINEA AND"
				+ "				A.CDGO_LINEA = L.CDGO_LINEA AND" + "			    N.CDGO_ENTORNO = :value"
				+ "			ORDER BY LINEA DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg130Entorline.class);
		sqlquery.setParameter("value", cdgoEntorno);
		return sqlquery.getResultList();
	}

	public List<Tbasg130Entorline> getEntorLine(String cdgoEntorno, String cdgoLinea, String cdgoOrigen,
			String cdgoDestino) {

		String sqlString = "SELECT * FROM PASG.TBASG130_ENTORLINE WHERE CDGO_ENTORNO=:cdgoEntorno AND CDGO_LINEA=:cdgoLinea AND CDGO_ORIGEN=:cdgoOrigen AND CDGO_DESTINO=:cdgoDestino";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg130Entorline.class);
		sqlquery.setParameter("cdgoEntorno", cdgoEntorno);
		sqlquery.setParameter("cdgoLinea", cdgoLinea);
		sqlquery.setParameter("cdgoOrigen", cdgoOrigen);
		sqlquery.setParameter("cdgoDestino", cdgoDestino);
		return sqlquery.getResultList();
	}

	public List<Tbasg130Entorline> getEntorLineListActive(String cdgoEntorno) {

		String sqlString = "SELECT N.CDGO_ENTORNO, N.CDGO_LINEA, N.CDGO_ORIGEN, N.CDGO_DESTINO, N.DESG_USUACT, 	N.FCHA_ACT,	N.MRCA_ACTIVO, "
				+ "				L.DESG_NOMBRE AS LINEA, B.DESG_NOMCORTO AS ORIGEN, E.DESG_NOMCORTO AS ENTORNO, A.DESG_NOMCORTO AS DESTINO"
				+ "			FROM  PASG.TBASG130_ENTORLINE N, PASG.TBASG128_ESTACLINE B, PASG.TBASG128_ESTACLINE A,"
				+ "				PASG.TBASG127_LINEAS L, PASG.TBASG129_ENTORNOS E			" + "			WHERE"
				+ "				N.CDGO_LINEA   = L.CDGO_LINEA AND" + "				N.CDGO_LINEA   = B.CDGO_LINEA AND"
				+ "				N.CDGO_LINEA   = A.CDGO_LINEA AND" + "				N.CDGO_ENTORNO = E.CDGO_ENTORNO AND"
				+ "				N.CDGO_ORIGEN  = B.CDGO_ESTACION AND"
				+ "				N.CDGO_DESTINO = A.CDGO_ESTACION AND" + "				B.CDGO_LINEA = L.CDGO_LINEA AND"
				+ "				A.CDGO_LINEA = L.CDGO_LINEA AND" + "				N.MRCA_ACTIVO = 'S' AND"
				+ "		        B.MRCA_ACTIVO = 'S' AND" + "		        A.MRCA_ACTIVO = 'S' AND"
				+ "		        L.MRCA_ACTIVO = 'S' AND	" + "	  	        E.MRCA_ACTIVO = 'S'	AND"
				+ "			    N.CDGO_ENTORNO = :value" + "		ORDER BY LINEA";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg130Entorline.class);
		sqlquery.setParameter("value", cdgoEntorno);
		return sqlquery.getResultList();
	}

	public List<Tbasg130Entorline> getEntorLineListDynamic(String cdgoEntorno) {

		String sqlString = "SELECT" + "				N.CDGO_ENTORNO," + "				N.CDGO_LINEA,"
				+ "				N.CDGO_ORIGEN," + "				N.CDGO_DESTINO," + "				N.DESG_USUACT,"
				+ "				N.FCHA_ACT," + "				N.MRCA_ACTIVO," + "				L.DESG_NOMBRE AS LINEA,"
				+ "				B.DESG_NOMCORTO AS ORIGEN," + "				E.DESG_NOMCORTO AS ENTORNO,"
				+ "				A.DESG_NOMCORTO AS DESTINO" + "				FROM        "
				+ "				PASG.TBASG130_ENTORLINE N," + "				PASG.TBASG128_ESTACLINE B,"
				+ "				PASG.TBASG128_ESTACLINE A," + "				PASG.TBASG127_LINEAS L"
				+ "				, PASG.TBASG129_ENTORNOS E" + "			WHERE"
				+ "				N.CDGO_LINEA    = L.CDGO_LINEA AND" + "				N.CDGO_LINEA    = B.CDGO_LINEA AND"
				+ "				N.CDGO_LINEA    = A.CDGO_LINEA AND"
				+ "				N.CDGO_ENTORNO  = E.CDGO_ENTORNO AND"
				+ "				N.CDGO_ORIGEN  = B.CDGO_ESTACION AND"
				+ "				N.CDGO_DESTINO = A.CDGO_ESTACION AND" + "				B.CDGO_LINEA = L.CDGO_LINEA AND"
				+ "				A.CDGO_LINEA = L.CDGO_LINEA AND" + "			    N.CDGO_ENTORNO = :cdgoEntorno";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg130Entorline.class);
		sqlquery.setParameter("cdgoEntorno", cdgoEntorno);
		return sqlquery.getResultList();
	}

	public int insertEntorLine(Tbasg130Entorline bean) {

		String sqlString = "INSERT INTO PASG.TBASG130_ENTORLINE (CDGO_ENTORNO, CDGO_LINEA, CDGO_ORIGEN, CDGO_DESTINO, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, ?, ?, ?, CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg130Entorline.class);
		sqlquery.setParameter(1, bean.getTbasg130entorlinepk().getCdgoEntorno());
		sqlquery.setParameter(2, bean.getTbasg130entorlinepk().getCdgoLinea());
		sqlquery.setParameter(3, bean.getTbasg130entorlinepk().getCdgoOrigen());
		sqlquery.setParameter(4, bean.getTbasg130entorlinepk().getCdgoDestino());
		sqlquery.setParameter(5, bean.getDesgUsuact());
		sqlquery.setParameter(6, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int reactiveEntorLine(Tbasg130Entorline bean) {

		String sqlString = "UPDATE PASG.TBASG130_ENTORLINE"
				+ "        SET MRCA_ACTIVO = 'S', DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg130Entorline.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		return sqlquery.executeUpdate();
	}

	public int desactiveEntorLine(Tbasg130Entorline bean) {

		String sqlString = "UPDATE PASG.TBASG130_ENTORLINE"
				+ "        SET MRCA_ACTIVO = 'N', DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg130Entorline.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		return sqlquery.executeUpdate();
	}

	public int deleteEntorLine() {

		String sqlString = "DELETE FROM PASG.TBASG130_ENTORLINE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg130Entorline.class);

		return sqlquery.executeUpdate();
	}

	public int deleteTramoLineaEntorno() {

		String sqlString = "DELETE FROM PASG.TBASG130_ENTORLINE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg130Entorline.class);

		return sqlquery.executeUpdate();
	}

	public List<Tbasg130Entorline> getTramosEntorno(String cdgoEntorno) {

		String sqlString = "SELECT RTRIM(D.DESG_NOMBRE) AS LINEA, RTRIM(B.DESG_NOMCORTO) AS ORIGEN, RTRIM(C.DESG_NOMCORTO) as DESTINO"
				+ "			FROM PASG.TBASG130_ENTORLINE A, PASG.TBASG128_ESTACLINE B, PASG.TBASG128_ESTACLINE C,"
				+ "				PASG.TBASG127_LINEAS D" + "			WHERE A.CDGO_LINEA = D.CDGO_LINEA"
				+ "	            AND A.CDGO_ORIGEN = B.CDGO_ESTACION"
				+ "	            AND A.CDGO_DESTINO = C.CDGO_ESTACION" + "	            AND B.CDGO_LINEA = D.CDGO_LINEA"
				+ "	            AND C.CDGO_LINEA = D.CDGO_LINEA" + "	            AND A.CDGO_ENTORNO = :codTramo";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg130Entorline.class);
		sqlquery.setParameter("codTramo", cdgoEntorno);
		return sqlquery.getResultList();
	}

	public List<Tbasg130Entorline> getTramosEntornos(String cdgoEntorno) {

		String sqlString = "SELECT A.CDGO_ENTORNO, A.CDGO_LINEA, A.CDGO_ORIGEN, A.CDGO_DESTINO, "
				+ "		    RTRIM(D.DESG_NOMBRE) AS LINEA, RTRIM(B.DESG_NOMCORTO) AS ORIGEN, RTRIM(C.DESG_NOMCORTO) as DESTINO"
				+ "		  FROM PASG.TBASG130_ENTORLINE A, PASG.TBASG128_ESTACLINE B, PASG.TBASG128_ESTACLINE C,"
				+ "			PASG.TBASG127_LINEAS D" + "		  WHERE A.CDGO_LINEA = D.CDGO_LINEA"
				+ "	           AND A.CDGO_ORIGEN = B.CDGO_ESTACION" + "	           AND A.CDGO_DESTINO = C.CDGO_ESTACION"
				+ "	           AND B.CDGO_LINEA = D.CDGO_LINEA" + "	           AND C.CDGO_LINEA = D.CDGO_LINEA"
				+ "			   AND A.MRCA_ACTIVO ='S'" + "	           AND A.CDGO_ENTORNO = :codTramo";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg130Entorline.class);
		sqlquery.setParameter("codTramo", cdgoEntorno);
		return sqlquery.getResultList();
	}

}
