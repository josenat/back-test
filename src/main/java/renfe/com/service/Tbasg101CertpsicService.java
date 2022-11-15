package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetCertPsicPersonaInactivosListDTO;
import renfe.com.dto.GetCertpsicCdgoPersonaDTO;

import renfe.com.dto.GetRelHabPsicByCdgoCertPsicDTO;
import renfe.com.dto.GetCertpsichistResultDTO;

import renfe.com.model.dto.Tbasg101CertpsicDto;
import renfe.com.model.entity.Tbasg101Certpsic;

public interface Tbasg101CertpsicService {

	public List<Tbasg101CertpsicDto> getAllTbasg101Certpsic(Tbasg101CertpsicDto filter);

	public Tbasg101CertpsicDto findByCdgoCertpsic(Integer cdgoCertpsic);

	public Tbasg101CertpsicDto createTbasg101Certpsic(Tbasg101CertpsicDto tbasg101CertpsicDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg101CertpsicDto updateTbasg101Certpsic(Integer cdgoCertpsic, Tbasg101CertpsicDto tbasg101CertpsicDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg101Certpsic(Integer cdgoCertpsic);

	public List<Tbasg101CertpsicDto> findByCdgoCertpsicIn(List<Integer> cdgoCertpsic);

	public List<Tbasg101CertpsicDto> getExpiredCertPsic(String fchaProxrev);

	public List<Tbasg101CertpsicDto> getNoExpiredCertPsicByCdgoPersona(String cdgoPersona, String fchaProxrev);

	public List<Tbasg101CertpsicDto> getCertPsic(String cdgoCertpsic);
	
	public List<Tbasg101CertpsicDto> getCertPsicByCdgoPersonaAndCdgoPsicoAmb(String cdgoPersona, Integer cdgoPsicoAmb);

	public List<GetCertpsichistResultDTO> getHistoricCertPsicPersona(String cdgoPersona);

	public List<Tbasg101CertpsicDto> getHistoricCertPsicPersonaInfSer(Integer cdgoPersona);

	public List<Tbasg101CertpsicDto> getActiveCertPsicWithMaxFchaReconoc(Integer cdgoPersona);

	public List<Tbasg101CertpsicDto> getCertPsicWithMaxFchaRec(String cdgoPersona);

	public List<Tbasg101CertpsicDto> getCertPsicActiveList(String cdgoPersona);

	public List<Tbasg101CertpsicDto> getActiveCertPsicWithMaxFchaProxRev(String cdgoPersona);

	public List<Tbasg101CertpsicDto> getCertPsicWithFchaProxRevActiveList(String cdgoPersona);

	public List<Tbasg101CertpsicDto> getCertPsicPersonaActivosList(String cdgoPersona);

	public List<GetCertPsicPersonaInactivosListDTO> getCertPsicPersonaInactivosList(String cdgoPersona);

	public List<Tbasg101CertpsicDto> getCertPsicByPerOrderByPsicAmb(String cdgoPersona);

	public List<Tbasg101CertpsicDto> getCertPsicByExpOrderByPsicAmb(String cdgoExpedient);

	public List<Tbasg101CertpsicDto> getCertPsicByPerOrderPsicAmbFchaProxRev(String cdgoPersona);

	public List<Tbasg101CertpsicDto> getFchaProxRevAOTByCdgoPersona(String cdgoPersona);

	public int insertCertPsic(Tbasg101Certpsic bean);
	
	public int updatePsicoBajas(Integer cdgoCertpsic);

	public int updateCertPsic(Tbasg101CertpsicDto bean);

	public int inactiveByCdgoCertPsic(Tbasg101Certpsic bean);

	public int desactivaCertPsicByPsicAmb(Tbasg101Certpsic bean);
	
	public int desactivaCertPsicByPsicAmbRepetido(Tbasg101Certpsic bean);

	public List<Tbasg101CertpsicDto> getCertPsicByPerList(String cdgoPersona);

	public List<GetRelHabPsicByCdgoCertPsicDTO> getRelHabPsicByCdgoCertPsic(Integer cdgoCertpsic);

	public List<GetCertpsicCdgoPersonaDTO> getCertpsicCdgoPersona(Integer cdgoPersona);
	
	//public Tbasg101CertpsicDto entityToDto(List<Tbasg101Certpsic> list);

	public static Tbasg101Certpsic entityToDto(List<Tbasg101Certpsic> tbasg101Certpsic) {
		// TODO Auto-generated method stub
		return null;
	}

}

