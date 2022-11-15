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

import renfe.com.dto.GetEntorLineListAscendenteCDGO_ENTORNODTO;
import renfe.com.model.dto.Tbasg130EntorlineDto;
import renfe.com.model.entity.Tbasg130Entorline;
import renfe.com.service.Tbasg130EntorlineService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg130Entorline")
public class Tbasg130EntorlineController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg130EntorlineService tbasg130EntorlineService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg130EntorlineDto>> getAllTbasg130Entorline(Tbasg130EntorlineDto filter) {
		return new ResponseEntity<>(tbasg130EntorlineService.getAllTbasg130Entorline(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoDestino}/{cdgoEntorno}/{cdgoLinea}/{cdgoOrigen}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoDestino") String cdgoDestino,
			@PathVariable("cdgoEntorno") Integer cdgoEntorno, @PathVariable("cdgoLinea") String cdgoLinea,
			@PathVariable("cdgoOrigen") String cdgoOrigen) {
		Tbasg130EntorlineDto tbasg130EntorlineData = tbasg130EntorlineService
				.findByCdgoDestinoCdgoEntornoCdgoLineaCdgoOrigen(cdgoDestino, cdgoEntorno, cdgoLinea, cdgoOrigen);

		if (tbasg130EntorlineData != null) {
			return new ResponseEntity<>(tbasg130EntorlineData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg130EntorlineDto> createTbasg130Entorline(
			@RequestBody Tbasg130EntorlineDto tbasg130EntorlineDto) {
		try {
			return new ResponseEntity<>(tbasg130EntorlineService.createTbasg130Entorline(tbasg130EntorlineDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg130Entorline {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoDestino}/{cdgoEntorno}/{cdgoLinea}/{cdgoOrigen}")
	public ResponseEntity<Tbasg130EntorlineDto> updateTbasg130Entorline(@PathVariable("cdgoDestino") String cdgoDestino,
			@PathVariable("cdgoEntorno") Integer cdgoEntorno, @PathVariable("cdgoLinea") String cdgoLinea,
			@PathVariable("cdgoOrigen") String cdgoOrigen, @RequestBody Tbasg130EntorlineDto tbasg130EntorlineDto) {
		try {
			Tbasg130EntorlineDto tbasg130EntorlineData = tbasg130EntorlineService.updateTbasg130Entorline(cdgoDestino,
					cdgoEntorno, cdgoLinea, cdgoOrigen, tbasg130EntorlineDto);
			if (tbasg130EntorlineData != null) {
				return new ResponseEntity<>(tbasg130EntorlineData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg130Entorline []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoDestino}/{cdgoEntorno}/{cdgoLinea}/{cdgoOrigen}")
	public ResponseEntity<HttpStatus> deleteTbasg130Entorline(@PathVariable("cdgoDestino") String cdgoDestino,
			@PathVariable("cdgoEntorno") Integer cdgoEntorno, @PathVariable("cdgoLinea") String cdgoLinea,
			@PathVariable("cdgoOrigen") String cdgoOrigen) {
		try {
			tbasg130EntorlineService.deleteTbasg130Entorline(cdgoDestino, cdgoEntorno, cdgoLinea, cdgoOrigen);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg130Entorline []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg130EntorlineDto>> findByCdgoDestinoCdgoEntornoCdgoLineaCdgoOrigenIn(
			List<String> cdgoDestino, List<Integer> cdgoEntorno, List<String> cdgoLinea, List<String> cdgoOrigen) {
		try {
			List<Tbasg130EntorlineDto> tbasg130EntorlineDto = tbasg130EntorlineService
					.findByCdgoDestinoCdgoEntornoCdgoLineaCdgoOrigenIn(cdgoDestino, cdgoEntorno, cdgoLinea, cdgoOrigen);

			if (tbasg130EntorlineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg130EntorlineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoDestinoCdgoEntornoCdgoLineaCdgoOrigenIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-entor-line-count")
	public ResponseEntity<?> getEntorLineCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg130EntorlineDto> tbasg130EntorlineDto = tbasg130EntorlineService.getEntorLineCount();

			if (tbasg130EntorlineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg130EntorlineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEntorLineCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-entor-line-count-c-d-g-o_-e-n-t-o-r-n-o")
	public ResponseEntity<?> getEntorLineCountCDGO_ENTORNO(String cdgoEntorno) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg130EntorlineDto> tbasg130EntorlineDto = tbasg130EntorlineService
					.getEntorLineCountCDGO_ENTORNO(cdgoEntorno);

			if (tbasg130EntorlineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg130EntorlineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEntorLineCountCDGO_ENTORNO []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-entor-line-list-ascendente-c-d-g-o_-e-n-t-o-r-n-o")
	public ResponseEntity<List<GetEntorLineListAscendenteCDGO_ENTORNODTO>> getEntorLineListAscendenteCDGO_ENTORNO(String cdgoEntorno) {
		// Generated from a SELECT found in an XML
		try {
			List<GetEntorLineListAscendenteCDGO_ENTORNODTO> tbasg130EntorlineDto = tbasg130EntorlineService.getEntorLineListAscendenteCDGO_ENTORNO(cdgoEntorno);

			if (tbasg130EntorlineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg130EntorlineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEntorLineListAscendenteCDGO_ENTORNO []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-entor-line-list-descendente-c-d-g-o_-e-n-t-o-r-n-o")
	public ResponseEntity<List<Tbasg130EntorlineDto>> getEntorLineListDescendenteCDGO_ENTORNO(String cdgoEntorno) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg130EntorlineDto> tbasg130EntorlineDto = tbasg130EntorlineService
					.getEntorLineListDescendenteCDGO_ENTORNO(cdgoEntorno);

			if (tbasg130EntorlineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg130EntorlineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEntorLineListDescendenteCDGO_ENTORNO []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-entor-line")
	public ResponseEntity<List<Tbasg130EntorlineDto>> getEntorLine(String cdgoEntorno, String cdgoLinea,
			String cdgoOrigen, String cdgoDestino) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg130EntorlineDto> tbasg130EntorlineDto = tbasg130EntorlineService.getEntorLine(cdgoEntorno,
					cdgoLinea, cdgoOrigen, cdgoDestino);

			if (tbasg130EntorlineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg130EntorlineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEntorLine []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-entor-line-list-active")
	public ResponseEntity<List<Tbasg130EntorlineDto>> getEntorLineListActive(String cdgoEntorno) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg130EntorlineDto> tbasg130EntorlineDto = tbasg130EntorlineService
					.getEntorLineListActive(cdgoEntorno);

			if (tbasg130EntorlineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg130EntorlineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEntorLineListActive []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-entor-line-list-dynamic")
	public ResponseEntity<List<Tbasg130EntorlineDto>> getEntorLineListDynamic(String cdgoEntorno) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg130EntorlineDto> tbasg130EntorlineDto = tbasg130EntorlineService
					.getEntorLineListDynamic(cdgoEntorno);

			if (tbasg130EntorlineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg130EntorlineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEntorLineListDynamic []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-entor-line")
	public ResponseEntity<?> insertEntorLine(Tbasg130Entorline bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg130EntorlineDto = tbasg130EntorlineService.insertEntorLine(bean);
			return new ResponseEntity<>(tbasg130EntorlineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertEntorLine []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/reactive-entor-line")
	public ResponseEntity<?> reactiveEntorLine(Tbasg130Entorline bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg130EntorlineDto = tbasg130EntorlineService.reactiveEntorLine(bean);
			return new ResponseEntity<>(tbasg130EntorlineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("reactiveEntorLine []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/desactive-entor-line")
	public ResponseEntity<?> desactiveEntorLine(Tbasg130Entorline bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg130EntorlineDto = tbasg130EntorlineService.desactiveEntorLine(bean);
			return new ResponseEntity<>(tbasg130EntorlineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("desactiveEntorLine []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-entor-line")
	public ResponseEntity<?> deleteEntorLine() {
		// Generated from a DELETE found in an XML
		try {
			int tbasg130EntorlineDto = tbasg130EntorlineService.deleteEntorLine();
			return new ResponseEntity<>(tbasg130EntorlineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteEntorLine []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-tramo-linea-entorno")
	public ResponseEntity<?> deleteTramoLineaEntorno() {
		// Generated from a DELETE found in an XML
		try {
			int tbasg130EntorlineDto = tbasg130EntorlineService.deleteTramoLineaEntorno();
			return new ResponseEntity<>(tbasg130EntorlineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteTramoLineaEntorno []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tramos-entorno")
	public ResponseEntity<List<Tbasg130EntorlineDto>> getTramosEntorno(String cdgoEntorno) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg130EntorlineDto> tbasg130EntorlineDto = tbasg130EntorlineService.getTramosEntorno(cdgoEntorno);

			if (tbasg130EntorlineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg130EntorlineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTramosEntorno []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tramos-entornos")
	public ResponseEntity<List<Tbasg130EntorlineDto>> getTramosEntornos(String cdgoEntorno) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg130EntorlineDto> tbasg130EntorlineDto = tbasg130EntorlineService.getTramosEntornos(cdgoEntorno);

			if (tbasg130EntorlineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg130EntorlineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTramosEntornos []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
