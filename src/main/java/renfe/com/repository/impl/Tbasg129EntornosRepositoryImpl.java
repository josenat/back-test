package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import renfe.com.model.entity.Tbasg100Persona;

import renfe.com.dto.GetMaxEstadoHabilitaListDTO;

import renfe.com.model.entity.Tbasg129Entornos;
import renfe.com.repository.Tbasg129EntornosRepositoryCustom;

public class Tbasg129EntornosRepositoryImpl implements Tbasg129EntornosRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg129Entornos> getEntornosCount() {

		String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG129_ENTORNOS";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg129Entornos.class);

		return sqlquery.getResultList();
	}
	
	public List<Tbasg129Entornos> getEntornosList() {

		String sqlString = "SELECT * FROM PASG.TBASG129_ENTORNOS";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg129Entornos> resultadosDevueltos = new ArrayList<>();
		
		for(Object[] object : resultados) {
			Tbasg129Entornos data = new Tbasg129Entornos();
			if(object[0]!=null) {
				data.setCdgoEntorno((Integer)object[0]);
			}
			if(object[1]!=null) {
				data.setCdgoAreact((Integer)object[1]);
			}
			if(object[2]!=null) {
				data.setDesgNomcorto((String)object[2]);
			}
			if(object[3]!=null) {
				data.setDesgNomentorno((String)object[3]);
			}
			if(object[4]!=null) {
				data.setDesgUsuact((String)object[4]);
			}
			if(object[5]!=null) {
				data.setFchaAct((Date)object[5]);
			}
			if(object[6]!=null) {
				data.setMrcaActivo((char)object[6]);
			}

			resultadosDevueltos.add(data);
		}

		return resultadosDevueltos;
	}

	public List<Tbasg129Entornos> getEntornosListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG129_ENTORNOS ORDER BY DESG_NOMCORTO ASC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg129Entornos.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg129Entornos> getEntornosListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG129_ENTORNOS ORDER BY DESG_NOMCORTO DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg129Entornos.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg129Entornos> getEntornosActiveListAscendente(String nombreLargo) {
		
		StringBuilder strGetEntornosActiveListAscendente = new StringBuilder();

		String sqlString = "SELECT * FROM PASG.TBASG129_ENTORNOS WHERE MRCA_ACTIVO='S' ORDER BY";
		
		strGetEntornosActiveListAscendente.append(sqlString);
		System.out.println("----------------------");
		System.out.println(strGetEntornosActiveListAscendente.toString());
		System.out.println("----------------------");
		
		if(nombreLargo != null) {
			strGetEntornosActiveListAscendente.append(" DESG_NOMENTORNO ASC");
		}else {
			strGetEntornosActiveListAscendente.append(" DESG_NOMCORTO ASC");
		}
		
		Query sqlquery = em.createNativeQuery(strGetEntornosActiveListAscendente.toString());
		List<Object[]> resultados = sqlquery.getResultList();
		
		List<Tbasg129Entornos> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg129Entornos entorno = new Tbasg129Entornos();
			entorno.setCdgoEntorno((Integer)object[0]);
			entorno.setDesgNomcorto((String)object[1]);
			entorno.setDesgNomentorno((String)object[2]);
			entorno.setDesgUsuact((String)object[3]);
			entorno.setFchaAct((Date)object[4]);
			entorno.setMrcaActivo((char)object[5]);
			entorno.setCdgoAreact((Integer)object[6]);

			resultadosDevueltos.add(entorno);
		}
		return resultadosDevueltos;

	}

	public List<Tbasg129Entornos> getEntornosActiveListDescendente(String nombreLargo) {

		StringBuilder strGetEntornosActiveListAscendente = new StringBuilder();

		String sqlString = "SELECT * FROM PASG.TBASG129_ENTORNOS WHERE MRCA_ACTIVO='S' ORDER BY";
		
		strGetEntornosActiveListAscendente.append(sqlString);
		System.out.println("----------------------");
		System.out.println(strGetEntornosActiveListAscendente.toString());
		System.out.println("----------------------");
		
		if(nombreLargo != null) {
			strGetEntornosActiveListAscendente.append(" DESG_NOMENTORNO DESC");
		}else {
			strGetEntornosActiveListAscendente.append(" DESG_NOMCORTO DESC");
		}
		
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		
		List<Tbasg129Entornos> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg129Entornos entorno = new Tbasg129Entornos();
			entorno.setCdgoEntorno((Integer)object[0]);
			entorno.setCdgoAreact((Integer)object[1]);
			entorno.setDesgNomcorto((String)object[2]);
			entorno.setDesgNomentorno((String)object[4]);
			entorno.setDesgUsuact((String)object[5]);
			entorno.setFchaAct((Date)object[6]);
			entorno.setMrcaActivo((char)object[7]);

			resultadosDevueltos.add(entorno);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg129Entornos> getEntornosActiveWithTramosListAscendente() {

		String sqlString = "SELECT DISTINCT A.* FROM PASG.TBASG129_ENTORNOS A, PASG.TBASG130_ENTORLINE B WHERE A.CDGO_ENTORNO = B.CDGO_ENTORNO AND A.MRCA_ACTIVO = 'S' AND "
				+ "		B.MRCA_ACTIVO = 'S' ORDER BY";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg129Entornos.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg129Entornos> getEntornosActiveWithTramosListDescendente() {

		String sqlString = "SELECT DISTINCT A.* FROM PASG.TBASG129_ENTORNOS A, PASG.TBASG130_ENTORLINE B WHERE A.CDGO_ENTORNO = B.CDGO_ENTORNO AND A.MRCA_ACTIVO = 'S' AND "
				+ "		B.MRCA_ACTIVO = 'S' ORDER BY";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg129Entornos.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg129Entornos> getEntornos(Integer cdgoEntorno) {

		String sqlString = "SELECT * FROM PASG.TBASG129_ENTORNOS WHERE CDGO_ENTORNO=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg129Entornos.class);
		sqlquery.setParameter("value", cdgoEntorno);
		return sqlquery.getResultList();
	}

	public List<Tbasg129Entornos> getAlcanceEntorno(Integer cdgoEntorno) {

		String sqlString = "SELECT DESG_NOMCORTO FROM PASG.TBASG129_ENTORNOS WHERE CDGO_ENTORNO =:value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoEntorno);

		List<Object> resultados = sqlquery.getResultList();
		List<Tbasg129Entornos> resultadosDevueltos = new ArrayList<>();
		for (Object object : resultados) {
			Tbasg129Entornos entornos = new Tbasg129Entornos();

			entornos.setDesgNomcorto((String)object);

			resultadosDevueltos.add(entornos);
		}
		return resultadosDevueltos;
	}
	
	public List<Tbasg129Entornos> getEntornosNombre(String cdgoEntorno) {

		String sqlString = "SELECT CDGO_ENTORNO , DESG_NOMCORTO FROM PASG.TBASG129_ENTORNOS WHERE CDGO_ENTORNO=:value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoEntorno);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg129Entornos> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg129Entornos entornos = new Tbasg129Entornos();
	
			entornos.setCdgoEntorno((Integer)object[0]);
			entornos.setDesgNomcorto((String)object[1]);

			resultadosDevueltos.add(entornos);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg129Entornos> getEntornosByNomCorto(String desgNomcorto) {

		String sqlString = "SELECT * FROM PASG.TBASG129_ENTORNOS WHERE DESG_NOMCORTO=:value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", desgNomcorto);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg129Entornos> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg129Entornos entornos = new Tbasg129Entornos();

			entornos.setCdgoEntorno((Integer) object[0]);
			entornos.setDesgNomcorto((String)object[1]);
			entornos.setDesgNomentorno((String)object[2]);
			entornos.setDesgUsuact((String)object[3]);
			entornos.setFchaAct((Date) object[4]);
			entornos.setMrcaActivo((char) object[5]);
			entornos.setCdgoAreact((Integer) object[6]);

			resultadosDevueltos.add(entornos);
		}
		return resultadosDevueltos;
	}

	public int insertEntornos(Tbasg129Entornos bean) {

		String sqlString = "INSERT INTO PASG.TBASG129_ENTORNOS (DESG_NOMCORTO, DESG_NOMENTORNO, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, ?, CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg129Entornos.class);
		sqlquery.setParameter(1, bean.getDesgNomcorto());
		sqlquery.setParameter(2, bean.getDesgNomentorno());
		sqlquery.setParameter(3, bean.getDesgUsuact());
		sqlquery.setParameter(4, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateEntornos(Tbasg129Entornos bean) {

		String sqlString = "UPDATE PASG.TBASG129_ENTORNOS SET DESG_NOMCORTO=:nomCorto, DESG_NOMENTORNO=:nomEntorno, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE  WHERE CDGO_ENTORNO=:cdgoEntorno";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg129Entornos.class);
		sqlquery.setParameter("nomCorto", bean.getDesgNomcorto());
		sqlquery.setParameter("nomEntorno", bean.getDesgNomentorno());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoEntorno", bean.getCdgoEntorno());
		return sqlquery.executeUpdate();
	}

}

