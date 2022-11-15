package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg175DocOrdenSuspDato;

public interface Tbasg175DocOrdenSuspDatoRepositoryCustom {

	public List<Tbasg175DocOrdenSuspDato> getDocOrdenSuspDatoActiveList(String cdgoReferenciadoc);

	public List<Tbasg175DocOrdenSuspDato> getDocOrdenSuspDatoList(String cdgoReferenciadoc);

	public List<Tbasg175DocOrdenSuspDato> getDocOrdenSuspDato(String cdgoReferenciadoc, String cdgoClave);

	public int insertDocOrdenSuspDato(Tbasg175DocOrdenSuspDato bean);

	public int updateDocOrdenSuspDato(Tbasg175DocOrdenSuspDato bean);

}
