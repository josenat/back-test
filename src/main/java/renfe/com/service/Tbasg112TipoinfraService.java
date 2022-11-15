package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg112TipoinfraDto;
import renfe.com.model.entity.Tbasg112Tipoinfra;

public interface Tbasg112TipoinfraService {

	public List<Tbasg112TipoinfraDto> getAllTbasg112Tipoinfra(Tbasg112TipoinfraDto filter);

	public Tbasg112TipoinfraDto findByCdgoTipinfr(Integer cdgoTipinfr);

	public Tbasg112TipoinfraDto createTbasg112Tipoinfra(Tbasg112TipoinfraDto tbasg112TipoinfraDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg112TipoinfraDto updateTbasg112Tipoinfra(Integer cdgoTipinfr, Tbasg112TipoinfraDto tbasg112TipoinfraDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg112Tipoinfra(Integer cdgoTipinfr);

	public List<Tbasg112TipoinfraDto> findByCdgoTipinfrIn(List<Integer> cdgoTipinfr);

	public List<Tbasg112TipoinfraDto> getTipoInfraCount();

	public List<Tbasg112TipoinfraDto> getTipoInfraActiveCount();

	public List<Tbasg112TipoinfraDto> getTipoInfraListAscendente();

	public List<Tbasg112TipoinfraDto> getTipoInfraListDescendente();

	public List<Tbasg112TipoinfraDto> getTipoInfraActiveListAscendente();

	public List<Tbasg112TipoinfraDto> getTipoInfraActiveListDescendente();

	public List<Tbasg112TipoinfraDto> getTipoInfra(String cdgoTipinfr);

	public int insertTipoInfra(Tbasg112Tipoinfra bean);

	public int updateTipoInfra(Tbasg112Tipoinfra bean);
	
	public int estadoTipoInfra(Tbasg112Tipoinfra bean);

}
