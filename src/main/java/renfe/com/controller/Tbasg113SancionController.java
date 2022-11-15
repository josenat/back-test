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

import renfe.com.model.dto.Tbasg113SancionDto;
import renfe.com.model.entity.Tbasg113Sancion;
import renfe.com.service.Tbasg113SancionService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg113Sancion")
public class Tbasg113SancionController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg113SancionService tbasg113SancionService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg113SancionDto>> getAllTbasg113Sancion(Tbasg113SancionDto filter) {
		return new ResponseEntity<>(tbasg113SancionService.getAllTbasg113Sancion(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoSancion}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoSancion") Integer cdgoSancion) {
		Tbasg113SancionDto tbasg113SancionData = tbasg113SancionService.findByCdgoSancion(cdgoSancion);

		if (tbasg113SancionData != null) {
			return new ResponseEntity<>(tbasg113SancionData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg113SancionDto> createTbasg113Sancion(
			@RequestBody Tbasg113SancionDto tbasg113SancionDto) {
		try {
			return new ResponseEntity<>(tbasg113SancionService.createTbasg113Sancion(tbasg113SancionDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg113Sancion {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoSancion}")
	public ResponseEntity<Tbasg113SancionDto> updateTbasg113Sancion(@PathVariable("cdgoSancion") Integer cdgo,
			@RequestBody Tbasg113SancionDto body) {
		try {
			Tbasg113SancionDto tbasg113SancionData = tbasg113SancionService.updateTbasg113Sancion(cdgo, body);
			if (tbasg113SancionData != null) {
				return new ResponseEntity<>(tbasg113SancionData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg113Sancion []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoSancion}")
	public ResponseEntity<HttpStatus> deleteTbasg113Sancion(@PathVariable("cdgoSancion") Integer cdgoSancion) {
		try {
			tbasg113SancionService.deleteTbasg113Sancion(cdgoSancion);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg113Sancion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg113SancionDto>> findByCdgoSancionIn(List<Integer> cdgoSancion) {
		try {
			List<Tbasg113SancionDto> tbasg113SancionDto = tbasg113SancionService.findByCdgoSancionIn(cdgoSancion);

			if (tbasg113SancionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg113SancionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoSancionIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sancion-count")
	public ResponseEntity<?> getSancionCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg113SancionDto> tbasg113SancionDto = tbasg113SancionService.getSancionCount();

			if (tbasg113SancionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg113SancionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSancionCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sancion-active-count")
	public ResponseEntity<?> getSancionActiveCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg113SancionDto> tbasg113SancionDto = tbasg113SancionService.getSancionActiveCount();

			if (tbasg113SancionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg113SancionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSancionActiveCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sancion-list-ascendente")
	public ResponseEntity<List<Tbasg113SancionDto>> getSancionListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg113SancionDto> tbasg113SancionDto = tbasg113SancionService.getSancionListAscendente();

			if (tbasg113SancionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg113SancionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSancionListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sancion-list-descendente")
	public ResponseEntity<List<Tbasg113SancionDto>> getSancionListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg113SancionDto> tbasg113SancionDto = tbasg113SancionService.getSancionListDescendente();

			if (tbasg113SancionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg113SancionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSancionListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sancion-active-list-ascendente")
	public ResponseEntity<List<Tbasg113SancionDto>> getSancionActiveListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg113SancionDto> tbasg113SancionDto = tbasg113SancionService.getSancionActiveListAscendente();

			if (tbasg113SancionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg113SancionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSancionActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sancion-active-list-descendente")
	public ResponseEntity<List<Tbasg113SancionDto>> getSancionActiveListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg113SancionDto> tbasg113SancionDto = tbasg113SancionService.getSancionActiveListDescendente();

			if (tbasg113SancionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg113SancionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSancionActiveListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sancion")
	public ResponseEntity<List<Tbasg113SancionDto>> getSancion(String cdgoSancion) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg113SancionDto> tbasg113SancionDto = tbasg113SancionService.getSancion(cdgoSancion);

			if (tbasg113SancionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg113SancionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSancion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-sancion")
	public ResponseEntity<?> insertSancion(@RequestBody Tbasg113Sancion bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg113SancionDto = tbasg113SancionService.insertSancion(bean);
			return new ResponseEntity<>(tbasg113SancionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertSancion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-sancion")
	public ResponseEntity<?> updateSancion(@RequestBody Tbasg113Sancion bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg113SancionDto = tbasg113SancionService.updateSancion(bean);
			return new ResponseEntity<>(tbasg113SancionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateSancion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-sancion")
	public ResponseEntity<?> estadoSancion(@RequestBody Tbasg113Sancion bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg113SancionDto = tbasg113SancionService.estadoSancion(bean);
			return new ResponseEntity<>(tbasg113SancionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoSancion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
