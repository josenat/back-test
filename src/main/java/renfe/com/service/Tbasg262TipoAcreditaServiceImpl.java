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

import renfe.com.model.dto.Tbasg262TipoAcreditaDto;
import renfe.com.model.entity.Tbasg262TipoAcredita;
import renfe.com.repository.Tbasg262TipoAcreditaRepository;

@Service
public class Tbasg262TipoAcreditaServiceImpl implements Tbasg262TipoAcreditaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg262TipoAcreditaRepository tbasg262TipoAcreditaRepository;

	public List<Tbasg262TipoAcreditaDto> getAllTbasg262TipoAcredita(Tbasg262TipoAcreditaDto filter) {

		logger.info("getAllTbasg262TipoAcredita " + filter);
		if (filter == null) {
			return this.toDtos(tbasg262TipoAcreditaRepository.findAll());
		}
		return this.toDtos(tbasg262TipoAcreditaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg262TipoAcreditaDto findByCdgoTipoacr(String cdgoTipoacr) {

		Optional<Tbasg262TipoAcredita> tbasg262TipoAcreditaData = tbasg262TipoAcreditaRepository
				.findByCdgoTipoacr(cdgoTipoacr);

		if (tbasg262TipoAcreditaData.isPresent()) {
			return toDto(tbasg262TipoAcreditaData.get());
		}
		return null;
	}

	public Tbasg262TipoAcreditaDto createTbasg262TipoAcredita(Tbasg262TipoAcreditaDto tbasg262TipoAcreditaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg262TipoAcredita dbTbasg262TipoAcredita = new Tbasg262TipoAcredita();
		BeanUtils.copyProperties(dbTbasg262TipoAcredita, tbasg262TipoAcreditaDto);
		Tbasg262TipoAcredita _tbasg262TipoAcredita = tbasg262TipoAcreditaRepository.save(dbTbasg262TipoAcredita);
		return toDto(_tbasg262TipoAcredita);
	}

	public Tbasg262TipoAcreditaDto updateTbasg262TipoAcredita(String cdgoTipoacr,
			Tbasg262TipoAcreditaDto tbasg262TipoAcreditaDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg262TipoAcredita> tbasg262TipoAcreditaData = tbasg262TipoAcreditaRepository.findById(cdgoTipoacr);

		if (tbasg262TipoAcreditaData.isPresent()) {
			Tbasg262TipoAcredita dbTbasg262TipoAcredita = tbasg262TipoAcreditaData.get();
			BeanUtils.copyProperties(dbTbasg262TipoAcredita, tbasg262TipoAcreditaDto);
			return toDto(tbasg262TipoAcreditaRepository.save(dbTbasg262TipoAcredita));
		}
		return null;
	}

	public int deleteTbasg262TipoAcredita(String cdgoTipoacr) {

		tbasg262TipoAcreditaRepository.deleteById(cdgoTipoacr);
		return 1;
	}

	public List<Tbasg262TipoAcreditaDto> findByCdgoTipoacrIn(List<String> cdgoTipoacr) {

		List<Tbasg262TipoAcredita> tbasg262TipoAcreditas = tbasg262TipoAcreditaRepository
				.findByCdgoTipoacrIn(cdgoTipoacr);

		return toDtos(tbasg262TipoAcreditas);
	}

	public List<Tbasg262TipoAcreditaDto> getTipoAcreditacion(String cdgoTipoacr) {
		return toDtos(tbasg262TipoAcreditaRepository.getTipoAcreditacion(cdgoTipoacr));
	}

	public List<Tbasg262TipoAcreditaDto> getValidezReciclaje(String cdgoTipoacr) {
		return toDtos(tbasg262TipoAcreditaRepository.getValidezReciclaje(cdgoTipoacr));
	}
	
	public List<Tbasg262TipoAcreditaDto> getListaTiposAcreditacion() {
		return toDtos(tbasg262TipoAcreditaRepository.getListaTiposAcreditacion());
	}

	public List<Tbasg262TipoAcreditaDto> getListaTiposAcreditacionActiv() {
		return toDtos(tbasg262TipoAcreditaRepository.getListaTiposAcreditacionActiv());
	}

	public List<Tbasg262TipoAcreditaDto> getDescTipoAcreditacion(String cdgoTipoacr) {
		return toDtos(tbasg262TipoAcreditaRepository.getDescTipoAcreditacion(cdgoTipoacr));
	}

	public Tbasg262TipoAcreditaDto toDto(Tbasg262TipoAcredita orig) {

		Tbasg262TipoAcreditaDto dest = new Tbasg262TipoAcreditaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg262TipoAcredita toEntity(Tbasg262TipoAcreditaDto orig) {

		Tbasg262TipoAcredita dest = new Tbasg262TipoAcredita();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg262TipoAcreditaDto> toDtos(List<Tbasg262TipoAcredita> orig) {

		List<Tbasg262TipoAcreditaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg262TipoAcredita> toEntities(List<Tbasg262TipoAcreditaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg262TipoAcredita> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
