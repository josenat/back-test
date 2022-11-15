package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg106Provincia;
import renfe.com.repository.Tbasg106ProvinciaRepositoryCustom;

public class Tbasg106ProvinciaRepositoryImpl implements Tbasg106ProvinciaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg106Provincia> getProvinciaCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG106_PROVINCIA";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg106Provincia.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg106Provincia> getProvinciaListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG106_PROVINCIA ORDER BY CDGO_PROVINCIA";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg106Provincia> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg106Provincia provincia = new Tbasg106Provincia();
			
			provincia.setCdgoProvincia(Long.valueOf((int)object[0]));
			provincia.setDesgNombre((String)object[1]);
			provincia.setDesgUsuact((String)object[2]);
			provincia.setFchaAct((Date) object[3]);
			provincia.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));

			resultadosDevueltos.add(provincia);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg106Provincia> getProvinciaListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG106_PROVINCIA ORDER BY CDGO_PROVINCIA DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg106Provincia.class);

		return sqlquery.getResultList();
	}

	/*public List<Tbasg106Provincia> getProvinciaListActiveAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG106_PROVINCIA WHERE MRCA_ACTIVO='S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg106Provincia.class);

		return sqlquery.getResultList();
	}*/
	
	public List<Tbasg106Provincia> getProvinciaListActiveAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG106_PROVINCIA WHERE MRCA_ACTIVO='S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg106Provincia> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg106Provincia provincia = new Tbasg106Provincia();

			provincia.setCdgoProvincia(Long.valueOf((int)object[0]));
			provincia.setDesgNombre((String)object[1]);
			provincia.setDesgUsuact((String)object[2]);
			provincia.setFchaAct((Date) object[3]);
			provincia.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));

			resultadosDevueltos.add(provincia);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg106Provincia> getProvinciaListActiveDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG106_PROVINCIA WHERE MRCA_ACTIVO='S' ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg106Provincia.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg106Provincia> getProvincia(String cdgoProvincia) {

		String sqlString = "SELECT * FROM PASG.TBASG106_PROVINCIA WHERE CDGO_PROVINCIA=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg106Provincia.class);
		sqlquery.setParameter("value", cdgoProvincia);
		return sqlquery.getResultList();
	}

	public int insertProvincia(Tbasg106Provincia bean) {

		String sqlString = "INSERT INTO PASG.TBASG106_PROVINCIA (CDGO_PROVINCIA, DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO) VALUES (?,?,?,CURRENT_DATE,?);";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg106Provincia.class);
		sqlquery.setParameter(1, bean.getCdgoProvincia());
		sqlquery.setParameter(2, bean.getDesgNombre());
		sqlquery.setParameter(3, bean.getDesgUsuact());
		sqlquery.setParameter(4, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateProvincia(Tbasg106Provincia bean) {

		String sqlString = "UPDATE PASG.TBASG106_PROVINCIA SET DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_PROVINCIA=:cdgoProvincia";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg106Provincia.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoProvincia", bean.getCdgoProvincia());
		return sqlquery.executeUpdate();
	}
	
	public int estadoProvincia(Tbasg106Provincia bean) {

		String sqlString = "UPDATE PASG.TBASG106_PROVINCIA SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_PROVINCIA=:cdgoProvincia";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg106Provincia.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoProvincia", bean.getCdgoProvincia());
		return sqlquery.executeUpdate();
	}

}
