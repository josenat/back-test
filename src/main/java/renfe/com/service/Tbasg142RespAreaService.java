package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetRespAreaListAscendenteDTO;
import renfe.com.model.dto.Tbasg142RespAreaDto;
import renfe.com.model.entity.Tbasg142RespArea;

public interface Tbasg142RespAreaService {

	public List<Tbasg142RespAreaDto> getAllTbasg142RespArea(Tbasg142RespAreaDto filter);

	public Tbasg142RespAreaDto findByCdgoAreact(Integer cdgoAreact);

	public Tbasg142RespAreaDto createTbasg142RespArea(Tbasg142RespAreaDto tbasg142RespAreaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg142RespAreaDto updateTbasg142RespArea(Integer cdgoAreact, Tbasg142RespAreaDto tbasg142RespAreaDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg142RespArea(Integer cdgoAreact);

	public List<Tbasg142RespAreaDto> findByCdgoAreactIn(List<Integer> cdgoAreact);

	public List<Tbasg142RespAreaDto> getRespArea(String cdgoAreact);

	public List<Tbasg142RespAreaDto> getRespAreaView(String cdgoAreact);

	public List<Tbasg142RespAreaDto> getRespAreaCount();

	public List<GetRespAreaListAscendenteDTO> getRespAreaListAscendente();

	public List<Tbasg142RespAreaDto> getRespAreaListDescendente();

	public int addRespArea(Tbasg142RespArea bean);

	public int updateRespArea(Tbasg142RespArea bean);

}
