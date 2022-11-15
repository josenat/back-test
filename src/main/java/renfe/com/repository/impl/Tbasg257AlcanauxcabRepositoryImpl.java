package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg257Alcanauxcab;
import renfe.com.repository.Tbasg257AlcanauxcabRepositoryCustom;

public class Tbasg257AlcanauxcabRepositoryImpl implements Tbasg257AlcanauxcabRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg257Alcanauxcab> getAuxCabCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG257_ALCANAUXCAB";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg257Alcanauxcab.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg257Alcanauxcab> getAuxCabListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG257_ALCANAUXCAB ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg257Alcanauxcab> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg257Alcanauxcab alcanauxcab = new Tbasg257Alcanauxcab();
			
			alcanauxcab.setCdgoAlcanauxcab(Long.valueOf((int)object[0]));
			alcanauxcab.setDesgNombre((String)object[1]);
			alcanauxcab.setDesgUsuact((String)object[2]);
			alcanauxcab.setFchaAct((Date) object[3]);
			alcanauxcab.setMrcaActivo(String.valueOf((Character) object[4]));

			resultadosDevueltos.add(alcanauxcab);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg257Alcanauxcab> getAuxCabListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG257_ALCANAUXCAB ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg257Alcanauxcab.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg257Alcanauxcab> getAuxCab(String cdgoAlcanauxcab) {

		String sqlString = "SELECT * FROM PASG.TBASG257_ALCANAUXCAB WHERE CDGO_ALCANAUXCAB=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg257Alcanauxcab.class);
		sqlquery.setParameter("value", cdgoAlcanauxcab);
		return sqlquery.getResultList();
	}
	
	public List<Tbasg257Alcanauxcab> getAuxCabNombre(String cdgoAlcanauxcab) {

		String sqlString = "SELECT CDGO_ALCANAUXCAB, DESG_NOMBRE FROM PASG.TBASG257_ALCANAUXCAB WHERE CDGO_ALCANAUXCAB=:value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoAlcanauxcab);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg257Alcanauxcab> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg257Alcanauxcab alcanauxcab = new Tbasg257Alcanauxcab();

			alcanauxcab.setCdgoAlcanauxcab(Long.valueOf((int)object[0]));
			alcanauxcab.setDesgNombre((String)object[1]);

			resultadosDevueltos.add(alcanauxcab);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg257Alcanauxcab> getAuxCabActiveList() {

		String sqlString = "SELECT * FROM PASG.TBASG257_ALCANAUXCAB WHERE MRCA_ACTIVO='S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg257Alcanauxcab.class);

		return sqlquery.getResultList();
	}

	public int insertAuxCab(Tbasg257Alcanauxcab bean) {

		String sqlString = "INSERT INTO PASG.TBASG257_ALCANAUXCAB (DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO) VALUES (?,?,CURRENT_DATE,?);";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg257Alcanauxcab.class);
		sqlquery.setParameter(1, bean.getDesgNombre());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateAuxCab(Tbasg257Alcanauxcab bean) {

		String sqlString = "UPDATE PASG.TBASG257_ALCANAUXCAB SET DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_ALCANAUXCAB=:cdgoAuxCab";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg257Alcanauxcab.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoAuxCab", bean.getCdgoAlcanauxcab());
		return sqlquery.executeUpdate();
	}
	
	public int estadoAuxCab(Tbasg257Alcanauxcab bean) {

		String sqlString = "UPDATE PASG.TBASG257_ALCANAUXCAB SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_ALCANAUXCAB=:cdgoAuxCab";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg257Alcanauxcab.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoAuxCab", bean.getCdgoAlcanauxcab());
		return sqlquery.executeUpdate();
	}

}
