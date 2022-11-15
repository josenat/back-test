package renfe.com.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import renfe.com.model.entity.Tbasg144Nivacceso;
import renfe.com.repository.Tbasg144NivaccesoRepositoryCustom;

public class Tbasg144NivaccesoRepositoryImpl implements Tbasg144NivaccesoRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    /*
     * public List<Tbasg144Nivacceso> getNivAccesoCount() {
     * 
     * String sqlString = "SELECT COUNT(T) FROM Tbasg144Nivacceso T";
     * Query sqlquery = em.createQuery(sqlString, Long.class);
     * return (long) sqlquery.getResultList().get(0);
     * }
     * 
     * return sqlquery.getResultList();
     * }
     */

    public List<Tbasg144Nivacceso> getNivAccesoAll() {
        String sqlString = "SELECT CDGO_ARETER FROM PASG.TBASG144_NIVACCESO AS ACCESO";
        Query sqlquery = em.createNativeQuery(sqlString, Tbasg144Nivacceso.class);
        return sqlquery.getResultList();
    }

    public Long getNivAccesoCount() {

        String sqlString = "SELECT COUNT(T) FROM Tbasg144Nivacceso T";
        Query sqlquery = em.createQuery(sqlString, Long.class);
        return (long) sqlquery.getResultList().get(0);
    }

}
