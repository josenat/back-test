package renfe.com.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg269Segur;
import renfe.com.repository.Tbasg269SegurRepositoryCustom;

public class Tbasg269SegurRepositoryImpl implements Tbasg269SegurRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public int insertSeguridadLOPD(Tbasg269Segur bean) {

		String sqlString = "INSERT INTO PASG.TBASG269_SEGUR (CDGO_PROCESO, CDGO_SUB_PROCESO, DESG_PROCESO, DESG_SUBPROCESO, "
				+ "		ROL, NIVEL, USUARIO, FCHA_ACCESO,DESCRIP_ROL)"
				+ "		VALUES (?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP,?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg269Segur.class);
		sqlquery.setParameter(1, bean.getCdgoProceso());
		sqlquery.setParameter(2, bean.getCdgoSubProceso());
		sqlquery.setParameter(3, bean.getDesgProceso());
		sqlquery.setParameter(4, bean.getDesgSubproceso());
		sqlquery.setParameter(5, bean.getRol());
		sqlquery.setParameter(6, bean.getNivel());
		sqlquery.setParameter(7, bean.getUsuario());
		sqlquery.setParameter(8, bean.getDescripRol());
		return sqlquery.executeUpdate();
	}

}
