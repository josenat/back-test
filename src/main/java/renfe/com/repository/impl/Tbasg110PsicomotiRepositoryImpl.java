package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg110Psicomoti;
import renfe.com.repository.Tbasg110PsicomotiRepositoryCustom;

public class Tbasg110PsicomotiRepositoryImpl implements Tbasg110PsicomotiRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg110Psicomoti> getPsicoMotiCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG110_PSICOMOTI";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg110Psicomoti.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg110Psicomoti> getPsicoMotiListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG110_PSICOMOTI ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg110Psicomoti> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg110Psicomoti psicomoti = new Tbasg110Psicomoti();
			
			psicomoti.setCdgoMotivo((Integer)object[0]);
			psicomoti.setDesgNombre((String)object[1]);
			psicomoti.setDesgUsuact((String)object[2]);
			psicomoti.setFchaAct((Date) object[3]);
			psicomoti.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));

			resultadosDevueltos.add(psicomoti);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg110Psicomoti> getPsicoMotiListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG110_PSICOMOTI ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg110Psicomoti.class);

		return sqlquery.getResultList();
	}

	/*public List<Tbasg110Psicomoti> getPsicoMotiActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG110_PSICOMOTI WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg110Psicomoti.class);

		return sqlquery.getResultList();
	}*/
	
	public List<Tbasg110Psicomoti> getPsicoMotiActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG110_PSICOMOTI WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg110Psicomoti> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg110Psicomoti psicomoti = new Tbasg110Psicomoti();

			psicomoti.setCdgoMotivo((Integer)object[0]);
			psicomoti.setDesgNombre((String)object[1]);
			psicomoti.setDesgUsuact((String)object[2]);
			psicomoti.setFchaAct((Date) object[3]);
			psicomoti.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));

			resultadosDevueltos.add(psicomoti);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg110Psicomoti> getPsicoMotiActiveListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG110_PSICOMOTI WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg110Psicomoti.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg110Psicomoti> getPsicoMoti(Integer cdgoMotivo) {

		String sqlString = "SELECT * FROM PASG.TBASG110_PSICOMOTI WHERE CDGO_MOTIVO=:value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoMotivo);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg110Psicomoti> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg110Psicomoti psicomoti = new Tbasg110Psicomoti();

			psicomoti.setCdgoMotivo((Integer)object[0]);
			psicomoti.setDesgNombre((String)object[1]);
			psicomoti.setDesgUsuact((String)object[2]);
			psicomoti.setFchaAct((Date) object[3]);
			psicomoti.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));

			resultadosDevueltos.add(psicomoti);
		}
		return resultadosDevueltos;
	}

	public int insertPsicoMoti(Tbasg110Psicomoti bean) {

		String sqlString = "INSERT INTO PASG.TBASG110_PSICOMOTI (DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO) VALUES (?,?,CURRENT_DATE,?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg110Psicomoti.class);
		sqlquery.setParameter(1, bean.getDesgNombre());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updatePsicoMoti(Tbasg110Psicomoti bean) {

		String sqlString = "UPDATE PASG.TBASG110_PSICOMOTI SET DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_MOTIVO=:cdgoMotivo";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg110Psicomoti.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoMotivo", bean.getCdgoMotivo());
		return sqlquery.executeUpdate();
	}
	
	public int estadoPsicoMoti(Tbasg110Psicomoti bean) {

		String sqlString = "UPDATE PASG.TBASG110_PSICOMOTI SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_MOTIVO=:cdgoMotivo";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg110Psicomoti.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoMotivo", bean.getCdgoMotivo());
		return sqlquery.executeUpdate();
	}

}
