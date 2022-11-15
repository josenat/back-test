package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetFormacionComplementariaPersonaListResultDTO;

import renfe.com.dto.InsertFormaccomplemenParamDTO;

import renfe.com.model.entity.Tbasg157FormacComplemen;

public interface Tbasg157FormacComplemenRepositoryCustom {


	public List<GetFormacionComplementariaPersonaListResultDTO> getFormacComplemenPersonaList(Integer cdgoPersona, Integer cdgoCategoria, Integer cdgoCualificacion);


	public int insertFormacComplemen(InsertFormaccomplemenParamDTO bean);

	public int updateFormacComplemen(Tbasg157FormacComplemen bean);

	public int deleteFormacComplemen(Integer cdgoPersona, Integer cdgoCategoria, Integer cdgoCualificacion);
	
	public List<Tbasg157FormacComplemen> getFormaComplemenPersona(Integer cdgoPersona);

}
