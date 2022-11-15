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

import renfe.com.model.dto.Tbasg260HabilifuncDto;
import renfe.com.service.Tbasg260HabilifuncService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg260Habilifunc")
public class Tbasg260HabilifuncController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg260HabilifuncService tbasg260HabilifuncService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg260HabilifuncDto>> getAllTbasg260Habilifunc(Tbasg260HabilifuncDto filter) {
		return new ResponseEntity<>(tbasg260HabilifuncService.getAllTbasg260Habilifunc(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoIdioma}/{cdgoMensaje}/{tipoHabi}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoIdioma") String cdgoIdioma,
			@PathVariable("cdgoMensaje") String cdgoMensaje, @PathVariable("tipoHabi") Integer tipoHabi) {
		Tbasg260HabilifuncDto tbasg260HabilifuncData = tbasg260HabilifuncService
				.findByCdgoIdiomaCdgoMensajeTipoHabi(cdgoIdioma, cdgoMensaje, tipoHabi);

		if (tbasg260HabilifuncData != null) {
			return new ResponseEntity<>(tbasg260HabilifuncData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg260HabilifuncDto> createTbasg260Habilifunc(
			@RequestBody Tbasg260HabilifuncDto tbasg260HabilifuncDto) {
		try {
			return new ResponseEntity<>(tbasg260HabilifuncService.createTbasg260Habilifunc(tbasg260HabilifuncDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg260Habilifunc {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoIdioma}/{cdgoMensaje}/{tipoHabi}")
	public ResponseEntity<Tbasg260HabilifuncDto> updateTbasg260Habilifunc(@PathVariable("cdgoIdioma") String cdgoIdioma,
			@PathVariable("cdgoMensaje") String cdgoMensaje, @PathVariable("tipoHabi") Integer tipoHabi,
			@RequestBody Tbasg260HabilifuncDto tbasg260HabilifuncDto) {
		try {
			Tbasg260HabilifuncDto tbasg260HabilifuncData = tbasg260HabilifuncService
					.updateTbasg260Habilifunc(cdgoIdioma, cdgoMensaje, tipoHabi, tbasg260HabilifuncDto);
			if (tbasg260HabilifuncData != null) {
				return new ResponseEntity<>(tbasg260HabilifuncData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg260Habilifunc []" + tbasg260HabilifuncDto, e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoIdioma}/{cdgoMensaje}/{tipoHabi}")
	public ResponseEntity<HttpStatus> deleteTbasg260Habilifunc(@PathVariable("cdgoIdioma") String cdgoIdioma,
			@PathVariable("cdgoMensaje") String cdgoMensaje, @PathVariable("tipoHabi") Integer tipoHabi) {
		try {
			tbasg260HabilifuncService.deleteTbasg260Habilifunc(cdgoIdioma, cdgoMensaje, tipoHabi);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg260Habilifunc []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg260HabilifuncDto>> findByCdgoIdiomaCdgoMensajeTipoHabiIn(List<String> cdgoIdioma,
			List<String> cdgoMensaje, List<Integer> tipoHabi) {
		try {
			List<Tbasg260HabilifuncDto> tbasg260HabilifuncDto = tbasg260HabilifuncService
					.findByCdgoIdiomaCdgoMensajeTipoHabiIn(cdgoIdioma, cdgoMensaje, tipoHabi);

			if (tbasg260HabilifuncDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg260HabilifuncDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoIdiomaCdgoMensajeTipoHabiIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-funciones-asoc-habil")
	public ResponseEntity<List<Tbasg260HabilifuncDto>> getFuncionesAsocHabil(List<Integer> listHabilitaciones, String cdgoIdioma) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg260HabilifuncDto> tbasg260HabilifuncDto = tbasg260HabilifuncService
					.getFuncionesAsocHabil(listHabilitaciones, cdgoIdioma);

			if (tbasg260HabilifuncDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg260HabilifuncDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFuncionesAsocHabil []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
