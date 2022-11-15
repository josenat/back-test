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

import renfe.com.model.dto.Tbasg206RepErrSaludDto;
import renfe.com.model.entity.Tbasg206RepErrSalud;
import renfe.com.service.Tbasg206RepErrSaludService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg206RepErrSalud")
public class Tbasg206RepErrSaludController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg206RepErrSaludService tbasg206RepErrSaludService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg206RepErrSaludDto>> getAllTbasg206RepErrSalud(Tbasg206RepErrSaludDto filter) {
		return new ResponseEntity<>(tbasg206RepErrSaludService.getAllTbasg206RepErrSalud(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoReprocesado}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoReprocesado") Integer cdgoReprocesado) {
		Tbasg206RepErrSaludDto tbasg206RepErrSaludData = tbasg206RepErrSaludService
				.findByCdgoReprocesado(cdgoReprocesado);

		if (tbasg206RepErrSaludData != null) {
			return new ResponseEntity<>(tbasg206RepErrSaludData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg206RepErrSaludDto> createTbasg206RepErrSalud(
			@RequestBody Tbasg206RepErrSaludDto tbasg206RepErrSaludDto) {
		try {
			return new ResponseEntity<>(tbasg206RepErrSaludService.createTbasg206RepErrSalud(tbasg206RepErrSaludDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg206RepErrSalud {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoReprocesado}")
	public ResponseEntity<Tbasg206RepErrSaludDto> updateTbasg206RepErrSalud(
			@PathVariable("cdgoReprocesado") Integer cdgo, @RequestBody Tbasg206RepErrSaludDto body) {
		try {
			Tbasg206RepErrSaludDto tbasg206RepErrSaludData = tbasg206RepErrSaludService.updateTbasg206RepErrSalud(cdgo,
					body);
			if (tbasg206RepErrSaludData != null) {
				return new ResponseEntity<>(tbasg206RepErrSaludData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg206RepErrSalud []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoReprocesado}")
	public ResponseEntity<HttpStatus> deleteTbasg206RepErrSalud(
			@PathVariable("cdgoReprocesado") Integer cdgoReprocesado) {
		try {
			tbasg206RepErrSaludService.deleteTbasg206RepErrSalud(cdgoReprocesado);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg206RepErrSalud []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg206RepErrSaludDto>> findByCdgoReprocesadoIn(List<Integer> cdgoReprocesado) {
		try {
			List<Tbasg206RepErrSaludDto> tbasg206RepErrSaludDto = tbasg206RepErrSaludService
					.findByCdgoReprocesadoIn(cdgoReprocesado);

			if (tbasg206RepErrSaludDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg206RepErrSaludDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoReprocesadoIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-rep-err-salud")
	public ResponseEntity<?> insertRepErrSalud(@RequestBody Tbasg206RepErrSalud bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg206RepErrSaludDto = tbasg206RepErrSaludService.insertRepErrSalud(bean);
			return new ResponseEntity<>(tbasg206RepErrSaludDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertRepErrSalud []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
