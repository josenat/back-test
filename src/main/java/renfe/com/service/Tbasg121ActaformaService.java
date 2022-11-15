package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetActaFormaDTO;
import renfe.com.dto.GetActasPersonaOrderByCdgoActaFormDTO;
import renfe.com.dto.GetCdgoActaFormByTitUltimoDTO;
import renfe.com.dto.GetActaformaResultDTO;
import renfe.com.model.dto.Tbasg121ActaformaDto;
import renfe.com.model.entity.Tbasg121Actaforma;

public interface Tbasg121ActaformaService {

	public List<Tbasg121ActaformaDto> getAllTbasg121Actaforma(Tbasg121ActaformaDto filter);

	public Tbasg121ActaformaDto findByCdgoActaform(Integer cdgoActaform);

	public Tbasg121ActaformaDto createTbasg121Actaforma(Tbasg121ActaformaDto tbasg121ActaformaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg121ActaformaDto updateTbasg121Actaforma(Integer cdgoActaform, Tbasg121ActaformaDto tbasg121ActaformaDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg121Actaforma(Integer cdgoActaform);

	public List<Tbasg121ActaformaDto> findByCdgoActaformIn(List<Integer> cdgoActaform);

	public List<Tbasg121ActaformaDto> getExpiredActaForma(String fchaCurso);

	public List<Tbasg121ActaformaDto> getNoExpiredActaFormaByCdgoExpedient(String cdgoExpedient, String fchaCurso);

	public List<Tbasg121ActaformaDto> getNoExpiredActaFormaByCdgoTit(String cdgoTit, String fchaCurso);

	public List<Tbasg121ActaformaDto> getActaForma(String cdgoActaform);

	public List<Tbasg121ActaformaDto> getActaFormaByCod(String cdgoActaform);

	public List<Tbasg121ActaformaDto> getActasFormaByCods();

	public List<Tbasg121ActaformaDto> getActaFormaList();

	public List<Tbasg121ActaformaDto> getActaFormaExpediente(String cdgoExpedient);

	public List<GetActaFormaDTO> getHistoricActaFormaPersona(Integer cdgoExpedient);

	public List<GetActaFormaDTO> getLastActaForma(Integer cdgoExpedient);

	public List<Tbasg121ActaformaDto> getActaFormaCount();

	public List<Tbasg121ActaformaDto> getActasExpediente(String cdgoExpedient);

	public List<Tbasg121ActaformaDto> getCdgoActaFormByExpUltimo(String cdgoExpedient);

	public List<Tbasg121ActaformaDto> getCdgosActasFormsByExpsUltimo();

	public List<Tbasg121ActaformaDto> getActaFormaByExp(String cdgoExpedient);

	public List<Tbasg121ActaformaDto> getActaFormaByTit(String cdgoTit);

	public List<Tbasg121ActaformaDto> getExistActaExpediente(String cdgoActaform, String cdgoExpedient);

	public List<Tbasg121ActaformaDto> getExistActaAcreditacion(String cdgoActaform, String cdgoAcredita);

	public List<Tbasg121ActaformaDto> getExistActaAcre(Tbasg121Actaforma bean);

	public List<GetCdgoActaFormByTitUltimoDTO> getCdgoActaFormByTitUltimo(Integer cdgoTit);

	public int insertActaForma(Tbasg121Actaforma bean);

	public int updateActaForma(String cdgoCurso,String descCurso, String descObserva, Integer cdgoCentrofor, String descUsuact, String mrcaActivo, Integer cdgoActaform);

	public int updateActaFormaMantenimiento(Tbasg121Actaforma bean);

	public int inactiveByCdgoActaForma(String usuAct,Integer cdgoActaform);

	public int deleteActaForma(Tbasg121Actaforma bean);

	public List<Tbasg121ActaformaDto> getCdgoActaFchaCursoList(String cdgoExpedient);

	public List<GetActasPersonaOrderByCdgoActaFormDTO> getActasPersonaOrderByCdgoActaForm(Integer cdgoPersona, Integer cdgoExpediente);

}
