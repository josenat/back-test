package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetErrListParam;
import renfe.com.model.dto.Tbasg203ErrInactDto;
import renfe.com.model.entity.Tbasg203ErrInact;

public interface Tbasg203ErrInactService {

	public List<Tbasg203ErrInactDto> getAllTbasg203ErrInact(Tbasg203ErrInactDto filter);

	public Tbasg203ErrInactDto findByCdgoError(Integer cdgoError);

	public Tbasg203ErrInactDto createTbasg203ErrInact(Tbasg203ErrInactDto tbasg203ErrInactDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg203ErrInactDto updateTbasg203ErrInact(Integer cdgoError, Tbasg203ErrInactDto tbasg203ErrInactDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg203ErrInact(Integer cdgoError);

	public List<Tbasg203ErrInactDto> findByCdgoErrorIn(List<Integer> cdgoError);

	public List<Tbasg203ErrInactDto> getErrInactList(GetErrListParam filter);

	public List<Tbasg203ErrInactDto> getErrInact(Integer cdgoError);

	public int updateErrInact(Tbasg203ErrInact bean);

	public int deleteErrInact(Integer cdgoError);

}
