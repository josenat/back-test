package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg135Cargo;
import renfe.com.repository.Tbasg135CargoRepositoryCustom;

public class Tbasg135CargoRepositoryImpl implements Tbasg135CargoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg135Cargo> getCargoAltasCargo() {

		String sqlString = "SELECT * FROM PASG.TBASG135_CARGO WHERE CDGO_CARGO IN ('K00', 'K10', 'K20', 'K30', 'K40','K9B')";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg135Cargo.class);
		return sqlquery.getResultList();
	}
	
	public List<Tbasg135Cargo> getCargo(String cdgoCargo) {

		String sqlString = "SELECT * FROM PASG.TBASG135_CARGO WHERE CDGO_CARGO = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg135Cargo.class);
		sqlquery.setParameter("value", cdgoCargo);
		return sqlquery.getResultList();
	}

	public List<Tbasg135Cargo> getCargoListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG135_CARGO ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg135Cargo> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg135Cargo cargo = new Tbasg135Cargo();
			
			cargo.setCdgoCargo((String)object[0]);
			cargo.setDesgNombre((String)object[1]);
			cargo.setDesgUsuact((String)object[2]);
			cargo.setFchaAct((Date) object[3]);
			cargo.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));

			resultadosDevueltos.add(cargo);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg135Cargo> getCargoListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG135_CARGO ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg135Cargo.class);

		return sqlquery.getResultList();
	}

	/*public List<Tbasg135Cargo> getCargoActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG135_CARGO WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg135Cargo.class);

		return sqlquery.getResultList();
	}*/
	
	public List<Tbasg135Cargo> getCargoActiveListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG135_CARGO WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg135Cargo> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg135Cargo cargo = new Tbasg135Cargo();

			cargo.setCdgoCargo((String)object[0]);
			cargo.setDesgNombre((String)object[1]);
			cargo.setDesgUsuact((String)object[2]);
			cargo.setFchaAct((Date) object[3]);
			cargo.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));

			resultadosDevueltos.add(cargo);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg135Cargo> getCargoActiveListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG135_CARGO WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg135Cargo.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg135Cargo> getCargoCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG135_CARGO";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg135Cargo.class);

		return sqlquery.getResultList();
	}

	public int insertCargo(Tbasg135Cargo bean) {

		String sqlString = "INSERT INTO PASG.TBASG135_CARGO (CDGO_CARGO, DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO) VALUES (?,?,?,CURRENT_DATE,?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg135Cargo.class);
		sqlquery.setParameter(1, bean.getCdgoCargo());
		sqlquery.setParameter(2, bean.getDesgNombre());
		sqlquery.setParameter(3, bean.getDesgUsuact());
		sqlquery.setParameter(4, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateCargo(Tbasg135Cargo bean) {

		String sqlString = "UPDATE PASG.TBASG135_CARGO SET DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_CARGO=:cdgoCargo";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg135Cargo.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoCargo", bean.getCdgoCargo());
		return sqlquery.executeUpdate();
	}
	
	public int estadoCargo(Tbasg135Cargo bean) {

		String sqlString = "UPDATE PASG.TBASG135_CARGO SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_CARGO=:cdgoCargo";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg135Cargo.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoCargo", bean.getCdgoCargo());
		return sqlquery.executeUpdate();
	}

}
