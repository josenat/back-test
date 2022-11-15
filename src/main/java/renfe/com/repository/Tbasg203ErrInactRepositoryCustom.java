package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetErrListParam;
import renfe.com.model.entity.Tbasg203ErrInact;

public interface Tbasg203ErrInactRepositoryCustom {

	public List<Tbasg203ErrInact> getErrInactList(GetErrListParam filter);

	public List<Tbasg203ErrInact> getErrInact(Integer cdgoError);

	public int updateErrInact(Tbasg203ErrInact bean);

	public int deleteErrInact(Integer cdgoError);

}
