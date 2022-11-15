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

import renfe.com.model.dto.Tbasg168AnotacionInspectorDto;
import renfe.com.model.entity.Tbasg168AnotacionInspector;
import renfe.com.repository.Tbasg168AnotacionInspectorRepository;

@Service
public class Tbasg168AnotacionInspectorServiceImpl implements Tbasg168AnotacionInspectorService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg168AnotacionInspectorRepository tbasg168AnotacionInspectorRepository;

	public List<Tbasg168AnotacionInspectorDto> getAllTbasg168AnotacionInspector(Tbasg168AnotacionInspectorDto filter) {

		logger.info("getAllTbasg168AnotacionInspector " + filter);
		if (filter == null) {
			return this.toDtos(tbasg168AnotacionInspectorRepository.findAll());
		}
		return this.toDtos(tbasg168AnotacionInspectorRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg168AnotacionInspectorDto findByCdgoAnotacion(Integer cdgoAnotacion) {

		Optional<Tbasg168AnotacionInspector> tbasg168AnotacionInspectorData = tbasg168AnotacionInspectorRepository
				.findByCdgoAnotacion(cdgoAnotacion);

		if (tbasg168AnotacionInspectorData.isPresent()) {
			return toDto(tbasg168AnotacionInspectorData.get());
		}
		return null;
	}

	public Tbasg168AnotacionInspectorDto createTbasg168AnotacionInspector(
			Tbasg168AnotacionInspectorDto tbasg168AnotacionInspectorDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg168AnotacionInspector dbTbasg168AnotacionInspector = new Tbasg168AnotacionInspector();
		BeanUtils.copyProperties(dbTbasg168AnotacionInspector, tbasg168AnotacionInspectorDto);
		Tbasg168AnotacionInspector _tbasg168AnotacionInspector = tbasg168AnotacionInspectorRepository
				.save(dbTbasg168AnotacionInspector);
		return toDto(_tbasg168AnotacionInspector);
	}

	public Tbasg168AnotacionInspectorDto updateTbasg168AnotacionInspector(Integer cdgoAnotacion,
			Tbasg168AnotacionInspectorDto tbasg168AnotacionInspectorDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg168AnotacionInspector> tbasg168AnotacionInspectorData = tbasg168AnotacionInspectorRepository
				.findById(cdgoAnotacion);

		if (tbasg168AnotacionInspectorData.isPresent()) {
			Tbasg168AnotacionInspector dbTbasg168AnotacionInspector = tbasg168AnotacionInspectorData.get();
			BeanUtils.copyProperties(dbTbasg168AnotacionInspector, tbasg168AnotacionInspectorDto);
			return toDto(tbasg168AnotacionInspectorRepository.save(dbTbasg168AnotacionInspector));
		}
		return null;
	}

	public int deleteTbasg168AnotacionInspector(Integer cdgoAnotacion) {

		tbasg168AnotacionInspectorRepository.deleteById(cdgoAnotacion);
		return 1;
	}

	public List<Tbasg168AnotacionInspectorDto> findByCdgoAnotacionIn(List<Integer> cdgoAnotacion) {

		List<Tbasg168AnotacionInspector> tbasg168AnotacionInspectors = tbasg168AnotacionInspectorRepository
				.findByCdgoAnotacionIn(cdgoAnotacion);

		return toDtos(tbasg168AnotacionInspectors);
	}

	public List<Tbasg168AnotacionInspectorDto> getAnotacionInspectorList() {
		return toDtos(tbasg168AnotacionInspectorRepository.getAnotacionInspectorList());
	}

	public List<Tbasg168AnotacionInspectorDto> getAnotacionInspectorListCount() {
		return toDtos(tbasg168AnotacionInspectorRepository.getAnotacionInspectorListCount());
	}

	public List<Tbasg168AnotacionInspectorDto> getAnotacionInspectorByCdgoAnotacion(String cdgoAnotacion) {
		return toDtos(tbasg168AnotacionInspectorRepository.getAnotacionInspectorByCdgoAnotacion(cdgoAnotacion));
	}

	public Tbasg168AnotacionInspectorDto toDto(Tbasg168AnotacionInspector orig) {

		Tbasg168AnotacionInspectorDto dest = new Tbasg168AnotacionInspectorDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg168AnotacionInspector toEntity(Tbasg168AnotacionInspectorDto orig) {

		Tbasg168AnotacionInspector dest = new Tbasg168AnotacionInspector();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg168AnotacionInspectorDto> toDtos(List<Tbasg168AnotacionInspector> orig) {

		List<Tbasg168AnotacionInspectorDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg168AnotacionInspector> toEntities(List<Tbasg168AnotacionInspectorDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg168AnotacionInspector> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
