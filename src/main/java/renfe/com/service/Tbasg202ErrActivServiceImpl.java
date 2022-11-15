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

import renfe.com.dto.GetErrActivDTO;
import renfe.com.dto.GetErrListParam;
import renfe.com.model.dto.Tbasg202ErrActivDto;
import renfe.com.model.entity.Tbasg202ErrActiv;
import renfe.com.repository.Tbasg202ErrActivRepository;

@Transactional
@Service
public class Tbasg202ErrActivServiceImpl implements Tbasg202ErrActivService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg202ErrActivRepository tbasg202ErrActivRepository;

	public List<Tbasg202ErrActivDto> getAllTbasg202ErrActiv(Tbasg202ErrActivDto filter) {

		logger.info("getAllTbasg202ErrActiv " + filter);
		if (filter == null) {
			return this.toDtos(tbasg202ErrActivRepository.findAll());
		}
		return this.toDtos(tbasg202ErrActivRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg202ErrActivDto findByCdgoError(Integer cdgoError) {

		Optional<Tbasg202ErrActiv> tbasg202ErrActivData = tbasg202ErrActivRepository.findByCdgoError(cdgoError);

		if (tbasg202ErrActivData.isPresent()) {
			return toDto(tbasg202ErrActivData.get());
		}
		return null;
	}

	public Tbasg202ErrActivDto createTbasg202ErrActiv(Tbasg202ErrActivDto tbasg202ErrActivDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg202ErrActiv dbTbasg202ErrActiv = new Tbasg202ErrActiv();
		BeanUtils.copyProperties(dbTbasg202ErrActiv, tbasg202ErrActivDto);
		Tbasg202ErrActiv _tbasg202ErrActiv = tbasg202ErrActivRepository.save(dbTbasg202ErrActiv);
		return toDto(_tbasg202ErrActiv);
	}

	public Tbasg202ErrActivDto updateTbasg202ErrActiv(Integer cdgoError, Tbasg202ErrActivDto tbasg202ErrActivDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg202ErrActiv> tbasg202ErrActivData = tbasg202ErrActivRepository.findById(cdgoError);

		if (tbasg202ErrActivData.isPresent()) {
			Tbasg202ErrActiv dbTbasg202ErrActiv = tbasg202ErrActivData.get();
			BeanUtils.copyProperties(dbTbasg202ErrActiv, tbasg202ErrActivDto);
			return toDto(tbasg202ErrActivRepository.save(dbTbasg202ErrActiv));
		}
		return null;
	}

	public int deleteTbasg202ErrActiv(Integer cdgoError) {

		tbasg202ErrActivRepository.deleteById(cdgoError);
		return 1;
	}

	public List<Tbasg202ErrActivDto> findByCdgoErrorIn(List<Integer> cdgoError) {

		List<Tbasg202ErrActiv> tbasg202ErrActivs = tbasg202ErrActivRepository.findByCdgoErrorIn(cdgoError);

		return toDtos(tbasg202ErrActivs);
	}

	public List<Tbasg202ErrActivDto> getErrActivList(GetErrListParam filter) {
		return toDtos(tbasg202ErrActivRepository.getErrActivList(filter));
	}

	public List<GetErrActivDTO> getErrActiv(Integer cdgoError) {
		return tbasg202ErrActivRepository.getErrActiv(cdgoError);
	}

	public int updateErrActiv(Tbasg202ErrActiv bean) {
		return tbasg202ErrActivRepository.updateErrActiv(bean);
	}

	public int deleteErrActiv(Integer cdgoError) {
		return tbasg202ErrActivRepository.deleteErrActiv(cdgoError);
	}

	public Tbasg202ErrActivDto toDto(Tbasg202ErrActiv orig) {

		Tbasg202ErrActivDto dest = new Tbasg202ErrActivDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg202ErrActiv toEntity(Tbasg202ErrActivDto orig) {

		Tbasg202ErrActiv dest = new Tbasg202ErrActiv();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg202ErrActivDto> toDtos(List<Tbasg202ErrActiv> orig) {

		List<Tbasg202ErrActivDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg202ErrActiv> toEntities(List<Tbasg202ErrActivDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg202ErrActiv> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
