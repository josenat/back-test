package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import renfe.com.model.entity.Tbasg197Formacion;
import renfe.com.repository.Tbasg197FormacionRepositoryCustom;

public class Tbasg197FormacionRepositoryImpl implements Tbasg197FormacionRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg197Formacion> getAlcaForma(String cdgoSolicitud) {

		String sqlString = "SELECT * FROM PASG.TBASG197_FORMACION WHERE CDGO_SOLICITUD = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg197Formacion.class);
		sqlquery.setParameter("value", cdgoSolicitud);
		return sqlquery.getResultList();
	}

	public List<Tbasg197Formacion> getFormacionByDniNif(String desgNifpas) {

		String sqlString = "SELECT * FROM PASG.TBASG197_FORMACION WHERE DESG_NIFPAS = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg197Formacion.class);
		sqlquery.setParameter("value", desgNifpas);
		return sqlquery.getResultList();
	}

	public List<Tbasg197Formacion> getFormacionExpediente(Integer cdgoExpedient) {

		String sqlString = "SELECT * FROM PASG.TBASG197_FORMACION WHERE CDGO_EXPEDIENT = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoExpedient);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg197Formacion> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg197Formacion formacion = new Tbasg197Formacion();

			formacion.setCdgoSolicitud((Integer)object[0]);
			formacion.setCdgoExpedient((Integer) object[1]);			
			formacion.setDesgNifpas((String)object[2]);
			formacion.setDesgNombre((String)object[3]);
			formacion.setDesgApell1((String)object[4]);
			formacion.setDesgApell2((String)object[5]);
			formacion.setDesgCif((String)object[6]);
			formacion.setDesgEmpresa((String)object[7]);
			formacion.setCdgoAreact((Integer) object[8]);
			formacion.setCdgoTipohab((Integer) object[9]);
			formacion.setCdgoAlcance((String) object[10]);
			formacion.setCdgoSerie((String) object[11]);
			formacion.setCdgoSubserie((String) object[12]);
			formacion.setDesgDescripcion((String)object[13]);
			formacion.setDesgTipoexp(String.valueOf((Character)object[14]));
			formacion.setCdgoEstado((Integer) object[15]);
			formacion.setDesgUsuact((String)object[16]);
			formacion.setFchaAct((Date) object[17]);
			formacion.setCdgoTit((Integer) object[18]);

			resultadosDevueltos.add(formacion);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg197Formacion> getMaxFormacionExpediente(String cdgoExpedient) {

		String sqlString = "SELECT * FROM PASG.TBASG197_FORMACION F WHERE CDGO_EXPEDIENT = :value"
				+ "		    and CDGO_SOLICITUD in (select max(CDGO_SOLICITUD) as CDGO_SOLICITUD"
				+ "                             FROM PASG.TBASG197_FORMACION WHERE CDGO_EXPEDIENT = F.CDGO_EXPEDIENT)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg197Formacion.class);
		sqlquery.setParameter("value", cdgoExpedient);
		return sqlquery.getResultList();
	}

	public List<Tbasg197Formacion> getReciclajeExpediente(Integer cdgoExpedient) {

		String sqlString = "SELECT * FROM PASG.TBASG197_FORMACION " + "			WHERE DESG_TIPOEXP = 'R'"
				+ "				AND CDGO_ESTADO != 2" + "				AND CDGO_EXPEDIENT = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoExpedient);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg197Formacion> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg197Formacion formacion = new Tbasg197Formacion();
	
			formacion.setCdgoSolicitud((Integer)object[0]);
			formacion.setCdgoExpedient((Integer)object[1]);
			formacion.setDesgNifpas((String)object[2]);
			formacion.setDesgNombre((String)object[3]);
			formacion.setDesgApell1((String)object[4]);
			formacion.setDesgApell2((String)object[5]);
			formacion.setDesgCif((String)object[6]);
			formacion.setDesgEmpresa((String)object[7]);
			formacion.setCdgoAreact((Integer)object[8]);
			formacion.setCdgoTipohab((Integer)object[9]);
			formacion.setCdgoAlcance((String)object[10]);
			formacion.setCdgoSerie((String)object[11]);
			formacion.setCdgoSubserie((String)object[12]);
			formacion.setDesgDescripcion((String)object[13]);
			formacion.setDesgTipoexp(String.valueOf((Character)object[14]));
			formacion.setCdgoEstado((Integer)object[15]);
			formacion.setDesgUsuact((String)object[16]);
			formacion.setFchaAct((Date)object[17]);
			formacion.setCdgoTit((Integer)object[18]);

			resultadosDevueltos.add(formacion);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg197Formacion> getReciclajeTituloCond(String cdgoTit) {

		String sqlString = "SELECT * FROM PASG.TBASG197_FORMACION " + "			WHERE DESG_TIPOEXP = 'R'"
				+ "				AND CDGO_ESTADO != 2" + "				AND CDGO_TIT = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg197Formacion.class);
		sqlquery.setParameter("value", cdgoTit);
		return sqlquery.getResultList();
	}

	public List<Tbasg197Formacion> getFormacionValores() {

		String sqlString = "SELECT * FROM PASG.TBASG197_FORMACION";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg197Formacion.class);

		return sqlquery.getResultList();
	}

	@Transactional
	public int insertFormacion(Tbasg197Formacion bean) {

		String sqlString = "INSERT INTO PASG.TBASG197_FORMACION (CDGO_EXPEDIENT, CDGO_TIT, DESG_NIFPAS, DESG_NOMBRE, DESG_APELL1, "
				+ "			DESG_APELL2, DESG_CIF, DESG_EMPRESA, CDGO_AREACT, CDGO_TIPOHAB, CDGO_ALCANCE, CDGO_SERIE,"
				+ "			CDGO_SUBSERIE, DESG_DESCRIPCION, DESG_TIPOEXP, CDGO_ESTADO, DESG_USUACT, FCHA_ACT)"
				+ "		VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg197Formacion.class);
		sqlquery.setParameter(1, bean.getCdgoExpedient());
		sqlquery.setParameter(2, bean.getCdgoTit());
		sqlquery.setParameter(3, bean.getDesgNifpas());
		sqlquery.setParameter(4, bean.getDesgNombre());
		sqlquery.setParameter(5, bean.getDesgApell1());
		sqlquery.setParameter(6, bean.getDesgApell2());
		sqlquery.setParameter(7, bean.getDesgCif());
		sqlquery.setParameter(8, bean.getDesgEmpresa());
		sqlquery.setParameter(9, bean.getCdgoAreact());
		sqlquery.setParameter(10, bean.getCdgoTipohab());
		sqlquery.setParameter(11, bean.getCdgoAlcance());
		sqlquery.setParameter(12, bean.getCdgoSerie());
		sqlquery.setParameter(13, bean.getCdgoSubserie());
		sqlquery.setParameter(14, bean.getDesgDescripcion());
		sqlquery.setParameter(15, bean.getDesgTipoexp());
		sqlquery.setParameter(16, bean.getCdgoEstado());
		sqlquery.setParameter(17, bean.getDesgUsuact());
		return sqlquery.executeUpdate();
	}

	public int deleteFormacion(Integer cdgoSolicitud) {

		String sqlString = "DELETE FROM PASG.TBASG197_FORMACION	WHERE CDGO_SOLICITUD = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg197Formacion.class);
		sqlquery.setParameter("value", cdgoSolicitud);
		return sqlquery.executeUpdate();
	}

}
