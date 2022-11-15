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

import renfe.com.dto.GetErrListParam;
import renfe.com.model.dto.Tbasg203ErrInactDto;
import renfe.com.model.entity.Tbasg203ErrInact;
import renfe.com.service.Tbasg203ErrInactService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg203ErrInact")
public class Tbasg203ErrInactController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg203ErrInactService tbasg203ErrInactService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg203ErrInactDto>> getAllTbasg203ErrInact(Tbasg203ErrInactDto filter) {
		return new ResponseEntity<>(tbasg203ErrInactService.getAllTbasg203ErrInact(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoError}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoError") Integer cdgoError) {
		Tbasg203ErrInactDto tbasg203ErrInactData = tbasg203ErrInactService.findByCdgoError(cdgoError);

		if (tbasg203ErrInactData != null) {
			return new ResponseEntity<>(tbasg203ErrInactData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg203ErrInactDto> createTbasg203ErrInact(
			@RequestBody Tbasg203ErrInactDto tbasg203ErrInactDto) {
		try {
			return new ResponseEntity<>(tbasg203ErrInactService.createTbasg203ErrInact(tbasg203ErrInactDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg203ErrInact {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoError}")
	public ResponseEntity<Tbasg203ErrInactDto> updateTbasg203ErrInact(@PathVariable("cdgoError") Integer cdgo,
			@RequestBody Tbasg203ErrInactDto body) {
		try {
			Tbasg203ErrInactDto tbasg203ErrInactData = tbasg203ErrInactService.updateTbasg203ErrInact(cdgo, body);
			if (tbasg203ErrInactData != null) {
				return new ResponseEntity<>(tbasg203ErrInactData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg203ErrInact []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoError}")
	public ResponseEntity<HttpStatus> deleteTbasg203ErrInact(@PathVariable("cdgoError") Integer cdgoError) {
		try {
			tbasg203ErrInactService.deleteTbasg203ErrInact(cdgoError);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg203ErrInact []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg203ErrInactDto>> findByCdgoErrorIn(List<Integer> cdgoError) {
		try {
			List<Tbasg203ErrInactDto> tbasg203ErrInactDto = tbasg203ErrInactService.findByCdgoErrorIn(cdgoError);

			if (tbasg203ErrInactDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg203ErrInactDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoErrorIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-err-inact-list")
	public ResponseEntity<List<Tbasg203ErrInactDto>> getErrInactList(GetErrListParam filter) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg203ErrInactDto> tbasg203ErrInactDto = tbasg203ErrInactService.getErrInactList(filter);

			if (tbasg203ErrInactDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg203ErrInactDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getErrInactList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-err-inact")
	public ResponseEntity<List<Tbasg203ErrInactDto>> getErrInact(Integer cdgoError) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg203ErrInactDto> tbasg203ErrInactDto = tbasg203ErrInactService.getErrInact(cdgoError);

			if (tbasg203ErrInactDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg203ErrInactDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getErrInact []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-err-inact")
	public ResponseEntity<?> updateErrInact(@RequestBody Tbasg203ErrInact bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg203ErrInactDto = tbasg203ErrInactService.updateErrInact(bean);
			return new ResponseEntity<>(tbasg203ErrInactDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateErrInact []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete-err-inact/{cdgoError}")
	public ResponseEntity<?> deleteErrInact(@PathVariable("cdgoError") Integer cdgoError) {
		// Generated from a DELETE found in an XML
		try {
			tbasg203ErrInactService.deleteErrInact(cdgoError);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteErrInact []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
