package renfe.com.repository.impl;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg131Alcanceot;
import renfe.com.model.entity.Tbasg199DatConf;
import renfe.com.repository.Tbasg131AlcanceotRepositoryCustom;

public class Tbasg131AlcanceotRepositoryImpl implements Tbasg131AlcanceotRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg131Alcanceot> getAlcanceOtCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG131_ALCANCEOT";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg131Alcanceot.class);

		return sqlquery.getResultList();
	}
	
	public List<Tbasg131Alcanceot> getAlcanceOtList() {

		String sqlString = "SELECT * FROM PASG.TBASG131_ALCANCEOT";
		
		Query sqlquery = em.createNativeQuery(sqlString); 
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg131Alcanceot> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg131Alcanceot area = new Tbasg131Alcanceot();

			area.setCdgoAlcanceot((Integer)object[0]);
			area.setDesgNombre((String)object[1]);
			area.setDesgUsuact((String)object[2]);
			area.setFchaAct((Date)object[3]);
			area.setMrcaActivo((String)object[4]);

			resultadosDevueltos.add(area);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg131Alcanceot> getAlcanceOtListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG131_ALCANCEOT ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg131Alcanceot> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg131Alcanceot alcanceOt = new Tbasg131Alcanceot();
			
			alcanceOt.setCdgoAlcanceot((Integer)object[0]);
			alcanceOt.setDesgNombre((String)object[1]);
			alcanceOt.setDesgUsuact((String)object[2]);
			alcanceOt.setFchaAct((Date) object[3]);
			alcanceOt.setMrcaActivo(String.valueOf((Character) object[4]));

			resultadosDevueltos.add(alcanceOt);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg131Alcanceot> getAlcanceOtListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG131_ALCANCEOT ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg131Alcanceot.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg131Alcanceot> getAlcanceOt(Integer cdgoAlcanceot) {

		String sqlString = "SELECT * FROM PASG.TBASG131_ALCANCEOT WHERE CDGO_ALCANCEOT=:value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoAlcanceot);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg131Alcanceot> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg131Alcanceot alcanceOt = new Tbasg131Alcanceot();

			alcanceOt.setCdgoAlcanceot((Integer)object[0]);
			alcanceOt.setDesgNombre((String)object[1]);
			alcanceOt.setDesgUsuact((String)object[2]);
			alcanceOt.setFchaAct((Date) object[3]);
			alcanceOt.setMrcaActivo(String.valueOf((Character) object[4]));

			resultadosDevueltos.add(alcanceOt);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg131Alcanceot> getAlcanceOtInfSer(Integer cdgoAlcanceot) {

		String sqlString = "SELECT DESG_NOMBRE FROM PASG.TBASG131_ALCANCEOT WHERE CDGO_ALCANCEOT=:value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoAlcanceot);
		List<Object> resultados = sqlquery.getResultList();
		List<Tbasg131Alcanceot> resultadosDevueltos = new ArrayList<>();
		for (Object object : resultados) {
			Tbasg131Alcanceot alcanceot = new Tbasg131Alcanceot();

			alcanceot.setDesgNombre((String)object);

			resultadosDevueltos.add(alcanceot);
		}
		return resultadosDevueltos;
	}
	
	public List<Tbasg131Alcanceot> getAlcanceOtNombre(String cdgoAlcanceot) {

		String sqlString = "SELECT CDGO_ALCANCEOT, DESG_NOMBRE FROM PASG.TBASG131_ALCANCEOT WHERE CDGO_ALCANCEOT=:value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoAlcanceot);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg131Alcanceot> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg131Alcanceot alcanceot = new Tbasg131Alcanceot();

			alcanceot.setCdgoAlcanceot((Integer)object[0]);
			alcanceot.setDesgNombre((String)object[1]);

			resultadosDevueltos.add(alcanceot);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg131Alcanceot> getAlcanceOtActiveList() {

		String sqlString = "SELECT * FROM PASG.TBASG131_ALCANCEOT WHERE MRCA_ACTIVO='S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg131Alcanceot.class);

		return sqlquery.getResultList();
	}

	public int insertAlcanceOt(Tbasg131Alcanceot bean) {

		String sqlString = "INSERT INTO PASG.TBASG131_ALCANCEOT (DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO) VALUES (?,?,CURRENT_DATE,?);";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg131Alcanceot.class);
		sqlquery.setParameter(1, bean.getDesgNombre());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateAlcanceOt(Tbasg131Alcanceot bean) {

		String sqlString = "UPDATE PASG.TBASG131_ALCANCEOT SET DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_ALCANCEOT=:cdgoAlcanceOt";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg131Alcanceot.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoAlcanceOt", bean.getCdgoAlcanceot());
		return sqlquery.executeUpdate();
	}
	
	public int estadoAlcanceOt(Tbasg131Alcanceot bean) {

		String sqlString = "UPDATE PASG.TBASG131_ALCANCEOT SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_ALCANCEOT=:cdgoAlcanceOt";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg131Alcanceot.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoAlcanceOt", bean.getCdgoAlcanceot());
		return sqlquery.executeUpdate();
	}

}