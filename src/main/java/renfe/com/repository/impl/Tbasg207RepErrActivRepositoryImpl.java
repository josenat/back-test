package renfe.com.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg207RepErrActiv;
import renfe.com.repository.Tbasg207RepErrActivRepositoryCustom;

public class Tbasg207RepErrActivRepositoryImpl implements Tbasg207RepErrActivRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public int insertRepErrActiv(Tbasg207RepErrActiv bean) {

		String sqlString = "INSERT INTO PASG.TBASG207_REP_ERR_ACTIV (CDGO_ERROR, DESG_MATRICULA, CDGO_TIPOID, DESG_ID,"
				+ "				DESG_APELLIDO1, DESG_APELLIDO2, DESG_NOMBRE, FCHA_NAC, CDGO_PAISNAC,"
				+ "				DESG_NACIONALIDAD, FCHA_INGRESO, CDGO_CATEGORIA, DESG_CATEGORIA, CDGO_CTROCOSTE,"
				+ "				DESG_UNIDADPRESUP, CDGO_DIVISION, DESG_DIVISION, CDGO_RESIDENCIA, DESG_RESIDENCIA,"
				+ "				CDGO_TIPOVIA, DESG_NOMBREVIA, DESG_AUXILIAR, DESG_NUMERO, DESG_PLANTA, DESG_PUERTA, "
				+ "				CDGO_POSTAL, DESG_MUNICIPIO, CDGO_PROVINCIA, DESG_PROVINCIA, CDGO_PAISDIR, "
				+ "				DESG_USUACT, FCHA_ACT, FCHA_ANTIG_CARGO)"
				+ "		VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
				+ "				?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg207RepErrActiv.class);
		sqlquery.setParameter(1, bean.getCdgoError());
		sqlquery.setParameter(2, bean.getDesgMatricula());
		sqlquery.setParameter(3, bean.getCdgoTipoid());
		sqlquery.setParameter(4, bean.getDesgId());
		sqlquery.setParameter(5, bean.getDesgApellido1());
		sqlquery.setParameter(6, bean.getDesgApellido2());
		sqlquery.setParameter(7, bean.getDesgNombre());
		sqlquery.setParameter(8, bean.getFchaNac());
		sqlquery.setParameter(9, bean.getCdgoPaisnac());
		sqlquery.setParameter(10, bean.getDesgNacionalidad());
		sqlquery.setParameter(11, bean.getFchaIngreso());
		sqlquery.setParameter(12, bean.getCdgoCategoria());
		sqlquery.setParameter(13, bean.getDesgCategoria());
		sqlquery.setParameter(14, bean.getCdgoCtrocoste());
		sqlquery.setParameter(15, bean.getDesgUnidadpresup());
		sqlquery.setParameter(16, bean.getCdgoDivision());
		sqlquery.setParameter(17, bean.getDesgDivision());
		sqlquery.setParameter(18, bean.getCdgoResidencia());
		sqlquery.setParameter(19, bean.getDesgResidencia());
		sqlquery.setParameter(20, bean.getCdgoTipovia());
		sqlquery.setParameter(21, bean.getDesgNombrevia());
		sqlquery.setParameter(22, bean.getDesgAuxiliar());
		sqlquery.setParameter(23, bean.getDesgNumero());
		sqlquery.setParameter(24, bean.getDesgPlanta());
		sqlquery.setParameter(25, bean.getDesgPuerta());
		sqlquery.setParameter(26, bean.getCdgoPostal());
		sqlquery.setParameter(27, bean.getDesgMunicipio());
		sqlquery.setParameter(28, bean.getCdgoProvincia());
		sqlquery.setParameter(29, bean.getDesgProvincia());
		sqlquery.setParameter(30, bean.getCdgoPaisdir());
		sqlquery.setParameter(31, bean.getDesgUsuact());
		sqlquery.setParameter(32, bean.getFchaAntigCargo());
		return sqlquery.executeUpdate();
	}

}
