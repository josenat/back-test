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

import renfe.com.model.dto.Tbasg191DocInfrDestinatarioDto;
import renfe.com.service.Tbasg191DocInfrDestinatarioService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg191DocInfrDestinatario")
public class Tbasg191DocInfrDestinatarioController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg191DocInfrDestinatarioService tbasg191DocInfrDestinatarioService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg191DocInfrDestinatarioDto>> getAllTbasg191DocInfrDestinatario(
			Tbasg191DocInfrDestinatarioDto filter) {
		return new ResponseEntity<>(tbasg191DocInfrDestinatarioService.getAllTbasg191DocInfrDestinatario(filter),
				HttpStatus.OK);
	}

	@GetMapping("/{cdgoDestinatario}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoDestinatario") Integer cdgoDestinatario) {
		Tbasg191DocInfrDestinatarioDto tbasg191DocInfrDestinatarioData = tbasg191DocInfrDestinatarioService
				.findByCdgoDestinatario(cdgoDestinatario);

		if (tbasg191DocInfrDestinatarioData != null) {
			return new ResponseEntity<>(tbasg191DocInfrDestinatarioData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg191DocInfrDestinatarioDto> createTbasg191DocInfrDestinatario(
			@RequestBody Tbasg191DocInfrDestinatarioDto tbasg191DocInfrDestinatarioDto) {
		try {
			return new ResponseEntity<>(tbasg191DocInfrDestinatarioService
					.createTbasg191DocInfrDestinatario(tbasg191DocInfrDestinatarioDto), HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg191DocInfrDestinatario {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoDestinatario}")
	public ResponseEntity<Tbasg191DocInfrDestinatarioDto> updateTbasg191DocInfrDestinatario(
			@PathVariable("cdgoDestinatario") Integer cdgo, @RequestBody Tbasg191DocInfrDestinatarioDto body) {
		try {
			Tbasg191DocInfrDestinatarioDto tbasg191DocInfrDestinatarioData = tbasg191DocInfrDestinatarioService
					.updateTbasg191DocInfrDestinatario(cdgo, body);
			if (tbasg191DocInfrDestinatarioData != null) {
				return new ResponseEntity<>(tbasg191DocInfrDestinatarioData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg191DocInfrDestinatario []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoDestinatario}")
	public ResponseEntity<HttpStatus> deleteTbasg191DocInfrDestinatario(
			@PathVariable("cdgoDestinatario") Integer cdgoDestinatario) {
		try {
			tbasg191DocInfrDestinatarioService.deleteTbasg191DocInfrDestinatario(cdgoDestinatario);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg191DocInfrDestinatario []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg191DocInfrDestinatarioDto>> findByCdgoDestinatarioIn(
			List<Integer> cdgoDestinatario) {
		try {
			List<Tbasg191DocInfrDestinatarioDto> tbasg191DocInfrDestinatarioDto = tbasg191DocInfrDestinatarioService
					.findByCdgoDestinatarioIn(cdgoDestinatario);

			if (tbasg191DocInfrDestinatarioDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg191DocInfrDestinatarioDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoDestinatarioIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-doc-infr-destinatario-list")
	public ResponseEntity<List<Tbasg191DocInfrDestinatarioDto>> getDocInfrDestinatarioList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg191DocInfrDestinatarioDto> tbasg191DocInfrDestinatarioDto = tbasg191DocInfrDestinatarioService
					.getDocInfrDestinatarioList();

			if (tbasg191DocInfrDestinatarioDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg191DocInfrDestinatarioDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDocInfrDestinatarioList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-doc-infr-destinatario-by-cdgo-destinatario")
	public ResponseEntity<List<Tbasg191DocInfrDestinatarioDto>> getDocInfrDestinatarioByCdgoDestinatario(
			String cdgoDestinatario) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg191DocInfrDestinatarioDto> tbasg191DocInfrDestinatarioDto = tbasg191DocInfrDestinatarioService
					.getDocInfrDestinatarioByCdgoDestinatario(cdgoDestinatario);

			if (tbasg191DocInfrDestinatarioDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg191DocInfrDestinatarioDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDocInfrDestinatarioByCdgoDestinatario []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
