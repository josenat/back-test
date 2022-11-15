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

import renfe.com.model.dto.Tbasg207RepErrActivDto;
import renfe.com.model.entity.Tbasg207RepErrActiv;
import renfe.com.service.Tbasg207RepErrActivService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg207RepErrActiv")
public class Tbasg207RepErrActivController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg207RepErrActivService tbasg207RepErrActivService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg207RepErrActivDto>> getAllTbasg207RepErrActiv(Tbasg207RepErrActivDto filter) {
		return new ResponseEntity<>(tbasg207RepErrActivService.getAllTbasg207RepErrActiv(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoReprocesado}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoReprocesado") Integer cdgoReprocesado) {
		Tbasg207RepErrActivDto tbasg207RepErrActivData = tbasg207RepErrActivService
				.findByCdgoReprocesado(cdgoReprocesado);

		if (tbasg207RepErrActivData != null) {
			return new ResponseEntity<>(tbasg207RepErrActivData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg207RepErrActivDto> createTbasg207RepErrActiv(
			@RequestBody Tbasg207RepErrActivDto tbasg207RepErrActivDto) {
		try {
			return new ResponseEntity<>(tbasg207RepErrActivService.createTbasg207RepErrActiv(tbasg207RepErrActivDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg207RepErrActiv {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoReprocesado}")
	public ResponseEntity<Tbasg207RepErrActivDto> updateTbasg207RepErrActiv(
			@PathVariable("cdgoReprocesado") Integer cdgo, @RequestBody Tbasg207RepErrActivDto body) {
		try {
			Tbasg207RepErrActivDto tbasg207RepErrActivData = tbasg207RepErrActivService.updateTbasg207RepErrActiv(cdgo,
					body);
			if (tbasg207RepErrActivData != null) {
				return new ResponseEntity<>(tbasg207RepErrActivData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg207RepErrActiv []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoReprocesado}")
	public ResponseEntity<HttpStatus> deleteTbasg207RepErrActiv(
			@PathVariable("cdgoReprocesado") Integer cdgoReprocesado) {
		try {
			tbasg207RepErrActivService.deleteTbasg207RepErrActiv(cdgoReprocesado);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg207RepErrActiv []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg207RepErrActivDto>> findByCdgoReprocesadoIn(List<Integer> cdgoReprocesado) {
		try {
			List<Tbasg207RepErrActivDto> tbasg207RepErrActivDto = tbasg207RepErrActivService
					.findByCdgoReprocesadoIn(cdgoReprocesado);

			if (tbasg207RepErrActivDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg207RepErrActivDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoReprocesadoIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-rep-err-activ")
	public ResponseEntity<?> insertRepErrActiv(@RequestBody Tbasg207RepErrActiv bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg207RepErrActivDto = tbasg207RepErrActivService.insertRepErrActiv(bean);
			return new ResponseEntity<>(tbasg207RepErrActivDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertRepErrActiv []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
