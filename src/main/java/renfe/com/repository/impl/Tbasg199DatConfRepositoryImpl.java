package renfe.com.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg199DatConf;
import renfe.com.repository.Tbasg199DatConfRepositoryCustom;

public class Tbasg199DatConfRepositoryImpl implements Tbasg199DatConfRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Tbasg199DatConf> SQL_LOAD_VALUES(String nombre) {
		
		String sqlString = "SELECT CLAVE, VALOR, TIPO FROM PASG.TBASG199_DAT_CONF WHERE CLAVE LIKE '%" + nombre + "%'";
		Query sqlquery = em.createNativeQuery(sqlString); 
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg199DatConf> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg199DatConf area = new Tbasg199DatConf();

		area.setValor((String)object[1]);


		resultadosDevueltos.add(area);
		}
		return resultadosDevueltos;
	}

}
