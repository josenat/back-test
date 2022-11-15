package renfe.com.repository.impl;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import renfe.com.dto.GetErrSaludDTO;
import renfe.com.dto.GetErrListParam;
import renfe.com.model.entity.Tbasg100Persona;
import renfe.com.model.entity.Tbasg201ErrSalud;
import renfe.com.repository.Tbasg201ErrSaludRepositoryCustom;

public class Tbasg201ErrSaludRepositoryImpl implements Tbasg201ErrSaludRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(Tbasg100PersonaRepositoryImpl.class);

	public List<Tbasg201ErrSalud> getErrSaludList(GetErrListParam filter) {

		String sqlString = "SELECT * FROM PASG.TBASG201_ERR_SALUD WHERE";
		
		if(filter!=null) {

			if(Objects.nonNull(filter.getReprocesado())) {

			sqlString = sqlString + " MRCA_REPROCESADO = :reprocesado AND" ;
			}
			
			if(Objects.nonNull(filter.getFchaDesdeError())) {

				sqlString = sqlString + " FCHA_ERROR >= :fchaDesdeError " ;
			}
			
			if(Objects.nonNull(filter.getFchaDesdeError())) {

				sqlString = sqlString + " AND FCHA_ERROR <= :fchaHastaError " ;
			}
			
			/*if(Objects.nonNull(filter.getColumOrden())) {

				if("FECHA".equals(filter.getColumOrden())) {
					
					if("A".equals(filter.getCdgoOrden())){
						sqlString = sqlString + " ORDER BY FCHA_ERROR ASC, CDGO_ERROR ASC " ;
					}
					
					if("D".equals(filter.getCdgoOrden())){
						sqlString = sqlString + " ORDER BY FCHA_ERROR DESC, CDGO_ERROR DESC " ;
					}
					
				}
			}*/
			
		}
		
		
		Query sqlquery = em.createNativeQuery(sqlString);
		
		
		if(filter!=null) {

			if(Objects.nonNull(filter.getReprocesado())) {

				sqlquery.setParameter("reprocesado", filter.getReprocesado());
			}
			
			if(Objects.nonNull(filter.getFchaDesdeError())) {

				sqlquery.setParameter("fchaDesdeError", filter.getFchaDesdeError());
			}
			
			if(Objects.nonNull(filter.getFchaDesdeError())) {

				sqlquery.setParameter("fchaHastaError", filter.getFchaHastaError());
			}
			
		}
		
		

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg201ErrSalud> resultadosDevueltos = new ArrayList<Tbasg201ErrSalud>();
		for (Object[] object : resultados) {
			Tbasg201ErrSalud errSalud = new Tbasg201ErrSalud();
			
			errSalud.setCdgoError(Long.valueOf((int)object[0]));
			errSalud.setDesgError((String)object[1]);
			errSalud.setFchaError((Date)object[2]);
			errSalud.setDesgFichero((String)object[3]);
			errSalud.setDesgMatricula((String)object[4]);
			errSalud.setDesgNifpas((String)object[5]);
			errSalud.setDesgNombre((String)object[6]);
			errSalud.setDesgApell1((String)object[7]);
			errSalud.setDesgApell2((String)object[8]);
			errSalud.setDesgMotivorev((String)object[9]);
			errSalud.setDesgCalific((String)object[10]);
			errSalud.setDesgNumcolegiado((String)object[11]);
			errSalud.setDesgNombrefacult((String)object[12]);
			errSalud.setDesgApell1Facult((String)object[13]);
			errSalud.setDesgApell2Facult((String)object[14]);
			errSalud.setMrcaCorrecvisu(String.valueOf((Character)object[15]));
			errSalud.setMrcaProteaudi(String.valueOf((Character)object[16]));
			errSalud.setDesgCentromed((String)object[17]);
			errSalud.setFchaReconoc((Date)object[18]);
			errSalud.setFchaValidezcert((Date)object[19]);
			errSalud.setFchaProxrev((Date)object[20]);
			errSalud.setDesgAmbitovalcert((String)object[21]);
			errSalud.setMrcaReprocesado(String.valueOf((Character)object[22]));

			resultadosDevueltos.add(errSalud);
		}
		return resultadosDevueltos;
	}

	public List<GetErrSaludDTO> getErrSalud(Integer cdgoError) {

		String sqlString = "SELECT ES.*, CM.DESG_NOMBRE AS CENTROMEDIC_NOMBRE FROM PASG.TBASG201_ERR_SALUD ES"
				+ "		LEFT JOIN PASG.TBASG108_CENTMEDIC CM ON (CM.CDGO_SAP = ES.DESG_CENTROMED AND ES.DESG_CENTROMED <> '')"
				+ "		WHERE ES.CDGO_ERROR = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoError);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetErrSaludDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetErrSaludDTO errSalud = new GetErrSaludDTO();

			errSalud.setCdgoError((Integer) object[0]);
			errSalud.setDesgError((String) object[1]);
			errSalud.setFchaError((Date) object[2]);
			errSalud.setDesgFichero((String) object[3]);
			errSalud.setDesgMatricula((String) object[4]);
			errSalud.setDesgNifPas((String) object[5]);
			errSalud.setDesgNombre((String) object[6]);
			errSalud.setDesgApell1((String) object[7]);
			errSalud.setDesgApell2((String) object[8]);
			errSalud.setDesgMotivoRev((String) object[9]);
			errSalud.setDesgCalific((String) object[10]);
			errSalud.setDesgNumColegiado((String) object[11]);
			errSalud.setDesgNombreFacult((String) object[12]);
			errSalud.setDesgApell1Facult((String) object[13]);
			errSalud.setDesgApell2Facult((String) object[14]);
			errSalud.setMrcaCorrVisu(String.valueOf((Character) object[15]));
			errSalud.setMrcaProteaudi(String.valueOf((Character) object[16]));
			errSalud.setDesgCentroMec((String) object[17]);
			errSalud.setFchaReconoc((Date) object[18]);
			errSalud.setFchaValidezCert((Date) object[19]);
			errSalud.setFchaProxRec((Date) object[20]);
			errSalud.setDesgAmbitoValcert((String) object[21]);
			errSalud.setMrcaReprocesado(String.valueOf((Character) object[22]));
			errSalud.setCentroMedicNombre((String) object[23]);

			resultadosDevueltos.add(errSalud);
		}
		return resultadosDevueltos;
	}

	/*public int updateErrSalud(Tbasg201ErrSalud bean) {

		String sqlString = "UPDATE PASG.TBASG201_ERR_SALUD SET" + "			MRCA_REPROCESADO = ?"
				+ "		WHERE CDGO_ERROR = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg201ErrSalud.class);
		sqlquery.setParameter(1, bean.getMrcaReprocesado());
		sqlquery.setParameter(2, bean.getCdgoError());
		return sqlquery.executeUpdate();
	}*/
	
	public int updateErrSalud(Tbasg201ErrSalud bean) {

		String sqlString = "UPDATE PASG.TBASG201_ERR_SALUD SET" + "			MRCA_REPROCESADO = :mrcaReprocesado "
				+ "		WHERE CDGO_ERROR = :cdgoError";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg201ErrSalud.class);
		sqlquery.setParameter("cdgoError", bean.getCdgoError());
		sqlquery.setParameter("mrcaReprocesado", bean.getMrcaReprocesado());
		return sqlquery.executeUpdate();
	}

	public int deleteErrSalud(Integer cdgoError) {

		String sqlString = "DELETE FROM PASG.TBASG201_ERR_SALUD" + "		WHERE CDGO_ERROR = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg201ErrSalud.class);
		sqlquery.setParameter("value", cdgoError);
		return sqlquery.executeUpdate();
	}

}
