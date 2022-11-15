package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetInfractionListDTO;
import renfe.com.dto.GetInfractionParametersDTO;
import renfe.com.model.dto.Tbasg103InfracperDto;
import renfe.com.model.entity.Tbasg103Infracper;

public interface Tbasg103InfracperService {

	public List<Tbasg103InfracperDto> getAllTbasg103Infracper(Tbasg103InfracperDto filter);

	public Tbasg103InfracperDto findByCdgoInfrper(Integer cdgoInfrper);

	public Tbasg103InfracperDto createTbasg103Infracper(Tbasg103InfracperDto tbasg103InfracperDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg103InfracperDto updateTbasg103Infracper(Integer cdgoInfrper, Tbasg103InfracperDto tbasg103InfracperDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg103Infracper(Integer cdgoInfrper);

	public List<Tbasg103InfracperDto> findByCdgoInfrperIn(List<Integer> cdgoInfrper);

	public List<Tbasg103InfracperDto> getInfracPersonaListAscendente(String cdgoPersona);

	public List<Tbasg103InfracperDto> getInfracPersonaListDescendente(String cdgoPersona);

	public List<Tbasg103InfracperDto> getInfracPersonaActiveListAscendente(String cdgoPersona);

	public List<Tbasg103InfracperDto> getInfracPersonaActiveListDescendente(String cdgoPersona);

	public List<Tbasg103InfracperDto> getInfracPersonaCount(String cdgoPersona);

	public List<GetInfractionListDTO> getInfracPerList(GetInfractionParametersDTO params);

	public List<Tbasg103InfracperDto> getInfracPerCount();

	public List<Tbasg103InfracperDto> getInfracPerView(String cdgoInfrper);

	public List<Tbasg103InfracperDto> getInfracPersona(String cdgoInfrper);

	public int insertInfracPersona(GetInfractionParametersDTO bean);

	public int updateInfracPersona(GetInfractionParametersDTO bean);

	public int deleteInfracPersona(GetInfractionParametersDTO bean);

	public int updateInfrPerRefDoc(Tbasg103Infracper bean);

}
