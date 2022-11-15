package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg160GcConsulta;
import renfe.com.repository.Tbasg160GcConsultaRepositoryCustom;

public class Tbasg160GcConsultaRepositoryImpl implements Tbasg160GcConsultaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg160GcConsulta> getGcConsultasListActive(String desgUsuario) {

		String sqlString = "SELECT * " + "        FROM PASG.TBASG160_GC_CONSULTA "
				+ "        WHERE DESG_USUARIO = :usuario " + "              AND MRCA_ACTIVO = 'S' "
				+ "        ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg160GcConsulta.class);
		sqlquery.setParameter("usuario", desgUsuario);
		return sqlquery.getResultList();
	}

	public List<Tbasg160GcConsulta> getGcConsulta(String cdgoConsulta) {

		String sqlString = "SELECT * " + "        FROM PASG.TBASG160_GC_CONSULTA "
				+ "        WHERE CDGO_CONSULTA = :value" + "        ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg160GcConsulta.class);
		sqlquery.setParameter("value", cdgoConsulta);
		return sqlquery.getResultList();
	}

	public int insertGcConsulta(Tbasg160GcConsulta bean) {

		String sqlString = "INSERT INTO PASG.TBASG160_GC_CONSULTA "
				+ "           (DESG_NOMBRE, DESG_USUARIO, MRCA_CONTAR, DESG_EXPLOGICA, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO) "
				+ "        VALUES (?,?,?,?,?,CURRENT_DATE,?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg160GcConsulta.class);
		sqlquery.setParameter(1, bean.getDesgNombre());
		sqlquery.setParameter(2, bean.getDesgUsuario());
		sqlquery.setParameter(3, bean.getMrcaContar());
		sqlquery.setParameter(4, bean.getDesgExplogica());
		sqlquery.setParameter(5, bean.getDesgUsuact());
		sqlquery.setParameter(6, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateGcConsulta(Tbasg160GcConsulta bean) {

		String sqlString = "UPDATE PASG.TBASG160_GC_CONSULTA " + "        SET DESG_NOMBRE = ?,"
				+ "            MRCA_CONTAR = ?," + "			DESG_EXPLOGICA = ?," + "            DESG_USUACT = ?, "
				+ "            FCHA_ACT = CURRENT_DATE " + "        WHERE CDGO_CONSULTA = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg160GcConsulta.class);
		sqlquery.setParameter(1, bean.getDesgNombre());
		sqlquery.setParameter(2, bean.getMrcaContar());
		sqlquery.setParameter(3, bean.getDesgExplogica());
		sqlquery.setParameter(4, bean.getDesgUsuact());
		sqlquery.setParameter(5, bean.getCdgoConsulta());
		return sqlquery.executeUpdate();
	}

	public int deleteGcConsulta(Tbasg160GcConsulta bean) {

		String sqlString = "UPDATE PASG.TBASG160_GC_CONSULTA" + "        SET DESG_USUACT = :usuAct, "
				+ "            FCHA_ACT = CURRENT_DATE, " + "            MRCA_ACTIVO = 'N'"
				+ "        WHERE CDGO_CONSULTA = :cdgoConsulta";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg160GcConsulta.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoConsulta", bean.getCdgoConsulta());
		return sqlquery.executeUpdate();
	}

}
