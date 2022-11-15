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

import renfe.com.model.dto.Tbasg106ProvinciaDto;
import renfe.com.model.entity.Tbasg106Provincia;
import renfe.com.service.Tbasg106ProvinciaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg106Provincia")
public class Tbasg106ProvinciaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg106ProvinciaService tbasg106ProvinciaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg106ProvinciaDto>> getAllTbasg106Provincia(Tbasg106ProvinciaDto filter) {
		return new ResponseEntity<>(tbasg106ProvinciaService.getAllTbasg106Provincia(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoProvincia}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoProvincia") Integer cdgoProvincia) {
		Tbasg106ProvinciaDto tbasg106ProvinciaData = tbasg106ProvinciaService.findByCdgoProvincia(cdgoProvincia);

		if (tbasg106ProvinciaData != null) {
			return new ResponseEntity<>(tbasg106ProvinciaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg106ProvinciaDto> createTbasg106Provincia(
			@RequestBody Tbasg106ProvinciaDto tbasg106ProvinciaDto) {
		try {
			return new ResponseEntity<>(tbasg106ProvinciaService.createTbasg106Provincia(tbasg106ProvinciaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg106Provincia {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoProvincia}")
	public ResponseEntity<Tbasg106ProvinciaDto> updateTbasg106Provincia(@PathVariable("cdgoProvincia") Integer cdgo,
			@RequestBody Tbasg106ProvinciaDto body) {
		try {
			Tbasg106ProvinciaDto tbasg106ProvinciaData = tbasg106ProvinciaService.updateTbasg106Provincia(cdgo, body);
			if (tbasg106ProvinciaData != null) {
				return new ResponseEntity<>(tbasg106ProvinciaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg106Provincia []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoProvincia}")
	public ResponseEntity<HttpStatus> deleteTbasg106Provincia(@PathVariable("cdgoProvincia") Integer cdgoProvincia) {
		try {
			tbasg106ProvinciaService.deleteTbasg106Provincia(cdgoProvincia);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg106Provincia []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg106ProvinciaDto>> findByCdgoProvinciaIn(List<Integer> cdgoProvincia) {
		try {
			List<Tbasg106ProvinciaDto> tbasg106ProvinciaDto = tbasg106ProvinciaService
					.findByCdgoProvinciaIn(cdgoProvincia);

			if (tbasg106ProvinciaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg106ProvinciaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoProvinciaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-provincia-count")
	public ResponseEntity<?> getProvinciaCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg106ProvinciaDto> tbasg106ProvinciaDto = tbasg106ProvinciaService.getProvinciaCount();

			if (tbasg106ProvinciaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg106ProvinciaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getProvinciaCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-provincia-list-ascendente")
	public ResponseEntity<List<Tbasg106ProvinciaDto>> getProvinciaListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg106ProvinciaDto> tbasg106ProvinciaDto = tbasg106ProvinciaService.getProvinciaListAscendente();

			if (tbasg106ProvinciaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg106ProvinciaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getProvinciaListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-provincia-list-descendente")
	public ResponseEntity<List<Tbasg106ProvinciaDto>> getProvinciaListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg106ProvinciaDto> tbasg106ProvinciaDto = tbasg106ProvinciaService.getProvinciaListDescendente();

			if (tbasg106ProvinciaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg106ProvinciaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getProvinciaListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-provincia-list-active-ascendente")
	public ResponseEntity<List<Tbasg106ProvinciaDto>> getProvinciaListActiveAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg106ProvinciaDto> tbasg106ProvinciaDto = tbasg106ProvinciaService
					.getProvinciaListActiveAscendente();

			if (tbasg106ProvinciaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg106ProvinciaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getProvinciaListActiveAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-provincia-list-active-descendente")
	public ResponseEntity<List<Tbasg106ProvinciaDto>> getProvinciaListActiveDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg106ProvinciaDto> tbasg106ProvinciaDto = tbasg106ProvinciaService
					.getProvinciaListActiveDescendente();

			if (tbasg106ProvinciaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg106ProvinciaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getProvinciaListActiveDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-provincia")
	public ResponseEntity<List<Tbasg106ProvinciaDto>> getProvincia(String cdgoProvincia) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg106ProvinciaDto> tbasg106ProvinciaDto = tbasg106ProvinciaService.getProvincia(cdgoProvincia);

			if (tbasg106ProvinciaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg106ProvinciaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getProvincia []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-provincia")
	public ResponseEntity<?> insertProvincia(@RequestBody Tbasg106Provincia bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg106ProvinciaDto = tbasg106ProvinciaService.insertProvincia(bean);
			return new ResponseEntity<>(tbasg106ProvinciaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertProvincia []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-provincia")
	public ResponseEntity<?> updateProvincia(@RequestBody Tbasg106Provincia bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg106ProvinciaDto = tbasg106ProvinciaService.updateProvincia(bean);
			return new ResponseEntity<>(tbasg106ProvinciaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateProvincia []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-provincia")
	public ResponseEntity<?> estadoProvincia(@RequestBody Tbasg106Provincia bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg106ProvinciaDto = tbasg106ProvinciaService.estadoProvincia(bean);
			return new ResponseEntity<>(tbasg106ProvinciaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoProvincia []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
