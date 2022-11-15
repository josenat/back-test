package renfe.com.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg262TipoAcredita;
import renfe.com.model.entity.Tbasg263TipoEstado;
import renfe.com.repository.Tbasg263TipoEstadoRepositoryCustom;

public class Tbasg263TipoEstadoRepositoryImpl implements Tbasg263TipoEstadoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg263TipoEstado> getTipoEstAcAllList() {

		String sqlString = "SELECT CDGO_ESTADO, DESG_ESTADO, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO FROM PASG.TBASG263_TIPO_ESTADO";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg263TipoEstado> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg263TipoEstado estado = new Tbasg263TipoEstado();
			
			estado.setCdgoEstado((String)object[0]);
			estado.setDesgEstado((String)object[1]);
			
			resultadosDevueltos.add(estado);
		}
			return resultadosDevueltos;
	}

	public List<Tbasg263TipoEstado> getTipoEstAcCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG263_TIPO_ESTADO";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg263TipoEstado.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg263TipoEstado> getTipoEstadoAcredita() {

		String sqlString = "SELECT * FROM PASG.TBASG263_TIPO_ESTADO";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg263TipoEstado.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg263TipoEstado> getTipoEstadosAcredita() {

		String sqlString = "SELECT * FROM PASG.TBASG263_TIPO_ESTADO";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg263TipoEstado.class);

		return sqlquery.getResultList();
	}

}
