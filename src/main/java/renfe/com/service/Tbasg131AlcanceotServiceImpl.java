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

import renfe.com.model.dto.Tbasg131AlcanceotDto;
import renfe.com.model.entity.Tbasg131Alcanceot;
import renfe.com.repository.Tbasg131AlcanceotRepository;

@Transactional
@Service
public class Tbasg131AlcanceotServiceImpl implements Tbasg131AlcanceotService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg131AlcanceotRepository tbasg131AlcanceotRepository;

	public List<Tbasg131AlcanceotDto> getAllTbasg131Alcanceot(Tbasg131AlcanceotDto filter) {

		logger.info("getAllTbasg131Alcanceot " + filter);
		if (filter == null) {
			return this.toDtos(tbasg131AlcanceotRepository.findAll());
		}
		return this.toDtos(tbasg131AlcanceotRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg131AlcanceotDto findByCdgoAlcanceot(Integer cdgoAlcanceot) {

		Optional<Tbasg131Alcanceot> tbasg131AlcanceotData = tbasg131AlcanceotRepository
				.findByCdgoAlcanceot(cdgoAlcanceot);

		if (tbasg131AlcanceotData.isPresent()) {
			return toDto(tbasg131AlcanceotData.get());
		}
		return null;
	}

	public Tbasg131AlcanceotDto createTbasg131Alcanceot(Tbasg131AlcanceotDto tbasg131AlcanceotDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg131Alcanceot dbTbasg131Alcanceot = new Tbasg131Alcanceot();
		BeanUtils.copyProperties(dbTbasg131Alcanceot, tbasg131AlcanceotDto);
		Tbasg131Alcanceot _tbasg131Alcanceot = tbasg131AlcanceotRepository.save(dbTbasg131Alcanceot);
		return toDto(_tbasg131Alcanceot);
	}

	public Tbasg131AlcanceotDto updateTbasg131Alcanceot(Integer cdgoAlcanceot,
			Tbasg131AlcanceotDto tbasg131AlcanceotDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg131Alcanceot> tbasg131AlcanceotData = tbasg131AlcanceotRepository.findById(cdgoAlcanceot);

		if (tbasg131AlcanceotData.isPresent()) {
			Tbasg131Alcanceot dbTbasg131Alcanceot = tbasg131AlcanceotData.get();
			BeanUtils.copyProperties(dbTbasg131Alcanceot, tbasg131AlcanceotDto);
			return toDto(tbasg131AlcanceotRepository.save(dbTbasg131Alcanceot));
		}
		return null;
	}

	public int deleteTbasg131Alcanceot(Integer cdgoAlcanceot) {

		tbasg131AlcanceotRepository.deleteById(cdgoAlcanceot);
		return 1;
	}

	public List<Tbasg131AlcanceotDto> findByCdgoAlcanceotIn(List<Integer> cdgoAlcanceot) {

		List<Tbasg131Alcanceot> tbasg131Alcanceots = tbasg131AlcanceotRepository.findByCdgoAlcanceotIn(cdgoAlcanceot);

		return toDtos(tbasg131Alcanceots);
	}

	public List<Tbasg131AlcanceotDto> getAlcanceOtCount() {
		return toDtos(tbasg131AlcanceotRepository.getAlcanceOtCount());
	}

	public List<Tbasg131AlcanceotDto> getAlcanceOtListAscendente() {
		return toDtos(tbasg131AlcanceotRepository.getAlcanceOtListAscendente());
	}
	
	public List<Tbasg131AlcanceotDto> getAlcanceOtList() {
		return toDtos(tbasg131AlcanceotRepository.getAlcanceOtList());
	}

	public List<Tbasg131AlcanceotDto> getAlcanceOtListDescendente() {
		return toDtos(tbasg131AlcanceotRepository.getAlcanceOtListDescendente());
	}

	public List<Tbasg131AlcanceotDto> getAlcanceOt(Integer cdgoAlcanceot) {
		return toDtos(tbasg131AlcanceotRepository.getAlcanceOt(cdgoAlcanceot));
	}
	
	public List<Tbasg131AlcanceotDto> getAlcanceOtNombre(String cdgoAlcanceot) {
		return toDtos(tbasg131AlcanceotRepository.getAlcanceOtNombre(cdgoAlcanceot));
	}

	public List<Tbasg131AlcanceotDto> getAlcanceOtInfSer(Integer cdgoAlcanceot) {
		return toDtos(tbasg131AlcanceotRepository.getAlcanceOtInfSer(cdgoAlcanceot));
	}

	public List<Tbasg131AlcanceotDto> getAlcanceOtActiveList() {
		return toDtos(tbasg131AlcanceotRepository.getAlcanceOtActiveList());
	}

	public int insertAlcanceOt(Tbasg131Alcanceot bean) {
		return tbasg131AlcanceotRepository.insertAlcanceOt(bean);
	}

	public int updateAlcanceOt(Tbasg131Alcanceot bean) {
		return tbasg131AlcanceotRepository.updateAlcanceOt(bean);
	}
	
	public int estadoAlcanceOt(Tbasg131Alcanceot bean) {
		return tbasg131AlcanceotRepository.estadoAlcanceOt(bean);
	}
	
	public Tbasg131AlcanceotDto toDto(Tbasg131Alcanceot orig) {

		Tbasg131AlcanceotDto dest = new Tbasg131AlcanceotDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg131Alcanceot toEntity(Tbasg131AlcanceotDto orig) {

		Tbasg131Alcanceot dest = new Tbasg131Alcanceot();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg131AlcanceotDto> toDtos(List<Tbasg131Alcanceot> orig) {

		List<Tbasg131AlcanceotDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg131Alcanceot> toEntities(List<Tbasg131AlcanceotDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg131Alcanceot> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}

}

