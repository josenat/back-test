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

import renfe.com.model.dto.Tbasg119EstahabinDto;
import renfe.com.model.entity.Tbasg119Estahabin;
import renfe.com.model.entity.Tbasg119EstahabinPK;
import renfe.com.repository.Tbasg119EstahabinRepository;

@Service
public class Tbasg119EstahabinServiceImpl implements Tbasg119EstahabinService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg119EstahabinRepository tbasg119EstahabinRepository;

	public List<Tbasg119EstahabinDto> getAllTbasg119Estahabin(Tbasg119EstahabinDto filter) {

		logger.info("getAllTbasg119Estahabin " + filter);
		if (filter == null) {
			return this.toDtos(tbasg119EstahabinRepository.findAll());
		}
		return this.toDtos(tbasg119EstahabinRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg119EstahabinDto findByCdgoAlchabinfCdgoEstadoFchaEstado(Integer cdgoAlchabinf, Integer cdgoEstado,
			String fchaEstado) {
		Tbasg119EstahabinPK pk = new Tbasg119EstahabinPK();
		pk.setCdgoAlchabinf(cdgoAlchabinf);
		pk.setCdgoEstado(cdgoEstado);
		pk.setFchaEstado(fchaEstado);
		Optional<Tbasg119Estahabin> tbasg119EstahabinData = tbasg119EstahabinRepository.findById(pk);

		if (tbasg119EstahabinData.isPresent()) {
			return toDto(tbasg119EstahabinData.get());
		}
		return null;
	}

	public Tbasg119EstahabinDto createTbasg119Estahabin(Tbasg119EstahabinDto tbasg119EstahabinDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg119Estahabin dbTbasg119Estahabin = new Tbasg119Estahabin();
		BeanUtils.copyProperties(dbTbasg119Estahabin, tbasg119EstahabinDto);
		Tbasg119Estahabin _tbasg119Estahabin = tbasg119EstahabinRepository.save(dbTbasg119Estahabin);
		return toDto(_tbasg119Estahabin);
	}

	public Tbasg119EstahabinDto updateTbasg119Estahabin(Integer cdgoAlchabinf, Integer cdgoEstado, String fchaEstado,
			Tbasg119EstahabinDto tbasg119EstahabinDto) throws IllegalAccessException, InvocationTargetException {
		Tbasg119EstahabinPK pk = new Tbasg119EstahabinPK();
		pk.setCdgoAlchabinf(cdgoAlchabinf);
		pk.setCdgoEstado(cdgoEstado);
		pk.setFchaEstado(fchaEstado);
		Optional<Tbasg119Estahabin> tbasg119EstahabinData = tbasg119EstahabinRepository.findById(pk);

		if (tbasg119EstahabinData.isPresent()) {
			Tbasg119Estahabin dbTbasg119Estahabin = tbasg119EstahabinData.get();
			BeanUtils.copyProperties(dbTbasg119Estahabin, tbasg119EstahabinDto);
			return toDto(tbasg119EstahabinRepository.save(dbTbasg119Estahabin));
		}
		return null;
	}

	public int deleteTbasg119Estahabin(Integer cdgoAlchabinf, Integer cdgoEstado, String fchaEstado) {
		Tbasg119EstahabinPK pk = new Tbasg119EstahabinPK();
		pk.setCdgoAlchabinf(cdgoAlchabinf);
		pk.setCdgoEstado(cdgoEstado);
		pk.setFchaEstado(fchaEstado);
		tbasg119EstahabinRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg119EstahabinDto> findByCdgoAlchabinfCdgoEstadoFchaEstadoIn(List<Integer> cdgoAlchabinf,
			List<Integer> cdgoEstado, List<String> fchaEstado) {
		List<Tbasg119EstahabinPK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoAlchabinf.size(); i++) {
			Tbasg119EstahabinPK newPk = new Tbasg119EstahabinPK();
			newPk.setCdgoAlchabinf(cdgoAlchabinf.get(i));
			newPk.setCdgoEstado(cdgoEstado.get(i));
			newPk.setFchaEstado(fchaEstado.get(i));
			pks.add(newPk);
		}
		List<Tbasg119Estahabin> tbasg119Estahabins = tbasg119EstahabinRepository.findByTbasg119estahabinpkIn(pks);

		return toDtos(tbasg119Estahabins);
	}

	public List<Tbasg119EstahabinDto> findEstaHabInByCdgoAlc(String cdgoAlchabinf) {
		return toDtos(tbasg119EstahabinRepository.findEstaHabInByCdgoAlc(cdgoAlchabinf));
	}

	public int insertEstaHabIn(Integer cdgoAlchabinf, Integer cdgoEstado, String desgUsuact, String mrcaActivo) {
		return tbasg119EstahabinRepository.insertEstaHabIn(cdgoAlchabinf, cdgoEstado, desgUsuact, mrcaActivo);
	}

	public Tbasg119EstahabinDto toDto(Tbasg119Estahabin orig) {

		Tbasg119EstahabinDto dest = new Tbasg119EstahabinDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}finally {
			if(dest!=null && orig != null) {
				dest.setCdgoAlchabinf(orig.getTbasg119estahabinpk().getCdgoAlchabinf());
				dest.setCdgoEstado(orig.getTbasg119estahabinpk().getCdgoEstado());
				dest.setFchaEstado(orig.getTbasg119estahabinpk().getFchaEstado());
			}
		}
		return dest;
	}

	public Tbasg119Estahabin toEntity(Tbasg119EstahabinDto orig) {

		Tbasg119Estahabin dest = new Tbasg119Estahabin();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg119EstahabinDto> toDtos(List<Tbasg119Estahabin> orig) {

		List<Tbasg119EstahabinDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg119Estahabin> toEntities(List<Tbasg119EstahabinDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg119Estahabin> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
