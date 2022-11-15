package renfe.com.controller;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

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

import renfe.com.dto.GetDiferentValuesTipoDTO;
import renfe.com.dto.InsertActaincalParamDTO;
import renfe.com.model.dto.Tbasg146ActaincalDto;
import renfe.com.model.entity.Tbasg146Actaincal;
import renfe.com.service.Tbasg146ActaincalService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg146Actaincal")
public class Tbasg146ActaincalController {
	
	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg146ActaincalService tbasg146ActaincalService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg146ActaincalDto>> getAllTbasg146Actaincal(Tbasg146ActaincalDto filter) {
		return new ResponseEntity<>(tbasg146ActaincalService.getAllTbasg146Actaincal(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoActaform}/{desgTipocurso}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoActaform") Integer cdgoActaform,
			@PathVariable("desgTipocurso") String desgTipocurso) {
		Tbasg146ActaincalDto tbasg146ActaincalData = tbasg146ActaincalService
				.findByCdgoActaformDesgTipocurso(cdgoActaform, desgTipocurso);

		if (tbasg146ActaincalData != null) {
			return new ResponseEntity<>(tbasg146ActaincalData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg146ActaincalDto> createTbasg146Actaincal(
			@RequestBody Tbasg146ActaincalDto tbasg146ActaincalDto) {
		try {
			return new ResponseEntity<>(tbasg146ActaincalService.createTbasg146Actaincal(tbasg146ActaincalDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg146Actaincal {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoActaform}/{desgTipocurso}")
	public ResponseEntity<Tbasg146ActaincalDto> updateTbasg146Actaincal(
			@PathVariable("cdgoActaform") Integer cdgoActaform, @PathVariable("desgTipocurso") String desgTipocurso,
			@RequestBody Tbasg146ActaincalDto tbasg146ActaincalDto) {
		try {
			Tbasg146ActaincalDto tbasg146ActaincalData = tbasg146ActaincalService.updateTbasg146Actaincal(cdgoActaform,
					desgTipocurso, tbasg146ActaincalDto);
			if (tbasg146ActaincalData != null) {
				return new ResponseEntity<>(tbasg146ActaincalData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg146Actaincal []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoActaform}/{desgTipocurso}")
	public ResponseEntity<HttpStatus> deleteTbasg146Actaincal(@PathVariable("cdgoActaform") Integer cdgoActaform,
			@PathVariable("desgTipocurso") String desgTipocurso) {
		try {
			tbasg146ActaincalService.deleteTbasg146Actaincal(cdgoActaform, desgTipocurso);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg146Actaincal []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Tbasg146ActaincalDto>> findByCdgoActaformDesgTipocursoIn(List<Integer> cdgoActaform,
			List<String> desgTipocurso) {
		try {
			List<Tbasg146ActaincalDto> tbasg146ActaincalDto = tbasg146ActaincalService
					.findByCdgoActaformDesgTipocursoIn(cdgoActaform, desgTipocurso);

			if (tbasg146ActaincalDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg146ActaincalDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoActaformDesgTipocursoIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-diferent-values")
	public ResponseEntity<List<GetDiferentValuesTipoDTO>> getDiferentValues() {
		try {
			List<GetDiferentValuesTipoDTO> tbasg146ActaincalDto = tbasg146ActaincalService.getDiferentValues();

			if (tbasg146ActaincalDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg146ActaincalDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDiferentValues {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-acta-in-cal")
	public ResponseEntity<List<Tbasg146ActaincalDto>> getActaInCal(String cdgoActaform, String desgTipocurso) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg146ActaincalDto> tbasg146ActaincalDto = tbasg146ActaincalService.getActaInCal(cdgoActaform,
					desgTipocurso);

			if (tbasg146ActaincalDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg146ActaincalDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActaInCal []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-acta-in-cal-list")
	public ResponseEntity<List<Tbasg146ActaincalDto>> getActaInCalList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg146ActaincalDto> tbasg146ActaincalDto = tbasg146ActaincalService.getActaInCalList();

			if (tbasg146ActaincalDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg146ActaincalDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActaInCalList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-acta-in-cal-acta-forma")
	public ResponseEntity<List<Tbasg146ActaincalDto>> getActaInCalActaForma(String cdgoActaform) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg146ActaincalDto> tbasg146ActaincalDto = tbasg146ActaincalService
					.getActaInCalActaForma(cdgoActaform);

			if (tbasg146ActaincalDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg146ActaincalDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActaInCalActaForma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-acta-in-cal-acta-forma-mantenimiento")
	public ResponseEntity<List<Tbasg146ActaincalDto>> getActaInCalActaFormaMantenimiento(String cdgoActaform) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg146ActaincalDto> tbasg146ActaincalDto = tbasg146ActaincalService
					.getActaInCalActaFormaMantenimiento(cdgoActaform);

			if (tbasg146ActaincalDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg146ActaincalDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActaInCalActaFormaMantenimiento []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-actas-in-cal-actas-forma-mantenimiento")
	public ResponseEntity<List<Tbasg146ActaincalDto>> getActasInCalActasFormaMantenimiento() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg146ActaincalDto> tbasg146ActaincalDto = tbasg146ActaincalService
					.getActasInCalActasFormaMantenimiento();

			if (tbasg146ActaincalDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg146ActaincalDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActasInCalActasFormaMantenimiento []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-acta-in-cal-count")
	public ResponseEntity<?> getActaInCalCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg146ActaincalDto> tbasg146ActaincalDto = tbasg146ActaincalService.getActaInCalCount();

			if (tbasg146ActaincalDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg146ActaincalDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActaInCalCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-acta-in-cal-by-acta")
	public ResponseEntity<List<Tbasg146ActaincalDto>> getActaInCalByActa(Integer cdgoActaform) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg146ActaincalDto> tbasg146ActaincalDto = tbasg146ActaincalService.getActaInCalByActa(cdgoActaform);

			if (tbasg146ActaincalDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg146ActaincalDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActaInCalByActa []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-acta-in-cal")
	public ResponseEntity<Integer> insertActaInCal(@RequestBody Tbasg146Actaincal bean) {
		ResponseEntity<Integer> result = new ResponseEntity<Integer>(0, HttpStatus.OK);		

		try {
			int tbasg146ActaincalDto = tbasg146ActaincalService.insertActaInCal(bean);
			result = new ResponseEntity<>(tbasg146ActaincalDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("insertActaInCal []", e);
		}

		return result;
	}

	@Transactional
	@GetMapping("/update-acta-in-cal")
	public ResponseEntity<?> updateActaInCal(String desgTipocurso, Integer cdgoCalifi, String cdgoIdinstru, String fchaCurso, String descUsuact, String mrcaActivo, String cdgoIdexa, Integer cdgoActaform, String desgTipocursoActual) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg146ActaincalDto = tbasg146ActaincalService.updateActaInCal(desgTipocurso,cdgoCalifi,cdgoIdinstru,fchaCurso,descUsuact,mrcaActivo,cdgoIdexa,cdgoActaform,desgTipocursoActual);
			return new ResponseEntity<>(tbasg146ActaincalDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateActaInCal []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-acta-in-cal-mantenimiento")
	public ResponseEntity<?> updateActaInCalMantenimiento(Tbasg146Actaincal bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg146ActaincalDto = tbasg146ActaincalService.updateActaInCalMantenimiento(bean);
			return new ResponseEntity<>(tbasg146ActaincalDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateActaInCalMantenimiento []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional
	@GetMapping("/inactive-by-cdgo-acta-form")
	public ResponseEntity<?> inactiveByCdgoActaForm(String usuAct, Integer cdgoActaform) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg146ActaincalDto = tbasg146ActaincalService.inactiveByCdgoActaForm(usuAct,cdgoActaform);
			return new ResponseEntity<>(tbasg146ActaincalDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("inactiveByCdgoActaForm []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-acta-in-cal")
	public ResponseEntity<?> deleteActaInCal(Tbasg146Actaincal bean) {
		// Generated from a DELETE found in an XML
		try {
			int tbasg146ActaincalDto = tbasg146ActaincalService.deleteActaInCal(bean);
			return new ResponseEntity<>(tbasg146ActaincalDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteActaInCal []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
