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

import renfe.com.model.dto.Tbasg136EstudioDto;
import renfe.com.model.entity.Tbasg136Estudio;
import renfe.com.service.Tbasg136EstudioService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg136Estudio")
public class Tbasg136EstudioController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg136EstudioService tbasg136EstudioService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg136EstudioDto>> getAllTbasg136Estudio(Tbasg136EstudioDto filter) {
		return new ResponseEntity<>(tbasg136EstudioService.getAllTbasg136Estudio(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoEstudio}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoEstudio") Integer cdgoEstudio) {
		Tbasg136EstudioDto tbasg136EstudioData = tbasg136EstudioService.findByCdgoEstudio(cdgoEstudio);

		if (tbasg136EstudioData != null) {
			return new ResponseEntity<>(tbasg136EstudioData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg136EstudioDto> createTbasg136Estudio(
			@RequestBody Tbasg136EstudioDto tbasg136EstudioDto) {
		try {
			return new ResponseEntity<>(tbasg136EstudioService.createTbasg136Estudio(tbasg136EstudioDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg136Estudio {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoEstudio}")
	public ResponseEntity<Tbasg136EstudioDto> updateTbasg136Estudio(@PathVariable("cdgoEstudio") Integer cdgo,
			@RequestBody Tbasg136EstudioDto body) {
		try {
			Tbasg136EstudioDto tbasg136EstudioData = tbasg136EstudioService.updateTbasg136Estudio(cdgo, body);
			if (tbasg136EstudioData != null) {
				return new ResponseEntity<>(tbasg136EstudioData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg136Estudio []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoEstudio}")
	public ResponseEntity<HttpStatus> deleteTbasg136Estudio(@PathVariable("cdgoEstudio") Integer cdgoEstudio) {
		try {
			tbasg136EstudioService.deleteTbasg136Estudio(cdgoEstudio);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg136Estudio []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg136EstudioDto>> findByCdgoEstudioIn(List<Integer> cdgoEstudio) {
		try {
			List<Tbasg136EstudioDto> tbasg136EstudioDto = tbasg136EstudioService.findByCdgoEstudioIn(cdgoEstudio);

			if (tbasg136EstudioDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg136EstudioDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoEstudioIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estudio-count")
	public ResponseEntity<?> getEstudioCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg136EstudioDto> tbasg136EstudioDto = tbasg136EstudioService.getEstudioCount();

			if (tbasg136EstudioDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg136EstudioDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstudioCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estudio-list-ascendente")
	public ResponseEntity<List<Tbasg136EstudioDto>> getEstudioListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg136EstudioDto> tbasg136EstudioDto = tbasg136EstudioService.getEstudioListAscendente();

			if (tbasg136EstudioDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg136EstudioDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstudioListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estudio-list-descendente")
	public ResponseEntity<List<Tbasg136EstudioDto>> getEstudioListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg136EstudioDto> tbasg136EstudioDto = tbasg136EstudioService.getEstudioListDescendente();

			if (tbasg136EstudioDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg136EstudioDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstudioListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estudio-active-list-ascendente")
	public ResponseEntity<List<Tbasg136EstudioDto>> getEstudioActiveListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg136EstudioDto> tbasg136EstudioDto = tbasg136EstudioService.getEstudioActiveListAscendente();

			if (tbasg136EstudioDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg136EstudioDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstudioActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estudio-active-list-descendente")
	public ResponseEntity<List<Tbasg136EstudioDto>> getEstudioActiveListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg136EstudioDto> tbasg136EstudioDto = tbasg136EstudioService.getEstudioActiveListDescendente();

			if (tbasg136EstudioDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg136EstudioDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstudioActiveListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estudio")
	public ResponseEntity<List<Tbasg136EstudioDto>> getEstudio(String cdgoEstudio) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg136EstudioDto> tbasg136EstudioDto = tbasg136EstudioService.getEstudio(cdgoEstudio);

			if (tbasg136EstudioDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg136EstudioDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstudio []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-estudio")
	public ResponseEntity<?> insertEstudio(@RequestBody Tbasg136Estudio bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg136EstudioDto = tbasg136EstudioService.insertEstudio(bean);
			return new ResponseEntity<>(tbasg136EstudioDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertEstudio []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-estudio")
	public ResponseEntity<?> updateEstudio(@RequestBody Tbasg136Estudio bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg136EstudioDto = tbasg136EstudioService.updateEstudio(bean);
			return new ResponseEntity<>(tbasg136EstudioDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateEstudio []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-estudio")
	public ResponseEntity<?> estadoEstudio(@RequestBody Tbasg136Estudio bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg136EstudioDto = tbasg136EstudioService.estadoEstudio(bean);
			return new ResponseEntity<>(tbasg136EstudioDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateEstudio []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
