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

import renfe.com.model.dto.Tbasg182AltaEstacionDto;
import renfe.com.model.entity.Tbasg182AltaEstacion;
import renfe.com.model.entity.Tbasg182AltaEstacionPK;
import renfe.com.repository.Tbasg182AltaEstacionRepository;

@Service
public class Tbasg182AltaEstacionServiceImpl implements Tbasg182AltaEstacionService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg182AltaEstacionRepository tbasg182AltaEstacionRepository;

	public List<Tbasg182AltaEstacionDto> getAllTbasg182AltaEstacion(Tbasg182AltaEstacionDto filter) {

		logger.info("getAllTbasg182AltaEstacion " + filter);
		if (filter == null) {
			return this.toDtos(tbasg182AltaEstacionRepository.findAll());
		}
		return this.toDtos(tbasg182AltaEstacionRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg182AltaEstacionDto findByCdgoEstacionCdgoLinea(String cdgoEstacion, String cdgoLinea) {
		Tbasg182AltaEstacionPK pk = new Tbasg182AltaEstacionPK();
		pk.setCdgoEstacion(cdgoEstacion);
		pk.setCdgoLinea(cdgoLinea);
		Optional<Tbasg182AltaEstacion> tbasg182AltaEstacionData = tbasg182AltaEstacionRepository.findById(pk);

		if (tbasg182AltaEstacionData.isPresent()) {
			return toDto(tbasg182AltaEstacionData.get());
		}
		return null;
	}

	public Tbasg182AltaEstacionDto createTbasg182AltaEstacion(Tbasg182AltaEstacionDto tbasg182AltaEstacionDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg182AltaEstacion dbTbasg182AltaEstacion = new Tbasg182AltaEstacion();
		BeanUtils.copyProperties(dbTbasg182AltaEstacion, tbasg182AltaEstacionDto);
		Tbasg182AltaEstacion _tbasg182AltaEstacion = tbasg182AltaEstacionRepository.save(dbTbasg182AltaEstacion);
		return toDto(_tbasg182AltaEstacion);
	}

	public Tbasg182AltaEstacionDto updateTbasg182AltaEstacion(String cdgoEstacion, String cdgoLinea,
			Tbasg182AltaEstacionDto tbasg182AltaEstacionDto) throws IllegalAccessException, InvocationTargetException {
		Tbasg182AltaEstacionPK pk = new Tbasg182AltaEstacionPK();
		pk.setCdgoEstacion(cdgoEstacion);
		pk.setCdgoLinea(cdgoLinea);
		Optional<Tbasg182AltaEstacion> tbasg182AltaEstacionData = tbasg182AltaEstacionRepository.findById(pk);

		if (tbasg182AltaEstacionData.isPresent()) {
			Tbasg182AltaEstacion dbTbasg182AltaEstacion = tbasg182AltaEstacionData.get();
			BeanUtils.copyProperties(dbTbasg182AltaEstacion, tbasg182AltaEstacionDto);
			return toDto(tbasg182AltaEstacionRepository.save(dbTbasg182AltaEstacion));
		}
		return null;
	}

	public int deleteTbasg182AltaEstacion(String cdgoEstacion, String cdgoLinea) {
		Tbasg182AltaEstacionPK pk = new Tbasg182AltaEstacionPK();
		pk.setCdgoEstacion(cdgoEstacion);
		pk.setCdgoLinea(cdgoLinea);
		tbasg182AltaEstacionRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg182AltaEstacionDto> findByCdgoEstacionCdgoLineaIn(List<String> cdgoEstacion,
			List<String> cdgoLinea) {
		List<Tbasg182AltaEstacionPK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoEstacion.size(); i++) {
			Tbasg182AltaEstacionPK newPk = new Tbasg182AltaEstacionPK();
			newPk.setCdgoEstacion(cdgoEstacion.get(i));
			newPk.setCdgoLinea(cdgoLinea.get(i));
			pks.add(newPk);
		}
		List<Tbasg182AltaEstacion> tbasg182AltaEstacions = tbasg182AltaEstacionRepository
				.findByTbasg182altaestacionpkIn(pks);

		return toDtos(tbasg182AltaEstacions);
	}

	public List<Tbasg182AltaEstacionDto> getAltaEstacion(String cdgoEstacion, String cdgoLinea) {
		return toDtos(tbasg182AltaEstacionRepository.getAltaEstacion(cdgoEstacion, cdgoLinea));
	}

	public int insertAltaEstacion(Tbasg182AltaEstacion bean) {
		return tbasg182AltaEstacionRepository.insertAltaEstacion(bean);
	}

	public Tbasg182AltaEstacionDto toDto(Tbasg182AltaEstacion orig) {

		Tbasg182AltaEstacionDto dest = new Tbasg182AltaEstacionDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg182AltaEstacion toEntity(Tbasg182AltaEstacionDto orig) {

		Tbasg182AltaEstacion dest = new Tbasg182AltaEstacion();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg182AltaEstacionDto> toDtos(List<Tbasg182AltaEstacion> orig) {

		List<Tbasg182AltaEstacionDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg182AltaEstacion> toEntities(List<Tbasg182AltaEstacionDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg182AltaEstacion> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
