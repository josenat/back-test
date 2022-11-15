package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import renfe.com.dto.GetActaFormaDTO;
import renfe.com.dto.GetActasPersonaOrderByCdgoActaFormDTO;
import renfe.com.dto.GetCdgoActaFormByTitUltimoDTO;
import renfe.com.dto.GetActaformaResultDTO;
import renfe.com.model.dto.Tbasg121ActaformaDto;
import renfe.com.model.entity.Tbasg121Actaforma;
import renfe.com.repository.Tbasg121ActaformaRepository;

@Service
public class Tbasg121ActaformaServiceImpl implements Tbasg121ActaformaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg121ActaformaRepository tbasg121ActaformaRepository;

	public List<Tbasg121ActaformaDto> getAllTbasg121Actaforma(Tbasg121ActaformaDto filter) {

		logger.info("getAllTbasg121Actaforma " + filter);
		if (filter == null) {
			return this.toDtos(tbasg121ActaformaRepository.findAll());
		}
		return this.toDtos(tbasg121ActaformaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg121ActaformaDto findByCdgoActaform(Integer cdgoActaform) {

		Optional<Tbasg121Actaforma> tbasg121ActaformaData = tbasg121ActaformaRepository
				.findByCdgoActaform(cdgoActaform);

		if (tbasg121ActaformaData.isPresent()) {
			return toDto(tbasg121ActaformaData.get());
		}
		return null;
	}

	public Tbasg121ActaformaDto createTbasg121Actaforma(Tbasg121ActaformaDto tbasg121ActaformaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg121Actaforma dbTbasg121Actaforma = new Tbasg121Actaforma();
		BeanUtils.copyProperties(dbTbasg121Actaforma, tbasg121ActaformaDto);
		Tbasg121Actaforma _tbasg121Actaforma = tbasg121ActaformaRepository.save(dbTbasg121Actaforma);
		return toDto(_tbasg121Actaforma);
	}

	public Tbasg121ActaformaDto updateTbasg121Actaforma(Integer cdgoActaform, Tbasg121ActaformaDto tbasg121ActaformaDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg121Actaforma> tbasg121ActaformaData = tbasg121ActaformaRepository.findById(cdgoActaform);

		if (tbasg121ActaformaData.isPresent()) {
			Tbasg121Actaforma dbTbasg121Actaforma = tbasg121ActaformaData.get();
			BeanUtils.copyProperties(dbTbasg121Actaforma, tbasg121ActaformaDto);
			return toDto(tbasg121ActaformaRepository.save(dbTbasg121Actaforma));
		}
		return null;
	}

	public int deleteTbasg121Actaforma(Integer cdgoActaform) {

		tbasg121ActaformaRepository.deleteById(cdgoActaform);
		return 1;
	}

	public List<Tbasg121ActaformaDto> findByCdgoActaformIn(List<Integer> cdgoActaform) {

		List<Tbasg121Actaforma> tbasg121Actaformas = tbasg121ActaformaRepository.findByCdgoActaformIn(cdgoActaform);

		return toDtos(tbasg121Actaformas);
	}

	public List<Tbasg121ActaformaDto> getExpiredActaForma(String fchaCurso) {
		return toDtos(tbasg121ActaformaRepository.getExpiredActaForma(fchaCurso));
	}

	public List<Tbasg121ActaformaDto> getNoExpiredActaFormaByCdgoExpedient(String cdgoExpedient, String fchaCurso) {
		return toDtos(tbasg121ActaformaRepository.getNoExpiredActaFormaByCdgoExpedient(cdgoExpedient, fchaCurso));
	}

	public List<Tbasg121ActaformaDto> getNoExpiredActaFormaByCdgoTit(String cdgoTit, String fchaCurso) {
		return toDtos(tbasg121ActaformaRepository.getNoExpiredActaFormaByCdgoTit(cdgoTit, fchaCurso));
	}

	public List<GetActasPersonaOrderByCdgoActaFormDTO> getActasPersonaOrderByCdgoActaForm(Integer cdgoPersona, Integer cdgoExpediente) {
		return tbasg121ActaformaRepository.getActasPersonaOrderByCdgoActaForm(cdgoPersona, cdgoExpediente);
	}
	
	public List<Tbasg121ActaformaDto> getActaForma(String cdgoActaform) {
		return toDtos(tbasg121ActaformaRepository.getActaForma(cdgoActaform));
	}

	public List<Tbasg121ActaformaDto> getActaFormaByCod(String cdgoActaform) {
		return toDtos(tbasg121ActaformaRepository.getActaFormaByCod(cdgoActaform));
	}

	public List<Tbasg121ActaformaDto> getActasFormaByCods() {
		return toDtos(tbasg121ActaformaRepository.getActasFormaByCods());
	}

	public List<Tbasg121ActaformaDto> getActaFormaList() {
		return toDtos(tbasg121ActaformaRepository.getActaFormaList());
	}

	public List<Tbasg121ActaformaDto> getActaFormaExpediente(String cdgoExpedient) {
		return toDtos(tbasg121ActaformaRepository.getActaFormaExpediente(cdgoExpedient));
	}

	public List<GetActaFormaDTO> getHistoricActaFormaPersona(Integer cdgoExpedient) {
		return tbasg121ActaformaRepository.getHistoricActaFormaPersona(cdgoExpedient);
	}

	public List<GetActaFormaDTO> getLastActaForma(Integer cdgoExpedient) {
		return tbasg121ActaformaRepository.getLastActaForma(cdgoExpedient);
	}

	public List<Tbasg121ActaformaDto> getActaFormaCount() {
		return toDtos(tbasg121ActaformaRepository.getActaFormaCount());
	}

	public List<Tbasg121ActaformaDto> getActasExpediente(String cdgoExpedient) {
		return toDtos(tbasg121ActaformaRepository.getActasExpediente(cdgoExpedient));
	}

	public List<Tbasg121ActaformaDto> getCdgoActaFormByExpUltimo(String cdgoExpedient) {
		return toDtos(tbasg121ActaformaRepository.getCdgoActaFormByExpUltimo(cdgoExpedient));
	}

	public List<Tbasg121ActaformaDto> getCdgosActasFormsByExpsUltimo() {
		return toDtos(tbasg121ActaformaRepository.getCdgosActasFormsByExpsUltimo());
	}

	public List<Tbasg121ActaformaDto> getActaFormaByExp(String cdgoExpedient) {
		return toDtos(tbasg121ActaformaRepository.getActaFormaByExp(cdgoExpedient));
	}

	public List<Tbasg121ActaformaDto> getActaFormaByTit(String cdgoTit) {
		return toDtos(tbasg121ActaformaRepository.getActaFormaByTit(cdgoTit));
	}

	public List<Tbasg121ActaformaDto> getExistActaExpediente(String cdgoActaform, String cdgoExpedient) {
		return toDtos(tbasg121ActaformaRepository.getExistActaExpediente(cdgoActaform, cdgoExpedient));
	}

	public List<Tbasg121ActaformaDto> getExistActaAcreditacion(String cdgoActaform, String cdgoAcredita) {
		return toDtos(tbasg121ActaformaRepository.getExistActaAcreditacion(cdgoActaform, cdgoAcredita));
	}

	public List<Tbasg121ActaformaDto> getExistActaAcre(Tbasg121Actaforma bean) {
		return toDtos(tbasg121ActaformaRepository.getExistActaAcre(bean));
	}

	public List<GetCdgoActaFormByTitUltimoDTO> getCdgoActaFormByTitUltimo(Integer cdgoTit) {
		return tbasg121ActaformaRepository.getCdgoActaFormByTitUltimo(cdgoTit);
	}

	public int insertActaForma(Tbasg121Actaforma bean) {
		return tbasg121ActaformaRepository.insertActaForma(bean);
	}

	public int updateActaForma(String cdgoCurso,String descCurso, String descObserva, Integer cdgoCentrofor, String descUsuact, String mrcaActivo, Integer cdgoActaform) {
		return tbasg121ActaformaRepository.updateActaForma(cdgoCurso,descCurso,descObserva,cdgoCentrofor,descUsuact,mrcaActivo,cdgoActaform);
	}

	public int updateActaFormaMantenimiento(Tbasg121Actaforma bean) {
		return tbasg121ActaformaRepository.updateActaFormaMantenimiento(bean);
	}

	public int inactiveByCdgoActaForma(String usuAct,Integer cdgoActaform) {
		return tbasg121ActaformaRepository.inactiveByCdgoActaForma(usuAct, cdgoActaform);
	}

	public int deleteActaForma(Tbasg121Actaforma bean) {
		return tbasg121ActaformaRepository.deleteActaForma(bean);
	}

	public List<Tbasg121ActaformaDto> getCdgoActaFchaCursoList(String cdgoExpedient) {
		return toDtos(tbasg121ActaformaRepository.getCdgoActaFchaCursoList(cdgoExpedient));
	}

	public Tbasg121ActaformaDto toDto(Tbasg121Actaforma orig) {

		Tbasg121ActaformaDto dest = new Tbasg121ActaformaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg121Actaforma toEntity(Tbasg121ActaformaDto orig) {

		Tbasg121Actaforma dest = new Tbasg121Actaforma();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg121ActaformaDto> toDtos(List<Tbasg121Actaforma> orig) {

		List<Tbasg121ActaformaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg121Actaforma> toEntities(List<Tbasg121ActaformaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg121Actaforma> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}

}
