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

import renfe.com.model.dto.Tbasg255AmbovmDto;
import renfe.com.model.entity.Tbasg255Ambovm;
import renfe.com.repository.Tbasg255AmbovmRepository;

@Service
public class Tbasg255AmbovmServiceImpl implements Tbasg255AmbovmService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg255AmbovmRepository tbasg255AmbovmRepository;

	public List<Tbasg255AmbovmDto> getAllTbasg255Ambovm(Tbasg255AmbovmDto filter) {

		logger.info("getAllTbasg255Ambovm " + filter);
		if (filter == null) {
			return this.toDtos(tbasg255AmbovmRepository.findAll());
		}
		return this.toDtos(tbasg255AmbovmRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg255AmbovmDto findByCdgoAmbovm(Integer cdgoAmbovm) {

		Optional<Tbasg255Ambovm> tbasg255AmbovmData = tbasg255AmbovmRepository.findByCdgoAmbovm(cdgoAmbovm);

		if (tbasg255AmbovmData.isPresent()) {
			return toDto(tbasg255AmbovmData.get());
		}
		return null;
	}

	public Tbasg255AmbovmDto createTbasg255Ambovm(Tbasg255AmbovmDto tbasg255AmbovmDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg255Ambovm dbTbasg255Ambovm = new Tbasg255Ambovm();
		BeanUtils.copyProperties(dbTbasg255Ambovm, tbasg255AmbovmDto);
		Tbasg255Ambovm _tbasg255Ambovm = tbasg255AmbovmRepository.save(dbTbasg255Ambovm);
		return toDto(_tbasg255Ambovm);
	}

	public Tbasg255AmbovmDto updateTbasg255Ambovm(Integer cdgoAmbovm, Tbasg255AmbovmDto tbasg255AmbovmDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg255Ambovm> tbasg255AmbovmData = tbasg255AmbovmRepository.findById(cdgoAmbovm);

		if (tbasg255AmbovmData.isPresent()) {
			Tbasg255Ambovm dbTbasg255Ambovm = tbasg255AmbovmData.get();
			BeanUtils.copyProperties(dbTbasg255Ambovm, tbasg255AmbovmDto);
			return toDto(tbasg255AmbovmRepository.save(dbTbasg255Ambovm));
		}
		return null;
	}

	public int deleteTbasg255Ambovm(Integer cdgoAmbovm) {

		tbasg255AmbovmRepository.deleteById(cdgoAmbovm);
		return 1;
	}

	public List<Tbasg255AmbovmDto> findByCdgoAmbovmIn(List<Integer> cdgoAmbovm) {

		List<Tbasg255Ambovm> tbasg255Ambovms = tbasg255AmbovmRepository.findByCdgoAmbovmIn(cdgoAmbovm);

		return toDtos(tbasg255Ambovms);
	}

	public List<Tbasg255AmbovmDto> getAmbitosOVMCount() {
		return toDtos(tbasg255AmbovmRepository.getAmbitosOVMCount());
	}

	public List<Tbasg255AmbovmDto> getAmbitosOVMListAscendente() {
		return toDtos(tbasg255AmbovmRepository.getAmbitosOVMListAscendente());
	}

	public List<Tbasg255AmbovmDto> getAmbitosOVMListDescendente() {
		return toDtos(tbasg255AmbovmRepository.getAmbitosOVMListDescendente());
	}

	public List<Tbasg255AmbovmDto> getAmbitosOVMActiveList() {
		return toDtos(tbasg255AmbovmRepository.getAmbitosOVMActiveList());
	}

	public List<Tbasg255AmbovmDto> getAmbitosOVM(String cdgoAmbovm) {
		return toDtos(tbasg255AmbovmRepository.getAmbitosOVM(cdgoAmbovm));
	}

	public int insertAmbitosOVM(Tbasg255Ambovm bean) {
		return tbasg255AmbovmRepository.insertAmbitosOVM(bean);
	}

	public int updateAmbitosOVM(Tbasg255Ambovm bean) {
		return tbasg255AmbovmRepository.updateAmbitosOVM(bean);
	}

	public int deleteAmbitosOVM(Tbasg255Ambovm bean) {
		return tbasg255AmbovmRepository.deleteAmbitosOVM(bean);
	}

	public Tbasg255AmbovmDto toDto(Tbasg255Ambovm orig) {

		Tbasg255AmbovmDto dest = new Tbasg255AmbovmDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg255Ambovm toEntity(Tbasg255AmbovmDto orig) {

		Tbasg255Ambovm dest = new Tbasg255Ambovm();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg255AmbovmDto> toDtos(List<Tbasg255Ambovm> orig) {

		List<Tbasg255AmbovmDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg255Ambovm> toEntities(List<Tbasg255AmbovmDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg255Ambovm> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
