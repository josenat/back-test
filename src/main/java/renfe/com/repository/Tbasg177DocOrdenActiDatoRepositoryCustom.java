package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg177DocOrdenActiDato;

public interface Tbasg177DocOrdenActiDatoRepositoryCustom {

	public List<Tbasg177DocOrdenActiDato> getDocOrdenActiDatoActiveList(String cdgoReferenciadoc);

	public List<Tbasg177DocOrdenActiDato> getDocOrdenActiDatoList(String cdgoReferenciadoc);

	public List<Tbasg177DocOrdenActiDato> getDocOrdenActiDato(String cdgoReferenciadoc, String cdgoClave);

	public int insertDocOrdenActiDato(Tbasg177DocOrdenActiDato bean);

	public int updateDocOrdenActiDato(Tbasg177DocOrdenActiDato bean);

}
