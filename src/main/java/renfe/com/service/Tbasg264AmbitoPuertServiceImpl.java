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

import renfe.com.model.dto.Tbasg264AmbitoPuertDto;
import renfe.com.model.entity.Tbasg264AmbitoPuert;
import renfe.com.repository.Tbasg264AmbitoPuertRepository;

@Transactional
@Service
public class Tbasg264AmbitoPuertServiceImpl implements Tbasg264AmbitoPuertService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg264AmbitoPuertRepository tbasg264AmbitoPuertRepository;

	public List<Tbasg264AmbitoPuertDto> getAllTbasg264AmbitoPuert(Tbasg264AmbitoPuertDto filter) {

		logger.info("getAllTbasg264AmbitoPuert " + filter);
		if (filter == null) {
			return this.toDtos(tbasg264AmbitoPuertRepository.findAll());
		}
		return this.toDtos(tbasg264AmbitoPuertRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg264AmbitoPuertDto findByCdgoPuerto(String cdgoPuerto) {

		Optional<Tbasg264AmbitoPuert> tbasg264AmbitoPuertData = tbasg264AmbitoPuertRepository
				.findByCdgoPuerto(cdgoPuerto);

		if (tbasg264AmbitoPuertData.isPresent()) {
			return toDto(tbasg264AmbitoPuertData.get());
		}
		return null;
	}

	public Tbasg264AmbitoPuertDto createTbasg264AmbitoPuert(Tbasg264AmbitoPuertDto tbasg264AmbitoPuertDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg264AmbitoPuert dbTbasg264AmbitoPuert = new Tbasg264AmbitoPuert();
		BeanUtils.copyProperties(dbTbasg264AmbitoPuert, tbasg264AmbitoPuertDto);
		Tbasg264AmbitoPuert _tbasg264AmbitoPuert = tbasg264AmbitoPuertRepository.save(dbTbasg264AmbitoPuert);
		return toDto(_tbasg264AmbitoPuert);
	}

	public Tbasg264AmbitoPuertDto updateTbasg264AmbitoPuert(String cdgoPuerto,
			Tbasg264AmbitoPuertDto tbasg264AmbitoPuertDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg264AmbitoPuert> tbasg264AmbitoPuertData = tbasg264AmbitoPuertRepository.findById(cdgoPuerto);

		if (tbasg264AmbitoPuertData.isPresent()) {
			Tbasg264AmbitoPuert dbTbasg264AmbitoPuert = tbasg264AmbitoPuertData.get();
			BeanUtils.copyProperties(dbTbasg264AmbitoPuert, tbasg264AmbitoPuertDto);
			return toDto(tbasg264AmbitoPuertRepository.save(dbTbasg264AmbitoPuert));
		}
		return null;
	}

	public int deleteTbasg264AmbitoPuert(String cdgoPuerto) {

		tbasg264AmbitoPuertRepository.deleteById(cdgoPuerto);
		return 1;
	}

	public List<Tbasg264AmbitoPuertDto> findByCdgoPuertoIn(List<String> cdgoPuerto) {

		List<Tbasg264AmbitoPuert> tbasg264AmbitoPuerts = tbasg264AmbitoPuertRepository.findByCdgoPuertoIn(cdgoPuerto);

		return toDtos(tbasg264AmbitoPuerts);
	}

	public List<Tbasg264AmbitoPuertDto> getListaAmbitoPuertosActiv() {
		return toDtos(tbasg264AmbitoPuertRepository.getListaAmbitoPuertosActiv());
	}

	public List<Tbasg264AmbitoPuertDto> getDescTipoAmbitoPuertos(String cdgoPuerto) {
		return toDtos(tbasg264AmbitoPuertRepository.getDescTipoAmbitoPuertos(cdgoPuerto));
	}

	public List<Tbasg264AmbitoPuertDto> getAmbitoPuertoCount() {
		return toDtos(tbasg264AmbitoPuertRepository.getAmbitoPuertoCount());
	}

	public List<Tbasg264AmbitoPuertDto> getMaxAmbitoPuerto() {
		return toDtos(tbasg264AmbitoPuertRepository.getMaxAmbitoPuerto());
	}

	public List<Tbasg264AmbitoPuertDto> getAmbitoPuertoListAscendente() {
		return toDtos(tbasg264AmbitoPuertRepository.getAmbitoPuertoListAscendente());
	}
	
	public List<Tbasg264AmbitoPuertDto> getCdgoPuertAutoInc() {
		return toDtos(tbasg264AmbitoPuertRepository.getCdgoPuertAutoInc());
	}

	public List<Tbasg264AmbitoPuertDto> getAmbitoPuertoListDescendente() {
		return toDtos(tbasg264AmbitoPuertRepository.getAmbitoPuertoListDescendente());
	}

	public List<Tbasg264AmbitoPuertDto> getAmbitoPuerto(String cdgoPuerto) {
		return toDtos(tbasg264AmbitoPuertRepository.getAmbitoPuerto(cdgoPuerto));
	}

	public List<Tbasg264AmbitoPuertDto> getAmbitoPuertoByNombre(String desgPuerto) {
		return toDtos(tbasg264AmbitoPuertRepository.getAmbitoPuertoByNombre(desgPuerto));
	}

	public List<Tbasg264AmbitoPuertDto> getAmbitoPuertoListActive() {
		return toDtos(tbasg264AmbitoPuertRepository.getAmbitoPuertoListActive());
	}

	public int insertAmbitoPuerto(Tbasg264AmbitoPuert bean) {
		return tbasg264AmbitoPuertRepository.insertAmbitoPuerto(bean);
	}

	public int updateAmbitoPuerto(Tbasg264AmbitoPuert bean) {
		return tbasg264AmbitoPuertRepository.updateAmbitoPuerto(bean);
	}
	
	public int estadoAmbitoPuerto(Tbasg264AmbitoPuert bean) {
		return tbasg264AmbitoPuertRepository.estadoAmbitoPuerto(bean);
	}

	public Tbasg264AmbitoPuertDto toDto(Tbasg264AmbitoPuert orig) {

		Tbasg264AmbitoPuertDto dest = new Tbasg264AmbitoPuertDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg264AmbitoPuert toEntity(Tbasg264AmbitoPuertDto orig) {

		Tbasg264AmbitoPuert dest = new Tbasg264AmbitoPuert();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg264AmbitoPuertDto> toDtos(List<Tbasg264AmbitoPuert> orig) {

		List<Tbasg264AmbitoPuertDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg264AmbitoPuert> toEntities(List<Tbasg264AmbitoPuertDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg264AmbitoPuert> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
