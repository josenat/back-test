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

import renfe.com.dto.GetRespAreaListAscendenteDTO;
import renfe.com.model.dto.Tbasg142RespAreaDto;
import renfe.com.model.entity.Tbasg142RespArea;
import renfe.com.repository.Tbasg142RespAreaRepository;

@Transactional
@Service
public class Tbasg142RespAreaServiceImpl implements Tbasg142RespAreaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg142RespAreaRepository tbasg142RespAreaRepository;

	public List<Tbasg142RespAreaDto> getAllTbasg142RespArea(Tbasg142RespAreaDto filter) {

		logger.info("getAllTbasg142RespArea " + filter);
		if (filter == null) {
			return this.toDtos(tbasg142RespAreaRepository.findAll());
		}
		return this.toDtos(tbasg142RespAreaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg142RespAreaDto findByCdgoAreact(Integer cdgoAreact) {

		Optional<Tbasg142RespArea> tbasg142RespAreaData = tbasg142RespAreaRepository.findByCdgoAreact(cdgoAreact);

		if (tbasg142RespAreaData.isPresent()) {
			return toDto(tbasg142RespAreaData.get());
		}
		return null;
	}

	public Tbasg142RespAreaDto createTbasg142RespArea(Tbasg142RespAreaDto tbasg142RespAreaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg142RespArea dbTbasg142RespArea = new Tbasg142RespArea();
		BeanUtils.copyProperties(dbTbasg142RespArea, tbasg142RespAreaDto);
		Tbasg142RespArea _tbasg142RespArea = tbasg142RespAreaRepository.save(dbTbasg142RespArea);
		return toDto(_tbasg142RespArea);
	}

	public Tbasg142RespAreaDto updateTbasg142RespArea(Integer cdgoAreact, Tbasg142RespAreaDto tbasg142RespAreaDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg142RespArea> tbasg142RespAreaData = tbasg142RespAreaRepository.findById(cdgoAreact);

		if (tbasg142RespAreaData.isPresent()) {
			Tbasg142RespArea dbTbasg142RespArea = tbasg142RespAreaData.get();
			BeanUtils.copyProperties(dbTbasg142RespArea, tbasg142RespAreaDto);
			return toDto(tbasg142RespAreaRepository.save(dbTbasg142RespArea));
		}
		return null;
	}

	public int deleteTbasg142RespArea(Integer cdgoAreact) {

		tbasg142RespAreaRepository.deleteById(cdgoAreact);
		return 1;
	}

	public List<Tbasg142RespAreaDto> findByCdgoAreactIn(List<Integer> cdgoAreact) {

		List<Tbasg142RespArea> tbasg142RespAreas = tbasg142RespAreaRepository.findByCdgoAreactIn(cdgoAreact);

		return toDtos(tbasg142RespAreas);
	}

	public List<Tbasg142RespAreaDto> getRespArea(String cdgoAreact) {
		return toDtos(tbasg142RespAreaRepository.getRespArea(cdgoAreact));
	}

	public List<Tbasg142RespAreaDto> getRespAreaView(String cdgoAreact) {
		return toDtos(tbasg142RespAreaRepository.getRespAreaView(cdgoAreact));
	}

	public List<Tbasg142RespAreaDto> getRespAreaCount() {
		return toDtos(tbasg142RespAreaRepository.getRespAreaCount());
	}

	public List<GetRespAreaListAscendenteDTO> getRespAreaListAscendente() {
		return tbasg142RespAreaRepository.getRespAreaListAscendente();
	}

	public List<Tbasg142RespAreaDto> getRespAreaListDescendente() {
		return toDtos(tbasg142RespAreaRepository.getRespAreaListDescendente());
	}

	public int addRespArea(Tbasg142RespArea bean) {
		return tbasg142RespAreaRepository.addRespArea(bean);
	}

	public int updateRespArea(Tbasg142RespArea bean) {
		return tbasg142RespAreaRepository.updateRespArea(bean);
	}

	public Tbasg142RespAreaDto toDto(Tbasg142RespArea orig) {

		Tbasg142RespAreaDto dest = new Tbasg142RespAreaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg142RespArea toEntity(Tbasg142RespAreaDto orig) {

		Tbasg142RespArea dest = new Tbasg142RespArea();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg142RespAreaDto> toDtos(List<Tbasg142RespArea> orig) {

		List<Tbasg142RespAreaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg142RespArea> toEntities(List<Tbasg142RespAreaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg142RespArea> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
