package renfe.com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import renfe.com.model.dto.Tbasg197FormacionDto;
import renfe.com.model.entity.Tbasg197Formacion;
import renfe.com.service.Tbasg197FormacionService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg197Formacion")
public class Tbasg197FormacionController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg197FormacionService tbasg197FormacionService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg197FormacionDto>> getAllTbasg197Formacion(Tbasg197FormacionDto filter) {
		return new ResponseEntity<>(tbasg197FormacionService.getAllTbasg197Formacion(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoSolicitud}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoSolicitud") Integer cdgoSolicitud) {
		Tbasg197FormacionDto tbasg197FormacionData = tbasg197FormacionService.findByCdgoSolicitud(cdgoSolicitud);

		if (tbasg197FormacionData != null) {
			return new ResponseEntity<>(tbasg197FormacionData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg197FormacionDto> createTbasg197Formacion(
			@RequestBody Tbasg197FormacionDto tbasg197FormacionDto) {
		try {
			return new ResponseEntity<>(tbasg197FormacionService.createTbasg197Formacion(tbasg197FormacionDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg197Formacion {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoSolicitud}")
	public ResponseEntity<Tbasg197FormacionDto> updateTbasg197Formacion(@PathVariable("cdgoSolicitud") Integer cdgo,
			@RequestBody Tbasg197FormacionDto body) {
		try {
			Tbasg197FormacionDto tbasg197FormacionData = tbasg197FormacionService.updateTbasg197Formacion(cdgo, body);
			if (tbasg197FormacionData != null) {
				return new ResponseEntity<>(tbasg197FormacionData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg197Formacion []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoSolicitud}")
	public ResponseEntity<HttpStatus> deleteTbasg197Formacion(@PathVariable("cdgoSolicitud") Integer cdgoSolicitud) {
		try {
			tbasg197FormacionService.deleteTbasg197Formacion(cdgoSolicitud);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg197Formacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg197FormacionDto>> findByCdgoSolicitudIn(List<Integer> cdgoSolicitud) {
		try {
			List<Tbasg197FormacionDto> tbasg197FormacionDto = tbasg197FormacionService
					.findByCdgoSolicitudIn(cdgoSolicitud);

			if (tbasg197FormacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg197FormacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoSolicitudIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-alca-forma")
	public ResponseEntity<List<Tbasg197FormacionDto>> getAlcaForma(String cdgoSolicitud) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg197FormacionDto> tbasg197FormacionDto = tbasg197FormacionService.getAlcaForma(cdgoSolicitud);

			if (tbasg197FormacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg197FormacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAlcaForma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-formacion-by-dni-nif")
	public ResponseEntity<List<Tbasg197FormacionDto>> getFormacionByDniNif(String desgNifpas) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg197FormacionDto> tbasg197FormacionDto = tbasg197FormacionService.getFormacionByDniNif(desgNifpas);

			if (tbasg197FormacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg197FormacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFormacionByDniNif []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-formacion-expediente")
	public ResponseEntity<List<Tbasg197FormacionDto>> getFormacionExpediente(Integer cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg197FormacionDto> tbasg197FormacionDto = tbasg197FormacionService
					.getFormacionExpediente(cdgoExpedient);

			if (tbasg197FormacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg197FormacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFormacionExpediente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-max-formacion-expediente")
	public ResponseEntity<List<Tbasg197FormacionDto>> getMaxFormacionExpediente(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg197FormacionDto> tbasg197FormacionDto = tbasg197FormacionService
					.getMaxFormacionExpediente(cdgoExpedient);

			if (tbasg197FormacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg197FormacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getMaxFormacionExpediente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-reciclaje-expediente")
	public ResponseEntity<List<Tbasg197FormacionDto>> getReciclajeExpediente(Integer cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg197FormacionDto> tbasg197FormacionDto = tbasg197FormacionService
					.getReciclajeExpediente(cdgoExpedient);

			if (tbasg197FormacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg197FormacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getReciclajeExpediente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-reciclaje-titulo-cond")
	public ResponseEntity<List<Tbasg197FormacionDto>> getReciclajeTituloCond(String cdgoTit) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg197FormacionDto> tbasg197FormacionDto = tbasg197FormacionService.getReciclajeTituloCond(cdgoTit);

			if (tbasg197FormacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg197FormacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getReciclajeTituloCond []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-formacion-valores")
	public ResponseEntity<List<Tbasg197FormacionDto>> getFormacionValores() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg197FormacionDto> tbasg197FormacionDto = tbasg197FormacionService.getFormacionValores();

			if (tbasg197FormacionDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg197FormacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFormacionValores []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PostMapping("/insert-formacion")
	public ResponseEntity<?> insertFormacion(@RequestBody Tbasg197Formacion bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg197FormacionDto = tbasg197FormacionService.insertFormacion(bean);
			return new ResponseEntity<>(tbasg197FormacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertFormacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional
	@GetMapping("/delete-formacion")
	public ResponseEntity<?> deleteFormacion(Integer cdgoSolicitud) {
		// Generated from a DELETE found in an XML
		try {
			int tbasg197FormacionDto = tbasg197FormacionService.deleteFormacion(cdgoSolicitud);
			return new ResponseEntity<>(tbasg197FormacionDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteFormacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
