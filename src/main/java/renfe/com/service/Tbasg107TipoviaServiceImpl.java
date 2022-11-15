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
import org.springframework.stereotype.Service;

import renfe.com.model.dto.Tbasg107TipoviaDto;
import renfe.com.model.entity.Tbasg107Tipovia;
import renfe.com.repository.Tbasg107TipoviaRepository;

@Transactional
@Service
public class Tbasg107TipoviaServiceImpl implements Tbasg107TipoviaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg107TipoviaRepository tbasg107TipoviaRepository;

	public List<Tbasg107TipoviaDto> getAllTbasg107Tipovia(Tbasg107TipoviaDto filter) {

		logger.info("getAllTbasg107Tipovia " + filter);
		if (filter == null) {
			return this.toDtos(tbasg107TipoviaRepository.findAll());
		}
		return this.toDtos(tbasg107TipoviaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg107TipoviaDto findByCdgoTipovia(Integer cdgoTipovia) {

		Optional<Tbasg107Tipovia> tbasg107TipoviaData = tbasg107TipoviaRepository.findByCdgoTipovia(cdgoTipovia);

		if (tbasg107TipoviaData.isPresent()) {
			return toDto(tbasg107TipoviaData.get());
		}
		return null;
	}

	public Tbasg107TipoviaDto createTbasg107Tipovia(Tbasg107TipoviaDto tbasg107TipoviaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg107Tipovia dbTbasg107Tipovia = new Tbasg107Tipovia();
		BeanUtils.copyProperties(dbTbasg107Tipovia, tbasg107TipoviaDto);
		Tbasg107Tipovia _tbasg107Tipovia = tbasg107TipoviaRepository.save(dbTbasg107Tipovia);
		return toDto(_tbasg107Tipovia);
	}

	public Tbasg107TipoviaDto updateTbasg107Tipovia(Integer cdgoTipovia, Tbasg107TipoviaDto tbasg107TipoviaDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg107Tipovia> tbasg107TipoviaData = tbasg107TipoviaRepository.findById(cdgoTipovia);

		if (tbasg107TipoviaData.isPresent()) {
			Tbasg107Tipovia dbTbasg107Tipovia = tbasg107TipoviaData.get();
			BeanUtils.copyProperties(dbTbasg107Tipovia, tbasg107TipoviaDto);
			return toDto(tbasg107TipoviaRepository.save(dbTbasg107Tipovia));
		}
		return null;
	}

	public int deleteTbasg107Tipovia(Integer cdgoTipovia) {

		tbasg107TipoviaRepository.deleteById(cdgoTipovia);
		return 1;
	}

	public List<Tbasg107TipoviaDto> findByCdgoTipoviaIn(List<Integer> cdgoTipovia) {

		List<Tbasg107Tipovia> tbasg107Tipovias = tbasg107TipoviaRepository.findByCdgoTipoviaIn(cdgoTipovia);

		return toDtos(tbasg107Tipovias);
	}

	public List<Tbasg107TipoviaDto> getTipoVia(String cdgoTipovia) {
		return toDtos(tbasg107TipoviaRepository.getTipoVia(cdgoTipovia));
	}

	public List<Tbasg107TipoviaDto> getTipoViaListAscendente() {
		return toDtos(tbasg107TipoviaRepository.getTipoViaListAscendente());
	}

	public List<Tbasg107TipoviaDto> getTipoViaListDescendente() {
		return toDtos(tbasg107TipoviaRepository.getTipoViaListDescendente());
	}

	public List<Tbasg107TipoviaDto> getTipoViaActiveListAscendente() {
		return toDtos(tbasg107TipoviaRepository.getTipoViaActiveListAscendente());
	}

	public List<Tbasg107TipoviaDto> getTipoViaActiveListDescendente() {
		return toDtos(tbasg107TipoviaRepository.getTipoViaActiveListDescendente());
	}

	public List<Tbasg107TipoviaDto> getTipoViaCount() {
		return toDtos(tbasg107TipoviaRepository.getTipoViaCount());
	}

	public int insertTipoVia(Tbasg107Tipovia bean) {
		return tbasg107TipoviaRepository.insertTipoVia(bean);
	}

	public int updateTipoVia(Tbasg107Tipovia bean) {
		return tbasg107TipoviaRepository.updateTipoVia(bean);
	}
	
	public int estadoTipoVia(Tbasg107Tipovia bean) {
		return tbasg107TipoviaRepository.estadoTipoVia(bean);
	}

	public Tbasg107TipoviaDto toDto(Tbasg107Tipovia orig) {

		Tbasg107TipoviaDto dest = new Tbasg107TipoviaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg107Tipovia toEntity(Tbasg107TipoviaDto orig) {

		Tbasg107Tipovia dest = new Tbasg107Tipovia();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg107TipoviaDto> toDtos(List<Tbasg107Tipovia> orig) {

		List<Tbasg107TipoviaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg107Tipovia> toEntities(List<Tbasg107TipoviaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg107Tipovia> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
