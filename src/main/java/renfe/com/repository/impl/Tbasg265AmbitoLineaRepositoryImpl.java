package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg265AmbitoLinea;
import renfe.com.repository.Tbasg265AmbitoLineaRepositoryCustom;

public class Tbasg265AmbitoLineaRepositoryImpl implements Tbasg265AmbitoLineaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg265AmbitoLinea> getListaAmbitoLineasActiv() {

		String sqlString = "SELECT CDGO_LINEA,DESG_LINEA FROM PASG.TBASG265_AMBITO_LINEA WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_LINEA";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg265AmbitoLinea> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg265AmbitoLinea ambitoLinea = new Tbasg265AmbitoLinea();
			
			ambitoLinea.setCdgoLinea((String)object[0]);
			ambitoLinea.setDesgLinea((String)object[1]);

			resultadosDevueltos.add(ambitoLinea);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg265AmbitoLinea> getDescTipoAmbitoLineas(String cdgoLinea) {

		String sqlString = "SELECT DESG_LINEA FROM PASG.TBASG265_AMBITO_LINEA WHERE CDGO_LINEA = :value AND MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg265AmbitoLinea.class);
		sqlquery.setParameter("value", cdgoLinea);
		return sqlquery.getResultList();
	}

	public List<Tbasg265AmbitoLinea> getAmbitoLineaCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG265_AMBITO_LINEA";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg265AmbitoLinea.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg265AmbitoLinea> getMaxAmbitoLinea() {

		String sqlString = "SELECT MAX(INT(CDGO_LINEA))as value FROM PASG.TBASG265_AMBITO_LINEA";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg265AmbitoLinea.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg265AmbitoLinea> getAmbitoLineaListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG265_AMBITO_LINEA ORDER BY CDGO_LINEA";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg265AmbitoLinea> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg265AmbitoLinea ambitoLinea = new Tbasg265AmbitoLinea();
			
			ambitoLinea.setCdgoLinea((String)object[0]);
			ambitoLinea.setDesgLinea((String)object[1]);
			ambitoLinea.setDesgUsuact((String)object[2]);
			ambitoLinea.setFchaAct((Date) object[3]);
			ambitoLinea.setMrcaActivo(String.valueOf((Character) object[4]));

			resultadosDevueltos.add(ambitoLinea);
		}
		return resultadosDevueltos;
	}
	
	public List<Tbasg265AmbitoLinea> getCdgoLineaAutoInc() {

		String sqlString = "SELECT MAX(CDGO_LINEA) FROM PASG.TBASG265_AMBITO_LINEA";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object> resultados = sqlquery.getResultList();
		List<Tbasg265AmbitoLinea> resultadosDevueltos = new ArrayList<>();
		for (Object object : resultados) {
			Tbasg265AmbitoLinea ambitoLinea = new Tbasg265AmbitoLinea();
			
			ambitoLinea.setCdgoLinea((String)object);

			resultadosDevueltos.add(ambitoLinea);
		}
		return resultadosDevueltos;
		
	}

	public List<Tbasg265AmbitoLinea> getAmbitoLineaListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG265_AMBITO_LINEA ORDER BY CDGO_LINEA DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg265AmbitoLinea.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg265AmbitoLinea> getAmbitoLinea(String cdgoLinea) {

		String sqlString = "SELECT * FROM PASG.TBASG265_AMBITO_LINEA WHERE CDGO_LINEA=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg265AmbitoLinea.class);
		sqlquery.setParameter("value", cdgoLinea);
		return sqlquery.getResultList();
	}

	public List<Tbasg265AmbitoLinea> getAmbitoLineaByNombre(String desgLinea) {

		String sqlString = "SELECT CDGO_LINEA FROM PASG.TBASG265_AMBITO_LINEA WHERE DESG_LINEA=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg265AmbitoLinea.class);
		sqlquery.setParameter("value", desgLinea);
		return sqlquery.getResultList();
	}

	public List<Tbasg265AmbitoLinea> getAmbitoLineaListActive() {

		String sqlString = "SELECT * FROM PASG.TBASG265_AMBITO_LINEA WHERE MRCA_ACTIVO='S' ORDER BY DESG_LINEA";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg265AmbitoLinea.class);

		return sqlquery.getResultList();
	}

	public int insertAmbitoLinea(Tbasg265AmbitoLinea bean) {

		String sqlString = "INSERT INTO PASG.TBASG265_AMBITO_LINEA (CDGO_LINEA,DESG_LINEA, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, ?,CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg265AmbitoLinea.class);
		sqlquery.setParameter(1, bean.getCdgoLinea());
		sqlquery.setParameter(2, bean.getDesgLinea());
		sqlquery.setParameter(3, bean.getDesgUsuact());
		sqlquery.setParameter(4, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateAmbitoLinea(Tbasg265AmbitoLinea bean) {

		String sqlString = "UPDATE PASG.TBASG265_AMBITO_LINEA SET DESG_LINEA = :desgLinea, DESG_USUACT=:usuAct,FCHA_ACT=CURRENT_DATE WHERE CDGO_LINEA=:cdgoLinea";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg265AmbitoLinea.class);
		sqlquery.setParameter("desgLinea", bean.getDesgLinea());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoLinea", bean.getCdgoLinea());
		return sqlquery.executeUpdate();
	}
	
	public int estadoAmbitoLinea(Tbasg265AmbitoLinea bean) {

		String sqlString = "UPDATE PASG.TBASG265_AMBITO_LINEA SET MRCA_ACTIVO = :mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_LINEA=:cdgoLinea";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg265AmbitoLinea.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoLinea", bean.getCdgoLinea());
		return sqlquery.executeUpdate();
	}

}
