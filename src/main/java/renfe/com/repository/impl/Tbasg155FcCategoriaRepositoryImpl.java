package renfe.com.repository.impl;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import renfe.com.model.dto.Tbasg155FcCategoriaDto;

import renfe.com.model.entity.Tbasg123Tipohabil;

import renfe.com.model.entity.Tbasg155FcCategoria;
import renfe.com.repository.Tbasg155FcCategoriaRepositoryCustom;

public class Tbasg155FcCategoriaRepositoryImpl implements Tbasg155FcCategoriaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	public List<Tbasg155FcCategoria> getFcCategoriaCount() {

		String sqlString = "SELECT COUNT(*) as value FROM PASG.TBASG155_FC_CATEGORIA";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg155FcCategoria.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg155FcCategoria> getFcCategoriaListAscendente() {

		String sqlString = "SELECT * FROM PASG.TBASG155_FC_CATEGORIA ORDER BY DESG_DESCRIPCION";
		Query sqlquery = em.createNativeQuery(sqlString);
		
		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg155FcCategoria> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg155FcCategoria area = new Tbasg155FcCategoria();
			
			area.setCdgoCategoria((int)object[0]);
			area.setDesgDescripcion((String)object[1]);
			area.setDesgUsuact((String)object[2]);
			area.setFchaAct((Date)object[3]);
			area.setMrcaActivo((char)object[4]);
			
			resultadosDevueltos.add(area);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg155FcCategoria> getFcCategoriaListDescendente() {

		String sqlString = "SELECT * FROM PASG.TBASG155_FC_CATEGORIA ORDER BY DESG_DESCRIPCION DESC";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg155FcCategoria.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg155FcCategoria> getFcCategoria(String cdgoCategoria) {

		String sqlString = "SELECT * FROM PASG.TBASG155_FC_CATEGORIA WHERE CDGO_CATEGORIA=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg155FcCategoria.class);
		sqlquery.setParameter("value", cdgoCategoria);
		return sqlquery.getResultList();
	}

	public List<Tbasg155FcCategoria> getFcCategoriaByNombre(String desgDescripcion) {

		String sqlString = "SELECT CDGO_CATEGORIA FROM PASG.TBASG155_FC_CATEGORIA WHERE DESG_DESCRIPCION=:value";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg155FcCategoria.class);
		sqlquery.setParameter("value", desgDescripcion);
		return sqlquery.getResultList();
	}

	public List<Tbasg155FcCategoria> getFcCategoriaListActive() {

		String sqlString = "SELECT * FROM PASG.TBASG155_FC_CATEGORIA WHERE MRCA_ACTIVO='S' ORDER BY DESG_DESCRIPCION";
		Query sqlquery = em.createNativeQuery(sqlString);

		List<Object[]> resultados = sqlquery.getResultList();
		List<Tbasg155FcCategoria> resultadosDevueltos = new ArrayList<>();
		for (Object[] object : resultados) {
			Tbasg155FcCategoria area = new Tbasg155FcCategoria();
			
			area.setCdgoCategoria((int)object[0]);
			area.setDesgDescripcion((String)object[1]);
			area.setDesgUsuact((String)object[2]);
			area.setFchaAct((Date)object[3]);
			area.setMrcaActivo((char)object[4]);

			resultadosDevueltos.add(area);
		}
		return resultadosDevueltos;
	}

	public List<Tbasg155FcCategoria> getFcCategoriaIdiomaList() {

		String sqlString = "SELECT * FROM PASG.TBASG155_FC_CATEGORIA WHERE  CDGO_CATEGORIA ='4' OR CDGO_CATEGORIA ='6' AND MRCA_ACTIVO='S' ORDER BY DESG_DESCRIPCION";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg155FcCategoria.class);

		return sqlquery.getResultList();
	}

	public List<Tbasg155FcCategoriaDto> getFcCategoriaByNombre2(String desgDescripcion) {

		String sqlString = "SELECT CDGO_CATEGORIA FROM PASG.TBASG155_FC_CATEGORIA WHERE DESG_DESCRIPCION LIKE :desgDescripcion";
		Query sqlquery = em.createNativeQuery(sqlString);
		sqlquery.setParameter("desgDescripcion", "%" + desgDescripcion + "%");

		List<Integer> results = sqlquery.getResultList();
		List<Tbasg155FcCategoriaDto> resultList = new ArrayList<>();	
		
		for (Integer item : results) {
			Tbasg155FcCategoriaDto categoria = new Tbasg155FcCategoriaDto();
			categoria.setCdgoCategoria(item);		
			resultList.add(categoria);
		}

		return resultList;	
	}

	public int insertFcCategoria(Tbasg155FcCategoria bean) {

		String sqlString = "INSERT INTO PASG.TBASG155_FC_CATEGORIA (DESG_DESCRIPCION, DESG_USUACT, FCHA_ACT, MRCA_ACTIVO) VALUES (?,?,CURRENT_DATE,?);";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg155FcCategoria.class);
		sqlquery.setParameter(1, bean.getDesgDescripcion());
		sqlquery.setParameter(2, bean.getDesgUsuact());
		sqlquery.setParameter(3, bean.getMrcaActivo());
		return sqlquery.executeUpdate();
	}

	public int updateFcCategoria(Tbasg155FcCategoria bean) {

		String sqlString = "UPDATE PASG.TBASG155_FC_CATEGORIA SET DESG_DESCRIPCION=:descripcion, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_CATEGORIA=:cdgoCategoria";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg155FcCategoria.class);
		sqlquery.setParameter("descripcion", bean.getDesgDescripcion());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoCategoria", bean.getCdgoCategoria());
		return sqlquery.executeUpdate();
	}
	
	public int estadoFcCategoria(Tbasg155FcCategoria bean) {

		String sqlString = "UPDATE PASG.TBASG155_FC_CATEGORIA SET MRCA_ACTIVO=:mrcaActivo, DESG_USUACT=:usuAct, FCHA_ACT=CURRENT_DATE WHERE CDGO_CATEGORIA=:cdgoCategoria";
		Query sqlquery = em.createNativeQuery(sqlString, Tbasg155FcCategoria.class);
		sqlquery.setParameter("mrcaActivo", bean.getMrcaActivo());
		sqlquery.setParameter("usuAct", bean.getDesgUsuact());
		sqlquery.setParameter("cdgoCategoria", bean.getCdgoCategoria());
		return sqlquery.executeUpdate();
	}

}
