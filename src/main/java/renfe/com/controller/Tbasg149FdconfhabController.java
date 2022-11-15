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

import renfe.com.model.dto.Tbasg149FdconfhabDto;
import renfe.com.model.entity.Tbasg149Fdconfhab;
import renfe.com.service.Tbasg149FdconfhabService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg149Fdconfhab")
public class Tbasg149FdconfhabController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg149FdconfhabService tbasg149FdconfhabService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg149FdconfhabDto>> getAllTbasg149Fdconfhab(Tbasg149FdconfhabDto filter) {
		return new ResponseEntity<>(tbasg149FdconfhabService.getAllTbasg149Fdconfhab(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoFirma}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoFirma") Integer cdgoFirma) {
		Tbasg149FdconfhabDto tbasg149FdconfhabData = tbasg149FdconfhabService.findByCdgoFirma(cdgoFirma);

		if (tbasg149FdconfhabData != null) {
			return new ResponseEntity<>(tbasg149FdconfhabData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg149FdconfhabDto> createTbasg149Fdconfhab(
			@RequestBody Tbasg149FdconfhabDto tbasg149FdconfhabDto) {
		try {
			return new ResponseEntity<>(tbasg149FdconfhabService.createTbasg149Fdconfhab(tbasg149FdconfhabDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg149Fdconfhab {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoFirma}")
	public ResponseEntity<Tbasg149FdconfhabDto> updateTbasg149Fdconfhab(@PathVariable("cdgoFirma") Integer cdgo,
			@RequestBody Tbasg149FdconfhabDto body) {
		try {
			Tbasg149FdconfhabDto tbasg149FdconfhabData = tbasg149FdconfhabService.updateTbasg149Fdconfhab(cdgo, body);
			if (tbasg149FdconfhabData != null) {
				return new ResponseEntity<>(tbasg149FdconfhabData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg149Fdconfhab []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoFirma}")
	public ResponseEntity<HttpStatus> deleteTbasg149Fdconfhab(@PathVariable("cdgoFirma") Integer cdgoFirma) {
		try {
			tbasg149FdconfhabService.deleteTbasg149Fdconfhab(cdgoFirma);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg149Fdconfhab []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg149FdconfhabDto>> findByCdgoFirmaIn(List<Integer> cdgoFirma) {
		try {
			List<Tbasg149FdconfhabDto> tbasg149FdconfhabDto = tbasg149FdconfhabService.findByCdgoFirmaIn(cdgoFirma);

			if (tbasg149FdconfhabDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg149FdconfhabDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoFirmaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-fd-conf-hab")
	public ResponseEntity<?> insertFdConfHab(Tbasg149Fdconfhab bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg149FdconfhabDto = tbasg149FdconfhabService.insertFdConfHab(bean);
			return new ResponseEntity<>(tbasg149FdconfhabDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertFdConfHab []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
