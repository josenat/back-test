package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetErrActivDTO;
import renfe.com.dto.GetErrListParam;
import renfe.com.model.dto.Tbasg202ErrActivDto;
import renfe.com.model.entity.Tbasg202ErrActiv;

public interface Tbasg202ErrActivService {

	public List<Tbasg202ErrActivDto> getAllTbasg202ErrActiv(Tbasg202ErrActivDto filter);

	public Tbasg202ErrActivDto findByCdgoError(Integer cdgoError);

	public Tbasg202ErrActivDto createTbasg202ErrActiv(Tbasg202ErrActivDto tbasg202ErrActivDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg202ErrActivDto updateTbasg202ErrActiv(Integer cdgoError, Tbasg202ErrActivDto tbasg202ErrActivDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg202ErrActiv(Integer cdgoError);

	public List<Tbasg202ErrActivDto> findByCdgoErrorIn(List<Integer> cdgoError);

	public List<Tbasg202ErrActivDto> getErrActivList(GetErrListParam filter);

	public List<GetErrActivDTO> getErrActiv(Integer cdgoError);

	public int updateErrActiv(Tbasg202ErrActiv bean);

	public int deleteErrActiv(Integer cdgoError);

}
