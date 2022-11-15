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

import renfe.com.model.dto.Tbasg180RelHabPsicDto;
import renfe.com.model.entity.Tbasg180RelHabPsic;
import renfe.com.model.entity.Tbasg180RelHabPsicPK;
import renfe.com.repository.Tbasg180RelHabPsicRepository;

@Service
public class Tbasg180RelHabPsicServiceImpl implements Tbasg180RelHabPsicService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg180RelHabPsicRepository tbasg180RelHabPsicRepository;

	public List<Tbasg180RelHabPsicDto> getAllTbasg180RelHabPsic(Tbasg180RelHabPsicDto filter) {

		logger.info("getAllTbasg180RelHabPsic " + filter);
		if (filter == null) {
			return this.toDtos(tbasg180RelHabPsicRepository.findAll());
		}
		return this.toDtos(tbasg180RelHabPsicRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg180RelHabPsicDto findByCdgoPsicambCdgoTipohab(Integer cdgoPsicamb, Integer cdgoTipohab) {
		Tbasg180RelHabPsicPK pk = new Tbasg180RelHabPsicPK();
		pk.setCdgoPsicamb(cdgoPsicamb);
		pk.setCdgoTipohab(cdgoTipohab);
		Optional<Tbasg180RelHabPsic> tbasg180RelHabPsicData = tbasg180RelHabPsicRepository.findById(pk);

		if (tbasg180RelHabPsicData.isPresent()) {
			return toDto(tbasg180RelHabPsicData.get());
		}
		return null;
	}

	public Tbasg180RelHabPsicDto createTbasg180RelHabPsic(Tbasg180RelHabPsicDto tbasg180RelHabPsicDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg180RelHabPsic dbTbasg180RelHabPsic = new Tbasg180RelHabPsic();
		BeanUtils.copyProperties(dbTbasg180RelHabPsic, tbasg180RelHabPsicDto);
		Tbasg180RelHabPsic _tbasg180RelHabPsic = tbasg180RelHabPsicRepository.save(dbTbasg180RelHabPsic);
		return toDto(_tbasg180RelHabPsic);
	}

	public Tbasg180RelHabPsicDto updateTbasg180RelHabPsic(Integer cdgoPsicamb, Integer cdgoTipohab,
			Tbasg180RelHabPsicDto tbasg180RelHabPsicDto) throws IllegalAccessException, InvocationTargetException {
		Tbasg180RelHabPsicPK pk = new Tbasg180RelHabPsicPK();
		pk.setCdgoPsicamb(cdgoPsicamb);
		pk.setCdgoTipohab(cdgoTipohab);
		Optional<Tbasg180RelHabPsic> tbasg180RelHabPsicData = tbasg180RelHabPsicRepository.findById(pk);

		if (tbasg180RelHabPsicData.isPresent()) {
			Tbasg180RelHabPsic dbTbasg180RelHabPsic = tbasg180RelHabPsicData.get();
			BeanUtils.copyProperties(dbTbasg180RelHabPsic, tbasg180RelHabPsicDto);
			return toDto(tbasg180RelHabPsicRepository.save(dbTbasg180RelHabPsic));
		}
		return null;
	}

	public int deleteTbasg180RelHabPsic(Integer cdgoPsicamb, Integer cdgoTipohab) {
		Tbasg180RelHabPsicPK pk = new Tbasg180RelHabPsicPK();
		pk.setCdgoPsicamb(cdgoPsicamb);
		pk.setCdgoTipohab(cdgoTipohab);
		tbasg180RelHabPsicRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg180RelHabPsicDto> findByCdgoPsicambCdgoTipohabIn(List<Integer> cdgoPsicamb,
			List<Integer> cdgoTipohab) {
		List<Tbasg180RelHabPsicPK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoPsicamb.size(); i++) {
			Tbasg180RelHabPsicPK newPk = new Tbasg180RelHabPsicPK();
			newPk.setCdgoPsicamb(cdgoPsicamb.get(i));
			newPk.setCdgoTipohab(cdgoTipohab.get(i));
			pks.add(newPk);
		}
		List<Tbasg180RelHabPsic> tbasg180RelHabPsics = tbasg180RelHabPsicRepository.findByTbasg180relhabpsicpkIn(pks);

		return toDtos(tbasg180RelHabPsics);
	}

	public List<Tbasg180RelHabPsicDto> getRelHabPsic() {
		return toDtos(tbasg180RelHabPsicRepository.getRelHabPsic());
	}

	public Tbasg180RelHabPsicDto toDto(Tbasg180RelHabPsic orig) {

		Tbasg180RelHabPsicDto dest = new Tbasg180RelHabPsicDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			if(dest!=null && orig != null) {
				dest.setCdgoPsicamb(orig.getTbasg180relhabpsicpk().getCdgoPsicamb());
				dest.setCdgoTipohab(orig.getTbasg180relhabpsicpk().getCdgoTipohab());
			}
		}
		return dest;
	}

	public Tbasg180RelHabPsic toEntity(Tbasg180RelHabPsicDto orig) {

		Tbasg180RelHabPsic dest = new Tbasg180RelHabPsic();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg180RelHabPsicDto> toDtos(List<Tbasg180RelHabPsic> orig) {

		List<Tbasg180RelHabPsicDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg180RelHabPsic> toEntities(List<Tbasg180RelHabPsicDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg180RelHabPsic> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
