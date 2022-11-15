package renfe.com.repository.impl;

import java.sql.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.transaction.annotation.Transactional;

import renfe.com.dto.GetFormacionComplementariaPersonaListResultDTO;
import renfe.com.dto.InsertFormaccomplemenParamDTO;

import renfe.com.model.entity.Tbasg155FcCategoria;
import renfe.com.model.entity.Tbasg156FcCualificacion;
import renfe.com.model.entity.Tbasg157FormacComplemen;
import renfe.com.model.entity.Tbasg157FormacComplemenPK;
import renfe.com.model.entity.Tbasg267ExpedAcred;
import renfe.com.repository.Tbasg157FormacComplemenRepositoryCustom;

public class Tbasg157FormacComplemenRepositoryImpl implements Tbasg157FormacComplemenRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(Tbasg100PersonaRepositoryImpl.class);

	
	public List<GetFormacionComplementariaPersonaListResultDTO> getFormacComplemenPersonaList(Integer cdgoPersona, Integer cdgoCategoria, Integer cdgoCualificacion) {


		String sqlString = "SELECT " + "		    FC.CDGO_PERSONA, " + "			CA.CDGO_CATEGORIA,"
				+ "		    CA.DESG_DESCRIPCION AS CATEGORIA, " + "			CU.CDGO_CUALIFICACION, "
				+ "		    CU.DESG_NOMBRE AS CUALIFICACION,"
				+ "		    CU.DESG_DESCRIPCION AS DESG_DESCRIPCION_CUALIFICACION," + "		    FC.MRCA_ACTIVO, "
				+ "		    FC.FCHA_EXPEDICION, " + "		    FC.DESG_OBSERVACIONES "

				+ "         , FC.DESG_USUACT " 

				+ "		FROM "
				+ "		    PASG.TBASG157_FORMAC_COMPLEMEN FC"
				+ "		    INNER JOIN PASG.TBASG155_FC_CATEGORIA CA ON CA.CDGO_CATEGORIA = FC.CDGO_CATEGORIA"
				+ "		    INNER JOIN PASG.TBASG156_FC_CUALIFICACION CU ON CU.CDGO_CUALIFICACION = FC.CDGO_CUALIFICACION"
				+ "		WHERE " + "		    FC.MRCA_ACTIVO = 'S'" + "		    AND FC.CDGO_PERSONA = :cdgoPersona";
		

			if(Objects.nonNull(cdgoCategoria)) {
			sqlString = sqlString + " AND FC.CDGO_CATEGORIA = :cdgoCategoria " ;
			}

			if(Objects.nonNull(cdgoCualificacion)) {
			sqlString = sqlString + " AND FC.CDGO_CUALIFICACION = :cdgoCualificacion " ;
			}

			sqlString = sqlString + " ORDER BY CATEGORIA, CUALIFICACION";
		
		Query sqlquery = em.createNativeQuery(sqlString);
		
			if(Objects.nonNull(cdgoPersona)) {
			sqlquery.setParameter("cdgoPersona", cdgoPersona);
			}

			if(Objects.nonNull(cdgoCategoria)) {
			sqlquery.setParameter("cdgoCategoria", cdgoCategoria);
			}

			if(Objects.nonNull(cdgoCualificacion)) {
			sqlquery.setParameter("cdgoCualificacion", cdgoCualificacion);
			}
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetFormacionComplementariaPersonaListResultDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetFormacionComplementariaPersonaListResultDTO formacom = new GetFormacionComplementariaPersonaListResultDTO();
			logger.info("object0 {}, object1 {}, object2 {} ",object[0], object[1], object[3]);
			/*Tbasg157FormacComplemenPK formacomPK = new Tbasg157FormacComplemenPK();
			Tbasg155FcCategoria categoria = new Tbasg155FcCategoria();
			Tbasg156FcCualificacion cualificacion = new Tbasg156FcCualificacion();*/
			
			//formacomPK.setCdgoPersona((Integer) object[0]);
			formacom.setCdgoPersona((Integer) object[0]);
			//categoria.setCdgoCategoria(Long.valueOf((int)object[1]));
			formacom.setCdgoCategoria((Integer) object[1]);
			formacom.setCategoria((String)object[2]);
			//cualificacion.setCdgoCualificacion(Long.valueOf((int)object[3]));
			formacom.setCdgoCualificacion((Integer) object[3]);
			formacom.setCualificacion((String)object[4]);
			formacom.setDesgCualificacion((String)object[5]);
			formacom.setActivo(String.valueOf((java.lang.Character) object[6]));
			formacom.setFechaExpedicion((Date) object[7]);
			formacom.setObservaciones((String)object[8]);
			formacom.setDesgUsuact((String)object[9]);

			resultadosDevueltos.add(formacom);
		}
		return resultadosDevueltos;
	}

	@Transactional
	public int insertFormacComplemen(InsertFormaccomplemenParamDTO bean) {
		int result = 0; 

		if (Objects.nonNull(bean.getCdgoPersona())) {
			String sqlString = 
			      " INSERT INTO PASG.TBASG157_FORMAC_COMPLEMEN "
				+ "  ( CDGO_PERSONA, CDGO_CATEGORIA, CDGO_CUALIFICACION, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO, FCHA_EXPEDICION, DESG_OBSERVACIONES )"
				+ "	VALUES 	( :cdgoPersona , :cdgoCategoria , :cdgoCualificacion , :desgUsuact , CURRENT_DATE , :mrcaActivo , :fechaExpedicion , :observaciones );";

			Query sqlquery = em.createNativeQuery(sqlString);

			sqlquery.setParameter("cdgoPersona", bean.getCdgoPersona());
			sqlquery.setParameter("cdgoCategoria", bean.getCdgoCategoria());
			sqlquery.setParameter("cdgoCualificacion", bean.getCdgoCualificacion());
			sqlquery.setParameter("desgUsuact", bean.getDesgUsuact());
			sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo()); 
			sqlquery.setParameter("fechaExpedicion", bean.getFechaExpedicion());
			sqlquery.setParameter("observaciones", bean.getObservaciones());

			result = sqlquery.executeUpdate();
			
			/*
			Query sqlquery = em.createNativeQuery(sqlString);
			sqlquery.setParameter(1, bean.getCdgoPersona());
			sqlquery.setParameter(2, bean.getCdgoCategoria());
			sqlquery.setParameter(3, bean.getCdgoCualificacion());
			sqlquery.setParameter(4, bean.getDesgUsuact());
			sqlquery.setParameter(5, bean.getActivo());
			sqlquery.setParameter(6, bean.getFechaExpedicion());
			sqlquery.setParameter(7, bean.getObservaciones()); 
			return sqlquery.executeUpdate();
			

				String nuevo = f.format(object[9]);
				try {
					persona.setFchaCurso((Date) f.parse(nuevo));
				} catch (ParseException e) {
					e.printStackTrace();
				}		
			
			*/
		}

		return result;
	}

	public int updateFormacComplemen(Tbasg157FormacComplemen bean) {

		String sqlString = "UPDATE PASG.TBASG157_FORMAC_COMPLEMEN SET FCHA_EXPEDICION = ? "
				+ "			 WHERE CDGO_PERSONA = ? AND CDGO_CATEGORIA = ? AND CDGO_CUALIFICACION = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg157FormacComplemen.class);
		sqlquery.setParameter(1, bean.getFchaExpedicion());
		sqlquery.setParameter(2, bean.getTbasg157formaccomplemenpk().getCdgoPersona());
		sqlquery.setParameter(3, bean.getTbasg157formaccomplemenpk().getCdgoCategoria());
		sqlquery.setParameter(4, bean.getTbasg157formaccomplemenpk().getCdgoCualificacion());
		return sqlquery.executeUpdate();
	}

	public int deleteFormacComplemen(Integer cdgoPersona, Integer cdgoCategoria, Integer cdgoCualificacion) {

		String sqlString = "DELETE FROM PASG.TBASG157_FORMAC_COMPLEMEN " + "		WHERE "
				+ "		    CDGO_PERSONA = :cdgoPersona AND CDGO_CATEGORIA = :cdgoCategoria AND CDGO_CUALIFICACION = :cdgoCualificacion";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg157FormacComplemen.class);
		sqlquery.setParameter("cdgoPersona", cdgoPersona);
		sqlquery.setParameter("cdgoCategoria", cdgoCategoria);
		sqlquery.setParameter("cdgoCualificacion", cdgoCualificacion);
		return sqlquery.executeUpdate();
	}
	
	public List<Tbasg157FormacComplemen> getFormaComplemenPersona(Integer cdgoPersona) {

		String sqlString = "SELECT CDGO_PERSONA, CDGO_CATEGORIA, CDGO_CUALIFICACION, FCHA_EXPEDICION, DESG_OBSERVACIONES  FROM PASG.TBASG157_FORMAC_COMPLEMEN WHERE CDGO_PERSONA = :value ";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg157FormacComplemen> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg157FormacComplemen formaComple = new Tbasg157FormacComplemen();
			Tbasg157FormacComplemenPK formaComplePK = new Tbasg157FormacComplemenPK();
			
			formaComplePK.setCdgoPersona((Integer)object[0]);
			formaComplePK.setCdgoCategoria((Integer)object[1]);
			formaComplePK.setCdgoCualificacion((Integer)object[2]);
			
			formaComple.setTbasg157formaccomplemenpk(formaComplePK);
			
			formaComple.setFchaExpedicion((Date) object[3]);
			formaComple.setDesgObservaciones((String) object[4]);

			resultadosDevueltos.add(formaComple);
		}
		return resultadosDevueltos;
	}

}
