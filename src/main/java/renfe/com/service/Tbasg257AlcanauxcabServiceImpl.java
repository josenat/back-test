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

import renfe.com.model.dto.Tbasg257AlcanauxcabDto;
import renfe.com.model.entity.Tbasg257Alcanauxcab;
import renfe.com.repository.Tbasg257AlcanauxcabRepository;

@Transactional
@Service
public class Tbasg257AlcanauxcabServiceImpl implements Tbasg257AlcanauxcabService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg257AlcanauxcabRepository tbasg257AlcanauxcabRepository;

	public List<Tbasg257AlcanauxcabDto> getAllTbasg257Alcanauxcab(Tbasg257AlcanauxcabDto filter) {

		logger.info("getAllTbasg257Alcanauxcab " + filter);
		if (filter == null) {
			return this.toDtos(tbasg257AlcanauxcabRepository.findAll());
		}
		return this.toDtos(tbasg257AlcanauxcabRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg257AlcanauxcabDto findByCdgoAlcanauxcab(Integer cdgoAlcanauxcab) {

		Optional<Tbasg257Alcanauxcab> tbasg257AlcanauxcabData = tbasg257AlcanauxcabRepository
				.findByCdgoAlcanauxcab(cdgoAlcanauxcab);

		if (tbasg257AlcanauxcabData.isPresent()) {
			return toDto(tbasg257AlcanauxcabData.get());
		}
		return null;
	}

	public Tbasg257AlcanauxcabDto createTbasg257Alcanauxcab(Tbasg257AlcanauxcabDto tbasg257AlcanauxcabDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg257Alcanauxcab dbTbasg257Alcanauxcab = new Tbasg257Alcanauxcab();
		BeanUtils.copyProperties(dbTbasg257Alcanauxcab, tbasg257AlcanauxcabDto);
		Tbasg257Alcanauxcab _tbasg257Alcanauxcab = tbasg257AlcanauxcabRepository.save(dbTbasg257Alcanauxcab);
		return toDto(_tbasg257Alcanauxcab);
	}

	public Tbasg257AlcanauxcabDto updateTbasg257Alcanauxcab(Integer cdgoAlcanauxcab,
			Tbasg257AlcanauxcabDto tbasg257AlcanauxcabDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg257Alcanauxcab> tbasg257AlcanauxcabData = tbasg257AlcanauxcabRepository.findById(cdgoAlcanauxcab);

		if (tbasg257AlcanauxcabData.isPresent()) {
			Tbasg257Alcanauxcab dbTbasg257Alcanauxcab = tbasg257AlcanauxcabData.get();
			BeanUtils.copyProperties(dbTbasg257Alcanauxcab, tbasg257AlcanauxcabDto);
			return toDto(tbasg257AlcanauxcabRepository.save(dbTbasg257Alcanauxcab));
		}
		return null;
	}

	public int deleteTbasg257Alcanauxcab(Integer cdgoAlcanauxcab) {

		tbasg257AlcanauxcabRepository.deleteById(cdgoAlcanauxcab);
		return 1;
	}

	public List<Tbasg257AlcanauxcabDto> findByCdgoAlcanauxcabIn(List<Integer> cdgoAlcanauxcab) {

		List<Tbasg257Alcanauxcab> tbasg257Alcanauxcabs = tbasg257AlcanauxcabRepository
				.findByCdgoAlcanauxcabIn(cdgoAlcanauxcab);

		return toDtos(tbasg257Alcanauxcabs);
	}

	public List<Tbasg257AlcanauxcabDto> getAuxCabCount() {
		return toDtos(tbasg257AlcanauxcabRepository.getAuxCabCount());
	}

	public List<Tbasg257AlcanauxcabDto> getAuxCabListAscendente() {
		return toDtos(tbasg257AlcanauxcabRepository.getAuxCabListAscendente());
	}

	public List<Tbasg257AlcanauxcabDto> getAuxCabListDescendente() {
		return toDtos(tbasg257AlcanauxcabRepository.getAuxCabListDescendente());
	}

	public List<Tbasg257AlcanauxcabDto> getAuxCab(String cdgoAlcanauxcab) {
		return toDtos(tbasg257AlcanauxcabRepository.getAuxCab(cdgoAlcanauxcab));
	}
	
	public List<Tbasg257AlcanauxcabDto> getAuxCabNombre(String cdgoAlcanauxcab) {
		return toDtos(tbasg257AlcanauxcabRepository.getAuxCabNombre(cdgoAlcanauxcab));
	}

	public List<Tbasg257AlcanauxcabDto> getAuxCabActiveList() {
		return toDtos(tbasg257AlcanauxcabRepository.getAuxCabActiveList());
	}

	public int insertAuxCab(Tbasg257Alcanauxcab bean) {
		return tbasg257AlcanauxcabRepository.insertAuxCab(bean);
	}

	public int updateAuxCab(Tbasg257Alcanauxcab bean) {
		return tbasg257AlcanauxcabRepository.updateAuxCab(bean);
	}
	
	public int estadoAuxCab(Tbasg257Alcanauxcab bean) {
		return tbasg257AlcanauxcabRepository.estadoAuxCab(bean);
	}

	public Tbasg257AlcanauxcabDto toDto(Tbasg257Alcanauxcab orig) {

		Tbasg257AlcanauxcabDto dest = new Tbasg257AlcanauxcabDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg257Alcanauxcab toEntity(Tbasg257AlcanauxcabDto orig) {

		Tbasg257Alcanauxcab dest = new Tbasg257Alcanauxcab();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg257AlcanauxcabDto> toDtos(List<Tbasg257Alcanauxcab> orig) {

		List<Tbasg257AlcanauxcabDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg257Alcanauxcab> toEntities(List<Tbasg257AlcanauxcabDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg257Alcanauxcab> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
