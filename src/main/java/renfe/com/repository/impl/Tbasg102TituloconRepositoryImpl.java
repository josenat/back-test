package renfe.com.repository.impl;

import java.sql.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.dto.Tbasg102TituloconDto;
import renfe.com.dto.GetFindTituloConByCdgoPersonaActivo;
import renfe.com.dto.GetMaxEstadoHabilitaListDTO;
import renfe.com.dto.GetMaxEstadoTitCondBySociedadesListDTO;
import renfe.com.dto.GetMaxEstadoTitCondListAllDTO;
import renfe.com.dto.GetTituloConPersonaUltimoDTO;
import renfe.com.dto.SetMaxEstadoTitCondBySociedadesList;
import renfe.com.dto.SetMaxEstadoTitCondListAll;

import renfe.com.model.entity.Tbasg102Titulocon;
import renfe.com.model.entity.Tbasg117Estadotit;
import renfe.com.repository.Tbasg102TituloconRepositoryCustom;
import renfe.com.util.Util;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;

public class Tbasg102TituloconRepositoryImpl implements Tbasg102TituloconRepositoryCustom {

	@Autowired
	protected Logger logger;

	@PersistenceContext
	private EntityManager em;

	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");	

	public List<Tbasg102Titulocon> checkReciclajeTituloCond(String cdgoPersona) {

		String sqlString = "SELECT F.*" + "		FROM PASG.TBASG102_TITULOCON T"
				+ "			INNER JOIN PASG.TBASG197_FORMACION F ON T.CDGO_TIT = F.CDGO_TIT"
				+ "		WHERE T.CDGO_PERSONA = :value" + "			AND F.CDGO_ESTADO IN (1, 19)"
				+ "			AND F.DESG_TIPOEXP = 'R'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg102Titulocon.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}

	public List<GetMaxEstadoTitCondListAllDTO> getMaxEstadoTitCondListAll(SetMaxEstadoTitCondListAll mapPending) {
		
		StringBuilder strGetMaxEstadoTitCondListAll = new StringBuilder();

		String sqlString = "SELECT CASE WHEN MAX(G.FCHA_CURSO) > '2015-04-20'"
				+ " THEN MAX(G.FCHA_CURSO) + 2 YEARS ELSE MAX(G.FCHA_CURSO) + 3 YEARS END AS FCHA_CURSOINC,"
				
				+ " A.FCHA_OTORGADO, A.CDGO_TIT  AS CODIGO, A.DESG_TIPTIT AS DESG_TITULO, B.DESG_NOMBRE AS DESG_PERSONA,"
				+ "	B.CDGO_PERSONA, B.DESG_APELL1, B.DESG_APELL2, B.DESG_MATRICULA, B.DESG_NIFPAS, C.DESG_NOMBRE AS ESTADO,"
				+ " (A.FCHA_OTORGADO  + 3 YEARS) AS FCHA_OTORGADOINC, B.CDGO_AREACT, B.CDGO_ARETER, B.CDGO_CENTCONT,"
				+ "	AA.DESG_NOMBRE AS DESG_AREACT, AR.DESG_NOMBRE AS DESG_ARETER, CC.DESG_NOMBRE AS DESG_CENTCONT"
				+ "	FROM PASG.TBASG102_TITULOCON A"
				
				+ " LEFT OUTER JOIN PASG.TBASG121_ACTAFORMA E ON (E.CDGO_TIT = A.CDGO_TIT)"
				+ " LEFT OUTER JOIN PASG.TBASG146_ACTAINCAL G ON (G.CDGO_ACTAFORM = E.CDGO_ACTAFORM)"
				+ " INNER JOIN PASG.TBASG100_PERSONA B ON (B.CDGO_PERSONA = A.CDGO_PERSONA)"
				+ " INNER JOIN PASG.TBASG117_ESTADOTIT D ON (D.CDGO_TIT = A.CDGO_TIT)"
				+ " INNER JOIN PASG.TBASG116_ESTADOS C ON (C.CDGO_ESTADO = D.CDGO_ESTADO)"
				+ " INNER JOIN PASG.TBASG105_AREACTIVI R ON (R.CDGO_AREACT = B.CDGO_AREACT)"
				+ "	LEFT JOIN PASG.TBASG105_AREACTIVI AA ON (B.CDGO_AREACT = AA.CDGO_AREACT)"
				+ "	LEFT JOIN PASG.TBASG141_ARETER AR ON (B.CDGO_ARETER = AR.CDGO_ARETER)"
				+ "	LEFT JOIN PASG.TBASG132_CENTCONT CC ON (B.CDGO_CENTCONT = CC.CDGO_CENTCONT)"
				+ " INNER JOIN PASG.TBASG104_EXPEDIENT EXP ON EXP.CDGO_PERSONA = B.CDGO_PERSONA"
				+ " INNER JOIN PASG.TBASG261_SOCIEDADES SOC ON SOC.CDGO_SOCIEDAD = EXP.CDGO_SOCIOTOR"

				+ " WHERE D.FCHA_ESTADO IN (SELECT MAX(FCHA_ESTADO) FROM PASG.TBASG117_ESTADOTIT WHERE CDGO_TIT = D.CDGO_TIT AND MRCA_ACTIVO ='S') "
				+ " AND D.CDGO_ESTADO <> 3 AND (A.MRCA_ACTIVO = 'S' "
				+ " OR (  A.CDGO_TIT IN (SELECT CDGO_TIT FROM PASG.TBASG102_TITULOCON WHERE MRCA_ACTIVO = 'N' GROUP BY CDGO_TIT HAVING COUNT (CDGO_TIT) = 1))) "
				+ " AND B.MRCA_ACTIVO = 'S'AND C.MRCA_ACTIVO = 'S' AND D.MRCA_ACTIVO = 'S' AND R.MRCA_ACTIVO = 'S' AND G.MRCA_ACTIVO = 'S'";
		
		strGetMaxEstadoTitCondListAll.append(sqlString);
		System.out.println("----------------------");
		System.out.println(strGetMaxEstadoTitCondListAll.toString());
		System.out.println("----------------------");
		
		if(mapPending!=null) {
			if(mapPending.getCdgoAreAct() !=null) {
				
				strGetMaxEstadoTitCondListAll.append(" AND B.CDGO_AREACT IN (" + mapPending.getCdgoAreAct().get(0));
				
				for(int i = 1; i < mapPending.getCdgoAreAct().size(); i++) {
					strGetMaxEstadoTitCondListAll.append(" ," + mapPending.getCdgoAreAct().get(i));
				}
				
				strGetMaxEstadoTitCondListAll.append(" )");
			}
			
			if(mapPending.getCdgoAreTerr() !=null) {
				
				strGetMaxEstadoTitCondListAll.append(" AND B.CDGO_ARETER = " + mapPending.getCdgoAreTerr());
			}
			
			if(mapPending.getCdgoCentroCont() !=null) {
				strGetMaxEstadoTitCondListAll.append(" AND B.CDGO_CENTCONT LIKE '%" + mapPending.getCdgoCentroCont() + "%'");
			}
			
			if(mapPending.getListAreAct() != null) {
				strGetMaxEstadoTitCondListAll.append(" AND (B.CDGO_AREACT IN (" + mapPending.getListAreAct().get(0));
				
				for(int i = 1; i < mapPending.getListAreAct().size(); i++) {
					strGetMaxEstadoTitCondListAll.append(" ," + mapPending.getListAreAct().get(i));
				}
				
				strGetMaxEstadoTitCondListAll.append(" ) OR B.CDGO_AREACT IS NULL)");
			}
			
			if(mapPending.getDni() != null) {
				strGetMaxEstadoTitCondListAll.append(" AND DESG_NIFPAS LIKE '%" + mapPending.getDni() + "%'");
			}
			if(mapPending.getMatricula() != null) {
				strGetMaxEstadoTitCondListAll.append(" AND B.DESG_MATRICULA LIKE '%" + mapPending.getMatricula() + "%'");
			}
			if(mapPending.getNombre() != null) {
				strGetMaxEstadoTitCondListAll.append(" AND B.DESG_NOMBRE LIKE '%" + mapPending.getNombre() + "%'");
			}
			if(mapPending.getApell1() != null) {
				strGetMaxEstadoTitCondListAll.append(" AND B.DESG_APELL1 LIKE '%" + mapPending.getApell1() + "%'");
			}
			if(mapPending.getApell2() != null) {
				strGetMaxEstadoTitCondListAll.append(" AND B.DESG_APELL2 LIKE '%" + mapPending.getApell2() + "%'");
			}
			if(mapPending.getSociedad() != null) {
				strGetMaxEstadoTitCondListAll.append(" AND SOC.CDGO_SOCIEDAD =" + mapPending.getSociedad());
			}
			if(mapPending.getEstadoTitulos() != null) {
				strGetMaxEstadoTitCondListAll.append(" AND D.CDGO_ESTADO IN (" + mapPending.getEstadoTitulos().get(0));
				
				for(int i = 1; i < mapPending.getEstadoTitulos().size(); i++) {
					strGetMaxEstadoTitCondListAll.append(" ," + mapPending.getEstadoTitulos().get(i));
				}
				
				strGetMaxEstadoTitCondListAll.append(" )");
			}else {
				strGetMaxEstadoTitCondListAll.append(" AND D.CDGO_ESTADO IN (6, 3, 5, 7)");
			}
			if(mapPending.isNoAptos() != false) {
				strGetMaxEstadoTitCondListAll.append(" AND NOT EXISTS (SELECT 1 FROM PASG.TBASG101_CERTPSIC WHERE CDGO_PERSONA = B.CDGO_PERSONA AND MRCA_ACTIVO = 'S' AND CDGO_CALIFI = 3)");
			}
			if(mapPending.getPersonal() != null) {
				if(mapPending.getPersonal().equals("RENFE")) {
					strGetMaxEstadoTitCondListAll.append(" AND B.DESG_MATRICULA != '' AND B.DESG_MATRICULA IS NOT NULL");
				}
				if(mapPending.getPersonal().equals("EXT")) {
					strGetMaxEstadoTitCondListAll.append(" AND (B.DESG_MATRICULA = '' OR B.DESG_MATRICULA IS NULL)");
				}
			}
			
		}
		
		System.out.println("----------------------");
		System.out.println(strGetMaxEstadoTitCondListAll.toString());
		System.out.println("----------------------");
				
		strGetMaxEstadoTitCondListAll.append(" GROUP BY A.FCHA_OTORGADO, A.CDGO_TIT, A.DESG_TIPTIT, B.DESG_NOMBRE, B.CDGO_PERSONA, B.DESG_APELL1,"
						+ "	B.DESG_APELL2, B.DESG_MATRICULA, B.DESG_NIFPAS, C.DESG_NOMBRE, (A.FCHA_OTORGADO  + 3 YEARS),"
						+ " B.CDGO_AREACT, B.CDGO_ARETER, B.CDGO_CENTCONT, AA.DESG_NOMBRE, AR.DESG_NOMBRE, CC.DESG_NOMBRE");
		
		System.out.println("----------------------");
		System.out.println(strGetMaxEstadoTitCondListAll.toString());
		System.out.println("----------------------");
				
		Query sqlquery = em.createNativeQuery(strGetMaxEstadoTitCondListAll.toString()); 
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetMaxEstadoTitCondListAllDTO> resultadosDevueltos = new ArrayList<>();
		
		for(Object[] object : resultados) {
			GetMaxEstadoTitCondListAllDTO data = new GetMaxEstadoTitCondListAllDTO();
			if(object[0]!=null) {
				data.setFchaCursoInc((Date)object[0]);
			}
			if(object[1]!=null) {
				data.setFchaOtorgado((Date)object[1]);
			}
			if(object[2]!=null) {
				data.setCodigo((Integer)object[2]);
			}
			if(object[3]!=null) {
				data.setDesgTitulo(Util.quitarEspacios(object[3]));
			}
			if(object[4]!=null) {
				data.setDesgPersona(Util.quitarEspacios(object[4]));
			}
			if(object[5]!=null) {
				data.setCdgoPersona((Integer)object[5]);
			}
			if(object[6]!=null) {
				data.setDesgApell1(Util.quitarEspacios(object[6]));
			}
			if(object[7]!=null) {
				data.setDesgApell2(Util.quitarEspacios(object[7]));
			}
			if(object[8]!=null) {
				data.setDesgMatricula(Util.quitarEspacios(object[8]));
			}
			if(object[9]!=null) {
				data.setDesgNifpas(Util.quitarEspacios(object[9]));
			}
			if(object[10]!=null) {
				data.setEstadoTitulos(Util.quitarEspacios(object[10]));
			}
			if(object[11]!=null) {
				data.setFchaOtorgado((Date)object[11]);
			}
			if(object[12]!=null) {
				data.setCdgoAreAct((Integer)object[12]);
			}
			if(object[13]!=null) {
				data.setCdgoAreTerr((Integer)object[13]);
			}
			if(object[14]!=null) {
				data.setCdgoCentroCont(Util.quitarEspacios(object[14]));
			}
			if(object[15]!=null) {
				data.setDesgAreAct(Util.quitarEspacios(object[15]));
			}
			if(object[16]!=null) {
				data.setDesgAreTerr(Util.quitarEspacios(object[16]));
			}
			if(object[17]!=null) {
				data.setDesgCentroCont(Util.quitarEspacios(object[17]));
			}

			resultadosDevueltos.add(data);
			
		}

		return resultadosDevueltos;
	}
	
	public List<GetMaxEstadoTitCondBySociedadesListDTO> getMaxEstadoTitCondBySociedadesList(SetMaxEstadoTitCondBySociedadesList mapPending) {
		
		StringBuilder strGetMaxEstadoTitCondBySociedadesList = new StringBuilder();

		String sqlString = "SELECT CASE WHEN MAX(G.FCHA_CURSO) > '2015-04-20'"
				+ " THEN MAX(G.FCHA_CURSO) + 2 YEARS ELSE MAX(G.FCHA_CURSO) + 3 YEARS END AS FCHA_CURSOINC,"
				+ "	A.FCHA_OTORGADO, A.CDGO_TIT  AS CODIGO, A.DESG_TIPTIT AS DESG_TITULO, B.DESG_NOMBRE AS DESG_PERSONA,"
				+ "	B.CDGO_PERSONA, B.DESG_APELL1, B.DESG_APELL2, B.DESG_MATRICULA, B.DESG_NIFPAS,"
				+ "	C.DESG_NOMBRE AS ESTADO, (A.FCHA_OTORGADO  + 3 YEARS) AS FCHA_OTORGADOINC, B.CDGO_AREACT,"
				+ " B.CDGO_ARETER, B.CDGO_CENTCONT, AA.DESG_NOMBRE AS DESG_AREACT, AR.DESG_NOMBRE AS DESG_ARETER, CC.DESG_NOMBRE AS DESG_CENTCONT"
				+ "	FROM PASG.TBASG102_TITULOCON A"
				
				+ " LEFT OUTER JOIN PASG.TBASG121_ACTAFORMA E ON (E.CDGO_TIT = A.CDGO_TIT)"
				+ " LEFT OUTER JOIN PASG.TBASG146_ACTAINCAL G ON (G.CDGO_ACTAFORM = E.CDGO_ACTAFORM)"
				+ " INNER JOIN PASG.TBASG100_PERSONA B ON (B.CDGO_PERSONA = A.CDGO_PERSONA)"
				+ " INNER JOIN PASG.TBASG117_ESTADOTIT D ON (D.CDGO_TIT = A.CDGO_TIT)"
				+ " INNER JOIN PASG.TBASG116_ESTADOS C ON (C.CDGO_ESTADO = D.CDGO_ESTADO)"
				+ " INNER JOIN PASG.TBASG105_AREACTIVI R ON (R.CDGO_AREACT = B.CDGO_AREACT)"
				+ "	LEFT JOIN PASG.TBASG105_AREACTIVI AA ON (B.CDGO_AREACT = AA.CDGO_AREACT)"
				+ "	LEFT JOIN PASG.TBASG141_ARETER AR ON (B.CDGO_ARETER = AR.CDGO_ARETER)"
				+ "	LEFT JOIN PASG.TBASG132_CENTCONT CC ON (B.CDGO_CENTCONT = CC.CDGO_CENTCONT)"
				+ "	INNER JOIN PASG.TBASG104_EXPEDIENT EXP ON EXP.CDGO_PERSONA = B.CDGO_PERSONA"
				+ " INNER JOIN PASG.TBASG261_SOCIEDADES SOC ON SOC.CDGO_SOCIEDAD = EXP.CDGO_SOCIOTOR"
				
				+ " WHERE D.FCHA_ESTADO IN (SELECT MAX(FCHA_ESTADO) FROM PASG.TBASG117_ESTADOTIT WHERE CDGO_TIT = D.CDGO_TIT AND MRCA_ACTIVO ='S')"
				+ " AND D.CDGO_ESTADO <> 3 AND (A.MRCA_ACTIVO = 'S' OR ( A.CDGO_TIT IN (SELECT CDGO_TIT FROM PASG.TBASG102_TITULOCON WHERE MRCA_ACTIVO = 'N' GROUP BY CDGO_TIT HAVING COUNT (CDGO_TIT) = 1))) "
				+ " AND B.MRCA_ACTIVO = 'S' AND C.MRCA_ACTIVO = 'S' AND D.MRCA_ACTIVO = 'S' AND R.MRCA_ACTIVO = 'S'"
				+ " AND G.MRCA_ACTIVO = 'S'";
		
		strGetMaxEstadoTitCondBySociedadesList.append(sqlString);
		System.out.println("----------------------");
		System.out.println(strGetMaxEstadoTitCondBySociedadesList.toString());
		System.out.println("----------------------");
		
		if(mapPending != null) {
			if(mapPending.getCdgoAreAct() !=null) {
				
				strGetMaxEstadoTitCondBySociedadesList.append(" AND B.CDGO_AREACT IN (" + mapPending.getCdgoAreAct().get(0));
				
				for(int i = 1; i < mapPending.getCdgoAreAct().size(); i++) {
					strGetMaxEstadoTitCondBySociedadesList.append(" ," + mapPending.getCdgoAreAct().get(i));
				}
				
				strGetMaxEstadoTitCondBySociedadesList.append(" )");
			}
			
			if(mapPending.getCdgoAreTerr() !=null) {
				
				strGetMaxEstadoTitCondBySociedadesList.append(" AND B.CDGO_ARETER IN (" + mapPending.getCdgoAreTerr().get(0));

				for(int i = 1; i < mapPending.getCdgoAreTerr().size(); i++) {
					strGetMaxEstadoTitCondBySociedadesList.append(" ," + mapPending.getCdgoAreTerr().get(i));
				}
				
				strGetMaxEstadoTitCondBySociedadesList.append(" )");
				
			}
			
			if(mapPending.getCdgoCentroCont() !=null) {
				strGetMaxEstadoTitCondBySociedadesList.append(" AND B.CDGO_CENTCONT LIKE '%" + mapPending.getCdgoCentroCont() + "%'");
			}
			////////////////////////////////////////////
			if(mapPending.getListAreTer() != null) {
				strGetMaxEstadoTitCondBySociedadesList.append(" AND (B.CDGO_ARETER IN (" + mapPending.getListAreTer().get(0));
				
				for(int i = 1; i < mapPending.getListAreTer().size(); i++) {
					strGetMaxEstadoTitCondBySociedadesList.append(" ," + mapPending.getListAreTer().get(i));
				}
				
				strGetMaxEstadoTitCondBySociedadesList.append(" ) OR B.CDGO_ARETER IS NULL)");
			}
			///////////////////////////////////////
			if(mapPending.getListAreAct() != null) {
				strGetMaxEstadoTitCondBySociedadesList.append(" AND EXP.CDGO_SOCIOTOR IN(SELECT DISTINCT SOC.CDGO_SOCIEDAD FROM PASG.TBASG105_AREACTIVI ACT"
						+ "	INNER JOIN PASG.TBASG261_SOCIEDADES SOC ON ACT.CDGO_SOCIEDAD=SOC.CDGO_SOCIEDAD"
						+ "	WHERE ACT.CDGO_AREACT IN (" + mapPending.getListAreAct().get(0));
				
				for(int i = 1; i < mapPending.getListAreAct().size(); i++) {
					strGetMaxEstadoTitCondBySociedadesList.append(" ," + mapPending.getListAreAct().get(i));
				}
				
				strGetMaxEstadoTitCondBySociedadesList.append(") AND ACT.MRCA_ACTIVO = 'S')");
			}
			/////////////////////////////////////
			if(mapPending.getDni() != null) {
				strGetMaxEstadoTitCondBySociedadesList.append(" AND DESG_NIFPAS LIKE '%" + mapPending.getDni() + "%'");
			}
			if(mapPending.getMatricula() != null) {
				strGetMaxEstadoTitCondBySociedadesList.append(" AND B.DESG_MATRICULA LIKE '%" + mapPending.getMatricula() + "%'");
			}
			if(mapPending.getNombre() != null) {
				strGetMaxEstadoTitCondBySociedadesList.append(" AND B.DESG_NOMBRE LIKE '%" + mapPending.getNombre() + "%'");
			}
			if(mapPending.getApell1() != null) {
				strGetMaxEstadoTitCondBySociedadesList.append(" AND B.DESG_APELL1 LIKE '%" + mapPending.getApell1() + "%'");
			}
			if(mapPending.getApell2() != null) {
				strGetMaxEstadoTitCondBySociedadesList.append(" AND B.DESG_APELL2 LIKE '%" + mapPending.getApell2() + "%'");
			}
			if(mapPending.getEstadoTitulos() != null) {
				strGetMaxEstadoTitCondBySociedadesList.append(" AND D.CDGO_ESTADO IN (" + mapPending.getEstadoTitulos().get(0));
				
				for(int i = 1; i < mapPending.getEstadoTitulos().size(); i++) {
					strGetMaxEstadoTitCondBySociedadesList.append(" ," + mapPending.getEstadoTitulos().get(i));
				}
				
				strGetMaxEstadoTitCondBySociedadesList.append(" )");
			}else {
				strGetMaxEstadoTitCondBySociedadesList.append(" AND D.CDGO_ESTADO IN (6, 3, 5, 7)");
			}
			if(mapPending.isNoAptos() != false) {
				strGetMaxEstadoTitCondBySociedadesList.append(" AND NOT EXISTS (SELECT 1 FROM PASG.TBASG101_CERTPSIC WHERE CDGO_PERSONA = B.CDGO_PERSONA AND MRCA_ACTIVO = 'S' AND CDGO_CALIFI = 3)");
			}
			if(mapPending.getPersonal() != null) {
				if(mapPending.getPersonal().equals("RENFE")) {
					strGetMaxEstadoTitCondBySociedadesList.append(" AND B.DESG_MATRICULA != '' AND B.DESG_MATRICULA IS NOT NULL");
				}
				if(mapPending.getPersonal().equals("EXT")) {
					strGetMaxEstadoTitCondBySociedadesList.append(" AND (B.DESG_MATRICULA = '' OR B.DESG_MATRICULA IS NULL)");
				}
			}
			
		}

		System.out.println("----------------------");
		System.out.println(strGetMaxEstadoTitCondBySociedadesList.toString());
		System.out.println("----------------------");
		
		strGetMaxEstadoTitCondBySociedadesList.append(" GROUP BY A.FCHA_OTORGADO, A.CDGO_TIT, A.DESG_TIPTIT, B.DESG_NOMBRE, B.CDGO_PERSONA, B.DESG_APELL1,"
				+ "	B.DESG_APELL2, B.DESG_MATRICULA, B.DESG_NIFPAS, C.DESG_NOMBRE, (A.FCHA_OTORGADO  + 3 YEARS),"
				+ " B.CDGO_AREACT, B.CDGO_ARETER, B.CDGO_CENTCONT, AA.DESG_NOMBRE, AR.DESG_NOMBRE, CC.DESG_NOMBRE");
		
		System.out.println("----------------------");
		System.out.println(strGetMaxEstadoTitCondBySociedadesList.toString());
		System.out.println("----------------------");
				
		Query sqlquery = em.createNativeQuery(strGetMaxEstadoTitCondBySociedadesList.toString()); 
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<GetMaxEstadoTitCondBySociedadesListDTO> resultadosDevueltos = new ArrayList<>();
		
		for(Object[] object : resultados) {
			GetMaxEstadoTitCondBySociedadesListDTO data = new GetMaxEstadoTitCondBySociedadesListDTO();
			if(object[0]!=null) {
				data.setFchaCursoInc((Date)object[0]);
			}
			if(object[1]!=null) {
				data.setFchaOtorgado((Date)object[1]);
			}
			if(object[2]!=null) {
				data.setCodigo((Integer)object[2]);
			}
			if(object[3]!=null) {
				data.setDesgTitulo(Util.quitarEspacios(object[3]));
			}
			if(object[4]!=null) {
				data.setDesgPersona(Util.quitarEspacios(object[4]));
			}
			if(object[5]!=null) {
				data.setCdgoPersona((Integer)object[5]);
			}
			if(object[6]!=null) {
				data.setDesgApell1(Util.quitarEspacios(object[6]));
			}
			if(object[7]!=null) {
				data.setDesgApell2(Util.quitarEspacios(object[7]));
			}
			if(object[8]!=null) {
				data.setDesgMatricula(Util.quitarEspacios(object[8]));
			}
			if(object[9]!=null) {
				data.setDesgNifpas(Util.quitarEspacios(object[9]));
			}
			if(object[10]!=null) {
				data.setEstadoTitulos(Util.quitarEspacios(object[10]));
			}
			if(object[11]!=null) {
				data.setFchaOtorgado((Date)object[11]);
			}
			if(object[12]!=null) {
				data.setCdgoAreAct((Integer)object[12]);
			}
			if(object[13]!=null) {
				data.setCdgoAreTerr((Integer)object[13]);
			}
			if(object[14]!=null) {
				data.setCdgoCentroCont(Util.quitarEspacios(object[14]));
			}
			if(object[15]!=null) {
				data.setDesgAreAct(Util.quitarEspacios(object[15]));
			}
			if(object[16]!=null) {
				data.setDesgAreTer(Util.quitarEspacios(object[16]));
			}
			if(object[17]!=null) {
				data.setDesgCentCont(Util.quitarEspacios(object[17]));
			}

			resultadosDevueltos.add(data);
			
		}

		return resultadosDevueltos;
	}

	public List<Tbasg102Titulocon> getTituloCon(String cdgoTit) {

		String sqlString = "SELECT * FROM PASG.TBASG102_TITULOCON WHERE CDGO_TIT = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg102Titulocon.class);
		sqlquery.setParameter("value", cdgoTit);
		return sqlquery.getResultList();
	}

	public List<Tbasg102Titulocon> getTituloConActiveByTitulo(String cdgoTit) {

		String sqlString = "SELECT * FROM PASG.TBASG102_TITULOCON WHERE CDGO_TIT = :value AND MRCA_ACTIVO = 'S'";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg102Titulocon.class);
		sqlquery.setParameter("value", cdgoTit);
		return sqlquery.getResultList();
	}

