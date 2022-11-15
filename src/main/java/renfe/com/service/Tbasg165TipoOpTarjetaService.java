package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg165TipoOpTarjetaDto;

public interface Tbasg165TipoOpTarjetaService {

	public List<Tbasg165TipoOpTarjetaDto> getAllTbasg165TipoOpTarjeta(Tbasg165TipoOpTarjetaDto filter);

	public Tbasg165TipoOpTarjetaDto findByCdgoOperacion(String cdgoOperacion);

	public Tbasg165TipoOpTarjetaDto createTbasg165TipoOpTarjeta(Tbasg165TipoOpTarjetaDto tbasg165TipoOpTarjetaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg165TipoOpTarjetaDto updateTbasg165TipoOpTarjeta(String cdgoOperacion,
			Tbasg165TipoOpTarjetaDto tbasg165TipoOpTarjetaDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg165TipoOpTarjeta(String cdgoOperacion);

	public List<Tbasg165TipoOpTarjetaDto> findByCdgoOperacionIn(List<String> cdgoOperacion);

	public List<Tbasg165TipoOpTarjetaDto> getTipoOpTarjetaActiveList();

}
