package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.dto.GetErrFormaDTO;
import renfe.com.dto.GetErrListParam;
import renfe.com.dto.GetErrSaludDTO;
import renfe.com.model.entity.Tbasg204ErrForma;
import renfe.com.repository.Tbasg204ErrFormaRepositoryCustom;

public class Tbasg204ErrFormaRepositoryImpl implements Tbasg204ErrFormaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg204ErrForma> getErrFormaList(GetErrListParam filter) {

		String sqlString = "SELECT * FROM PASG.TBASG204_ERR_FORMA WHERE";
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
		List<Tbasg204ErrForma> resultadosDevueltos = new ArrayList<Tbasg204ErrForma>();
		for (Object[] object : resultados) {
			Tbasg204ErrForma errForma = new Tbasg204ErrForma();
			
			errForma.setCdgoError(Long.valueOf((int)object[0]));
			errForma.setDesgError((String)object[1]);
			errForma.setFchaError((Date)object[2]);
			errForma.setDesgFichero((String)object[3]);
			errForma.setCdgoSolicitud((Integer)object[4]);
			errForma.setCdgoSapcentform((String)object[5]);
			errForma.setDesgCif((String)object[6]);
			errForma.setCdgoActo((String)object[7]);
			errForma.setDesgDescacto((String)object[8]);
			errForma.setFchaTeorico((Date)object[9]);
			errForma.setDesgTeNominstr((String)object[10]);
			errForma.setDesgTeApellinstr1((String)object[11]);
			errForma.setDesgTeApellinstr2((String)object[12]);
			errForma.setDesgTeNifinstr((String)object[13]);
			errForma.setCdgoTeCalifi((Integer)object[14]);
			errForma.setFchaPractico((Date)object[15]);
			errForma.setDesgPrNominstr((String)object[16]);
			errForma.setDesgPrApellinstr1((String)object[17]);
			errForma.setDesgPrApellinstr2((String)object[18]);
			errForma.setDesgPrNifinstr((String)object[19]);
			errForma.setCdgoPrCalifi((Integer)object[20]);
			errForma.setFchaTeoriprac((Date)object[21]);
			errForma.setDesgTpNominstr((String)object[22]);
			errForma.setDesgTpApellinstr1((String)object[23]);
			errForma.setDesgTpApellinstr2((String)object[24]);
			errForma.setDesgTpNifinstr((String)object[25]);
			errForma.setCdgoTpCalifi((Integer)object[26]);
			errForma.setFchaReciclaje((Date)object[27]);
			errForma.setDesgReNominstr((String)object[28]);
			errForma.setDesgReApellinstr1((String)object[29]);
			errForma.setDesgReApellinstr2((String)object[30]);
			errForma.setDesgReNifinstr((String)object[31]);
			errForma.setDesgObservaciones((String)object[32]);				
			errForma.setMrcaReprocesado(String.valueOf((Character)object[33]));

			resultadosDevueltos.add(errForma);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg204ErrForma> getErrFormaList2() {

		String sqlString = "SELECT EF.*,C4.DESG_NIFPAS AS DESG_NIFPAS, CF.DESG_NOMBRE AS SAPCENTFORM_NOMBRE, C1.DESG_NOMBRE AS TECALIFI_NOMBRE, "
				+ "		C2.DESG_NOMBRE AS PRCALIF_NOMBRE, C3.DESG_NOMBRE AS TPCALIF_NOMBRE   "
				+ "		FROM PASG.TBASG204_ERR_FORMA EF"
				+ "		LEFT JOIN PASG.TBASG120_CENTFORMA CF ON (CF.CDGO_SAP = EF.CDGO_SAPCENTFORM AND EF.CDGO_SAPCENTFORM <> '') "
				+ "		LEFT JOIN PASG.TBASG115_CALIFICAC C1 ON C1.CDGO_CALIFI = EF.CDGO_TE_CALIFI  "
				+ "		LEFT JOIN PASG.TBASG115_CALIFICAC C2 ON C2.CDGO_CALIFI = EF.CDGO_PR_CALIFI  "
				+ "		LEFT JOIN PASG.TBASG115_CALIFICAC C3 ON C3.CDGO_CALIFI = EF.CDGO_TP_CALIFI  "
				+ "		LEFT JOIN PASG.TBASG197_FORMACION C4 ON C4.CDGO_SOLICITUD = EF.CDGO_SOLICITUD";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg204ErrForma.class);

		return sqlquery.getResultList();
	}

