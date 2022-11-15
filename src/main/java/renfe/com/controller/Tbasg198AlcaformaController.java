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

import renfe.com.model.dto.Tbasg198AlcaformaDto;
import renfe.com.model.entity.Tbasg198Alcaforma;
import renfe.com.service.Tbasg198AlcaformaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg198Alcaforma")
public class Tbasg198AlcaformaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg198AlcaformaService tbasg198AlcaformaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg198AlcaformaDto>> getAllTbasg198Alcaforma(Tbasg198AlcaformaDto filter) {
		return new ResponseEntity<>(tbasg198AlcaformaService.getAllTbasg198Alcaforma(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoDestino}/{cdgoLinea}/{cdgoOrigen}/{cdgoSolicitud}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoDestino") String cdgoDestino,
			@PathVariable("cdgoLinea") String cdgoLinea, @PathVariable("cdgoOrigen") String cdgoOrigen,
			@PathVariable("cdgoSolicitud") Integer cdgoSolicitud) {
		Tbasg198AlcaformaDto tbasg198AlcaformaData = tbasg198AlcaformaService
				.findByCdgoDestinoCdgoLineaCdgoOrigenCdgoSolicitud(cdgoDestino, cdgoLinea, cdgoOrigen, cdgoSolicitud);

		if (tbasg198AlcaformaData != null) {
			return new ResponseEntity<>(tbasg198AlcaformaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg198AlcaformaDto> createTbasg198Alcaforma(
			@RequestBody Tbasg198AlcaformaDto tbasg198AlcaformaDto) {
		try {
			return new ResponseEntity<>(tbasg198AlcaformaService.createTbasg198Alcaforma(tbasg198AlcaformaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg198Alcaforma {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoDestino}/{cdgoLinea}/{cdgoOrigen}/{cdgoSolicitud}")
	public ResponseEntity<Tbasg198AlcaformaDto> updateTbasg198Alcaforma(@PathVariable("cdgoDestino") String cdgoDestino,
			@PathVariable("cdgoLinea") String cdgoLinea, @PathVariable("cdgoOrigen") String cdgoOrigen,
			@PathVariable("cdgoSolicitud") Integer cdgoSolicitud,
			@RequestBody Tbasg198AlcaformaDto tbasg198AlcaformaDto) {
		try {
			Tbasg198AlcaformaDto tbasg198AlcaformaData = tbasg198AlcaformaService.updateTbasg198Alcaforma(cdgoDestino,
					cdgoLinea, cdgoOrigen, cdgoSolicitud, tbasg198AlcaformaDto);
			if (tbasg198AlcaformaData != null) {
				return new ResponseEntity<>(tbasg198AlcaformaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg198Alcaforma []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoDestino}/{cdgoLinea}/{cdgoOrigen}/{cdgoSolicitud}")
	public ResponseEntity<HttpStatus> deleteTbasg198Alcaforma(@PathVariable("cdgoDestino") String cdgoDestino,
			@PathVariable("cdgoLinea") String cdgoLinea, @PathVariable("cdgoOrigen") String cdgoOrigen,
			@PathVariable("cdgoSolicitud") Integer cdgoSolicitud) {
		try {
			tbasg198AlcaformaService.deleteTbasg198Alcaforma(cdgoDestino, cdgoLinea, cdgoOrigen, cdgoSolicitud);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg198Alcaforma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg198AlcaformaDto>> findByCdgoDestinoCdgoLineaCdgoOrigenCdgoSolicitudIn(
			List<String> cdgoDestino, List<String> cdgoLinea, List<String> cdgoOrigen, List<Integer> cdgoSolicitud) {
		try {
			List<Tbasg198AlcaformaDto> tbasg198AlcaformaDto = tbasg198AlcaformaService
					.findByCdgoDestinoCdgoLineaCdgoOrigenCdgoSolicitudIn(cdgoDestino, cdgoLinea, cdgoOrigen,
							cdgoSolicitud);

			if (tbasg198AlcaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg198AlcaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoDestinoCdgoLineaCdgoOrigenCdgoSolicitudIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-alca-forma")
	public ResponseEntity<?> insertAlcaForma(Tbasg198Alcaforma bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg198AlcaformaDto = tbasg198AlcaformaService.insertAlcaForma(bean);
			return new ResponseEntity<>(tbasg198AlcaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertAlcaForma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-alca-forma")
	public ResponseEntity<?> deleteAlcaForma(Tbasg198Alcaforma bean) {
		// Generated from a DELETE found in an XML
		try {
			int tbasg198AlcaformaDto = tbasg198AlcaformaService.deleteAlcaForma(bean);
			return new ResponseEntity<>(tbasg198AlcaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteAlcaForma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
