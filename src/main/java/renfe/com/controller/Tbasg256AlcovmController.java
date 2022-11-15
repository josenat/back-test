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

import renfe.com.model.dto.Tbasg256AlcovmDto;
import renfe.com.model.entity.Tbasg256Alcovm;
import renfe.com.service.Tbasg256AlcovmService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg256Alcovm")
public class Tbasg256AlcovmController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg256AlcovmService tbasg256AlcovmService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg256AlcovmDto>> getAllTbasg256Alcovm(Tbasg256AlcovmDto filter) {
		return new ResponseEntity<>(tbasg256AlcovmService.getAllTbasg256Alcovm(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoAlcovm}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoAlcovm") Integer cdgoAlcovm) {
		Tbasg256AlcovmDto tbasg256AlcovmData = tbasg256AlcovmService.findByCdgoAlcovm(cdgoAlcovm);

		if (tbasg256AlcovmData != null) {
			return new ResponseEntity<>(tbasg256AlcovmData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg256AlcovmDto> createTbasg256Alcovm(@RequestBody Tbasg256AlcovmDto tbasg256AlcovmDto) {
		try {
			return new ResponseEntity<>(tbasg256AlcovmService.createTbasg256Alcovm(tbasg256AlcovmDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg256Alcovm {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoAlcovm}")
	public ResponseEntity<Tbasg256AlcovmDto> updateTbasg256Alcovm(@PathVariable("cdgoAlcovm") Integer cdgo,
			@RequestBody Tbasg256AlcovmDto body) {
		try {
			Tbasg256AlcovmDto tbasg256AlcovmData = tbasg256AlcovmService.updateTbasg256Alcovm(cdgo, body);
			if (tbasg256AlcovmData != null) {
				return new ResponseEntity<>(tbasg256AlcovmData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg256Alcovm []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoAlcovm}")
	public ResponseEntity<HttpStatus> deleteTbasg256Alcovm(@PathVariable("cdgoAlcovm") Integer cdgoAlcovm) {
		try {
			tbasg256AlcovmService.deleteTbasg256Alcovm(cdgoAlcovm);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg256Alcovm []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg256AlcovmDto>> findByCdgoAlcovmIn(List<Integer> cdgoAlcovm) {
		try {
			List<Tbasg256AlcovmDto> tbasg256AlcovmDto = tbasg256AlcovmService.findByCdgoAlcovmIn(cdgoAlcovm);

			if (tbasg256AlcovmDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg256AlcovmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoAlcovmIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-alcances-o-v-m-count")
	public ResponseEntity<?> getAlcancesOVMCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg256AlcovmDto> tbasg256AlcovmDto = tbasg256AlcovmService.getAlcancesOVMCount();

			if (tbasg256AlcovmDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg256AlcovmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAlcancesOVMCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-alcances-o-v-m-list-ascendente")
	public ResponseEntity<List<Tbasg256AlcovmDto>> getAlcancesOVMListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg256AlcovmDto> tbasg256AlcovmDto = tbasg256AlcovmService.getAlcancesOVMListAscendente();

			if (tbasg256AlcovmDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg256AlcovmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAlcancesOVMListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-alcances-o-v-m-list-descendente")
	public ResponseEntity<List<Tbasg256AlcovmDto>> getAlcancesOVMListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg256AlcovmDto> tbasg256AlcovmDto = tbasg256AlcovmService.getAlcancesOVMListDescendente();

			if (tbasg256AlcovmDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg256AlcovmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAlcancesOVMListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-alcances-o-v-m-active-list")
	public ResponseEntity<List<Tbasg256AlcovmDto>> getAlcancesOVMActiveList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg256AlcovmDto> tbasg256AlcovmDto = tbasg256AlcovmService.getAlcancesOVMActiveList();

			if (tbasg256AlcovmDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg256AlcovmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAlcancesOVMActiveList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-alcances-o-v-m")
	public ResponseEntity<List<Tbasg256AlcovmDto>> getAlcancesOVM(String cdgoAlcovm) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg256AlcovmDto> tbasg256AlcovmDto = tbasg256AlcovmService.getAlcancesOVM(cdgoAlcovm);

			if (tbasg256AlcovmDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg256AlcovmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAlcancesOVM []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-alcances-o-v-m")
	public ResponseEntity<?> insertAlcancesOVM(Tbasg256Alcovm bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg256AlcovmDto = tbasg256AlcovmService.insertAlcancesOVM(bean);
			return new ResponseEntity<>(tbasg256AlcovmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertAlcancesOVM []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-alcances-o-v-m")
	public ResponseEntity<?> updateAlcancesOVM(Tbasg256Alcovm bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg256AlcovmDto = tbasg256AlcovmService.updateAlcancesOVM(bean);
			return new ResponseEntity<>(tbasg256AlcovmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateAlcancesOVM []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-alcances-o-v-m")
	public ResponseEntity<?> deleteAlcancesOVM(Tbasg256Alcovm bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg256AlcovmDto = tbasg256AlcovmService.deleteAlcancesOVM(bean);
			return new ResponseEntity<>(tbasg256AlcovmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteAlcancesOVM []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
