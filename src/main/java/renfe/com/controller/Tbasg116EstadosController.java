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

import renfe.com.model.dto.Tbasg116EstadosDto;
import renfe.com.service.Tbasg116EstadosService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg116Estados")
public class Tbasg116EstadosController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg116EstadosService tbasg116EstadosService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg116EstadosDto>> getAllTbasg116Estados(Tbasg116EstadosDto filter) {
		return new ResponseEntity<>(tbasg116EstadosService.getAllTbasg116Estados(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoEstado}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoEstado") Integer cdgoEstado) {
		Tbasg116EstadosDto tbasg116EstadosData = tbasg116EstadosService.findByCdgoEstado(cdgoEstado);

		if (tbasg116EstadosData != null) {
			return new ResponseEntity<>(tbasg116EstadosData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg116EstadosDto> createTbasg116Estados(
			@RequestBody Tbasg116EstadosDto tbasg116EstadosDto) {
		try {
			return new ResponseEntity<>(tbasg116EstadosService.createTbasg116Estados(tbasg116EstadosDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg116Estados {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoEstado}")
	public ResponseEntity<Tbasg116EstadosDto> updateTbasg116Estados(@PathVariable("cdgoEstado") Integer cdgo,
			@RequestBody Tbasg116EstadosDto body) {
		try {
			Tbasg116EstadosDto tbasg116EstadosData = tbasg116EstadosService.updateTbasg116Estados(cdgo, body);
			if (tbasg116EstadosData != null) {
				return new ResponseEntity<>(tbasg116EstadosData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg116Estados []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoEstado}")
	public ResponseEntity<HttpStatus> deleteTbasg116Estados(@PathVariable("cdgoEstado") Integer cdgoEstado) {
		try {
			tbasg116EstadosService.deleteTbasg116Estados(cdgoEstado);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg116Estados []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg116EstadosDto>> findByCdgoEstadoIn(List<Integer> cdgoEstado) {
		try {
			List<Tbasg116EstadosDto> tbasg116EstadosDto = tbasg116EstadosService.findByCdgoEstadoIn(cdgoEstado);

			if (tbasg116EstadosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg116EstadosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoEstadoIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estados-list")
	public ResponseEntity<List<Tbasg116EstadosDto>> getEstadosList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg116EstadosDto> tbasg116EstadosDto = tbasg116EstadosService.getEstadosList();

			if (tbasg116EstadosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg116EstadosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstadosList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estados-habilitacion-list-active")
	public ResponseEntity<List<Tbasg116EstadosDto>> getEstadosHabilitacionListActive() { 
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg116EstadosDto> tbasg116EstadosDto = tbasg116EstadosService.getEstadosHabilitacionListActive();
			if (tbasg116EstadosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg116EstadosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstadosHabilitacionListActive []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/get-estados-conduccion-list-active")
	public ResponseEntity<List<Tbasg116EstadosDto>> getEstadosConduccionListActive() { 
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg116EstadosDto> tbasg116EstadosDto = tbasg116EstadosService.getEstadosConduccionListActive();
			if (tbasg116EstadosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg116EstadosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstadosConduccionListActive []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/get-active-status-list-for-driving")
	public ResponseEntity<List<Tbasg116EstadosDto>> getActiveStatusListForDriving() {
		try {
			List<Tbasg116EstadosDto> tbasg116EstadosDto = tbasg116EstadosService.getActiveStatusListForDriving();
			if (tbasg116EstadosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg116EstadosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActiveStatusListForDriving []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estado")
	public ResponseEntity<?> getEstado(Integer cdgoEstado) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg116EstadosDto> tbasg116EstadosDto = tbasg116EstadosService.getEstado(cdgoEstado);

			if (tbasg116EstadosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg116EstadosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstado []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estados-list-active")
	public ResponseEntity<List<Tbasg116EstadosDto>> getEstadosListActive() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg116EstadosDto> tbasg116EstadosDto = tbasg116EstadosService.getEstadosListActive();
			if (tbasg116EstadosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg116EstadosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstadosListActive []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
