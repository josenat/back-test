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

import renfe.com.model.dto.Tbasg111FacultatiDto;
import renfe.com.model.entity.Tbasg111Facultati;
import renfe.com.service.Tbasg111FacultatiService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg111Facultati")
public class Tbasg111FacultatiController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg111FacultatiService tbasg111FacultatiService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg111FacultatiDto>> getAllTbasg111Facultati(Tbasg111FacultatiDto filter) {
		return new ResponseEntity<>(tbasg111FacultatiService.getAllTbasg111Facultati(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoFacult}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoFacult") Integer cdgoFacult) {
		Tbasg111FacultatiDto tbasg111FacultatiData = tbasg111FacultatiService.findByCdgoFacult(cdgoFacult);

		if (tbasg111FacultatiData != null) {
			return new ResponseEntity<>(tbasg111FacultatiData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg111FacultatiDto> createTbasg111Facultati(
			@RequestBody Tbasg111FacultatiDto tbasg111FacultatiDto) {
		try {
			return new ResponseEntity<>(tbasg111FacultatiService.createTbasg111Facultati(tbasg111FacultatiDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg111Facultati {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoFacult}")
	public ResponseEntity<Tbasg111FacultatiDto> updateTbasg111Facultati(@PathVariable("cdgoFacult") Integer cdgo,
			@RequestBody Tbasg111FacultatiDto body) {
		try {
			Tbasg111FacultatiDto tbasg111FacultatiData = tbasg111FacultatiService.updateTbasg111Facultati(cdgo, body);
			if (tbasg111FacultatiData != null) {
				return new ResponseEntity<>(tbasg111FacultatiData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg111Facultati []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoFacult}")
	public ResponseEntity<HttpStatus> deleteTbasg111Facultati(@PathVariable("cdgoFacult") Integer cdgoFacult) {
		try {
			tbasg111FacultatiService.deleteTbasg111Facultati(cdgoFacult);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg111Facultati []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg111FacultatiDto>> findByCdgoFacultIn(List<Integer> cdgoFacult) {
		try {
			List<Tbasg111FacultatiDto> tbasg111FacultatiDto = tbasg111FacultatiService.findByCdgoFacultIn(cdgoFacult);

			if (tbasg111FacultatiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg111FacultatiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoFacultIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-facultati")
	public ResponseEntity<List<Tbasg111FacultatiDto>> getFacultati(Integer cdgoFacult) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg111FacultatiDto> tbasg111FacultatiDto = tbasg111FacultatiService.getFacultati(cdgoFacult);

			if (tbasg111FacultatiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg111FacultatiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFacultati []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-facultati-by-num-colegiado")
	public ResponseEntity<List<Tbasg111FacultatiDto>> getFacultatiByNumColegiado(String desgNumcolegiado) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg111FacultatiDto> tbasg111FacultatiDto = tbasg111FacultatiService
					.getFacultatiByNumColegiado(desgNumcolegiado);

			if (tbasg111FacultatiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg111FacultatiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFacultatiByNumColegiado []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-facultati-list-ascendente")
	public ResponseEntity<List<Tbasg111FacultatiDto>> getFacultatiListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg111FacultatiDto> tbasg111FacultatiDto = tbasg111FacultatiService.getFacultatiListAscendente();

			if (tbasg111FacultatiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg111FacultatiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFacultatiListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-facultati-list-descendente")
	public ResponseEntity<List<Tbasg111FacultatiDto>> getFacultatiListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg111FacultatiDto> tbasg111FacultatiDto = tbasg111FacultatiService.getFacultatiListDescendente();

			if (tbasg111FacultatiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg111FacultatiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFacultatiListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-facultati-view-list-ascendente")
	public ResponseEntity<List<Tbasg111FacultatiDto>> getFacultatiViewListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg111FacultatiDto> tbasg111FacultatiDto = tbasg111FacultatiService.getFacultatiViewListAscendente();

			if (tbasg111FacultatiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg111FacultatiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFacultatiViewListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-facultati-view-list-descendente")
	public ResponseEntity<List<Tbasg111FacultatiDto>> getFacultatiViewListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg111FacultatiDto> tbasg111FacultatiDto = tbasg111FacultatiService
					.getFacultatiViewListDescendente();

			if (tbasg111FacultatiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg111FacultatiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFacultatiViewListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-facultati-active-list-ascendente")
	public ResponseEntity<List<Tbasg111FacultatiDto>> getFacultatiActiveListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg111FacultatiDto> tbasg111FacultatiDto = tbasg111FacultatiService
					.getFacultatiActiveListAscendente();

			if (tbasg111FacultatiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg111FacultatiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFacultatiActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-facultati-active-list-ascendente-ape1-ape2-nom")
	public ResponseEntity<List<Tbasg111FacultatiDto>> getFacultatiActiveListAscendenteApe1Ape2Nom() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg111FacultatiDto> tbasg111FacultatiDto = tbasg111FacultatiService
					.getFacultatiActiveListAscendenteApe1Ape2Nom();

			if (tbasg111FacultatiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg111FacultatiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFacultatiActiveListAscendenteApe1Ape2Nom []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-facultati-active-list-descendente")
	public ResponseEntity<List<Tbasg111FacultatiDto>> getFacultatiActiveListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg111FacultatiDto> tbasg111FacultatiDto = tbasg111FacultatiService
					.getFacultatiActiveListDescendente();

			if (tbasg111FacultatiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg111FacultatiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFacultatiActiveListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-facultati-count")
	public ResponseEntity<?> getFacultatiCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg111FacultatiDto> tbasg111FacultatiDto = tbasg111FacultatiService.getFacultatiCount();

			if (tbasg111FacultatiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg111FacultatiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFacultatiCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-facultati")
	public ResponseEntity<?> insertFacultati(@RequestBody Tbasg111Facultati bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg111FacultatiDto = tbasg111FacultatiService.insertFacultati(bean);
			return new ResponseEntity<>(tbasg111FacultatiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertFacultati []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-facultati")
	public ResponseEntity<?> updateFacultati(@RequestBody Tbasg111Facultati bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg111FacultatiDto = tbasg111FacultatiService.updateFacultati(bean);
			return new ResponseEntity<>(tbasg111FacultatiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateFacultati []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-facultati")
	public ResponseEntity<?> estadoFacultati(@RequestBody Tbasg111Facultati bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg111FacultatiDto = tbasg111FacultatiService.estadoFacultati(bean);
			return new ResponseEntity<>(tbasg111FacultatiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoFacultati []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
