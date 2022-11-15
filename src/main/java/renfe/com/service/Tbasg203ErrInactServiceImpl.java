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

import renfe.com.dto.GetErrListParam;
import renfe.com.model.dto.Tbasg203ErrInactDto;
import renfe.com.model.entity.Tbasg203ErrInact;
import renfe.com.repository.Tbasg203ErrInactRepository;

@Transactional
@Service
public class Tbasg203ErrInactServiceImpl implements Tbasg203ErrInactService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg203ErrInactRepository tbasg203ErrInactRepository;

	public List<Tbasg203ErrInactDto> getAllTbasg203ErrInact(Tbasg203ErrInactDto filter) {

		logger.info("getAllTbasg203ErrInact " + filter);
		if (filter == null) {
			return this.toDtos(tbasg203ErrInactRepository.findAll());
		}
		return this.toDtos(tbasg203ErrInactRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg203ErrInactDto findByCdgoError(Integer cdgoError) {

		Optional<Tbasg203ErrInact> tbasg203ErrInactData = tbasg203ErrInactRepository.findByCdgoError(cdgoError);

		if (tbasg203ErrInactData.isPresent()) {
			return toDto(tbasg203ErrInactData.get());
		}
		return null;
	}

	public Tbasg203ErrInactDto createTbasg203ErrInact(Tbasg203ErrInactDto tbasg203ErrInactDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg203ErrInact dbTbasg203ErrInact = new Tbasg203ErrInact();
		BeanUtils.copyProperties(dbTbasg203ErrInact, tbasg203ErrInactDto);
		Tbasg203ErrInact _tbasg203ErrInact = tbasg203ErrInactRepository.save(dbTbasg203ErrInact);
		return toDto(_tbasg203ErrInact);
	}

	public Tbasg203ErrInactDto updateTbasg203ErrInact(Integer cdgoError, Tbasg203ErrInactDto tbasg203ErrInactDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg203ErrInact> tbasg203ErrInactData = tbasg203ErrInactRepository.findById(cdgoError);

		if (tbasg203ErrInactData.isPresent()) {
			Tbasg203ErrInact dbTbasg203ErrInact = tbasg203ErrInactData.get();
			BeanUtils.copyProperties(dbTbasg203ErrInact, tbasg203ErrInactDto);
			return toDto(tbasg203ErrInactRepository.save(dbTbasg203ErrInact));
		}
		return null;
	}

	public int deleteTbasg203ErrInact(Integer cdgoError) {

		tbasg203ErrInactRepository.deleteById(cdgoError);
		return 1;
	}

	public List<Tbasg203ErrInactDto> findByCdgoErrorIn(List<Integer> cdgoError) {

		List<Tbasg203ErrInact> tbasg203ErrInacts = tbasg203ErrInactRepository.findByCdgoErrorIn(cdgoError);

		return toDtos(tbasg203ErrInacts);
	}

	public List<Tbasg203ErrInactDto> getErrInactList(GetErrListParam filter) {
		return toDtos(tbasg203ErrInactRepository.getErrInactList(filter));
	}

	public List<Tbasg203ErrInactDto> getErrInact(Integer cdgoError) {
		return toDtos(tbasg203ErrInactRepository.getErrInact(cdgoError));
	}

	public int updateErrInact(Tbasg203ErrInact bean) {
		return tbasg203ErrInactRepository.updateErrInact(bean);
	}

	public int deleteErrInact(Integer cdgoError) {
		return tbasg203ErrInactRepository.deleteErrInact(cdgoError);
	}

	public Tbasg203ErrInactDto toDto(Tbasg203ErrInact orig) {

		Tbasg203ErrInactDto dest = new Tbasg203ErrInactDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg203ErrInact toEntity(Tbasg203ErrInactDto orig) {

		Tbasg203ErrInact dest = new Tbasg203ErrInact();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg203ErrInactDto> toDtos(List<Tbasg203ErrInact> orig) {

		List<Tbasg203ErrInactDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg203ErrInact> toEntities(List<Tbasg203ErrInactDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg203ErrInact> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
