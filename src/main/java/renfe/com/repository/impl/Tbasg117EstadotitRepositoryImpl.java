package renfe.com.repository.impl;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.dto.Tbasg117EstadotitDto;
import renfe.com.model.entity.Tbasg117Estadotit;
import renfe.com.repository.Tbasg117EstadotitRepositoryCustom;

public class Tbasg117EstadotitRepositoryImpl implements Tbasg117EstadotitRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg117Estadotit> findEstadoTitByCdgoTit(String cdgoTit) {

		String sqlString = "SELECT * FROM PASG.TBASG117_ESTADOTIT WHERE CDGO_TIT = :value AND MRCA_ACTIVO = 'S'"
				+ "		ORDER BY FCHA_ESTADO DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg117Estadotit.class);
		sqlquery.setParameter("value", cdgoTit);
		return sqlquery.getResultList();
	}

	public List<Tbasg117Estadotit> getEstadoTitList() {

		String sqlString = "SELECT * FROM PASG.TBASG117_ESTADOTIT ORDER BY CDGO_TIT,CDGO_ESTADO";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg117Estadotit.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg117Estadotit> getEstadoTitUltimo(String cdgoTit) {

		String sqlString = "SELECT T.*, T.CDGO_ESTADO AS CDGO_ESTADO_AUX FROM PASG.TBASG117_ESTADOTIT AS T WHERE CDGO_TIT = :value AND MRCA_ACTIVO ='S' "
				+ "			AND FCHA_ESTADO = (SELECT max(FCHA_ESTADO) FROM PASG.TBASG117_ESTADOTIT "
				+ "				WHERE CDGO_TIT = :value AND MRCA_ACTIVO ='S')";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg117Estadotit.class);
		sqlquery.setParameter("value", cdgoTit);
		return sqlquery.getResultList();
	}

	public List<Tbasg117EstadotitDto> getEstadoTit(String cdgoTit) {

		String sqlString = "SELECT * FROM PASG.TBASG117_ESTADOTIT WHERE CDGO_TIT = :value AND MRCA_ACTIVO ='S' "
			+ " AND FCHA_ESTADO = (SELECT max(FCHA_ESTADO) FROM PASG.TBASG117_ESTADOTIT "
			+ "	WHERE CDGO_TIT = :value AND MRCA_ACTIVO ='S')";

		Query sqlquery = em.createNativeQuery(sqlString);

		sqlquery.setParameter("value", cdgoTit);
		
		List<Object[]> resultListQuery        = sqlquery.getResultList();
		List<Tbasg117EstadotitDto> resultList = new ArrayList<>();
		for (Object[] object : resultListQuery) {			
			Tbasg117EstadotitDto estadoTitList = new Tbasg117EstadotitDto();        
			estadoTitList.setCdgoTit((Integer)object[0]); 
			estadoTitList.setCdgoEstado((Integer)object[1]);  
			estadoTitList.setFchaEstado(this.convertToString(object[2]).trim()); 
			estadoTitList.setDesgUsuact(this.convertToString(object[3]).trim());  
			estadoTitList.setFchaAct((Date)object[4]); 
			estadoTitList.setMrcaActivo(this.convertToString(object[5]).trim()); 
			
			resultList.add(estadoTitList);
		}

		return resultList;		
	}	
	
	public List<Tbasg117Estadotit> existeEstadoTit(String cdgoTit, String cdgoEstado) {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG117_ESTADOTIT WHERE CDGO_TIT=:cdgoTit AND CDGO_ESTADO=:cdgoEstado";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg117Estadotit.class);
		sqlquery.setParameter("cdgoTit", cdgoTit);
		sqlquery.setParameter("cdgoEstado", cdgoEstado);
		return sqlquery.getResultList();
	}

	public int insertEstadoTit(Tbasg117Estadotit bean) {

		String sqlString = "INSERT INTO PASG.TBASG117_ESTADOTIT (CDGO_TIT, CDGO_ESTADO, FCHA_ESTADO, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "			VALUES (?,?,?,?,CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg117Estadotit.class);
		sqlquery.setParameter(1, bean.getTbasg117estadotitpk().getCdgoTit());
		sqlquery.setParameter(2, bean.getTbasg117estadotitpk().getCdgoEstado());
		sqlquery.setParameter(3, bean.getTbasg117estadotitpk().getFchaEstado());
		sqlquery.setParameter(4, bean.getDesgUsuact());
		sqlquery.setParameter(5, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int insertEstadoTitSinFecha(Tbasg117Estadotit bean) {

		String sqlString = "INSERT INTO PASG.TBASG117_ESTADOTIT (CDGO_TIT, CDGO_ESTADO, FCHA_ESTADO, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO)"
				+ "		VALUES (?, ?, CURRENT_TIMESTAMP, ?, CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg117Estadotit.class);
		sqlquery.setParameter(1, bean.getTbasg117estadotitpk().getCdgoTit());
		sqlquery.setParameter(2, bean.getTbasg117estadotitpk().getCdgoEstado());
		sqlquery.setParameter(3, bean.getDesgUsuact());
		sqlquery.setParameter(4, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateEstadoTit(Tbasg117Estadotit bean) {

		String sqlString = "UPDATE PASG.TBASG117_ESTADOTIT SET CDGO_ESTADO=:cdgoEstado, FCHA_ESTADO=:fchaEstado , DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE"
				+ "		WHERE CDGO_TIT=:cdgoTit"
				+ "		  AND FCHA_ESTADO= (SELECT MAX(FCHA_ESTADO) FROM PASG.TBASG117_ESTADOTIT WHERE CDGO_TIT = :cdgoTit AND MRCA_ACTIVO='S')";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg117Estadotit.class);
		sqlquery.setParameter("cdgoEstado", bean.getTbasg117estadotitpk().getCdgoEstado());
		sqlquery.setParameter("fchaEstado", bean.getTbasg117estadotitpk().getFchaEstado());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoTit", bean.getTbasg117estadotitpk().getCdgoTit());
		return sqlquery.executeUpdate();
	}

	public int deactivateEstadoTit(Tbasg117Estadotit bean) {

		String sqlString = "UPDATE PASG.TBASG117_ESTADOTIT SET MRCA_ACTIVO = 'N' WHERE CDGO_TIT = :value AND MRCA_ACTIVO ='S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg117Estadotit.class);
		sqlquery.setParameter("value", bean.getTbasg117estadotitpk().getCdgoTit());
		return sqlquery.executeUpdate();
	}

	public <T> String convertToString(T value) {
        return value != null ? value.toString() : null;          
    }	
}
