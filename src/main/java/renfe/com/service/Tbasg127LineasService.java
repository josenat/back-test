package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg127LineasDto;
import renfe.com.model.entity.Tbasg127Lineas;

public interface Tbasg127LineasService {

	public List<Tbasg127LineasDto> getAllTbasg127Lineas(Tbasg127LineasDto filter);

	public Tbasg127LineasDto findByCdgoLinea(String cdgoLinea);

	public Tbasg127LineasDto createTbasg127Lineas(Tbasg127LineasDto tbasg127LineasDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg127LineasDto updateTbasg127Lineas(String cdgoLinea, Tbasg127LineasDto tbasg127LineasDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg127Lineas(String cdgoLinea);

	public List<Tbasg127LineasDto> findByCdgoLineaIn(List<String> cdgoLinea);

	public List<Tbasg127LineasDto> getLineasCount();

	public List<Tbasg127LineasDto> getLineasListAscendente();

	public List<Tbasg127LineasDto> getLineasListDescendente();

	public List<Tbasg127LineasDto> getLineasActiveListAscendente();

	public List<Tbasg127LineasDto> getLineasActiveListDescendente();

	public List<Tbasg127LineasDto> getLineas(String cdgoLinea);

	public List<Tbasg127LineasDto> getAlcanceLinea(String cdgoLinea);

	public List<Tbasg127LineasDto> getLineasListDynamic();

	public int insertLineas(Tbasg127Lineas bean);

	public int updateLineas(Tbasg127Lineas bean);
	
	public int estadoLineas(Tbasg127Lineas bean);

	public int deleteLineas(Tbasg127Lineas bean);

	public int reactiveLineas(Tbasg127Lineas bean);

}
