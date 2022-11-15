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

import renfe.com.dto.GetPersempParametersDTO;
import renfe.com.model.dto.Tbasg152PersempDto;
import renfe.com.model.entity.Tbasg152Persemp;
import renfe.com.service.Tbasg152PersempService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg152Persemp")
public class Tbasg152PersempController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg152PersempService tbasg152PersempService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg152PersempDto>> getAllTbasg152Persemp(Tbasg152PersempDto filter) {
		return new ResponseEntity<>(tbasg152PersempService.getAllTbasg152Persemp(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoEmpresa}/{cdgoPersona}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoEmpresa") Integer cdgoEmpresa,
			@PathVariable("cdgoPersona") Integer cdgoPersona) {
		Tbasg152PersempDto tbasg152PersempData = tbasg152PersempService.findByCdgoEmpresaCdgoPersona(cdgoEmpresa,
				cdgoPersona);

		if (tbasg152PersempData != null) {
			return new ResponseEntity<>(tbasg152PersempData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg152PersempDto> createTbasg152Persemp(
			@RequestBody Tbasg152PersempDto tbasg152PersempDto) {
		try {
			return new ResponseEntity<>(tbasg152PersempService.createTbasg152Persemp(tbasg152PersempDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg152Persemp {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoEmpresa}/{cdgoPersona}")
	public ResponseEntity<Tbasg152PersempDto> updateTbasg152Persemp(@PathVariable("cdgoEmpresa") Integer cdgoEmpresa,
			@PathVariable("cdgoPersona") Integer cdgoPersona, @RequestBody Tbasg152PersempDto tbasg152PersempDto) {
		try {
			Tbasg152PersempDto tbasg152PersempData = tbasg152PersempService.updateTbasg152Persemp(cdgoEmpresa,
					cdgoPersona, tbasg152PersempDto);
			if (tbasg152PersempData != null) {
				return new ResponseEntity<>(tbasg152PersempData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg152Persemp []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoEmpresa}/{cdgoPersona}")
	public ResponseEntity<HttpStatus> deleteTbasg152Persemp(@PathVariable("cdgoEmpresa") Integer cdgoEmpresa,
			@PathVariable("cdgoPersona") Integer cdgoPersona) {
		try {
			tbasg152PersempService.deleteTbasg152Persemp(cdgoEmpresa, cdgoPersona);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg152Persemp []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg152PersempDto>> findByCdgoEmpresaCdgoPersonaIn(List<Integer> cdgoEmpresa,
			List<Integer> cdgoPersona) {
		try {
			List<Tbasg152PersempDto> tbasg152PersempDto = tbasg152PersempService
					.findByCdgoEmpresaCdgoPersonaIn(cdgoEmpresa, cdgoPersona);

			if (tbasg152PersempDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg152PersempDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoEmpresaCdgoPersonaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-persona-empresa")
	public ResponseEntity<List<Tbasg152PersempDto>> getPersonaEmpresa(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg152PersempDto> tbasg152PersempDto = tbasg152PersempService.getPersonaEmpresa(cdgoPersona);

			if (tbasg152PersempDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg152PersempDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPersonaEmpresa []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-persona-empresa-list-mantenimiento")
	public ResponseEntity<List<Tbasg152PersempDto>> getPersonaEmpresaListMantenimiento(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg152PersempDto> tbasg152PersempDto = tbasg152PersempService
					.getPersonaEmpresaListMantenimiento(cdgoPersona);

			if (tbasg152PersempDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg152PersempDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPersonaEmpresaListMantenimiento []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-persona-empresa")
	public ResponseEntity<Integer> insertPersonaEmpresa(@RequestBody GetPersempParametersDTO bean) {
		try {
			int tbasg152PersempDto = tbasg152PersempService.insertPersonaEmpresa(bean);
			return new ResponseEntity<>(tbasg152PersempDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("insertPersonaEmpresa []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-persona-empresa")
	public ResponseEntity<Integer> updatePersonaEmpresa(@RequestBody GetPersempParametersDTO bean) {		
		try {
			int tbasg152PersempDto = tbasg152PersempService.updatePersonaEmpresa(bean);
			return new ResponseEntity<>(tbasg152PersempDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("updatePersonaEmpresa []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-persona-empresa-mantenimiento")
	public ResponseEntity<?> deletePersonaEmpresaMantenimiento(Tbasg152Persemp bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg152PersempDto = tbasg152PersempService.deletePersonaEmpresaMantenimiento(bean);
			return new ResponseEntity<>(tbasg152PersempDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deletePersonaEmpresaMantenimiento []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-persona-empresa-mantenimiento")
	public ResponseEntity<?> updatePersonaEmpresaMantenimiento(Tbasg152Persemp bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg152PersempDto = tbasg152PersempService.updatePersonaEmpresaMantenimiento(bean);
			return new ResponseEntity<>(tbasg152PersempDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updatePersonaEmpresaMantenimiento []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
