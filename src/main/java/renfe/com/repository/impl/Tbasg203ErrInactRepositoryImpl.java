package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.dto.GetErrListParam;
import renfe.com.model.entity.Tbasg202ErrActiv;
import renfe.com.model.entity.Tbasg203ErrInact;
import renfe.com.repository.Tbasg203ErrInactRepositoryCustom;

public class Tbasg203ErrInactRepositoryImpl implements Tbasg203ErrInactRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	/*public List<Tbasg203ErrInact> getErrInactList() {

		String sqlString = "SELECT * FROM PASG.TBASG203_ERR_INACT";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg203ErrInact.class);

		return sqlquery.getResultList();
	}*/
	
	public List<Tbasg203ErrInact> getErrInactList(GetErrListParam filter) {

		String sqlString = "SELECT * FROM PASG.TBASG203_ERR_INACT WHERE";
		
		if(filter!=null) {

			if(Objects.nonNull(filter.getReprocesado())) {

			sqlString = sqlString + " MRCA_REPROCESADO = :reprocesado AND" ;
			}
			
			if(Objects.nonNull(filter.getFchaDesdeError())) {

				sqlString = sqlString + " FCHA_ERROR >= :fchaDesdeError " ;
			}
			
			if(Objects.nonNull(filter.getFchaDesdeError())) {

				sqlString = sqlString + " AND FCHA_ERROR <= :fchaHastaError " ;
			}			
		}
			
		Query sqlquery = em.createNativeQuery(sqlString);	
		
		if(filter!=null) {

			if(Objects.nonNull(filter.getReprocesado())) {

				sqlquery.setParameter("reprocesado", filter.getReprocesado());
			}
			
			if(Objects.nonNull(filter.getFchaDesdeError())) {

				sqlquery.setParameter("fchaDesdeError", filter.getFchaDesdeError());
			}
			
			if(Objects.nonNull(filter.getFchaDesdeError())) {

				sqlquery.setParameter("fchaHastaError", filter.getFchaHastaError());
			}
			
		}		

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg203ErrInact> resultadosDevueltos = new ArrayList<Tbasg203ErrInact>();
		for (Object[] object : resultados) {
			Tbasg203ErrInact errInactiv = new Tbasg203ErrInact();
			
			errInactiv.setCdgoError(Long.valueOf((int)object[0]));
			errInactiv.setDesgError((String)object[1]);
			errInactiv.setFchaError((Date)object[2]);
			errInactiv.setDesgFichero((String)object[3]);
			errInactiv.setDesgMatricula((String)object[4]);
			errInactiv.setDesgMedidabaja((String)object[5]);
			errInactiv.setFchaBaja((Date)object[6]);		
			errInactiv.setMrcaReprocesado(String.valueOf((Character)object[7]));

			resultadosDevueltos.add(errInactiv);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg203ErrInact> getErrInact(Integer cdgoError) {

		String sqlString = "SELECT * FROM PASG.TBASG203_ERR_INACT" + "		WHERE CDGO_ERROR = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoError);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg203ErrInact> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg203ErrInact errInactiv = new Tbasg203ErrInact();
			
			errInactiv.setCdgoError(Long.valueOf((int)object[0]));
			errInactiv.setDesgError((String)object[1]);
			errInactiv.setFchaError((Date)object[2]);
			errInactiv.setDesgFichero((String)object[3]);
			errInactiv.setDesgMatricula((String)object[4]);
			errInactiv.setDesgMedidabaja((String)object[5]);
			errInactiv.setFchaBaja((Date)object[6]);		
			errInactiv.setMrcaReprocesado(String.valueOf((Character)object[7]));

			resultadosDevueltos.add(errInactiv);
		}
		return resultadosDevueltos;
	}

	public int updateErrInact(Tbasg203ErrInact bean) {

		String sqlString = "UPDATE PASG.TBASG203_ERR_INACT SET" + "			MRCA_REPROCESADO = :mrcaReprocesado"
				+ "		WHERE CDGO_ERROR = :cdgoError";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg203ErrInact.class);
		sqlquery.setParameter("mrcaReprocesado", bean.getMrcaReprocesado());
		sqlquery.setParameter("cdgoError", bean.getCdgoError());
		return sqlquery.executeUpdate();
	}

	public int deleteErrInact(Integer cdgoError) {

		String sqlString = "DELETE FROM PASG.TBASG203_ERR_INACT" + "		WHERE CDGO_ERROR = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg203ErrInact.class);
		sqlquery.setParameter("value", cdgoError);
		return sqlquery.executeUpdate();
	}

}
