package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetAmbitosListAscendenteDTO;
import renfe.com.model.dto.Tbasg124AmbitosDto;
import renfe.com.model.entity.Tbasg124Ambitos;

public interface Tbasg124AmbitosService {

	public List<Tbasg124AmbitosDto> getAllTbasg124Ambitos(Tbasg124AmbitosDto filter);

	public Tbasg124AmbitosDto findByCdgoAmbitos(Integer cdgoAmbitos);

	public Tbasg124AmbitosDto createTbasg124Ambitos(Tbasg124AmbitosDto tbasg124AmbitosDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg124AmbitosDto updateTbasg124Ambitos(Integer cdgoAmbitos, Tbasg124AmbitosDto tbasg124AmbitosDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg124Ambitos(Integer cdgoAmbitos);

	public List<Tbasg124AmbitosDto> findByCdgoAmbitosIn(List<Integer> cdgoAmbitos);

	public List<Tbasg124AmbitosDto> getAmbitosCount();

	public List<GetAmbitosListAscendenteDTO> getAmbitosListAscendente();

	public List<Tbasg124AmbitosDto> getAmbitosListDescendente();

	public List<GetAmbitosListAscendenteDTO> getAmbitosTipoHabListAscendente(Integer cdgoTipohab);

	public List<Tbasg124AmbitosDto> getAmbitosTipoHabListDescendente(String cdgoTipohab);

	public List<Tbasg124AmbitosDto> getAmbitosTipoHabCount(String cdgoTipohab);

	public List<Tbasg124AmbitosDto> getAmbitosActiveList();

	public List<Tbasg124AmbitosDto> getAmbitosActiveList2();

	public List<Tbasg124AmbitosDto> getAmbitos(String cdgoAmbitos);

	public List<Tbasg124AmbitosDto> getAlcanceAmbito(Integer cdgoAmbitos);

	public List<Tbasg124AmbitosDto> getAmbitosView(String cdgoAmbitos);

	public List<Tbasg124AmbitosDto> getAmbitosNombre(String desgNombre);

	public int insertAmbitos(Tbasg124Ambitos bean);

	public int updateAmbitos(Tbasg124Ambitos bean);
	
	public int estadoAmbitos(Tbasg124Ambitos bean);

}
