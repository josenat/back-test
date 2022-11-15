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

import renfe.com.model.dto.Tbasg266EstadoAcreDto;
import renfe.com.model.entity.Tbasg266EstadoAcre;
import renfe.com.model.entity.Tbasg266EstadoAcrePK;
import renfe.com.repository.Tbasg266EstadoAcreRepository;

@Transactional
@Service
public class Tbasg266EstadoAcreServiceImpl implements Tbasg266EstadoAcreService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg266EstadoAcreRepository tbasg266EstadoAcreRepository;

	public List<Tbasg266EstadoAcreDto> getAllTbasg266EstadoAcre(Tbasg266EstadoAcreDto filter) {

		logger.info("getAllTbasg266EstadoAcre " + filter);
		if (filter == null) {
			return this.toDtos(tbasg266EstadoAcreRepository.findAll());
		}
		return this.toDtos(tbasg266EstadoAcreRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg266EstadoAcreDto findByCdgoAcreditaCdgoEstadoFchaEstado(Integer cdgoAcredita, String cdgoEstado,
			String fchaEstado) {
		Tbasg266EstadoAcrePK pk = new Tbasg266EstadoAcrePK();
		pk.setCdgoAcredita(cdgoAcredita);
		pk.setCdgoEstado(cdgoEstado);
		pk.setFchaEstado(fchaEstado);
		Optional<Tbasg266EstadoAcre> tbasg266EstadoAcreData = tbasg266EstadoAcreRepository.findById(pk);

		if (tbasg266EstadoAcreData.isPresent()) {
			return toDto(tbasg266EstadoAcreData.get());
		}
		return null;
	}

	public Tbasg266EstadoAcreDto createTbasg266EstadoAcre(Tbasg266EstadoAcreDto tbasg266EstadoAcreDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg266EstadoAcre dbTbasg266EstadoAcre = new Tbasg266EstadoAcre();
		BeanUtils.copyProperties(dbTbasg266EstadoAcre, tbasg266EstadoAcreDto);
		Tbasg266EstadoAcre _tbasg266EstadoAcre = tbasg266EstadoAcreRepository.save(dbTbasg266EstadoAcre);
		return toDto(_tbasg266EstadoAcre);
	}

	public Tbasg266EstadoAcreDto updateTbasg266EstadoAcre(Integer cdgoAcredita, String cdgoEstado, String fchaEstado,
			Tbasg266EstadoAcreDto tbasg266EstadoAcreDto) throws IllegalAccessException, InvocationTargetException {
		Tbasg266EstadoAcrePK pk = new Tbasg266EstadoAcrePK();
		pk.setCdgoAcredita(cdgoAcredita);
		pk.setCdgoEstado(cdgoEstado);
		pk.setFchaEstado(fchaEstado);
		Optional<Tbasg266EstadoAcre> tbasg266EstadoAcreData = tbasg266EstadoAcreRepository.findById(pk);

		if (tbasg266EstadoAcreData.isPresent()) {
			Tbasg266EstadoAcre dbTbasg266EstadoAcre = tbasg266EstadoAcreData.get();
			BeanUtils.copyProperties(dbTbasg266EstadoAcre, tbasg266EstadoAcreDto);
			return toDto(tbasg266EstadoAcreRepository.save(dbTbasg266EstadoAcre));
		}
		return null;
	}

	public int deleteTbasg266EstadoAcre(Integer cdgoAcredita, String cdgoEstado, String fchaEstado) {
		Tbasg266EstadoAcrePK pk = new Tbasg266EstadoAcrePK();
		pk.setCdgoAcredita(cdgoAcredita);
		pk.setCdgoEstado(cdgoEstado);
		pk.setFchaEstado(fchaEstado);
		tbasg266EstadoAcreRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg266EstadoAcreDto> findByCdgoAcreditaCdgoEstadoFchaEstadoIn(List<Integer> cdgoAcredita,
			List<String> cdgoEstado, List<String> fchaEstado) {
		List<Tbasg266EstadoAcrePK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoAcredita.size(); i++) {
			Tbasg266EstadoAcrePK newPk = new Tbasg266EstadoAcrePK();
			newPk.setCdgoAcredita(cdgoAcredita.get(i));
			newPk.setCdgoEstado(cdgoEstado.get(i));
			newPk.setFchaEstado(fchaEstado.get(i));
			pks.add(newPk);
		}
		List<Tbasg266EstadoAcre> tbasg266EstadoAcres = tbasg266EstadoAcreRepository.findByTbasg266estadoacrepkIn(pks);

		return toDtos(tbasg266EstadoAcres);
	}

	public int insertEstadoAcreditacion(Tbasg266EstadoAcre bean) {
		return tbasg266EstadoAcreRepository.insertEstadoAcreditacion(bean);
	}

	public int updateEstadoAcreditacion(Tbasg266EstadoAcre bean) {
		return tbasg266EstadoAcreRepository.updateEstadoAcreditacion(bean);
	}

	public List<Tbasg266EstadoAcreDto> getEstadosAcreditaMaxFecha() {
		return toDtos(tbasg266EstadoAcreRepository.getEstadosAcreditaMaxFecha());
	}

	public List<Tbasg266EstadoAcreDto> getEstadosAcreditaTodosMaxFecha() {
		return toDtos(tbasg266EstadoAcreRepository.getEstadosAcreditaTodosMaxFecha());
	}

	public int insertEstadoAcre(Tbasg266EstadoAcre bean) {
		return tbasg266EstadoAcreRepository.insertEstadoAcre(bean);
	}

	public int updateEstadoAcreditacionMantenimiento(Tbasg266EstadoAcre bean) {
		return tbasg266EstadoAcreRepository.updateEstadoAcreditacionMantenimiento(bean);
	}

	public Tbasg266EstadoAcreDto toDto(Tbasg266EstadoAcre orig) {

		Tbasg266EstadoAcreDto dest = new Tbasg266EstadoAcreDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			if(dest!=null && orig!=null) {
				dest.setCdgoAcredita(orig.getTbasg266estadoacrepk().getCdgoAcredita());
				dest.setCdgoEstado(orig.getTbasg266estadoacrepk().getCdgoEstado());
				dest.setFchaEstado(orig.getTbasg266estadoacrepk().getFchaEstado());
			}
		}
		return dest;
	}

	public Tbasg266EstadoAcre toEntity(Tbasg266EstadoAcreDto orig) {

		Tbasg266EstadoAcre dest = new Tbasg266EstadoAcre();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg266EstadoAcreDto> toDtos(List<Tbasg266EstadoAcre> orig) {

		List<Tbasg266EstadoAcreDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg266EstadoAcre> toEntities(List<Tbasg266EstadoAcreDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg266EstadoAcre> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
