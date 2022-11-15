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

import renfe.com.model.dto.Tbasg137EspecialiDto;
import renfe.com.model.entity.Tbasg137Especiali;
import renfe.com.repository.Tbasg137EspecialiRepository;

@Transactional
@Service
public class Tbasg137EspecialiServiceImpl implements Tbasg137EspecialiService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg137EspecialiRepository tbasg137EspecialiRepository;

	public List<Tbasg137EspecialiDto> getAllTbasg137Especiali(Tbasg137EspecialiDto filter) {

		logger.info("getAllTbasg137Especiali " + filter);
		if (filter == null) {
			return this.toDtos(tbasg137EspecialiRepository.findAll());
		}
		return this.toDtos(tbasg137EspecialiRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg137EspecialiDto findByCdgoEspec(Integer cdgoEspec) {

		Optional<Tbasg137Especiali> tbasg137EspecialiData = tbasg137EspecialiRepository.findByCdgoEspec(cdgoEspec);

		if (tbasg137EspecialiData.isPresent()) {
			return toDto(tbasg137EspecialiData.get());
		}
		return null;
	}

	public Tbasg137EspecialiDto createTbasg137Especiali(Tbasg137EspecialiDto tbasg137EspecialiDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg137Especiali dbTbasg137Especiali = new Tbasg137Especiali();
		BeanUtils.copyProperties(dbTbasg137Especiali, tbasg137EspecialiDto);
		Tbasg137Especiali _tbasg137Especiali = tbasg137EspecialiRepository.save(dbTbasg137Especiali);
		return toDto(_tbasg137Especiali);
	}

	public Tbasg137EspecialiDto updateTbasg137Especiali(Integer cdgoEspec, Tbasg137EspecialiDto tbasg137EspecialiDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg137Especiali> tbasg137EspecialiData = tbasg137EspecialiRepository.findById(cdgoEspec);

		if (tbasg137EspecialiData.isPresent()) {
			Tbasg137Especiali dbTbasg137Especiali = tbasg137EspecialiData.get();
			BeanUtils.copyProperties(dbTbasg137Especiali, tbasg137EspecialiDto);
			return toDto(tbasg137EspecialiRepository.save(dbTbasg137Especiali));
		}
		return null;
	}

	public int deleteTbasg137Especiali(Integer cdgoEspec) {

		tbasg137EspecialiRepository.deleteById(cdgoEspec);
		return 1;
	}

	public List<Tbasg137EspecialiDto> findByCdgoEspecIn(List<Integer> cdgoEspec) {

		List<Tbasg137Especiali> tbasg137Especialis = tbasg137EspecialiRepository.findByCdgoEspecIn(cdgoEspec);

		return toDtos(tbasg137Especialis);
	}

	public List<Tbasg137EspecialiDto> getEspecialiCount() {
		return toDtos(tbasg137EspecialiRepository.getEspecialiCount());
	}

	public List<Tbasg137EspecialiDto> getEspecialiListAscendente() {
		return toDtos(tbasg137EspecialiRepository.getEspecialiListAscendente());
	}
	
	public List<Tbasg137EspecialiDto> getEspecialiList() {
		return toDtos(tbasg137EspecialiRepository.getEspecialiList());
	}

	public List<Tbasg137EspecialiDto> getEspecialiListDescendente() {
		return toDtos(tbasg137EspecialiRepository.getEspecialiListDescendente());
	}

	public List<Tbasg137EspecialiDto> getEspeciali(Integer cdgoEspec) {
		return toDtos(tbasg137EspecialiRepository.getEspeciali(cdgoEspec));
	}
	
	public List<Tbasg137EspecialiDto> getEspecialiNombre(String cdgoEspec) {
		return toDtos(tbasg137EspecialiRepository.getEspecialiNombre(cdgoEspec));
	}

	public List<Tbasg137EspecialiDto> getAlcanceEspeciali(Integer cdgoEspec) {
		return toDtos(tbasg137EspecialiRepository.getAlcanceEspeciali(cdgoEspec));
	}

	public List<Tbasg137EspecialiDto> getEspecialiActiveList() {
		return toDtos(tbasg137EspecialiRepository.getEspecialiActiveList());
	}

	public int insertEspeciali(Tbasg137Especiali bean) {
		return tbasg137EspecialiRepository.insertEspeciali(bean);
	}

	public int updateEspeciali(Tbasg137Especiali bean) {
		return tbasg137EspecialiRepository.updateEspeciali(bean);
	}
	
	public int estadoEspeciali(Tbasg137Especiali bean) {
		return tbasg137EspecialiRepository.estadoEspeciali(bean);
	}

	public Tbasg137EspecialiDto toDto(Tbasg137Especiali orig) {

		Tbasg137EspecialiDto dest = new Tbasg137EspecialiDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg137Especiali toEntity(Tbasg137EspecialiDto orig) {

		Tbasg137Especiali dest = new Tbasg137Especiali();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg137EspecialiDto> toDtos(List<Tbasg137Especiali> orig) {

		List<Tbasg137EspecialiDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg137Especiali> toEntities(List<Tbasg137EspecialiDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg137Especiali> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}

