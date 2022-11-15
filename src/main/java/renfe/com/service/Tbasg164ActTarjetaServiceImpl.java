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

import renfe.com.model.dto.Tbasg164ActTarjetaDto;
import renfe.com.model.entity.Tbasg164ActTarjeta;
import renfe.com.repository.Tbasg164ActTarjetaRepository;

@Service
public class Tbasg164ActTarjetaServiceImpl implements Tbasg164ActTarjetaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg164ActTarjetaRepository tbasg164ActTarjetaRepository;

	public List<Tbasg164ActTarjetaDto> getAllTbasg164ActTarjeta(Tbasg164ActTarjetaDto filter) {

		logger.info("getAllTbasg164ActTarjeta " + filter);
		if (filter == null) {
			return this.toDtos(tbasg164ActTarjetaRepository.findAll());
		}
		return this.toDtos(tbasg164ActTarjetaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg164ActTarjetaDto findByCdgoNumserie(String cdgoNumserie) {

		Optional<Tbasg164ActTarjeta> tbasg164ActTarjetaData = tbasg164ActTarjetaRepository
				.findByCdgoNumserie(cdgoNumserie);

		if (tbasg164ActTarjetaData.isPresent()) {
			return toDto(tbasg164ActTarjetaData.get());
		}
		return null;
	}

	public Tbasg164ActTarjetaDto createTbasg164ActTarjeta(Tbasg164ActTarjetaDto tbasg164ActTarjetaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg164ActTarjeta dbTbasg164ActTarjeta = new Tbasg164ActTarjeta();
		BeanUtils.copyProperties(dbTbasg164ActTarjeta, tbasg164ActTarjetaDto);
		Tbasg164ActTarjeta _tbasg164ActTarjeta = tbasg164ActTarjetaRepository.save(dbTbasg164ActTarjeta);
		return toDto(_tbasg164ActTarjeta);
	}

	public Tbasg164ActTarjetaDto updateTbasg164ActTarjeta(String cdgoNumserie,
			Tbasg164ActTarjetaDto tbasg164ActTarjetaDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg164ActTarjeta> tbasg164ActTarjetaData = tbasg164ActTarjetaRepository.findById(cdgoNumserie);

		if (tbasg164ActTarjetaData.isPresent()) {
			Tbasg164ActTarjeta dbTbasg164ActTarjeta = tbasg164ActTarjetaData.get();
			BeanUtils.copyProperties(dbTbasg164ActTarjeta, tbasg164ActTarjetaDto);
			return toDto(tbasg164ActTarjetaRepository.save(dbTbasg164ActTarjeta));
		}
		return null;
	}

	public int deleteTbasg164ActTarjeta(String cdgoNumserie) {

		tbasg164ActTarjetaRepository.deleteById(cdgoNumserie);
		return 1;
	}

	public List<Tbasg164ActTarjetaDto> findByCdgoNumserieIn(List<String> cdgoNumserie) {

		List<Tbasg164ActTarjeta> tbasg164ActTarjetas = tbasg164ActTarjetaRepository.findByCdgoNumserieIn(cdgoNumserie);

		return toDtos(tbasg164ActTarjetas);
	}

	public List<Tbasg164ActTarjetaDto> getTarjetaActualizar(String cdgoNumserie) {
		return toDtos(tbasg164ActTarjetaRepository.getTarjetaActualizar(cdgoNumserie));
	}

	public int insertActTarjeta(Tbasg164ActTarjeta bean) {
		return tbasg164ActTarjetaRepository.insertActTarjeta(bean);
	}

	public Tbasg164ActTarjetaDto toDto(Tbasg164ActTarjeta orig) {

		Tbasg164ActTarjetaDto dest = new Tbasg164ActTarjetaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg164ActTarjeta toEntity(Tbasg164ActTarjetaDto orig) {

		Tbasg164ActTarjeta dest = new Tbasg164ActTarjeta();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg164ActTarjetaDto> toDtos(List<Tbasg164ActTarjeta> orig) {

		List<Tbasg164ActTarjetaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg164ActTarjeta> toEntities(List<Tbasg164ActTarjetaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg164ActTarjeta> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
