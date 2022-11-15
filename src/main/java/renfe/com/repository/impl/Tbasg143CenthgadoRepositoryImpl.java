package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.dto.GetCentHgadoListAscendenteDTO;
import renfe.com.model.entity.Tbasg143Centhgado;
import renfe.com.repository.Tbasg143CenthgadoRepositoryCustom;

public class Tbasg143CenthgadoRepositoryImpl implements Tbasg143CenthgadoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg143Centhgado> getCentHgado(String cdgoCenthgado) {

		String sqlString = "SELECT * FROM PASG.TBASG143_CENTHGADO WHERE CDGO_CENTHGADO=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg143Centhgado.class);
		sqlquery.setParameter("value", cdgoCenthgado);
		return sqlquery.getResultList();
	}

	public List<Tbasg143Centhgado> getActiveCentHgado(String cdgoCenthgado) {

		String sqlString = "SELECT * FROM PASG.TBASG143_CENTHGADO WHERE MRCA_ACTIVO='S' AND CDGO_CENTHGADO=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg143Centhgado.class);
		sqlquery.setParameter("value", cdgoCenthgado);
		return sqlquery.getResultList();
	}

	public List<Tbasg143Centhgado> getCentHgadoByCIF(String desgCif) {

		String sqlString = "SELECT * FROM PASG.TBASG143_CENTHGADO WHERE DESG_CIF = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg143Centhgado.class);
		sqlquery.setParameter("value", desgCif);
		return sqlquery.getResultList();
	}

	public List<Tbasg143Centhgado> getCentHgadoCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG143_CENTHGADO";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg143Centhgado.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg143Centhgado> findByCdgoCentFor(String cdgoCentrofor) {

		String sqlString = "SELECT C.* " + "		FROM PASG.TBASG143_CENTHGADO C LEFT JOIN PASG.TBASG120_CENTFORMA F"
				+ "		ON C.CDGO_CENTHGADO = F.CDGO_CENTHGADO" + "		WHERE F.CDGO_CENTROFOR = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg143Centhgado.class);
		sqlquery.setParameter("value", cdgoCentrofor);
		return sqlquery.getResultList();
	}

	public List<Tbasg143Centhgado> findByCdgoCentMed(String cdgoCenmed) {

		String sqlString = "SELECT C.* " + "		FROM PASG.TBASG143_CENTHGADO C LEFT JOIN PASG.TBASG108_CENTMEDIC M"
				+ "		ON C.CDGO_CENTHGADO = M.CDGO_CENTHGADO" + "		WHERE M.CDGO_CENMED = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg143Centhgado.class);
		sqlquery.setParameter("value", cdgoCenmed);
		return sqlquery.getResultList();
	}

	public List<GetCentHgadoListAscendenteDTO> getCentHgadoListAscendente() {

		String sqlString = " SELECT C.*, N.DESG_NOMBRE AS PAIS FROM 	PASG.TBASG143_CENTHGADO C INNER JOIN PASG.TBASG134_NACION N ON N.CDGO_NACION = C.CDGO_NACION "
				+ "ORDER BY C.DESG_NOMBRE ";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetCentHgadoListAscendenteDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetCentHgadoListAscendenteDTO centhgado = new GetCentHgadoListAscendenteDTO();
			
			centhgado.setCdgoCenthgado((Integer) object[0]);
			centhgado.setDesgCif((String)object[1]);
			centhgado.setDesgNombre((String)object[2]);
			centhgado.setDesgDomsocial((String)object[3]);
			centhgado.setDesgUsuact((String)object[4]);
			centhgado.setFchaAct((Date) object[5]);
			centhgado.setMrcaActivo(String.valueOf((Character) object[6]));
			centhgado.setCdgoNacion((Integer) object[7]);
			centhgado.setPais((String)object[8]);

			resultadosDevueltos.add(centhgado);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg143Centhgado> getCentHgadoListDescendente() {

		String sqlString = "SELECT C.*, N.DESG_NOMBRE AS PAIS" + "		FROM " + "			PASG.TBASG143_CENTHGADO C"
				+ "			INNER JOIN PASG.TBASG134_NACION N ON N.CDGO_NACION = C.CDGO_NACION"
				+ "		ORDER BY C.DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg143Centhgado.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg143Centhgado> getCentHgadoActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG143_CENTHGADO WHERE MRCA_ACTIVO='S' ORDER BY CDGO_CENTHGADO";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg143Centhgado> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg143Centhgado centhgado = new Tbasg143Centhgado();
			
			centhgado.setCdgoCenthgado(Long.valueOf((int)object[0]));
			centhgado.setDesgCif((String)object[1]);
			centhgado.setDesgNombre((String)object[2]);
			centhgado.setDesgDomsocial((String)object[3]);
			centhgado.setDesgUsuact((String)object[4]);
			centhgado.setFchaAct((Date) object[5]);
			centhgado.setMrcaActivo(String.valueOf((Character) object[6]));
			centhgado.setCdgoNacion((Integer) object[7]);

			resultadosDevueltos.add(centhgado);
		}
		return resultadosDevueltos;
	}

	public int insertCentHgado(Tbasg143Centhgado bean) {

		String sqlString = "INSERT INTO PASG.TBASG143_CENTHGADO (DESG_CIF, DESG_NOMBRE, DESG_DOMSOCIAL, CDGO_NACION, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, ?, ?, ?, CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg143Centhgado.class);
		sqlquery.setParameter(1, bean.getDesgCif());
		sqlquery.setParameter(2, bean.getDesgNombre());
		sqlquery.setParameter(3, bean.getDesgDomsocial());
		sqlquery.setParameter(4, bean.getCdgoNacion());
		sqlquery.setParameter(5, bean.getDesgUsuact());
		sqlquery.setParameter(6, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateCentHgado(Tbasg143Centhgado bean) {

		String sqlString = "UPDATE PASG.TBASG143_CENTHGADO SET " + "			DESG_NOMBRE = ?,"
				+ "			DESG_DOMSOCIAL = ?," + "			CDGO_NACION = ?," + "			DESG_USUACT = ?,"
				+ "			FCHA_ACT = CURRENT_DATE" + "		WHERE DESG_CIF = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg143Centhgado.class);
		sqlquery.setParameter(1, bean.getDesgNombre());
		sqlquery.setParameter(2, bean.getDesgDomsocial());
		sqlquery.setParameter(3, bean.getCdgoNacion());
		sqlquery.setParameter(4, bean.getDesgUsuact());
		sqlquery.setParameter(5, bean.getDesgCif());
		return sqlquery.executeUpdate();
	}
	
	public int estadoCentHgado(Tbasg143Centhgado bean) {

		String sqlString = "UPDATE PASG.TBASG143_CENTHGADO SET	MRCA_ACTIVO = ?, DESG_USUACT = ?, FCHA_ACT = CURRENT_DATE WHERE DESG_CIF = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg143Centhgado.class);
		sqlquery.setParameter(1, bean.getMrcaActivo());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getDesgCif());
		return sqlquery.executeUpdate();
	}

	public int reactivateCentHgado(Tbasg143Centhgado bean) {

		String sqlString = "UPDATE PASG.TBASG143_CENTHGADO " + "		SET MRCA_ACTIVO = 'S'"
				+ "		WHERE DESG_CIF = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg143Centhgado.class);
		sqlquery.setParameter("value", bean.getDesgCif());
		return sqlquery.executeUpdate();
	}

}
