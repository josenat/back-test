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

import renfe.com.model.dto.Tbasg140TidepenciDto;
import renfe.com.model.entity.Tbasg140Tidepenci;
import renfe.com.service.Tbasg140TidepenciService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg140Tidepenci")
public class Tbasg140TidepenciController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg140TidepenciService tbasg140TidepenciService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg140TidepenciDto>> getAllTbasg140Tidepenci(Tbasg140TidepenciDto filter) {
		return new ResponseEntity<>(tbasg140TidepenciService.getAllTbasg140Tidepenci(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoTipodep}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoTipodep") Integer cdgoTipodep) {
		Tbasg140TidepenciDto tbasg140TidepenciData = tbasg140TidepenciService.findByCdgoTipodep(cdgoTipodep);

		if (tbasg140TidepenciData != null) {
			return new ResponseEntity<>(tbasg140TidepenciData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg140TidepenciDto> createTbasg140Tidepenci(
			@RequestBody Tbasg140TidepenciDto tbasg140TidepenciDto) {
		try {
			return new ResponseEntity<>(tbasg140TidepenciService.createTbasg140Tidepenci(tbasg140TidepenciDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg140Tidepenci {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoTipodep}")
	public ResponseEntity<Tbasg140TidepenciDto> updateTbasg140Tidepenci(@PathVariable("cdgoTipodep") Integer cdgo,
			@RequestBody Tbasg140TidepenciDto body) {
		try {
			Tbasg140TidepenciDto tbasg140TidepenciData = tbasg140TidepenciService.updateTbasg140Tidepenci(cdgo, body);
			if (tbasg140TidepenciData != null) {
				return new ResponseEntity<>(tbasg140TidepenciData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg140Tidepenci []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoTipodep}")
	public ResponseEntity<HttpStatus> deleteTbasg140Tidepenci(@PathVariable("cdgoTipodep") Integer cdgoTipodep) {
		try {
			tbasg140TidepenciService.deleteTbasg140Tidepenci(cdgoTipodep);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg140Tidepenci []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg140TidepenciDto>> findByCdgoTipodepIn(List<Integer> cdgoTipodep) {
		try {
			List<Tbasg140TidepenciDto> tbasg140TidepenciDto = tbasg140TidepenciService.findByCdgoTipodepIn(cdgoTipodep);

			if (tbasg140TidepenciDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg140TidepenciDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoTipodepIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ti-depenci-count")
	public ResponseEntity<?> getTiDepenciCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg140TidepenciDto> tbasg140TidepenciDto = tbasg140TidepenciService.getTiDepenciCount();

			if (tbasg140TidepenciDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg140TidepenciDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTiDepenciCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ti-depenci-list-ascendente")
	public ResponseEntity<List<Tbasg140TidepenciDto>> getTiDepenciListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg140TidepenciDto> tbasg140TidepenciDto = tbasg140TidepenciService.getTiDepenciListAscendente();

			if (tbasg140TidepenciDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg140TidepenciDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTiDepenciListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ti-depenci-list-descendente")
	public ResponseEntity<List<Tbasg140TidepenciDto>> getTiDepenciListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg140TidepenciDto> tbasg140TidepenciDto = tbasg140TidepenciService.getTiDepenciListDescendente();

			if (tbasg140TidepenciDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg140TidepenciDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTiDepenciListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ti-depenci-list-active-ascendente")
	public ResponseEntity<List<Tbasg140TidepenciDto>> getTiDepenciListActiveAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg140TidepenciDto> tbasg140TidepenciDto = tbasg140TidepenciService
					.getTiDepenciListActiveAscendente();

			if (tbasg140TidepenciDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg140TidepenciDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTiDepenciListActiveAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ti-depenci-list-active-descendente")
	public ResponseEntity<List<Tbasg140TidepenciDto>> getTiDepenciListActiveDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg140TidepenciDto> tbasg140TidepenciDto = tbasg140TidepenciService
					.getTiDepenciListActiveDescendente();

			if (tbasg140TidepenciDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg140TidepenciDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTiDepenciListActiveDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ti-depenci")
	public ResponseEntity<List<Tbasg140TidepenciDto>> getTiDepenci(String cdgoTipodep) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg140TidepenciDto> tbasg140TidepenciDto = tbasg140TidepenciService.getTiDepenci(cdgoTipodep);

			if (tbasg140TidepenciDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg140TidepenciDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTiDepenci []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-ti-depenci")
	public ResponseEntity<?> insertTiDepenci(Tbasg140Tidepenci bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg140TidepenciDto = tbasg140TidepenciService.insertTiDepenci(bean);
			return new ResponseEntity<>(tbasg140TidepenciDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertTiDepenci []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-ti-depenci")
	public ResponseEntity<?> updateTiDepenci(Tbasg140Tidepenci bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg140TidepenciDto = tbasg140TidepenciService.updateTiDepenci(bean);
			return new ResponseEntity<>(tbasg140TidepenciDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateTiDepenci []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-ti-depenci")
	public ResponseEntity<?> deleteTiDepenci(Tbasg140Tidepenci bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg140TidepenciDto = tbasg140TidepenciService.deleteTiDepenci(bean);
			return new ResponseEntity<>(tbasg140TidepenciDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteTiDepenci []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
