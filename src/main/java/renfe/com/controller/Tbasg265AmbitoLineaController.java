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

import renfe.com.model.dto.Tbasg265AmbitoLineaDto;
import renfe.com.model.entity.Tbasg265AmbitoLinea;
import renfe.com.service.Tbasg265AmbitoLineaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg265AmbitoLinea")
public class Tbasg265AmbitoLineaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg265AmbitoLineaService tbasg265AmbitoLineaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg265AmbitoLineaDto>> getAllTbasg265AmbitoLinea(Tbasg265AmbitoLineaDto filter) {
		return new ResponseEntity<>(tbasg265AmbitoLineaService.getAllTbasg265AmbitoLinea(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoLinea}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoLinea") String cdgoLinea) {
		Tbasg265AmbitoLineaDto tbasg265AmbitoLineaData = tbasg265AmbitoLineaService.findByCdgoLinea(cdgoLinea);

		if (tbasg265AmbitoLineaData != null) {
			return new ResponseEntity<>(tbasg265AmbitoLineaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg265AmbitoLineaDto> createTbasg265AmbitoLinea(
			@RequestBody Tbasg265AmbitoLineaDto tbasg265AmbitoLineaDto) {
		try {
			return new ResponseEntity<>(tbasg265AmbitoLineaService.createTbasg265AmbitoLinea(tbasg265AmbitoLineaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg265AmbitoLinea {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoLinea}")
	public ResponseEntity<Tbasg265AmbitoLineaDto> updateTbasg265AmbitoLinea(@PathVariable("cdgoLinea") String cdgoLinea,
			@RequestBody Tbasg265AmbitoLineaDto tbasg265AmbitoLineaDto) {
		try {
			Tbasg265AmbitoLineaDto tbasg265AmbitoLineaData = tbasg265AmbitoLineaService
					.updateTbasg265AmbitoLinea(cdgoLinea, tbasg265AmbitoLineaDto);
			if (tbasg265AmbitoLineaData != null) {
				return new ResponseEntity<>(tbasg265AmbitoLineaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg265AmbitoLinea []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoLinea}")
	public ResponseEntity<HttpStatus> deleteTbasg265AmbitoLinea(@PathVariable("cdgoLinea") String cdgoLinea) {
		try {
			tbasg265AmbitoLineaService.deleteTbasg265AmbitoLinea(cdgoLinea);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg265AmbitoLinea []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg265AmbitoLineaDto>> findByCdgoLineaIn(List<String> cdgoLinea) {
		try {
			List<Tbasg265AmbitoLineaDto> tbasg265AmbitoLineaDto = tbasg265AmbitoLineaService
					.findByCdgoLineaIn(cdgoLinea);

			if (tbasg265AmbitoLineaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg265AmbitoLineaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoLineaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-lista-ambito-lineas-activ")
	public ResponseEntity<List<Tbasg265AmbitoLineaDto>> getListaAmbitoLineasActiv() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg265AmbitoLineaDto> tbasg265AmbitoLineaDto = tbasg265AmbitoLineaService
					.getListaAmbitoLineasActiv();

			if (tbasg265AmbitoLineaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg265AmbitoLineaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getListaAmbitoLineasActiv []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-desc-tipo-ambito-lineas")
	public ResponseEntity<?> getDescTipoAmbitoLineas(String cdgoLinea) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg265AmbitoLineaDto> tbasg265AmbitoLineaDto = tbasg265AmbitoLineaService
					.getDescTipoAmbitoLineas(cdgoLinea);

			if (tbasg265AmbitoLineaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg265AmbitoLineaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDescTipoAmbitoLineas []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambito-linea-count")
	public ResponseEntity<?> getAmbitoLineaCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg265AmbitoLineaDto> tbasg265AmbitoLineaDto = tbasg265AmbitoLineaService.getAmbitoLineaCount();

			if (tbasg265AmbitoLineaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg265AmbitoLineaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitoLineaCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-max-ambito-linea")
	public ResponseEntity<?> getMaxAmbitoLinea() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg265AmbitoLineaDto> tbasg265AmbitoLineaDto = tbasg265AmbitoLineaService.getMaxAmbitoLinea();

			if (tbasg265AmbitoLineaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg265AmbitoLineaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getMaxAmbitoLinea []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambito-linea-list-ascendente")
	public ResponseEntity<List<Tbasg265AmbitoLineaDto>> getAmbitoLineaListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg265AmbitoLineaDto> tbasg265AmbitoLineaDto = tbasg265AmbitoLineaService
					.getAmbitoLineaListAscendente();

			if (tbasg265AmbitoLineaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg265AmbitoLineaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitoLineaListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-cdgo-linea-auto-inc")
	public ResponseEntity<List<Tbasg265AmbitoLineaDto>> getCdgoLineaAutoInc() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg265AmbitoLineaDto> tbasg265AmbitoLineaDto = tbasg265AmbitoLineaService
					.getCdgoLineaAutoInc();

			if (tbasg265AmbitoLineaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg265AmbitoLineaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCdgoLineaAutoInc []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambito-linea-list-descendente")
	public ResponseEntity<List<Tbasg265AmbitoLineaDto>> getAmbitoLineaListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg265AmbitoLineaDto> tbasg265AmbitoLineaDto = tbasg265AmbitoLineaService
					.getAmbitoLineaListDescendente();

			if (tbasg265AmbitoLineaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg265AmbitoLineaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitoLineaListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambito-linea")
	public ResponseEntity<List<Tbasg265AmbitoLineaDto>> getAmbitoLinea(String cdgoLinea) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg265AmbitoLineaDto> tbasg265AmbitoLineaDto = tbasg265AmbitoLineaService.getAmbitoLinea(cdgoLinea);

			if (tbasg265AmbitoLineaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg265AmbitoLineaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitoLinea []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambito-linea-by-nombre")
	public ResponseEntity<?> getAmbitoLineaByNombre(String desgLinea) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg265AmbitoLineaDto> tbasg265AmbitoLineaDto = tbasg265AmbitoLineaService
					.getAmbitoLineaByNombre(desgLinea);

			if (tbasg265AmbitoLineaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg265AmbitoLineaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitoLineaByNombre []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambito-linea-list-active")
	public ResponseEntity<List<Tbasg265AmbitoLineaDto>> getAmbitoLineaListActive() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg265AmbitoLineaDto> tbasg265AmbitoLineaDto = tbasg265AmbitoLineaService.getAmbitoLineaListActive();

			if (tbasg265AmbitoLineaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg265AmbitoLineaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitoLineaListActive []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-ambito-linea")
	public ResponseEntity<?> insertAmbitoLinea(@RequestBody Tbasg265AmbitoLinea bean) {
		// Generated from a INSERT found in an XML
		
		int cdgoLineaAux;
		String cdgoLinea;
		
		List<Tbasg265AmbitoLineaDto> valor = tbasg265AmbitoLineaService.getCdgoLineaAutoInc();
		
		cdgoLinea = valor.get(0).getCdgoLinea();		
		cdgoLineaAux = Integer.valueOf(cdgoLinea) + 1;	
		cdgoLinea = String.valueOf(cdgoLineaAux);
		
		if(cdgoLineaAux <= 9) {
			cdgoLinea = "0" + cdgoLinea;
		}
		
		bean.setCdgoLinea(cdgoLinea);
		
		
		try {
			int tbasg265AmbitoLineaDto = tbasg265AmbitoLineaService.insertAmbitoLinea(bean);
			return new ResponseEntity<>(tbasg265AmbitoLineaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertAmbitoLinea []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-ambito-linea")
	public ResponseEntity<?> updateAmbitoLinea(@RequestBody Tbasg265AmbitoLinea bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg265AmbitoLineaDto = tbasg265AmbitoLineaService.updateAmbitoLinea(bean);
			return new ResponseEntity<>(tbasg265AmbitoLineaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateAmbitoLinea []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-ambito-linea")
	public ResponseEntity<?> estadoAmbitoLinea(@RequestBody Tbasg265AmbitoLinea bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg265AmbitoLineaDto = tbasg265AmbitoLineaService.estadoAmbitoLinea(bean);
			return new ResponseEntity<>(tbasg265AmbitoLineaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoAmbitoLinea []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
