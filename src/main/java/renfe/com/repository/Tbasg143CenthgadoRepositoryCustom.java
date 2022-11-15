package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetCentHgadoListAscendenteDTO;
import renfe.com.model.entity.Tbasg143Centhgado;

public interface Tbasg143CenthgadoRepositoryCustom {

	public List<Tbasg143Centhgado> getCentHgado(String cdgoCenthgado);

	public List<Tbasg143Centhgado> getActiveCentHgado(String cdgoCenthgado);

	public List<Tbasg143Centhgado> getCentHgadoByCIF(String desgCif);

	public List<Tbasg143Centhgado> getCentHgadoCount();

	public List<Tbasg143Centhgado> findByCdgoCentFor(String cdgoCentrofor);

	public List<Tbasg143Centhgado> findByCdgoCentMed(String cdgoCenmed);

	public List<GetCentHgadoListAscendenteDTO> getCentHgadoListAscendente();

	public List<Tbasg143Centhgado> getCentHgadoListDescendente();

	public List<Tbasg143Centhgado> getCentHgadoActiveListAscendente();

	public int insertCentHgado(Tbasg143Centhgado bean);

	public int updateCentHgado(Tbasg143Centhgado bean);
	
	public int estadoCentHgado(Tbasg143Centhgado bean);

	public int reactivateCentHgado(Tbasg143Centhgado bean);

}
