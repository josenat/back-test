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

import renfe.com.model.dto.Tbasg260HabilifuncDto;
import renfe.com.model.entity.Tbasg260Habilifunc;
import renfe.com.model.entity.Tbasg260HabilifuncPK;
import renfe.com.repository.Tbasg260HabilifuncRepository;

@Service
public class Tbasg260HabilifuncServiceImpl implements Tbasg260HabilifuncService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg260HabilifuncRepository tbasg260HabilifuncRepository;

	public List<Tbasg260HabilifuncDto> getAllTbasg260Habilifunc(Tbasg260HabilifuncDto filter) {

		logger.info("getAllTbasg260Habilifunc " + filter);
		if (filter == null) {
			return this.toDtos(tbasg260HabilifuncRepository.findAll());
		}
		return this.toDtos(tbasg260HabilifuncRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg260HabilifuncDto findByCdgoIdiomaCdgoMensajeTipoHabi(String cdgoIdioma, String cdgoMensaje,
			Integer tipoHabi) {
		Tbasg260HabilifuncPK pk = new Tbasg260HabilifuncPK();
		pk.setCdgoIdioma(cdgoIdioma);
		pk.setCdgoMensaje(cdgoMensaje);
		pk.setTipoHabi(tipoHabi);
		Optional<Tbasg260Habilifunc> tbasg260HabilifuncData = tbasg260HabilifuncRepository.findById(pk);

		if (tbasg260HabilifuncData.isPresent()) {
			return toDto(tbasg260HabilifuncData.get());
		}
		return null;
	}

	public Tbasg260HabilifuncDto createTbasg260Habilifunc(Tbasg260HabilifuncDto tbasg260HabilifuncDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg260Habilifunc dbTbasg260Habilifunc = new Tbasg260Habilifunc();
		BeanUtils.copyProperties(dbTbasg260Habilifunc, tbasg260HabilifuncDto);
		Tbasg260Habilifunc _tbasg260Habilifunc = tbasg260HabilifuncRepository.save(dbTbasg260Habilifunc);
		return toDto(_tbasg260Habilifunc);
	}

	public Tbasg260HabilifuncDto updateTbasg260Habilifunc(String cdgoIdioma, String cdgoMensaje, Integer tipoHabi,
			Tbasg260HabilifuncDto tbasg260HabilifuncDto) throws IllegalAccessException, InvocationTargetException {
		Tbasg260HabilifuncPK pk = new Tbasg260HabilifuncPK();
		pk.setCdgoIdioma(cdgoIdioma);
		pk.setCdgoMensaje(cdgoMensaje);
		pk.setTipoHabi(tipoHabi);
		Optional<Tbasg260Habilifunc> tbasg260HabilifuncData = tbasg260HabilifuncRepository.findById(pk);

		if (tbasg260HabilifuncData.isPresent()) {
			Tbasg260Habilifunc dbTbasg260Habilifunc = tbasg260HabilifuncData.get();
			BeanUtils.copyProperties(dbTbasg260Habilifunc, tbasg260HabilifuncDto);
			return toDto(tbasg260HabilifuncRepository.save(dbTbasg260Habilifunc));
		}
		return null;
	}

	public int deleteTbasg260Habilifunc(String cdgoIdioma, String cdgoMensaje, Integer tipoHabi) {
		Tbasg260HabilifuncPK pk = new Tbasg260HabilifuncPK();
		pk.setCdgoIdioma(cdgoIdioma);
		pk.setCdgoMensaje(cdgoMensaje);
		pk.setTipoHabi(tipoHabi);
		tbasg260HabilifuncRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg260HabilifuncDto> findByCdgoIdiomaCdgoMensajeTipoHabiIn(List<String> cdgoIdioma,
			List<String> cdgoMensaje, List<Integer> tipoHabi) {
		List<Tbasg260HabilifuncPK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoIdioma.size(); i++) {
			Tbasg260HabilifuncPK newPk = new Tbasg260HabilifuncPK();
			newPk.setCdgoIdioma(cdgoIdioma.get(i));
			newPk.setCdgoMensaje(cdgoMensaje.get(i));
			newPk.setTipoHabi(tipoHabi.get(i));
			pks.add(newPk);
		}
		List<Tbasg260Habilifunc> tbasg260Habilifuncs = tbasg260HabilifuncRepository.findByTbasg260habilifuncpkIn(pks);

		return toDtos(tbasg260Habilifuncs);
	}

	public List<Tbasg260HabilifuncDto> getFuncionesAsocHabil(List<Integer> listHabilitaciones, String cdgoIdioma) {
		return toDtos(tbasg260HabilifuncRepository.getFuncionesAsocHabil(listHabilitaciones, cdgoIdioma));
	}

	public Tbasg260HabilifuncDto toDto(Tbasg260Habilifunc orig) {

		Tbasg260HabilifuncDto dest = new Tbasg260HabilifuncDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg260Habilifunc toEntity(Tbasg260HabilifuncDto orig) {

		Tbasg260Habilifunc dest = new Tbasg260Habilifunc();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg260HabilifuncDto> toDtos(List<Tbasg260Habilifunc> orig) {

		List<Tbasg260HabilifuncDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg260Habilifunc> toEntities(List<Tbasg260HabilifuncDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg260Habilifunc> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
