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

import renfe.com.model.dto.Tbasg175DocOrdenSuspDatoDto;
import renfe.com.model.entity.Tbasg175DocOrdenSuspDato;
import renfe.com.service.Tbasg175DocOrdenSuspDatoService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg175DocOrdenSuspDato")
public class Tbasg175DocOrdenSuspDatoController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg175DocOrdenSuspDatoService tbasg175DocOrdenSuspDatoService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg175DocOrdenSuspDatoDto>> getAllTbasg175DocOrdenSuspDato(
			Tbasg175DocOrdenSuspDatoDto filter) {
		return new ResponseEntity<>(tbasg175DocOrdenSuspDatoService.getAllTbasg175DocOrdenSuspDato(filter),
				HttpStatus.OK);
	}

	@GetMapping("/{cdgoClave}/{cdgoReferenciadoc}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoClave") Integer cdgoClave,
			@PathVariable("cdgoReferenciadoc") Integer cdgoReferenciadoc) {
		Tbasg175DocOrdenSuspDatoDto tbasg175DocOrdenSuspDatoData = tbasg175DocOrdenSuspDatoService
				.findByCdgoClaveCdgoReferenciadoc(cdgoClave, cdgoReferenciadoc);

		if (tbasg175DocOrdenSuspDatoData != null) {
			return new ResponseEntity<>(tbasg175DocOrdenSuspDatoData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg175DocOrdenSuspDatoDto> createTbasg175DocOrdenSuspDato(
			@RequestBody Tbasg175DocOrdenSuspDatoDto tbasg175DocOrdenSuspDatoDto) {
		try {
			return new ResponseEntity<>(
					tbasg175DocOrdenSuspDatoService.createTbasg175DocOrdenSuspDato(tbasg175DocOrdenSuspDatoDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg175DocOrdenSuspDato {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoClave}/{cdgoReferenciadoc}")
	public ResponseEntity<Tbasg175DocOrdenSuspDatoDto> updateTbasg175DocOrdenSuspDato(
			@PathVariable("cdgoClave") Integer cdgoClave, @PathVariable("cdgoReferenciadoc") Integer cdgoReferenciadoc,
			@RequestBody Tbasg175DocOrdenSuspDatoDto tbasg175DocOrdenSuspDatoDto) {
		try {
			Tbasg175DocOrdenSuspDatoDto tbasg175DocOrdenSuspDatoData = tbasg175DocOrdenSuspDatoService
					.updateTbasg175DocOrdenSuspDato(cdgoClave, cdgoReferenciadoc, tbasg175DocOrdenSuspDatoDto);
			if (tbasg175DocOrdenSuspDatoData != null) {
				return new ResponseEntity<>(tbasg175DocOrdenSuspDatoData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg175DocOrdenSuspDato []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoClave}/{cdgoReferenciadoc}")
	public ResponseEntity<HttpStatus> deleteTbasg175DocOrdenSuspDato(@PathVariable("cdgoClave") Integer cdgoClave,
			@PathVariable("cdgoReferenciadoc") Integer cdgoReferenciadoc) {
		try {
			tbasg175DocOrdenSuspDatoService.deleteTbasg175DocOrdenSuspDato(cdgoClave, cdgoReferenciadoc);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg175DocOrdenSuspDato []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg175DocOrdenSuspDatoDto>> findByCdgoClaveCdgoReferenciadocIn(List<Integer> cdgoClave,
			List<Integer> cdgoReferenciadoc) {
		try {
			List<Tbasg175DocOrdenSuspDatoDto> tbasg175DocOrdenSuspDatoDto = tbasg175DocOrdenSuspDatoService
					.findByCdgoClaveCdgoReferenciadocIn(cdgoClave, cdgoReferenciadoc);

			if (tbasg175DocOrdenSuspDatoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg175DocOrdenSuspDatoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoClaveCdgoReferenciadocIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-doc-orden-susp-dato-active-list")
	public ResponseEntity<List<Tbasg175DocOrdenSuspDatoDto>> getDocOrdenSuspDatoActiveList(String cdgoReferenciadoc) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg175DocOrdenSuspDatoDto> tbasg175DocOrdenSuspDatoDto = tbasg175DocOrdenSuspDatoService
					.getDocOrdenSuspDatoActiveList(cdgoReferenciadoc);

			if (tbasg175DocOrdenSuspDatoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg175DocOrdenSuspDatoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDocOrdenSuspDatoActiveList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-doc-orden-susp-dato-list")
	public ResponseEntity<List<Tbasg175DocOrdenSuspDatoDto>> getDocOrdenSuspDatoList(String cdgoReferenciadoc) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg175DocOrdenSuspDatoDto> tbasg175DocOrdenSuspDatoDto = tbasg175DocOrdenSuspDatoService
					.getDocOrdenSuspDatoList(cdgoReferenciadoc);

			if (tbasg175DocOrdenSuspDatoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg175DocOrdenSuspDatoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDocOrdenSuspDatoList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-doc-orden-susp-dato")
	public ResponseEntity<List<Tbasg175DocOrdenSuspDatoDto>> getDocOrdenSuspDato(String cdgoReferenciadoc,
			String cdgoClave) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg175DocOrdenSuspDatoDto> tbasg175DocOrdenSuspDatoDto = tbasg175DocOrdenSuspDatoService
					.getDocOrdenSuspDato(cdgoReferenciadoc, cdgoClave);

			if (tbasg175DocOrdenSuspDatoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg175DocOrdenSuspDatoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDocOrdenSuspDato []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-doc-orden-susp-dato")
	public ResponseEntity<?> insertDocOrdenSuspDato(Tbasg175DocOrdenSuspDato bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg175DocOrdenSuspDatoDto = tbasg175DocOrdenSuspDatoService.insertDocOrdenSuspDato(bean);
			return new ResponseEntity<>(tbasg175DocOrdenSuspDatoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertDocOrdenSuspDato []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-doc-orden-susp-dato")
	public ResponseEntity<?> updateDocOrdenSuspDato(Tbasg175DocOrdenSuspDato bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg175DocOrdenSuspDatoDto = tbasg175DocOrdenSuspDatoService.updateDocOrdenSuspDato(bean);
			return new ResponseEntity<>(tbasg175DocOrdenSuspDatoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateDocOrdenSuspDato []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
