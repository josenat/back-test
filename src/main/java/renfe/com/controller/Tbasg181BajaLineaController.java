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

import renfe.com.model.dto.Tbasg181BajaLineaDto;
import renfe.com.model.entity.Tbasg181BajaLinea;
import renfe.com.service.Tbasg181BajaLineaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg181BajaLinea")
public class Tbasg181BajaLineaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg181BajaLineaService tbasg181BajaLineaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg181BajaLineaDto>> getAllTbasg181BajaLinea(Tbasg181BajaLineaDto filter) {
		return new ResponseEntity<>(tbasg181BajaLineaService.getAllTbasg181BajaLinea(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoLinea}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoLinea") String cdgoLinea) {
		Tbasg181BajaLineaDto tbasg181BajaLineaData = tbasg181BajaLineaService.findByCdgoLinea(cdgoLinea);

		if (tbasg181BajaLineaData != null) {
			return new ResponseEntity<>(tbasg181BajaLineaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg181BajaLineaDto> createTbasg181BajaLinea(
			@RequestBody Tbasg181BajaLineaDto tbasg181BajaLineaDto) {
		try {
			return new ResponseEntity<>(tbasg181BajaLineaService.createTbasg181BajaLinea(tbasg181BajaLineaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg181BajaLinea {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoLinea}")
	public ResponseEntity<Tbasg181BajaLineaDto> updateTbasg181BajaLinea(@PathVariable("cdgoLinea") String cdgoLinea,
			@RequestBody Tbasg181BajaLineaDto tbasg181BajaLineaDto) {
		try {
			Tbasg181BajaLineaDto tbasg181BajaLineaData = tbasg181BajaLineaService.updateTbasg181BajaLinea(cdgoLinea,
					tbasg181BajaLineaDto);
			if (tbasg181BajaLineaData != null) {
				return new ResponseEntity<>(tbasg181BajaLineaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg181BajaLinea []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoLinea}")
	public ResponseEntity<HttpStatus> deleteTbasg181BajaLinea(@PathVariable("cdgoLinea") String cdgoLinea) {
		try {
			tbasg181BajaLineaService.deleteTbasg181BajaLinea(cdgoLinea);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg181BajaLinea []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg181BajaLineaDto>> findByCdgoLineaIn(List<String> cdgoLinea) {
		try {
			List<Tbasg181BajaLineaDto> tbasg181BajaLineaDto = tbasg181BajaLineaService.findByCdgoLineaIn(cdgoLinea);

			if (tbasg181BajaLineaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg181BajaLineaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoLineaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-baja-linea")
	public ResponseEntity<List<Tbasg181BajaLineaDto>> getBajaLinea(String cdgoLinea) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg181BajaLineaDto> tbasg181BajaLineaDto = tbasg181BajaLineaService.getBajaLinea(cdgoLinea);

			if (tbasg181BajaLineaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg181BajaLineaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getBajaLinea []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-baja-linea")
	public ResponseEntity<?> insertBajaLinea(Tbasg181BajaLinea bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg181BajaLineaDto = tbasg181BajaLineaService.insertBajaLinea(bean);
			return new ResponseEntity<>(tbasg181BajaLineaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertBajaLinea []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
