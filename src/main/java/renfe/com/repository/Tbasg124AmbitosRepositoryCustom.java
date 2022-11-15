package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetAmbitosListAscendenteDTO;
import renfe.com.model.entity.Tbasg124Ambitos;

public interface Tbasg124AmbitosRepositoryCustom {

	public List<Tbasg124Ambitos> getAmbitosCount();

	public List<GetAmbitosListAscendenteDTO> getAmbitosListAscendente();

	public List<Tbasg124Ambitos> getAmbitosListDescendente();

	public List<GetAmbitosListAscendenteDTO> getAmbitosTipoHabListAscendente(Integer cdgoTipohab);

	public List<Tbasg124Ambitos> getAmbitosTipoHabListDescendente(String cdgoTipohab);

	public List<Tbasg124Ambitos> getAmbitosTipoHabCount(String cdgoTipohab);

	public List<Tbasg124Ambitos> getAmbitosActiveList();

	public List<Tbasg124Ambitos> getAmbitosActiveList2();

	public List<Tbasg124Ambitos> getAmbitos(String cdgoAmbitos);

	public List<Tbasg124Ambitos> getAlcanceAmbito(Integer cdgoAmbitos);

	public List<Tbasg124Ambitos> getAmbitosView(String cdgoAmbitos);

	public List<Tbasg124Ambitos> getAmbitosNombre(String desgNombre);

	public int insertAmbitos(Tbasg124Ambitos bean);

	public int updateAmbitos(Tbasg124Ambitos bean);
	
	public int estadoAmbitos(Tbasg124Ambitos bean);

}
