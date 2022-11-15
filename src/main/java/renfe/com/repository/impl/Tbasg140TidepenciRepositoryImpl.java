package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg140Tidepenci;
import renfe.com.repository.Tbasg140TidepenciRepositoryCustom;

public class Tbasg140TidepenciRepositoryImpl implements Tbasg140TidepenciRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg140Tidepenci> getTiDepenciCount() {

		String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG140_TIDEPENCI";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg140Tidepenci.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg140Tidepenci> getTiDepenciListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG140_TIDEPENCI ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg140Tidepenci.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg140Tidepenci> getTiDepenciListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG140_TIDEPENCI ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg140Tidepenci.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg140Tidepenci> getTiDepenciListActiveAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG140_TIDEPENCI WHERE MRCA_ACTIVO='S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg140Tidepenci.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg140Tidepenci> getTiDepenciListActiveDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG140_TIDEPENCI WHERE MRCA_ACTIVO='S' ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg140Tidepenci.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg140Tidepenci> getTiDepenci(String cdgoTipodep) {

		String sqlString = "SELECT * FROM PASG.TBASG140_TIDEPENCI WHERE CDGO_TIPODEP=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg140Tidepenci.class);
		sqlquery.setParameter("value", cdgoTipodep);
		return sqlquery.getResultList();
	}

	public int insertTiDepenci(Tbasg140Tidepenci bean) {

		String sqlString = "INSERT INTO PASG.TBASG140_TIDEPENCI (DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg140Tidepenci.class);
		sqlquery.setParameter(1, bean.getDesgNombre());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateTiDepenci(Tbasg140Tidepenci bean) {

		String sqlString = "UPDATE PASG.TBASG140_TIDEPENCI SET DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE  WHERE CDGO_TIPODEP=:cdgoTipoDep";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg140Tidepenci.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoTipoDep", bean.getCdgoTipodep());
		return sqlquery.executeUpdate();
	}

	public int deleteTiDepenci(Tbasg140Tidepenci bean) {

		String sqlString = "UPDATE PASG.TBASG140_TIDEPENCI SET MRCA_ACTIVO='N', DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE  WHERE CDGO_TIPODEP=:cdgoTipoDep";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg140Tidepenci.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoTipoDep", bean.getCdgoTipodep());
		return sqlquery.executeUpdate();
	}

}
