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

import renfe.com.model.dto.Tbasg154OpTarjetaDto;
import renfe.com.model.entity.Tbasg154OpTarjeta;
import renfe.com.service.Tbasg154OpTarjetaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg154OpTarjeta")
public class Tbasg154OpTarjetaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg154OpTarjetaService tbasg154OpTarjetaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg154OpTarjetaDto>> getAllTbasg154OpTarjeta(Tbasg154OpTarjetaDto filter) {
		return new ResponseEntity<>(tbasg154OpTarjetaService.getAllTbasg154OpTarjeta(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoPersona}/{fchaOperacion}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoPersona") Integer cdgoPersona,
			@PathVariable("fchaOperacion") String fchaOperacion) {
		Tbasg154OpTarjetaDto tbasg154OpTarjetaData = tbasg154OpTarjetaService
				.findByCdgoPersonaFchaOperacion(cdgoPersona, fchaOperacion);

		if (tbasg154OpTarjetaData != null) {
			return new ResponseEntity<>(tbasg154OpTarjetaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg154OpTarjetaDto> createTbasg154OpTarjeta(
			@RequestBody Tbasg154OpTarjetaDto tbasg154OpTarjetaDto) {
		try {
			return new ResponseEntity<>(tbasg154OpTarjetaService.createTbasg154OpTarjeta(tbasg154OpTarjetaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg154OpTarjeta {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoPersona}/{fchaOperacion}")
	public ResponseEntity<Tbasg154OpTarjetaDto> updateTbasg154OpTarjeta(
			@PathVariable("cdgoPersona") Integer cdgoPersona, @PathVariable("fchaOperacion") String fchaOperacion,
			@RequestBody Tbasg154OpTarjetaDto tbasg154OpTarjetaDto) {
		try {
			Tbasg154OpTarjetaDto tbasg154OpTarjetaData = tbasg154OpTarjetaService.updateTbasg154OpTarjeta(cdgoPersona,
					fchaOperacion, tbasg154OpTarjetaDto);
			if (tbasg154OpTarjetaData != null) {
				return new ResponseEntity<>(tbasg154OpTarjetaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg154OpTarjeta []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoPersona}/{fchaOperacion}")
	public ResponseEntity<HttpStatus> deleteTbasg154OpTarjeta(@PathVariable("cdgoPersona") Integer cdgoPersona,
			@PathVariable("fchaOperacion") String fchaOperacion) {
		try {
			tbasg154OpTarjetaService.deleteTbasg154OpTarjeta(cdgoPersona, fchaOperacion);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg154OpTarjeta []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg154OpTarjetaDto>> findByCdgoPersonaFchaOperacionIn(List<Integer> cdgoPersona,
			List<String> fchaOperacion) {
		try {
			List<Tbasg154OpTarjetaDto> tbasg154OpTarjetaDto = tbasg154OpTarjetaService
					.findByCdgoPersonaFchaOperacionIn(cdgoPersona, fchaOperacion);

			if (tbasg154OpTarjetaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg154OpTarjetaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoPersonaFchaOperacionIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-operacion")
	public ResponseEntity<List<Tbasg154OpTarjetaDto>> getOperacion(String cdgoNumserie) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg154OpTarjetaDto> tbasg154OpTarjetaDto = tbasg154OpTarjetaService.getOperacion(cdgoNumserie);

			if (tbasg154OpTarjetaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg154OpTarjetaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getOperacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-oper-tarjeta")
	public ResponseEntity<?> insertOperTarjeta(Tbasg154OpTarjeta bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg154OpTarjetaDto = tbasg154OpTarjetaService.insertOperTarjeta(bean);
			return new ResponseEntity<>(tbasg154OpTarjetaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertOperTarjeta []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
