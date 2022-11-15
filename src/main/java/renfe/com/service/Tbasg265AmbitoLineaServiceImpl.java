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

import renfe.com.model.dto.Tbasg265AmbitoLineaDto;
import renfe.com.model.entity.Tbasg265AmbitoLinea;
import renfe.com.repository.Tbasg265AmbitoLineaRepository;

@Transactional
@Service
public class Tbasg265AmbitoLineaServiceImpl implements Tbasg265AmbitoLineaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg265AmbitoLineaRepository tbasg265AmbitoLineaRepository;

	public List<Tbasg265AmbitoLineaDto> getAllTbasg265AmbitoLinea(Tbasg265AmbitoLineaDto filter) {

		logger.info("getAllTbasg265AmbitoLinea " + filter);
		if (filter == null) {
			return this.toDtos(tbasg265AmbitoLineaRepository.findAll());
		}
		return this.toDtos(tbasg265AmbitoLineaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg265AmbitoLineaDto findByCdgoLinea(String cdgoLinea) {

		Optional<Tbasg265AmbitoLinea> tbasg265AmbitoLineaData = tbasg265AmbitoLineaRepository
				.findByCdgoLinea(cdgoLinea);

		if (tbasg265AmbitoLineaData.isPresent()) {
			return toDto(tbasg265AmbitoLineaData.get());
		}
		return null;
	}

	public Tbasg265AmbitoLineaDto createTbasg265AmbitoLinea(Tbasg265AmbitoLineaDto tbasg265AmbitoLineaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg265AmbitoLinea dbTbasg265AmbitoLinea = new Tbasg265AmbitoLinea();
		BeanUtils.copyProperties(dbTbasg265AmbitoLinea, tbasg265AmbitoLineaDto);
		Tbasg265AmbitoLinea _tbasg265AmbitoLinea = tbasg265AmbitoLineaRepository.save(dbTbasg265AmbitoLinea);
		return toDto(_tbasg265AmbitoLinea);
	}

	public Tbasg265AmbitoLineaDto updateTbasg265AmbitoLinea(String cdgoLinea,
			Tbasg265AmbitoLineaDto tbasg265AmbitoLineaDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg265AmbitoLinea> tbasg265AmbitoLineaData = tbasg265AmbitoLineaRepository.findById(cdgoLinea);

		if (tbasg265AmbitoLineaData.isPresent()) {
			Tbasg265AmbitoLinea dbTbasg265AmbitoLinea = tbasg265AmbitoLineaData.get();
			BeanUtils.copyProperties(dbTbasg265AmbitoLinea, tbasg265AmbitoLineaDto);
			return toDto(tbasg265AmbitoLineaRepository.save(dbTbasg265AmbitoLinea));
		}
		return null;
	}

	public int deleteTbasg265AmbitoLinea(String cdgoLinea) {

		tbasg265AmbitoLineaRepository.deleteById(cdgoLinea);
		return 1;
	}

	public List<Tbasg265AmbitoLineaDto> findByCdgoLineaIn(List<String> cdgoLinea) {

		List<Tbasg265AmbitoLinea> tbasg265AmbitoLineas = tbasg265AmbitoLineaRepository.findByCdgoLineaIn(cdgoLinea);

		return toDtos(tbasg265AmbitoLineas);
	}

	public List<Tbasg265AmbitoLineaDto> getListaAmbitoLineasActiv() {
		return toDtos(tbasg265AmbitoLineaRepository.getListaAmbitoLineasActiv());
	}

	public List<Tbasg265AmbitoLineaDto> getDescTipoAmbitoLineas(String cdgoLinea) {
		return toDtos(tbasg265AmbitoLineaRepository.getDescTipoAmbitoLineas(cdgoLinea));
	}

	public List<Tbasg265AmbitoLineaDto> getAmbitoLineaCount() {
		return toDtos(tbasg265AmbitoLineaRepository.getAmbitoLineaCount());
	}

	public List<Tbasg265AmbitoLineaDto> getMaxAmbitoLinea() {
		return toDtos(tbasg265AmbitoLineaRepository.getMaxAmbitoLinea());
	}

	public List<Tbasg265AmbitoLineaDto> getAmbitoLineaListAscendente() {
		return toDtos(tbasg265AmbitoLineaRepository.getAmbitoLineaListAscendente());
	}
	
	public List<Tbasg265AmbitoLineaDto> getCdgoLineaAutoInc() {
		return toDtos(tbasg265AmbitoLineaRepository.getCdgoLineaAutoInc());
	}

	public List<Tbasg265AmbitoLineaDto> getAmbitoLineaListDescendente() {
		return toDtos(tbasg265AmbitoLineaRepository.getAmbitoLineaListDescendente());
	}

	public List<Tbasg265AmbitoLineaDto> getAmbitoLinea(String cdgoLinea) {
		return toDtos(tbasg265AmbitoLineaRepository.getAmbitoLinea(cdgoLinea));
	}

	public List<Tbasg265AmbitoLineaDto> getAmbitoLineaByNombre(String desgLinea) {
		return toDtos(tbasg265AmbitoLineaRepository.getAmbitoLineaByNombre(desgLinea));
	}

	public List<Tbasg265AmbitoLineaDto> getAmbitoLineaListActive() {
		return toDtos(tbasg265AmbitoLineaRepository.getAmbitoLineaListActive());
	}

	public int insertAmbitoLinea(Tbasg265AmbitoLinea bean) {
		return tbasg265AmbitoLineaRepository.insertAmbitoLinea(bean);
	}

	public int updateAmbitoLinea(Tbasg265AmbitoLinea bean) {
		return tbasg265AmbitoLineaRepository.updateAmbitoLinea(bean);
	}

	public int estadoAmbitoLinea(Tbasg265AmbitoLinea bean) {
		return tbasg265AmbitoLineaRepository.estadoAmbitoLinea(bean);
	}
	
	public Tbasg265AmbitoLineaDto toDto(Tbasg265AmbitoLinea orig) {

		Tbasg265AmbitoLineaDto dest = new Tbasg265AmbitoLineaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg265AmbitoLinea toEntity(Tbasg265AmbitoLineaDto orig) {

		Tbasg265AmbitoLinea dest = new Tbasg265AmbitoLinea();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg265AmbitoLineaDto> toDtos(List<Tbasg265AmbitoLinea> orig) {

		List<Tbasg265AmbitoLineaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg265AmbitoLinea> toEntities(List<Tbasg265AmbitoLineaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg265AmbitoLinea> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
