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

import renfe.com.model.dto.Tbasg169TipoAnotacionDto;
import renfe.com.model.entity.Tbasg169TipoAnotacion;
import renfe.com.repository.Tbasg169TipoAnotacionRepository;

@Service
public class Tbasg169TipoAnotacionServiceImpl implements Tbasg169TipoAnotacionService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg169TipoAnotacionRepository tbasg169TipoAnotacionRepository;

	public List<Tbasg169TipoAnotacionDto> getAllTbasg169TipoAnotacion(Tbasg169TipoAnotacionDto filter) {

		logger.info("getAllTbasg169TipoAnotacion " + filter);
		if (filter == null) {
			return this.toDtos(tbasg169TipoAnotacionRepository.findAll());
		}
		return this.toDtos(tbasg169TipoAnotacionRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg169TipoAnotacionDto findByCdgoTipoanotacion(String cdgoTipoanotacion) {

		Optional<Tbasg169TipoAnotacion> tbasg169TipoAnotacionData = tbasg169TipoAnotacionRepository
				.findByCdgoTipoanotacion(cdgoTipoanotacion);

		if (tbasg169TipoAnotacionData.isPresent()) {
			return toDto(tbasg169TipoAnotacionData.get());
		}
		return null;
	}

	public Tbasg169TipoAnotacionDto createTbasg169TipoAnotacion(Tbasg169TipoAnotacionDto tbasg169TipoAnotacionDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg169TipoAnotacion dbTbasg169TipoAnotacion = new Tbasg169TipoAnotacion();
		BeanUtils.copyProperties(dbTbasg169TipoAnotacion, tbasg169TipoAnotacionDto);
		Tbasg169TipoAnotacion _tbasg169TipoAnotacion = tbasg169TipoAnotacionRepository.save(dbTbasg169TipoAnotacion);
		return toDto(_tbasg169TipoAnotacion);
	}

	public Tbasg169TipoAnotacionDto updateTbasg169TipoAnotacion(String cdgoTipoanotacion,
			Tbasg169TipoAnotacionDto tbasg169TipoAnotacionDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg169TipoAnotacion> tbasg169TipoAnotacionData = tbasg169TipoAnotacionRepository
				.findById(cdgoTipoanotacion);

		if (tbasg169TipoAnotacionData.isPresent()) {
			Tbasg169TipoAnotacion dbTbasg169TipoAnotacion = tbasg169TipoAnotacionData.get();
			BeanUtils.copyProperties(dbTbasg169TipoAnotacion, tbasg169TipoAnotacionDto);
			return toDto(tbasg169TipoAnotacionRepository.save(dbTbasg169TipoAnotacion));
		}
		return null;
	}

	public int deleteTbasg169TipoAnotacion(String cdgoTipoanotacion) {

		tbasg169TipoAnotacionRepository.deleteById(cdgoTipoanotacion);
		return 1;
	}

	public List<Tbasg169TipoAnotacionDto> findByCdgoTipoanotacionIn(List<String> cdgoTipoanotacion) {

		List<Tbasg169TipoAnotacion> tbasg169TipoAnotacions = tbasg169TipoAnotacionRepository
				.findByCdgoTipoanotacionIn(cdgoTipoanotacion);

		return toDtos(tbasg169TipoAnotacions);
	}

	public List<Tbasg169TipoAnotacionDto> getTipoAnotacionInspectorActiveList() {
		return toDtos(tbasg169TipoAnotacionRepository.getTipoAnotacionInspectorActiveList());
	}

	public Tbasg169TipoAnotacionDto toDto(Tbasg169TipoAnotacion orig) {

		Tbasg169TipoAnotacionDto dest = new Tbasg169TipoAnotacionDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg169TipoAnotacion toEntity(Tbasg169TipoAnotacionDto orig) {

		Tbasg169TipoAnotacion dest = new Tbasg169TipoAnotacion();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg169TipoAnotacionDto> toDtos(List<Tbasg169TipoAnotacion> orig) {

		List<Tbasg169TipoAnotacionDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg169TipoAnotacion> toEntities(List<Tbasg169TipoAnotacionDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg169TipoAnotacion> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
