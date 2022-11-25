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

import renfe.com.model.dto.Tbasg126AlchabinfDto;
import renfe.com.model.entity.Tbasg126Alchabinf;
import renfe.com.service.Tbasg126AlchabinfService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg126Alchabinf")
public class Tbasg126AlchabinfController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg126AlchabinfService tbasg126AlchabinfService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg126AlchabinfDto>> getAllTbasg126Alchabinf(Tbasg126AlchabinfDto filter) {
		return new ResponseEntity<>(tbasg126AlchabinfService.getAllTbasg126Alchabinf(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoAlchabinf}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoAlchabinf") Integer cdgoAlchabinf) {
		Tbasg126AlchabinfDto tbasg126AlchabinfData = tbasg126AlchabinfService.findByCdgoAlchabinf(cdgoAlchabinf);

		if (tbasg126AlchabinfData != null) {
			return new ResponseEntity<>(tbasg126AlchabinfData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg126AlchabinfDto> createTbasg126Alchabinf(
			@RequestBody Tbasg126AlchabinfDto tbasg126AlchabinfDto) {
		try {
			return new ResponseEntity<>(tbasg126AlchabinfService.createTbasg126Alchabinf(tbasg126AlchabinfDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg126Alchabinf {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoAlchabinf}")
	public ResponseEntity<Tbasg126AlchabinfDto> updateTbasg126Alchabinf(@PathVariable("cdgoAlchabinf") Integer cdgo,
			@RequestBody Tbasg126AlchabinfDto body) {
		try {
			Tbasg126AlchabinfDto tbasg126AlchabinfData = tbasg126AlchabinfService.updateTbasg126Alchabinf(cdgo, body);
			if (tbasg126AlchabinfData != null) {
				return new ResponseEntity<>(tbasg126AlchabinfData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg126Alchabinf []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoAlchabinf}")
	public ResponseEntity<HttpStatus> deleteTbasg126Alchabinf(@PathVariable("cdgoAlchabinf") Integer cdgoAlchabinf) {
		try {
			tbasg126AlchabinfService.deleteTbasg126Alchabinf(cdgoAlchabinf);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg126Alchabinf []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg126AlchabinfDto>> findByCdgoAlchabinfIn(List<Integer> cdgoAlchabinf) {
		try {
			List<Tbasg126AlchabinfDto> tbasg126AlchabinfDto = tbasg126AlchabinfService
					.findByCdgoAlchabinfIn(cdgoAlchabinf);

			if (tbasg126AlchabinfDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg126AlchabinfDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoAlchabinfIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-alc-hab-inf-by-cdgo-exp")
	public ResponseEntity<List<Tbasg126AlchabinfDto>> findAlcHabInfByCdgoExp(Integer cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg126AlchabinfDto> tbasg126AlchabinfDto = tbasg126AlchabinfService
					.findAlcHabInfByCdgoExp(cdgoExpedient);

			if (tbasg126AlchabinfDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg126AlchabinfDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findAlcHabInfByCdgoExp []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-alc-hab-inf")
	public ResponseEntity<List<Tbasg126AlchabinfDto>> getAlcHabInf(String cdgoAlchabinf) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg126AlchabinfDto> tbasg126AlchabinfDto = tbasg126AlchabinfService.getAlcHabInf(cdgoAlchabinf);

			if (tbasg126AlchabinfDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg126AlchabinfDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAlcHabInf []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-alc-hab-inf")
	public ResponseEntity<Integer> insertAlcHabInf(@RequestBody Tbasg126AlchabinfDto bean) {
		try {
			int tbasg126AlchabinfDto = tbasg126AlchabinfService.insertAlcHabInf(bean);
			return new ResponseEntity<>(tbasg126AlchabinfDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("insertAlcHabInf []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/delete-alc-hab-inf-by-cdgo-exp")
	public ResponseEntity<?> deleteAlcHabInfByCdgoExp(@RequestBody Tbasg126Alchabinf bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg126AlchabinfDto = tbasg126AlchabinfService.deleteAlcHabInfByCdgoExp(bean);
			return new ResponseEntity<>(tbasg126AlchabinfDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteAlcHabInfByCdgoExp []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-alc-hab-inf")
	public ResponseEntity<?> deleteAlcHabInf(Tbasg126Alchabinf bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg126AlchabinfDto = tbasg126AlchabinfService.deleteAlcHabInf(bean);
			return new ResponseEntity<>(tbasg126AlchabinfDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteAlcHabInf []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-previous-esta-hab-in-list")
	public ResponseEntity<?> getPreviousEstaHabInList(String cdgoAlchabinf) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg126AlchabinfDto> tbasg126AlchabinfDto = tbasg126AlchabinfService
					.getPreviousEstaHabInList(cdgoAlchabinf);

			if (tbasg126AlchabinfDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg126AlchabinfDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPreviousEstaHabInList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-max-entornos-exp-list")
	public ResponseEntity<List<Tbasg126AlchabinfDto>> getMaxEntornosExpList(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg126AlchabinfDto> tbasg126AlchabinfDto = tbasg126AlchabinfService
					.getMaxEntornosExpList(cdgoExpedient);

			if (tbasg126AlchabinfDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg126AlchabinfDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getMaxEntornosExpList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-max-entornos-exp-list-desc")
	public ResponseEntity<List<Tbasg126AlchabinfDto>> getMaxEntornosExpListDesc(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg126AlchabinfDto> tbasg126AlchabinfDto = tbasg126AlchabinfService
					.getMaxEntornosExpListDesc(cdgoExpedient);

			if (tbasg126AlchabinfDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg126AlchabinfDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getMaxEntornosExpListDesc []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-tramo-by-cod-expediente")
	public ResponseEntity<List<Tbasg126AlchabinfDto>> findTramoByCodExpediente(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg126AlchabinfDto> tbasg126AlchabinfDto = tbasg126AlchabinfService
					.findTramoByCodExpediente(cdgoExpedient);

			if (tbasg126AlchabinfDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg126AlchabinfDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findTramoByCodExpediente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
