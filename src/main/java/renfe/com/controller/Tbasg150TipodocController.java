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

import renfe.com.model.dto.Tbasg150TipodocDto;
import renfe.com.service.Tbasg150TipodocService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg150Tipodoc")
public class Tbasg150TipodocController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg150TipodocService tbasg150TipodocService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg150TipodocDto>> getAllTbasg150Tipodoc(Tbasg150TipodocDto filter) {
		return new ResponseEntity<>(tbasg150TipodocService.getAllTbasg150Tipodoc(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoTipodoc}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoTipodoc") Integer cdgoTipodoc) {
		Tbasg150TipodocDto tbasg150TipodocData = tbasg150TipodocService.findByCdgoTipodoc(cdgoTipodoc);

		if (tbasg150TipodocData != null) {
			return new ResponseEntity<>(tbasg150TipodocData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg150TipodocDto> createTbasg150Tipodoc(
			@RequestBody Tbasg150TipodocDto tbasg150TipodocDto) {
		try {
			return new ResponseEntity<>(tbasg150TipodocService.createTbasg150Tipodoc(tbasg150TipodocDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg150Tipodoc {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoTipodoc}")
	public ResponseEntity<Tbasg150TipodocDto> updateTbasg150Tipodoc(@PathVariable("cdgoTipodoc") Integer cdgo,
			@RequestBody Tbasg150TipodocDto body) {
		try {
			Tbasg150TipodocDto tbasg150TipodocData = tbasg150TipodocService.updateTbasg150Tipodoc(cdgo, body);
			if (tbasg150TipodocData != null) {
				return new ResponseEntity<>(tbasg150TipodocData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg150Tipodoc []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoTipodoc}")
	public ResponseEntity<HttpStatus> deleteTbasg150Tipodoc(@PathVariable("cdgoTipodoc") Integer cdgoTipodoc) {
		try {
			tbasg150TipodocService.deleteTbasg150Tipodoc(cdgoTipodoc);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg150Tipodoc []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg150TipodocDto>> findByCdgoTipodocIn(List<Integer> cdgoTipodoc) {
		try {
			List<Tbasg150TipodocDto> tbasg150TipodocDto = tbasg150TipodocService.findByCdgoTipodocIn(cdgoTipodoc);

			if (tbasg150TipodocDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg150TipodocDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoTipodocIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-desc-tipo-documento")
	public ResponseEntity<?> getDescTipoDocumento(String cdgoTipodoc) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg150TipodocDto> tbasg150TipodocDto = tbasg150TipodocService.getDescTipoDocumento(cdgoTipodoc);

			if (tbasg150TipodocDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg150TipodocDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDescTipoDocumento []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-doc-list-by-codigo")
	public ResponseEntity<List<Tbasg150TipodocDto>> getTipoDocListByCodigo() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg150TipodocDto> tbasg150TipodocDto = tbasg150TipodocService.getTipoDocListByCodigo();

			if (tbasg150TipodocDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg150TipodocDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoDocListByCodigo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-doc-count")
	public ResponseEntity<?> getTipoDocCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg150TipodocDto> tbasg150TipodocDto = tbasg150TipodocService.getTipoDocCount();

			if (tbasg150TipodocDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg150TipodocDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoDocCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
