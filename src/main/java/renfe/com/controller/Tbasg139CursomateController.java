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

import renfe.com.model.dto.Tbasg139CursomateDto;
import renfe.com.model.entity.Tbasg139Cursomate;
import renfe.com.service.Tbasg139CursomateService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg139Cursomate")
public class Tbasg139CursomateController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg139CursomateService tbasg139CursomateService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg139CursomateDto>> getAllTbasg139Cursomate(Tbasg139CursomateDto filter) {
		return new ResponseEntity<>(tbasg139CursomateService.getAllTbasg139Cursomate(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoCursomat}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoCursomat") Integer cdgoCursomat) {
		Tbasg139CursomateDto tbasg139CursomateData = tbasg139CursomateService.findByCdgoCursomat(cdgoCursomat);

		if (tbasg139CursomateData != null) {
			return new ResponseEntity<>(tbasg139CursomateData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg139CursomateDto> createTbasg139Cursomate(
			@RequestBody Tbasg139CursomateDto tbasg139CursomateDto) {
		try {
			return new ResponseEntity<>(tbasg139CursomateService.createTbasg139Cursomate(tbasg139CursomateDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg139Cursomate {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoCursomat}")
	public ResponseEntity<Tbasg139CursomateDto> updateTbasg139Cursomate(@PathVariable("cdgoCursomat") Integer cdgo,
			@RequestBody Tbasg139CursomateDto body) {
		try {
			Tbasg139CursomateDto tbasg139CursomateData = tbasg139CursomateService.updateTbasg139Cursomate(cdgo, body);
			if (tbasg139CursomateData != null) {
				return new ResponseEntity<>(tbasg139CursomateData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg139Cursomate []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoCursomat}")
	public ResponseEntity<HttpStatus> deleteTbasg139Cursomate(@PathVariable("cdgoCursomat") Integer cdgoCursomat) {
		try {
			tbasg139CursomateService.deleteTbasg139Cursomate(cdgoCursomat);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg139Cursomate []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg139CursomateDto>> findByCdgoCursomatIn(List<Integer> cdgoCursomat) {
		try {
			List<Tbasg139CursomateDto> tbasg139CursomateDto = tbasg139CursomateService
					.findByCdgoCursomatIn(cdgoCursomat);

			if (tbasg139CursomateDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg139CursomateDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoCursomatIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-curso-mate-count")
	public ResponseEntity<?> getCursoMateCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg139CursomateDto> tbasg139CursomateDto = tbasg139CursomateService.getCursoMateCount();

			if (tbasg139CursomateDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg139CursomateDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCursoMateCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-curso-mate-list-ascendente")
	public ResponseEntity<List<Tbasg139CursomateDto>> getCursoMateListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg139CursomateDto> tbasg139CursomateDto = tbasg139CursomateService.getCursoMateListAscendente();

			if (tbasg139CursomateDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg139CursomateDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCursoMateListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-curso-mate-list-descendente")
	public ResponseEntity<List<Tbasg139CursomateDto>> getCursoMateListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg139CursomateDto> tbasg139CursomateDto = tbasg139CursomateService.getCursoMateListDescendente();

			if (tbasg139CursomateDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg139CursomateDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCursoMateListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-curso-mate")
	public ResponseEntity<List<Tbasg139CursomateDto>> getCursoMate(String cdgoCursomat) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg139CursomateDto> tbasg139CursomateDto = tbasg139CursomateService.getCursoMate(cdgoCursomat);

			if (tbasg139CursomateDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg139CursomateDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCursoMate []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-curso-mate")
	public ResponseEntity<?> insertCursoMate(Tbasg139Cursomate bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg139CursomateDto = tbasg139CursomateService.insertCursoMate(bean);
			return new ResponseEntity<>(tbasg139CursomateDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertCursoMate []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-curso-mate")
	public ResponseEntity<?> updateCursoMate(Tbasg139Cursomate bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg139CursomateDto = tbasg139CursomateService.updateCursoMate(bean);
			return new ResponseEntity<>(tbasg139CursomateDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateCursoMate []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-curso-mate")
	public ResponseEntity<?> deleteCursoMate(Tbasg139Cursomate bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg139CursomateDto = tbasg139CursomateService.deleteCursoMate(bean);
			return new ResponseEntity<>(tbasg139CursomateDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteCursoMate []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
