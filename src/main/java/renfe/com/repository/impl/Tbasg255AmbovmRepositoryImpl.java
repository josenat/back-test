package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg255Ambovm;
import renfe.com.repository.Tbasg255AmbovmRepositoryCustom;

public class Tbasg255AmbovmRepositoryImpl implements Tbasg255AmbovmRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg255Ambovm> getAmbitosOVMCount() {

		String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG255_AMBOVM";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg255Ambovm.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg255Ambovm> getAmbitosOVMListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG255_AMBOVM " + "			ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg255Ambovm.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg255Ambovm> getAmbitosOVMListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG255_AMBOVM " + "			ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg255Ambovm.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg255Ambovm> getAmbitosOVMActiveList() {

		String sqlString = "SELECT * FROM PASG.TBASG255_AMBOVM " + "		WHERE MRCA_ACTIVO = 'S'"
				+ "		ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg255Ambovm.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg255Ambovm> getAmbitosOVM(String cdgoAmbovm) {

		String sqlString = "SELECT * FROM PASG.TBASG255_AMBOVM WHERE CDGO_AMBOVM=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg255Ambovm.class);
		sqlquery.setParameter("value", cdgoAmbovm);
		return sqlquery.getResultList();
	}

	public int insertAmbitosOVM(Tbasg255Ambovm bean) {

		String sqlString = "INSERT INTO PASG.TBASG255_AMBOVM (DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg255Ambovm.class);
		sqlquery.setParameter(1, bean.getDesgNombre());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateAmbitosOVM(Tbasg255Ambovm bean) {

		String sqlString = "UPDATE PASG.TBASG255_AMBOVM SET DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE"
				+ "        WHERE CDGO_AMBOVM=:cdgoAmbitosOVM";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg255Ambovm.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoAmbitosOVM", bean.getCdgoAmbovm());
		return sqlquery.executeUpdate();
	}

	public int deleteAmbitosOVM(Tbasg255Ambovm bean) {

		String sqlString = "UPDATE PASG.TBASG255_AMBOVM SET MRCA_ACTIVO='N', DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE"
				+ "        WHERE CDGO_AMBOVM=:cdgoAmbitosOVM";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg255Ambovm.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoAmbitosOVM", bean.getCdgoAmbovm());
		return sqlquery.executeUpdate();
	}

}
