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

import renfe.com.model.dto.Tbasg176DocOrdenActiClaveDto;
import renfe.com.service.Tbasg176DocOrdenActiClaveService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg176DocOrdenActiClave")
public class Tbasg176DocOrdenActiClaveController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg176DocOrdenActiClaveService tbasg176DocOrdenActiClaveService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg176DocOrdenActiClaveDto>> getAllTbasg176DocOrdenActiClave(
			Tbasg176DocOrdenActiClaveDto filter) {
		return new ResponseEntity<>(tbasg176DocOrdenActiClaveService.getAllTbasg176DocOrdenActiClave(filter),
				HttpStatus.OK);
	}

	@GetMapping("/{cdgoClave}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoClave") Integer cdgoClave) {
		Tbasg176DocOrdenActiClaveDto tbasg176DocOrdenActiClaveData = tbasg176DocOrdenActiClaveService
				.findByCdgoClave(cdgoClave);

		if (tbasg176DocOrdenActiClaveData != null) {
			return new ResponseEntity<>(tbasg176DocOrdenActiClaveData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg176DocOrdenActiClaveDto> createTbasg176DocOrdenActiClave(
			@RequestBody Tbasg176DocOrdenActiClaveDto tbasg176DocOrdenActiClaveDto) {
		try {
			return new ResponseEntity<>(
					tbasg176DocOrdenActiClaveService.createTbasg176DocOrdenActiClave(tbasg176DocOrdenActiClaveDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg176DocOrdenActiClave {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoClave}")
	public ResponseEntity<Tbasg176DocOrdenActiClaveDto> updateTbasg176DocOrdenActiClave(
			@PathVariable("cdgoClave") Integer cdgo, @RequestBody Tbasg176DocOrdenActiClaveDto body) {
		try {
			Tbasg176DocOrdenActiClaveDto tbasg176DocOrdenActiClaveData = tbasg176DocOrdenActiClaveService
					.updateTbasg176DocOrdenActiClave(cdgo, body);
			if (tbasg176DocOrdenActiClaveData != null) {
				return new ResponseEntity<>(tbasg176DocOrdenActiClaveData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg176DocOrdenActiClave []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoClave}")
	public ResponseEntity<HttpStatus> deleteTbasg176DocOrdenActiClave(@PathVariable("cdgoClave") Integer cdgoClave) {
		try {
			tbasg176DocOrdenActiClaveService.deleteTbasg176DocOrdenActiClave(cdgoClave);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg176DocOrdenActiClave []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg176DocOrdenActiClaveDto>> findByCdgoClaveIn(List<Integer> cdgoClave) {
		try {
			List<Tbasg176DocOrdenActiClaveDto> tbasg176DocOrdenActiClaveDto = tbasg176DocOrdenActiClaveService
					.findByCdgoClaveIn(cdgoClave);

			if (tbasg176DocOrdenActiClaveDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg176DocOrdenActiClaveDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoClaveIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-doc-orden-acti-clave-active-list")
	public ResponseEntity<List<Tbasg176DocOrdenActiClaveDto>> getDocOrdenActiClaveActiveList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg176DocOrdenActiClaveDto> tbasg176DocOrdenActiClaveDto = tbasg176DocOrdenActiClaveService
					.getDocOrdenActiClaveActiveList();

			if (tbasg176DocOrdenActiClaveDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg176DocOrdenActiClaveDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDocOrdenActiClaveActiveList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
