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

import renfe.com.model.dto.Tbasg148FdotorhabDto;
import renfe.com.model.entity.Tbasg148Fdotorhab;
import renfe.com.service.Tbasg148FdotorhabService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg148Fdotorhab")
public class Tbasg148FdotorhabController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg148FdotorhabService tbasg148FdotorhabService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg148FdotorhabDto>> getAllTbasg148Fdotorhab(Tbasg148FdotorhabDto filter) {
		return new ResponseEntity<>(tbasg148FdotorhabService.getAllTbasg148Fdotorhab(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoFirma}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoFirma") Integer cdgoFirma) {
		Tbasg148FdotorhabDto tbasg148FdotorhabData = tbasg148FdotorhabService.findByCdgoFirma(cdgoFirma);

		if (tbasg148FdotorhabData != null) {
			return new ResponseEntity<>(tbasg148FdotorhabData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg148FdotorhabDto> createTbasg148Fdotorhab(
			@RequestBody Tbasg148FdotorhabDto tbasg148FdotorhabDto) {
		try {
			return new ResponseEntity<>(tbasg148FdotorhabService.createTbasg148Fdotorhab(tbasg148FdotorhabDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg148Fdotorhab {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoFirma}")
	public ResponseEntity<Tbasg148FdotorhabDto> updateTbasg148Fdotorhab(@PathVariable("cdgoFirma") Integer cdgo,
			@RequestBody Tbasg148FdotorhabDto body) {
		try {
			Tbasg148FdotorhabDto tbasg148FdotorhabData = tbasg148FdotorhabService.updateTbasg148Fdotorhab(cdgo, body);
			if (tbasg148FdotorhabData != null) {
				return new ResponseEntity<>(tbasg148FdotorhabData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg148Fdotorhab []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoFirma}")
	public ResponseEntity<HttpStatus> deleteTbasg148Fdotorhab(@PathVariable("cdgoFirma") Integer cdgoFirma) {
		try {
			tbasg148FdotorhabService.deleteTbasg148Fdotorhab(cdgoFirma);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg148Fdotorhab []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg148FdotorhabDto>> findByCdgoFirmaIn(List<Integer> cdgoFirma) {
		try {
			List<Tbasg148FdotorhabDto> tbasg148FdotorhabDto = tbasg148FdotorhabService.findByCdgoFirmaIn(cdgoFirma);

			if (tbasg148FdotorhabDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg148FdotorhabDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoFirmaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-fd-otor-hab")
	public ResponseEntity<?> insertFdOtorHab(Tbasg148Fdotorhab bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg148FdotorhabDto = tbasg148FdotorhabService.insertFdOtorHab(bean);
			return new ResponseEntity<>(tbasg148FdotorhabDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertFdOtorHab []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
