package renfe.com.controller;

import java.util.List;

import javax.transaction.Transactional;

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

import renfe.com.model.dto.Tbasg119EstahabinDto;
import renfe.com.model.entity.Tbasg119Estahabin;
import renfe.com.service.Tbasg119EstahabinService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg119Estahabin")
public class Tbasg119EstahabinController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg119EstahabinService tbasg119EstahabinService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg119EstahabinDto>> getAllTbasg119Estahabin(Tbasg119EstahabinDto filter) {
		return new ResponseEntity<>(tbasg119EstahabinService.getAllTbasg119Estahabin(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoAlchabinf}/{cdgoEstado}/{fchaEstado}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoAlchabinf") Integer cdgoAlchabinf,
			@PathVariable("cdgoEstado") Integer cdgoEstado, @PathVariable("fchaEstado") String fchaEstado) {
		Tbasg119EstahabinDto tbasg119EstahabinData = tbasg119EstahabinService
				.findByCdgoAlchabinfCdgoEstadoFchaEstado(cdgoAlchabinf, cdgoEstado, fchaEstado);

		if (tbasg119EstahabinData != null) {
			return new ResponseEntity<>(tbasg119EstahabinData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg119EstahabinDto> createTbasg119Estahabin(
			@RequestBody Tbasg119EstahabinDto tbasg119EstahabinDto) {
		try {
			return new ResponseEntity<>(tbasg119EstahabinService.createTbasg119Estahabin(tbasg119EstahabinDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg119Estahabin {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoAlchabinf}/{cdgoEstado}/{fchaEstado}")
	public ResponseEntity<Tbasg119EstahabinDto> updateTbasg119Estahabin(
			@PathVariable("cdgoAlchabinf") Integer cdgoAlchabinf, @PathVariable("cdgoEstado") Integer cdgoEstado,
			@PathVariable("fchaEstado") String fchaEstado, @RequestBody Tbasg119EstahabinDto tbasg119EstahabinDto) {
		try {
			Tbasg119EstahabinDto tbasg119EstahabinData = tbasg119EstahabinService.updateTbasg119Estahabin(cdgoAlchabinf,
					cdgoEstado, fchaEstado, tbasg119EstahabinDto);
			if (tbasg119EstahabinData != null) {
				return new ResponseEntity<>(tbasg119EstahabinData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg119Estahabin []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoAlchabinf}/{cdgoEstado}/{fchaEstado}")
	public ResponseEntity<HttpStatus> deleteTbasg119Estahabin(@PathVariable("cdgoAlchabinf") Integer cdgoAlchabinf,
			@PathVariable("cdgoEstado") Integer cdgoEstado, @PathVariable("fchaEstado") String fchaEstado) {
		try {
			tbasg119EstahabinService.deleteTbasg119Estahabin(cdgoAlchabinf, cdgoEstado, fchaEstado);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg119Estahabin []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg119EstahabinDto>> findByCdgoAlchabinfCdgoEstadoFchaEstadoIn(
			List<Integer> cdgoAlchabinf, List<Integer> cdgoEstado, List<String> fchaEstado) {
		try {
			List<Tbasg119EstahabinDto> tbasg119EstahabinDto = tbasg119EstahabinService
					.findByCdgoAlchabinfCdgoEstadoFchaEstadoIn(cdgoAlchabinf, cdgoEstado, fchaEstado);

			if (tbasg119EstahabinDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg119EstahabinDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoAlchabinfCdgoEstadoFchaEstadoIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-esta-hab-in-by-cdgo-alc")
	public ResponseEntity<List<Tbasg119EstahabinDto>> findEstaHabInByCdgoAlc(String cdgoAlchabinf) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg119EstahabinDto> tbasg119EstahabinDto = tbasg119EstahabinService
					.findEstaHabInByCdgoAlc(cdgoAlchabinf);

			if (tbasg119EstahabinDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg119EstahabinDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findEstaHabInByCdgoAlc []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional
	@GetMapping("/insert-esta-hab-in")
	public ResponseEntity<?> insertEstaHabIn(Integer cdgoAlchabinf, Integer cdgoEstado, String desgUsuact, String mrcaActivo) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg119EstahabinDto = tbasg119EstahabinService.insertEstaHabIn(cdgoAlchabinf, cdgoEstado, desgUsuact, mrcaActivo);
			return new ResponseEntity<>(tbasg119EstahabinDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertEstaHabIn []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
