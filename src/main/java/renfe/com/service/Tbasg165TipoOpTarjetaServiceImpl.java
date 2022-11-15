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

import renfe.com.model.dto.Tbasg165TipoOpTarjetaDto;
import renfe.com.model.entity.Tbasg165TipoOpTarjeta;
import renfe.com.repository.Tbasg165TipoOpTarjetaRepository;

@Service
public class Tbasg165TipoOpTarjetaServiceImpl implements Tbasg165TipoOpTarjetaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg165TipoOpTarjetaRepository tbasg165TipoOpTarjetaRepository;

	public List<Tbasg165TipoOpTarjetaDto> getAllTbasg165TipoOpTarjeta(Tbasg165TipoOpTarjetaDto filter) {

		logger.info("getAllTbasg165TipoOpTarjeta " + filter);
		if (filter == null) {
			return this.toDtos(tbasg165TipoOpTarjetaRepository.findAll());
		}
		return this.toDtos(tbasg165TipoOpTarjetaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg165TipoOpTarjetaDto findByCdgoOperacion(String cdgoOperacion) {

		Optional<Tbasg165TipoOpTarjeta> tbasg165TipoOpTarjetaData = tbasg165TipoOpTarjetaRepository
				.findByCdgoOperacion(cdgoOperacion);

		if (tbasg165TipoOpTarjetaData.isPresent()) {
			return toDto(tbasg165TipoOpTarjetaData.get());
		}
		return null;
	}

	public Tbasg165TipoOpTarjetaDto createTbasg165TipoOpTarjeta(Tbasg165TipoOpTarjetaDto tbasg165TipoOpTarjetaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg165TipoOpTarjeta dbTbasg165TipoOpTarjeta = new Tbasg165TipoOpTarjeta();
		BeanUtils.copyProperties(dbTbasg165TipoOpTarjeta, tbasg165TipoOpTarjetaDto);
		Tbasg165TipoOpTarjeta _tbasg165TipoOpTarjeta = tbasg165TipoOpTarjetaRepository.save(dbTbasg165TipoOpTarjeta);
		return toDto(_tbasg165TipoOpTarjeta);
	}

	public Tbasg165TipoOpTarjetaDto updateTbasg165TipoOpTarjeta(String cdgoOperacion,
			Tbasg165TipoOpTarjetaDto tbasg165TipoOpTarjetaDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg165TipoOpTarjeta> tbasg165TipoOpTarjetaData = tbasg165TipoOpTarjetaRepository
				.findById(cdgoOperacion);

		if (tbasg165TipoOpTarjetaData.isPresent()) {
			Tbasg165TipoOpTarjeta dbTbasg165TipoOpTarjeta = tbasg165TipoOpTarjetaData.get();
			BeanUtils.copyProperties(dbTbasg165TipoOpTarjeta, tbasg165TipoOpTarjetaDto);
			return toDto(tbasg165TipoOpTarjetaRepository.save(dbTbasg165TipoOpTarjeta));
		}
		return null;
	}

	public int deleteTbasg165TipoOpTarjeta(String cdgoOperacion) {

		tbasg165TipoOpTarjetaRepository.deleteById(cdgoOperacion);
		return 1;
	}

	public List<Tbasg165TipoOpTarjetaDto> findByCdgoOperacionIn(List<String> cdgoOperacion) {

		List<Tbasg165TipoOpTarjeta> tbasg165TipoOpTarjetas = tbasg165TipoOpTarjetaRepository
				.findByCdgoOperacionIn(cdgoOperacion);

		return toDtos(tbasg165TipoOpTarjetas);
	}

	public List<Tbasg165TipoOpTarjetaDto> getTipoOpTarjetaActiveList() {
		return toDtos(tbasg165TipoOpTarjetaRepository.getTipoOpTarjetaActiveList());
	}

	public Tbasg165TipoOpTarjetaDto toDto(Tbasg165TipoOpTarjeta orig) {

		Tbasg165TipoOpTarjetaDto dest = new Tbasg165TipoOpTarjetaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg165TipoOpTarjeta toEntity(Tbasg165TipoOpTarjetaDto orig) {

		Tbasg165TipoOpTarjeta dest = new Tbasg165TipoOpTarjeta();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg165TipoOpTarjetaDto> toDtos(List<Tbasg165TipoOpTarjeta> orig) {

		List<Tbasg165TipoOpTarjetaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg165TipoOpTarjeta> toEntities(List<Tbasg165TipoOpTarjetaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg165TipoOpTarjeta> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
