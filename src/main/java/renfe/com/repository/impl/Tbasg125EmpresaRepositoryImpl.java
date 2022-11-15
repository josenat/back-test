package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg107Tipovia;
import renfe.com.model.entity.Tbasg123Tipohabil;
import renfe.com.model.entity.Tbasg125Empresa;

import renfe.com.model.entity.Tbasg134Nacion;

import renfe.com.model.entity.Tbasg263TipoEstado;
import renfe.com.repository.Tbasg125EmpresaRepositoryCustom;

public class Tbasg125EmpresaRepositoryImpl implements Tbasg125EmpresaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg125Empresa> getEmpresaCount() {

		String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG125_EMPRESA";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg125Empresa.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg125Empresa> getEmpresaViewListAscendente() {

		String sqlString = "SELECT " + "			TBASG125.*, " + "			TBASG107.DESG_NOMBRE AS TIPOVIA, "
				+ "			TBASG106.DESG_NOMBRE AS PROVINCIA," + "			N.DESG_NOMBRE AS PAIS" + "		FROM "
				+ "			PASG.TBASG125_EMPRESA TBASG125, " + "			PASG.TBASG106_PROVINCIA TBASG106, "
				+ "			PASG.TBASG107_TIPOVIA TBASG107," + "			PASG.TBASG134_NACION N" + "		WHERE "
				+ "			TBASG125.CDGO_TIPOVIA = TBASG107.CDGO_TIPOVIA "
				+ "			AND TBASG125.CDGO_PROVINCIA = TBASG106.CDGO_PROVINCIA "
				+ "			AND N.CDGO_NACION = TBASG125.CDGO_NACION" + "		ORDER BY DESG_CIF";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg125Empresa.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg125Empresa> getEmpresaViewListDescendente() {

		String sqlString = "SELECT " + "			TBASG125.*," + "			TBASG107.DESG_NOMBRE AS TIPOVIA,"
				+ "			TBASG106.DESG_NOMBRE AS PROVINCIA," + "			N.DESG_NOMBRE AS PAIS" + "		FROM "
				+ "			PASG.TBASG125_EMPRESA TBASG125," + "			PASG.TBASG106_PROVINCIA TBASG106,"
				+ "			PASG.TBASG107_TIPOVIA TBASG107," + "			PASG.TBASG134_NACION N" + "		WHERE "
				+ "			TBASG125.CDGO_TIPOVIA = TBASG107.CDGO_TIPOVIA"
				+ "			AND TBASG125.CDGO_PROVINCIA = TBASG106.CDGO_PROVINCIA"
				+ "			AND N.CDGO_NACION = TBASG125.CDGO_NACION" + "		ORDER BY DESG_CIF DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg125Empresa.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg125Empresa> getEmpresaViewListAscendenteEMPRESA() {

		String sqlString = "SELECT " + "			TBASG125.*," + "			TBASG107.DESG_NOMBRE AS TIPOVIA,"
				+ "			TBASG106.DESG_NOMBRE AS PROVINCIA," + "			N.DESG_NOMBRE AS PAIS" + "		FROM "
				+ "			PASG.TBASG125_EMPRESA TBASG125," + "			PASG.TBASG106_PROVINCIA TBASG106,"
				+ "			PASG.TBASG107_TIPOVIA TBASG107," + "			PASG.TBASG134_NACION N" + "		WHERE "
				+ "			TBASG125.CDGO_TIPOVIA = TBASG107.CDGO_TIPOVIA"
				+ "			AND TBASG125.CDGO_PROVINCIA = TBASG106.CDGO_PROVINCIA"
				+ "			AND N.CDGO_NACION = TBASG125.CDGO_NACION" + "		ORDER BY TBASG125.DESG_NOMBRE ASC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg125Empresa.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg125Empresa> getEmpresaViewListDescendenteEMPRESA() {

		String sqlString = "SELECT " + "			TBASG125.*," + "			TBASG107.DESG_NOMBRE AS TIPOVIA,"
				+ "			TBASG106.DESG_NOMBRE AS PROVINCIA," + "			N.DESG_NOMBRE AS PAIS" + "		FROM "
				+ "			PASG.TBASG125_EMPRESA TBASG125," + "			PASG.TBASG106_PROVINCIA TBASG106,"
				+ "			PASG.TBASG107_TIPOVIA TBASG107," + "			PASG.TBASG134_NACION N" + "		WHERE "
				+ "			TBASG125.CDGO_TIPOVIA = TBASG107.CDGO_TIPOVIA"
				+ "			AND TBASG125.CDGO_PROVINCIA = TBASG106.CDGO_PROVINCIA"
				+ "			AND N.CDGO_NACION = TBASG125.CDGO_NACION" + "		ORDER BY TBASG125.DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg125Empresa.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg125Empresa> getEmpresaListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG125_EMPRESA ORDER BY CDGO_EMPRESA";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg125Empresa.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg125Empresa> getEmpresaListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG125_EMPRESA ORDER BY CDGO_EMPRESA DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg125Empresa.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg125Empresa> getEmpresa(Integer cdgoEmpresa) {

		String sqlString = "SELECT * FROM PASG.TBASG125_EMPRESA WHERE CDGO_EMPRESA=:value";
		
		Query sqlquery = em.createNativeQuery(sqlString);
		
		sqlquery.setParameter("value", cdgoEmpresa);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg125Empresa> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg125Empresa empresa = new Tbasg125Empresa();

			empresa.setCdgoEmpresa(Integer.valueOf((int)object[0]));
			empresa.setDesgCif((String)object[1]);
			empresa.setDesgNombre((String)object[2]);
			empresa.setCdgoTipovia((Integer)object[3]);
			empresa.setDesgVia((String)object[4]);
			empresa.setDesgNumvia((String)object[5]);
			empresa.setDesgPlanta((String)object[6]);
			empresa.setDesgPuerta((String)object[7]);
			empresa.setDesgEscalera((String)object[8]);
			empresa.setDesgCodpost((String)object[9]);
			empresa.setDesgMunicipio((String)object[10]);
			empresa.setCdgoProvincia((Integer)object[11]);
			empresa.setDesgPerscontac((String) object[12]);
			empresa.setDesgTelefono((Integer)object[13]);
			empresa.setDesgUsuact((String)object[14]);
			empresa.setFchaAct((Date) object[15]);
			empresa.setMrcaActivo((java.lang.Character) object[16]);
			empresa.setDesgFax((Integer)object[17]);
			empresa.setDesgEmail((String)object[18]);
			empresa.setCdgoNacion((Integer)object[19]);

			resultadosDevueltos.add(empresa);
		}
		return resultadosDevueltos;
		
	}

