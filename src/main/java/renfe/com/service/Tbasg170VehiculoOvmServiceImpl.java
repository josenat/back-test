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

import renfe.com.model.dto.Tbasg170VehiculoOvmDto;
import renfe.com.model.entity.Tbasg170VehiculoOvm;
import renfe.com.repository.Tbasg170VehiculoOvmRepository;

@Transactional
@Service
public class Tbasg170VehiculoOvmServiceImpl implements Tbasg170VehiculoOvmService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg170VehiculoOvmRepository tbasg170VehiculoOvmRepository;

	public List<Tbasg170VehiculoOvmDto> getAllTbasg170VehiculoOvm(Tbasg170VehiculoOvmDto filter) {

		logger.info("getAllTbasg170VehiculoOvm " + filter);
		if (filter == null) {
			return this.toDtos(tbasg170VehiculoOvmRepository.findAll());
		}
		return this.toDtos(tbasg170VehiculoOvmRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg170VehiculoOvmDto findByCdgoVehiculo(Integer cdgoVehiculo) {

		Optional<Tbasg170VehiculoOvm> tbasg170VehiculoOvmData = tbasg170VehiculoOvmRepository
				.findByCdgoVehiculo(cdgoVehiculo);

		if (tbasg170VehiculoOvmData.isPresent()) {
			return toDto(tbasg170VehiculoOvmData.get());
		}
		return null;
	}

	public Tbasg170VehiculoOvmDto createTbasg170VehiculoOvm(Tbasg170VehiculoOvmDto tbasg170VehiculoOvmDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg170VehiculoOvm dbTbasg170VehiculoOvm = new Tbasg170VehiculoOvm();
		BeanUtils.copyProperties(dbTbasg170VehiculoOvm, tbasg170VehiculoOvmDto);
		Tbasg170VehiculoOvm _tbasg170VehiculoOvm = tbasg170VehiculoOvmRepository.save(dbTbasg170VehiculoOvm);
		return toDto(_tbasg170VehiculoOvm);
	}

	public Tbasg170VehiculoOvmDto updateTbasg170VehiculoOvm(Integer cdgoVehiculo,
			Tbasg170VehiculoOvmDto tbasg170VehiculoOvmDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg170VehiculoOvm> tbasg170VehiculoOvmData = tbasg170VehiculoOvmRepository.findById(cdgoVehiculo);

		if (tbasg170VehiculoOvmData.isPresent()) {
			Tbasg170VehiculoOvm dbTbasg170VehiculoOvm = tbasg170VehiculoOvmData.get();
			BeanUtils.copyProperties(dbTbasg170VehiculoOvm, tbasg170VehiculoOvmDto);
			return toDto(tbasg170VehiculoOvmRepository.save(dbTbasg170VehiculoOvm));
		}
		return null;
	}

	public int deleteTbasg170VehiculoOvm(Integer cdgoVehiculo) {

		tbasg170VehiculoOvmRepository.deleteById(cdgoVehiculo);
		return 1;
	}

	public List<Tbasg170VehiculoOvmDto> findByCdgoVehiculoIn(List<Integer> cdgoVehiculo) {

		List<Tbasg170VehiculoOvm> tbasg170VehiculoOvms = tbasg170VehiculoOvmRepository
				.findByCdgoVehiculoIn(cdgoVehiculo);

		return toDtos(tbasg170VehiculoOvms);
	}

	public List<Tbasg170VehiculoOvmDto> getVehiculoOVMListAscendente() {
		return toDtos(tbasg170VehiculoOvmRepository.getVehiculoOVMListAscendente());
	}

	public List<Tbasg170VehiculoOvmDto> getVehiculoOVMListDescendente() {
		return toDtos(tbasg170VehiculoOvmRepository.getVehiculoOVMListDescendente());
	}

	public List<Tbasg170VehiculoOvmDto> getVehiculoOVMCount() {
		return toDtos(tbasg170VehiculoOvmRepository.getVehiculoOVMCount());
	}

	public List<Tbasg170VehiculoOvmDto> getVehiculoOVM(String cdgoVehiculo) {
		return toDtos(tbasg170VehiculoOvmRepository.getVehiculoOVM(cdgoVehiculo));
	}

	public List<Tbasg170VehiculoOvmDto> getVehiculoOVMListActive() {
		return toDtos(tbasg170VehiculoOvmRepository.getVehiculoOVMListActive());
	}

	public int insertVehiculoOVM(Tbasg170VehiculoOvm bean) {
		return tbasg170VehiculoOvmRepository.insertVehiculoOVM(bean);
	}

	public int updateVehiculoOVM(Tbasg170VehiculoOvm bean) {
		return tbasg170VehiculoOvmRepository.updateVehiculoOVM(bean);
	}
	
	public int estadoVehiculoOVM(Tbasg170VehiculoOvm bean) {
		return tbasg170VehiculoOvmRepository.estadoVehiculoOVM(bean);
	}

	public Tbasg170VehiculoOvmDto toDto(Tbasg170VehiculoOvm orig) {

		Tbasg170VehiculoOvmDto dest = new Tbasg170VehiculoOvmDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg170VehiculoOvm toEntity(Tbasg170VehiculoOvmDto orig) {

		Tbasg170VehiculoOvm dest = new Tbasg170VehiculoOvm();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg170VehiculoOvmDto> toDtos(List<Tbasg170VehiculoOvm> orig) {

		List<Tbasg170VehiculoOvmDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg170VehiculoOvm> toEntities(List<Tbasg170VehiculoOvmDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg170VehiculoOvm> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}

