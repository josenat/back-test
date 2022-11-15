package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg136Estudio;
import renfe.com.repository.Tbasg136EstudioRepositoryCustom;

public class Tbasg136EstudioRepositoryImpl implements Tbasg136EstudioRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg136Estudio> getEstudioCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG136_ESTUDIO";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg136Estudio.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg136Estudio> getEstudioListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG136_ESTUDIO ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg136Estudio> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg136Estudio estudio = new Tbasg136Estudio();
			
			estudio.setCdgoEstudio(Long.valueOf((int)object[0]));
			estudio.setDesgNombre((String)object[1]);
			estudio.setDesgUsuact((String)object[2]);
			estudio.setFchaAct((Date) object[3]);
			estudio.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));

			resultadosDevueltos.add(estudio);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg136Estudio> getEstudioListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG136_ESTUDIO ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg136Estudio.class);

		return sqlquery.getResultList();
	}

	/*public List<Tbasg136Estudio> getEstudioActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG136_ESTUDIO WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg136Estudio.class);

		return sqlquery.getResultList();
	}*/
	
	public List<Tbasg136Estudio> getEstudioActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG136_ESTUDIO WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg136Estudio> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg136Estudio estudio = new Tbasg136Estudio();

			estudio.setCdgoEstudio(Long.valueOf((int)object[0]));
			estudio.setDesgNombre((String)object[1]);
			estudio.setDesgUsuact((String)object[2]);
			estudio.setFchaAct((Date) object[3]);
			estudio.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));

			resultadosDevueltos.add(estudio);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg136Estudio> getEstudioActiveListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG136_ESTUDIO WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg136Estudio.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg136Estudio> getEstudio(String cdgoEstudio) {

		String sqlString = "SELECT * FROM PASG.TBASG136_ESTUDIO WHERE CDGO_ESTUDIO=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg136Estudio.class);
		sqlquery.setParameter("value", cdgoEstudio);
		return sqlquery.getResultList();
	}

	public int insertEstudio(Tbasg136Estudio bean) {

		String sqlString = "INSERT INTO PASG.TBASG136_ESTUDIO (DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO) VALUES (?,?,CURRENT_DATE,?);";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg136Estudio.class);
		sqlquery.setParameter(1, bean.getDesgNombre());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateEstudio(Tbasg136Estudio bean) {

		String sqlString = "UPDATE PASG.TBASG136_ESTUDIO SET DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_ESTUDIO=:cdgoEstudio";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg136Estudio.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoEstudio", bean.getCdgoEstudio());
		return sqlquery.executeUpdate();
	}
	
	public int estadoEstudio(Tbasg136Estudio bean) {

		String sqlString = "UPDATE PASG.TBASG136_ESTUDIO SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_ESTUDIO=:cdgoEstudio";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg136Estudio.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoEstudio", bean.getCdgoEstudio());
		return sqlquery.executeUpdate();
	}

}
