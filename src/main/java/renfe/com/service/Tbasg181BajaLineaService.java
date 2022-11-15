package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg181BajaLineaDto;
import renfe.com.model.entity.Tbasg181BajaLinea;

public interface Tbasg181BajaLineaService {

	public List<Tbasg181BajaLineaDto> getAllTbasg181BajaLinea(Tbasg181BajaLineaDto filter);

	public Tbasg181BajaLineaDto findByCdgoLinea(String cdgoLinea);

	public Tbasg181BajaLineaDto createTbasg181BajaLinea(Tbasg181BajaLineaDto tbasg181BajaLineaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg181BajaLineaDto updateTbasg181BajaLinea(String cdgoLinea, Tbasg181BajaLineaDto tbasg181BajaLineaDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg181BajaLinea(String cdgoLinea);

	public List<Tbasg181BajaLineaDto> findByCdgoLineaIn(List<String> cdgoLinea);

	public List<Tbasg181BajaLineaDto> getBajaLinea(String cdgoLinea);

	public int insertBajaLinea(Tbasg181BajaLinea bean);

}
