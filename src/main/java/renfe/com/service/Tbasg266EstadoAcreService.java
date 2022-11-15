package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg266EstadoAcreDto;
import renfe.com.model.entity.Tbasg266EstadoAcre;

public interface Tbasg266EstadoAcreService {

	public List<Tbasg266EstadoAcreDto> getAllTbasg266EstadoAcre(Tbasg266EstadoAcreDto filter);

	public Tbasg266EstadoAcreDto findByCdgoAcreditaCdgoEstadoFchaEstado(Integer cdgoAcredita, String cdgoEstado,
			String fchaEstado);

	public Tbasg266EstadoAcreDto createTbasg266EstadoAcre(Tbasg266EstadoAcreDto tbasg266EstadoAcreDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg266EstadoAcreDto updateTbasg266EstadoAcre(Integer cdgoAcredita, String cdgoEstado, String fchaEstado,
			Tbasg266EstadoAcreDto tbasg266EstadoAcreDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg266EstadoAcre(Integer cdgoAcredita, String cdgoEstado, String fchaEstado);

	public List<Tbasg266EstadoAcreDto> findByCdgoAcreditaCdgoEstadoFchaEstadoIn(List<Integer> cdgoAcredita,
			List<String> cdgoEstado, List<String> fchaEstado);

	public int insertEstadoAcreditacion(Tbasg266EstadoAcre bean);

	public int updateEstadoAcreditacion(Tbasg266EstadoAcre bean);

	public List<Tbasg266EstadoAcreDto> getEstadosAcreditaMaxFecha();

	public List<Tbasg266EstadoAcreDto> getEstadosAcreditaTodosMaxFecha();

	public int insertEstadoAcre(Tbasg266EstadoAcre bean);

	public int updateEstadoAcreditacionMantenimiento(Tbasg266EstadoAcre bean);

}
