package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg114Gradoinci;
import renfe.com.repository.Tbasg114GradoinciRepositoryCustom;

public class Tbasg114GradoinciRepositoryImpl implements Tbasg114GradoinciRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg114Gradoinci> getGradoInciCount() {

		String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG114_GRADOINCI";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg114Gradoinci.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg114Gradoinci> getGradoInciActiveCount() {

		String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG114_GRADOINCI WHERE MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg114Gradoinci.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg114Gradoinci> getGradoInciListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG114_GRADOINCI ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg114Gradoinci> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg114Gradoinci gradoinci = new Tbasg114Gradoinci();
			
			gradoinci.setCdgoGrado(Long.valueOf((int)object[0]));
			gradoinci.setDesgNombre((String)object[1]);
			gradoinci.setDesgUsuact((String)object[2]);
			gradoinci.setFchaAct((Date) object[3]);
			gradoinci.setMrcaActivo(String.valueOf((Character) object[4]));

			resultadosDevueltos.add(gradoinci);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg114Gradoinci> getGradoInciListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG114_GRADOINCI ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg114Gradoinci.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg114Gradoinci> getGradoInciActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG114_GRADOINCI WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg114Gradoinci.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg114Gradoinci> getGradoInciActiveListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG114_GRADOINCI WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg114Gradoinci.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg114Gradoinci> getGradoInci(String cdgoGrado) {

		String sqlString = "SELECT * FROM PASG.TBASG114_GRADOINCI WHERE CDGO_GRADO=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg114Gradoinci.class);
		sqlquery.setParameter("value", cdgoGrado);
		return sqlquery.getResultList();
	}

	public int insertGradoInci(Tbasg114Gradoinci bean) {

		String sqlString = "INSERT INTO PASG.TBASG114_GRADOINCI (DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg114Gradoinci.class);
		sqlquery.setParameter(1, bean.getDesgNombre());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateGradoInci(Tbasg114Gradoinci bean) {

		String sqlString = "UPDATE PASG.TBASG114_GRADOINCI SET DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE  WHERE CDGO_GRADO=:cdgoGrado";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg114Gradoinci.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoGrado", bean.getCdgoGrado());
		return sqlquery.executeUpdate();
	}
	
	public int estadoGradoInci(Tbasg114Gradoinci bean) {

		String sqlString = "UPDATE PASG.TBASG114_GRADOINCI SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE  WHERE CDGO_GRADO=:cdgoGrado";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg114Gradoinci.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoGrado", bean.getCdgoGrado());
		return sqlquery.executeUpdate();
	}

}
