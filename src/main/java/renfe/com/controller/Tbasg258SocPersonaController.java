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

import renfe.com.model.dto.Tbasg258SocPersonaDto;
import renfe.com.model.entity.Tbasg258SocPersona;
import renfe.com.service.Tbasg258SocPersonaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg258SocPersona")
public class Tbasg258SocPersonaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg258SocPersonaService tbasg258SocPersonaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg258SocPersonaDto>> getAllTbasg258SocPersona(Tbasg258SocPersonaDto filter) {
		return new ResponseEntity<>(tbasg258SocPersonaService.getAllTbasg258SocPersona(filter), HttpStatus.OK);
	}

	@GetMapping("/{idSocpersona}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("idSocpersona") Integer idSocpersona) {
		Tbasg258SocPersonaDto tbasg258SocPersonaData = tbasg258SocPersonaService.findByIdSocpersona(idSocpersona);

		if (tbasg258SocPersonaData != null) {
			return new ResponseEntity<>(tbasg258SocPersonaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg258SocPersonaDto> createTbasg258SocPersona(
			@RequestBody Tbasg258SocPersonaDto tbasg258SocPersonaDto) {
		try {
			return new ResponseEntity<>(tbasg258SocPersonaService.createTbasg258SocPersona(tbasg258SocPersonaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg258SocPersona {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{idSocpersona}")
	public ResponseEntity<Tbasg258SocPersonaDto> updateTbasg258SocPersona(
			@PathVariable("idSocpersona") Integer idSocpersona,
			@RequestBody Tbasg258SocPersonaDto tbasg258SocPersonaDto) {
		try {
			Tbasg258SocPersonaDto tbasg258SocPersonaData = tbasg258SocPersonaService
					.updateTbasg258SocPersona(idSocpersona, tbasg258SocPersonaDto);
			if (tbasg258SocPersonaData != null) {
				return new ResponseEntity<>(tbasg258SocPersonaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg258SocPersona []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{idSocpersona}")
	public ResponseEntity<HttpStatus> deleteTbasg258SocPersona(@PathVariable("idSocpersona") Integer idSocpersona) {
		try {
			tbasg258SocPersonaService.deleteTbasg258SocPersona(idSocpersona);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg258SocPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg258SocPersonaDto>> findByIdSocpersonaIn(List<Integer> idSocpersona) {
		try {
			List<Tbasg258SocPersonaDto> tbasg258SocPersonaDto = tbasg258SocPersonaService
					.findByIdSocpersonaIn(idSocpersona);

			if (tbasg258SocPersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg258SocPersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByIdSocpersonaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-by-cdgo-persona")
	public ResponseEntity<List<Tbasg258SocPersonaDto>> findByCdgoPersona(Integer cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg258SocPersonaDto> tbasg258SocPersonaDto = tbasg258SocPersonaService
					.findByCdgoPersona(cdgoPersona);

			if (tbasg258SocPersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg258SocPersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-by-cdgo-persona-activo")
	public ResponseEntity<List<Tbasg258SocPersonaDto>> findByCdgoPersonaActivo(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg258SocPersonaDto> tbasg258SocPersonaDto = tbasg258SocPersonaService
					.findByCdgoPersonaActivo(cdgoPersona);

			if (tbasg258SocPersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg258SocPersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoPersonaActivo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-by-cdgo-persona-in-activo")
	public ResponseEntity<List<Tbasg258SocPersonaDto>> findByCdgoPersonaInActivo(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg258SocPersonaDto> tbasg258SocPersonaDto = tbasg258SocPersonaService
					.findByCdgoPersonaInActivo(cdgoPersona);

			if (tbasg258SocPersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg258SocPersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoPersonaInActivo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional
	@GetMapping("/insert-soc-persona")
	public ResponseEntity<?> insertSocPersona(Integer cdgoPersona, String cdgoSociedad, Date fechAlta, Date fechBaja) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg258SocPersonaDto = tbasg258SocPersonaService.insertSocPersona(cdgoPersona,cdgoSociedad,fechAlta,fechBaja);
			return new ResponseEntity<>(tbasg258SocPersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertSocPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional
	@GetMapping("/update-soc-persona")
	public ResponseEntity<?> updateSocPersona(Integer idSocPersona, String cdgoSociedad, Date fechAlta, Date fechBaja) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg258SocPersonaDto = tbasg258SocPersonaService.updateSocPersona(idSocPersona,cdgoSociedad,fechAlta,fechBaja);
			return new ResponseEntity<>(tbasg258SocPersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateSocPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
