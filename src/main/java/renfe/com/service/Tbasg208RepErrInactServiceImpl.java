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

import renfe.com.model.dto.Tbasg208RepErrInactDto;
import renfe.com.model.entity.Tbasg208RepErrInact;
import renfe.com.repository.Tbasg208RepErrInactRepository;

@Transactional
@Service
public class Tbasg208RepErrInactServiceImpl implements Tbasg208RepErrInactService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg208RepErrInactRepository tbasg208RepErrInactRepository;

	public List<Tbasg208RepErrInactDto> getAllTbasg208RepErrInact(Tbasg208RepErrInactDto filter) {

		logger.info("getAllTbasg208RepErrInact " + filter);
		if (filter == null) {
			return this.toDtos(tbasg208RepErrInactRepository.findAll());
		}
		return this.toDtos(tbasg208RepErrInactRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg208RepErrInactDto findByCdgoReprocesado(Integer cdgoReprocesado) {

		Optional<Tbasg208RepErrInact> tbasg208RepErrInactData = tbasg208RepErrInactRepository
				.findByCdgoReprocesado(cdgoReprocesado);

		if (tbasg208RepErrInactData.isPresent()) {
			return toDto(tbasg208RepErrInactData.get());
		}
		return null;
	}

	public Tbasg208RepErrInactDto createTbasg208RepErrInact(Tbasg208RepErrInactDto tbasg208RepErrInactDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg208RepErrInact dbTbasg208RepErrInact = new Tbasg208RepErrInact();
		BeanUtils.copyProperties(dbTbasg208RepErrInact, tbasg208RepErrInactDto);
		Tbasg208RepErrInact _tbasg208RepErrInact = tbasg208RepErrInactRepository.save(dbTbasg208RepErrInact);
		return toDto(_tbasg208RepErrInact);
	}

	public Tbasg208RepErrInactDto updateTbasg208RepErrInact(Integer cdgoReprocesado,
			Tbasg208RepErrInactDto tbasg208RepErrInactDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg208RepErrInact> tbasg208RepErrInactData = tbasg208RepErrInactRepository.findById(cdgoReprocesado);

		if (tbasg208RepErrInactData.isPresent()) {
			Tbasg208RepErrInact dbTbasg208RepErrInact = tbasg208RepErrInactData.get();
			BeanUtils.copyProperties(dbTbasg208RepErrInact, tbasg208RepErrInactDto);
			return toDto(tbasg208RepErrInactRepository.save(dbTbasg208RepErrInact));
		}
		return null;
	}

	public int deleteTbasg208RepErrInact(Integer cdgoReprocesado) {

		tbasg208RepErrInactRepository.deleteById(cdgoReprocesado);
		return 1;
	}

	public List<Tbasg208RepErrInactDto> findByCdgoReprocesadoIn(List<Integer> cdgoReprocesado) {

		List<Tbasg208RepErrInact> tbasg208RepErrInacts = tbasg208RepErrInactRepository
				.findByCdgoReprocesadoIn(cdgoReprocesado);

		return toDtos(tbasg208RepErrInacts);
	}

	public int insertRepErrInact(Tbasg208RepErrInact bean) {
		return tbasg208RepErrInactRepository.insertRepErrInact(bean);
	}

	public Tbasg208RepErrInactDto toDto(Tbasg208RepErrInact orig) {

		Tbasg208RepErrInactDto dest = new Tbasg208RepErrInactDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg208RepErrInact toEntity(Tbasg208RepErrInactDto orig) {

		Tbasg208RepErrInact dest = new Tbasg208RepErrInact();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg208RepErrInactDto> toDtos(List<Tbasg208RepErrInact> orig) {

		List<Tbasg208RepErrInactDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg208RepErrInact> toEntities(List<Tbasg208RepErrInactDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg208RepErrInact> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
