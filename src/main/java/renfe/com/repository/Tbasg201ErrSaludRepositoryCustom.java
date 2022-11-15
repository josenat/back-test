package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetErrSaludDTO;
import renfe.com.dto.GetErrListParam;
import renfe.com.model.entity.Tbasg201ErrSalud;

public interface Tbasg201ErrSaludRepositoryCustom {

	public List<Tbasg201ErrSalud> getErrSaludList(GetErrListParam filter);

	public List<GetErrSaludDTO> getErrSalud(Integer cdgoError);

	public int updateErrSalud(Tbasg201ErrSalud bean);

	public int deleteErrSalud(Integer cdgoError);

}
