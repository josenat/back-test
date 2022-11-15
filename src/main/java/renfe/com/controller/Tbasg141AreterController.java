package renfe.com.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import renfe.com.dto.GetAreTerListAscendenteDTO;
import renfe.com.model.dto.Tbasg141AreterDto;
import renfe.com.model.entity.Tbasg141Areter;
import renfe.com.service.Tbasg141AreterService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg141Areter")
public class Tbasg141AreterController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg141AreterService tbasg141AreterService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg141AreterDto>> getAllTbasg141Areter(Tbasg141AreterDto filter) {
		return new ResponseEntity<>(tbasg141AreterService.getAllTbasg141Areter(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoAreter}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoAreter") Integer cdgoAreter) {
		Tbasg141AreterDto tbasg141AreterData = tbasg141AreterService.findByCdgoAreter(cdgoAreter);

		if (tbasg141AreterData != null) {
			return new ResponseEntity<>(tbasg141AreterData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg141AreterDto> createTbasg141Areter(@RequestBody Tbasg141AreterDto tbasg141AreterDto) {
		try {
			return new ResponseEntity<>(tbasg141AreterService.createTbasg141Areter(tbasg141AreterDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg141Areter {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoAreter}")
	public ResponseEntity<Tbasg141AreterDto> updateTbasg141Areter(@PathVariable("cdgoAreter") Integer cdgo,
			@RequestBody Tbasg141AreterDto body) {
		try {
			Tbasg141AreterDto tbasg141AreterData = tbasg141AreterService.updateTbasg141Areter(cdgo, body);
			if (tbasg141AreterData != null) {
				return new ResponseEntity<>(tbasg141AreterData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg141Areter []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoAreter}")
	public ResponseEntity<HttpStatus> deleteTbasg141Areter(@PathVariable("cdgoAreter") Integer cdgoAreter) {
		try {
			tbasg141AreterService.deleteTbasg141Areter(cdgoAreter);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg141Areter []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg141AreterDto>> findByCdgoAreterIn(List<Integer> cdgoAreter) {
		try {
			List<Tbasg141AreterDto> tbasg141AreterDto = tbasg141AreterService.findByCdgoAreterIn(cdgoAreter);

			if (tbasg141AreterDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg141AreterDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoAreterIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-ter-count")
	public ResponseEntity<?> getAreTerCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg141AreterDto> tbasg141AreterDto = tbasg141AreterService.getAreTerCount();

			if (tbasg141AreterDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg141AreterDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreTerCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-ter-list-descendente-c-d-g-o_-a-r-e-t-e-r")
	public ResponseEntity<List<Tbasg141AreterDto>> getAreTerListDescendenteCDGO_ARETER(Integer cdgoAreAct) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg141AreterDto> tbasg141AreterDto = tbasg141AreterService.getAreTerListDescendenteCDGO_ARETER(cdgoAreAct);

			if (tbasg141AreterDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg141AreterDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreTerListDescendenteCDGO_ARETER []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-ter-list-ascendente-d-e-s-g_-n-o-m-b-r-e")
	public ResponseEntity<List<Tbasg141AreterDto>> getAreTerListAscendenteDESG_NOMBRE() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg141AreterDto> tbasg141AreterDto = tbasg141AreterService.getAreTerListAscendenteDESG_NOMBRE();

			if (tbasg141AreterDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg141AreterDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreTerListAscendenteDESG_NOMBRE []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-are-ter-list-ascendente")
	public ResponseEntity<List<GetAreTerListAscendenteDTO>> getAreTerListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<GetAreTerListAscendenteDTO> tbasg141AreterDto = tbasg141AreterService.getAreTerListAscendente();

			if (tbasg141AreterDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg141AreterDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreTerListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-are-ter-active-list-ascendente")
	public ResponseEntity<List<GetAreTerListAscendenteDTO>> getAreTerActiveListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<GetAreTerListAscendenteDTO> tbasg141AreterDto = tbasg141AreterService.getAreTerActiveListAscendente();

			if (tbasg141AreterDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg141AreterDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreTerActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-ter-list-descendente-d-e-s-g_-n-o-m-b-r-e")
	public ResponseEntity<List<Tbasg141AreterDto>> getAreTerListDescendenteDESG_NOMBRE() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg141AreterDto> tbasg141AreterDto = tbasg141AreterService.getAreTerListDescendenteDESG_NOMBRE();

			if (tbasg141AreterDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg141AreterDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreTerListDescendenteDESG_NOMBRE []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-ter-active-list-descendente-c-d-g-o_-a-r-e-t-e-r")
	public ResponseEntity<List<Tbasg141AreterDto>> getAreTerActiveListDescendenteCDGO_ARETER() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg141AreterDto> tbasg141AreterDto = tbasg141AreterService
					.getAreTerActiveListDescendenteCDGO_ARETER();

			if (tbasg141AreterDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg141AreterDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreTerActiveListDescendenteCDGO_ARETER []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-ter-active-list-ascendente-d-e-s-g_-n-o-m-b-r-e")
	public ResponseEntity<List<Tbasg141AreterDto>> getAreTerActiveListAscendenteDESG_NOMBRE() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg141AreterDto> tbasg141AreterDto = tbasg141AreterService
					.getAreTerActiveListAscendenteDESG_NOMBRE();

			if (tbasg141AreterDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg141AreterDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreTerActiveListAscendenteDESG_NOMBRE []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-ter-active-list-descendente-d-e-s-g_-n-o-m-b-r-e")
	public ResponseEntity<List<Tbasg141AreterDto>> getAreTerActiveListDescendenteDESG_NOMBRE() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg141AreterDto> tbasg141AreterDto = tbasg141AreterService
					.getAreTerActiveListDescendenteDESG_NOMBRE();

			if (tbasg141AreterDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg141AreterDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreTerActiveListDescendenteDESG_NOMBRE []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-ter-active-list-by-cdgo-areact/{cdgoAreact}")
	public ResponseEntity<List<Tbasg141AreterDto>> getAreTerActiveListByCdgoAreact(@PathVariable("cdgoAreact") Integer cdgoAreact) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg141AreterDto> tbasg141AreterDto = tbasg141AreterService.getAreTerActiveListByCdgoAreact(cdgoAreact);
			if (tbasg141AreterDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tbasg141AreterDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("getAreTerActiveListByCdgoAreact []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	

	@GetMapping("/get-are-ter")
	public ResponseEntity<List<Tbasg141AreterDto>> getAreTer(String cdgoAreter) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg141AreterDto> tbasg141AreterDto = tbasg141AreterService.getAreTer(cdgoAreter);

			if (tbasg141AreterDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg141AreterDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreTer []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-list-are-ter-by-cods-are-ter")

	public ResponseEntity<List<Tbasg141AreterDto>> getListAreTerByCodsAreTer(@RequestParam List<Integer>cdgoAreTerList) {

		// Generated from a SELECT found in an XML
		try {

			List<Tbasg141AreterDto> tbasg141AreterDto = tbasg141AreterService.getListAreTerByCodsAreTer(cdgoAreTerList);


			if (tbasg141AreterDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg141AreterDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getListAreTerByCodsAreTer []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-are-ter")
	public ResponseEntity<?> insertAreTer(@RequestBody Tbasg141Areter bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg141AreterDto = tbasg141AreterService.insertAreTer(bean);
			return new ResponseEntity<>(tbasg141AreterDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertAreTer []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-are-ter")
	public ResponseEntity<?> updateAreTer(@RequestBody Tbasg141Areter bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg141AreterDto = tbasg141AreterService.updateAreTer(bean);
			return new ResponseEntity<>(tbasg141AreterDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateAreTer []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-are-ter")
	public ResponseEntity<?> estadoAreTer(@RequestBody Tbasg141Areter bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg141AreterDto = tbasg141AreterService.estadoAreTer(bean);
			return new ResponseEntity<>(tbasg141AreterDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoAreTer []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/desc-area-act-persona")
	public ResponseEntity<?> descAreaActPersona(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg141AreterDto> tbasg141AreterDto = tbasg141AreterService.descAreaActPersona(cdgoPersona);

			if (tbasg141AreterDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg141AreterDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("descAreaActPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