	public List<Tbasg102Titulocon> checkTituloToInsert(String cdgoPersona) {

		String sqlString = "SELECT * FROM PASG.TBASG102_TITULOCON WHERE CDGO_PERSONA = :value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg102Titulocon.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}

	public List<Tbasg102Titulocon> getTituloConPersona(String cdgoPersona) {

		String sqlString = "SELECT * FROM PASG.TBASG102_TITULOCON WHERE CDGO_PERSONA = :value AND MRCA_ACTIVO='S'";

		Query sqlquery = em.createNativeQuery(sqlString);

		sqlquery.setParameter("value", cdgoPersona);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg102Titulocon> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {

			Tbasg102Titulocon titulocon = new Tbasg102Titulocon();

			titulocon.setCdgoTit(Long.valueOf((int)object[0]));
			titulocon.setCdgoPersona((Integer)object[1]);
			titulocon.setFchaOtorgado((Date) object[2]);
			titulocon.setDesgTiptit(Util.quitarEspacios(object[3]));
			titulocon.setDesgUsuact(Util.quitarEspacios(object[4]));
			titulocon.setFchaAct((Date) object[5]);
			titulocon.setMrcaActivo(String.valueOf((Character) object[6]));
			titulocon.setDesgSoloram(Util.quitarEspacios(object[7]));

			titulocon.setFchaTipejerprof((Date) object[8]);	


			resultadosDevueltos.add(titulocon);
		}
		return resultadosDevueltos;
	}
	
	public List<Tbasg102TituloconDto> getTituloConPersonaUltimo(String cdgoPersona) {

		String sqlString = 
				  "  SELECT CDGO_TIT, CDGO_PERSONA, max(FCHA_OTORGADO) FCHA_OTORGADO, DESG_TIPTIT, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO, DESG_SOLORAM, FCHA_TIPEJERPROF "
				+ "  FROM PASG.TBASG102_TITULOCON "
				+ "	 WHERE CDGO_PERSONA = :value AND MRCA_ACTIVO='S' "
				+ "	 GROUP BY CDGO_PERSONA, CDGO_TIT, FCHA_OTORGADO, DESG_TIPTIT, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO, DESG_SOLORAM, FCHA_TIPEJERPROF ";
		
		/*String sqlString = 
				  "  SELECT TC.CDGO_TIT, TC.CDGO_PERSONA, TC.FCHA_OTORGADO, TC.DESG_TIPTIT, TC.DESG_USUACT, TC.FCHA_ACT, TC.MRCA_ACTIVO, TC.DESG_SOLORAM, TC.FCHA_TIPEJERPROF, ET.FCHA_ESTADO "
				+ "  FROM PASG.TBASG102_TITULOCON TC, PASG.TBASG117_ESTADOTIT ET "
				+ "	 WHERE TC.CDGO_TIT = ET.CDGO_TIT AND TC.CDGO_PERSONA = :cdgoPersona AND TC.MRCA_ACTIVO='S' "
				+ "	 ORDER BY TC.FCHA_OTORGADO DESC LIMIT 1 ";*/

		Query sqlquery = em.createNativeQuery(sqlString);

		sqlquery.setParameter("value", cdgoPersona);
		
		List<Tbasg102TituloconDto> resultList = new ArrayList<>();
		List<Object[]> results = sqlquery.getResultList();
		for (Object[] object : results) {
			Tbasg102TituloconDto titulocon = new Tbasg102TituloconDto();			
			titulocon.setCdgoTit((Integer)object[0]);
			titulocon.setCdgoPersona((Integer)object[1]);
			titulocon.setFchaOtorgado((Date) object[2]);
			titulocon.setDesgTiptit(Util.quitarEspacios(object[3]));
			titulocon.setDesgUsuact(Util.quitarEspacios(object[4]));
			titulocon.setFchaAct((Date) object[5]);
			titulocon.setMrcaActivo(String.valueOf((Character) object[6]));
			titulocon.setDesgSoloram(Util.quitarEspacios(object[7]));
			titulocon.setFchaTipejerprof((Date) object[8]);	
			//titulocon.setFchaEstado((String) dateFormat.format(object[9])); 	

			resultList.add(titulocon);
		}

		return resultList;
	}

	public List<GetFindTituloConByCdgoPersonaActivo> findTituloConByCdgoPersonaActivo(Integer cdgoPersona) {

		String sqlString = "SELECT T.CDGO_TIT, T.CDGO_PERSONA, T.FCHA_OTORGADO, E.CDGO_ESTADO " + "		FROM "
				+ "		    PASG.TBASG102_TITULOCON T"
				+ "		    INNER JOIN PASG.TBASG117_ESTADOTIT E ON E.CDGO_TIT = T.CDGO_TIT" + "		WHERE "
				+ "		    T.CDGO_PERSONA = :value " + "		    AND T.MRCA_ACTIVO = 'S'"
				+ "		    AND E.MRCA_ACTIVO = 'S'" + "		    AND E.FCHA_ESTADO = (   SELECT MAX(FCHA_ESTADO)"
				+ "		                            FROM PASG.TBASG117_ESTADOTIT"
				+ "		                            WHERE CDGO_TIT = T.CDGO_TIT"
				+ "		                            AND MRCA_ACTIVO = 'S');";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("value", cdgoPersona);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetFindTituloConByCdgoPersonaActivo> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetFindTituloConByCdgoPersonaActivo datos = new GetFindTituloConByCdgoPersonaActivo();

			datos.setCdgoTit((Integer)object[0]);
			datos.setCdgoPersona((Integer)object[1]);
			datos.setFchaOtorgado((Date) object[2]);
			datos.setCdgoEstado((Integer)object[3]);

			resultadosDevueltos.add(datos);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg102Titulocon> getTituloCondActivoVigenteByPersona(String cdgoPersona) {

		String sqlString = "SELECT T.* " + "		FROM PASG.TBASG102_TITULOCON T "
				+ "		INNER JOIN PASG.TBASG117_ESTADOTIT S ON T.CDGO_TIT = S.CDGO_TIT "
				+ "		WHERE T.MRCA_ACTIVO = 'S' " + "		AND S.MRCA_ACTIVO = 'S'"
				+ "		AND T.CDGO_PERSONA = :value"
				+ "		AND S.FCHA_ESTADO = (SELECT MAX(FCHA_ESTADO) FROM PASG.TBASG117_ESTADOTIT "
				+ "		                     WHERE CDGO_TIT = S.CDGO_TIT AND MRCA_ACTIVO = 'S')"
				+ "		AND S.CDGO_ESTADO IN (3, 5, 6, 7, 12, 13, 14, 15, 20);";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg102Titulocon.class);
		sqlquery.setParameter("value", cdgoPersona);
		return sqlquery.getResultList();
	}

	public List<Tbasg102Titulocon> getTituloCondActivoVigenteByTitulo(String cdgoTit) {

		String sqlString = "SELECT T.* " + "		FROM PASG.TBASG102_TITULOCON T "
				+ "		INNER JOIN PASG.TBASG117_ESTADOTIT S ON T.CDGO_TIT = S.CDGO_TIT "
				+ "		WHERE T.MRCA_ACTIVO = 'S' " + "		AND S.MRCA_ACTIVO = 'S'" + "		AND T.CDGO_TIT = :value"
				+ "		AND S.FCHA_ESTADO = (SELECT MAX(FCHA_ESTADO) FROM PASG.TBASG117_ESTADOTIT "
				+ "		                     WHERE CDGO_TIT = S.CDGO_TIT AND MRCA_ACTIVO = 'S')"
				+ "		AND S.CDGO_ESTADO IN (3, 5, 6, 7, 12, 13, 14, 15, 20);";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg102Titulocon.class);
		sqlquery.setParameter("value", cdgoTit);
		return sqlquery.getResultList();
	}

