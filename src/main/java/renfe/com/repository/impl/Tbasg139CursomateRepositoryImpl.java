package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg139Cursomate;
import renfe.com.repository.Tbasg139CursomateRepositoryCustom;

public class Tbasg139CursomateRepositoryImpl implements Tbasg139CursomateRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg139Cursomate> getCursoMateCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG139_CURSOMATE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg139Cursomate.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg139Cursomate> getCursoMateListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG139_CURSOMATE ORDER BY CDGO_CURSOMAT";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg139Cursomate.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg139Cursomate> getCursoMateListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG139_CURSOMATE ORDER BY CDGO_CURSOMAT DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg139Cursomate.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg139Cursomate> getCursoMate(String cdgoCursomat) {

		String sqlString = "SELECT * FROM PASG.TBASG139_CURSOMATE WHERE CDGO_CURSOMAT=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg139Cursomate.class);
		sqlquery.setParameter("value", cdgoCursomat);
		return sqlquery.getResultList();
	}

	public int insertCursoMate(Tbasg139Cursomate bean) {

		String sqlString = "INSERT INTO PASG.TBASG139_CURSOMATE (DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO) VALUES (?,?,CURRENT_DATE,?);";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg139Cursomate.class);
		sqlquery.setParameter(1, bean.getDesgNombre());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateCursoMate(Tbasg139Cursomate bean) {

		String sqlString = "UPDATE PASG.TBASG139_CURSOMATE SET DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_CURSOMAT=:cdgoCursoMat";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg139Cursomate.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoCursoMat", bean.getCdgoCursomat());
		return sqlquery.executeUpdate();
	}

	public int deleteCursoMate(Tbasg139Cursomate bean) {

		String sqlString = "UPDATE PASG.TBASG139_CURSOMATE SET DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE, MRCA_ACTIVO='N' WHERE CDGO_CURSOMAT=:cdgoCursoMat";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg139Cursomate.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoCursoMat", bean.getCdgoCursomat());
		return sqlquery.executeUpdate();
	}

}
