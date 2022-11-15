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

import renfe.com.model.dto.Tbasg192DocInfrGerenciaterrDto;
import renfe.com.service.Tbasg192DocInfrGerenciaterrService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg192DocInfrGerenciaterr")
public class Tbasg192DocInfrGerenciaterrController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg192DocInfrGerenciaterrService tbasg192DocInfrGerenciaterrService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg192DocInfrGerenciaterrDto>> getAllTbasg192DocInfrGerenciaterr(
			Tbasg192DocInfrGerenciaterrDto filter) {
		return new ResponseEntity<>(tbasg192DocInfrGerenciaterrService.getAllTbasg192DocInfrGerenciaterr(filter),
				HttpStatus.OK);
	}

	@GetMapping("/{cdgoGerencia}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoGerencia") Integer cdgoGerencia) {
		Tbasg192DocInfrGerenciaterrDto tbasg192DocInfrGerenciaterrData = tbasg192DocInfrGerenciaterrService
				.findByCdgoGerencia(cdgoGerencia);

		if (tbasg192DocInfrGerenciaterrData != null) {
			return new ResponseEntity<>(tbasg192DocInfrGerenciaterrData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg192DocInfrGerenciaterrDto> createTbasg192DocInfrGerenciaterr(
			@RequestBody Tbasg192DocInfrGerenciaterrDto tbasg192DocInfrGerenciaterrDto) {
		try {
			return new ResponseEntity<>(tbasg192DocInfrGerenciaterrService
					.createTbasg192DocInfrGerenciaterr(tbasg192DocInfrGerenciaterrDto), HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg192DocInfrGerenciaterr {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoGerencia}")
	public ResponseEntity<Tbasg192DocInfrGerenciaterrDto> updateTbasg192DocInfrGerenciaterr(
			@PathVariable("cdgoGerencia") Integer cdgo, @RequestBody Tbasg192DocInfrGerenciaterrDto body) {
		try {
			Tbasg192DocInfrGerenciaterrDto tbasg192DocInfrGerenciaterrData = tbasg192DocInfrGerenciaterrService
					.updateTbasg192DocInfrGerenciaterr(cdgo, body);
			if (tbasg192DocInfrGerenciaterrData != null) {
				return new ResponseEntity<>(tbasg192DocInfrGerenciaterrData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg192DocInfrGerenciaterr []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoGerencia}")
	public ResponseEntity<HttpStatus> deleteTbasg192DocInfrGerenciaterr(
			@PathVariable("cdgoGerencia") Integer cdgoGerencia) {
		try {
			tbasg192DocInfrGerenciaterrService.deleteTbasg192DocInfrGerenciaterr(cdgoGerencia);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg192DocInfrGerenciaterr []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg192DocInfrGerenciaterrDto>> findByCdgoGerenciaIn(List<Integer> cdgoGerencia) {
		try {
			List<Tbasg192DocInfrGerenciaterrDto> tbasg192DocInfrGerenciaterrDto = tbasg192DocInfrGerenciaterrService
					.findByCdgoGerenciaIn(cdgoGerencia);

			if (tbasg192DocInfrGerenciaterrDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg192DocInfrGerenciaterrDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoGerenciaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-doc-infr-gerencia-terr-list")
	public ResponseEntity<List<Tbasg192DocInfrGerenciaterrDto>> getDocInfrGerenciaTerrList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg192DocInfrGerenciaterrDto> tbasg192DocInfrGerenciaterrDto = tbasg192DocInfrGerenciaterrService
					.getDocInfrGerenciaTerrList();

			if (tbasg192DocInfrGerenciaterrDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg192DocInfrGerenciaterrDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDocInfrGerenciaTerrList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-doc-infr-gerencia-terr-by-cdgo-gerencia")
	public ResponseEntity<List<Tbasg192DocInfrGerenciaterrDto>> getDocInfrGerenciaTerrByCdgoGerencia(
			String cdgoGerencia) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg192DocInfrGerenciaterrDto> tbasg192DocInfrGerenciaterrDto = tbasg192DocInfrGerenciaterrService
					.getDocInfrGerenciaTerrByCdgoGerencia(cdgoGerencia);

			if (tbasg192DocInfrGerenciaterrDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg192DocInfrGerenciaterrDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDocInfrGerenciaTerrByCdgoGerencia []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
