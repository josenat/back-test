package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import renfe.com.model.dto.Tbasg258SocPersonaDto;
import renfe.com.model.entity.Tbasg258SocPersona;
import renfe.com.repository.Tbasg258SocPersonaRepository;

@Service
public class Tbasg258SocPersonaServiceImpl implements Tbasg258SocPersonaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg258SocPersonaRepository tbasg258SocPersonaRepository;

	public List<Tbasg258SocPersonaDto> getAllTbasg258SocPersona(Tbasg258SocPersonaDto filter) {

		logger.info("getAllTbasg258SocPersona " + filter);
		if (filter == null) {
			return this.toDtos(tbasg258SocPersonaRepository.findAll());
		}
		return this.toDtos(tbasg258SocPersonaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg258SocPersonaDto findByIdSocpersona(Integer idSocpersona) {

		Optional<Tbasg258SocPersona> tbasg258SocPersonaData = tbasg258SocPersonaRepository
				.findByIdSocpersona(idSocpersona);

		if (tbasg258SocPersonaData.isPresent()) {
			return toDto(tbasg258SocPersonaData.get());
		}
		return null;
	}

	public Tbasg258SocPersonaDto createTbasg258SocPersona(Tbasg258SocPersonaDto tbasg258SocPersonaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg258SocPersona dbTbasg258SocPersona = new Tbasg258SocPersona();
		BeanUtils.copyProperties(dbTbasg258SocPersona, tbasg258SocPersonaDto);
		Tbasg258SocPersona _tbasg258SocPersona = tbasg258SocPersonaRepository.save(dbTbasg258SocPersona);
		return toDto(_tbasg258SocPersona);
	}

	public Tbasg258SocPersonaDto updateTbasg258SocPersona(Integer idSocpersona,
			Tbasg258SocPersonaDto tbasg258SocPersonaDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg258SocPersona> tbasg258SocPersonaData = tbasg258SocPersonaRepository.findById(idSocpersona);

		if (tbasg258SocPersonaData.isPresent()) {
			Tbasg258SocPersona dbTbasg258SocPersona = tbasg258SocPersonaData.get();
			BeanUtils.copyProperties(dbTbasg258SocPersona, tbasg258SocPersonaDto);
			return toDto(tbasg258SocPersonaRepository.save(dbTbasg258SocPersona));
		}
		return null;
	}

	public int deleteTbasg258SocPersona(Integer idSocpersona) {

		tbasg258SocPersonaRepository.deleteById(idSocpersona);
		return 1;
	}

	public List<Tbasg258SocPersonaDto> findByIdSocpersonaIn(List<Integer> idSocpersona) {

		List<Tbasg258SocPersona> tbasg258SocPersonas = tbasg258SocPersonaRepository.findByIdSocpersonaIn(idSocpersona);

		return toDtos(tbasg258SocPersonas);
	}

	public List<Tbasg258SocPersonaDto> findByCdgoPersona(Integer cdgoPersona) {
		return toDtos(tbasg258SocPersonaRepository.findByCdgoPersona(cdgoPersona));
	}

	public List<Tbasg258SocPersonaDto> findByCdgoPersonaActivo(String cdgoPersona) {
		return toDtos(tbasg258SocPersonaRepository.findByCdgoPersonaActivo(cdgoPersona));
	}

	public List<Tbasg258SocPersonaDto> findByCdgoPersonaInActivo(String cdgoPersona) {
		return toDtos(tbasg258SocPersonaRepository.findByCdgoPersonaInActivo(cdgoPersona));
	}

	public int insertSocPersona(Integer cdgoPersona, String cdgoSociedad, Date fechAlta, Date fechBaja) {
		return tbasg258SocPersonaRepository.insertSocPersona(cdgoPersona,cdgoSociedad,fechAlta,fechBaja);
	}

	public int updateSocPersona(Integer idSocPersona, String cdgoSociedad, Date fechAlta, Date fechBaja) {
		return tbasg258SocPersonaRepository.updateSocPersona(idSocPersona,cdgoSociedad,fechAlta,fechBaja);
	}

	public Tbasg258SocPersonaDto toDto(Tbasg258SocPersona orig) {

		Tbasg258SocPersonaDto dest = new Tbasg258SocPersonaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg258SocPersona toEntity(Tbasg258SocPersonaDto orig) {

		Tbasg258SocPersona dest = new Tbasg258SocPersona();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg258SocPersonaDto> toDtos(List<Tbasg258SocPersona> orig) {

		List<Tbasg258SocPersonaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg258SocPersona> toEntities(List<Tbasg258SocPersonaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg258SocPersona> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
