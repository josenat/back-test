package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.dto.GetErrListParam;
import renfe.com.model.entity.Tbasg200ErrFich;
import renfe.com.repository.Tbasg200ErrFichRepositoryCustom;

public class Tbasg200ErrFichRepositoryImpl implements Tbasg200ErrFichRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	public List<Tbasg200ErrFich> getErrFichList(GetErrListParam filter) {

		String sqlString = "SELECT * FROM PASG.TBASG200_ERR_FICH WHERE";
		
		if(filter!=null) {

			if(Objects.nonNull(filter.getDesgProceso())) {

			sqlString = sqlString + " DESG_PROCESO = :desgProceso AND" ;
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

			if(Objects.nonNull(filter.getDesgProceso())) {

				sqlquery.setParameter("desgProceso", filter.getDesgProceso());
			}
			
			if(Objects.nonNull(filter.getFchaDesdeError())) {

				sqlquery.setParameter("fchaDesdeError", filter.getFchaDesdeError());
			}
			
			if(Objects.nonNull(filter.getFchaDesdeError())) {

				sqlquery.setParameter("fchaHastaError", filter.getFchaHastaError());
			}
			
		}		

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg200ErrFich> resultadosDevueltos = new ArrayList<Tbasg200ErrFich>();
		for (Object[] object : resultados) {
			Tbasg200ErrFich errFich = new Tbasg200ErrFich();
			
			errFich.setCdgoError(Long.valueOf((int)object[0]));
			errFich.setDesgProceso((String)object[1]);
			errFich.setDesgFichero((String)object[2]);
			errFich.setFchaError((Date)object[3]);
			errFich.setCdgoLinea((Integer)object[4]);
			errFich.setDesgError((String)object[5]);
			errFich.setDesgValor((String)object[6]);		

			resultadosDevueltos.add(errFich);
		}
		return resultadosDevueltos;
	}
	
	public List<Tbasg200ErrFich> getErrFich(Integer cdgoError) {

		String sqlString = " SELECT * FROM PASG.TBASG200_ERR_FICH WHERE CDGO_ERROR = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoError);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg200ErrFich> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg200ErrFich errFich = new Tbasg200ErrFich();
			
			errFich.setCdgoError(Long.valueOf((int)object[0]));
			errFich.setDesgProceso((String)object[1]);
			errFich.setDesgFichero((String)object[2]);
			errFich.setFchaError((Date)object[3]);
			errFich.setCdgoLinea((Integer)object[4]);
			errFich.setDesgError((String)object[5]);
			errFich.setDesgValor((String)object[6]);

			resultadosDevueltos.add(errFich);
		}
		return resultadosDevueltos;
	}
	
}
