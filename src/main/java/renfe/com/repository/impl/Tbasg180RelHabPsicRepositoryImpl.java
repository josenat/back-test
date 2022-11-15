package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg180RelHabPsic;
import renfe.com.model.entity.Tbasg180RelHabPsicPK;
import renfe.com.repository.Tbasg180RelHabPsicRepositoryCustom;

public class Tbasg180RelHabPsicRepositoryImpl implements Tbasg180RelHabPsicRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg180RelHabPsic> getRelHabPsic() {

		String sqlString = "SELECT * FROM PASG.TBASG180_REL_HAB_PSIC;";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg180RelHabPsic> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg180RelHabPsic relHabPsic = new Tbasg180RelHabPsic();
			Tbasg180RelHabPsicPK relHabPsicPK = new Tbasg180RelHabPsicPK();
			
			relHabPsicPK.setCdgoPsicamb((Integer)object[0]);
			relHabPsicPK.setCdgoTipohab((Integer)object[1]);
			relHabPsic.setDesgUsuact((String)object[2]);
			relHabPsic.setFchaAct((Date)object[3]);
			
			relHabPsic.setTbasg180relhabpsicpk(relHabPsicPK);
			
			resultadosDevueltos.add(relHabPsic);
		}
		return resultadosDevueltos;
		
	}

}
