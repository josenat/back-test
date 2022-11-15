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

import renfe.com.model.dto.Tbasg135CargoDto;
import renfe.com.model.entity.Tbasg135Cargo;
import renfe.com.repository.Tbasg135CargoRepository;

@Transactional
@Service
public class Tbasg135CargoServiceImpl implements Tbasg135CargoService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg135CargoRepository tbasg135CargoRepository;

	public List<Tbasg135CargoDto> getAllTbasg135Cargo(Tbasg135CargoDto filter) {

		logger.info("getAllTbasg135Cargo " + filter);
		if (filter == null) {
			return this.toDtos(tbasg135CargoRepository.findAll());
		}
		return this.toDtos(tbasg135CargoRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg135CargoDto findByCdgoCargo(String cdgoCargo) {

		Optional<Tbasg135Cargo> tbasg135CargoData = tbasg135CargoRepository.findByCdgoCargo(cdgoCargo);

		if (tbasg135CargoData.isPresent()) {
			return toDto(tbasg135CargoData.get());
		}
		return null;
	}

	public Tbasg135CargoDto createTbasg135Cargo(Tbasg135CargoDto tbasg135CargoDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg135Cargo dbTbasg135Cargo = new Tbasg135Cargo();
		BeanUtils.copyProperties(dbTbasg135Cargo, tbasg135CargoDto);
		Tbasg135Cargo _tbasg135Cargo = tbasg135CargoRepository.save(dbTbasg135Cargo);
		return toDto(_tbasg135Cargo);
	}

	public Tbasg135CargoDto updateTbasg135Cargo(String cdgoCargo, Tbasg135CargoDto tbasg135CargoDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg135Cargo> tbasg135CargoData = tbasg135CargoRepository.findById(cdgoCargo);

		if (tbasg135CargoData.isPresent()) {
			Tbasg135Cargo dbTbasg135Cargo = tbasg135CargoData.get();
			BeanUtils.copyProperties(dbTbasg135Cargo, tbasg135CargoDto);
			return toDto(tbasg135CargoRepository.save(dbTbasg135Cargo));
		}
		return null;
	}

	public int deleteTbasg135Cargo(String cdgoCargo) {

		tbasg135CargoRepository.deleteById(cdgoCargo);
		return 1;
	}

	public List<Tbasg135CargoDto> findByCdgoCargoIn(List<String> cdgoCargo) {

		List<Tbasg135Cargo> tbasg135Cargos = tbasg135CargoRepository.findByCdgoCargoIn(cdgoCargo);

		return toDtos(tbasg135Cargos);
	}
	
	
	public List<Tbasg135CargoDto> getCargoAltasCargo() {
		return toDtos(tbasg135CargoRepository.getCargoAltasCargo());
	}

	public List<Tbasg135CargoDto> getCargo(String cdgoCargo) {
		return toDtos(tbasg135CargoRepository.getCargo(cdgoCargo));
	}

	public List<Tbasg135CargoDto> getCargoListAscendente() {
		return toDtos(tbasg135CargoRepository.getCargoListAscendente());
	}

	public List<Tbasg135CargoDto> getCargoListDescendente() {
		return toDtos(tbasg135CargoRepository.getCargoListDescendente());
	}

	public List<Tbasg135CargoDto> getCargoActiveListAscendente() {
		return toDtos(tbasg135CargoRepository.getCargoActiveListAscendente());
	}

	public List<Tbasg135CargoDto> getCargoActiveListDescendente() {
		return toDtos(tbasg135CargoRepository.getCargoActiveListDescendente());
	}

	public List<Tbasg135CargoDto> getCargoCount() {
		return toDtos(tbasg135CargoRepository.getCargoCount());
	}

	public int insertCargo(Tbasg135Cargo bean) {
		return tbasg135CargoRepository.insertCargo(bean);
	}

	public int updateCargo(Tbasg135Cargo bean) {
		return tbasg135CargoRepository.updateCargo(bean);
	}
	
	public int estadoCargo(Tbasg135Cargo bean) {
		return tbasg135CargoRepository.estadoCargo(bean);
	}

	public Tbasg135CargoDto toDto(Tbasg135Cargo orig) {

		Tbasg135CargoDto dest = new Tbasg135CargoDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg135Cargo toEntity(Tbasg135CargoDto orig) {

		Tbasg135Cargo dest = new Tbasg135Cargo();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg135CargoDto> toDtos(List<Tbasg135Cargo> orig) {

		List<Tbasg135CargoDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg135Cargo> toEntities(List<Tbasg135CargoDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg135Cargo> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}

}
