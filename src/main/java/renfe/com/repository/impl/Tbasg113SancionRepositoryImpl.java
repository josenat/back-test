package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg113Sancion;
import renfe.com.repository.Tbasg113SancionRepositoryCustom;

public class Tbasg113SancionRepositoryImpl implements Tbasg113SancionRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg113Sancion> getSancionCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG113_SANCION";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg113Sancion.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg113Sancion> getSancionActiveCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG113_SANCION WHERE MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg113Sancion.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg113Sancion> getSancionListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG113_SANCION ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg113Sancion> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg113Sancion sancion = new Tbasg113Sancion();
			
			sancion.setCdgoSancion(Long.valueOf((Integer)object[0]));
			sancion.setDesgNombre((String)object[1]);
			sancion.setDesgUsuact((String)object[2]);
			sancion.setFchaAct((Date) object[3]);
			sancion.setMrcaActivo(String.valueOf((Character) object[4]));

			resultadosDevueltos.add(sancion);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg113Sancion> getSancionListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG113_SANCION ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg113Sancion.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg113Sancion> getSancionActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG113_SANCION WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg113Sancion.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg113Sancion> getSancionActiveListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG113_SANCION WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg113Sancion.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg113Sancion> getSancion(String cdgoSancion) {

		String sqlString = "SELECT * FROM PASG.TBASG113_SANCION WHERE CDGO_SANCION=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg113Sancion.class);
		sqlquery.setParameter("value", cdgoSancion);
		return sqlquery.getResultList();
	}

	public int insertSancion(Tbasg113Sancion bean) {

		String sqlString = "INSERT INTO PASG.TBASG113_SANCION (DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO) VALUES (?,?,CURRENT_DATE,?);";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg113Sancion.class);
		sqlquery.setParameter(1, bean.getDesgNombre());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateSancion(Tbasg113Sancion bean) {

		String sqlString = "UPDATE PASG.TBASG113_SANCION SET DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_SANCION=:cdgoSancion";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg113Sancion.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoSancion", bean.getCdgoSancion());
		return sqlquery.executeUpdate();
	}
	
	public int estadoSancion(Tbasg113Sancion bean) {

		String sqlString = "UPDATE PASG.TBASG113_SANCION SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_SANCION=:cdgoSancion";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg113Sancion.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoSancion", bean.getCdgoSancion());
		return sqlquery.executeUpdate();
	}

}
