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

import renfe.com.model.dto.Tbasg192DocInfrGerenciaterrDto;
import renfe.com.model.entity.Tbasg192DocInfrGerenciaterr;
import renfe.com.repository.Tbasg192DocInfrGerenciaterrRepository;

@Service
public class Tbasg192DocInfrGerenciaterrServiceImpl implements Tbasg192DocInfrGerenciaterrService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg192DocInfrGerenciaterrRepository tbasg192DocInfrGerenciaterrRepository;

	public List<Tbasg192DocInfrGerenciaterrDto> getAllTbasg192DocInfrGerenciaterr(
			Tbasg192DocInfrGerenciaterrDto filter) {

		logger.info("getAllTbasg192DocInfrGerenciaterr " + filter);
		if (filter == null) {
			return this.toDtos(tbasg192DocInfrGerenciaterrRepository.findAll());
		}
		return this.toDtos(tbasg192DocInfrGerenciaterrRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg192DocInfrGerenciaterrDto findByCdgoGerencia(Integer cdgoGerencia) {

		Optional<Tbasg192DocInfrGerenciaterr> tbasg192DocInfrGerenciaterrData = tbasg192DocInfrGerenciaterrRepository
				.findByCdgoGerencia(cdgoGerencia);

		if (tbasg192DocInfrGerenciaterrData.isPresent()) {
			return toDto(tbasg192DocInfrGerenciaterrData.get());
		}
		return null;
	}

	public Tbasg192DocInfrGerenciaterrDto createTbasg192DocInfrGerenciaterr(
			Tbasg192DocInfrGerenciaterrDto tbasg192DocInfrGerenciaterrDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg192DocInfrGerenciaterr dbTbasg192DocInfrGerenciaterr = new Tbasg192DocInfrGerenciaterr();
		BeanUtils.copyProperties(dbTbasg192DocInfrGerenciaterr, tbasg192DocInfrGerenciaterrDto);
		Tbasg192DocInfrGerenciaterr _tbasg192DocInfrGerenciaterr = tbasg192DocInfrGerenciaterrRepository
				.save(dbTbasg192DocInfrGerenciaterr);
		return toDto(_tbasg192DocInfrGerenciaterr);
	}

	public Tbasg192DocInfrGerenciaterrDto updateTbasg192DocInfrGerenciaterr(Integer cdgoGerencia,
			Tbasg192DocInfrGerenciaterrDto tbasg192DocInfrGerenciaterrDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg192DocInfrGerenciaterr> tbasg192DocInfrGerenciaterrData = tbasg192DocInfrGerenciaterrRepository
				.findById(cdgoGerencia);

		if (tbasg192DocInfrGerenciaterrData.isPresent()) {
			Tbasg192DocInfrGerenciaterr dbTbasg192DocInfrGerenciaterr = tbasg192DocInfrGerenciaterrData.get();
			BeanUtils.copyProperties(dbTbasg192DocInfrGerenciaterr, tbasg192DocInfrGerenciaterrDto);
			return toDto(tbasg192DocInfrGerenciaterrRepository.save(dbTbasg192DocInfrGerenciaterr));
		}
		return null;
	}

	public int deleteTbasg192DocInfrGerenciaterr(Integer cdgoGerencia) {

		tbasg192DocInfrGerenciaterrRepository.deleteById(cdgoGerencia);
		return 1;
	}

	public List<Tbasg192DocInfrGerenciaterrDto> findByCdgoGerenciaIn(List<Integer> cdgoGerencia) {

		List<Tbasg192DocInfrGerenciaterr> tbasg192DocInfrGerenciaterrs = tbasg192DocInfrGerenciaterrRepository
				.findByCdgoGerenciaIn(cdgoGerencia);

		return toDtos(tbasg192DocInfrGerenciaterrs);
	}

	public List<Tbasg192DocInfrGerenciaterrDto> getDocInfrGerenciaTerrList() {
		return toDtos(tbasg192DocInfrGerenciaterrRepository.getDocInfrGerenciaTerrList());
	}

	public List<Tbasg192DocInfrGerenciaterrDto> getDocInfrGerenciaTerrByCdgoGerencia(String cdgoGerencia) {
		return toDtos(tbasg192DocInfrGerenciaterrRepository.getDocInfrGerenciaTerrByCdgoGerencia(cdgoGerencia));
	}

	public Tbasg192DocInfrGerenciaterrDto toDto(Tbasg192DocInfrGerenciaterr orig) {

		Tbasg192DocInfrGerenciaterrDto dest = new Tbasg192DocInfrGerenciaterrDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg192DocInfrGerenciaterr toEntity(Tbasg192DocInfrGerenciaterrDto orig) {

		Tbasg192DocInfrGerenciaterr dest = new Tbasg192DocInfrGerenciaterr();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg192DocInfrGerenciaterrDto> toDtos(List<Tbasg192DocInfrGerenciaterr> orig) {

		List<Tbasg192DocInfrGerenciaterrDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg192DocInfrGerenciaterr> toEntities(List<Tbasg192DocInfrGerenciaterrDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg192DocInfrGerenciaterr> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
