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

import renfe.com.model.dto.Tbasg262TipoAcreditaDto;
import renfe.com.service.Tbasg262TipoAcreditaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg262TipoAcredita")
public class Tbasg262TipoAcreditaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg262TipoAcreditaService tbasg262TipoAcreditaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg262TipoAcreditaDto>> getAllTbasg262TipoAcredita(Tbasg262TipoAcreditaDto filter) {
		return new ResponseEntity<>(tbasg262TipoAcreditaService.getAllTbasg262TipoAcredita(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoTipoacr}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoTipoacr") String cdgoTipoacr) {
		Tbasg262TipoAcreditaDto tbasg262TipoAcreditaData = tbasg262TipoAcreditaService.findByCdgoTipoacr(cdgoTipoacr);

		if (tbasg262TipoAcreditaData != null) {
			return new ResponseEntity<>(tbasg262TipoAcreditaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg262TipoAcreditaDto> createTbasg262TipoAcredita(
			@RequestBody Tbasg262TipoAcreditaDto tbasg262TipoAcreditaDto) {
		try {
			return new ResponseEntity<>(tbasg262TipoAcreditaService.createTbasg262TipoAcredita(tbasg262TipoAcreditaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg262TipoAcredita {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoTipoacr}")
	public ResponseEntity<Tbasg262TipoAcreditaDto> updateTbasg262TipoAcredita(
			@PathVariable("cdgoTipoacr") String cdgoTipoacr,
			@RequestBody Tbasg262TipoAcreditaDto tbasg262TipoAcreditaDto) {
		try {
			Tbasg262TipoAcreditaDto tbasg262TipoAcreditaData = tbasg262TipoAcreditaService
					.updateTbasg262TipoAcredita(cdgoTipoacr, tbasg262TipoAcreditaDto);
			if (tbasg262TipoAcreditaData != null) {
				return new ResponseEntity<>(tbasg262TipoAcreditaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg262TipoAcredita []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoTipoacr}")
	public ResponseEntity<HttpStatus> deleteTbasg262TipoAcredita(@PathVariable("cdgoTipoacr") String cdgoTipoacr) {
		try {
			tbasg262TipoAcreditaService.deleteTbasg262TipoAcredita(cdgoTipoacr);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg262TipoAcredita []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg262TipoAcreditaDto>> findByCdgoTipoacrIn(List<String> cdgoTipoacr) {
		try {
			List<Tbasg262TipoAcreditaDto> tbasg262TipoAcreditaDto = tbasg262TipoAcreditaService
					.findByCdgoTipoacrIn(cdgoTipoacr);

			if (tbasg262TipoAcreditaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg262TipoAcreditaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoTipoacrIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-acreditacion")
	public ResponseEntity<List<Tbasg262TipoAcreditaDto>> getTipoAcreditacion(String cdgoTipoacr) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg262TipoAcreditaDto> tbasg262TipoAcreditaDto = tbasg262TipoAcreditaService
					.getTipoAcreditacion(cdgoTipoacr);

			if (tbasg262TipoAcreditaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg262TipoAcreditaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoAcreditacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-lista-tipos-acreditacion")
	public ResponseEntity<List<Tbasg262TipoAcreditaDto>> getListaTiposAcreditacion() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg262TipoAcreditaDto> tbasg262TipoAcreditaDto = tbasg262TipoAcreditaService
					.getListaTiposAcreditacion();

			if (tbasg262TipoAcreditaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg262TipoAcreditaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getListaTiposAcreditacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-lista-tipos-acreditacion-activ")
	public ResponseEntity<List<Tbasg262TipoAcreditaDto>> getListaTiposAcreditacionActiv() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg262TipoAcreditaDto> tbasg262TipoAcreditaDto = tbasg262TipoAcreditaService
					.getListaTiposAcreditacionActiv();

			if (tbasg262TipoAcreditaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg262TipoAcreditaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getListaTiposAcreditacionActiv []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-desc-tipo-acreditacion")
	public ResponseEntity<?> getDescTipoAcreditacion(String cdgoTipoacr) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg262TipoAcreditaDto> tbasg262TipoAcreditaDto = tbasg262TipoAcreditaService
					.getDescTipoAcreditacion(cdgoTipoacr);

			if (tbasg262TipoAcreditaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg262TipoAcreditaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDescTipoAcreditacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-validez-reciclaje")
	public ResponseEntity<List<Tbasg262TipoAcreditaDto>> getValidezReciclaje(String cdgoTipoacr) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg262TipoAcreditaDto> tbasg262TipoAcreditaDto = tbasg262TipoAcreditaService
					.getValidezReciclaje(cdgoTipoacr);

			if (tbasg262TipoAcreditaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg262TipoAcreditaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoAcreditacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
