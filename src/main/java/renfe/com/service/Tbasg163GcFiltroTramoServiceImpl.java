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

import renfe.com.model.dto.Tbasg163GcFiltroTramoDto;
import renfe.com.model.entity.Tbasg163GcFiltroTramo;
import renfe.com.repository.Tbasg163GcFiltroTramoRepository;

@Service
public class Tbasg163GcFiltroTramoServiceImpl implements Tbasg163GcFiltroTramoService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg163GcFiltroTramoRepository tbasg163GcFiltroTramoRepository;

	public List<Tbasg163GcFiltroTramoDto> getAllTbasg163GcFiltroTramo(Tbasg163GcFiltroTramoDto filter) {

		logger.info("getAllTbasg163GcFiltroTramo " + filter);
		if (filter == null) {
			return this.toDtos(tbasg163GcFiltroTramoRepository.findAll());
		}
		return this.toDtos(tbasg163GcFiltroTramoRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg163GcFiltroTramoDto findByCdgoFiltroTramo(Integer cdgoFiltroTramo) {

		Optional<Tbasg163GcFiltroTramo> tbasg163GcFiltroTramoData = tbasg163GcFiltroTramoRepository
				.findByCdgoFiltroTramo(cdgoFiltroTramo);

		if (tbasg163GcFiltroTramoData.isPresent()) {
			return toDto(tbasg163GcFiltroTramoData.get());
		}
		return null;
	}

	public Tbasg163GcFiltroTramoDto createTbasg163GcFiltroTramo(Tbasg163GcFiltroTramoDto tbasg163GcFiltroTramoDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg163GcFiltroTramo dbTbasg163GcFiltroTramo = new Tbasg163GcFiltroTramo();
		BeanUtils.copyProperties(dbTbasg163GcFiltroTramo, tbasg163GcFiltroTramoDto);
		Tbasg163GcFiltroTramo _tbasg163GcFiltroTramo = tbasg163GcFiltroTramoRepository.save(dbTbasg163GcFiltroTramo);
		return toDto(_tbasg163GcFiltroTramo);
	}

	public Tbasg163GcFiltroTramoDto updateTbasg163GcFiltroTramo(Integer cdgoFiltroTramo,
			Tbasg163GcFiltroTramoDto tbasg163GcFiltroTramoDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg163GcFiltroTramo> tbasg163GcFiltroTramoData = tbasg163GcFiltroTramoRepository
				.findById(cdgoFiltroTramo);

		if (tbasg163GcFiltroTramoData.isPresent()) {
			Tbasg163GcFiltroTramo dbTbasg163GcFiltroTramo = tbasg163GcFiltroTramoData.get();
			BeanUtils.copyProperties(dbTbasg163GcFiltroTramo, tbasg163GcFiltroTramoDto);
			return toDto(tbasg163GcFiltroTramoRepository.save(dbTbasg163GcFiltroTramo));
		}
		return null;
	}

	public int deleteTbasg163GcFiltroTramo(Integer cdgoFiltroTramo) {

		tbasg163GcFiltroTramoRepository.deleteById(cdgoFiltroTramo);
		return 1;
	}

	public List<Tbasg163GcFiltroTramoDto> findByCdgoFiltroTramoIn(List<Integer> cdgoFiltroTramo) {

		List<Tbasg163GcFiltroTramo> tbasg163GcFiltroTramos = tbasg163GcFiltroTramoRepository
				.findByCdgoFiltroTramoIn(cdgoFiltroTramo);

		return toDtos(tbasg163GcFiltroTramos);
	}

	public List<Tbasg163GcFiltroTramoDto> getGcFiltrosTramoListActive(String cdgoConsulta) {
		return toDtos(tbasg163GcFiltroTramoRepository.getGcFiltrosTramoListActive(cdgoConsulta));
	}

	public List<Tbasg163GcFiltroTramoDto> getGcFiltroTramo(String cdgoFiltroTramo) {
		return toDtos(tbasg163GcFiltroTramoRepository.getGcFiltroTramo(cdgoFiltroTramo));
	}

	public int insertGcFiltroTramo(Tbasg163GcFiltroTramo bean) {
		return tbasg163GcFiltroTramoRepository.insertGcFiltroTramo(bean);
	}

	public int deleteGcFiltrosTramo(Tbasg163GcFiltroTramo bean) {
		return tbasg163GcFiltroTramoRepository.deleteGcFiltrosTramo(bean);
	}

	public Tbasg163GcFiltroTramoDto toDto(Tbasg163GcFiltroTramo orig) {

		Tbasg163GcFiltroTramoDto dest = new Tbasg163GcFiltroTramoDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg163GcFiltroTramo toEntity(Tbasg163GcFiltroTramoDto orig) {

		Tbasg163GcFiltroTramo dest = new Tbasg163GcFiltroTramo();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg163GcFiltroTramoDto> toDtos(List<Tbasg163GcFiltroTramo> orig) {

		List<Tbasg163GcFiltroTramoDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg163GcFiltroTramo> toEntities(List<Tbasg163GcFiltroTramoDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg163GcFiltroTramo> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
