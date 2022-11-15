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

import renfe.com.dto.GetCentFormaListAscCentHgadoDTO;
import renfe.com.model.dto.Tbasg120CentformaDto;
import renfe.com.model.entity.Tbasg120Centforma;
import renfe.com.repository.Tbasg120CentformaRepository;

@Transactional
@Service
public class Tbasg120CentformaServiceImpl implements Tbasg120CentformaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg120CentformaRepository tbasg120CentformaRepository;

	public List<Tbasg120CentformaDto> getAllTbasg120Centforma(Tbasg120CentformaDto filter) {

		logger.info("getAllTbasg120Centforma " + filter);
		if (filter == null) {
			return this.toDtos(tbasg120CentformaRepository.findAll());
		}
		return this.toDtos(tbasg120CentformaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg120CentformaDto findByCdgoCentrofor(Integer cdgoCentrofor) {

		Optional<Tbasg120Centforma> tbasg120CentformaData = tbasg120CentformaRepository
				.findByCdgoCentrofor(cdgoCentrofor);

		if (tbasg120CentformaData.isPresent()) {
			return toDto(tbasg120CentformaData.get());
		}
		return null;
	}

	public Tbasg120CentformaDto createTbasg120Centforma(Tbasg120CentformaDto tbasg120CentformaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg120Centforma dbTbasg120Centforma = new Tbasg120Centforma();
		BeanUtils.copyProperties(dbTbasg120Centforma, tbasg120CentformaDto);
		Tbasg120Centforma _tbasg120Centforma = tbasg120CentformaRepository.save(dbTbasg120Centforma);
		return toDto(_tbasg120Centforma);
	}

	public Tbasg120CentformaDto updateTbasg120Centforma(Integer cdgoCentrofor,
			Tbasg120CentformaDto tbasg120CentformaDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg120Centforma> tbasg120CentformaData = tbasg120CentformaRepository.findById(cdgoCentrofor);

		if (tbasg120CentformaData.isPresent()) {
			Tbasg120Centforma dbTbasg120Centforma = tbasg120CentformaData.get();
			BeanUtils.copyProperties(dbTbasg120Centforma, tbasg120CentformaDto);
			return toDto(tbasg120CentformaRepository.save(dbTbasg120Centforma));
		}
		return null;
	}

	public int deleteTbasg120Centforma(Integer cdgoCentrofor) {

		tbasg120CentformaRepository.deleteById(cdgoCentrofor);
		return 1;
	}

	public List<Tbasg120CentformaDto> findByCdgoCentroforIn(List<Integer> cdgoCentrofor) {

		List<Tbasg120Centforma> tbasg120Centformas = tbasg120CentformaRepository.findByCdgoCentroforIn(cdgoCentrofor);

		return toDtos(tbasg120Centformas);
	}

	public List<Tbasg120CentformaDto> getCentroForName(String desgNombre) {
		return tbasg120CentformaRepository.getCentroForName(desgNombre);
	}

	public List<Tbasg120CentformaDto> getCentFormaCount() {
		return toDtos(tbasg120CentformaRepository.getCentFormaCount());
	}

	public List<Tbasg120CentformaDto> getCentFormaViewCount(String cdgoCenthgado) {
		return toDtos(tbasg120CentformaRepository.getCentFormaViewCount(cdgoCenthgado));
	}

	public List<Tbasg120CentformaDto> getCentFormaListAscendente() {
		return toDtos(tbasg120CentformaRepository.getCentFormaListAscendente());
	}
	
	public List<GetCentFormaListAscCentHgadoDTO> getCentFormaListAscCentHgado(Integer cdgoCenthgado) {
		return tbasg120CentformaRepository.getCentFormaListAscCentHgado(cdgoCenthgado);
	}

	public List<Tbasg120CentformaDto> getCentFormaListDescendente() {
		return toDtos(tbasg120CentformaRepository.getCentFormaListDescendente());
	}

	public List<Tbasg120CentformaDto> getCentFormaActiveListAscendente() {
		return toDtos(tbasg120CentformaRepository.getCentFormaActiveListAscendente());
	}

	public List<Tbasg120CentformaDto> getCentFormaActiveListDescendente() {
		return toDtos(tbasg120CentformaRepository.getCentFormaActiveListDescendente());
	}

	public List<Tbasg120CentformaDto> getCentForma(String cdgoCentrofor) {
		return toDtos(tbasg120CentformaRepository.getCentForma(cdgoCentrofor));
	}

	public List<Tbasg120CentformaDto> getCentFormaListAscendenteViewCDGO_CENTFORMA(String cdgoCenthgado) {
		return toDtos(tbasg120CentformaRepository.getCentFormaListAscendenteViewCDGO_CENTFORMA(cdgoCenthgado));
	}

	public List<Tbasg120CentformaDto> getCentFormaListDescendenteViewCDGO_CENTFORMA(String cdgoCenthgado) {
		return toDtos(tbasg120CentformaRepository.getCentFormaListDescendenteViewCDGO_CENTFORMA(cdgoCenthgado));
	}

	public List<Tbasg120CentformaDto> getCentFormaActiveListAscendenteViewCDGO_CENTFORMA(String cdgoCenthgado) {
		return toDtos(tbasg120CentformaRepository.getCentFormaActiveListAscendenteViewCDGO_CENTFORMA(cdgoCenthgado));
	}

	public List<Tbasg120CentformaDto> getCentFormaActiveListDescendenteViewCDGO_CENTFORMA(String cdgoCenthgado) {
		return toDtos(tbasg120CentformaRepository.getCentFormaActiveListDescendenteViewCDGO_CENTFORMA(cdgoCenthgado));
	}

	public int insertCentForma(Tbasg120Centforma bean) {
		return tbasg120CentformaRepository.insertCentForma(bean);
	}

	public int updateCentForma(Tbasg120Centforma bean) {
		return tbasg120CentformaRepository.updateCentForma(bean);
	}
	
	public int estadoCentForma(Tbasg120Centforma bean) {
		return tbasg120CentformaRepository.estadoCentForma(bean);
	}

	public int deleteCentFormaByCentHgado(Tbasg120Centforma bean) {
		return tbasg120CentformaRepository.deleteCentFormaByCentHgado(bean);
	}

	public Tbasg120CentformaDto toDto(Tbasg120Centforma orig) {

		Tbasg120CentformaDto dest = new Tbasg120CentformaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg120Centforma toEntity(Tbasg120CentformaDto orig) {

		Tbasg120Centforma dest = new Tbasg120Centforma();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg120CentformaDto> toDtos(List<Tbasg120Centforma> orig) {

		List<Tbasg120CentformaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg120Centforma> toEntities(List<Tbasg120CentformaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg120Centforma> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
