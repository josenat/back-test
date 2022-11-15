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

import renfe.com.model.dto.Tbasg151RidDto;
import renfe.com.model.entity.Tbasg151Rid;
import renfe.com.service.Tbasg151RidService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg151Rid")
public class Tbasg151RidController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg151RidService tbasg151RidService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg151RidDto>> getAllTbasg151Rid(Tbasg151RidDto filter) {
		return new ResponseEntity<>(tbasg151RidService.getAllTbasg151Rid(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoExpedient}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoExpedient") Integer cdgoExpedient) {
		Tbasg151RidDto tbasg151RidData = tbasg151RidService.findByCdgoExpedient(cdgoExpedient);

		if (tbasg151RidData != null) {
			return new ResponseEntity<>(tbasg151RidData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg151RidDto> createTbasg151Rid(@RequestBody Tbasg151RidDto tbasg151RidDto) {
		try {
			return new ResponseEntity<>(tbasg151RidService.createTbasg151Rid(tbasg151RidDto), HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg151Rid {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoExpedient}")
	public ResponseEntity<Tbasg151RidDto> updateTbasg151Rid(@PathVariable("cdgoExpedient") Integer cdgo,
			@RequestBody Tbasg151RidDto body) {
		try {
			Tbasg151RidDto tbasg151RidData = tbasg151RidService.updateTbasg151Rid(cdgo, body);
			if (tbasg151RidData != null) {
				return new ResponseEntity<>(tbasg151RidData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg151Rid []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoExpedient}")
	public ResponseEntity<HttpStatus> deleteTbasg151Rid(@PathVariable("cdgoExpedient") Integer cdgoExpedient) {
		try {
			tbasg151RidService.deleteTbasg151Rid(cdgoExpedient);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg151Rid []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg151RidDto>> findByCdgoExpedientIn(List<Integer> cdgoExpedient) {
		try {
			List<Tbasg151RidDto> tbasg151RidDto = tbasg151RidService.findByCdgoExpedientIn(cdgoExpedient);

			if (tbasg151RidDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg151RidDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoExpedientIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-rid-list")
	public ResponseEntity<List<Tbasg151RidDto>> getRidList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg151RidDto> tbasg151RidDto = tbasg151RidService.getRidList();

			if (tbasg151RidDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg151RidDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getRidList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-rid-count")
	public ResponseEntity<?> getRidCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg151RidDto> tbasg151RidDto = tbasg151RidService.getRidCount();

			if (tbasg151RidDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg151RidDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getRidCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-rid")
	public ResponseEntity<List<Tbasg151RidDto>> getRid(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg151RidDto> tbasg151RidDto = tbasg151RidService.getRid(cdgoExpedient);

			if (tbasg151RidDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg151RidDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getRid []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-rid")
	public ResponseEntity<Integer> insertRid(String cdgoExpedient, String fchaRid, String desgUsuact) {
		try {
			int insertRid = tbasg151RidService.insertRid(cdgoExpedient, fchaRid, desgUsuact);
			return new ResponseEntity<>(insertRid, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("insertRid []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-rid")
	public ResponseEntity<?> updateRid(Tbasg151Rid bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg151RidDto = tbasg151RidService.updateRid(bean);
			return new ResponseEntity<>(tbasg151RidDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateRid []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
