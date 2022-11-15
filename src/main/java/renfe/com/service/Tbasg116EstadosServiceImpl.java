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

import renfe.com.model.dto.Tbasg116EstadosDto;
import renfe.com.model.entity.Tbasg116Estados;
import renfe.com.repository.Tbasg116EstadosRepository;

@Service
public class Tbasg116EstadosServiceImpl implements Tbasg116EstadosService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg116EstadosRepository tbasg116EstadosRepository;

	public List<Tbasg116EstadosDto> getAllTbasg116Estados(Tbasg116EstadosDto filter) {

		logger.info("getAllTbasg116Estados " + filter);
		if (filter == null) {
			return this.toDtos(tbasg116EstadosRepository.findAll());
		}
		return this.toDtos(tbasg116EstadosRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg116EstadosDto findByCdgoEstado(Integer cdgoEstado) {

		Optional<Tbasg116Estados> tbasg116EstadosData = tbasg116EstadosRepository.findByCdgoEstado(cdgoEstado);

		if (tbasg116EstadosData.isPresent()) {
			return toDto(tbasg116EstadosData.get());
		}
		return null;
	}

	public Tbasg116EstadosDto createTbasg116Estados(Tbasg116EstadosDto tbasg116EstadosDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg116Estados dbTbasg116Estados = new Tbasg116Estados();
		BeanUtils.copyProperties(dbTbasg116Estados, tbasg116EstadosDto);
		Tbasg116Estados _tbasg116Estados = tbasg116EstadosRepository.save(dbTbasg116Estados);
		return toDto(_tbasg116Estados);
	}

	public Tbasg116EstadosDto updateTbasg116Estados(Integer cdgoEstado, Tbasg116EstadosDto tbasg116EstadosDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg116Estados> tbasg116EstadosData = tbasg116EstadosRepository.findById(cdgoEstado);

		if (tbasg116EstadosData.isPresent()) {
			Tbasg116Estados dbTbasg116Estados = tbasg116EstadosData.get();
			BeanUtils.copyProperties(dbTbasg116Estados, tbasg116EstadosDto);
			return toDto(tbasg116EstadosRepository.save(dbTbasg116Estados));
		}
		return null;
	}

	public int deleteTbasg116Estados(Integer cdgoEstado) {

		tbasg116EstadosRepository.deleteById(cdgoEstado);
		return 1;
	}

	public List<Tbasg116EstadosDto> findByCdgoEstadoIn(List<Integer> cdgoEstado) {

		List<Tbasg116Estados> tbasg116Estadoss = tbasg116EstadosRepository.findByCdgoEstadoIn(cdgoEstado);

		return toDtos(tbasg116Estadoss);
	}

	public List<Tbasg116EstadosDto> getEstadosList() {
		return toDtos(tbasg116EstadosRepository.getEstadosList());
	}

	public List<Tbasg116EstadosDto> getEstadosHabilitacionListActive() {
		return toDtos(tbasg116EstadosRepository.getEstadosHabilitacionListActive());
	}
	public List<Tbasg116EstadosDto> getEstadosConduccionListActive() {
		return toDtos(tbasg116EstadosRepository.getEstadosConduccionListActive());
	}
	public List<Tbasg116EstadosDto> getEstadosListActive() {
		return toDtos(tbasg116EstadosRepository.getEstadosListActive());
	}
	public List<Tbasg116EstadosDto> getActiveStatusListForDriving() {
		return toDtos(tbasg116EstadosRepository.getActiveStatusListForDriving());
	}

	public List<Tbasg116EstadosDto> getEstado(Integer cdgoEstado) {
		return toDtos(tbasg116EstadosRepository.getEstado(cdgoEstado));
	}

	public Tbasg116EstadosDto toDto(Tbasg116Estados orig) {

		Tbasg116EstadosDto dest = new Tbasg116EstadosDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg116Estados toEntity(Tbasg116EstadosDto orig) {

		Tbasg116Estados dest = new Tbasg116Estados();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg116EstadosDto> toDtos(List<Tbasg116Estados> orig) {

		List<Tbasg116EstadosDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg116Estados> toEntities(List<Tbasg116EstadosDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg116Estados> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
