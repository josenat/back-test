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

import renfe.com.model.dto.Tbasg193DocInfrArtSuspenDto;
import renfe.com.model.entity.Tbasg193DocInfrArtSuspen;
import renfe.com.repository.Tbasg193DocInfrArtSuspenRepository;

@Service
public class Tbasg193DocInfrArtSuspenServiceImpl implements Tbasg193DocInfrArtSuspenService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg193DocInfrArtSuspenRepository tbasg193DocInfrArtSuspenRepository;

	public List<Tbasg193DocInfrArtSuspenDto> getAllTbasg193DocInfrArtSuspen(Tbasg193DocInfrArtSuspenDto filter) {

		logger.info("getAllTbasg193DocInfrArtSuspen " + filter);
		if (filter == null) {
			return this.toDtos(tbasg193DocInfrArtSuspenRepository.findAll());
		}
		return this.toDtos(tbasg193DocInfrArtSuspenRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg193DocInfrArtSuspenDto findByCdgoArticulo(Integer cdgoArticulo) {

		Optional<Tbasg193DocInfrArtSuspen> tbasg193DocInfrArtSuspenData = tbasg193DocInfrArtSuspenRepository
				.findByCdgoArticulo(cdgoArticulo);

		if (tbasg193DocInfrArtSuspenData.isPresent()) {
			return toDto(tbasg193DocInfrArtSuspenData.get());
		}
		return null;
	}

	public Tbasg193DocInfrArtSuspenDto createTbasg193DocInfrArtSuspen(
			Tbasg193DocInfrArtSuspenDto tbasg193DocInfrArtSuspenDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg193DocInfrArtSuspen dbTbasg193DocInfrArtSuspen = new Tbasg193DocInfrArtSuspen();
		BeanUtils.copyProperties(dbTbasg193DocInfrArtSuspen, tbasg193DocInfrArtSuspenDto);
		Tbasg193DocInfrArtSuspen _tbasg193DocInfrArtSuspen = tbasg193DocInfrArtSuspenRepository
				.save(dbTbasg193DocInfrArtSuspen);
		return toDto(_tbasg193DocInfrArtSuspen);
	}

	public Tbasg193DocInfrArtSuspenDto updateTbasg193DocInfrArtSuspen(Integer cdgoArticulo,
			Tbasg193DocInfrArtSuspenDto tbasg193DocInfrArtSuspenDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg193DocInfrArtSuspen> tbasg193DocInfrArtSuspenData = tbasg193DocInfrArtSuspenRepository
				.findById(cdgoArticulo);

		if (tbasg193DocInfrArtSuspenData.isPresent()) {
			Tbasg193DocInfrArtSuspen dbTbasg193DocInfrArtSuspen = tbasg193DocInfrArtSuspenData.get();
			BeanUtils.copyProperties(dbTbasg193DocInfrArtSuspen, tbasg193DocInfrArtSuspenDto);
			return toDto(tbasg193DocInfrArtSuspenRepository.save(dbTbasg193DocInfrArtSuspen));
		}
		return null;
	}

	public int deleteTbasg193DocInfrArtSuspen(Integer cdgoArticulo) {

		tbasg193DocInfrArtSuspenRepository.deleteById(cdgoArticulo);
		return 1;
	}

	public List<Tbasg193DocInfrArtSuspenDto> findByCdgoArticuloIn(List<Integer> cdgoArticulo) {

		List<Tbasg193DocInfrArtSuspen> tbasg193DocInfrArtSuspens = tbasg193DocInfrArtSuspenRepository
				.findByCdgoArticuloIn(cdgoArticulo);

		return toDtos(tbasg193DocInfrArtSuspens);
	}

	public List<Tbasg193DocInfrArtSuspenDto> getDocInfrArtSuspenList() {
		return toDtos(tbasg193DocInfrArtSuspenRepository.getDocInfrArtSuspenList());
	}

	public List<Tbasg193DocInfrArtSuspenDto> getDocInfrArtSuspenByCdgoArticulo(String cdgoArticulo) {
		return toDtos(tbasg193DocInfrArtSuspenRepository.getDocInfrArtSuspenByCdgoArticulo(cdgoArticulo));
	}

	public Tbasg193DocInfrArtSuspenDto toDto(Tbasg193DocInfrArtSuspen orig) {

		Tbasg193DocInfrArtSuspenDto dest = new Tbasg193DocInfrArtSuspenDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg193DocInfrArtSuspen toEntity(Tbasg193DocInfrArtSuspenDto orig) {

		Tbasg193DocInfrArtSuspen dest = new Tbasg193DocInfrArtSuspen();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg193DocInfrArtSuspenDto> toDtos(List<Tbasg193DocInfrArtSuspen> orig) {

		List<Tbasg193DocInfrArtSuspenDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg193DocInfrArtSuspen> toEntities(List<Tbasg193DocInfrArtSuspenDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg193DocInfrArtSuspen> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
