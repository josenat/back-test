package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg161GcResultado;
import renfe.com.repository.Tbasg161GcResultadoRepositoryCustom;

public class Tbasg161GcResultadoRepositoryImpl implements Tbasg161GcResultadoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg161GcResultado> getGcResultadosListActive(String cdgoConsulta) {

		String sqlString = "SELECT * " + "        FROM PASG.TBASG161_GC_RESULTADO"
				+ "        WHERE CDGO_CONSULTA = :cdgoConsulta" + "        ORDER BY CDGO_ORDEN";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg161GcResultado.class);
		sqlquery.setParameter("cdgoConsulta", cdgoConsulta);
		return sqlquery.getResultList();
	}

	public List<Tbasg161GcResultado> getGcResultado(String cdgoConsulta, String cdgoCategoria, String cdgoConcepto) {

		String sqlString = "SELECT * " + "        FROM PASG.TBASG161_GC_RESULTADO"
				+ "        WHERE CDGO_CONSULTA = :cdgoConsulta" + "              AND CDGO_CATEGORIA = :cdgoCategoria"
				+ "              AND CDGO_CONCEPTO = :cdgoConcepto";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg161GcResultado.class);
		sqlquery.setParameter("cdgoConsulta", cdgoConsulta);
		sqlquery.setParameter("cdgoCategoria", cdgoCategoria);
		sqlquery.setParameter("cdgoConcepto", cdgoConcepto);
		return sqlquery.getResultList();
	}

	public int insertGcResultado(Tbasg161GcResultado bean) {

		String sqlString = "INSERT INTO PASG.TBASG161_GC_RESULTADO "
				+ "           (CDGO_CONSULTA, CDGO_CATEGORIA, CDGO_CONCEPTO, CDGO_ORDEN, CDGO_CRITORDEN, DESG_USUACT, FCHA_ACT) "
				+ "        VALUES (?,?,?,?,?,?,CURRENT_DATE)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg161GcResultado.class);
		sqlquery.setParameter(1, bean.getTbasg161gcresultadopk().getCdgoConsulta());
		sqlquery.setParameter(2, bean.getTbasg161gcresultadopk().getCdgoCategoria());
		sqlquery.setParameter(3, bean.getTbasg161gcresultadopk().getCdgoConcepto());
		sqlquery.setParameter(4, bean.getCdgoOrden());
		sqlquery.setParameter(5, bean.getCdgoCritorden());
		sqlquery.setParameter(6, bean.getDesgUsuact());
		return sqlquery.executeUpdate();
	}

	public int updateGcResultado(Tbasg161GcResultado bean) {

		String sqlString = "UPDATE PASG.TBASG161_GC_RESULTADO" + "        SET CDGO_ORDEN = :cdgoOrden,"
				+ "			CDGO_CRITORDEN = :cdgoCritOrden," + "            DESG_USUACT = :usuAct, "
				+ "            FCHA_ACT = CURRENT_DATE" + "        WHERE CDGO_CONSULTA = :cdgoConsulta"
				+ "              AND CDGO_CATEGORIA = :cdgoCategoria"
				+ "              AND CDGO_CONCEPTO = :cdgoConcepto";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg161GcResultado.class);
		sqlquery.setParameter("cdgoOrden", bean.getCdgoOrden());
		sqlquery.setParameter("cdgoCritOrden", bean.getCdgoCritorden());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoConsulta", bean.getTbasg161gcresultadopk().getCdgoConsulta());
		sqlquery.setParameter("cdgoCategoria", bean.getTbasg161gcresultadopk().getCdgoCategoria());
		sqlquery.setParameter("cdgoConcepto", bean.getTbasg161gcresultadopk().getCdgoConcepto());
		return sqlquery.executeUpdate();
	}

	public int deleteGcResultadosConsulta(Tbasg161GcResultado bean) {

		String sqlString = "DELETE FROM PASG.TBASG161_GC_RESULTADO" + "    	    WHERE CDGO_CONSULTA = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg161GcResultado.class);
		sqlquery.setParameter("value", bean.getTbasg161gcresultadopk().getCdgoConsulta());
		return sqlquery.executeUpdate();
	}

}
