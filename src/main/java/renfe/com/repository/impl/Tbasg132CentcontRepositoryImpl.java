package renfe.com.repository.impl;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.dto.GetCentContListAscendenteeDTO;
import renfe.com.model.entity.Tbasg105Areactivi;
import renfe.com.model.entity.Tbasg132Centcont;
import renfe.com.repository.Tbasg132CentcontRepositoryCustom;

public class Tbasg132CentcontRepositoryImpl implements Tbasg132CentcontRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg132Centcont> getCentContListRegistroAscendente() {

		String sqlString = "SELECT CDGO_CENTCONT FROM PASG.TBASG132_CENTCONT ORDER BY CDGO_CENTCONT";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg132Centcont.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg132Centcont> getCentContListRegistroDescendente() {

		String sqlString = "SELECT CDGO_CENTCONT FROM PASG.TBASG132_CENTCONT ORDER BY CDGO_CENTCONT DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg132Centcont.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg132Centcont> getCentContCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG132_CENTCONT";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg132Centcont.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg132Centcont> getCentContListAscendente(String cdgoAreter) {
		
		String sqlString = "SELECT C.CDGO_CENTCONT, C.CDGO_ARETER, C.DESG_NOMBRE, A.DESG_NOMBRE AS DESG_NOMBREAUX, C.DESG_USUACT, C.FCHA_ACT, C.MRCA_ACTIVO, C.DESG_BUZONCORREO FROM PASG.TBASG132_CENTCONT C, PASG.TBASG141_ARETER A WHERE C.CDGO_ARETER = A.CDGO_ARETER AND C.CDGO_ARETER = :cdgoAreTer ORDER BY C.CDGO_CENTCONT";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("cdgoAreTer", cdgoAreter);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg132Centcont> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg132Centcont centro = new Tbasg132Centcont();
			
			centro.setCdgoCentcont((String)object[0]);
			centro.setDesgNombre((String)object[2]);
			
			
			resultadosDevueltos.add(centro);
		}
			return resultadosDevueltos;
		
	}
	
