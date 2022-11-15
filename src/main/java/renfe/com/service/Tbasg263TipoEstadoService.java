package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg263TipoEstadoDto;

public interface Tbasg263TipoEstadoService {

	public List<Tbasg263TipoEstadoDto> getAllTbasg263TipoEstado(Tbasg263TipoEstadoDto filter);

	public Tbasg263TipoEstadoDto findByCdgoEstado(String cdgoEstado);

	public Tbasg263TipoEstadoDto createTbasg263TipoEstado(Tbasg263TipoEstadoDto tbasg263TipoEstadoDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg263TipoEstadoDto updateTbasg263TipoEstado(String cdgoEstado,
			Tbasg263TipoEstadoDto tbasg263TipoEstadoDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg263TipoEstado(String cdgoEstado);

	public List<Tbasg263TipoEstadoDto> findByCdgoEstadoIn(List<String> cdgoEstado);

	public List<Tbasg263TipoEstadoDto> getTipoEstAcAllList();

	public List<Tbasg263TipoEstadoDto> getTipoEstAcCount();

	public List<Tbasg263TipoEstadoDto> getTipoEstadoAcredita();

	public List<Tbasg263TipoEstadoDto> getTipoEstadosAcredita();

}
