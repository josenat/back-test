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

import renfe.com.dto.GetSubSerieListAscCdgoSerieDTO;
import renfe.com.model.dto.Tbasg147SubserieDto;
import renfe.com.model.entity.Tbasg147Subserie;
import renfe.com.service.Tbasg147SubserieService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg147Subserie")
public class Tbasg147SubserieController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg147SubserieService tbasg147SubserieService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg147SubserieDto>> getAllTbasg147Subserie(Tbasg147SubserieDto filter) {
		return new ResponseEntity<>(tbasg147SubserieService.getAllTbasg147Subserie(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoSerie}/{cdgoSubserie}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoSerie") String cdgoSerie,
			@PathVariable("cdgoSubserie") String cdgoSubserie) {
		Tbasg147SubserieDto tbasg147SubserieData = tbasg147SubserieService.findByCdgoSerieCdgoSubserie(cdgoSerie,
				cdgoSubserie);

		if (tbasg147SubserieData != null) {
			return new ResponseEntity<>(tbasg147SubserieData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg147SubserieDto> createTbasg147Subserie(
			@RequestBody Tbasg147SubserieDto tbasg147SubserieDto) {
		try {
			return new ResponseEntity<>(tbasg147SubserieService.createTbasg147Subserie(tbasg147SubserieDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg147Subserie {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoSerie}/{cdgoSubserie}")
	public ResponseEntity<Tbasg147SubserieDto> updateTbasg147Subserie(@PathVariable("cdgoSerie") String cdgoSerie,
			@PathVariable("cdgoSubserie") String cdgoSubserie, @RequestBody Tbasg147SubserieDto tbasg147SubserieDto) {
		try {
			Tbasg147SubserieDto tbasg147SubserieData = tbasg147SubserieService.updateTbasg147Subserie(cdgoSerie,
					cdgoSubserie, tbasg147SubserieDto);
			if (tbasg147SubserieData != null) {
				return new ResponseEntity<>(tbasg147SubserieData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg147Subserie []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoSerie}/{cdgoSubserie}")
	public ResponseEntity<HttpStatus> deleteTbasg147Subserie(@PathVariable("cdgoSerie") String cdgoSerie,
			@PathVariable("cdgoSubserie") String cdgoSubserie) {
		try {
			tbasg147SubserieService.deleteTbasg147Subserie(cdgoSerie, cdgoSubserie);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg147Subserie []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg147SubserieDto>> findByCdgoSerieCdgoSubserieIn(List<String> cdgoSerie,
			List<String> cdgoSubserie) {
		try {
			List<Tbasg147SubserieDto> tbasg147SubserieDto = tbasg147SubserieService
					.findByCdgoSerieCdgoSubserieIn(cdgoSerie, cdgoSubserie);

			if (tbasg147SubserieDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg147SubserieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoSerieCdgoSubserieIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sub-serie")
	public ResponseEntity<List<Tbasg147SubserieDto>> getSubSerie(String cdgoSerie, String cdgoSubserie) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg147SubserieDto> tbasg147SubserieDto = tbasg147SubserieService.getSubSerie(cdgoSerie,
					cdgoSubserie);

			if (tbasg147SubserieDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg147SubserieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSubSerie []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sub-serie-list-ascendente")
	public ResponseEntity<List<Tbasg147SubserieDto>> getSubSerieListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg147SubserieDto> tbasg147SubserieDto = tbasg147SubserieService.getSubSerieListAscendente();

			if (tbasg147SubserieDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg147SubserieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSubSerieListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sub-serie-list-descendente")
	public ResponseEntity<List<Tbasg147SubserieDto>> getSubSerieListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg147SubserieDto> tbasg147SubserieDto = tbasg147SubserieService.getSubSerieListDescendente();

			if (tbasg147SubserieDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg147SubserieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSubSerieListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sub-serie-list-ascendente-view")
	public ResponseEntity<List<Tbasg147SubserieDto>> getSubSerieListAscendenteView() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg147SubserieDto> tbasg147SubserieDto = tbasg147SubserieService.getSubSerieListAscendenteView();

			if (tbasg147SubserieDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg147SubserieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSubSerieListAscendenteView []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sub-serie-list-descendente-view")
	public ResponseEntity<List<Tbasg147SubserieDto>> getSubSerieListDescendenteView() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg147SubserieDto> tbasg147SubserieDto = tbasg147SubserieService.getSubSerieListDescendenteView();

			if (tbasg147SubserieDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg147SubserieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSubSerieListDescendenteView []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sub-serie-list-asc-cdgo-serie")
	public ResponseEntity<List<GetSubSerieListAscCdgoSerieDTO>> getSubSerieListAscendenteViewCDGO_SUBSERIE(String cdgoSerie) {
		// Generated from a SELECT found in an XML
		try {
			List<GetSubSerieListAscCdgoSerieDTO> tbasg147SubserieDto = tbasg147SubserieService
					.getSubSerieListAscendenteViewCDGO_SUBSERIE(cdgoSerie);

			if (tbasg147SubserieDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg147SubserieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSubSerieListAscendenteViewCDGO_SUBSERIE []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sub-serie-list-descendente-view-c-d-g-o_-s-u-b-s-e-r-i-e")
	public ResponseEntity<List<Tbasg147SubserieDto>> getSubSerieListDescendenteViewCDGO_SUBSERIE(String cdgoSerie) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg147SubserieDto> tbasg147SubserieDto = tbasg147SubserieService
					.getSubSerieListDescendenteViewCDGO_SUBSERIE(cdgoSerie);

			if (tbasg147SubserieDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg147SubserieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSubSerieListDescendenteViewCDGO_SUBSERIE []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sub-serie-count")
	public ResponseEntity<?> getSubSerieCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg147SubserieDto> tbasg147SubserieDto = tbasg147SubserieService.getSubSerieCount();

			if (tbasg147SubserieDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg147SubserieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSubSerieCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sub-serie-view-count")
	public ResponseEntity<?> getSubSerieViewCount(String cdgoSerie) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg147SubserieDto> tbasg147SubserieDto = tbasg147SubserieService.getSubSerieViewCount(cdgoSerie);

			if (tbasg147SubserieDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg147SubserieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSubSerieViewCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-sub-serie-list-active")
	public ResponseEntity<List<Tbasg147SubserieDto>> getSubSerieListActive() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg147SubserieDto> tbasg147SubserieDto = tbasg147SubserieService.getSubSerieListActive();

			if (tbasg147SubserieDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg147SubserieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getSubSerieListActive []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-sub-serie")
	public ResponseEntity<?> insertSubSerie(@RequestBody Tbasg147Subserie bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg147SubserieDto = tbasg147SubserieService.insertSubSerie(bean);
			return new ResponseEntity<>(tbasg147SubserieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertSubSerie []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-sub-serie")
	public ResponseEntity<?> updateSubSerie(Tbasg147Subserie bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg147SubserieDto = tbasg147SubserieService.updateSubSerie(bean);
			return new ResponseEntity<>(tbasg147SubserieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateSubSerie []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-sub-serie")
	public ResponseEntity<?> estadoSubSerie(@RequestBody Tbasg147Subserie bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg147SubserieDto = tbasg147SubserieService.estadoSubSerie(bean);
			return new ResponseEntity<>(tbasg147SubserieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoSubSerie []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-sub-serie")
	public ResponseEntity<?> deleteSubSerie(Tbasg147Subserie bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg147SubserieDto = tbasg147SubserieService.deleteSubSerie(bean);
			return new ResponseEntity<>(tbasg147SubserieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteSubSerie []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/reactive-sub-serie")
	public ResponseEntity<?> reactiveSubSerie(Tbasg147Subserie bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg147SubserieDto = tbasg147SubserieService.reactiveSubSerie(bean);
			return new ResponseEntity<>(tbasg147SubserieDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("reactiveSubSerie []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
