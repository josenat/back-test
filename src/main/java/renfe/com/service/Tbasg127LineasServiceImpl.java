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

import renfe.com.model.dto.Tbasg127LineasDto;
import renfe.com.model.entity.Tbasg127Lineas;
import renfe.com.repository.Tbasg127LineasRepository;

@Transactional
@Service
public class Tbasg127LineasServiceImpl implements Tbasg127LineasService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg127LineasRepository tbasg127LineasRepository;

	public List<Tbasg127LineasDto> getAllTbasg127Lineas(Tbasg127LineasDto filter) {

		logger.info("getAllTbasg127Lineas " + filter);
		if (filter == null) {
			return this.toDtos(tbasg127LineasRepository.findAll());
		}
		return this.toDtos(tbasg127LineasRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg127LineasDto findByCdgoLinea(String cdgoLinea) {

		Optional<Tbasg127Lineas> tbasg127LineasData = tbasg127LineasRepository.findByCdgoLinea(cdgoLinea);

		if (tbasg127LineasData.isPresent()) {
			return toDto(tbasg127LineasData.get());
		}
		return null;
	}

	public Tbasg127LineasDto createTbasg127Lineas(Tbasg127LineasDto tbasg127LineasDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg127Lineas dbTbasg127Lineas = new Tbasg127Lineas();
		BeanUtils.copyProperties(dbTbasg127Lineas, tbasg127LineasDto);
		Tbasg127Lineas _tbasg127Lineas = tbasg127LineasRepository.save(dbTbasg127Lineas);
		return toDto(_tbasg127Lineas);
	}

	public Tbasg127LineasDto updateTbasg127Lineas(String cdgoLinea, Tbasg127LineasDto tbasg127LineasDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg127Lineas> tbasg127LineasData = tbasg127LineasRepository.findById(cdgoLinea);

		if (tbasg127LineasData.isPresent()) {
			Tbasg127Lineas dbTbasg127Lineas = tbasg127LineasData.get();
			BeanUtils.copyProperties(dbTbasg127Lineas, tbasg127LineasDto);
			return toDto(tbasg127LineasRepository.save(dbTbasg127Lineas));
		}
		return null;
	}

	public int deleteTbasg127Lineas(String cdgoLinea) {

		tbasg127LineasRepository.deleteById(cdgoLinea);
		return 1;
	}

	public List<Tbasg127LineasDto> findByCdgoLineaIn(List<String> cdgoLinea) {

		List<Tbasg127Lineas> tbasg127Lineass = tbasg127LineasRepository.findByCdgoLineaIn(cdgoLinea);

		return toDtos(tbasg127Lineass);
	}

	public List<Tbasg127LineasDto> getLineasCount() {
		return toDtos(tbasg127LineasRepository.getLineasCount());
	}

	public List<Tbasg127LineasDto> getLineasListAscendente() {
		return toDtos(tbasg127LineasRepository.getLineasListAscendente());
	}

	public List<Tbasg127LineasDto> getLineasListDescendente() {
		return toDtos(tbasg127LineasRepository.getLineasListDescendente());
	}

	public List<Tbasg127LineasDto> getLineasActiveListAscendente() {
		return toDtos(tbasg127LineasRepository.getLineasActiveListAscendente());
	}

	public List<Tbasg127LineasDto> getLineasActiveListDescendente() {
		return toDtos(tbasg127LineasRepository.getLineasActiveListDescendente());
	}

	public List<Tbasg127LineasDto> getLineas(String cdgoLinea) {
		return toDtos(tbasg127LineasRepository.getLineas(cdgoLinea));
	}

	public List<Tbasg127LineasDto> getAlcanceLinea(String cdgoLinea) {
		return toDtos(tbasg127LineasRepository.getAlcanceLinea(cdgoLinea));
	}

	public List<Tbasg127LineasDto> getLineasListDynamic() {
		return toDtos(tbasg127LineasRepository.getLineasListDynamic());
	}

	public int insertLineas(Tbasg127Lineas bean) {
		return tbasg127LineasRepository.insertLineas(bean);
	}

	public int updateLineas(Tbasg127Lineas bean) {
		return tbasg127LineasRepository.updateLineas(bean);
	}

	public int estadoLineas(Tbasg127Lineas bean) {
		return tbasg127LineasRepository.estadoLineas(bean);
	}
	
	public int deleteLineas(Tbasg127Lineas bean) {
		return tbasg127LineasRepository.deleteLineas(bean);
	}

	public int reactiveLineas(Tbasg127Lineas bean) {
		return tbasg127LineasRepository.reactiveLineas(bean);
	}

	public Tbasg127LineasDto toDto(Tbasg127Lineas orig) {

		Tbasg127LineasDto dest = new Tbasg127LineasDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg127Lineas toEntity(Tbasg127LineasDto orig) {

		Tbasg127Lineas dest = new Tbasg127Lineas();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg127LineasDto> toDtos(List<Tbasg127Lineas> orig) {

		List<Tbasg127LineasDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg127Lineas> toEntities(List<Tbasg127LineasDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg127Lineas> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
