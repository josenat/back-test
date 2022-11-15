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

import renfe.com.model.dto.Tbasg174DocOrdenSuspClaveDto;
import renfe.com.service.Tbasg174DocOrdenSuspClaveService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg174DocOrdenSuspClave")
public class Tbasg174DocOrdenSuspClaveController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg174DocOrdenSuspClaveService tbasg174DocOrdenSuspClaveService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg174DocOrdenSuspClaveDto>> getAllTbasg174DocOrdenSuspClave(
			Tbasg174DocOrdenSuspClaveDto filter) {
		return new ResponseEntity<>(tbasg174DocOrdenSuspClaveService.getAllTbasg174DocOrdenSuspClave(filter),
				HttpStatus.OK);
	}

	@GetMapping("/{cdgoClave}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoClave") Integer cdgoClave) {
		Tbasg174DocOrdenSuspClaveDto tbasg174DocOrdenSuspClaveData = tbasg174DocOrdenSuspClaveService
				.findByCdgoClave(cdgoClave);

		if (tbasg174DocOrdenSuspClaveData != null) {
			return new ResponseEntity<>(tbasg174DocOrdenSuspClaveData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg174DocOrdenSuspClaveDto> createTbasg174DocOrdenSuspClave(
			@RequestBody Tbasg174DocOrdenSuspClaveDto tbasg174DocOrdenSuspClaveDto) {
		try {
			return new ResponseEntity<>(
					tbasg174DocOrdenSuspClaveService.createTbasg174DocOrdenSuspClave(tbasg174DocOrdenSuspClaveDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg174DocOrdenSuspClave {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoClave}")
	public ResponseEntity<Tbasg174DocOrdenSuspClaveDto> updateTbasg174DocOrdenSuspClave(
			@PathVariable("cdgoClave") Integer cdgo, @RequestBody Tbasg174DocOrdenSuspClaveDto body) {
		try {
			Tbasg174DocOrdenSuspClaveDto tbasg174DocOrdenSuspClaveData = tbasg174DocOrdenSuspClaveService
					.updateTbasg174DocOrdenSuspClave(cdgo, body);
			if (tbasg174DocOrdenSuspClaveData != null) {
				return new ResponseEntity<>(tbasg174DocOrdenSuspClaveData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg174DocOrdenSuspClave []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoClave}")
	public ResponseEntity<HttpStatus> deleteTbasg174DocOrdenSuspClave(@PathVariable("cdgoClave") Integer cdgoClave) {
		try {
			tbasg174DocOrdenSuspClaveService.deleteTbasg174DocOrdenSuspClave(cdgoClave);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg174DocOrdenSuspClave []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg174DocOrdenSuspClaveDto>> findByCdgoClaveIn(List<Integer> cdgoClave) {
		try {
			List<Tbasg174DocOrdenSuspClaveDto> tbasg174DocOrdenSuspClaveDto = tbasg174DocOrdenSuspClaveService
					.findByCdgoClaveIn(cdgoClave);

			if (tbasg174DocOrdenSuspClaveDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg174DocOrdenSuspClaveDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoClaveIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-doc-orden-susp-clave-active-list")
	public ResponseEntity<List<Tbasg174DocOrdenSuspClaveDto>> getDocOrdenSuspClaveActiveList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg174DocOrdenSuspClaveDto> tbasg174DocOrdenSuspClaveDto = tbasg174DocOrdenSuspClaveService
					.getDocOrdenSuspClaveActiveList();

			if (tbasg174DocOrdenSuspClaveDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg174DocOrdenSuspClaveDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDocOrdenSuspClaveActiveList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
