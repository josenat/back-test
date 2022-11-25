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

import renfe.com.model.dto.Tbasg145AlchaestaDto;
import renfe.com.model.entity.Tbasg145Alchaesta;
import renfe.com.model.entity.Tbasg145AlchaestaPK;
import renfe.com.repository.Tbasg145AlchaestaRepository;

@Transactional
@Service
public class Tbasg145AlchaestaServiceImpl implements Tbasg145AlchaestaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg145AlchaestaRepository tbasg145AlchaestaRepository;

	public List<Tbasg145AlchaestaDto> getAllTbasg145Alchaesta(Tbasg145AlchaestaDto filter) {

		logger.info("getAllTbasg145Alchaesta " + filter);
		if (filter == null) {
			return this.toDtos(tbasg145AlchaestaRepository.findAll());
		}
		return this.toDtos(tbasg145AlchaestaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg145AlchaestaDto findByCdgoAlchabinfCdgoDestinoCdgoLineaCdgoOrigen(Integer cdgoAlchabinf,
			String cdgoDestino, String cdgoLinea, String cdgoOrigen) {
		Tbasg145AlchaestaPK pk = new Tbasg145AlchaestaPK();
		pk.setCdgoAlchabinf(cdgoAlchabinf);
		pk.setCdgoDestino(cdgoDestino);
		pk.setCdgoLinea(cdgoLinea);
		pk.setCdgoOrigen(cdgoOrigen);
		Optional<Tbasg145Alchaesta> tbasg145AlchaestaData = tbasg145AlchaestaRepository.findById(pk);

		if (tbasg145AlchaestaData.isPresent()) {
			return toDto(tbasg145AlchaestaData.get());
		}
		return null;
	}

	public Tbasg145AlchaestaDto createTbasg145Alchaesta(Tbasg145AlchaestaDto tbasg145AlchaestaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg145Alchaesta dbTbasg145Alchaesta = new Tbasg145Alchaesta();
		BeanUtils.copyProperties(dbTbasg145Alchaesta, tbasg145AlchaestaDto);
		Tbasg145Alchaesta _tbasg145Alchaesta = tbasg145AlchaestaRepository.save(dbTbasg145Alchaesta);
		return toDto(_tbasg145Alchaesta);
	}

	public Tbasg145AlchaestaDto updateTbasg145Alchaesta(Integer cdgoAlchabinf, String cdgoDestino, String cdgoLinea,
			String cdgoOrigen, Tbasg145AlchaestaDto tbasg145AlchaestaDto)
			throws IllegalAccessException, InvocationTargetException {
		Tbasg145AlchaestaPK pk = new Tbasg145AlchaestaPK();
		pk.setCdgoAlchabinf(cdgoAlchabinf);
		pk.setCdgoDestino(cdgoDestino);
		pk.setCdgoLinea(cdgoLinea);
		pk.setCdgoOrigen(cdgoOrigen);
		Optional<Tbasg145Alchaesta> tbasg145AlchaestaData = tbasg145AlchaestaRepository.findById(pk);

		if (tbasg145AlchaestaData.isPresent()) {
			Tbasg145Alchaesta dbTbasg145Alchaesta = tbasg145AlchaestaData.get();
			BeanUtils.copyProperties(dbTbasg145Alchaesta, tbasg145AlchaestaDto);
			return toDto(tbasg145AlchaestaRepository.save(dbTbasg145Alchaesta));
		}
		return null;
	}

	public int deleteTbasg145Alchaesta(Integer cdgoAlchabinf, String cdgoDestino, String cdgoLinea, String cdgoOrigen) {
		Tbasg145AlchaestaPK pk = new Tbasg145AlchaestaPK();
		pk.setCdgoAlchabinf(cdgoAlchabinf);
		pk.setCdgoDestino(cdgoDestino);
		pk.setCdgoLinea(cdgoLinea);
		pk.setCdgoOrigen(cdgoOrigen);
		tbasg145AlchaestaRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg145AlchaestaDto> findByCdgoAlchabinfCdgoDestinoCdgoLineaCdgoOrigenIn(List<Integer> cdgoAlchabinf,
			List<String> cdgoDestino, List<String> cdgoLinea, List<String> cdgoOrigen) {
		List<Tbasg145AlchaestaPK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoAlchabinf.size(); i++) {
			Tbasg145AlchaestaPK newPk = new Tbasg145AlchaestaPK();
			newPk.setCdgoAlchabinf(cdgoAlchabinf.get(i));
			newPk.setCdgoDestino(cdgoDestino.get(i));
			newPk.setCdgoLinea(cdgoLinea.get(i));
			newPk.setCdgoOrigen(cdgoOrigen.get(i));
			pks.add(newPk);
		}
		List<Tbasg145Alchaesta> tbasg145Alchaestas = tbasg145AlchaestaRepository.findByTbasg145alchaestapkIn(pks);

		return toDtos(tbasg145Alchaestas);
	}

	public List<Tbasg145AlchaestaDto> getAlcHaEstaCount(/** FIXME revisar tipo */
	Object cdgoEntorno) {
		return toDtos(tbasg145AlchaestaRepository.getAlcHaEstaCount(cdgoEntorno));
	}

	public List<Tbasg145AlchaestaDto> getAlcHaEsta(String cdgoAlchabinf, String cdgoLinea, String cdgoOrigen,
			String cdgoDestino) {
		return toDtos(tbasg145AlchaestaRepository.getAlcHaEsta(cdgoAlchabinf, cdgoLinea, cdgoOrigen, cdgoDestino));
	}

	public int insertAlcHaEsta(Tbasg145AlchaestaDto bean) {
		return tbasg145AlchaestaRepository.insertAlcHaEsta(bean);
	}

	public int deleteAlcHaEsta(Tbasg145Alchaesta bean) {
		return tbasg145AlchaestaRepository.deleteAlcHaEsta(bean);
	}

	public int deleteAlcHaEstaByAlchabinf(Tbasg145Alchaesta bean) {
		return tbasg145AlchaestaRepository.deleteAlcHaEstaByAlchabinf(bean);
	}

	public Tbasg145AlchaestaDto toDto(Tbasg145Alchaesta orig) {

		Tbasg145AlchaestaDto dest = new Tbasg145AlchaestaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg145Alchaesta toEntity(Tbasg145AlchaestaDto orig) {

		Tbasg145Alchaesta dest = new Tbasg145Alchaesta();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg145AlchaestaDto> toDtos(List<Tbasg145Alchaesta> orig) {

		List<Tbasg145AlchaestaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg145Alchaesta> toEntities(List<Tbasg145AlchaestaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg145Alchaesta> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
