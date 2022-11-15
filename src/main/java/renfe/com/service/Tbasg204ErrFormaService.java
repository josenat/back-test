package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetErrFormaDTO;
import renfe.com.dto.GetErrListParam;
import renfe.com.model.dto.Tbasg204ErrFormaDto;
import renfe.com.model.entity.Tbasg204ErrForma;

public interface Tbasg204ErrFormaService {

	public List<Tbasg204ErrFormaDto> getAllTbasg204ErrForma(Tbasg204ErrFormaDto filter);

	public Tbasg204ErrFormaDto findByCdgoError(Integer cdgoError);

	public Tbasg204ErrFormaDto createTbasg204ErrForma(Tbasg204ErrFormaDto tbasg204ErrFormaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg204ErrFormaDto updateTbasg204ErrForma(Integer cdgoError, Tbasg204ErrFormaDto tbasg204ErrFormaDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg204ErrForma(Integer cdgoError);

	public List<Tbasg204ErrFormaDto> findByCdgoErrorIn(List<Integer> cdgoError);

	public List<Tbasg204ErrFormaDto> getErrFormaList(GetErrListParam filter);

	public List<Tbasg204ErrFormaDto> getErrFormaList2();

	public List<GetErrFormaDTO> getErrForma(Integer cdgoError);

	public int updateErrForma(Tbasg204ErrForma bean);

	public int deleteErrForma(Integer cdgoError);

}
