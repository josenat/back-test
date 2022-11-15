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

import renfe.com.model.dto.Tbasg135CargoDto;
import renfe.com.model.entity.Tbasg135Cargo;
import renfe.com.service.Tbasg135CargoService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg135Cargo")
public class Tbasg135CargoController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg135CargoService tbasg135CargoService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg135CargoDto>> getAllTbasg135Cargo(Tbasg135CargoDto filter) {
		return new ResponseEntity<>(tbasg135CargoService.getAllTbasg135Cargo(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoCargo}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoCargo") String cdgoCargo) {
		Tbasg135CargoDto tbasg135CargoData = tbasg135CargoService.findByCdgoCargo(cdgoCargo);

		if (tbasg135CargoData != null) {
			return new ResponseEntity<>(tbasg135CargoData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg135CargoDto> createTbasg135Cargo(@RequestBody Tbasg135CargoDto tbasg135CargoDto) {
		try {
			return new ResponseEntity<>(tbasg135CargoService.createTbasg135Cargo(tbasg135CargoDto), HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg135Cargo {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoCargo}")
	public ResponseEntity<Tbasg135CargoDto> updateTbasg135Cargo(@PathVariable("cdgoCargo") String cdgoCargo,
			@RequestBody Tbasg135CargoDto tbasg135CargoDto) {
		try {
			Tbasg135CargoDto tbasg135CargoData = tbasg135CargoService.updateTbasg135Cargo(cdgoCargo, tbasg135CargoDto);
			if (tbasg135CargoData != null) {
				return new ResponseEntity<>(tbasg135CargoData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg135Cargo []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoCargo}")
	public ResponseEntity<HttpStatus> deleteTbasg135Cargo(@PathVariable("cdgoCargo") String cdgoCargo) {
		try {
			tbasg135CargoService.deleteTbasg135Cargo(cdgoCargo);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg135Cargo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg135CargoDto>> findByCdgoCargoIn(List<String> cdgoCargo) {
		try {
			List<Tbasg135CargoDto> tbasg135CargoDto = tbasg135CargoService.findByCdgoCargoIn(cdgoCargo);

			if (tbasg135CargoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg135CargoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoCargoIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-cargos-altas-cargo")
	public ResponseEntity<List<Tbasg135CargoDto>> getCargosAltasCargo() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg135CargoDto> tbasg135CargoDto = tbasg135CargoService.getCargoAltasCargo();

			if (tbasg135CargoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg135CargoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCargo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cargo")
	public ResponseEntity<List<Tbasg135CargoDto>> getCargo(String cdgoCargo) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg135CargoDto> tbasg135CargoDto = tbasg135CargoService.getCargo(cdgoCargo);

			if (tbasg135CargoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg135CargoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCargo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cargo-list-ascendente")
	public ResponseEntity<List<Tbasg135CargoDto>> getCargoListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg135CargoDto> tbasg135CargoDto = tbasg135CargoService.getCargoListAscendente();

			if (tbasg135CargoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg135CargoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCargoListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cargo-list-descendente")
	public ResponseEntity<List<Tbasg135CargoDto>> getCargoListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg135CargoDto> tbasg135CargoDto = tbasg135CargoService.getCargoListDescendente();

			if (tbasg135CargoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg135CargoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCargoListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cargo-active-list-ascendente")
	public ResponseEntity<List<Tbasg135CargoDto>> getCargoActiveListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg135CargoDto> tbasg135CargoDto = tbasg135CargoService.getCargoActiveListAscendente();

			if (tbasg135CargoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg135CargoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCargoActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cargo-active-list-descendente")
	public ResponseEntity<List<Tbasg135CargoDto>> getCargoActiveListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg135CargoDto> tbasg135CargoDto = tbasg135CargoService.getCargoActiveListDescendente();

			if (tbasg135CargoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg135CargoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCargoActiveListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cargo-count")
	public ResponseEntity<?> getCargoCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg135CargoDto> tbasg135CargoDto = tbasg135CargoService.getCargoCount();

			if (tbasg135CargoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg135CargoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCargoCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-cargo")
	public ResponseEntity<?> insertCargo(@RequestBody Tbasg135Cargo bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg135CargoDto = tbasg135CargoService.insertCargo(bean);
			return new ResponseEntity<>(tbasg135CargoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertCargo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-cargo")
	public ResponseEntity<?> updateCargo(@RequestBody Tbasg135Cargo bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg135CargoDto = tbasg135CargoService.updateCargo(bean);
			return new ResponseEntity<>(tbasg135CargoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateCargo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-cargo")
	public ResponseEntity<?> estadoCargo(@RequestBody Tbasg135Cargo bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg135CargoDto = tbasg135CargoService.estadoCargo(bean);
			return new ResponseEntity<>(tbasg135CargoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoCargo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
