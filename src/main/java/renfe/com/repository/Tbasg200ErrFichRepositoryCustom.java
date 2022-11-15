package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetErrListParam;
import renfe.com.model.entity.Tbasg200ErrFich;

public interface Tbasg200ErrFichRepositoryCustom {

	public List<Tbasg200ErrFich> getErrFichList(GetErrListParam filter);
	
	public List<Tbasg200ErrFich> getErrFich(Integer cdgoError);
}