	public List<GetCentContListAscendenteeDTO> getCentContListAscendentee() {
		
		String sqlString = "SELECT C.*, A.DESG_NOMBRE AS AREA_TERRITORIAL FROM PASG.TBASG132_CENTCONT C INNER JOIN PASG.TBASG141_ARETER A ON C.CDGO_ARETER = A.CDGO_ARETER ORDER BY C.CDGO_CENTCONT";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetCentContListAscendenteeDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetCentContListAscendenteeDTO centro = new GetCentContListAscendenteeDTO();

			centro.setCdgoCentcont((String)object[0]);
			centro.setCdgoAreter((Integer) object[1]);
			centro.setDesgNombre((String)object[2]);
			centro.setDesgUsuact((String)object[3]);
			centro.setFchaAct((Date) object[4]);
			centro.setMrcaActivo(String.valueOf((Character) object[5]));
			centro.setDesgBuzoncorreo((String)object[6]);
			centro.setAreaTerritorial((String)object[7]);
			
			resultadosDevueltos.add(centro);
		}
			return resultadosDevueltos;
		
	}

	public List<Tbasg132Centcont> getCentContListDescendente() {

		String sqlString = "SELECT C.CDGO_CENTCONT, C.CDGO_ARETER, C.DESG_NOMBRE, A.DESG_NOMBRE AS DESG_NOMBREAUX, C.DESG_USUACT, C.FCHA_ACT, C.MRCA_ACTIVO, C.DESG_BUZONCORREO FROM PASG.TBASG132_CENTCONT C, PASG.TBASG141_ARETER A WHERE C.CDGO_ARETER = A.CDGO_ARETER ORDER BY C.CDGO_CENTCONT DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg132Centcont.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg132Centcont> getCentContListAscendenteDESG_NOMBRE_PMG() {

		String sqlString = "SELECT C.CDGO_CENTCONT, C.CDGO_ARETER, C.DESG_NOMBRE, A.DESG_NOMBRE AS DESG_NOMBREAUX, C.DESG_USUACT, C.FCHA_ACT, C.MRCA_ACTIVO, C.DESG_BUZONCORREO "
				+ "        FROM PASG.TBASG132_CENTCONT C, PASG.TBASG141_ARETER A "
				+ "        WHERE C.CDGO_ARETER = A.CDGO_ARETER" + "          AND C.MRCA_ACTIVO = 'S'"
				+ "        ORDER BY C.DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg132Centcont.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg132Centcont> getCentContListDescendenteDESG_NOMBRE_PMG() {

		String sqlString = "SELECT C.CDGO_CENTCONT, C.CDGO_ARETER, C.DESG_NOMBRE, A.DESG_NOMBRE AS DESG_NOMBREAUX, C.DESG_USUACT, C.FCHA_ACT, C.MRCA_ACTIVO, C.DESG_BUZONCORREO "
				+ "        FROM PASG.TBASG132_CENTCONT C, PASG.TBASG141_ARETER A"
				+ "        WHERE C.CDGO_ARETER = A.CDGO_ARETER " + "          AND C.MRCA_ACTIVO = 'S'"
				+ "        ORDER BY C.DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg132Centcont.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg132Centcont> getCentContListAscendenteCDGO_CENTCONT() {

		String sqlString = "SELECT C.CDGO_CENTCONT, C.CDGO_ARETER, C.DESG_NOMBRE, A.DESG_NOMBRE AS DESG_NOMBREAUX, C.DESG_USUACT, C.FCHA_ACT, C.MRCA_ACTIVO, C.DESG_BUZONCORREO  FROM PASG.TBASG132_CENTCONT C, PASG.TBASG141_ARETER A WHERE C.CDGO_ARETER = A.CDGO_ARETER ORDER BY C.CDGO_CENTCONT";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg132Centcont.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg132Centcont> getCentContListDescendenteCDGO_CENTCONT() {

		String sqlString = "SELECT C.CDGO_CENTCONT, C.CDGO_ARETER, C.DESG_NOMBRE, A.DESG_NOMBRE AS DESG_NOMBREAUX, C.DESG_USUACT, C.FCHA_ACT, C.MRCA_ACTIVO, C.DESG_BUZONCORREO  FROM PASG.TBASG132_CENTCONT C, PASG.TBASG141_ARETER A WHERE C.CDGO_ARETER = A.CDGO_ARETER ORDER BY C.CDGO_CENTCONT DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg132Centcont.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg132Centcont> getCentContListByCdgoAreter(Integer cdgoAreter) {

		String sqlString = "SELECT * FROM PASG.TBASG132_CENTCONT WHERE MRCA_ACTIVO ='S' AND CDGO_ARETER = ? ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg132Centcont.class);
		sqlquery.setParameter(1,  cdgoAreter);

		return sqlquery.getResultList();
	}	

	public List<Tbasg132Centcont> getCentContListAscendenteDESG_NOMBRE() {

		String sqlString = "SELECT C.CDGO_CENTCONT, C.CDGO_ARETER, C.DESG_NOMBRE, A.DESG_NOMBRE AS DESG_NOMBREAUX, C.DESG_USUACT, C.FCHA_ACT, C.MRCA_ACTIVO, C.DESG_BUZONCORREO  FROM PASG.TBASG132_CENTCONT C, PASG.TBASG141_ARETER A WHERE C.CDGO_ARETER = A.CDGO_ARETER ORDER BY C.DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg132Centcont.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg132Centcont> getCentContListDescendenteDESG_NOMBRE() {

		String sqlString = "SELECT C.CDGO_CENTCONT, C.CDGO_ARETER, C.DESG_NOMBRE, A.DESG_NOMBRE AS DESG_NOMBREAUX, C.DESG_USUACT, C.FCHA_ACT, C.MRCA_ACTIVO, C.DESG_BUZONCORREO  FROM PASG.TBASG132_CENTCONT C, PASG.TBASG141_ARETER A WHERE C.CDGO_ARETER = A.CDGO_ARETER ORDER BY C.DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg132Centcont.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg132Centcont> getCentCont(String cdgoCentcont) {

		String sqlString = "SELECT * FROM PASG.TBASG132_CENTCONT WHERE CDGO_CENTCONT=:value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoCentcont);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg132Centcont> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg132Centcont centro = new Tbasg132Centcont();
			
			centro.setCdgoCentcont((String)object[0]);
			centro.setCdgoAreter((Integer) object[1]);
			centro.setDesgNombre((String)object[2]);
			centro.setDesgUsuact((String)object[3]);
			centro.setFchaAct((Date) object[4]);
			centro.setMrcaActivo(String.valueOf((Character) object[5]));
			centro.setDesgBuzoncorreo((String)object[6]);

			resultadosDevueltos.add(centro);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg132Centcont> getListCentContActive(Integer cdgoAreTer) {
		String sqlString = "SELECT * FROM PASG.TBASG132_CENTCONT WHERE MRCA_ACTIVO ='S' AND CDGO_ARETER=:cdgoAreter ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);

		sqlquery.setParameter("cdgoAreter", cdgoAreTer);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg132Centcont> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg132Centcont centro = new Tbasg132Centcont();
			
			centro.setCdgoCentcont(((String)object[0]).trim());
			centro.setDesgNombre((String)object[2]);
			
			
			resultadosDevueltos.add(centro);
		}
			return resultadosDevueltos;

	}

	public int insertCentCont(Tbasg132Centcont bean) {

		String sqlString = "INSERT INTO PASG.TBASG132_CENTCONT (CDGO_CENTCONT, CDGO_ARETER, DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO, DESG_BUZONCORREO) VALUES (?,?,?,?,CURRENT_DATE,?,?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg132Centcont.class);
		sqlquery.setParameter(1, bean.getCdgoCentcont());
		sqlquery.setParameter(2, bean.getCdgoAreter());
		sqlquery.setParameter(3, bean.getDesgNombre());
		sqlquery.setParameter(4, bean.getDesgUsuact());
		sqlquery.setParameter(5, bean.getMrcaActivo());
		sqlquery.setParameter(6, bean.getDesgBuzoncorreo());
		return sqlquery.executeUpdate();
	}

	public int updateCentCont(Tbasg132Centcont bean) {

		String sqlString = "UPDATE PASG.TBASG132_CENTCONT SET CDGO_ARETER=:cdgoAreTer, DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE, DESG_BUZONCORREO=:buzonCorreo WHERE CDGO_CENTCONT=:cdgoCentCont";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg132Centcont.class);
		sqlquery.setParameter("cdgoAreTer", bean.getCdgoAreter());
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("buzonCorreo", bean.getDesgBuzoncorreo());
		sqlquery.setParameter("cdgoCentCont", bean.getCdgoCentcont());
		return sqlquery.executeUpdate();
	}
	
	public int estadoCentCont(Tbasg132Centcont bean) {

		String sqlString = "UPDATE PASG.TBASG132_CENTCONT SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_CENTCONT=:cdgoCentCont";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg132Centcont.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoCentCont", bean.getCdgoCentcont());
		return sqlquery.executeUpdate();
	}

}
