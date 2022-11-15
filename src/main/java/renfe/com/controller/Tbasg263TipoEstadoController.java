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

import renfe.com.model.dto.Tbasg263TipoEstadoDto;
import renfe.com.service.Tbasg263TipoEstadoService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg263TipoEstado")
public class Tbasg263TipoEstadoController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg263TipoEstadoService tbasg263TipoEstadoService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg263TipoEstadoDto>> getAllTbasg263TipoEstado(Tbasg263TipoEstadoDto filter) {
		return new ResponseEntity<>(tbasg263TipoEstadoService.getAllTbasg263TipoEstado(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoEstado}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoEstado") String cdgoEstado) {
		Tbasg263TipoEstadoDto tbasg263TipoEstadoData = tbasg263TipoEstadoService.findByCdgoEstado(cdgoEstado);

		if (tbasg263TipoEstadoData != null) {
			return new ResponseEntity<>(tbasg263TipoEstadoData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg263TipoEstadoDto> createTbasg263TipoEstado(
			@RequestBody Tbasg263TipoEstadoDto tbasg263TipoEstadoDto) {
		try {
			return new ResponseEntity<>(tbasg263TipoEstadoService.createTbasg263TipoEstado(tbasg263TipoEstadoDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg263TipoEstado {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoEstado}")
	public ResponseEntity<Tbasg263TipoEstadoDto> updateTbasg263TipoEstado(@PathVariable("cdgoEstado") String cdgoEstado,
			@RequestBody Tbasg263TipoEstadoDto tbasg263TipoEstadoDto) {
		try {
			Tbasg263TipoEstadoDto tbasg263TipoEstadoData = tbasg263TipoEstadoService
					.updateTbasg263TipoEstado(cdgoEstado, tbasg263TipoEstadoDto);
			if (tbasg263TipoEstadoData != null) {
				return new ResponseEntity<>(tbasg263TipoEstadoData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg263TipoEstado []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoEstado}")
	public ResponseEntity<HttpStatus> deleteTbasg263TipoEstado(@PathVariable("cdgoEstado") String cdgoEstado) {
		try {
			tbasg263TipoEstadoService.deleteTbasg263TipoEstado(cdgoEstado);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg263TipoEstado []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg263TipoEstadoDto>> findByCdgoEstadoIn(List<String> cdgoEstado) {
		try {
			List<Tbasg263TipoEstadoDto> tbasg263TipoEstadoDto = tbasg263TipoEstadoService
					.findByCdgoEstadoIn(cdgoEstado);

			if (tbasg263TipoEstadoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg263TipoEstadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoEstadoIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-est-ac-all-list")
	public ResponseEntity<List<Tbasg263TipoEstadoDto>> getTipoEstAcAllList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg263TipoEstadoDto> tbasg263TipoEstadoDto = tbasg263TipoEstadoService.getTipoEstAcAllList();

			if (tbasg263TipoEstadoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg263TipoEstadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoEstAcAllList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-est-ac-count")
	public ResponseEntity<?> getTipoEstAcCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg263TipoEstadoDto> tbasg263TipoEstadoDto = tbasg263TipoEstadoService.getTipoEstAcCount();

			if (tbasg263TipoEstadoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg263TipoEstadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoEstAcCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-estado-acredita")
	public ResponseEntity<List<Tbasg263TipoEstadoDto>> getTipoEstadoAcredita() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg263TipoEstadoDto> tbasg263TipoEstadoDto = tbasg263TipoEstadoService.getTipoEstadoAcredita();

			if (tbasg263TipoEstadoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg263TipoEstadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoEstadoAcredita []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-estados-acredita")
	public ResponseEntity<List<Tbasg263TipoEstadoDto>> getTipoEstadosAcredita() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg263TipoEstadoDto> tbasg263TipoEstadoDto = tbasg263TipoEstadoService.getTipoEstadosAcredita();

			if (tbasg263TipoEstadoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg263TipoEstadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoEstadosAcredita []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