	public List<Tbasg125Empresa> getEmpresaCif(String desgCif) {

		String sqlString = "SELECT * FROM PASG.TBASG125_EMPRESA WHERE DESG_CIF=:value AND MRCA_ACTIVO = 'S';";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg125Empresa.class);
		sqlquery.setParameter("value", desgCif);
		return sqlquery.getResultList();
	}

	public List<Tbasg125Empresa> getEmpresaCifInactive(String desgCif) {

		String sqlString = "SELECT * FROM PASG.TBASG125_EMPRESA WHERE DESG_CIF=:value AND MRCA_ACTIVO = 'N';";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg125Empresa.class);
		sqlquery.setParameter("value", desgCif);
		return sqlquery.getResultList();
	}

	public List<Tbasg125Empresa> getEmpresaViewListActive() {

		String sqlString = "SELECT * FROM PASG.TBASG125_EMPRESA WHERE MRCA_ACTIVO='S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg125Empresa> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg125Empresa empresa = new Tbasg125Empresa();

			empresa.setCdgoEmpresa(Integer.valueOf((int)object[0]));

			empresa.setDesgCif((String)object[1]);
			empresa.setDesgNombre((String)object[2]);
			empresa.setCdgoTipovia((Integer)object[3]);
			empresa.setDesgVia((String)object[4]);
			empresa.setDesgNumvia((String)object[5]);
			empresa.setDesgPlanta((String)object[6]);
			empresa.setDesgPuerta((String)object[7]);
			empresa.setDesgEscalera((String)object[8]);
			empresa.setDesgCodpost((String)object[9]);
			empresa.setDesgMunicipio((String)object[10]);
			empresa.setCdgoProvincia((Integer)object[11]);
			empresa.setDesgPerscontac((String) object[12]);
			empresa.setDesgTelefono((Integer)object[13]);
			empresa.setDesgUsuact((String)object[14]);
			empresa.setFchaAct((Date) object[15]);
			empresa.setMrcaActivo((char) object[16]);
			empresa.setDesgFax((Integer)object[17]);
			empresa.setDesgEmail((String)object[18]);
			empresa.setCdgoNacion((Integer)object[19]);

			resultadosDevueltos.add(empresa);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg125Empresa> getEmpresaComboListActive() {

		String sqlString = "SELECT CDGO_EMPRESA,DESG_NOMBRE  FROM PASG.TBASG125_EMPRESA WHERE MRCA_ACTIVO='S'"
				+ "			 ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg125Empresa> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg125Empresa empresa = new Tbasg125Empresa();
			
			empresa.setCdgoEmpresa(Integer.valueOf((int)object[0]));
			empresa.setDesgNombre((String)object[1]);
			
			resultadosDevueltos.add(empresa);
		}
			return resultadosDevueltos;
	}

	public int insertEmpresa(Tbasg125Empresa bean) {

		String sqlString = "SELECT DESG_CIF FROM PASG.TBASG125_EMPRESA WHERE DESG_CIF = :desgCif";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("desgCif", bean.getDesgCif());
		List<String> desgCif = sqlquery.getResultList();
		if (!desgCif.isEmpty()) {
			return 2;
		}	
		
		sqlString = "INSERT INTO PASG.TBASG125_EMPRESA (DESG_CIF, DESG_NOMBRE, CDGO_NACION, CDGO_TIPOVIA, DESG_VIA, DESG_NUMVIA, DESG_PLANTA, DESG_PUERTA, DESG_ESCALERA, "
				+ "			DESG_CODPOST, DESG_MUNICIPIO, CDGO_PROVINCIA, DESG_PERSCONTAC, DESG_TELEFONO, DESG_FAX, DESG_EMAIL, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE, ?)";
		sqlquery = em.createNativeQuery(sqlString, Tbasg125Empresa.class);
		sqlquery.setParameter(1, bean.getDesgCif());
		sqlquery.setParameter(2, bean.getDesgNombre());
		sqlquery.setParameter(3, bean.getCdgoNacion());
		sqlquery.setParameter(4, bean.getCdgoTipovia());
		sqlquery.setParameter(5, bean.getDesgVia());
		sqlquery.setParameter(6, bean.getDesgNumvia());
		sqlquery.setParameter(7, bean.getDesgPlanta());
		sqlquery.setParameter(8, bean.getDesgPuerta());
		sqlquery.setParameter(9, bean.getDesgEscalera());
		sqlquery.setParameter(10, bean.getDesgCodpost());
		sqlquery.setParameter(11, bean.getDesgMunicipio());
		sqlquery.setParameter(12, bean.getCdgoProvincia());
		sqlquery.setParameter(13, bean.getDesgPerscontac());
		sqlquery.setParameter(14, bean.getDesgTelefono());
		sqlquery.setParameter(15, bean.getDesgFax());
		sqlquery.setParameter(16, bean.getDesgEmail());
		sqlquery.setParameter(17, bean.getDesgUsuact());
		sqlquery.setParameter(18, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateEmpresa(Tbasg125Empresa bean) {

		String sqlString = "UPDATE PASG.TBASG125_EMPRESA SET DESG_CIF=?, DESG_NOMBRE=?, CDGO_NACION=?, CDGO_TIPOVIA=?, DESG_VIA=?, DESG_NUMVIA=?, "
				+ "			DESG_PLANTA=?, DESG_PUERTA=?, DESG_ESCALERA=?, DESG_CODPOST=?, DESG_MUNICIPIO=?, "
				+ "			CDGO_PROVINCIA=?, DESG_PERSCONTAC=?, DESG_TELEFONO=?, DESG_FAX=?, DESG_EMAIL=?,"
				+ "			DESG_USUACT=?, FCHA_ACT=CURRENT_DATE  " + "			WHERE CDGO_EMPRESA=?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg125Empresa.class);
		sqlquery.setParameter(1, bean.getDesgCif());
		sqlquery.setParameter(2, bean.getDesgNombre());
		sqlquery.setParameter(3, bean.getCdgoNacion());
		sqlquery.setParameter(4, bean.getCdgoTipovia());
		sqlquery.setParameter(5, bean.getDesgVia());
		sqlquery.setParameter(6, bean.getDesgNumvia());
		sqlquery.setParameter(7, bean.getDesgPlanta());
		sqlquery.setParameter(8, bean.getDesgPuerta());
		sqlquery.setParameter(9, bean.getDesgEscalera());
		sqlquery.setParameter(10, bean.getDesgCodpost());
		sqlquery.setParameter(11, bean.getDesgMunicipio());
		sqlquery.setParameter(12, bean.getCdgoProvincia());
		sqlquery.setParameter(13, bean.getDesgPerscontac());
		sqlquery.setParameter(14, bean.getDesgTelefono());
		sqlquery.setParameter(15, bean.getDesgFax());
		sqlquery.setParameter(16, bean.getDesgEmail());
		sqlquery.setParameter(17, bean.getDesgUsuact());
		sqlquery.setParameter(18, bean.getCdgoEmpresa());
		return sqlquery.executeUpdate();
	}
	
	public int deleteEmpresa(Tbasg125Empresa bean) {

		String sqlString = " UPDATE PASG.TBASG125_EMPRESA SET MRCA_ACTIVO='N', DESG_USUACT='', FCHA_ACT=CURRENT_DATE "
				+ " WHERE CDGO_EMPRESA=? ";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg125Empresa.class);

		sqlquery.setParameter(1, bean.getCdgoEmpresa());
		return sqlquery.executeUpdate();
	}
	
	public int reactiveEmpresa(Tbasg125Empresa bean) {

		String sqlString = " UPDATE PASG.TBASG125_EMPRESA SET MRCA_ACTIVO='S', DESG_USUACT='', FCHA_ACT=CURRENT_DATE "
				+ " WHERE CDGO_EMPRESA=? ";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg125Empresa.class);

		sqlquery.setParameter(1, bean.getCdgoEmpresa());
		return sqlquery.executeUpdate();
	}

	public int unDeleteEmpresa(Tbasg125Empresa bean) {

		String sqlString = "UPDATE PASG.TBASG125_EMPRESA SET MRCA_ACTIVO='S', DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE DESG_CIF=:cif";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg125Empresa.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cif", bean.getDesgCif());
		return sqlquery.executeUpdate();
	}

}
