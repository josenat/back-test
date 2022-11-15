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

import renfe.com.model.dto.Tbasg190DocInfrOrdenanteDto;
import renfe.com.model.entity.Tbasg190DocInfrOrdenante;
import renfe.com.repository.Tbasg190DocInfrOrdenanteRepository;

@Service
public class Tbasg190DocInfrOrdenanteServiceImpl implements Tbasg190DocInfrOrdenanteService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg190DocInfrOrdenanteRepository tbasg190DocInfrOrdenanteRepository;

	public List<Tbasg190DocInfrOrdenanteDto> getAllTbasg190DocInfrOrdenante(Tbasg190DocInfrOrdenanteDto filter) {

		logger.info("getAllTbasg190DocInfrOrdenante " + filter);
		if (filter == null) {
			return this.toDtos(tbasg190DocInfrOrdenanteRepository.findAll());
		}
		return this.toDtos(tbasg190DocInfrOrdenanteRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg190DocInfrOrdenanteDto findByCdgoOrdenante(Integer cdgoOrdenante) {

		Optional<Tbasg190DocInfrOrdenante> tbasg190DocInfrOrdenanteData = tbasg190DocInfrOrdenanteRepository
				.findByCdgoOrdenante(cdgoOrdenante);

		if (tbasg190DocInfrOrdenanteData.isPresent()) {
			return toDto(tbasg190DocInfrOrdenanteData.get());
		}
		return null;
	}

	public Tbasg190DocInfrOrdenanteDto createTbasg190DocInfrOrdenante(
			Tbasg190DocInfrOrdenanteDto tbasg190DocInfrOrdenanteDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg190DocInfrOrdenante dbTbasg190DocInfrOrdenante = new Tbasg190DocInfrOrdenante();
		BeanUtils.copyProperties(dbTbasg190DocInfrOrdenante, tbasg190DocInfrOrdenanteDto);
		Tbasg190DocInfrOrdenante _tbasg190DocInfrOrdenante = tbasg190DocInfrOrdenanteRepository
				.save(dbTbasg190DocInfrOrdenante);
		return toDto(_tbasg190DocInfrOrdenante);
	}

	public Tbasg190DocInfrOrdenanteDto updateTbasg190DocInfrOrdenante(Integer cdgoOrdenante,
			Tbasg190DocInfrOrdenanteDto tbasg190DocInfrOrdenanteDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg190DocInfrOrdenante> tbasg190DocInfrOrdenanteData = tbasg190DocInfrOrdenanteRepository
				.findById(cdgoOrdenante);

		if (tbasg190DocInfrOrdenanteData.isPresent()) {
			Tbasg190DocInfrOrdenante dbTbasg190DocInfrOrdenante = tbasg190DocInfrOrdenanteData.get();
			BeanUtils.copyProperties(dbTbasg190DocInfrOrdenante, tbasg190DocInfrOrdenanteDto);
			return toDto(tbasg190DocInfrOrdenanteRepository.save(dbTbasg190DocInfrOrdenante));
		}
		return null;
	}

	public int deleteTbasg190DocInfrOrdenante(Integer cdgoOrdenante) {

		tbasg190DocInfrOrdenanteRepository.deleteById(cdgoOrdenante);
		return 1;
	}

	public List<Tbasg190DocInfrOrdenanteDto> findByCdgoOrdenanteIn(List<Integer> cdgoOrdenante) {

		List<Tbasg190DocInfrOrdenante> tbasg190DocInfrOrdenantes = tbasg190DocInfrOrdenanteRepository
				.findByCdgoOrdenanteIn(cdgoOrdenante);

		return toDtos(tbasg190DocInfrOrdenantes);
	}

	public List<Tbasg190DocInfrOrdenanteDto> getDocInfrOrdenanteList() {
		return toDtos(tbasg190DocInfrOrdenanteRepository.getDocInfrOrdenanteList());
	}

	public List<Tbasg190DocInfrOrdenanteDto> getDocInfrOrdenanteByCdgoOrdenante(String cdgoOrdenante) {
		return toDtos(tbasg190DocInfrOrdenanteRepository.getDocInfrOrdenanteByCdgoOrdenante(cdgoOrdenante));
	}

	public Tbasg190DocInfrOrdenanteDto toDto(Tbasg190DocInfrOrdenante orig) {

		Tbasg190DocInfrOrdenanteDto dest = new Tbasg190DocInfrOrdenanteDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg190DocInfrOrdenante toEntity(Tbasg190DocInfrOrdenanteDto orig) {

		Tbasg190DocInfrOrdenante dest = new Tbasg190DocInfrOrdenante();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg190DocInfrOrdenanteDto> toDtos(List<Tbasg190DocInfrOrdenante> orig) {

		List<Tbasg190DocInfrOrdenanteDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg190DocInfrOrdenante> toEntities(List<Tbasg190DocInfrOrdenanteDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg190DocInfrOrdenante> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
