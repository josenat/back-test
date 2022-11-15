package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetErrFormaDTO;
import renfe.com.dto.GetErrListParam;
import renfe.com.model.entity.Tbasg204ErrForma;

public interface Tbasg204ErrFormaRepositoryCustom {

	public List<Tbasg204ErrForma> getErrFormaList(GetErrListParam filter);

	public List<Tbasg204ErrForma> getErrFormaList2();

	public List<GetErrFormaDTO> getErrForma(Integer cdgoError);

	public int updateErrForma(Tbasg204ErrForma bean);

	public int deleteErrForma(Integer cdgoError);

}
