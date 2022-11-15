package renfe.com.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg230DestinatariosEmail;
import renfe.com.repository.Tbasg230DestinatariosEmailRepositoryCustom;

public class Tbasg230DestinatariosEmailRepositoryImpl implements Tbasg230DestinatariosEmailRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg230DestinatariosEmail> getDestinatariosEmailCount() {

		String sqlString = "SELECT COUNT(1) as value FROM PASG.TBASG230_DESTINATARIOS_EMAIL";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg230DestinatariosEmail.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg230DestinatariosEmail> getDestinatarioDireccionCount(String desgDireccionEmail) {

		String sqlString = "SELECT COUNT(1) as value FROM PASG.TBASG230_DESTINATARIOS_EMAIL WHERE DESG_DIRECCION_EMAIL =:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg230DestinatariosEmail.class);
		sqlquery.setParameter("value", desgDireccionEmail);
		return sqlquery.getResultList();
	}

	public List<Tbasg230DestinatariosEmail> getDestinatariosEmailListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG230_DESTINATARIOS_EMAIL ORDER BY DESG_DIRECCION_EMAIL";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg230DestinatariosEmail> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg230DestinatariosEmail destinataemail = new Tbasg230DestinatariosEmail();
			
			destinataemail.setDesgDireccionEmail((String)object[0]);
			destinataemail.setDesgNombre((String)object[1]);
			destinataemail.setDesgNivelDeEnvio(String.valueOf((java.lang.Character) object[2]));
			destinataemail.setCdgoAreaActividad((Integer) object[3]);
			destinataemail.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));

			resultadosDevueltos.add(destinataemail);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg230DestinatariosEmail> getDestinatariosEmailListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG230_DESTINATARIOS_EMAIL ORDER BY DESG_DIRECCION_EMAIL DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg230DestinatariosEmail.class);

		return sqlquery.getResultList();
	}

	/*public List<Tbasg230DestinatariosEmail> getDestinatariosEmailListActiveAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG230_DESTINATARIOS_EMAIL WHERE MRCA_ACTIVO='S' ORDER BY DESG_DIRECCION_EMAIL";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg230DestinatariosEmail.class);

		return sqlquery.getResultList();
	}*/
	
	public List<Tbasg230DestinatariosEmail> getDestinatariosEmailListActiveAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG230_DESTINATARIOS_EMAIL WHERE MRCA_ACTIVO='S' ORDER BY DESG_DIRECCION_EMAIL";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg230DestinatariosEmail> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg230DestinatariosEmail destinataemail = new Tbasg230DestinatariosEmail();

			destinataemail.setDesgDireccionEmail((String)object[0]);
			destinataemail.setDesgNombre((String)object[1]);
			destinataemail.setDesgNivelDeEnvio(String.valueOf((java.lang.Character) object[2]));
			destinataemail.setCdgoAreaActividad((Integer) object[3]);
			destinataemail.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));

			resultadosDevueltos.add(destinataemail);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg230DestinatariosEmail> getDestinatariosEmailListActiveDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG230_DESTINATARIOS_EMAIL WHERE MRCA_ACTIVO='S' ORDER BY DESG_DIRECCION_EMAIL DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg230DestinatariosEmail.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg230DestinatariosEmail> getDestinatariosEmail(String desgDireccionEmail) {

		String sqlString = "SELECT * FROM PASG.TBASG230_DESTINATARIOS_EMAIL WHERE DESG_DIRECCION_EMAIL=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg230DestinatariosEmail.class);
		sqlquery.setParameter("value", desgDireccionEmail);
		return sqlquery.getResultList();
	}

	public int insertDestinatariosEmail(Tbasg230DestinatariosEmail bean) {

		String sqlString = "INSERT INTO PASG.TBASG230_DESTINATARIOS_EMAIL (DESG_DIRECCION_EMAIL, DESG_NOMBRE, DESG_NIVEL_DE_ENVIO, CDGO_AREA_ACTIVIDAD, MRCA_ACTIVO) VALUES (?,?,?,?,?);";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg230DestinatariosEmail.class);
		sqlquery.setParameter(1, bean.getDesgDireccionEmail());
		sqlquery.setParameter(2, bean.getDesgNombre());
		sqlquery.setParameter(3, bean.getDesgNivelDeEnvio());
		sqlquery.setParameter(4, bean.getCdgoAreaActividad());
		sqlquery.setParameter(5, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateDestinatarioEmail(Tbasg230DestinatariosEmail bean) {

		String sqlString = "UPDATE PASG.TBASG230_DESTINATARIOS_EMAIL SET DESG_NOMBRE=:nombre, DESG_NIVEL_DE_ENVIO=:nivelEnvio, CDGO_AREA_ACTIVIDAD=:areaAct WHERE DESG_DIRECCION_EMAIL=:direccEmail";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg230DestinatariosEmail.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("nivelEnvio", bean.getDesgNivelDeEnvio());
		sqlquery.setParameter("areaAct", bean.getCdgoAreaActividad());
		sqlquery.setParameter("direccEmail", bean.getDesgDireccionEmail());
		return sqlquery.executeUpdate();
	}
	
	public int estadoDestinatarioEmail(Tbasg230DestinatariosEmail bean) {

		String sqlString = "UPDATE PASG.TBASG230_DESTINATARIOS_EMAIL SET MRCA_ACTIVO=:mrcaActivo WHERE DESG_DIRECCION_EMAIL=:direccEmail";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg230DestinatariosEmail.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("direccEmail", bean.getDesgDireccionEmail());
		return sqlquery.executeUpdate();
	}

	public int updateDestinatarioEmailAreaNull(Tbasg230DestinatariosEmail bean) {

		String sqlString = "UPDATE PASG.TBASG230_DESTINATARIOS_EMAIL SET DESG_DIRECCION_EMAIL=:direccEmail, DESG_NOMBRE=:nombre, DESG_NIVEL_DE_ENVIO=:nivelEnvio, CDGO_AREA_ACTIVIDAD=null WHERE DESG_DIRECCION_EMAIL=:direccEmail";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg230DestinatariosEmail.class);
		sqlquery.setParameter("direccEmail", bean.getDesgDireccionEmail());
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("nivelEnvio", bean.getDesgNivelDeEnvio());
		sqlquery.setParameter("direccEmail", bean.getDesgDireccionEmail());
		return sqlquery.executeUpdate();
	}

}
