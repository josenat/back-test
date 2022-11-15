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

import renfe.com.dto.GetCentMedicListAscCentHgadoDTO;
import renfe.com.model.dto.Tbasg108CentmedicDto;
import renfe.com.model.entity.Tbasg108Centmedic;
import renfe.com.repository.Tbasg108CentmedicRepository;

@Transactional
@Service
public class Tbasg108CentmedicServiceImpl implements Tbasg108CentmedicService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg108CentmedicRepository tbasg108CentmedicRepository;

	public List<Tbasg108CentmedicDto> getAllTbasg108Centmedic(Tbasg108CentmedicDto filter) {

		logger.info("getAllTbasg108Centmedic " + filter);
		if (filter == null) {
			return this.toDtos(tbasg108CentmedicRepository.findAll());
		}
		return this.toDtos(tbasg108CentmedicRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg108CentmedicDto findByCdgoCenmed(Integer cdgoCenmed) {

		Optional<Tbasg108Centmedic> tbasg108CentmedicData = tbasg108CentmedicRepository.findByCdgoCenmed(cdgoCenmed);

		if (tbasg108CentmedicData.isPresent()) {
			return toDto(tbasg108CentmedicData.get());
		}
		return null;
	}

	public Tbasg108CentmedicDto createTbasg108Centmedic(Tbasg108CentmedicDto tbasg108CentmedicDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg108Centmedic dbTbasg108Centmedic = new Tbasg108Centmedic();
		BeanUtils.copyProperties(dbTbasg108Centmedic, tbasg108CentmedicDto);
		Tbasg108Centmedic _tbasg108Centmedic = tbasg108CentmedicRepository.save(dbTbasg108Centmedic);
		return toDto(_tbasg108Centmedic);
	}

	public Tbasg108CentmedicDto updateTbasg108Centmedic(Integer cdgoCenmed, Tbasg108CentmedicDto tbasg108CentmedicDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg108Centmedic> tbasg108CentmedicData = tbasg108CentmedicRepository.findById(cdgoCenmed);

		if (tbasg108CentmedicData.isPresent()) {
			Tbasg108Centmedic dbTbasg108Centmedic = tbasg108CentmedicData.get();
			BeanUtils.copyProperties(dbTbasg108Centmedic, tbasg108CentmedicDto);
			return toDto(tbasg108CentmedicRepository.save(dbTbasg108Centmedic));
		}
		return null;
	}

	public int deleteTbasg108Centmedic(Integer cdgoCenmed) {

		tbasg108CentmedicRepository.deleteById(cdgoCenmed);
		return 1;
	}

	public List<Tbasg108CentmedicDto> findByCdgoCenmedIn(List<Integer> cdgoCenmed) {

		List<Tbasg108Centmedic> tbasg108Centmedics = tbasg108CentmedicRepository.findByCdgoCenmedIn(cdgoCenmed);

		return toDtos(tbasg108Centmedics);
	}

	public List<Tbasg108CentmedicDto> getCentMedicCount() {
		return toDtos(tbasg108CentmedicRepository.getCentMedicCount());
	}

	public List<Tbasg108CentmedicDto> getCentMedicViewCount() {
		return toDtos(tbasg108CentmedicRepository.getCentMedicViewCount());
	}

	public List<Tbasg108CentmedicDto> getCentMedicListAscendente() {
		return toDtos(tbasg108CentmedicRepository.getCentMedicListAscendente());
	}
	
	public List<GetCentMedicListAscCentHgadoDTO> getCentMedicListAscCentHgado(Integer cdgoCenthgado) {
		return tbasg108CentmedicRepository.getCentMedicListAscCentHgado(cdgoCenthgado);
	}

	public List<Tbasg108CentmedicDto> getCentMedicListDescendente() {
		return toDtos(tbasg108CentmedicRepository.getCentMedicListDescendente());
	}

	public List<Tbasg108CentmedicDto> getCentMedicActiveListAscendente() {
		return toDtos(tbasg108CentmedicRepository.getCentMedicActiveListAscendente());
	}

	public List<Tbasg108CentmedicDto> getCentMedicActiveListDescendente() {
		return toDtos(tbasg108CentmedicRepository.getCentMedicActiveListDescendente());
	}

	public List<Tbasg108CentmedicDto> getCentMedic(Integer cdgoCenmed) {
		return toDtos(tbasg108CentmedicRepository.getCentMedic(cdgoCenmed));
	}

	public List<Tbasg108CentmedicDto> getCentMedicActiveListAscendenteViewCDGO_CENTMEDIC(String cdgoCenthgado) {
		return toDtos(tbasg108CentmedicRepository.getCentMedicActiveListAscendenteViewCDGO_CENTMEDIC(cdgoCenthgado));
	}

	public List<Tbasg108CentmedicDto> getCentMedicActiveListDescendenteViewCDGO_CENTMEDIC(String cdgoCenthgado) {
		return toDtos(tbasg108CentmedicRepository.getCentMedicActiveListDescendenteViewCDGO_CENTMEDIC(cdgoCenthgado));
	}

	public List<Tbasg108CentmedicDto> getCentMedicListAscendenteViewCDGO_CENTMEDIC(String cdgoCenthgado) {
		return toDtos(tbasg108CentmedicRepository.getCentMedicListAscendenteViewCDGO_CENTMEDIC(cdgoCenthgado));
	}

	public List<Tbasg108CentmedicDto> getCentMedicListDescendenteViewCDGO_CENTMEDIC(String cdgoCenthgado) {
		return toDtos(tbasg108CentmedicRepository.getCentMedicListDescendenteViewCDGO_CENTMEDIC(cdgoCenthgado));
	}

	public int insertCentMedic(Tbasg108Centmedic bean) {
		return tbasg108CentmedicRepository.insertCentMedic(bean);
	}

	public int updateCentMedic(Tbasg108Centmedic bean) {
		return tbasg108CentmedicRepository.updateCentMedic(bean);
	}
	
	public int estadoCentMedic(Tbasg108Centmedic bean) {
		return tbasg108CentmedicRepository.estadoCentMedic(bean);
	}

	public int deleteCentMedicByCentHgado(Tbasg108Centmedic bean) {
		return tbasg108CentmedicRepository.deleteCentMedicByCentHgado(bean);
	}

	public Tbasg108CentmedicDto toDto(Tbasg108Centmedic orig) {

		Tbasg108CentmedicDto dest = new Tbasg108CentmedicDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg108Centmedic toEntity(Tbasg108CentmedicDto orig) {

		Tbasg108Centmedic dest = new Tbasg108Centmedic();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg108CentmedicDto> toDtos(List<Tbasg108Centmedic> orig) {

		List<Tbasg108CentmedicDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg108Centmedic> toEntities(List<Tbasg108CentmedicDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg108Centmedic> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
