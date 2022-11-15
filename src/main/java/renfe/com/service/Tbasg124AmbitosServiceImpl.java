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

import renfe.com.dto.GetAmbitosListAscendenteDTO;
import renfe.com.model.dto.Tbasg124AmbitosDto;
import renfe.com.model.entity.Tbasg124Ambitos;
import renfe.com.repository.Tbasg124AmbitosRepository;

@Transactional
@Service
public class Tbasg124AmbitosServiceImpl implements Tbasg124AmbitosService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg124AmbitosRepository tbasg124AmbitosRepository;

	public List<Tbasg124AmbitosDto> getAllTbasg124Ambitos(Tbasg124AmbitosDto filter) {

		logger.info("getAllTbasg124Ambitos " + filter);
		if (filter == null) {
			return this.toDtos(tbasg124AmbitosRepository.findAll());
		}
		return this.toDtos(tbasg124AmbitosRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg124AmbitosDto findByCdgoAmbitos(Integer cdgoAmbitos) {

		Optional<Tbasg124Ambitos> tbasg124AmbitosData = tbasg124AmbitosRepository.findByCdgoAmbitos(cdgoAmbitos);

		if (tbasg124AmbitosData.isPresent()) {
			return toDto(tbasg124AmbitosData.get());
		}
		return null;
	}

	public Tbasg124AmbitosDto createTbasg124Ambitos(Tbasg124AmbitosDto tbasg124AmbitosDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg124Ambitos dbTbasg124Ambitos = new Tbasg124Ambitos();
		BeanUtils.copyProperties(dbTbasg124Ambitos, tbasg124AmbitosDto);
		Tbasg124Ambitos _tbasg124Ambitos = tbasg124AmbitosRepository.save(dbTbasg124Ambitos);
		return toDto(_tbasg124Ambitos);
	}

	public Tbasg124AmbitosDto updateTbasg124Ambitos(Integer cdgoAmbitos, Tbasg124AmbitosDto tbasg124AmbitosDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg124Ambitos> tbasg124AmbitosData = tbasg124AmbitosRepository.findById(cdgoAmbitos);

		if (tbasg124AmbitosData.isPresent()) {
			Tbasg124Ambitos dbTbasg124Ambitos = tbasg124AmbitosData.get();
			BeanUtils.copyProperties(dbTbasg124Ambitos, tbasg124AmbitosDto);
			return toDto(tbasg124AmbitosRepository.save(dbTbasg124Ambitos));
		}
		return null;
	}

	public int deleteTbasg124Ambitos(Integer cdgoAmbitos) {

		tbasg124AmbitosRepository.deleteById(cdgoAmbitos);
		return 1;
	}

	public List<Tbasg124AmbitosDto> findByCdgoAmbitosIn(List<Integer> cdgoAmbitos) {

		List<Tbasg124Ambitos> tbasg124Ambitoss = tbasg124AmbitosRepository.findByCdgoAmbitosIn(cdgoAmbitos);

		return toDtos(tbasg124Ambitoss);
	}

	public List<Tbasg124AmbitosDto> getAmbitosCount() {
		return toDtos(tbasg124AmbitosRepository.getAmbitosCount());
	}

	public List<GetAmbitosListAscendenteDTO> getAmbitosListAscendente() {
		return tbasg124AmbitosRepository.getAmbitosListAscendente();
	}

	public List<Tbasg124AmbitosDto> getAmbitosListDescendente() {
		return toDtos(tbasg124AmbitosRepository.getAmbitosListDescendente());
	}

	public List<GetAmbitosListAscendenteDTO> getAmbitosTipoHabListAscendente(Integer cdgoTipohab) {
		return tbasg124AmbitosRepository.getAmbitosTipoHabListAscendente(cdgoTipohab);
	}

	public List<Tbasg124AmbitosDto> getAmbitosTipoHabListDescendente(String cdgoTipohab) {
		return toDtos(tbasg124AmbitosRepository.getAmbitosTipoHabListDescendente(cdgoTipohab));
	}

	public List<Tbasg124AmbitosDto> getAmbitosTipoHabCount(String cdgoTipohab) {
		return toDtos(tbasg124AmbitosRepository.getAmbitosTipoHabCount(cdgoTipohab));
	}

	public List<Tbasg124AmbitosDto> getAmbitosActiveList() {
		return toDtos(tbasg124AmbitosRepository.getAmbitosActiveList());
	}

	public List<Tbasg124AmbitosDto> getAmbitosActiveList2() {
		return toDtos(tbasg124AmbitosRepository.getAmbitosActiveList2());
	}

	public List<Tbasg124AmbitosDto> getAmbitos(String cdgoAmbitos) {
		return toDtos(tbasg124AmbitosRepository.getAmbitos(cdgoAmbitos));
	}

	public List<Tbasg124AmbitosDto> getAlcanceAmbito(Integer cdgoAmbitos) {
		return toDtos(tbasg124AmbitosRepository.getAlcanceAmbito(cdgoAmbitos));
	}

	public List<Tbasg124AmbitosDto> getAmbitosView(String cdgoAmbitos) {
		return toDtos(tbasg124AmbitosRepository.getAmbitosView(cdgoAmbitos));
	}

	public List<Tbasg124AmbitosDto> getAmbitosNombre(String desgNombre) {
		return toDtos(tbasg124AmbitosRepository.getAmbitosNombre(desgNombre));
	}

	public int insertAmbitos(Tbasg124Ambitos bean) {
		return tbasg124AmbitosRepository.insertAmbitos(bean);
	}

	public int updateAmbitos(Tbasg124Ambitos bean) {
		return tbasg124AmbitosRepository.updateAmbitos(bean);
	}
	
	public int estadoAmbitos(Tbasg124Ambitos bean) {
		return tbasg124AmbitosRepository.estadoAmbitos(bean);
	}

	public Tbasg124AmbitosDto toDto(Tbasg124Ambitos orig) {

		Tbasg124AmbitosDto dest = new Tbasg124AmbitosDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg124Ambitos toEntity(Tbasg124AmbitosDto orig) {

		Tbasg124Ambitos dest = new Tbasg124Ambitos();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg124AmbitosDto> toDtos(List<Tbasg124Ambitos> orig) {

		List<Tbasg124AmbitosDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg124Ambitos> toEntities(List<Tbasg124AmbitosDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg124Ambitos> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
