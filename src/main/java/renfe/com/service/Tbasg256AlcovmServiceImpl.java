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

import renfe.com.model.dto.Tbasg256AlcovmDto;
import renfe.com.model.entity.Tbasg256Alcovm;
import renfe.com.repository.Tbasg256AlcovmRepository;

@Service
public class Tbasg256AlcovmServiceImpl implements Tbasg256AlcovmService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg256AlcovmRepository tbasg256AlcovmRepository;

	public List<Tbasg256AlcovmDto> getAllTbasg256Alcovm(Tbasg256AlcovmDto filter) {

		logger.info("getAllTbasg256Alcovm " + filter);
		if (filter == null) {
			return this.toDtos(tbasg256AlcovmRepository.findAll());
		}
		return this.toDtos(tbasg256AlcovmRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg256AlcovmDto findByCdgoAlcovm(Integer cdgoAlcovm) {

		Optional<Tbasg256Alcovm> tbasg256AlcovmData = tbasg256AlcovmRepository.findByCdgoAlcovm(cdgoAlcovm);

		if (tbasg256AlcovmData.isPresent()) {
			return toDto(tbasg256AlcovmData.get());
		}
		return null;
	}

	public Tbasg256AlcovmDto createTbasg256Alcovm(Tbasg256AlcovmDto tbasg256AlcovmDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg256Alcovm dbTbasg256Alcovm = new Tbasg256Alcovm();
		BeanUtils.copyProperties(dbTbasg256Alcovm, tbasg256AlcovmDto);
		Tbasg256Alcovm _tbasg256Alcovm = tbasg256AlcovmRepository.save(dbTbasg256Alcovm);
		return toDto(_tbasg256Alcovm);
	}

	public Tbasg256AlcovmDto updateTbasg256Alcovm(Integer cdgoAlcovm, Tbasg256AlcovmDto tbasg256AlcovmDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg256Alcovm> tbasg256AlcovmData = tbasg256AlcovmRepository.findById(cdgoAlcovm);

		if (tbasg256AlcovmData.isPresent()) {
			Tbasg256Alcovm dbTbasg256Alcovm = tbasg256AlcovmData.get();
			BeanUtils.copyProperties(dbTbasg256Alcovm, tbasg256AlcovmDto);
			return toDto(tbasg256AlcovmRepository.save(dbTbasg256Alcovm));
		}
		return null;
	}

	public int deleteTbasg256Alcovm(Integer cdgoAlcovm) {

		tbasg256AlcovmRepository.deleteById(cdgoAlcovm);
		return 1;
	}

	public List<Tbasg256AlcovmDto> findByCdgoAlcovmIn(List<Integer> cdgoAlcovm) {

		List<Tbasg256Alcovm> tbasg256Alcovms = tbasg256AlcovmRepository.findByCdgoAlcovmIn(cdgoAlcovm);

		return toDtos(tbasg256Alcovms);
	}

	public List<Tbasg256AlcovmDto> getAlcancesOVMCount() {
		return toDtos(tbasg256AlcovmRepository.getAlcancesOVMCount());
	}

	public List<Tbasg256AlcovmDto> getAlcancesOVMListAscendente() {
		return toDtos(tbasg256AlcovmRepository.getAlcancesOVMListAscendente());
	}

	public List<Tbasg256AlcovmDto> getAlcancesOVMListDescendente() {
		return toDtos(tbasg256AlcovmRepository.getAlcancesOVMListDescendente());
	}

	public List<Tbasg256AlcovmDto> getAlcancesOVMActiveList() {
		return toDtos(tbasg256AlcovmRepository.getAlcancesOVMActiveList());
	}

	public List<Tbasg256AlcovmDto> getAlcancesOVM(String cdgoAlcovm) {
		return toDtos(tbasg256AlcovmRepository.getAlcancesOVM(cdgoAlcovm));
	}

	public int insertAlcancesOVM(Tbasg256Alcovm bean) {
		return tbasg256AlcovmRepository.insertAlcancesOVM(bean);
	}

	public int updateAlcancesOVM(Tbasg256Alcovm bean) {
		return tbasg256AlcovmRepository.updateAlcancesOVM(bean);
	}

	public int deleteAlcancesOVM(Tbasg256Alcovm bean) {
		return tbasg256AlcovmRepository.deleteAlcancesOVM(bean);
	}

	public Tbasg256AlcovmDto toDto(Tbasg256Alcovm orig) {

		Tbasg256AlcovmDto dest = new Tbasg256AlcovmDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg256Alcovm toEntity(Tbasg256AlcovmDto orig) {

		Tbasg256Alcovm dest = new Tbasg256Alcovm();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg256AlcovmDto> toDtos(List<Tbasg256Alcovm> orig) {

		List<Tbasg256AlcovmDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg256Alcovm> toEntities(List<Tbasg256AlcovmDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg256Alcovm> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
