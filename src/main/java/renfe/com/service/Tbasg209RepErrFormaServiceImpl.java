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

import renfe.com.model.dto.Tbasg209RepErrFormaDto;
import renfe.com.model.entity.Tbasg209RepErrForma;
import renfe.com.repository.Tbasg209RepErrFormaRepository;

@Transactional
@Service
public class Tbasg209RepErrFormaServiceImpl implements Tbasg209RepErrFormaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg209RepErrFormaRepository tbasg209RepErrFormaRepository;

	public List<Tbasg209RepErrFormaDto> getAllTbasg209RepErrForma(Tbasg209RepErrFormaDto filter) {

		logger.info("getAllTbasg209RepErrForma " + filter);
		if (filter == null) {
			return this.toDtos(tbasg209RepErrFormaRepository.findAll());
		}
		return this.toDtos(tbasg209RepErrFormaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg209RepErrFormaDto findByCdgoReprocesado(Integer cdgoReprocesado) {

		Optional<Tbasg209RepErrForma> tbasg209RepErrFormaData = tbasg209RepErrFormaRepository
				.findByCdgoReprocesado(cdgoReprocesado);

		if (tbasg209RepErrFormaData.isPresent()) {
			return toDto(tbasg209RepErrFormaData.get());
		}
		return null;
	}

	public Tbasg209RepErrFormaDto createTbasg209RepErrForma(Tbasg209RepErrFormaDto tbasg209RepErrFormaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg209RepErrForma dbTbasg209RepErrForma = new Tbasg209RepErrForma();
		BeanUtils.copyProperties(dbTbasg209RepErrForma, tbasg209RepErrFormaDto);
		Tbasg209RepErrForma _tbasg209RepErrForma = tbasg209RepErrFormaRepository.save(dbTbasg209RepErrForma);
		return toDto(_tbasg209RepErrForma);
	}

	public Tbasg209RepErrFormaDto updateTbasg209RepErrForma(Integer cdgoReprocesado,
			Tbasg209RepErrFormaDto tbasg209RepErrFormaDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg209RepErrForma> tbasg209RepErrFormaData = tbasg209RepErrFormaRepository.findById(cdgoReprocesado);

		if (tbasg209RepErrFormaData.isPresent()) {
			Tbasg209RepErrForma dbTbasg209RepErrForma = tbasg209RepErrFormaData.get();
			BeanUtils.copyProperties(dbTbasg209RepErrForma, tbasg209RepErrFormaDto);
			return toDto(tbasg209RepErrFormaRepository.save(dbTbasg209RepErrForma));
		}
		return null;
	}

	public int deleteTbasg209RepErrForma(Integer cdgoReprocesado) {

		tbasg209RepErrFormaRepository.deleteById(cdgoReprocesado);
		return 1;
	}

	public List<Tbasg209RepErrFormaDto> findByCdgoReprocesadoIn(List<Integer> cdgoReprocesado) {

		List<Tbasg209RepErrForma> tbasg209RepErrFormas = tbasg209RepErrFormaRepository
				.findByCdgoReprocesadoIn(cdgoReprocesado);

		return toDtos(tbasg209RepErrFormas);
	}

	public int insertRepErrForma(Tbasg209RepErrForma bean) {
		return tbasg209RepErrFormaRepository.insertRepErrForma(bean);
	}

	public Tbasg209RepErrFormaDto toDto(Tbasg209RepErrForma orig) {

		Tbasg209RepErrFormaDto dest = new Tbasg209RepErrFormaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg209RepErrForma toEntity(Tbasg209RepErrFormaDto orig) {

		Tbasg209RepErrForma dest = new Tbasg209RepErrForma();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg209RepErrFormaDto> toDtos(List<Tbasg209RepErrForma> orig) {

		List<Tbasg209RepErrFormaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg209RepErrForma> toEntities(List<Tbasg209RepErrFormaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg209RepErrForma> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
