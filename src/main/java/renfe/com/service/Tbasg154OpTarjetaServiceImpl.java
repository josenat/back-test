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

import renfe.com.model.dto.Tbasg154OpTarjetaDto;
import renfe.com.model.entity.Tbasg154OpTarjeta;
import renfe.com.model.entity.Tbasg154OpTarjetaPK;
import renfe.com.repository.Tbasg154OpTarjetaRepository;

@Service
public class Tbasg154OpTarjetaServiceImpl implements Tbasg154OpTarjetaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg154OpTarjetaRepository tbasg154OpTarjetaRepository;

	public List<Tbasg154OpTarjetaDto> getAllTbasg154OpTarjeta(Tbasg154OpTarjetaDto filter) {

		logger.info("getAllTbasg154OpTarjeta " + filter);
		if (filter == null) {
			return this.toDtos(tbasg154OpTarjetaRepository.findAll());
		}
		return this.toDtos(tbasg154OpTarjetaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg154OpTarjetaDto findByCdgoPersonaFchaOperacion(Integer cdgoPersona, String fchaOperacion) {
		Tbasg154OpTarjetaPK pk = new Tbasg154OpTarjetaPK();
		pk.setCdgoPersona(cdgoPersona);
		pk.setFchaOperacion(fchaOperacion);
		Optional<Tbasg154OpTarjeta> tbasg154OpTarjetaData = tbasg154OpTarjetaRepository.findById(pk);

		if (tbasg154OpTarjetaData.isPresent()) {
			return toDto(tbasg154OpTarjetaData.get());
		}
		return null;
	}

	public Tbasg154OpTarjetaDto createTbasg154OpTarjeta(Tbasg154OpTarjetaDto tbasg154OpTarjetaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg154OpTarjeta dbTbasg154OpTarjeta = new Tbasg154OpTarjeta();
		BeanUtils.copyProperties(dbTbasg154OpTarjeta, tbasg154OpTarjetaDto);
		Tbasg154OpTarjeta _tbasg154OpTarjeta = tbasg154OpTarjetaRepository.save(dbTbasg154OpTarjeta);
		return toDto(_tbasg154OpTarjeta);
	}

	public Tbasg154OpTarjetaDto updateTbasg154OpTarjeta(Integer cdgoPersona, String fchaOperacion,
			Tbasg154OpTarjetaDto tbasg154OpTarjetaDto) throws IllegalAccessException, InvocationTargetException {
		Tbasg154OpTarjetaPK pk = new Tbasg154OpTarjetaPK();
		pk.setCdgoPersona(cdgoPersona);
		pk.setFchaOperacion(fchaOperacion);
		Optional<Tbasg154OpTarjeta> tbasg154OpTarjetaData = tbasg154OpTarjetaRepository.findById(pk);

		if (tbasg154OpTarjetaData.isPresent()) {
			Tbasg154OpTarjeta dbTbasg154OpTarjeta = tbasg154OpTarjetaData.get();
			BeanUtils.copyProperties(dbTbasg154OpTarjeta, tbasg154OpTarjetaDto);
			return toDto(tbasg154OpTarjetaRepository.save(dbTbasg154OpTarjeta));
		}
		return null;
	}

	public int deleteTbasg154OpTarjeta(Integer cdgoPersona, String fchaOperacion) {
		Tbasg154OpTarjetaPK pk = new Tbasg154OpTarjetaPK();
		pk.setCdgoPersona(cdgoPersona);
		pk.setFchaOperacion(fchaOperacion);
		tbasg154OpTarjetaRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg154OpTarjetaDto> findByCdgoPersonaFchaOperacionIn(List<Integer> cdgoPersona,
			List<String> fchaOperacion) {
		List<Tbasg154OpTarjetaPK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoPersona.size(); i++) {
			Tbasg154OpTarjetaPK newPk = new Tbasg154OpTarjetaPK();
			newPk.setCdgoPersona(cdgoPersona.get(i));
			newPk.setFchaOperacion(fchaOperacion.get(i));
			pks.add(newPk);
		}
		List<Tbasg154OpTarjeta> tbasg154OpTarjetas = tbasg154OpTarjetaRepository.findByTbasg154optarjetapkIn(pks);

		return toDtos(tbasg154OpTarjetas);
	}

	public List<Tbasg154OpTarjetaDto> getOperacion(String cdgoNumserie) {
		return toDtos(tbasg154OpTarjetaRepository.getOperacion(cdgoNumserie));
	}

	public int insertOperTarjeta(Tbasg154OpTarjeta bean) {
		return tbasg154OpTarjetaRepository.insertOperTarjeta(bean);
	}

	public Tbasg154OpTarjetaDto toDto(Tbasg154OpTarjeta orig) {

		Tbasg154OpTarjetaDto dest = new Tbasg154OpTarjetaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg154OpTarjeta toEntity(Tbasg154OpTarjetaDto orig) {

		Tbasg154OpTarjeta dest = new Tbasg154OpTarjeta();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg154OpTarjetaDto> toDtos(List<Tbasg154OpTarjeta> orig) {

		List<Tbasg154OpTarjetaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg154OpTarjeta> toEntities(List<Tbasg154OpTarjetaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg154OpTarjeta> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
