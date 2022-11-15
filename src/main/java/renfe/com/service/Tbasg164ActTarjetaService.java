package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg164ActTarjetaDto;
import renfe.com.model.entity.Tbasg164ActTarjeta;

public interface Tbasg164ActTarjetaService {

	public List<Tbasg164ActTarjetaDto> getAllTbasg164ActTarjeta(Tbasg164ActTarjetaDto filter);

	public Tbasg164ActTarjetaDto findByCdgoNumserie(String cdgoNumserie);

	public Tbasg164ActTarjetaDto createTbasg164ActTarjeta(Tbasg164ActTarjetaDto tbasg164ActTarjetaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg164ActTarjetaDto updateTbasg164ActTarjeta(String cdgoNumserie,
			Tbasg164ActTarjetaDto tbasg164ActTarjetaDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg164ActTarjeta(String cdgoNumserie);

	public List<Tbasg164ActTarjetaDto> findByCdgoNumserieIn(List<String> cdgoNumserie);

	public List<Tbasg164ActTarjetaDto> getTarjetaActualizar(String cdgoNumserie);

	public int insertActTarjeta(Tbasg164ActTarjeta bean);

}
