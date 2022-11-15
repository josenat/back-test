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

import renfe.com.model.dto.Tbasg129EntornosDto;
import renfe.com.model.entity.Tbasg129Entornos;
import renfe.com.repository.Tbasg129EntornosRepository;

@Service
public class Tbasg129EntornosServiceImpl implements Tbasg129EntornosService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg129EntornosRepository tbasg129EntornosRepository;

	public List<Tbasg129EntornosDto> getAllTbasg129Entornos(Tbasg129EntornosDto filter) {

		logger.info("getAllTbasg129Entornos " + filter);
		if (filter == null) {
			return this.toDtos(tbasg129EntornosRepository.findAll());
		}
		return this.toDtos(tbasg129EntornosRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg129EntornosDto findByCdgoEntorno(Integer cdgoEntorno) {

		Optional<Tbasg129Entornos> tbasg129EntornosData = tbasg129EntornosRepository.findByCdgoEntorno(cdgoEntorno);

		if (tbasg129EntornosData.isPresent()) {
			return toDto(tbasg129EntornosData.get());
		}
		return null;
	}

	public Tbasg129EntornosDto createTbasg129Entornos(Tbasg129EntornosDto tbasg129EntornosDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg129Entornos dbTbasg129Entornos = new Tbasg129Entornos();
		BeanUtils.copyProperties(dbTbasg129Entornos, tbasg129EntornosDto);
		Tbasg129Entornos _tbasg129Entornos = tbasg129EntornosRepository.save(dbTbasg129Entornos);
		return toDto(_tbasg129Entornos);
	}

	public Tbasg129EntornosDto updateTbasg129Entornos(Integer cdgoEntorno, Tbasg129EntornosDto tbasg129EntornosDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg129Entornos> tbasg129EntornosData = tbasg129EntornosRepository.findById(cdgoEntorno);

		if (tbasg129EntornosData.isPresent()) {
			Tbasg129Entornos dbTbasg129Entornos = tbasg129EntornosData.get();
			BeanUtils.copyProperties(dbTbasg129Entornos, tbasg129EntornosDto);
			return toDto(tbasg129EntornosRepository.save(dbTbasg129Entornos));
		}
		return null;
	}

	public int deleteTbasg129Entornos(Integer cdgoEntorno) {

		tbasg129EntornosRepository.deleteById(cdgoEntorno);
		return 1;
	}

	public List<Tbasg129EntornosDto> findByCdgoEntornoIn(List<Integer> cdgoEntorno) {

		List<Tbasg129Entornos> tbasg129Entornoss = tbasg129EntornosRepository.findByCdgoEntornoIn(cdgoEntorno);

		return toDtos(tbasg129Entornoss);
	}

	public List<Tbasg129EntornosDto> getEntornosCount() {
		return toDtos(tbasg129EntornosRepository.getEntornosCount());
	}

	public List<Tbasg129EntornosDto> getEntornosListAscendente() {
		return toDtos(tbasg129EntornosRepository.getEntornosListAscendente());
	}
	
	public List<Tbasg129EntornosDto> getEntornosList() {
		return toDtos(tbasg129EntornosRepository.getEntornosList());
	}

	public List<Tbasg129EntornosDto> getEntornosListDescendente() {
		return toDtos(tbasg129EntornosRepository.getEntornosListDescendente());
	}

	public List<Tbasg129EntornosDto> getEntornosActiveListAscendente(String nombreLargo) {
		return toDtos(tbasg129EntornosRepository.getEntornosActiveListAscendente(nombreLargo));
	}

	public List<Tbasg129EntornosDto> getEntornosActiveListDescendente(String nombreLargo) {
		return toDtos(tbasg129EntornosRepository.getEntornosActiveListDescendente(nombreLargo));
	}

	public List<Tbasg129EntornosDto> getEntornosActiveWithTramosListAscendente() {
		return toDtos(tbasg129EntornosRepository.getEntornosActiveWithTramosListAscendente());
	}

	public List<Tbasg129EntornosDto> getEntornosActiveWithTramosListDescendente() {
		return toDtos(tbasg129EntornosRepository.getEntornosActiveWithTramosListDescendente());
	}

	public List<Tbasg129EntornosDto> getEntornos(Integer cdgoEntorno) {
		return toDtos(tbasg129EntornosRepository.getEntornos(cdgoEntorno));
	}
	
	public List<Tbasg129EntornosDto> getEntornosNombre(String cdgoEntorno) {
		return toDtos(tbasg129EntornosRepository.getEntornosNombre(cdgoEntorno));
	}

	public List<Tbasg129EntornosDto> getAlcanceEntorno(Integer cdgoEntorno) {
		return toDtos(tbasg129EntornosRepository.getAlcanceEntorno(cdgoEntorno));
	}

	public List<Tbasg129EntornosDto> getEntornosByNomCorto(String desgNomcorto) {
		return toDtos(tbasg129EntornosRepository.getEntornosByNomCorto(desgNomcorto));
	}

	public int insertEntornos(Tbasg129Entornos bean) {
		return tbasg129EntornosRepository.insertEntornos(bean);
	}

	public int updateEntornos(Tbasg129Entornos bean) {
		return tbasg129EntornosRepository.updateEntornos(bean);
	}

	public Tbasg129EntornosDto toDto(Tbasg129Entornos orig) {

		Tbasg129EntornosDto dest = new Tbasg129EntornosDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg129Entornos toEntity(Tbasg129EntornosDto orig) {

		Tbasg129Entornos dest = new Tbasg129Entornos();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg129EntornosDto> toDtos(List<Tbasg129Entornos> orig) {

		List<Tbasg129EntornosDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg129Entornos> toEntities(List<Tbasg129EntornosDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg129Entornos> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}