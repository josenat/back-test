package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.dto.GetErrActivDTO;
import renfe.com.dto.GetErrListParam;
import renfe.com.model.entity.Tbasg201ErrSalud;
import renfe.com.model.entity.Tbasg202ErrActiv;
import renfe.com.repository.Tbasg202ErrActivRepositoryCustom;

public class Tbasg202ErrActivRepositoryImpl implements Tbasg202ErrActivRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	/*public List<Tbasg202ErrActiv> getErrActivList() {

		String sqlString = "SELECT * FROM PASG.TBASG202_ERR_ACTIV";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg202ErrActiv.class);

		return sqlquery.getResultList();
	}*/
	
	public List<Tbasg202ErrActiv> getErrActivList(GetErrListParam filter) {

		String sqlString = "SELECT * FROM PASG.TBASG202_ERR_ACTIV WHERE";
		
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
		List<Tbasg202ErrActiv> resultadosDevueltos = new ArrayList<Tbasg202ErrActiv>();
		for (Object[] object : resultados) {
			Tbasg202ErrActiv errActiv = new Tbasg202ErrActiv();
			
			errActiv.setCdgoError(Long.valueOf((int)object[0]));
			errActiv.setDesgError((String)object[1]);
			errActiv.setFchaError((Date)object[2]);
			errActiv.setDesgFichero((String)object[3]);
			errActiv.setDesgMatricula((String)object[4]);
			errActiv.setCdgoTipoid((Integer) object[5]);
			errActiv.setDesgId((String)object[6]);
			errActiv.setDesgApellido1((String)object[7]);
			errActiv.setDesgApellido2((String)object[8]);
			errActiv.setDesgNombre((String)object[9]);
			errActiv.setFchaNac((Date)object[10]);
			errActiv.setCdgoPaisnac((String)object[11]);
			errActiv.setDesgNacionalidad((String)object[12]);
			errActiv.setFchaIngreso((Date)object[13]);
			errActiv.setCdgoCategoria((String)object[14]);
			errActiv.setDesgCategoria((String)object[15]);
			errActiv.setCdgoCtrocoste((String)object[16]);
			errActiv.setDesgUnidadpresup((String)object[17]);
			errActiv.setCdgoDivision((String)object[18]);
			errActiv.setDesgDivision((String)object[19]);
			errActiv.setCdgoResidencia((String)object[20]);
			errActiv.setDesgResidencia((String)object[21]);
			errActiv.setCdgoTipovia((String)object[22]);
			errActiv.setDesgNombrevia((String)object[23]);
			errActiv.setDesgAuxiliar((String)object[24]);
			errActiv.setDesgNumero((String)object[25]);
			errActiv.setDesgPlanta((String)object[26]);
			errActiv.setDesgPuerta((String)object[27]);
			errActiv.setCdgoPostal((String)object[28]);
			errActiv.setDesgMunicipio((String)object[29]);
			errActiv.setCdgoProvincia((Integer) object[30]);
			errActiv.setDesgProvincia((String)object[31]);
			errActiv.setCdgoPaisnac((String)object[32]);			
			errActiv.setMrcaReprocesado(String.valueOf((Character)object[33]));
			errActiv.setFchaAntigCargo((Date)object[34]);

			resultadosDevueltos.add(errActiv);
		}
		return resultadosDevueltos;
	}

	public List<GetErrActivDTO> getErrActiv(Integer cdgoError) {

		String sqlString = "SELECT EA.*, TD.DESG_NOMBRE AS TIPOID_NOMBRE, NA1.DESG_NOMBRE AS PAISNAC_NOMBRE, "
				+ "		TV.DESG_NOMBRE AS TIPOVIA_NOMBRE, NA2.DESG_NOMBRE AS PAISDIR_NOMBRE "
				+ "		FROM PASG.TBASG202_ERR_ACTIV EA"
				+ "		LEFT JOIN PASG.TBASG150_TIPODOC TD ON TD.CDGO_TIPODOC = EA.CDGO_TIPOID "
				+ "		LEFT JOIN PASG.TBASG134_NACION NA1 ON NA1.CDGO_SAP = EA.CDGO_PAISNAC "
				+ "		LEFT JOIN PASG.TBASG107_TIPOVIA TV ON TV.CDGO_SAP = EA.CDGO_TIPOVIA "
				+ "		LEFT JOIN PASG.TBASG134_NACION NA2 ON NA2.CDGO_SAP = EA.CDGO_PAISDIR "
				+ "		WHERE EA.CDGO_ERROR = :value";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoError);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetErrActivDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetErrActivDTO errActiv = new GetErrActivDTO();

			errActiv.setCdgoError(Long.valueOf((int)object[0]));
			errActiv.setDesgError((String)object[1]);
			errActiv.setFchaError((Date)object[2]);
			errActiv.setDesgFichero((String)object[3]);
			errActiv.setDesgMatricula((String)object[4]);
			errActiv.setCdgoTipoid((Integer) object[5]);
			errActiv.setDesgId((String)object[6]);
			errActiv.setDesgApellido1((String)object[7]);
			errActiv.setDesgApellido2((String)object[8]);
			errActiv.setDesgNombre((String)object[9]);
			errActiv.setFchaNac((Date)object[10]);
			errActiv.setCdgoPaisnac((String)object[11]);
			errActiv.setDesgNacionalidad((String)object[12]);
			errActiv.setFchaIngreso((Date)object[13]);
			errActiv.setCdgoCategoria((String)object[14]);
			errActiv.setDesgCategoria((String)object[15]);
			errActiv.setCdgoCtrocoste((String)object[16]);
			errActiv.setDesgUnidadpresup((String)object[17]);
			errActiv.setCdgoDivision((String)object[18]);
			errActiv.setDesgDivision((String)object[19]);
			errActiv.setCdgoResidencia((String)object[20]);
			errActiv.setDesgResidencia((String)object[21]);
			errActiv.setCdgoTipovia((String)object[22]);
			errActiv.setDesgNombrevia((String)object[23]);
			errActiv.setDesgAuxiliar((String)object[24]);
			errActiv.setDesgNumero((String)object[25]);
			errActiv.setDesgPlanta((String)object[26]);
			errActiv.setDesgPuerta((String)object[27]);
			errActiv.setCdgoPostal((String)object[28]);
			errActiv.setDesgMunicipio((String)object[29]);
			errActiv.setCdgoProvincia((Integer) object[30]);
			errActiv.setDesgProvincia((String)object[31]);
			errActiv.setCdgoPaisnac((String)object[32]);			
			errActiv.setMrcaReprocesado(String.valueOf((Character)object[33]));
			errActiv.setFchaAntigCargo((Date)object[34]);
			
			errActiv.setTipoIdNombre((String) object[35]);
			errActiv.setPaisNacNombre((String) object[36]);
			errActiv.setTipoViaNombre((String) object[37]);
			errActiv.setPaisDirnombre((String) object[38]);

			resultadosDevueltos.add(errActiv);
		}
		return resultadosDevueltos;
	}

	public int updateErrActiv(Tbasg202ErrActiv bean) {

		String sqlString = "UPDATE PASG.TBASG202_ERR_ACTIV SET" + "			MRCA_REPROCESADO = :mrcaReprocesado"
				+ "		WHERE CDGO_ERROR = :cdgoError";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg202ErrActiv.class);
		sqlquery.setParameter("mrcaReprocesado", bean.getMrcaReprocesado());
		sqlquery.setParameter("cdgoError", bean.getCdgoError());
		return sqlquery.executeUpdate();
	}
	

	public int deleteErrActiv(Integer cdgoError) {

		String sqlString = "DELETE FROM PASG.TBASG202_ERR_ACTIV" + "		WHERE CDGO_ERROR = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg202ErrActiv.class);
		sqlquery.setParameter("value", cdgoError);
		return sqlquery.executeUpdate();
	}


}
