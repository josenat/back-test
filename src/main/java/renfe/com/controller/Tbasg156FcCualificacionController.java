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

import renfe.com.dto.GetFcCualificacionListAscCdgoCategoriaDTO;
import renfe.com.model.dto.Tbasg156FcCualificacionDto;
import renfe.com.model.entity.Tbasg156FcCualificacion;
import renfe.com.service.Tbasg156FcCualificacionService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg156FcCualificacion")
public class Tbasg156FcCualificacionController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg156FcCualificacionService tbasg156FcCualificacionService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg156FcCualificacionDto>> getAllTbasg156FcCualificacion(
			Tbasg156FcCualificacionDto filter) {
		return new ResponseEntity<>(tbasg156FcCualificacionService.getAllTbasg156FcCualificacion(filter),
				HttpStatus.OK);
	}

	@GetMapping("/{cdgoCualificacion}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoCualificacion") Integer cdgoCualificacion) {
		Tbasg156FcCualificacionDto tbasg156FcCualificacionData = tbasg156FcCualificacionService
				.findByCdgoCualificacion(cdgoCualificacion);

		if (tbasg156FcCualificacionData != null) {
			return new ResponseEntity<>(tbasg156FcCualificacionData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg156FcCualificacionDto> createTbasg156FcCualificacion(
			@RequestBody Tbasg156FcCualificacionDto tbasg156FcCualificacionDto) {
		try {
			return new ResponseEntity<>(
					tbasg156FcCualificacionService.createTbasg156FcCualificacion(tbasg156FcCualificacionDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg156FcCualificacion {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoCualificacion}")
	public ResponseEntity<Tbasg156FcCualificacionDto> updateTbasg156FcCualificacion(
			@PathVariable("cdgoCualificacion") Integer cdgo, @RequestBody Tbasg156FcCualificacionDto body) {
		try {
			Tbasg156FcCualificacionDto tbasg156FcCualificacionData = tbasg156FcCualificacionService
					.updateTbasg156FcCualificacion(cdgo, body);
			if (tbasg156FcCualificacionData != null) {
				return new ResponseEntity<>(tbasg156FcCualificacionData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg156FcCualificacion []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoCualificacion}")
	public ResponseEntity<HttpStatus> deleteTbasg156FcCualificacion(
			@PathVariable("cdgoCualificacion") Integer cdgoCualificacion) {
		try {
			tbasg156FcCualificacionService.deleteTbasg156FcCualificacion(cdgoCualificacion);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg156FcCualificacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg156FcCualificacionDto>> findByCdgoCualificacionIn(List<Integer> cdgoCualificacion) {
		try {
			List<Tbasg156FcCualificacionDto> tbasg156FcCualificacionDto = tbasg156FcCualificacionService
					.findByCdgoCualificacionIn(cdgoCualificacion);

			if (tbasg156FcCualificacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg156FcCualificacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoCualificacionIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fc-cualificacion")
	public ResponseEntity<List<Tbasg156FcCualificacionDto>> getFcCualificacion(String cdgoCategoria,
			String cdgoCualificacion) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg156FcCualificacionDto> tbasg156FcCualificacionDto = tbasg156FcCualificacionService
					.getFcCualificacion(cdgoCategoria, cdgoCualificacion);

			if (tbasg156FcCualificacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg156FcCualificacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFcCualificacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fc-cualificacion-view")
	public ResponseEntity<List<Tbasg156FcCualificacionDto>> getFcCualificacionView(String cdgoCategoria,
			String cdgoCualificacion) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg156FcCualificacionDto> tbasg156FcCualificacionDto = tbasg156FcCualificacionService
					.getFcCualificacionView(cdgoCategoria, cdgoCualificacion);

			if (tbasg156FcCualificacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg156FcCualificacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFcCualificacionView []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fc-cualificacion-list-ascendente")
	public ResponseEntity<List<Tbasg156FcCualificacionDto>> getFcCualificacionListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg156FcCualificacionDto> tbasg156FcCualificacionDto = tbasg156FcCualificacionService
					.getFcCualificacionListAscendente();

			if (tbasg156FcCualificacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg156FcCualificacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFcCualificacionListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-fc-cualificacion-list-asc-cdgo-categoria")
	public ResponseEntity<List<GetFcCualificacionListAscCdgoCategoriaDTO>> getFcCualificacionListAscCdgoCategoria(Integer cdgoCategoria) {
		// Generated from a SELECT found in an XML
		try {
			List<GetFcCualificacionListAscCdgoCategoriaDTO> tbasg156FcCualificacionDto = tbasg156FcCualificacionService
					.getFcCualificacionListAscCdgoCategoria(cdgoCategoria);

			if (tbasg156FcCualificacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg156FcCualificacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFcCualificacionListAscCdgoCategoria []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fc-cualificacion-list-descendente")
	public ResponseEntity<List<Tbasg156FcCualificacionDto>> getFcCualificacionListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg156FcCualificacionDto> tbasg156FcCualificacionDto = tbasg156FcCualificacionService
					.getFcCualificacionListDescendente();

			if (tbasg156FcCualificacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg156FcCualificacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFcCualificacionListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fc-cualificacion-list-ascendente-view")
	public ResponseEntity<List<Tbasg156FcCualificacionDto>> getFcCualificacionListAscendenteView(String cdgoCategoria) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg156FcCualificacionDto> tbasg156FcCualificacionDto = tbasg156FcCualificacionService
					.getFcCualificacionListAscendenteView(cdgoCategoria);

			if (tbasg156FcCualificacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg156FcCualificacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFcCualificacionListAscendenteView []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fc-cualificacion-list-descendente-view")
	public ResponseEntity<List<Tbasg156FcCualificacionDto>> getFcCualificacionListDescendenteView(
			String cdgoCategoria) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg156FcCualificacionDto> tbasg156FcCualificacionDto = tbasg156FcCualificacionService
					.getFcCualificacionListDescendenteView(cdgoCategoria);

			if (tbasg156FcCualificacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg156FcCualificacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFcCualificacionListDescendenteView []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fc-cualificacion-count")
	public ResponseEntity<?> getFcCualificacionCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg156FcCualificacionDto> tbasg156FcCualificacionDto = tbasg156FcCualificacionService
					.getFcCualificacionCount();

			if (tbasg156FcCualificacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg156FcCualificacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFcCualificacionCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fc-cualificacion-view-count")
	public ResponseEntity<?> getFcCualificacionViewCount(String cdgoCategoria) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg156FcCualificacionDto> tbasg156FcCualificacionDto = tbasg156FcCualificacionService
					.getFcCualificacionViewCount(cdgoCategoria);

			if (tbasg156FcCualificacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg156FcCualificacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFcCualificacionViewCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fc-cualificacion-list-active")
	public ResponseEntity<List<Tbasg156FcCualificacionDto>> getFcCualificacionListActive() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg156FcCualificacionDto> tbasg156FcCualificacionDto = tbasg156FcCualificacionService
					.getFcCualificacionListActive();

			if (tbasg156FcCualificacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg156FcCualificacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFcCualificacionListActive []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fc-cualificacion-list-order-by-categoria")
	public ResponseEntity<List<Tbasg156FcCualificacionDto>> getFcCualificacionListOrderByCategoria() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg156FcCualificacionDto> tbasg156FcCualificacionDto = tbasg156FcCualificacionService
					.getFcCualificacionListOrderByCategoria();

			if (tbasg156FcCualificacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg156FcCualificacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFcCualificacionListOrderByCategoria []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cuali-for-name")
	public ResponseEntity<List<Tbasg156FcCualificacionDto>> getCualiForName(String desgDescripcion) {
		try {
			List<Tbasg156FcCualificacionDto> tbasg156FcCualificacionDto = tbasg156FcCualificacionService.getCualiForName(desgDescripcion);

			return new ResponseEntity<>(tbasg156FcCualificacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCualiForName []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-fc-cualificacion")
	public ResponseEntity<?> insertFcCualificacion(@RequestBody Tbasg156FcCualificacion bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg156FcCualificacionDto = tbasg156FcCualificacionService.insertFcCualificacion(bean);
			return new ResponseEntity<>(tbasg156FcCualificacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertFcCualificacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-fc-cualificacion")
	public ResponseEntity<?> updateFcCualificacion(@RequestBody Tbasg156FcCualificacion bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg156FcCualificacionDto = tbasg156FcCualificacionService.updateFcCualificacion(bean);
			return new ResponseEntity<>(tbasg156FcCualificacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateFcCualificacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-fc-cualificacion")
	public ResponseEntity<?> estadoFcCualificacion(@RequestBody Tbasg156FcCualificacion bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg156FcCualificacionDto = tbasg156FcCualificacionService.estadoFcCualificacion(bean);
			return new ResponseEntity<>(tbasg156FcCualificacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoFcCualificacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-fc-cualificacion")
	public ResponseEntity<?> deleteFcCualificacion(Tbasg156FcCualificacion bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg156FcCualificacionDto = tbasg156FcCualificacionService.deleteFcCualificacion(bean);
			return new ResponseEntity<>(tbasg156FcCualificacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteFcCualificacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/reactive-fc-cualificacion")
	public ResponseEntity<?> reactiveFcCualificacion(Tbasg156FcCualificacion bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg156FcCualificacionDto = tbasg156FcCualificacionService.reactiveFcCualificacion(bean);
			return new ResponseEntity<>(tbasg156FcCualificacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("reactiveFcCualificacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
