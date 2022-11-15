package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.dto.GetActasNoActivasPersonaDTO;
import renfe.com.dto.GetDiferentValuesTipoDTO;
import org.springframework.transaction.annotation.Transactional;

import renfe.com.dto.InsertActaincalParamDTO;
import renfe.com.model.dto.Tbasg146ActaincalDto;
import renfe.com.model.entity.Tbasg146Actaincal;
import renfe.com.repository.Tbasg146ActaincalRepositoryCustom;

public class Tbasg146ActaincalRepositoryImpl implements Tbasg146ActaincalRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg146Actaincal> getActaInCal(String cdgoActaform, String desgTipocurso) {

		String sqlString = "SELECT * FROM PASG.TBASG146_ACTAINCAL WHERE CDGO_ACTAFORM = :cdgoActa "
				+ "			AND DESG_TIPOCURSO=:tipoCurso AND MRCA_ACTIVO ='S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg146Actaincal.class);
		sqlquery.setParameter("cdgoActa", cdgoActaform);
		sqlquery.setParameter("tipoCurso", desgTipocurso);
		return sqlquery.getResultList();
	}
	
	public List<GetDiferentValuesTipoDTO> getDiferentValues() {

		String sqlString = "SELECT DISTINCT (DESG_TIPOCURSO) FROM PASG.TBASG146_ACTAINCAL";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object> resultados = sqlquery.getResultList();
		List<GetDiferentValuesTipoDTO> resultadosDevueltos = new ArrayList<>();

		for (Object object : resultados) {
			
			GetDiferentValuesTipoDTO tipo = new GetDiferentValuesTipoDTO();
				
			tipo.setDesgTipoCurso((String)object);

			resultadosDevueltos.add(tipo);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg146Actaincal> getActaInCalList() {

		String sqlString = "SELECT * FROM PASG.TBASG146_ACTAINCAL";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg146Actaincal.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg146Actaincal> getActaInCalActaForma(String cdgoActaform) {

		String sqlString = "SELECT * FROM PASG.TBASG146_ACTAINCAL WHERE CDGO_ACTAFORM = :value AND MRCA_ACTIVO ='S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg146Actaincal.class);
		sqlquery.setParameter("value", cdgoActaform);
		return sqlquery.getResultList();
	}

	public List<Tbasg146Actaincal> getActaInCalActaFormaMantenimiento(String cdgoActaform) {

		String sqlString = "SELECT * FROM PASG.TBASG146_ACTAINCAL WHERE CDGO_ACTAFORM = :value "
				+ "		FETCH FIRST 1 ROW ONLY";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg146Actaincal.class);
		sqlquery.setParameter("value", cdgoActaform);
		return sqlquery.getResultList();
	}

	public List<Tbasg146Actaincal> getActasInCalActasFormaMantenimiento() {

		String sqlString = "SELECT * FROM PASG.TBASG146_ACTAINCAL" + "			" + "		ORDER BY CDGO_ACTAFORM";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg146Actaincal.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg146Actaincal> getActaInCalCount() {

		String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG146_ACTAINCAL";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg146Actaincal.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg146ActaincalDto> getActaInCalByActa(Integer cdgoActaform) {

		String sqlString = "SELECT * FROM PASG.TBASG146_ACTAINCAL" + "		WHERE" + "		    CDGO_ACTAFORM = :value"
				+ "		    AND MRCA_ACTIVO = 'S';";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoActaform);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg146ActaincalDto> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg146ActaincalDto actaincal = new Tbasg146ActaincalDto();
			
			actaincal.setCdgoActaform((Integer)object[0]);
			actaincal.setDesgTipocurso((String)object[1]);
			actaincal.setCdgoCalifi((Integer)object[2]);
			actaincal.setCdgoIdinstru((String)object[3]);
			actaincal.setFchaCurso((Date)object[4]);
			actaincal.setDesgUsuact((String)object[5]);
			actaincal.setFchaAct((Date)object[6]);
			actaincal.setMrcaActivo(String.valueOf((Character) object[7]));
			actaincal.setCdgoIdexa((String)object[8]);

			resultadosDevueltos.add(actaincal);
		}
		return resultadosDevueltos;
	}

	@Transactional
	public int insertActaInCal(Tbasg146Actaincal bean) {

		String sqlString = "INSERT INTO PASG.TBASG146_ACTAINCAL (CDGO_ACTAFORM, DESG_TIPOCURSO, CDGO_CALIFI,"
				+ "			CDGO_IDINSTRU, FCHA_CURSO, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO, CDGO_IDEXA)"
				+ "		VALUES (?, ?, ?, ?, ?, ?, CURRENT_DATE, ?, ?)";

		Query sqlquery = em.createNativeQuery(sqlString,Tbasg146Actaincal.class);

		sqlquery.setParameter(1, bean.getTbasg146actaincalpk().getCdgoActaform());
		sqlquery.setParameter(2, bean.getTbasg146actaincalpk().getDesgTipocurso());
		sqlquery.setParameter(3, bean.getCdgoCalifi());
		sqlquery.setParameter(4, bean.getCdgoIdinstru());
		sqlquery.setParameter(5, bean.getFchaCurso());
		sqlquery.setParameter(6, bean.getDesgUsuact());
		sqlquery.setParameter(7, bean.getMrcaActivo());
		sqlquery.setParameter(8, bean.getCdgoIdexa());

		return sqlquery.executeUpdate();
	}

	public int updateActaInCal(String desgTipocurso, Integer cdgoCalifi, String cdgoIdinstru, String fchaCurso, String descUsuact, String mrcaActivo, String cdgoIdexa, Integer cdgoActaform, String desgTipocursoActual) {

		String sqlString = "UPDATE PASG.TBASG146_ACTAINCAL SET DESG_TIPOCURSO = ?, CDGO_CALIFI=?, CDGO_IDINSTRU=?, FCHA_CURSO=?,"
				+ "			DESG_USUACT=?, FCHA_ACT=CURRENT_DATE, MRCA_ACTIVO=?, CDGO_IDEXA=?"
				+ "		WHERE CDGO_ACTAFORM = ? and DESG_TIPOCURSO = ?";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter(1, desgTipocurso);
		sqlquery.setParameter(2, cdgoCalifi);
		sqlquery.setParameter(3, cdgoIdinstru);
		sqlquery.setParameter(4, fchaCurso);
		sqlquery.setParameter(5, descUsuact);
		sqlquery.setParameter(6, mrcaActivo);
		sqlquery.setParameter(7, cdgoIdexa);
		sqlquery.setParameter(8, cdgoActaform);
		sqlquery.setParameter(9, desgTipocursoActual);
		return sqlquery.executeUpdate();
	}

	public int updateActaInCalMantenimiento(Tbasg146Actaincal bean) {

		String sqlString = "UPDATE PASG.TBASG146_ACTAINCAL SET " + "		DESG_TIPOCURSO = ?,"
				+ "		CDGO_CALIFI=?, " + "		CDGO_IDINSTRU=?, " + "		FCHA_CURSO=?," + "		DESG_USUACT=?, "
				+ "		FCHA_ACT=CURRENT_DATE " + "		WHERE CDGO_ACTAFORM = ? and DESG_TIPOCURSO = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg146Actaincal.class);
		sqlquery.setParameter(1, bean.getTbasg146actaincalpk().getDesgTipocurso());
		sqlquery.setParameter(2, bean.getCdgoCalifi());
		sqlquery.setParameter(3, bean.getCdgoIdinstru());
		sqlquery.setParameter(4, bean.getFchaCurso());
		sqlquery.setParameter(5, bean.getDesgUsuact());
		sqlquery.setParameter(6, bean.getTbasg146actaincalpk().getCdgoActaform());
		sqlquery.setParameter(7, bean.getTbasg146actaincalpk().getDesgTipocurso());
		return sqlquery.executeUpdate();
	}

	public int inactiveByCdgoActaForm(String usuAct, Integer cdgoActaform) {

		String sqlString = "UPDATE PASG.TBASG146_ACTAINCAL SET" + "			DESG_USUACT = :usuAct, "
				+ "			FCHA_ACT = CURRENT_DATE, " + "			MRCA_ACTIVO = 'N'"
				+ "		WHERE CDGO_ACTAFORM = :cdgoActaForm";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg146Actaincal.class);
		sqlquery.setParameter("usuAct", usuAct);
		sqlquery.setParameter("cdgoActaForm", cdgoActaform);
		return sqlquery.executeUpdate();
	}

	public int deleteActaInCal(Tbasg146Actaincal bean) {

		String sqlString = "DELETE FROM PASG.TBASG146_ACTAINCAL	WHERE CDGO_ACTAFORM = ? AND DESG_TIPOCURSO = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg146Actaincal.class);
		sqlquery.setParameter(1, bean.getTbasg146actaincalpk().getCdgoActaform());
		sqlquery.setParameter(2, bean.getTbasg146actaincalpk().getDesgTipocurso());
		return sqlquery.executeUpdate();
	}

}
