package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetActaFormaDTO;
import renfe.com.dto.GetActasPersonaOrderByCdgoActaFormDTO;
import renfe.com.dto.GetCdgoActaFormByTitUltimoDTO;
import renfe.com.dto.GetActaformaResultDTO;
import renfe.com.model.entity.Tbasg121Actaforma;

public interface Tbasg121ActaformaRepositoryCustom {

	public List<Tbasg121Actaforma> getExpiredActaForma(String fchaCurso);

	public List<Tbasg121Actaforma> getNoExpiredActaFormaByCdgoExpedient(String cdgoExpedient, String fchaCurso);

	public List<Tbasg121Actaforma> getNoExpiredActaFormaByCdgoTit(String cdgoTit, String fchaCurso);

	public List<Tbasg121Actaforma> getActaForma(String cdgoActaform);

	public List<Tbasg121Actaforma> getActaFormaByCod(String cdgoActaform);

	public List<Tbasg121Actaforma> getActasFormaByCods();

	public List<Tbasg121Actaforma> getActaFormaList();

	public List<Tbasg121Actaforma> getActaFormaExpediente(String cdgoExpedient);

	public List<Tbasg121Actaforma> getActaFormaCount();

	public List<Tbasg121Actaforma> getActasExpediente(String cdgoExpedient);

	public List<Tbasg121Actaforma> getCdgoActaFormByExpUltimo(String cdgoExpedient);

	public List<Tbasg121Actaforma> getCdgosActasFormsByExpsUltimo();

	public List<Tbasg121Actaforma> getActaFormaByExp(String cdgoExpedient);

	public List<GetActaFormaDTO> getHistoricActaFormaPersona(Integer cdgoExpedient);

	public List<GetActaFormaDTO> getLastActaForma(Integer cdgoExpedient);

	public List<Tbasg121Actaforma> getActaFormaByTit(String cdgoTit);

	public List<Tbasg121Actaforma> getExistActaExpediente(String cdgoActaform, String cdgoExpedient);

	public List<Tbasg121Actaforma> getExistActaAcreditacion(String cdgoActaform, String cdgoAcredita);

	public List<Tbasg121Actaforma> getExistActaAcre(Tbasg121Actaforma bean);

	public List<GetCdgoActaFormByTitUltimoDTO> getCdgoActaFormByTitUltimo(Integer cdgoTit);

	public int insertActaForma(Tbasg121Actaforma bean);

	public int updateActaForma(String cdgoCurso,String descCurso, String descObserva, Integer cdgoCentrofor, String descUsuact, String mrcaActivo, Integer cdgoActaform);

	public int updateActaFormaMantenimiento(Tbasg121Actaforma bean);

	public int inactiveByCdgoActaForma(String usuAct, Integer cdgoActaform);

	public int deleteActaForma(Tbasg121Actaforma bean);

	public List<Tbasg121Actaforma> getCdgoActaFchaCursoList(String cdgoExpedient);
	
	public List<GetActasPersonaOrderByCdgoActaFormDTO> getActasPersonaOrderByCdgoActaForm(Integer cdgoPersona, Integer cdgoExpediente);

}
