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

import renfe.com.model.dto.Tbasg134NacionDto;
import renfe.com.model.entity.Tbasg134Nacion;
import renfe.com.service.Tbasg134NacionService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg134Nacion")
public class Tbasg134NacionController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg134NacionService tbasg134NacionService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg134NacionDto>> getAllTbasg134Nacion(Tbasg134NacionDto filter) {
		return new ResponseEntity<>(tbasg134NacionService.getAllTbasg134Nacion(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoNacion}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoNacion") Integer cdgoNacion) {
		Tbasg134NacionDto tbasg134NacionData = tbasg134NacionService.findByCdgoNacion(cdgoNacion);

		if (tbasg134NacionData != null) {
			return new ResponseEntity<>(tbasg134NacionData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg134NacionDto> createTbasg134Nacion(@RequestBody Tbasg134NacionDto tbasg134NacionDto) {
		try {
			return new ResponseEntity<>(tbasg134NacionService.createTbasg134Nacion(tbasg134NacionDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg134Nacion {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoNacion}")
	public ResponseEntity<Tbasg134NacionDto> updateTbasg134Nacion(@PathVariable("cdgoNacion") Integer cdgo,
			@RequestBody Tbasg134NacionDto body) {
		try {
			Tbasg134NacionDto tbasg134NacionData = tbasg134NacionService.updateTbasg134Nacion(cdgo, body);
			if (tbasg134NacionData != null) {
				return new ResponseEntity<>(tbasg134NacionData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg134Nacion []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoNacion}")
	public ResponseEntity<HttpStatus> deleteTbasg134Nacion(@PathVariable("cdgoNacion") Integer cdgoNacion) {
		try {
			tbasg134NacionService.deleteTbasg134Nacion(cdgoNacion);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg134Nacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg134NacionDto>> findByCdgoNacionIn(List<Integer> cdgoNacion) {
		try {
			List<Tbasg134NacionDto> tbasg134NacionDto = tbasg134NacionService.findByCdgoNacionIn(cdgoNacion);

			if (tbasg134NacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg134NacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoNacionIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-nacion-count")
	public ResponseEntity<?> getNacionCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg134NacionDto> tbasg134NacionDto = tbasg134NacionService.getNacionCount();

			if (tbasg134NacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg134NacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getNacionCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-nacion-list-ascendente")
	public ResponseEntity<List<Tbasg134NacionDto>> getNacionListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg134NacionDto> tbasg134NacionDto = tbasg134NacionService.getNacionListAscendente();

			if (tbasg134NacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg134NacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getNacionListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-nacion-list-descendente")
	public ResponseEntity<List<Tbasg134NacionDto>> getNacionListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg134NacionDto> tbasg134NacionDto = tbasg134NacionService.getNacionListDescendente();

			if (tbasg134NacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg134NacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getNacionListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-nacion-active-list-ascendente")
	public ResponseEntity<List<Tbasg134NacionDto>> getNacionActiveListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg134NacionDto> tbasg134NacionDto = tbasg134NacionService.getNacionActiveListAscendente();

			if (tbasg134NacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg134NacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getNacionActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-nacion-active-list-descendente")
	public ResponseEntity<List<Tbasg134NacionDto>> getNacionActiveListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg134NacionDto> tbasg134NacionDto = tbasg134NacionService.getNacionActiveListDescendente();

			if (tbasg134NacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg134NacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getNacionActiveListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-nacion")
	public ResponseEntity<List<Tbasg134NacionDto>> getNacion(String cdgoNacion) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg134NacionDto> tbasg134NacionDto = tbasg134NacionService.getNacion(cdgoNacion);

			if (tbasg134NacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg134NacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getNacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-nacion")
	public ResponseEntity<?> insertNacion(@RequestBody Tbasg134Nacion bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg134NacionDto = tbasg134NacionService.insertNacion(bean);
			return new ResponseEntity<>(tbasg134NacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertNacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-nacion")
	public ResponseEntity<?> updateNacion(@RequestBody Tbasg134Nacion bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg134NacionDto = tbasg134NacionService.updateNacion(bean);
			return new ResponseEntity<>(tbasg134NacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateNacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-nacion")
	public ResponseEntity<?> estadoNacion(@RequestBody Tbasg134Nacion bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg134NacionDto = tbasg134NacionService.estadoNacion(bean);
			return new ResponseEntity<>(tbasg134NacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoNacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
