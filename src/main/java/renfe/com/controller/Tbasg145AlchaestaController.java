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

import renfe.com.model.dto.Tbasg145AlchaestaDto;
import renfe.com.model.entity.Tbasg145Alchaesta;
import renfe.com.service.Tbasg145AlchaestaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg145Alchaesta")
public class Tbasg145AlchaestaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg145AlchaestaService tbasg145AlchaestaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg145AlchaestaDto>> getAllTbasg145Alchaesta(Tbasg145AlchaestaDto filter) {
		return new ResponseEntity<>(tbasg145AlchaestaService.getAllTbasg145Alchaesta(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoAlchabinf}/{cdgoDestino}/{cdgoLinea}/{cdgoOrigen}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoAlchabinf") Integer cdgoAlchabinf,
			@PathVariable("cdgoDestino") String cdgoDestino, @PathVariable("cdgoLinea") String cdgoLinea,
			@PathVariable("cdgoOrigen") String cdgoOrigen) {
		Tbasg145AlchaestaDto tbasg145AlchaestaData = tbasg145AlchaestaService
				.findByCdgoAlchabinfCdgoDestinoCdgoLineaCdgoOrigen(cdgoAlchabinf, cdgoDestino, cdgoLinea, cdgoOrigen);

		if (tbasg145AlchaestaData != null) {
			return new ResponseEntity<>(tbasg145AlchaestaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg145AlchaestaDto> createTbasg145Alchaesta(
			@RequestBody Tbasg145AlchaestaDto tbasg145AlchaestaDto) {
		try {
			return new ResponseEntity<>(tbasg145AlchaestaService.createTbasg145Alchaesta(tbasg145AlchaestaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg145Alchaesta {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoAlchabinf}/{cdgoDestino}/{cdgoLinea}/{cdgoOrigen}")
	public ResponseEntity<Tbasg145AlchaestaDto> updateTbasg145Alchaesta(
			@PathVariable("cdgoAlchabinf") Integer cdgoAlchabinf, @PathVariable("cdgoDestino") String cdgoDestino,
			@PathVariable("cdgoLinea") String cdgoLinea, @PathVariable("cdgoOrigen") String cdgoOrigen,
			@RequestBody Tbasg145AlchaestaDto tbasg145AlchaestaDto) {
		try {
			Tbasg145AlchaestaDto tbasg145AlchaestaData = tbasg145AlchaestaService.updateTbasg145Alchaesta(cdgoAlchabinf,
					cdgoDestino, cdgoLinea, cdgoOrigen, tbasg145AlchaestaDto);
			if (tbasg145AlchaestaData != null) {
				return new ResponseEntity<>(tbasg145AlchaestaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg145Alchaesta []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoAlchabinf}/{cdgoDestino}/{cdgoLinea}/{cdgoOrigen}")
	public ResponseEntity<HttpStatus> deleteTbasg145Alchaesta(@PathVariable("cdgoAlchabinf") Integer cdgoAlchabinf,
			@PathVariable("cdgoDestino") String cdgoDestino, @PathVariable("cdgoLinea") String cdgoLinea,
			@PathVariable("cdgoOrigen") String cdgoOrigen) {
		try {
			tbasg145AlchaestaService.deleteTbasg145Alchaesta(cdgoAlchabinf, cdgoDestino, cdgoLinea, cdgoOrigen);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg145Alchaesta []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg145AlchaestaDto>> findByCdgoAlchabinfCdgoDestinoCdgoLineaCdgoOrigenIn(
			List<Integer> cdgoAlchabinf, List<String> cdgoDestino, List<String> cdgoLinea, List<String> cdgoOrigen) {
		try {
			List<Tbasg145AlchaestaDto> tbasg145AlchaestaDto = tbasg145AlchaestaService
					.findByCdgoAlchabinfCdgoDestinoCdgoLineaCdgoOrigenIn(cdgoAlchabinf, cdgoDestino, cdgoLinea,
							cdgoOrigen);

			if (tbasg145AlchaestaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg145AlchaestaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoAlchabinfCdgoDestinoCdgoLineaCdgoOrigenIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-alc-ha-esta-count")
	public ResponseEntity<?> getAlcHaEstaCount(/** FIXME revisar tipo */
	Object cdgoEntorno) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg145AlchaestaDto> tbasg145AlchaestaDto = tbasg145AlchaestaService.getAlcHaEstaCount(cdgoEntorno);

			if (tbasg145AlchaestaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg145AlchaestaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAlcHaEstaCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-alc-ha-esta")
	public ResponseEntity<List<Tbasg145AlchaestaDto>> getAlcHaEsta(String cdgoAlchabinf, String cdgoLinea,
			String cdgoOrigen, String cdgoDestino) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg145AlchaestaDto> tbasg145AlchaestaDto = tbasg145AlchaestaService.getAlcHaEsta(cdgoAlchabinf,
					cdgoLinea, cdgoOrigen, cdgoDestino);

			if (tbasg145AlchaestaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg145AlchaestaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAlcHaEsta []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-alc-ha-esta")
	public ResponseEntity<Integer> insertAlcHaEsta(@RequestBody Tbasg145AlchaestaDto bean) {
		try {
			int tbasg145AlchaestaDto = tbasg145AlchaestaService.insertAlcHaEsta(bean);
			return new ResponseEntity<>(tbasg145AlchaestaDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("insertAlcHaEsta []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-alc-ha-esta")
	public ResponseEntity<?> deleteAlcHaEsta(Tbasg145Alchaesta bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg145AlchaestaDto = tbasg145AlchaestaService.deleteAlcHaEsta(bean);
			return new ResponseEntity<>(tbasg145AlchaestaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteAlcHaEsta []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/delete-alc-ha-esta-by-alchabinf")
	public ResponseEntity<?> deleteAlcHaEstaByAlchabinf(@RequestBody Tbasg145Alchaesta bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg145AlchaestaDto = tbasg145AlchaestaService.deleteAlcHaEstaByAlchabinf(bean);
			return new ResponseEntity<>(tbasg145AlchaestaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteAlcHaEstaByAlchabinf []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
