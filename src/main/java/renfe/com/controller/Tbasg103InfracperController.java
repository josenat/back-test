package renfe.com.controller;

import java.util.List;

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

import renfe.com.dto.GetInfractionListDTO;
import renfe.com.dto.GetInfractionParametersDTO;
import renfe.com.model.dto.Tbasg103InfracperDto;
import renfe.com.model.entity.Tbasg103Infracper;
import renfe.com.service.Tbasg103InfracperService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg103Infracper")
public class Tbasg103InfracperController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg103InfracperService tbasg103InfracperService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg103InfracperDto>> getAllTbasg103Infracper(Tbasg103InfracperDto filter) {
		return new ResponseEntity<>(tbasg103InfracperService.getAllTbasg103Infracper(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoInfrper}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoInfrper") Integer cdgoInfrper) {
		Tbasg103InfracperDto tbasg103InfracperData = tbasg103InfracperService.findByCdgoInfrper(cdgoInfrper);

		if (tbasg103InfracperData != null) {
			return new ResponseEntity<>(tbasg103InfracperData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg103InfracperDto> createTbasg103Infracper(
			@RequestBody Tbasg103InfracperDto tbasg103InfracperDto) {
		try {
			return new ResponseEntity<>(tbasg103InfracperService.createTbasg103Infracper(tbasg103InfracperDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg103Infracper {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoInfrper}")
	public ResponseEntity<Tbasg103InfracperDto> updateTbasg103Infracper(@PathVariable("cdgoInfrper") Integer cdgo,
			@RequestBody Tbasg103InfracperDto body) {
		try {
			Tbasg103InfracperDto tbasg103InfracperData = tbasg103InfracperService.updateTbasg103Infracper(cdgo, body);
			if (tbasg103InfracperData != null) {
				return new ResponseEntity<>(tbasg103InfracperData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg103Infracper []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoInfrper}")
	public ResponseEntity<HttpStatus> deleteTbasg103Infracper(@PathVariable("cdgoInfrper") Integer cdgoInfrper) {
		try {
			tbasg103InfracperService.deleteTbasg103Infracper(cdgoInfrper);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg103Infracper []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg103InfracperDto>> findByCdgoInfrperIn(List<Integer> cdgoInfrper) {
		try {
			List<Tbasg103InfracperDto> tbasg103InfracperDto = tbasg103InfracperService.findByCdgoInfrperIn(cdgoInfrper);

			if (tbasg103InfracperDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg103InfracperDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoInfrperIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-infrac-persona-list-ascendente")
	public ResponseEntity<List<Tbasg103InfracperDto>> getInfracPersonaListAscendente(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg103InfracperDto> tbasg103InfracperDto = tbasg103InfracperService
					.getInfracPersonaListAscendente(cdgoPersona);

			if (tbasg103InfracperDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg103InfracperDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInfracPersonaListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-infrac-persona-list-descendente")
	public ResponseEntity<List<Tbasg103InfracperDto>> getInfracPersonaListDescendente(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg103InfracperDto> tbasg103InfracperDto = tbasg103InfracperService
					.getInfracPersonaListDescendente(cdgoPersona);

			if (tbasg103InfracperDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg103InfracperDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInfracPersonaListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-infrac-persona-active-list-ascendente")
	public ResponseEntity<List<Tbasg103InfracperDto>> getInfracPersonaActiveListAscendente(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg103InfracperDto> tbasg103InfracperDto = tbasg103InfracperService
					.getInfracPersonaActiveListAscendente(cdgoPersona);

			if (tbasg103InfracperDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg103InfracperDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInfracPersonaActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-infrac-persona-active-list-descendente")
	public ResponseEntity<List<Tbasg103InfracperDto>> getInfracPersonaActiveListDescendente(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg103InfracperDto> tbasg103InfracperDto = tbasg103InfracperService
					.getInfracPersonaActiveListDescendente(cdgoPersona);

			if (tbasg103InfracperDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg103InfracperDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInfracPersonaActiveListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-infrac-persona-count")
	public ResponseEntity<?> getInfracPersonaCount(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg103InfracperDto> tbasg103InfracperDto = tbasg103InfracperService
					.getInfracPersonaCount(cdgoPersona);

			if (tbasg103InfracperDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg103InfracperDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInfracPersonaCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/get-infrac-per-list")
	public ResponseEntity<List<GetInfractionListDTO>> getInfracPerList(@RequestBody GetInfractionParametersDTO params) {
		try {
			List<GetInfractionListDTO> getInfractionListDTO = tbasg103InfracperService.getInfracPerList(params);
			return new ResponseEntity<>(getInfractionListDTO, HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error("getInfracPerList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-infrac-per-count")
	public ResponseEntity<?> getInfracPerCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg103InfracperDto> tbasg103InfracperDto = tbasg103InfracperService.getInfracPerCount();

			if (tbasg103InfracperDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg103InfracperDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInfracPerCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-infrac-per-view")
	public ResponseEntity<List<Tbasg103InfracperDto>> getInfracPerView(String cdgoInfrper) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg103InfracperDto> tbasg103InfracperDto = tbasg103InfracperService.getInfracPerView(cdgoInfrper);

			if (tbasg103InfracperDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg103InfracperDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInfracPerView []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-infrac-persona")
	public ResponseEntity<List<Tbasg103InfracperDto>> getInfracPersona(String cdgoInfrper) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg103InfracperDto> tbasg103InfracperDto = tbasg103InfracperService.getInfracPersona(cdgoInfrper);

			if (tbasg103InfracperDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg103InfracperDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInfracPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-infrac-persona")
	public ResponseEntity<Integer> insertInfracPersona(@RequestBody GetInfractionParametersDTO bean) {
		try {
			int tbasg103InfracperDto = tbasg103InfracperService.insertInfracPersona(bean);

			return new ResponseEntity<>(tbasg103InfracperDto, HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error("insertInfracPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-infrac-persona")
	public ResponseEntity<Integer> updateInfracPersona(@RequestBody GetInfractionParametersDTO bean) {
		try { 
			int tbasg103InfracperDto = tbasg103InfracperService.updateInfracPersona(bean);
			return new ResponseEntity<>(tbasg103InfracperDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("updateInfracPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/delete-infrac-persona")
	public ResponseEntity<Integer> deleteInfracPersona(@RequestBody GetInfractionParametersDTO bean) { 
		try {
			int tbasg103InfracperDto = tbasg103InfracperService.deleteInfracPersona(bean);
			return new ResponseEntity<>(tbasg103InfracperDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("deleteInfracPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-infr-per-ref-doc")
	public ResponseEntity<?> updateInfrPerRefDoc(Tbasg103Infracper bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg103InfracperDto = tbasg103InfracperService.updateInfrPerRefDoc(bean);
			return new ResponseEntity<>(tbasg103InfracperDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateInfrPerRefDoc []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
