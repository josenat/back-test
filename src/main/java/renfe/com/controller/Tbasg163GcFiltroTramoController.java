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

import renfe.com.model.dto.Tbasg163GcFiltroTramoDto;
import renfe.com.model.entity.Tbasg163GcFiltroTramo;
import renfe.com.service.Tbasg163GcFiltroTramoService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg163GcFiltroTramo")
public class Tbasg163GcFiltroTramoController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg163GcFiltroTramoService tbasg163GcFiltroTramoService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg163GcFiltroTramoDto>> getAllTbasg163GcFiltroTramo(Tbasg163GcFiltroTramoDto filter) {
		return new ResponseEntity<>(tbasg163GcFiltroTramoService.getAllTbasg163GcFiltroTramo(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoFiltroTramo}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoFiltroTramo") Integer cdgoFiltroTramo) {
		Tbasg163GcFiltroTramoDto tbasg163GcFiltroTramoData = tbasg163GcFiltroTramoService
				.findByCdgoFiltroTramo(cdgoFiltroTramo);

		if (tbasg163GcFiltroTramoData != null) {
			return new ResponseEntity<>(tbasg163GcFiltroTramoData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg163GcFiltroTramoDto> createTbasg163GcFiltroTramo(
			@RequestBody Tbasg163GcFiltroTramoDto tbasg163GcFiltroTramoDto) {
		try {
			return new ResponseEntity<>(
					tbasg163GcFiltroTramoService.createTbasg163GcFiltroTramo(tbasg163GcFiltroTramoDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg163GcFiltroTramo {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoFiltroTramo}")
	public ResponseEntity<Tbasg163GcFiltroTramoDto> updateTbasg163GcFiltroTramo(
			@PathVariable("cdgoFiltroTramo") Integer cdgo, @RequestBody Tbasg163GcFiltroTramoDto body) {
		try {
			Tbasg163GcFiltroTramoDto tbasg163GcFiltroTramoData = tbasg163GcFiltroTramoService
					.updateTbasg163GcFiltroTramo(cdgo, body);
			if (tbasg163GcFiltroTramoData != null) {
				return new ResponseEntity<>(tbasg163GcFiltroTramoData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg163GcFiltroTramo []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoFiltroTramo}")
	public ResponseEntity<HttpStatus> deleteTbasg163GcFiltroTramo(
			@PathVariable("cdgoFiltroTramo") Integer cdgoFiltroTramo) {
		try {
			tbasg163GcFiltroTramoService.deleteTbasg163GcFiltroTramo(cdgoFiltroTramo);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg163GcFiltroTramo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg163GcFiltroTramoDto>> findByCdgoFiltroTramoIn(List<Integer> cdgoFiltroTramo) {
		try {
			List<Tbasg163GcFiltroTramoDto> tbasg163GcFiltroTramoDto = tbasg163GcFiltroTramoService
					.findByCdgoFiltroTramoIn(cdgoFiltroTramo);

			if (tbasg163GcFiltroTramoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg163GcFiltroTramoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoFiltroTramoIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-gc-filtros-tramo-list-active")
	public ResponseEntity<List<Tbasg163GcFiltroTramoDto>> getGcFiltrosTramoListActive(String cdgoConsulta) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg163GcFiltroTramoDto> tbasg163GcFiltroTramoDto = tbasg163GcFiltroTramoService
					.getGcFiltrosTramoListActive(cdgoConsulta);

			if (tbasg163GcFiltroTramoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg163GcFiltroTramoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getGcFiltrosTramoListActive []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-gc-filtro-tramo")
	public ResponseEntity<List<Tbasg163GcFiltroTramoDto>> getGcFiltroTramo(String cdgoFiltroTramo) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg163GcFiltroTramoDto> tbasg163GcFiltroTramoDto = tbasg163GcFiltroTramoService
					.getGcFiltroTramo(cdgoFiltroTramo);

			if (tbasg163GcFiltroTramoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg163GcFiltroTramoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getGcFiltroTramo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-gc-filtro-tramo")
	public ResponseEntity<?> insertGcFiltroTramo(Tbasg163GcFiltroTramo bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg163GcFiltroTramoDto = tbasg163GcFiltroTramoService.insertGcFiltroTramo(bean);
			return new ResponseEntity<>(tbasg163GcFiltroTramoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertGcFiltroTramo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-gc-filtros-tramo")
	public ResponseEntity<?> deleteGcFiltrosTramo(Tbasg163GcFiltroTramo bean) {
		// Generated from a DELETE found in an XML
		try {
			int tbasg163GcFiltroTramoDto = tbasg163GcFiltroTramoService.deleteGcFiltrosTramo(bean);
			return new ResponseEntity<>(tbasg163GcFiltroTramoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteGcFiltrosTramo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
