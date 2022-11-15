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

import renfe.com.model.dto.Tbasg168AnotacionInspectorDto;
import renfe.com.service.Tbasg168AnotacionInspectorService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg168AnotacionInspector")
public class Tbasg168AnotacionInspectorController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg168AnotacionInspectorService tbasg168AnotacionInspectorService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg168AnotacionInspectorDto>> getAllTbasg168AnotacionInspector(
			Tbasg168AnotacionInspectorDto filter) {
		return new ResponseEntity<>(tbasg168AnotacionInspectorService.getAllTbasg168AnotacionInspector(filter),
				HttpStatus.OK);
	}

	@GetMapping("/{cdgoAnotacion}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoAnotacion") Integer cdgoAnotacion) {
		Tbasg168AnotacionInspectorDto tbasg168AnotacionInspectorData = tbasg168AnotacionInspectorService
				.findByCdgoAnotacion(cdgoAnotacion);

		if (tbasg168AnotacionInspectorData != null) {
			return new ResponseEntity<>(tbasg168AnotacionInspectorData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg168AnotacionInspectorDto> createTbasg168AnotacionInspector(
			@RequestBody Tbasg168AnotacionInspectorDto tbasg168AnotacionInspectorDto) {
		try {
			return new ResponseEntity<>(
					tbasg168AnotacionInspectorService.createTbasg168AnotacionInspector(tbasg168AnotacionInspectorDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg168AnotacionInspector {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoAnotacion}")
	public ResponseEntity<Tbasg168AnotacionInspectorDto> updateTbasg168AnotacionInspector(
			@PathVariable("cdgoAnotacion") Integer cdgo, @RequestBody Tbasg168AnotacionInspectorDto body) {
		try {
			Tbasg168AnotacionInspectorDto tbasg168AnotacionInspectorData = tbasg168AnotacionInspectorService
					.updateTbasg168AnotacionInspector(cdgo, body);
			if (tbasg168AnotacionInspectorData != null) {
				return new ResponseEntity<>(tbasg168AnotacionInspectorData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg168AnotacionInspector []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoAnotacion}")
	public ResponseEntity<HttpStatus> deleteTbasg168AnotacionInspector(
			@PathVariable("cdgoAnotacion") Integer cdgoAnotacion) {
		try {
			tbasg168AnotacionInspectorService.deleteTbasg168AnotacionInspector(cdgoAnotacion);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg168AnotacionInspector []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg168AnotacionInspectorDto>> findByCdgoAnotacionIn(List<Integer> cdgoAnotacion) {
		try {
			List<Tbasg168AnotacionInspectorDto> tbasg168AnotacionInspectorDto = tbasg168AnotacionInspectorService
					.findByCdgoAnotacionIn(cdgoAnotacion);

			if (tbasg168AnotacionInspectorDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg168AnotacionInspectorDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoAnotacionIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-anotacion-inspector-list")
	public ResponseEntity<?> getAnotacionInspectorList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg168AnotacionInspectorDto> tbasg168AnotacionInspectorDto = tbasg168AnotacionInspectorService
					.getAnotacionInspectorList();

			if (tbasg168AnotacionInspectorDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg168AnotacionInspectorDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAnotacionInspectorList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-anotacion-inspector-list-count")
	public ResponseEntity<?> getAnotacionInspectorListCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg168AnotacionInspectorDto> tbasg168AnotacionInspectorDto = tbasg168AnotacionInspectorService
					.getAnotacionInspectorListCount();

			if (tbasg168AnotacionInspectorDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg168AnotacionInspectorDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAnotacionInspectorListCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-anotacion-inspector-by-cdgo-anotacion")
	public ResponseEntity<?> getAnotacionInspectorByCdgoAnotacion(String cdgoAnotacion) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg168AnotacionInspectorDto> tbasg168AnotacionInspectorDto = tbasg168AnotacionInspectorService
					.getAnotacionInspectorByCdgoAnotacion(cdgoAnotacion);

			if (tbasg168AnotacionInspectorDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg168AnotacionInspectorDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAnotacionInspectorByCdgoAnotacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
