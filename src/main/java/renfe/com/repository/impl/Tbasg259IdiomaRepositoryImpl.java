package renfe.com.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg259Idioma;
import renfe.com.repository.Tbasg259IdiomaRepositoryCustom;

public class Tbasg259IdiomaRepositoryImpl implements Tbasg259IdiomaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg259Idioma> getListaIdiomas() {

		String sqlString = "SELECT * FROM PASG.TBASG259_IDIOMA";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg259Idioma> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg259Idioma idioma = new Tbasg259Idioma();

			idioma.setCdgoIdioma((String)object[0]);
			idioma.setDesgIdioma((String)object[1]);
			idioma.setMrcaActivo(String.valueOf((Character) object[2]));

			resultadosDevueltos.add(idioma);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg259Idioma> getListaIdiomasActivos() {

		String sqlString = "SELECT CDGO_IDIOMA,DESG_IDIOMA FROM PASG.TBASG259_IDIOMA WHERE MRCA_ACTIVO='S'";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg259Idioma> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg259Idioma idioma = new Tbasg259Idioma();
	
			idioma.setCdgoIdioma((String)object[0]);
			idioma.setDesgIdioma((String)object[1]);

			resultadosDevueltos.add(idioma);
		}
		return resultadosDevueltos;
	}

}
