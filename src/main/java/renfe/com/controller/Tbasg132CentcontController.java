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

import renfe.com.dto.GetCentContListAscendenteeDTO;
import renfe.com.model.dto.Tbasg132CentcontDto;
import renfe.com.model.entity.Tbasg132Centcont;
import renfe.com.service.Tbasg132CentcontService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg132Centcont")
public class Tbasg132CentcontController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg132CentcontService tbasg132CentcontService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg132CentcontDto>> getAllTbasg132Centcont(Tbasg132CentcontDto filter) {
		return new ResponseEntity<>(tbasg132CentcontService.getAllTbasg132Centcont(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoCentcont}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoCentcont") String cdgoCentcont) {
		Tbasg132CentcontDto tbasg132CentcontData = tbasg132CentcontService.findByCdgoCentcont(cdgoCentcont);

		if (tbasg132CentcontData != null) {
			return new ResponseEntity<>(tbasg132CentcontData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg132CentcontDto> createTbasg132Centcont(
			@RequestBody Tbasg132CentcontDto tbasg132CentcontDto) {
		try {
			return new ResponseEntity<>(tbasg132CentcontService.createTbasg132Centcont(tbasg132CentcontDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg132Centcont {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoCentcont}")
	public ResponseEntity<Tbasg132CentcontDto> updateTbasg132Centcont(@PathVariable("cdgoCentcont") String cdgoCentcont,
			@RequestBody Tbasg132CentcontDto tbasg132CentcontDto) {
		try {
			Tbasg132CentcontDto tbasg132CentcontData = tbasg132CentcontService.updateTbasg132Centcont(cdgoCentcont,
					tbasg132CentcontDto);
			if (tbasg132CentcontData != null) {
				return new ResponseEntity<>(tbasg132CentcontData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg132Centcont []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoCentcont}")
	public ResponseEntity<HttpStatus> deleteTbasg132Centcont(@PathVariable("cdgoCentcont") String cdgoCentcont) {
		try {
			tbasg132CentcontService.deleteTbasg132Centcont(cdgoCentcont);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg132Centcont []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg132CentcontDto>> findByCdgoCentcontIn(List<String> cdgoCentcont) {
		try {
			List<Tbasg132CentcontDto> tbasg132CentcontDto = tbasg132CentcontService.findByCdgoCentcontIn(cdgoCentcont);

			if (tbasg132CentcontDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg132CentcontDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoCentcontIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-cont-list-registro-ascendente")
	public ResponseEntity<?> getCentContListRegistroAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg132CentcontDto> tbasg132CentcontDto = tbasg132CentcontService.getCentContListRegistroAscendente();

			if (tbasg132CentcontDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg132CentcontDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentContListRegistroAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-cont-list-registro-descendente")
	public ResponseEntity<?> getCentContListRegistroDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg132CentcontDto> tbasg132CentcontDto = tbasg132CentcontService
					.getCentContListRegistroDescendente();

			if (tbasg132CentcontDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg132CentcontDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentContListRegistroDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-cont-count")
	public ResponseEntity<?> getCentContCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg132CentcontDto> tbasg132CentcontDto = tbasg132CentcontService.getCentContCount();

			if (tbasg132CentcontDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg132CentcontDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentContCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-cont-list-ascendente")
	public ResponseEntity<List<Tbasg132CentcontDto>> getCentContListAscendente(String cdgoAreTer) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg132CentcontDto> tbasg132CentcontDto = tbasg132CentcontService.getCentContListAscendente(cdgoAreTer);

			if (tbasg132CentcontDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg132CentcontDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentContListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-cent-cont-list-ascendentee")
	public ResponseEntity<List<GetCentContListAscendenteeDTO>> getCentContListAscendentee() {
		// Generated from a SELECT found in an XML
		try {
			List<GetCentContListAscendenteeDTO> tbasg132CentcontDto = tbasg132CentcontService.getCentContListAscendentee();

			if (tbasg132CentcontDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg132CentcontDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentContListAscendentee []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-cont-list-descendente")
	public ResponseEntity<List<Tbasg132CentcontDto>> getCentContListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg132CentcontDto> tbasg132CentcontDto = tbasg132CentcontService.getCentContListDescendente();

			if (tbasg132CentcontDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg132CentcontDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentContListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-cont-list-ascendente-d-e-s-g_-n-o-m-b-r-e_-p-m-g")
	public ResponseEntity<List<Tbasg132CentcontDto>> getCentContListAscendenteDESG_NOMBRE_PMG() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg132CentcontDto> tbasg132CentcontDto = tbasg132CentcontService
					.getCentContListAscendenteDESG_NOMBRE_PMG();

			if (tbasg132CentcontDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg132CentcontDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentContListAscendenteDESG_NOMBRE_PMG []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-cont-list-descendente-d-e-s-g_-n-o-m-b-r-e_-p-m-g")
	public ResponseEntity<List<Tbasg132CentcontDto>> getCentContListDescendenteDESG_NOMBRE_PMG() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg132CentcontDto> tbasg132CentcontDto = tbasg132CentcontService
					.getCentContListDescendenteDESG_NOMBRE_PMG();

			if (tbasg132CentcontDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg132CentcontDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentContListDescendenteDESG_NOMBRE_PMG []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-cont-list-ascendente-c-d-g-o_-c-e-n-t-c-o-n-t")
	public ResponseEntity<List<Tbasg132CentcontDto>> getCentContListAscendenteCDGO_CENTCONT() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg132CentcontDto> tbasg132CentcontDto = tbasg132CentcontService
					.getCentContListAscendenteCDGO_CENTCONT();

			if (tbasg132CentcontDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg132CentcontDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentContListAscendenteCDGO_CENTCONT []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-cont-list-descendente-c-d-g-o_-c-e-n-t-c-o-n-t")
	public ResponseEntity<List<Tbasg132CentcontDto>> getCentContListDescendenteCDGO_CENTCONT() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg132CentcontDto> tbasg132CentcontDto = tbasg132CentcontService
					.getCentContListDescendenteCDGO_CENTCONT();

			if (tbasg132CentcontDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg132CentcontDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentContListDescendenteCDGO_CENTCONT []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-cont-list-by-cdgo-areter/{cdgoAreter}")
	public ResponseEntity<List<Tbasg132CentcontDto>> getCentContListByCdgoAreter(@PathVariable("cdgoAreter") Integer cdgoAreter) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg132CentcontDto> tbasg132CentcontDto = tbasg132CentcontService.getCentContListByCdgoAreter(cdgoAreter);
			if (tbasg132CentcontDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg132CentcontDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("---> getCentContListByCdgoAreter []", e);
			logger.debug("---> getCentContListByCdgoAreter param: {}",cdgoAreter);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	

	@GetMapping("/get-cent-cont-list-ascendente-d-e-s-g_-n-o-m-b-r-e")
	public ResponseEntity<List<Tbasg132CentcontDto>> getCentContListAscendenteDESG_NOMBRE() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg132CentcontDto> tbasg132CentcontDto = tbasg132CentcontService
					.getCentContListAscendenteDESG_NOMBRE();

			if (tbasg132CentcontDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg132CentcontDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentContListAscendenteDESG_NOMBRE []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-cont-list-descendente-d-e-s-g_-n-o-m-b-r-e")
	public ResponseEntity<List<Tbasg132CentcontDto>> getCentContListDescendenteDESG_NOMBRE() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg132CentcontDto> tbasg132CentcontDto = tbasg132CentcontService
					.getCentContListDescendenteDESG_NOMBRE();

			if (tbasg132CentcontDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg132CentcontDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentContListDescendenteDESG_NOMBRE []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-cont")
	public ResponseEntity<List<Tbasg132CentcontDto>> getCentCont(String cdgoCentcont) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg132CentcontDto> tbasg132CentcontDto = tbasg132CentcontService.getCentCont(cdgoCentcont);

			if (tbasg132CentcontDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg132CentcontDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentCont []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-list-cent-cont-active")
	public ResponseEntity<List<Tbasg132CentcontDto>> getListCentContActive(Integer cdgoAreTer) {
		// Generated from a SELECT found in an XML
		try {

			List<Tbasg132CentcontDto> tbasg132CentcontDto = tbasg132CentcontService.getListCentContActive(cdgoAreTer);

			if (tbasg132CentcontDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg132CentcontDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getListCentContActive []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-cent-cont")
	public ResponseEntity<?> insertCentCont(@RequestBody Tbasg132Centcont bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg132CentcontDto = tbasg132CentcontService.insertCentCont(bean);
			return new ResponseEntity<>(tbasg132CentcontDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertCentCont []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-cent-cont")
	public ResponseEntity<?> updateCentCont(@RequestBody Tbasg132Centcont bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg132CentcontDto = tbasg132CentcontService.updateCentCont(bean);
			return new ResponseEntity<>(tbasg132CentcontDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateCentCont []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-cent-cont")
	public ResponseEntity<?> estadoCentCont(@RequestBody Tbasg132Centcont bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg132CentcontDto = tbasg132CentcontService.estadoCentCont(bean);
			return new ResponseEntity<>(tbasg132CentcontDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoCentCont []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
