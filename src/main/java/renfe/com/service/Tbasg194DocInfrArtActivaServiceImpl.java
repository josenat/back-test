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

import renfe.com.model.dto.Tbasg194DocInfrArtActivaDto;
import renfe.com.model.entity.Tbasg194DocInfrArtActiva;
import renfe.com.repository.Tbasg194DocInfrArtActivaRepository;

@Service
public class Tbasg194DocInfrArtActivaServiceImpl implements Tbasg194DocInfrArtActivaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg194DocInfrArtActivaRepository tbasg194DocInfrArtActivaRepository;

	public List<Tbasg194DocInfrArtActivaDto> getAllTbasg194DocInfrArtActiva(Tbasg194DocInfrArtActivaDto filter) {

		logger.info("getAllTbasg194DocInfrArtActiva " + filter);
		if (filter == null) {
			return this.toDtos(tbasg194DocInfrArtActivaRepository.findAll());
		}
		return this.toDtos(tbasg194DocInfrArtActivaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg194DocInfrArtActivaDto findByCdgoArticulo(Integer cdgoArticulo) {

		Optional<Tbasg194DocInfrArtActiva> tbasg194DocInfrArtActivaData = tbasg194DocInfrArtActivaRepository
				.findByCdgoArticulo(cdgoArticulo);

		if (tbasg194DocInfrArtActivaData.isPresent()) {
			return toDto(tbasg194DocInfrArtActivaData.get());
		}
		return null;
	}

	public Tbasg194DocInfrArtActivaDto createTbasg194DocInfrArtActiva(
			Tbasg194DocInfrArtActivaDto tbasg194DocInfrArtActivaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg194DocInfrArtActiva dbTbasg194DocInfrArtActiva = new Tbasg194DocInfrArtActiva();
		BeanUtils.copyProperties(dbTbasg194DocInfrArtActiva, tbasg194DocInfrArtActivaDto);
		Tbasg194DocInfrArtActiva _tbasg194DocInfrArtActiva = tbasg194DocInfrArtActivaRepository
				.save(dbTbasg194DocInfrArtActiva);
		return toDto(_tbasg194DocInfrArtActiva);
	}

	public Tbasg194DocInfrArtActivaDto updateTbasg194DocInfrArtActiva(Integer cdgoArticulo,
			Tbasg194DocInfrArtActivaDto tbasg194DocInfrArtActivaDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg194DocInfrArtActiva> tbasg194DocInfrArtActivaData = tbasg194DocInfrArtActivaRepository
				.findById(cdgoArticulo);

		if (tbasg194DocInfrArtActivaData.isPresent()) {
			Tbasg194DocInfrArtActiva dbTbasg194DocInfrArtActiva = tbasg194DocInfrArtActivaData.get();
			BeanUtils.copyProperties(dbTbasg194DocInfrArtActiva, tbasg194DocInfrArtActivaDto);
			return toDto(tbasg194DocInfrArtActivaRepository.save(dbTbasg194DocInfrArtActiva));
		}
		return null;
	}

	public int deleteTbasg194DocInfrArtActiva(Integer cdgoArticulo) {

		tbasg194DocInfrArtActivaRepository.deleteById(cdgoArticulo);
		return 1;
	}

	public List<Tbasg194DocInfrArtActivaDto> findByCdgoArticuloIn(List<Integer> cdgoArticulo) {

		List<Tbasg194DocInfrArtActiva> tbasg194DocInfrArtActivas = tbasg194DocInfrArtActivaRepository
				.findByCdgoArticuloIn(cdgoArticulo);

		return toDtos(tbasg194DocInfrArtActivas);
	}

	public List<Tbasg194DocInfrArtActivaDto> getDocInfrArtActivaList() {
		return toDtos(tbasg194DocInfrArtActivaRepository.getDocInfrArtActivaList());
	}

	public List<Tbasg194DocInfrArtActivaDto> getDocInfrArtActivaByCdgoArticulo(String cdgoArticulo) {
		return toDtos(tbasg194DocInfrArtActivaRepository.getDocInfrArtActivaByCdgoArticulo(cdgoArticulo));
	}

	public Tbasg194DocInfrArtActivaDto toDto(Tbasg194DocInfrArtActiva orig) {

		Tbasg194DocInfrArtActivaDto dest = new Tbasg194DocInfrArtActivaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg194DocInfrArtActiva toEntity(Tbasg194DocInfrArtActivaDto orig) {

		Tbasg194DocInfrArtActiva dest = new Tbasg194DocInfrArtActiva();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg194DocInfrArtActivaDto> toDtos(List<Tbasg194DocInfrArtActiva> orig) {

		List<Tbasg194DocInfrArtActivaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg194DocInfrArtActiva> toEntities(List<Tbasg194DocInfrArtActivaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg194DocInfrArtActiva> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
