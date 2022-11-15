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

import renfe.com.model.dto.Tbasg263TipoEstadoDto;
import renfe.com.model.entity.Tbasg263TipoEstado;
import renfe.com.repository.Tbasg263TipoEstadoRepository;

@Service
public class Tbasg263TipoEstadoServiceImpl implements Tbasg263TipoEstadoService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg263TipoEstadoRepository tbasg263TipoEstadoRepository;

	public List<Tbasg263TipoEstadoDto> getAllTbasg263TipoEstado(Tbasg263TipoEstadoDto filter) {

		logger.info("getAllTbasg263TipoEstado " + filter);
		if (filter == null) {
			return this.toDtos(tbasg263TipoEstadoRepository.findAll());
		}
		return this.toDtos(tbasg263TipoEstadoRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg263TipoEstadoDto findByCdgoEstado(String cdgoEstado) {

		Optional<Tbasg263TipoEstado> tbasg263TipoEstadoData = tbasg263TipoEstadoRepository.findByCdgoEstado(cdgoEstado);

		if (tbasg263TipoEstadoData.isPresent()) {
			return toDto(tbasg263TipoEstadoData.get());
		}
		return null;
	}

	public Tbasg263TipoEstadoDto createTbasg263TipoEstado(Tbasg263TipoEstadoDto tbasg263TipoEstadoDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg263TipoEstado dbTbasg263TipoEstado = new Tbasg263TipoEstado();
		BeanUtils.copyProperties(dbTbasg263TipoEstado, tbasg263TipoEstadoDto);
		Tbasg263TipoEstado _tbasg263TipoEstado = tbasg263TipoEstadoRepository.save(dbTbasg263TipoEstado);
		return toDto(_tbasg263TipoEstado);
	}

	public Tbasg263TipoEstadoDto updateTbasg263TipoEstado(String cdgoEstado,
			Tbasg263TipoEstadoDto tbasg263TipoEstadoDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg263TipoEstado> tbasg263TipoEstadoData = tbasg263TipoEstadoRepository.findById(cdgoEstado);

		if (tbasg263TipoEstadoData.isPresent()) {
			Tbasg263TipoEstado dbTbasg263TipoEstado = tbasg263TipoEstadoData.get();
			BeanUtils.copyProperties(dbTbasg263TipoEstado, tbasg263TipoEstadoDto);
			return toDto(tbasg263TipoEstadoRepository.save(dbTbasg263TipoEstado));
		}
		return null;
	}

	public int deleteTbasg263TipoEstado(String cdgoEstado) {

		tbasg263TipoEstadoRepository.deleteById(cdgoEstado);
		return 1;
	}

	public List<Tbasg263TipoEstadoDto> findByCdgoEstadoIn(List<String> cdgoEstado) {

		List<Tbasg263TipoEstado> tbasg263TipoEstados = tbasg263TipoEstadoRepository.findByCdgoEstadoIn(cdgoEstado);

		return toDtos(tbasg263TipoEstados);
	}

	public List<Tbasg263TipoEstadoDto> getTipoEstAcAllList() {
		return toDtos(tbasg263TipoEstadoRepository.getTipoEstAcAllList());
	}

	public List<Tbasg263TipoEstadoDto> getTipoEstAcCount() {
		return toDtos(tbasg263TipoEstadoRepository.getTipoEstAcCount());
	}

	public List<Tbasg263TipoEstadoDto> getTipoEstadoAcredita() {
		return toDtos(tbasg263TipoEstadoRepository.getTipoEstadoAcredita());
	}

	public List<Tbasg263TipoEstadoDto> getTipoEstadosAcredita() {
		return toDtos(tbasg263TipoEstadoRepository.getTipoEstadosAcredita());
	}

	public Tbasg263TipoEstadoDto toDto(Tbasg263TipoEstado orig) {

		Tbasg263TipoEstadoDto dest = new Tbasg263TipoEstadoDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg263TipoEstado toEntity(Tbasg263TipoEstadoDto orig) {

		Tbasg263TipoEstado dest = new Tbasg263TipoEstado();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg263TipoEstadoDto> toDtos(List<Tbasg263TipoEstado> orig) {

		List<Tbasg263TipoEstadoDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg263TipoEstado> toEntities(List<Tbasg263TipoEstadoDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg263TipoEstado> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
