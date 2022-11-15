package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.dto.GetCentMedicListAscCentHgadoDTO;
import renfe.com.model.entity.Tbasg108Centmedic;
import renfe.com.repository.Tbasg108CentmedicRepositoryCustom;

public class Tbasg108CentmedicRepositoryImpl implements Tbasg108CentmedicRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg108Centmedic> getCentMedicCount() {

		String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG108_CENTMEDIC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg108Centmedic.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg108Centmedic> getCentMedicViewCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG108_CENTMEDIC C, PASG.TBASG143_CENTHGADO H"
				+ "		WHERE C.CDGO_CENTHGADO = H.CDGO_CENTHGADO";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg108Centmedic.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg108Centmedic> getCentMedicListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG108_CENTMEDIC ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg108Centmedic> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg108Centmedic centmedic = new Tbasg108Centmedic();
			
			centmedic.setCdgoCenmed((int)object[0]);
			centmedic.setCdgoCenthgado((Integer)object[1]);
			centmedic.setCdgoSap((String)object[2]);
			centmedic.setCdgoRef((String)object[3]);
			centmedic.setDesgNombre((String)object[4]);
			centmedic.setDesgNifdirector((String)object[5]);
			centmedic.setDesgNomdirector((String)object[6]);
			centmedic.setDesgDomcentro((String)object[7]);
			centmedic.setDesgTelefono((Integer)object[8]);
			centmedic.setFchaHomologa( (Date) object[9]);
			centmedic.setFchaValidez((Date) object[10]);
			centmedic.setDesgUsuact((String)object[11]);
			centmedic.setFchaAct((Date) object[12]);
			centmedic.setMrcaActivo(String.valueOf((java.lang.Character) object[13]));

