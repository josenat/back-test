package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg154OpTarjetaDto;
import renfe.com.model.entity.Tbasg154OpTarjeta;

public interface Tbasg154OpTarjetaService {

	public List<Tbasg154OpTarjetaDto> getAllTbasg154OpTarjeta(Tbasg154OpTarjetaDto filter);

	public Tbasg154OpTarjetaDto findByCdgoPersonaFchaOperacion(Integer cdgoPersona, String fchaOperacion);

	public Tbasg154OpTarjetaDto createTbasg154OpTarjeta(Tbasg154OpTarjetaDto tbasg154OpTarjetaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg154OpTarjetaDto updateTbasg154OpTarjeta(Integer cdgoPersona, String fchaOperacion,
			Tbasg154OpTarjetaDto tbasg154OpTarjetaDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg154OpTarjeta(Integer cdgoPersona, String fchaOperacion);

	public List<Tbasg154OpTarjetaDto> findByCdgoPersonaFchaOperacionIn(List<Integer> cdgoPersona,
			List<String> fchaOperacion);

	public List<Tbasg154OpTarjetaDto> getOperacion(String cdgoNumserie);

	public int insertOperTarjeta(Tbasg154OpTarjeta bean);

}
