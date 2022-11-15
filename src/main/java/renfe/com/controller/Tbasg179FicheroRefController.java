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

import renfe.com.model.dto.Tbasg179FicheroRefDto;
import renfe.com.service.Tbasg179FicheroRefService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg179FicheroRef")
public class Tbasg179FicheroRefController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg179FicheroRefService tbasg179FicheroRefService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg179FicheroRefDto>> getAllTbasg179FicheroRef(Tbasg179FicheroRefDto filter) {
		return new ResponseEntity<>(tbasg179FicheroRefService.getAllTbasg179FicheroRef(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoFichero}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoFichero") Integer cdgoFichero) {
		Tbasg179FicheroRefDto tbasg179FicheroRefData = tbasg179FicheroRefService.findByCdgoFichero(cdgoFichero);

		if (tbasg179FicheroRefData != null) {
			return new ResponseEntity<>(tbasg179FicheroRefData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg179FicheroRefDto> createTbasg179FicheroRef(
			@RequestBody Tbasg179FicheroRefDto tbasg179FicheroRefDto) {
		try {
			return new ResponseEntity<>(tbasg179FicheroRefService.createTbasg179FicheroRef(tbasg179FicheroRefDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg179FicheroRef {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoFichero}")
	public ResponseEntity<Tbasg179FicheroRefDto> updateTbasg179FicheroRef(@PathVariable("cdgoFichero") Integer cdgo,
			@RequestBody Tbasg179FicheroRefDto body) {
		try {
			Tbasg179FicheroRefDto tbasg179FicheroRefData = tbasg179FicheroRefService.updateTbasg179FicheroRef(cdgo,
					body);
			if (tbasg179FicheroRefData != null) {
				return new ResponseEntity<>(tbasg179FicheroRefData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg179FicheroRef []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoFichero}")
	public ResponseEntity<HttpStatus> deleteTbasg179FicheroRef(@PathVariable("cdgoFichero") Integer cdgoFichero) {
		try {
			tbasg179FicheroRefService.deleteTbasg179FicheroRef(cdgoFichero);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg179FicheroRef []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg179FicheroRefDto>> findByCdgoFicheroIn(List<Integer> cdgoFichero) {
		try {
			List<Tbasg179FicheroRefDto> tbasg179FicheroRefDto = tbasg179FicheroRefService
					.findByCdgoFicheroIn(cdgoFichero);

			if (tbasg179FicheroRefDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg179FicheroRefDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoFicheroIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fichero-ref-list")
	public ResponseEntity<List<Tbasg179FicheroRefDto>> getFicheroRefList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg179FicheroRefDto> tbasg179FicheroRefDto = tbasg179FicheroRefService.getFicheroRefList();

			if (tbasg179FicheroRefDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg179FicheroRefDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFicheroRefList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fichero-ref-list-by-fecha")
	public ResponseEntity<List<Tbasg179FicheroRefDto>> getFicheroRefListByFecha() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg179FicheroRefDto> tbasg179FicheroRefDto = tbasg179FicheroRefService.getFicheroRefListByFecha();

			if (tbasg179FicheroRefDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg179FicheroRefDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFicheroRefListByFecha []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fichero-ref-list-by-fecha-asc")
	public ResponseEntity<List<Tbasg179FicheroRefDto>> getFicheroRefListByFechaAsc() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg179FicheroRefDto> tbasg179FicheroRefDto = tbasg179FicheroRefService.getFicheroRefListByFechaAsc();

			if (tbasg179FicheroRefDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg179FicheroRefDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFicheroRefListByFechaAsc []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
