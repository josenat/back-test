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

import renfe.com.model.dto.Tbasg155FcCategoriaDto;
import renfe.com.model.entity.Tbasg155FcCategoria;
import renfe.com.service.Tbasg155FcCategoriaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg155FcCategoria")
public class Tbasg155FcCategoriaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg155FcCategoriaService tbasg155FcCategoriaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg155FcCategoriaDto>> getAllTbasg155FcCategoria(Tbasg155FcCategoriaDto filter) {
		return new ResponseEntity<>(tbasg155FcCategoriaService.getAllTbasg155FcCategoria(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoCategoria}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoCategoria") Integer cdgoCategoria) {
		Tbasg155FcCategoriaDto tbasg155FcCategoriaData = tbasg155FcCategoriaService.findByCdgoCategoria(cdgoCategoria);

		if (tbasg155FcCategoriaData != null) {
			return new ResponseEntity<>(tbasg155FcCategoriaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg155FcCategoriaDto> createTbasg155FcCategoria(
			@RequestBody Tbasg155FcCategoriaDto tbasg155FcCategoriaDto) {
		try {
			return new ResponseEntity<>(tbasg155FcCategoriaService.createTbasg155FcCategoria(tbasg155FcCategoriaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg155FcCategoria {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoCategoria}")
	public ResponseEntity<Tbasg155FcCategoriaDto> updateTbasg155FcCategoria(@PathVariable("cdgoCategoria") Integer cdgo,
			@RequestBody Tbasg155FcCategoriaDto body) {
		try {
			Tbasg155FcCategoriaDto tbasg155FcCategoriaData = tbasg155FcCategoriaService.updateTbasg155FcCategoria(cdgo,
					body);
			if (tbasg155FcCategoriaData != null) {
				return new ResponseEntity<>(tbasg155FcCategoriaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg155FcCategoria []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoCategoria}")
	public ResponseEntity<HttpStatus> deleteTbasg155FcCategoria(@PathVariable("cdgoCategoria") Integer cdgoCategoria) {
		try {
			tbasg155FcCategoriaService.deleteTbasg155FcCategoria(cdgoCategoria);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg155FcCategoria []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg155FcCategoriaDto>> findByCdgoCategoriaIn(List<Integer> cdgoCategoria) {
		try {
			List<Tbasg155FcCategoriaDto> tbasg155FcCategoriaDto = tbasg155FcCategoriaService
					.findByCdgoCategoriaIn(cdgoCategoria);

			if (tbasg155FcCategoriaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg155FcCategoriaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoCategoriaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fc-categoria-count")
	public ResponseEntity<?> getFcCategoriaCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg155FcCategoriaDto> tbasg155FcCategoriaDto = tbasg155FcCategoriaService.getFcCategoriaCount();

			if (tbasg155FcCategoriaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg155FcCategoriaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFcCategoriaCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fc-categoria-list-ascendente")
	public ResponseEntity<List<Tbasg155FcCategoriaDto>> getFcCategoriaListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg155FcCategoriaDto> tbasg155FcCategoriaDto = tbasg155FcCategoriaService
					.getFcCategoriaListAscendente();

			if (tbasg155FcCategoriaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg155FcCategoriaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFcCategoriaListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fc-categoria-list-descendente")
	public ResponseEntity<List<Tbasg155FcCategoriaDto>> getFcCategoriaListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg155FcCategoriaDto> tbasg155FcCategoriaDto = tbasg155FcCategoriaService
					.getFcCategoriaListDescendente();

			if (tbasg155FcCategoriaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg155FcCategoriaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFcCategoriaListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fc-categoria")
	public ResponseEntity<List<Tbasg155FcCategoriaDto>> getFcCategoria(String cdgoCategoria) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg155FcCategoriaDto> tbasg155FcCategoriaDto = tbasg155FcCategoriaService
					.getFcCategoria(cdgoCategoria);

			if (tbasg155FcCategoriaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg155FcCategoriaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFcCategoria []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fc-categoria-by-nombre")
	public ResponseEntity<?> getFcCategoriaByNombre(String desgDescripcion) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg155FcCategoriaDto> tbasg155FcCategoriaDto = tbasg155FcCategoriaService
					.getFcCategoriaByNombre(desgDescripcion);

			if (tbasg155FcCategoriaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg155FcCategoriaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFcCategoriaByNombre []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fc-categoria-list-active")
	public ResponseEntity<List<Tbasg155FcCategoriaDto>> getFcCategoriaListActive() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg155FcCategoriaDto> tbasg155FcCategoriaDto = tbasg155FcCategoriaService.getFcCategoriaListActive();

			if (tbasg155FcCategoriaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg155FcCategoriaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFcCategoriaListActive []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fc-categoria-idioma-list")
	public ResponseEntity<List<Tbasg155FcCategoriaDto>> getFcCategoriaIdiomaList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg155FcCategoriaDto> tbasg155FcCategoriaDto = tbasg155FcCategoriaService.getFcCategoriaIdiomaList();

			if (tbasg155FcCategoriaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg155FcCategoriaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFcCategoriaIdiomaList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fc-categoria-by-nombre2")
	public ResponseEntity<List<Tbasg155FcCategoriaDto>> getFcCategoriaByNombre2(String desgDescripcion) {
		try {
			logger.debug("---> Descripcion {} ",desgDescripcion);

			List<Tbasg155FcCategoriaDto> tbasg155FcCategoriaDto = tbasg155FcCategoriaService.getFcCategoriaByNombre2(desgDescripcion);

			return new ResponseEntity<>(tbasg155FcCategoriaDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("getFcCategoriaByNombre2 []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-fc-categoria")
	public ResponseEntity<?> insertFcCategoria(@RequestBody Tbasg155FcCategoria bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg155FcCategoriaDto = tbasg155FcCategoriaService.insertFcCategoria(bean);
			return new ResponseEntity<>(tbasg155FcCategoriaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertFcCategoria []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-fc-categoria")
	public ResponseEntity<?> updateFcCategoria(@RequestBody Tbasg155FcCategoria bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg155FcCategoriaDto = tbasg155FcCategoriaService.updateFcCategoria(bean);
			return new ResponseEntity<>(tbasg155FcCategoriaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateFcCategoria []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-fc-categoria")
	public ResponseEntity<?> estadoFcCategoria(@RequestBody Tbasg155FcCategoria bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg155FcCategoriaDto = tbasg155FcCategoriaService.estadoFcCategoria(bean);
			return new ResponseEntity<>(tbasg155FcCategoriaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoFcCategoria []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
