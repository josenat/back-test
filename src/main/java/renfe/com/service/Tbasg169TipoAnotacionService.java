package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg169TipoAnotacionDto;

public interface Tbasg169TipoAnotacionService {

	public List<Tbasg169TipoAnotacionDto> getAllTbasg169TipoAnotacion(Tbasg169TipoAnotacionDto filter);

	public Tbasg169TipoAnotacionDto findByCdgoTipoanotacion(String cdgoTipoanotacion);

	public Tbasg169TipoAnotacionDto createTbasg169TipoAnotacion(Tbasg169TipoAnotacionDto tbasg169TipoAnotacionDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg169TipoAnotacionDto updateTbasg169TipoAnotacion(String cdgoTipoanotacion,
			Tbasg169TipoAnotacionDto tbasg169TipoAnotacionDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg169TipoAnotacion(String cdgoTipoanotacion);

	public List<Tbasg169TipoAnotacionDto> findByCdgoTipoanotacionIn(List<String> cdgoTipoanotacion);

	public List<Tbasg169TipoAnotacionDto> getTipoAnotacionInspectorActiveList();

}
