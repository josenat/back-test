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

import renfe.com.model.dto.Tbasg266EstadoAcreDto;
import renfe.com.model.entity.Tbasg266EstadoAcre;
import renfe.com.service.Tbasg266EstadoAcreService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg266EstadoAcre")
public class Tbasg266EstadoAcreController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg266EstadoAcreService tbasg266EstadoAcreService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg266EstadoAcreDto>> getAllTbasg266EstadoAcre(Tbasg266EstadoAcreDto filter) {
		return new ResponseEntity<>(tbasg266EstadoAcreService.getAllTbasg266EstadoAcre(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoAcredita}/{cdgoEstado}/{fchaEstado}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoAcredita") Integer cdgoAcredita,
			@PathVariable("cdgoEstado") String cdgoEstado, @PathVariable("fchaEstado") String fchaEstado) {
		Tbasg266EstadoAcreDto tbasg266EstadoAcreData = tbasg266EstadoAcreService
				.findByCdgoAcreditaCdgoEstadoFchaEstado(cdgoAcredita, cdgoEstado, fchaEstado);

		if (tbasg266EstadoAcreData != null) {
			return new ResponseEntity<>(tbasg266EstadoAcreData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg266EstadoAcreDto> createTbasg266EstadoAcre(
			@RequestBody Tbasg266EstadoAcreDto tbasg266EstadoAcreDto) {
		try {
			return new ResponseEntity<>(tbasg266EstadoAcreService.createTbasg266EstadoAcre(tbasg266EstadoAcreDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg266EstadoAcre {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoAcredita}/{cdgoEstado}/{fchaEstado}")
	public ResponseEntity<Tbasg266EstadoAcreDto> updateTbasg266EstadoAcre(
			@PathVariable("cdgoAcredita") Integer cdgoAcredita, @PathVariable("cdgoEstado") String cdgoEstado,
			@PathVariable("fchaEstado") String fchaEstado, @RequestBody Tbasg266EstadoAcreDto tbasg266EstadoAcreDto) {
		try {
			Tbasg266EstadoAcreDto tbasg266EstadoAcreData = tbasg266EstadoAcreService
					.updateTbasg266EstadoAcre(cdgoAcredita, cdgoEstado, fchaEstado, tbasg266EstadoAcreDto);
			if (tbasg266EstadoAcreData != null) {
				return new ResponseEntity<>(tbasg266EstadoAcreData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg266EstadoAcre []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoAcredita}/{cdgoEstado}/{fchaEstado}")
	public ResponseEntity<HttpStatus> deleteTbasg266EstadoAcre(@PathVariable("cdgoAcredita") Integer cdgoAcredita,
			@PathVariable("cdgoEstado") String cdgoEstado, @PathVariable("fchaEstado") String fchaEstado) {
		try {
			tbasg266EstadoAcreService.deleteTbasg266EstadoAcre(cdgoAcredita, cdgoEstado, fchaEstado);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg266EstadoAcre []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg266EstadoAcreDto>> findByCdgoAcreditaCdgoEstadoFchaEstadoIn(
			List<Integer> cdgoAcredita, List<String> cdgoEstado, List<String> fchaEstado) {
		try {
			List<Tbasg266EstadoAcreDto> tbasg266EstadoAcreDto = tbasg266EstadoAcreService
					.findByCdgoAcreditaCdgoEstadoFchaEstadoIn(cdgoAcredita, cdgoEstado, fchaEstado);

			if (tbasg266EstadoAcreDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg266EstadoAcreDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoAcreditaCdgoEstadoFchaEstadoIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-estado-acreditacion")
	public ResponseEntity<?> insertEstadoAcreditacion(@RequestBody Tbasg266EstadoAcre bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg266EstadoAcreDto = tbasg266EstadoAcreService.insertEstadoAcreditacion(bean);
			return new ResponseEntity<>(tbasg266EstadoAcreDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertEstadoAcreditacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-estado-acreditacion")
	public ResponseEntity<?> updateEstadoAcreditacion(Tbasg266EstadoAcre bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg266EstadoAcreDto = tbasg266EstadoAcreService.updateEstadoAcreditacion(bean);
			return new ResponseEntity<>(tbasg266EstadoAcreDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateEstadoAcreditacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estados-acredita-max-fecha")
	public ResponseEntity<List<Tbasg266EstadoAcreDto>> getEstadosAcreditaMaxFecha() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg266EstadoAcreDto> tbasg266EstadoAcreDto = tbasg266EstadoAcreService.getEstadosAcreditaMaxFecha();

			if (tbasg266EstadoAcreDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg266EstadoAcreDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstadosAcreditaMaxFecha []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estados-acredita-todos-max-fecha")
	public ResponseEntity<List<Tbasg266EstadoAcreDto>> getEstadosAcreditaTodosMaxFecha() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg266EstadoAcreDto> tbasg266EstadoAcreDto = tbasg266EstadoAcreService
					.getEstadosAcreditaTodosMaxFecha();

			if (tbasg266EstadoAcreDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg266EstadoAcreDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstadosAcreditaTodosMaxFecha []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-estado-acre")
	public ResponseEntity<?> insertEstadoAcre(Tbasg266EstadoAcre bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg266EstadoAcreDto = tbasg266EstadoAcreService.insertEstadoAcre(bean);
			return new ResponseEntity<>(tbasg266EstadoAcreDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertEstadoAcre []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-estado-acreditacion-mantenimiento")
	public ResponseEntity<?> updateEstadoAcreditacionMantenimiento(Tbasg266EstadoAcre bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg266EstadoAcreDto = tbasg266EstadoAcreService.updateEstadoAcreditacionMantenimiento(bean);
			return new ResponseEntity<>(tbasg266EstadoAcreDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateEstadoAcreditacionMantenimiento []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
