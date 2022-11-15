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

import renfe.com.dto.GetAmbitosListAscendenteDTO;
import renfe.com.model.dto.Tbasg124AmbitosDto;
import renfe.com.model.entity.Tbasg124Ambitos;
import renfe.com.service.Tbasg124AmbitosService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg124Ambitos")
public class Tbasg124AmbitosController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg124AmbitosService tbasg124AmbitosService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg124AmbitosDto>> getAllTbasg124Ambitos(Tbasg124AmbitosDto filter) {
		return new ResponseEntity<>(tbasg124AmbitosService.getAllTbasg124Ambitos(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoAmbitos}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoAmbitos") Integer cdgoAmbitos) {
		Tbasg124AmbitosDto tbasg124AmbitosData = tbasg124AmbitosService.findByCdgoAmbitos(cdgoAmbitos);

		if (tbasg124AmbitosData != null) {
			return new ResponseEntity<>(tbasg124AmbitosData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg124AmbitosDto> createTbasg124Ambitos(
			@RequestBody Tbasg124AmbitosDto tbasg124AmbitosDto) {
		try {
			return new ResponseEntity<>(tbasg124AmbitosService.createTbasg124Ambitos(tbasg124AmbitosDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg124Ambitos {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoAmbitos}")
	public ResponseEntity<Tbasg124AmbitosDto> updateTbasg124Ambitos(@PathVariable("cdgoAmbitos") Integer cdgo,
			@RequestBody Tbasg124AmbitosDto body) {
		try {
			Tbasg124AmbitosDto tbasg124AmbitosData = tbasg124AmbitosService.updateTbasg124Ambitos(cdgo, body);
			if (tbasg124AmbitosData != null) {
				return new ResponseEntity<>(tbasg124AmbitosData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg124Ambitos []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoAmbitos}")
	public ResponseEntity<HttpStatus> deleteTbasg124Ambitos(@PathVariable("cdgoAmbitos") Integer cdgoAmbitos) {
		try {
			tbasg124AmbitosService.deleteTbasg124Ambitos(cdgoAmbitos);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg124Ambitos []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg124AmbitosDto>> findByCdgoAmbitosIn(List<Integer> cdgoAmbitos) {
		try {
			List<Tbasg124AmbitosDto> tbasg124AmbitosDto = tbasg124AmbitosService.findByCdgoAmbitosIn(cdgoAmbitos);

			if (tbasg124AmbitosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg124AmbitosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoAmbitosIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambitos-count")
	public ResponseEntity<?> getAmbitosCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg124AmbitosDto> tbasg124AmbitosDto = tbasg124AmbitosService.getAmbitosCount();

			if (tbasg124AmbitosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg124AmbitosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitosCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambitos-list-ascendente")
	public ResponseEntity<List<GetAmbitosListAscendenteDTO>> getAmbitosListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<GetAmbitosListAscendenteDTO> tbasg124AmbitosDto = tbasg124AmbitosService.getAmbitosListAscendente();

			if (tbasg124AmbitosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg124AmbitosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitosListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambitos-list-descendente")
	public ResponseEntity<List<Tbasg124AmbitosDto>> getAmbitosListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg124AmbitosDto> tbasg124AmbitosDto = tbasg124AmbitosService.getAmbitosListDescendente();

			if (tbasg124AmbitosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg124AmbitosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitosListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambitos-tipo-hab-list-ascendente")
	public ResponseEntity<List<GetAmbitosListAscendenteDTO>> getAmbitosTipoHabListAscendente(Integer cdgoTipohab) {
		// Generated from a SELECT found in an XML
		try {
			List<GetAmbitosListAscendenteDTO> tbasg124AmbitosDto = tbasg124AmbitosService
					.getAmbitosTipoHabListAscendente(cdgoTipohab);

			if (tbasg124AmbitosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg124AmbitosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitosTipoHabListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambitos-tipo-hab-list-descendente")
	public ResponseEntity<List<Tbasg124AmbitosDto>> getAmbitosTipoHabListDescendente(String cdgoTipohab) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg124AmbitosDto> tbasg124AmbitosDto = tbasg124AmbitosService
					.getAmbitosTipoHabListDescendente(cdgoTipohab);

			if (tbasg124AmbitosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg124AmbitosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitosTipoHabListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambitos-tipo-hab-count")
	public ResponseEntity<?> getAmbitosTipoHabCount(String cdgoTipohab) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg124AmbitosDto> tbasg124AmbitosDto = tbasg124AmbitosService.getAmbitosTipoHabCount(cdgoTipohab);

			if (tbasg124AmbitosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg124AmbitosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitosTipoHabCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambitos-active-list")
	public ResponseEntity<List<Tbasg124AmbitosDto>> getAmbitosActiveList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg124AmbitosDto> tbasg124AmbitosDto = tbasg124AmbitosService.getAmbitosActiveList();

			if (tbasg124AmbitosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg124AmbitosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitosActiveList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambitos-active-list2")
	public ResponseEntity<List<Tbasg124AmbitosDto>> getAmbitosActiveList2() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg124AmbitosDto> tbasg124AmbitosDto = tbasg124AmbitosService.getAmbitosActiveList2();

			if (tbasg124AmbitosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg124AmbitosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitosActiveList2 []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambitos")
	public ResponseEntity<List<Tbasg124AmbitosDto>> getAmbitos(String cdgoAmbitos) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg124AmbitosDto> tbasg124AmbitosDto = tbasg124AmbitosService.getAmbitos(cdgoAmbitos);

			if (tbasg124AmbitosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg124AmbitosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitos []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-alcance-ambitos")
	public ResponseEntity<List<Tbasg124AmbitosDto>> getAlcanceAmbito(Integer cdgoAmbitos) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg124AmbitosDto> tbasg124AmbitosDto = tbasg124AmbitosService.getAlcanceAmbito(cdgoAmbitos);

			if (tbasg124AmbitosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg124AmbitosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAlcanceAmbito []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambitos-view")
	public ResponseEntity<List<Tbasg124AmbitosDto>> getAmbitosView(String cdgoAmbitos) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg124AmbitosDto> tbasg124AmbitosDto = tbasg124AmbitosService.getAmbitosView(cdgoAmbitos);

			if (tbasg124AmbitosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg124AmbitosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitosView []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-ambitos-nombre")
	public ResponseEntity<List<Tbasg124AmbitosDto>> getAmbitosNombre(String desgNombre) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg124AmbitosDto> tbasg124AmbitosDto = tbasg124AmbitosService.getAmbitosNombre(desgNombre);

			if (tbasg124AmbitosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg124AmbitosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAmbitosNombre []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-ambitos")
	public ResponseEntity<?> insertAmbitos(@RequestBody Tbasg124Ambitos bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg124AmbitosDto = tbasg124AmbitosService.insertAmbitos(bean);
			return new ResponseEntity<>(tbasg124AmbitosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertAmbitos []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-ambitos")
	public ResponseEntity<?> updateAmbitos(@RequestBody Tbasg124Ambitos bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg124AmbitosDto = tbasg124AmbitosService.updateAmbitos(bean);
			return new ResponseEntity<>(tbasg124AmbitosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateAmbitos []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-ambitos")
	public ResponseEntity<?> estadoAmbitos(@RequestBody Tbasg124Ambitos bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg124AmbitosDto = tbasg124AmbitosService.estadoAmbitos(bean);
			return new ResponseEntity<>(tbasg124AmbitosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateAmbitos []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
