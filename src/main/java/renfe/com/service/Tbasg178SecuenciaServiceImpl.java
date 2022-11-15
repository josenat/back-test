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

import renfe.com.model.dto.Tbasg178SecuenciaDto;
import renfe.com.model.entity.Tbasg178Secuencia;
import renfe.com.repository.Tbasg178SecuenciaRepository;

@Service
public class Tbasg178SecuenciaServiceImpl implements Tbasg178SecuenciaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg178SecuenciaRepository tbasg178SecuenciaRepository;

	public List<Tbasg178SecuenciaDto> getAllTbasg178Secuencia(Tbasg178SecuenciaDto filter) {

		logger.info("getAllTbasg178Secuencia " + filter);
		if (filter == null) {
			return this.toDtos(tbasg178SecuenciaRepository.findAll());
		}
		return this.toDtos(tbasg178SecuenciaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg178SecuenciaDto findByEntityName(String entityName) {

		Optional<Tbasg178Secuencia> tbasg178SecuenciaData = tbasg178SecuenciaRepository.findByEntityName(entityName);

		if (tbasg178SecuenciaData.isPresent()) {
			return toDto(tbasg178SecuenciaData.get());
		}
		return null;
	}

	public Tbasg178SecuenciaDto createTbasg178Secuencia(Tbasg178SecuenciaDto tbasg178SecuenciaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg178Secuencia dbTbasg178Secuencia = new Tbasg178Secuencia();
		BeanUtils.copyProperties(dbTbasg178Secuencia, tbasg178SecuenciaDto);
		Tbasg178Secuencia _tbasg178Secuencia = tbasg178SecuenciaRepository.save(dbTbasg178Secuencia);
		return toDto(_tbasg178Secuencia);
	}

	public Tbasg178SecuenciaDto updateTbasg178Secuencia(String entityName, Tbasg178SecuenciaDto tbasg178SecuenciaDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg178Secuencia> tbasg178SecuenciaData = tbasg178SecuenciaRepository.findById(entityName);

		if (tbasg178SecuenciaData.isPresent()) {
			Tbasg178Secuencia dbTbasg178Secuencia = tbasg178SecuenciaData.get();
			BeanUtils.copyProperties(dbTbasg178Secuencia, tbasg178SecuenciaDto);
			return toDto(tbasg178SecuenciaRepository.save(dbTbasg178Secuencia));
		}
		return null;
	}

	public int deleteTbasg178Secuencia(String entityName) {

		tbasg178SecuenciaRepository.deleteById(entityName);
		return 1;
	}

	public List<Tbasg178SecuenciaDto> findByEntityNameIn(List<String> entityName) {

		List<Tbasg178Secuencia> tbasg178Secuencias = tbasg178SecuenciaRepository.findByEntityNameIn(entityName);

		return toDtos(tbasg178Secuencias);
	}

	public List<Tbasg178SecuenciaDto> getSequence(String entityName) {
		return toDtos(tbasg178SecuenciaRepository.getSequence(entityName));
	}

	public int updateSequence(Tbasg178Secuencia bean) {
		return tbasg178SecuenciaRepository.updateSequence(bean);
	}

	public Tbasg178SecuenciaDto toDto(Tbasg178Secuencia orig) {

		Tbasg178SecuenciaDto dest = new Tbasg178SecuenciaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg178Secuencia toEntity(Tbasg178SecuenciaDto orig) {

		Tbasg178Secuencia dest = new Tbasg178Secuencia();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg178SecuenciaDto> toDtos(List<Tbasg178Secuencia> orig) {

		List<Tbasg178SecuenciaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg178Secuencia> toEntities(List<Tbasg178SecuenciaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg178Secuencia> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
