package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg170VehiculoOvm;
import renfe.com.repository.Tbasg170VehiculoOvmRepositoryCustom;

public class Tbasg170VehiculoOvmRepositoryImpl implements Tbasg170VehiculoOvmRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg170VehiculoOvm> getVehiculoOVMListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG170_VEHICULO_OVM ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg170VehiculoOvm> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg170VehiculoOvm vehiculoOvm = new Tbasg170VehiculoOvm();
			
			vehiculoOvm.setCdgoVehiculo(Long.valueOf((int)object[0]));
			vehiculoOvm.setDesgNombre((String)object[1]);
			vehiculoOvm.setDesgUsuact((String)object[2]);
			vehiculoOvm.setFchaAct((Date) object[3]);
			vehiculoOvm.setMrcaActivo(String.valueOf((Character) object[4]));

			resultadosDevueltos.add(vehiculoOvm);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg170VehiculoOvm> getVehiculoOVMListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG170_VEHICULO_OVM ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg170VehiculoOvm.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg170VehiculoOvm> getVehiculoOVMCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG170_VEHICULO_OVM";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg170VehiculoOvm.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg170VehiculoOvm> getVehiculoOVM(String cdgoVehiculo) {

		String sqlString = "SELECT * FROM PASG.TBASG170_VEHICULO_OVM WHERE CDGO_VEHICULO=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg170VehiculoOvm.class);
		sqlquery.setParameter("value", cdgoVehiculo);
		return sqlquery.getResultList();
	}

	public List<Tbasg170VehiculoOvm> getVehiculoOVMListActive() {

		String sqlString = "SELECT * FROM PASG.TBASG170_VEHICULO_OVM WHERE MRCA_ACTIVO='S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg170VehiculoOvm.class);

		return sqlquery.getResultList();
	}

	public int insertVehiculoOVM(Tbasg170VehiculoOvm bean) {

		String sqlString = "INSERT INTO PASG.TBASG170_VEHICULO_OVM (DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO) VALUES (?,?,CURRENT_DATE,?);";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg170VehiculoOvm.class);
		sqlquery.setParameter(1, bean.getDesgNombre());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateVehiculoOVM(Tbasg170VehiculoOvm bean) {

		String sqlString = "UPDATE PASG.TBASG170_VEHICULO_OVM SET DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_VEHICULO=:cdgoVehiculo";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg170VehiculoOvm.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoVehiculo", bean.getCdgoVehiculo());
		return sqlquery.executeUpdate();
	}
	
	public int estadoVehiculoOVM(Tbasg170VehiculoOvm bean) {

		String sqlString = "UPDATE PASG.TBASG170_VEHICULO_OVM SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_VEHICULO=:cdgoVehiculo";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg170VehiculoOvm.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoVehiculo", bean.getCdgoVehiculo());
		return sqlquery.executeUpdate();
	}

}

