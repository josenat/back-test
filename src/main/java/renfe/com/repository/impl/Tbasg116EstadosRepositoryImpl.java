package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg116Estados;
import renfe.com.model.entity.Tbasg132Centcont;
import renfe.com.repository.Tbasg116EstadosRepositoryCustom;

public class Tbasg116EstadosRepositoryImpl implements Tbasg116EstadosRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg116Estados> getEstadosList() {

		String sqlString = "SELECT * FROM PASG.TBASG116_ESTADOS ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg116Estados.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg116Estados> getEstadosHabilitacionListActive() {

		String sqlString = "SELECT * FROM PASG.TBASG116_ESTADOS WHERE MRCA_ACTIVO='S' AND DESG_NOMBRE \r\n"
				+ "NOT IN ('ABIERTO', 'CERRADO', 'VIGENTE', 'CONFIRMADO', \r\n"
				+ "'PROPUESTA_OTORGAMIENTO', 'PROPUESTA_RESOLUCION', 'REVOCADO', \r\n"
				+ "'TRAMITACION', 'PENDIENTE_CONFIRMAR') ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg116Estados> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg116Estados area = new Tbasg116Estados();

			area.setCdgoEstado((int)object[0]);
			area.setDesgNombre((String)object[1]);
			area.setDesgUsuact((String)object[2]);
			area.setFchaAct((Date)object[3]);
			area.setMrcaActivo((char)object[4]);
		
			resultadosDevueltos.add(area);
		}
		return resultadosDevueltos;

	}
	
	public List<Tbasg116Estados> getEstadosConduccionListActive() {

		String sqlString = "SELECT * FROM PASG.TBASG116_ESTADOS WHERE MRCA_ACTIVO='S' AND DESG_NOMBRE \r\n"
				+ "IN ('VIGENTE', 'SUSPENDIDO', 'REACTIVADO', 'RENOVADO') \r\n"
				+ "ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg116Estados> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg116Estados area = new Tbasg116Estados();

			area.setCdgoEstado((int)object[0]);
			area.setDesgNombre((String)object[1]);
			area.setDesgUsuact((String)object[2]);
			area.setFchaAct((Date)object[3]);
			area.setMrcaActivo((char)object[4]);
		
			resultadosDevueltos.add(area);
		}
		return resultadosDevueltos;

	}
	
	public List<Tbasg116Estados> getEstadosListActive() {
		String sqlString = "SELECT * FROM PASG.TBASG116_ESTADOS WHERE MRCA_ACTIVO='S' AND DESG_NOMBRE NOT IN ('CERRADO','TRAMITACION') ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg116Estados> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg116Estados estados = new Tbasg116Estados();

			estados.setCdgoEstado((Integer)object[0]);
			estados.setDesgNombre((String)object[1]);
			estados.setDesgUsuact((String)object[2]);
			estados.setFchaAct((Date) object[3]);
			estados.setMrcaActivo((char) object[4]);

			resultadosDevueltos.add(estados);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg116Estados> getActiveStatusListForDriving() {

		String sqlString = "SELECT * FROM PASG.TBASG116_ESTADOS WHERE MRCA_ACTIVO='S' AND CDGO_ESTADO NOT IN (8, 9, 10, 11) ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg116Estados> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg116Estados estados = new Tbasg116Estados();

			estados.setCdgoEstado(Integer.valueOf((int)object[0]));
			estados.setDesgNombre((String)object[1]);
			estados.setDesgUsuact((String)object[2]);
			estados.setFchaAct((Date) object[3]);
			estados.setMrcaActivo((java.lang.Character) object[4]);

			resultadosDevueltos.add(estados);
		}
		return resultadosDevueltos;
	}	

	public List<Tbasg116Estados> getEstado(Integer cdgoEstado) {

		String sqlString = "SELECT DESG_NOMBRE FROM PASG.TBASG116_ESTADOS WHERE CDGO_ESTADO = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoEstado);
		List<Object> resultados = sqlquery.getResultList();
		List<Tbasg116Estados> resultadosDevueltos = new ArrayList<>();
		for (Object object : resultados) {
			Tbasg116Estados estados = new Tbasg116Estados();

			estados.setDesgNombre((String)object);
		
			resultadosDevueltos.add(estados);
		}
		return resultadosDevueltos;
	}

}
