package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg153Tarjeta;
import renfe.com.repository.Tbasg153TarjetaRepositoryCustom;

public class Tbasg153TarjetaRepositoryImpl implements Tbasg153TarjetaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg153Tarjeta> getTarjeta(String cdgoNumserie) {

		String sqlString = "SELECT * " + "			FROM PASG.TBASG153_TARJETA WHERE CDGO_NUMSERIE = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg153Tarjeta.class);
		sqlquery.setParameter("value", cdgoNumserie);
		return sqlquery.getResultList();
	}

	public List<Tbasg153Tarjeta> getTarjetaPer(String cdgoPersona) {

		String sqlString = "SELECT * " + "		FROM " + "		    PASG.TBASG153_TARJETA" + "		WHERE "
				+ "		    CDGO_PERSONA = :value" + "		    AND MRCA_LISTANEGRA = 'N'"
				+ "		    AND MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg153Tarjeta> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg153Tarjeta tarjeta = new Tbasg153Tarjeta();

			tarjeta.setCdgoNumserie(Long.valueOf((String) object[0]));
			tarjeta.setCdgoPersona((Integer) object[1]);
			tarjeta.setMrcaListanegra(String.valueOf((java.lang.Character) object[2]));
			tarjeta.setFchaListanegra((String) object[3]);
			tarjeta.setDesgUsuact((String) object[4]);
			tarjeta.setFchaAct((Date) object[5]);
			tarjeta.setMrcaActivo(String.valueOf((java.lang.Character) object[6]));
			tarjeta.setFchaExpedicion((Date) object[7]);
			tarjeta.setFchaExpiracion((Date) object[8]);
			tarjeta.setCdgoRfid((String) object[9]);

			resultadosDevueltos.add(tarjeta);
		}
		return resultadosDevueltos;
	}

}
