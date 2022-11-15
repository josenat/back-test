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

import renfe.com.model.dto.Tbasg259IdiomaDto;
import renfe.com.model.entity.Tbasg259Idioma;
import renfe.com.repository.Tbasg259IdiomaRepository;

@Service
public class Tbasg259IdiomaServiceImpl implements Tbasg259IdiomaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg259IdiomaRepository tbasg259IdiomaRepository;

	public List<Tbasg259IdiomaDto> getAllTbasg259Idioma(Tbasg259IdiomaDto filter) {

		logger.info("getAllTbasg259Idioma " + filter);
		if (filter == null) {
			return this.toDtos(tbasg259IdiomaRepository.findAll());
		}
		return this.toDtos(tbasg259IdiomaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg259IdiomaDto findByCdgoIdioma(String cdgoIdioma) {

		Optional<Tbasg259Idioma> tbasg259IdiomaData = tbasg259IdiomaRepository.findByCdgoIdioma(cdgoIdioma);

		if (tbasg259IdiomaData.isPresent()) {
			return toDto(tbasg259IdiomaData.get());
		}
		return null;
	}

	public Tbasg259IdiomaDto createTbasg259Idioma(Tbasg259IdiomaDto tbasg259IdiomaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg259Idioma dbTbasg259Idioma = new Tbasg259Idioma();
		BeanUtils.copyProperties(dbTbasg259Idioma, tbasg259IdiomaDto);
		Tbasg259Idioma _tbasg259Idioma = tbasg259IdiomaRepository.save(dbTbasg259Idioma);
		return toDto(_tbasg259Idioma);
	}

	public Tbasg259IdiomaDto updateTbasg259Idioma(String cdgoIdioma, Tbasg259IdiomaDto tbasg259IdiomaDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg259Idioma> tbasg259IdiomaData = tbasg259IdiomaRepository.findById(cdgoIdioma);

		if (tbasg259IdiomaData.isPresent()) {
			Tbasg259Idioma dbTbasg259Idioma = tbasg259IdiomaData.get();
			BeanUtils.copyProperties(dbTbasg259Idioma, tbasg259IdiomaDto);
			return toDto(tbasg259IdiomaRepository.save(dbTbasg259Idioma));
		}
		return null;
	}

	public int deleteTbasg259Idioma(String cdgoIdioma) {

		tbasg259IdiomaRepository.deleteById(cdgoIdioma);
		return 1;
	}

	public List<Tbasg259IdiomaDto> findByCdgoIdiomaIn(List<String> cdgoIdioma) {

		List<Tbasg259Idioma> tbasg259Idiomas = tbasg259IdiomaRepository.findByCdgoIdiomaIn(cdgoIdioma);

		return toDtos(tbasg259Idiomas);
	}

	public List<Tbasg259IdiomaDto> getListaIdiomas() {
		return toDtos(tbasg259IdiomaRepository.getListaIdiomas());
	}

	public List<Tbasg259IdiomaDto> getListaIdiomasActivos() {
		return toDtos(tbasg259IdiomaRepository.getListaIdiomasActivos());
	}

	public Tbasg259IdiomaDto toDto(Tbasg259Idioma orig) {

		Tbasg259IdiomaDto dest = new Tbasg259IdiomaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg259Idioma toEntity(Tbasg259IdiomaDto orig) {

		Tbasg259Idioma dest = new Tbasg259Idioma();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg259IdiomaDto> toDtos(List<Tbasg259Idioma> orig) {

		List<Tbasg259IdiomaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg259Idioma> toEntities(List<Tbasg259IdiomaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg259Idioma> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
