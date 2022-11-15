package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg151Rid;
import renfe.com.repository.Tbasg151RidRepositoryCustom;
import org.springframework.transaction.annotation.Transactional;

public class Tbasg151RidRepositoryImpl implements Tbasg151RidRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg151Rid> getRidList() {

		String sqlString = "SELECT * FROM PASG.TBASG151_RID ORDER BY CDGO_EXPEDIENT";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg151Rid.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg151Rid> getRidCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG151_RID";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg151Rid.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg151Rid> getRid(String cdgoExpedient) {

		String sqlString = "SELECT * FROM PASG.TBASG151_RID WHERE CDGO_EXPEDIENT = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg151Rid.class);
		sqlquery.setParameter("value", cdgoExpedient);
		return sqlquery.getResultList();
	}

	@Transactional
	public int insertRid(String cdgoExpedient, String fchaRid, String desgUsuact) {
		String sqlString = "INSERT INTO PASG.TBASG151_RID (CDGO_EXPEDIENT, FCHA_RID, DESG_USUACT, FCHA_ACT) VALUES (?, ?, ?, CURRENT_DATE) ";
		Query sqlquery = em.createNativeQuery(sqlString);

		sqlquery.setParameter(1, cdgoExpedient);
		sqlquery.setParameter(2, fchaRid);
		sqlquery.setParameter(3, desgUsuact);
		
		return sqlquery.executeUpdate();
	}

	public int updateRid(Tbasg151Rid bean) {

		String sqlString = "UPDATE PASG.TBASG151_RID SET " + "			FCHA_RID = ?, " + "			DESG_USUACT = ?, "
				+ "			FCHA_ACT = CURRENT_DATE			" + "		WHERE CDGO_EXPEDIENT = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg151Rid.class);
		sqlquery.setParameter(1, bean.getFchaRid());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getCdgoExpedient());
		return sqlquery.executeUpdate();
	}

}
