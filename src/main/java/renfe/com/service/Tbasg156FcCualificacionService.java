package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetFcCualificacionListAscCdgoCategoriaDTO;
import renfe.com.model.dto.Tbasg156FcCualificacionDto;
import renfe.com.model.entity.Tbasg156FcCualificacion;

public interface Tbasg156FcCualificacionService {

	public List<Tbasg156FcCualificacionDto> getAllTbasg156FcCualificacion(Tbasg156FcCualificacionDto filter);

	public Tbasg156FcCualificacionDto findByCdgoCualificacion(Integer cdgoCualificacion);

	public Tbasg156FcCualificacionDto createTbasg156FcCualificacion(
			Tbasg156FcCualificacionDto tbasg156FcCualificacionDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg156FcCualificacionDto updateTbasg156FcCualificacion(Integer cdgoCualificacion,
			Tbasg156FcCualificacionDto tbasg156FcCualificacionDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg156FcCualificacion(Integer cdgoCualificacion);

	public List<Tbasg156FcCualificacionDto> findByCdgoCualificacionIn(List<Integer> cdgoCualificacion);

	public List<Tbasg156FcCualificacionDto> getFcCualificacion(String cdgoCategoria, String cdgoCualificacion);

	public List<Tbasg156FcCualificacionDto> getFcCualificacionView(String cdgoCategoria, String cdgoCualificacion);

	public List<Tbasg156FcCualificacionDto> getFcCualificacionListAscendente();
	
	public List<GetFcCualificacionListAscCdgoCategoriaDTO> getFcCualificacionListAscCdgoCategoria(Integer cdgoCategoria);

	public List<Tbasg156FcCualificacionDto> getFcCualificacionListDescendente();

	public List<Tbasg156FcCualificacionDto> getFcCualificacionListAscendenteView(String cdgoCategoria);

	public List<Tbasg156FcCualificacionDto> getFcCualificacionListDescendenteView(String cdgoCategoria);

	public List<Tbasg156FcCualificacionDto> getFcCualificacionCount();

	public List<Tbasg156FcCualificacionDto> getFcCualificacionViewCount(String cdgoCategoria);

	public List<Tbasg156FcCualificacionDto> getFcCualificacionListActive();

	public List<Tbasg156FcCualificacionDto> getFcCualificacionListOrderByCategoria();

	public List<Tbasg156FcCualificacionDto> getCualiForName(String desgDescripcion);

	public int insertFcCualificacion(Tbasg156FcCualificacion bean);

	public int updateFcCualificacion(Tbasg156FcCualificacion bean);
	
	public int estadoFcCualificacion(Tbasg156FcCualificacion bean);

	public int deleteFcCualificacion(Tbasg156FcCualificacion bean);

	public int reactiveFcCualificacion(Tbasg156FcCualificacion bean);

}
