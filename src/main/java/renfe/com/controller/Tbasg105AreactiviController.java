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

import renfe.com.dto.GetAreActiviListAscendenteDTO;
import renfe.com.dto.GetAreActiviListComboDTO;
import renfe.com.dto.GetSociedadesByCodAreaActivListDTO;
import renfe.com.model.dto.Tbasg105AreactiviDto;
import renfe.com.model.entity.Tbasg105Areactivi;
import renfe.com.service.Tbasg105AreactiviService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg105Areactivi")
public class Tbasg105AreactiviController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg105AreactiviService tbasg105AreactiviService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg105AreactiviDto>> getAllTbasg105Areactivi(Tbasg105AreactiviDto filter) {
		return new ResponseEntity<>(tbasg105AreactiviService.getAllTbasg105Areactivi(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoAreact}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoAreact") Integer cdgoAreact) {
		Tbasg105AreactiviDto tbasg105AreactiviData = tbasg105AreactiviService.findByCdgoAreact(cdgoAreact);

		if (tbasg105AreactiviData != null) {
			return new ResponseEntity<>(tbasg105AreactiviData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg105AreactiviDto> createTbasg105Areactivi(
			@RequestBody Tbasg105AreactiviDto tbasg105AreactiviDto) {
		try {
			return new ResponseEntity<>(tbasg105AreactiviService.createTbasg105Areactivi(tbasg105AreactiviDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg105Areactivi {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoAreact}")
	public ResponseEntity<Tbasg105AreactiviDto> updateTbasg105Areactivi(@PathVariable("cdgoAreact") Integer cdgo,
			@RequestBody Tbasg105AreactiviDto body) {
		try {
			Tbasg105AreactiviDto tbasg105AreactiviData = tbasg105AreactiviService.updateTbasg105Areactivi(cdgo, body);
			if (tbasg105AreactiviData != null) {
				return new ResponseEntity<>(tbasg105AreactiviData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg105Areactivi []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoAreact}")
	public ResponseEntity<HttpStatus> deleteTbasg105Areactivi(@PathVariable("cdgoAreact") Integer cdgoAreact) {
		try {
			tbasg105AreactiviService.deleteTbasg105Areactivi(cdgoAreact);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg105Areactivi []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-areact-all-list")
	public ResponseEntity<List<Tbasg105AreactiviDto>> getAllAreAct() {
		try {
			List<Tbasg105AreactiviDto> tbasg105AreactiviDto = tbasg105AreactiviService.getAllAreAct();

			if (tbasg105AreactiviDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAllAreAct {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg105AreactiviDto>> findByCdgoAreactIn(List<Integer> cdgoAreact) {
		try {
			List<Tbasg105AreactiviDto> tbasg105AreactiviDto = tbasg105AreactiviService.findByCdgoAreactIn(cdgoAreact);

			if (tbasg105AreactiviDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoAreactIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-activi-count")
	public ResponseEntity<?> getAreActiviCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg105AreactiviDto> tbasg105AreactiviDto = tbasg105AreactiviService.getAreActiviCount();

			if (tbasg105AreactiviDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreActiviCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-activi-list-combo")
	public ResponseEntity<List<GetAreActiviListComboDTO>> getAreActiviListCombo() {
		// Generated from a SELECT found in an XML
		try {
			List<GetAreActiviListComboDTO> tbasg105AreactiviDto = tbasg105AreactiviService.getAreActiviListCombo();

			if (tbasg105AreactiviDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreActiviListCombo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-activi-list-ascendente")
	public ResponseEntity<List<GetAreActiviListAscendenteDTO>> getAreActiviListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<GetAreActiviListAscendenteDTO> tbasg105AreactiviDto = tbasg105AreactiviService.getAreActiviListAscendente();

			if (tbasg105AreactiviDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreActiviListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-activi-list-descendente")
	public ResponseEntity<List<Tbasg105AreactiviDto>> getAreActiviListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg105AreactiviDto> tbasg105AreactiviDto = tbasg105AreactiviService.getAreActiviListDescendente();

			if (tbasg105AreactiviDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreActiviListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-activi-active-list-ascendente")
	public ResponseEntity<List<Tbasg105AreactiviDto>> getAreActiviActiveListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg105AreactiviDto> tbasg105AreactiviDto = tbasg105AreactiviService
					.getAreActiviActiveListAscendente();

			if (tbasg105AreactiviDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreActiviActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-activi-active-list-descendente")
	public ResponseEntity<List<Tbasg105AreactiviDto>> getAreActiviActiveListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg105AreactiviDto> tbasg105AreactiviDto = tbasg105AreactiviService
					.getAreActiviActiveListDescendente();

			if (tbasg105AreactiviDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreActiviActiveListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-activi-list-ascendente-d-e-s-g_-n-o-m-b-r-e")
	public ResponseEntity<List<Tbasg105AreactiviDto>> getAreActiviListAscendenteDESG_NOMBRE() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg105AreactiviDto> tbasg105AreactiviDto = tbasg105AreactiviService
					.getAreActiviListAscendenteDESG_NOMBRE();

			if (tbasg105AreactiviDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreActiviListAscendenteDESG_NOMBRE []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-activi-list-ascendente-selected-by-level")
	public ResponseEntity<List<Tbasg105AreactiviDto>> getAreActiviListAscendenteSelectedByLevel() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg105AreactiviDto> tbasg105AreactiviDto = tbasg105AreactiviService
					.getAreActiviListAscendenteSelectedByLevel();

			if (tbasg105AreactiviDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreActiviListAscendenteSelectedByLevel []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-activi-active-list-ascendente-d-e-s-g_-n-o-m-b-r-e")
	public ResponseEntity<List<Tbasg105AreactiviDto>> getAreActiviActiveListAscendenteDESG_NOMBRE() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg105AreactiviDto> tbasg105AreactiviDto = tbasg105AreactiviService
					.getAreActiviActiveListAscendenteDESG_NOMBRE();

			if (tbasg105AreactiviDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreActiviActiveListAscendenteDESG_NOMBRE []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-activi-active-list-descendente-d-e-s-g_-n-o-m-b-r-e")
	public ResponseEntity<List<Tbasg105AreactiviDto>> getAreActiviActiveListDescendenteDESG_NOMBRE() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg105AreactiviDto> tbasg105AreactiviDto = tbasg105AreactiviService
					.getAreActiviActiveListDescendenteDESG_NOMBRE();

			if (tbasg105AreactiviDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreActiviActiveListDescendenteDESG_NOMBRE []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-activi")
	public ResponseEntity<List<Tbasg105AreactiviDto>> getAreActivi(String cdgoAreact) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg105AreactiviDto> tbasg105AreactiviDto = tbasg105AreactiviService.getAreActivi(cdgoAreact);

			if (tbasg105AreactiviDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreActivi []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-activi-active-list-codes")
	public ResponseEntity<List<Tbasg105AreactiviDto>> getAreActiviActiveListCodes() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg105AreactiviDto> tbasg105AreactiviDto = tbasg105AreactiviService.getAreActiviActiveListCodes();

			if (tbasg105AreactiviDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreActiviActiveListCodes []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-activi-list-by-are-ter-list")

	public ResponseEntity<List<Tbasg105AreactiviDto>> getAreActiviListByAreTerList(@RequestParam List<Integer>estadosList) {

		// Generated from a SELECT found in an XML
		try {

			List<Tbasg105AreactiviDto> tbasg105AreactiviDto = tbasg105AreactiviService.getAreActiviListByAreTerList(estadosList);


			if (tbasg105AreactiviDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreActiviListByAreTerList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-activi-list-by-are-ter-list-all")
	public ResponseEntity<List<Tbasg105AreactiviDto>> getAreActiviListByAreTerListAll() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg105AreactiviDto> tbasg105AreactiviDto = tbasg105AreactiviService
					.getAreActiviListByAreTerListAll();

			if (tbasg105AreactiviDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreActiviListByAreTerListAll []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cod-are-activi-list-by-are-ter-list")
	public ResponseEntity<?> getCodAreActiviListByAreTerList() {
	// Generated from a SELECT found in an XML
	try {
	List<Tbasg105AreactiviDto> tbasg105AreactiviDto = tbasg105AreactiviService
	.getCodAreActiviListByAreTerList();
	
	
	
	if (tbasg105AreactiviDto.isEmpty()) {
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
	} catch (Exception e) {
	logger.error("getCodAreActiviListByAreTerList []", e);
	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}

	@PostMapping("/insert-are-activi")
	public ResponseEntity<?> insertAreActivi(@RequestBody Tbasg105Areactivi bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg105AreactiviDto = tbasg105AreactiviService.insertAreActivi(bean);
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertAreActivi []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-are-activi")
	public ResponseEntity<?> updateAreActivi(@RequestBody Tbasg105Areactivi bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg105AreactiviDto = tbasg105AreactiviService.updateAreActivi(bean);
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateAreActivi []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-are-activi")
	public ResponseEntity<?> estadoAreActivi(@RequestBody Tbasg105Areactivi bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg105AreactiviDto = tbasg105AreactiviService.estadoAreActivi(bean);
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoAreActivi []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-ter-list-ascendente-c-d-g-o_-a-r-e-t-e-r")
	public ResponseEntity<List<Tbasg105AreactiviDto>> getAreTerListAscendenteCDGO_ARETER() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg105AreactiviDto> tbasg105AreactiviDto = tbasg105AreactiviService
					.getAreTerListAscendenteCDGO_ARETER();

			if (tbasg105AreactiviDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreTerListAscendenteCDGO_ARETER []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-are-ter-active-list-ascendente-c-d-g-o_-a-r-e-t-e-r")
	public ResponseEntity<List<Tbasg105AreactiviDto>> getAreTerActiveListAscendenteCDGO_ARETER() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg105AreactiviDto> tbasg105AreactiviDto = tbasg105AreactiviService
					.getAreTerActiveListAscendenteCDGO_ARETER();

			if (tbasg105AreactiviDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAreTerActiveListAscendenteCDGO_ARETER []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sociedades-by-cod-area-activ")
	public ResponseEntity<List<Tbasg105AreactiviDto>> getSociedadesByCodAreaActiv(@RequestParam(value="listAreaActi") List<Integer> listAreaActi) {
		// Generated from a SELECT found in an XML
		try {
			System.out.println("Tamaño de la lista de actividades" +listAreaActi.size());
			List<Tbasg105AreactiviDto> tbasg105AreactiviDto = tbasg105AreactiviService.getSociedadesByCodAreaActiv(listAreaActi);

			if (tbasg105AreactiviDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSociedadesByCodAreaActiv []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/get-sociedades-by-cod-area-activ-all")
	public ResponseEntity<List<Tbasg105AreactiviDto>> getSociedadesByCodAreaActivAll() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg105AreactiviDto> tbasg105AreactiviDto = tbasg105AreactiviService.getSociedadesByCodAreaActivAll();

			if (tbasg105AreactiviDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSociedadesByCodAreaActivAll []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sociedades-by-cod-area-activ-list")
	public ResponseEntity<List<GetSociedadesByCodAreaActivListDTO>> getSociedadesByCodAreaActivList() {
		// Generated from a SELECT found in an XML
		try {
			List<GetSociedadesByCodAreaActivListDTO> tbasg105AreactiviDto = tbasg105AreactiviService.getSociedadesByCodAreaActivList();
			if (tbasg105AreactiviDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tbasg105AreactiviDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("---> getSociedadesByCodAreaActivList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	

}
