package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg269SegurDto;
import renfe.com.model.entity.Tbasg269Segur;

public interface Tbasg269SegurService {

	public List<Tbasg269SegurDto> getAllTbasg269Segur(Tbasg269SegurDto filter);

	public Tbasg269SegurDto findByCdgoSeguridad(Integer cdgoSeguridad);

	public Tbasg269SegurDto createTbasg269Segur(Tbasg269SegurDto tbasg269SegurDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg269SegurDto updateTbasg269Segur(Integer cdgoSeguridad, Tbasg269SegurDto tbasg269SegurDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg269Segur(Integer cdgoSeguridad);

	public List<Tbasg269SegurDto> findByCdgoSeguridadIn(List<Integer> cdgoSeguridad);

	public int insertSeguridadLOPD(Tbasg269Segur bean);

}
