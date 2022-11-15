package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg105Areactivi;
import renfe.com.dto.GetAreTerListAscendenteDTO;
import renfe.com.model.entity.Tbasg100Persona;
import renfe.com.model.entity.Tbasg141Areter;
import renfe.com.repository.Tbasg141AreterRepositoryCustom;

public class Tbasg141AreterRepositoryImpl implements Tbasg141AreterRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg141Areter> getAreTerCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG141_ARETER";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg141Areter.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg141Areter> getAreTerListDescendenteCDGO_ARETER(Integer cdgoAreTer) {

		String sqlString = "SELECT T.CDGO_ARETER, T.CDGO_AREACT, T.DESG_NOMBRE, A.DESG_NOMBRE AS DESG_NOMBREAUX, T.DESG_USUACT, T.FCHA_ACT, T.MRCA_ACTIVO FROM PASG.TBASG141_ARETER T, PASG.TBASG105_AREACTIVI A WHERE T.CDGO_AREACT = A.CDGO_AREACT AND T.CDGO_AREACT = :cdgoAreter ORDER BY T.CDGO_ARETER DESC";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("cdgoAreter", cdgoAreTer);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg141Areter> resultadosDevueltos = new ArrayList<>();
			for (Object[] object : resultados) {
				Tbasg141Areter areaTerritorial = new Tbasg141Areter();
				
				areaTerritorial.setCdgoAreter(Integer.valueOf((int)object[0]));
				areaTerritorial.setDesgNombre((String)object[2]);
					
				resultadosDevueltos.add(areaTerritorial);
			}
			return resultadosDevueltos;
	}

	public List<Tbasg141Areter> getAreTerListAscendenteDESG_NOMBRE() {

		String sqlString = "SELECT T.CDGO_ARETER, T.CDGO_AREACT, T.DESG_NOMBRE, A.DESG_NOMBRE AS DESG_NOMBREAUX, T.DESG_USUACT, T.FCHA_ACT, T.MRCA_ACTIVO FROM PASG.TBASG141_ARETER T, PASG.TBASG105_AREACTIVI A WHERE T.CDGO_AREACT = A.CDGO_AREACT ORDER BY T.DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg141Areter.class);

		return sqlquery.getResultList();
	}
	
	public List<GetAreTerListAscendenteDTO> getAreTerListAscendente() {

		String sqlString = "SELECT T.*, A.DESG_NOMBRE AS NOMBRE_AREACT FROM PASG.TBASG141_ARETER T INNER JOIN PASG.TBASG105_AREACTIVI A ON T.CDGO_AREACT = A.CDGO_AREACT ORDER BY T.CDGO_ARETER ";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetAreTerListAscendenteDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetAreTerListAscendenteDTO areter = new GetAreTerListAscendenteDTO();
			
			areter.setCdgoAreter((Integer)object[0]);
			areter.setCdgoAreact((Integer)object[1]);
			areter.setDesgNombre((String)object[2]);
			areter.setDesgUsuact((String)object[3]);
			areter.setFchaAct((Date)object[4]);
			areter.setMrcaActivo((char) object[5]);
			areter.setNombreAreact((String)object[6]);

			resultadosDevueltos.add(areter);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg141Areter> getAreTerListDescendenteDESG_NOMBRE() {

		String sqlString = "SELECT T.CDGO_ARETER, T.CDGO_AREACT, T.DESG_NOMBRE, A.DESG_NOMBRE AS DESG_NOMBREAUX, T.DESG_USUACT, T.FCHA_ACT, T.MRCA_ACTIVO FROM PASG.TBASG141_ARETER T, PASG.TBASG105_AREACTIVI A WHERE T.CDGO_AREACT = A.CDGO_AREACT ORDER BY T.DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg141Areter.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg141Areter> getAreTerActiveListDescendenteCDGO_ARETER() {

		String sqlString = "SELECT T.CDGO_ARETER, T.CDGO_AREACT, T.DESG_NOMBRE, A.DESG_NOMBRE AS DESG_NOMBREAUX, T.DESG_USUACT, T.FCHA_ACT, T.MRCA_ACTIVO FROM PASG.TBASG141_ARETER T, PASG.TBASG105_AREACTIVI A WHERE T.MRCA_ACTIVO='S' AND T.CDGO_AREACT = A.CDGO_AREACT ORDER BY T.CDGO_ARETER DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg141Areter.class);

		return sqlquery.getResultList();
	}
	
	public List<GetAreTerListAscendenteDTO> getAreTerActiveListAscendente() {

		String sqlString = " SELECT T.*, A.DESG_NOMBRE AS NOMBRE_AREACT FROM PASG.TBASG141_ARETER T INNER JOIN PASG.TBASG105_AREACTIVI A ON T.CDGO_AREACT = A.CDGO_AREACT "
				+ " WHERE T.MRCA_ACTIVO = 'S' ORDER BY T.DESG_NOMBRE ";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetAreTerListAscendenteDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetAreTerListAscendenteDTO areter = new GetAreTerListAscendenteDTO();
			
			areter.setCdgoAreter((Integer)object[0]);
			areter.setCdgoAreact((Integer)object[1]);
			areter.setDesgNombre((String)object[2]);
			areter.setDesgUsuact((String)object[3]);
			areter.setFchaAct((Date)object[4]);
			areter.setMrcaActivo((char) object[5]);
			areter.setNombreAreact((String)object[6]);

			resultadosDevueltos.add(areter);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg141Areter> getAreTerActiveListAscendenteDESG_NOMBRE() {

		String sqlString = "SELECT T.CDGO_ARETER, T.CDGO_AREACT, T.DESG_NOMBRE, A.DESG_NOMBRE AS DESG_NOMBREAUX, T.DESG_USUACT, T.FCHA_ACT, T.MRCA_ACTIVO FROM PASG.TBASG141_ARETER T, PASG.TBASG105_AREACTIVI A WHERE T.MRCA_ACTIVO='S' AND T.CDGO_AREACT = A.CDGO_AREACT ORDER BY T.DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg141Areter.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg141Areter> getAreTerActiveListDescendenteDESG_NOMBRE() {

		String sqlString = "SELECT T.CDGO_ARETER, T.CDGO_AREACT, T.DESG_NOMBRE, A.DESG_NOMBRE AS DESG_NOMBREAUX, T.DESG_USUACT, T.FCHA_ACT, T.MRCA_ACTIVO FROM PASG.TBASG141_ARETER T, PASG.TBASG105_AREACTIVI A WHERE T.MRCA_ACTIVO='S' AND T.CDGO_AREACT = A.CDGO_AREACT ORDER BY T.DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg141Areter.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg141Areter> getAreTerActiveListByCdgoAreact(Integer cdgoAreact) {

		String sqlString = "SELECT T.CDGO_ARETER, T.CDGO_AREACT, T.DESG_NOMBRE, T.DESG_USUACT, T.FCHA_ACT, T.MRCA_ACTIVO FROM PASG.TBASG141_ARETER T WHERE T.MRCA_ACTIVO='S' AND T.CDGO_AREACT = ? ORDER BY T.DESG_NOMBRE DESC;";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg141Areter.class);
		sqlquery.setParameter(1, cdgoAreact);

		return sqlquery.getResultList();
	}	

	public List<Tbasg141Areter> getAreTer(String cdgoAreter) {

		String sqlString = "SELECT * FROM PASG.TBASG141_ARETER WHERE CDGO_ARETER=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg141Areter.class);
		sqlquery.setParameter("value", cdgoAreter);
		return sqlquery.getResultList();
	}

	public List<Tbasg141Areter> getListAreTerByCodsAreTer(List<Integer>cdgoAreTerList) {

		StringBuilder strGetListAreTerByCodsAreTer = new StringBuilder();

		String sqlString = "SELECT * FROM PASG.TBASG141_ARETER WHERE 1=1";

		strGetListAreTerByCodsAreTer.append(sqlString);
		System.out.println("----------------------");
		System.out.println(strGetListAreTerByCodsAreTer.toString());
		System.out.println("----------------------");

		if(cdgoAreTerList!=null) {
		strGetListAreTerByCodsAreTer.append(" AND CDGO_AREACT IN (" + cdgoAreTerList.get(0));
		for( int i = 1; i < cdgoAreTerList.size(); i++) {
		strGetListAreTerByCodsAreTer.append("," + cdgoAreTerList.get(i));
		}
		strGetListAreTerByCodsAreTer.append(") ");
		}

		System.out.println("----------------------");
		System.out.println(strGetListAreTerByCodsAreTer.toString());
		System.out.println("----------------------");

		Query sqlquery = em.createNativeQuery(strGetListAreTerByCodsAreTer.toString());



		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg141Areter> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
		Tbasg141Areter area = new Tbasg141Areter();



		area.setCdgoAreter((int)object[0]);
		area.setCdgoAreact((int)object[1]);
		area.setDesgNombre((String)object[2]);
		area.setDesgUsuact((String)object[3]);
		area.setFchaAct((Date)object[4]);
		area.setMrcaActivo(String.valueOf((java.lang.Character) object[5]));



		resultadosDevueltos.add(area);
		}
		return resultadosDevueltos;
		}
	
	
	public int insertAreTer(Tbasg141Areter bean) {

		String sqlString = "INSERT INTO PASG.TBASG141_ARETER (CDGO_ARETER, CDGO_AREACT, DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO) VALUES (?,?,?,?,CURRENT_DATE,?);";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg141Areter.class);
		sqlquery.setParameter(1, bean.getCdgoAreter());
		sqlquery.setParameter(2, bean.getCdgoAreact());
		sqlquery.setParameter(3, bean.getDesgNombre());
		sqlquery.setParameter(4, bean.getDesgUsuact());
		sqlquery.setParameter(5, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateAreTer(Tbasg141Areter bean) {

		String sqlString = "UPDATE PASG.TBASG141_ARETER SET CDGO_AREACT=:cdgoAreAct, DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_ARETER=:cdgoAreTer";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg141Areter.class);
		sqlquery.setParameter("cdgoAreAct", bean.getCdgoAreact());
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoAreTer", bean.getCdgoAreter());
		return sqlquery.executeUpdate();
	}
	
	public int estadoAreTer(Tbasg141Areter bean) {

		String sqlString = "UPDATE PASG.TBASG141_ARETER SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_ARETER=:cdgoAreTer";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg141Areter.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoAreTer", bean.getCdgoAreter());
		return sqlquery.executeUpdate();
	}

	public List<Tbasg141Areter> descAreaActPersona(String cdgoPersona) {

		String sqlString = "select a.DESG_NOMBRE from PASG.TBASG141_ARETER a, PASG.TBASG132_CENTCONT b, PASG.TBASG100_PERSONA c"
				+ "		  where a.CDGO_ARETER = b.CDGO_ARETER" + "				and b.CDGO_CENTCONT = c.CDGO_CENTCONT"
				+ "				and c.CDGO_PERSONA = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg141Areter.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}

}
