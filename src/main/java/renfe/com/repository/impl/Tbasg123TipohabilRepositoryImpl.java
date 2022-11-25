package renfe.com.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg105Areactivi;
import renfe.com.model.entity.Tbasg123Tipohabil;
import renfe.com.repository.Tbasg123TipohabilRepositoryCustom;

import java.util.Map;

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
	
	public List<Tbasg123Tipohabil> getTipoHabList(Map cdgoTipohab) {
		
		StringBuilder strGetTipoHabList = new StringBuilder();
		
		List tipiHab = (List) cdgoTipohab.get("cdgosHabil");

		String sqlString = "SELECT T.CDGO_TIPOHAB, T.DESG_NOMBRE FROM PASG.TBASG123_TIPOHABIL T WHERE T.MRCA_ACTIVO = 'S' AND T.CDGO_TIPOHAB IN (" + tipiHab.get(0);
		
		strGetTipoHabList.append(sqlString);
		
		for(int i = 1; i < tipiHab.size(); i++) {
			strGetTipoHabList.append(", " + tipiHab.get(i));
		}
		
		strGetTipoHabList.append(")");
		
		System.out.println("----------------------");
		System.out.println(strGetTipoHabList.toString());
		System.out.println("----------------------");
		
		Query sqlquery = em.createNativeQuery(strGetTipoHabList.toString()); 
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg123Tipohabil> resultadosDevueltos = new ArrayList<>();
		
		for(Object[] object : resultados) {
			Tbasg123Tipohabil data = new Tbasg123Tipohabil();
			if(object[0]!=null) {
				data.setCdgoTipohab((Integer)object[0]);
			}
			if(object[1]!=null) {
				data.setDesgNombre((String)object[1]);
			}
			
			resultadosDevueltos.add(data);
			
		}
		return resultadosDevueltos;
	}


}
