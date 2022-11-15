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

import renfe.com.model.dto.Tbasg115CalificacDto;
import renfe.com.model.entity.Tbasg115Calificac;
import renfe.com.service.Tbasg115CalificacService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg115Calificac")
public class Tbasg115CalificacController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg115CalificacService tbasg115CalificacService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg115CalificacDto>> getAllTbasg115Calificac(Tbasg115CalificacDto filter) {
		return new ResponseEntity<>(tbasg115CalificacService.getAllTbasg115Calificac(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoCalifi}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoCalifi") Integer cdgoCalifi) {
		Tbasg115CalificacDto tbasg115CalificacData = tbasg115CalificacService.findByCdgoCalifi(cdgoCalifi);

		if (tbasg115CalificacData != null) {
			return new ResponseEntity<>(tbasg115CalificacData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg115CalificacDto> createTbasg115Calificac(
			@RequestBody Tbasg115CalificacDto tbasg115CalificacDto) {
		try {
			return new ResponseEntity<>(tbasg115CalificacService.createTbasg115Calificac(tbasg115CalificacDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg115Calificac {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoCalifi}")
	public ResponseEntity<Tbasg115CalificacDto> updateTbasg115Calificac(@PathVariable("cdgoCalifi") Integer cdgo,
			@RequestBody Tbasg115CalificacDto body) {
		try {
			Tbasg115CalificacDto tbasg115CalificacData = tbasg115CalificacService.updateTbasg115Calificac(cdgo, body);
			if (tbasg115CalificacData != null) {
				return new ResponseEntity<>(tbasg115CalificacData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg115Calificac []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoCalifi}")
	public ResponseEntity<HttpStatus> deleteTbasg115Calificac(@PathVariable("cdgoCalifi") Integer cdgoCalifi) {
		try {
			tbasg115CalificacService.deleteTbasg115Calificac(cdgoCalifi);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg115Calificac []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg115CalificacDto>> findByCdgoCalifiIn(List<Integer> cdgoCalifi) {
		try {
			List<Tbasg115CalificacDto> tbasg115CalificacDto = tbasg115CalificacService.findByCdgoCalifiIn(cdgoCalifi);

			if (tbasg115CalificacDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg115CalificacDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoCalifiIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-calificac-count")
	public ResponseEntity<?> getCalificacCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg115CalificacDto> tbasg115CalificacDto = tbasg115CalificacService.getCalificacCount();

			if (tbasg115CalificacDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg115CalificacDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCalificacCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-calificac-list-ascendente")
	public ResponseEntity<List<Tbasg115CalificacDto>> getCalificacListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg115CalificacDto> tbasg115CalificacDto = tbasg115CalificacService.getCalificacListAscendente();

			if (tbasg115CalificacDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg115CalificacDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCalificacListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-calificac-list-ascendente-revision")
	public ResponseEntity<List<Tbasg115CalificacDto>> getCalificacActiveListAscendenteRevision() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg115CalificacDto> tbasg115CalificacDto = tbasg115CalificacService.getCalificacActiveListAscendenteRevision();

			if (tbasg115CalificacDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg115CalificacDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCalificacActiveListAscendenteRevision []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-calificac-list-descendente")
	public ResponseEntity<List<Tbasg115CalificacDto>> getCalificacListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg115CalificacDto> tbasg115CalificacDto = tbasg115CalificacService.getCalificacListDescendente();

			if (tbasg115CalificacDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg115CalificacDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCalificacListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-calificac-active-list-ascendente")
	public ResponseEntity<List<Tbasg115CalificacDto>> getCalificacActiveListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg115CalificacDto> tbasg115CalificacDto = tbasg115CalificacService
					.getCalificacActiveListAscendente();

			if (tbasg115CalificacDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg115CalificacDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCalificacActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-calificac-active-list-descendente")
	public ResponseEntity<List<Tbasg115CalificacDto>> getCalificacActiveListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg115CalificacDto> tbasg115CalificacDto = tbasg115CalificacService
					.getCalificacActiveListDescendente();

			if (tbasg115CalificacDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg115CalificacDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCalificacActiveListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-calificac")
	public ResponseEntity<List<Tbasg115CalificacDto>> getCalificac(Integer cdgoCalifi) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg115CalificacDto> tbasg115CalificacDto = tbasg115CalificacService.getCalificac(cdgoCalifi);

			if (tbasg115CalificacDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg115CalificacDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCalificac []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-calificac")
	public ResponseEntity<?> insertCalificac(@RequestBody Tbasg115Calificac bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg115CalificacDto = tbasg115CalificacService.insertCalificac(bean);
			return new ResponseEntity<>(tbasg115CalificacDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertCalificac []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-calificac")
	public ResponseEntity<?> updateCalificac(@RequestBody Tbasg115Calificac bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg115CalificacDto = tbasg115CalificacService.updateCalificac(bean);
			return new ResponseEntity<>(tbasg115CalificacDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateCalificac []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-calificac")
	public ResponseEntity<?> estadoCalificac(@RequestBody Tbasg115Calificac bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg115CalificacDto = tbasg115CalificacService.estadoCalificac(bean);
			return new ResponseEntity<>(tbasg115CalificacDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoCalificac []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
