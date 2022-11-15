package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg153TarjetaDto;

public interface Tbasg153TarjetaService {

	public List<Tbasg153TarjetaDto> getAllTbasg153Tarjeta(Tbasg153TarjetaDto filter);

	public Tbasg153TarjetaDto findByCdgoNumserie(String cdgoNumserie);

	public Tbasg153TarjetaDto createTbasg153Tarjeta(Tbasg153TarjetaDto tbasg153TarjetaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg153TarjetaDto updateTbasg153Tarjeta(String cdgoNumserie, Tbasg153TarjetaDto tbasg153TarjetaDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg153Tarjeta(String cdgoNumserie);

	public List<Tbasg153TarjetaDto> findByCdgoNumserieIn(List<String> cdgoNumserie);

	public List<Tbasg153TarjetaDto> getTarjeta(String cdgoNumserie);

	public List<Tbasg153TarjetaDto> getTarjetaPer(String cdgoPersona);

}
