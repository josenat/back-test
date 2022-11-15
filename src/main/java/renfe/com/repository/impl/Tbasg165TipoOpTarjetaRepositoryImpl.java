package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg165TipoOpTarjeta;
import renfe.com.repository.Tbasg165TipoOpTarjetaRepositoryCustom;

public class Tbasg165TipoOpTarjetaRepositoryImpl implements Tbasg165TipoOpTarjetaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg165TipoOpTarjeta> getTipoOpTarjetaActiveList() {

		String sqlString = "SELECT * FROM PASG.TBASG165_TIPO_OP_TARJETA WHERE MRCA_ACTIVO='S' ORDER BY CDGO_OPERACION";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg165TipoOpTarjeta.class);

		return sqlquery.getResultList();
	}

}
