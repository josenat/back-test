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

import renfe.com.model.dto.Tbasg173DatoPlantDocDto;
import renfe.com.service.Tbasg173DatoPlantDocService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg173DatoPlantDoc")
public class Tbasg173DatoPlantDocController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg173DatoPlantDocService tbasg173DatoPlantDocService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg173DatoPlantDocDto>> getAllTbasg173DatoPlantDoc(Tbasg173DatoPlantDocDto filter) {
		return new ResponseEntity<>(tbasg173DatoPlantDocService.getAllTbasg173DatoPlantDoc(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoClave}/{cdgoDocumento}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoClave") String cdgoClave,
			@PathVariable("cdgoDocumento") Integer cdgoDocumento) {
		Tbasg173DatoPlantDocDto tbasg173DatoPlantDocData = tbasg173DatoPlantDocService
				.findByCdgoClaveCdgoDocumento(cdgoClave, cdgoDocumento);

		if (tbasg173DatoPlantDocData != null) {
			return new ResponseEntity<>(tbasg173DatoPlantDocData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg173DatoPlantDocDto> createTbasg173DatoPlantDoc(
			@RequestBody Tbasg173DatoPlantDocDto tbasg173DatoPlantDocDto) {
		try {
			return new ResponseEntity<>(tbasg173DatoPlantDocService.createTbasg173DatoPlantDoc(tbasg173DatoPlantDocDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg173DatoPlantDoc {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoClave}/{cdgoDocumento}")
	public ResponseEntity<Tbasg173DatoPlantDocDto> updateTbasg173DatoPlantDoc(
			@PathVariable("cdgoClave") String cdgoClave, @PathVariable("cdgoDocumento") Integer cdgoDocumento,
			@RequestBody Tbasg173DatoPlantDocDto tbasg173DatoPlantDocDto) {
		try {
			Tbasg173DatoPlantDocDto tbasg173DatoPlantDocData = tbasg173DatoPlantDocService
					.updateTbasg173DatoPlantDoc(cdgoClave, cdgoDocumento, tbasg173DatoPlantDocDto);
			if (tbasg173DatoPlantDocData != null) {
				return new ResponseEntity<>(tbasg173DatoPlantDocData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg173DatoPlantDoc []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoClave}/{cdgoDocumento}")
	public ResponseEntity<HttpStatus> deleteTbasg173DatoPlantDoc(@PathVariable("cdgoClave") String cdgoClave,
			@PathVariable("cdgoDocumento") Integer cdgoDocumento) {
		try {
			tbasg173DatoPlantDocService.deleteTbasg173DatoPlantDoc(cdgoClave, cdgoDocumento);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg173DatoPlantDoc []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg173DatoPlantDocDto>> findByCdgoClaveCdgoDocumentoIn(List<String> cdgoClave,
			List<Integer> cdgoDocumento) {
		try {
			List<Tbasg173DatoPlantDocDto> tbasg173DatoPlantDocDto = tbasg173DatoPlantDocService
					.findByCdgoClaveCdgoDocumentoIn(cdgoClave, cdgoDocumento);

			if (tbasg173DatoPlantDocDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg173DatoPlantDocDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoClaveCdgoDocumentoIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-dato-plant-doc-active-list")
	public ResponseEntity<List<Tbasg173DatoPlantDocDto>> getDatoPlantDocActiveList(String cdgoDocumento) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg173DatoPlantDocDto> tbasg173DatoPlantDocDto = tbasg173DatoPlantDocService
					.getDatoPlantDocActiveList(cdgoDocumento);

			if (tbasg173DatoPlantDocDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg173DatoPlantDocDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDatoPlantDocActiveList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
