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

import renfe.com.dto.GetFormacionComplementariaPersonaListResultDTO;
import renfe.com.dto.InsertFormaccomplemenParamDTO;
import renfe.com.model.dto.Tbasg152PersempDto;
import renfe.com.model.dto.Tbasg157FormacComplemenDto;
import renfe.com.model.entity.Tbasg157FormacComplemen;
import renfe.com.service.Tbasg157FormacComplemenService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg157FormacComplemen")
public class Tbasg157FormacComplemenController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg157FormacComplemenService tbasg157FormacComplemenService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg157FormacComplemenDto>> getAllTbasg157FormacComplemen(
			Tbasg157FormacComplemenDto filter) {
		return new ResponseEntity<>(tbasg157FormacComplemenService.getAllTbasg157FormacComplemen(filter),
				HttpStatus.OK);
	}

	@GetMapping("/{cdgoCategoria}/{cdgoCualificacion}/{cdgoPersona}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoCategoria") Integer cdgoCategoria,
			@PathVariable("cdgoCualificacion") Integer cdgoCualificacion,
			@PathVariable("cdgoPersona") Integer cdgoPersona) {
		Tbasg157FormacComplemenDto tbasg157FormacComplemenData = tbasg157FormacComplemenService
				.findByCdgoCategoriaCdgoCualificacionCdgoPersona(cdgoCategoria, cdgoCualificacion, cdgoPersona);

		if (tbasg157FormacComplemenData != null) {
			return new ResponseEntity<>(tbasg157FormacComplemenData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg157FormacComplemenDto> createTbasg157FormacComplemen(
			@RequestBody Tbasg157FormacComplemenDto tbasg157FormacComplemenDto) {
		try {
			return new ResponseEntity<>(
					tbasg157FormacComplemenService.createTbasg157FormacComplemen(tbasg157FormacComplemenDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg157FormacComplemen {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoCategoria}/{cdgoCualificacion}/{cdgoPersona}")
	public ResponseEntity<Tbasg157FormacComplemenDto> updateTbasg157FormacComplemen(
			@PathVariable("cdgoCategoria") Integer cdgoCategoria,
			@PathVariable("cdgoCualificacion") Integer cdgoCualificacion,
			@PathVariable("cdgoPersona") Integer cdgoPersona,
			@RequestBody Tbasg157FormacComplemenDto tbasg157FormacComplemenDto) {
		try {
			Tbasg157FormacComplemenDto tbasg157FormacComplemenData = tbasg157FormacComplemenService
					.updateTbasg157FormacComplemen(cdgoCategoria, cdgoCualificacion, cdgoPersona,
							tbasg157FormacComplemenDto);
			if (tbasg157FormacComplemenData != null) {
				return new ResponseEntity<>(tbasg157FormacComplemenData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg157FormacComplemen []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoCategoria}/{cdgoCualificacion}/{cdgoPersona}")
	public ResponseEntity<HttpStatus> deleteTbasg157FormacComplemen(
			@PathVariable("cdgoCategoria") Integer cdgoCategoria,
			@PathVariable("cdgoCualificacion") Integer cdgoCualificacion,
			@PathVariable("cdgoPersona") Integer cdgoPersona) {
		try {
			tbasg157FormacComplemenService.deleteTbasg157FormacComplemen(cdgoCategoria, cdgoCualificacion, cdgoPersona);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg157FormacComplemen []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg157FormacComplemenDto>> findByCdgoCategoriaCdgoCualificacionCdgoPersonaIn(
			List<Integer> cdgoCategoria, List<Integer> cdgoCualificacion, List<Integer> cdgoPersona) {
		try {
			List<Tbasg157FormacComplemenDto> tbasg157FormacComplemenDto = tbasg157FormacComplemenService
					.findByCdgoCategoriaCdgoCualificacionCdgoPersonaIn(cdgoCategoria, cdgoCualificacion, cdgoPersona);

			if (tbasg157FormacComplemenDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg157FormacComplemenDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoCategoriaCdgoCualificacionCdgoPersonaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-formac-complemen-persona-list")
	public ResponseEntity<List<GetFormacionComplementariaPersonaListResultDTO>> getFormacComplemenPersonaList(Integer cdgoPersona, Integer cdgoCategoria, Integer cdgoCualificacion) {

		try {

			List<GetFormacionComplementariaPersonaListResultDTO> tbasg157FormacComplemenDto = tbasg157FormacComplemenService.getFormacComplemenPersonaList(cdgoPersona,cdgoCategoria,cdgoCualificacion);


			if (tbasg157FormacComplemenDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tbasg157FormacComplemenDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("getFormacComplemenPersonaList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-formac-complemen")
	public ResponseEntity<Integer> insertFormacComplemen(@RequestBody InsertFormaccomplemenParamDTO bean) { 
		ResponseEntity<Integer> result = new ResponseEntity<Integer>(0, HttpStatus.OK);
		try {
			logger.debug("---> getCdgoPersona {} ",bean.getCdgoPersona());
			logger.debug("---> getCdgoCategoria {} ",bean.getCdgoCategoria());
			logger.debug("---> getCdgoCualificacion {} ",bean.getCdgoCualificacion());			
			logger.debug("---> getFechaExpedicion {} ",bean.getFechaExpedicion());
			logger.debug("---> getMrcaActivo {} ",bean.getMrcaActivo()); 
			logger.debug("---> getObservaciones {} ",bean.getObservaciones()); 
			
			//Verificar si ya existe la formacion complementaria 
			List<GetFormacionComplementariaPersonaListResultDTO> getFormacComplemenPersonaListResponse = tbasg157FormacComplemenService.getFormacComplemenPersonaList(bean.getCdgoPersona(), bean.getCdgoCategoria(), bean.getCdgoCualificacion());

			logger.debug("---- "); 
			logger.debug("---> getFormacComplemenPersonaListResponse is empty: {} ",getFormacComplemenPersonaListResponse.isEmpty()); 

			//Si no existe registramos la formacion complementaria
			if (getFormacComplemenPersonaListResponse.isEmpty()) {	
				int insertFormacComplemenResponse = tbasg157FormacComplemenService.insertFormacComplemen(bean);
				return new ResponseEntity<>(insertFormacComplemenResponse, HttpStatus.OK);				
			
			} else {
				logger.debug("---- "); 
				logger.debug("---> getFormacComplemenPersonaListResponse: {} ",getFormacComplemenPersonaListResponse.get(0).getCdgoPersona());
			}

		} catch (Exception e) {
			logger.error("insertFormacComplemen []", e);
		}

		return result;
	}

	@PutMapping("/update-formac-complemen")
	public ResponseEntity<?> updateFormacComplemen(@RequestBody Tbasg157FormacComplemen bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg157FormacComplemenDto = tbasg157FormacComplemenService.updateFormacComplemen(bean);
			return new ResponseEntity<>(tbasg157FormacComplemenDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateFormacComplemen []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete-formac-complemen/{cdgoPersona}/{cdgoCategoria}/{cdgoCualificacion}")
	public ResponseEntity<?> deleteFormacComplemen(@PathVariable("cdgoPersona") Integer cdgoPersona, @PathVariable("cdgoCategoria") Integer cdgoCategoria, @PathVariable("cdgoCualificacion") Integer cdgoCualificacion) {
		// Generated from a DELETE found in an XML
		try {
			tbasg157FormacComplemenService.deleteFormacComplemen(cdgoPersona, cdgoCategoria, cdgoCualificacion);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteFormacComplemen []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-forma-compl-persona")
	public ResponseEntity<List<Tbasg157FormacComplemenDto>> getFormaComplemenPersona(Integer cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg157FormacComplemenDto> tbasg157FormacComplemenDto = tbasg157FormacComplemenService.getFormaComplemenPersona(cdgoPersona);

			if (tbasg157FormacComplemenDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg157FormacComplemenDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFormaComplemenPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
