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

import renfe.com.model.dto.Tbasg134NacionDto;
import renfe.com.model.entity.Tbasg134Nacion;
import renfe.com.repository.Tbasg134NacionRepository;

@Transactional
@Service
public class Tbasg134NacionServiceImpl implements Tbasg134NacionService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg134NacionRepository tbasg134NacionRepository;

	public List<Tbasg134NacionDto> getAllTbasg134Nacion(Tbasg134NacionDto filter) {

		logger.info("getAllTbasg134Nacion " + filter);
		if (filter == null) {
			return this.toDtos(tbasg134NacionRepository.findAll());
		}
		return this.toDtos(tbasg134NacionRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg134NacionDto findByCdgoNacion(Integer cdgoNacion) {

		Optional<Tbasg134Nacion> tbasg134NacionData = tbasg134NacionRepository.findByCdgoNacion(cdgoNacion);

		if (tbasg134NacionData.isPresent()) {
			return toDto(tbasg134NacionData.get());
		}
		return null;
	}

	public Tbasg134NacionDto createTbasg134Nacion(Tbasg134NacionDto tbasg134NacionDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg134Nacion dbTbasg134Nacion = new Tbasg134Nacion();
		BeanUtils.copyProperties(dbTbasg134Nacion, tbasg134NacionDto);
		Tbasg134Nacion _tbasg134Nacion = tbasg134NacionRepository.save(dbTbasg134Nacion);
		return toDto(_tbasg134Nacion);
	}

	public Tbasg134NacionDto updateTbasg134Nacion(Integer cdgoNacion, Tbasg134NacionDto tbasg134NacionDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg134Nacion> tbasg134NacionData = tbasg134NacionRepository.findById(cdgoNacion);

		if (tbasg134NacionData.isPresent()) {
			Tbasg134Nacion dbTbasg134Nacion = tbasg134NacionData.get();
			BeanUtils.copyProperties(dbTbasg134Nacion, tbasg134NacionDto);
			return toDto(tbasg134NacionRepository.save(dbTbasg134Nacion));
		}
		return null;
	}

	public int deleteTbasg134Nacion(Integer cdgoNacion) {

		tbasg134NacionRepository.deleteById(cdgoNacion);
		return 1;
	}

	public List<Tbasg134NacionDto> findByCdgoNacionIn(List<Integer> cdgoNacion) {

		List<Tbasg134Nacion> tbasg134Nacions = tbasg134NacionRepository.findByCdgoNacionIn(cdgoNacion);

		return toDtos(tbasg134Nacions);
	}

	public List<Tbasg134NacionDto> getNacionCount() {
		return toDtos(tbasg134NacionRepository.getNacionCount());
	}

	public List<Tbasg134NacionDto> getNacionListAscendente() {
		return toDtos(tbasg134NacionRepository.getNacionListAscendente());
	}

	public List<Tbasg134NacionDto> getNacionListDescendente() {
		return toDtos(tbasg134NacionRepository.getNacionListDescendente());
	}

	public List<Tbasg134NacionDto> getNacionActiveListAscendente() {
		return toDtos(tbasg134NacionRepository.getNacionActiveListAscendente());
	}

	public List<Tbasg134NacionDto> getNacionActiveListDescendente() {
		return toDtos(tbasg134NacionRepository.getNacionActiveListDescendente());
	}

	public List<Tbasg134NacionDto> getNacion(String cdgoNacion) {
		return toDtos(tbasg134NacionRepository.getNacion(cdgoNacion));
	}

	public int insertNacion(Tbasg134Nacion bean) {
		return tbasg134NacionRepository.insertNacion(bean);
	}

	public int updateNacion(Tbasg134Nacion bean) {
		return tbasg134NacionRepository.updateNacion(bean);
	}

	public int estadoNacion(Tbasg134Nacion bean) {
		return tbasg134NacionRepository.estadoNacion(bean);
	}
	
	public Tbasg134NacionDto toDto(Tbasg134Nacion orig) {

		Tbasg134NacionDto dest = new Tbasg134NacionDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg134Nacion toEntity(Tbasg134NacionDto orig) {

		Tbasg134Nacion dest = new Tbasg134Nacion();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg134NacionDto> toDtos(List<Tbasg134Nacion> orig) {

		List<Tbasg134NacionDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg134Nacion> toEntities(List<Tbasg134NacionDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg134Nacion> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
