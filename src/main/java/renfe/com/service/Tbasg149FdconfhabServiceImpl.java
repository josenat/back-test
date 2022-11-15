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

import renfe.com.model.dto.Tbasg149FdconfhabDto;
import renfe.com.model.entity.Tbasg149Fdconfhab;
import renfe.com.repository.Tbasg149FdconfhabRepository;

@Service
public class Tbasg149FdconfhabServiceImpl implements Tbasg149FdconfhabService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg149FdconfhabRepository tbasg149FdconfhabRepository;

	public List<Tbasg149FdconfhabDto> getAllTbasg149Fdconfhab(Tbasg149FdconfhabDto filter) {

		logger.info("getAllTbasg149Fdconfhab " + filter);
		if (filter == null) {
			return this.toDtos(tbasg149FdconfhabRepository.findAll());
		}
		return this.toDtos(tbasg149FdconfhabRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg149FdconfhabDto findByCdgoFirma(Integer cdgoFirma) {

		Optional<Tbasg149Fdconfhab> tbasg149FdconfhabData = tbasg149FdconfhabRepository.findByCdgoFirma(cdgoFirma);

		if (tbasg149FdconfhabData.isPresent()) {
			return toDto(tbasg149FdconfhabData.get());
		}
		return null;
	}

	public Tbasg149FdconfhabDto createTbasg149Fdconfhab(Tbasg149FdconfhabDto tbasg149FdconfhabDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg149Fdconfhab dbTbasg149Fdconfhab = new Tbasg149Fdconfhab();
		BeanUtils.copyProperties(dbTbasg149Fdconfhab, tbasg149FdconfhabDto);
		Tbasg149Fdconfhab _tbasg149Fdconfhab = tbasg149FdconfhabRepository.save(dbTbasg149Fdconfhab);
		return toDto(_tbasg149Fdconfhab);
	}

	public Tbasg149FdconfhabDto updateTbasg149Fdconfhab(Integer cdgoFirma, Tbasg149FdconfhabDto tbasg149FdconfhabDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg149Fdconfhab> tbasg149FdconfhabData = tbasg149FdconfhabRepository.findById(cdgoFirma);

		if (tbasg149FdconfhabData.isPresent()) {
			Tbasg149Fdconfhab dbTbasg149Fdconfhab = tbasg149FdconfhabData.get();
			BeanUtils.copyProperties(dbTbasg149Fdconfhab, tbasg149FdconfhabDto);
			return toDto(tbasg149FdconfhabRepository.save(dbTbasg149Fdconfhab));
		}
		return null;
	}

	public int deleteTbasg149Fdconfhab(Integer cdgoFirma) {

		tbasg149FdconfhabRepository.deleteById(cdgoFirma);
		return 1;
	}

	public List<Tbasg149FdconfhabDto> findByCdgoFirmaIn(List<Integer> cdgoFirma) {

		List<Tbasg149Fdconfhab> tbasg149Fdconfhabs = tbasg149FdconfhabRepository.findByCdgoFirmaIn(cdgoFirma);

		return toDtos(tbasg149Fdconfhabs);
	}

	public int insertFdConfHab(Tbasg149Fdconfhab bean) {
		return tbasg149FdconfhabRepository.insertFdConfHab(bean);
	}

	public Tbasg149FdconfhabDto toDto(Tbasg149Fdconfhab orig) {

		Tbasg149FdconfhabDto dest = new Tbasg149FdconfhabDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg149Fdconfhab toEntity(Tbasg149FdconfhabDto orig) {

		Tbasg149Fdconfhab dest = new Tbasg149Fdconfhab();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg149FdconfhabDto> toDtos(List<Tbasg149Fdconfhab> orig) {

		List<Tbasg149FdconfhabDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg149Fdconfhab> toEntities(List<Tbasg149FdconfhabDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg149Fdconfhab> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
