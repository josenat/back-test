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

import renfe.com.model.dto.Tbasg114GradoinciDto;
import renfe.com.model.entity.Tbasg114Gradoinci;
import renfe.com.service.Tbasg114GradoinciService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg114Gradoinci")
public class Tbasg114GradoinciController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg114GradoinciService tbasg114GradoinciService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg114GradoinciDto>> getAllTbasg114Gradoinci(Tbasg114GradoinciDto filter) {
		return new ResponseEntity<>(tbasg114GradoinciService.getAllTbasg114Gradoinci(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoGrado}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoGrado") Integer cdgoGrado) {
		Tbasg114GradoinciDto tbasg114GradoinciData = tbasg114GradoinciService.findByCdgoGrado(cdgoGrado);

		if (tbasg114GradoinciData != null) {
			return new ResponseEntity<>(tbasg114GradoinciData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg114GradoinciDto> createTbasg114Gradoinci(
			@RequestBody Tbasg114GradoinciDto tbasg114GradoinciDto) {
		try {
			return new ResponseEntity<>(tbasg114GradoinciService.createTbasg114Gradoinci(tbasg114GradoinciDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg114Gradoinci {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoGrado}")
	public ResponseEntity<Tbasg114GradoinciDto> updateTbasg114Gradoinci(@PathVariable("cdgoGrado") Integer cdgo,
			@RequestBody Tbasg114GradoinciDto body) {
		try {
			Tbasg114GradoinciDto tbasg114GradoinciData = tbasg114GradoinciService.updateTbasg114Gradoinci(cdgo, body);
			if (tbasg114GradoinciData != null) {
				return new ResponseEntity<>(tbasg114GradoinciData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg114Gradoinci []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoGrado}")
	public ResponseEntity<HttpStatus> deleteTbasg114Gradoinci(@PathVariable("cdgoGrado") Integer cdgoGrado) {
		try {
			tbasg114GradoinciService.deleteTbasg114Gradoinci(cdgoGrado);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg114Gradoinci []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg114GradoinciDto>> findByCdgoGradoIn(List<Integer> cdgoGrado) {
		try {
			List<Tbasg114GradoinciDto> tbasg114GradoinciDto = tbasg114GradoinciService.findByCdgoGradoIn(cdgoGrado);

			if (tbasg114GradoinciDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg114GradoinciDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoGradoIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-grado-inci-count")
	public ResponseEntity<?> getGradoInciCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg114GradoinciDto> tbasg114GradoinciDto = tbasg114GradoinciService.getGradoInciCount();

			if (tbasg114GradoinciDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg114GradoinciDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getGradoInciCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-grado-inci-active-count")
	public ResponseEntity<?> getGradoInciActiveCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg114GradoinciDto> tbasg114GradoinciDto = tbasg114GradoinciService.getGradoInciActiveCount();

			if (tbasg114GradoinciDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg114GradoinciDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getGradoInciActiveCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-grado-inci-list-ascendente")
	public ResponseEntity<List<Tbasg114GradoinciDto>> getGradoInciListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg114GradoinciDto> tbasg114GradoinciDto = tbasg114GradoinciService.getGradoInciListAscendente();

			if (tbasg114GradoinciDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg114GradoinciDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getGradoInciListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-grado-inci-list-descendente")
	public ResponseEntity<List<Tbasg114GradoinciDto>> getGradoInciListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg114GradoinciDto> tbasg114GradoinciDto = tbasg114GradoinciService.getGradoInciListDescendente();

			if (tbasg114GradoinciDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg114GradoinciDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getGradoInciListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-grado-inci-active-list-ascendente")
	public ResponseEntity<List<Tbasg114GradoinciDto>> getGradoInciActiveListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg114GradoinciDto> tbasg114GradoinciDto = tbasg114GradoinciService
					.getGradoInciActiveListAscendente();

			if (tbasg114GradoinciDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg114GradoinciDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getGradoInciActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-grado-inci-active-list-descendente")
	public ResponseEntity<List<Tbasg114GradoinciDto>> getGradoInciActiveListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg114GradoinciDto> tbasg114GradoinciDto = tbasg114GradoinciService
					.getGradoInciActiveListDescendente();

			if (tbasg114GradoinciDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg114GradoinciDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getGradoInciActiveListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-grado-inci")
	public ResponseEntity<List<Tbasg114GradoinciDto>> getGradoInci(String cdgoGrado) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg114GradoinciDto> tbasg114GradoinciDto = tbasg114GradoinciService.getGradoInci(cdgoGrado);

			if (tbasg114GradoinciDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg114GradoinciDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getGradoInci []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-grado-inci")
	public ResponseEntity<?> insertGradoInci(@RequestBody Tbasg114Gradoinci bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg114GradoinciDto = tbasg114GradoinciService.insertGradoInci(bean);
			return new ResponseEntity<>(tbasg114GradoinciDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertGradoInci []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-grado-inci")
	public ResponseEntity<?> updateGradoInci(@RequestBody Tbasg114Gradoinci bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg114GradoinciDto = tbasg114GradoinciService.updateGradoInci(bean);
			return new ResponseEntity<>(tbasg114GradoinciDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateGradoInci []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-grado-inci")
	public ResponseEntity<?> estadoGradoInci(@RequestBody Tbasg114Gradoinci bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg114GradoinciDto = tbasg114GradoinciService.estadoGradoInci(bean);
			return new ResponseEntity<>(tbasg114GradoinciDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoGradoInci []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
