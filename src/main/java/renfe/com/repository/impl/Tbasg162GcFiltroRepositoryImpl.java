package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg162GcFiltro;
import renfe.com.repository.Tbasg162GcFiltroRepositoryCustom;

public class Tbasg162GcFiltroRepositoryImpl implements Tbasg162GcFiltroRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg162GcFiltro> getGcFiltrosListActive(String cdgoConsulta) {

		String sqlString = "SELECT * " + "        FROM PASG.TBASG162_GC_FILTRO"
				+ "        WHERE CDGO_CONSULTA = :cdgoConsulta" + "        ORDER BY CDGO_ORDEN";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg162GcFiltro.class);
		sqlquery.setParameter("cdgoConsulta", cdgoConsulta);
		return sqlquery.getResultList();
	}

	public List<Tbasg162GcFiltro> getGcFiltrosList(String cdgoConsulta) {

		String sqlString = "SELECT * " + "        FROM PASG.TBASG162_GC_FILTRO"
				+ "        WHERE CDGO_CONSULTA = :cdgoConsulta" + "        ORDER BY CDGO_ORDEN";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg162GcFiltro.class);
		sqlquery.setParameter("cdgoConsulta", cdgoConsulta);
		return sqlquery.getResultList();
	}

	public List<Tbasg162GcFiltro> getGcFiltro(String cdgoFiltro) {

		String sqlString = "SELECT * " + "        FROM PASG.TBASG162_GC_FILTRO"
				+ "        WHERE CDGO_FILTRO = :cdgoFiltro";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg162GcFiltro.class);
		sqlquery.setParameter("cdgoFiltro", cdgoFiltro);
		return sqlquery.getResultList();
	}

	public int insertGcFiltro(Tbasg162GcFiltro bean) {

		String sqlString = "INSERT INTO PASG.TBASG162_GC_FILTRO"
				+ "           (CDGO_CONSULTA, CDGO_CATEGORIA, CDGO_CONCEPTO, CDGO_ORDEN, DESG_TIPOCONJUNCION, "
				+ "            MRCA_NEGACION, DESG_OPERADOR, DESG_VALOR1, DESG_VALOR2, DESG_USUACT, FCHA_ACT) "
				+ "        VALUES (?,?,?,?,?,?,?,?,?,?,CURRENT_DATE)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg162GcFiltro.class);
		sqlquery.setParameter(1, bean.getCdgoConsulta());
		sqlquery.setParameter(2, bean.getCdgoCategoria());
		sqlquery.setParameter(3, bean.getCdgoConcepto());
		sqlquery.setParameter(4, bean.getCdgoOrden());
		sqlquery.setParameter(5, bean.getDesgTipoconjuncion());
		sqlquery.setParameter(6, bean.getMrcaNegacion());
		sqlquery.setParameter(7, bean.getDesgOperador());
		sqlquery.setParameter(8, bean.getDesgValor1());
		sqlquery.setParameter(9, bean.getDesgValor2());
		sqlquery.setParameter(10, bean.getDesgUsuact());
		return sqlquery.executeUpdate();
	}

	public int updateGcFiltro(Tbasg162GcFiltro bean) {

		String sqlString = "UPDATE PASG.TBASG162_GC_FILTRO" + "        SET CDGO_CONSULTA = :cdgoConsulta,"
				+ "			CDGO_CATEGORIA = :cdgoCategoria," + "			CDGO_CONCEPTO = :cdgoConcepto,"
				+ "			CDGO_ORDEN = :cdgoOrden," + "            DESG_TIPOCONJUNCION = :tipoConjuncion,"
				+ "            MRCA_NEGACION = :negacion," + "            DESG_OPERADOR = :operador,"
				+ "            DESG_VALOR1 = :valor1," + "            DESG_VALOR2 = :valor2,"
				+ "            DESG_USUACT = :usuAct, " + "            FCHA_ACT = CURRENT_DATE"
				+ "        WHERE CDGO_FILTRO = :cdgoFiltro";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg162GcFiltro.class);
		sqlquery.setParameter("cdgoConsulta", bean.getCdgoConsulta());
		sqlquery.setParameter("cdgoCategoria", bean.getCdgoCategoria());
		sqlquery.setParameter("cdgoConcepto", bean.getCdgoConcepto());
		sqlquery.setParameter("cdgoOrden", bean.getCdgoOrden());
		sqlquery.setParameter("tipoConjuncion", bean.getDesgTipoconjuncion());
		sqlquery.setParameter("negacion", bean.getMrcaNegacion());
		sqlquery.setParameter("operador", bean.getDesgOperador());
		sqlquery.setParameter("valor1", bean.getDesgValor1());
		sqlquery.setParameter("valor2", bean.getDesgValor2());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoFiltro", bean.getCdgoFiltro());
		return sqlquery.executeUpdate();
	}

	public int deleteGcFiltroLogico(Tbasg162GcFiltro bean) {

		String sqlString = "UPDATE PASG.TBASG162_GC_FILTRO" + "        SET DESG_USUACT = :usuAct,"
				+ "            FCHA_ACT = CURRENT_DATE," + "            MRCA_ACTIVO = 'N'"
				+ "        WHERE CDGO_FILTRO = :cdgoFiltro";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg162GcFiltro.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoFiltro", bean.getCdgoFiltro());
		return sqlquery.executeUpdate();
	}

	public int deleteGcFiltrosConsulta(Tbasg162GcFiltro bean) {

		String sqlString = "DELETE FROM PASG.TBASG162_GC_FILTRO" + "    	    WHERE CDGO_CONSULTA = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg162GcFiltro.class);
		sqlquery.setParameter("value", bean.getCdgoConsulta());
		return sqlquery.executeUpdate();
	}

}
