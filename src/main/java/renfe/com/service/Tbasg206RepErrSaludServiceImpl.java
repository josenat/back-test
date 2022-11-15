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

import renfe.com.model.dto.Tbasg206RepErrSaludDto;
import renfe.com.model.entity.Tbasg206RepErrSalud;
import renfe.com.repository.Tbasg206RepErrSaludRepository;

@Transactional
@Service
public class Tbasg206RepErrSaludServiceImpl implements Tbasg206RepErrSaludService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg206RepErrSaludRepository tbasg206RepErrSaludRepository;

	public List<Tbasg206RepErrSaludDto> getAllTbasg206RepErrSalud(Tbasg206RepErrSaludDto filter) {

		logger.info("getAllTbasg206RepErrSalud " + filter);
		if (filter == null) {
			return this.toDtos(tbasg206RepErrSaludRepository.findAll());
		}
		return this.toDtos(tbasg206RepErrSaludRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg206RepErrSaludDto findByCdgoReprocesado(Integer cdgoReprocesado) {

		Optional<Tbasg206RepErrSalud> tbasg206RepErrSaludData = tbasg206RepErrSaludRepository
				.findByCdgoReprocesado(cdgoReprocesado);

		if (tbasg206RepErrSaludData.isPresent()) {
			return toDto(tbasg206RepErrSaludData.get());
		}
		return null;
	}

	public Tbasg206RepErrSaludDto createTbasg206RepErrSalud(Tbasg206RepErrSaludDto tbasg206RepErrSaludDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg206RepErrSalud dbTbasg206RepErrSalud = new Tbasg206RepErrSalud();
		BeanUtils.copyProperties(dbTbasg206RepErrSalud, tbasg206RepErrSaludDto);
		Tbasg206RepErrSalud _tbasg206RepErrSalud = tbasg206RepErrSaludRepository.save(dbTbasg206RepErrSalud);
		return toDto(_tbasg206RepErrSalud);
	}

	public Tbasg206RepErrSaludDto updateTbasg206RepErrSalud(Integer cdgoReprocesado,
			Tbasg206RepErrSaludDto tbasg206RepErrSaludDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg206RepErrSalud> tbasg206RepErrSaludData = tbasg206RepErrSaludRepository.findById(cdgoReprocesado);

		if (tbasg206RepErrSaludData.isPresent()) {
			Tbasg206RepErrSalud dbTbasg206RepErrSalud = tbasg206RepErrSaludData.get();
			BeanUtils.copyProperties(dbTbasg206RepErrSalud, tbasg206RepErrSaludDto);
			return toDto(tbasg206RepErrSaludRepository.save(dbTbasg206RepErrSalud));
		}
		return null;
	}

	public int deleteTbasg206RepErrSalud(Integer cdgoReprocesado) {

		tbasg206RepErrSaludRepository.deleteById(cdgoReprocesado);
		return 1;
	}

	public List<Tbasg206RepErrSaludDto> findByCdgoReprocesadoIn(List<Integer> cdgoReprocesado) {

		List<Tbasg206RepErrSalud> tbasg206RepErrSaluds = tbasg206RepErrSaludRepository
				.findByCdgoReprocesadoIn(cdgoReprocesado);

		return toDtos(tbasg206RepErrSaluds);
	}

	public int insertRepErrSalud(Tbasg206RepErrSalud bean) {
		return tbasg206RepErrSaludRepository.insertRepErrSalud(bean);
	}

	public Tbasg206RepErrSaludDto toDto(Tbasg206RepErrSalud orig) {

		Tbasg206RepErrSaludDto dest = new Tbasg206RepErrSaludDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg206RepErrSalud toEntity(Tbasg206RepErrSaludDto orig) {

		Tbasg206RepErrSalud dest = new Tbasg206RepErrSalud();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg206RepErrSaludDto> toDtos(List<Tbasg206RepErrSalud> orig) {

		List<Tbasg206RepErrSaludDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg206RepErrSalud> toEntities(List<Tbasg206RepErrSaludDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg206RepErrSalud> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
