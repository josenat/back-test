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

import renfe.com.model.dto.Tbasg139CursomateDto;
import renfe.com.model.entity.Tbasg139Cursomate;
import renfe.com.repository.Tbasg139CursomateRepository;

@Service
public class Tbasg139CursomateServiceImpl implements Tbasg139CursomateService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg139CursomateRepository tbasg139CursomateRepository;

	public List<Tbasg139CursomateDto> getAllTbasg139Cursomate(Tbasg139CursomateDto filter) {

		logger.info("getAllTbasg139Cursomate " + filter);
		if (filter == null) {
			return this.toDtos(tbasg139CursomateRepository.findAll());
		}
		return this.toDtos(tbasg139CursomateRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg139CursomateDto findByCdgoCursomat(Integer cdgoCursomat) {

		Optional<Tbasg139Cursomate> tbasg139CursomateData = tbasg139CursomateRepository
				.findByCdgoCursomat(cdgoCursomat);

		if (tbasg139CursomateData.isPresent()) {
			return toDto(tbasg139CursomateData.get());
		}
		return null;
	}

	public Tbasg139CursomateDto createTbasg139Cursomate(Tbasg139CursomateDto tbasg139CursomateDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg139Cursomate dbTbasg139Cursomate = new Tbasg139Cursomate();
		BeanUtils.copyProperties(dbTbasg139Cursomate, tbasg139CursomateDto);
		Tbasg139Cursomate _tbasg139Cursomate = tbasg139CursomateRepository.save(dbTbasg139Cursomate);
		return toDto(_tbasg139Cursomate);
	}

	public Tbasg139CursomateDto updateTbasg139Cursomate(Integer cdgoCursomat, Tbasg139CursomateDto tbasg139CursomateDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg139Cursomate> tbasg139CursomateData = tbasg139CursomateRepository.findById(cdgoCursomat);

		if (tbasg139CursomateData.isPresent()) {
			Tbasg139Cursomate dbTbasg139Cursomate = tbasg139CursomateData.get();
			BeanUtils.copyProperties(dbTbasg139Cursomate, tbasg139CursomateDto);
			return toDto(tbasg139CursomateRepository.save(dbTbasg139Cursomate));
		}
		return null;
	}

	public int deleteTbasg139Cursomate(Integer cdgoCursomat) {

		tbasg139CursomateRepository.deleteById(cdgoCursomat);
		return 1;
	}

	public List<Tbasg139CursomateDto> findByCdgoCursomatIn(List<Integer> cdgoCursomat) {

		List<Tbasg139Cursomate> tbasg139Cursomates = tbasg139CursomateRepository.findByCdgoCursomatIn(cdgoCursomat);

		return toDtos(tbasg139Cursomates);
	}

	public List<Tbasg139CursomateDto> getCursoMateCount() {
		return toDtos(tbasg139CursomateRepository.getCursoMateCount());
	}

	public List<Tbasg139CursomateDto> getCursoMateListAscendente() {
		return toDtos(tbasg139CursomateRepository.getCursoMateListAscendente());
	}

	public List<Tbasg139CursomateDto> getCursoMateListDescendente() {
		return toDtos(tbasg139CursomateRepository.getCursoMateListDescendente());
	}

	public List<Tbasg139CursomateDto> getCursoMate(String cdgoCursomat) {
		return toDtos(tbasg139CursomateRepository.getCursoMate(cdgoCursomat));
	}

	public int insertCursoMate(Tbasg139Cursomate bean) {
		return tbasg139CursomateRepository.insertCursoMate(bean);
	}

	public int updateCursoMate(Tbasg139Cursomate bean) {
		return tbasg139CursomateRepository.updateCursoMate(bean);
	}

	public int deleteCursoMate(Tbasg139Cursomate bean) {
		return tbasg139CursomateRepository.deleteCursoMate(bean);
	}

	public Tbasg139CursomateDto toDto(Tbasg139Cursomate orig) {

		Tbasg139CursomateDto dest = new Tbasg139CursomateDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg139Cursomate toEntity(Tbasg139CursomateDto orig) {

		Tbasg139Cursomate dest = new Tbasg139Cursomate();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg139CursomateDto> toDtos(List<Tbasg139Cursomate> orig) {

		List<Tbasg139CursomateDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg139Cursomate> toEntities(List<Tbasg139CursomateDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg139Cursomate> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
