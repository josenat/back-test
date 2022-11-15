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

import renfe.com.dto.GetFcCualificacionListAscCdgoCategoriaDTO;
import renfe.com.model.dto.Tbasg156FcCualificacionDto;
import renfe.com.model.entity.Tbasg156FcCualificacion;
import renfe.com.repository.Tbasg156FcCualificacionRepository;

@Transactional
@Service
public class Tbasg156FcCualificacionServiceImpl implements Tbasg156FcCualificacionService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg156FcCualificacionRepository tbasg156FcCualificacionRepository;

	public List<Tbasg156FcCualificacionDto> getAllTbasg156FcCualificacion(Tbasg156FcCualificacionDto filter) {

		logger.info("getAllTbasg156FcCualificacion " + filter);
		if (filter == null) {
			return this.toDtos(tbasg156FcCualificacionRepository.findAll());
		}
		return this.toDtos(tbasg156FcCualificacionRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg156FcCualificacionDto findByCdgoCualificacion(Integer cdgoCualificacion) {

		Optional<Tbasg156FcCualificacion> tbasg156FcCualificacionData = tbasg156FcCualificacionRepository
				.findByCdgoCualificacion(cdgoCualificacion);

		if (tbasg156FcCualificacionData.isPresent()) {
			return toDto(tbasg156FcCualificacionData.get());
		}
		return null;
	}

	public Tbasg156FcCualificacionDto createTbasg156FcCualificacion(
			Tbasg156FcCualificacionDto tbasg156FcCualificacionDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg156FcCualificacion dbTbasg156FcCualificacion = new Tbasg156FcCualificacion();
		BeanUtils.copyProperties(dbTbasg156FcCualificacion, tbasg156FcCualificacionDto);
		Tbasg156FcCualificacion _tbasg156FcCualificacion = tbasg156FcCualificacionRepository
				.save(dbTbasg156FcCualificacion);
		return toDto(_tbasg156FcCualificacion);
	}

	public Tbasg156FcCualificacionDto updateTbasg156FcCualificacion(Integer cdgoCualificacion,
			Tbasg156FcCualificacionDto tbasg156FcCualificacionDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg156FcCualificacion> tbasg156FcCualificacionData = tbasg156FcCualificacionRepository
				.findById(cdgoCualificacion);

		if (tbasg156FcCualificacionData.isPresent()) {
			Tbasg156FcCualificacion dbTbasg156FcCualificacion = tbasg156FcCualificacionData.get();
			BeanUtils.copyProperties(dbTbasg156FcCualificacion, tbasg156FcCualificacionDto);
			return toDto(tbasg156FcCualificacionRepository.save(dbTbasg156FcCualificacion));
		}
		return null;
	}

	public int deleteTbasg156FcCualificacion(Integer cdgoCualificacion) {

		tbasg156FcCualificacionRepository.deleteById(cdgoCualificacion);
		return 1;
	}

	public List<Tbasg156FcCualificacionDto> findByCdgoCualificacionIn(List<Integer> cdgoCualificacion) {

		List<Tbasg156FcCualificacion> tbasg156FcCualificacions = tbasg156FcCualificacionRepository
				.findByCdgoCualificacionIn(cdgoCualificacion);

		return toDtos(tbasg156FcCualificacions);
	}

	public List<Tbasg156FcCualificacionDto> getFcCualificacion(String cdgoCategoria, String cdgoCualificacion) {
		return toDtos(tbasg156FcCualificacionRepository.getFcCualificacion(cdgoCategoria, cdgoCualificacion));
	}

	public List<Tbasg156FcCualificacionDto> getFcCualificacionView(String cdgoCategoria, String cdgoCualificacion) {
		return toDtos(tbasg156FcCualificacionRepository.getFcCualificacionView(cdgoCategoria, cdgoCualificacion));
	}

	public List<Tbasg156FcCualificacionDto> getFcCualificacionListAscendente() {
		return toDtos(tbasg156FcCualificacionRepository.getFcCualificacionListAscendente());
	}
	
	public List<GetFcCualificacionListAscCdgoCategoriaDTO> getFcCualificacionListAscCdgoCategoria(Integer cdgoCategoria) {
		return tbasg156FcCualificacionRepository.getFcCualificacionListAscCdgoCategoria(cdgoCategoria);
	}

	public List<Tbasg156FcCualificacionDto> getFcCualificacionListDescendente() {
		return toDtos(tbasg156FcCualificacionRepository.getFcCualificacionListDescendente());
	}

	public List<Tbasg156FcCualificacionDto> getFcCualificacionListAscendenteView(String cdgoCategoria) {
		return toDtos(tbasg156FcCualificacionRepository.getFcCualificacionListAscendenteView(cdgoCategoria));
	}

	public List<Tbasg156FcCualificacionDto> getFcCualificacionListDescendenteView(String cdgoCategoria) {
		return toDtos(tbasg156FcCualificacionRepository.getFcCualificacionListDescendenteView(cdgoCategoria));
	}

	public List<Tbasg156FcCualificacionDto> getFcCualificacionCount() {
		return toDtos(tbasg156FcCualificacionRepository.getFcCualificacionCount());
	}

	public List<Tbasg156FcCualificacionDto> getFcCualificacionViewCount(String cdgoCategoria) {
		return toDtos(tbasg156FcCualificacionRepository.getFcCualificacionViewCount(cdgoCategoria));
	}

	public List<Tbasg156FcCualificacionDto> getFcCualificacionListActive() {
		return toDtos(tbasg156FcCualificacionRepository.getFcCualificacionListActive());
	}

	public List<Tbasg156FcCualificacionDto> getFcCualificacionListOrderByCategoria() {
		return toDtos(tbasg156FcCualificacionRepository.getFcCualificacionListOrderByCategoria());
	}

	public List<Tbasg156FcCualificacionDto> getCualiForName(String desgDescripcion) {
		return tbasg156FcCualificacionRepository.getCualiForName(desgDescripcion);
	}

	public int insertFcCualificacion(Tbasg156FcCualificacion bean) {
		return tbasg156FcCualificacionRepository.insertFcCualificacion(bean);
	}

	public int estadoFcCualificacion(Tbasg156FcCualificacion bean) {
		return tbasg156FcCualificacionRepository.estadoFcCualificacion(bean);
	}
	
	public int updateFcCualificacion(Tbasg156FcCualificacion bean) {
		return tbasg156FcCualificacionRepository.updateFcCualificacion(bean);
	}

	public int deleteFcCualificacion(Tbasg156FcCualificacion bean) {
		return tbasg156FcCualificacionRepository.deleteFcCualificacion(bean);
	}

	public int reactiveFcCualificacion(Tbasg156FcCualificacion bean) {
		return tbasg156FcCualificacionRepository.reactiveFcCualificacion(bean);
	}

	public Tbasg156FcCualificacionDto toDto(Tbasg156FcCualificacion orig) {

		Tbasg156FcCualificacionDto dest = new Tbasg156FcCualificacionDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg156FcCualificacion toEntity(Tbasg156FcCualificacionDto orig) {

		Tbasg156FcCualificacion dest = new Tbasg156FcCualificacion();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg156FcCualificacionDto> toDtos(List<Tbasg156FcCualificacion> orig) {

		List<Tbasg156FcCualificacionDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg156FcCualificacion> toEntities(List<Tbasg156FcCualificacionDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg156FcCualificacion> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
