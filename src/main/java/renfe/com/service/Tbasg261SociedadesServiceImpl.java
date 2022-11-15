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

import renfe.com.model.dto.Tbasg261SociedadesDto;
import renfe.com.model.entity.Tbasg261Sociedades;
import renfe.com.repository.Tbasg261SociedadesRepository;

@Transactional
@Service
public class Tbasg261SociedadesServiceImpl implements Tbasg261SociedadesService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg261SociedadesRepository tbasg261SociedadesRepository;

	public List<Tbasg261SociedadesDto> getAllTbasg261Sociedades(Tbasg261SociedadesDto filter) {

		logger.info("getAllTbasg261Sociedades " + filter);
		if (filter == null) {
			return this.toDtos(tbasg261SociedadesRepository.findAll());
		}
		return this.toDtos(tbasg261SociedadesRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg261SociedadesDto findByCdgoSociedad(String cdgoSociedad) {

		Optional<Tbasg261Sociedades> tbasg261SociedadesData = tbasg261SociedadesRepository
				.findByCdgoSociedad(cdgoSociedad);

		if (tbasg261SociedadesData.isPresent()) {
			return toDto(tbasg261SociedadesData.get());
		}
		return null;
	}

	public Tbasg261SociedadesDto createTbasg261Sociedades(Tbasg261SociedadesDto tbasg261SociedadesDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg261Sociedades dbTbasg261Sociedades = new Tbasg261Sociedades();
		BeanUtils.copyProperties(dbTbasg261Sociedades, tbasg261SociedadesDto);
		Tbasg261Sociedades _tbasg261Sociedades = tbasg261SociedadesRepository.save(dbTbasg261Sociedades);
		return toDto(_tbasg261Sociedades);
	}

	public Tbasg261SociedadesDto updateTbasg261Sociedades(String cdgoSociedad,
			Tbasg261SociedadesDto tbasg261SociedadesDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg261Sociedades> tbasg261SociedadesData = tbasg261SociedadesRepository.findById(cdgoSociedad);

		if (tbasg261SociedadesData.isPresent()) {
			Tbasg261Sociedades dbTbasg261Sociedades = tbasg261SociedadesData.get();
			BeanUtils.copyProperties(dbTbasg261Sociedades, tbasg261SociedadesDto);
			return toDto(tbasg261SociedadesRepository.save(dbTbasg261Sociedades));
		}
		return null;
	}

	public int deleteTbasg261Sociedades(String cdgoSociedad) {

		tbasg261SociedadesRepository.deleteById(cdgoSociedad);
		return 1;
	}

	public List<Tbasg261SociedadesDto> findByCdgoSociedadIn(List<String> cdgoSociedad) {

		List<Tbasg261Sociedades> tbasg261Sociedadess = tbasg261SociedadesRepository.findByCdgoSociedadIn(cdgoSociedad);

		return toDtos(tbasg261Sociedadess);
	}

	public List<Tbasg261SociedadesDto> getSociedadCount() {
		return toDtos(tbasg261SociedadesRepository.getSociedadCount());
	}

	public List<Tbasg261SociedadesDto> getSociedadListAscendente() {
		return toDtos(tbasg261SociedadesRepository.getSociedadListAscendente());
	}
	
	public List<Tbasg261SociedadesDto> getSociedadActiveListAscendente() {
		return toDtos(tbasg261SociedadesRepository.getSociedadActiveListAscendente());
	}

	public List<Tbasg261SociedadesDto> getSociedadListDescendente() {
		return toDtos(tbasg261SociedadesRepository.getSociedadListDescendente());
	}

	public List<Tbasg261SociedadesDto> getSociedad(String cdgoSociedad) {
		return toDtos(tbasg261SociedadesRepository.getSociedad(cdgoSociedad));
	}

	public List<Tbasg261SociedadesDto> getSociedadByNombre(String descSociedad) {
		return toDtos(tbasg261SociedadesRepository.getSociedadByNombre(descSociedad));
	}

	public List<Tbasg261SociedadesDto> getSociedadListActive() {
		return toDtos(tbasg261SociedadesRepository.getSociedadListActive());
	}

	public int insertSociedad(Tbasg261Sociedades bean) {
		return tbasg261SociedadesRepository.insertSociedad(bean);
	}

	public int updateSociedad(Tbasg261Sociedades bean) {
		return tbasg261SociedadesRepository.updateSociedad(bean);
	}

	public int estadoSociedad(Tbasg261Sociedades bean) {
		return tbasg261SociedadesRepository.estadoSociedad(bean);
	}
	
	public Tbasg261SociedadesDto toDto(Tbasg261Sociedades orig) {

		Tbasg261SociedadesDto dest = new Tbasg261SociedadesDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg261Sociedades toEntity(Tbasg261SociedadesDto orig) {

		Tbasg261Sociedades dest = new Tbasg261Sociedades();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg261SociedadesDto> toDtos(List<Tbasg261Sociedades> orig) {

		List<Tbasg261SociedadesDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg261Sociedades> toEntities(List<Tbasg261SociedadesDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg261Sociedades> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
