package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetCentMedicListAscCentHgadoDTO;
import renfe.com.model.entity.Tbasg108Centmedic;

public interface Tbasg108CentmedicRepositoryCustom {

	public List<Tbasg108Centmedic> getCentMedicCount();

	public List<Tbasg108Centmedic> getCentMedicViewCount();

	public List<Tbasg108Centmedic> getCentMedicListAscendente();
	
	public List<GetCentMedicListAscCentHgadoDTO> getCentMedicListAscCentHgado(Integer cdgoCenthgado);

	public List<Tbasg108Centmedic> getCentMedicListDescendente();

	public List<Tbasg108Centmedic> getCentMedicActiveListAscendente();

	public List<Tbasg108Centmedic> getCentMedicActiveListDescendente();

	public List<Tbasg108Centmedic> getCentMedic(Integer cdgoCenmed);

	public List<Tbasg108Centmedic> getCentMedicActiveListAscendenteViewCDGO_CENTMEDIC(String cdgoCenthgado);

	public List<Tbasg108Centmedic> getCentMedicActiveListDescendenteViewCDGO_CENTMEDIC(String cdgoCenthgado);

	public List<Tbasg108Centmedic> getCentMedicListAscendenteViewCDGO_CENTMEDIC(String cdgoCenthgado);

	public List<Tbasg108Centmedic> getCentMedicListDescendenteViewCDGO_CENTMEDIC(String cdgoCenthgado);

	public int insertCentMedic(Tbasg108Centmedic bean);

	public int updateCentMedic(Tbasg108Centmedic bean);
	
	public int estadoCentMedic(Tbasg108Centmedic bean);

	public int deleteCentMedicByCentHgado(Tbasg108Centmedic bean);

}
