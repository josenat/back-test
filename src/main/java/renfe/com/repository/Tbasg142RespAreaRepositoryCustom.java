package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetRespAreaListAscendenteDTO;
import renfe.com.model.entity.Tbasg142RespArea;

public interface Tbasg142RespAreaRepositoryCustom {

	public List<Tbasg142RespArea> getRespArea(String cdgoAreact);

	public List<Tbasg142RespArea> getRespAreaView(String cdgoAreact);

	public List<Tbasg142RespArea> getRespAreaCount();

	public List<GetRespAreaListAscendenteDTO> getRespAreaListAscendente();

	public List<Tbasg142RespArea> getRespAreaListDescendente();

	public int addRespArea(Tbasg142RespArea bean);

	public int updateRespArea(Tbasg142RespArea bean);

}
