package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetFcCualificacionListAscCdgoCategoriaDTO;
import renfe.com.model.dto.Tbasg156FcCualificacionDto;
import renfe.com.model.entity.Tbasg156FcCualificacion;

public interface Tbasg156FcCualificacionRepositoryCustom {

	public List<Tbasg156FcCualificacion> getFcCualificacion(String cdgoCategoria, String cdgoCualificacion);

	public List<Tbasg156FcCualificacion> getFcCualificacionView(String cdgoCategoria, String cdgoCualificacion);

	public List<Tbasg156FcCualificacion> getFcCualificacionListAscendente();
	
	public List<GetFcCualificacionListAscCdgoCategoriaDTO> getFcCualificacionListAscCdgoCategoria(Integer cdgoCategoria);

	public List<Tbasg156FcCualificacion> getFcCualificacionListDescendente();

	public List<Tbasg156FcCualificacion> getFcCualificacionListAscendenteView(String cdgoCategoria);

	public List<Tbasg156FcCualificacion> getFcCualificacionListDescendenteView(String cdgoCategoria);

	public List<Tbasg156FcCualificacion> getFcCualificacionCount();

	public List<Tbasg156FcCualificacion> getFcCualificacionViewCount(String cdgoCategoria);

	public List<Tbasg156FcCualificacion> getFcCualificacionListActive();

	public List<Tbasg156FcCualificacion> getFcCualificacionListOrderByCategoria();

	public List<Tbasg156FcCualificacionDto> getCualiForName(String desgDescripcion);

	public int insertFcCualificacion(Tbasg156FcCualificacion bean);

	public int updateFcCualificacion(Tbasg156FcCualificacion bean);
	
	public int estadoFcCualificacion(Tbasg156FcCualificacion bean);

	public int deleteFcCualificacion(Tbasg156FcCualificacion bean);

	public int reactiveFcCualificacion(Tbasg156FcCualificacion bean);

}
