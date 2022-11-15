
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

import renfe.com.model.dto.Tbasg129EntornosDto;
import renfe.com.model.entity.Tbasg129Entornos;
import renfe.com.service.Tbasg129EntornosService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg129Entornos")
public class Tbasg129EntornosController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg129EntornosService tbasg129EntornosService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg129EntornosDto>> getAllTbasg129Entornos(Tbasg129EntornosDto filter) {
		return new ResponseEntity<>(tbasg129EntornosService.getAllTbasg129Entornos(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoEntorno}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoEntorno") Integer cdgoEntorno) {
		Tbasg129EntornosDto tbasg129EntornosData = tbasg129EntornosService.findByCdgoEntorno(cdgoEntorno);

		if (tbasg129EntornosData != null) {
			return new ResponseEntity<>(tbasg129EntornosData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg129EntornosDto> createTbasg129Entornos(
			@RequestBody Tbasg129EntornosDto tbasg129EntornosDto) {
		try {
			return new ResponseEntity<>(tbasg129EntornosService.createTbasg129Entornos(tbasg129EntornosDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg129Entornos {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoEntorno}")
	public ResponseEntity<Tbasg129EntornosDto> updateTbasg129Entornos(@PathVariable("cdgoEntorno") Integer cdgo,
			@RequestBody Tbasg129EntornosDto body) {
		try {
			Tbasg129EntornosDto tbasg129EntornosData = tbasg129EntornosService.updateTbasg129Entornos(cdgo, body);
			if (tbasg129EntornosData != null) {
				return new ResponseEntity<>(tbasg129EntornosData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg129Entornos []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoEntorno}")
	public ResponseEntity<HttpStatus> deleteTbasg129Entornos(@PathVariable("cdgoEntorno") Integer cdgoEntorno) {
		try {
			tbasg129EntornosService.deleteTbasg129Entornos(cdgoEntorno);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg129Entornos []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg129EntornosDto>> findByCdgoEntornoIn(List<Integer> cdgoEntorno) {
		try {
			List<Tbasg129EntornosDto> tbasg129EntornosDto = tbasg129EntornosService.findByCdgoEntornoIn(cdgoEntorno);

			if (tbasg129EntornosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg129EntornosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoEntornoIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-entornos-count")
	public ResponseEntity<?> getEntornosCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg129EntornosDto> tbasg129EntornosDto = tbasg129EntornosService.getEntornosCount();

			if (tbasg129EntornosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg129EntornosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEntornosCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-entornos-list-ascendente")
	public ResponseEntity<List<Tbasg129EntornosDto>> getEntornosListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg129EntornosDto> tbasg129EntornosDto = tbasg129EntornosService.getEntornosListAscendente();

			if (tbasg129EntornosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg129EntornosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEntornosListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-entornos-list-descendente")
	public ResponseEntity<List<Tbasg129EntornosDto>> getEntornosListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg129EntornosDto> tbasg129EntornosDto = tbasg129EntornosService.getEntornosListDescendente();

			if (tbasg129EntornosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg129EntornosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEntornosListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-entornos-active-list-ascendente")
	public ResponseEntity<List<Tbasg129EntornosDto>> getEntornosActiveListAscendente(String nombreLargo) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg129EntornosDto> tbasg129EntornosDto = tbasg129EntornosService.getEntornosActiveListAscendente(nombreLargo);

			if (tbasg129EntornosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg129EntornosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEntornosActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-entornos-active-list-descendente")
	public ResponseEntity<List<Tbasg129EntornosDto>> getEntornosActiveListDescendente(String nombreLargo) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg129EntornosDto> tbasg129EntornosDto = tbasg129EntornosService.getEntornosActiveListDescendente(nombreLargo);

			if (tbasg129EntornosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg129EntornosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEntornosActiveListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-entornos-active-with-tramos-list-ascendente")
	public ResponseEntity<List<Tbasg129EntornosDto>> getEntornosActiveWithTramosListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg129EntornosDto> tbasg129EntornosDto = tbasg129EntornosService
					.getEntornosActiveWithTramosListAscendente();

			if (tbasg129EntornosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg129EntornosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEntornosActiveWithTramosListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-entornos-active-with-tramos-list-descendente")
	public ResponseEntity<List<Tbasg129EntornosDto>> getEntornosActiveWithTramosListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg129EntornosDto> tbasg129EntornosDto = tbasg129EntornosService
					.getEntornosActiveWithTramosListDescendente();

			if (tbasg129EntornosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg129EntornosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEntornosActiveWithTramosListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-entornos")
	public ResponseEntity<List<Tbasg129EntornosDto>> getEntornos(Integer cdgoEntorno) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg129EntornosDto> tbasg129EntornosDto = tbasg129EntornosService.getEntornos(cdgoEntorno);

			if (tbasg129EntornosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg129EntornosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEntornos []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-entornos-nombre")
	public ResponseEntity<List<Tbasg129EntornosDto>> getEntornosNombre(String cdgoEntorno) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg129EntornosDto> tbasg129EntornosDto = tbasg129EntornosService.getEntornosNombre(cdgoEntorno);

			if (tbasg129EntornosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg129EntornosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEntornos []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@GetMapping("/get-alcance-entornos")
	public ResponseEntity<List<Tbasg129EntornosDto>> getAlcanceEntorno(Integer cdgoEntorno) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg129EntornosDto> tbasg129EntornosDto = tbasg129EntornosService.getAlcanceEntorno(cdgoEntorno);

			if (tbasg129EntornosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg129EntornosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAlcanceEntorno []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-entornos-by-nom-corto")
	public ResponseEntity<?> getEntornosByNomCorto(String desgNomcorto) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg129EntornosDto> tbasg129EntornosDto = tbasg129EntornosService.getEntornosByNomCorto(desgNomcorto);

			if (tbasg129EntornosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg129EntornosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEntornosByNomCorto []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-entornos")
	public ResponseEntity<?> insertEntornos(Tbasg129Entornos bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg129EntornosDto = tbasg129EntornosService.insertEntornos(bean);
			return new ResponseEntity<>(tbasg129EntornosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertEntornos []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-entornos")
	public ResponseEntity<?> updateEntornos(Tbasg129Entornos bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg129EntornosDto = tbasg129EntornosService.updateEntornos(bean);
			return new ResponseEntity<>(tbasg129EntornosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateEntornos []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}