package renfe.com.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.dto.CountGetTramosDTO;
import renfe.com.model.entity.Tbasg260Habilifunc;
import renfe.com.model.entity.Tbasg260HabilifuncPK;
import renfe.com.repository.Tbasg260HabilifuncRepositoryCustom;

public class Tbasg260HabilifuncRepositoryImpl implements Tbasg260HabilifuncRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	public List<Tbasg260Habilifunc> getFuncionesAsocHabil(List<Integer> listHabilitaciones, String cdgoIdioma) {

		String sqlString = "SELECT DISTINCT CDGO_MENSAJE,DESC_MENSAJE FROM PASG.TBASG260_HABILIFUNC WHERE CDGO_IDIOMA =  :cdgoIdioma ";
			
		if(listHabilitaciones != null) {
			
			sqlString = sqlString + " AND TIPO_HABI IN ( " + listHabilitaciones.get(0);
			
			for(int i = 1; i < listHabilitaciones.size(); i++) {
				sqlString = sqlString + " ," + listHabilitaciones.get(i);
			}
			
			sqlString = sqlString + " )";		
		}
		
		sqlString = sqlString + " ORDER BY CDGO_MENSAJE ";

		Query sqlquery = em.createNativeQuery(sqlString);
		
		sqlquery.setParameter("cdgoIdioma", cdgoIdioma);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg260Habilifunc> resultadosDevueltos = new ArrayList<>();		
		for (Object[] object : resultados) {
			Tbasg260Habilifunc habilifunc = new Tbasg260Habilifunc();
			Tbasg260HabilifuncPK habilifuncPK = new Tbasg260HabilifuncPK();
			
			habilifuncPK.setCdgoMensaje((String)object[0]);
			
			habilifunc.setTbasg260habilifuncpk(habilifuncPK);
			habilifunc.setDescMensaje((String)object[1]);
			
			resultadosDevueltos.add(habilifunc);
		}
		return resultadosDevueltos;
	}

}
