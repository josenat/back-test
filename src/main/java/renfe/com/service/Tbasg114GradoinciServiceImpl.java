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

import renfe.com.model.dto.Tbasg114GradoinciDto;
import renfe.com.model.entity.Tbasg114Gradoinci;
import renfe.com.repository.Tbasg114GradoinciRepository;

@Transactional
@Service
public class Tbasg114GradoinciServiceImpl implements Tbasg114GradoinciService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg114GradoinciRepository tbasg114GradoinciRepository;

	public List<Tbasg114GradoinciDto> getAllTbasg114Gradoinci(Tbasg114GradoinciDto filter) {

		logger.info("getAllTbasg114Gradoinci " + filter);
		if (filter == null) {
			return this.toDtos(tbasg114GradoinciRepository.findAll());
		}
		return this.toDtos(tbasg114GradoinciRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg114GradoinciDto findByCdgoGrado(Integer cdgoGrado) {

		Optional<Tbasg114Gradoinci> tbasg114GradoinciData = tbasg114GradoinciRepository.findByCdgoGrado(cdgoGrado);

		if (tbasg114GradoinciData.isPresent()) {
			return toDto(tbasg114GradoinciData.get());
		}
		return null;
	}

	public Tbasg114GradoinciDto createTbasg114Gradoinci(Tbasg114GradoinciDto tbasg114GradoinciDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg114Gradoinci dbTbasg114Gradoinci = new Tbasg114Gradoinci();
		BeanUtils.copyProperties(dbTbasg114Gradoinci, tbasg114GradoinciDto);
		Tbasg114Gradoinci _tbasg114Gradoinci = tbasg114GradoinciRepository.save(dbTbasg114Gradoinci);
		return toDto(_tbasg114Gradoinci);
	}

	public Tbasg114GradoinciDto updateTbasg114Gradoinci(Integer cdgoGrado, Tbasg114GradoinciDto tbasg114GradoinciDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg114Gradoinci> tbasg114GradoinciData = tbasg114GradoinciRepository.findById(cdgoGrado);

		if (tbasg114GradoinciData.isPresent()) {
			Tbasg114Gradoinci dbTbasg114Gradoinci = tbasg114GradoinciData.get();
			BeanUtils.copyProperties(dbTbasg114Gradoinci, tbasg114GradoinciDto);
			return toDto(tbasg114GradoinciRepository.save(dbTbasg114Gradoinci));
		}
		return null;
	}

	public int deleteTbasg114Gradoinci(Integer cdgoGrado) {

		tbasg114GradoinciRepository.deleteById(cdgoGrado);
		return 1;
	}

	public List<Tbasg114GradoinciDto> findByCdgoGradoIn(List<Integer> cdgoGrado) {

		List<Tbasg114Gradoinci> tbasg114Gradoincis = tbasg114GradoinciRepository.findByCdgoGradoIn(cdgoGrado);

		return toDtos(tbasg114Gradoincis);
	}

	public List<Tbasg114GradoinciDto> getGradoInciCount() {
		return toDtos(tbasg114GradoinciRepository.getGradoInciCount());
	}

	public List<Tbasg114GradoinciDto> getGradoInciActiveCount() {
		return toDtos(tbasg114GradoinciRepository.getGradoInciActiveCount());
	}

	public List<Tbasg114GradoinciDto> getGradoInciListAscendente() {
		return toDtos(tbasg114GradoinciRepository.getGradoInciListAscendente());
	}

	public List<Tbasg114GradoinciDto> getGradoInciListDescendente() {
		return toDtos(tbasg114GradoinciRepository.getGradoInciListDescendente());
	}

	public List<Tbasg114GradoinciDto> getGradoInciActiveListAscendente() {
		return toDtos(tbasg114GradoinciRepository.getGradoInciActiveListAscendente());
	}

	public List<Tbasg114GradoinciDto> getGradoInciActiveListDescendente() {
		return toDtos(tbasg114GradoinciRepository.getGradoInciActiveListDescendente());
	}

	public List<Tbasg114GradoinciDto> getGradoInci(String cdgoGrado) {
		return toDtos(tbasg114GradoinciRepository.getGradoInci(cdgoGrado));
	}

	public int insertGradoInci(Tbasg114Gradoinci bean) {
		return tbasg114GradoinciRepository.insertGradoInci(bean);
	}

	public int updateGradoInci(Tbasg114Gradoinci bean) {
		return tbasg114GradoinciRepository.updateGradoInci(bean);
	}
	
	public int estadoGradoInci(Tbasg114Gradoinci bean) {
		return tbasg114GradoinciRepository.estadoGradoInci(bean);
	}

	public Tbasg114GradoinciDto toDto(Tbasg114Gradoinci orig) {

		Tbasg114GradoinciDto dest = new Tbasg114GradoinciDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg114Gradoinci toEntity(Tbasg114GradoinciDto orig) {

		Tbasg114Gradoinci dest = new Tbasg114Gradoinci();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg114GradoinciDto> toDtos(List<Tbasg114Gradoinci> orig) {

		List<Tbasg114GradoinciDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg114Gradoinci> toEntities(List<Tbasg114GradoinciDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg114Gradoinci> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
