package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg115Calificac;
import renfe.com.repository.Tbasg115CalificacRepositoryCustom;

public class Tbasg115CalificacRepositoryImpl implements Tbasg115CalificacRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg115Calificac> getCalificacCount() {

		String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG115_CALIFICAC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg115Calificac.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg115Calificac> getCalificacListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG115_CALIFICAC ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg115Calificac> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg115Calificac calificac = new Tbasg115Calificac();
			
			calificac.setCdgoCalifi((int)object[0]);
			calificac.setDesgNombre((String)object[1]);
			calificac.setDesgTipocalif((String)object[2]);
			calificac.setDesgUsuact((String)object[3]);
			calificac.setFchaAct((Date) object[4]);
			calificac.setMrcaActivo(String.valueOf((java.lang.Character) object[5]));

			resultadosDevueltos.add(calificac);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg115Calificac> getCalificacListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG115_CALIFICAC ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg115Calificac.class);

		return sqlquery.getResultList();
	}

	/*public List<Tbasg115Calificac> getCalificacActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG115_CALIFICAC WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg115Calificac.class);

		return sqlquery.getResultList();
	}*/
	
	public List<Tbasg115Calificac> getCalificacActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG115_CALIFICAC WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg115Calificac> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg115Calificac calificac = new Tbasg115Calificac();

			calificac.setCdgoCalifi((int)object[0]);
			calificac.setDesgNombre((String)object[1]);
			calificac.setDesgTipocalif((String)object[2]);
			calificac.setDesgUsuact((String)object[3]);
			calificac.setFchaAct((Date) object[4]);
			calificac.setMrcaActivo(String.valueOf((java.lang.Character) object[5]));

			resultadosDevueltos.add(calificac);
		}
		return resultadosDevueltos;
	}
	
	public List<Tbasg115Calificac> getCalificacActiveListAscendenteRevision() {

		String sqlString = " SELECT * FROM PASG.TBASG115_CALIFICAC WHERE MRCA_ACTIVO = 'S' AND DESG_TIPOCALIF = 'REVISIÓN' AND CDGO_CALIFI <> 2 ORDER BY DESG_NOMBRE ";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg115Calificac> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg115Calificac calificac = new Tbasg115Calificac();

			calificac.setCdgoCalifi((int)object[0]);
			calificac.setDesgNombre((String)object[1]);
			calificac.setDesgTipocalif((String)object[2]);
			calificac.setDesgUsuact((String)object[3]);
			calificac.setFchaAct((Date) object[4]);
			calificac.setMrcaActivo(String.valueOf((java.lang.Character) object[5]));

			resultadosDevueltos.add(calificac);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg115Calificac> getCalificacActiveListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG115_CALIFICAC WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg115Calificac.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg115Calificac> getCalificac(Integer cdgoCalifi) {

		String sqlString = "SELECT * FROM PASG.TBASG115_CALIFICAC WHERE CDGO_CALIFI=:value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoCalifi);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg115Calificac> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg115Calificac calificac = new Tbasg115Calificac();

			calificac.setCdgoCalifi((int)object[0]);
			calificac.setDesgNombre((String)object[1]);
			calificac.setDesgTipocalif((String)object[2]);
			calificac.setDesgUsuact((String)object[3]);
			calificac.setFchaAct((Date) object[4]);
			calificac.setMrcaActivo(String.valueOf((java.lang.Character) object[5]));

			resultadosDevueltos.add(calificac);
		}
		return resultadosDevueltos;
	}

	public int insertCalificac(Tbasg115Calificac bean) {

		String sqlString = "INSERT INTO PASG.TBASG115_CALIFICAC (DESG_NOMBRE, DESG_TIPOCALIF, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, ?, CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg115Calificac.class);
		sqlquery.setParameter(1, bean.getDesgNombre());
		sqlquery.setParameter(2, bean.getDesgTipocalif());
		sqlquery.setParameter(3, bean.getDesgUsuact());
		sqlquery.setParameter(4, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateCalificac(Tbasg115Calificac bean) {

		String sqlString = "UPDATE PASG.TBASG115_CALIFICAC SET DESG_NOMBRE=:nombre, DESG_TIPOCALIF=:tipoCalif, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE  WHERE CDGO_CALIFI=:cdgoCalifi";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg115Calificac.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("tipoCalif", bean.getDesgTipocalif());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoCalifi", bean.getCdgoCalifi());
		return sqlquery.executeUpdate();
	}
	
	public int estadoCalificac(Tbasg115Calificac bean) {

		String sqlString = "UPDATE PASG.TBASG115_CALIFICAC SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE  WHERE CDGO_CALIFI=:cdgoCalifi";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg115Calificac.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoCalifi", bean.getCdgoCalifi());
		return sqlquery.executeUpdate();
	}

}
