package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.dto.GetEntorLineListAscendenteCDGO_ENTORNODTO;
import renfe.com.model.entity.Tbasg127Lineas;
import renfe.com.repository.Tbasg127LineasRepositoryCustom;

public class Tbasg127LineasRepositoryImpl implements Tbasg127LineasRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg127Lineas> getLineasCount() {

		String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG127_LINEAS";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg127Lineas.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg127Lineas> getLineasListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG127_LINEAS ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg127Lineas> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg127Lineas lineas = new Tbasg127Lineas();
			
			lineas.setCdgoLinea((String)object[0]);
			lineas.setDesgNombre((String)object[1]);
			lineas.setCdgoNumestaciones((Integer)object[2]);
			lineas.setDesgUsuact((String)object[3]);
			lineas.setFchaAct((Date)object[4]);
			lineas.setMrcaActivo((char)object[5]);
			lineas.setDesgSoportedoc((String)object[6]);

			resultadosDevueltos.add(lineas);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg127Lineas> getLineasListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG127_LINEAS ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg127Lineas.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg127Lineas> getLineasActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG127_LINEAS WHERE MRCA_ACTIVO='S' ORDER BY CDGO_LINEA";
		Query sqlquery = em.createNativeQuery(sqlString);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg127Lineas> resultadosDevueltos = new ArrayList<>();
		
		for (Object[] object : resultados) {
			Tbasg127Lineas lineas = new Tbasg127Lineas();
			
			lineas.setCdgoLinea((String)object[0]);
			lineas.setDesgNombre((String)object[1]);
			lineas.setCdgoNumestaciones((Integer)object[2]);
			lineas.setDesgUsuact((String)object[3]);
			lineas.setFchaAct((Date)object[4]);
			lineas.setMrcaActivo((char)object[5]);
			lineas.setDesgSoportedoc((String)object[6]);

			resultadosDevueltos.add(lineas);
		}
		return resultadosDevueltos;

	}

	public List<Tbasg127Lineas> getLineasActiveListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG127_LINEAS WHERE MRCA_ACTIVO='S' ORDER BY CDGO_LINEA DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg127Lineas.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg127Lineas> getLineas(String cdgoLinea) {

		String sqlString = "SELECT * FROM PASG.TBASG127_LINEAS WHERE CDGO_LINEA=:value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoLinea);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg127Lineas> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg127Lineas lineas = new Tbasg127Lineas();

			lineas.setCdgoLinea((String)object[0]);
			lineas.setDesgNombre((String)object[1]);
			lineas.setCdgoNumestaciones((Integer) object[2]);
			lineas.setDesgUsuact((String)object[3]);
			lineas.setFchaAct((Date) object[4]);
			lineas.setMrcaActivo((char) object[5]);

			resultadosDevueltos.add(lineas);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg127Lineas> getAlcanceLinea(String cdgoLinea) {

		String sqlString = "SELECT CONCAT(CDGO_LINEA,CONCAT(' (',CONCAT(RTRIM(DESG_NOMBRE),')'))) AS NOMBRE\n" +
				"\t\t  FROM PASG.TBASG127_LINEAS WHERE CDGO_LINEA = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoLinea);

		List<Object> resultados = sqlquery.getResultList();
		List<Tbasg127Lineas> resultadosDevueltos = new ArrayList<>();
		for (Object object : resultados) {
			Tbasg127Lineas lineas = new Tbasg127Lineas();

			lineas.setDesgNombre((String)object);

			resultadosDevueltos.add(lineas);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg127Lineas> getLineasListDynamic() {

		String sqlString = "SELECT * FROM PASG.TBASG127_LINEAS";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg127Lineas.class);

		return sqlquery.getResultList();
	}

	public int insertLineas(Tbasg127Lineas bean) {

		String sqlString = "INSERT INTO PASG.TBASG127_LINEAS (CDGO_LINEA, DESG_NOMBRE, CDGO_NUMESTACIONES, DESG_USUACT, FCHA_ACT, DESG_SOPORTEDOC, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, ?, ?, CURRENT_DATE, ?, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg127Lineas.class);
		sqlquery.setParameter(1, bean.getCdgoLinea());
		sqlquery.setParameter(2, bean.getDesgNombre());
		sqlquery.setParameter(3, bean.getCdgoNumestaciones());
		sqlquery.setParameter(4, bean.getDesgUsuact());
		sqlquery.setParameter(5, bean.getDesgSoportedoc());
		sqlquery.setParameter(6, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateLineas(Tbasg127Lineas bean) {

		String sqlString = "UPDATE PASG.TBASG127_LINEAS SET DESG_NOMBRE=?, DESG_USUACT=?, FCHA_ACT=CURRENT_DATE, DESG_SOPORTEDOC=?  WHERE CDGO_LINEA=?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg127Lineas.class);
		sqlquery.setParameter(1, bean.getDesgNombre());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getDesgSoportedoc());
		sqlquery.setParameter(4, bean.getCdgoLinea());
		return sqlquery.executeUpdate();
	}
	
	public int estadoLineas(Tbasg127Lineas bean) {

		String sqlString = "UPDATE PASG.TBASG127_LINEAS SET MRCA_ACTIVO=?, DESG_USUACT=?, FCHA_ACT=CURRENT_DATE WHERE CDGO_LINEA=?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg127Lineas.class);
		sqlquery.setParameter(1, bean.getMrcaActivo());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getCdgoLinea());
		return sqlquery.executeUpdate();
	}

	public int deleteLineas(Tbasg127Lineas bean) {

		String sqlString = "UPDATE PASG.TBASG127_LINEAS SET MRCA_ACTIVO='N', DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE, DESG_SOPORTEDOC=:soporteDoc WHERE CDGO_LINEA=:cdgoLinea";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg127Lineas.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("soporteDoc", bean.getDesgSoportedoc());
		sqlquery.setParameter("cdgoLinea", bean.getCdgoLinea());
		return sqlquery.executeUpdate();
	}

	public int reactiveLineas(Tbasg127Lineas bean) {

		String sqlString = "UPDATE PASG.TBASG127_LINEAS SET MRCA_ACTIVO='S', DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE, DESG_SOPORTEDOC=:soporteDoc WHERE CDGO_LINEA=:cdgoLinea";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg127Lineas.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("soporteDoc", bean.getDesgSoportedoc());
		sqlquery.setParameter("cdgoLinea", bean.getCdgoLinea());
		return sqlquery.executeUpdate();
	}

}
