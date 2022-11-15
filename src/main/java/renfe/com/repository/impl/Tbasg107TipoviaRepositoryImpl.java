package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg107Tipovia;
import renfe.com.repository.Tbasg107TipoviaRepositoryCustom;

public class Tbasg107TipoviaRepositoryImpl implements Tbasg107TipoviaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg107Tipovia> getTipoVia(String cdgoTipovia) {

		String sqlString = "SELECT * FROM PASG.TBASG107_TIPOVIA WHERE CDGO_TIPOVIA = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoTipovia);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg107Tipovia> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg107Tipovia tipovia = new Tbasg107Tipovia();

			tipovia.setCdgoTipovia(Long.valueOf((int)object[0]));
			tipovia.setCdgoSap((String) object[1]);
			tipovia.setDesgNombre((String) object[2]);
			tipovia.setDesgUsuact((String) object[3]);
			tipovia.setFchaAct((Date) object[4]);
			tipovia.setMrcaActivo(String.valueOf((java.lang.Character) object[5]));

			resultadosDevueltos.add(tipovia);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg107Tipovia> getTipoViaListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG107_TIPOVIA ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg107Tipovia> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg107Tipovia tipovia = new Tbasg107Tipovia();
			
			tipovia.setCdgoTipovia(Long.valueOf((int)object[0]));
			tipovia.setCdgoSap((String) object[1]);
			tipovia.setDesgNombre((String) object[2]);
			tipovia.setDesgUsuact((String) object[3]);
			tipovia.setFchaAct((Date) object[4]);
			tipovia.setMrcaActivo(String.valueOf((java.lang.Character) object[5]));

			resultadosDevueltos.add(tipovia);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg107Tipovia> getTipoViaListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG107_TIPOVIA ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg107Tipovia.class);

		return sqlquery.getResultList();
	}

	/*public List<Tbasg107Tipovia> getTipoViaActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG107_TIPOVIA WHERE MRCA_ACTIVO='S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg107Tipovia.class);

		return sqlquery.getResultList();
	}*/
	
	public List<Tbasg107Tipovia> getTipoViaActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG107_TIPOVIA WHERE MRCA_ACTIVO='S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg107Tipovia> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg107Tipovia tipovia = new Tbasg107Tipovia();
			
			tipovia.setCdgoTipovia(Long.valueOf((int)object[0]));
			tipovia.setCdgoSap((String) object[1]);
			tipovia.setDesgNombre((String) object[2]);
			tipovia.setDesgUsuact((String) object[3]);
			tipovia.setFchaAct((Date) object[4]);
			tipovia.setMrcaActivo(String.valueOf((java.lang.Character) object[5]));

			resultadosDevueltos.add(tipovia);
		}
		return resultadosDevueltos;
	}


	public List<Tbasg107Tipovia> getTipoViaActiveListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG107_TIPOVIA WHERE MRCA_ACTIVO='S' ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg107Tipovia.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg107Tipovia> getTipoViaCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG107_TIPOVIA";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg107Tipovia.class);

		return sqlquery.getResultList();
	}

	public int insertTipoVia(Tbasg107Tipovia bean) {

		String sqlString = "INSERT INTO PASG.TBASG107_TIPOVIA (CDGO_SAP, DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO) VALUES (?,?,?,CURRENT_DATE,?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg107Tipovia.class);
		sqlquery.setParameter(1, bean.getCdgoSap());
		sqlquery.setParameter(2, bean.getDesgNombre());
		sqlquery.setParameter(3, bean.getDesgUsuact());
		sqlquery.setParameter(4, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateTipoVia(Tbasg107Tipovia bean) {

		String sqlString = "UPDATE PASG.TBASG107_TIPOVIA SET CDGO_SAP=:cdgoSap, DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_TIPOVIA=:cdgoTipoVia";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg107Tipovia.class);
		sqlquery.setParameter("cdgoSap", bean.getCdgoSap());
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoTipoVia", bean.getCdgoTipovia());
		return sqlquery.executeUpdate();
	}
	
	public int estadoTipoVia(Tbasg107Tipovia bean) {

		String sqlString = "UPDATE PASG.TBASG107_TIPOVIA SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_TIPOVIA=:cdgoTipoVia";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg107Tipovia.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoTipoVia", bean.getCdgoTipovia());
		return sqlquery.executeUpdate();
	}

}
