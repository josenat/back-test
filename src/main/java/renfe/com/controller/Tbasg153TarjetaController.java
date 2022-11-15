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

import renfe.com.model.dto.Tbasg153TarjetaDto;
import renfe.com.service.Tbasg153TarjetaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg153Tarjeta")
public class Tbasg153TarjetaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg153TarjetaService tbasg153TarjetaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg153TarjetaDto>> getAllTbasg153Tarjeta(Tbasg153TarjetaDto filter) {
		return new ResponseEntity<>(tbasg153TarjetaService.getAllTbasg153Tarjeta(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoNumserie}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoNumserie") String cdgoNumserie) {
		Tbasg153TarjetaDto tbasg153TarjetaData = tbasg153TarjetaService.findByCdgoNumserie(cdgoNumserie);

		if (tbasg153TarjetaData != null) {
			return new ResponseEntity<>(tbasg153TarjetaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg153TarjetaDto> createTbasg153Tarjeta(
			@RequestBody Tbasg153TarjetaDto tbasg153TarjetaDto) {
		try {
			return new ResponseEntity<>(tbasg153TarjetaService.createTbasg153Tarjeta(tbasg153TarjetaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg153Tarjeta {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoNumserie}")
	public ResponseEntity<Tbasg153TarjetaDto> updateTbasg153Tarjeta(@PathVariable("cdgoNumserie") String cdgoNumserie,
			@RequestBody Tbasg153TarjetaDto tbasg153TarjetaDto) {
		try {
			Tbasg153TarjetaDto tbasg153TarjetaData = tbasg153TarjetaService.updateTbasg153Tarjeta(cdgoNumserie,
					tbasg153TarjetaDto);
			if (tbasg153TarjetaData != null) {
				return new ResponseEntity<>(tbasg153TarjetaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg153Tarjeta []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoNumserie}")
	public ResponseEntity<HttpStatus> deleteTbasg153Tarjeta(@PathVariable("cdgoNumserie") String cdgoNumserie) {
		try {
			tbasg153TarjetaService.deleteTbasg153Tarjeta(cdgoNumserie);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg153Tarjeta []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg153TarjetaDto>> findByCdgoNumserieIn(List<String> cdgoNumserie) {
		try {
			List<Tbasg153TarjetaDto> tbasg153TarjetaDto = tbasg153TarjetaService.findByCdgoNumserieIn(cdgoNumserie);

			if (tbasg153TarjetaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg153TarjetaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoNumserieIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tarjeta")
	public ResponseEntity<List<Tbasg153TarjetaDto>> getTarjeta(String cdgoNumserie) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg153TarjetaDto> tbasg153TarjetaDto = tbasg153TarjetaService.getTarjeta(cdgoNumserie);

			if (tbasg153TarjetaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg153TarjetaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTarjeta []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tarjeta-per")
	public ResponseEntity<List<Tbasg153TarjetaDto>> getTarjetaPer(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg153TarjetaDto> tbasg153TarjetaDto = tbasg153TarjetaService.getTarjetaPer(cdgoPersona);

			if (tbasg153TarjetaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg153TarjetaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTarjetaPer []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
