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

import renfe.com.model.dto.Tbasg113SancionDto;
import renfe.com.model.entity.Tbasg113Sancion;
import renfe.com.repository.Tbasg113SancionRepository;

@Transactional
@Service
public class Tbasg113SancionServiceImpl implements Tbasg113SancionService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg113SancionRepository tbasg113SancionRepository;

	public List<Tbasg113SancionDto> getAllTbasg113Sancion(Tbasg113SancionDto filter) {

		logger.info("getAllTbasg113Sancion " + filter);
		if (filter == null) {
			return this.toDtos(tbasg113SancionRepository.findAll());
		}
		return this.toDtos(tbasg113SancionRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg113SancionDto findByCdgoSancion(Integer cdgoSancion) {

		Optional<Tbasg113Sancion> tbasg113SancionData = tbasg113SancionRepository.findByCdgoSancion(cdgoSancion);

		if (tbasg113SancionData.isPresent()) {
			return toDto(tbasg113SancionData.get());
		}
		return null;
	}

	public Tbasg113SancionDto createTbasg113Sancion(Tbasg113SancionDto tbasg113SancionDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg113Sancion dbTbasg113Sancion = new Tbasg113Sancion();
		BeanUtils.copyProperties(dbTbasg113Sancion, tbasg113SancionDto);
		Tbasg113Sancion _tbasg113Sancion = tbasg113SancionRepository.save(dbTbasg113Sancion);
		return toDto(_tbasg113Sancion);
	}

	public Tbasg113SancionDto updateTbasg113Sancion(Integer cdgoSancion, Tbasg113SancionDto tbasg113SancionDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg113Sancion> tbasg113SancionData = tbasg113SancionRepository.findById(cdgoSancion);

		if (tbasg113SancionData.isPresent()) {
			Tbasg113Sancion dbTbasg113Sancion = tbasg113SancionData.get();
			BeanUtils.copyProperties(dbTbasg113Sancion, tbasg113SancionDto);
			return toDto(tbasg113SancionRepository.save(dbTbasg113Sancion));
		}
		return null;
	}

	public int deleteTbasg113Sancion(Integer cdgoSancion) {

		tbasg113SancionRepository.deleteById(cdgoSancion);
		return 1;
	}

	public List<Tbasg113SancionDto> findByCdgoSancionIn(List<Integer> cdgoSancion) {

		List<Tbasg113Sancion> tbasg113Sancions = tbasg113SancionRepository.findByCdgoSancionIn(cdgoSancion);

		return toDtos(tbasg113Sancions);
	}

	public List<Tbasg113SancionDto> getSancionCount() {
		return toDtos(tbasg113SancionRepository.getSancionCount());
	}

	public List<Tbasg113SancionDto> getSancionActiveCount() {
		return toDtos(tbasg113SancionRepository.getSancionActiveCount());
	}

	public List<Tbasg113SancionDto> getSancionListAscendente() {
		return toDtos(tbasg113SancionRepository.getSancionListAscendente());
	}

	public List<Tbasg113SancionDto> getSancionListDescendente() {
		return toDtos(tbasg113SancionRepository.getSancionListDescendente());
	}

	public List<Tbasg113SancionDto> getSancionActiveListAscendente() {
		return toDtos(tbasg113SancionRepository.getSancionActiveListAscendente());
	}

	public List<Tbasg113SancionDto> getSancionActiveListDescendente() {
		return toDtos(tbasg113SancionRepository.getSancionActiveListDescendente());
	}

	public List<Tbasg113SancionDto> getSancion(String cdgoSancion) {
		return toDtos(tbasg113SancionRepository.getSancion(cdgoSancion));
	}

	public int insertSancion(Tbasg113Sancion bean) {
		return tbasg113SancionRepository.insertSancion(bean);
	}

	public int updateSancion(Tbasg113Sancion bean) {
		return tbasg113SancionRepository.updateSancion(bean);
	}
	
	public int estadoSancion(Tbasg113Sancion bean) {
		return tbasg113SancionRepository.estadoSancion(bean);
	}

	public Tbasg113SancionDto toDto(Tbasg113Sancion orig) {

		Tbasg113SancionDto dest = new Tbasg113SancionDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg113Sancion toEntity(Tbasg113SancionDto orig) {

		Tbasg113Sancion dest = new Tbasg113Sancion();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg113SancionDto> toDtos(List<Tbasg113Sancion> orig) {

		List<Tbasg113SancionDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg113Sancion> toEntities(List<Tbasg113SancionDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg113Sancion> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
