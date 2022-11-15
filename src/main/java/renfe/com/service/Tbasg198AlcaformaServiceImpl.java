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

import renfe.com.model.dto.Tbasg198AlcaformaDto;
import renfe.com.model.entity.Tbasg198Alcaforma;
import renfe.com.model.entity.Tbasg198AlcaformaPK;
import renfe.com.repository.Tbasg198AlcaformaRepository;

@Transactional
@Service
public class Tbasg198AlcaformaServiceImpl implements Tbasg198AlcaformaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg198AlcaformaRepository tbasg198AlcaformaRepository;

	public List<Tbasg198AlcaformaDto> getAllTbasg198Alcaforma(Tbasg198AlcaformaDto filter) {

		logger.info("getAllTbasg198Alcaforma " + filter);
		if (filter == null) {
			return this.toDtos(tbasg198AlcaformaRepository.findAll());
		}
		return this.toDtos(tbasg198AlcaformaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg198AlcaformaDto findByCdgoDestinoCdgoLineaCdgoOrigenCdgoSolicitud(String cdgoDestino, String cdgoLinea,
			String cdgoOrigen, Integer cdgoSolicitud) {
		Tbasg198AlcaformaPK pk = new Tbasg198AlcaformaPK();
		pk.setCdgoDestino(cdgoDestino);
		pk.setCdgoLinea(cdgoLinea);
		pk.setCdgoOrigen(cdgoOrigen);
		pk.setCdgoSolicitud(cdgoSolicitud);
		Optional<Tbasg198Alcaforma> tbasg198AlcaformaData = tbasg198AlcaformaRepository.findById(pk);

		if (tbasg198AlcaformaData.isPresent()) {
			return toDto(tbasg198AlcaformaData.get());
		}
		return null;
	}

	public Tbasg198AlcaformaDto createTbasg198Alcaforma(Tbasg198AlcaformaDto tbasg198AlcaformaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg198Alcaforma dbTbasg198Alcaforma = new Tbasg198Alcaforma();
		BeanUtils.copyProperties(dbTbasg198Alcaforma, tbasg198AlcaformaDto);
		Tbasg198Alcaforma _tbasg198Alcaforma = tbasg198AlcaformaRepository.save(dbTbasg198Alcaforma);
		return toDto(_tbasg198Alcaforma);
	}

	public Tbasg198AlcaformaDto updateTbasg198Alcaforma(String cdgoDestino, String cdgoLinea, String cdgoOrigen,
			Integer cdgoSolicitud, Tbasg198AlcaformaDto tbasg198AlcaformaDto)
			throws IllegalAccessException, InvocationTargetException {
		Tbasg198AlcaformaPK pk = new Tbasg198AlcaformaPK();
		pk.setCdgoDestino(cdgoDestino);
		pk.setCdgoLinea(cdgoLinea);
		pk.setCdgoOrigen(cdgoOrigen);
		pk.setCdgoSolicitud(cdgoSolicitud);
		Optional<Tbasg198Alcaforma> tbasg198AlcaformaData = tbasg198AlcaformaRepository.findById(pk);

		if (tbasg198AlcaformaData.isPresent()) {
			Tbasg198Alcaforma dbTbasg198Alcaforma = tbasg198AlcaformaData.get();
			BeanUtils.copyProperties(dbTbasg198Alcaforma, tbasg198AlcaformaDto);
			return toDto(tbasg198AlcaformaRepository.save(dbTbasg198Alcaforma));
		}
		return null;
	}

	public int deleteTbasg198Alcaforma(String cdgoDestino, String cdgoLinea, String cdgoOrigen, Integer cdgoSolicitud) {
		Tbasg198AlcaformaPK pk = new Tbasg198AlcaformaPK();
		pk.setCdgoDestino(cdgoDestino);
		pk.setCdgoLinea(cdgoLinea);
		pk.setCdgoOrigen(cdgoOrigen);
		pk.setCdgoSolicitud(cdgoSolicitud);
		tbasg198AlcaformaRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg198AlcaformaDto> findByCdgoDestinoCdgoLineaCdgoOrigenCdgoSolicitudIn(List<String> cdgoDestino,
			List<String> cdgoLinea, List<String> cdgoOrigen, List<Integer> cdgoSolicitud) {
		List<Tbasg198AlcaformaPK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoDestino.size(); i++) {
			Tbasg198AlcaformaPK newPk = new Tbasg198AlcaformaPK();
			newPk.setCdgoDestino(cdgoDestino.get(i));
			newPk.setCdgoLinea(cdgoLinea.get(i));
			newPk.setCdgoOrigen(cdgoOrigen.get(i));
			newPk.setCdgoSolicitud(cdgoSolicitud.get(i));
			pks.add(newPk);
		}
		List<Tbasg198Alcaforma> tbasg198Alcaformas = tbasg198AlcaformaRepository.findByTbasg198alcaformapkIn(pks);

		return toDtos(tbasg198Alcaformas);
	}

	public int insertAlcaForma(Tbasg198Alcaforma bean) {
		return tbasg198AlcaformaRepository.insertAlcaForma(bean);
	}

	public int deleteAlcaForma(Tbasg198Alcaforma bean) {
		return tbasg198AlcaformaRepository.deleteAlcaForma(bean);
	}

	public Tbasg198AlcaformaDto toDto(Tbasg198Alcaforma orig) {

		Tbasg198AlcaformaDto dest = new Tbasg198AlcaformaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg198Alcaforma toEntity(Tbasg198AlcaformaDto orig) {

		Tbasg198Alcaforma dest = new Tbasg198Alcaforma();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg198AlcaformaDto> toDtos(List<Tbasg198Alcaforma> orig) {

		List<Tbasg198AlcaformaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg198Alcaforma> toEntities(List<Tbasg198AlcaformaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg198Alcaforma> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
