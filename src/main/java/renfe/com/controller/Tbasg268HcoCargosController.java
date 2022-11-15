package renfe.com.controller;

import java.sql.Date;
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

import renfe.com.model.dto.Tbasg268HcoCargosDto;
import renfe.com.model.entity.Tbasg268HcoCargos;
import renfe.com.service.Tbasg268HcoCargosService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg268HcoCargos")
public class Tbasg268HcoCargosController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg268HcoCargosService tbasg268HcoCargosService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg268HcoCargosDto>> getAllTbasg268HcoCargos(Tbasg268HcoCargosDto filter) {
		return new ResponseEntity<>(tbasg268HcoCargosService.getAllTbasg268HcoCargos(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoPersona}/{fchaInicio}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoPersona") String cdgoPersona,
			@PathVariable("fchaInicio") Date fchaInicio) {
		/*Tbasg268HcoCargosDto tbasg268HcoCargosData = tbasg268HcoCargosService.findByCdgoPersonaFchaInicio(cdgoPersona,
				fchaInicio);

		if (tbasg268HcoCargosData != null) {
			return new ResponseEntity<>(tbasg268HcoCargosData, HttpStatus.OK);
		}*/
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg268HcoCargosDto> createTbasg268HcoCargos(
			@RequestBody Tbasg268HcoCargosDto tbasg268HcoCargosDto) {
		try {
			return new ResponseEntity<>(tbasg268HcoCargosService.createTbasg268HcoCargos(tbasg268HcoCargosDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg268HcoCargos {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoPersona}/{fchaInicio}")
	public ResponseEntity<Tbasg268HcoCargosDto> updateTbasg268HcoCargos(@PathVariable("cdgoPersona") String cdgoPersona,
			@PathVariable("fchaInicio") Date fchaInicio, @RequestBody Tbasg268HcoCargosDto tbasg268HcoCargosDto) {
		try {
			/*Tbasg268HcoCargosDto tbasg268HcoCargosData = tbasg268HcoCargosService.updateTbasg268HcoCargos(cdgoPersona,
					fchaInicio, tbasg268HcoCargosDto);
			if (tbasg268HcoCargosData != null) {
				return new ResponseEntity<>(tbasg268HcoCargosData, HttpStatus.OK);
			}*/
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg268HcoCargos []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/*@DeleteMapping("/{cdgoPersona}/{fchaInicio}")
	public ResponseEntity<HttpStatus> deleteTbasg268HcoCargos(@PathVariable("cdgoPersona") String cdgoPersona,
			@PathVariable("fchaInicio") Date fchaInicio) {
		try {
			tbasg268HcoCargosService.deleteTbasg268HcoCargos(cdgoPersona, fchaInicio);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg268HcoCargos []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/

	/*@GetMapping("/list")
	public ResponseEntity<List<Tbasg268HcoCargosDto>> findByCdgoPersonaFchaInicioIn(List<String> cdgoPersona,
			List<Date> fchaInicio) {
		try {
			List<Tbasg268HcoCargosDto> tbasg268HcoCargosDto = tbasg268HcoCargosService
					.findByCdgoPersonaFchaInicioIn(cdgoPersona, fchaInicio);

			if (tbasg268HcoCargosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg268HcoCargosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoPersonaFchaInicioIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/

	@GetMapping("/find-by-cdgo-persona")
	public ResponseEntity<List<Tbasg268HcoCargosDto>> findByCdgoPersona(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg268HcoCargosDto> tbasg268HcoCargosDto = tbasg268HcoCargosService.findByCdgoPersona(cdgoPersona);

			if (tbasg268HcoCargosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg268HcoCargosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-by-cdgo-persona-cargo")
	public ResponseEntity<List<Tbasg268HcoCargosDto>> findByCdgoPersonaCargo(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg268HcoCargosDto> tbasg268HcoCargosDto = tbasg268HcoCargosService
					.findByCdgoPersonaCargo(cdgoPersona);

			if (tbasg268HcoCargosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg268HcoCargosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoPersonaCargo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-cdgo-cargo-beginning-k")
	public ResponseEntity<List<Tbasg268HcoCargosDto>> findCdgoCargoBeginningK(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg268HcoCargosDto> tbasg268HcoCargosDto = tbasg268HcoCargosService
					.findCdgoCargoBeginningK(cdgoPersona);

			if (tbasg268HcoCargosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg268HcoCargosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findCdgoCargoBeginningK []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional
	@GetMapping("/insert-hsto-cargos")
	public ResponseEntity<?> insertHstoCargos(String cdgoPersona, Date fchaInicio, Date fchaFin, String desgUsuact, String cdgoCargo) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg268HcoCargosDto = tbasg268HcoCargosService.insertHstoCargos(cdgoPersona, fchaInicio, fchaFin, desgUsuact, cdgoCargo);
			return new ResponseEntity<>(tbasg268HcoCargosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertHstoCargos []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	@GetMapping("/update-hsto-cargos")
	public ResponseEntity<?> updateHstoCargos(String cdgoCargo, Date fchaFin, String desgUsuact, String cdgoPersona, Date fchaInicio) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg268HcoCargosDto = tbasg268HcoCargosService.updateHstoCargos(cdgoCargo, fchaFin, desgUsuact, cdgoPersona, fchaInicio);
			return new ResponseEntity<>(tbasg268HcoCargosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateHstoCargos []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-hsto-cargos")
	public ResponseEntity<?> deleteHstoCargos(Tbasg268HcoCargos bean) {
		// Generated from a DELETE found in an XML
		try {
			int tbasg268HcoCargosDto = tbasg268HcoCargosService.deleteHstoCargos(bean);
			return new ResponseEntity<>(tbasg268HcoCargosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteHstoCargos []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
