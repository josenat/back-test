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

import renfe.com.model.dto.Tbasg173DatoPlantDocDto;
import renfe.com.model.entity.Tbasg173DatoPlantDoc;
import renfe.com.model.entity.Tbasg173DatoPlantDocPK;
import renfe.com.repository.Tbasg173DatoPlantDocRepository;

@Service
public class Tbasg173DatoPlantDocServiceImpl implements Tbasg173DatoPlantDocService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg173DatoPlantDocRepository tbasg173DatoPlantDocRepository;

	public List<Tbasg173DatoPlantDocDto> getAllTbasg173DatoPlantDoc(Tbasg173DatoPlantDocDto filter) {

		logger.info("getAllTbasg173DatoPlantDoc " + filter);
		if (filter == null) {
			return this.toDtos(tbasg173DatoPlantDocRepository.findAll());
		}
		return this.toDtos(tbasg173DatoPlantDocRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg173DatoPlantDocDto findByCdgoClaveCdgoDocumento(String cdgoClave, Integer cdgoDocumento) {
		Tbasg173DatoPlantDocPK pk = new Tbasg173DatoPlantDocPK();
		pk.setCdgoClave(cdgoClave);
		pk.setCdgoDocumento(cdgoDocumento);
		Optional<Tbasg173DatoPlantDoc> tbasg173DatoPlantDocData = tbasg173DatoPlantDocRepository.findById(pk);

		if (tbasg173DatoPlantDocData.isPresent()) {
			return toDto(tbasg173DatoPlantDocData.get());
		}
		return null;
	}

	public Tbasg173DatoPlantDocDto createTbasg173DatoPlantDoc(Tbasg173DatoPlantDocDto tbasg173DatoPlantDocDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg173DatoPlantDoc dbTbasg173DatoPlantDoc = new Tbasg173DatoPlantDoc();
		BeanUtils.copyProperties(dbTbasg173DatoPlantDoc, tbasg173DatoPlantDocDto);
		Tbasg173DatoPlantDoc _tbasg173DatoPlantDoc = tbasg173DatoPlantDocRepository.save(dbTbasg173DatoPlantDoc);
		return toDto(_tbasg173DatoPlantDoc);
	}

	public Tbasg173DatoPlantDocDto updateTbasg173DatoPlantDoc(String cdgoClave, Integer cdgoDocumento,
			Tbasg173DatoPlantDocDto tbasg173DatoPlantDocDto) throws IllegalAccessException, InvocationTargetException {
		Tbasg173DatoPlantDocPK pk = new Tbasg173DatoPlantDocPK();
		pk.setCdgoClave(cdgoClave);
		pk.setCdgoDocumento(cdgoDocumento);
		Optional<Tbasg173DatoPlantDoc> tbasg173DatoPlantDocData = tbasg173DatoPlantDocRepository.findById(pk);

		if (tbasg173DatoPlantDocData.isPresent()) {
			Tbasg173DatoPlantDoc dbTbasg173DatoPlantDoc = tbasg173DatoPlantDocData.get();
			BeanUtils.copyProperties(dbTbasg173DatoPlantDoc, tbasg173DatoPlantDocDto);
			return toDto(tbasg173DatoPlantDocRepository.save(dbTbasg173DatoPlantDoc));
		}
		return null;
	}

	public int deleteTbasg173DatoPlantDoc(String cdgoClave, Integer cdgoDocumento) {
		Tbasg173DatoPlantDocPK pk = new Tbasg173DatoPlantDocPK();
		pk.setCdgoClave(cdgoClave);
		pk.setCdgoDocumento(cdgoDocumento);
		tbasg173DatoPlantDocRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg173DatoPlantDocDto> findByCdgoClaveCdgoDocumentoIn(List<String> cdgoClave,
			List<Integer> cdgoDocumento) {
		List<Tbasg173DatoPlantDocPK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoClave.size(); i++) {
			Tbasg173DatoPlantDocPK newPk = new Tbasg173DatoPlantDocPK();
			newPk.setCdgoClave(cdgoClave.get(i));
			newPk.setCdgoDocumento(cdgoDocumento.get(i));
			pks.add(newPk);
		}
		List<Tbasg173DatoPlantDoc> tbasg173DatoPlantDocs = tbasg173DatoPlantDocRepository
				.findByTbasg173datoplantdocpkIn(pks);

		return toDtos(tbasg173DatoPlantDocs);
	}

	public List<Tbasg173DatoPlantDocDto> getDatoPlantDocActiveList(String cdgoDocumento) {
		return toDtos(tbasg173DatoPlantDocRepository.getDatoPlantDocActiveList(cdgoDocumento));
	}

	public Tbasg173DatoPlantDocDto toDto(Tbasg173DatoPlantDoc orig) {

		Tbasg173DatoPlantDocDto dest = new Tbasg173DatoPlantDocDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg173DatoPlantDoc toEntity(Tbasg173DatoPlantDocDto orig) {

		Tbasg173DatoPlantDoc dest = new Tbasg173DatoPlantDoc();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg173DatoPlantDocDto> toDtos(List<Tbasg173DatoPlantDoc> orig) {

		List<Tbasg173DatoPlantDocDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg173DatoPlantDoc> toEntities(List<Tbasg173DatoPlantDocDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg173DatoPlantDoc> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
