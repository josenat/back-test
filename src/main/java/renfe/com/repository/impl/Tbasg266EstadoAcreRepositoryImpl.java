package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import renfe.com.model.entity.Tbasg266EstadoAcre;
import renfe.com.repository.Tbasg266EstadoAcreRepositoryCustom;

public class Tbasg266EstadoAcreRepositoryImpl implements Tbasg266EstadoAcreRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public int insertEstadoAcreditacion(Tbasg266EstadoAcre bean) {

		String sqlString = "INSERT INTO  PASG.TBASG266_ESTADO_ACRE (CDGO_ACREDITA,CDGO_ESTADO,FCHA_ESTADO,DESG_USUACT,FCHA_ACT,MRCA_ACTIVO)"
				+ "		VALUES (?, ?, CURRENT_TIMESTAMP, ?, CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg266EstadoAcre.class);
		
		sqlquery.setParameter(1, bean.getTbasg266estadoacrepk().getCdgoAcredita());
		sqlquery.setParameter(2, bean.getTbasg266estadoacrepk().getCdgoEstado());
		sqlquery.setParameter(3, bean.getDesgUsuact());
		sqlquery.setParameter(4, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateEstadoAcreditacion(Tbasg266EstadoAcre bean) {

		String sqlString = "UPDATE PASG.TBASG266_ESTADO_ACRE SET CDGO_ESTADO = :estado  WHERE CDGO_ACREDITA = :cdgoAcredita";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg266EstadoAcre.class);
		sqlquery.setParameter("estado", bean.getTbasg266estadoacrepk().getCdgoEstado());
		sqlquery.setParameter("cdgoAcredita", bean.getTbasg266estadoacrepk().getCdgoAcredita());
		return sqlquery.executeUpdate();
	}

	public List<Tbasg266EstadoAcre> getEstadosAcreditaMaxFecha() {

		String sqlString = "SELECT ESTADO.CDGO_ACREDITA, ESTADO.CDGO_ESTADO, ESTADO.DESG_USUACT, ESTADO.FCHA_ACT, ESTADO.MRCA_ACTIVO"
				+ "		FROM PASG.TBASG266_ESTADO_ACRE ESTADO";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg266EstadoAcre.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg266EstadoAcre> getEstadosAcreditaTodosMaxFecha() {

		String sqlString = "SELECT ESTADO.CDGO_ACREDITA, ESTADO.CDGO_ESTADO, ESTADO.DESG_USUACT, ESTADO.FCHA_ACT, ESTADO.MRCA_ACTIVO"
				+ "		FROM PASG.TBASG266_ESTADO_ACRE ESTADO";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg266EstadoAcre.class);

		return sqlquery.getResultList();
	}
	
	public int insertEstadoAcre(Tbasg266EstadoAcre bean) {

		String sqlString = "INSERT INTO PASG.TBASG266_ESTADO_ACRE(CDGO_ACREDITA, CDGO_ESTADO, FCHA_ESTADO, DESG_USUACT,FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, CURRENT_TIMESTAMP, ?,CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg266EstadoAcre.class);
		sqlquery.setParameter(1, bean.getTbasg266estadoacrepk().getCdgoAcredita());
		sqlquery.setParameter(2, bean.getTbasg266estadoacrepk().getCdgoEstado());
		sqlquery.setParameter(3, bean.getDesgUsuact());
		sqlquery.setParameter(4, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateEstadoAcreditacionMantenimiento(Tbasg266EstadoAcre bean) {

		String sqlString = "UPDATE PASG.TBASG266_ESTADO_ACRE SET FCHA_ACT=CURRENT_DATE, CDGO_ESTADO = ? ,MRCA_ACTIVO=? , DESG_USUACT=?"
				+ "		 WHERE CDGO_ACREDITA = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg266EstadoAcre.class);
		sqlquery.setParameter(1, bean.getTbasg266estadoacrepk().getCdgoEstado());
		sqlquery.setParameter(2, bean.getMrcaActivo());
		sqlquery.setParameter(3, bean.getDesgUsuact());
		sqlquery.setParameter(4, bean.getTbasg266estadoacrepk().getCdgoAcredita());
		return sqlquery.executeUpdate();
	}

}
