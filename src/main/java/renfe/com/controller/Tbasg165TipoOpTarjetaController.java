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

import renfe.com.model.dto.Tbasg165TipoOpTarjetaDto;
import renfe.com.service.Tbasg165TipoOpTarjetaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg165TipoOpTarjeta")
public class Tbasg165TipoOpTarjetaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg165TipoOpTarjetaService tbasg165TipoOpTarjetaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg165TipoOpTarjetaDto>> getAllTbasg165TipoOpTarjeta(Tbasg165TipoOpTarjetaDto filter) {
		return new ResponseEntity<>(tbasg165TipoOpTarjetaService.getAllTbasg165TipoOpTarjeta(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoOperacion}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoOperacion") String cdgoOperacion) {
		Tbasg165TipoOpTarjetaDto tbasg165TipoOpTarjetaData = tbasg165TipoOpTarjetaService
				.findByCdgoOperacion(cdgoOperacion);

		if (tbasg165TipoOpTarjetaData != null) {
			return new ResponseEntity<>(tbasg165TipoOpTarjetaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg165TipoOpTarjetaDto> createTbasg165TipoOpTarjeta(
			@RequestBody Tbasg165TipoOpTarjetaDto tbasg165TipoOpTarjetaDto) {
		try {
			return new ResponseEntity<>(
					tbasg165TipoOpTarjetaService.createTbasg165TipoOpTarjeta(tbasg165TipoOpTarjetaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg165TipoOpTarjeta {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoOperacion}")
	public ResponseEntity<Tbasg165TipoOpTarjetaDto> updateTbasg165TipoOpTarjeta(
			@PathVariable("cdgoOperacion") String cdgoOperacion,
			@RequestBody Tbasg165TipoOpTarjetaDto tbasg165TipoOpTarjetaDto) {
		try {
			Tbasg165TipoOpTarjetaDto tbasg165TipoOpTarjetaData = tbasg165TipoOpTarjetaService
					.updateTbasg165TipoOpTarjeta(cdgoOperacion, tbasg165TipoOpTarjetaDto);
			if (tbasg165TipoOpTarjetaData != null) {
				return new ResponseEntity<>(tbasg165TipoOpTarjetaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg165TipoOpTarjeta []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoOperacion}")
	public ResponseEntity<HttpStatus> deleteTbasg165TipoOpTarjeta(@PathVariable("cdgoOperacion") String cdgoOperacion) {
		try {
			tbasg165TipoOpTarjetaService.deleteTbasg165TipoOpTarjeta(cdgoOperacion);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg165TipoOpTarjeta []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg165TipoOpTarjetaDto>> findByCdgoOperacionIn(List<String> cdgoOperacion) {
		try {
			List<Tbasg165TipoOpTarjetaDto> tbasg165TipoOpTarjetaDto = tbasg165TipoOpTarjetaService
					.findByCdgoOperacionIn(cdgoOperacion);

			if (tbasg165TipoOpTarjetaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg165TipoOpTarjetaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoOperacionIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-op-tarjeta-active-list")
	public ResponseEntity<List<Tbasg165TipoOpTarjetaDto>> getTipoOpTarjetaActiveList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg165TipoOpTarjetaDto> tbasg165TipoOpTarjetaDto = tbasg165TipoOpTarjetaService
					.getTipoOpTarjetaActiveList();

			if (tbasg165TipoOpTarjetaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg165TipoOpTarjetaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoOpTarjetaActiveList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
