package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg145Alchaesta;
import renfe.com.repository.Tbasg145AlchaestaRepositoryCustom;

public class Tbasg145AlchaestaRepositoryImpl implements Tbasg145AlchaestaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg145Alchaesta> getAlcHaEstaCount(/** FIXME revisar tipo */
	Object cdgoEntorno) {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG145_ALCHAESTA where CDGO_ENTORNO = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg145Alchaesta.class);
		sqlquery.setParameter("value", cdgoEntorno);
		return sqlquery.getResultList();
	}

	public List<Tbasg145Alchaesta> getAlcHaEsta(String cdgoAlchabinf, String cdgoLinea, String cdgoOrigen,
			String cdgoDestino) {

		String sqlString = "SELECT * FROM PASG.TBASG145_ALCHAESTA WHERE CDGO_ALCHABINF=:cdgoAlcHabInf AND CDGO_LINEA=:cdgoLinea AND CDGO_ORIGEN=:cdgoOrigen AND CDGO_DESTINO=:cdgoDestino";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg145Alchaesta.class);
		sqlquery.setParameter("cdgoAlcHabInf", cdgoAlchabinf);
		sqlquery.setParameter("cdgoLinea", cdgoLinea);
		sqlquery.setParameter("cdgoOrigen", cdgoOrigen);
		sqlquery.setParameter("cdgoDestino", cdgoDestino);
		return sqlquery.getResultList();
	}

	public int insertAlcHaEsta(Tbasg145Alchaesta bean) {

		String sqlString = "INSERT INTO PASG.TBASG145_ALCHAESTA (CDGO_ALCHABINF, CDGO_LINEA, CDGO_ORIGEN, CDGO_DESTINO, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, ?, ?, ?, CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg145Alchaesta.class);
		sqlquery.setParameter(1, bean.getTbasg145alchaestapk().getCdgoAlchabinf());
		sqlquery.setParameter(2, bean.getTbasg145alchaestapk().getCdgoLinea());
		sqlquery.setParameter(3, bean.getTbasg145alchaestapk().getCdgoOrigen());
		sqlquery.setParameter(4, bean.getTbasg145alchaestapk().getCdgoDestino());
		sqlquery.setParameter(5, bean.getDesgUsuact());
		sqlquery.setParameter(6, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int deleteAlcHaEsta(Tbasg145Alchaesta bean) {

		String sqlString = "UPDATE PASG.TBASG145_ALCHAESTA SET MRCA_ACTIVO='N', DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE  WHERE CDGO_ALCHABINF=:cdgoAlcHabInf AND CDGO_LINEA=:cdgoLinea AND CDGO_ORIGEN=:cdgoOrigen AND CDGO_DESTINO=:cdgoDestino";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg145Alchaesta.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoAlcHabInf", bean.getTbasg145alchaestapk().getCdgoAlchabinf());
		sqlquery.setParameter("cdgoLinea", bean.getTbasg145alchaestapk().getCdgoLinea());
		sqlquery.setParameter("cdgoOrigen", bean.getTbasg145alchaestapk().getCdgoOrigen());
		sqlquery.setParameter("cdgoDestino", bean.getTbasg145alchaestapk().getCdgoDestino());
		return sqlquery.executeUpdate();
	}

	public int deleteAlcHaEstaByAlchabinf(Tbasg145Alchaesta bean) {

		String sqlString = "UPDATE PASG.TBASG145_ALCHAESTA SET MRCA_ACTIVO='N', DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE  WHERE CDGO_ALCHABINF=:cdgoAlcHabInf";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg145Alchaesta.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoAlcHabInf", bean.getTbasg145alchaestapk().getCdgoAlchabinf());
		return sqlquery.executeUpdate();
	}

}