	public int insertTituloCon(Tbasg102Titulocon bean) {

		String sqlString = "INSERT INTO PASG.TBASG102_TITULOCON (CDGO_PERSONA, FCHA_OTORGADO, DESG_TIPTIT, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO, DESG_SOLORAM, FCHA_TIPEJERPROF)"
				+ "			VALUES (?,?,?,?,CURRENT_DATE, ?, ?, ?)";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg102Titulocon.class);
		sqlquery.setParameter(1, bean.getCdgoPersona());
		sqlquery.setParameter(2, bean.getFchaOtorgado());
		sqlquery.setParameter(3, bean.getDesgTiptit());
		sqlquery.setParameter(4, bean.getDesgUsuact());
		sqlquery.setParameter(5, bean.getMrcaActivo());
		sqlquery.setParameter(6, bean.getDesgSoloram());
		sqlquery.setParameter(7, bean.getFchaTipejerprof());
		return sqlquery.executeUpdate();
	}

	@Transactional
	public int updateTituloCon(Tbasg102TituloconDto bean) {
		int result = 0;

		String sqlString = "UPDATE PASG.TBASG102_TITULOCON SET FCHA_OTORGADO = :fchaOtorgado, FCHA_ACT = CURRENT_DATE, DESG_TIPTIT = :tiptit ";

		if (Objects.nonNull(bean.getMrcaActivo()))       sqlString += ", MRCA_ACTIVO      = :mrcaActivo "; 
		if (Objects.nonNull(bean.getDesgSoloram()))      sqlString += ", DESG_SOLORAM     = :desgSoloram "; 
		if (Objects.nonNull(bean.getFchaTipejerprof()))  sqlString += ", FCHA_TIPEJERPROF = :fchaTipejerprof "; 
		sqlString += " WHERE CDGO_TIT = :cdgoTit ";

		Query sqlquery = em.createNativeQuery(sqlString, Tbasg102Titulocon.class);	

		sqlquery.setParameter("fchaOtorgado",      dateFormat.format(bean.getFchaOtorgado()) );
		sqlquery.setParameter("tiptit",            bean.getDesgTiptit() );
		if (Objects.nonNull(bean.getMrcaActivo()))       sqlquery.setParameter("mrcaActivo",      bean.getMrcaActivo() );
		if (Objects.nonNull(bean.getDesgSoloram()))      sqlquery.setParameter("desgSoloram",     bean.getDesgSoloram() );
		if (Objects.nonNull(bean.getFchaTipejerprof()))  sqlquery.setParameter("fchaTipejerprof", dateFormat.format(bean.getFchaTipejerprof()) );
		sqlquery.setParameter("cdgoTit",           bean.getCdgoTit());

		try {
			result = sqlquery.executeUpdate();

		} catch (Exception e) {
			logger.debug("Error updating driver's license - part1");			
		}
		
		if (result > 0) {
			result = 0;

			sqlString = "UPDATE PASG.TBASG117_ESTADOTIT SET CDGO_ESTADO=:cdgoEstado, FCHA_ACT = CURRENT_DATE WHERE CDGO_TIT=:cdgoTit";

			sqlquery = em.createNativeQuery(sqlString, Tbasg117Estadotit.class);

			sqlquery.setParameter("cdgoEstado", bean.getDesgUsuact() );        	
			sqlquery.setParameter("cdgoTit",    bean.getCdgoTit());

			try {
				result = sqlquery.executeUpdate();
	
			} catch (Exception e) {
				logger.debug("Error updating driver's license - part2");			
			}			
		}

		return result;
	}

	public <T> String convertToString(T value) {
        return value != null ? value.toString() : null;          
    }	
}
