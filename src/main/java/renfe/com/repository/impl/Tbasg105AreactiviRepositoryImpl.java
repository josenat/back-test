package renfe.com.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.dto.GetAreActiviListAscendenteDTO;
import renfe.com.dto.GetAreActiviListComboDTO;
import renfe.com.dto.GetSociedadesByCodAreaActivListDTO;
import renfe.com.model.dto.Tbasg105AreactiviDto;
import renfe.com.model.entity.Tbasg105Areactivi;
import renfe.com.repository.Tbasg105AreactiviRepositoryCustom;

public class Tbasg105AreactiviRepositoryImpl implements Tbasg105AreactiviRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    public List<Tbasg105Areactivi> getAreActiviCount() {

        String sqlString = "SELECT COUNT(*) as value  FROM PASG.TBASG105_AREACTIVI";
        Query sqlquery = em.createNativeQuery(sqlString, Tbasg105Areactivi.class);

		return sqlquery.getResultList();
	}
	

	public List<Tbasg105Areactivi> getAllAreAct() {

		String sqlString = "SELECT CDGO_AREACT, DESG_NOMBRE FROM PASG.TBASG105_AREACTIVI";
		
		Query sqlquery = em.createNativeQuery(sqlString);
	
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg105Areactivi> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg105Areactivi area = new Tbasg105Areactivi();
			
			area.setCdgoAreact(Integer.valueOf((int)object[0]));
			area.setDesgNombre((String)object[1]);
			
			resultadosDevueltos.add(area);
		}
			return resultadosDevueltos;
    }

    public List<GetAreActiviListComboDTO> getAreActiviListCombo() {

        String sqlString = "SELECT A.CDGO_AREACT,A.DESG_NOMBRE,A.DESG_USUACT,A.FCHA_ACT,A.MRCA_ACTIVO,"
                + "		A.CDGO_SOCIEDAD AS CODIGO_SOCIEDAD,S.DESC_SOCIEDAD" + "		 FROM "
                + "			PASG.TBASG105_AREACTIVI A"
                + "			LEFT JOIN PASG.TBASG261_SOCIEDADES S ON S.CDGO_SOCIEDAD = A.CDGO_SOCIEDAD" + "		WHERE"
                + "			A.MRCA_ACTIVO='S' ORDER BY DESG_NOMBRE";
        Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetAreActiviListComboDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetAreActiviListComboDTO areaactivi = new GetAreActiviListComboDTO();
			
			areaactivi.setCdgoAreact(Integer.valueOf((int) object[0]));
            areaactivi.setDesgNombre((String) object[1]);
            areaactivi.setDesgUsuact((String) object[2]);
            areaactivi.setFchaAct((Date) object[3]);
            areaactivi.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));
            areaactivi.setCdgoSociedad((String) object[5]);
            areaactivi.setDescSociedad((String) object[6]);

			resultadosDevueltos.add(areaactivi);
		}
		return resultadosDevueltos;
    }

    public List<GetAreActiviListAscendenteDTO> getAreActiviListAscendente() {

        String sqlString = "SELECT A.CDGO_AREACT,A.DESG_NOMBRE,A.DESG_USUACT,A.FCHA_ACT,A.MRCA_ACTIVO,A.CDGO_SOCIEDAD AS CODIGO_SOCIEDAD,S.DESC_SOCIEDAD"
                + "		 FROM " + "			PASG.TBASG105_AREACTIVI A"
                + "			LEFT JOIN PASG.TBASG261_SOCIEDADES S ON S.CDGO_SOCIEDAD = A.CDGO_SOCIEDAD"
                + "		ORDER BY A.CDGO_AREACT";
        Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<GetAreActiviListAscendenteDTO> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			GetAreActiviListAscendenteDTO areaactivi = new GetAreActiviListAscendenteDTO();
			
			areaactivi.setCdgoAreact(Integer.valueOf((int) object[0]));
            areaactivi.setDesgNombre((String) object[1]);
            areaactivi.setDesgUsuact((String) object[2]);
            areaactivi.setFchaAct((Date) object[3]);
            areaactivi.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));
            areaactivi.setCdgoSociedad((String) object[5]);
            areaactivi.setDescSociedad((String) object[6]);

			resultadosDevueltos.add(areaactivi);
		}
		return resultadosDevueltos;
    }

    public List<Tbasg105Areactivi> getAreActiviListDescendente() {

        String sqlString = "SELECT A.CDGO_AREACT,A.DESG_NOMBRE,A.DESG_USUACT,A.FCHA_ACT,A.MRCA_ACTIVO,A.CDGO_SOCIEDAD AS CODIGO_SOCIEDAD,S.DESC_SOCIEDAD"
                + "		 FROM " + "			PASG.TBASG105_AREACTIVI A"
                + "			LEFT JOIN PASG.TBASG261_SOCIEDADES S ON S.CDGO_SOCIEDAD = A.CDGO_SOCIEDAD"
                + "		ORDER BY CDGO_AREACT DESC";
        Query sqlquery = em.createNativeQuery(sqlString, Tbasg105Areactivi.class);

        return sqlquery.getResultList();
    }

    public List<Tbasg105Areactivi> getAreActiviActiveListAscendente() {

        String sqlString = "SELECT A.CDGO_AREACT,A.DESG_NOMBRE,A.DESG_USUACT,A.FCHA_ACT,A.MRCA_ACTIVO,A.CDGO_SOCIEDAD AS CODIGO_SOCIEDAD,S.DESC_SOCIEDAD"
                + "		 FROM " + "			PASG.TBASG105_AREACTIVI A"
                + "			LEFT JOIN PASG.TBASG261_SOCIEDADES S ON S.CDGO_SOCIEDAD = A.CDGO_SOCIEDAD" + "		WHERE"
                + "			A.MRCA_ACTIVO='S' ORDER BY CDGO_AREACT";
        Query sqlquery = em.createNativeQuery(sqlString, Tbasg105Areactivi.class);

        return sqlquery.getResultList();
    }

    public List<Tbasg105Areactivi> getAreActiviActiveListDescendente() {

        String sqlString = "SELECT A.CDGO_AREACT,A.DESG_NOMBRE,A.DESG_USUACT,A.FCHA_ACT,A.MRCA_ACTIVO,A.CDGO_SOCIEDAD AS CODIGO_SOCIEDAD,S.DESC_SOCIEDAD"
                + "		 FROM " + "			PASG.TBASG105_AREACTIVI A"
                + "			LEFT JOIN PASG.TBASG261_SOCIEDADES S ON S.CDGO_SOCIEDAD = A.CDGO_SOCIEDAD" + "		WHERE"
                + "			A.MRCA_ACTIVO='S' ORDER BY CDGO_AREACT DESC";
        Query sqlquery = em.createNativeQuery(sqlString, Tbasg105Areactivi.class);

        return sqlquery.getResultList();
    }

    public List<Tbasg105Areactivi> getAreActiviListAscendenteDESG_NOMBRE() {

        String sqlString = "SELECT A.CDGO_AREACT,A.DESG_NOMBRE,A.DESG_USUACT,A.FCHA_ACT,A.MRCA_ACTIVO,A.CDGO_SOCIEDAD AS CODIGO_SOCIEDAD,S.DESC_SOCIEDAD"
                + "		 FROM " + "			PASG.TBASG105_AREACTIVI A"
                + "			LEFT JOIN PASG.TBASG261_SOCIEDADES S ON S.CDGO_SOCIEDAD = A.CDGO_SOCIEDAD" + "		WHERE"
                + "			A.MRCA_ACTIVO='S' ORDER BY DESG_NOMBRE";
        Query sqlquery = em.createNativeQuery(sqlString, Tbasg105Areactivi.class);

        return sqlquery.getResultList();
    }


    public List<Tbasg105Areactivi> getAreActiviListAscendenteSelectedByLevel() {
        String sqlString = "SELECT DISTINCT A.CDGO_AREACT,A.DESG_NOMBRE,A.DESG_USUACT,A.FCHA_ACT,A.MRCA_ACTIVO,A.CDGO_SOCIEDAD "
                + " FROM PASG.TBASG105_AREACTIVI A"
                + " INNER JOIN PASG.TBASG141_ARETER TER ON A.CDGO_AREACT = TER.CDGO_AREACT "
                + " " + " ORDER BY A.DESG_NOMBRE";
        Query sqlquery = em.createNativeQuery(sqlString, Tbasg105Areactivi.class);
        return sqlquery.getResultList();
    }


    public List<Tbasg105Areactivi> getAreActiviActiveListAscendenteDESG_NOMBRE() {

        String sqlString = "SELECT A.CDGO_AREACT,A.DESG_NOMBRE,A.DESG_USUACT,A.FCHA_ACT,A.MRCA_ACTIVO,A.CDGO_SOCIEDAD AS CODIGO_SOCIEDAD,S.DESC_SOCIEDAD"
                + "		 FROM " + "			PASG.TBASG105_AREACTIVI A"
                + "			LEFT JOIN PASG.TBASG261_SOCIEDADES S ON S.CDGO_SOCIEDAD = A.CDGO_SOCIEDAD" + "		WHERE"
                + "			A.MRCA_ACTIVO='S' ORDER BY DESG_NOMBRE";
        Query sqlquery = em.createNativeQuery(sqlString);
        List<Object[]> resultados = sqlquery.getResultList();
        List<Tbasg105Areactivi> resultadosDevueltos = new ArrayList<>();
        for (Object[] object : resultados) {
            Tbasg105Areactivi areaactivi = new Tbasg105Areactivi();

            areaactivi.setCdgoAreact(Integer.valueOf((int) object[0]));
            areaactivi.setDesgNombre((String) object[1]);
            areaactivi.setDesgUsuact((String) object[2]);
            areaactivi.setFchaAct((Date) object[3]);
            areaactivi.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));
            areaactivi.setCdgoSociedad((String) object[5]);

            resultadosDevueltos.add(areaactivi);
        }
        return resultadosDevueltos;
    }

    public List<Tbasg105Areactivi> getAreActiviActiveListDescendenteDESG_NOMBRE() {

        String sqlString = "SELECT A.CDGO_AREACT,A.DESG_NOMBRE,A.DESG_USUACT,A.FCHA_ACT,A.MRCA_ACTIVO,A.CDGO_SOCIEDAD AS CODIGO_SOCIEDAD,S.DESC_SOCIEDAD"
                + "		 FROM " + "			PASG.TBASG105_AREACTIVI A"
                + "			LEFT JOIN PASG.TBASG261_SOCIEDADES S ON S.CDGO_SOCIEDAD = A.CDGO_SOCIEDAD" + "		WHERE"
                + "			A.MRCA_ACTIVO='S' ORDER BY DESG_NOMBRE DESC";
        Query sqlquery = em.createNativeQuery(sqlString, Tbasg105Areactivi.class);

        return sqlquery.getResultList();
    }

    public List<Tbasg105Areactivi> getAreActivi(String cdgoAreact) {

        String sqlString = "SELECT A.CDGO_AREACT,A.DESG_NOMBRE,A.DESG_USUACT,A.FCHA_ACT,A.MRCA_ACTIVO,A.CDGO_SOCIEDAD AS CODIGO_SOCIEDAD,S.DESC_SOCIEDAD"
                + "		 FROM " + "			PASG.TBASG105_AREACTIVI A"
                + "			LEFT JOIN PASG.TBASG261_SOCIEDADES S ON S.CDGO_SOCIEDAD = A.CDGO_SOCIEDAD"
                + "		 WHERE CDGO_AREACT=:value";
        Query sqlquery = em.createNativeQuery(sqlString, Tbasg105Areactivi.class);
        sqlquery.setParameter("value", cdgoAreact);
        return sqlquery.getResultList();
    }

    public List<Tbasg105Areactivi> getAreActiviActiveListCodes() {

        String sqlString = "SELECT A.CDGO_AREACT,A.DESG_NOMBRE,A.DESG_USUACT,A.FCHA_ACT,A.MRCA_ACTIVO,S.DESC_SOCIEDAD"
                + "		 FROM " + "			PASG.TBASG105_AREACTIVI A"
                + "			LEFT JOIN PASG.TBASG261_SOCIEDADES S ON S.CDGO_SOCIEDAD = A.CDGO_SOCIEDAD" + "		WHERE"
                + "			A.MRCA_ACTIVO='S'";
        Query sqlquery = em.createNativeQuery(sqlString, Tbasg105Areactivi.class);

        return sqlquery.getResultList();
    }

    public List<Tbasg105Areactivi> getAreActiviListByAreTerList(List<Integer>estadosList) {

    	StringBuilder strGetAreActiviListByAreTerList = new StringBuilder();



    	String sqlString = "SELECT DISTINCT A.CDGO_AREACT,A.DESG_NOMBRE,A.DESG_USUACT,A.FCHA_ACT,A.MRCA_ACTIVO,A.CDGO_SOCIEDAD"
    	+ " FROM PASG.TBASG105_AREACTIVI A"
    	+ " INNER JOIN PASG.TBASG141_ARETER T ON A.CDGO_AREACT = T.CDGO_AREACT"
    	+ " WHERE 1=1";

    	strGetAreActiviListByAreTerList.append(sqlString);
    	System.out.println("----------------------");
    	System.out.println(strGetAreActiviListByAreTerList.toString());
    	System.out.println("----------------------");

    	if(estadosList!=null) {
    	strGetAreActiviListByAreTerList.append(" AND T.CDGO_ARETER IN (" + estadosList.get(0));
    	for( int i = 1; i < estadosList.size(); i++) {
    	strGetAreActiviListByAreTerList.append("," + estadosList.get(i));
    	}
    	strGetAreActiviListByAreTerList.append(") ");
    	}

    	strGetAreActiviListByAreTerList.append(" ORDER BY DESG_NOMBRE");
    	System.out.println("----------------------");
    	System.out.println(strGetAreActiviListByAreTerList.toString());
    	System.out.println("----------------------");

    	Query sqlquery = em.createNativeQuery(strGetAreActiviListByAreTerList.toString());

    	List<Object[]> resultados = sqlquery.getResultList();
    	List<Tbasg105Areactivi> resultadosDevueltos = new ArrayList<>();
    	for (Object[] object : resultados) {
    	Tbasg105Areactivi area = new Tbasg105Areactivi();



    	area.setCdgoAreact((int)object[0]);
    	area.setDesgNombre((String)object[1]);
    	area.setDesgUsuact((String)object[2]);
    	area.setFchaAct((Date)object[3]);
    	area.setMrcaActivo(String.valueOf((java.lang.Character) object[4]));
    	area.setCdgoSociedad((String)object[5]);



    	resultadosDevueltos.add(area);
    	}
    	return resultadosDevueltos;



    	}
    
    public List<Tbasg105Areactivi> getAreActiviListByAreTerListAll() {

        String sqlString = "SELECT DISTINCT A.CDGO_AREACT,A.DESG_NOMBRE,A.DESG_USUACT,A.FCHA_ACT,A.MRCA_ACTIVO,A.CDGO_SOCIEDAD AS CODIGO_SOCIEDAD"
                + "			FROM PASG.TBASG105_AREACTIVI A"
                + "			INNER JOIN PASG.TBASG141_ARETER T ON A.CDGO_AREACT = T.CDGO_AREACT"
                + "			ORDER BY DESG_NOMBRE";
        Query sqlquery = em.createNativeQuery(sqlString, Tbasg105Areactivi.class);

        return sqlquery.getResultList();
    }

    public int insertAreActivi(Tbasg105Areactivi bean) {

        String sqlString = "INSERT INTO PASG.TBASG105_AREACTIVI (CDGO_AREACT, DESG_NOMBRE, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO , CDGO_SOCIEDAD)"
                + "		VALUES (?, ?, ?, CURRENT_DATE, ? , ?)";
        Query sqlquery = em.createNativeQuery(sqlString, Tbasg105Areactivi.class);
        sqlquery.setParameter(1, bean.getCdgoAreact());
        sqlquery.setParameter(2, bean.getDesgNombre());
        sqlquery.setParameter(3, bean.getDesgUsuact());
        sqlquery.setParameter(4, bean.getMrcaActivo());
        sqlquery.setParameter(5, bean.getCdgoSociedad());
        return sqlquery.executeUpdate();
    }

    public int updateAreActivi(Tbasg105Areactivi bean) {

        String sqlString = "UPDATE PASG.TBASG105_AREACTIVI SET DESG_NOMBRE=:nombre, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE , CDGO_SOCIEDAD=:cdgoSociedad WHERE CDGO_AREACT=:cdgoAreAct";
        Query sqlquery = em.createNativeQuery(sqlString, Tbasg105Areactivi.class);
        sqlquery.setParameter("nombre", bean.getDesgNombre());
        sqlquery.setParameter("usuAct", bean.getDesgUsuact());
        sqlquery.setParameter("cdgoSociedad", bean.getCdgoSociedad());
        sqlquery.setParameter("cdgoAreAct", bean.getCdgoAreact());
        return sqlquery.executeUpdate();
    }
    
    public int estadoAreActivi(Tbasg105Areactivi bean) {

        String sqlString = "UPDATE PASG.TBASG105_AREACTIVI SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE  WHERE CDGO_AREACT=:cdgoAreAct";
        Query sqlquery = em.createNativeQuery(sqlString, Tbasg105Areactivi.class);
        sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
        sqlquery.setParameter("usuAct", bean.getDesgUsuact());
        sqlquery.setParameter("cdgoAreAct", bean.getCdgoAreact());
        return sqlquery.executeUpdate();
    }

    public List<Tbasg105Areactivi> getAreTerListAscendenteCDGO_ARETER() {

        String sqlString = "SELECT T.CDGO_ARETER, T.CDGO_AREACT, T.DESG_NOMBRE,	A.DESG_NOMBRE AS DESG_NOMBREAUX, T.DESG_USUACT, T.FCHA_ACT, T.MRCA_ACTIVO FROM 	PASG.TBASG105_AREACTIVI A, PASG.TBASG141_ARETER T WHERE T.CDGO_AREACT = A.CDGO_AREACT ORDER BY T.CDGO_ARETER";
        Query sqlquery = em.createNativeQuery(sqlString, Tbasg105Areactivi.class);

        return sqlquery.getResultList();
    }

    public List<Tbasg105Areactivi> getAreTerActiveListAscendenteCDGO_ARETER() {

        String sqlString = "SELECT T.CDGO_ARETER, T.CDGO_AREACT, T.DESG_NOMBRE,	A.DESG_NOMBRE AS DESG_NOMBREAUX, T.DESG_USUACT, T.FCHA_ACT, T.MRCA_ACTIVO FROM 	PASG.TBASG105_AREACTIVI A, PASG.TBASG141_ARETER T WHERE T.MRCA_ACTIVO='S' AND T.CDGO_AREACT = A.CDGO_AREACT ORDER BY T.CDGO_ARETER";
        Query sqlquery = em.createNativeQuery(sqlString, Tbasg105Areactivi.class);

        return sqlquery.getResultList();
    }

    public List<Tbasg105Areactivi> getSociedadesByCodAreaActiv() {

        String sqlString = "SELECT DISTINCT S.CDGO_SOCIEDAD,S.DESC_SOCIEDAD,S.DESG_USUACT,S.FCHA_ACT,S.MRCA_ACTIVO"
                + "		FROM PASG.TBASG105_AREACTIVI A"
                + "		INNER JOIN PASG.TBASG261_SOCIEDADES S ON A.CDGO_SOCIEDAD = S.CDGO_SOCIEDAD" + "			"
                + "		AND A.MRCA_ACTIVO='S'" + "		ORDER BY S.CDGO_SOCIEDAD";
        Query sqlquery = em.createNativeQuery(sqlString, Tbasg105Areactivi.class);

        return sqlquery.getResultList();
    }

    public List<Tbasg105Areactivi> getSociedadesByCodAreaActivAll() {

        String sqlString = "SELECT DISTINCT S.CDGO_SOCIEDAD,S.DESC_SOCIEDAD" + "		FROM PASG.TBASG105_AREACTIVI A"
                + "		INNER JOIN PASG.TBASG261_SOCIEDADES S ON A.CDGO_SOCIEDAD = S.CDGO_SOCIEDAD"
                + "		WHERE A.MRCA_ACTIVO='S'" + "		ORDER BY S.CDGO_SOCIEDAD";
        Query sqlquery = em.createNativeQuery(sqlString, Tbasg105Areactivi.class);

        return sqlquery.getResultList();
    }

    public List<Tbasg105Areactivi> getCodAreActiviListByAreTerList() {
        String sqlString = "SELECT DISTINCT A.CDGO_AREACT" + " FROM PASG.TBASG105_AREACTIVI A"
                + " INNER JOIN PASG.TBASG141_ARETER T ON A.CDGO_AREACT = T.CDGO_AREACT" + " "
                + " ORDER BY A.CDGO_AREACT";
        Query sqlquery = em.createNativeQuery(sqlString);

        List<Object> resultados = sqlquery.getResultList();
        List<Tbasg105Areactivi> resultadosDevueltos = new ArrayList<>();
        for (Object object : resultados) {
            Tbasg105Areactivi areaactivi = new Tbasg105Areactivi();

            areaactivi.setCdgoAreact(Integer.valueOf((int) object));

            resultadosDevueltos.add(areaactivi);
        }
        return resultadosDevueltos;
    }

    public List<GetSociedadesByCodAreaActivListDTO> getSociedadesByCodAreaActivList() {
        String sqlString = "SELECT DISTINCT S.CDGO_SOCIEDAD, S.DESC_SOCIEDAD, S.DESG_USUACT, S.FCHA_ACT, S.MRCA_ACTIVO"
            + " FROM PASG.TBASG105_AREACTIVI A"
            + " INNER JOIN PASG.TBASG261_SOCIEDADES S ON A.CDGO_SOCIEDAD = S.CDGO_SOCIEDAD" 
            + " WHERE A.CDGO_AREACT IN"
                + " (SELECT DISTINCT AA.CDGO_AREACT FROM PASG.TBASG105_AREACTIVI AA"
                + " INNER JOIN PASG.TBASG141_ARETER T ON AA.CDGO_AREACT = T.CDGO_AREACT"
                + " WHERE AA.MRCA_ACTIVO = 'S')"
            + " AND A.MRCA_ACTIVO='S'"
            + " ORDER BY S.CDGO_SOCIEDAD"; 
        Query sqlquery = em.createNativeQuery(sqlString);

        List<Object[]> resultados                                    = sqlquery.getResultList();
        List<GetSociedadesByCodAreaActivListDTO> resultadosDevueltos = new ArrayList<>();
        for (Object[] object : resultados) {
        GetSociedadesByCodAreaActivListDTO areaActivi = new GetSociedadesByCodAreaActivListDTO();        
            areaActivi.setCdgoSociedad(this.convertToString(object[0])); 
            areaActivi.setDescSociedad(this.convertToString(object[1])); 
            areaActivi.setDescUsuact(this.convertToString(object[2])); 
            areaActivi.setFchaAct((Date)object[3]);
            areaActivi.setMrcaActivo(this.convertToString(object[4]));  //areaActivi.setMrcaActivo(String.valueOf((Character) object[4]));
            resultadosDevueltos.add(areaActivi);
        }

        return resultadosDevueltos;
    }
    @Override
	public List<Tbasg105Areactivi> getSociedadesByCodAreaActiv(List<Integer> listAreaActi) {
		String sqlString = "SELECT * "
				+ "FROM PASG.TBASG105_AREACTIVI A "
				+ "INNER JOIN PASG.TBASG261_SOCIEDADES S ON A.CDGO_SOCIEDAD = S.CDGO_SOCIEDAD "
				+ "WHERE A.CDGO_AREACT IN  :list "
				+ "AND A.MRCA_ACTIVO='S' "
				+ "ORDER BY S.CDGO_SOCIEDAD";
		
        Query sqlquery = em.createNativeQuery(sqlString, Tbasg105Areactivi.class);
        sqlquery.setParameter("list", listAreaActi);
        return sqlquery.getResultList();
     
	}

    public <T> String convertToString(T value) {
        return value != null ? value.toString() : null;        
    }    
}
