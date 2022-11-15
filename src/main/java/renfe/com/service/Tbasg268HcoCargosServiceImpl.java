package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import renfe.com.model.dto.Tbasg268HcoCargosDto;
import renfe.com.model.entity.Tbasg268HcoCargos;
import renfe.com.repository.Tbasg268HcoCargosRepository;

@Service
public class Tbasg268HcoCargosServiceImpl implements Tbasg268HcoCargosService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg268HcoCargosRepository tbasg268HcoCargosRepository;

	public List<Tbasg268HcoCargosDto> getAllTbasg268HcoCargos(Tbasg268HcoCargosDto filter) {

		logger.info("getAllTbasg268HcoCargos " + filter);
		if (filter == null) {
			return this.toDtos(tbasg268HcoCargosRepository.findAll());
		}
		return this.toDtos(tbasg268HcoCargosRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg268HcoCargosDto findByCdgoPersonaFchaInicio(String cdgoPersona, Date fchaInicio) {
		Tbasg268HcoCargos pk = new Tbasg268HcoCargos();
		pk.getTbasg268HcoCargosPK().setCdgoPersona(cdgoPersona);
		//pk.setFchaInicio(fchaInicio);
		/*Optional<Tbasg268HcoCargos> tbasg268HcoCargosData = tbasg268HcoCargosRepository.findById(pk);

		if (tbasg268HcoCargosData.isPresent()) {
			return toDto(tbasg268HcoCargosData.get());
		}*/
		return null;
	}

	public Tbasg268HcoCargosDto createTbasg268HcoCargos(Tbasg268HcoCargosDto tbasg268HcoCargosDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg268HcoCargos dbTbasg268HcoCargos = new Tbasg268HcoCargos();
		BeanUtils.copyProperties(dbTbasg268HcoCargos, tbasg268HcoCargosDto);
		Tbasg268HcoCargos _tbasg268HcoCargos = tbasg268HcoCargosRepository.save(dbTbasg268HcoCargos);
		return toDto(_tbasg268HcoCargos);
	}

	public Tbasg268HcoCargosDto updateTbasg268HcoCargos(String cdgoPersona, Date fchaInicio,
			Tbasg268HcoCargosDto tbasg268HcoCargosDto) throws IllegalAccessException, InvocationTargetException {
		Tbasg268HcoCargos pk = new Tbasg268HcoCargos();
		//pk.setCdgoPersona(cdgoPersona);
		//pk.setFchaInicio(fchaInicio);
		/*Optional<Tbasg268HcoCargos> tbasg268HcoCargosData = tbasg268HcoCargosRepository.findById(pk);

		if (tbasg268HcoCargosData.isPresent()) {
			Tbasg268HcoCargos dbTbasg268HcoCargos = tbasg268HcoCargosData.get();
			BeanUtils.copyProperties(dbTbasg268HcoCargos, tbasg268HcoCargosDto);
			return toDto(tbasg268HcoCargosRepository.save(dbTbasg268HcoCargos));
		}*/
		return null;
	}

	public int deleteTbasg268HcoCargos(String cdgoPersona, Date fchaInicio) {
		Tbasg268HcoCargos pk = new Tbasg268HcoCargos();
		//pk.setCdgoPersona(cdgoPersona);
		//pk.setFchaInicio(fchaInicio);
		//tbasg268HcoCargosRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg268HcoCargosDto> findByCdgoPersonaFchaInicioIn(List<String> cdgoPersona, List<Date> fchaInicio) {
		Collection<Tbasg268HcoCargos> pks = new ArrayList<>();
		for (int i = 0; i < cdgoPersona.size(); i++) {
			Tbasg268HcoCargos newPk = new Tbasg268HcoCargos();
			//newPk.setCdgoPersona(cdgoPersona.get(i));
			//newPk.setFchaInicio(fchaInicio.get(i));
			//pks.add(newPk);
		}
		//List<Tbasg268HcoCargos> tbasg268HcoCargoss = tbasg268HcoCargosRepository.findByTbasg268hcocargospkIn(pks);

		return null;
	}

	public List<Tbasg268HcoCargosDto> findByCdgoPersona(String cdgoPersona) {
		return toDtos(tbasg268HcoCargosRepository.findByCdgoPersona(cdgoPersona));
	}

	public List<Tbasg268HcoCargosDto> findByCdgoPersonaCargo(String cdgoPersona) {
		return toDtos(tbasg268HcoCargosRepository.findByCdgoPersonaCargo(cdgoPersona));
	}

	public List<Tbasg268HcoCargosDto> findCdgoCargoBeginningK(String cdgoPersona) {
		return toDtos(tbasg268HcoCargosRepository.findCdgoCargoBeginningK(cdgoPersona));
	}

	public int insertHstoCargos(String cdgoPersona, Date fchaInicio, Date fchaFin, String desgUsuact, String cdgoCargo) {
		return tbasg268HcoCargosRepository.insertHstoCargos(cdgoPersona, fchaInicio, fchaFin, desgUsuact, cdgoCargo);
	}

	public int updateHstoCargos(String cdgoCargo, Date fchaFin, String desgUsuact, String cdgoPersona, Date fchaInicio) {
		return tbasg268HcoCargosRepository.updateHstoCargos(cdgoCargo, fchaFin, desgUsuact, cdgoPersona, fchaInicio);
	}

	public int deleteHstoCargos(Tbasg268HcoCargos bean) {
		return tbasg268HcoCargosRepository.deleteHstoCargos(bean);
	}

	public Tbasg268HcoCargosDto toDto(Tbasg268HcoCargos orig) {

		Tbasg268HcoCargosDto dest = new Tbasg268HcoCargosDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			if(dest!=null && orig != null) {
				dest.setCdgoPersona(orig.getTbasg268HcoCargosPK().getCdgoPersona());
				dest.setFchaInicio(orig.getTbasg268HcoCargosPK().getFchaInicio());
			}
		}
			
		return dest;
	}

	public Tbasg268HcoCargos toEntity(Tbasg268HcoCargosDto orig) {

		Tbasg268HcoCargos dest = new Tbasg268HcoCargos();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg268HcoCargosDto> toDtos(List<Tbasg268HcoCargos> orig) {

		List<Tbasg268HcoCargosDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg268HcoCargos> toEntities(List<Tbasg268HcoCargosDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg268HcoCargos> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
	
}
