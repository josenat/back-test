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

import renfe.com.model.dto.Tbasg150TipodocDto;
import renfe.com.model.entity.Tbasg150Tipodoc;
import renfe.com.repository.Tbasg150TipodocRepository;

@Service
public class Tbasg150TipodocServiceImpl implements Tbasg150TipodocService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg150TipodocRepository tbasg150TipodocRepository;

	public List<Tbasg150TipodocDto> getAllTbasg150Tipodoc(Tbasg150TipodocDto filter) {

		logger.info("getAllTbasg150Tipodoc " + filter);
		if (filter == null) {
			return this.toDtos(tbasg150TipodocRepository.findAll());
		}
		return this.toDtos(tbasg150TipodocRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg150TipodocDto findByCdgoTipodoc(Integer cdgoTipodoc) {

		Optional<Tbasg150Tipodoc> tbasg150TipodocData = tbasg150TipodocRepository.findByCdgoTipodoc(cdgoTipodoc);

		if (tbasg150TipodocData.isPresent()) {
			return toDto(tbasg150TipodocData.get());
		}
		return null;
	}

	public Tbasg150TipodocDto createTbasg150Tipodoc(Tbasg150TipodocDto tbasg150TipodocDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg150Tipodoc dbTbasg150Tipodoc = new Tbasg150Tipodoc();
		BeanUtils.copyProperties(dbTbasg150Tipodoc, tbasg150TipodocDto);
		Tbasg150Tipodoc _tbasg150Tipodoc = tbasg150TipodocRepository.save(dbTbasg150Tipodoc);
		return toDto(_tbasg150Tipodoc);
	}

	public Tbasg150TipodocDto updateTbasg150Tipodoc(Integer cdgoTipodoc, Tbasg150TipodocDto tbasg150TipodocDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg150Tipodoc> tbasg150TipodocData = tbasg150TipodocRepository.findById(cdgoTipodoc);

		if (tbasg150TipodocData.isPresent()) {
			Tbasg150Tipodoc dbTbasg150Tipodoc = tbasg150TipodocData.get();
			BeanUtils.copyProperties(dbTbasg150Tipodoc, tbasg150TipodocDto);
			return toDto(tbasg150TipodocRepository.save(dbTbasg150Tipodoc));
		}
		return null;
	}

	public int deleteTbasg150Tipodoc(Integer cdgoTipodoc) {

		tbasg150TipodocRepository.deleteById(cdgoTipodoc);
		return 1;
	}

	public List<Tbasg150TipodocDto> findByCdgoTipodocIn(List<Integer> cdgoTipodoc) {

		List<Tbasg150Tipodoc> tbasg150Tipodocs = tbasg150TipodocRepository.findByCdgoTipodocIn(cdgoTipodoc);

		return toDtos(tbasg150Tipodocs);
	}

	public List<Tbasg150TipodocDto> getDescTipoDocumento(String cdgoTipodoc) {
		return toDtos(tbasg150TipodocRepository.getDescTipoDocumento(cdgoTipodoc));
	}

	public List<Tbasg150TipodocDto> getTipoDocListByCodigo() {
		return toDtos(tbasg150TipodocRepository.getTipoDocListByCodigo());
	}

	public List<Tbasg150TipodocDto> getTipoDocCount() {
		return toDtos(tbasg150TipodocRepository.getTipoDocCount());
	}

	public Tbasg150TipodocDto toDto(Tbasg150Tipodoc orig) {

		Tbasg150TipodocDto dest = new Tbasg150TipodocDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg150Tipodoc toEntity(Tbasg150TipodocDto orig) {

		Tbasg150Tipodoc dest = new Tbasg150Tipodoc();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg150TipodocDto> toDtos(List<Tbasg150Tipodoc> orig) {

		List<Tbasg150TipodocDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg150Tipodoc> toEntities(List<Tbasg150TipodocDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg150Tipodoc> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
