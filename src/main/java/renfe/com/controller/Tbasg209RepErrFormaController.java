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

import renfe.com.model.dto.Tbasg209RepErrFormaDto;
import renfe.com.model.entity.Tbasg209RepErrForma;
import renfe.com.service.Tbasg209RepErrFormaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg209RepErrForma")
public class Tbasg209RepErrFormaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg209RepErrFormaService tbasg209RepErrFormaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg209RepErrFormaDto>> getAllTbasg209RepErrForma(Tbasg209RepErrFormaDto filter) {
		return new ResponseEntity<>(tbasg209RepErrFormaService.getAllTbasg209RepErrForma(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoReprocesado}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoReprocesado") Integer cdgoReprocesado) {
		Tbasg209RepErrFormaDto tbasg209RepErrFormaData = tbasg209RepErrFormaService
				.findByCdgoReprocesado(cdgoReprocesado);

		if (tbasg209RepErrFormaData != null) {
			return new ResponseEntity<>(tbasg209RepErrFormaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg209RepErrFormaDto> createTbasg209RepErrForma(
			@RequestBody Tbasg209RepErrFormaDto tbasg209RepErrFormaDto) {
		try {
			return new ResponseEntity<>(tbasg209RepErrFormaService.createTbasg209RepErrForma(tbasg209RepErrFormaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg209RepErrForma {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoReprocesado}")
	public ResponseEntity<Tbasg209RepErrFormaDto> updateTbasg209RepErrForma(
			@PathVariable("cdgoReprocesado") Integer cdgo, @RequestBody Tbasg209RepErrFormaDto body) {
		try {
			Tbasg209RepErrFormaDto tbasg209RepErrFormaData = tbasg209RepErrFormaService.updateTbasg209RepErrForma(cdgo,
					body);
			if (tbasg209RepErrFormaData != null) {
				return new ResponseEntity<>(tbasg209RepErrFormaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg209RepErrForma []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoReprocesado}")
	public ResponseEntity<HttpStatus> deleteTbasg209RepErrForma(
			@PathVariable("cdgoReprocesado") Integer cdgoReprocesado) {
		try {
			tbasg209RepErrFormaService.deleteTbasg209RepErrForma(cdgoReprocesado);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg209RepErrForma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg209RepErrFormaDto>> findByCdgoReprocesadoIn(List<Integer> cdgoReprocesado) {
		try {
			List<Tbasg209RepErrFormaDto> tbasg209RepErrFormaDto = tbasg209RepErrFormaService
					.findByCdgoReprocesadoIn(cdgoReprocesado);

			if (tbasg209RepErrFormaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg209RepErrFormaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoReprocesadoIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-rep-err-forma")
	public ResponseEntity<?> insertRepErrForma(@RequestBody Tbasg209RepErrForma bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg209RepErrFormaDto = tbasg209RepErrFormaService.insertRepErrForma(bean);
			return new ResponseEntity<>(tbasg209RepErrFormaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertRepErrForma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
