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

import renfe.com.model.dto.Tbasg183BajaEstacionDto;
import renfe.com.model.entity.Tbasg183BajaEstacion;
import renfe.com.service.Tbasg183BajaEstacionService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg183BajaEstacion")
public class Tbasg183BajaEstacionController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg183BajaEstacionService tbasg183BajaEstacionService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg183BajaEstacionDto>> getAllTbasg183BajaEstacion(Tbasg183BajaEstacionDto filter) {
		return new ResponseEntity<>(tbasg183BajaEstacionService.getAllTbasg183BajaEstacion(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoEstacion}/{cdgoLinea}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoEstacion") String cdgoEstacion,
			@PathVariable("cdgoLinea") String cdgoLinea) {
		Tbasg183BajaEstacionDto tbasg183BajaEstacionData = tbasg183BajaEstacionService
				.findByCdgoEstacionCdgoLinea(cdgoEstacion, cdgoLinea);

		if (tbasg183BajaEstacionData != null) {
			return new ResponseEntity<>(tbasg183BajaEstacionData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg183BajaEstacionDto> createTbasg183BajaEstacion(
			@RequestBody Tbasg183BajaEstacionDto tbasg183BajaEstacionDto) {
		try {
			return new ResponseEntity<>(tbasg183BajaEstacionService.createTbasg183BajaEstacion(tbasg183BajaEstacionDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg183BajaEstacion {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoEstacion}/{cdgoLinea}")
	public ResponseEntity<Tbasg183BajaEstacionDto> updateTbasg183BajaEstacion(
			@PathVariable("cdgoEstacion") String cdgoEstacion, @PathVariable("cdgoLinea") String cdgoLinea,
			@RequestBody Tbasg183BajaEstacionDto tbasg183BajaEstacionDto) {
		try {
			Tbasg183BajaEstacionDto tbasg183BajaEstacionData = tbasg183BajaEstacionService
					.updateTbasg183BajaEstacion(cdgoEstacion, cdgoLinea, tbasg183BajaEstacionDto);
			if (tbasg183BajaEstacionData != null) {
				return new ResponseEntity<>(tbasg183BajaEstacionData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg183BajaEstacion []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoEstacion}/{cdgoLinea}")
	public ResponseEntity<HttpStatus> deleteTbasg183BajaEstacion(@PathVariable("cdgoEstacion") String cdgoEstacion,
			@PathVariable("cdgoLinea") String cdgoLinea) {
		try {
			tbasg183BajaEstacionService.deleteTbasg183BajaEstacion(cdgoEstacion, cdgoLinea);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg183BajaEstacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg183BajaEstacionDto>> findByCdgoEstacionCdgoLineaIn(List<String> cdgoEstacion,
			List<String> cdgoLinea) {
		try {
			List<Tbasg183BajaEstacionDto> tbasg183BajaEstacionDto = tbasg183BajaEstacionService
					.findByCdgoEstacionCdgoLineaIn(cdgoEstacion, cdgoLinea);

			if (tbasg183BajaEstacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg183BajaEstacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoEstacionCdgoLineaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-baja-estacion")
	public ResponseEntity<List<Tbasg183BajaEstacionDto>> getBajaEstacion(String cdgoEstacion, String cdgoLinea) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg183BajaEstacionDto> tbasg183BajaEstacionDto = tbasg183BajaEstacionService
					.getBajaEstacion(cdgoEstacion, cdgoLinea);

			if (tbasg183BajaEstacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg183BajaEstacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getBajaEstacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-baja-estacion")
	public ResponseEntity<?> insertBajaEstacion(Tbasg183BajaEstacion bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg183BajaEstacionDto = tbasg183BajaEstacionService.insertBajaEstacion(bean);
			return new ResponseEntity<>(tbasg183BajaEstacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertBajaEstacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
