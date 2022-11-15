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

import renfe.com.dto.GetCentContListAscendenteeDTO;
import renfe.com.model.dto.Tbasg132CentcontDto;
import renfe.com.model.entity.Tbasg132Centcont;
import renfe.com.repository.Tbasg132CentcontRepository;

@Transactional
@Service
public class Tbasg132CentcontServiceImpl implements Tbasg132CentcontService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg132CentcontRepository tbasg132CentcontRepository;

	public List<Tbasg132CentcontDto> getAllTbasg132Centcont(Tbasg132CentcontDto filter) {

		logger.info("getAllTbasg132Centcont " + filter);
		if (filter == null) {
			return this.toDtos(tbasg132CentcontRepository.findAll());
		}
		return this.toDtos(tbasg132CentcontRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg132CentcontDto findByCdgoCentcont(String cdgoCentcont) {

		Optional<Tbasg132Centcont> tbasg132CentcontData = tbasg132CentcontRepository.findByCdgoCentcont(cdgoCentcont);

		if (tbasg132CentcontData.isPresent()) {
			return toDto(tbasg132CentcontData.get());
		}
		return null;
	}

	public Tbasg132CentcontDto createTbasg132Centcont(Tbasg132CentcontDto tbasg132CentcontDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg132Centcont dbTbasg132Centcont = new Tbasg132Centcont();
		BeanUtils.copyProperties(dbTbasg132Centcont, tbasg132CentcontDto);
		Tbasg132Centcont _tbasg132Centcont = tbasg132CentcontRepository.save(dbTbasg132Centcont);
		return toDto(_tbasg132Centcont);
	}

	public Tbasg132CentcontDto updateTbasg132Centcont(String cdgoCentcont, Tbasg132CentcontDto tbasg132CentcontDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg132Centcont> tbasg132CentcontData = tbasg132CentcontRepository.findById(cdgoCentcont);

		if (tbasg132CentcontData.isPresent()) {
			Tbasg132Centcont dbTbasg132Centcont = tbasg132CentcontData.get();
			BeanUtils.copyProperties(dbTbasg132Centcont, tbasg132CentcontDto);
			return toDto(tbasg132CentcontRepository.save(dbTbasg132Centcont));
		}
		return null;
	}

	public int deleteTbasg132Centcont(String cdgoCentcont) {

		tbasg132CentcontRepository.deleteById(cdgoCentcont);
		return 1;
	}

	public List<Tbasg132CentcontDto> findByCdgoCentcontIn(List<String> cdgoCentcont) {

		List<Tbasg132Centcont> tbasg132Centconts = tbasg132CentcontRepository.findByCdgoCentcontIn(cdgoCentcont);

		return toDtos(tbasg132Centconts);
	}

	public List<Tbasg132CentcontDto> getCentContListRegistroAscendente() {
		return toDtos(tbasg132CentcontRepository.getCentContListRegistroAscendente());
	}

	public List<Tbasg132CentcontDto> getCentContListRegistroDescendente() {
		return toDtos(tbasg132CentcontRepository.getCentContListRegistroDescendente());
	}

	public List<Tbasg132CentcontDto> getCentContCount() {
		return toDtos(tbasg132CentcontRepository.getCentContCount());
	}

	public List<Tbasg132CentcontDto> getCentContListAscendente(String cdgoAreTer) {
		return toDtos(tbasg132CentcontRepository.getCentContListAscendente(cdgoAreTer));
	}

	public List<Tbasg132CentcontDto> getCentContListDescendente() {
		return toDtos(tbasg132CentcontRepository.getCentContListDescendente());
	}

	public List<Tbasg132CentcontDto> getCentContListAscendenteDESG_NOMBRE_PMG() {
		return toDtos(tbasg132CentcontRepository.getCentContListAscendenteDESG_NOMBRE_PMG());
	}

	public List<Tbasg132CentcontDto> getCentContListDescendenteDESG_NOMBRE_PMG() {
		return toDtos(tbasg132CentcontRepository.getCentContListDescendenteDESG_NOMBRE_PMG());
	}

	public List<Tbasg132CentcontDto> getCentContListAscendenteCDGO_CENTCONT() {
		return toDtos(tbasg132CentcontRepository.getCentContListAscendenteCDGO_CENTCONT());
	}

	public List<Tbasg132CentcontDto> getCentContListDescendenteCDGO_CENTCONT() {
		return toDtos(tbasg132CentcontRepository.getCentContListDescendenteCDGO_CENTCONT());
	}

	public List<Tbasg132CentcontDto> getCentContListByCdgoAreter(Integer cdgoAreter) {
		return toDtos(tbasg132CentcontRepository.getCentContListByCdgoAreter(cdgoAreter));
	}	

	public List<Tbasg132CentcontDto> getCentContListAscendenteDESG_NOMBRE() {
		return toDtos(tbasg132CentcontRepository.getCentContListAscendenteDESG_NOMBRE());
	}

	public List<Tbasg132CentcontDto> getCentContListDescendenteDESG_NOMBRE() {
		return toDtos(tbasg132CentcontRepository.getCentContListDescendenteDESG_NOMBRE());
	}

	public List<Tbasg132CentcontDto> getCentCont(String cdgoCentcont) {
		return toDtos(tbasg132CentcontRepository.getCentCont(cdgoCentcont));
	}

	public List<Tbasg132CentcontDto> getListCentContActive(Integer cdgoAreTer) {
		return toDtos(tbasg132CentcontRepository.getListCentContActive(cdgoAreTer));
	}
	
	public List<GetCentContListAscendenteeDTO> getCentContListAscendentee() {
		return tbasg132CentcontRepository.getCentContListAscendentee();
	}

	public int insertCentCont(Tbasg132Centcont bean) {
		return tbasg132CentcontRepository.insertCentCont(bean);
	}

	public int updateCentCont(Tbasg132Centcont bean) {
		return tbasg132CentcontRepository.updateCentCont(bean);
	}
	
	public int estadoCentCont(Tbasg132Centcont bean) {
		return tbasg132CentcontRepository.estadoCentCont(bean);
	}

	public Tbasg132CentcontDto toDto(Tbasg132Centcont orig) {

		Tbasg132CentcontDto dest = new Tbasg132CentcontDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg132Centcont toEntity(Tbasg132CentcontDto orig) {

		Tbasg132Centcont dest = new Tbasg132Centcont();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg132CentcontDto> toDtos(List<Tbasg132Centcont> orig) {

		List<Tbasg132CentcontDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg132Centcont> toEntities(List<Tbasg132CentcontDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg132Centcont> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
