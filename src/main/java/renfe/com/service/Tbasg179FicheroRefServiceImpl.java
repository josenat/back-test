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

import renfe.com.model.dto.Tbasg179FicheroRefDto;
import renfe.com.model.entity.Tbasg179FicheroRef;
import renfe.com.repository.Tbasg179FicheroRefRepository;

@Service
public class Tbasg179FicheroRefServiceImpl implements Tbasg179FicheroRefService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg179FicheroRefRepository tbasg179FicheroRefRepository;

	public List<Tbasg179FicheroRefDto> getAllTbasg179FicheroRef(Tbasg179FicheroRefDto filter) {

		logger.info("getAllTbasg179FicheroRef " + filter);
		if (filter == null) {
			return this.toDtos(tbasg179FicheroRefRepository.findAll());
		}
		return this.toDtos(tbasg179FicheroRefRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg179FicheroRefDto findByCdgoFichero(Integer cdgoFichero) {

		Optional<Tbasg179FicheroRef> tbasg179FicheroRefData = tbasg179FicheroRefRepository
				.findByCdgoFichero(cdgoFichero);

		if (tbasg179FicheroRefData.isPresent()) {
			return toDto(tbasg179FicheroRefData.get());
		}
		return null;
	}

	public Tbasg179FicheroRefDto createTbasg179FicheroRef(Tbasg179FicheroRefDto tbasg179FicheroRefDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg179FicheroRef dbTbasg179FicheroRef = new Tbasg179FicheroRef();
		BeanUtils.copyProperties(dbTbasg179FicheroRef, tbasg179FicheroRefDto);
		Tbasg179FicheroRef _tbasg179FicheroRef = tbasg179FicheroRefRepository.save(dbTbasg179FicheroRef);
		return toDto(_tbasg179FicheroRef);
	}

	public Tbasg179FicheroRefDto updateTbasg179FicheroRef(Integer cdgoFichero,
			Tbasg179FicheroRefDto tbasg179FicheroRefDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg179FicheroRef> tbasg179FicheroRefData = tbasg179FicheroRefRepository.findById(cdgoFichero);

		if (tbasg179FicheroRefData.isPresent()) {
			Tbasg179FicheroRef dbTbasg179FicheroRef = tbasg179FicheroRefData.get();
			BeanUtils.copyProperties(dbTbasg179FicheroRef, tbasg179FicheroRefDto);
			return toDto(tbasg179FicheroRefRepository.save(dbTbasg179FicheroRef));
		}
		return null;
	}

	public int deleteTbasg179FicheroRef(Integer cdgoFichero) {

		tbasg179FicheroRefRepository.deleteById(cdgoFichero);
		return 1;
	}

	public List<Tbasg179FicheroRefDto> findByCdgoFicheroIn(List<Integer> cdgoFichero) {

		List<Tbasg179FicheroRef> tbasg179FicheroRefs = tbasg179FicheroRefRepository.findByCdgoFicheroIn(cdgoFichero);

		return toDtos(tbasg179FicheroRefs);
	}

	public List<Tbasg179FicheroRefDto> getFicheroRefList() {
		return toDtos(tbasg179FicheroRefRepository.getFicheroRefList());
	}

	public List<Tbasg179FicheroRefDto> getFicheroRefListByFecha() {
		return toDtos(tbasg179FicheroRefRepository.getFicheroRefListByFecha());
	}

	public List<Tbasg179FicheroRefDto> getFicheroRefListByFechaAsc() {
		return toDtos(tbasg179FicheroRefRepository.getFicheroRefListByFechaAsc());
	}

	public Tbasg179FicheroRefDto toDto(Tbasg179FicheroRef orig) {

		Tbasg179FicheroRefDto dest = new Tbasg179FicheroRefDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg179FicheroRef toEntity(Tbasg179FicheroRefDto orig) {

		Tbasg179FicheroRef dest = new Tbasg179FicheroRef();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg179FicheroRefDto> toDtos(List<Tbasg179FicheroRef> orig) {

		List<Tbasg179FicheroRefDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg179FicheroRef> toEntities(List<Tbasg179FicheroRefDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg179FicheroRef> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
