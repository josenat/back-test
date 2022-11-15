package renfe.com.service;

import java.util.List;

import renfe.com.dto.GetErrListParam;
import renfe.com.model.dto.Tbasg200ErrFichDto;

public interface Tbasg200ErrFichService {

	public List<Tbasg200ErrFichDto> getErrFichList(GetErrListParam filter);
	
	public List<Tbasg200ErrFichDto> getErrFich(Integer cdgoError);
}
