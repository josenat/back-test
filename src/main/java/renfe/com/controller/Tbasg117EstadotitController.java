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

import renfe.com.model.dto.Tbasg117EstadotitDto;
import renfe.com.model.entity.Tbasg117Estadotit;
import renfe.com.service.Tbasg117EstadotitService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg117Estadotit")
public class Tbasg117EstadotitController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg117EstadotitService tbasg117EstadotitService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg117EstadotitDto>> getAllTbasg117Estadotit(Tbasg117EstadotitDto filter) {
		return new ResponseEntity<>(tbasg117EstadotitService.getAllTbasg117Estadotit(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoEstado}/{cdgoTit}/{fchaEstado}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoEstado") Integer cdgoEstado,
			@PathVariable("cdgoTit") Integer cdgoTit, @PathVariable("fchaEstado") String fchaEstado) {
		Tbasg117EstadotitDto tbasg117EstadotitData = tbasg117EstadotitService
				.findByCdgoEstadoCdgoTitFchaEstado(cdgoEstado, cdgoTit, fchaEstado);

		if (tbasg117EstadotitData != null) {
			return new ResponseEntity<>(tbasg117EstadotitData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg117EstadotitDto> createTbasg117Estadotit(
			@RequestBody Tbasg117EstadotitDto tbasg117EstadotitDto) {
		try {
			return new ResponseEntity<>(tbasg117EstadotitService.createTbasg117Estadotit(tbasg117EstadotitDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg117Estadotit {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoEstado}/{cdgoTit}/{fchaEstado}")
	public ResponseEntity<Tbasg117EstadotitDto> updateTbasg117Estadotit(@PathVariable("cdgoEstado") Integer cdgoEstado,
			@PathVariable("cdgoTit") Integer cdgoTit, @PathVariable("fchaEstado") String fchaEstado,
			@RequestBody Tbasg117EstadotitDto tbasg117EstadotitDto) {
		try {
			Tbasg117EstadotitDto tbasg117EstadotitData = tbasg117EstadotitService.updateTbasg117Estadotit(cdgoEstado,
					cdgoTit, fchaEstado, tbasg117EstadotitDto);
			if (tbasg117EstadotitData != null) {
				return new ResponseEntity<>(tbasg117EstadotitData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg117Estadotit []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoEstado}/{cdgoTit}/{fchaEstado}")
	public ResponseEntity<HttpStatus> deleteTbasg117Estadotit(@PathVariable("cdgoEstado") Integer cdgoEstado,
			@PathVariable("cdgoTit") Integer cdgoTit, @PathVariable("fchaEstado") String fchaEstado) {
		try {
			tbasg117EstadotitService.deleteTbasg117Estadotit(cdgoEstado, cdgoTit, fchaEstado);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg117Estadotit []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg117EstadotitDto>> findByCdgoEstadoCdgoTitFchaEstadoIn(List<Integer> cdgoEstado,
			List<Integer> cdgoTit, List<String> fchaEstado) {
		try {
			List<Tbasg117EstadotitDto> tbasg117EstadotitDto = tbasg117EstadotitService
					.findByCdgoEstadoCdgoTitFchaEstadoIn(cdgoEstado, cdgoTit, fchaEstado);

			if (tbasg117EstadotitDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg117EstadotitDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoEstadoCdgoTitFchaEstadoIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-estado-tit-by-cdgo-tit")
	public ResponseEntity<List<Tbasg117EstadotitDto>> findEstadoTitByCdgoTit(String cdgoTit) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg117EstadotitDto> tbasg117EstadotitDto = tbasg117EstadotitService.findEstadoTitByCdgoTit(cdgoTit);

			if (tbasg117EstadotitDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg117EstadotitDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findEstadoTitByCdgoTit []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estado-tit-list")
	public ResponseEntity<List<Tbasg117EstadotitDto>> getEstadoTitList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg117EstadotitDto> tbasg117EstadotitDto = tbasg117EstadotitService.getEstadoTitList();

			if (tbasg117EstadotitDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg117EstadotitDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstadoTitList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estado-tit-ultimo")
	public ResponseEntity<List<Tbasg117EstadotitDto>> getEstadoTitUltimo(String cdgoTit) {
		// Generated from a SELECT found in an XML
		try {
			logger.debug("---> cdgoTit {} ",cdgoTit);
			List<Tbasg117EstadotitDto> tbasg117EstadotitDto = tbasg117EstadotitService.getEstadoTitUltimo(cdgoTit);

			if (tbasg117EstadotitDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tbasg117EstadotitDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("getEstadoTitUltimo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estado-tit")
	public ResponseEntity<List<Tbasg117EstadotitDto>> getEstadoTit(String cdgoTit) {
		try {
			logger.debug("---> cdgoTit {} ",cdgoTit);
			List<Tbasg117EstadotitDto> tbasg117EstadotitDto = tbasg117EstadotitService.getEstadoTit(cdgoTit);

			//logger.debug("---> getCdgoEstado() [] ",tbasg117EstadotitDto[0].cdgoEstado);
			//logger.debug("---> getDesgUsuact() {} ",tbasg117EstadotitDto[0].getDesgUsuact());
			
			return new ResponseEntity<>(tbasg117EstadotitDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("getEstadoTit []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	

	@GetMapping("/existe-estado-tit")
	public ResponseEntity<?> existeEstadoTit(String cdgoTit, String cdgoEstado) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg117EstadotitDto> tbasg117EstadotitDto = tbasg117EstadotitService.existeEstadoTit(cdgoTit,
					cdgoEstado);

			if (tbasg117EstadotitDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg117EstadotitDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("existeEstadoTit []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-estado-tit")
	public ResponseEntity<?> insertEstadoTit(Tbasg117Estadotit bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg117EstadotitDto = tbasg117EstadotitService.insertEstadoTit(bean);
			return new ResponseEntity<>(tbasg117EstadotitDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertEstadoTit []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-estado-tit-sin-fecha")
	public ResponseEntity<?> insertEstadoTitSinFecha(Tbasg117Estadotit bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg117EstadotitDto = tbasg117EstadotitService.insertEstadoTitSinFecha(bean);
			return new ResponseEntity<>(tbasg117EstadotitDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertEstadoTitSinFecha []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-estado-tit")
	public ResponseEntity<?> updateEstadoTit(Tbasg117Estadotit bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg117EstadotitDto = tbasg117EstadotitService.updateEstadoTit(bean);
			return new ResponseEntity<>(tbasg117EstadotitDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateEstadoTit []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/deactivate-estado-tit")
	public ResponseEntity<?> deactivateEstadoTit(Tbasg117Estadotit bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg117EstadotitDto = tbasg117EstadotitService.desactivateEstadoTit(bean);
			return new ResponseEntity<>(tbasg117EstadotitDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deactivateEstadoTit []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
