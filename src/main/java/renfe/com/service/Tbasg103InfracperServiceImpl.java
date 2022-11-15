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

import renfe.com.dto.GetInfractionListDTO;
import renfe.com.dto.GetInfractionParametersDTO;
import renfe.com.model.dto.Tbasg103InfracperDto;
import renfe.com.model.entity.Tbasg103Infracper;
import renfe.com.repository.Tbasg103InfracperRepository;

@Service
public class Tbasg103InfracperServiceImpl implements Tbasg103InfracperService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg103InfracperRepository tbasg103InfracperRepository;

	public List<Tbasg103InfracperDto> getAllTbasg103Infracper(Tbasg103InfracperDto filter) {

		logger.info("getAllTbasg103Infracper " + filter);
		if (filter == null) {
			return this.toDtos(tbasg103InfracperRepository.findAll());
		}
		return this.toDtos(tbasg103InfracperRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg103InfracperDto findByCdgoInfrper(Integer cdgoInfrper) {

		Optional<Tbasg103Infracper> tbasg103InfracperData = tbasg103InfracperRepository.findByCdgoInfrper(cdgoInfrper);

		if (tbasg103InfracperData.isPresent()) {
			return toDto(tbasg103InfracperData.get());
		}
		return null;
	}

	public Tbasg103InfracperDto createTbasg103Infracper(Tbasg103InfracperDto tbasg103InfracperDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg103Infracper dbTbasg103Infracper = new Tbasg103Infracper();
		BeanUtils.copyProperties(dbTbasg103Infracper, tbasg103InfracperDto);
		Tbasg103Infracper _tbasg103Infracper = tbasg103InfracperRepository.save(dbTbasg103Infracper);
		return toDto(_tbasg103Infracper);
	}

	public Tbasg103InfracperDto updateTbasg103Infracper(Integer cdgoInfrper, Tbasg103InfracperDto tbasg103InfracperDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg103Infracper> tbasg103InfracperData = tbasg103InfracperRepository.findById(cdgoInfrper);

		if (tbasg103InfracperData.isPresent()) {
			Tbasg103Infracper dbTbasg103Infracper = tbasg103InfracperData.get();
			BeanUtils.copyProperties(dbTbasg103Infracper, tbasg103InfracperDto);
			return toDto(tbasg103InfracperRepository.save(dbTbasg103Infracper));
		}
		return null;
	}

	public int deleteTbasg103Infracper(Integer cdgoInfrper) {

		tbasg103InfracperRepository.deleteById(cdgoInfrper);
		return 1;
	}

	public List<Tbasg103InfracperDto> findByCdgoInfrperIn(List<Integer> cdgoInfrper) {
		return toDtos(tbasg103InfracperRepository.findByCdgoInfrperIn(cdgoInfrper));
	}

	public List<Tbasg103InfracperDto> getInfracPersonaListAscendente(String cdgoPersona) {
		return toDtos(tbasg103InfracperRepository.getInfracPersonaListAscendente(cdgoPersona));
	}

	public List<Tbasg103InfracperDto> getInfracPersonaListDescendente(String cdgoPersona) {
		return toDtos(tbasg103InfracperRepository.getInfracPersonaListDescendente(cdgoPersona));
	}

	public List<Tbasg103InfracperDto> getInfracPersonaActiveListAscendente(String cdgoPersona) {
		return toDtos(tbasg103InfracperRepository.getInfracPersonaActiveListAscendente(cdgoPersona));
	}

	public List<Tbasg103InfracperDto> getInfracPersonaActiveListDescendente(String cdgoPersona) {
		return toDtos(tbasg103InfracperRepository.getInfracPersonaActiveListDescendente(cdgoPersona));
	}

	public List<Tbasg103InfracperDto> getInfracPersonaCount(String cdgoPersona) {
		return toDtos(tbasg103InfracperRepository.getInfracPersonaCount(cdgoPersona));
	}

	public List<GetInfractionListDTO> getInfracPerList(GetInfractionParametersDTO params) {
		return tbasg103InfracperRepository.getInfracPerList(params);
	}

	public List<Tbasg103InfracperDto> getInfracPerCount() {
		return toDtos(tbasg103InfracperRepository.getInfracPerCount());
	}

	public List<Tbasg103InfracperDto> getInfracPerView(String cdgoInfrper) {
		return toDtos(tbasg103InfracperRepository.getInfracPerView(cdgoInfrper));
	}

	public List<Tbasg103InfracperDto> getInfracPersona(String cdgoInfrper) {
		return toDtos(tbasg103InfracperRepository.getInfracPersona(cdgoInfrper));
	}

	public int insertInfracPersona(GetInfractionParametersDTO bean) {
		return tbasg103InfracperRepository.insertInfracPersona(bean);
	}

	public int updateInfracPersona(GetInfractionParametersDTO bean) {
		return tbasg103InfracperRepository.updateInfracPersona(bean);
	}

	public int deleteInfracPersona(GetInfractionParametersDTO bean) {
		return tbasg103InfracperRepository.deleteInfracPersona(bean);
	}

	public int updateInfrPerRefDoc(Tbasg103Infracper bean) {
		return tbasg103InfracperRepository.updateInfrPerRefDoc(bean);
	}

	public Tbasg103InfracperDto toDto(Tbasg103Infracper orig) {

		Tbasg103InfracperDto dest = new Tbasg103InfracperDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg103Infracper toEntity(Tbasg103InfracperDto orig) {

		Tbasg103Infracper dest = new Tbasg103Infracper();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg103InfracperDto> toDtos(List<Tbasg103Infracper> orig) {

		List<Tbasg103InfracperDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg103Infracper> toEntities(List<Tbasg103InfracperDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg103Infracper> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