			resultadosDevueltos.add(centmedic);
		}
		return resultadosDevueltos;
	}
	
	public List<GetCentMedicListAscCentHgadoDTO> getCentMedicListAscCentHgado(Integer cdgoCenthgado) {

		String sqlString = "SELECT CM.*, CG.DESG_CIF FROM PASG.TBASG108_CENTMEDIC CM INNER JOIN PASG.TBASG143_CENTHGADO CG ON CM.CDGO_CENTHGADO = CG.CDGO_CENTHGADO \r\n"
				+ "WHERE CG.CDGO_CENTHGADO = :cdgoCenthgado ORDER BY DESG_NOMBRE";
		
		Query sqlquery = em.createNativeQuery(sqlString);
		
		sqlquery.setParameter("cdgoCenthgado", cdgoCenthgado);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetCentMedicListAscCentHgadoDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetCentMedicListAscCentHgadoDTO centmedic = new GetCentMedicListAscCentHgadoDTO();
			
			centmedic.setCdgoCenmed((int)object[0]);
			centmedic.setCdgoCenthgado((Integer)object[1]);
			centmedic.setCdgoSap((String)object[2]);
			centmedic.setCdgoRef((String)object[3]);
			centmedic.setDesgNombre((String)object[4]);
			centmedic.setDesgNifdirector((String)object[5]);
			centmedic.setDesgNomdirector((String)object[6]);
			centmedic.setDesgDomcentro((String)object[7]);
			centmedic.setDesgTelefono((Integer)object[8]);
			centmedic.setFchaHomologa( (Date) object[9]);
			centmedic.setFchaValidez((Date) object[10]);
			centmedic.setDesgUsuact((String)object[11]);
			centmedic.setFchaAct((Date) object[12]);
			centmedic.setMrcaActivo(String.valueOf((java.lang.Character) object[13]));
			centmedic.setDesgCif((String)object[14]);

			resultadosDevueltos.add(centmedic);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg108Centmedic> getCentMedicListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG108_CENTMEDIC ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg108Centmedic.class);

		return sqlquery.getResultList();
	}

	/*public List<Tbasg108Centmedic> getCentMedicActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG108_CENTMEDIC WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg108Centmedic.class);

		return sqlquery.getResultList();
	}*/
	
	public List<Tbasg108Centmedic> getCentMedicActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG108_CENTMEDIC WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE ASC";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg108Centmedic> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg108Centmedic centmedic = new Tbasg108Centmedic();

			centmedic.setCdgoCenmed((int)object[0]);
			centmedic.setCdgoCenthgado((Integer)object[1]);
			centmedic.setCdgoSap((String)object[2]);
			centmedic.setCdgoRef((String)object[3]);
			centmedic.setDesgNombre((String)object[4]);
			centmedic.setDesgNifdirector((String)object[5]);
			centmedic.setDesgNomdirector((String)object[6]);
			centmedic.setDesgDomcentro((String)object[7]);
			centmedic.setDesgTelefono((Integer)object[8]);
			centmedic.setFchaHomologa((Date) object[9]);
			centmedic.setFchaValidez((Date) object[10]);
			centmedic.setDesgUsuact((String)object[11]);
			centmedic.setFchaAct((Date) object[12]);
			centmedic.setMrcaActivo(String.valueOf((java.lang.Character) object[13]));

			resultadosDevueltos.add(centmedic);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg108Centmedic> getCentMedicActiveListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG108_CENTMEDIC WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg108Centmedic.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg108Centmedic> getCentMedic(Integer cdgoCenmed) {

		String sqlString = "SELECT * FROM PASG.TBASG108_CENTMEDIC WHERE CDGO_CENMED=:value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoCenmed);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg108Centmedic> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg108Centmedic centmedic = new Tbasg108Centmedic();

			centmedic.setCdgoCenmed((int)object[0]);
			centmedic.setCdgoCenthgado((Integer)object[1]);
			centmedic.setCdgoSap((String)object[2]);
			centmedic.setCdgoRef((String)object[3]);
			centmedic.setDesgNombre((String)object[4]);
			centmedic.setDesgNifdirector((String)object[5]);
			centmedic.setDesgNomdirector((String)object[6]);
			centmedic.setDesgDomcentro((String)object[7]);
			centmedic.setDesgTelefono((Integer)object[8]);
			centmedic.setFchaHomologa((Date) object[9]);
			centmedic.setFchaValidez((Date) object[10]);
			centmedic.setDesgUsuact((String)object[11]);
			centmedic.setFchaAct((Date) object[12]);
			centmedic.setMrcaActivo(String.valueOf((java.lang.Character) object[13]));

			resultadosDevueltos.add(centmedic);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg108Centmedic> getCentMedicActiveListAscendenteViewCDGO_CENTMEDIC(String cdgoCenthgado) {

		String sqlString = "SELECT C.*, H.DESG_NOMBRE  AS DESG_CENTHGADO, H.DESG_CIF, H.DESG_DOMSOCIAL FROM PASG.TBASG108_CENTMEDIC C, PASG.TBASG143_CENTHGADO H"
				+ "		WHERE C.CDGO_CENTHGADO = H.CDGO_CENTHGADO AND C.CDGO_CENTHGADO = :value AND C.MRCA_ACTIVO = 'S' ORDER BY C.DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg108Centmedic.class);
		sqlquery.setParameter("value", cdgoCenthgado);
		return sqlquery.getResultList();
	}

	public List<Tbasg108Centmedic> getCentMedicActiveListDescendenteViewCDGO_CENTMEDIC(String cdgoCenthgado) {

		String sqlString = "SELECT C.*, H.DESG_NOMBRE  AS DESG_CENTHGADO, H.DESG_CIF, H.DESG_DOMSOCIAL FROM PASG.TBASG108_CENTMEDIC C, PASG.TBASG143_CENTHGADO H"
				+ "		WHERE C.CDGO_CENTHGADO = H.CDGO_CENTHGADO AND C.CDGO_CENTHGADO = :value AND C.MRCA_ACTIVO = 'S' ORDER BY C.DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg108Centmedic.class);
		sqlquery.setParameter("value", cdgoCenthgado);
		return sqlquery.getResultList();
	}

	public List<Tbasg108Centmedic> getCentMedicListAscendenteViewCDGO_CENTMEDIC(String cdgoCenthgado) {

		String sqlString = "SELECT C.*, H.DESG_NOMBRE  AS DESG_CENTHGADO, H.DESG_CIF, H.DESG_DOMSOCIAL FROM PASG.TBASG108_CENTMEDIC C, PASG.TBASG143_CENTHGADO H"
				+ "		WHERE C.CDGO_CENTHGADO = H.CDGO_CENTHGADO AND C.CDGO_CENTHGADO = :value ORDER BY C.DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg108Centmedic.class);
		sqlquery.setParameter("value", cdgoCenthgado);
		return sqlquery.getResultList();
	}

	public List<Tbasg108Centmedic> getCentMedicListDescendenteViewCDGO_CENTMEDIC(String cdgoCenthgado) {

		String sqlString = "SELECT C.*, H.DESG_NOMBRE  AS DESG_CENTHGADO, H.DESG_CIF, H.DESG_DOMSOCIAL FROM PASG.TBASG108_CENTMEDIC C, PASG.TBASG143_CENTHGADO H"
				+ "		WHERE C.CDGO_CENTHGADO = H.CDGO_CENTHGADO AND C.CDGO_CENTHGADO = :value ORDER BY C.DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg108Centmedic.class);
		sqlquery.setParameter("value", cdgoCenthgado);
		return sqlquery.getResultList();
	}

	public int insertCentMedic(Tbasg108Centmedic bean) {

		String sqlString = "INSERT INTO PASG.TBASG108_CENTMEDIC (CDGO_CENTHGADO, CDGO_SAP, CDGO_REF, DESG_NOMBRE, DESG_NIFDIRECTOR, DESG_NOMDIRECTOR, DESG_DOMCENTRO, DESG_TELEFONO, "
				+ "					FCHA_HOMOLOGA, FCHA_VALIDEZ, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg108Centmedic.class);
		sqlquery.setParameter(1, bean.getCdgoCenthgado());
		sqlquery.setParameter(2, bean.getCdgoSap());
		sqlquery.setParameter(3, bean.getCdgoRef());
		sqlquery.setParameter(4, bean.getDesgNombre());
		sqlquery.setParameter(5, bean.getDesgNifdirector());
		sqlquery.setParameter(6, bean.getDesgNomdirector());
		sqlquery.setParameter(7, bean.getDesgDomcentro());
		sqlquery.setParameter(8, bean.getDesgTelefono());
		sqlquery.setParameter(9, bean.getFchaHomologa());
		sqlquery.setParameter(10, bean.getFchaValidez());
		sqlquery.setParameter(11, bean.getDesgUsuact());
		sqlquery.setParameter(12, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateCentMedic(Tbasg108Centmedic bean) {

		String sqlString = "UPDATE PASG.TBASG108_CENTMEDIC SET CDGO_CENTHGADO=?, CDGO_SAP=?, CDGO_REF=?, DESG_NOMBRE=?, DESG_NIFDIRECTOR=?, DESG_NOMDIRECTOR=?, "
				+ "						DESG_DOMCENTRO=?, DESG_TELEFONO=?, FCHA_HOMOLOGA=?, "
				+ "						FCHA_VALIDEZ=?, DESG_USUACT=?, FCHA_ACT=CURRENT_DATE  WHERE CDGO_CENMED=?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg108Centmedic.class);
		sqlquery.setParameter(1, bean.getCdgoCenthgado());
		sqlquery.setParameter(2, bean.getCdgoSap());
		sqlquery.setParameter(3, bean.getCdgoRef());
		sqlquery.setParameter(4, bean.getDesgNombre());
		sqlquery.setParameter(5, bean.getDesgNifdirector());
		sqlquery.setParameter(6, bean.getDesgNomdirector());
		sqlquery.setParameter(7, bean.getDesgDomcentro());
		sqlquery.setParameter(8, bean.getDesgTelefono());
		sqlquery.setParameter(9, bean.getFchaHomologa());
		sqlquery.setParameter(10, bean.getFchaValidez());
		sqlquery.setParameter(11, bean.getDesgUsuact());
		sqlquery.setParameter(12, bean.getCdgoCenmed());
		return sqlquery.executeUpdate();
	}
	
	public int estadoCentMedic(Tbasg108Centmedic bean) {

		String sqlString = "UPDATE PASG.TBASG108_CENTMEDIC SET MRCA_ACTIVO=?, DESG_USUACT=?, FCHA_ACT=CURRENT_DATE  WHERE CDGO_CENMED=?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg108Centmedic.class);
		sqlquery.setParameter(1, bean.getMrcaActivo());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getCdgoCenmed());
		return sqlquery.executeUpdate();
	}

	public int deleteCentMedicByCentHgado(Tbasg108Centmedic bean) {

		String sqlString = "UPDATE PASG.TBASG108_CENTMEDIC SET " + "		DESG_USUACT = :usuAct,"
				+ "		FCHA_ACT = CURRENT_DATE," + "		MRCA_ACTIVO = 'N'"
				+ "		WHERE CDGO_CENTHGADO = :cdgoCentHgado";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg108Centmedic.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoCentHgado", bean.getCdgoCenthgado());
		return sqlquery.executeUpdate();
	}

}
