package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.dto.GetCentFormaListAscCentHgadoDTO;
import renfe.com.model.dto.Tbasg120CentformaDto;
import renfe.com.model.entity.Tbasg120Centforma;
import renfe.com.repository.Tbasg120CentformaRepositoryCustom;

public class Tbasg120CentformaRepositoryImpl implements Tbasg120CentformaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg120CentformaDto> getCentroForName(String desgNombre) {

		String sqlString = "SELECT CDGO_CENTROFOR FROM PASG.TBASG120_CENTFORMA WHERE DESG_NOMBRE LIKE :desgNombre AND MRCA_ACTIVO = 'S'";		
		
		Query sqlquery = em.createNativeQuery(sqlString);
		
		sqlquery.setParameter("desgNombre", "%"+ desgNombre +"%");

		List<Integer> results = sqlquery.getResultList();
		List<Tbasg120CentformaDto> resultList = new ArrayList<>();
  
		for (Integer item : results) {
		  Tbasg120CentformaDto centro = new Tbasg120CentformaDto();
		  centro.setCdgoCentrofor(item);
		  resultList.add(centro);
		}
  
		return resultList;		
	}

	public List<Tbasg120Centforma> getCentFormaCount() {

		String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG120_CENTFORMA";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg120Centforma.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg120Centforma> getCentFormaViewCount(String cdgoCenthgado) {

		String sqlString = "SELECT COUNT(*) as value"
				+ "		FROM PASG.TBASG120_CENTFORMA C, PASG.TBASG143_CENTHGADO H"
				+ "		WHERE C.CDGO_CENTHGADO = H.CDGO_CENTHGADO AND C.CDGO_CENTHGADO = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg120Centforma.class);
		sqlquery.setParameter("value", cdgoCenthgado);
		return sqlquery.getResultList();
	}

	public List<Tbasg120Centforma> getCentFormaListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG120_CENTFORMA ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg120Centforma> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg120Centforma centforma = new Tbasg120Centforma();
			
			centforma.setCdgoCentrofor(Integer.valueOf((int)object[0]));
			centforma.setCdgoCenthgado((Integer)object[1]);
			centforma.setCdgoSap((String)object[2]);
			centforma.setCdgoRef((String)object[3]);
			centforma.setDesgNombre((String)object[4]);
			centforma.setDesgNifdirector((String)object[5]);
			centforma.setDesgNomdirector((String)object[6]);
			centforma.setDesgDomcentro((String)object[7]);
			centforma.setFchaHomologa((Date) object[8]);
			centforma.setFchaValidez((Date) object[9]);
			centforma.setDesgTelefono((Integer)object[10]);
			centforma.setDesgPersocontac((String)object[11]);
			centforma.setDesgUsuact((String)object[12]);
			centforma.setFchaAct((Date) object[13]);
			centforma.setMrcaActivo(String.valueOf((java.lang.Character) object[14]));

			resultadosDevueltos.add(centforma);
		}
		return resultadosDevueltos;
	}
	
	public List<GetCentFormaListAscCentHgadoDTO> getCentFormaListAscCentHgado(Integer cdgoCenthgado) {

		String sqlString = "SELECT CF.*, CG.DESG_CIF FROM PASG.TBASG120_CENTFORMA CF INNER JOIN PASG.TBASG143_CENTHGADO CG ON CF.CDGO_CENTHGADO = CG.CDGO_CENTHGADO "
				+ "WHERE CG.CDGO_CENTHGADO = :cdgoCenthgado ORDER BY DESG_NOMBRE";
		
		Query sqlquery = em.createNativeQuery(sqlString);
		
		sqlquery.setParameter("cdgoCenthgado", cdgoCenthgado);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetCentFormaListAscCentHgadoDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetCentFormaListAscCentHgadoDTO centforma = new GetCentFormaListAscCentHgadoDTO();
			
			centforma.setCdgoCentrofor((Integer)object[0]);
			centforma.setCdgoCenthgado((Integer)object[1]);
			centforma.setCdgoSap((String)object[2]);
			centforma.setCdgoRef((String)object[3]);
			centforma.setDesgNombre((String)object[4]);
			centforma.setDesgNifdirector((String)object[5]);
			centforma.setDesgNomdirector((String)object[6]);
			centforma.setDesgDomcentro((String)object[7]);
			centforma.setFchaHomologa((Date) object[8]);
			centforma.setFchaValidez((Date) object[9]);
			centforma.setDesgTelefono((Integer)object[10]);
			centforma.setDesgPersocontac((String)object[11]);
			centforma.setDesgUsuact((String)object[12]);
			centforma.setFchaAct((Date) object[13]);
			centforma.setMrcaActivo(String.valueOf((java.lang.Character) object[14]));
			centforma.setDesgCif((String)object[15]);

			resultadosDevueltos.add(centforma);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg120Centforma> getCentFormaListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG120_CENTFORMA ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg120Centforma.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg120Centforma> getCentFormaActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG120_CENTFORMA WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg120Centforma> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg120Centforma centforma = new Tbasg120Centforma();

			centforma.setCdgoCentrofor(Integer.valueOf((int)object[0]));
			centforma.setCdgoCenthgado((Integer)object[1]);
			centforma.setCdgoSap((String)object[2]);
			centforma.setCdgoRef((String)object[3]);
			centforma.setDesgNombre((String)object[4]);
			centforma.setDesgNifdirector((String)object[5]);
			centforma.setDesgNomdirector((String)object[6]);
			centforma.setDesgDomcentro((String)object[7]);
			centforma.setFchaHomologa((Date) object[8]);
			centforma.setFchaValidez((Date) object[9]);
			centforma.setDesgTelefono((Integer)object[10]);
			centforma.setDesgPersocontac((String)object[11]);
			centforma.setDesgUsuact((String)object[12]);
			centforma.setFchaAct((Date) object[13]);
			centforma.setMrcaActivo(String.valueOf((java.lang.Character) object[14]));

			resultadosDevueltos.add(centforma);
		}
		return resultadosDevueltos;
	}
	
	public List<Tbasg120Centforma> getCentFormaActiveListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG120_CENTFORMA WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg120Centforma.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg120Centforma> getCentForma(String cdgoCentrofor) {

		String sqlString = "SELECT * FROM PASG.TBASG120_CENTFORMA WHERE CDGO_CENTROFOR=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg120Centforma.class);
		sqlquery.setParameter("value", cdgoCentrofor);
		return sqlquery.getResultList();
	}

	public List<Tbasg120Centforma> getCentFormaListAscendenteViewCDGO_CENTFORMA(String cdgoCenthgado) {

		String sqlString = "SELECT C.*, H.DESG_NOMBRE AS DESG_CENTHGADO, H.DESG_CIF, H.DESG_DOMSOCIAL FROM PASG.TBASG120_CENTFORMA C, PASG.TBASG143_CENTHGADO H"
				+ "		WHERE C.CDGO_CENTHGADO = H.CDGO_CENTHGADO AND C.CDGO_CENTHGADO = :value ORDER BY C.DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg120Centforma.class);
		sqlquery.setParameter("value", cdgoCenthgado);
		return sqlquery.getResultList();
	}

	public List<Tbasg120Centforma> getCentFormaListDescendenteViewCDGO_CENTFORMA(String cdgoCenthgado) {

		String sqlString = "SELECT C.*, H.DESG_NOMBRE AS DESG_CENTHGADO, H.DESG_CIF, H.DESG_DOMSOCIAL FROM PASG.TBASG120_CENTFORMA C, PASG.TBASG143_CENTHGADO H"
				+ "		WHERE C.CDGO_CENTHGADO = H.CDGO_CENTHGADO AND C.CDGO_CENTHGADO = :value ORDER BY C.DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg120Centforma.class);
		sqlquery.setParameter("value", cdgoCenthgado);
		return sqlquery.getResultList();
	}

	public List<Tbasg120Centforma> getCentFormaActiveListAscendenteViewCDGO_CENTFORMA(String cdgoCenthgado) {

		String sqlString = "SELECT C.*, H.DESG_NOMBRE AS DESG_CENTHGADO, H.DESG_CIF, H.DESG_DOMSOCIAL FROM PASG.TBASG120_CENTFORMA C, PASG.TBASG143_CENTHGADO H"
				+ "		WHERE C.CDGO_CENTHGADO = H.CDGO_CENTHGADO AND C.CDGO_CENTHGADO = :value AND C.MRCA_ACTIVO = 'S' ORDER BY C.DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg120Centforma.class);
		sqlquery.setParameter("value", cdgoCenthgado);
		return sqlquery.getResultList();
	}

	public List<Tbasg120Centforma> getCentFormaActiveListDescendenteViewCDGO_CENTFORMA(String cdgoCenthgado) {

		String sqlString = "SELECT C.*, H.DESG_NOMBRE AS DESG_CENTHGADO, H.DESG_CIF, H.DESG_DOMSOCIAL FROM PASG.TBASG120_CENTFORMA C, PASG.TBASG143_CENTHGADO H"
				+ "		WHERE C.CDGO_CENTHGADO = H.CDGO_CENTHGADO AND C.CDGO_CENTHGADO = :value AND C.MRCA_ACTIVO = 'S' ORDER BY C.DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg120Centforma.class);
		sqlquery.setParameter("value", cdgoCenthgado);
		return sqlquery.getResultList();
	}

	public int insertCentForma(Tbasg120Centforma bean) {

		String sqlString = "INSERT INTO PASG.TBASG120_CENTFORMA (CDGO_CENTHGADO, CDGO_SAP, CDGO_REF, DESG_NOMBRE, DESG_NIFDIRECTOR, DESG_NOMDIRECTOR, DESG_DOMCENTRO, DESG_TELEFONO, "
				+ "		DESG_PERSOCONTAC, FCHA_HOMOLOGA, FCHA_VALIDEZ, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg120Centforma.class);
		sqlquery.setParameter(1, bean.getCdgoCenthgado());
		sqlquery.setParameter(2, bean.getCdgoSap());
		sqlquery.setParameter(3, bean.getCdgoRef());
		sqlquery.setParameter(4, bean.getDesgNombre());
		sqlquery.setParameter(5, bean.getDesgNifdirector());
		sqlquery.setParameter(6, bean.getDesgNomdirector());
		sqlquery.setParameter(7, bean.getDesgDomcentro());
		sqlquery.setParameter(8, bean.getDesgTelefono());
		sqlquery.setParameter(9, bean.getDesgPersocontac());
		sqlquery.setParameter(10, bean.getFchaHomologa());
		sqlquery.setParameter(11, bean.getFchaValidez());
		sqlquery.setParameter(12, bean.getDesgUsuact());
		sqlquery.setParameter(13, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateCentForma(Tbasg120Centforma bean) {

		String sqlString = "UPDATE PASG.TBASG120_CENTFORMA SET CDGO_CENTHGADO=?, CDGO_SAP=?, CDGO_REF=?, DESG_NOMBRE=?, DESG_NIFDIRECTOR=?, DESG_NOMDIRECTOR=?, "
				+ "						DESG_DOMCENTRO=?, DESG_TELEFONO=?, DESG_PERSOCONTAC=?, FCHA_HOMOLOGA=?, "
				+ "						FCHA_VALIDEZ=?, DESG_USUACT=?, FCHA_ACT=CURRENT_DATE  WHERE CDGO_CENTROFOR=?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg120Centforma.class);
		sqlquery.setParameter(1, bean.getCdgoCenthgado());
		sqlquery.setParameter(2, bean.getCdgoSap());
		sqlquery.setParameter(3, bean.getCdgoRef());
		sqlquery.setParameter(4, bean.getDesgNombre());
		sqlquery.setParameter(5, bean.getDesgNifdirector());
		sqlquery.setParameter(6, bean.getDesgNomdirector());
		sqlquery.setParameter(7, bean.getDesgDomcentro());
		sqlquery.setParameter(8, bean.getDesgTelefono());
		sqlquery.setParameter(9, bean.getDesgPersocontac());
		sqlquery.setParameter(10, bean.getFchaHomologa());
		sqlquery.setParameter(11, bean.getFchaValidez());
		sqlquery.setParameter(12, bean.getDesgUsuact());
		sqlquery.setParameter(13, bean.getCdgoCentrofor());
		return sqlquery.executeUpdate();
	}
	
	public int estadoCentForma(Tbasg120Centforma bean) {

		String sqlString = "UPDATE PASG.TBASG120_CENTFORMA SET MRCA_ACTIVO=?, DESG_USUACT=?, FCHA_ACT=CURRENT_DATE  WHERE CDGO_CENTROFOR=?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg120Centforma.class);
		sqlquery.setParameter(1, bean.getMrcaActivo());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getCdgoCentrofor());
		return sqlquery.executeUpdate();
	}

	public int deleteCentFormaByCentHgado(Tbasg120Centforma bean) {

		String sqlString = "UPDATE PASG.TBASG120_CENTFORMA SET " + "		DESG_USUACT = :usuAct,"
				+ "		FCHA_ACT = CURRENT_DATE," + "		MRCA_ACTIVO = 'N'"
				+ "		WHERE CDGO_CENTHGADO = :cdgoCentHgado";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg120Centforma.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoCentHgado", bean.getCdgoCenthgado());
		return sqlquery.executeUpdate();
	}

}
