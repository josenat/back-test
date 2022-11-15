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

import renfe.com.model.dto.Tbasg255AmbovmDto;
import renfe.com.model.entity.Tbasg255Ambovm;
import renfe.com.service.Tbasg255AmbovmService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg255Ambovm")
public class Tbasg255AmbovmController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg255AmbovmService tbasg255AmbovmService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg255AmbovmDto>> getAllTbasg255Ambovm(Tbasg255AmbovmDto filter) {
		return new ResponseEntity<>(tbasg255AmbovmService.getAllTbasg255Ambovm(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoAmbovm}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoAmbovm") Integer cdgoAmbovm) {
		Tbasg255AmbovmDto tbasg255AmbovmData = tbasg255AmbovmService.findByCdgoAmbovm(cdgoAmbovm);

		if (tbasg255AmbovmData != null) {
			return new ResponseEntity<>(tbasg255AmbovmData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg255AmbovmDto> createTbasg255Ambovm(@RequestBody Tbasg255AmbovmDto tbasg255AmbovmDto) {
		try {
			return new ResponseEntity<>(tbasg255AmbovmService.createTbasg255Ambovm(tbasg255AmbovmDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg255Ambovm {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoAmbovm}")
	public ResponseEntity<Tbasg255AmbovmDto> updateTbasg255Ambovm(@PathVariable("cdgoAmbovm") Integer cdgo,
			@RequestBody Tbasg255AmbovmDto body) {
		try {
			Tbasg255AmbovmDto tbasg255AmbovmData = tbasg255AmbovmService.updateTbasg255Ambovm(cdgo, body);
			if (tbasg255AmbovmData != null) {
				return new ResponseEntity<>(tbasg255AmbovmData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg255Ambovm []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoAmbovm}")
	public ResponseEntity<HttpStatus> deleteTbasg255Ambovm(@PathVariable("cdgoAmbovm") Integer cdgoAmbovm) {
		try {
			tbasg255AmbovmService.deleteTbasg255Ambovm(cdgoAmbovm);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg255Ambovm []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg255AmbovmDto>> findByCdgoAmbovmIn(List<Integer> cdgoAmbovm) {
		try {
			List<Tbasg255AmbovmDto> tbasg255AmbovmDto = tbasg255AmbovmService.findByCdgoAmbovmIn(cdgoAmbovm);

			if (tbasg255AmbovmDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg255AmbovmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoAmbovmIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambitos-o-v-m-count")
	public ResponseEntity<?> getAmbitosOVMCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg255AmbovmDto> tbasg255AmbovmDto = tbasg255AmbovmService.getAmbitosOVMCount();

			if (tbasg255AmbovmDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg255AmbovmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitosOVMCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambitos-o-v-m-list-ascendente")
	public ResponseEntity<List<Tbasg255AmbovmDto>> getAmbitosOVMListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg255AmbovmDto> tbasg255AmbovmDto = tbasg255AmbovmService.getAmbitosOVMListAscendente();

			if (tbasg255AmbovmDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg255AmbovmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitosOVMListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambitos-o-v-m-list-descendente")
	public ResponseEntity<List<Tbasg255AmbovmDto>> getAmbitosOVMListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg255AmbovmDto> tbasg255AmbovmDto = tbasg255AmbovmService.getAmbitosOVMListDescendente();

			if (tbasg255AmbovmDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg255AmbovmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitosOVMListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambitos-o-v-m-active-list")
	public ResponseEntity<List<Tbasg255AmbovmDto>> getAmbitosOVMActiveList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg255AmbovmDto> tbasg255AmbovmDto = tbasg255AmbovmService.getAmbitosOVMActiveList();

			if (tbasg255AmbovmDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg255AmbovmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitosOVMActiveList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambitos-o-v-m")
	public ResponseEntity<List<Tbasg255AmbovmDto>> getAmbitosOVM(String cdgoAmbovm) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg255AmbovmDto> tbasg255AmbovmDto = tbasg255AmbovmService.getAmbitosOVM(cdgoAmbovm);

			if (tbasg255AmbovmDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg255AmbovmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitosOVM []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-ambitos-o-v-m")
	public ResponseEntity<?> insertAmbitosOVM(Tbasg255Ambovm bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg255AmbovmDto = tbasg255AmbovmService.insertAmbitosOVM(bean);
			return new ResponseEntity<>(tbasg255AmbovmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertAmbitosOVM []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-ambitos-o-v-m")
	public ResponseEntity<?> updateAmbitosOVM(Tbasg255Ambovm bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg255AmbovmDto = tbasg255AmbovmService.updateAmbitosOVM(bean);
			return new ResponseEntity<>(tbasg255AmbovmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateAmbitosOVM []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-ambitos-o-v-m")
	public ResponseEntity<?> deleteAmbitosOVM(Tbasg255Ambovm bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg255AmbovmDto = tbasg255AmbovmService.deleteAmbitosOVM(bean);
			return new ResponseEntity<>(tbasg255AmbovmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteAmbitosOVM []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
