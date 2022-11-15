package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetFormacionComplementariaPersonaListResultDTO;

import renfe.com.dto.InsertFormaccomplemenParamDTO;

import renfe.com.model.dto.Tbasg157FormacComplemenDto;
import renfe.com.model.entity.Tbasg157FormacComplemen;

public interface Tbasg157FormacComplemenService {

	public List<Tbasg157FormacComplemenDto> getAllTbasg157FormacComplemen(Tbasg157FormacComplemenDto filter);

	public Tbasg157FormacComplemenDto findByCdgoCategoriaCdgoCualificacionCdgoPersona(Integer cdgoCategoria,
			Integer cdgoCualificacion, Integer cdgoPersona);

	public Tbasg157FormacComplemenDto createTbasg157FormacComplemen(
			Tbasg157FormacComplemenDto tbasg157FormacComplemenDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg157FormacComplemenDto updateTbasg157FormacComplemen(Integer cdgoCategoria, Integer cdgoCualificacion,
			Integer cdgoPersona, Tbasg157FormacComplemenDto tbasg157FormacComplemenDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg157FormacComplemen(Integer cdgoCategoria, Integer cdgoCualificacion, Integer cdgoPersona);

	public List<Tbasg157FormacComplemenDto> findByCdgoCategoriaCdgoCualificacionCdgoPersonaIn(
			List<Integer> cdgoCategoria, List<Integer> cdgoCualificacion, List<Integer> cdgoPersona);

	public List<GetFormacionComplementariaPersonaListResultDTO> getFormacComplemenPersonaList(Integer cdgoPersona, Integer cdgoCategoria, Integer cdgoCualificacion);

	public int insertFormacComplemen(InsertFormaccomplemenParamDTO bean);

	public int updateFormacComplemen(Tbasg157FormacComplemen bean);

	public int deleteFormacComplemen(Integer cdgoPersona, Integer cdgoCategoria, Integer cdgoCualificacion);
	
	public List<Tbasg157FormacComplemenDto> getFormaComplemenPersona(Integer cdgoPersona);

}
