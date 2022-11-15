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

import renfe.com.dto.GetErrActivDTO;
import renfe.com.dto.GetErrListParam;
import renfe.com.model.dto.Tbasg202ErrActivDto;
import renfe.com.model.entity.Tbasg202ErrActiv;
import renfe.com.service.Tbasg202ErrActivService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg202ErrActiv")
public class Tbasg202ErrActivController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg202ErrActivService tbasg202ErrActivService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg202ErrActivDto>> getAllTbasg202ErrActiv(Tbasg202ErrActivDto filter) {
		return new ResponseEntity<>(tbasg202ErrActivService.getAllTbasg202ErrActiv(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoError}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoError") Integer cdgoError) {
		Tbasg202ErrActivDto tbasg202ErrActivData = tbasg202ErrActivService.findByCdgoError(cdgoError);

		if (tbasg202ErrActivData != null) {
			return new ResponseEntity<>(tbasg202ErrActivData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg202ErrActivDto> createTbasg202ErrActiv(
			@RequestBody Tbasg202ErrActivDto tbasg202ErrActivDto) {
		try {
			return new ResponseEntity<>(tbasg202ErrActivService.createTbasg202ErrActiv(tbasg202ErrActivDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg202ErrActiv {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoError}")
	public ResponseEntity<Tbasg202ErrActivDto> updateTbasg202ErrActiv(@PathVariable("cdgoError") Integer cdgo,
			@RequestBody Tbasg202ErrActivDto body) {
		try {
			Tbasg202ErrActivDto tbasg202ErrActivData = tbasg202ErrActivService.updateTbasg202ErrActiv(cdgo, body);
			if (tbasg202ErrActivData != null) {
				return new ResponseEntity<>(tbasg202ErrActivData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg202ErrActiv []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoError}")
	public ResponseEntity<HttpStatus> deleteTbasg202ErrActiv(@PathVariable("cdgoError") Integer cdgoError) {
		try {
			tbasg202ErrActivService.deleteTbasg202ErrActiv(cdgoError);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg202ErrActiv []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg202ErrActivDto>> findByCdgoErrorIn(List<Integer> cdgoError) {
		try {
			List<Tbasg202ErrActivDto> tbasg202ErrActivDto = tbasg202ErrActivService.findByCdgoErrorIn(cdgoError);

			if (tbasg202ErrActivDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg202ErrActivDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoErrorIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-err-activ-list")
	public ResponseEntity<List<Tbasg202ErrActivDto>> getErrActivList(GetErrListParam filter) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg202ErrActivDto> tbasg202ErrActivDto = tbasg202ErrActivService.getErrActivList(filter);

			if (tbasg202ErrActivDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg202ErrActivDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getErrActivList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-err-activ")
	public ResponseEntity<List<GetErrActivDTO>> getErrActiv(Integer cdgoError) {
		// Generated from a SELECT found in an XML
		try {
			List<GetErrActivDTO> tbasg202ErrActivDto = tbasg202ErrActivService.getErrActiv(cdgoError);

			if (tbasg202ErrActivDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg202ErrActivDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getErrActiv []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-err-activ")
	public ResponseEntity<?> updateErrActiv(@RequestBody Tbasg202ErrActiv bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg202ErrActivDto = tbasg202ErrActivService.updateErrActiv(bean);
			return new ResponseEntity<>(tbasg202ErrActivDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateErrActiv []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete-err-activ/{cdgoError}")
	public ResponseEntity<?> deleteErrActiv(@PathVariable("cdgoError") Integer cdgoError) {
		// Generated from a DELETE found in an XML
		try {
			tbasg202ErrActivService.deleteErrActiv(cdgoError);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteErrActiv []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
