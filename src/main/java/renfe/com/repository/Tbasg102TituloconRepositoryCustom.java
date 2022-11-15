package renfe.com.repository;

import java.util.List;


import renfe.com.model.dto.Tbasg102TituloconDto;
import renfe.com.dto.GetFindTituloConByCdgoPersonaActivo;
import renfe.com.dto.GetMaxEstadoTitCondBySociedadesListDTO;
import renfe.com.dto.GetMaxEstadoTitCondListAllDTO;
import renfe.com.dto.GetTituloConPersonaUltimoDTO;
import renfe.com.dto.SetMaxEstadoTitCondBySociedadesList;
import renfe.com.dto.SetMaxEstadoTitCondListAll;

import renfe.com.model.entity.Tbasg102Titulocon;

public interface Tbasg102TituloconRepositoryCustom {

	public List<Tbasg102Titulocon> checkReciclajeTituloCond(String cdgoPersona);

	public List<GetMaxEstadoTitCondListAllDTO> getMaxEstadoTitCondListAll(SetMaxEstadoTitCondListAll mapPending);

	public List<GetMaxEstadoTitCondBySociedadesListDTO> getMaxEstadoTitCondBySociedadesList(SetMaxEstadoTitCondBySociedadesList mapPending);

	public List<Tbasg102Titulocon> getTituloCon(String cdgoTit);

	public List<Tbasg102Titulocon> getTituloConActiveByTitulo(String cdgoTit);

	public List<Tbasg102Titulocon> checkTituloToInsert(String cdgoPersona);

	public List<Tbasg102Titulocon> getTituloConPersona(String cdgoPersona);

	public List<Tbasg102TituloconDto> getTituloConPersonaUltimo(String cdgoPersona);

	public List<GetFindTituloConByCdgoPersonaActivo> findTituloConByCdgoPersonaActivo(Integer cdgoPersona);

	public List<Tbasg102Titulocon> getTituloCondActivoVigenteByPersona(String cdgoPersona);

	public List<Tbasg102Titulocon> getTituloCondActivoVigenteByTitulo(String cdgoTit);

	public int insertTituloCon(Tbasg102Titulocon bean);

	public int updateTituloCon(Tbasg102TituloconDto bean);

}
