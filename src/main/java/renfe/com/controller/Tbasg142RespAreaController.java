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

import renfe.com.dto.GetRespAreaListAscendenteDTO;
import renfe.com.model.dto.Tbasg142RespAreaDto;
import renfe.com.model.entity.Tbasg142RespArea;
import renfe.com.service.Tbasg142RespAreaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg142RespArea")
public class Tbasg142RespAreaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg142RespAreaService tbasg142RespAreaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg142RespAreaDto>> getAllTbasg142RespArea(Tbasg142RespAreaDto filter) {
		return new ResponseEntity<>(tbasg142RespAreaService.getAllTbasg142RespArea(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoAreact}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoAreact") Integer cdgoAreact) {
		Tbasg142RespAreaDto tbasg142RespAreaData = tbasg142RespAreaService.findByCdgoAreact(cdgoAreact);

		if (tbasg142RespAreaData != null) {
			return new ResponseEntity<>(tbasg142RespAreaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg142RespAreaDto> createTbasg142RespArea(
			@RequestBody Tbasg142RespAreaDto tbasg142RespAreaDto) {
		try {
			return new ResponseEntity<>(tbasg142RespAreaService.createTbasg142RespArea(tbasg142RespAreaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg142RespArea {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoAreact}")
	public ResponseEntity<Tbasg142RespAreaDto> updateTbasg142RespArea(@PathVariable("cdgoAreact") Integer cdgo,
			@RequestBody Tbasg142RespAreaDto body) {
		try {
			Tbasg142RespAreaDto tbasg142RespAreaData = tbasg142RespAreaService.updateTbasg142RespArea(cdgo, body);
			if (tbasg142RespAreaData != null) {
				return new ResponseEntity<>(tbasg142RespAreaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg142RespArea []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoAreact}")
	public ResponseEntity<HttpStatus> deleteTbasg142RespArea(@PathVariable("cdgoAreact") Integer cdgoAreact) {
		try {
			tbasg142RespAreaService.deleteTbasg142RespArea(cdgoAreact);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg142RespArea []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg142RespAreaDto>> findByCdgoAreactIn(List<Integer> cdgoAreact) {
		try {
			List<Tbasg142RespAreaDto> tbasg142RespAreaDto = tbasg142RespAreaService.findByCdgoAreactIn(cdgoAreact);

			if (tbasg142RespAreaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg142RespAreaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoAreactIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-resp-area")
	public ResponseEntity<List<Tbasg142RespAreaDto>> getRespArea(String cdgoAreact) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg142RespAreaDto> tbasg142RespAreaDto = tbasg142RespAreaService.getRespArea(cdgoAreact);

			if (tbasg142RespAreaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg142RespAreaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getRespArea []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-resp-area-view")
	public ResponseEntity<List<Tbasg142RespAreaDto>> getRespAreaView(String cdgoAreact) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg142RespAreaDto> tbasg142RespAreaDto = tbasg142RespAreaService.getRespAreaView(cdgoAreact);

			if (tbasg142RespAreaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg142RespAreaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getRespAreaView []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-resp-area-count")
	public ResponseEntity<?> getRespAreaCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg142RespAreaDto> tbasg142RespAreaDto = tbasg142RespAreaService.getRespAreaCount();

			if (tbasg142RespAreaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg142RespAreaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getRespAreaCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-resp-area-list-ascendente")
	public ResponseEntity<List<GetRespAreaListAscendenteDTO>> getRespAreaListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<GetRespAreaListAscendenteDTO> tbasg142RespAreaDto = tbasg142RespAreaService.getRespAreaListAscendente();

			if (tbasg142RespAreaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg142RespAreaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getRespAreaListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-resp-area-list-descendente")
	public ResponseEntity<List<Tbasg142RespAreaDto>> getRespAreaListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg142RespAreaDto> tbasg142RespAreaDto = tbasg142RespAreaService.getRespAreaListDescendente();

			if (tbasg142RespAreaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg142RespAreaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getRespAreaListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-resp-area")
	public ResponseEntity<?> addRespArea(@RequestBody Tbasg142RespArea bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg142RespAreaDto = tbasg142RespAreaService.addRespArea(bean);
			return new ResponseEntity<>(tbasg142RespAreaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("addRespArea []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-resp-area")
	public ResponseEntity<?> updateRespArea(@RequestBody Tbasg142RespArea bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg142RespAreaDto = tbasg142RespAreaService.updateRespArea(bean);
			return new ResponseEntity<>(tbasg142RespAreaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateRespArea []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
