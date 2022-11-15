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

import renfe.com.model.dto.Tbasg144NivaccesoDto;
import renfe.com.model.entity.Tbasg144Nivacceso;
import renfe.com.repository.Tbasg144NivaccesoRepository;

@Service
public class Tbasg144NivaccesoServiceImpl implements Tbasg144NivaccesoService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg144NivaccesoRepository tbasg144NivaccesoRepository;

	public List<Tbasg144NivaccesoDto> getAllTbasg144Nivacceso(Tbasg144NivaccesoDto filter) {

		logger.info("getAllTbasg144Nivacceso " + filter);
		if (filter == null) {
			return this.toDtos(tbasg144NivaccesoRepository.findAll());
		}
		return this.toDtos(tbasg144NivaccesoRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg144NivaccesoDto findByCdgoNivel(String cdgoNivel) {

		Optional<Tbasg144Nivacceso> tbasg144NivaccesoData = tbasg144NivaccesoRepository.findByCdgoNivel(cdgoNivel);

		if (tbasg144NivaccesoData.isPresent()) {
			return toDto(tbasg144NivaccesoData.get());
		}
		return null;
	}

	public Tbasg144NivaccesoDto createTbasg144Nivacceso(Tbasg144NivaccesoDto tbasg144NivaccesoDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg144Nivacceso dbTbasg144Nivacceso = new Tbasg144Nivacceso();
		BeanUtils.copyProperties(dbTbasg144Nivacceso, tbasg144NivaccesoDto);
		Tbasg144Nivacceso _tbasg144Nivacceso = tbasg144NivaccesoRepository.save(dbTbasg144Nivacceso);
		return toDto(_tbasg144Nivacceso);
	}

	public Tbasg144NivaccesoDto updateTbasg144Nivacceso(String cdgoNivel, Tbasg144NivaccesoDto tbasg144NivaccesoDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg144Nivacceso> tbasg144NivaccesoData = tbasg144NivaccesoRepository.findById(cdgoNivel);

		if (tbasg144NivaccesoData.isPresent()) {
			Tbasg144Nivacceso dbTbasg144Nivacceso = tbasg144NivaccesoData.get();
			BeanUtils.copyProperties(dbTbasg144Nivacceso, tbasg144NivaccesoDto);
			return toDto(tbasg144NivaccesoRepository.save(dbTbasg144Nivacceso));
		}
		return null;
	}

	public int deleteTbasg144Nivacceso(String cdgoNivel) {

		tbasg144NivaccesoRepository.deleteById(cdgoNivel);
		return 1;
	}

	public List<Tbasg144NivaccesoDto> findByCdgoNivelIn(List<String> cdgoNivel) {

		List<Tbasg144Nivacceso> tbasg144Nivaccesos = tbasg144NivaccesoRepository.findByCdgoNivelIn(cdgoNivel);

		return toDtos(tbasg144Nivaccesos);
	}

	/*public List<Tbasg144NivaccesoDto> getNivAccesoCount() {
		return toDtos(tbasg144NivaccesoRepository.getNivAccesoCount());
	}*/
	
	public Long getNivAccesoCount() {
		return tbasg144NivaccesoRepository.getNivAccesoCount();
	}

	public List<Tbasg144NivaccesoDto> getNivAccesoAll() {
		return toDtos(tbasg144NivaccesoRepository.getNivAccesoAll());
	}

	public Tbasg144NivaccesoDto toDto(Tbasg144Nivacceso orig) {

		Tbasg144NivaccesoDto dest = new Tbasg144NivaccesoDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg144Nivacceso toEntity(Tbasg144NivaccesoDto orig) {

		Tbasg144Nivacceso dest = new Tbasg144Nivacceso();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg144NivaccesoDto> toDtos(List<Tbasg144Nivacceso> orig) {

		List<Tbasg144NivaccesoDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg144Nivacceso> toEntities(List<Tbasg144NivaccesoDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg144Nivacceso> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
