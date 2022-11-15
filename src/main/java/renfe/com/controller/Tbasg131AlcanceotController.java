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

import renfe.com.model.dto.Tbasg131AlcanceotDto;
import renfe.com.model.entity.Tbasg131Alcanceot;
import renfe.com.service.Tbasg131AlcanceotService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg131Alcanceot")
public class Tbasg131AlcanceotController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg131AlcanceotService tbasg131AlcanceotService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg131AlcanceotDto>> getAllTbasg131Alcanceot(Tbasg131AlcanceotDto filter) {
		return new ResponseEntity<>(tbasg131AlcanceotService.getAllTbasg131Alcanceot(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoAlcanceot}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoAlcanceot") Integer cdgoAlcanceot) {
		Tbasg131AlcanceotDto tbasg131AlcanceotData = tbasg131AlcanceotService.findByCdgoAlcanceot(cdgoAlcanceot);

		if (tbasg131AlcanceotData != null) {
			return new ResponseEntity<>(tbasg131AlcanceotData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg131AlcanceotDto> createTbasg131Alcanceot(
			@RequestBody Tbasg131AlcanceotDto tbasg131AlcanceotDto) {
		try {
			return new ResponseEntity<>(tbasg131AlcanceotService.createTbasg131Alcanceot(tbasg131AlcanceotDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg131Alcanceot {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoAlcanceot}")
	public ResponseEntity<Tbasg131AlcanceotDto> updateTbasg131Alcanceot(@PathVariable("cdgoAlcanceot") Integer cdgo,
			@RequestBody Tbasg131AlcanceotDto body) {
		try {
			Tbasg131AlcanceotDto tbasg131AlcanceotData = tbasg131AlcanceotService.updateTbasg131Alcanceot(cdgo, body);
			if (tbasg131AlcanceotData != null) {
				return new ResponseEntity<>(tbasg131AlcanceotData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg131Alcanceot []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoAlcanceot}")
	public ResponseEntity<HttpStatus> deleteTbasg131Alcanceot(@PathVariable("cdgoAlcanceot") Integer cdgoAlcanceot) {
		try {
			tbasg131AlcanceotService.deleteTbasg131Alcanceot(cdgoAlcanceot);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg131Alcanceot []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg131AlcanceotDto>> findByCdgoAlcanceotIn(List<Integer> cdgoAlcanceot) {
		try {
			List<Tbasg131AlcanceotDto> tbasg131AlcanceotDto = tbasg131AlcanceotService
					.findByCdgoAlcanceotIn(cdgoAlcanceot);

			if (tbasg131AlcanceotDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg131AlcanceotDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoAlcanceotIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-alcance-ot-count")
	public ResponseEntity<?> getAlcanceOtCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg131AlcanceotDto> tbasg131AlcanceotDto = tbasg131AlcanceotService.getAlcanceOtCount();

			if (tbasg131AlcanceotDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg131AlcanceotDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAlcanceOtCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-alcance-ot-list-ascendente")
	public ResponseEntity<List<Tbasg131AlcanceotDto>> getAlcanceOtListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg131AlcanceotDto> tbasg131AlcanceotDto = tbasg131AlcanceotService.getAlcanceOtListAscendente();

			if (tbasg131AlcanceotDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg131AlcanceotDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAlcanceOtListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-alcance-ot-list-descendente")
	public ResponseEntity<List<Tbasg131AlcanceotDto>> getAlcanceOtListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg131AlcanceotDto> tbasg131AlcanceotDto = tbasg131AlcanceotService.getAlcanceOtListDescendente();

			if (tbasg131AlcanceotDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg131AlcanceotDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAlcanceOtListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-alcance-ot")
	public ResponseEntity<List<Tbasg131AlcanceotDto>> getAlcanceOt(Integer cdgoAlcanceot) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg131AlcanceotDto> tbasg131AlcanceotDto = tbasg131AlcanceotService.getAlcanceOt(cdgoAlcanceot);

			if (tbasg131AlcanceotDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg131AlcanceotDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAlcanceOt []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-alcance-ot-nombre")
	public ResponseEntity<List<Tbasg131AlcanceotDto>> getAlcanceOtNombre(String cdgoAlcanceot) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg131AlcanceotDto> tbasg131AlcanceotDto = tbasg131AlcanceotService.getAlcanceOtNombre(cdgoAlcanceot);

			if (tbasg131AlcanceotDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg131AlcanceotDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAlcanceOt []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-alcance-ot-inf-ser")
	public ResponseEntity<List<Tbasg131AlcanceotDto>> getAlcanceOtInfSer(Integer cdgoAlcanceot) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg131AlcanceotDto> tbasg131AlcanceotDto = tbasg131AlcanceotService.getAlcanceOtInfSer(cdgoAlcanceot);

			if (tbasg131AlcanceotDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg131AlcanceotDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAlcanceOtInfSer []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-alcance-ot-active-list")
	public ResponseEntity<List<Tbasg131AlcanceotDto>> getAlcanceOtActiveList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg131AlcanceotDto> tbasg131AlcanceotDto = tbasg131AlcanceotService.getAlcanceOtActiveList();

			if (tbasg131AlcanceotDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg131AlcanceotDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAlcanceOtActiveList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-alcance-ot")
	public ResponseEntity<?> insertAlcanceOt(@RequestBody Tbasg131Alcanceot bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg131AlcanceotDto = tbasg131AlcanceotService.insertAlcanceOt(bean);
			return new ResponseEntity<>(tbasg131AlcanceotDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertAlcanceOt []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-alcance-ot")
	public ResponseEntity<?> updateAlcanceOt(@RequestBody Tbasg131Alcanceot bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg131AlcanceotDto = tbasg131AlcanceotService.updateAlcanceOt(bean);
			return new ResponseEntity<>(tbasg131AlcanceotDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateAlcanceOt []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-alcance-ot")
	public ResponseEntity<?> estadoAlcanceOt(@RequestBody Tbasg131Alcanceot bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg131AlcanceotDto = tbasg131AlcanceotService.estadoAlcanceOt(bean);
			return new ResponseEntity<>(tbasg131AlcanceotDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateAlcanceOt []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

