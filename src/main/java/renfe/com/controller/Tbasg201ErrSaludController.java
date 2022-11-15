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

import renfe.com.dto.GetErrSaludDTO;
import renfe.com.dto.GetErrListParam;
import renfe.com.model.dto.Tbasg201ErrSaludDto;
import renfe.com.model.entity.Tbasg100Persona;
import renfe.com.model.entity.Tbasg201ErrSalud;
import renfe.com.service.Tbasg201ErrSaludService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg201ErrSalud")
public class Tbasg201ErrSaludController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg201ErrSaludService tbasg201ErrSaludService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg201ErrSaludDto>> getAllTbasg201ErrSalud(Tbasg201ErrSaludDto filter) {
		return new ResponseEntity<>(tbasg201ErrSaludService.getAllTbasg201ErrSalud(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoError}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoError") Integer cdgoError) {
		Tbasg201ErrSaludDto tbasg201ErrSaludData = tbasg201ErrSaludService.findByCdgoError(cdgoError);

		if (tbasg201ErrSaludData != null) {
			return new ResponseEntity<>(tbasg201ErrSaludData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg201ErrSaludDto> createTbasg201ErrSalud(
			@RequestBody Tbasg201ErrSaludDto tbasg201ErrSaludDto) {
		try {
			return new ResponseEntity<>(tbasg201ErrSaludService.createTbasg201ErrSalud(tbasg201ErrSaludDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg201ErrSalud {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoError}")
	public ResponseEntity<Tbasg201ErrSaludDto> updateTbasg201ErrSalud(@PathVariable("cdgoError") Integer cdgo,
			@RequestBody Tbasg201ErrSaludDto body) {
		try {
			Tbasg201ErrSaludDto tbasg201ErrSaludData = tbasg201ErrSaludService.updateTbasg201ErrSalud(cdgo, body);
			if (tbasg201ErrSaludData != null) {
				return new ResponseEntity<>(tbasg201ErrSaludData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg201ErrSalud []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoError}")
	public ResponseEntity<HttpStatus> deleteTbasg201ErrSalud(@PathVariable("cdgoError") Integer cdgoError) {
		try {
			tbasg201ErrSaludService.deleteTbasg201ErrSalud(cdgoError);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg201ErrSalud []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg201ErrSaludDto>> findByCdgoErrorIn(List<Integer> cdgoError) {
		try {
			List<Tbasg201ErrSaludDto> tbasg201ErrSaludDto = tbasg201ErrSaludService.findByCdgoErrorIn(cdgoError);

			if (tbasg201ErrSaludDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg201ErrSaludDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoErrorIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-err-salud-list")
	public ResponseEntity<List<Tbasg201ErrSaludDto>> getErrSaludList(GetErrListParam filter) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg201ErrSaludDto> tbasg201ErrSaludDto = tbasg201ErrSaludService.getErrSaludList(filter);

			if (tbasg201ErrSaludDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg201ErrSaludDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getErrSaludList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-err-salud")
	public ResponseEntity<List<GetErrSaludDTO>> getErrSalud(Integer cdgoError) {
		// Generated from a SELECT found in an XML
		try {
			List<GetErrSaludDTO> tbasg201ErrSaludDto = tbasg201ErrSaludService.getErrSalud(cdgoError);

			if (tbasg201ErrSaludDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg201ErrSaludDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getErrSalud []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update-err-salud")
	public ResponseEntity<?> updateErrSalud(@RequestBody Tbasg201ErrSalud bean) {
		
		try {
			int tbasg201ErrSaludDto = tbasg201ErrSaludService.updateErrSalud(bean);
			return new ResponseEntity<>(tbasg201ErrSaludDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateErrSalud []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@DeleteMapping("/delete-err-salud/{cdgoError}")
	public ResponseEntity<?> deleteErrSalud(@PathVariable("cdgoError") Integer cdgoError) {
		
		try {
			tbasg201ErrSaludService.deleteErrSalud(cdgoError);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteErrSalud []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
