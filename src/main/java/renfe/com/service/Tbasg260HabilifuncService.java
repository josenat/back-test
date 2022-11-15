package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg260HabilifuncDto;

public interface Tbasg260HabilifuncService {

	public List<Tbasg260HabilifuncDto> getAllTbasg260Habilifunc(Tbasg260HabilifuncDto filter);

	public Tbasg260HabilifuncDto findByCdgoIdiomaCdgoMensajeTipoHabi(String cdgoIdioma, String cdgoMensaje,
			Integer tipoHabi);

	public Tbasg260HabilifuncDto createTbasg260Habilifunc(Tbasg260HabilifuncDto tbasg260HabilifuncDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg260HabilifuncDto updateTbasg260Habilifunc(String cdgoIdioma, String cdgoMensaje, Integer tipoHabi,
			Tbasg260HabilifuncDto tbasg260HabilifuncDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg260Habilifunc(String cdgoIdioma, String cdgoMensaje, Integer tipoHabi);

	public List<Tbasg260HabilifuncDto> findByCdgoIdiomaCdgoMensajeTipoHabiIn(List<String> cdgoIdioma,
			List<String> cdgoMensaje, List<Integer> tipoHabi);

	public List<Tbasg260HabilifuncDto> getFuncionesAsocHabil(List<Integer> listHabilitaciones, String cdgoIdioma);

}
