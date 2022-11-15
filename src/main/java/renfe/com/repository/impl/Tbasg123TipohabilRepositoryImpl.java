package renfe.com.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg105Areactivi;
import renfe.com.model.entity.Tbasg123Tipohabil;
import renfe.com.repository.Tbasg123TipohabilRepositoryCustom;

public class Tbasg123TipohabilRepositoryImpl implements Tbasg123TipohabilRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg123Tipohabil> getTipoHabilList() {

		String sqlString = "SELECT * FROM PASG.TBASG123_TIPOHABIL ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg123Tipohabil.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg123Tipohabil> getTipoHabilListCombo() {

		String sqlString = "SELECT CDGO_TIPOHAB, DESG_NOMBRE, DESG_GRUPO, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO FROM PASG.TBASG123_TIPOHABIL WHERE MRCA_ACTIVO='S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);


		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg123Tipohabil> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg123Tipohabil habilita = new Tbasg123Tipohabil();
			
			habilita.setCdgoTipohab(Integer.valueOf((int)object[0]));
			habilita.setDesgNombre((String)object[1]);
			//area.setDesgNombre((String)object[1]);
			
			resultadosDevueltos.add(habilita);
		}
			return resultadosDevueltos;
	}

	public List<Tbasg123Tipohabil> getTipoHabil(String cdgoTipohab) {

		String sqlString = "SELECT * FROM PASG.TBASG123_TIPOHABIL WHERE CDGO_TIPOHAB = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg123Tipohabil.class);
		sqlquery.setParameter("value", cdgoTipohab);
		return sqlquery.getResultList();
	}

}
