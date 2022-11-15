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

import renfe.com.model.dto.Tbasg257AlcanauxcabDto;
import renfe.com.model.entity.Tbasg257Alcanauxcab;
import renfe.com.service.Tbasg257AlcanauxcabService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg257Alcanauxcab")
public class Tbasg257AlcanauxcabController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg257AlcanauxcabService tbasg257AlcanauxcabService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg257AlcanauxcabDto>> getAllTbasg257Alcanauxcab(Tbasg257AlcanauxcabDto filter) {
		return new ResponseEntity<>(tbasg257AlcanauxcabService.getAllTbasg257Alcanauxcab(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoAlcanauxcab}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoAlcanauxcab") Integer cdgoAlcanauxcab) {
		Tbasg257AlcanauxcabDto tbasg257AlcanauxcabData = tbasg257AlcanauxcabService
				.findByCdgoAlcanauxcab(cdgoAlcanauxcab);

		if (tbasg257AlcanauxcabData != null) {
			return new ResponseEntity<>(tbasg257AlcanauxcabData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg257AlcanauxcabDto> createTbasg257Alcanauxcab(
			@RequestBody Tbasg257AlcanauxcabDto tbasg257AlcanauxcabDto) {
		try {
			return new ResponseEntity<>(tbasg257AlcanauxcabService.createTbasg257Alcanauxcab(tbasg257AlcanauxcabDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg257Alcanauxcab {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoAlcanauxcab}")
	public ResponseEntity<Tbasg257AlcanauxcabDto> updateTbasg257Alcanauxcab(
			@PathVariable("cdgoAlcanauxcab") Integer cdgo, @RequestBody Tbasg257AlcanauxcabDto body) {
		try {
			Tbasg257AlcanauxcabDto tbasg257AlcanauxcabData = tbasg257AlcanauxcabService.updateTbasg257Alcanauxcab(cdgo,
					body);
			if (tbasg257AlcanauxcabData != null) {
				return new ResponseEntity<>(tbasg257AlcanauxcabData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg257Alcanauxcab []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoAlcanauxcab}")
	public ResponseEntity<HttpStatus> deleteTbasg257Alcanauxcab(
			@PathVariable("cdgoAlcanauxcab") Integer cdgoAlcanauxcab) {
		try {
			tbasg257AlcanauxcabService.deleteTbasg257Alcanauxcab(cdgoAlcanauxcab);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg257Alcanauxcab []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg257AlcanauxcabDto>> findByCdgoAlcanauxcabIn(List<Integer> cdgoAlcanauxcab) {
		try {
			List<Tbasg257AlcanauxcabDto> tbasg257AlcanauxcabDto = tbasg257AlcanauxcabService
					.findByCdgoAlcanauxcabIn(cdgoAlcanauxcab);

			if (tbasg257AlcanauxcabDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg257AlcanauxcabDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoAlcanauxcabIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-aux-cab-count")
	public ResponseEntity<?> getAuxCabCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg257AlcanauxcabDto> tbasg257AlcanauxcabDto = tbasg257AlcanauxcabService.getAuxCabCount();

			if (tbasg257AlcanauxcabDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg257AlcanauxcabDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAuxCabCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-aux-cab-list-ascendente")
	public ResponseEntity<List<Tbasg257AlcanauxcabDto>> getAuxCabListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg257AlcanauxcabDto> tbasg257AlcanauxcabDto = tbasg257AlcanauxcabService.getAuxCabListAscendente();

			if (tbasg257AlcanauxcabDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg257AlcanauxcabDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAuxCabListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-aux-cab-list-descendente")
	public ResponseEntity<List<Tbasg257AlcanauxcabDto>> getAuxCabListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg257AlcanauxcabDto> tbasg257AlcanauxcabDto = tbasg257AlcanauxcabService.getAuxCabListDescendente();

			if (tbasg257AlcanauxcabDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg257AlcanauxcabDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAuxCabListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-aux-cab")
	public ResponseEntity<List<Tbasg257AlcanauxcabDto>> getAuxCab(String cdgoAlcanauxcab) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg257AlcanauxcabDto> tbasg257AlcanauxcabDto = tbasg257AlcanauxcabService.getAuxCab(cdgoAlcanauxcab);

			if (tbasg257AlcanauxcabDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg257AlcanauxcabDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAuxCab []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-aux-cab-nombre")
	public ResponseEntity<List<Tbasg257AlcanauxcabDto>> getAuxCabNombre(String cdgoAlcanauxcab) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg257AlcanauxcabDto> tbasg257AlcanauxcabDto = tbasg257AlcanauxcabService.getAuxCabNombre(cdgoAlcanauxcab);

			if (tbasg257AlcanauxcabDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg257AlcanauxcabDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAuxCab []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-aux-cab-active-list")
	public ResponseEntity<List<Tbasg257AlcanauxcabDto>> getAuxCabActiveList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg257AlcanauxcabDto> tbasg257AlcanauxcabDto = tbasg257AlcanauxcabService.getAuxCabActiveList();

			if (tbasg257AlcanauxcabDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg257AlcanauxcabDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAuxCabActiveList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-aux-cab")
	public ResponseEntity<?> insertAuxCab(@RequestBody Tbasg257Alcanauxcab bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg257AlcanauxcabDto = tbasg257AlcanauxcabService.insertAuxCab(bean);
			return new ResponseEntity<>(tbasg257AlcanauxcabDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertAuxCab []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-aux-cab")
	public ResponseEntity<?> updateAuxCab(@RequestBody Tbasg257Alcanauxcab bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg257AlcanauxcabDto = tbasg257AlcanauxcabService.updateAuxCab(bean);
			return new ResponseEntity<>(tbasg257AlcanauxcabDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateAuxCab []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-aux-cab")
	public ResponseEntity<?> estadoAuxCab(@RequestBody Tbasg257Alcanauxcab bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg257AlcanauxcabDto = tbasg257AlcanauxcabService.estadoAuxCab(bean);
			return new ResponseEntity<>(tbasg257AlcanauxcabDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoAuxCab []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
