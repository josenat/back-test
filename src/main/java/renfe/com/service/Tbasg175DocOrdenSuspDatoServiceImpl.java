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

import renfe.com.model.dto.Tbasg175DocOrdenSuspDatoDto;
import renfe.com.model.entity.Tbasg175DocOrdenSuspDato;
import renfe.com.model.entity.Tbasg175DocOrdenSuspDatoPK;
import renfe.com.repository.Tbasg175DocOrdenSuspDatoRepository;

@Service
public class Tbasg175DocOrdenSuspDatoServiceImpl implements Tbasg175DocOrdenSuspDatoService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg175DocOrdenSuspDatoRepository tbasg175DocOrdenSuspDatoRepository;

	public List<Tbasg175DocOrdenSuspDatoDto> getAllTbasg175DocOrdenSuspDato(Tbasg175DocOrdenSuspDatoDto filter) {

		logger.info("getAllTbasg175DocOrdenSuspDato " + filter);
		if (filter == null) {
			return this.toDtos(tbasg175DocOrdenSuspDatoRepository.findAll());
		}
		return this.toDtos(tbasg175DocOrdenSuspDatoRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg175DocOrdenSuspDatoDto findByCdgoClaveCdgoReferenciadoc(Integer cdgoClave, Integer cdgoReferenciadoc) {
		Tbasg175DocOrdenSuspDatoPK pk = new Tbasg175DocOrdenSuspDatoPK();
		pk.setCdgoClave(cdgoClave);
		pk.setCdgoReferenciadoc(cdgoReferenciadoc);
		Optional<Tbasg175DocOrdenSuspDato> tbasg175DocOrdenSuspDatoData = tbasg175DocOrdenSuspDatoRepository
				.findById(pk);

		if (tbasg175DocOrdenSuspDatoData.isPresent()) {
			return toDto(tbasg175DocOrdenSuspDatoData.get());
		}
		return null;
	}

	public Tbasg175DocOrdenSuspDatoDto createTbasg175DocOrdenSuspDato(
			Tbasg175DocOrdenSuspDatoDto tbasg175DocOrdenSuspDatoDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg175DocOrdenSuspDato dbTbasg175DocOrdenSuspDato = new Tbasg175DocOrdenSuspDato();
		BeanUtils.copyProperties(dbTbasg175DocOrdenSuspDato, tbasg175DocOrdenSuspDatoDto);
		Tbasg175DocOrdenSuspDato _tbasg175DocOrdenSuspDato = tbasg175DocOrdenSuspDatoRepository
				.save(dbTbasg175DocOrdenSuspDato);
		return toDto(_tbasg175DocOrdenSuspDato);
	}

	public Tbasg175DocOrdenSuspDatoDto updateTbasg175DocOrdenSuspDato(Integer cdgoClave, Integer cdgoReferenciadoc,
			Tbasg175DocOrdenSuspDatoDto tbasg175DocOrdenSuspDatoDto)
			throws IllegalAccessException, InvocationTargetException {
		Tbasg175DocOrdenSuspDatoPK pk = new Tbasg175DocOrdenSuspDatoPK();
		pk.setCdgoClave(cdgoClave);
		pk.setCdgoReferenciadoc(cdgoReferenciadoc);
		Optional<Tbasg175DocOrdenSuspDato> tbasg175DocOrdenSuspDatoData = tbasg175DocOrdenSuspDatoRepository
				.findById(pk);

		if (tbasg175DocOrdenSuspDatoData.isPresent()) {
			Tbasg175DocOrdenSuspDato dbTbasg175DocOrdenSuspDato = tbasg175DocOrdenSuspDatoData.get();
			BeanUtils.copyProperties(dbTbasg175DocOrdenSuspDato, tbasg175DocOrdenSuspDatoDto);
			return toDto(tbasg175DocOrdenSuspDatoRepository.save(dbTbasg175DocOrdenSuspDato));
		}
		return null;
	}

	public int deleteTbasg175DocOrdenSuspDato(Integer cdgoClave, Integer cdgoReferenciadoc) {
		Tbasg175DocOrdenSuspDatoPK pk = new Tbasg175DocOrdenSuspDatoPK();
		pk.setCdgoClave(cdgoClave);
		pk.setCdgoReferenciadoc(cdgoReferenciadoc);
		tbasg175DocOrdenSuspDatoRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg175DocOrdenSuspDatoDto> findByCdgoClaveCdgoReferenciadocIn(List<Integer> cdgoClave,
			List<Integer> cdgoReferenciadoc) {
		List<Tbasg175DocOrdenSuspDatoPK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoClave.size(); i++) {
			Tbasg175DocOrdenSuspDatoPK newPk = new Tbasg175DocOrdenSuspDatoPK();
			newPk.setCdgoClave(cdgoClave.get(i));
			newPk.setCdgoReferenciadoc(cdgoReferenciadoc.get(i));
			pks.add(newPk);
		}
		List<Tbasg175DocOrdenSuspDato> tbasg175DocOrdenSuspDatos = tbasg175DocOrdenSuspDatoRepository
				.findByTbasg175docordensuspdatopkIn(pks);

		return toDtos(tbasg175DocOrdenSuspDatos);
	}

	public List<Tbasg175DocOrdenSuspDatoDto> getDocOrdenSuspDatoActiveList(String cdgoReferenciadoc) {
		return toDtos(tbasg175DocOrdenSuspDatoRepository.getDocOrdenSuspDatoActiveList(cdgoReferenciadoc));
	}

	public List<Tbasg175DocOrdenSuspDatoDto> getDocOrdenSuspDatoList(String cdgoReferenciadoc) {
		return toDtos(tbasg175DocOrdenSuspDatoRepository.getDocOrdenSuspDatoList(cdgoReferenciadoc));
	}

	public List<Tbasg175DocOrdenSuspDatoDto> getDocOrdenSuspDato(String cdgoReferenciadoc, String cdgoClave) {
		return toDtos(tbasg175DocOrdenSuspDatoRepository.getDocOrdenSuspDato(cdgoReferenciadoc, cdgoClave));
	}

	public int insertDocOrdenSuspDato(Tbasg175DocOrdenSuspDato bean) {
		return tbasg175DocOrdenSuspDatoRepository.insertDocOrdenSuspDato(bean);
	}

	public int updateDocOrdenSuspDato(Tbasg175DocOrdenSuspDato bean) {
		return tbasg175DocOrdenSuspDatoRepository.updateDocOrdenSuspDato(bean);
	}

	public Tbasg175DocOrdenSuspDatoDto toDto(Tbasg175DocOrdenSuspDato orig) {

		Tbasg175DocOrdenSuspDatoDto dest = new Tbasg175DocOrdenSuspDatoDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg175DocOrdenSuspDato toEntity(Tbasg175DocOrdenSuspDatoDto orig) {

		Tbasg175DocOrdenSuspDato dest = new Tbasg175DocOrdenSuspDato();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg175DocOrdenSuspDatoDto> toDtos(List<Tbasg175DocOrdenSuspDato> orig) {

		List<Tbasg175DocOrdenSuspDatoDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg175DocOrdenSuspDato> toEntities(List<Tbasg175DocOrdenSuspDatoDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg175DocOrdenSuspDato> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
