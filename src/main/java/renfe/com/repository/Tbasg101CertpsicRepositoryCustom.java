package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetCertPsicPersonaInactivosListDTO;
import renfe.com.dto.GetCertpsicCdgoPersonaDTO;

import renfe.com.dto.GetRelHabPsicByCdgoCertPsicDTO;
import renfe.com.dto.GetCertpsichistResultDTO;
import renfe.com.model.dto.Tbasg101CertpsicDto;

import renfe.com.dto.GetCertsPsicByPersListDTO;

import renfe.com.model.entity.Tbasg101Certpsic;

public interface Tbasg101CertpsicRepositoryCustom {

	public List<Tbasg101Certpsic> getExpiredCertPsic(String fchaProxrev);

	public List<Tbasg101Certpsic> getNoExpiredCertPsicByCdgoPersona(String cdgoPersona, String fchaProxrev);

	public List<Tbasg101Certpsic> getCertPsic(String cdgoCertpsic);

	public List<GetCertpsichistResultDTO> getHistoricCertPsicPersona(String cdgoPersona);

	public List<Tbasg101Certpsic> getHistoricCertPsicPersonaInfSer(Integer cdgoPersona);

	public List<Tbasg101Certpsic> getActiveCertPsicWithMaxFchaReconoc(Integer cdgoPersona);

	public List<Tbasg101Certpsic> getCertPsicWithMaxFchaRec(String cdgoPersona);

	public List<Tbasg101Certpsic> getCertPsicActiveList(String cdgoPersona);

	public List<Tbasg101Certpsic> getActiveCertPsicWithMaxFchaProxRev(String cdgoPersona);

	public List<Tbasg101Certpsic> getCertPsicWithFchaProxRevActiveList(String cdgoPersona);

	public List<Tbasg101Certpsic> getCertPsicPersonaActivosList(String cdgoPersona);

	public List<GetCertPsicPersonaInactivosListDTO> getCertPsicPersonaInactivosList(String cdgoPersona);

	public List<Tbasg101Certpsic> getCertPsicByPerOrderByPsicAmb(String cdgoPersona);

	public List<Tbasg101Certpsic> getCertPsicByExpOrderByPsicAmb(String cdgoExpedient);

	public List<Tbasg101Certpsic> getCertPsicByPerOrderPsicAmbFchaProxRev(String cdgoPersona);

	public List<Tbasg101Certpsic> getFchaProxRevAOTByCdgoPersona(String cdgoPersona);
	
	public List<Tbasg101Certpsic> getCertPsicByCdgoPersonaAndCdgoPsicoAmb(String cdgoPersona, Integer cdgoPsicoAmb);


	public int insertCertPsic(Tbasg101Certpsic bean);
	
	public int updatePsicoBajas(Integer cdgoCertpsic);

	public int updateCertPsic(Tbasg101CertpsicDto bean);

	public int inactiveByCdgoCertPsic(Tbasg101Certpsic bean);

	public int desactivaCertPsicByPsicAmb(Tbasg101Certpsic bean);

	public List<Tbasg101Certpsic> getCertPsicByPerList(String cdgoPersona);
	
	public List<GetCertsPsicByPersListDTO> getCertsPsicByPersList(List<Integer> mapPending);

	public List<GetRelHabPsicByCdgoCertPsicDTO> getRelHabPsicByCdgoCertPsic(Integer cdgoCertpsic);
	
	public List<GetCertpsicCdgoPersonaDTO> getCertpsicCdgoPersona(Integer cdgoPersona);
	
	public int desactivaCertPsicByPsicAmbRepetido(Tbasg101Certpsic bean);


}