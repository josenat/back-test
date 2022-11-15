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

import renfe.com.model.dto.Tbasg151RidDto;
import renfe.com.model.entity.Tbasg151Rid;
import renfe.com.repository.Tbasg151RidRepository;

@Service
public class Tbasg151RidServiceImpl implements Tbasg151RidService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg151RidRepository tbasg151RidRepository;

	public List<Tbasg151RidDto> getAllTbasg151Rid(Tbasg151RidDto filter) {

		logger.info("getAllTbasg151Rid " + filter);
		if (filter == null) {
			return this.toDtos(tbasg151RidRepository.findAll());
		}
		return this.toDtos(tbasg151RidRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg151RidDto findByCdgoExpedient(Integer cdgoExpedient) {

		Optional<Tbasg151Rid> tbasg151RidData = tbasg151RidRepository.findByCdgoExpedient(cdgoExpedient);

		if (tbasg151RidData.isPresent()) {
			return toDto(tbasg151RidData.get());
		}
		return null;
	}

	public Tbasg151RidDto createTbasg151Rid(Tbasg151RidDto tbasg151RidDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg151Rid dbTbasg151Rid = new Tbasg151Rid();
		BeanUtils.copyProperties(dbTbasg151Rid, tbasg151RidDto);
		Tbasg151Rid _tbasg151Rid = tbasg151RidRepository.save(dbTbasg151Rid);
		return toDto(_tbasg151Rid);
	}

	public Tbasg151RidDto updateTbasg151Rid(Integer cdgoExpedient, Tbasg151RidDto tbasg151RidDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg151Rid> tbasg151RidData = tbasg151RidRepository.findById(cdgoExpedient);

		if (tbasg151RidData.isPresent()) {
			Tbasg151Rid dbTbasg151Rid = tbasg151RidData.get();
			BeanUtils.copyProperties(dbTbasg151Rid, tbasg151RidDto);
			return toDto(tbasg151RidRepository.save(dbTbasg151Rid));
		}
		return null;
	}

	public int deleteTbasg151Rid(Integer cdgoExpedient) {

		tbasg151RidRepository.deleteById(cdgoExpedient);
		return 1;
	}

	public List<Tbasg151RidDto> findByCdgoExpedientIn(List<Integer> cdgoExpedient) {

		List<Tbasg151Rid> tbasg151Rids = tbasg151RidRepository.findByCdgoExpedientIn(cdgoExpedient);

		return toDtos(tbasg151Rids);
	}

	public List<Tbasg151RidDto> getRidList() {
		return toDtos(tbasg151RidRepository.getRidList());
	}

	public List<Tbasg151RidDto> getRidCount() {
		return toDtos(tbasg151RidRepository.getRidCount());
	}

	public List<Tbasg151RidDto> getRid(String cdgoExpedient) {
		return toDtos(tbasg151RidRepository.getRid(cdgoExpedient));
	}

	public int insertRid(String cdgoExpedient, String fchaRid, String desgUsuact) {
		return tbasg151RidRepository.insertRid(cdgoExpedient, fchaRid, desgUsuact);
	}

	public int updateRid(Tbasg151Rid bean) {
		return tbasg151RidRepository.updateRid(bean);
	}

	public Tbasg151RidDto toDto(Tbasg151Rid orig) {

		Tbasg151RidDto dest = new Tbasg151RidDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg151Rid toEntity(Tbasg151RidDto orig) {

		Tbasg151Rid dest = new Tbasg151Rid();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg151RidDto> toDtos(List<Tbasg151Rid> orig) {

		List<Tbasg151RidDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg151Rid> toEntities(List<Tbasg151RidDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg151Rid> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
