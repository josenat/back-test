package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.dto.GetSubSerieListAscCdgoSerieDTO;
import renfe.com.model.dto.Tbasg147SubserieDto;
import renfe.com.model.entity.Tbasg147Subserie;
import renfe.com.repository.Tbasg147SubserieRepositoryCustom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Tbasg147SubserieRepositoryImpl implements Tbasg147SubserieRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public List<Tbasg147Subserie> getSubSerie(String cdgoSerie, String cdgoSubserie) {

		String sqlString = "SELECT * FROM PASG.TBASG147_SUBSERIE WHERE CDGO_SERIE=:cdgoSerie AND CDGO_SUBSERIE=:cdgoSubSerie";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg147Subserie.class);
		sqlquery.setParameter("cdgoSerie", cdgoSerie);
		sqlquery.setParameter("cdgoSubSerie", cdgoSubserie);
		return sqlquery.getResultList();
	}

	public List<Tbasg147SubserieDto> getSubSerieListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG147_SUBSERIE ORDER BY CDGO_SERIE ASC, CDGO_SUBSERIE ASC";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg147SubserieDto> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg147SubserieDto subSerie = new Tbasg147SubserieDto();
			
			subSerie.setCdgoSubserie((String) object[0]);
			subSerie.setCdgoSerie((String)object[1]);
			subSerie.setDesgUsuact((String)object[2]);
			subSerie.setFchaAct((Date) object[3]);
			subSerie.setMrcaActivo(String.valueOf((Character) object[4]));

			resultadosDevueltos.add(subSerie);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg147Subserie> getSubSerieListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG147_SUBSERIE ORDER BY CDGO_SERIE DESC, CDGO_SUBSERIE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg147Subserie.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg147Subserie> getSubSerieListAscendenteView() {

		String sqlString = "SELECT A.*, B.DESG_NOMBRE AS DESG_NOMBRESERIE FROM PASG.TBASG147_SUBSERIE A, PASG.TBASG133_SERIE B"
				+ "		WHERE A.CDGO_SERIE = B.CDGO_SERIE ORDER BY A.CDGO_SUBSERIE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg147Subserie.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg147Subserie> getSubSerieListDescendenteView() {

		String sqlString = "SELECT A.*, B.DESG_NOMBRE AS DESG_NOMBRESERIE FROM PASG.TBASG147_SUBSERIE A, PASG.TBASG133_SERIE B"
				+ "		WHERE A.CDGO_SERIE = B.CDGO_SERIE ORDER BY A.CDGO_SUBSERIE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg147Subserie.class);

		return sqlquery.getResultList();
	}

	public List<GetSubSerieListAscCdgoSerieDTO> getSubSerieListAscendenteViewCDGO_SUBSERIE(String cdgoSerie) {

		String sqlString = "SELECT A.*, B.DESG_NOMBRE AS DESG_NOMBRESERIE FROM PASG.TBASG147_SUBSERIE A INNER JOIN PASG.TBASG133_SERIE B ON A.CDGO_SERIE = B.CDGO_SERIE "
				+ "WHERE A.CDGO_SERIE = :value AND A.CDGO_SERIE = B.CDGO_SERIE ORDER BY A.CDGO_SUBSERIE ";
		Query sqlquery = em.createNativeQuery(sqlString);
		
		sqlquery.setParameter("value", cdgoSerie);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetSubSerieListAscCdgoSerieDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetSubSerieListAscCdgoSerieDTO subSerie = new GetSubSerieListAscCdgoSerieDTO();
			
			subSerie.setCdgoSubserie((String) object[0]);
			subSerie.setCdgoSerie((String)object[1]);
			subSerie.setDesgUsuact((String)object[2]);
			subSerie.setFchaAct((Date) object[3]);
			subSerie.setMrcaActivo(String.valueOf((Character) object[4]));
			subSerie.setDesgNombreSerie((String)object[5]);

			resultadosDevueltos.add(subSerie);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg147Subserie> getSubSerieListDescendenteViewCDGO_SUBSERIE(String cdgoSerie) {

		String sqlString = "SELECT A.*, B.DESG_NOMBRE AS DESG_NOMBRESERIE FROM PASG.TBASG147_SUBSERIE A, PASG.TBASG133_SERIE B"
				+ "		WHERE A.CDGO_SERIE = :value AND A.CDGO_SERIE = B.CDGO_SERIE ORDER BY A.CDGO_SUBSERIE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg147Subserie.class);
		sqlquery.setParameter("value", cdgoSerie);
		return sqlquery.getResultList();
	}

	public List<Tbasg147Subserie> getSubSerieCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG147_SUBSERIE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg147Subserie.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg147Subserie> getSubSerieViewCount(String cdgoSerie) {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG147_SUBSERIE A, PASG.TBASG133_SERIE B"
				+ "		WHERE A.CDGO_SERIE = :value AND A.CDGO_SERIE = B.CDGO_SERIE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg147Subserie.class);
		sqlquery.setParameter("value", cdgoSerie);
		return sqlquery.getResultList();
	}

	public List<Tbasg147SubserieDto> getSubSerieListActive() {

		String sqlString = "SELECT CDGO_SERIE, CDGO_SUBSERIE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO FROM PASG.TBASG147_SUBSERIE WHERE MRCA_ACTIVO='S' ORDER BY CDGO_SUBSERIE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> results = sqlquery.getResultList();
		List<Tbasg147SubserieDto> resultList = new ArrayList<>();
  
		for (Object[] item : results) {
		  Tbasg147SubserieDto row = new Tbasg147SubserieDto();
		  row.setCdgoSerie((String) item[0]);
		  row.setCdgoSubserie((String) item[1]);
		  row.setDesgUsuact((String) item[2]);
		  row.setFchaAct((Date) item[3]);
		  row.setMrcaActivo(String.valueOf((Character) item[4]));

		  resultList.add(row);
		}
  
		return resultList;
	}

	public int insertSubSerie(Tbasg147Subserie bean) {

		String sqlString = "INSERT INTO PASG.TBASG147_SUBSERIE (CDGO_SUBSERIE, CDGO_SERIE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO) VALUES (?,?,?,CURRENT_DATE,?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg147Subserie.class);
		sqlquery.setParameter(1, bean.getTbasg147subseriepk().getCdgoSubserie());
		sqlquery.setParameter(2, bean.getTbasg147subseriepk().getCdgoSerie());
		sqlquery.setParameter(3, bean.getDesgUsuact());
		sqlquery.setParameter(4, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateSubSerie(Tbasg147Subserie bean) {

		String sqlString = "UPDATE PASG.TBASG147_SUBSERIE SET CDGO_SERIE=:cdgoSerie, CDGO_SUBSERIE=:cdgoSubSerie, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_SERIE=:cdgoSerie AND CDGO_SUBSERIE=:cdgoSubSerie";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg147Subserie.class);
		sqlquery.setParameter("cdgoSerie", bean.getTbasg147subseriepk().getCdgoSerie());
		sqlquery.setParameter("cdgoSubSerie", bean.getTbasg147subseriepk().getCdgoSubserie());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoSerie", bean.getTbasg147subseriepk().getCdgoSerie());
		sqlquery.setParameter("cdgoSubSerie", bean.getTbasg147subseriepk().getCdgoSubserie());
		return sqlquery.executeUpdate();
	}
	
	public int estadoSubSerie(Tbasg147Subserie bean) {

		String sqlString = "UPDATE PASG.TBASG147_SUBSERIE SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_SERIE=:cdgoSerie AND CDGO_SUBSERIE=:cdgoSubSerie";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg147Subserie.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoSerie", bean.getTbasg147subseriepk().getCdgoSerie());
		sqlquery.setParameter("cdgoSubSerie", bean.getTbasg147subseriepk().getCdgoSubserie());
		return sqlquery.executeUpdate();
	}

	public int deleteSubSerie(Tbasg147Subserie bean) {

		String sqlString = "UPDATE PASG.TBASG147_SUBSERIE SET MRCA_ACTIVO='N', DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg147Subserie.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		return sqlquery.executeUpdate();
	}

	public int reactiveSubSerie(Tbasg147Subserie bean) {

		String sqlString = "UPDATE PASG.TBASG147_SUBSERIE SET MRCA_ACTIVO='S', DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg147Subserie.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		return sqlquery.executeUpdate();
	}

}
