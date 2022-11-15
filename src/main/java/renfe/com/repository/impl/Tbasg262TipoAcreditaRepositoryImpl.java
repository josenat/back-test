package renfe.com.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg105Areactivi;
import renfe.com.model.entity.Tbasg262TipoAcredita;
import renfe.com.repository.Tbasg262TipoAcreditaRepositoryCustom;

public class Tbasg262TipoAcreditaRepositoryImpl implements Tbasg262TipoAcreditaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg262TipoAcredita> getTipoAcreditacion(String cdgoTipoacr) {

		String sqlString = "SELECT CDGO_TIPOACR,DESG_ACREDITA FROM PASG.TBASG262_TIPO_ACREDITA WHERE CDGO_TIPOACR = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg262TipoAcredita.class);
		sqlquery.setParameter("value", cdgoTipoacr);
		return sqlquery.getResultList();
	}

	public List<Tbasg262TipoAcredita> getListaTiposAcreditacion() {

		String sqlString = "SELECT CDGO_TIPOACR,DESG_ACREDITA FROM PASG.TBASG262_TIPO_ACREDITA ORDER BY CDGO_TIPOACR";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg262TipoAcredita.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg262TipoAcredita> getListaTiposAcreditacionActiv() {

		String sqlString = "SELECT CDGO_TIPOACR,DESG_ACREDITA FROM PASG.TBASG262_TIPO_ACREDITA WHERE MRCA_ACTIVO = 'S' ORDER BY CDGO_TIPOACR";
		Query sqlquery = em.createNativeQuery(sqlString);


		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg262TipoAcredita> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg262TipoAcredita acreditacion = new Tbasg262TipoAcredita();
			
			acreditacion.setCdgoTipoacr((String)object[0]);
			acreditacion.setDesgAcredita((String)object[1]);
			
			resultadosDevueltos.add(acreditacion);
		}
			return resultadosDevueltos;
	}

	public List<Tbasg262TipoAcredita> getDescTipoAcreditacion(String cdgoTipoacr) {

		String sqlString = "SELECT DESG_ACREDITA  FROM PASG.TBASG262_TIPO_ACREDITA WHERE CDGO_TIPOACR = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg262TipoAcredita.class);
		sqlquery.setParameter("value", cdgoTipoacr);
		return sqlquery.getResultList();
	}
	
	public List<Tbasg262TipoAcredita> getValidezReciclaje(String cdgoTipoacr) {

		String sqlString = "SELECT CDGO_TIPOACR,DESG_ACREDITA,VALIDEZ_RECICLAJE  FROM PASG.TBASG262_TIPO_ACREDITA WHERE CDGO_TIPOACR = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoTipoacr);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg262TipoAcredita> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg262TipoAcredita acreditacion = new Tbasg262TipoAcredita();
			
			acreditacion.setCdgoTipoacr((String)object[0]);
			acreditacion.setDesgAcredita((String)object[1]);
			acreditacion.setValidezReciclaje((Integer)object[2]);
			
			resultadosDevueltos.add(acreditacion);
		}
			return resultadosDevueltos;
	}

}
