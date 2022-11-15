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

import renfe.com.model.dto.Tbasg178SecuenciaDto;
import renfe.com.model.entity.Tbasg178Secuencia;
import renfe.com.service.Tbasg178SecuenciaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg178Secuencia")
public class Tbasg178SecuenciaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg178SecuenciaService tbasg178SecuenciaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg178SecuenciaDto>> getAllTbasg178Secuencia(Tbasg178SecuenciaDto filter) {
		return new ResponseEntity<>(tbasg178SecuenciaService.getAllTbasg178Secuencia(filter), HttpStatus.OK);
	}

	@GetMapping("/{entityName}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("entityName") String entityName) {
		Tbasg178SecuenciaDto tbasg178SecuenciaData = tbasg178SecuenciaService.findByEntityName(entityName);

		if (tbasg178SecuenciaData != null) {
			return new ResponseEntity<>(tbasg178SecuenciaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg178SecuenciaDto> createTbasg178Secuencia(
			@RequestBody Tbasg178SecuenciaDto tbasg178SecuenciaDto) {
		try {
			return new ResponseEntity<>(tbasg178SecuenciaService.createTbasg178Secuencia(tbasg178SecuenciaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg178Secuencia {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{entityName}")
	public ResponseEntity<Tbasg178SecuenciaDto> updateTbasg178Secuencia(@PathVariable("entityName") String entityName,
			@RequestBody Tbasg178SecuenciaDto tbasg178SecuenciaDto) {
		try {
			Tbasg178SecuenciaDto tbasg178SecuenciaData = tbasg178SecuenciaService.updateTbasg178Secuencia(entityName,
					tbasg178SecuenciaDto);
			if (tbasg178SecuenciaData != null) {
				return new ResponseEntity<>(tbasg178SecuenciaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg178Secuencia []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{entityName}")
	public ResponseEntity<HttpStatus> deleteTbasg178Secuencia(@PathVariable("entityName") String entityName) {
		try {
			tbasg178SecuenciaService.deleteTbasg178Secuencia(entityName);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg178Secuencia []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg178SecuenciaDto>> findByEntityNameIn(List<String> entityName) {
		try {
			List<Tbasg178SecuenciaDto> tbasg178SecuenciaDto = tbasg178SecuenciaService.findByEntityNameIn(entityName);

			if (tbasg178SecuenciaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg178SecuenciaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByEntityNameIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sequence")
	public ResponseEntity<?> getSequence(String entityName) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg178SecuenciaDto> tbasg178SecuenciaDto = tbasg178SecuenciaService.getSequence(entityName);

			if (tbasg178SecuenciaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg178SecuenciaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSequence []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-sequence")
	public ResponseEntity<?> updateSequence(Tbasg178Secuencia bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg178SecuenciaDto = tbasg178SecuenciaService.updateSequence(bean);
			return new ResponseEntity<>(tbasg178SecuenciaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateSequence []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
