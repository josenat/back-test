package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg129Entornos;
import renfe.com.model.entity.Tbasg133Serie;
import renfe.com.repository.Tbasg133SerieRepositoryCustom;

public class Tbasg133SerieRepositoryImpl implements Tbasg133SerieRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg133Serie> getSerieCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG133_SERIE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg133Serie.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg133Serie> getSerieList() {

		String sqlString = "SELECT * FROM PASG.TBASG133_SERIE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg133Serie> resultadosDevueltos = new ArrayList<>();
		
		for(Object[] object : resultados) {
			Tbasg133Serie data = new Tbasg133Serie();
			if(object[0]!=null) {
				data.setCdgoSerie((String)object[0]);
			}
			if(object[1]!=null) {
				data.setDesgNombre((String)object[1]);
			}
			if(object[2]!=null) {
				data.setDesgUsuact((String)object[2]);
			}
			if(object[3]!=null) {
				data.setFchaAct((Date)object[3]);
			}
			if(object[4]!=null) {
				data.setMrcaActivo((String)object[4]);
			}

			resultadosDevueltos.add(data);
		}

		return resultadosDevueltos;
	}
	
	public List<Tbasg133Serie> getSerieListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG133_SERIE ORDER BY CDGO_SERIE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg133Serie> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg133Serie serie = new Tbasg133Serie();
			
			serie.setCdgoSerie((String)object[0]);
			serie.setDesgNombre((String)object[1]);
			serie.setDesgUsuact((String)object[2]);
			serie.setFchaAct((Date) object[3]);
			serie.setMrcaActivo(String.valueOf((Character) object[4]));

			resultadosDevueltos.add(serie);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg133Serie> getSerieListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG133_SERIE ORDER BY CDGO_SERIE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg133Serie.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg133Serie> getSerie(String cdgoSerie) {

		String sqlString = "SELECT * FROM PASG.TBASG133_SERIE WHERE CDGO_SERIE=:value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoSerie);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg133Serie> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg133Serie serie = new Tbasg133Serie();

			serie.setCdgoSerie((String)object[0]);
			serie.setDesgNombre((String)object[1]);
			serie.setDesgUsuact((String)object[2]);
			serie.setFchaAct((Date) object[3]);
			serie.setMrcaActivo(String.valueOf((Character) object[4]));

			resultadosDevueltos.add(serie);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg133Serie> getSerieNombre(String cdgoSerie) {

		String sqlString = "SELECT CDGO_SERIE , DESG_NOMBRE FROM PASG.TBASG133_SERIE WHERE CDGO_SERIE=:value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoSerie);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg133Serie> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg133Serie serie = new Tbasg133Serie();
			
			//serie.setCdgoSerie(Long.valueOf((int)object[0]));
			serie.setCdgoSerie((String)object[0]);
			serie.setDesgNombre((String)object[1]);

			resultadosDevueltos.add(serie);
		}
		return resultadosDevueltos;
	}
	
	public List<Tbasg133Serie> getSerieByNombre(/** FIXME revisar tipo */ Object nombre) {

		String sqlString = "SELECT CDGO_SERIE FROM PASG.TBASG133_SERIE WHERE NOMBRE=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg133Serie.class);
		sqlquery.setParameter("value", nombre);
		return sqlquery.getResultList();
	}


	public List<Tbasg133Serie> getSerieListActive() {

		String sqlString = "SELECT * FROM PASG.TBASG133_SERIE WHERE MRCA_ACTIVO='S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg133Serie.class);

		return sqlquery.getResultList();
	}
	
	public List<Tbasg133Serie> getSerieActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG133_SERIE WHERE MRCA_ACTIVO='S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg133Serie> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg133Serie serie = new Tbasg133Serie();
			
			serie.setCdgoSerie((String)object[0]);
			serie.setDesgNombre((String)object[1]);
			serie.setDesgUsuact((String)object[2]);
			serie.setFchaAct((Date) object[3]);
			serie.setMrcaActivo(String.valueOf((Character) object[4]));

			resultadosDevueltos.add(serie);
		}
		return resultadosDevueltos;
	}

	public int insertSerie(Tbasg133Serie bean) {

		String sqlString = "INSERT INTO PASG.TBASG133_SERIE (CDGO_SERIE, DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO) VALUES (?,?,?,CURRENT_DATE,?);";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg133Serie.class);
		sqlquery.setParameter(1, bean.getCdgoSerie());
		sqlquery.setParameter(2, bean.getDesgNombre());
		sqlquery.setParameter(3, bean.getDesgUsuact());
		sqlquery.setParameter(4, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateSerie(Tbasg133Serie bean) {

		String sqlString = "UPDATE PASG.TBASG133_SERIE SET DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_SERIE=:cdgoSerie";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg133Serie.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoSerie", bean.getCdgoSerie());
		return sqlquery.executeUpdate();
	}
	
	public int estadoSerie(Tbasg133Serie bean) {

		String sqlString = "UPDATE PASG.TBASG133_SERIE SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_SERIE=:cdgoSerie";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg133Serie.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoSerie", bean.getCdgoSerie());
		return sqlquery.executeUpdate();
	}

}


