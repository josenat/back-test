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

import renfe.com.model.dto.Tbasg153TarjetaDto;
import renfe.com.model.entity.Tbasg153Tarjeta;
import renfe.com.repository.Tbasg153TarjetaRepository;

@Service
public class Tbasg153TarjetaServiceImpl implements Tbasg153TarjetaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg153TarjetaRepository tbasg153TarjetaRepository;

	public List<Tbasg153TarjetaDto> getAllTbasg153Tarjeta(Tbasg153TarjetaDto filter) {

		logger.info("getAllTbasg153Tarjeta " + filter);
		if (filter == null) {
			return this.toDtos(tbasg153TarjetaRepository.findAll());
		}
		return this.toDtos(tbasg153TarjetaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg153TarjetaDto findByCdgoNumserie(String cdgoNumserie) {

		Optional<Tbasg153Tarjeta> tbasg153TarjetaData = tbasg153TarjetaRepository.findByCdgoNumserie(cdgoNumserie);

		if (tbasg153TarjetaData.isPresent()) {
			return toDto(tbasg153TarjetaData.get());
		}
		return null;
	}

	public Tbasg153TarjetaDto createTbasg153Tarjeta(Tbasg153TarjetaDto tbasg153TarjetaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg153Tarjeta dbTbasg153Tarjeta = new Tbasg153Tarjeta();
		BeanUtils.copyProperties(dbTbasg153Tarjeta, tbasg153TarjetaDto);
		Tbasg153Tarjeta _tbasg153Tarjeta = tbasg153TarjetaRepository.save(dbTbasg153Tarjeta);
		return toDto(_tbasg153Tarjeta);
	}

	public Tbasg153TarjetaDto updateTbasg153Tarjeta(String cdgoNumserie, Tbasg153TarjetaDto tbasg153TarjetaDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg153Tarjeta> tbasg153TarjetaData = tbasg153TarjetaRepository.findById(cdgoNumserie);

		if (tbasg153TarjetaData.isPresent()) {
			Tbasg153Tarjeta dbTbasg153Tarjeta = tbasg153TarjetaData.get();
			BeanUtils.copyProperties(dbTbasg153Tarjeta, tbasg153TarjetaDto);
			return toDto(tbasg153TarjetaRepository.save(dbTbasg153Tarjeta));
		}
		return null;
	}

	public int deleteTbasg153Tarjeta(String cdgoNumserie) {

		tbasg153TarjetaRepository.deleteById(cdgoNumserie);
		return 1;
	}

	public List<Tbasg153TarjetaDto> findByCdgoNumserieIn(List<String> cdgoNumserie) {

		List<Tbasg153Tarjeta> tbasg153Tarjetas = tbasg153TarjetaRepository.findByCdgoNumserieIn(cdgoNumserie);

		return toDtos(tbasg153Tarjetas);
	}

	public List<Tbasg153TarjetaDto> getTarjeta(String cdgoNumserie) {
		return toDtos(tbasg153TarjetaRepository.getTarjeta(cdgoNumserie));
	}

	public List<Tbasg153TarjetaDto> getTarjetaPer(String cdgoPersona) {
		return toDtos(tbasg153TarjetaRepository.getTarjetaPer(cdgoPersona));
	}

	public Tbasg153TarjetaDto toDto(Tbasg153Tarjeta orig) {

		Tbasg153TarjetaDto dest = new Tbasg153TarjetaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg153Tarjeta toEntity(Tbasg153TarjetaDto orig) {

		Tbasg153Tarjeta dest = new Tbasg153Tarjeta();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg153TarjetaDto> toDtos(List<Tbasg153Tarjeta> orig) {

		List<Tbasg153TarjetaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg153Tarjeta> toEntities(List<Tbasg153TarjetaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg153Tarjeta> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
