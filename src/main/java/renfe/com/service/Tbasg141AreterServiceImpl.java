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

import renfe.com.dto.GetAreTerListAscendenteDTO;
import renfe.com.model.dto.Tbasg141AreterDto;
import renfe.com.model.entity.Tbasg141Areter;
import renfe.com.repository.Tbasg141AreterRepository;

@Transactional
@Service
public class Tbasg141AreterServiceImpl implements Tbasg141AreterService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg141AreterRepository tbasg141AreterRepository;

	public List<Tbasg141AreterDto> getAllTbasg141Areter(Tbasg141AreterDto filter) {

		logger.info("getAllTbasg141Areter " + filter);
		if (filter == null) {
			return this.toDtos(tbasg141AreterRepository.findAll());
		}
		return this.toDtos(tbasg141AreterRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg141AreterDto findByCdgoAreter(Integer cdgoAreter) {

		Optional<Tbasg141Areter> tbasg141AreterData = tbasg141AreterRepository.findByCdgoAreter(cdgoAreter);

		if (tbasg141AreterData.isPresent()) {
			return toDto(tbasg141AreterData.get());
		}
		return null;
	}

	public Tbasg141AreterDto createTbasg141Areter(Tbasg141AreterDto tbasg141AreterDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg141Areter dbTbasg141Areter = new Tbasg141Areter();
		BeanUtils.copyProperties(dbTbasg141Areter, tbasg141AreterDto);
		Tbasg141Areter _tbasg141Areter = tbasg141AreterRepository.save(dbTbasg141Areter);
		return toDto(_tbasg141Areter);
	}

	public Tbasg141AreterDto updateTbasg141Areter(Integer cdgoAreter, Tbasg141AreterDto tbasg141AreterDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg141Areter> tbasg141AreterData = tbasg141AreterRepository.findById(cdgoAreter);

		if (tbasg141AreterData.isPresent()) {
			Tbasg141Areter dbTbasg141Areter = tbasg141AreterData.get();
			BeanUtils.copyProperties(dbTbasg141Areter, tbasg141AreterDto);
			return toDto(tbasg141AreterRepository.save(dbTbasg141Areter));
		}
		return null;
	}

	public int deleteTbasg141Areter(Integer cdgoAreter) {

		tbasg141AreterRepository.deleteById(cdgoAreter);
		return 1;
	}

	public List<Tbasg141AreterDto> findByCdgoAreterIn(List<Integer> cdgoAreter) {

		List<Tbasg141Areter> tbasg141Areters = tbasg141AreterRepository.findByCdgoAreterIn(cdgoAreter);

		return toDtos(tbasg141Areters);
	}

	public List<Tbasg141AreterDto> getAreTerCount() {
		return toDtos(tbasg141AreterRepository.getAreTerCount());
	}

	public List<Tbasg141AreterDto> getAreTerListDescendenteCDGO_ARETER(Integer cdgoAreAct) {
		return toDtos(tbasg141AreterRepository.getAreTerListDescendenteCDGO_ARETER(cdgoAreAct));
	}

	public List<Tbasg141AreterDto> getAreTerListAscendenteDESG_NOMBRE() {
		return toDtos(tbasg141AreterRepository.getAreTerListAscendenteDESG_NOMBRE());
	}

	public List<Tbasg141AreterDto> getAreTerListDescendenteDESG_NOMBRE() {
		return toDtos(tbasg141AreterRepository.getAreTerListDescendenteDESG_NOMBRE());
	}

	public List<Tbasg141AreterDto> getAreTerActiveListDescendenteCDGO_ARETER() {
		return toDtos(tbasg141AreterRepository.getAreTerActiveListDescendenteCDGO_ARETER());
	}

	public List<GetAreTerListAscendenteDTO> getAreTerListAscendente() {
		return tbasg141AreterRepository.getAreTerListAscendente();
	}
	
	public List<GetAreTerListAscendenteDTO> getAreTerActiveListAscendente() {
		return tbasg141AreterRepository.getAreTerActiveListAscendente();
	}
	
	public List<Tbasg141AreterDto> getAreTerActiveListAscendenteDESG_NOMBRE() {
		return toDtos(tbasg141AreterRepository.getAreTerActiveListAscendenteDESG_NOMBRE());
	}

	public List<Tbasg141AreterDto> getAreTerActiveListDescendenteDESG_NOMBRE() {
		return toDtos(tbasg141AreterRepository.getAreTerActiveListDescendenteDESG_NOMBRE());
	}

	public List<Tbasg141AreterDto> getAreTerActiveListByCdgoAreact(Integer cdgoAreact) {
		return toDtos(tbasg141AreterRepository.getAreTerActiveListByCdgoAreact(cdgoAreact));
	}		

	public List<Tbasg141AreterDto> getAreTer(String cdgoAreter) {
		return toDtos(tbasg141AreterRepository.getAreTer(cdgoAreter));
	}

	public List<Tbasg141AreterDto> getListAreTerByCodsAreTer(List<Integer>cdgoAreTerList) {
		return toDtos(tbasg141AreterRepository.getListAreTerByCodsAreTer(cdgoAreTerList));
	}

	public int insertAreTer(Tbasg141Areter bean) {
		return tbasg141AreterRepository.insertAreTer(bean);
	}

	public int updateAreTer(Tbasg141Areter bean) {
		return tbasg141AreterRepository.updateAreTer(bean);
	}
	
	public int estadoAreTer(Tbasg141Areter bean) {
		return tbasg141AreterRepository.estadoAreTer(bean);
	}

	public List<Tbasg141AreterDto> descAreaActPersona(String cdgoPersona) {
		return toDtos(tbasg141AreterRepository.descAreaActPersona(cdgoPersona));
	}

	public Tbasg141AreterDto toDto(Tbasg141Areter orig) {

		Tbasg141AreterDto dest = new Tbasg141AreterDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg141Areter toEntity(Tbasg141AreterDto orig) {

		Tbasg141Areter dest = new Tbasg141Areter();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg141AreterDto> toDtos(List<Tbasg141Areter> orig) {

		List<Tbasg141AreterDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg141Areter> toEntities(List<Tbasg141AreterDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg141Areter> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}

}
