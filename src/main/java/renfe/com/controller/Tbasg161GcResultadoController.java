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

import renfe.com.model.dto.Tbasg161GcResultadoDto;
import renfe.com.model.entity.Tbasg161GcResultado;
import renfe.com.service.Tbasg161GcResultadoService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg161GcResultado")
public class Tbasg161GcResultadoController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg161GcResultadoService tbasg161GcResultadoService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg161GcResultadoDto>> getAllTbasg161GcResultado(Tbasg161GcResultadoDto filter) {
		return new ResponseEntity<>(tbasg161GcResultadoService.getAllTbasg161GcResultado(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoCategoria}/{cdgoConcepto}/{cdgoConsulta}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoCategoria") String cdgoCategoria,
			@PathVariable("cdgoConcepto") String cdgoConcepto, @PathVariable("cdgoConsulta") Integer cdgoConsulta) {
		Tbasg161GcResultadoDto tbasg161GcResultadoData = tbasg161GcResultadoService
				.findByCdgoCategoriaCdgoConceptoCdgoConsulta(cdgoCategoria, cdgoConcepto, cdgoConsulta);

		if (tbasg161GcResultadoData != null) {
			return new ResponseEntity<>(tbasg161GcResultadoData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg161GcResultadoDto> createTbasg161GcResultado(
			@RequestBody Tbasg161GcResultadoDto tbasg161GcResultadoDto) {
		try {
			return new ResponseEntity<>(tbasg161GcResultadoService.createTbasg161GcResultado(tbasg161GcResultadoDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg161GcResultado {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoCategoria}/{cdgoConcepto}/{cdgoConsulta}")
	public ResponseEntity<Tbasg161GcResultadoDto> updateTbasg161GcResultado(
			@PathVariable("cdgoCategoria") String cdgoCategoria, @PathVariable("cdgoConcepto") String cdgoConcepto,
			@PathVariable("cdgoConsulta") Integer cdgoConsulta,
			@RequestBody Tbasg161GcResultadoDto tbasg161GcResultadoDto) {
		try {
			Tbasg161GcResultadoDto tbasg161GcResultadoData = tbasg161GcResultadoService
					.updateTbasg161GcResultado(cdgoCategoria, cdgoConcepto, cdgoConsulta, tbasg161GcResultadoDto);
			if (tbasg161GcResultadoData != null) {
				return new ResponseEntity<>(tbasg161GcResultadoData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg161GcResultado []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoCategoria}/{cdgoConcepto}/{cdgoConsulta}")
	public ResponseEntity<HttpStatus> deleteTbasg161GcResultado(@PathVariable("cdgoCategoria") String cdgoCategoria,
			@PathVariable("cdgoConcepto") String cdgoConcepto, @PathVariable("cdgoConsulta") Integer cdgoConsulta) {
		try {
			tbasg161GcResultadoService.deleteTbasg161GcResultado(cdgoCategoria, cdgoConcepto, cdgoConsulta);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg161GcResultado []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg161GcResultadoDto>> findByCdgoCategoriaCdgoConceptoCdgoConsultaIn(
			List<String> cdgoCategoria, List<String> cdgoConcepto, List<Integer> cdgoConsulta) {
		try {
			List<Tbasg161GcResultadoDto> tbasg161GcResultadoDto = tbasg161GcResultadoService
					.findByCdgoCategoriaCdgoConceptoCdgoConsultaIn(cdgoCategoria, cdgoConcepto, cdgoConsulta);

			if (tbasg161GcResultadoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg161GcResultadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoCategoriaCdgoConceptoCdgoConsultaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-gc-resultados-list-active")
	public ResponseEntity<List<Tbasg161GcResultadoDto>> getGcResultadosListActive(String cdgoConsulta) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg161GcResultadoDto> tbasg161GcResultadoDto = tbasg161GcResultadoService
					.getGcResultadosListActive(cdgoConsulta);

			if (tbasg161GcResultadoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg161GcResultadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getGcResultadosListActive []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-gc-resultado")
	public ResponseEntity<List<Tbasg161GcResultadoDto>> getGcResultado(String cdgoConsulta, String cdgoCategoria,
			String cdgoConcepto) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg161GcResultadoDto> tbasg161GcResultadoDto = tbasg161GcResultadoService
					.getGcResultado(cdgoConsulta, cdgoCategoria, cdgoConcepto);

			if (tbasg161GcResultadoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg161GcResultadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getGcResultado []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-gc-resultado")
	public ResponseEntity<?> insertGcResultado(Tbasg161GcResultado bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg161GcResultadoDto = tbasg161GcResultadoService.insertGcResultado(bean);
			return new ResponseEntity<>(tbasg161GcResultadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertGcResultado []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-gc-resultado")
	public ResponseEntity<?> updateGcResultado(Tbasg161GcResultado bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg161GcResultadoDto = tbasg161GcResultadoService.updateGcResultado(bean);
			return new ResponseEntity<>(tbasg161GcResultadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateGcResultado []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-gc-resultados-consulta")
	public ResponseEntity<?> deleteGcResultadosConsulta(Tbasg161GcResultado bean) {
		// Generated from a DELETE found in an XML
		try {
			int tbasg161GcResultadoDto = tbasg161GcResultadoService.deleteGcResultadosConsulta(bean);
			return new ResponseEntity<>(tbasg161GcResultadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteGcResultadosConsulta []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
