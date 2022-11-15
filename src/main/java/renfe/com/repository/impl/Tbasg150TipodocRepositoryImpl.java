package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg150Tipodoc;
import renfe.com.repository.Tbasg150TipodocRepositoryCustom;

public class Tbasg150TipodocRepositoryImpl implements Tbasg150TipodocRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg150Tipodoc> getDescTipoDocumento(String cdgoTipodoc) {

		String sqlString = "SELECT DESG_NOMBRE FROM PASG.TBASG150_TIPODOC WHERE CDGO_TIPODOC = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg150Tipodoc.class);
		sqlquery.setParameter("value", cdgoTipodoc);
		return sqlquery.getResultList();
	}

	/*public List<Tbasg150Tipodoc> getTipoDocListByCodigo() {

		String sqlString = "SELECT * FROM PASG.TBASG150_TIPODOC WHERE MRCA_ACTIVO='S' ORDER BY CDGO_TIPODOC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg150Tipodoc.class);

		return sqlquery.getResultList();
	}*/
	
	public List<Tbasg150Tipodoc> getTipoDocListByCodigo() {

		String sqlString = "SELECT * FROM PASG.TBASG150_TIPODOC WHERE MRCA_ACTIVO='S' ORDER BY CDGO_TIPODOC";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg150Tipodoc> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg150Tipodoc tipodoc = new Tbasg150Tipodoc();

			tipodoc.setCdgoTipodoc(Long.valueOf((int)object[0]));
			tipodoc.setDesgNombre((String)object[1]);
			tipodoc.setDesgUsuact((String)object[2]);
			tipodoc.setFchaAct((Date) object[3]);
			tipodoc.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));

			resultadosDevueltos.add(tipodoc);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg150Tipodoc> getTipoDocCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG150_TIPODOC WHERE MRCA_ACTIVO='S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg150Tipodoc.class);

		return sqlquery.getResultList();
	}

}
