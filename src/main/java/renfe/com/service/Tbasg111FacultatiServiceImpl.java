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

import renfe.com.model.dto.Tbasg111FacultatiDto;
import renfe.com.model.entity.Tbasg111Facultati;
import renfe.com.repository.Tbasg111FacultatiRepository;

@Transactional
@Service
public class Tbasg111FacultatiServiceImpl implements Tbasg111FacultatiService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg111FacultatiRepository tbasg111FacultatiRepository;

	public List<Tbasg111FacultatiDto> getAllTbasg111Facultati(Tbasg111FacultatiDto filter) {

		logger.info("getAllTbasg111Facultati " + filter);
		if (filter == null) {
			return this.toDtos(tbasg111FacultatiRepository.findAll());
		}
		return this.toDtos(tbasg111FacultatiRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg111FacultatiDto findByCdgoFacult(Integer cdgoFacult) {

		Optional<Tbasg111Facultati> tbasg111FacultatiData = tbasg111FacultatiRepository.findByCdgoFacult(cdgoFacult);

		if (tbasg111FacultatiData.isPresent()) {
			return toDto(tbasg111FacultatiData.get());
		}
		return null;
	}

	public Tbasg111FacultatiDto createTbasg111Facultati(Tbasg111FacultatiDto tbasg111FacultatiDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg111Facultati dbTbasg111Facultati = new Tbasg111Facultati();
		BeanUtils.copyProperties(dbTbasg111Facultati, tbasg111FacultatiDto);
		Tbasg111Facultati _tbasg111Facultati = tbasg111FacultatiRepository.save(dbTbasg111Facultati);
		return toDto(_tbasg111Facultati);
	}

	public Tbasg111FacultatiDto updateTbasg111Facultati(Integer cdgoFacult, Tbasg111FacultatiDto tbasg111FacultatiDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg111Facultati> tbasg111FacultatiData = tbasg111FacultatiRepository.findById(cdgoFacult);

		if (tbasg111FacultatiData.isPresent()) {
			Tbasg111Facultati dbTbasg111Facultati = tbasg111FacultatiData.get();
			BeanUtils.copyProperties(dbTbasg111Facultati, tbasg111FacultatiDto);
			return toDto(tbasg111FacultatiRepository.save(dbTbasg111Facultati));
		}
		return null;
	}

	public int deleteTbasg111Facultati(Integer cdgoFacult) {

		tbasg111FacultatiRepository.deleteById(cdgoFacult);
		return 1;
	}

	public List<Tbasg111FacultatiDto> findByCdgoFacultIn(List<Integer> cdgoFacult) {

		List<Tbasg111Facultati> tbasg111Facultatis = tbasg111FacultatiRepository.findByCdgoFacultIn(cdgoFacult);

		return toDtos(tbasg111Facultatis);
	}

	public List<Tbasg111FacultatiDto> getFacultati(Integer cdgoFacult) {
		return toDtos(tbasg111FacultatiRepository.getFacultati(cdgoFacult));
	}

	public List<Tbasg111FacultatiDto> getFacultatiByNumColegiado(String desgNumcolegiado) {
		return toDtos(tbasg111FacultatiRepository.getFacultatiByNumColegiado(desgNumcolegiado));
	}

	public List<Tbasg111FacultatiDto> getFacultatiListAscendente() {
		return toDtos(tbasg111FacultatiRepository.getFacultatiListAscendente());
	}

	public List<Tbasg111FacultatiDto> getFacultatiListDescendente() {
		return toDtos(tbasg111FacultatiRepository.getFacultatiListDescendente());
	}

	public List<Tbasg111FacultatiDto> getFacultatiViewListAscendente() {
		return toDtos(tbasg111FacultatiRepository.getFacultatiViewListAscendente());
	}

	public List<Tbasg111FacultatiDto> getFacultatiViewListDescendente() {
		return toDtos(tbasg111FacultatiRepository.getFacultatiViewListDescendente());
	}

	public List<Tbasg111FacultatiDto> getFacultatiActiveListAscendente() {
		return toDtos(tbasg111FacultatiRepository.getFacultatiActiveListAscendente());
	}

	public List<Tbasg111FacultatiDto> getFacultatiActiveListAscendenteApe1Ape2Nom() {
		return toDtos(tbasg111FacultatiRepository.getFacultatiActiveListAscendenteApe1Ape2Nom());
	}

	public List<Tbasg111FacultatiDto> getFacultatiActiveListDescendente() {
		return toDtos(tbasg111FacultatiRepository.getFacultatiActiveListDescendente());
	}

	public List<Tbasg111FacultatiDto> getFacultatiCount() {
		return toDtos(tbasg111FacultatiRepository.getFacultatiCount());
	}

	public int insertFacultati(Tbasg111Facultati bean) {
		return tbasg111FacultatiRepository.insertFacultati(bean);
	}

	public int updateFacultati(Tbasg111Facultati bean) {
		return tbasg111FacultatiRepository.updateFacultati(bean);
	}
	
	public int estadoFacultati(Tbasg111Facultati bean) {
		return tbasg111FacultatiRepository.estadoFacultati(bean);
	}

	public Tbasg111FacultatiDto toDto(Tbasg111Facultati orig) {

		Tbasg111FacultatiDto dest = new Tbasg111FacultatiDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg111Facultati toEntity(Tbasg111FacultatiDto orig) {

		Tbasg111Facultati dest = new Tbasg111Facultati();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg111FacultatiDto> toDtos(List<Tbasg111Facultati> orig) {

		List<Tbasg111FacultatiDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg111Facultati> toEntities(List<Tbasg111FacultatiDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg111Facultati> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
