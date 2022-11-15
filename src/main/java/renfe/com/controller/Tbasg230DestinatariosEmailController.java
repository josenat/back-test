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

import renfe.com.model.dto.Tbasg230DestinatariosEmailDto;
import renfe.com.model.entity.Tbasg230DestinatariosEmail;
import renfe.com.service.Tbasg230DestinatariosEmailService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg230DestinatariosEmail")
public class Tbasg230DestinatariosEmailController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg230DestinatariosEmailService tbasg230DestinatariosEmailService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg230DestinatariosEmailDto>> getAllTbasg230DestinatariosEmail(
			Tbasg230DestinatariosEmailDto filter) {
		return new ResponseEntity<>(tbasg230DestinatariosEmailService.getAllTbasg230DestinatariosEmail(filter),
				HttpStatus.OK);
	}

	@GetMapping("/{desgDireccionEmail}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("desgDireccionEmail") String desgDireccionEmail) {
		Tbasg230DestinatariosEmailDto tbasg230DestinatariosEmailData = tbasg230DestinatariosEmailService
				.findByDesgDireccionEmail(desgDireccionEmail);

		if (tbasg230DestinatariosEmailData != null) {
			return new ResponseEntity<>(tbasg230DestinatariosEmailData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg230DestinatariosEmailDto> createTbasg230DestinatariosEmail(
			@RequestBody Tbasg230DestinatariosEmailDto tbasg230DestinatariosEmailDto) {
		try {
			return new ResponseEntity<>(
					tbasg230DestinatariosEmailService.createTbasg230DestinatariosEmail(tbasg230DestinatariosEmailDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg230DestinatariosEmail {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{desgDireccionEmail}")
	public ResponseEntity<Tbasg230DestinatariosEmailDto> updateTbasg230DestinatariosEmail(
			@PathVariable("desgDireccionEmail") String desgDireccionEmail,
			@RequestBody Tbasg230DestinatariosEmailDto tbasg230DestinatariosEmailDto) {
		try {
			Tbasg230DestinatariosEmailDto tbasg230DestinatariosEmailData = tbasg230DestinatariosEmailService
					.updateTbasg230DestinatariosEmail(desgDireccionEmail, tbasg230DestinatariosEmailDto);
			if (tbasg230DestinatariosEmailData != null) {
				return new ResponseEntity<>(tbasg230DestinatariosEmailData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg230DestinatariosEmail []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{desgDireccionEmail}")
	public ResponseEntity<HttpStatus> deleteTbasg230DestinatariosEmail(
			@PathVariable("desgDireccionEmail") String desgDireccionEmail) {
		try {
			tbasg230DestinatariosEmailService.deleteTbasg230DestinatariosEmail(desgDireccionEmail);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg230DestinatariosEmail []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg230DestinatariosEmailDto>> findByDesgDireccionEmailIn(
			List<String> desgDireccionEmail) {
		try {
			List<Tbasg230DestinatariosEmailDto> tbasg230DestinatariosEmailDto = tbasg230DestinatariosEmailService
					.findByDesgDireccionEmailIn(desgDireccionEmail);

			if (tbasg230DestinatariosEmailDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg230DestinatariosEmailDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByDesgDireccionEmailIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-destinatarios-email-count")
	public ResponseEntity<?> getDestinatariosEmailCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg230DestinatariosEmailDto> tbasg230DestinatariosEmailDto = tbasg230DestinatariosEmailService
					.getDestinatariosEmailCount();

			if (tbasg230DestinatariosEmailDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg230DestinatariosEmailDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDestinatariosEmailCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-destinatario-direccion-count")
	public ResponseEntity<?> getDestinatarioDireccionCount(String desgDireccionEmail) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg230DestinatariosEmailDto> tbasg230DestinatariosEmailDto = tbasg230DestinatariosEmailService
					.getDestinatarioDireccionCount(desgDireccionEmail);

			if (tbasg230DestinatariosEmailDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg230DestinatariosEmailDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDestinatarioDireccionCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-destinatarios-email-list-ascendente")
	public ResponseEntity<List<Tbasg230DestinatariosEmailDto>> getDestinatariosEmailListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg230DestinatariosEmailDto> tbasg230DestinatariosEmailDto = tbasg230DestinatariosEmailService
					.getDestinatariosEmailListAscendente();

			if (tbasg230DestinatariosEmailDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg230DestinatariosEmailDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDestinatariosEmailListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-destinatarios-email-list-descendente")
	public ResponseEntity<List<Tbasg230DestinatariosEmailDto>> getDestinatariosEmailListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg230DestinatariosEmailDto> tbasg230DestinatariosEmailDto = tbasg230DestinatariosEmailService
					.getDestinatariosEmailListDescendente();

			if (tbasg230DestinatariosEmailDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg230DestinatariosEmailDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDestinatariosEmailListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-destinatarios-email-list-active-ascendente")
	public ResponseEntity<List<Tbasg230DestinatariosEmailDto>> getDestinatariosEmailListActiveAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg230DestinatariosEmailDto> tbasg230DestinatariosEmailDto = tbasg230DestinatariosEmailService
					.getDestinatariosEmailListActiveAscendente();

			if (tbasg230DestinatariosEmailDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg230DestinatariosEmailDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDestinatariosEmailListActiveAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-destinatarios-email-list-active-descendente")
	public ResponseEntity<List<Tbasg230DestinatariosEmailDto>> getDestinatariosEmailListActiveDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg230DestinatariosEmailDto> tbasg230DestinatariosEmailDto = tbasg230DestinatariosEmailService
					.getDestinatariosEmailListActiveDescendente();

			if (tbasg230DestinatariosEmailDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg230DestinatariosEmailDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDestinatariosEmailListActiveDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-destinatarios-email")
	public ResponseEntity<List<Tbasg230DestinatariosEmailDto>> getDestinatariosEmail(String desgDireccionEmail) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg230DestinatariosEmailDto> tbasg230DestinatariosEmailDto = tbasg230DestinatariosEmailService
					.getDestinatariosEmail(desgDireccionEmail);

			if (tbasg230DestinatariosEmailDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg230DestinatariosEmailDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDestinatariosEmail []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-destinatarios-email")
	public ResponseEntity<?> insertDestinatariosEmail(@RequestBody Tbasg230DestinatariosEmail bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg230DestinatariosEmailDto = tbasg230DestinatariosEmailService.insertDestinatariosEmail(bean);
			return new ResponseEntity<>(tbasg230DestinatariosEmailDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertDestinatariosEmail []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-destinatario-email")
	public ResponseEntity<?> updateDestinatarioEmail(@RequestBody Tbasg230DestinatariosEmail bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg230DestinatariosEmailDto = tbasg230DestinatariosEmailService.updateDestinatarioEmail(bean);
			return new ResponseEntity<>(tbasg230DestinatariosEmailDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateDestinatarioEmail []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-destinatario-email")
	public ResponseEntity<?> estadoDestinatarioEmail(@RequestBody Tbasg230DestinatariosEmail bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg230DestinatariosEmailDto = tbasg230DestinatariosEmailService.estadoDestinatarioEmail(bean);
			return new ResponseEntity<>(tbasg230DestinatariosEmailDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoDestinatarioEmail []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-destinatario-email-area-null")
	public ResponseEntity<?> updateDestinatarioEmailAreaNull(Tbasg230DestinatariosEmail bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg230DestinatariosEmailDto = tbasg230DestinatariosEmailService.updateDestinatarioEmailAreaNull(bean);
			return new ResponseEntity<>(tbasg230DestinatariosEmailDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateDestinatarioEmailAreaNull []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
