package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import renfe.com.model.dto.Tbasg280MarcaGmmDto;
import renfe.com.model.entity.Tbasg280MarcaGmm;
import renfe.com.model.entity.Tbasg280MarcaGmmPK;
import renfe.com.repository.Tbasg280MarcaGmmRepository;

@Service
public class Tbasg280MarcaGmmServiceImpl implements Tbasg280MarcaGmmService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg280MarcaGmmRepository tbasg280MarcaGmmRepository;

	public List<Tbasg280MarcaGmmDto> getAllTbasg280MarcaGmm(Tbasg280MarcaGmmDto filter) {

		logger.info("getAllTbasg280MarcaGmm " + filter);
		if (filter == null) {
			return this.toDtos(tbasg280MarcaGmmRepository.findAll());
		}
		return this.toDtos(tbasg280MarcaGmmRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg280MarcaGmmDto findByDesgMatriculaFchaAct(String desgMatricula, Date fchaAct) {
		Tbasg280MarcaGmmPK pk = new Tbasg280MarcaGmmPK();
		pk.setDesgMatricula(desgMatricula);
		pk.setFchaAct(fchaAct);
		Optional<Tbasg280MarcaGmm> tbasg280MarcaGmmData = tbasg280MarcaGmmRepository.findById(pk);

		if (tbasg280MarcaGmmData.isPresent()) {
			return toDto(tbasg280MarcaGmmData.get());
		}
		return null;
	}

	public Tbasg280MarcaGmmDto createTbasg280MarcaGmm(Tbasg280MarcaGmmDto tbasg280MarcaGmmDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg280MarcaGmm dbTbasg280MarcaGmm = new Tbasg280MarcaGmm();
		BeanUtils.copyProperties(dbTbasg280MarcaGmm, tbasg280MarcaGmmDto);
		Tbasg280MarcaGmm _tbasg280MarcaGmm = tbasg280MarcaGmmRepository.save(dbTbasg280MarcaGmm);
		return toDto(_tbasg280MarcaGmm);
	}

	public Tbasg280MarcaGmmDto updateTbasg280MarcaGmm(String desgMatricula, Date fchaAct,
			Tbasg280MarcaGmmDto tbasg280MarcaGmmDto) throws IllegalAccessException, InvocationTargetException {
		Tbasg280MarcaGmmPK pk = new Tbasg280MarcaGmmPK();
		pk.setDesgMatricula(desgMatricula);
		pk.setFchaAct(fchaAct);
		Optional<Tbasg280MarcaGmm> tbasg280MarcaGmmData = tbasg280MarcaGmmRepository.findById(pk);

		if (tbasg280MarcaGmmData.isPresent()) {
			Tbasg280MarcaGmm dbTbasg280MarcaGmm = tbasg280MarcaGmmData.get();
			BeanUtils.copyProperties(dbTbasg280MarcaGmm, tbasg280MarcaGmmDto);
			return toDto(tbasg280MarcaGmmRepository.save(dbTbasg280MarcaGmm));
		}
		return null;
	}

	public int deleteTbasg280MarcaGmm(String desgMatricula, Date fchaAct) {
		Tbasg280MarcaGmmPK pk = new Tbasg280MarcaGmmPK();
		pk.setDesgMatricula(desgMatricula);
		pk.setFchaAct(fchaAct);
		tbasg280MarcaGmmRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg280MarcaGmmDto> findByDesgMatriculaFchaActIn(List<String> desgMatricula, List<Date> fchaAct) {
		List<Tbasg280MarcaGmmPK> pks = new ArrayList<>();
		for (int i = 0; i < desgMatricula.size(); i++) {
			Tbasg280MarcaGmmPK newPk = new Tbasg280MarcaGmmPK();
			newPk.setDesgMatricula(desgMatricula.get(i));
			newPk.setFchaAct(fchaAct.get(i));
			pks.add(newPk);
		}

		List<Tbasg280MarcaGmm> tbasg280MarcaGmms = tbasg280MarcaGmmRepository.findByTbasg280marcagmmpkIn(pks);

		return toDtos(tbasg280MarcaGmms);
	}

	public List<Tbasg280MarcaGmmDto> getASG280(String desgMatricula) {
		return toDtos(tbasg280MarcaGmmRepository.getASG280(desgMatricula));
	}

	public int insertFicheroASG280(Tbasg280MarcaGmm bean) {
		return tbasg280MarcaGmmRepository.insertFicheroASG280(bean);
	}

	public Tbasg280MarcaGmmDto toDto(Tbasg280MarcaGmm orig) {

		Tbasg280MarcaGmmDto dest = new Tbasg280MarcaGmmDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}finally {
			dest.setDesgMatricula(orig.getTbasg280marcagmmpk().getDesgMatricula());
			dest.setFchaAct(orig.getTbasg280marcagmmpk().getFchaAct());
		}
		return dest;
	}

	public Tbasg280MarcaGmm toEntity(Tbasg280MarcaGmmDto orig) {

		Tbasg280MarcaGmm dest = new Tbasg280MarcaGmm();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg280MarcaGmmDto> toDtos(List<Tbasg280MarcaGmm> orig) {

		List<Tbasg280MarcaGmmDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg280MarcaGmm> toEntities(List<Tbasg280MarcaGmmDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg280MarcaGmm> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
