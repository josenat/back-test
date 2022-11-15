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

import renfe.com.model.dto.Tbasg207RepErrActivDto;
import renfe.com.model.entity.Tbasg207RepErrActiv;
import renfe.com.repository.Tbasg207RepErrActivRepository;

@Transactional
@Service
public class Tbasg207RepErrActivServiceImpl implements Tbasg207RepErrActivService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg207RepErrActivRepository tbasg207RepErrActivRepository;

	public List<Tbasg207RepErrActivDto> getAllTbasg207RepErrActiv(Tbasg207RepErrActivDto filter) {

		logger.info("getAllTbasg207RepErrActiv " + filter);
		if (filter == null) {
			return this.toDtos(tbasg207RepErrActivRepository.findAll());
		}
		return this.toDtos(tbasg207RepErrActivRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg207RepErrActivDto findByCdgoReprocesado(Integer cdgoReprocesado) {

		Optional<Tbasg207RepErrActiv> tbasg207RepErrActivData = tbasg207RepErrActivRepository
				.findByCdgoReprocesado(cdgoReprocesado);

		if (tbasg207RepErrActivData.isPresent()) {
			return toDto(tbasg207RepErrActivData.get());
		}
		return null;
	}

	public Tbasg207RepErrActivDto createTbasg207RepErrActiv(Tbasg207RepErrActivDto tbasg207RepErrActivDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg207RepErrActiv dbTbasg207RepErrActiv = new Tbasg207RepErrActiv();
		BeanUtils.copyProperties(dbTbasg207RepErrActiv, tbasg207RepErrActivDto);
		Tbasg207RepErrActiv _tbasg207RepErrActiv = tbasg207RepErrActivRepository.save(dbTbasg207RepErrActiv);
		return toDto(_tbasg207RepErrActiv);
	}

	public Tbasg207RepErrActivDto updateTbasg207RepErrActiv(Integer cdgoReprocesado,
			Tbasg207RepErrActivDto tbasg207RepErrActivDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg207RepErrActiv> tbasg207RepErrActivData = tbasg207RepErrActivRepository.findById(cdgoReprocesado);

		if (tbasg207RepErrActivData.isPresent()) {
			Tbasg207RepErrActiv dbTbasg207RepErrActiv = tbasg207RepErrActivData.get();
			BeanUtils.copyProperties(dbTbasg207RepErrActiv, tbasg207RepErrActivDto);
			return toDto(tbasg207RepErrActivRepository.save(dbTbasg207RepErrActiv));
		}
		return null;
	}

	public int deleteTbasg207RepErrActiv(Integer cdgoReprocesado) {

		tbasg207RepErrActivRepository.deleteById(cdgoReprocesado);
		return 1;
	}

	public List<Tbasg207RepErrActivDto> findByCdgoReprocesadoIn(List<Integer> cdgoReprocesado) {

		List<Tbasg207RepErrActiv> tbasg207RepErrActivs = tbasg207RepErrActivRepository
				.findByCdgoReprocesadoIn(cdgoReprocesado);

		return toDtos(tbasg207RepErrActivs);
	}

	public int insertRepErrActiv(Tbasg207RepErrActiv bean) {
		return tbasg207RepErrActivRepository.insertRepErrActiv(bean);
	}

	public Tbasg207RepErrActivDto toDto(Tbasg207RepErrActiv orig) {

		Tbasg207RepErrActivDto dest = new Tbasg207RepErrActivDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg207RepErrActiv toEntity(Tbasg207RepErrActivDto orig) {

		Tbasg207RepErrActiv dest = new Tbasg207RepErrActiv();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg207RepErrActivDto> toDtos(List<Tbasg207RepErrActiv> orig) {

		List<Tbasg207RepErrActivDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg207RepErrActiv> toEntities(List<Tbasg207RepErrActivDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg207RepErrActiv> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
