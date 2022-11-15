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

import renfe.com.model.dto.Tbasg261SociedadesDto;
import renfe.com.model.entity.Tbasg261Sociedades;
import renfe.com.service.Tbasg261SociedadesService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg261Sociedades")
public class Tbasg261SociedadesController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg261SociedadesService tbasg261SociedadesService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg261SociedadesDto>> getAllTbasg261Sociedades(Tbasg261SociedadesDto filter) {
		return new ResponseEntity<>(tbasg261SociedadesService.getAllTbasg261Sociedades(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoSociedad}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoSociedad") String cdgoSociedad) {
		Tbasg261SociedadesDto tbasg261SociedadesData = tbasg261SociedadesService.findByCdgoSociedad(cdgoSociedad);

		if (tbasg261SociedadesData != null) {
			return new ResponseEntity<>(tbasg261SociedadesData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg261SociedadesDto> createTbasg261Sociedades(
			@RequestBody Tbasg261SociedadesDto tbasg261SociedadesDto) {
		try {
			return new ResponseEntity<>(tbasg261SociedadesService.createTbasg261Sociedades(tbasg261SociedadesDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg261Sociedades {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoSociedad}")
	public ResponseEntity<Tbasg261SociedadesDto> updateTbasg261Sociedades(
			@PathVariable("cdgoSociedad") String cdgoSociedad,
			@RequestBody Tbasg261SociedadesDto tbasg261SociedadesDto) {
		try {
			Tbasg261SociedadesDto tbasg261SociedadesData = tbasg261SociedadesService
					.updateTbasg261Sociedades(cdgoSociedad, tbasg261SociedadesDto);
			if (tbasg261SociedadesData != null) {
				return new ResponseEntity<>(tbasg261SociedadesData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg261Sociedades []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoSociedad}")
	public ResponseEntity<HttpStatus> deleteTbasg261Sociedades(@PathVariable("cdgoSociedad") String cdgoSociedad) {
		try {
			tbasg261SociedadesService.deleteTbasg261Sociedades(cdgoSociedad);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg261Sociedades []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg261SociedadesDto>> findByCdgoSociedadIn(List<String> cdgoSociedad) {
		try {
			List<Tbasg261SociedadesDto> tbasg261SociedadesDto = tbasg261SociedadesService
					.findByCdgoSociedadIn(cdgoSociedad);

			if (tbasg261SociedadesDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg261SociedadesDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoSociedadIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sociedad-count")
	public ResponseEntity<?> getSociedadCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg261SociedadesDto> tbasg261SociedadesDto = tbasg261SociedadesService.getSociedadCount();

			if (tbasg261SociedadesDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg261SociedadesDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSociedadCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sociedad-list-ascendente")
	public ResponseEntity<List<Tbasg261SociedadesDto>> getSociedadListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg261SociedadesDto> tbasg261SociedadesDto = tbasg261SociedadesService.getSociedadListAscendente();

			if (tbasg261SociedadesDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg261SociedadesDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSociedadListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-sociedad-active-list-ascendente")
	public ResponseEntity<List<Tbasg261SociedadesDto>> getSociedadActiveListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg261SociedadesDto> tbasg261SociedadesDto = tbasg261SociedadesService.getSociedadActiveListAscendente();

			if (tbasg261SociedadesDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg261SociedadesDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSociedadActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sociedad-list-descendente")
	public ResponseEntity<List<Tbasg261SociedadesDto>> getSociedadListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg261SociedadesDto> tbasg261SociedadesDto = tbasg261SociedadesService.getSociedadListDescendente();

			if (tbasg261SociedadesDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg261SociedadesDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSociedadListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sociedad")
	public ResponseEntity<List<Tbasg261SociedadesDto>> getSociedad(String cdgoSociedad) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg261SociedadesDto> tbasg261SociedadesDto = tbasg261SociedadesService.getSociedad(cdgoSociedad);

			if (tbasg261SociedadesDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg261SociedadesDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSociedad []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sociedad-by-nombre")
	public ResponseEntity<?> getSociedadByNombre(String descSociedad) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg261SociedadesDto> tbasg261SociedadesDto = tbasg261SociedadesService
					.getSociedadByNombre(descSociedad);

			if (tbasg261SociedadesDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg261SociedadesDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSociedadByNombre []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sociedad-list-active")
	public ResponseEntity<List<Tbasg261SociedadesDto>> getSociedadListActive() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg261SociedadesDto> tbasg261SociedadesDto = tbasg261SociedadesService.getSociedadListActive();

			if (tbasg261SociedadesDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg261SociedadesDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSociedadListActive []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-sociedad")
	public ResponseEntity<?> insertSociedad(@RequestBody Tbasg261Sociedades bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg261SociedadesDto = tbasg261SociedadesService.insertSociedad(bean);
			return new ResponseEntity<>(tbasg261SociedadesDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertSociedad []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-sociedad")
	public ResponseEntity<?> updateSociedad(@RequestBody Tbasg261Sociedades bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg261SociedadesDto = tbasg261SociedadesService.updateSociedad(bean);
			return new ResponseEntity<>(tbasg261SociedadesDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateSociedad []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-sociedad")
	public ResponseEntity<?> estadoSociedad(@RequestBody Tbasg261Sociedades bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg261SociedadesDto = tbasg261SociedadesService.estadoSociedad(bean);
			return new ResponseEntity<>(tbasg261SociedadesDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoSociedad []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
