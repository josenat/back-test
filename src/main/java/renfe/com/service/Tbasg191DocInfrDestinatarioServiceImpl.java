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

import renfe.com.model.dto.Tbasg191DocInfrDestinatarioDto;
import renfe.com.model.entity.Tbasg191DocInfrDestinatario;
import renfe.com.repository.Tbasg191DocInfrDestinatarioRepository;

@Service
public class Tbasg191DocInfrDestinatarioServiceImpl implements Tbasg191DocInfrDestinatarioService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg191DocInfrDestinatarioRepository tbasg191DocInfrDestinatarioRepository;

	public List<Tbasg191DocInfrDestinatarioDto> getAllTbasg191DocInfrDestinatario(
			Tbasg191DocInfrDestinatarioDto filter) {

		logger.info("getAllTbasg191DocInfrDestinatario " + filter);
		if (filter == null) {
			return this.toDtos(tbasg191DocInfrDestinatarioRepository.findAll());
		}
		return this.toDtos(tbasg191DocInfrDestinatarioRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg191DocInfrDestinatarioDto findByCdgoDestinatario(Integer cdgoDestinatario) {

		Optional<Tbasg191DocInfrDestinatario> tbasg191DocInfrDestinatarioData = tbasg191DocInfrDestinatarioRepository
				.findByCdgoDestinatario(cdgoDestinatario);

		if (tbasg191DocInfrDestinatarioData.isPresent()) {
			return toDto(tbasg191DocInfrDestinatarioData.get());
		}
		return null;
	}

	public Tbasg191DocInfrDestinatarioDto createTbasg191DocInfrDestinatario(
			Tbasg191DocInfrDestinatarioDto tbasg191DocInfrDestinatarioDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg191DocInfrDestinatario dbTbasg191DocInfrDestinatario = new Tbasg191DocInfrDestinatario();
		BeanUtils.copyProperties(dbTbasg191DocInfrDestinatario, tbasg191DocInfrDestinatarioDto);
		Tbasg191DocInfrDestinatario _tbasg191DocInfrDestinatario = tbasg191DocInfrDestinatarioRepository
				.save(dbTbasg191DocInfrDestinatario);
		return toDto(_tbasg191DocInfrDestinatario);
	}

	public Tbasg191DocInfrDestinatarioDto updateTbasg191DocInfrDestinatario(Integer cdgoDestinatario,
			Tbasg191DocInfrDestinatarioDto tbasg191DocInfrDestinatarioDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg191DocInfrDestinatario> tbasg191DocInfrDestinatarioData = tbasg191DocInfrDestinatarioRepository
				.findById(cdgoDestinatario);

		if (tbasg191DocInfrDestinatarioData.isPresent()) {
			Tbasg191DocInfrDestinatario dbTbasg191DocInfrDestinatario = tbasg191DocInfrDestinatarioData.get();
			BeanUtils.copyProperties(dbTbasg191DocInfrDestinatario, tbasg191DocInfrDestinatarioDto);
			return toDto(tbasg191DocInfrDestinatarioRepository.save(dbTbasg191DocInfrDestinatario));
		}
		return null;
	}

	public int deleteTbasg191DocInfrDestinatario(Integer cdgoDestinatario) {

		tbasg191DocInfrDestinatarioRepository.deleteById(cdgoDestinatario);
		return 1;
	}

	public List<Tbasg191DocInfrDestinatarioDto> findByCdgoDestinatarioIn(List<Integer> cdgoDestinatario) {

		List<Tbasg191DocInfrDestinatario> tbasg191DocInfrDestinatarios = tbasg191DocInfrDestinatarioRepository
				.findByCdgoDestinatarioIn(cdgoDestinatario);

		return toDtos(tbasg191DocInfrDestinatarios);
	}

	public List<Tbasg191DocInfrDestinatarioDto> getDocInfrDestinatarioList() {
		return toDtos(tbasg191DocInfrDestinatarioRepository.getDocInfrDestinatarioList());
	}

	public List<Tbasg191DocInfrDestinatarioDto> getDocInfrDestinatarioByCdgoDestinatario(String cdgoDestinatario) {
		return toDtos(tbasg191DocInfrDestinatarioRepository.getDocInfrDestinatarioByCdgoDestinatario(cdgoDestinatario));
	}

	public Tbasg191DocInfrDestinatarioDto toDto(Tbasg191DocInfrDestinatario orig) {

		Tbasg191DocInfrDestinatarioDto dest = new Tbasg191DocInfrDestinatarioDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg191DocInfrDestinatario toEntity(Tbasg191DocInfrDestinatarioDto orig) {

		Tbasg191DocInfrDestinatario dest = new Tbasg191DocInfrDestinatario();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg191DocInfrDestinatarioDto> toDtos(List<Tbasg191DocInfrDestinatario> orig) {

		List<Tbasg191DocInfrDestinatarioDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg191DocInfrDestinatario> toEntities(List<Tbasg191DocInfrDestinatarioDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg191DocInfrDestinatario> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
