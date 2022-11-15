package renfe.com.repository.impl;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg137Especiali;
import renfe.com.model.entity.Tbasg199DatConf;
import renfe.com.repository.Tbasg137EspecialiRepositoryCustom;

public class Tbasg137EspecialiRepositoryImpl implements Tbasg137EspecialiRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg137Especiali> getEspecialiCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG137_ESPECIALI";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg137Especiali.class);

		return sqlquery.getResultList();
	}
	
	public List<Tbasg137Especiali> getEspecialiList() {

		String sqlString = "SELECT * FROM PASG.TBASG137_ESPECIALI";
		
		Query sqlquery = em.createNativeQuery(sqlString); 
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg137Especiali> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg137Especiali area = new Tbasg137Especiali();

			area.setCdgoEspec((Long)object[0]);
			area.setDesgNombre((String)object[1]);
			area.setDesgUsuact((String)object[2]);
			area.setFchaAct((Date)object[3]);
			area.setMrcaActivo((String)object[4]);

		resultadosDevueltos.add(area);
		}
		return resultadosDevueltos;

	}

	public List<Tbasg137Especiali> getEspecialiListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG137_ESPECIALI ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg137Especiali> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg137Especiali especiali = new Tbasg137Especiali();
			
			especiali.setCdgoEspec(Long.valueOf((int)object[0]));
			especiali.setDesgNombre((String)object[1]);
			especiali.setDesgUsuact((String)object[2]);
			especiali.setFchaAct((Date) object[3]);
			especiali.setMrcaActivo(String.valueOf((Character) object[4]));

			resultadosDevueltos.add(especiali);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg137Especiali> getEspecialiListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG137_ESPECIALI ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg137Especiali.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg137Especiali> getEspeciali(Integer cdgoEspec) {

		String sqlString = "SELECT * FROM PASG.TBASG137_ESPECIALI WHERE CDGO_ESPEC=:value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoEspec);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg137Especiali> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg137Especiali especiali = new Tbasg137Especiali();

			especiali.setCdgoEspec(Long.valueOf((int)object[0]));
			especiali.setDesgNombre((String)object[1]);
			especiali.setDesgUsuact((String)object[2]);
			especiali.setFchaAct((Date) object[3]);
			especiali.setMrcaActivo(String.valueOf((Character) object[4]));

			resultadosDevueltos.add(especiali);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg137Especiali> getAlcanceEspeciali(Integer cdgoEspec) {

		String sqlString = "SELECT DESG_NOMBRE FROM PASG.TBASG137_ESPECIALI WHERE CDGO_ESPEC = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoEspec);

		List<Object> resultados = sqlquery.getResultList();
		List<Tbasg137Especiali> resultadosDevueltos = new ArrayList<>();
		for (Object object : resultados) {
			Tbasg137Especiali especiali = new Tbasg137Especiali();

			especiali.setDesgNombre((String)object);

			resultadosDevueltos.add(especiali);
		}
		return resultadosDevueltos;
	}
	
	public List<Tbasg137Especiali> getEspecialiNombre(String cdgoEspec) {

		String sqlString = "SELECT CDGO_ESPEC, DESG_NOMBRE FROM PASG.TBASG137_ESPECIALI WHERE CDGO_ESPEC=:value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoEspec);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg137Especiali> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg137Especiali especiali = new Tbasg137Especiali();
	
			especiali.setCdgoEspec(Long.valueOf((int)object[0]));
			especiali.setDesgNombre((String)object[1]);

			resultadosDevueltos.add(especiali);
		}
		return resultadosDevueltos;
	}


	public List<Tbasg137Especiali> getEspecialiActiveList() {

		String sqlString = "SELECT * FROM PASG.TBASG137_ESPECIALI WHERE MRCA_ACTIVO='S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg137Especiali.class);

		return sqlquery.getResultList();
	}

	public int insertEspeciali(Tbasg137Especiali bean) {

		String sqlString = "INSERT INTO PASG.TBASG137_ESPECIALI (DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO) VALUES (?,?,CURRENT_DATE,?);";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg137Especiali.class);
		sqlquery.setParameter(1, bean.getDesgNombre());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateEspeciali(Tbasg137Especiali bean) {

		String sqlString = "UPDATE PASG.TBASG137_ESPECIALI SET DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_ESPEC=:cdgoEspec";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg137Especiali.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoEspec", bean.getCdgoEspec());
		return sqlquery.executeUpdate();
	}
	
	public int estadoEspeciali(Tbasg137Especiali bean) {

		String sqlString = "UPDATE PASG.TBASG137_ESPECIALI SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_ESPEC=:cdgoEspec";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg137Especiali.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoEspec", bean.getCdgoEspec());
		return sqlquery.executeUpdate();
	}

}