package renfe.com.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import renfe.com.dto.GetCertPsicPersonaInactivosListDTO;
import renfe.com.dto.GetCertpsicCdgoPersonaDTO;

import renfe.com.dto.GetRelHabPsicByCdgoCertPsicDTO;
import renfe.com.dto.GetCertpsichistResultDTO;

import renfe.com.model.dto.Tbasg101CertpsicDto;
import renfe.com.model.entity.Tbasg101Certpsic;
import renfe.com.service.Tbasg101CertpsicService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg101Certpsic")
public class Tbasg101CertpsicController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg101CertpsicService tbasg101CertpsicService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg101CertpsicDto>> getAllTbasg101Certpsic(Tbasg101CertpsicDto filter) {
		return new ResponseEntity<>(tbasg101CertpsicService.getAllTbasg101Certpsic(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoCertpsic}")
	public ResponseEntity<Tbasg101CertpsicDto> findByCdgoExpediente(
			@PathVariable("cdgoCertpsic") Integer cdgoCertpsic) {
		Tbasg101CertpsicDto tbasg101CertpsicData = tbasg101CertpsicService.findByCdgoCertpsic(cdgoCertpsic);

		if (tbasg101CertpsicData != null) {
			return new ResponseEntity<>(tbasg101CertpsicData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg101CertpsicDto> createTbasg101Certpsic(
			@RequestBody Tbasg101CertpsicDto tbasg101CertpsicDto) {
		try {
			return new ResponseEntity<>(tbasg101CertpsicService.createTbasg101Certpsic(tbasg101CertpsicDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg101Certpsic {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoCertpsic}")
	public ResponseEntity<Tbasg101CertpsicDto> updateTbasg101Certpsic(
			@PathVariable("cdgoCertpsic") Integer cdgoCertpsic, @RequestBody Tbasg101CertpsicDto tbasg101CertpsicDto) {
		try {
			Tbasg101CertpsicDto tbasg101CertpsicData = tbasg101CertpsicService.updateTbasg101Certpsic(cdgoCertpsic,
					tbasg101CertpsicDto);
			if (tbasg101CertpsicData != null) {
				return new ResponseEntity<>(tbasg101CertpsicData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg101Certpsic []" + tbasg101CertpsicDto, e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoCertpsic}")
	public ResponseEntity<HttpStatus> deleteTbasg101Certpsic(@PathVariable("cdgoCertpsic") Integer cdgoCertpsic) {
		try {
			tbasg101CertpsicService.deleteTbasg101Certpsic(cdgoCertpsic);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg101Certpsic []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg101CertpsicDto>> findByCdgoCertpsicIn(List<Integer> cdgoCertpsic) {
		try {
			List<Tbasg101CertpsicDto> tbasg101CertpsicDto = tbasg101CertpsicService.findByCdgoCertpsicIn(cdgoCertpsic);

			if (tbasg101CertpsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoCertpsicIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-expired-cert-psic")
	public ResponseEntity<List<Tbasg101CertpsicDto>> getExpiredCertPsic(String fchaProxrev) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg101CertpsicDto> tbasg101CertpsicDto = tbasg101CertpsicService.getExpiredCertPsic(fchaProxrev);

			if (tbasg101CertpsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExpiredCertPsic []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-no-expired-cert-psic-by-cdgo-persona")
	public ResponseEntity<List<Tbasg101CertpsicDto>> getNoExpiredCertPsicByCdgoPersona(String cdgoPersona,
			String fchaProxrev) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg101CertpsicDto> tbasg101CertpsicDto = tbasg101CertpsicService
					.getNoExpiredCertPsicByCdgoPersona(cdgoPersona, fchaProxrev);

			if (tbasg101CertpsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getNoExpiredCertPsicByCdgoPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cert-psic")
	public ResponseEntity<List<Tbasg101CertpsicDto>> getCertPsic(String cdgoCertpsic) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg101CertpsicDto> tbasg101CertpsicDto = tbasg101CertpsicService.getCertPsic(cdgoCertpsic);

			if (tbasg101CertpsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCertPsic []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-cert-psic-by-cdgopersona-and-cdgopsicoamb")
	public ResponseEntity<List<Tbasg101CertpsicDto>> getCertPsicByCdgoPersonaAndCdgoPsicoAmb(String cdgoPersona, Integer cdgoPsicoAmb) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg101CertpsicDto> tbasg101CertpsicDto = tbasg101CertpsicService.getCertPsicByCdgoPersonaAndCdgoPsicoAmb(cdgoPersona,cdgoPsicoAmb);

			if (tbasg101CertpsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCertPsic []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-cert-psic-with-max-fcha-rec")
	public ResponseEntity<List<Tbasg101CertpsicDto>> getCertPsicWithMaxFchaRec(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg101CertpsicDto> tbasg101CertpsicDto = tbasg101CertpsicService.getCertPsicWithMaxFchaRec(cdgoPersona);

			if (tbasg101CertpsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCertPsic []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@GetMapping("/get-certpsic-by-cdgoPersona")
	public ResponseEntity<List<GetCertpsicCdgoPersonaDTO>> getCertpsicCdgoPersona(Integer cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<GetCertpsicCdgoPersonaDTO> tbasg101CertpsicDto = tbasg101CertpsicService.getCertpsicCdgoPersona(cdgoPersona);

			if (tbasg101CertpsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCertpsicCdgoPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-historic-cert-psic-persona-inf-ser")
	public ResponseEntity<List<Tbasg101CertpsicDto>> getHistoricCertPsicPersonaInfSer(Integer cdgoPersona) {
		try {
			List<Tbasg101CertpsicDto> tbasg101CertpsicDto = tbasg101CertpsicService.getHistoricCertPsicPersonaInfSer(cdgoPersona);

			if (tbasg101CertpsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getHistoricCertPsicPersonaInfSer []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-active-cert-psic-with-max-fchareconoc")
	public ResponseEntity<List<Tbasg101CertpsicDto>> getActiveCertPsicWithMaxFchaReconoc(Integer cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg101CertpsicDto> tbasg101CertpsicDto = tbasg101CertpsicService.getActiveCertPsicWithMaxFchaReconoc(cdgoPersona);

			if (tbasg101CertpsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActiveCertPsicWithMaxFchaReconoc []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/get-historia-certpsic-by-cdgoPersona")
	public ResponseEntity<List<GetCertpsichistResultDTO>> getHistoricCertPsicPersona(String cdgoPersona) {
		try {
			List<GetCertpsichistResultDTO> certpsichistDto = tbasg101CertpsicService.getHistoricCertPsicPersona(cdgoPersona);

			if (certpsichistDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(certpsichistDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("getHistoricCertPsicPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	

	@GetMapping("/get-cert-psic-active-list")
	public ResponseEntity<List<Tbasg101CertpsicDto>> getCertPsicActiveList(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg101CertpsicDto> tbasg101CertpsicDto = tbasg101CertpsicService.getCertPsicActiveList(cdgoPersona);

			if (tbasg101CertpsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCertPsicActiveList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-active-cert-psic-with-max-fcha-prox-rev")
	public ResponseEntity<List<Tbasg101CertpsicDto>> getActiveCertPsicWithMaxFchaProxRev(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg101CertpsicDto> tbasg101CertpsicDto = tbasg101CertpsicService
					.getActiveCertPsicWithMaxFchaProxRev(cdgoPersona);

			if (tbasg101CertpsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActiveCertPsicWithMaxFchaProxRev []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cert-psic-with-fcha-prox-rev-active-list")
	public ResponseEntity<List<Tbasg101CertpsicDto>> getCertPsicWithFchaProxRevActiveList(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg101CertpsicDto> tbasg101CertpsicDto = tbasg101CertpsicService
					.getCertPsicWithFchaProxRevActiveList(cdgoPersona);

			if (tbasg101CertpsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCertPsicWithFchaProxRevActiveList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cert-psic-persona-activos-list")
	public ResponseEntity<List<Tbasg101CertpsicDto>> getCertPsicPersonaActivosList(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg101CertpsicDto> tbasg101CertpsicDto = tbasg101CertpsicService
					.getCertPsicPersonaActivosList(cdgoPersona);

			if (tbasg101CertpsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCertPsicPersonaActivosList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cert-psic-persona-inactivos-list")
	public ResponseEntity<List<GetCertPsicPersonaInactivosListDTO>> getCertPsicPersonaInactivosList(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<GetCertPsicPersonaInactivosListDTO> tbasg101CertpsicDto = tbasg101CertpsicService
					.getCertPsicPersonaInactivosList(cdgoPersona);

			if (tbasg101CertpsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCertPsicPersonaInactivosList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cert-psic-by-per-order-by-psic-amb")
	public ResponseEntity<List<Tbasg101CertpsicDto>> getCertPsicByPerOrderByPsicAmb(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg101CertpsicDto> tbasg101CertpsicDto = tbasg101CertpsicService
					.getCertPsicByPerOrderByPsicAmb(cdgoPersona);

			if (tbasg101CertpsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCertPsicByPerOrderByPsicAmb []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cert-psic-by-exp-order-by-psic-amb")
	public ResponseEntity<List<Tbasg101CertpsicDto>> getCertPsicByExpOrderByPsicAmb(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg101CertpsicDto> tbasg101CertpsicDto = tbasg101CertpsicService
					.getCertPsicByExpOrderByPsicAmb(cdgoExpedient);

			if (tbasg101CertpsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCertPsicByExpOrderByPsicAmb []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cert-psic-by-per-order-psic-amb-fcha-prox-rev")
	public ResponseEntity<List<Tbasg101CertpsicDto>> getCertPsicByPerOrderPsicAmbFchaProxRev(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg101CertpsicDto> tbasg101CertpsicDto = tbasg101CertpsicService
					.getCertPsicByPerOrderPsicAmbFchaProxRev(cdgoPersona);

			if (tbasg101CertpsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCertPsicByPerOrderPsicAmbFchaProxRev []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fcha-prox-rev-a-o-t-by-cdgo-persona")
	public ResponseEntity<?> getFchaProxRevAOTByCdgoPersona(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg101CertpsicDto> tbasg101CertpsicDto = tbasg101CertpsicService
					.getFchaProxRevAOTByCdgoPersona(cdgoPersona);

			if (tbasg101CertpsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFchaProxRevAOTByCdgoPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-cert-psic")
	public ResponseEntity<?> insertCertPsic(@RequestBody Tbasg101Certpsic bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg101CertpsicDto = tbasg101CertpsicService.insertCertPsic(bean);
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertCertPsic []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	@GetMapping("/update-psico-bajas")
	public ResponseEntity<List<GetCertpsicCdgoPersonaDTO>> updatePsicoBajas(Integer cdgoCertpsic, Integer cdgoPersona) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg101CertpsicDto = tbasg101CertpsicService.updatePsicoBajas(cdgoCertpsic);
			List<GetCertpsicCdgoPersonaDTO> tbasg101CertpsicDto1 = tbasg101CertpsicService.getCertpsicCdgoPersona(cdgoPersona);
			return new ResponseEntity<>(tbasg101CertpsicDto1, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateCertPsic []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-cert-psic")
	public ResponseEntity<Integer> updateCertPsic(@RequestBody Tbasg101CertpsicDto bean) {
		try {
			int tbasg101CertpsicDto = tbasg101CertpsicService.updateCertPsic(bean);
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("updateCertPsic []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/inactive-by-cdgo-cert-psic")
	public ResponseEntity<?> inactiveByCdgoCertPsic(Tbasg101Certpsic bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg101CertpsicDto = tbasg101CertpsicService.inactiveByCdgoCertPsic(bean);
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("inactiveByCdgoCertPsic []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/desactiva-cert-psic-by-psic-amb")
	public ResponseEntity<?> desactivaCertPsicByPsicAmb(Tbasg101Certpsic bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg101CertpsicDto = tbasg101CertpsicService.desactivaCertPsicByPsicAmb(bean);
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("desactivaCertPsicByPsicAmb []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/desactiva-cert-psic-by-psic-amb-repetido")
	public ResponseEntity<?> desactivaCertPsicByPsicAmbRepetido(@RequestBody Tbasg101Certpsic bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg101CertpsicDto = tbasg101CertpsicService.desactivaCertPsicByPsicAmbRepetido(bean);
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("desactivaCertPsicByPsicAmbRepetido []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cert-psic-by-per-list")
	public ResponseEntity<List<Tbasg101CertpsicDto>> getCertPsicByPerList(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg101CertpsicDto> tbasg101CertpsicDto = tbasg101CertpsicService.getCertPsicByPerList(cdgoPersona);

			if (tbasg101CertpsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCertPsicByPerList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-rel-hab-psic-by-cdgo-cert-psic")
	public ResponseEntity<List<GetRelHabPsicByCdgoCertPsicDTO>> getRelHabPsicByCdgoCertPsic(Integer cdgoCertpsic) {
		// Generated from a SELECT found in an XML
		try {
			List<GetRelHabPsicByCdgoCertPsicDTO> tbasg101CertpsicDto = tbasg101CertpsicService.getRelHabPsicByCdgoCertPsic(cdgoCertpsic);

			if (tbasg101CertpsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg101CertpsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getRelHabPsicByCdgoCertPsic []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
