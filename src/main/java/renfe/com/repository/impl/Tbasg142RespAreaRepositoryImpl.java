package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.dto.GetRespAreaListAscendenteDTO;
import renfe.com.model.entity.Tbasg142RespArea;
import renfe.com.repository.Tbasg142RespAreaRepositoryCustom;

public class Tbasg142RespAreaRepositoryImpl implements Tbasg142RespAreaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg142RespArea> getRespArea(String cdgoAreact) {

		String sqlString = "SELECT * FROM PASG.TBASG142_RESP_AREA WHERE CDGO_AREACT = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg142RespArea.class);
		sqlquery.setParameter("value", cdgoAreact);
		return sqlquery.getResultList();
	}

	public List<Tbasg142RespArea> getRespAreaView(String cdgoAreact) {

		String sqlString = "SELECT R.CDGO_AREACT, R.DESG_RESPONSABLE, R.DESG_CARGO, R.DESG_USUACT, R.FCHA_ACT, A.DESG_NOMBRE"
				+ "		FROM PASG.TBASG142_RESP_AREA R INNER JOIN PASG.TBASG105_AREACTIVI A"
				+ "									   ON R.CDGO_AREACT = A.CDGO_AREACT"
				+ "		WHERE R.CDGO_AREACT = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg142RespArea.class);
		sqlquery.setParameter("value", cdgoAreact);
		return sqlquery.getResultList();
	}

	public List<Tbasg142RespArea> getRespAreaCount() {

		String sqlString = "SELECT COUNT(*) AS value FROM PASG.TBASG142_RESP_AREA";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg142RespArea.class);

		return sqlquery.getResultList();
	}

	public List<GetRespAreaListAscendenteDTO> getRespAreaListAscendente() {

		String sqlString = "SELECT R.CDGO_AREACT, R.DESG_RESPONSABLE, R.DESG_CARGO, R.DESG_USUACT, R.FCHA_ACT, A.DESG_NOMBRE"
				+ "		FROM PASG.TBASG142_RESP_AREA R INNER JOIN PASG.TBASG105_AREACTIVI A"
				+ "									   ON R.CDGO_AREACT = A.CDGO_AREACT"
				+ "		ORDER BY R.DESG_RESPONSABLE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetRespAreaListAscendenteDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetRespAreaListAscendenteDTO respArea = new GetRespAreaListAscendenteDTO();
			
			respArea.setCdgoAreact((Integer)object[0]);
			respArea.setDesgResponsable((String)object[1]);
			respArea.setDesgCargo((String)object[2]);
			respArea.setDesgUsuact((String)object[3]);
			respArea.setFchaAct((Date) object[4]);
			respArea.setDesgNombre((String)object[5]);

			resultadosDevueltos.add(respArea);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg142RespArea> getRespAreaListDescendente() {

		String sqlString = "SELECT R.CDGO_AREACT, R.DESG_RESPONSABLE, R.DESG_CARGO, R.DESG_USUACT, R.FCHA_ACT, A.DESG_NOMBRE"
				+ "		FROM PASG.TBASG142_RESP_AREA R INNER JOIN PASG.TBASG105_AREACTIVI A"
				+ "									   ON R.CDGO_AREACT = A.CDGO_AREACT"
				+ "		ORDER BY R.DESG_RESPONSABLE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg142RespArea.class);

		return sqlquery.getResultList();
	}

	public int addRespArea(Tbasg142RespArea bean) {

		String sqlString = "INSERT INTO PASG.TBASG142_RESP_AREA (CDGO_AREACT, DESG_RESPONSABLE, DESG_CARGO, DESG_USUACT, FCHA_ACT) "
				+ "		VALUES (?, ?, ?, ?, CURRENT_DATE)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg142RespArea.class);
		sqlquery.setParameter(1, bean.getCdgoAreact());
		sqlquery.setParameter(2, bean.getDesgResponsable());
		sqlquery.setParameter(3, bean.getDesgCargo());
		sqlquery.setParameter(4, bean.getDesgUsuact());
		return sqlquery.executeUpdate();
	}

	public int updateRespArea(Tbasg142RespArea bean) {

		String sqlString = "UPDATE PASG.TBASG142_RESP_AREA SET " + "			DESG_RESPONSABLE = ?,"
				+ "			DESG_CARGO = ?," + "			DESG_USUACT = ?," + "			FCHA_ACT = CURRENT_DATE  "
				+ "		WHERE CDGO_AREACT = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg142RespArea.class);
		sqlquery.setParameter(1, bean.getDesgResponsable());
		sqlquery.setParameter(2, bean.getDesgCargo());
		sqlquery.setParameter(3, bean.getDesgUsuact());
		sqlquery.setParameter(4, bean.getCdgoAreact());
		return sqlquery.executeUpdate();
	}	

}
