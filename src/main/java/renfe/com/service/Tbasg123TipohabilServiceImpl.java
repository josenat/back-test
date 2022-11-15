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

import renfe.com.model.dto.Tbasg123TipohabilDto;
import renfe.com.model.entity.Tbasg123Tipohabil;
import renfe.com.repository.Tbasg123TipohabilRepository;

@Service
public class Tbasg123TipohabilServiceImpl implements Tbasg123TipohabilService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg123TipohabilRepository tbasg123TipohabilRepository;

	public List<Tbasg123TipohabilDto> getAllTbasg123Tipohabil(Tbasg123TipohabilDto filter) {

		logger.info("getAllTbasg123Tipohabil " + filter);
		if (filter == null) {
			return this.toDtos(tbasg123TipohabilRepository.findAll());
		}
		return this.toDtos(tbasg123TipohabilRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg123TipohabilDto findByCdgoTipohab(Integer cdgoTipohab) {

		Optional<Tbasg123Tipohabil> tbasg123TipohabilData = tbasg123TipohabilRepository.findByCdgoTipohab(cdgoTipohab);

		if (tbasg123TipohabilData.isPresent()) {
			return toDto(tbasg123TipohabilData.get());
		}
		return null;
	}

	public Tbasg123TipohabilDto createTbasg123Tipohabil(Tbasg123TipohabilDto tbasg123TipohabilDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg123Tipohabil dbTbasg123Tipohabil = new Tbasg123Tipohabil();
		BeanUtils.copyProperties(dbTbasg123Tipohabil, tbasg123TipohabilDto);
		Tbasg123Tipohabil _tbasg123Tipohabil = tbasg123TipohabilRepository.save(dbTbasg123Tipohabil);
		return toDto(_tbasg123Tipohabil);
	}

	public Tbasg123TipohabilDto updateTbasg123Tipohabil(Integer cdgoTipohab, Tbasg123TipohabilDto tbasg123TipohabilDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg123Tipohabil> tbasg123TipohabilData = tbasg123TipohabilRepository.findById(cdgoTipohab);

		if (tbasg123TipohabilData.isPresent()) {
			Tbasg123Tipohabil dbTbasg123Tipohabil = tbasg123TipohabilData.get();
			BeanUtils.copyProperties(dbTbasg123Tipohabil, tbasg123TipohabilDto);
			return toDto(tbasg123TipohabilRepository.save(dbTbasg123Tipohabil));
		}
		return null;
	}

	public int deleteTbasg123Tipohabil(Integer cdgoTipohab) {

		tbasg123TipohabilRepository.deleteById(cdgoTipohab);
		return 1;
	}

	public List<Tbasg123TipohabilDto> findByCdgoTipohabIn(List<Integer> cdgoTipohab) {

		List<Tbasg123Tipohabil> tbasg123Tipohabils = tbasg123TipohabilRepository.findByCdgoTipohabIn(cdgoTipohab);

		return toDtos(tbasg123Tipohabils);
	}

	public List<Tbasg123TipohabilDto> getTipoHabilList() {
		return toDtos(tbasg123TipohabilRepository.getTipoHabilList());
	}

	public List<Tbasg123TipohabilDto> getTipoHabilListCombo() {
		return toDtos(tbasg123TipohabilRepository.getTipoHabilListCombo());
	}

	public List<Tbasg123TipohabilDto> getTipoHabil(String cdgoTipohab) {
		return toDtos(tbasg123TipohabilRepository.getTipoHabil(cdgoTipohab));
	}

	public Tbasg123TipohabilDto toDto(Tbasg123Tipohabil orig) {

		Tbasg123TipohabilDto dest = new Tbasg123TipohabilDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg123Tipohabil toEntity(Tbasg123TipohabilDto orig) {

		Tbasg123Tipohabil dest = new Tbasg123Tipohabil();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg123TipohabilDto> toDtos(List<Tbasg123Tipohabil> orig) {

		List<Tbasg123TipohabilDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg123Tipohabil> toEntities(List<Tbasg123TipohabilDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg123Tipohabil> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}

