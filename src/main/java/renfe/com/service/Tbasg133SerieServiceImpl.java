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

import renfe.com.model.dto.Tbasg133SerieDto;
import renfe.com.model.entity.Tbasg133Serie;
import renfe.com.repository.Tbasg133SerieRepository;

@Transactional
@Service
public class Tbasg133SerieServiceImpl implements Tbasg133SerieService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg133SerieRepository tbasg133SerieRepository;

	public List<Tbasg133SerieDto> getAllTbasg133Serie(Tbasg133SerieDto filter) {

		logger.info("getAllTbasg133Serie " + filter);
		if (filter == null) {
			return this.toDtos(tbasg133SerieRepository.findAll());
		}
		return this.toDtos(tbasg133SerieRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg133SerieDto findByCdgoSerie(String cdgoSerie) {

		Optional<Tbasg133Serie> tbasg133SerieData = tbasg133SerieRepository.findByCdgoSerie(cdgoSerie);

		if (tbasg133SerieData.isPresent()) {
			return toDto(tbasg133SerieData.get());
		}
		return null;
	}

	public Tbasg133SerieDto createTbasg133Serie(Tbasg133SerieDto tbasg133SerieDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg133Serie dbTbasg133Serie = new Tbasg133Serie();
		BeanUtils.copyProperties(dbTbasg133Serie, tbasg133SerieDto);
		Tbasg133Serie _tbasg133Serie = tbasg133SerieRepository.save(dbTbasg133Serie);
		return toDto(_tbasg133Serie);
	}

	public Tbasg133SerieDto updateTbasg133Serie(String cdgoSerie, Tbasg133SerieDto tbasg133SerieDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg133Serie> tbasg133SerieData = tbasg133SerieRepository.findById(cdgoSerie);

		if (tbasg133SerieData.isPresent()) {
			Tbasg133Serie dbTbasg133Serie = tbasg133SerieData.get();
			BeanUtils.copyProperties(dbTbasg133Serie, tbasg133SerieDto);
			return toDto(tbasg133SerieRepository.save(dbTbasg133Serie));
		}
		return null;
	}

	public int deleteTbasg133Serie(String cdgoSerie) {

		tbasg133SerieRepository.deleteById(cdgoSerie);
		return 1;
	}

	public List<Tbasg133SerieDto> findByCdgoSerieIn(List<String> cdgoSerie) {

		List<Tbasg133Serie> tbasg133Series = tbasg133SerieRepository.findByCdgoSerieIn(cdgoSerie);

		return toDtos(tbasg133Series);
	}

	public List<Tbasg133SerieDto> getSerieCount() {
		return toDtos(tbasg133SerieRepository.getSerieCount());
	}

	public List<Tbasg133SerieDto> getSerieListAscendente() {
		return toDtos(tbasg133SerieRepository.getSerieListAscendente());
	}

	public List<Tbasg133SerieDto> getSerieListDescendente() {
		return toDtos(tbasg133SerieRepository.getSerieListDescendente());
	}

	public List<Tbasg133SerieDto> getSerie(String cdgoSerie) {
		return toDtos(tbasg133SerieRepository.getSerie(cdgoSerie));
	}
	
	public List<Tbasg133SerieDto> getSerieNombre(String cdgoSerie) {
		return toDtos(tbasg133SerieRepository.getSerieNombre(cdgoSerie));
	}

	public List<Tbasg133SerieDto> getSerieByNombre(/** FIXME revisar tipo */
	Object nombre) {
		return toDtos(tbasg133SerieRepository.getSerieByNombre(nombre));
	}

	public List<Tbasg133SerieDto> getSerieListActive() {
		return toDtos(tbasg133SerieRepository.getSerieListActive());
	}
	
	public List<Tbasg133SerieDto> getSerieActiveListAscendente() {
		return toDtos(tbasg133SerieRepository.getSerieActiveListAscendente());
	}

	public int insertSerie(Tbasg133Serie bean) {
		return tbasg133SerieRepository.insertSerie(bean);
	}

	public int updateSerie(Tbasg133Serie bean) {
		return tbasg133SerieRepository.updateSerie(bean);
	}
	
	public int estadoSerie(Tbasg133Serie bean) {
		return tbasg133SerieRepository.estadoSerie(bean);
	}

	public Tbasg133SerieDto toDto(Tbasg133Serie orig) {

		Tbasg133SerieDto dest = new Tbasg133SerieDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg133Serie toEntity(Tbasg133SerieDto orig) {

		Tbasg133Serie dest = new Tbasg133Serie();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg133SerieDto> toDtos(List<Tbasg133Serie> orig) {

		List<Tbasg133SerieDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg133Serie> toEntities(List<Tbasg133SerieDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg133Serie> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}

