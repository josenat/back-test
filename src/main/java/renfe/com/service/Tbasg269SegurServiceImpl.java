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

import renfe.com.model.dto.Tbasg269SegurDto;
import renfe.com.model.entity.Tbasg269Segur;
import renfe.com.repository.Tbasg269SegurRepository;

@Service
public class Tbasg269SegurServiceImpl implements Tbasg269SegurService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg269SegurRepository tbasg269SegurRepository;

	public List<Tbasg269SegurDto> getAllTbasg269Segur(Tbasg269SegurDto filter) {

		logger.info("getAllTbasg269Segur " + filter);
		if (filter == null) {
			return this.toDtos(tbasg269SegurRepository.findAll());
		}
		return this.toDtos(tbasg269SegurRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg269SegurDto findByCdgoSeguridad(Integer cdgoSeguridad) {

		Optional<Tbasg269Segur> tbasg269SegurData = tbasg269SegurRepository.findByCdgoSeguridad(cdgoSeguridad);

		if (tbasg269SegurData.isPresent()) {
			return toDto(tbasg269SegurData.get());
		}
		return null;
	}

	public Tbasg269SegurDto createTbasg269Segur(Tbasg269SegurDto tbasg269SegurDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg269Segur dbTbasg269Segur = new Tbasg269Segur();
		BeanUtils.copyProperties(dbTbasg269Segur, tbasg269SegurDto);
		Tbasg269Segur _tbasg269Segur = tbasg269SegurRepository.save(dbTbasg269Segur);
		return toDto(_tbasg269Segur);
	}

	public Tbasg269SegurDto updateTbasg269Segur(Integer cdgoSeguridad, Tbasg269SegurDto tbasg269SegurDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg269Segur> tbasg269SegurData = tbasg269SegurRepository.findById(cdgoSeguridad);

		if (tbasg269SegurData.isPresent()) {
			Tbasg269Segur dbTbasg269Segur = tbasg269SegurData.get();
			BeanUtils.copyProperties(dbTbasg269Segur, tbasg269SegurDto);
			return toDto(tbasg269SegurRepository.save(dbTbasg269Segur));
		}
		return null;
	}

	public int deleteTbasg269Segur(Integer cdgoSeguridad) {

		tbasg269SegurRepository.deleteById(cdgoSeguridad);
		return 1;
	}

	public List<Tbasg269SegurDto> findByCdgoSeguridadIn(List<Integer> cdgoSeguridad) {

		List<Tbasg269Segur> tbasg269Segurs = tbasg269SegurRepository.findByCdgoSeguridadIn(cdgoSeguridad);

		return toDtos(tbasg269Segurs);
	}

	public int insertSeguridadLOPD(Tbasg269Segur bean) {
		return tbasg269SegurRepository.insertSeguridadLOPD(bean);
	}

	public Tbasg269SegurDto toDto(Tbasg269Segur orig) {

		Tbasg269SegurDto dest = new Tbasg269SegurDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg269Segur toEntity(Tbasg269SegurDto orig) {

		Tbasg269Segur dest = new Tbasg269Segur();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg269SegurDto> toDtos(List<Tbasg269Segur> orig) {

		List<Tbasg269SegurDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg269Segur> toEntities(List<Tbasg269SegurDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg269Segur> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
