package renfe.com.repository;

import java.util.List;

import renfe.com.model.dto.Tbasg117EstadotitDto;
import renfe.com.model.entity.Tbasg117Estadotit;

public interface Tbasg117EstadotitRepositoryCustom {

	public List<Tbasg117Estadotit> findEstadoTitByCdgoTit(String cdgoTit);

	public List<Tbasg117Estadotit> getEstadoTitList();

	public List<Tbasg117Estadotit> getEstadoTitUltimo(String cdgoTit);

	public List<Tbasg117EstadotitDto> getEstadoTit(String cdgoTit);	

	public List<Tbasg117Estadotit> existeEstadoTit(String cdgoTit, String cdgoEstado);

	public int insertEstadoTit(Tbasg117Estadotit bean);

	public int insertEstadoTitSinFecha(Tbasg117Estadotit bean);

	public int updateEstadoTit(Tbasg117Estadotit bean);

	public int deactivateEstadoTit(Tbasg117Estadotit bean);

}
