package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg163GcFiltroTramo;
import renfe.com.repository.Tbasg163GcFiltroTramoRepositoryCustom;

public class Tbasg163GcFiltroTramoRepositoryImpl implements Tbasg163GcFiltroTramoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg163GcFiltroTramo> getGcFiltrosTramoListActive(String cdgoConsulta) {

		String sqlString = "SELECT FT.* " + "        FROM PASG.TBASG163_GC_FILTRO_TRAMO FT, PASG.TBASG162_GC_FILTRO F"
				+ "        WHERE FT.CDGO_FILTRO = F.CDGO_FILTRO" + "			  AND F.CDGO_CONSULTA = :value"
				+ "        ORDER BY FT.CDGO_FILTRO";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg163GcFiltroTramo.class);
		sqlquery.setParameter("value", cdgoConsulta);
		return sqlquery.getResultList();
	}

	public List<Tbasg163GcFiltroTramo> getGcFiltroTramo(String cdgoFiltroTramo) {

		String sqlString = "SELECT * " + "        FROM PASG.TBASG163_GC_FILTRO_TRAMO"
				+ "        WHERE CDGO_FILTRO_TRAMO = :cdgoFiltroTramo";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg163GcFiltroTramo.class);
		sqlquery.setParameter("cdgoFiltroTramo", cdgoFiltroTramo);
		return sqlquery.getResultList();
	}

	public int insertGcFiltroTramo(Tbasg163GcFiltroTramo bean) {

		String sqlString = "INSERT INTO PASG.TBASG163_GC_FILTRO_TRAMO"
				+ "           (CDGO_FILTRO, CDGO_LINEA, CDGO_ORIGEN, CDGO_DESTINO, "
				+ "			DESG_USUACT, FCHA_ACT) " + "        VALUES (?,?,?,?,?,CURRENT_DATE)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg163GcFiltroTramo.class);
		sqlquery.setParameter(1, bean.getCdgoFiltro());
		sqlquery.setParameter(2, bean.getCdgoLinea());
		sqlquery.setParameter(3, bean.getCdgoOrigen());
		sqlquery.setParameter(4, bean.getCdgoDestino());
		sqlquery.setParameter(5, bean.getDesgUsuact());
		return sqlquery.executeUpdate();
	}

	public int deleteGcFiltrosTramo(Tbasg163GcFiltroTramo bean) {

		String sqlString = "DELETE FROM PASG.TBASG163_GC_FILTRO_TRAMO" + "    	    WHERE CDGO_FILTRO = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg163GcFiltroTramo.class);
		sqlquery.setParameter("value", bean.getCdgoFiltro());
		return sqlquery.executeUpdate();
	}

}
