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

import renfe.com.model.dto.Tbasg140TidepenciDto;
import renfe.com.model.entity.Tbasg140Tidepenci;
import renfe.com.repository.Tbasg140TidepenciRepository;

@Service
public class Tbasg140TidepenciServiceImpl implements Tbasg140TidepenciService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg140TidepenciRepository tbasg140TidepenciRepository;

	public List<Tbasg140TidepenciDto> getAllTbasg140Tidepenci(Tbasg140TidepenciDto filter) {

		logger.info("getAllTbasg140Tidepenci " + filter);
		if (filter == null) {
			return this.toDtos(tbasg140TidepenciRepository.findAll());
		}
		return this.toDtos(tbasg140TidepenciRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg140TidepenciDto findByCdgoTipodep(Integer cdgoTipodep) {

		Optional<Tbasg140Tidepenci> tbasg140TidepenciData = tbasg140TidepenciRepository.findByCdgoTipodep(cdgoTipodep);

		if (tbasg140TidepenciData.isPresent()) {
			return toDto(tbasg140TidepenciData.get());
		}
		return null;
	}

	public Tbasg140TidepenciDto createTbasg140Tidepenci(Tbasg140TidepenciDto tbasg140TidepenciDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg140Tidepenci dbTbasg140Tidepenci = new Tbasg140Tidepenci();
		BeanUtils.copyProperties(dbTbasg140Tidepenci, tbasg140TidepenciDto);
		Tbasg140Tidepenci _tbasg140Tidepenci = tbasg140TidepenciRepository.save(dbTbasg140Tidepenci);
		return toDto(_tbasg140Tidepenci);
	}

	public Tbasg140TidepenciDto updateTbasg140Tidepenci(Integer cdgoTipodep, Tbasg140TidepenciDto tbasg140TidepenciDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg140Tidepenci> tbasg140TidepenciData = tbasg140TidepenciRepository.findById(cdgoTipodep);

		if (tbasg140TidepenciData.isPresent()) {
			Tbasg140Tidepenci dbTbasg140Tidepenci = tbasg140TidepenciData.get();
			BeanUtils.copyProperties(dbTbasg140Tidepenci, tbasg140TidepenciDto);
			return toDto(tbasg140TidepenciRepository.save(dbTbasg140Tidepenci));
		}
		return null;
	}

	public int deleteTbasg140Tidepenci(Integer cdgoTipodep) {

		tbasg140TidepenciRepository.deleteById(cdgoTipodep);
		return 1;
	}

	public List<Tbasg140TidepenciDto> findByCdgoTipodepIn(List<Integer> cdgoTipodep) {

		List<Tbasg140Tidepenci> tbasg140Tidepencis = tbasg140TidepenciRepository.findByCdgoTipodepIn(cdgoTipodep);

		return toDtos(tbasg140Tidepencis);
	}

	public List<Tbasg140TidepenciDto> getTiDepenciCount() {
		return toDtos(tbasg140TidepenciRepository.getTiDepenciCount());
	}

	public List<Tbasg140TidepenciDto> getTiDepenciListAscendente() {
		return toDtos(tbasg140TidepenciRepository.getTiDepenciListAscendente());
	}

	public List<Tbasg140TidepenciDto> getTiDepenciListDescendente() {
		return toDtos(tbasg140TidepenciRepository.getTiDepenciListDescendente());
	}

	public List<Tbasg140TidepenciDto> getTiDepenciListActiveAscendente() {
		return toDtos(tbasg140TidepenciRepository.getTiDepenciListActiveAscendente());
	}

	public List<Tbasg140TidepenciDto> getTiDepenciListActiveDescendente() {
		return toDtos(tbasg140TidepenciRepository.getTiDepenciListActiveDescendente());
	}

	public List<Tbasg140TidepenciDto> getTiDepenci(String cdgoTipodep) {
		return toDtos(tbasg140TidepenciRepository.getTiDepenci(cdgoTipodep));
	}

	public int insertTiDepenci(Tbasg140Tidepenci bean) {
		return tbasg140TidepenciRepository.insertTiDepenci(bean);
	}

	public int updateTiDepenci(Tbasg140Tidepenci bean) {
		return tbasg140TidepenciRepository.updateTiDepenci(bean);
	}

	public int deleteTiDepenci(Tbasg140Tidepenci bean) {
		return tbasg140TidepenciRepository.deleteTiDepenci(bean);
	}

	public Tbasg140TidepenciDto toDto(Tbasg140Tidepenci orig) {

		Tbasg140TidepenciDto dest = new Tbasg140TidepenciDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg140Tidepenci toEntity(Tbasg140TidepenciDto orig) {

		Tbasg140Tidepenci dest = new Tbasg140Tidepenci();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg140TidepenciDto> toDtos(List<Tbasg140Tidepenci> orig) {

		List<Tbasg140TidepenciDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg140Tidepenci> toEntities(List<Tbasg140TidepenciDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg140Tidepenci> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
