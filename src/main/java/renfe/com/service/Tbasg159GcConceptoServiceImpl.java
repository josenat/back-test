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

import renfe.com.model.dto.Tbasg159GcConceptoDto;
import renfe.com.model.entity.Tbasg159GcConcepto;
import renfe.com.model.entity.Tbasg159GcConceptoPK;
import renfe.com.repository.Tbasg159GcConceptoRepository;

@Service
public class Tbasg159GcConceptoServiceImpl implements Tbasg159GcConceptoService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg159GcConceptoRepository tbasg159GcConceptoRepository;

	public List<Tbasg159GcConceptoDto> getAllTbasg159GcConcepto(Tbasg159GcConceptoDto filter) {

		logger.info("getAllTbasg159GcConcepto " + filter);
		if (filter == null) {
			return this.toDtos(tbasg159GcConceptoRepository.findAll());
		}
		return this.toDtos(tbasg159GcConceptoRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg159GcConceptoDto findByCdgoCategoriaCdgoConcepto(String cdgoCategoria, String cdgoConcepto) {
		Tbasg159GcConceptoPK pk = new Tbasg159GcConceptoPK();
		pk.setCdgoCategoria(cdgoCategoria);
		pk.setCdgoConcepto(cdgoConcepto);
		Optional<Tbasg159GcConcepto> tbasg159GcConceptoData = tbasg159GcConceptoRepository.findById(pk);

		if (tbasg159GcConceptoData.isPresent()) {
			return toDto(tbasg159GcConceptoData.get());
		}
		return null;
	}

	public Tbasg159GcConceptoDto createTbasg159GcConcepto(Tbasg159GcConceptoDto tbasg159GcConceptoDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg159GcConcepto dbTbasg159GcConcepto = new Tbasg159GcConcepto();
		BeanUtils.copyProperties(dbTbasg159GcConcepto, tbasg159GcConceptoDto);
		Tbasg159GcConcepto _tbasg159GcConcepto = tbasg159GcConceptoRepository.save(dbTbasg159GcConcepto);
		return toDto(_tbasg159GcConcepto);
	}

	public Tbasg159GcConceptoDto updateTbasg159GcConcepto(String cdgoCategoria, String cdgoConcepto,
			Tbasg159GcConceptoDto tbasg159GcConceptoDto) throws IllegalAccessException, InvocationTargetException {
		Tbasg159GcConceptoPK pk = new Tbasg159GcConceptoPK();
		pk.setCdgoCategoria(cdgoCategoria);
		pk.setCdgoConcepto(cdgoConcepto);
		Optional<Tbasg159GcConcepto> tbasg159GcConceptoData = tbasg159GcConceptoRepository.findById(pk);

		if (tbasg159GcConceptoData.isPresent()) {
			Tbasg159GcConcepto dbTbasg159GcConcepto = tbasg159GcConceptoData.get();
			BeanUtils.copyProperties(dbTbasg159GcConcepto, tbasg159GcConceptoDto);
			return toDto(tbasg159GcConceptoRepository.save(dbTbasg159GcConcepto));
		}
		return null;
	}

	public int deleteTbasg159GcConcepto(String cdgoCategoria, String cdgoConcepto) {
		Tbasg159GcConceptoPK pk = new Tbasg159GcConceptoPK();
		pk.setCdgoCategoria(cdgoCategoria);
		pk.setCdgoConcepto(cdgoConcepto);
		tbasg159GcConceptoRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg159GcConceptoDto> findByCdgoCategoriaCdgoConceptoIn(List<String> cdgoCategoria,
			List<String> cdgoConcepto) {
		List<Tbasg159GcConceptoPK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoCategoria.size(); i++) {
			Tbasg159GcConceptoPK newPk = new Tbasg159GcConceptoPK();
			newPk.setCdgoCategoria(cdgoCategoria.get(i));
			newPk.setCdgoConcepto(cdgoConcepto.get(i));
			pks.add(newPk);
		}
		List<Tbasg159GcConcepto> tbasg159GcConceptos = tbasg159GcConceptoRepository.findByTbasg159gcconceptopkIn(pks);

		return toDtos(tbasg159GcConceptos);
	}

	public List<Tbasg159GcConceptoDto> getGcConceptosActiveList() {
		return toDtos(tbasg159GcConceptoRepository.getGcConceptosActiveList());
	}

	public Tbasg159GcConceptoDto toDto(Tbasg159GcConcepto orig) {

		Tbasg159GcConceptoDto dest = new Tbasg159GcConceptoDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg159GcConcepto toEntity(Tbasg159GcConceptoDto orig) {

		Tbasg159GcConcepto dest = new Tbasg159GcConcepto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg159GcConceptoDto> toDtos(List<Tbasg159GcConcepto> orig) {

		List<Tbasg159GcConceptoDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg159GcConcepto> toEntities(List<Tbasg159GcConceptoDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg159GcConcepto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
