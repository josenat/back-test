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

import renfe.com.model.dto.Tbasg176DocOrdenActiClaveDto;
import renfe.com.model.entity.Tbasg176DocOrdenActiClave;
import renfe.com.repository.Tbasg176DocOrdenActiClaveRepository;

@Service
public class Tbasg176DocOrdenActiClaveServiceImpl implements Tbasg176DocOrdenActiClaveService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg176DocOrdenActiClaveRepository tbasg176DocOrdenActiClaveRepository;

	public List<Tbasg176DocOrdenActiClaveDto> getAllTbasg176DocOrdenActiClave(Tbasg176DocOrdenActiClaveDto filter) {

		logger.info("getAllTbasg176DocOrdenActiClave " + filter);
		if (filter == null) {
			return this.toDtos(tbasg176DocOrdenActiClaveRepository.findAll());
		}
		return this.toDtos(tbasg176DocOrdenActiClaveRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg176DocOrdenActiClaveDto findByCdgoClave(Integer cdgoClave) {

		Optional<Tbasg176DocOrdenActiClave> tbasg176DocOrdenActiClaveData = tbasg176DocOrdenActiClaveRepository
				.findByCdgoClave(cdgoClave);

		if (tbasg176DocOrdenActiClaveData.isPresent()) {
			return toDto(tbasg176DocOrdenActiClaveData.get());
		}
		return null;
	}

	public Tbasg176DocOrdenActiClaveDto createTbasg176DocOrdenActiClave(
			Tbasg176DocOrdenActiClaveDto tbasg176DocOrdenActiClaveDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg176DocOrdenActiClave dbTbasg176DocOrdenActiClave = new Tbasg176DocOrdenActiClave();
		BeanUtils.copyProperties(dbTbasg176DocOrdenActiClave, tbasg176DocOrdenActiClaveDto);
		Tbasg176DocOrdenActiClave _tbasg176DocOrdenActiClave = tbasg176DocOrdenActiClaveRepository
				.save(dbTbasg176DocOrdenActiClave);
		return toDto(_tbasg176DocOrdenActiClave);
	}

	public Tbasg176DocOrdenActiClaveDto updateTbasg176DocOrdenActiClave(Integer cdgoClave,
			Tbasg176DocOrdenActiClaveDto tbasg176DocOrdenActiClaveDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg176DocOrdenActiClave> tbasg176DocOrdenActiClaveData = tbasg176DocOrdenActiClaveRepository
				.findById(cdgoClave);

		if (tbasg176DocOrdenActiClaveData.isPresent()) {
			Tbasg176DocOrdenActiClave dbTbasg176DocOrdenActiClave = tbasg176DocOrdenActiClaveData.get();
			BeanUtils.copyProperties(dbTbasg176DocOrdenActiClave, tbasg176DocOrdenActiClaveDto);
			return toDto(tbasg176DocOrdenActiClaveRepository.save(dbTbasg176DocOrdenActiClave));
		}
		return null;
	}

	public int deleteTbasg176DocOrdenActiClave(Integer cdgoClave) {

		tbasg176DocOrdenActiClaveRepository.deleteById(cdgoClave);
		return 1;
	}

	public List<Tbasg176DocOrdenActiClaveDto> findByCdgoClaveIn(List<Integer> cdgoClave) {

		List<Tbasg176DocOrdenActiClave> tbasg176DocOrdenActiClaves = tbasg176DocOrdenActiClaveRepository
				.findByCdgoClaveIn(cdgoClave);

		return toDtos(tbasg176DocOrdenActiClaves);
	}

	public List<Tbasg176DocOrdenActiClaveDto> getDocOrdenActiClaveActiveList() {
		return toDtos(tbasg176DocOrdenActiClaveRepository.getDocOrdenActiClaveActiveList());
	}

	public Tbasg176DocOrdenActiClaveDto toDto(Tbasg176DocOrdenActiClave orig) {

		Tbasg176DocOrdenActiClaveDto dest = new Tbasg176DocOrdenActiClaveDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg176DocOrdenActiClave toEntity(Tbasg176DocOrdenActiClaveDto orig) {

		Tbasg176DocOrdenActiClave dest = new Tbasg176DocOrdenActiClave();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg176DocOrdenActiClaveDto> toDtos(List<Tbasg176DocOrdenActiClave> orig) {

		List<Tbasg176DocOrdenActiClaveDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg176DocOrdenActiClave> toEntities(List<Tbasg176DocOrdenActiClaveDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg176DocOrdenActiClave> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
