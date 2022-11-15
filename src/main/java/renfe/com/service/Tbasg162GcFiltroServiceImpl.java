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

import renfe.com.model.dto.Tbasg162GcFiltroDto;
import renfe.com.model.entity.Tbasg162GcFiltro;
import renfe.com.repository.Tbasg162GcFiltroRepository;

@Service
public class Tbasg162GcFiltroServiceImpl implements Tbasg162GcFiltroService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg162GcFiltroRepository tbasg162GcFiltroRepository;

	public List<Tbasg162GcFiltroDto> getAllTbasg162GcFiltro(Tbasg162GcFiltroDto filter) {

		logger.info("getAllTbasg162GcFiltro " + filter);
		if (filter == null) {
			return this.toDtos(tbasg162GcFiltroRepository.findAll());
		}
		return this.toDtos(tbasg162GcFiltroRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg162GcFiltroDto findByCdgoFiltro(Integer cdgoFiltro) {

		Optional<Tbasg162GcFiltro> tbasg162GcFiltroData = tbasg162GcFiltroRepository.findByCdgoFiltro(cdgoFiltro);

		if (tbasg162GcFiltroData.isPresent()) {
			return toDto(tbasg162GcFiltroData.get());
		}
		return null;
	}

	public Tbasg162GcFiltroDto createTbasg162GcFiltro(Tbasg162GcFiltroDto tbasg162GcFiltroDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg162GcFiltro dbTbasg162GcFiltro = new Tbasg162GcFiltro();
		BeanUtils.copyProperties(dbTbasg162GcFiltro, tbasg162GcFiltroDto);
		Tbasg162GcFiltro _tbasg162GcFiltro = tbasg162GcFiltroRepository.save(dbTbasg162GcFiltro);
		return toDto(_tbasg162GcFiltro);
	}

	public Tbasg162GcFiltroDto updateTbasg162GcFiltro(Integer cdgoFiltro, Tbasg162GcFiltroDto tbasg162GcFiltroDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg162GcFiltro> tbasg162GcFiltroData = tbasg162GcFiltroRepository.findById(cdgoFiltro);

		if (tbasg162GcFiltroData.isPresent()) {
			Tbasg162GcFiltro dbTbasg162GcFiltro = tbasg162GcFiltroData.get();
			BeanUtils.copyProperties(dbTbasg162GcFiltro, tbasg162GcFiltroDto);
			return toDto(tbasg162GcFiltroRepository.save(dbTbasg162GcFiltro));
		}
		return null;
	}

	public int deleteTbasg162GcFiltro(Integer cdgoFiltro) {

		tbasg162GcFiltroRepository.deleteById(cdgoFiltro);
		return 1;
	}

	public List<Tbasg162GcFiltroDto> findByCdgoFiltroIn(List<Integer> cdgoFiltro) {

		List<Tbasg162GcFiltro> tbasg162GcFiltros = tbasg162GcFiltroRepository.findByCdgoFiltroIn(cdgoFiltro);

		return toDtos(tbasg162GcFiltros);
	}

	public List<Tbasg162GcFiltroDto> getGcFiltrosListActive(String cdgoConsulta) {
		return toDtos(tbasg162GcFiltroRepository.getGcFiltrosListActive(cdgoConsulta));
	}

	public List<Tbasg162GcFiltroDto> getGcFiltrosList(String cdgoConsulta) {
		return toDtos(tbasg162GcFiltroRepository.getGcFiltrosList(cdgoConsulta));
	}

	public List<Tbasg162GcFiltroDto> getGcFiltro(String cdgoFiltro) {
		return toDtos(tbasg162GcFiltroRepository.getGcFiltro(cdgoFiltro));
	}

	public int insertGcFiltro(Tbasg162GcFiltro bean) {
		return tbasg162GcFiltroRepository.insertGcFiltro(bean);
	}

	public int updateGcFiltro(Tbasg162GcFiltro bean) {
		return tbasg162GcFiltroRepository.updateGcFiltro(bean);
	}

	public int deleteGcFiltroLogico(Tbasg162GcFiltro bean) {
		return tbasg162GcFiltroRepository.deleteGcFiltroLogico(bean);
	}

	public int deleteGcFiltrosConsulta(Tbasg162GcFiltro bean) {
		return tbasg162GcFiltroRepository.deleteGcFiltrosConsulta(bean);
	}

	public Tbasg162GcFiltroDto toDto(Tbasg162GcFiltro orig) {

		Tbasg162GcFiltroDto dest = new Tbasg162GcFiltroDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg162GcFiltro toEntity(Tbasg162GcFiltroDto orig) {

		Tbasg162GcFiltro dest = new Tbasg162GcFiltro();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg162GcFiltroDto> toDtos(List<Tbasg162GcFiltro> orig) {

		List<Tbasg162GcFiltroDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg162GcFiltro> toEntities(List<Tbasg162GcFiltroDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg162GcFiltro> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
