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

import renfe.com.model.dto.Tbasg181BajaLineaDto;
import renfe.com.model.entity.Tbasg181BajaLinea;
import renfe.com.repository.Tbasg181BajaLineaRepository;

@Service
public class Tbasg181BajaLineaServiceImpl implements Tbasg181BajaLineaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg181BajaLineaRepository tbasg181BajaLineaRepository;

	public List<Tbasg181BajaLineaDto> getAllTbasg181BajaLinea(Tbasg181BajaLineaDto filter) {

		logger.info("getAllTbasg181BajaLinea " + filter);
		if (filter == null) {
			return this.toDtos(tbasg181BajaLineaRepository.findAll());
		}
		return this.toDtos(tbasg181BajaLineaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg181BajaLineaDto findByCdgoLinea(String cdgoLinea) {

		Optional<Tbasg181BajaLinea> tbasg181BajaLineaData = tbasg181BajaLineaRepository.findByCdgoLinea(cdgoLinea);

		if (tbasg181BajaLineaData.isPresent()) {
			return toDto(tbasg181BajaLineaData.get());
		}
		return null;
	}

	public Tbasg181BajaLineaDto createTbasg181BajaLinea(Tbasg181BajaLineaDto tbasg181BajaLineaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg181BajaLinea dbTbasg181BajaLinea = new Tbasg181BajaLinea();
		BeanUtils.copyProperties(dbTbasg181BajaLinea, tbasg181BajaLineaDto);
		Tbasg181BajaLinea _tbasg181BajaLinea = tbasg181BajaLineaRepository.save(dbTbasg181BajaLinea);
		return toDto(_tbasg181BajaLinea);
	}

	public Tbasg181BajaLineaDto updateTbasg181BajaLinea(String cdgoLinea, Tbasg181BajaLineaDto tbasg181BajaLineaDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg181BajaLinea> tbasg181BajaLineaData = tbasg181BajaLineaRepository.findById(cdgoLinea);

		if (tbasg181BajaLineaData.isPresent()) {
			Tbasg181BajaLinea dbTbasg181BajaLinea = tbasg181BajaLineaData.get();
			BeanUtils.copyProperties(dbTbasg181BajaLinea, tbasg181BajaLineaDto);
			return toDto(tbasg181BajaLineaRepository.save(dbTbasg181BajaLinea));
		}
		return null;
	}

	public int deleteTbasg181BajaLinea(String cdgoLinea) {

		tbasg181BajaLineaRepository.deleteById(cdgoLinea);
		return 1;
	}

	public List<Tbasg181BajaLineaDto> findByCdgoLineaIn(List<String> cdgoLinea) {

		List<Tbasg181BajaLinea> tbasg181BajaLineas = tbasg181BajaLineaRepository.findByCdgoLineaIn(cdgoLinea);

		return toDtos(tbasg181BajaLineas);
	}

	public List<Tbasg181BajaLineaDto> getBajaLinea(String cdgoLinea) {
		return toDtos(tbasg181BajaLineaRepository.getBajaLinea(cdgoLinea));
	}

	public int insertBajaLinea(Tbasg181BajaLinea bean) {
		return tbasg181BajaLineaRepository.insertBajaLinea(bean);
	}

	public Tbasg181BajaLineaDto toDto(Tbasg181BajaLinea orig) {

		Tbasg181BajaLineaDto dest = new Tbasg181BajaLineaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg181BajaLinea toEntity(Tbasg181BajaLineaDto orig) {

		Tbasg181BajaLinea dest = new Tbasg181BajaLinea();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg181BajaLineaDto> toDtos(List<Tbasg181BajaLinea> orig) {

		List<Tbasg181BajaLineaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg181BajaLinea> toEntities(List<Tbasg181BajaLineaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg181BajaLinea> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
