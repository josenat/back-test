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

import renfe.com.model.dto.Tbasg137EspecialiDto;
import renfe.com.model.entity.Tbasg137Especiali;
import renfe.com.service.Tbasg137EspecialiService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg137Especiali")
public class Tbasg137EspecialiController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg137EspecialiService tbasg137EspecialiService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg137EspecialiDto>> getAllTbasg137Especiali(Tbasg137EspecialiDto filter) {
		return new ResponseEntity<>(tbasg137EspecialiService.getAllTbasg137Especiali(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoEspec}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoEspec") Integer cdgoEspec) {
		Tbasg137EspecialiDto tbasg137EspecialiData = tbasg137EspecialiService.findByCdgoEspec(cdgoEspec);

		if (tbasg137EspecialiData != null) {
			return new ResponseEntity<>(tbasg137EspecialiData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg137EspecialiDto> createTbasg137Especiali(
			@RequestBody Tbasg137EspecialiDto tbasg137EspecialiDto) {
		try {
			return new ResponseEntity<>(tbasg137EspecialiService.createTbasg137Especiali(tbasg137EspecialiDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg137Especiali {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoEspec}")
	public ResponseEntity<Tbasg137EspecialiDto> updateTbasg137Especiali(@PathVariable("cdgoEspec") Integer cdgo,
			@RequestBody Tbasg137EspecialiDto body) {
		try {
			Tbasg137EspecialiDto tbasg137EspecialiData = tbasg137EspecialiService.updateTbasg137Especiali(cdgo, body);
			if (tbasg137EspecialiData != null) {
				return new ResponseEntity<>(tbasg137EspecialiData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg137Especiali []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoEspec}")
	public ResponseEntity<HttpStatus> deleteTbasg137Especiali(@PathVariable("cdgoEspec") Integer cdgoEspec) {
		try {
			tbasg137EspecialiService.deleteTbasg137Especiali(cdgoEspec);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg137Especiali []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg137EspecialiDto>> findByCdgoEspecIn(List<Integer> cdgoEspec) {
		try {
			List<Tbasg137EspecialiDto> tbasg137EspecialiDto = tbasg137EspecialiService.findByCdgoEspecIn(cdgoEspec);

			if (tbasg137EspecialiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg137EspecialiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoEspecIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-especiali-count")
	public ResponseEntity<?> getEspecialiCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg137EspecialiDto> tbasg137EspecialiDto = tbasg137EspecialiService.getEspecialiCount();

			if (tbasg137EspecialiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg137EspecialiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEspecialiCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-especiali-list-ascendente")
	public ResponseEntity<List<Tbasg137EspecialiDto>> getEspecialiListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg137EspecialiDto> tbasg137EspecialiDto = tbasg137EspecialiService.getEspecialiListAscendente();

			if (tbasg137EspecialiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg137EspecialiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEspecialiListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-especiali-list-descendente")
	public ResponseEntity<List<Tbasg137EspecialiDto>> getEspecialiListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg137EspecialiDto> tbasg137EspecialiDto = tbasg137EspecialiService.getEspecialiListDescendente();

			if (tbasg137EspecialiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg137EspecialiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEspecialiListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-especiali")
	public ResponseEntity<List<Tbasg137EspecialiDto>> getEspeciali(Integer cdgoEspec) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg137EspecialiDto> tbasg137EspecialiDto = tbasg137EspecialiService.getEspeciali(cdgoEspec);

			if (tbasg137EspecialiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg137EspecialiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEspeciali []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-especiali-nombre")
	public ResponseEntity<List<Tbasg137EspecialiDto>> getEspecialiNombre(String cdgoEspec) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg137EspecialiDto> tbasg137EspecialiDto = tbasg137EspecialiService.getEspecialiNombre(cdgoEspec);

			if (tbasg137EspecialiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg137EspecialiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEspeciali []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-alcance-especiali")
	public ResponseEntity<List<Tbasg137EspecialiDto>> getAlcanceEspeciali(Integer cdgoEspec) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg137EspecialiDto> tbasg137EspecialiDto = tbasg137EspecialiService.getAlcanceEspeciali(cdgoEspec);

			if (tbasg137EspecialiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg137EspecialiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAlcanceEspeciali []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-especiali-active-list")
	public ResponseEntity<List<Tbasg137EspecialiDto>> getEspecialiActiveList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg137EspecialiDto> tbasg137EspecialiDto = tbasg137EspecialiService.getEspecialiActiveList();

			if (tbasg137EspecialiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg137EspecialiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEspecialiActiveList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-especiali")
	public ResponseEntity<?> insertEspeciali(@RequestBody Tbasg137Especiali bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg137EspecialiDto = tbasg137EspecialiService.insertEspeciali(bean);
			return new ResponseEntity<>(tbasg137EspecialiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertEspeciali []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-especiali")
	public ResponseEntity<?> updateEspeciali(@RequestBody Tbasg137Especiali bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg137EspecialiDto = tbasg137EspecialiService.updateEspeciali(bean);
			return new ResponseEntity<>(tbasg137EspecialiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateEspeciali []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-especiali")
	public ResponseEntity<?> estadoEspeciali(@RequestBody Tbasg137Especiali bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg137EspecialiDto = tbasg137EspecialiService.estadoEspeciali(bean);
			return new ResponseEntity<>(tbasg137EspecialiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoEspeciali []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}