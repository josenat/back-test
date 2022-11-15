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


import renfe.com.dto.GetCertpsicCdgoPersonaDTO;
import renfe.com.dto.GetRelHabPsicByCdgoCertPsicDTO;
import renfe.com.dto.GetCertpsichistResultDTO;
import renfe.com.model.dto.Tbasg100PersonaDto;

import renfe.com.dto.GetCertPsicPersonaInactivosListDTO;

import renfe.com.dto.GetCertsPsicByPersListDTO;

import renfe.com.model.dto.Tbasg101CertpsicDto;
import renfe.com.model.entity.Tbasg100Persona;
import renfe.com.model.entity.Tbasg101Certpsic;
import renfe.com.repository.Tbasg101CertpsicRepository;

@Transactional
@Service
public class Tbasg101CertpsicServiceImpl implements Tbasg101CertpsicService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg101CertpsicRepository tbasg101CertpsicRepository;
	
	@Autowired
	private Tbasg100PersonaService tbasg100PersonaService;
	
	public List<Tbasg101CertpsicDto> getAllTbasg101Certpsic(Tbasg101CertpsicDto filter) {

		logger.info("getAllTbasg101Certpsic " + filter);
		if (filter == null) {
			return this.toDtos(tbasg101CertpsicRepository.findAll());
		}
		return this.toDtos(tbasg101CertpsicRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg101CertpsicDto findByCdgoCertpsic(Integer cdgoCertpsic) {

		Optional<Tbasg101Certpsic> tbasg101CertpsicData = tbasg101CertpsicRepository.findByCdgoCertpsic(cdgoCertpsic);

		if (tbasg101CertpsicData.isPresent()) {
			return toDto(tbasg101CertpsicData.get());
		}
		return null;
	}

	public Tbasg101CertpsicDto createTbasg101Certpsic(Tbasg101CertpsicDto tbasg101CertpsicDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg101Certpsic dbTbasg101Certpsic = new Tbasg101Certpsic();
		BeanUtils.copyProperties(dbTbasg101Certpsic, tbasg101CertpsicDto);
		Tbasg101Certpsic tbasg101Certpsic = tbasg101CertpsicRepository.save(dbTbasg101Certpsic);
		return toDto(tbasg101Certpsic);
	}

	public Tbasg101CertpsicDto updateTbasg101Certpsic(Integer cdgoCertpsic, Tbasg101CertpsicDto tbasg101CertpsicDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg101Certpsic> tbasg101CertpsicData = tbasg101CertpsicRepository.findById(cdgoCertpsic);

		if (tbasg101CertpsicData.isPresent()) {
			Tbasg101Certpsic dbTbasg101Certpsic = tbasg101CertpsicData.get();
			BeanUtils.copyProperties(dbTbasg101Certpsic, tbasg101CertpsicDto);
			return toDto(tbasg101CertpsicRepository.save(dbTbasg101Certpsic));
		}
		return null;
	}

	public int deleteTbasg101Certpsic(Integer cdgoCertpsic) {

		tbasg101CertpsicRepository.deleteById(cdgoCertpsic);
		return 1;
	}

	public List<Tbasg101CertpsicDto> findByCdgoCertpsicIn(List<Integer> cdgoCertpsic) {
		return toDtos(tbasg101CertpsicRepository.findByCdgoCertpsicIn(cdgoCertpsic));
	}

	public List<Tbasg101CertpsicDto> getExpiredCertPsic(String fchaProxrev) {
		return toDtos(tbasg101CertpsicRepository.getExpiredCertPsic(fchaProxrev));
	}

	public List<Tbasg101CertpsicDto> getNoExpiredCertPsicByCdgoPersona(String cdgoPersona, String fchaProxrev) {
		return toDtos(tbasg101CertpsicRepository.getNoExpiredCertPsicByCdgoPersona(cdgoPersona, fchaProxrev));
	}

	public List<Tbasg101CertpsicDto> getCertPsic(String cdgoCertpsic) {
		return toDtos(tbasg101CertpsicRepository.getCertPsic(cdgoCertpsic));
	}

	public List<GetCertpsichistResultDTO> getHistoricCertPsicPersona(String cdgoPersona) {
		return tbasg101CertpsicRepository.getHistoricCertPsicPersona(cdgoPersona);
	}

	public List<Tbasg101CertpsicDto> getHistoricCertPsicPersonaInfSer(Integer cdgoPersona) {
		return toDtos(tbasg101CertpsicRepository.getHistoricCertPsicPersonaInfSer(cdgoPersona));
	}

	public List<Tbasg101CertpsicDto> getActiveCertPsicWithMaxFchaReconoc(Integer cdgoPersona) {
		return toDtos(tbasg101CertpsicRepository.getActiveCertPsicWithMaxFchaReconoc(cdgoPersona));
	}

	public List<Tbasg101CertpsicDto> getCertPsicWithMaxFchaRec(String cdgoPersona) {
		return toDtos(tbasg101CertpsicRepository.getCertPsicWithMaxFchaRec(cdgoPersona));
	}

	public List<Tbasg101CertpsicDto> getCertPsicActiveList(String cdgoPersona) {
		return toDtos(tbasg101CertpsicRepository.getCertPsicActiveList(cdgoPersona));
	}

	public List<Tbasg101CertpsicDto> getActiveCertPsicWithMaxFchaProxRev(String cdgoPersona) {
		return toDtos(tbasg101CertpsicRepository.getActiveCertPsicWithMaxFchaProxRev(cdgoPersona));
	}

	public List<Tbasg101CertpsicDto> getCertPsicWithFchaProxRevActiveList(String cdgoPersona) {
		return toDtos(tbasg101CertpsicRepository.getCertPsicWithFchaProxRevActiveList(cdgoPersona));
	}

	public List<Tbasg101CertpsicDto> getCertPsicPersonaActivosList(String cdgoPersona) {
		return toDtos(tbasg101CertpsicRepository.getCertPsicPersonaActivosList(cdgoPersona));
	}

	public List<GetCertPsicPersonaInactivosListDTO> getCertPsicPersonaInactivosList(String cdgoPersona) {
		return tbasg101CertpsicRepository.getCertPsicPersonaInactivosList(cdgoPersona);
	}

	public List<Tbasg101CertpsicDto> getCertPsicByPerOrderByPsicAmb(String cdgoPersona) {
		return toDtos(tbasg101CertpsicRepository.getCertPsicByPerOrderByPsicAmb(cdgoPersona));
	}

	public List<Tbasg101CertpsicDto> getCertPsicByExpOrderByPsicAmb(String cdgoExpedient) {
		return toDtos(tbasg101CertpsicRepository.getCertPsicByExpOrderByPsicAmb(cdgoExpedient));
	}

	public List<Tbasg101CertpsicDto> getCertPsicByPerOrderPsicAmbFchaProxRev(String cdgoPersona) {
		return toDtos(tbasg101CertpsicRepository.getCertPsicByPerOrderPsicAmbFchaProxRev(cdgoPersona));
	}

	public List<Tbasg101CertpsicDto> getFchaProxRevAOTByCdgoPersona(String cdgoPersona) {
		return toDtos(tbasg101CertpsicRepository.getFchaProxRevAOTByCdgoPersona(cdgoPersona));
	}

	public List<GetCertpsicCdgoPersonaDTO> getCertpsicCdgoPersona(Integer cdgoPersona) {
		return tbasg101CertpsicRepository.getCertpsicCdgoPersona(cdgoPersona);
	}
	
	public List<Tbasg101CertpsicDto> getCertPsicByCdgoPersonaAndCdgoPsicoAmb(String cdgoPersona, Integer cdgoPsicoAmb) {
		return toDtos(tbasg101CertpsicRepository.getCertPsicByCdgoPersonaAndCdgoPsicoAmb(cdgoPersona,cdgoPsicoAmb));
	}
	
	
	public int insertCertPsic(Tbasg101Certpsic bean) {
		return tbasg101CertpsicRepository.insertCertPsic(bean);
	}

	public int updateCertPsic(Tbasg101CertpsicDto bean) {
		return tbasg101CertpsicRepository.updateCertPsic(bean);
	}
	
	public int updatePsicoBajas(Integer cdgoCertpsic) {
		
		return tbasg101CertpsicRepository.updatePsicoBajas(cdgoCertpsic);
	}

	public int inactiveByCdgoCertPsic(Tbasg101Certpsic bean) {
		return tbasg101CertpsicRepository.inactiveByCdgoCertPsic(bean);
	}

	public int desactivaCertPsicByPsicAmb(Tbasg101Certpsic bean) {
		return tbasg101CertpsicRepository.desactivaCertPsicByPsicAmb(bean);
	}
	
	public int desactivaCertPsicByPsicAmbRepetido(Tbasg101Certpsic bean) {
		return tbasg101CertpsicRepository.desactivaCertPsicByPsicAmbRepetido(bean);
	}

	public List<Tbasg101CertpsicDto> getCertPsicByPerList(String cdgoPersona) {
		return toDtos(tbasg101CertpsicRepository.getCertPsicByPerList(cdgoPersona));
	}

	public List<GetRelHabPsicByCdgoCertPsicDTO> getRelHabPsicByCdgoCertPsic(Integer cdgoCertpsic) {
		//return toDtos(tbasg101CertpsicRepository.getRelHabPsicByCdgoCertPsic(cdgoCertpsic));
		return tbasg101CertpsicRepository.getRelHabPsicByCdgoCertPsic(cdgoCertpsic);
	}
	
	public List<GetCertsPsicByPersListDTO> getCertsPsicByPersList(List<Integer> mapPending){
		return toDtos1(tbasg101CertpsicRepository.getCertsPsicByPersList(mapPending));
	}
	
	public Tbasg101CertpsicDto entityToDto(Tbasg101Certpsic entity) {
		return toDto(entity);
	}
	


	public Tbasg101CertpsicDto toDto(Tbasg101Certpsic orig) {

		Tbasg101CertpsicDto dest = new Tbasg101CertpsicDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}
	

	public Tbasg101Certpsic toEntity(Tbasg101CertpsicDto orig) {

		Tbasg101Certpsic dest = new Tbasg101Certpsic();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg101CertpsicDto> toDtos(List<Tbasg101Certpsic> orig) {

		List<Tbasg101CertpsicDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg101Certpsic> toEntities(List<Tbasg101CertpsicDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg101Certpsic> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
	
	public GetCertsPsicByPersListDTO toDto1(GetCertsPsicByPersListDTO origItem) {

		GetCertsPsicByPersListDTO dest = new GetCertsPsicByPersListDTO();
		try {
			BeanUtils.copyProperties(dest, origItem);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}
	
	public List<GetCertsPsicByPersListDTO> toDtos1(List<GetCertsPsicByPersListDTO> list) {

		List<GetCertsPsicByPersListDTO> dest = new ArrayList<>();
		if (list == null) {
			return dest;
		}
		list.forEach(origItem -> {
			dest.add(this.toDto1(origItem));
		});
		return dest;
	}

	public Tbasg101Certpsic entityToDto(List<Tbasg101Certpsic> tbasg101Certpsic) {
		// TODO Auto-generated method stub
		return null;
	}

}

