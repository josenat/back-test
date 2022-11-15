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

import renfe.com.model.dto.Tbasg174DocOrdenSuspClaveDto;
import renfe.com.model.entity.Tbasg174DocOrdenSuspClave;
import renfe.com.repository.Tbasg174DocOrdenSuspClaveRepository;

@Service
public class Tbasg174DocOrdenSuspClaveServiceImpl implements Tbasg174DocOrdenSuspClaveService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg174DocOrdenSuspClaveRepository tbasg174DocOrdenSuspClaveRepository;

	public List<Tbasg174DocOrdenSuspClaveDto> getAllTbasg174DocOrdenSuspClave(Tbasg174DocOrdenSuspClaveDto filter) {

		logger.info("getAllTbasg174DocOrdenSuspClave " + filter);
		if (filter == null) {
			return this.toDtos(tbasg174DocOrdenSuspClaveRepository.findAll());
		}
		return this.toDtos(tbasg174DocOrdenSuspClaveRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg174DocOrdenSuspClaveDto findByCdgoClave(Integer cdgoClave) {

		Optional<Tbasg174DocOrdenSuspClave> tbasg174DocOrdenSuspClaveData = tbasg174DocOrdenSuspClaveRepository
				.findByCdgoClave(cdgoClave);

		if (tbasg174DocOrdenSuspClaveData.isPresent()) {
			return toDto(tbasg174DocOrdenSuspClaveData.get());
		}
		return null;
	}

	public Tbasg174DocOrdenSuspClaveDto createTbasg174DocOrdenSuspClave(
			Tbasg174DocOrdenSuspClaveDto tbasg174DocOrdenSuspClaveDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg174DocOrdenSuspClave dbTbasg174DocOrdenSuspClave = new Tbasg174DocOrdenSuspClave();
		BeanUtils.copyProperties(dbTbasg174DocOrdenSuspClave, tbasg174DocOrdenSuspClaveDto);
		Tbasg174DocOrdenSuspClave _tbasg174DocOrdenSuspClave = tbasg174DocOrdenSuspClaveRepository
				.save(dbTbasg174DocOrdenSuspClave);
		return toDto(_tbasg174DocOrdenSuspClave);
	}

	public Tbasg174DocOrdenSuspClaveDto updateTbasg174DocOrdenSuspClave(Integer cdgoClave,
			Tbasg174DocOrdenSuspClaveDto tbasg174DocOrdenSuspClaveDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg174DocOrdenSuspClave> tbasg174DocOrdenSuspClaveData = tbasg174DocOrdenSuspClaveRepository
				.findById(cdgoClave);

		if (tbasg174DocOrdenSuspClaveData.isPresent()) {
			Tbasg174DocOrdenSuspClave dbTbasg174DocOrdenSuspClave = tbasg174DocOrdenSuspClaveData.get();
			BeanUtils.copyProperties(dbTbasg174DocOrdenSuspClave, tbasg174DocOrdenSuspClaveDto);
			return toDto(tbasg174DocOrdenSuspClaveRepository.save(dbTbasg174DocOrdenSuspClave));
		}
		return null;
	}

	public int deleteTbasg174DocOrdenSuspClave(Integer cdgoClave) {

		tbasg174DocOrdenSuspClaveRepository.deleteById(cdgoClave);
		return 1;
	}

	public List<Tbasg174DocOrdenSuspClaveDto> findByCdgoClaveIn(List<Integer> cdgoClave) {

		List<Tbasg174DocOrdenSuspClave> tbasg174DocOrdenSuspClaves = tbasg174DocOrdenSuspClaveRepository
				.findByCdgoClaveIn(cdgoClave);

		return toDtos(tbasg174DocOrdenSuspClaves);
	}

	public List<Tbasg174DocOrdenSuspClaveDto> getDocOrdenSuspClaveActiveList() {
		return toDtos(tbasg174DocOrdenSuspClaveRepository.getDocOrdenSuspClaveActiveList());
	}

	public Tbasg174DocOrdenSuspClaveDto toDto(Tbasg174DocOrdenSuspClave orig) {

		Tbasg174DocOrdenSuspClaveDto dest = new Tbasg174DocOrdenSuspClaveDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg174DocOrdenSuspClave toEntity(Tbasg174DocOrdenSuspClaveDto orig) {

		Tbasg174DocOrdenSuspClave dest = new Tbasg174DocOrdenSuspClave();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg174DocOrdenSuspClaveDto> toDtos(List<Tbasg174DocOrdenSuspClave> orig) {

		List<Tbasg174DocOrdenSuspClaveDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg174DocOrdenSuspClave> toEntities(List<Tbasg174DocOrdenSuspClaveDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg174DocOrdenSuspClave> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
