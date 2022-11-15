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

import renfe.com.model.dto.Tbasg133SerieDto;
import renfe.com.model.entity.Tbasg133Serie;
import renfe.com.service.Tbasg133SerieService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg133Serie")
public class Tbasg133SerieController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg133SerieService tbasg133SerieService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg133SerieDto>> getAllTbasg133Serie(Tbasg133SerieDto filter) {
		return new ResponseEntity<>(tbasg133SerieService.getAllTbasg133Serie(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoSerie}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoSerie") String cdgoSerie) {
		Tbasg133SerieDto tbasg133SerieData = tbasg133SerieService.findByCdgoSerie(cdgoSerie);

		if (tbasg133SerieData != null) {
			return new ResponseEntity<>(tbasg133SerieData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg133SerieDto> createTbasg133Serie(@RequestBody Tbasg133SerieDto tbasg133SerieDto) {
		try {
			return new ResponseEntity<>(tbasg133SerieService.createTbasg133Serie(tbasg133SerieDto), HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg133Serie {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoSerie}")
	public ResponseEntity<Tbasg133SerieDto> updateTbasg133Serie(@PathVariable("cdgoSerie") String cdgoSerie,
			@RequestBody Tbasg133SerieDto tbasg133SerieDto) {
		try {
			Tbasg133SerieDto tbasg133SerieData = tbasg133SerieService.updateTbasg133Serie(cdgoSerie, tbasg133SerieDto);
			if (tbasg133SerieData != null) {
				return new ResponseEntity<>(tbasg133SerieData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg133Serie []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoSerie}")
	public ResponseEntity<HttpStatus> deleteTbasg133Serie(@PathVariable("cdgoSerie") String cdgoSerie) {
		try {
			tbasg133SerieService.deleteTbasg133Serie(cdgoSerie);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg133Serie []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg133SerieDto>> findByCdgoSerieIn(List<String> cdgoSerie) {
		try {
			List<Tbasg133SerieDto> tbasg133SerieDto = tbasg133SerieService.findByCdgoSerieIn(cdgoSerie);

			if (tbasg133SerieDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg133SerieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoSerieIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-serie-count")
	public ResponseEntity<?> getSerieCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg133SerieDto> tbasg133SerieDto = tbasg133SerieService.getSerieCount();

			if (tbasg133SerieDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg133SerieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSerieCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-serie-list-ascendente")
	public ResponseEntity<List<Tbasg133SerieDto>> getSerieListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg133SerieDto> tbasg133SerieDto = tbasg133SerieService.getSerieListAscendente();

			if (tbasg133SerieDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg133SerieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSerieListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-serie-list-descendente")
	public ResponseEntity<List<Tbasg133SerieDto>> getSerieListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg133SerieDto> tbasg133SerieDto = tbasg133SerieService.getSerieListDescendente();

			if (tbasg133SerieDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg133SerieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSerieListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-serie")
	public ResponseEntity<List<Tbasg133SerieDto>> getSerie(String cdgoSerie) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg133SerieDto> tbasg133SerieDto = tbasg133SerieService.getSerie(cdgoSerie);

			if (tbasg133SerieDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg133SerieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSerie []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-serie-nombre")
	public ResponseEntity<List<Tbasg133SerieDto>> getSerieNombre(String cdgoSerie) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg133SerieDto> tbasg133SerieDto = tbasg133SerieService.getSerieNombre(cdgoSerie);

			if (tbasg133SerieDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg133SerieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSerie []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-serie-by-nombre")
	public ResponseEntity<?> getSerieByNombre(/** FIXME revisar tipo */
	Object nombre) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg133SerieDto> tbasg133SerieDto = tbasg133SerieService.getSerieByNombre(nombre);

			if (tbasg133SerieDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg133SerieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSerieByNombre []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-serie-list-active")
	public ResponseEntity<List<Tbasg133SerieDto>> getSerieListActive() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg133SerieDto> tbasg133SerieDto = tbasg133SerieService.getSerieListActive();

			if (tbasg133SerieDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg133SerieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSerieListActive []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-serie-active-list-ascendente")
	public ResponseEntity<List<Tbasg133SerieDto>> getSerieActiveListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg133SerieDto> tbasg133SerieDto = tbasg133SerieService.getSerieActiveListAscendente();

			if (tbasg133SerieDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg133SerieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSerieActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-serie")
	public ResponseEntity<?> insertSerie(@RequestBody Tbasg133Serie bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg133SerieDto = tbasg133SerieService.insertSerie(bean);
			return new ResponseEntity<>(tbasg133SerieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertSerie []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-serie")
	public ResponseEntity<?> updateSerie(@RequestBody Tbasg133Serie bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg133SerieDto = tbasg133SerieService.updateSerie(bean);
			return new ResponseEntity<>(tbasg133SerieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateSerie []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-serie")
	public ResponseEntity<?> estadoSerie(@RequestBody Tbasg133Serie bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg133SerieDto = tbasg133SerieService.estadoSerie(bean);
			return new ResponseEntity<>(tbasg133SerieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoSerie []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
