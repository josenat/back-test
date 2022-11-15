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

import renfe.com.model.dto.Tbasg112TipoinfraDto;
import renfe.com.model.entity.Tbasg112Tipoinfra;
import renfe.com.repository.Tbasg112TipoinfraRepository;

@Transactional
@Service
public class Tbasg112TipoinfraServiceImpl implements Tbasg112TipoinfraService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg112TipoinfraRepository tbasg112TipoinfraRepository;

	public List<Tbasg112TipoinfraDto> getAllTbasg112Tipoinfra(Tbasg112TipoinfraDto filter) {

		logger.info("getAllTbasg112Tipoinfra " + filter);
		if (filter == null) {
			return this.toDtos(tbasg112TipoinfraRepository.findAll());
		}
		return this.toDtos(tbasg112TipoinfraRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg112TipoinfraDto findByCdgoTipinfr(Integer cdgoTipinfr) {

		Optional<Tbasg112Tipoinfra> tbasg112TipoinfraData = tbasg112TipoinfraRepository.findByCdgoTipinfr(cdgoTipinfr);

		if (tbasg112TipoinfraData.isPresent()) {
			return toDto(tbasg112TipoinfraData.get());
		}
		return null;
	}

	public Tbasg112TipoinfraDto createTbasg112Tipoinfra(Tbasg112TipoinfraDto tbasg112TipoinfraDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg112Tipoinfra dbTbasg112Tipoinfra = new Tbasg112Tipoinfra();
		BeanUtils.copyProperties(dbTbasg112Tipoinfra, tbasg112TipoinfraDto);
		Tbasg112Tipoinfra _tbasg112Tipoinfra = tbasg112TipoinfraRepository.save(dbTbasg112Tipoinfra);
		return toDto(_tbasg112Tipoinfra);
	}

	public Tbasg112TipoinfraDto updateTbasg112Tipoinfra(Integer cdgoTipinfr, Tbasg112TipoinfraDto tbasg112TipoinfraDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg112Tipoinfra> tbasg112TipoinfraData = tbasg112TipoinfraRepository.findById(cdgoTipinfr);

		if (tbasg112TipoinfraData.isPresent()) {
			Tbasg112Tipoinfra dbTbasg112Tipoinfra = tbasg112TipoinfraData.get();
			BeanUtils.copyProperties(dbTbasg112Tipoinfra, tbasg112TipoinfraDto);
			return toDto(tbasg112TipoinfraRepository.save(dbTbasg112Tipoinfra));
		}
		return null;
	}

	public int deleteTbasg112Tipoinfra(Integer cdgoTipinfr) {

		tbasg112TipoinfraRepository.deleteById(cdgoTipinfr);
		return 1;
	}

	public List<Tbasg112TipoinfraDto> findByCdgoTipinfrIn(List<Integer> cdgoTipinfr) {

		List<Tbasg112Tipoinfra> tbasg112Tipoinfras = tbasg112TipoinfraRepository.findByCdgoTipinfrIn(cdgoTipinfr);

		return toDtos(tbasg112Tipoinfras);
	}

	public List<Tbasg112TipoinfraDto> getTipoInfraCount() {
		return toDtos(tbasg112TipoinfraRepository.getTipoInfraCount());
	}

	public List<Tbasg112TipoinfraDto> getTipoInfraActiveCount() {
		return toDtos(tbasg112TipoinfraRepository.getTipoInfraActiveCount());
	}

	public List<Tbasg112TipoinfraDto> getTipoInfraListAscendente() {
		return toDtos(tbasg112TipoinfraRepository.getTipoInfraListAscendente());
	}

	public List<Tbasg112TipoinfraDto> getTipoInfraListDescendente() {
		return toDtos(tbasg112TipoinfraRepository.getTipoInfraListDescendente());
	}

	public List<Tbasg112TipoinfraDto> getTipoInfraActiveListAscendente() {
		return toDtos(tbasg112TipoinfraRepository.getTipoInfraActiveListAscendente());
	}

	public List<Tbasg112TipoinfraDto> getTipoInfraActiveListDescendente() {
		return toDtos(tbasg112TipoinfraRepository.getTipoInfraActiveListDescendente());
	}

	public List<Tbasg112TipoinfraDto> getTipoInfra(String cdgoTipinfr) {
		return toDtos(tbasg112TipoinfraRepository.getTipoInfra(cdgoTipinfr));
	}

	public int insertTipoInfra(Tbasg112Tipoinfra bean) {
		return tbasg112TipoinfraRepository.insertTipoInfra(bean);
	}

	public int updateTipoInfra(Tbasg112Tipoinfra bean) {
		return tbasg112TipoinfraRepository.updateTipoInfra(bean);
	}
	
	public int estadoTipoInfra(Tbasg112Tipoinfra bean) {
		return tbasg112TipoinfraRepository.estadoTipoInfra(bean);
	}

	public Tbasg112TipoinfraDto toDto(Tbasg112Tipoinfra orig) {

		Tbasg112TipoinfraDto dest = new Tbasg112TipoinfraDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg112Tipoinfra toEntity(Tbasg112TipoinfraDto orig) {

		Tbasg112Tipoinfra dest = new Tbasg112Tipoinfra();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg112TipoinfraDto> toDtos(List<Tbasg112Tipoinfra> orig) {

		List<Tbasg112TipoinfraDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg112Tipoinfra> toEntities(List<Tbasg112TipoinfraDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg112Tipoinfra> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
