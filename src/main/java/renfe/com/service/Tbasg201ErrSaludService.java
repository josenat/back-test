package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetErrSaludDTO;
import renfe.com.dto.GetErrListParam;
import renfe.com.model.dto.Tbasg201ErrSaludDto;
import renfe.com.model.entity.Tbasg201ErrSalud;

public interface Tbasg201ErrSaludService {

	public List<Tbasg201ErrSaludDto> getAllTbasg201ErrSalud(Tbasg201ErrSaludDto filter);

	public Tbasg201ErrSaludDto findByCdgoError(Integer cdgoError);

	public Tbasg201ErrSaludDto createTbasg201ErrSalud(Tbasg201ErrSaludDto tbasg201ErrSaludDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg201ErrSaludDto updateTbasg201ErrSalud(Integer cdgoError, Tbasg201ErrSaludDto tbasg201ErrSaludDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg201ErrSalud(Integer cdgoError);

	public List<Tbasg201ErrSaludDto> findByCdgoErrorIn(List<Integer> cdgoError);

	public List<Tbasg201ErrSaludDto> getErrSaludList(GetErrListParam filter);

	public List<GetErrSaludDTO> getErrSalud(Integer cdgoError);

	public int updateErrSalud(Tbasg201ErrSalud bean);

	public int deleteErrSalud(Integer cdgoError);

}
