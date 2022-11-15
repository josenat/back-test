package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.dto.GetAmbitosListAscendenteDTO;
import renfe.com.model.entity.Tbasg124Ambitos;
import renfe.com.repository.Tbasg124AmbitosRepositoryCustom;

public class Tbasg124AmbitosRepositoryImpl implements Tbasg124AmbitosRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg124Ambitos> getAmbitosCount() {

		String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG124_AMBITOS";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg124Ambitos.class);

		return sqlquery.getResultList();
	}

	public List<GetAmbitosListAscendenteDTO> getAmbitosListAscendente() {

		String sqlString = "SELECT TBASG124.*, TBASG106.DESG_NOMBRE AS PROVINCIA, TBASG140.DESG_NOMBRE AS TIPDEP, TBASG123.DESG_NOMBRE AS TIPHAB"
				+ "		FROM PASG.TBASG124_AMBITOS TBASG124"
				+ "		LEFT JOIN PASG.TBASG106_PROVINCIA TBASG106 ON TBASG124.CDGO_PROVINCIA = TBASG106.CDGO_PROVINCIA"
				+ "		LEFT JOIN PASG.TBASG140_TIDEPENCI TBASG140 ON TBASG124.CDGO_TIPODEP = TBASG140.CDGO_TIPODEP"
				+ "		LEFT JOIN PASG.TBASG123_TIPOHABIL TBASG123 ON TBASG124.CDGO_TIPOHAB = TBASG123.CDGO_TIPOHAB"
				+ "		ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetAmbitosListAscendenteDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetAmbitosListAscendenteDTO ambitos = new GetAmbitosListAscendenteDTO();
			
			ambitos.setCdgoAmbitos((Integer)object[0]);
			ambitos.setDesgNombre((String)object[1]);
			ambitos.setCdgoGerencia((String)object[2]);
			ambitos.setCdgoProvincia((Integer)object[3]);
			ambitos.setCdgoTipodep((Integer)object[4]);
			ambitos.setDesgUsuact((String)object[5]);
			ambitos.setFchaAct((Date)object[6]);
			ambitos.setMrcaActivo(String.valueOf((Character) object[7]));
			ambitos.setCdgoTipohab((Integer)object[8]);
			ambitos.setProvincia((String)object[9]);
			ambitos.setTipDeb((String)object[10]);
			ambitos.setTipHab((String)object[11]);

			resultadosDevueltos.add(ambitos);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg124Ambitos> getAmbitosListDescendente() {

		String sqlString = "SELECT TBASG124.*, TBASG106.DESG_NOMBRE AS PROVINCIA, TBASG140.DESG_NOMBRE AS TIPDEP, TBASG123.DESG_NOMBRE AS TIPHAB"
				+ "		FROM PASG.TBASG124_AMBITOS TBASG124"
				+ "		LEFT JOIN PASG.TBASG106_PROVINCIA TBASG106 ON TBASG124.CDGO_PROVINCIA = TBASG106.CDGO_PROVINCIA"
				+ "		LEFT JOIN PASG.TBASG140_TIDEPENCI TBASG140 ON TBASG124.CDGO_TIPODEP = TBASG140.CDGO_TIPODEP"
				+ "		LEFT JOIN PASG.TBASG123_TIPOHABIL TBASG123 ON TBASG124.CDGO_TIPOHAB = TBASG123.CDGO_TIPOHAB"
				+ "		ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg124Ambitos.class);

		return sqlquery.getResultList();
	}

	public List<GetAmbitosListAscendenteDTO> getAmbitosTipoHabListAscendente(Integer cdgoTipohab) {

		String sqlString = "SELECT TBASG124.*, TBASG106.DESG_NOMBRE AS PROVINCIA, TBASG140.DESG_NOMBRE AS TIPDEP, TBASG123.DESG_NOMBRE AS TIPHAB"
				+ "		FROM PASG.TBASG124_AMBITOS TBASG124"
				+ "		LEFT JOIN PASG.TBASG106_PROVINCIA TBASG106 ON TBASG124.CDGO_PROVINCIA = TBASG106.CDGO_PROVINCIA"
				+ "		LEFT JOIN PASG.TBASG140_TIDEPENCI TBASG140 ON TBASG124.CDGO_TIPODEP = TBASG140.CDGO_TIPODEP"
				+ "		LEFT JOIN PASG.TBASG123_TIPOHABIL TBASG123 ON TBASG124.CDGO_TIPOHAB = TBASG123.CDGO_TIPOHAB"
				+ "		WHERE TBASG124.CDGO_TIPOHAB = :value" + "		ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);
		
		sqlquery.setParameter("value", cdgoTipohab);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetAmbitosListAscendenteDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetAmbitosListAscendenteDTO ambitos = new GetAmbitosListAscendenteDTO();
			
			ambitos.setCdgoAmbitos((Integer)object[0]);
			ambitos.setDesgNombre((String)object[1]);
			ambitos.setCdgoGerencia((String)object[2]);
			ambitos.setCdgoProvincia((Integer)object[3]);
			ambitos.setCdgoTipodep((Integer)object[4]);
			ambitos.setDesgUsuact((String)object[5]);
			ambitos.setFchaAct((Date)object[6]);
			ambitos.setMrcaActivo(String.valueOf((Character) object[7]));
			ambitos.setCdgoTipohab((Integer)object[8]);
			ambitos.setProvincia((String)object[9]);
			ambitos.setTipDeb((String)object[10]);
			ambitos.setTipHab((String)object[11]);

			resultadosDevueltos.add(ambitos);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg124Ambitos> getAmbitosTipoHabListDescendente(String cdgoTipohab) {

		String sqlString = "SELECT TBASG124.*, TBASG106.DESG_NOMBRE AS PROVINCIA, TBASG140.DESG_NOMBRE AS TIPDEP, TBASG123.DESG_NOMBRE AS TIPHAB"
				+ "		FROM PASG.TBASG124_AMBITOS TBASG124"
				+ "		LEFT JOIN PASG.TBASG106_PROVINCIA TBASG106 ON TBASG124.CDGO_PROVINCIA = TBASG106.CDGO_PROVINCIA"
				+ "		LEFT JOIN PASG.TBASG140_TIDEPENCI TBASG140 ON TBASG124.CDGO_TIPODEP = TBASG140.CDGO_TIPODEP"
				+ "		LEFT JOIN PASG.TBASG123_TIPOHABIL TBASG123 ON TBASG124.CDGO_TIPOHAB = TBASG123.CDGO_TIPOHAB"
				+ "		WHERE TBASG124.CDGO_TIPOHAB = :value" + "		ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg124Ambitos.class);
		sqlquery.setParameter("value", cdgoTipohab);
		return sqlquery.getResultList();
	}

	public List<Tbasg124Ambitos> getAmbitosTipoHabCount(String cdgoTipohab) {

		String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG124_AMBITOS TBASG124"
				+ "		LEFT JOIN PASG.TBASG106_PROVINCIA TBASG106 ON TBASG124.CDGO_PROVINCIA = TBASG106.CDGO_PROVINCIA"
				+ "		LEFT JOIN PASG.TBASG140_TIDEPENCI TBASG140 ON TBASG124.CDGO_TIPODEP = TBASG140.CDGO_TIPODEP"
				+ "		LEFT JOIN PASG.TBASG123_TIPOHABIL TBASG123 ON TBASG124.CDGO_TIPOHAB = TBASG123.CDGO_TIPOHAB"
				+ "		WHERE TBASG124.CDGO_TIPOHAB = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg124Ambitos.class);
		sqlquery.setParameter("value", cdgoTipohab);
		return sqlquery.getResultList();
	}

	public List<Tbasg124Ambitos> getAmbitosActiveList() {

		String sqlString = "SELECT TBASG124.*, TBASG106.DESG_NOMBRE AS PROVINCIA, TBASG140.DESG_NOMBRE AS TIPDEP FROM PASG.TBASG124_AMBITOS TBASG124, PASG.TBASG106_PROVINCIA TBASG106, PASG.TBASG140_TIDEPENCI TBASG140 "
				+ "		WHERE TBASG124.CDGO_PROVINCIA = TBASG106.CDGO_PROVINCIA AND TBASG124.CDGO_TIPODEP = TBASG140.CDGO_TIPODEP AND TBASG124.MRCA_ACTIVO = 'S'"
				+ "		ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg124Ambitos.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg124Ambitos> getAmbitosActiveList2() {

		String sqlString = "SELECT *" + "		FROM PASG.TBASG124_AMBITOS " + "		WHERE MRCA_ACTIVO = 'S'"
				+ "		ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg124Ambitos.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg124Ambitos> getAmbitos(String cdgoAmbitos) {

		String sqlString = "SELECT * FROM PASG.TBASG124_AMBITOS WHERE CDGO_AMBITOS=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg124Ambitos.class);
		sqlquery.setParameter("value", cdgoAmbitos);
		return sqlquery.getResultList();
	}

	public List<Tbasg124Ambitos> getAlcanceAmbito(Integer cdgoAmbitos) {

		String sqlString = "SELECT DESG_NOMBRE FROM PASG.TBASG124_AMBITOS WHERE CDGO_AMBITOS = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoAmbitos);

		List<Object> resultados = sqlquery.getResultList();
		List<Tbasg124Ambitos> resultadosDevueltos = new ArrayList<>();
		for (Object object : resultados) {
			Tbasg124Ambitos ambitos = new Tbasg124Ambitos();

			ambitos.setDesgNombre((String)object);

			resultadosDevueltos.add(ambitos);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg124Ambitos> getAmbitosView(String cdgoAmbitos) {

		String sqlString = "SELECT TBASG124.*, TBASG106.DESG_NOMBRE AS PROVINCIA, TBASG140.DESG_NOMBRE AS TIPDEP, TBASG123.DESG_NOMBRE AS TIPHAB"
				+ "		FROM PASG.TBASG124_AMBITOS TBASG124"
				+ "		LEFT JOIN PASG.TBASG106_PROVINCIA TBASG106 ON TBASG124.CDGO_PROVINCIA = TBASG106.CDGO_PROVINCIA"
				+ "		LEFT JOIN PASG.TBASG140_TIDEPENCI TBASG140 ON TBASG124.CDGO_TIPODEP = TBASG140.CDGO_TIPODEP"
				+ "		LEFT JOIN PASG.TBASG123_TIPOHABIL TBASG123 ON TBASG124.CDGO_TIPOHAB = TBASG123.CDGO_TIPOHAB"
				+ "		WHERE TBASG124.CDGO_AMBITOS=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg124Ambitos.class);
		sqlquery.setParameter("value", cdgoAmbitos);
		return sqlquery.getResultList();
	}

	public List<Tbasg124Ambitos> getAmbitosNombre(String desgNombre) {

		String sqlString = "SELECT * FROM PASG.TBASG124_AMBITOS WHERE DESG_NOMBRE = :value"
				+ "		FETCH FIRST 1 ROW ONLY";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg124Ambitos.class);
		sqlquery.setParameter("value", desgNombre);
		return sqlquery.getResultList();
	}

	public int insertAmbitos(Tbasg124Ambitos bean) {

		String sqlString = "INSERT INTO PASG.TBASG124_AMBITOS (DESG_NOMBRE, CDGO_GERENCIA, CDGO_PROVINCIA, CDGO_TIPODEP, CDGO_TIPOHAB, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, ?, ?, ?, ?, CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg124Ambitos.class);
		sqlquery.setParameter(1, bean.getDesgNombre());
		sqlquery.setParameter(2, bean.getCdgoGerencia());
		sqlquery.setParameter(3, bean.getCdgoProvincia());
		sqlquery.setParameter(4, bean.getCdgoTipodep());
		sqlquery.setParameter(5, bean.getCdgoTipohab());
		sqlquery.setParameter(6, bean.getDesgUsuact());
		sqlquery.setParameter(7, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateAmbitos(Tbasg124Ambitos bean) {

		String sqlString = "UPDATE PASG.TBASG124_AMBITOS SET DESG_NOMBRE=:nombre, CDGO_GERENCIA=:cdgoGerencia, CDGO_PROVINCIA=:cdgoProvincia, CDGO_TIPODEP=:cdgoTipoDep, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE  WHERE CDGO_AMBITOS=:cdgoAmbitos";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg124Ambitos.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("cdgoGerencia", bean.getCdgoGerencia());
		sqlquery.setParameter("cdgoProvincia", bean.getCdgoProvincia());
		sqlquery.setParameter("cdgoTipoDep", bean.getCdgoTipodep());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoAmbitos", bean.getCdgoAmbitos());
		return sqlquery.executeUpdate();
	}
	
	public int estadoAmbitos(Tbasg124Ambitos bean) {

		String sqlString = "UPDATE PASG.TBASG124_AMBITOS SET MRCA_ACTIVO =:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE  WHERE CDGO_AMBITOS=:cdgoAmbitos";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg124Ambitos.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoAmbitos", bean.getCdgoAmbitos());
		return sqlquery.executeUpdate();
	}

}
