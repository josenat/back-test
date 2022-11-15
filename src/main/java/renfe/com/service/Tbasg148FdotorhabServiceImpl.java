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

import renfe.com.model.dto.Tbasg148FdotorhabDto;
import renfe.com.model.entity.Tbasg148Fdotorhab;
import renfe.com.repository.Tbasg148FdotorhabRepository;

@Service
public class Tbasg148FdotorhabServiceImpl implements Tbasg148FdotorhabService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg148FdotorhabRepository tbasg148FdotorhabRepository;

	public List<Tbasg148FdotorhabDto> getAllTbasg148Fdotorhab(Tbasg148FdotorhabDto filter) {

		logger.info("getAllTbasg148Fdotorhab " + filter);
		if (filter == null) {
			return this.toDtos(tbasg148FdotorhabRepository.findAll());
		}
		return this.toDtos(tbasg148FdotorhabRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg148FdotorhabDto findByCdgoFirma(Integer cdgoFirma) {

		Optional<Tbasg148Fdotorhab> tbasg148FdotorhabData = tbasg148FdotorhabRepository.findByCdgoFirma(cdgoFirma);

		if (tbasg148FdotorhabData.isPresent()) {
			return toDto(tbasg148FdotorhabData.get());
		}
		return null;
	}

	public Tbasg148FdotorhabDto createTbasg148Fdotorhab(Tbasg148FdotorhabDto tbasg148FdotorhabDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg148Fdotorhab dbTbasg148Fdotorhab = new Tbasg148Fdotorhab();
		BeanUtils.copyProperties(dbTbasg148Fdotorhab, tbasg148FdotorhabDto);
		Tbasg148Fdotorhab _tbasg148Fdotorhab = tbasg148FdotorhabRepository.save(dbTbasg148Fdotorhab);
		return toDto(_tbasg148Fdotorhab);
	}

	public Tbasg148FdotorhabDto updateTbasg148Fdotorhab(Integer cdgoFirma, Tbasg148FdotorhabDto tbasg148FdotorhabDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg148Fdotorhab> tbasg148FdotorhabData = tbasg148FdotorhabRepository.findById(cdgoFirma);

		if (tbasg148FdotorhabData.isPresent()) {
			Tbasg148Fdotorhab dbTbasg148Fdotorhab = tbasg148FdotorhabData.get();
			BeanUtils.copyProperties(dbTbasg148Fdotorhab, tbasg148FdotorhabDto);
			return toDto(tbasg148FdotorhabRepository.save(dbTbasg148Fdotorhab));
		}
		return null;
	}

	public int deleteTbasg148Fdotorhab(Integer cdgoFirma) {

		tbasg148FdotorhabRepository.deleteById(cdgoFirma);
		return 1;
	}

	public List<Tbasg148FdotorhabDto> findByCdgoFirmaIn(List<Integer> cdgoFirma) {

		List<Tbasg148Fdotorhab> tbasg148Fdotorhabs = tbasg148FdotorhabRepository.findByCdgoFirmaIn(cdgoFirma);

		return toDtos(tbasg148Fdotorhabs);
	}

	public int insertFdOtorHab(Tbasg148Fdotorhab bean) {
		return tbasg148FdotorhabRepository.insertFdOtorHab(bean);
	}

	public Tbasg148FdotorhabDto toDto(Tbasg148Fdotorhab orig) {

		Tbasg148FdotorhabDto dest = new Tbasg148FdotorhabDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg148Fdotorhab toEntity(Tbasg148FdotorhabDto orig) {

		Tbasg148Fdotorhab dest = new Tbasg148Fdotorhab();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg148FdotorhabDto> toDtos(List<Tbasg148Fdotorhab> orig) {

		List<Tbasg148FdotorhabDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg148Fdotorhab> toEntities(List<Tbasg148FdotorhabDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg148Fdotorhab> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
