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

import renfe.com.dto.GetCentHgadoListAscendenteDTO;
import renfe.com.model.dto.Tbasg143CenthgadoDto;
import renfe.com.model.entity.Tbasg143Centhgado;
import renfe.com.service.Tbasg143CenthgadoService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg143Centhgado")
public class Tbasg143CenthgadoController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg143CenthgadoService tbasg143CenthgadoService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg143CenthgadoDto>> getAllTbasg143Centhgado(Tbasg143CenthgadoDto filter) {
		return new ResponseEntity<>(tbasg143CenthgadoService.getAllTbasg143Centhgado(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoCenthgado}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoCenthgado") Integer cdgoCenthgado) {
		Tbasg143CenthgadoDto tbasg143CenthgadoData = tbasg143CenthgadoService.findByCdgoCenthgado(cdgoCenthgado);

		if (tbasg143CenthgadoData != null) {
			return new ResponseEntity<>(tbasg143CenthgadoData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg143CenthgadoDto> createTbasg143Centhgado(
			@RequestBody Tbasg143CenthgadoDto tbasg143CenthgadoDto) {
		try {
			return new ResponseEntity<>(tbasg143CenthgadoService.createTbasg143Centhgado(tbasg143CenthgadoDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg143Centhgado {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoCenthgado}")
	public ResponseEntity<Tbasg143CenthgadoDto> updateTbasg143Centhgado(@PathVariable("cdgoCenthgado") Integer cdgo,
			@RequestBody Tbasg143CenthgadoDto body) {
		try {
			Tbasg143CenthgadoDto tbasg143CenthgadoData = tbasg143CenthgadoService.updateTbasg143Centhgado(cdgo, body);
			if (tbasg143CenthgadoData != null) {
				return new ResponseEntity<>(tbasg143CenthgadoData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg143Centhgado []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoCenthgado}")
	public ResponseEntity<HttpStatus> deleteTbasg143Centhgado(@PathVariable("cdgoCenthgado") Integer cdgoCenthgado) {
		try {
			tbasg143CenthgadoService.deleteTbasg143Centhgado(cdgoCenthgado);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg143Centhgado []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg143CenthgadoDto>> findByCdgoCenthgadoIn(List<Integer> cdgoCenthgado) {
		try {
			List<Tbasg143CenthgadoDto> tbasg143CenthgadoDto = tbasg143CenthgadoService
					.findByCdgoCenthgadoIn(cdgoCenthgado);

			if (tbasg143CenthgadoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg143CenthgadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoCenthgadoIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-hgado")
	public ResponseEntity<List<Tbasg143CenthgadoDto>> getCentHgado(String cdgoCenthgado) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg143CenthgadoDto> tbasg143CenthgadoDto = tbasg143CenthgadoService.getCentHgado(cdgoCenthgado);

			if (tbasg143CenthgadoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg143CenthgadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentHgado []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-active-cent-hgado")
	public ResponseEntity<List<Tbasg143CenthgadoDto>> getActiveCentHgado(String cdgoCenthgado) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg143CenthgadoDto> tbasg143CenthgadoDto = tbasg143CenthgadoService
					.getActiveCentHgado(cdgoCenthgado);

			if (tbasg143CenthgadoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg143CenthgadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActiveCentHgado []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-hgado-by-c-i-f")
	public ResponseEntity<List<Tbasg143CenthgadoDto>> getCentHgadoByCIF(String desgCif) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg143CenthgadoDto> tbasg143CenthgadoDto = tbasg143CenthgadoService.getCentHgadoByCIF(desgCif);

			if (tbasg143CenthgadoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg143CenthgadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentHgadoByCIF []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-hgado-count")
	public ResponseEntity<?> getCentHgadoCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg143CenthgadoDto> tbasg143CenthgadoDto = tbasg143CenthgadoService.getCentHgadoCount();

			if (tbasg143CenthgadoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg143CenthgadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentHgadoCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-by-cdgo-cent-for")
	public ResponseEntity<List<Tbasg143CenthgadoDto>> findByCdgoCentFor(String cdgoCentrofor) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg143CenthgadoDto> tbasg143CenthgadoDto = tbasg143CenthgadoService.findByCdgoCentFor(cdgoCentrofor);

			if (tbasg143CenthgadoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg143CenthgadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoCentFor []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-by-cdgo-cent-med")
	public ResponseEntity<List<Tbasg143CenthgadoDto>> findByCdgoCentMed(String cdgoCenmed) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg143CenthgadoDto> tbasg143CenthgadoDto = tbasg143CenthgadoService.findByCdgoCentMed(cdgoCenmed);

			if (tbasg143CenthgadoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg143CenthgadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoCentMed []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-hgado-list-ascendente")
	public ResponseEntity<List<GetCentHgadoListAscendenteDTO>> getCentHgadoListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<GetCentHgadoListAscendenteDTO> tbasg143CenthgadoDto = tbasg143CenthgadoService.getCentHgadoListAscendente();

			if (tbasg143CenthgadoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg143CenthgadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentHgadoListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-hgado-list-descendente")
	public ResponseEntity<List<Tbasg143CenthgadoDto>> getCentHgadoListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg143CenthgadoDto> tbasg143CenthgadoDto = tbasg143CenthgadoService.getCentHgadoListDescendente();

			if (tbasg143CenthgadoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg143CenthgadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentHgadoListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-hgado-active-list-ascendente")
	public ResponseEntity<List<Tbasg143CenthgadoDto>> getCentHgadoActiveListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg143CenthgadoDto> tbasg143CenthgadoDto = tbasg143CenthgadoService
					.getCentHgadoActiveListAscendente();

			if (tbasg143CenthgadoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg143CenthgadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentHgadoActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-cent-hgado")
	public ResponseEntity<?> insertCentHgado(@RequestBody Tbasg143Centhgado bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg143CenthgadoDto = tbasg143CenthgadoService.insertCentHgado(bean);
			return new ResponseEntity<>(tbasg143CenthgadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertCentHgado []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-cent-hgado")
	public ResponseEntity<?> updateCentHgado(@RequestBody Tbasg143Centhgado bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg143CenthgadoDto = tbasg143CenthgadoService.updateCentHgado(bean);
			return new ResponseEntity<>(tbasg143CenthgadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateCentHgado []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-cent-hgado")
	public ResponseEntity<?> estadoCentHgado(@RequestBody Tbasg143Centhgado bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg143CenthgadoDto = tbasg143CenthgadoService.estadoCentHgado(bean);
			return new ResponseEntity<>(tbasg143CenthgadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoCentHgado []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/reactivate-cent-hgado")
	public ResponseEntity<?> reactivateCentHgado(Tbasg143Centhgado bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg143CenthgadoDto = tbasg143CenthgadoService.reactivateCentHgado(bean);
			return new ResponseEntity<>(tbasg143CenthgadoDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("reactivateCentHgado []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
