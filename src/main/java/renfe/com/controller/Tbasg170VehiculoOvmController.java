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

import renfe.com.model.dto.Tbasg170VehiculoOvmDto;
import renfe.com.model.entity.Tbasg170VehiculoOvm;
import renfe.com.service.Tbasg170VehiculoOvmService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg170VehiculoOvm")
public class Tbasg170VehiculoOvmController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg170VehiculoOvmService tbasg170VehiculoOvmService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg170VehiculoOvmDto>> getAllTbasg170VehiculoOvm(Tbasg170VehiculoOvmDto filter) {
		return new ResponseEntity<>(tbasg170VehiculoOvmService.getAllTbasg170VehiculoOvm(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoVehiculo}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoVehiculo") Integer cdgoVehiculo) {
		Tbasg170VehiculoOvmDto tbasg170VehiculoOvmData = tbasg170VehiculoOvmService.findByCdgoVehiculo(cdgoVehiculo);

		if (tbasg170VehiculoOvmData != null) {
			return new ResponseEntity<>(tbasg170VehiculoOvmData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg170VehiculoOvmDto> createTbasg170VehiculoOvm(
			@RequestBody Tbasg170VehiculoOvmDto tbasg170VehiculoOvmDto) {
		try {
			return new ResponseEntity<>(tbasg170VehiculoOvmService.createTbasg170VehiculoOvm(tbasg170VehiculoOvmDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg170VehiculoOvm {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoVehiculo}")
	public ResponseEntity<Tbasg170VehiculoOvmDto> updateTbasg170VehiculoOvm(@PathVariable("cdgoVehiculo") Integer cdgo,
			@RequestBody Tbasg170VehiculoOvmDto body) {
		try {
			Tbasg170VehiculoOvmDto tbasg170VehiculoOvmData = tbasg170VehiculoOvmService.updateTbasg170VehiculoOvm(cdgo,
					body);
			if (tbasg170VehiculoOvmData != null) {
				return new ResponseEntity<>(tbasg170VehiculoOvmData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg170VehiculoOvm []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoVehiculo}")
	public ResponseEntity<HttpStatus> deleteTbasg170VehiculoOvm(@PathVariable("cdgoVehiculo") Integer cdgoVehiculo) {
		try {
			tbasg170VehiculoOvmService.deleteTbasg170VehiculoOvm(cdgoVehiculo);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg170VehiculoOvm []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg170VehiculoOvmDto>> findByCdgoVehiculoIn(List<Integer> cdgoVehiculo) {
		try {
			List<Tbasg170VehiculoOvmDto> tbasg170VehiculoOvmDto = tbasg170VehiculoOvmService
					.findByCdgoVehiculoIn(cdgoVehiculo);

			if (tbasg170VehiculoOvmDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg170VehiculoOvmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoVehiculoIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-vehiculo-o-v-m-list-ascendente")
	public ResponseEntity<List<Tbasg170VehiculoOvmDto>> getVehiculoOVMListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg170VehiculoOvmDto> tbasg170VehiculoOvmDto = tbasg170VehiculoOvmService
					.getVehiculoOVMListAscendente();

			if (tbasg170VehiculoOvmDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg170VehiculoOvmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getVehiculoOVMListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-vehiculo-o-v-m-list-descendente")
	public ResponseEntity<List<Tbasg170VehiculoOvmDto>> getVehiculoOVMListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg170VehiculoOvmDto> tbasg170VehiculoOvmDto = tbasg170VehiculoOvmService
					.getVehiculoOVMListDescendente();

			if (tbasg170VehiculoOvmDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg170VehiculoOvmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getVehiculoOVMListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-vehiculo-o-v-m-count")
	public ResponseEntity<?> getVehiculoOVMCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg170VehiculoOvmDto> tbasg170VehiculoOvmDto = tbasg170VehiculoOvmService.getVehiculoOVMCount();

			if (tbasg170VehiculoOvmDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg170VehiculoOvmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getVehiculoOVMCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-vehiculo-o-v-m")
	public ResponseEntity<List<Tbasg170VehiculoOvmDto>> getVehiculoOVM(String cdgoVehiculo) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg170VehiculoOvmDto> tbasg170VehiculoOvmDto = tbasg170VehiculoOvmService
					.getVehiculoOVM(cdgoVehiculo);

			if (tbasg170VehiculoOvmDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg170VehiculoOvmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getVehiculoOVM []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-vehiculo-o-v-m-list-active")
	public ResponseEntity<List<Tbasg170VehiculoOvmDto>> getVehiculoOVMListActive() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg170VehiculoOvmDto> tbasg170VehiculoOvmDto = tbasg170VehiculoOvmService.getVehiculoOVMListActive();

			if (tbasg170VehiculoOvmDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg170VehiculoOvmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getVehiculoOVMListActive []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-vehiculo-o-v-m")
	public ResponseEntity<?> insertVehiculoOVM(@RequestBody Tbasg170VehiculoOvm bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg170VehiculoOvmDto = tbasg170VehiculoOvmService.insertVehiculoOVM(bean);
			return new ResponseEntity<>(tbasg170VehiculoOvmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertVehiculoOVM []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-vehiculo-o-v-m")
	public ResponseEntity<?> updateVehiculoOVM(@RequestBody Tbasg170VehiculoOvm bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg170VehiculoOvmDto = tbasg170VehiculoOvmService.updateVehiculoOVM(bean);
			return new ResponseEntity<>(tbasg170VehiculoOvmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateVehiculoOVM []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-vehiculo-o-v-m")
	public ResponseEntity<?> estadoVehiculoOVM(@RequestBody Tbasg170VehiculoOvm bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg170VehiculoOvmDto = tbasg170VehiculoOvmService.estadoVehiculoOVM(bean);
			return new ResponseEntity<>(tbasg170VehiculoOvmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoVehiculoOVM []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
