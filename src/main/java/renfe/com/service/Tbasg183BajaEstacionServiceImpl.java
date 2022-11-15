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

import renfe.com.model.dto.Tbasg183BajaEstacionDto;
import renfe.com.model.entity.Tbasg183BajaEstacion;
import renfe.com.model.entity.Tbasg183BajaEstacionPK;
import renfe.com.repository.Tbasg183BajaEstacionRepository;

@Service
public class Tbasg183BajaEstacionServiceImpl implements Tbasg183BajaEstacionService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg183BajaEstacionRepository tbasg183BajaEstacionRepository;

	public List<Tbasg183BajaEstacionDto> getAllTbasg183BajaEstacion(Tbasg183BajaEstacionDto filter) {

		logger.info("getAllTbasg183BajaEstacion " + filter);
		if (filter == null) {
			return this.toDtos(tbasg183BajaEstacionRepository.findAll());
		}
		return this.toDtos(tbasg183BajaEstacionRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg183BajaEstacionDto findByCdgoEstacionCdgoLinea(String cdgoEstacion, String cdgoLinea) {
		Tbasg183BajaEstacionPK pk = new Tbasg183BajaEstacionPK();
		pk.setCdgoEstacion(cdgoEstacion);
		pk.setCdgoLinea(cdgoLinea);
		Optional<Tbasg183BajaEstacion> tbasg183BajaEstacionData = tbasg183BajaEstacionRepository.findById(pk);

		if (tbasg183BajaEstacionData.isPresent()) {
			return toDto(tbasg183BajaEstacionData.get());
		}
		return null;
	}

	public Tbasg183BajaEstacionDto createTbasg183BajaEstacion(Tbasg183BajaEstacionDto tbasg183BajaEstacionDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg183BajaEstacion dbTbasg183BajaEstacion = new Tbasg183BajaEstacion();
		BeanUtils.copyProperties(dbTbasg183BajaEstacion, tbasg183BajaEstacionDto);
		Tbasg183BajaEstacion _tbasg183BajaEstacion = tbasg183BajaEstacionRepository.save(dbTbasg183BajaEstacion);
		return toDto(_tbasg183BajaEstacion);
	}

	public Tbasg183BajaEstacionDto updateTbasg183BajaEstacion(String cdgoEstacion, String cdgoLinea,
			Tbasg183BajaEstacionDto tbasg183BajaEstacionDto) throws IllegalAccessException, InvocationTargetException {
		Tbasg183BajaEstacionPK pk = new Tbasg183BajaEstacionPK();
		pk.setCdgoEstacion(cdgoEstacion);
		pk.setCdgoLinea(cdgoLinea);
		Optional<Tbasg183BajaEstacion> tbasg183BajaEstacionData = tbasg183BajaEstacionRepository.findById(pk);

		if (tbasg183BajaEstacionData.isPresent()) {
			Tbasg183BajaEstacion dbTbasg183BajaEstacion = tbasg183BajaEstacionData.get();
			BeanUtils.copyProperties(dbTbasg183BajaEstacion, tbasg183BajaEstacionDto);
			return toDto(tbasg183BajaEstacionRepository.save(dbTbasg183BajaEstacion));
		}
		return null;
	}

	public int deleteTbasg183BajaEstacion(String cdgoEstacion, String cdgoLinea) {
		Tbasg183BajaEstacionPK pk = new Tbasg183BajaEstacionPK();
		pk.setCdgoEstacion(cdgoEstacion);
		pk.setCdgoLinea(cdgoLinea);
		tbasg183BajaEstacionRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg183BajaEstacionDto> findByCdgoEstacionCdgoLineaIn(List<String> cdgoEstacion,
			List<String> cdgoLinea) {
		List<Tbasg183BajaEstacionPK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoEstacion.size(); i++) {
			Tbasg183BajaEstacionPK newPk = new Tbasg183BajaEstacionPK();
			newPk.setCdgoEstacion(cdgoEstacion.get(i));
			newPk.setCdgoLinea(cdgoLinea.get(i));
			pks.add(newPk);
		}
		List<Tbasg183BajaEstacion> tbasg183BajaEstacions = tbasg183BajaEstacionRepository
				.findByTbasg183bajaestacionpkIn(pks);

		return toDtos(tbasg183BajaEstacions);
	}

	public List<Tbasg183BajaEstacionDto> getBajaEstacion(String cdgoEstacion, String cdgoLinea) {
		return toDtos(tbasg183BajaEstacionRepository.getBajaEstacion(cdgoEstacion, cdgoLinea));
	}

	public int insertBajaEstacion(Tbasg183BajaEstacion bean) {
		return tbasg183BajaEstacionRepository.insertBajaEstacion(bean);
	}

	public Tbasg183BajaEstacionDto toDto(Tbasg183BajaEstacion orig) {

		Tbasg183BajaEstacionDto dest = new Tbasg183BajaEstacionDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg183BajaEstacion toEntity(Tbasg183BajaEstacionDto orig) {

		Tbasg183BajaEstacion dest = new Tbasg183BajaEstacion();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg183BajaEstacionDto> toDtos(List<Tbasg183BajaEstacion> orig) {

		List<Tbasg183BajaEstacionDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg183BajaEstacion> toEntities(List<Tbasg183BajaEstacionDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg183BajaEstacion> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
