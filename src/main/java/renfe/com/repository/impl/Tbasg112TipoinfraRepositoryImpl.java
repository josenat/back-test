package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg112Tipoinfra;
import renfe.com.repository.Tbasg112TipoinfraRepositoryCustom;

public class Tbasg112TipoinfraRepositoryImpl implements Tbasg112TipoinfraRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg112Tipoinfra> getTipoInfraCount() {

		String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG112_TIPOINFRA";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg112Tipoinfra.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg112Tipoinfra> getTipoInfraActiveCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG112_TIPOINFRA WHERE MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg112Tipoinfra.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg112Tipoinfra> getTipoInfraListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG112_TIPOINFRA ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg112Tipoinfra> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg112Tipoinfra tipoInfra = new Tbasg112Tipoinfra();
			
			tipoInfra.setCdgoTipinfr(Long.valueOf((int)object[0]));
			tipoInfra.setDesgNombre((String)object[1]);
			tipoInfra.setDesgUsuact((String)object[2]);
			tipoInfra.setFchaAct((Date) object[3]);
			tipoInfra.setMrcaActivo(String.valueOf((Character) object[4]));

			resultadosDevueltos.add(tipoInfra);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg112Tipoinfra> getTipoInfraListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG112_TIPOINFRA ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg112Tipoinfra.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg112Tipoinfra> getTipoInfraActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG112_TIPOINFRA WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg112Tipoinfra.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg112Tipoinfra> getTipoInfraActiveListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG112_TIPOINFRA WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg112Tipoinfra.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg112Tipoinfra> getTipoInfra(String cdgoTipinfr) {

		String sqlString = "SELECT * FROM PASG.TBASG112_TIPOINFRA WHERE CDGO_TIPINFR=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg112Tipoinfra.class);
		sqlquery.setParameter("value", cdgoTipinfr);
		return sqlquery.getResultList();
	}

	public int insertTipoInfra(Tbasg112Tipoinfra bean) {

		String sqlString = "INSERT INTO PASG.TBASG112_TIPOINFRA (DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg112Tipoinfra.class);
		sqlquery.setParameter(1, bean.getDesgNombre());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateTipoInfra(Tbasg112Tipoinfra bean) {

		String sqlString = "UPDATE PASG.TBASG112_TIPOINFRA SET DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE  WHERE CDGO_TIPINFR=:cdgoTipInfr";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg112Tipoinfra.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoTipInfr", bean.getCdgoTipinfr());
		return sqlquery.executeUpdate();
	}
	
	public int estadoTipoInfra(Tbasg112Tipoinfra bean) {

		String sqlString = "UPDATE PASG.TBASG112_TIPOINFRA SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE  WHERE CDGO_TIPINFR=:cdgoTipInfr";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg112Tipoinfra.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoTipInfr", bean.getCdgoTipinfr());
		return sqlquery.executeUpdate();
	}

}
