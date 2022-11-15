package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetFindTituloConByCdgoPersonaActivo;
import renfe.com.dto.GetMaxEstadoTitCondBySociedadesListDTO;
import renfe.com.dto.GetMaxEstadoTitCondListAllDTO;
import renfe.com.dto.GetTituloConPersonaUltimoDTO;
import renfe.com.dto.SetMaxEstadoTitCondBySociedadesList;
import renfe.com.dto.SetMaxEstadoTitCondListAll;
import renfe.com.model.dto.Tbasg102TituloconDto;
import renfe.com.model.entity.Tbasg102Titulocon;

public interface Tbasg102TituloconService {

	public List<Tbasg102TituloconDto> getAllTbasg102Titulocon(Tbasg102TituloconDto filter);

	public Tbasg102TituloconDto findByCdgoTit(Integer cdgoTit);

	public Tbasg102TituloconDto createTbasg102Titulocon(Tbasg102TituloconDto tbasg102TituloconDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg102TituloconDto updateTbasg102Titulocon(Integer cdgoTit, Tbasg102TituloconDto tbasg102TituloconDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg102Titulocon(Integer cdgoTit);

	public List<Tbasg102TituloconDto> findByCdgoTitIn(List<Integer> cdgoTit);

	public List<Tbasg102TituloconDto> checkReciclajeTituloCond(String cdgoPersona);

	public List<GetMaxEstadoTitCondListAllDTO> getMaxEstadoTitCondListAll(SetMaxEstadoTitCondListAll mapPending);

	public List<GetMaxEstadoTitCondBySociedadesListDTO> getMaxEstadoTitCondBySociedadesList(SetMaxEstadoTitCondBySociedadesList mapPending);

	public List<Tbasg102TituloconDto> getTituloCon(String cdgoTit);

	public List<Tbasg102TituloconDto> getTituloConActiveByTitulo(String cdgoTit);

	public List<Tbasg102TituloconDto> checkTituloToInsert(String cdgoPersona);

	public List<Tbasg102TituloconDto> getTituloConPersona(String cdgoPersona);

	public List<Tbasg102TituloconDto> getTituloConPersonaUltimo(String cdgoPersona);

	public List<GetFindTituloConByCdgoPersonaActivo> findTituloConByCdgoPersonaActivo(Integer cdgoPersona);

	public List<Tbasg102TituloconDto> getTituloCondActivoVigenteByPersona(String cdgoPersona);

	public List<Tbasg102TituloconDto> getTituloCondActivoVigenteByTitulo(String cdgoTit);

	public int insertTituloCon(Tbasg102Titulocon bean);

	public int updateTituloCon(Tbasg102TituloconDto bean);

}
