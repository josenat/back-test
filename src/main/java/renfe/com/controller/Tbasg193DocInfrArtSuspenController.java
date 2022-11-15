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

import renfe.com.model.dto.Tbasg193DocInfrArtSuspenDto;
import renfe.com.service.Tbasg193DocInfrArtSuspenService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg193DocInfrArtSuspen")
public class Tbasg193DocInfrArtSuspenController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg193DocInfrArtSuspenService tbasg193DocInfrArtSuspenService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg193DocInfrArtSuspenDto>> getAllTbasg193DocInfrArtSuspen(
			Tbasg193DocInfrArtSuspenDto filter) {
		return new ResponseEntity<>(tbasg193DocInfrArtSuspenService.getAllTbasg193DocInfrArtSuspen(filter),
				HttpStatus.OK);
	}

	@GetMapping("/{cdgoArticulo}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoArticulo") Integer cdgoArticulo) {
		Tbasg193DocInfrArtSuspenDto tbasg193DocInfrArtSuspenData = tbasg193DocInfrArtSuspenService
				.findByCdgoArticulo(cdgoArticulo);

		if (tbasg193DocInfrArtSuspenData != null) {
			return new ResponseEntity<>(tbasg193DocInfrArtSuspenData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg193DocInfrArtSuspenDto> createTbasg193DocInfrArtSuspen(
			@RequestBody Tbasg193DocInfrArtSuspenDto tbasg193DocInfrArtSuspenDto) {
		try {
			return new ResponseEntity<>(
					tbasg193DocInfrArtSuspenService.createTbasg193DocInfrArtSuspen(tbasg193DocInfrArtSuspenDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg193DocInfrArtSuspen {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoArticulo}")
	public ResponseEntity<Tbasg193DocInfrArtSuspenDto> updateTbasg193DocInfrArtSuspen(
			@PathVariable("cdgoArticulo") Integer cdgo, @RequestBody Tbasg193DocInfrArtSuspenDto body) {
		try {
			Tbasg193DocInfrArtSuspenDto tbasg193DocInfrArtSuspenData = tbasg193DocInfrArtSuspenService
					.updateTbasg193DocInfrArtSuspen(cdgo, body);
			if (tbasg193DocInfrArtSuspenData != null) {
				return new ResponseEntity<>(tbasg193DocInfrArtSuspenData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg193DocInfrArtSuspen []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoArticulo}")
	public ResponseEntity<HttpStatus> deleteTbasg193DocInfrArtSuspen(
			@PathVariable("cdgoArticulo") Integer cdgoArticulo) {
		try {
			tbasg193DocInfrArtSuspenService.deleteTbasg193DocInfrArtSuspen(cdgoArticulo);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg193DocInfrArtSuspen []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg193DocInfrArtSuspenDto>> findByCdgoArticuloIn(List<Integer> cdgoArticulo) {
		try {
			List<Tbasg193DocInfrArtSuspenDto> tbasg193DocInfrArtSuspenDto = tbasg193DocInfrArtSuspenService
					.findByCdgoArticuloIn(cdgoArticulo);

			if (tbasg193DocInfrArtSuspenDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg193DocInfrArtSuspenDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoArticuloIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-doc-infr-art-suspen-list")
	public ResponseEntity<List<Tbasg193DocInfrArtSuspenDto>> getDocInfrArtSuspenList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg193DocInfrArtSuspenDto> tbasg193DocInfrArtSuspenDto = tbasg193DocInfrArtSuspenService
					.getDocInfrArtSuspenList();

			if (tbasg193DocInfrArtSuspenDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg193DocInfrArtSuspenDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDocInfrArtSuspenList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-doc-infr-art-suspen-by-cdgo-articulo")
	public ResponseEntity<List<Tbasg193DocInfrArtSuspenDto>> getDocInfrArtSuspenByCdgoArticulo(String cdgoArticulo) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg193DocInfrArtSuspenDto> tbasg193DocInfrArtSuspenDto = tbasg193DocInfrArtSuspenService
					.getDocInfrArtSuspenByCdgoArticulo(cdgoArticulo);

			if (tbasg193DocInfrArtSuspenDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg193DocInfrArtSuspenDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDocInfrArtSuspenByCdgoArticulo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
