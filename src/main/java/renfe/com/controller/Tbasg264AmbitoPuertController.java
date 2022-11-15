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

import renfe.com.model.dto.Tbasg264AmbitoPuertDto;
import renfe.com.model.dto.Tbasg265AmbitoLineaDto;
import renfe.com.model.entity.Tbasg264AmbitoPuert;
import renfe.com.service.Tbasg264AmbitoPuertService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg264AmbitoPuert")
public class Tbasg264AmbitoPuertController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg264AmbitoPuertService tbasg264AmbitoPuertService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg264AmbitoPuertDto>> getAllTbasg264AmbitoPuert(Tbasg264AmbitoPuertDto filter) {
		return new ResponseEntity<>(tbasg264AmbitoPuertService.getAllTbasg264AmbitoPuert(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoPuerto}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoPuerto") String cdgoPuerto) {
		Tbasg264AmbitoPuertDto tbasg264AmbitoPuertData = tbasg264AmbitoPuertService.findByCdgoPuerto(cdgoPuerto);

		if (tbasg264AmbitoPuertData != null) {
			return new ResponseEntity<>(tbasg264AmbitoPuertData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg264AmbitoPuertDto> createTbasg264AmbitoPuert(
			@RequestBody Tbasg264AmbitoPuertDto tbasg264AmbitoPuertDto) {
		try {
			return new ResponseEntity<>(tbasg264AmbitoPuertService.createTbasg264AmbitoPuert(tbasg264AmbitoPuertDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg264AmbitoPuert {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoPuerto}")
	public ResponseEntity<Tbasg264AmbitoPuertDto> updateTbasg264AmbitoPuert(
			@PathVariable("cdgoPuerto") String cdgoPuerto, @RequestBody Tbasg264AmbitoPuertDto tbasg264AmbitoPuertDto) {
		try {
			Tbasg264AmbitoPuertDto tbasg264AmbitoPuertData = tbasg264AmbitoPuertService
					.updateTbasg264AmbitoPuert(cdgoPuerto, tbasg264AmbitoPuertDto);
			if (tbasg264AmbitoPuertData != null) {
				return new ResponseEntity<>(tbasg264AmbitoPuertData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg264AmbitoPuert []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoPuerto}")
	public ResponseEntity<HttpStatus> deleteTbasg264AmbitoPuert(@PathVariable("cdgoPuerto") String cdgoPuerto) {
		try {
			tbasg264AmbitoPuertService.deleteTbasg264AmbitoPuert(cdgoPuerto);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg264AmbitoPuert []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg264AmbitoPuertDto>> findByCdgoPuertoIn(List<String> cdgoPuerto) {
		try {
			List<Tbasg264AmbitoPuertDto> tbasg264AmbitoPuertDto = tbasg264AmbitoPuertService
					.findByCdgoPuertoIn(cdgoPuerto);

			if (tbasg264AmbitoPuertDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg264AmbitoPuertDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoPuertoIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-lista-ambito-puertos-activ")
	public ResponseEntity<List<Tbasg264AmbitoPuertDto>> getListaAmbitoPuertosActiv() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg264AmbitoPuertDto> tbasg264AmbitoPuertDto = tbasg264AmbitoPuertService
					.getListaAmbitoPuertosActiv();

			if (tbasg264AmbitoPuertDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg264AmbitoPuertDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getListaAmbitoPuertosActiv []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-desc-tipo-ambito-puertos")
	public ResponseEntity<?> getDescTipoAmbitoPuertos(String cdgoPuerto) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg264AmbitoPuertDto> tbasg264AmbitoPuertDto = tbasg264AmbitoPuertService
					.getDescTipoAmbitoPuertos(cdgoPuerto);

			if (tbasg264AmbitoPuertDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg264AmbitoPuertDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDescTipoAmbitoPuertos []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambito-puerto-count")
	public ResponseEntity<?> getAmbitoPuertoCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg264AmbitoPuertDto> tbasg264AmbitoPuertDto = tbasg264AmbitoPuertService.getAmbitoPuertoCount();

			if (tbasg264AmbitoPuertDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg264AmbitoPuertDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitoPuertoCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-max-ambito-puerto")
	public ResponseEntity<?> getMaxAmbitoPuerto() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg264AmbitoPuertDto> tbasg264AmbitoPuertDto = tbasg264AmbitoPuertService.getMaxAmbitoPuerto();

			if (tbasg264AmbitoPuertDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg264AmbitoPuertDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getMaxAmbitoPuerto []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambito-puerto-list-ascendente")
	public ResponseEntity<List<Tbasg264AmbitoPuertDto>> getAmbitoPuertoListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg264AmbitoPuertDto> tbasg264AmbitoPuertDto = tbasg264AmbitoPuertService
					.getAmbitoPuertoListAscendente();

			if (tbasg264AmbitoPuertDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg264AmbitoPuertDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitoPuertoListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambito-puerto-list-descendente")
	public ResponseEntity<List<Tbasg264AmbitoPuertDto>> getAmbitoPuertoListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg264AmbitoPuertDto> tbasg264AmbitoPuertDto = tbasg264AmbitoPuertService
					.getAmbitoPuertoListDescendente();

			if (tbasg264AmbitoPuertDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg264AmbitoPuertDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitoPuertoListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambito-puerto")
	public ResponseEntity<List<Tbasg264AmbitoPuertDto>> getAmbitoPuerto(String cdgoPuerto) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg264AmbitoPuertDto> tbasg264AmbitoPuertDto = tbasg264AmbitoPuertService
					.getAmbitoPuerto(cdgoPuerto);

			if (tbasg264AmbitoPuertDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg264AmbitoPuertDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitoPuerto []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambito-puerto-by-nombre")
	public ResponseEntity<?> getAmbitoPuertoByNombre(String desgPuerto) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg264AmbitoPuertDto> tbasg264AmbitoPuertDto = tbasg264AmbitoPuertService
					.getAmbitoPuertoByNombre(desgPuerto);

			if (tbasg264AmbitoPuertDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg264AmbitoPuertDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitoPuertoByNombre []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambito-puerto-list-active")
	public ResponseEntity<List<Tbasg264AmbitoPuertDto>> getAmbitoPuertoListActive() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg264AmbitoPuertDto> tbasg264AmbitoPuertDto = tbasg264AmbitoPuertService
					.getAmbitoPuertoListActive();

			if (tbasg264AmbitoPuertDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg264AmbitoPuertDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitoPuertoListActive []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-ambito-puerto")
	public ResponseEntity<?> insertAmbitoPuerto(@RequestBody Tbasg264AmbitoPuert bean) {
		// Generated from a INSERT found in an XML
		
		int cdgoPuertoAux;
		String cdgoPuerto;
		
		List<Tbasg264AmbitoPuertDto> valor = tbasg264AmbitoPuertService.getCdgoPuertAutoInc();
		
		cdgoPuerto = valor.get(0).getCdgoPuerto();		
		cdgoPuertoAux = Integer.valueOf(cdgoPuerto) + 1;	
		cdgoPuerto = String.valueOf(cdgoPuertoAux);
		
		if(cdgoPuertoAux <= 9) {
			cdgoPuerto = "0" + cdgoPuerto;
		}
		
		bean.setCdgoPuerto(cdgoPuerto);
		
		try {
			int tbasg264AmbitoPuertDto = tbasg264AmbitoPuertService.insertAmbitoPuerto(bean);
			return new ResponseEntity<>(tbasg264AmbitoPuertDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertAmbitoPuerto []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-ambito-puerto")
	public ResponseEntity<?> updateAmbitoPuerto(@RequestBody Tbasg264AmbitoPuert bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg264AmbitoPuertDto = tbasg264AmbitoPuertService.updateAmbitoPuerto(bean);
			return new ResponseEntity<>(tbasg264AmbitoPuertDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateAmbitoPuerto []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-ambito-puerto")
	public ResponseEntity<?> estadoAmbitoPuerto(@RequestBody Tbasg264AmbitoPuert bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg264AmbitoPuertDto = tbasg264AmbitoPuertService.estadoAmbitoPuerto(bean);
			return new ResponseEntity<>(tbasg264AmbitoPuertDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoAmbitoPuerto []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
