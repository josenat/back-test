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

import renfe.com.model.dto.Tbasg169TipoAnotacionDto;
import renfe.com.service.Tbasg169TipoAnotacionService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg169TipoAnotacion")
public class Tbasg169TipoAnotacionController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg169TipoAnotacionService tbasg169TipoAnotacionService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg169TipoAnotacionDto>> getAllTbasg169TipoAnotacion(Tbasg169TipoAnotacionDto filter) {
		return new ResponseEntity<>(tbasg169TipoAnotacionService.getAllTbasg169TipoAnotacion(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoTipoanotacion}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoTipoanotacion") String cdgoTipoanotacion) {
		Tbasg169TipoAnotacionDto tbasg169TipoAnotacionData = tbasg169TipoAnotacionService
				.findByCdgoTipoanotacion(cdgoTipoanotacion);

		if (tbasg169TipoAnotacionData != null) {
			return new ResponseEntity<>(tbasg169TipoAnotacionData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg169TipoAnotacionDto> createTbasg169TipoAnotacion(
			@RequestBody Tbasg169TipoAnotacionDto tbasg169TipoAnotacionDto) {
		try {
			return new ResponseEntity<>(
					tbasg169TipoAnotacionService.createTbasg169TipoAnotacion(tbasg169TipoAnotacionDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg169TipoAnotacion {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoTipoanotacion}")
	public ResponseEntity<Tbasg169TipoAnotacionDto> updateTbasg169TipoAnotacion(
			@PathVariable("cdgoTipoanotacion") String cdgoTipoanotacion,
			@RequestBody Tbasg169TipoAnotacionDto tbasg169TipoAnotacionDto) {
		try {
			Tbasg169TipoAnotacionDto tbasg169TipoAnotacionData = tbasg169TipoAnotacionService
					.updateTbasg169TipoAnotacion(cdgoTipoanotacion, tbasg169TipoAnotacionDto);
			if (tbasg169TipoAnotacionData != null) {
				return new ResponseEntity<>(tbasg169TipoAnotacionData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg169TipoAnotacion []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoTipoanotacion}")
	public ResponseEntity<HttpStatus> deleteTbasg169TipoAnotacion(
			@PathVariable("cdgoTipoanotacion") String cdgoTipoanotacion) {
		try {
			tbasg169TipoAnotacionService.deleteTbasg169TipoAnotacion(cdgoTipoanotacion);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg169TipoAnotacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg169TipoAnotacionDto>> findByCdgoTipoanotacionIn(List<String> cdgoTipoanotacion) {
		try {
			List<Tbasg169TipoAnotacionDto> tbasg169TipoAnotacionDto = tbasg169TipoAnotacionService
					.findByCdgoTipoanotacionIn(cdgoTipoanotacion);

			if (tbasg169TipoAnotacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg169TipoAnotacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoTipoanotacionIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-anotacion-inspector-active-list")
	public ResponseEntity<List<Tbasg169TipoAnotacionDto>> getTipoAnotacionInspectorActiveList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg169TipoAnotacionDto> tbasg169TipoAnotacionDto = tbasg169TipoAnotacionService
					.getTipoAnotacionInspectorActiveList();

			if (tbasg169TipoAnotacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg169TipoAnotacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoAnotacionInspectorActiveList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
