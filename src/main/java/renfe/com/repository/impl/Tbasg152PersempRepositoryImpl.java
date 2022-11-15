package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import renfe.com.dto.GetPersempParametersDTO;
import renfe.com.model.entity.Tbasg152Persemp;
import renfe.com.model.entity.Tbasg152PersempPK;
import renfe.com.repository.Tbasg152PersempRepositoryCustom;



public class Tbasg152PersempRepositoryImpl implements Tbasg152PersempRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(Tbasg100PersonaRepositoryImpl.class);

	/*public List<Tbasg152Persemp> getPersonaEmpresa(String cdgoPersona) {

		String sqlString = "SELECT PE.*, EM.DESG_NOMBRE AS DESG_EMPRESA FROM PASG.TBASG152_PERSEMP PE, PASG.TBASG125_EMPRESA EM"
				+ "		WHERE PE.CDGO_PERSONA = :value" + "		AND PE.CDGO_EMPRESA = EM.CDGO_EMPRESA";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg152Persemp.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}*/
	
	public List<Tbasg152Persemp> getPersonaEmpresa(String cdgoPersona) {

		String sqlString = "SELECT PE.*, EM.DESG_NOMBRE AS DESG_EMPRESA FROM PASG.TBASG152_PERSEMP PE, PASG.TBASG125_EMPRESA EM"
				+ "		WHERE PE.CDGO_PERSONA = :value" + "		AND PE.CDGO_EMPRESA = EM.CDGO_EMPRESA";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg152Persemp> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg152Persemp persemp = new Tbasg152Persemp();
			Tbasg152PersempPK persempPK = new Tbasg152PersempPK();

			persempPK.setCdgoPersona((Integer)object[0]);
			persempPK.setCdgoEmpresa((Integer)object[1]);
			persemp.setTbasg152persemppk(persempPK);
			persemp.setDesgUsuact((String)object[2]);
			persemp.setFchaAct((Date) object[3]);
			persemp.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));
			
			resultadosDevueltos.add(persemp);
		}
		return resultadosDevueltos;
	}
	

	public List<Tbasg152Persemp> getPersonaEmpresaListMantenimiento(String cdgoPersona) {

		String sqlString = "SELECT PE.*, EM.DESG_NOMBRE AS DESG_EMPRESA FROM PASG.TBASG152_PERSEMP PE, PASG.TBASG125_EMPRESA EM"
				+ "		WHERE PE.CDGO_PERSONA = :value" + "		AND PE.MRCA_ACTIVO = 'S'"
				+ "		AND PE.CDGO_EMPRESA = EM.CDGO_EMPRESA";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg152Persemp.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}

	@Transactional
	public int insertPersonaEmpresa(GetPersempParametersDTO bean) {
		int result = 0;
		if (Objects.nonNull(bean.getCdgoPersona()) && Objects.nonNull(bean.getCdgoEmpresa())) {
			String sqlString = " INSERT INTO PASG.TBASG152_PERSEMP "
				+ " (CDGO_PERSONA, CDGO_EMPRESA, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO) "
				+ "	VALUES (:cdgoPersona, :cdgoEmpresa, :desgUsuact, CURRENT_DATE, :mrcaActivo) ";

			Query sqlquery = em.createNativeQuery(sqlString);

			if (Objects.nonNull(bean.getCdgoEmpresa())) {
				sqlquery.setParameter("cdgoEmpresa", bean.getCdgoEmpresa());
			} else { 
				sqlquery.setParameter("cdgoEmpresa", null);
			} 

			if (Objects.nonNull(bean.getDesgUsuact())) {
				sqlquery.setParameter("desgUsuact", bean.getDesgUsuact());
			} else { 
				sqlquery.setParameter("desgUsuact", null);
			} 
			
			if (Objects.nonNull(bean.getMrcaActivo())) {
				sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
			} else { 
				sqlquery.setParameter("mrcaActivo", null);
			} 
			
			if (Objects.nonNull(bean.getCdgoPersona())) {
				sqlquery.setParameter("cdgoPersona", bean.getCdgoPersona());
			} else { 
				sqlquery.setParameter("cdgoPersona", null);
			} 	
			
			try {
				result = sqlquery.executeUpdate();
			} catch (Exception e) {
				logger.error("--> Error insertPersonaEmpresa:", e);
			}			 
		}

		return result;
	}

	@Transactional
	public int updatePersonaEmpresa(GetPersempParametersDTO bean) {
		int result = 0;
		if (Objects.nonNull(bean.getCdgoPersona()) && Objects.nonNull(bean.getCdgoEmpresa())) {
			String sqlString = " UPDATE PASG.TBASG152_PERSEMP "
				+ "	SET	CDGO_EMPRESA = :cdgoEmpresa, DESG_USUACT = :desgUsuact, FCHA_ACT = CURRENT_DATE, MRCA_ACTIVO = :mrcaActivo "
				+ "	WHERE CDGO_PERSONA = :cdgoPersona ";

			Query sqlquery = em.createNativeQuery(sqlString);

			if (Objects.nonNull(bean.getCdgoEmpresa())) {
				sqlquery.setParameter("cdgoEmpresa", bean.getCdgoEmpresa());
			} else { 
				sqlquery.setParameter("cdgoEmpresa", null);
			} 

			if (Objects.nonNull(bean.getDesgUsuact())) {
				sqlquery.setParameter("desgUsuact", bean.getDesgUsuact());
			} else { 
				sqlquery.setParameter("desgUsuact", null);
			} 
			
			if (Objects.nonNull(bean.getMrcaActivo())) {
				sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
			} else { 
				sqlquery.setParameter("mrcaActivo", null);
			} 
			
			if (Objects.nonNull(bean.getCdgoPersona())) {
				sqlquery.setParameter("cdgoPersona", bean.getCdgoPersona());
			} else { 
				sqlquery.setParameter("cdgoPersona", null);
			} 			

			try {
				result = sqlquery.executeUpdate();
			} catch (Exception e) {
				logger.error("--> Error updatePersonaEmpresa:", e);
			}			
		}

		return result;
	}

	public int deletePersonaEmpresaMantenimiento(Tbasg152Persemp bean) {

		String sqlString = "DELETE FROM PASG.TBASG152_PERSEMP " + "		WHERE CDGO_PERSONA = :cdgoPersona";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg152Persemp.class);
		sqlquery.setParameter("cdgoPersona", bean.getTbasg152persemppk().getCdgoPersona());
		return sqlquery.executeUpdate();
	}

	public int updatePersonaEmpresaMantenimiento(Tbasg152Persemp bean) {

		String sqlString = "UPDATE PASG.TBASG152_PERSEMP SET" + "			CDGO_EMPRESA = ?,    "
				+ "			DESG_USUACT = ?, " + "			FCHA_ACT = CURRENT_DATE," + "			MRCA_ACTIVO = 'S' "
				+ "		WHERE CDGO_PERSONA = ? AND CDGO_EMPRESA = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg152Persemp.class);
		sqlquery.setParameter(1, bean.getTbasg152persemppk().getCdgoEmpresa());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getTbasg152persemppk().getCdgoPersona());
		sqlquery.setParameter(4, bean.getTbasg152persemppk().getCdgoEmpresa());
		return sqlquery.executeUpdate();
	}

}
