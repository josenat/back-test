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

import renfe.com.model.dto.Tbasg182AltaEstacionDto;
import renfe.com.model.entity.Tbasg182AltaEstacion;
import renfe.com.service.Tbasg182AltaEstacionService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg182AltaEstacion")
public class Tbasg182AltaEstacionController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg182AltaEstacionService tbasg182AltaEstacionService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg182AltaEstacionDto>> getAllTbasg182AltaEstacion(Tbasg182AltaEstacionDto filter) {
		return new ResponseEntity<>(tbasg182AltaEstacionService.getAllTbasg182AltaEstacion(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoEstacion}/{cdgoLinea}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoEstacion") String cdgoEstacion,
			@PathVariable("cdgoLinea") String cdgoLinea) {
		Tbasg182AltaEstacionDto tbasg182AltaEstacionData = tbasg182AltaEstacionService
				.findByCdgoEstacionCdgoLinea(cdgoEstacion, cdgoLinea);

		if (tbasg182AltaEstacionData != null) {
			return new ResponseEntity<>(tbasg182AltaEstacionData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg182AltaEstacionDto> createTbasg182AltaEstacion(
			@RequestBody Tbasg182AltaEstacionDto tbasg182AltaEstacionDto) {
		try {
			return new ResponseEntity<>(tbasg182AltaEstacionService.createTbasg182AltaEstacion(tbasg182AltaEstacionDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg182AltaEstacion {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoEstacion}/{cdgoLinea}")
	public ResponseEntity<Tbasg182AltaEstacionDto> updateTbasg182AltaEstacion(
			@PathVariable("cdgoEstacion") String cdgoEstacion, @PathVariable("cdgoLinea") String cdgoLinea,
			@RequestBody Tbasg182AltaEstacionDto tbasg182AltaEstacionDto) {
		try {
			Tbasg182AltaEstacionDto tbasg182AltaEstacionData = tbasg182AltaEstacionService
					.updateTbasg182AltaEstacion(cdgoEstacion, cdgoLinea, tbasg182AltaEstacionDto);
			if (tbasg182AltaEstacionData != null) {
				return new ResponseEntity<>(tbasg182AltaEstacionData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg182AltaEstacion []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoEstacion}/{cdgoLinea}")
	public ResponseEntity<HttpStatus> deleteTbasg182AltaEstacion(@PathVariable("cdgoEstacion") String cdgoEstacion,
			@PathVariable("cdgoLinea") String cdgoLinea) {
		try {
			tbasg182AltaEstacionService.deleteTbasg182AltaEstacion(cdgoEstacion, cdgoLinea);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg182AltaEstacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg182AltaEstacionDto>> findByCdgoEstacionCdgoLineaIn(List<String> cdgoEstacion,
			List<String> cdgoLinea) {
		try {
			List<Tbasg182AltaEstacionDto> tbasg182AltaEstacionDto = tbasg182AltaEstacionService
					.findByCdgoEstacionCdgoLineaIn(cdgoEstacion, cdgoLinea);

			if (tbasg182AltaEstacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg182AltaEstacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoEstacionCdgoLineaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-alta-estacion")
	public ResponseEntity<List<Tbasg182AltaEstacionDto>> getAltaEstacion(String cdgoEstacion, String cdgoLinea) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg182AltaEstacionDto> tbasg182AltaEstacionDto = tbasg182AltaEstacionService
					.getAltaEstacion(cdgoEstacion, cdgoLinea);

			if (tbasg182AltaEstacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg182AltaEstacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAltaEstacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-alta-estacion")
	public ResponseEntity<?> insertAltaEstacion(Tbasg182AltaEstacion bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg182AltaEstacionDto = tbasg182AltaEstacionService.insertAltaEstacion(bean);
			return new ResponseEntity<>(tbasg182AltaEstacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertAltaEstacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
