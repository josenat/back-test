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

import renfe.com.model.dto.Tbasg190DocInfrOrdenanteDto;
import renfe.com.service.Tbasg190DocInfrOrdenanteService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg190DocInfrOrdenante")
public class Tbasg190DocInfrOrdenanteController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg190DocInfrOrdenanteService tbasg190DocInfrOrdenanteService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg190DocInfrOrdenanteDto>> getAllTbasg190DocInfrOrdenante(
			Tbasg190DocInfrOrdenanteDto filter) {
		return new ResponseEntity<>(tbasg190DocInfrOrdenanteService.getAllTbasg190DocInfrOrdenante(filter),
				HttpStatus.OK);
	}

	@GetMapping("/{cdgoOrdenante}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoOrdenante") Integer cdgoOrdenante) {
		Tbasg190DocInfrOrdenanteDto tbasg190DocInfrOrdenanteData = tbasg190DocInfrOrdenanteService
				.findByCdgoOrdenante(cdgoOrdenante);

		if (tbasg190DocInfrOrdenanteData != null) {
			return new ResponseEntity<>(tbasg190DocInfrOrdenanteData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg190DocInfrOrdenanteDto> createTbasg190DocInfrOrdenante(
			@RequestBody Tbasg190DocInfrOrdenanteDto tbasg190DocInfrOrdenanteDto) {
		try {
			return new ResponseEntity<>(
					tbasg190DocInfrOrdenanteService.createTbasg190DocInfrOrdenante(tbasg190DocInfrOrdenanteDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg190DocInfrOrdenante {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoOrdenante}")
	public ResponseEntity<Tbasg190DocInfrOrdenanteDto> updateTbasg190DocInfrOrdenante(
			@PathVariable("cdgoOrdenante") Integer cdgo, @RequestBody Tbasg190DocInfrOrdenanteDto body) {
		try {
			Tbasg190DocInfrOrdenanteDto tbasg190DocInfrOrdenanteData = tbasg190DocInfrOrdenanteService
					.updateTbasg190DocInfrOrdenante(cdgo, body);
			if (tbasg190DocInfrOrdenanteData != null) {
				return new ResponseEntity<>(tbasg190DocInfrOrdenanteData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg190DocInfrOrdenante []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoOrdenante}")
	public ResponseEntity<HttpStatus> deleteTbasg190DocInfrOrdenante(
			@PathVariable("cdgoOrdenante") Integer cdgoOrdenante) {
		try {
			tbasg190DocInfrOrdenanteService.deleteTbasg190DocInfrOrdenante(cdgoOrdenante);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg190DocInfrOrdenante []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg190DocInfrOrdenanteDto>> findByCdgoOrdenanteIn(List<Integer> cdgoOrdenante) {
		try {
			List<Tbasg190DocInfrOrdenanteDto> tbasg190DocInfrOrdenanteDto = tbasg190DocInfrOrdenanteService
					.findByCdgoOrdenanteIn(cdgoOrdenante);

			if (tbasg190DocInfrOrdenanteDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg190DocInfrOrdenanteDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoOrdenanteIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-doc-infr-ordenante-list")
	public ResponseEntity<List<Tbasg190DocInfrOrdenanteDto>> getDocInfrOrdenanteList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg190DocInfrOrdenanteDto> tbasg190DocInfrOrdenanteDto = tbasg190DocInfrOrdenanteService
					.getDocInfrOrdenanteList();

			if (tbasg190DocInfrOrdenanteDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg190DocInfrOrdenanteDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDocInfrOrdenanteList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-doc-infr-ordenante-by-cdgo-ordenante")
	public ResponseEntity<List<Tbasg190DocInfrOrdenanteDto>> getDocInfrOrdenanteByCdgoOrdenante(String cdgoOrdenante) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg190DocInfrOrdenanteDto> tbasg190DocInfrOrdenanteDto = tbasg190DocInfrOrdenanteService
					.getDocInfrOrdenanteByCdgoOrdenante(cdgoOrdenante);

			if (tbasg190DocInfrOrdenanteDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg190DocInfrOrdenanteDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDocInfrOrdenanteByCdgoOrdenante []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
