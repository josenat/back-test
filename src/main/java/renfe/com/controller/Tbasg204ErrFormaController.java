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

import renfe.com.dto.GetErrFormaDTO;
import renfe.com.dto.GetErrListParam;
import renfe.com.model.dto.Tbasg204ErrFormaDto;
import renfe.com.model.entity.Tbasg204ErrForma;
import renfe.com.service.Tbasg204ErrFormaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg204ErrForma")
public class Tbasg204ErrFormaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg204ErrFormaService tbasg204ErrFormaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg204ErrFormaDto>> getAllTbasg204ErrForma(Tbasg204ErrFormaDto filter) {
		return new ResponseEntity<>(tbasg204ErrFormaService.getAllTbasg204ErrForma(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoError}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoError") Integer cdgoError) {
		Tbasg204ErrFormaDto tbasg204ErrFormaData = tbasg204ErrFormaService.findByCdgoError(cdgoError);

		if (tbasg204ErrFormaData != null) {
			return new ResponseEntity<>(tbasg204ErrFormaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg204ErrFormaDto> createTbasg204ErrForma(
			@RequestBody Tbasg204ErrFormaDto tbasg204ErrFormaDto) {
		try {
			return new ResponseEntity<>(tbasg204ErrFormaService.createTbasg204ErrForma(tbasg204ErrFormaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg204ErrForma {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoError}")
	public ResponseEntity<Tbasg204ErrFormaDto> updateTbasg204ErrForma(@PathVariable("cdgoError") Integer cdgo,
			@RequestBody Tbasg204ErrFormaDto body) {
		try {
			Tbasg204ErrFormaDto tbasg204ErrFormaData = tbasg204ErrFormaService.updateTbasg204ErrForma(cdgo, body);
			if (tbasg204ErrFormaData != null) {
				return new ResponseEntity<>(tbasg204ErrFormaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg204ErrForma []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoError}")
	public ResponseEntity<HttpStatus> deleteTbasg204ErrForma(@PathVariable("cdgoError") Integer cdgoError) {
		try {
			tbasg204ErrFormaService.deleteTbasg204ErrForma(cdgoError);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg204ErrForma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg204ErrFormaDto>> findByCdgoErrorIn(List<Integer> cdgoError) {
		try {
			List<Tbasg204ErrFormaDto> tbasg204ErrFormaDto = tbasg204ErrFormaService.findByCdgoErrorIn(cdgoError);

			if (tbasg204ErrFormaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg204ErrFormaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoErrorIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-err-forma-list")
	public ResponseEntity<List<Tbasg204ErrFormaDto>> getErrFormaList(GetErrListParam filter) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg204ErrFormaDto> tbasg204ErrFormaDto = tbasg204ErrFormaService.getErrFormaList(filter);

			if (tbasg204ErrFormaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg204ErrFormaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getErrFormaList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-err-forma-list2")
	public ResponseEntity<List<Tbasg204ErrFormaDto>> getErrFormaList2() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg204ErrFormaDto> tbasg204ErrFormaDto = tbasg204ErrFormaService.getErrFormaList2();

			if (tbasg204ErrFormaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg204ErrFormaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getErrFormaList2 []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-err-forma")
	public ResponseEntity<List<GetErrFormaDTO>> getErrForma(Integer cdgoError) {
		// Generated from a SELECT found in an XML
		try {
			List<GetErrFormaDTO> tbasg204ErrFormaDto = tbasg204ErrFormaService.getErrForma(cdgoError);

			if (tbasg204ErrFormaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg204ErrFormaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getErrForma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-err-forma")
	public ResponseEntity<?> updateErrForma(@RequestBody Tbasg204ErrForma bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg204ErrFormaDto = tbasg204ErrFormaService.updateErrForma(bean);
			return new ResponseEntity<>(tbasg204ErrFormaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateErrForma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete-err-forma/{cdgoError}")
	public ResponseEntity<?> deleteErrForma(@PathVariable("cdgoError") Integer cdgoError) {
		// Generated from a DELETE found in an XML
		try {
			tbasg204ErrFormaService.deleteErrForma(cdgoError);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteErrForma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
