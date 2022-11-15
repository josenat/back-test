package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetErrActivDTO;
import renfe.com.dto.GetErrListParam;
import renfe.com.model.entity.Tbasg202ErrActiv;

public interface Tbasg202ErrActivRepositoryCustom {

	public List<Tbasg202ErrActiv> getErrActivList(GetErrListParam filter);

	public List<GetErrActivDTO> getErrActiv(Integer cdgoError);

	public int updateErrActiv(Tbasg202ErrActiv bean);

	public int deleteErrActiv(Integer bean);

}
