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

import renfe.com.model.dto.Tbasg177DocOrdenActiDatoDto;
import renfe.com.model.entity.Tbasg177DocOrdenActiDato;
import renfe.com.model.entity.Tbasg177DocOrdenActiDatoPK;
import renfe.com.repository.Tbasg177DocOrdenActiDatoRepository;

@Service
public class Tbasg177DocOrdenActiDatoServiceImpl implements Tbasg177DocOrdenActiDatoService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg177DocOrdenActiDatoRepository tbasg177DocOrdenActiDatoRepository;

	public List<Tbasg177DocOrdenActiDatoDto> getAllTbasg177DocOrdenActiDato(Tbasg177DocOrdenActiDatoDto filter) {

		logger.info("getAllTbasg177DocOrdenActiDato " + filter);
		if (filter == null) {
			return this.toDtos(tbasg177DocOrdenActiDatoRepository.findAll());
		}
		return this.toDtos(tbasg177DocOrdenActiDatoRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg177DocOrdenActiDatoDto findByCdgoClaveCdgoReferenciadoc(Integer cdgoClave, Integer cdgoReferenciadoc) {
		Tbasg177DocOrdenActiDatoPK pk = new Tbasg177DocOrdenActiDatoPK();
		pk.setCdgoClave(cdgoClave);
		pk.setCdgoReferenciadoc(cdgoReferenciadoc);
		Optional<Tbasg177DocOrdenActiDato> tbasg177DocOrdenActiDatoData = tbasg177DocOrdenActiDatoRepository
				.findById(pk);

		if (tbasg177DocOrdenActiDatoData.isPresent()) {
			return toDto(tbasg177DocOrdenActiDatoData.get());
		}
		return null;
	}

	public Tbasg177DocOrdenActiDatoDto createTbasg177DocOrdenActiDato(
			Tbasg177DocOrdenActiDatoDto tbasg177DocOrdenActiDatoDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg177DocOrdenActiDato dbTbasg177DocOrdenActiDato = new Tbasg177DocOrdenActiDato();
		BeanUtils.copyProperties(dbTbasg177DocOrdenActiDato, tbasg177DocOrdenActiDatoDto);
		Tbasg177DocOrdenActiDato _tbasg177DocOrdenActiDato = tbasg177DocOrdenActiDatoRepository
				.save(dbTbasg177DocOrdenActiDato);
		return toDto(_tbasg177DocOrdenActiDato);
	}

	public Tbasg177DocOrdenActiDatoDto updateTbasg177DocOrdenActiDato(Integer cdgoClave, Integer cdgoReferenciadoc,
			Tbasg177DocOrdenActiDatoDto tbasg177DocOrdenActiDatoDto)
			throws IllegalAccessException, InvocationTargetException {
		Tbasg177DocOrdenActiDatoPK pk = new Tbasg177DocOrdenActiDatoPK();
		pk.setCdgoClave(cdgoClave);
		pk.setCdgoReferenciadoc(cdgoReferenciadoc);
		Optional<Tbasg177DocOrdenActiDato> tbasg177DocOrdenActiDatoData = tbasg177DocOrdenActiDatoRepository
				.findById(pk);

		if (tbasg177DocOrdenActiDatoData.isPresent()) {
			Tbasg177DocOrdenActiDato dbTbasg177DocOrdenActiDato = tbasg177DocOrdenActiDatoData.get();
			BeanUtils.copyProperties(dbTbasg177DocOrdenActiDato, tbasg177DocOrdenActiDatoDto);
			return toDto(tbasg177DocOrdenActiDatoRepository.save(dbTbasg177DocOrdenActiDato));
		}
		return null;
	}

	public int deleteTbasg177DocOrdenActiDato(Integer cdgoClave, Integer cdgoReferenciadoc) {
		Tbasg177DocOrdenActiDatoPK pk = new Tbasg177DocOrdenActiDatoPK();
		pk.setCdgoClave(cdgoClave);
		pk.setCdgoReferenciadoc(cdgoReferenciadoc);
		tbasg177DocOrdenActiDatoRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg177DocOrdenActiDatoDto> findByCdgoClaveCdgoReferenciadocIn(List<Integer> cdgoClave,
			List<Integer> cdgoReferenciadoc) {
		List<Tbasg177DocOrdenActiDatoPK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoClave.size(); i++) {
			Tbasg177DocOrdenActiDatoPK newPk = new Tbasg177DocOrdenActiDatoPK();
			newPk.setCdgoClave(cdgoClave.get(i));
			newPk.setCdgoReferenciadoc(cdgoReferenciadoc.get(i));
			pks.add(newPk);
		}
		List<Tbasg177DocOrdenActiDato> tbasg177DocOrdenActiDatos = tbasg177DocOrdenActiDatoRepository
				.findByTbasg177docordenactidatopkIn(pks);

		return toDtos(tbasg177DocOrdenActiDatos);
	}

	public List<Tbasg177DocOrdenActiDatoDto> getDocOrdenActiDatoActiveList(String cdgoReferenciadoc) {
		return toDtos(tbasg177DocOrdenActiDatoRepository.getDocOrdenActiDatoActiveList(cdgoReferenciadoc));
	}

	public List<Tbasg177DocOrdenActiDatoDto> getDocOrdenActiDatoList(String cdgoReferenciadoc) {
		return toDtos(tbasg177DocOrdenActiDatoRepository.getDocOrdenActiDatoList(cdgoReferenciadoc));
	}

	public List<Tbasg177DocOrdenActiDatoDto> getDocOrdenActiDato(String cdgoReferenciadoc, String cdgoClave) {
		return toDtos(tbasg177DocOrdenActiDatoRepository.getDocOrdenActiDato(cdgoReferenciadoc, cdgoClave));
	}

	public int insertDocOrdenActiDato(Tbasg177DocOrdenActiDato bean) {
		return tbasg177DocOrdenActiDatoRepository.insertDocOrdenActiDato(bean);
	}

	public int updateDocOrdenActiDato(Tbasg177DocOrdenActiDato bean) {
		return tbasg177DocOrdenActiDatoRepository.updateDocOrdenActiDato(bean);
	}

	public Tbasg177DocOrdenActiDatoDto toDto(Tbasg177DocOrdenActiDato orig) {

		Tbasg177DocOrdenActiDatoDto dest = new Tbasg177DocOrdenActiDatoDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg177DocOrdenActiDato toEntity(Tbasg177DocOrdenActiDatoDto orig) {

		Tbasg177DocOrdenActiDato dest = new Tbasg177DocOrdenActiDato();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg177DocOrdenActiDatoDto> toDtos(List<Tbasg177DocOrdenActiDato> orig) {

		List<Tbasg177DocOrdenActiDatoDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg177DocOrdenActiDato> toEntities(List<Tbasg177DocOrdenActiDatoDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg177DocOrdenActiDato> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
