package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import renfe.com.dto.GetDiferentValuesTipoDTO;
import renfe.com.dto.InsertActaincalParamDTO;
import renfe.com.model.dto.Tbasg146ActaincalDto;
import renfe.com.model.entity.Tbasg146Actaincal;
import renfe.com.model.entity.Tbasg146ActaincalPK;
import renfe.com.repository.Tbasg146ActaincalRepository;

@Service
public class Tbasg146ActaincalServiceImpl implements Tbasg146ActaincalService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg146ActaincalRepository tbasg146ActaincalRepository;

	public List<Tbasg146ActaincalDto> getAllTbasg146Actaincal(Tbasg146ActaincalDto filter) {

		logger.info("getAllTbasg146Actaincal " + filter);
		if (filter == null) {
			return this.toDtos(tbasg146ActaincalRepository.findAll());
		}
		return this.toDtos(tbasg146ActaincalRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg146ActaincalDto findByCdgoActaformDesgTipocurso(Integer cdgoActaform, String desgTipocurso) {
		Tbasg146ActaincalPK pk = new Tbasg146ActaincalPK();
		pk.setCdgoActaform(cdgoActaform);
		pk.setDesgTipocurso(desgTipocurso);
		Optional<Tbasg146Actaincal> tbasg146ActaincalData = tbasg146ActaincalRepository.findById(pk);

		if (tbasg146ActaincalData.isPresent()) {
			return toDto(tbasg146ActaincalData.get());
		}
		return null;
	}

	public Tbasg146ActaincalDto createTbasg146Actaincal(Tbasg146ActaincalDto tbasg146ActaincalDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg146Actaincal dbTbasg146Actaincal = new Tbasg146Actaincal();
		BeanUtils.copyProperties(dbTbasg146Actaincal, tbasg146ActaincalDto);
		Tbasg146Actaincal _tbasg146Actaincal = tbasg146ActaincalRepository.save(dbTbasg146Actaincal);
		return toDto(_tbasg146Actaincal);
	}

	public Tbasg146ActaincalDto updateTbasg146Actaincal(Integer cdgoActaform, String desgTipocurso,
			Tbasg146ActaincalDto tbasg146ActaincalDto) throws IllegalAccessException, InvocationTargetException {
		Tbasg146ActaincalPK pk = new Tbasg146ActaincalPK();
		pk.setCdgoActaform(cdgoActaform);
		pk.setDesgTipocurso(desgTipocurso);
		Optional<Tbasg146Actaincal> tbasg146ActaincalData = tbasg146ActaincalRepository.findById(pk);

		if (tbasg146ActaincalData.isPresent()) {
			Tbasg146Actaincal dbTbasg146Actaincal = tbasg146ActaincalData.get();
			BeanUtils.copyProperties(dbTbasg146Actaincal, tbasg146ActaincalDto);
			return toDto(tbasg146ActaincalRepository.save(dbTbasg146Actaincal));
		}
		return null;
	}

	public int deleteTbasg146Actaincal(Integer cdgoActaform, String desgTipocurso) {
		Tbasg146ActaincalPK pk = new Tbasg146ActaincalPK();
		pk.setCdgoActaform(cdgoActaform);
		pk.setDesgTipocurso(desgTipocurso);
		tbasg146ActaincalRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg146ActaincalDto> findByCdgoActaformDesgTipocursoIn(List<Integer> cdgoActaform,
			List<String> desgTipocurso) {
		List<Tbasg146ActaincalPK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoActaform.size(); i++) {
			Tbasg146ActaincalPK newPk = new Tbasg146ActaincalPK();
			newPk.setCdgoActaform(cdgoActaform.get(i));
			newPk.setDesgTipocurso(desgTipocurso.get(i));
			pks.add(newPk);
		}
		List<Tbasg146Actaincal> tbasg146Actaincals = tbasg146ActaincalRepository.findByTbasg146actaincalpkIn(pks);

		return toDtos(tbasg146Actaincals);
	}

	public List<Tbasg146ActaincalDto> getActaInCal(String cdgoActaform, String desgTipocurso) {
		return toDtos(tbasg146ActaincalRepository.getActaInCal(cdgoActaform, desgTipocurso));
	}
	
	
	public List<GetDiferentValuesTipoDTO> getDiferentValues() {
		return tbasg146ActaincalRepository.getDiferentValues();
	}

	public List<Tbasg146ActaincalDto> getActaInCalList() {
		return toDtos(tbasg146ActaincalRepository.getActaInCalList());
	}

	public List<Tbasg146ActaincalDto> getActaInCalActaForma(String cdgoActaform) {
		return toDtos(tbasg146ActaincalRepository.getActaInCalActaForma(cdgoActaform));
	}

	public List<Tbasg146ActaincalDto> getActaInCalActaFormaMantenimiento(String cdgoActaform) {
		return toDtos(tbasg146ActaincalRepository.getActaInCalActaFormaMantenimiento(cdgoActaform));
	}

	public List<Tbasg146ActaincalDto> getActasInCalActasFormaMantenimiento() {
		return toDtos(tbasg146ActaincalRepository.getActasInCalActasFormaMantenimiento());
	}

	public List<Tbasg146ActaincalDto> getActaInCalCount() {
		return toDtos(tbasg146ActaincalRepository.getActaInCalCount());
	}

	public List<Tbasg146ActaincalDto> getActaInCalByActa(Integer cdgoActaform) {
		return tbasg146ActaincalRepository.getActaInCalByActa(cdgoActaform);
	}

	public int insertActaInCal(Tbasg146Actaincal bean) {
		return tbasg146ActaincalRepository.insertActaInCal(bean);
	}

	public int updateActaInCal(String desgTipocurso, Integer cdgoCalifi, String cdgoIdinstru, String fchaCurso, String descUsuact, String mrcaActivo, String cdgoIdexa, Integer cdgoActaform, String desgTipocursoActual) {
		return tbasg146ActaincalRepository.updateActaInCal(desgTipocurso,cdgoCalifi,cdgoIdinstru,fchaCurso,descUsuact,mrcaActivo,cdgoIdexa,cdgoActaform,desgTipocursoActual);
	}

	public int updateActaInCalMantenimiento(Tbasg146Actaincal bean) {
		return tbasg146ActaincalRepository.updateActaInCalMantenimiento(bean);
	}

	public int inactiveByCdgoActaForm(String usuAct, Integer cdgoActaform) {
		return tbasg146ActaincalRepository.inactiveByCdgoActaForm(usuAct, cdgoActaform);
	}

	public int deleteActaInCal(Tbasg146Actaincal bean) {
		return tbasg146ActaincalRepository.deleteActaInCal(bean);
	}

	public Tbasg146ActaincalDto toDto(Tbasg146Actaincal orig) {

		Tbasg146ActaincalDto dest = new Tbasg146ActaincalDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}finally {
			if(dest!=null && orig != null) {
				dest.setCdgoActaform(orig.getTbasg146actaincalpk().getCdgoActaform());
				dest.setDesgTipocurso(orig.getTbasg146actaincalpk().getDesgTipocurso());
			}
		}
		return dest;
	}

	public Tbasg146Actaincal toEntity(Tbasg146ActaincalDto orig) {

		Tbasg146Actaincal dest = new Tbasg146Actaincal();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg146ActaincalDto> toDtos(List<Tbasg146Actaincal> orig) {

		List<Tbasg146ActaincalDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg146Actaincal> toEntities(List<Tbasg146ActaincalDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg146Actaincal> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}

}
