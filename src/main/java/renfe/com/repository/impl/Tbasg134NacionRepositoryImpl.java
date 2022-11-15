package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg134Nacion;
import renfe.com.repository.Tbasg134NacionRepositoryCustom;

public class Tbasg134NacionRepositoryImpl implements Tbasg134NacionRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg134Nacion> getNacionCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG134_NACION";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg134Nacion.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg134Nacion> getNacionListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG134_NACION ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg134Nacion> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg134Nacion nacion = new Tbasg134Nacion();
			
			nacion.setCdgoNacion(Long.valueOf((int)object[0]));
			nacion.setCdgoSap((String)object[1]);
			nacion.setDesgNombre((String)object[2]);
			nacion.setDesgUsuact((String)object[3]);
			nacion.setFchaAct((Date) object[4]);
			nacion.setMrcaActivo(String.valueOf((java.lang.Character) object[5]));

			resultadosDevueltos.add(nacion);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg134Nacion> getNacionListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG134_NACION ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg134Nacion.class);

		return sqlquery.getResultList();
	}

	/*public List<Tbasg134Nacion> getNacionActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG134_NACION WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg134Nacion.class);

		return sqlquery.getResultList();
	}*/
	
	public List<Tbasg134Nacion> getNacionActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG134_NACION WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg134Nacion> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg134Nacion nacion = new Tbasg134Nacion();

			nacion.setCdgoNacion(Long.valueOf((int)object[0]));
			nacion.setCdgoSap((String)object[1]);
			nacion.setDesgNombre((String)object[2]);
			nacion.setDesgUsuact((String)object[3]);
			nacion.setFchaAct((Date) object[4]);
			nacion.setMrcaActivo(String.valueOf((java.lang.Character) object[5]));

			resultadosDevueltos.add(nacion);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg134Nacion> getNacionActiveListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG134_NACION WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg134Nacion.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg134Nacion> getNacion(String cdgoNacion) {

		String sqlString = "SELECT * FROM PASG.TBASG134_NACION WHERE CDGO_NACION=:value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoNacion);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg134Nacion> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg134Nacion nacion = new Tbasg134Nacion();
		
			nacion.setCdgoNacion(Long.valueOf((int)object[0]));
			nacion.setCdgoSap((String)object[1]);
			nacion.setDesgNombre((String)object[2]);
			nacion.setDesgUsuact((String) object[3]);
			nacion.setFchaAct((Date) object[4]);
			nacion.setMrcaActivo(String.valueOf((java.lang.Character) object[5]));

			resultadosDevueltos.add(nacion);
		}
		return resultadosDevueltos;
	}

	public int insertNacion(Tbasg134Nacion bean) {

		String sqlString = "INSERT INTO PASG.TBASG134_NACION (CDGO_SAP, DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO) VALUES (?,?,?,CURRENT_DATE,?);";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg134Nacion.class);
		sqlquery.setParameter(1, bean.getCdgoSap());
		sqlquery.setParameter(2, bean.getDesgNombre());
		sqlquery.setParameter(3, bean.getDesgUsuact());
		sqlquery.setParameter(4, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateNacion(Tbasg134Nacion bean) {

		String sqlString = "UPDATE PASG.TBASG134_NACION SET CDGO_SAP=:cdgoSap, DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_NACION=:cdgoNacion";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg134Nacion.class);
		sqlquery.setParameter("cdgoSap", bean.getCdgoSap());
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoNacion", bean.getCdgoNacion());
		return sqlquery.executeUpdate();
	}
	
	public int estadoNacion(Tbasg134Nacion bean) {

		String sqlString = "UPDATE PASG.TBASG134_NACION SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_NACION=:cdgoNacion";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg134Nacion.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoNacion", bean.getCdgoNacion());
		return sqlquery.executeUpdate();
	}

}
