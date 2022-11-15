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

import renfe.com.model.dto.Tbasg158GcCategoriaDto;
import renfe.com.model.entity.Tbasg158GcCategoria;
import renfe.com.repository.Tbasg158GcCategoriaRepository;

@Service
public class Tbasg158GcCategoriaServiceImpl implements Tbasg158GcCategoriaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg158GcCategoriaRepository tbasg158GcCategoriaRepository;

	public List<Tbasg158GcCategoriaDto> getAllTbasg158GcCategoria(Tbasg158GcCategoriaDto filter) {

		logger.info("getAllTbasg158GcCategoria " + filter);
		if (filter == null) {
			return this.toDtos(tbasg158GcCategoriaRepository.findAll());
		}
		return this.toDtos(tbasg158GcCategoriaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg158GcCategoriaDto findByCdgoCategoria(String cdgoCategoria) {

		Optional<Tbasg158GcCategoria> tbasg158GcCategoriaData = tbasg158GcCategoriaRepository
				.findByCdgoCategoria(cdgoCategoria);

		if (tbasg158GcCategoriaData.isPresent()) {
			return toDto(tbasg158GcCategoriaData.get());
		}
		return null;
	}

	public Tbasg158GcCategoriaDto createTbasg158GcCategoria(Tbasg158GcCategoriaDto tbasg158GcCategoriaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg158GcCategoria dbTbasg158GcCategoria = new Tbasg158GcCategoria();
		BeanUtils.copyProperties(dbTbasg158GcCategoria, tbasg158GcCategoriaDto);
		Tbasg158GcCategoria _tbasg158GcCategoria = tbasg158GcCategoriaRepository.save(dbTbasg158GcCategoria);
		return toDto(_tbasg158GcCategoria);
	}

	public Tbasg158GcCategoriaDto updateTbasg158GcCategoria(String cdgoCategoria,
			Tbasg158GcCategoriaDto tbasg158GcCategoriaDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg158GcCategoria> tbasg158GcCategoriaData = tbasg158GcCategoriaRepository.findById(cdgoCategoria);

		if (tbasg158GcCategoriaData.isPresent()) {
			Tbasg158GcCategoria dbTbasg158GcCategoria = tbasg158GcCategoriaData.get();
			BeanUtils.copyProperties(dbTbasg158GcCategoria, tbasg158GcCategoriaDto);
			return toDto(tbasg158GcCategoriaRepository.save(dbTbasg158GcCategoria));
		}
		return null;
	}

	public int deleteTbasg158GcCategoria(String cdgoCategoria) {

		tbasg158GcCategoriaRepository.deleteById(cdgoCategoria);
		return 1;
	}

	public List<Tbasg158GcCategoriaDto> findByCdgoCategoriaIn(List<String> cdgoCategoria) {

		List<Tbasg158GcCategoria> tbasg158GcCategorias = tbasg158GcCategoriaRepository
				.findByCdgoCategoriaIn(cdgoCategoria);

		return toDtos(tbasg158GcCategorias);
	}

	public List<Tbasg158GcCategoriaDto> getGcCategoriasActiveList() {
		return toDtos(tbasg158GcCategoriaRepository.getGcCategoriasActiveList());
	}

	public Tbasg158GcCategoriaDto toDto(Tbasg158GcCategoria orig) {

		Tbasg158GcCategoriaDto dest = new Tbasg158GcCategoriaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg158GcCategoria toEntity(Tbasg158GcCategoriaDto orig) {

		Tbasg158GcCategoria dest = new Tbasg158GcCategoria();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg158GcCategoriaDto> toDtos(List<Tbasg158GcCategoria> orig) {

		List<Tbasg158GcCategoriaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg158GcCategoria> toEntities(List<Tbasg158GcCategoriaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg158GcCategoria> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
