package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetCentMedicListAscCentHgadoDTO;
import renfe.com.model.dto.Tbasg108CentmedicDto;
import renfe.com.model.entity.Tbasg108Centmedic;

public interface Tbasg108CentmedicService {

	public List<Tbasg108CentmedicDto> getAllTbasg108Centmedic(Tbasg108CentmedicDto filter);

	public Tbasg108CentmedicDto findByCdgoCenmed(Integer cdgoCenmed);

	public Tbasg108CentmedicDto createTbasg108Centmedic(Tbasg108CentmedicDto tbasg108CentmedicDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg108CentmedicDto updateTbasg108Centmedic(Integer cdgoCenmed, Tbasg108CentmedicDto tbasg108CentmedicDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg108Centmedic(Integer cdgoCenmed);

	public List<Tbasg108CentmedicDto> findByCdgoCenmedIn(List<Integer> cdgoCenmed);

	public List<Tbasg108CentmedicDto> getCentMedicCount();

	public List<Tbasg108CentmedicDto> getCentMedicViewCount();

	public List<Tbasg108CentmedicDto> getCentMedicListAscendente();
	
	public List<GetCentMedicListAscCentHgadoDTO> getCentMedicListAscCentHgado(Integer cdgoCenthgado);

	public List<Tbasg108CentmedicDto> getCentMedicListDescendente();

	public List<Tbasg108CentmedicDto> getCentMedicActiveListAscendente();

	public List<Tbasg108CentmedicDto> getCentMedicActiveListDescendente();

	public List<Tbasg108CentmedicDto> getCentMedic(Integer cdgoCenmed);

	public List<Tbasg108CentmedicDto> getCentMedicActiveListAscendenteViewCDGO_CENTMEDIC(String cdgoCenthgado);

	public List<Tbasg108CentmedicDto> getCentMedicActiveListDescendenteViewCDGO_CENTMEDIC(String cdgoCenthgado);

	public List<Tbasg108CentmedicDto> getCentMedicListAscendenteViewCDGO_CENTMEDIC(String cdgoCenthgado);

	public List<Tbasg108CentmedicDto> getCentMedicListDescendenteViewCDGO_CENTMEDIC(String cdgoCenthgado);

	public int insertCentMedic(Tbasg108Centmedic bean);

	public int updateCentMedic(Tbasg108Centmedic bean);
	
	public int estadoCentMedic(Tbasg108Centmedic bean);

	public int deleteCentMedicByCentHgado(Tbasg108Centmedic bean);

	public static Tbasg108CentmedicDto entityToDto(Tbasg108Centmedic entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
