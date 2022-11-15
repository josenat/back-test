package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetDatosAcreditacionesDTO;
import renfe.com.dto.GetExpeAcreTipoValidezReciclajeDTO;
import renfe.com.dto.GetfindListAcreditaByCdgoPerDTO;
import renfe.com.model.dto.Tbasg267ExpedAcredDto;
import renfe.com.model.dto.Tbasg267PlanningAccredDTO;
import renfe.com.model.dto.Tbasg267PlanningAccredParamDTO;
import renfe.com.model.entity.Tbasg267ExpedAcred;

public interface Tbasg267ExpedAcredService {

	public List<Tbasg267ExpedAcredDto> getAllTbasg267ExpedAcred(Tbasg267ExpedAcredDto filter);

	public Tbasg267ExpedAcredDto findByCdgoAcredita(Integer cdgoAcredita);

	public Tbasg267ExpedAcredDto createTbasg267ExpedAcred(Tbasg267ExpedAcredDto tbasg267ExpedAcredDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg267ExpedAcredDto updateTbasg267ExpedAcred(Integer cdgoAcredita,
			Tbasg267ExpedAcredDto tbasg267ExpedAcredDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg267ExpedAcred(Integer cdgoAcredita);

	public List<Tbasg267ExpedAcredDto> findByCdgoAcreditaIn(List<Integer> cdgoAcredita);

	public List<GetDatosAcreditacionesDTO> getDatosAcreditaciones(String cdgoPersona);

	public List<GetfindListAcreditaByCdgoPerDTO> findListAcreditaByCdgoPer(Integer cdgoPersona);

	public List<Tbasg267PlanningAccredDTO> findDataPlanificacionAcreditaciones(Tbasg267PlanningAccredParamDTO bean);

	public List<Tbasg267ExpedAcredDto> getAcreditacionesPersonaList(String cdgoPersona);

	public List<Tbasg267ExpedAcredDto> getAcreditacionesPersonaListCount(String cdgoPersona);

	public List<Tbasg267ExpedAcredDto> getAcreditacion(String cdgoAcredita);

	public List<Tbasg267ExpedAcredDto> getAcreditacionesDeLaPersona(String cdgoPersona);

	public int insertAcreditacion(Tbasg267ExpedAcred bean);

	public int updateAcreditacionMantenimiento(GetDatosAcreditacionesDTO bean);

	public List<Tbasg267ExpedAcredDto> getAcrePersonaObject(String cdgoAcredita);
	
	public List<GetExpeAcreTipoValidezReciclajeDTO> getExpeAcreTipoValidezReciclaje(Integer cdgoAcredita);
	
	public List<Tbasg267ExpedAcredDto> getUltimaAcreditacion();
	
	public List<Tbasg267ExpedAcredDto> getExpeAcredValPersona(Integer cdgoPersona);
	
	public List<Tbasg267ExpedAcredDto> getExpeCdgoAcredita(Integer cdgoAcredita);
	
	public int updateAcreditacion(Tbasg267ExpedAcred bean);
	
	public Object getAcreditacionesActionDoExecute(Integer codPersona) throws Exception;

}
