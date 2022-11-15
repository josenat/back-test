package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.dto.Tbasg122InstruDto;
import renfe.com.model.entity.Tbasg122Instru;
import renfe.com.repository.Tbasg122InstruRepositoryCustom;

public class Tbasg122InstruRepositoryImpl implements Tbasg122InstruRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg122InstruDto> getIntruForName(String desgApell1) {

		String sqlString = "SELECT CDGO_NIF FROM PASG.TBASG122_INSTRU WHERE DESG_APELL1 || DESG_APELL2 || DESG_NOMBRE LIKE :value AND MRCA_ACTIVO = 'S' AND MRCA_INSTRUCTOR = 'S'";
		
		Query sqlquery = em.createNativeQuery(sqlString);

		sqlquery.setParameter("value", "%"+ desgApell1 +"%");

		List<String> results = sqlquery.getResultList();
		List<Tbasg122InstruDto> resultList = new ArrayList<>();

		for (String item : results) {
			Tbasg122InstruDto instru = new Tbasg122InstruDto();
			instru.setCdgoNif(item);
			resultList.add(instru);
		}

		return resultList;
	}

	public List<Tbasg122Instru> getInstru(String cdgoNif) {

		String sqlString = "SELECT * FROM PASG.TBASG122_INSTRU WHERE CDGO_NIF = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg122Instru.class);
		sqlquery.setParameter("value", cdgoNif);
		return sqlquery.getResultList();
	}

	public List<Tbasg122Instru> getInstruListRegistroAscendente() {

		String sqlString = "SELECT CDGO_NIF FROM PASG.TBASG122_INSTRU ORDER BY CDGO_NIF";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg122Instru.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg122Instru> getInstruListRegistroDescendente() {

		String sqlString = "SELECT CDGO_NIF FROM PASG.TBASG122_INSTRU ORDER BY CDGO_NIF DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg122Instru.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg122Instru> getInstruListAscendenteDESG_APELL1() {

		String sqlString = "SELECT * FROM PASG.TBASG122_INSTRU ORDER BY DESG_APELL1 ASC, CDGO_NIF ASC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg122Instru.class);

		return sqlquery.getResultList();
	}
	
	public List<Tbasg122Instru> getInstruListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG122_INSTRU ORDER BY CDGO_NIF ASC";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg122Instru> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg122Instru instru = new Tbasg122Instru();
			
			instru.setCdgoNif((String) object[0]);
			instru.setDesgNombre((String) object[1]);
			instru.setDesgApell1((String) object[2]);
			instru.setDesgApell2((String) object[3]);
			instru.setDesgUsuact((String) object[4]);
			instru.setFchaAct((Date) object[5]);
			instru.setMrcaActivo(String.valueOf((java.lang.Character) object[6]));
			instru.setMrcaExaminador(String.valueOf((java.lang.Character) object[7]));
			instru.setMrcaInstructor(String.valueOf((java.lang.Character) object[8]));

			resultadosDevueltos.add(instru);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg122Instru> getInstruListDescendenteDESG_APELL1() {

		String sqlString = "SELECT * FROM PASG.TBASG122_INSTRU ORDER BY DESG_APELL1 DESC, CDGO_NIF DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg122Instru.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg122Instru> getInstruListAscendenteCDGO_NIF() {

		String sqlString = "SELECT * FROM PASG.TBASG122_INSTRU ORDER BY CDGO_NIF ASC, DESG_APELL1 ASC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg122Instru.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg122Instru> getInstruListDescendenteCDGO_NIF() {

		String sqlString = "SELECT * FROM PASG.TBASG122_INSTRU ORDER BY CDGO_NIF DESC, DESG_APELL1 DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg122Instru.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg122Instru> getInstruActiveListAscendenteDESG_APELL1() {

		String sqlString = "SELECT * FROM PASG.TBASG122_INSTRU WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_APELL1 ASC, CDGO_NIF ASC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg122Instru.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg122Instru> getInstruActiveListDescendenteDESG_APELL1() {

		String sqlString = "SELECT * FROM PASG.TBASG122_INSTRU WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_APELL1 DESC, CDGO_NIF DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg122Instru.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg122Instru> getInstruActiveListAscendenteCDGO_NIF() {

		String sqlString = "SELECT * FROM PASG.TBASG122_INSTRU WHERE MRCA_ACTIVO = 'S' ORDER BY CDGO_NIF ASC, DESG_APELL1 ASC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg122Instru.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg122Instru> getInstruActiveListDescendenteCDGO_NIF() {

		String sqlString = "SELECT * FROM PASG.TBASG122_INSTRU WHERE MRCA_ACTIVO = 'S' ORDER BY CDGO_NIF DESC, DESG_APELL1 DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg122Instru.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg122Instru> getInstruCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG122_INSTRU";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg122Instru.class);

		return sqlquery.getResultList();
	}

	/*public List<Tbasg122Instru> getInstruActiveListNombre() {

		String sqlString = "SELECT * FROM PASG.TBASG122_INSTRU WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg122Instru.class);

		return sqlquery.getResultList();
	}*/

	public List<Tbasg122Instru> getInstruActiveListNombre() {

		String sqlString = "SELECT * FROM PASG.TBASG122_INSTRU WHERE MRCA_ACTIVO = 'S' ORDER BY DESG_NOMBRE";
		Query sqlquery = em.createNativeQuery(sqlString);
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg122Instru> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg122Instru instru = new Tbasg122Instru();

			instru.setCdgoNif((String) object[0]);
			instru.setDesgNombre((String) object[1]);
			instru.setDesgApell1((String) object[2]);
			instru.setDesgApell2((String) object[3]);
			instru.setDesgUsuact((String) object[4]);
			instru.setFchaAct((Date) object[5]);
			instru.setMrcaActivo(String.valueOf((java.lang.Character) object[6]));
			instru.setMrcaExaminador(String.valueOf((java.lang.Character) object[7]));
			instru.setMrcaInstructor(String.valueOf((java.lang.Character) object[8]));

			resultadosDevueltos.add(instru);
		}
		return resultadosDevueltos;
	}
	
	public List<Tbasg122Instru> getInstruActiveListApe1Ape2Nom() {

		String sqlString = "SELECT * FROM PASG.TBASG122_INSTRU WHERE MRCA_ACTIVO = 'S' AND MRCA_INSTRUCTOR='S' ORDER BY DESG_APELL1, DESG_APELL2, DESG_NOMBRE;";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg122Instru> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg122Instru instru = new Tbasg122Instru();

			instru.setCdgoNif((String) object[0]);
			instru.setDesgNombre((String) object[1]);
			instru.setDesgApell1((String) object[2]);
			instru.setDesgApell2((String) object[3]);
			instru.setDesgUsuact((String) object[4]);
			instru.setFchaAct((Date) object[5]);
			instru.setMrcaActivo(String.valueOf((java.lang.Character) object[6]));
			instru.setMrcaExaminador(String.valueOf((java.lang.Character) object[7]));
			instru.setMrcaInstructor(String.valueOf((java.lang.Character) object[8]));

			resultadosDevueltos.add(instru);
		}
		return resultadosDevueltos;
	}
	
	public List<Tbasg122Instru> getExamiActiveListApe1Ape2Nom() {

		String sqlString = "SELECT * FROM PASG.TBASG122_INSTRU WHERE MRCA_ACTIVO = 'S' AND MRCA_INSTRUCTOR='S' AND MRCA_EXAMINADOR='S' ORDER BY DESG_APELL1, DESG_APELL2, DESG_NOMBRE;";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg122Instru> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg122Instru instru = new Tbasg122Instru();

			instru.setCdgoNif((String) object[0]);
			instru.setDesgNombre((String) object[1]);
			instru.setDesgApell1((String) object[2]);
			instru.setDesgApell2((String) object[3]);
			instru.setDesgUsuact((String) object[4]);
			instru.setFchaAct((Date) object[5]);
			instru.setMrcaActivo(String.valueOf((java.lang.Character) object[6]));
			instru.setMrcaExaminador(String.valueOf((java.lang.Character) object[7]));
			instru.setMrcaInstructor(String.valueOf((java.lang.Character) object[8]));

			resultadosDevueltos.add(instru);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg122Instru> getInstruActiveListMrcaInstru() {

		String sqlString = "SELECT * FROM PASG.TBASG122_INSTRU WHERE MRCA_ACTIVO = 'S' AND MRCA_INSTRUCTOR='S' AND MRCA_INSTRUCTOR='S' ORDER BY DESG_APELL1, DESG_APELL2, DESG_NOMBRE;";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg122Instru.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg122Instru> getExaminActiveListMrcaExamin() {

		String sqlString = "SELECT * FROM PASG.TBASG122_INSTRU WHERE MRCA_ACTIVO = 'S' AND MRCA_EXAMINADOR='S' ORDER BY DESG_APELL1, DESG_APELL2, DESG_NOMBRE;";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg122Instru.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg122Instru> existeInstruDNI(String cdgoNif) {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG122_INSTRU WHERE CDGO_NIF = :cdgoNif";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg122Instru.class);
		sqlquery.setParameter("cdgoNif", cdgoNif);
		return sqlquery.getResultList();
	}

	public int insertInstru(Tbasg122Instru bean) {

		String sqlString = "INSERT INTO PASG.TBASG122_INSTRU (CDGO_NIF, DESG_NOMBRE, DESG_APELL1, DESG_APELL2, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO, MRCA_EXAMINADOR, MRCA_INSTRUCTOR) VALUES (?,?,?,?,?,CURRENT_DATE,?,?,?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg122Instru.class);
		sqlquery.setParameter(1, bean.getCdgoNif());
		sqlquery.setParameter(2, bean.getDesgNombre());
		sqlquery.setParameter(3, bean.getDesgApell1());
		sqlquery.setParameter(4, bean.getDesgApell2());
		sqlquery.setParameter(5, bean.getDesgUsuact());
		sqlquery.setParameter(6, bean.getMrcaActivo());
		sqlquery.setParameter(7, bean.getMrcaExaminador());
		sqlquery.setParameter(8, bean.getMrcaInstructor());
		return sqlquery.executeUpdate();
	}

	public int estadoInstru(Tbasg122Instru bean) {

		String sqlString = "UPDATE PASG.TBASG122_INSTRU SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_NIF=:cdgoNif";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg122Instru.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoNif", bean.getCdgoNif());
		return sqlquery.executeUpdate();
	}
	
	public int updateInstru(Tbasg122Instru bean) {

		String sqlString = "UPDATE PASG.TBASG122_INSTRU SET DESG_NOMBRE=:nombre, DESG_APELL1=:apell1, DESG_APELL2=:apell2, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE, MRCA_EXAMINADOR=:examinador WHERE CDGO_NIF=:cdgoNif";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg122Instru.class);
		sqlquery.setParameter("nombre", bean.getDesgNombre());
		sqlquery.setParameter("apell1", bean.getDesgApell1());
		sqlquery.setParameter("apell2", bean.getDesgApell2());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("examinador", bean.getMrcaExaminador());
		sqlquery.setParameter("cdgoNif", bean.getCdgoNif());
		return sqlquery.executeUpdate();
	}

	public int unDeleteInstru(Tbasg122Instru bean) {

		String sqlString = "UPDATE PASG.TBASG122_INSTRU SET " + "			MRCA_ACTIVO = 'S', "
				+ "			DESG_USUACT = :usuAct, " + "			FCHA_ACT = CURRENT_DATE "
				+ "		WHERE CDGO_NIF = :cdgoNif";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg122Instru.class);
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoNif", bean.getCdgoNif());
		return sqlquery.executeUpdate();
	}

	public List<Tbasg122InstruDto> getTrainerExaminerStatus(String cdgoNif) {

		String sqlString = "SELECT MRCA_INSTRUCTOR, MRCA_EXAMINADOR FROM PASG.TBASG122_INSTRU WHERE CDGO_NIF = :cdgoNif";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("cdgoNif", cdgoNif);	

		List<Object[]> results = sqlquery.getResultList();
		List<Tbasg122InstruDto> resultList = new ArrayList<>();
  
		for (Object[] item : results) {
		  Tbasg122InstruDto row = new Tbasg122InstruDto();
		  row.setMrcaInstructor(String.valueOf((Character) item[0]));
		  row.setMrcaExaminador(String.valueOf((Character) item[1]));		  
		  resultList.add(row);
		}
  
		return resultList;		
	}	

}