	public List<GetErrFormaDTO> getErrForma(Integer cdgoError) {

		String sqlString = "SELECT EF.*,C4.DESG_NIFPAS AS DESG_NIFPAS, CF.DESG_NOMBRE AS SAPCENTFORM_NOMBRE, C1.DESG_NOMBRE AS TECALIFI_NOMBRE, "
				+ "		C2.DESG_NOMBRE AS PRCALIF_NOMBRE, C3.DESG_NOMBRE AS TPCALIF_NOMBRE  "
				+ "		FROM PASG.TBASG204_ERR_FORMA EF"
				+ "		LEFT JOIN PASG.TBASG120_CENTFORMA CF ON (CF.CDGO_SAP = EF.CDGO_SAPCENTFORM AND EF.CDGO_SAPCENTFORM <> '') "
				+ "		LEFT JOIN PASG.TBASG115_CALIFICAC C1 ON C1.CDGO_CALIFI = EF.CDGO_TE_CALIFI  "
				+ "		LEFT JOIN PASG.TBASG115_CALIFICAC C2 ON C2.CDGO_CALIFI = EF.CDGO_PR_CALIFI  "
				+ "		LEFT JOIN PASG.TBASG115_CALIFICAC C3 ON C3.CDGO_CALIFI = EF.CDGO_TP_CALIFI  "
				+ "		LEFT JOIN PASG.TBASG197_FORMACION C4 ON C4.CDGO_SOLICITUD = EF.CDGO_SOLICITUD "
				+ "		WHERE EF.CDGO_ERROR = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoError);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetErrFormaDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetErrFormaDTO errForma = new GetErrFormaDTO();

			errForma.setCdgoError((Integer)object[0]);
			errForma.setDesgError((String)object[1]);
			errForma.setFchaError((Date)object[2]);
			errForma.setDesgFichero((String)object[3]);
			errForma.setCdgoSolicitud((Integer)object[4]);
			errForma.setCdgoSapcentform((String)object[5]);
			errForma.setDesgCif((String)object[6]);
			errForma.setCdgoActo((String)object[7]);
			errForma.setDesgDescacto((String)object[8]);
			errForma.setFchaTeorico((Date)object[9]);
			errForma.setDesgTeNominstr((String)object[10]);
			errForma.setDesgTeApellinstr1((String)object[11]);
			errForma.setDesgTeApellinstr2((String)object[12]);
			errForma.setDesgTeNifinstr((String)object[13]);
			errForma.setCdgoTeCalifi((Integer)object[14]);
			errForma.setFchaPractico((Date)object[15]);
			errForma.setDesgPrNominstr((String)object[16]);
			errForma.setDesgPrApellinstr1((String)object[17]);
			errForma.setDesgPrApellinstr2((String)object[18]);
			errForma.setDesgPrNifinstr((String)object[19]);
			errForma.setCdgoPrCalifi((Integer)object[20]);
			errForma.setFchaTeoriprac((Date)object[21]);
			errForma.setDesgTpNominstr((String)object[22]);
			errForma.setDesgTpApellinstr1((String)object[23]);
			errForma.setDesgTpApellinstr2((String)object[24]);
			errForma.setDesgTpNifinstr((String)object[25]);
			errForma.setCdgoTpCalifi((Integer)object[26]);
			errForma.setFchaReciclaje((Date)object[27]);
			errForma.setDesgReNominstr((String)object[28]);
			errForma.setDesgReApellinstr1((String)object[29]);
			errForma.setDesgReApellinstr2((String)object[30]);
			errForma.setDesgReNifinstr((String)object[31]);
			errForma.setDesgObservaciones((String)object[32]);				
			errForma.setMrcaReprocesado(String.valueOf((Character)object[33]));
			errForma.setDesgNifPas((String) object[34]);
			errForma.setSapCentFormNombre((String) object[35]);
			errForma.setTeCalifiNombre((String) object[36]);
			errForma.setPrCalifiNombre((String) object[37]);
			errForma.setTpCalifiNombre((String) object[38]);

			resultadosDevueltos.add(errForma);
		}
		return resultadosDevueltos;
	}

	public int updateErrForma(Tbasg204ErrForma bean) {

		String sqlString = "UPDATE PASG.TBASG204_ERR_FORMA SET" + "			MRCA_REPROCESADO = ?"
				+ "		WHERE CDGO_ERROR = ?";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg204ErrForma.class);
		sqlquery.setParameter(1, bean.getMrcaReprocesado());
		sqlquery.setParameter(2, bean.getCdgoError());
		return sqlquery.executeUpdate();
	}

	public int deleteErrForma(Integer cdgoError) {

		String sqlString = "DELETE FROM PASG.TBASG204_ERR_FORMA" + "		WHERE CDGO_ERROR = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg204ErrForma.class);
		sqlquery.setParameter("value", cdgoError);
		return sqlquery.executeUpdate();
	}

}
