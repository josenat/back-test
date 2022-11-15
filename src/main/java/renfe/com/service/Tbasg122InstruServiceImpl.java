package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import renfe.com.model.dto.Tbasg122InstruDto;
import renfe.com.model.entity.Tbasg122Instru;
import renfe.com.repository.Tbasg122InstruRepository;

@Transactional
@Service
public class Tbasg122InstruServiceImpl implements Tbasg122InstruService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg122InstruRepository tbasg122InstruRepository;

	public List<Tbasg122InstruDto> getAllTbasg122Instru(Tbasg122InstruDto filter) {

		logger.info("getAllTbasg122Instru " + filter);
		if (filter == null) {
			return this.toDtos(tbasg122InstruRepository.findAll());
		}
		return this.toDtos(tbasg122InstruRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg122InstruDto findByCdgoNif(String cdgoNif) {

		Optional<Tbasg122Instru> tbasg122InstruData = tbasg122InstruRepository.findByCdgoNif(cdgoNif);

		if (tbasg122InstruData.isPresent()) {
			return toDto(tbasg122InstruData.get());
		}
		return null;
	}

	public Tbasg122InstruDto createTbasg122Instru(Tbasg122InstruDto tbasg122InstruDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg122Instru dbTbasg122Instru = new Tbasg122Instru();
		BeanUtils.copyProperties(dbTbasg122Instru, tbasg122InstruDto);
		Tbasg122Instru _tbasg122Instru = tbasg122InstruRepository.save(dbTbasg122Instru);
		return toDto(_tbasg122Instru);
	}

	public Tbasg122InstruDto updateTbasg122Instru(String cdgoNif, Tbasg122InstruDto tbasg122InstruDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg122Instru> tbasg122InstruData = tbasg122InstruRepository.findById(cdgoNif);

		if (tbasg122InstruData.isPresent()) {
			Tbasg122Instru dbTbasg122Instru = tbasg122InstruData.get();
			BeanUtils.copyProperties(dbTbasg122Instru, tbasg122InstruDto);
			return toDto(tbasg122InstruRepository.save(dbTbasg122Instru));
		}
		return null;
	}

	public int deleteTbasg122Instru(String cdgoNif) {

		tbasg122InstruRepository.deleteById(cdgoNif);
		return 1;
	}

	public List<Tbasg122InstruDto> findByCdgoNifIn(List<String> cdgoNif) {

		List<Tbasg122Instru> tbasg122Instrus = tbasg122InstruRepository.findByCdgoNifIn(cdgoNif);

		return toDtos(tbasg122Instrus);
	}

	public List<Tbasg122InstruDto> getIntruForName(String desgApell1) {
		return tbasg122InstruRepository.getIntruForName(desgApell1);
	}

	public List<Tbasg122InstruDto> getInstru(String cdgoNif) {
		return toDtos(tbasg122InstruRepository.getInstru(cdgoNif));
	}

	public List<Tbasg122InstruDto> getInstruListRegistroAscendente() {
		return toDtos(tbasg122InstruRepository.getInstruListRegistroAscendente());
	}

	public List<Tbasg122InstruDto> getInstruListRegistroDescendente() {
		return toDtos(tbasg122InstruRepository.getInstruListRegistroDescendente());
	}

	public List<Tbasg122InstruDto> getInstruListAscendenteDESG_APELL1() {
		return toDtos(tbasg122InstruRepository.getInstruListAscendenteDESG_APELL1());
	}
	
	public List<Tbasg122InstruDto> getInstruListAscendente() {
		return toDtos(tbasg122InstruRepository.getInstruListAscendente());
	}

	public List<Tbasg122InstruDto> getInstruListDescendenteDESG_APELL1() {
		return toDtos(tbasg122InstruRepository.getInstruListDescendenteDESG_APELL1());
	}

	public List<Tbasg122InstruDto> getInstruListAscendenteCDGO_NIF() {
		return toDtos(tbasg122InstruRepository.getInstruListAscendenteCDGO_NIF());
	}

	public List<Tbasg122InstruDto> getInstruListDescendenteCDGO_NIF() {
		return toDtos(tbasg122InstruRepository.getInstruListDescendenteCDGO_NIF());
	}

	public List<Tbasg122InstruDto> getInstruActiveListAscendenteDESG_APELL1() {
		return toDtos(tbasg122InstruRepository.getInstruActiveListAscendenteDESG_APELL1());
	}

	public List<Tbasg122InstruDto> getInstruActiveListDescendenteDESG_APELL1() {
		return toDtos(tbasg122InstruRepository.getInstruActiveListDescendenteDESG_APELL1());
	}

	public List<Tbasg122InstruDto> getInstruActiveListAscendenteCDGO_NIF() {
		return toDtos(tbasg122InstruRepository.getInstruActiveListAscendenteCDGO_NIF());
	}

	public List<Tbasg122InstruDto> getInstruActiveListDescendenteCDGO_NIF() {
		return toDtos(tbasg122InstruRepository.getInstruActiveListDescendenteCDGO_NIF());
	}

	public List<Tbasg122InstruDto> getInstruCount() {
		return toDtos(tbasg122InstruRepository.getInstruCount());
	}

	public List<Tbasg122InstruDto> getInstruActiveListNombre() {
		return toDtos(tbasg122InstruRepository.getInstruActiveListNombre());
	}

	public List<Tbasg122InstruDto> getInstruActiveListApe1Ape2Nom() {
		return toDtos(tbasg122InstruRepository.getInstruActiveListApe1Ape2Nom());
	}
	
	public List<Tbasg122InstruDto> getExamiActiveListApe1Ape2Nom() {
		return toDtos(tbasg122InstruRepository.getExamiActiveListApe1Ape2Nom());
	}

	public List<Tbasg122InstruDto> getInstruActiveListMrcaInstru() {
		return toDtos(tbasg122InstruRepository.getInstruActiveListMrcaInstru());
	}

	public List<Tbasg122InstruDto> getExaminActiveListMrcaExamin() {
		return toDtos(tbasg122InstruRepository.getExaminActiveListMrcaExamin());
	}

	public List<Tbasg122InstruDto> existeInstruDNI(String cdgoNif) {
		return toDtos(tbasg122InstruRepository.existeInstruDNI(cdgoNif));
	}

	public int insertInstru(Tbasg122Instru bean) {
		return tbasg122InstruRepository.insertInstru(bean);
	}

	public int updateInstru(Tbasg122Instru bean) {
		return tbasg122InstruRepository.updateInstru(bean);
	}
	
	public int estadoInstru(Tbasg122Instru bean) {
		return tbasg122InstruRepository.estadoInstru(bean);
	}

	public int unDeleteInstru(Tbasg122Instru bean) {
		return tbasg122InstruRepository.unDeleteInstru(bean);
	}
	
	public Tbasg122InstruDto entityToDto(Tbasg122Instru entity) {
		return toDto(entity);
	}

	public Tbasg122InstruDto toDto(Tbasg122Instru orig) {

		Tbasg122InstruDto dest = new Tbasg122InstruDto();
		try {
			BeanUtils.copyProperties(dest, orig);
			//dest.setTbasg100Persona(Tbasg100PersonaService.entityToDto(orig.getTbasg100Persona()));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg122Instru toEntity(Tbasg122InstruDto orig) {

		Tbasg122Instru dest = new Tbasg122Instru();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg122InstruDto> toDtos(List<Tbasg122Instru> orig) {

		List<Tbasg122InstruDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg122Instru> toEntities(List<Tbasg122InstruDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg122Instru> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}

	public List<Tbasg122InstruDto> getTrainerExaminerStatus(String cdgoNif) {
		return tbasg122InstruRepository.getTrainerExaminerStatus(cdgoNif);
	}

}
