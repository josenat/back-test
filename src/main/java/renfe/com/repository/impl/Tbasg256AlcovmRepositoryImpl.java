package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg256Alcovm;
import renfe.com.repository.Tbasg256AlcovmRepositoryCustom;

public class Tbasg256AlcovmRepositoryImpl implements Tbasg256AlcovmRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg256Alcovm> getAlcancesOVMCount() {

		String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG256_ALCOVM WHERE MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg256Alcovm.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg256Alcovm> getAlcancesOVMListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG256_ALCOVM" + "            WHERE MRCA_ACTIVO = 'S'"
				+ "			ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg256Alcovm.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg256Alcovm> getAlcancesOVMListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG256_ALCOVM" + "            WHERE MRCA_ACTIVO = 'S' "
				+ "			ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg256Alcovm.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg256Alcovm> getAlcancesOVMActiveList() {

		String sqlString = "SELECT * FROM PASG.TBASG256_ALCOVM " + "		WHERE MRCA_ACTIVO = 'S'"
				+ "		ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg256Alcovm.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg256Alcovm> getAlcancesOVM(String cdgoAlcovm) {

		String sqlString = "SELECT * FROM PASG.TBASG256_ALCOVM WHERE CDGO_ALCOVM=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg256Alcovm.class);
		sqlquery.setParameter("value", cdgoAlcovm);
		return sqlquery.getResultList();
	}

	public int insertAlcancesOVM(Tbasg256Alcovm bean) {

		String sqlString = "INSERT INTO PASG.TBASG256_ALCOVM (DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg256Alcovm.class);
		sqlquery.setParameter(1, bean.getDesgNombre());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateAlcancesOVM(Tbasg256Alcovm bean) {

		String sqlString = "UPDATE PASG.TBASG256_ALCOVM SET DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE"
				+ "        WHERE CDGO_ALCOVM=:cdgoAlcancesOVM";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg256Alcovm.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoAlcancesOVM", bean.getCdgoAlcovm());
		return sqlquery.executeUpdate();
	}

	public int deleteAlcancesOVM(Tbasg256Alcovm bean) {

		String sqlString = "UPDATE PASG.TBASG256_ALCOVM SET MRCA_ACTIVO='N', DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE"
				+ "        WHERE CDGO_ALCOVM=:cdgoAlcancesOVM";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg256Alcovm.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoAlcancesOVM", bean.getCdgoAlcovm());
		return sqlquery.executeUpdate();
	}

}
