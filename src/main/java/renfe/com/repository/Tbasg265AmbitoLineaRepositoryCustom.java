package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg265AmbitoLinea;

public interface Tbasg265AmbitoLineaRepositoryCustom {

	public List<Tbasg265AmbitoLinea> getListaAmbitoLineasActiv();

	public List<Tbasg265AmbitoLinea> getDescTipoAmbitoLineas(String cdgoLinea);

	public List<Tbasg265AmbitoLinea> getAmbitoLineaCount();

	public List<Tbasg265AmbitoLinea> getMaxAmbitoLinea();

	public List<Tbasg265AmbitoLinea> getAmbitoLineaListAscendente();
	
	public List<Tbasg265AmbitoLinea> getCdgoLineaAutoInc();

	public List<Tbasg265AmbitoLinea> getAmbitoLineaListDescendente();

	public List<Tbasg265AmbitoLinea> getAmbitoLinea(String cdgoLinea);

	public List<Tbasg265AmbitoLinea> getAmbitoLineaByNombre(String desgLinea);

	public List<Tbasg265AmbitoLinea> getAmbitoLineaListActive();

	public int insertAmbitoLinea(Tbasg265AmbitoLinea bean);

	public int updateAmbitoLinea(Tbasg265AmbitoLinea bean);
	
	public int estadoAmbitoLinea(Tbasg265AmbitoLinea bean);

}
