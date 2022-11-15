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

import renfe.com.model.dto.Tbasg194DocInfrArtActivaDto;
import renfe.com.service.Tbasg194DocInfrArtActivaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg194DocInfrArtActiva")
public class Tbasg194DocInfrArtActivaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg194DocInfrArtActivaService tbasg194DocInfrArtActivaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg194DocInfrArtActivaDto>> getAllTbasg194DocInfrArtActiva(
			Tbasg194DocInfrArtActivaDto filter) {
		return new ResponseEntity<>(tbasg194DocInfrArtActivaService.getAllTbasg194DocInfrArtActiva(filter),
				HttpStatus.OK);
	}

	@GetMapping("/{cdgoArticulo}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoArticulo") Integer cdgoArticulo) {
		Tbasg194DocInfrArtActivaDto tbasg194DocInfrArtActivaData = tbasg194DocInfrArtActivaService
				.findByCdgoArticulo(cdgoArticulo);

		if (tbasg194DocInfrArtActivaData != null) {
			return new ResponseEntity<>(tbasg194DocInfrArtActivaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg194DocInfrArtActivaDto> createTbasg194DocInfrArtActiva(
			@RequestBody Tbasg194DocInfrArtActivaDto tbasg194DocInfrArtActivaDto) {
		try {
			return new ResponseEntity<>(
					tbasg194DocInfrArtActivaService.createTbasg194DocInfrArtActiva(tbasg194DocInfrArtActivaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg194DocInfrArtActiva {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoArticulo}")
	public ResponseEntity<Tbasg194DocInfrArtActivaDto> updateTbasg194DocInfrArtActiva(
			@PathVariable("cdgoArticulo") Integer cdgo, @RequestBody Tbasg194DocInfrArtActivaDto body) {
		try {
			Tbasg194DocInfrArtActivaDto tbasg194DocInfrArtActivaData = tbasg194DocInfrArtActivaService
					.updateTbasg194DocInfrArtActiva(cdgo, body);
			if (tbasg194DocInfrArtActivaData != null) {
				return new ResponseEntity<>(tbasg194DocInfrArtActivaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg194DocInfrArtActiva []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoArticulo}")
	public ResponseEntity<HttpStatus> deleteTbasg194DocInfrArtActiva(
			@PathVariable("cdgoArticulo") Integer cdgoArticulo) {
		try {
			tbasg194DocInfrArtActivaService.deleteTbasg194DocInfrArtActiva(cdgoArticulo);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg194DocInfrArtActiva []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg194DocInfrArtActivaDto>> findByCdgoArticuloIn(List<Integer> cdgoArticulo) {
		try {
			List<Tbasg194DocInfrArtActivaDto> tbasg194DocInfrArtActivaDto = tbasg194DocInfrArtActivaService
					.findByCdgoArticuloIn(cdgoArticulo);

			if (tbasg194DocInfrArtActivaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg194DocInfrArtActivaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoArticuloIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-doc-infr-art-activa-list")
	public ResponseEntity<List<Tbasg194DocInfrArtActivaDto>> getDocInfrArtActivaList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg194DocInfrArtActivaDto> tbasg194DocInfrArtActivaDto = tbasg194DocInfrArtActivaService
					.getDocInfrArtActivaList();

			if (tbasg194DocInfrArtActivaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg194DocInfrArtActivaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDocInfrArtActivaList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-doc-infr-art-activa-by-cdgo-articulo")
	public ResponseEntity<List<Tbasg194DocInfrArtActivaDto>> getDocInfrArtActivaByCdgoArticulo(String cdgoArticulo) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg194DocInfrArtActivaDto> tbasg194DocInfrArtActivaDto = tbasg194DocInfrArtActivaService
					.getDocInfrArtActivaByCdgoArticulo(cdgoArticulo);

			if (tbasg194DocInfrArtActivaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg194DocInfrArtActivaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDocInfrArtActivaByCdgoArticulo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
