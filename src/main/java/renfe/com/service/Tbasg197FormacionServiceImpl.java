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

import renfe.com.model.dto.Tbasg197FormacionDto;
import renfe.com.model.entity.Tbasg197Formacion;
import renfe.com.repository.Tbasg197FormacionRepository;

@Service
public class Tbasg197FormacionServiceImpl implements Tbasg197FormacionService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg197FormacionRepository tbasg197FormacionRepository;

	public List<Tbasg197FormacionDto> getAllTbasg197Formacion(Tbasg197FormacionDto filter) {

		logger.info("getAllTbasg197Formacion " + filter);
		if (filter == null) {
			return this.toDtos(tbasg197FormacionRepository.findAll());
		}
		return this.toDtos(tbasg197FormacionRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg197FormacionDto findByCdgoSolicitud(Integer cdgoSolicitud) {

		Optional<Tbasg197Formacion> tbasg197FormacionData = tbasg197FormacionRepository
				.findByCdgoSolicitud(cdgoSolicitud);

		if (tbasg197FormacionData.isPresent()) {
			return toDto(tbasg197FormacionData.get());
		}
		return null;
	}

	public Tbasg197FormacionDto createTbasg197Formacion(Tbasg197FormacionDto tbasg197FormacionDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg197Formacion dbTbasg197Formacion = new Tbasg197Formacion();
		BeanUtils.copyProperties(dbTbasg197Formacion, tbasg197FormacionDto);
		Tbasg197Formacion _tbasg197Formacion = tbasg197FormacionRepository.save(dbTbasg197Formacion);
		return toDto(_tbasg197Formacion);
	}

	public Tbasg197FormacionDto updateTbasg197Formacion(Integer cdgoSolicitud,
			Tbasg197FormacionDto tbasg197FormacionDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg197Formacion> tbasg197FormacionData = tbasg197FormacionRepository.findById(cdgoSolicitud);

		if (tbasg197FormacionData.isPresent()) {
			Tbasg197Formacion dbTbasg197Formacion = tbasg197FormacionData.get();
			BeanUtils.copyProperties(dbTbasg197Formacion, tbasg197FormacionDto);
			return toDto(tbasg197FormacionRepository.save(dbTbasg197Formacion));
		}
		return null;
	}

	public int deleteTbasg197Formacion(Integer cdgoSolicitud) {

		tbasg197FormacionRepository.deleteById(cdgoSolicitud);
		return 1;
	}

	public List<Tbasg197FormacionDto> findByCdgoSolicitudIn(List<Integer> cdgoSolicitud) {

		List<Tbasg197Formacion> tbasg197Formacions = tbasg197FormacionRepository.findByCdgoSolicitudIn(cdgoSolicitud);

		return toDtos(tbasg197Formacions);
	}

	public List<Tbasg197FormacionDto> getAlcaForma(String cdgoSolicitud) {
		return toDtos(tbasg197FormacionRepository.getAlcaForma(cdgoSolicitud));
	}

	public List<Tbasg197FormacionDto> getFormacionByDniNif(String desgNifpas) {
		return toDtos(tbasg197FormacionRepository.getFormacionByDniNif(desgNifpas));
	}

	public List<Tbasg197FormacionDto> getFormacionExpediente(Integer cdgoExpedient) {
		return toDtos(tbasg197FormacionRepository.getFormacionExpediente(cdgoExpedient));
	}

	public List<Tbasg197FormacionDto> getMaxFormacionExpediente(String cdgoExpedient) {
		return toDtos(tbasg197FormacionRepository.getMaxFormacionExpediente(cdgoExpedient));
	}

	public List<Tbasg197FormacionDto> getReciclajeExpediente(Integer cdgoExpedient) {
		return toDtos(tbasg197FormacionRepository.getReciclajeExpediente(cdgoExpedient));
	}

	public List<Tbasg197FormacionDto> getReciclajeTituloCond(String cdgoTit) {
		return toDtos(tbasg197FormacionRepository.getReciclajeTituloCond(cdgoTit));
	}

	public List<Tbasg197FormacionDto> getFormacionValores() {
		return toDtos(tbasg197FormacionRepository.getFormacionValores());
	}

	public int insertFormacion(Tbasg197Formacion bean) {
		return tbasg197FormacionRepository.insertFormacion(bean);
	}

	public int deleteFormacion(Integer cdgoSolicitud) {
		return tbasg197FormacionRepository.deleteFormacion(cdgoSolicitud);
	}

	public Tbasg197FormacionDto toDto(Tbasg197Formacion orig) {

		Tbasg197FormacionDto dest = new Tbasg197FormacionDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg197Formacion toEntity(Tbasg197FormacionDto orig) {

		Tbasg197Formacion dest = new Tbasg197Formacion();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg197FormacionDto> toDtos(List<Tbasg197Formacion> orig) {

		List<Tbasg197FormacionDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg197Formacion> toEntities(List<Tbasg197FormacionDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg197Formacion> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
