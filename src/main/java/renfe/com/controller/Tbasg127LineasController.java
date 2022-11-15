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

import renfe.com.model.dto.Tbasg127LineasDto;
import renfe.com.model.entity.Tbasg127Lineas;
import renfe.com.service.Tbasg127LineasService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg127Lineas")
public class Tbasg127LineasController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg127LineasService tbasg127LineasService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg127LineasDto>> getAllTbasg127Lineas(Tbasg127LineasDto filter) {
		return new ResponseEntity<>(tbasg127LineasService.getAllTbasg127Lineas(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoLinea}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoLinea") String cdgoLinea) {
		Tbasg127LineasDto tbasg127LineasData = tbasg127LineasService.findByCdgoLinea(cdgoLinea);

		if (tbasg127LineasData != null) {
			return new ResponseEntity<>(tbasg127LineasData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg127LineasDto> createTbasg127Lineas(@RequestBody Tbasg127LineasDto tbasg127LineasDto) {
		try {
			return new ResponseEntity<>(tbasg127LineasService.createTbasg127Lineas(tbasg127LineasDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg127Lineas {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoLinea}")
	public ResponseEntity<Tbasg127LineasDto> updateTbasg127Lineas(@PathVariable("cdgoLinea") String cdgoLinea,
			@RequestBody Tbasg127LineasDto tbasg127LineasDto) {
		try {
			Tbasg127LineasDto tbasg127LineasData = tbasg127LineasService.updateTbasg127Lineas(cdgoLinea,
					tbasg127LineasDto);
			if (tbasg127LineasData != null) {
				return new ResponseEntity<>(tbasg127LineasData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg127Lineas []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoLinea}")
	public ResponseEntity<HttpStatus> deleteTbasg127Lineas(@PathVariable("cdgoLinea") String cdgoLinea) {
		try {
			tbasg127LineasService.deleteTbasg127Lineas(cdgoLinea);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg127Lineas []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg127LineasDto>> findByCdgoLineaIn(List<String> cdgoLinea) {
		try {
			List<Tbasg127LineasDto> tbasg127LineasDto = tbasg127LineasService.findByCdgoLineaIn(cdgoLinea);

			if (tbasg127LineasDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg127LineasDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoLineaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-lineas-count")
	public ResponseEntity<?> getLineasCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg127LineasDto> tbasg127LineasDto = tbasg127LineasService.getLineasCount();

			if (tbasg127LineasDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg127LineasDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getLineasCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-lineas-list-ascendente")
	public ResponseEntity<List<Tbasg127LineasDto>> getLineasListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg127LineasDto> tbasg127LineasDto = tbasg127LineasService.getLineasListAscendente();

			if (tbasg127LineasDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg127LineasDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getLineasListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-lineas-list-descendente")
	public ResponseEntity<List<Tbasg127LineasDto>> getLineasListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg127LineasDto> tbasg127LineasDto = tbasg127LineasService.getLineasListDescendente();

			if (tbasg127LineasDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg127LineasDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getLineasListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-lineas-active-list-ascendente")
	public ResponseEntity<List<Tbasg127LineasDto>> getLineasActiveListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg127LineasDto> tbasg127LineasDto = tbasg127LineasService.getLineasActiveListAscendente();

			if (tbasg127LineasDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg127LineasDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getLineasActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-lineas-active-list-descendente")
	public ResponseEntity<List<Tbasg127LineasDto>> getLineasActiveListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg127LineasDto> tbasg127LineasDto = tbasg127LineasService.getLineasActiveListDescendente();

			if (tbasg127LineasDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg127LineasDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getLineasActiveListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-lineas")
	public ResponseEntity<List<Tbasg127LineasDto>> getLineas(String cdgoLinea) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg127LineasDto> tbasg127LineasDto = tbasg127LineasService.getLineas(cdgoLinea);

			if (tbasg127LineasDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg127LineasDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getLineas []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-alcance-lineas")
	public ResponseEntity<List<Tbasg127LineasDto>> getAlcanceLinea(String cdgoLinea) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg127LineasDto> tbasg127LineasDto = tbasg127LineasService.getAlcanceLinea(cdgoLinea);

			if (tbasg127LineasDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg127LineasDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAlcanceLinea []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-lineas-list-dynamic")
	public ResponseEntity<List<Tbasg127LineasDto>> getLineasListDynamic() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg127LineasDto> tbasg127LineasDto = tbasg127LineasService.getLineasListDynamic();

			if (tbasg127LineasDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg127LineasDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getLineasListDynamic []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-lineas")
	public ResponseEntity<?> insertLineas(@RequestBody Tbasg127Lineas bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg127LineasDto = tbasg127LineasService.insertLineas(bean);
			return new ResponseEntity<>(tbasg127LineasDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertLineas []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-lineas")
	public ResponseEntity<?> updateLineas(@RequestBody Tbasg127Lineas bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg127LineasDto = tbasg127LineasService.updateLineas(bean);
			return new ResponseEntity<>(tbasg127LineasDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateLineas []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-lineas")
	public ResponseEntity<?> estadoLineas(@RequestBody Tbasg127Lineas bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg127LineasDto = tbasg127LineasService.estadoLineas(bean);
			return new ResponseEntity<>(tbasg127LineasDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoLineas []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-lineas")
	public ResponseEntity<?> deleteLineas(Tbasg127Lineas bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg127LineasDto = tbasg127LineasService.deleteLineas(bean);
			return new ResponseEntity<>(tbasg127LineasDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteLineas []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/reactive-lineas")
	public ResponseEntity<?> reactiveLineas(Tbasg127Lineas bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg127LineasDto = tbasg127LineasService.reactiveLineas(bean);
			return new ResponseEntity<>(tbasg127LineasDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("reactiveLineas []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
