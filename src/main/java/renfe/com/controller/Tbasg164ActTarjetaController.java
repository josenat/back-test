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

import renfe.com.model.dto.Tbasg164ActTarjetaDto;
import renfe.com.model.entity.Tbasg164ActTarjeta;
import renfe.com.service.Tbasg164ActTarjetaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg164ActTarjeta")
public class Tbasg164ActTarjetaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg164ActTarjetaService tbasg164ActTarjetaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg164ActTarjetaDto>> getAllTbasg164ActTarjeta(Tbasg164ActTarjetaDto filter) {
		return new ResponseEntity<>(tbasg164ActTarjetaService.getAllTbasg164ActTarjeta(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoNumserie}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoNumserie") String cdgoNumserie) {
		Tbasg164ActTarjetaDto tbasg164ActTarjetaData = tbasg164ActTarjetaService.findByCdgoNumserie(cdgoNumserie);

		if (tbasg164ActTarjetaData != null) {
			return new ResponseEntity<>(tbasg164ActTarjetaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg164ActTarjetaDto> createTbasg164ActTarjeta(
			@RequestBody Tbasg164ActTarjetaDto tbasg164ActTarjetaDto) {
		try {
			return new ResponseEntity<>(tbasg164ActTarjetaService.createTbasg164ActTarjeta(tbasg164ActTarjetaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg164ActTarjeta {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoNumserie}")
	public ResponseEntity<Tbasg164ActTarjetaDto> updateTbasg164ActTarjeta(
			@PathVariable("cdgoNumserie") String cdgoNumserie,
			@RequestBody Tbasg164ActTarjetaDto tbasg164ActTarjetaDto) {
		try {
			Tbasg164ActTarjetaDto tbasg164ActTarjetaData = tbasg164ActTarjetaService
					.updateTbasg164ActTarjeta(cdgoNumserie, tbasg164ActTarjetaDto);
			if (tbasg164ActTarjetaData != null) {
				return new ResponseEntity<>(tbasg164ActTarjetaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg164ActTarjeta []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoNumserie}")
	public ResponseEntity<HttpStatus> deleteTbasg164ActTarjeta(@PathVariable("cdgoNumserie") String cdgoNumserie) {
		try {
			tbasg164ActTarjetaService.deleteTbasg164ActTarjeta(cdgoNumserie);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg164ActTarjeta []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg164ActTarjetaDto>> findByCdgoNumserieIn(List<String> cdgoNumserie) {
		try {
			List<Tbasg164ActTarjetaDto> tbasg164ActTarjetaDto = tbasg164ActTarjetaService
					.findByCdgoNumserieIn(cdgoNumserie);

			if (tbasg164ActTarjetaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg164ActTarjetaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoNumserieIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tarjeta-actualizar")
	public ResponseEntity<?> getTarjetaActualizar(String cdgoNumserie) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg164ActTarjetaDto> tbasg164ActTarjetaDto = tbasg164ActTarjetaService
					.getTarjetaActualizar(cdgoNumserie);

			if (tbasg164ActTarjetaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg164ActTarjetaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTarjetaActualizar []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-act-tarjeta")
	public ResponseEntity<?> insertActTarjeta(Tbasg164ActTarjeta bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg164ActTarjetaDto = tbasg164ActTarjetaService.insertActTarjeta(bean);
			return new ResponseEntity<>(tbasg164ActTarjetaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertActTarjeta []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
