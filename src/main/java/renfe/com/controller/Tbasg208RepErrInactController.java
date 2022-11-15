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

import renfe.com.model.dto.Tbasg208RepErrInactDto;
import renfe.com.model.entity.Tbasg208RepErrInact;
import renfe.com.service.Tbasg208RepErrInactService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg208RepErrInact")
public class Tbasg208RepErrInactController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg208RepErrInactService tbasg208RepErrInactService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg208RepErrInactDto>> getAllTbasg208RepErrInact(Tbasg208RepErrInactDto filter) {
		return new ResponseEntity<>(tbasg208RepErrInactService.getAllTbasg208RepErrInact(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoReprocesado}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoReprocesado") Integer cdgoReprocesado) {
		Tbasg208RepErrInactDto tbasg208RepErrInactData = tbasg208RepErrInactService
				.findByCdgoReprocesado(cdgoReprocesado);

		if (tbasg208RepErrInactData != null) {
			return new ResponseEntity<>(tbasg208RepErrInactData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg208RepErrInactDto> createTbasg208RepErrInact(
			@RequestBody Tbasg208RepErrInactDto tbasg208RepErrInactDto) {
		try {
			return new ResponseEntity<>(tbasg208RepErrInactService.createTbasg208RepErrInact(tbasg208RepErrInactDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg208RepErrInact {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoReprocesado}")
	public ResponseEntity<Tbasg208RepErrInactDto> updateTbasg208RepErrInact(
			@PathVariable("cdgoReprocesado") Integer cdgo, @RequestBody Tbasg208RepErrInactDto body) {
		try {
			Tbasg208RepErrInactDto tbasg208RepErrInactData = tbasg208RepErrInactService.updateTbasg208RepErrInact(cdgo,
					body);
			if (tbasg208RepErrInactData != null) {
				return new ResponseEntity<>(tbasg208RepErrInactData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg208RepErrInact []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoReprocesado}")
	public ResponseEntity<HttpStatus> deleteTbasg208RepErrInact(
			@PathVariable("cdgoReprocesado") Integer cdgoReprocesado) {
		try {
			tbasg208RepErrInactService.deleteTbasg208RepErrInact(cdgoReprocesado);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg208RepErrInact []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg208RepErrInactDto>> findByCdgoReprocesadoIn(List<Integer> cdgoReprocesado) {
		try {
			List<Tbasg208RepErrInactDto> tbasg208RepErrInactDto = tbasg208RepErrInactService
					.findByCdgoReprocesadoIn(cdgoReprocesado);

			if (tbasg208RepErrInactDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg208RepErrInactDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoReprocesadoIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-rep-err-inact")
	public ResponseEntity<?> insertRepErrInact(@RequestBody Tbasg208RepErrInact bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg208RepErrInactDto = tbasg208RepErrInactService.insertRepErrInact(bean);
			return new ResponseEntity<>(tbasg208RepErrInactDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertRepErrInact []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
