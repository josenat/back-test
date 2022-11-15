package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg109Psicoambi;
import renfe.com.repository.Tbasg109PsicoambiRepositoryCustom;

public class Tbasg109PsicoambiRepositoryImpl implements Tbasg109PsicoambiRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg109Psicoambi> getPsicoAmbiListCount() {

		String sqlString = "SELECT COUNT(*) AS value FROM PASG.TBASG109_PSICOAMBI";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg109Psicoambi.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg109Psicoambi> getPsicoAmbiListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG109_PSICOAMBI ORDER BY CDGO_PSICAMB";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg109Psicoambi> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg109Psicoambi psicoambi = new Tbasg109Psicoambi();
			
			psicoambi.setCdgoPsicamb((Integer)object[0]);
			psicoambi.setDesgNombre((String)object[1]);
			psicoambi.setDesgUsuact((String)object[2]);
			psicoambi.setFchaAct((Date) object[3]);
			psicoambi.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));
			psicoambi.setCdgoPsicambFom((Integer)object[5]);

			resultadosDevueltos.add(psicoambi);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg109Psicoambi> getPsicoAmbiListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG109_PSICOAMBI ORDER BY CDGO_PSICAMB DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg109Psicoambi.class);

		return sqlquery.getResultList();
	}

	/*public List<Tbasg109Psicoambi> getPsicoAmbiActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG109_PSICOAMBI WHERE MRCA_ACTIVO = 'S' ORDER BY CDGO_PSICAMB";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg109Psicoambi.class);

		return sqlquery.getResultList();
	}*/
	
	public List<Tbasg109Psicoambi> getPsicoAmbiActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG109_PSICOAMBI WHERE MRCA_ACTIVO = 'S' ORDER BY CDGO_PSICAMB";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg109Psicoambi> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg109Psicoambi psicoambi = new Tbasg109Psicoambi();

			psicoambi.setCdgoPsicamb((Integer)object[0]);
			psicoambi.setDesgNombre((String)object[1]);
			psicoambi.setDesgUsuact((String)object[2]);
			psicoambi.setFchaAct((Date) object[3]);
			psicoambi.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));
			psicoambi.setCdgoPsicambFom((Integer)object[5]);

			resultadosDevueltos.add(psicoambi);
		}
		return resultadosDevueltos;
	}
	
	public List<Tbasg109Psicoambi> getPsicoAmbiActiveListAscendente1() {

		String sqlString = "SELECT * FROM PASG.TBASG109_PSICOAMBI WHERE MRCA_ACTIVO = 'S' AND CDGO_PSICOTIPO=1 ORDER BY CDGO_PSICAMB";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg109Psicoambi> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg109Psicoambi psicoambi = new Tbasg109Psicoambi();

			psicoambi.setCdgoPsicamb((Integer)object[0]);
			psicoambi.setDesgNombre((String)object[1]);
			psicoambi.setDesgUsuact((String)object[2]);
			psicoambi.setFchaAct((Date) object[3]);
			psicoambi.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));
			psicoambi.setCdgoPsicambFom((Integer)object[5]);

			resultadosDevueltos.add(psicoambi);
		}
		return resultadosDevueltos;
	}
	
	public List<Tbasg109Psicoambi> getPsicoAmbiActiveListAscendente2() {

		String sqlString = "SELECT * FROM PASG.TBASG109_PSICOAMBI WHERE MRCA_ACTIVO = 'S' AND CDGO_PSICOTIPO=2 ORDER BY CDGO_PSICAMB";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg109Psicoambi> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg109Psicoambi psicoambi = new Tbasg109Psicoambi();

			psicoambi.setCdgoPsicamb((Integer)object[0]);
			psicoambi.setDesgNombre((String)object[1]);
			psicoambi.setDesgUsuact((String)object[2]);
			psicoambi.setFchaAct((Date) object[3]);
			psicoambi.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));
			psicoambi.setCdgoPsicambFom((Integer)object[5]);

			resultadosDevueltos.add(psicoambi);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg109Psicoambi> getPsicoAmbiActiveListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG109_PSICOAMBI WHERE MRCA_ACTIVO = 'S' ORDER BY CDGO_PSICAMB DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg109Psicoambi.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg109Psicoambi> getPsicoAmbi(Integer cdgoPsicamb) {

		String sqlString = "SELECT * FROM PASG.TBASG109_PSICOAMBI WHERE CDGO_PSICAMB = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPsicamb);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg109Psicoambi> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg109Psicoambi psicoambi = new Tbasg109Psicoambi();

			psicoambi.setCdgoPsicamb((Integer)object[0]);
			psicoambi.setDesgNombre((String)object[1]);
			psicoambi.setDesgUsuact((String)object[2]);
			psicoambi.setFchaAct((Date) object[3]);
			psicoambi.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));
			psicoambi.setCdgoPsicambFom((Integer)object[5]);

			resultadosDevueltos.add(psicoambi);
		}
		return resultadosDevueltos;
	}

	public int insertPsicoAmbi(Tbasg109Psicoambi bean) {

		String sqlString = "INSERT INTO PASG.TBASG109_PSICOAMBI (DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO) VALUES (?,?,CURRENT_DATE,?);";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg109Psicoambi.class);
		sqlquery.setParameter(1, bean.getDesgNombre());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updatePsicoAmbi(Tbasg109Psicoambi bean) {

		String sqlString = "UPDATE PASG.TBASG109_PSICOAMBI SET DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_PSICAMB=:cdgoPsicAmb";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg109Psicoambi.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoPsicAmb", bean.getCdgoPsicamb());
		return sqlquery.executeUpdate();
	}
	
	public int estadoPsicoAmbi(Tbasg109Psicoambi bean) {

		String sqlString = "UPDATE PASG.TBASG109_PSICOAMBI SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_PSICAMB=:cdgoPsicAmb";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg109Psicoambi.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoPsicAmb", bean.getCdgoPsicamb());
		return sqlquery.executeUpdate();
	}

}
