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

import renfe.com.model.dto.Tbasg155FcCategoriaDto;
import renfe.com.model.entity.Tbasg155FcCategoria;
import renfe.com.repository.Tbasg155FcCategoriaRepository;

@Transactional
@Service
public class Tbasg155FcCategoriaServiceImpl implements Tbasg155FcCategoriaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg155FcCategoriaRepository tbasg155FcCategoriaRepository;

	public List<Tbasg155FcCategoriaDto> getAllTbasg155FcCategoria(Tbasg155FcCategoriaDto filter) {

		logger.info("getAllTbasg155FcCategoria " + filter);
		if (filter == null) {
			return this.toDtos(tbasg155FcCategoriaRepository.findAll());
		}
		return this.toDtos(tbasg155FcCategoriaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg155FcCategoriaDto findByCdgoCategoria(Integer cdgoCategoria) {

		Optional<Tbasg155FcCategoria> tbasg155FcCategoriaData = tbasg155FcCategoriaRepository
				.findByCdgoCategoria(cdgoCategoria);

		if (tbasg155FcCategoriaData.isPresent()) {
			return toDto(tbasg155FcCategoriaData.get());
		}
		return null;
	}

	public Tbasg155FcCategoriaDto createTbasg155FcCategoria(Tbasg155FcCategoriaDto tbasg155FcCategoriaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg155FcCategoria dbTbasg155FcCategoria = new Tbasg155FcCategoria();
		BeanUtils.copyProperties(dbTbasg155FcCategoria, tbasg155FcCategoriaDto);
		Tbasg155FcCategoria _tbasg155FcCategoria = tbasg155FcCategoriaRepository.save(dbTbasg155FcCategoria);
		return toDto(_tbasg155FcCategoria);
	}

	public Tbasg155FcCategoriaDto updateTbasg155FcCategoria(Integer cdgoCategoria,
			Tbasg155FcCategoriaDto tbasg155FcCategoriaDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg155FcCategoria> tbasg155FcCategoriaData = tbasg155FcCategoriaRepository.findById(cdgoCategoria);

		if (tbasg155FcCategoriaData.isPresent()) {
			Tbasg155FcCategoria dbTbasg155FcCategoria = tbasg155FcCategoriaData.get();
			BeanUtils.copyProperties(dbTbasg155FcCategoria, tbasg155FcCategoriaDto);
			return toDto(tbasg155FcCategoriaRepository.save(dbTbasg155FcCategoria));
		}
		return null;
	}

	public int deleteTbasg155FcCategoria(Integer cdgoCategoria) {

		tbasg155FcCategoriaRepository.deleteById(cdgoCategoria);
		return 1;
	}

	public List<Tbasg155FcCategoriaDto> findByCdgoCategoriaIn(List<Integer> cdgoCategoria) {

		List<Tbasg155FcCategoria> tbasg155FcCategorias = tbasg155FcCategoriaRepository
				.findByCdgoCategoriaIn(cdgoCategoria);

		return toDtos(tbasg155FcCategorias);
	}

	public List<Tbasg155FcCategoriaDto> getFcCategoriaCount() {
		return toDtos(tbasg155FcCategoriaRepository.getFcCategoriaCount());
	}

	public List<Tbasg155FcCategoriaDto> getFcCategoriaListAscendente() {
		return toDtos(tbasg155FcCategoriaRepository.getFcCategoriaListAscendente());
	}

	public List<Tbasg155FcCategoriaDto> getFcCategoriaListDescendente() {
		return toDtos(tbasg155FcCategoriaRepository.getFcCategoriaListDescendente());
	}

	public List<Tbasg155FcCategoriaDto> getFcCategoria(String cdgoCategoria) {
		return toDtos(tbasg155FcCategoriaRepository.getFcCategoria(cdgoCategoria));
	}

	public List<Tbasg155FcCategoriaDto> getFcCategoriaByNombre(String desgDescripcion) {
		return toDtos(tbasg155FcCategoriaRepository.getFcCategoriaByNombre(desgDescripcion));
	}

	public List<Tbasg155FcCategoriaDto> getFcCategoriaListActive() {
		return toDtos(tbasg155FcCategoriaRepository.getFcCategoriaListActive());
	}

	public List<Tbasg155FcCategoriaDto> getFcCategoriaIdiomaList() {
		return toDtos(tbasg155FcCategoriaRepository.getFcCategoriaIdiomaList());
	}

	public List<Tbasg155FcCategoriaDto> getFcCategoriaByNombre2(String desgDescripcion) {
		return tbasg155FcCategoriaRepository.getFcCategoriaByNombre2(desgDescripcion);
	}

	public int insertFcCategoria(Tbasg155FcCategoria bean) {
		return tbasg155FcCategoriaRepository.insertFcCategoria(bean);
	}

	public int updateFcCategoria(Tbasg155FcCategoria bean) {
		return tbasg155FcCategoriaRepository.updateFcCategoria(bean);
	}
	
	public int estadoFcCategoria(Tbasg155FcCategoria bean) {
		return tbasg155FcCategoriaRepository.estadoFcCategoria(bean);
	}

	public Tbasg155FcCategoriaDto toDto(Tbasg155FcCategoria orig) {

		Tbasg155FcCategoriaDto dest = new Tbasg155FcCategoriaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg155FcCategoria toEntity(Tbasg155FcCategoriaDto orig) {

		Tbasg155FcCategoria dest = new Tbasg155FcCategoria();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg155FcCategoriaDto> toDtos(List<Tbasg155FcCategoria> orig) {

		List<Tbasg155FcCategoriaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg155FcCategoria> toEntities(List<Tbasg155FcCategoriaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg155FcCategoria> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
