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

import renfe.com.model.dto.Tbasg136EstudioDto;
import renfe.com.model.entity.Tbasg136Estudio;
import renfe.com.repository.Tbasg136EstudioRepository;

@Transactional
@Service
public class Tbasg136EstudioServiceImpl implements Tbasg136EstudioService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg136EstudioRepository tbasg136EstudioRepository;

	public List<Tbasg136EstudioDto> getAllTbasg136Estudio(Tbasg136EstudioDto filter) {

		logger.info("getAllTbasg136Estudio " + filter);
		if (filter == null) {
			return this.toDtos(tbasg136EstudioRepository.findAll());
		}
		return this.toDtos(tbasg136EstudioRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg136EstudioDto findByCdgoEstudio(Integer cdgoEstudio) {

		Optional<Tbasg136Estudio> tbasg136EstudioData = tbasg136EstudioRepository.findByCdgoEstudio(cdgoEstudio);

		if (tbasg136EstudioData.isPresent()) {
			return toDto(tbasg136EstudioData.get());
		}
		return null;
	}

	public Tbasg136EstudioDto createTbasg136Estudio(Tbasg136EstudioDto tbasg136EstudioDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg136Estudio dbTbasg136Estudio = new Tbasg136Estudio();
		BeanUtils.copyProperties(dbTbasg136Estudio, tbasg136EstudioDto);
		Tbasg136Estudio _tbasg136Estudio = tbasg136EstudioRepository.save(dbTbasg136Estudio);
		return toDto(_tbasg136Estudio);
	}

	public Tbasg136EstudioDto updateTbasg136Estudio(Integer cdgoEstudio, Tbasg136EstudioDto tbasg136EstudioDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg136Estudio> tbasg136EstudioData = tbasg136EstudioRepository.findById(cdgoEstudio);

		if (tbasg136EstudioData.isPresent()) {
			Tbasg136Estudio dbTbasg136Estudio = tbasg136EstudioData.get();
			BeanUtils.copyProperties(dbTbasg136Estudio, tbasg136EstudioDto);
			return toDto(tbasg136EstudioRepository.save(dbTbasg136Estudio));
		}
		return null;
	}

	public int deleteTbasg136Estudio(Integer cdgoEstudio) {

		tbasg136EstudioRepository.deleteById(cdgoEstudio);
		return 1;
	}

	public List<Tbasg136EstudioDto> findByCdgoEstudioIn(List<Integer> cdgoEstudio) {

		List<Tbasg136Estudio> tbasg136Estudios = tbasg136EstudioRepository.findByCdgoEstudioIn(cdgoEstudio);

		return toDtos(tbasg136Estudios);
	}

	public List<Tbasg136EstudioDto> getEstudioCount() {
		return toDtos(tbasg136EstudioRepository.getEstudioCount());
	}

	public List<Tbasg136EstudioDto> getEstudioListAscendente() {
		return toDtos(tbasg136EstudioRepository.getEstudioListAscendente());
	}

	public List<Tbasg136EstudioDto> getEstudioListDescendente() {
		return toDtos(tbasg136EstudioRepository.getEstudioListDescendente());
	}

	public List<Tbasg136EstudioDto> getEstudioActiveListAscendente() {
		return toDtos(tbasg136EstudioRepository.getEstudioActiveListAscendente());
	}

	public List<Tbasg136EstudioDto> getEstudioActiveListDescendente() {
		return toDtos(tbasg136EstudioRepository.getEstudioActiveListDescendente());
	}

	public List<Tbasg136EstudioDto> getEstudio(String cdgoEstudio) {
		return toDtos(tbasg136EstudioRepository.getEstudio(cdgoEstudio));
	}

	public int insertEstudio(Tbasg136Estudio bean) {
		return tbasg136EstudioRepository.insertEstudio(bean);
	}

	public int updateEstudio(Tbasg136Estudio bean) {
		return tbasg136EstudioRepository.updateEstudio(bean);
	}
	
	public int estadoEstudio(Tbasg136Estudio bean) {
		return tbasg136EstudioRepository.estadoEstudio(bean);
	}

	public Tbasg136EstudioDto toDto(Tbasg136Estudio orig) {

		Tbasg136EstudioDto dest = new Tbasg136EstudioDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg136Estudio toEntity(Tbasg136EstudioDto orig) {

		Tbasg136Estudio dest = new Tbasg136Estudio();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg136EstudioDto> toDtos(List<Tbasg136Estudio> orig) {

		List<Tbasg136EstudioDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg136Estudio> toEntities(List<Tbasg136EstudioDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg136Estudio> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
