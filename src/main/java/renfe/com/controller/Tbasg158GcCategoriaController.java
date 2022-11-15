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

import renfe.com.model.dto.Tbasg158GcCategoriaDto;
import renfe.com.service.Tbasg158GcCategoriaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg158GcCategoria")
public class Tbasg158GcCategoriaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg158GcCategoriaService tbasg158GcCategoriaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg158GcCategoriaDto>> getAllTbasg158GcCategoria(Tbasg158GcCategoriaDto filter) {
		return new ResponseEntity<>(tbasg158GcCategoriaService.getAllTbasg158GcCategoria(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoCategoria}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoCategoria") String cdgoCategoria) {
		Tbasg158GcCategoriaDto tbasg158GcCategoriaData = tbasg158GcCategoriaService.findByCdgoCategoria(cdgoCategoria);

		if (tbasg158GcCategoriaData != null) {
			return new ResponseEntity<>(tbasg158GcCategoriaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg158GcCategoriaDto> createTbasg158GcCategoria(
			@RequestBody Tbasg158GcCategoriaDto tbasg158GcCategoriaDto) {
		try {
			return new ResponseEntity<>(tbasg158GcCategoriaService.createTbasg158GcCategoria(tbasg158GcCategoriaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg158GcCategoria {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoCategoria}")
	public ResponseEntity<Tbasg158GcCategoriaDto> updateTbasg158GcCategoria(
			@PathVariable("cdgoCategoria") String cdgoCategoria,
			@RequestBody Tbasg158GcCategoriaDto tbasg158GcCategoriaDto) {
		try {
			Tbasg158GcCategoriaDto tbasg158GcCategoriaData = tbasg158GcCategoriaService
					.updateTbasg158GcCategoria(cdgoCategoria, tbasg158GcCategoriaDto);
			if (tbasg158GcCategoriaData != null) {
				return new ResponseEntity<>(tbasg158GcCategoriaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg158GcCategoria []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoCategoria}")
	public ResponseEntity<HttpStatus> deleteTbasg158GcCategoria(@PathVariable("cdgoCategoria") String cdgoCategoria) {
		try {
			tbasg158GcCategoriaService.deleteTbasg158GcCategoria(cdgoCategoria);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg158GcCategoria []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg158GcCategoriaDto>> findByCdgoCategoriaIn(List<String> cdgoCategoria) {
		try {
			List<Tbasg158GcCategoriaDto> tbasg158GcCategoriaDto = tbasg158GcCategoriaService
					.findByCdgoCategoriaIn(cdgoCategoria);

			if (tbasg158GcCategoriaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg158GcCategoriaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoCategoriaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-gc-categorias-active-list")
	public ResponseEntity<List<Tbasg158GcCategoriaDto>> getGcCategoriasActiveList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg158GcCategoriaDto> tbasg158GcCategoriaDto = tbasg158GcCategoriaService
					.getGcCategoriasActiveList();

			if (tbasg158GcCategoriaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg158GcCategoriaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getGcCategoriasActiveList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
