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

import renfe.com.model.dto.Tbasg159GcConceptoDto;
import renfe.com.service.Tbasg159GcConceptoService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg159GcConcepto")
public class Tbasg159GcConceptoController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg159GcConceptoService tbasg159GcConceptoService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg159GcConceptoDto>> getAllTbasg159GcConcepto(Tbasg159GcConceptoDto filter) {
		return new ResponseEntity<>(tbasg159GcConceptoService.getAllTbasg159GcConcepto(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoCategoria}/{cdgoConcepto}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoCategoria") String cdgoCategoria,
			@PathVariable("cdgoConcepto") String cdgoConcepto) {
		Tbasg159GcConceptoDto tbasg159GcConceptoData = tbasg159GcConceptoService
				.findByCdgoCategoriaCdgoConcepto(cdgoCategoria, cdgoConcepto);

		if (tbasg159GcConceptoData != null) {
			return new ResponseEntity<>(tbasg159GcConceptoData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg159GcConceptoDto> createTbasg159GcConcepto(
			@RequestBody Tbasg159GcConceptoDto tbasg159GcConceptoDto) {
		try {
			return new ResponseEntity<>(tbasg159GcConceptoService.createTbasg159GcConcepto(tbasg159GcConceptoDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg159GcConcepto {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoCategoria}/{cdgoConcepto}")
	public ResponseEntity<Tbasg159GcConceptoDto> updateTbasg159GcConcepto(
			@PathVariable("cdgoCategoria") String cdgoCategoria, @PathVariable("cdgoConcepto") String cdgoConcepto,
			@RequestBody Tbasg159GcConceptoDto tbasg159GcConceptoDto) {
		try {
			Tbasg159GcConceptoDto tbasg159GcConceptoData = tbasg159GcConceptoService
					.updateTbasg159GcConcepto(cdgoCategoria, cdgoConcepto, tbasg159GcConceptoDto);
			if (tbasg159GcConceptoData != null) {
				return new ResponseEntity<>(tbasg159GcConceptoData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg159GcConcepto []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoCategoria}/{cdgoConcepto}")
	public ResponseEntity<HttpStatus> deleteTbasg159GcConcepto(@PathVariable("cdgoCategoria") String cdgoCategoria,
			@PathVariable("cdgoConcepto") String cdgoConcepto) {
		try {
			tbasg159GcConceptoService.deleteTbasg159GcConcepto(cdgoCategoria, cdgoConcepto);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg159GcConcepto []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg159GcConceptoDto>> findByCdgoCategoriaCdgoConceptoIn(List<String> cdgoCategoria,
			List<String> cdgoConcepto) {
		try {
			List<Tbasg159GcConceptoDto> tbasg159GcConceptoDto = tbasg159GcConceptoService
					.findByCdgoCategoriaCdgoConceptoIn(cdgoCategoria, cdgoConcepto);

			if (tbasg159GcConceptoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg159GcConceptoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoCategoriaCdgoConceptoIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-gc-conceptos-active-list")
	public ResponseEntity<List<Tbasg159GcConceptoDto>> getGcConceptosActiveList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg159GcConceptoDto> tbasg159GcConceptoDto = tbasg159GcConceptoService.getGcConceptosActiveList();

			if (tbasg159GcConceptoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg159GcConceptoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getGcConceptosActiveList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
