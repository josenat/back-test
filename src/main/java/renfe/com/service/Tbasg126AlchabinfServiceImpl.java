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

import renfe.com.model.dto.Tbasg126AlchabinfDto;
import renfe.com.model.entity.Tbasg126Alchabinf;
import renfe.com.repository.Tbasg126AlchabinfRepository;

@Transactional
@Service
public class Tbasg126AlchabinfServiceImpl implements Tbasg126AlchabinfService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg126AlchabinfRepository tbasg126AlchabinfRepository;

	public List<Tbasg126AlchabinfDto> getAllTbasg126Alchabinf(Tbasg126AlchabinfDto filter) {

		logger.info("getAllTbasg126Alchabinf " + filter);
		if (filter == null) {
			return this.toDtos(tbasg126AlchabinfRepository.findAll());
		}
		return this.toDtos(tbasg126AlchabinfRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg126AlchabinfDto findByCdgoAlchabinf(Integer cdgoAlchabinf) {

		Optional<Tbasg126Alchabinf> tbasg126AlchabinfData = tbasg126AlchabinfRepository
				.findByCdgoAlchabinf(cdgoAlchabinf);

		if (tbasg126AlchabinfData.isPresent()) {
			return toDto(tbasg126AlchabinfData.get());
		}
		return null;
	}

	public Tbasg126AlchabinfDto createTbasg126Alchabinf(Tbasg126AlchabinfDto tbasg126AlchabinfDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg126Alchabinf dbTbasg126Alchabinf = new Tbasg126Alchabinf();
		BeanUtils.copyProperties(dbTbasg126Alchabinf, tbasg126AlchabinfDto);
		Tbasg126Alchabinf _tbasg126Alchabinf = tbasg126AlchabinfRepository.save(dbTbasg126Alchabinf);
		return toDto(_tbasg126Alchabinf);
	}

	public Tbasg126AlchabinfDto updateTbasg126Alchabinf(Integer cdgoAlchabinf,
			Tbasg126AlchabinfDto tbasg126AlchabinfDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg126Alchabinf> tbasg126AlchabinfData = tbasg126AlchabinfRepository.findById(cdgoAlchabinf);

		if (tbasg126AlchabinfData.isPresent()) {
			Tbasg126Alchabinf dbTbasg126Alchabinf = tbasg126AlchabinfData.get();
			BeanUtils.copyProperties(dbTbasg126Alchabinf, tbasg126AlchabinfDto);
			return toDto(tbasg126AlchabinfRepository.save(dbTbasg126Alchabinf));
		}
		return null;
	}

	public int deleteTbasg126Alchabinf(Integer cdgoAlchabinf) {

		tbasg126AlchabinfRepository.deleteById(cdgoAlchabinf);
		return 1;
	}

	public List<Tbasg126AlchabinfDto> findByCdgoAlchabinfIn(List<Integer> cdgoAlchabinf) {

		List<Tbasg126Alchabinf> tbasg126Alchabinfs = tbasg126AlchabinfRepository.findByCdgoAlchabinfIn(cdgoAlchabinf);

		return toDtos(tbasg126Alchabinfs);
	}

	public List<Tbasg126AlchabinfDto> findAlcHabInfByCdgoExp(Integer cdgoExpedient) {
		return toDtos(tbasg126AlchabinfRepository.findAlcHabInfByCdgoExp(cdgoExpedient));
	}

	public List<Tbasg126AlchabinfDto> getAlcHabInf(String cdgoAlchabinf) {
		return toDtos(tbasg126AlchabinfRepository.getAlcHabInf(cdgoAlchabinf));
	}

	public int insertAlcHabInf(Tbasg126AlchabinfDto bean) {
		return tbasg126AlchabinfRepository.insertAlcHabInf(bean);
	}

	public int deleteAlcHabInfByCdgoExp(Tbasg126Alchabinf bean) {
		return tbasg126AlchabinfRepository.deleteAlcHabInfByCdgoExp(bean);
	}

	public int deleteAlcHabInf(Tbasg126Alchabinf bean) {
		return tbasg126AlchabinfRepository.deleteAlcHabInf(bean);
	}

	public List<Tbasg126AlchabinfDto> getPreviousEstaHabInList(String cdgoAlchabinf) {
		return toDtos(tbasg126AlchabinfRepository.getPreviousEstaHabInList(cdgoAlchabinf));
	}

	public List<Tbasg126AlchabinfDto> getMaxEntornosExpList(String cdgoExpedient) {
		return toDtos(tbasg126AlchabinfRepository.getMaxEntornosExpList(cdgoExpedient));
	}

	public List<Tbasg126AlchabinfDto> getMaxEntornosExpListDesc(String cdgoExpedient) {
		return toDtos(tbasg126AlchabinfRepository.getMaxEntornosExpListDesc(cdgoExpedient));
	}

	public List<Tbasg126AlchabinfDto> findTramoByCodExpediente(String cdgoExpedient) {
		return toDtos(tbasg126AlchabinfRepository.findTramoByCodExpediente(cdgoExpedient));
	}

	public Tbasg126AlchabinfDto toDto(Tbasg126Alchabinf orig) {

		Tbasg126AlchabinfDto dest = new Tbasg126AlchabinfDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg126Alchabinf toEntity(Tbasg126AlchabinfDto orig) {

		Tbasg126Alchabinf dest = new Tbasg126Alchabinf();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg126AlchabinfDto> toDtos(List<Tbasg126Alchabinf> orig) {

		List<Tbasg126AlchabinfDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg126Alchabinf> toEntities(List<Tbasg126AlchabinfDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg126Alchabinf> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
