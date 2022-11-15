package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetDatosAcreditacionesDTO;
import renfe.com.dto.GetExpeAcreTipoValidezReciclajeDTO;
import renfe.com.dto.GetfindListAcreditaByCdgoPerDTO;
import renfe.com.model.dto.Tbasg267PlanningAccredDTO;
import renfe.com.model.dto.Tbasg267PlanningAccredParamDTO;

import renfe.com.model.entity.Tbasg267ExpedAcred;

public interface Tbasg267ExpedAcredRepositoryCustom {

	public List<GetDatosAcreditacionesDTO> getDatosAcreditaciones(String cdgoPersona);

	public List<GetfindListAcreditaByCdgoPerDTO> findListAcreditaByCdgoPer(Integer cdgoPersona);

	public List<Tbasg267PlanningAccredDTO> findDataPlanificacionAcreditaciones(Tbasg267PlanningAccredParamDTO bean);

	public List<Tbasg267ExpedAcred> getAcreditacionesPersonaList(String cdgoPersona);

	public List<Tbasg267ExpedAcred> getAcreditacionesPersonaListCount(String cdgoPersona);

	public List<Tbasg267ExpedAcred> getAcreditacion(String cdgoAcredita);

	public List<Tbasg267ExpedAcred> getAcreditacionesDeLaPersona(String cdgoPersona);
	
	public List<GetExpeAcreTipoValidezReciclajeDTO> getExpeAcreTipoValidezReciclaje(Integer cdgoAcredita);

	public int insertAcreditacion(Tbasg267ExpedAcred bean);

	public int updateAcreditacionMantenimiento(GetDatosAcreditacionesDTO bean);

	public List<Tbasg267ExpedAcred> getAcrePersonaObject(String cdgoAcredita);
	
	public List<Tbasg267ExpedAcred> getUltimaAcreditacion();
	
	public List<Tbasg267ExpedAcred> getExpeAcredValPersona(Integer cdgoPersona);
	
	public List<Tbasg267ExpedAcred> getExpeCdgoAcredita(Integer cdgoAcredita);
	
	public int updateAcreditacion(Tbasg267ExpedAcred bean);

}
