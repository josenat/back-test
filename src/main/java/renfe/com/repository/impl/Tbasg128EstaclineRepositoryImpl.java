package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.dto.Tbasg128EstaclineDto;
import renfe.com.model.entity.Tbasg128Estacline;
import renfe.com.model.entity.Tbasg128EstaclinePK;
import renfe.com.repository.Tbasg128EstaclineRepositoryCustom;

public class Tbasg128EstaclineRepositoryImpl implements Tbasg128EstaclineRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg128Estacline> getDatosLinea(String cdgoEstacion, String cdgoAcredita) {

		String sqlString = "SELECT " + "				TRIM(C.CDGO_LINEA) AS COD_LINEA,"
				+ "			    RTRIM(L.DESG_NOMBRE) AS LINEA, " + "			    C.CDGO_ESTACION AS COD_ORIGEN,"
				+ "				RTRIM(C.DESG_NOMLARGO) AS DESC_ORIGEN," + "				D.CDGO_ESTACION AS COD_DESTINO,"
				+ "				RTRIM(D.DESG_NOMLARGO) AS DESC_DESTINO"
				+ "				FROM PASG.TBASG128_ESTACLINE C,PASG.TBASG128_ESTACLINE D, PASG.TBASG127_LINEAS L, PASG.TBASG267_EXPED_ACRED E"
				+ "				WHERE " + "				C.CDGO_LINEA = D.CDGO_LINEA AND C.CDGO_LINEA = L.CDGO_LINEA AND"
				+ "				C.CDGO_ORDEN=(SELECT MIN(CDGO_ORDEN) AS MINIMO FROM PASG.TBASG128_ESTACLINE WHERE CDGO_ESTACION = :codEstacion)"
				+ "				AND D.CDGO_ORDEN=(SELECT MAX(CDGO_ORDEN) AS MAXIMO FROM PASG.TBASG128_ESTACLINE WHERE CDGO_ESTACION = :codEstacion )"
				+ "				AND C.CDGO_ESTACION = :codEstacion" + "				AND E.CDGO_ESTACION = :codEstacion"
				+ "				AND E.CDGO_ACREDITA = :codAcred";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);
		sqlquery.setParameter("codEstacion", cdgoEstacion);
		sqlquery.setParameter("codAcred", cdgoAcredita);
		return sqlquery.getResultList();
	}

	public List<Tbasg128Estacline> getDescTipoAmbitoEstacionLinea(String cdgoEstacion) {

		String sqlString = "SELECT DESG_NOMCORTO FROM PASG.TBASG128_ESTACLINE WHERE CDGO_ESTACION = :value  AND MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);
		sqlquery.setParameter("value", cdgoEstacion);
		return sqlquery.getResultList();
	}

	public List<Tbasg128Estacline> getOrdenByLineasEstacionesList(/** FIXME revisar tipo */
	Object cdgoLinea, /** FIXME revisar tipo */
	Object cdgoOrden, /** FIXME revisar tipo */
	Object cdgoOrden_1) {
		// FIXME adaptar las definiciones
		String sqlString = "select cdgo_orden " + "		from pasg.TBASG128_ESTACLINE "
				+ "		where cdgo_linea = :cdgolinea and cdgo_orden between :ordenestacorigen and :ordenestacdestino"
				+ "		order by cdgo_orden";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);
		sqlquery.setParameter("cdgolinea", cdgoLinea);
		sqlquery.setParameter("ordenestacorigen", cdgoOrden);
		sqlquery.setParameter("ordenestacdestino", cdgoOrden_1);
		return sqlquery.getResultList();
	}

	public List<Tbasg128Estacline> getOrdenByEstacion(/** FIXME revisar tipo */
	Object cdgoLinea, /** FIXME revisar tipo */
	Object cdgoEstacion) {

		String sqlString = "select cdgo_orden " + "		from pasg.TBASG128_ESTACLINE "
				+ "		where cdgo_linea = :cdgolinea and cdgo_estacion = :estacion " + "		order by cdgo_orden";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);
		sqlquery.setParameter("cdgolinea", cdgoLinea);
		sqlquery.setParameter("estacion", cdgoEstacion);
		return sqlquery.getResultList();
	}

	public List<Tbasg128Estacline> getEntorLineOrdenOrigenDestino(String cdgoEntorno, String cdgoLinea) {

		String sqlString = "SELECT" + "				A.CDGO_PK AS PK_DESTINO," + "				B.CDGO_PK AS PK_ORIGEN,"
				+ "				A.DESG_NOMCORTO AS DESTINO," + "				B.DESG_NOMCORTO AS ORIGEN,"
				+ "				E.CDGO_ORIGEN, " + "				E.CDGO_DESTINO" + "			FROM "
				+ "				PASG.TBASG128_ESTACLINE B, " + "				PASG.TBASG128_ESTACLINE A, "
				+ "				PASG.TBASG130_ENTORLINE E" + "			WHERE "
				+ "				E.CDGO_ENTORNO = :cdgoEntorno" + "				AND E.CDGO_LINEA = :cdgoLinea"
				+ "				AND E.CDGO_ORIGEN = B.CDGO_ESTACION"
				+ "				AND E.CDGO_DESTINO = A.CDGO_ESTACION" + "				AND E.CDGO_LINEA = A.CDGO_LINEA"
				+ "				AND E.CDGO_LINEA = B.CDGO_LINEA" + "" + "				AND B.MRCA_ACTIVO = 'S'"
				+ "				AND A.MRCA_ACTIVO = 'S'" + "				AND E.MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);
		sqlquery.setParameter("cdgoEntorno", cdgoEntorno);
		sqlquery.setParameter("cdgoLinea", cdgoLinea);
		return sqlquery.getResultList();
	}

	public List<Tbasg128Estacline> getEstacLineList() {

		String sqlString = "SELECT DISTINCT CDGO_ESTACION,DESG_NOMLARGO FROM PASG.TBASG128_ESTACLINE ORDER BY DESG_NOMLARGO ASC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg128Estacline> getEstacLineCount() {

		String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG128_ESTACLINE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg128Estacline> getEstacLineCountByLine(String cdgoLinea) {

		String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG128_ESTACLINE WHERE CDGO_LINEA=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);
		sqlquery.setParameter("value", cdgoLinea);
		return sqlquery.getResultList();
	}

	public List<Tbasg128Estacline> getEstacLineCountByEstacion(String cdgoEstacion) {

		String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG128_ESTACLINE WHERE CDGO_ESTACION=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);
		sqlquery.setParameter("value", cdgoEstacion);
		return sqlquery.getResultList();
	}

	public List<Tbasg128EstaclineDto> getEstacLineListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG128_ESTACLINE ORDER BY DESG_NOMLARGO ASC";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg128EstaclineDto> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg128EstaclineDto estacline = new Tbasg128EstaclineDto();
			
			estacline.setCdgoLinea((String)object[0]);	
			estacline.setCdgoEstacion((String)object[1]);
			estacline.setCdgoOrden((Integer) object[2]);
			estacline.setCdgoPk(String.valueOf((java.math.BigDecimal) object[3]));
			estacline.setDesgNomcorto((String)object[4]);
			estacline.setDesgNomlargo((String)object[5]);
			estacline.setDesgUsuact((String)object[6]);
			estacline.setFchaAct((Date)object[7]);
			estacline.setMrcaActivo(String.valueOf((Character) object[8]));
			estacline.setDesgSoportedoc((String)object[9]);

			resultadosDevueltos.add(estacline);
		}
		return resultadosDevueltos;
	}
	
	public List<Tbasg128EstaclineDto> getEstacLineListAscCdgoLinea(String cdgoLinea) {

		String sqlString = "SELECT * FROM PASG.TBASG128_ESTACLINE WHERE CDGO_LINEA = :value ORDER BY CDGO_ORDEN ";
		
		Query sqlquery = em.createNativeQuery(sqlString);
		
		sqlquery.setParameter("value", cdgoLinea);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg128EstaclineDto> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg128EstaclineDto estacline = new Tbasg128EstaclineDto();
			
			estacline.setCdgoLinea((String)object[0]);	
			estacline.setCdgoEstacion((String)object[1]);
			estacline.setCdgoOrden((Integer) object[2]);
			estacline.setCdgoPk(String.valueOf((java.math.BigDecimal) object[3]));
			estacline.setDesgNomcorto((String)object[4]);
			estacline.setDesgNomlargo((String)object[5]);
			estacline.setDesgUsuact((String)object[6]);
			estacline.setFchaAct((Date)object[7]);
			estacline.setMrcaActivo(String.valueOf((Character) object[8]));
			estacline.setDesgSoportedoc((String)object[9]);

			resultadosDevueltos.add(estacline);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg128Estacline> getEstacLineListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG128_ESTACLINE ORDER BY DESG_NOMLARGO DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg128Estacline> getEstacLineActiveListAscendente() {

		String sqlString = "SELECT CDGO_ESTACION,CDGO_LINEA,CDGO_ORDEN,CDGO_PK,DESG_NOMCORTO,DESG_NOMLARGO,DESG_USUACT,FCHA_ACT,DESG_SOPORTEDOC,MRCA_ACTIVO FROM PASG.TBASG128_ESTACLINE WHERE MRCA_ACTIVO='S'"
				+ "            UNION"
				+ "            SELECT CDGO_ESTACION,CDGO_LINEA,CDGO_ORDEN,CDGO_PK,DESG_NOMCORTO,DESG_NOMLARGO,DESG_USUACT,FCHA_ACT,DESG_SOPORTEDOC,'S' AS MRCA_ACTIVO FROM PASG.TBASG182_ALTA_ESTACION ORDER BY CDGO_ORDEN";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg128Estacline> getEstacLineActiveListDescendente() {

		String sqlString = "SELECT CDGO_ESTACION,CDGO_LINEA,CDGO_ORDEN,CDGO_PK,DESG_NOMCORTO,DESG_NOMLARGO,DESG_USUACT,FCHA_ACT,DESG_SOPORTEDOC,MRCA_ACTIVO FROM PASG.TBASG128_ESTACLINE WHERE MRCA_ACTIVO='S' "
				+ "            UNION"
				+ "            SELECT CDGO_ESTACION,CDGO_LINEA,CDGO_ORDEN,CDGO_PK,DESG_NOMCORTO,DESG_NOMLARGO,DESG_USUACT,FCHA_ACT,DESG_SOPORTEDOC,'S' AS MRCA_ACTIVO FROM PASG.TBASG182_ALTA_ESTACION ORDER BY CDGO_ORDEN DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg128Estacline> getEstacLineMax(String cdgoLinea) {

		String sqlString = "SELECT * FROM PASG.TBASG128_ESTACLINE WHERE CDGO_LINEA=:value AND MRCA_ACTIVO = 'S' AND CDGO_PK IN "
				+ "            (SELECT MAX(CDGO_PK) FROM PASG.TBASG128_ESTACLINE WHERE CDGO_LINEA=:value AND MRCA_ACTIVO = 'S')";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoLinea);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg128Estacline> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			
			Tbasg128Estacline estacline = new Tbasg128Estacline();
			Tbasg128EstaclinePK estaclinePK = new Tbasg128EstaclinePK();
			
			estaclinePK.setCdgoLinea((String)object[0]);	
			estaclinePK.setCdgoEstacion((String)object[1]);
			estacline.setTbasg128estaclinepk(estaclinePK);
			estacline.setCdgoOrden((Integer) object[2]);
			estacline.setCdgoPk(String.valueOf((java.math.BigDecimal) object[3]));
			estacline.setDesgNomcorto((String)object[4]);
			estacline.setDesgNomlargo((String)object[5]);
			estacline.setDesgUsuact((String)object[6]);
			estacline.setFchaAct((Date)object[7]);
			estacline.setMrcaActivo(String.valueOf((Character) object[8]));
			estacline.setDesgSoportedoc((String)object[9]);

			resultadosDevueltos.add(estacline);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg128Estacline> getEstacLineMin(String cdgoLinea) {

		String sqlString = "SELECT * FROM PASG.TBASG128_ESTACLINE WHERE CDGO_LINEA=:value AND MRCA_ACTIVO = 'S' AND CDGO_PK IN "
				+ "            (SELECT MIN(CDGO_PK) FROM PASG.TBASG128_ESTACLINE WHERE CDGO_LINEA=:value AND MRCA_ACTIVO = 'S')";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoLinea);


		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg128Estacline> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			
			Tbasg128Estacline estacline = new Tbasg128Estacline();
			Tbasg128EstaclinePK estaclinePK = new Tbasg128EstaclinePK();
			
			estaclinePK.setCdgoLinea((String)object[0]);	
			estaclinePK.setCdgoEstacion((String)object[1]);
			estacline.setTbasg128estaclinepk(estaclinePK);
			estacline.setCdgoOrden((Integer) object[2]);
			estacline.setCdgoPk(String.valueOf((java.math.BigDecimal) object[3]));
			estacline.setDesgNomcorto((String)object[4]);
			estacline.setDesgNomlargo((String)object[5]);
			estacline.setDesgUsuact((String)object[6]);
			estacline.setFchaAct((Date)object[7]);
			estacline.setMrcaActivo(String.valueOf((Character) object[8]));
			estacline.setDesgSoportedoc((String)object[9]);

			resultadosDevueltos.add(estacline);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg128Estacline> getEstacLineMaxByOrden(String cdgoLinea) {

		String sqlString = "SELECT CDGO_ORDEN FROM PASG.TBASG128_ESTACLINE WHERE CDGO_LINEA=:value AND MRCA_ACTIVO = 'S' AND CDGO_ORDEN= "
				+ "            (SELECT MAX(CDGO_ORDEN) FROM PASG.TBASG128_ESTACLINE WHERE CDGO_LINEA=:value AND MRCA_ACTIVO = 'S')";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);
		sqlquery.setParameter("value", cdgoLinea);
		return sqlquery.getResultList();
	}

	public List<Tbasg128Estacline> getEstacLineMinByOrden(String cdgoLinea) {

		String sqlString = "SELECT CDGO_ORDEN FROM PASG.TBASG128_ESTACLINE WHERE CDGO_LINEA=:value AND MRCA_ACTIVO = 'S' AND CDGO_ORDEN IN "
				+ "            (SELECT MIN(CDGO_ORDEN) FROM PASG.TBASG128_ESTACLINE WHERE CDGO_LINEA=:value AND MRCA_ACTIVO = 'S')";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);
		sqlquery.setParameter("value", cdgoLinea);
		return sqlquery.getResultList();
	}

	public List<Tbasg128Estacline> getEstacLineListByLineDesc(String cdgoLinea) {

		String sqlString = "SELECT * FROM PASG.TBASG128_ESTACLINE WHERE CDGO_LINEA=:value ORDER BY CDGO_ORDEN DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);
		sqlquery.setParameter("value", cdgoLinea);
		return sqlquery.getResultList();
	}
	
	public List<Tbasg128Estacline> getEstacLineNombre(String cdgoLinea) {

		String sqlString = "SELECT CDGO_LINEA, DESG_NOMCORTO FROM PASG.TBASG128_ESTACLINE WHERE CDGO_LINEA=:value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoLinea);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg128Estacline> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			
			Tbasg128Estacline estacline = new Tbasg128Estacline();
			Tbasg128EstaclinePK estaclinePK = new Tbasg128EstaclinePK();
			
			estaclinePK.setCdgoLinea((String)object[0]);	
			estacline.setTbasg128estaclinepk(estaclinePK);
			estacline.setDesgNomcorto((String)object[1]);

			resultadosDevueltos.add(estacline);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg128Estacline> getEstacLine(String cdgoEstacion, String cdgoLinea) {

		String sqlString = "SELECT * FROM PASG.TBASG128_ESTACLINE WHERE CDGO_ESTACION=:cdgoEstacion AND CDGO_LINEA=:cdgoLinea";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);
		sqlquery.setParameter("cdgoEstacion", cdgoEstacion);
		sqlquery.setParameter("cdgoLinea", cdgoLinea);
		return sqlquery.getResultList();
	}

	public List<Tbasg128Estacline> getEstacLineTramoByPKAsc(String cdgoLinea, String cdgoOrigen, String cdgoDestino) {

		String sqlString = "SELECT * FROM PASG.TBASG128_ESTACLINE WHERE CDGO_LINEA=:codLinea  "
				+ "			AND CDGO_ORDEN  >= "
				+ "    			(SELECT MIN(CDGO_ORDEN) FROM PASG.TBASG128_ESTACLINE WHERE CDGO_LINEA=:codLinea AND ( CDGO_ESTACION=:codOrigen  OR CDGO_ESTACION=:codDestino))"
				+ "			AND CDGO_ORDEN  <= "
				+ "				(SELECT MAX(CDGO_ORDEN) FROM PASG.TBASG128_ESTACLINE WHERE CDGO_LINEA=:codLinea AND ( CDGO_ESTACION=:codOrigen  OR CDGO_ESTACION=:codDestino))"
				+ "			AND MRCA_ACTIVO = 'S'" + "			ORDER BY CDGO_ORDEN ASC";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("codLinea", cdgoLinea);
		sqlquery.setParameter("codOrigen", cdgoOrigen);
		sqlquery.setParameter("codDestino", cdgoDestino);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg128Estacline> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			
			Tbasg128Estacline estacline = new Tbasg128Estacline();
			Tbasg128EstaclinePK estaclinePK = new Tbasg128EstaclinePK();
			
			estaclinePK.setCdgoLinea((String)object[0]);	
			estaclinePK.setCdgoEstacion((String)object[1]);
			estacline.setTbasg128estaclinepk(estaclinePK);
			estacline.setCdgoOrden((Integer) object[2]);
			estacline.setCdgoPk(String.valueOf((java.math.BigDecimal) object[3]));
			estacline.setDesgNomcorto((String)object[4]);
			estacline.setDesgNomlargo((String)object[5]);
			estacline.setDesgUsuact((String)object[6]);
			estacline.setFchaAct((Date)object[7]);
			estacline.setMrcaActivo(String.valueOf((Character) object[8]));
			estacline.setDesgSoportedoc((String)object[9]);

			resultadosDevueltos.add(estacline);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg128Estacline> getEstacLineListByLineAsc(String cdgoLinea) {

		String sqlString = "SELECT * FROM PASG.TBASG128_ESTACLINE WHERE CDGO_LINEA=:value AND MRCA_ACTIVO = 'S' ORDER BY CDGO_ORDEN";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);
		sqlquery.setParameter("value", cdgoLinea);
		return sqlquery.getResultList();
	}

	public List<Tbasg128Estacline> getEstacLineListByEstacionAsc(String cdgoEstacion) {

		String sqlString = "SELECT * FROM PASG.TBASG128_ESTACLINE WHERE CDGO_ESTACION=:value AND MRCA_ACTIVO = 'S' ORDER BY CDGO_ORDEN";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);
		sqlquery.setParameter("value", cdgoEstacion);
		return sqlquery.getResultList();
	}

	public List<Tbasg128Estacline> getEstacLineListByEstacionDesc(String cdgoEstacion) {

		String sqlString = "SELECT * FROM PASG.TBASG128_ESTACLINE WHERE CDGO_ESTACION=:value ORDER BY CDGO_ORDEN DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);
		sqlquery.setParameter("value", cdgoEstacion);
		return sqlquery.getResultList();
	}

	public List<Tbasg128Estacline> getEstacLineListActive() {

		String sqlString = "SELECT DISTINCT CDGO_ESTACION,DESG_NOMLARGO FROM PASG.TBASG128_ESTACLINE  WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMLARGO ASC";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg128Estacline> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg128Estacline estaCline = new Tbasg128Estacline();
			Tbasg128EstaclinePK estaClinePK = new Tbasg128EstaclinePK();
			
			estaClinePK.setCdgoEstacion((String) object[0]);
			
			estaCline.setTbasg128estaclinepk(estaClinePK);
			estaCline.setDesgNomlargo((String)object[1]);

			resultadosDevueltos.add(estaCline);
		}
		return resultadosDevueltos;
	}

	public int insertEstacLine(Tbasg128Estacline bean) {

		String sqlString = "INSERT INTO PASG.TBASG128_ESTACLINE (CDGO_ESTACION, CDGO_LINEA, CDGO_ORDEN, CDGO_PK, DESG_NOMCORTO, DESG_NOMLARGO, DESG_USUACT, FCHA_ACT, DESG_SOPORTEDOC, MRCA_ACTIVO)"
				+ "            VALUES (?, ?, 0, ?, ?, ?, ?, CURRENT_DATE, ?, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);
		sqlquery.setParameter(1, bean.getTbasg128estaclinepk().getCdgoEstacion());
		sqlquery.setParameter(2, bean.getTbasg128estaclinepk().getCdgoLinea());
		sqlquery.setParameter(3, bean.getCdgoPk());
		sqlquery.setParameter(4, bean.getDesgNomcorto());
		sqlquery.setParameter(5, bean.getDesgNomlargo());
		sqlquery.setParameter(6, bean.getDesgUsuact());
		sqlquery.setParameter(7, bean.getDesgSoportedoc());
		sqlquery.setParameter(8, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateEstacLine(Tbasg128Estacline bean) {

		String sqlString = "UPDATE PASG.TBASG128_ESTACLINE SET CDGO_PK=:cdgoPK, DESG_NOMCORTO=:nomCorto, DESG_NOMLARGO=:nomLargo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE, DESG_SOPORTEDOC=:soporteDoc "
				+ "                  WHERE CDGO_ESTACION=:cdgoEstacion AND CDGO_LINEA=:cdgoLinea";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);
		sqlquery.setParameter("cdgoPK", bean.getCdgoPk());
		sqlquery.setParameter("nomCorto", bean.getDesgNomcorto());
		sqlquery.setParameter("nomLargo", bean.getDesgNomlargo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("soporteDoc", bean.getDesgSoportedoc());
		sqlquery.setParameter("cdgoEstacion", bean.getTbasg128estaclinepk().getCdgoEstacion());
		sqlquery.setParameter("cdgoLinea", bean.getTbasg128estaclinepk().getCdgoLinea());
		return sqlquery.executeUpdate();
	}
	
	public int estadoEstacLine(Tbasg128Estacline bean) {

		String sqlString = "UPDATE PASG.TBASG128_ESTACLINE SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE "
				+ "                  WHERE CDGO_ESTACION=:cdgoEstacion AND CDGO_LINEA=:cdgoLinea";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoEstacion", bean.getTbasg128estaclinepk().getCdgoEstacion());
		sqlquery.setParameter("cdgoLinea", bean.getTbasg128estaclinepk().getCdgoLinea());
		return sqlquery.executeUpdate();
	}

	public int deleteEstacLine(Tbasg128Estacline bean) {

		String sqlString = "UPDATE PASG.TBASG128_ESTACLINE SET MRCA_ACTIVO='N', DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE, DESG_SOPORTEDOC=:soporteDoc WHERE CDGO_ESTACION=:cdgoEstacion AND CDGO_LINEA=:cdgoLinea";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg128Estacline.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("soporteDoc", bean.getDesgSoportedoc());
		sqlquery.setParameter("cdgoEstacion", bean.getTbasg128estaclinepk().getCdgoEstacion());
		sqlquery.setParameter("cdgoLinea", bean.getTbasg128estaclinepk().getCdgoLinea());
		return sqlquery.executeUpdate();
	}

}

