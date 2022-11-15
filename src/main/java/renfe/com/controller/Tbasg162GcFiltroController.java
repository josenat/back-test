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

import renfe.com.model.dto.Tbasg162GcFiltroDto;
import renfe.com.model.entity.Tbasg162GcFiltro;
import renfe.com.service.Tbasg162GcFiltroService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg162GcFiltro")
public class Tbasg162GcFiltroController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg162GcFiltroService tbasg162GcFiltroService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg162GcFiltroDto>> getAllTbasg162GcFiltro(Tbasg162GcFiltroDto filter) {
		return new ResponseEntity<>(tbasg162GcFiltroService.getAllTbasg162GcFiltro(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoFiltro}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoFiltro") Integer cdgoFiltro) {
		Tbasg162GcFiltroDto tbasg162GcFiltroData = tbasg162GcFiltroService.findByCdgoFiltro(cdgoFiltro);

		if (tbasg162GcFiltroData != null) {
			return new ResponseEntity<>(tbasg162GcFiltroData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg162GcFiltroDto> createTbasg162GcFiltro(
			@RequestBody Tbasg162GcFiltroDto tbasg162GcFiltroDto) {
		try {
			return new ResponseEntity<>(tbasg162GcFiltroService.createTbasg162GcFiltro(tbasg162GcFiltroDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg162GcFiltro {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoFiltro}")
	public ResponseEntity<Tbasg162GcFiltroDto> updateTbasg162GcFiltro(@PathVariable("cdgoFiltro") Integer cdgo,
			@RequestBody Tbasg162GcFiltroDto body) {
		try {
			Tbasg162GcFiltroDto tbasg162GcFiltroData = tbasg162GcFiltroService.updateTbasg162GcFiltro(cdgo, body);
			if (tbasg162GcFiltroData != null) {
				return new ResponseEntity<>(tbasg162GcFiltroData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg162GcFiltro []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoFiltro}")
	public ResponseEntity<HttpStatus> deleteTbasg162GcFiltro(@PathVariable("cdgoFiltro") Integer cdgoFiltro) {
		try {
			tbasg162GcFiltroService.deleteTbasg162GcFiltro(cdgoFiltro);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg162GcFiltro []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg162GcFiltroDto>> findByCdgoFiltroIn(List<Integer> cdgoFiltro) {
		try {
			List<Tbasg162GcFiltroDto> tbasg162GcFiltroDto = tbasg162GcFiltroService.findByCdgoFiltroIn(cdgoFiltro);

			if (tbasg162GcFiltroDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg162GcFiltroDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoFiltroIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-gc-filtros-list-active")
	public ResponseEntity<List<Tbasg162GcFiltroDto>> getGcFiltrosListActive(String cdgoConsulta) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg162GcFiltroDto> tbasg162GcFiltroDto = tbasg162GcFiltroService
					.getGcFiltrosListActive(cdgoConsulta);

			if (tbasg162GcFiltroDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg162GcFiltroDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getGcFiltrosListActive []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-gc-filtros-list")
	public ResponseEntity<List<Tbasg162GcFiltroDto>> getGcFiltrosList(String cdgoConsulta) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg162GcFiltroDto> tbasg162GcFiltroDto = tbasg162GcFiltroService.getGcFiltrosList(cdgoConsulta);

			if (tbasg162GcFiltroDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg162GcFiltroDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getGcFiltrosList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-gc-filtro")
	public ResponseEntity<List<Tbasg162GcFiltroDto>> getGcFiltro(String cdgoFiltro) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg162GcFiltroDto> tbasg162GcFiltroDto = tbasg162GcFiltroService.getGcFiltro(cdgoFiltro);

			if (tbasg162GcFiltroDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg162GcFiltroDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getGcFiltro []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-gc-filtro")
	public ResponseEntity<?> insertGcFiltro(Tbasg162GcFiltro bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg162GcFiltroDto = tbasg162GcFiltroService.insertGcFiltro(bean);
			return new ResponseEntity<>(tbasg162GcFiltroDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertGcFiltro []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-gc-filtro")
	public ResponseEntity<?> updateGcFiltro(Tbasg162GcFiltro bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg162GcFiltroDto = tbasg162GcFiltroService.updateGcFiltro(bean);
			return new ResponseEntity<>(tbasg162GcFiltroDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateGcFiltro []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-gc-filtro-logico")
	public ResponseEntity<?> deleteGcFiltroLogico(Tbasg162GcFiltro bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg162GcFiltroDto = tbasg162GcFiltroService.deleteGcFiltroLogico(bean);
			return new ResponseEntity<>(tbasg162GcFiltroDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteGcFiltroLogico []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-gc-filtros-consulta")
	public ResponseEntity<?> deleteGcFiltrosConsulta(Tbasg162GcFiltro bean) {
		// Generated from a DELETE found in an XML
		try {
			int tbasg162GcFiltroDto = tbasg162GcFiltroService.deleteGcFiltrosConsulta(bean);
			return new ResponseEntity<>(tbasg162GcFiltroDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteGcFiltrosConsulta []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
