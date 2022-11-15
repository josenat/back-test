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

import renfe.com.model.dto.Tbasg106ProvinciaDto;
import renfe.com.model.entity.Tbasg106Provincia;
import renfe.com.repository.Tbasg106ProvinciaRepository;

@Transactional
@Service
public class Tbasg106ProvinciaServiceImpl implements Tbasg106ProvinciaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg106ProvinciaRepository tbasg106ProvinciaRepository;

	public List<Tbasg106ProvinciaDto> getAllTbasg106Provincia(Tbasg106ProvinciaDto filter) {

		logger.info("getAllTbasg106Provincia " + filter);
		if (filter == null) {
			return this.toDtos(tbasg106ProvinciaRepository.findAll());
		}
		return this.toDtos(tbasg106ProvinciaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg106ProvinciaDto findByCdgoProvincia(Integer cdgoProvincia) {

		Optional<Tbasg106Provincia> tbasg106ProvinciaData = tbasg106ProvinciaRepository
				.findByCdgoProvincia(cdgoProvincia);

		if (tbasg106ProvinciaData.isPresent()) {
			return toDto(tbasg106ProvinciaData.get());
		}
		return null;
	}

	public Tbasg106ProvinciaDto createTbasg106Provincia(Tbasg106ProvinciaDto tbasg106ProvinciaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg106Provincia dbTbasg106Provincia = new Tbasg106Provincia();
		BeanUtils.copyProperties(dbTbasg106Provincia, tbasg106ProvinciaDto);
		Tbasg106Provincia _tbasg106Provincia = tbasg106ProvinciaRepository.save(dbTbasg106Provincia);
		return toDto(_tbasg106Provincia);
	}

	public Tbasg106ProvinciaDto updateTbasg106Provincia(Integer cdgoProvincia,
			Tbasg106ProvinciaDto tbasg106ProvinciaDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg106Provincia> tbasg106ProvinciaData = tbasg106ProvinciaRepository.findById(cdgoProvincia);

		if (tbasg106ProvinciaData.isPresent()) {
			Tbasg106Provincia dbTbasg106Provincia = tbasg106ProvinciaData.get();
			BeanUtils.copyProperties(dbTbasg106Provincia, tbasg106ProvinciaDto);
			return toDto(tbasg106ProvinciaRepository.save(dbTbasg106Provincia));
		}
		return null;
	}

	public int deleteTbasg106Provincia(Integer cdgoProvincia) {

		tbasg106ProvinciaRepository.deleteById(cdgoProvincia);
		return 1;
	}

	public List<Tbasg106ProvinciaDto> findByCdgoProvinciaIn(List<Integer> cdgoProvincia) {

		List<Tbasg106Provincia> tbasg106Provincias = tbasg106ProvinciaRepository.findByCdgoProvinciaIn(cdgoProvincia);

		return toDtos(tbasg106Provincias);
	}

	public List<Tbasg106ProvinciaDto> getProvinciaCount() {
		return toDtos(tbasg106ProvinciaRepository.getProvinciaCount());
	}

	public List<Tbasg106ProvinciaDto> getProvinciaListAscendente() {
		return toDtos(tbasg106ProvinciaRepository.getProvinciaListAscendente());
	}

	public List<Tbasg106ProvinciaDto> getProvinciaListDescendente() {
		return toDtos(tbasg106ProvinciaRepository.getProvinciaListDescendente());
	}

	public List<Tbasg106ProvinciaDto> getProvinciaListActiveAscendente() {
		return toDtos(tbasg106ProvinciaRepository.getProvinciaListActiveAscendente());
	}

	public List<Tbasg106ProvinciaDto> getProvinciaListActiveDescendente() {
		return toDtos(tbasg106ProvinciaRepository.getProvinciaListActiveDescendente());
	}

	public List<Tbasg106ProvinciaDto> getProvincia(String cdgoProvincia) {
		return toDtos(tbasg106ProvinciaRepository.getProvincia(cdgoProvincia));
	}

	public int insertProvincia(Tbasg106Provincia bean) {
		return tbasg106ProvinciaRepository.insertProvincia(bean);
	}

	public int updateProvincia(Tbasg106Provincia bean) {
		return tbasg106ProvinciaRepository.updateProvincia(bean);
	}
	
	public int estadoProvincia(Tbasg106Provincia bean) {
		return tbasg106ProvinciaRepository.estadoProvincia(bean);
	}

	public Tbasg106ProvinciaDto toDto(Tbasg106Provincia orig) {

		Tbasg106ProvinciaDto dest = new Tbasg106ProvinciaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg106Provincia toEntity(Tbasg106ProvinciaDto orig) {

		Tbasg106Provincia dest = new Tbasg106Provincia();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg106ProvinciaDto> toDtos(List<Tbasg106Provincia> orig) {

		List<Tbasg106ProvinciaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg106Provincia> toEntities(List<Tbasg106ProvinciaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg106Provincia> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
