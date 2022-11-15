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

import renfe.com.model.dto.Tbasg177DocOrdenActiDatoDto;
import renfe.com.model.entity.Tbasg177DocOrdenActiDato;
import renfe.com.service.Tbasg177DocOrdenActiDatoService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg177DocOrdenActiDato")
public class Tbasg177DocOrdenActiDatoController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg177DocOrdenActiDatoService tbasg177DocOrdenActiDatoService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg177DocOrdenActiDatoDto>> getAllTbasg177DocOrdenActiDato(
			Tbasg177DocOrdenActiDatoDto filter) {
		return new ResponseEntity<>(tbasg177DocOrdenActiDatoService.getAllTbasg177DocOrdenActiDato(filter),
				HttpStatus.OK);
	}

	@GetMapping("/{cdgoClave}/{cdgoReferenciadoc}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoClave") Integer cdgoClave,
			@PathVariable("cdgoReferenciadoc") Integer cdgoReferenciadoc) {
		Tbasg177DocOrdenActiDatoDto tbasg177DocOrdenActiDatoData = tbasg177DocOrdenActiDatoService
				.findByCdgoClaveCdgoReferenciadoc(cdgoClave, cdgoReferenciadoc);

		if (tbasg177DocOrdenActiDatoData != null) {
			return new ResponseEntity<>(tbasg177DocOrdenActiDatoData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg177DocOrdenActiDatoDto> createTbasg177DocOrdenActiDato(
			@RequestBody Tbasg177DocOrdenActiDatoDto tbasg177DocOrdenActiDatoDto) {
		try {
			return new ResponseEntity<>(
					tbasg177DocOrdenActiDatoService.createTbasg177DocOrdenActiDato(tbasg177DocOrdenActiDatoDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg177DocOrdenActiDato {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoClave}/{cdgoReferenciadoc}")
	public ResponseEntity<Tbasg177DocOrdenActiDatoDto> updateTbasg177DocOrdenActiDato(
			@PathVariable("cdgoClave") Integer cdgoClave, @PathVariable("cdgoReferenciadoc") Integer cdgoReferenciadoc,
			@RequestBody Tbasg177DocOrdenActiDatoDto tbasg177DocOrdenActiDatoDto) {
		try {
			Tbasg177DocOrdenActiDatoDto tbasg177DocOrdenActiDatoData = tbasg177DocOrdenActiDatoService
					.updateTbasg177DocOrdenActiDato(cdgoClave, cdgoReferenciadoc, tbasg177DocOrdenActiDatoDto);
			if (tbasg177DocOrdenActiDatoData != null) {
				return new ResponseEntity<>(tbasg177DocOrdenActiDatoData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg177DocOrdenActiDato []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoClave}/{cdgoReferenciadoc}")
	public ResponseEntity<HttpStatus> deleteTbasg177DocOrdenActiDato(@PathVariable("cdgoClave") Integer cdgoClave,
			@PathVariable("cdgoReferenciadoc") Integer cdgoReferenciadoc) {
		try {
			tbasg177DocOrdenActiDatoService.deleteTbasg177DocOrdenActiDato(cdgoClave, cdgoReferenciadoc);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg177DocOrdenActiDato []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg177DocOrdenActiDatoDto>> findByCdgoClaveCdgoReferenciadocIn(List<Integer> cdgoClave,
			List<Integer> cdgoReferenciadoc) {
		try {
			List<Tbasg177DocOrdenActiDatoDto> tbasg177DocOrdenActiDatoDto = tbasg177DocOrdenActiDatoService
					.findByCdgoClaveCdgoReferenciadocIn(cdgoClave, cdgoReferenciadoc);

			if (tbasg177DocOrdenActiDatoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg177DocOrdenActiDatoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoClaveCdgoReferenciadocIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-doc-orden-acti-dato-active-list")
	public ResponseEntity<List<Tbasg177DocOrdenActiDatoDto>> getDocOrdenActiDatoActiveList(String cdgoReferenciadoc) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg177DocOrdenActiDatoDto> tbasg177DocOrdenActiDatoDto = tbasg177DocOrdenActiDatoService
					.getDocOrdenActiDatoActiveList(cdgoReferenciadoc);

			if (tbasg177DocOrdenActiDatoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg177DocOrdenActiDatoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDocOrdenActiDatoActiveList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-doc-orden-acti-dato-list")
	public ResponseEntity<List<Tbasg177DocOrdenActiDatoDto>> getDocOrdenActiDatoList(String cdgoReferenciadoc) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg177DocOrdenActiDatoDto> tbasg177DocOrdenActiDatoDto = tbasg177DocOrdenActiDatoService
					.getDocOrdenActiDatoList(cdgoReferenciadoc);

			if (tbasg177DocOrdenActiDatoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg177DocOrdenActiDatoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDocOrdenActiDatoList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-doc-orden-acti-dato")
	public ResponseEntity<List<Tbasg177DocOrdenActiDatoDto>> getDocOrdenActiDato(String cdgoReferenciadoc,
			String cdgoClave) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg177DocOrdenActiDatoDto> tbasg177DocOrdenActiDatoDto = tbasg177DocOrdenActiDatoService
					.getDocOrdenActiDato(cdgoReferenciadoc, cdgoClave);

			if (tbasg177DocOrdenActiDatoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg177DocOrdenActiDatoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDocOrdenActiDato []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-doc-orden-acti-dato")
	public ResponseEntity<?> insertDocOrdenActiDato(Tbasg177DocOrdenActiDato bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg177DocOrdenActiDatoDto = tbasg177DocOrdenActiDatoService.insertDocOrdenActiDato(bean);
			return new ResponseEntity<>(tbasg177DocOrdenActiDatoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertDocOrdenActiDato []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-doc-orden-acti-dato")
	public ResponseEntity<?> updateDocOrdenActiDato(Tbasg177DocOrdenActiDato bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg177DocOrdenActiDatoDto = tbasg177DocOrdenActiDatoService.updateDocOrdenActiDato(bean);
			return new ResponseEntity<>(tbasg177DocOrdenActiDatoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateDocOrdenActiDato []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
