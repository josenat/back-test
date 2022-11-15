package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg111Facultati;
import renfe.com.repository.Tbasg111FacultatiRepositoryCustom;

public class Tbasg111FacultatiRepositoryImpl implements Tbasg111FacultatiRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg111Facultati> getFacultati(Integer cdgoFacult) {

		String sqlString = "SELECT * FROM PASG.TBASG111_FACULTATI WHERE CDGO_FACULT = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoFacult);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg111Facultati> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg111Facultati facultati = new Tbasg111Facultati();

			facultati.setCdgoFacult((int)object[0]);
			facultati.setDesgNumcolegiado((String)object[1]);
			facultati.setDesgNombre((String) object[2]);
			facultati.setDesgApell1((String) object[3]);
			facultati.setDesgApell2((String) object[4]);
			facultati.setDesgUsuact((String)object[5]);
			facultati.setFchaAct((Date) object[6]);
			facultati.setMrcaActivo(String.valueOf((java.lang.Character) object[7]));
			facultati.setCdgoCenmed((Integer)object[8]);

			resultadosDevueltos.add(facultati);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg111Facultati> getFacultatiByNumColegiado(String desgNumcolegiado) {

		String sqlString = "SELECT * FROM PASG.TBASG111_FACULTATI WHERE DESG_NUMCOLEGIADO = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg111Facultati.class);
		sqlquery.setParameter("value", desgNumcolegiado);
		return sqlquery.getResultList();
	}

	public List<Tbasg111Facultati> getFacultatiListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG111_FACULTATI ORDER BY DESG_APELL1";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg111Facultati> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg111Facultati facultati = new Tbasg111Facultati();

			facultati.setCdgoFacult((int)object[0]);
			facultati.setDesgNumcolegiado((String)object[1]);
			facultati.setDesgNombre((String) object[2]);
			facultati.setDesgApell1((String) object[3]);
			facultati.setDesgApell2((String) object[4]);
			facultati.setDesgUsuact((String)object[5]);
			facultati.setFchaAct((Date) object[6]);
			facultati.setMrcaActivo(String.valueOf((char) object[7]));
			facultati.setCdgoCenmed((Integer)object[8]);

			resultadosDevueltos.add(facultati);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg111Facultati> getFacultatiListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG111_FACULTATI ORDER BY DESG_APELL1 DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg111Facultati.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg111Facultati> getFacultatiViewListAscendente() {

		String sqlString = "SELECT F.*, C.DESG_NOMBRE AS NOMBRECENMED" + "		FROM PASG.TBASG111_FACULTATI F"
				+ "		LEFT JOIN PASG.TBASG108_CENTMEDIC C ON F.CDGO_CENMED = C.CDGO_CENMED  "
				+ "		ORDER BY F.DESG_APELL1";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg111Facultati.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg111Facultati> getFacultatiViewListDescendente() {

		String sqlString = "SELECT F.*, C.DESG_NOMBRE AS NOMBRECENMED" + "		FROM PASG.TBASG111_FACULTATI F"
				+ "		LEFT JOIN PASG.TBASG108_CENTMEDIC C ON F.CDGO_CENMED = C.CDGO_CENMED "
				+ "		ORDER BY F.DESG_APELL1 DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg111Facultati.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg111Facultati> getFacultatiActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG111_FACULTATI WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_APELL1";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg111Facultati.class);

		return sqlquery.getResultList();
	}

	/*public List<Tbasg111Facultati> getFacultatiActiveListAscendenteApe1Ape2Nom() {

		String sqlString = "SELECT * FROM PASG.TBASG111_FACULTATI WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_APELL1, DESG_APELL2, DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg111Facultati.class);

		return sqlquery.getResultList();
	}*/
	
	public List<Tbasg111Facultati> getFacultatiActiveListAscendenteApe1Ape2Nom() {

		String sqlString = "SELECT * FROM PASG.TBASG111_FACULTATI WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_APELL1, DESG_APELL2, DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg111Facultati> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg111Facultati facultati = new Tbasg111Facultati();

			facultati.setCdgoFacult((int)object[0]);
			facultati.setDesgNumcolegiado((String)object[1]);
			facultati.setDesgNombre((String) object[2]);
			facultati.setDesgApell1((String) object[3]);
			facultati.setDesgApell2((String) object[4]);
			facultati.setDesgUsuact((String)object[5]);
			facultati.setFchaAct((Date) object[6]);
			facultati.setMrcaActivo(String.valueOf((java.lang.Character) object[7]));
			facultati.setCdgoCenmed((Integer)object[8]);

			resultadosDevueltos.add(facultati);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg111Facultati> getFacultatiActiveListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG111_FACULTATI WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_APELL1 DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg111Facultati.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg111Facultati> getFacultatiCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG111_FACULTATI";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg111Facultati.class);

		return sqlquery.getResultList();
	}

	public int insertFacultati(Tbasg111Facultati bean) {

		String sqlString = "INSERT INTO PASG.TBASG111_FACULTATI (DESG_NUMCOLEGIADO, DESG_NOMBRE, DESG_APELL1, DESG_APELL2, CDGO_CENMED, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO) VALUES (?,?,?,?,?,?,CURRENT_DATE,?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg111Facultati.class);
		sqlquery.setParameter(1, bean.getDesgNumcolegiado());
		sqlquery.setParameter(2, bean.getDesgNombre());
		sqlquery.setParameter(3, bean.getDesgApell1());
		sqlquery.setParameter(4, bean.getDesgApell2());
		sqlquery.setParameter(5, bean.getCdgoCenmed());
		sqlquery.setParameter(6, bean.getDesgUsuact());
		sqlquery.setParameter(7, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateFacultati(Tbasg111Facultati bean) {

		String sqlString = "UPDATE PASG.TBASG111_FACULTATI SET DESG_NUMCOLEGIADO=:numColegiado, DESG_NOMBRE=:nombre, DESG_APELL1=:apell1, DESG_APELL2=:apell2, CDGO_CENMED=:cdgoCenMed, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_FACULT=:cdgoFacult";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg111Facultati.class);
		sqlquery.setParameter("numColegiado", bean.getDesgNumcolegiado());
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("apell1", bean.getDesgApell1());
		sqlquery.setParameter("apell2", bean.getDesgApell2());
		sqlquery.setParameter("cdgoCenMed", bean.getCdgoCenmed());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoFacult", bean.getCdgoFacult());
		return sqlquery.executeUpdate();
	}
	
	public int estadoFacultati(Tbasg111Facultati bean) {

		String sqlString = "UPDATE PASG.TBASG111_FACULTATI SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_FACULT=:cdgoFacult";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg111Facultati.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoFacult", bean.getCdgoFacult());
		return sqlquery.executeUpdate();
	}

}
