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

import renfe.com.model.dto.Tbasg123TipohabilDto;
import renfe.com.service.Tbasg123TipohabilService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg123Tipohabil")
public class Tbasg123TipohabilController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg123TipohabilService tbasg123TipohabilService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg123TipohabilDto>> getAllTbasg123Tipohabil(Tbasg123TipohabilDto filter) {
		return new ResponseEntity<>(tbasg123TipohabilService.getAllTbasg123Tipohabil(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoTipohab}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoTipohab") Integer cdgoTipohab) {
		Tbasg123TipohabilDto tbasg123TipohabilData = tbasg123TipohabilService.findByCdgoTipohab(cdgoTipohab);

		if (tbasg123TipohabilData != null) {
			return new ResponseEntity<>(tbasg123TipohabilData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg123TipohabilDto> createTbasg123Tipohabil(
			@RequestBody Tbasg123TipohabilDto tbasg123TipohabilDto) {
		try {
			return new ResponseEntity<>(tbasg123TipohabilService.createTbasg123Tipohabil(tbasg123TipohabilDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg123Tipohabil {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoTipohab}")
	public ResponseEntity<Tbasg123TipohabilDto> updateTbasg123Tipohabil(@PathVariable("cdgoTipohab") Integer cdgo,
			@RequestBody Tbasg123TipohabilDto body) {
		try {
			Tbasg123TipohabilDto tbasg123TipohabilData = tbasg123TipohabilService.updateTbasg123Tipohabil(cdgo, body);
			if (tbasg123TipohabilData != null) {
				return new ResponseEntity<>(tbasg123TipohabilData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg123Tipohabil []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoTipohab}")
	public ResponseEntity<HttpStatus> deleteTbasg123Tipohabil(@PathVariable("cdgoTipohab") Integer cdgoTipohab) {
		try {
			tbasg123TipohabilService.deleteTbasg123Tipohabil(cdgoTipohab);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg123Tipohabil []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg123TipohabilDto>> findByCdgoTipohabIn(List<Integer> cdgoTipohab) {
		try {
			List<Tbasg123TipohabilDto> tbasg123TipohabilDto = tbasg123TipohabilService.findByCdgoTipohabIn(cdgoTipohab);

			if (tbasg123TipohabilDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg123TipohabilDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoTipohabIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-habil-list")
	public ResponseEntity<List<Tbasg123TipohabilDto>> getTipoHabilList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg123TipohabilDto> tbasg123TipohabilDto = tbasg123TipohabilService.getTipoHabilList();

			if (tbasg123TipohabilDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg123TipohabilDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoHabilList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-habil-list-combo")
	public ResponseEntity<List<Tbasg123TipohabilDto>> getTipoHabilListCombo() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg123TipohabilDto> tbasg123TipohabilDto = tbasg123TipohabilService.getTipoHabilListCombo();

			if (tbasg123TipohabilDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg123TipohabilDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoHabilListCombo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-habil")
	public ResponseEntity<List<Tbasg123TipohabilDto>> getTipoHabil(String cdgoTipohab) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg123TipohabilDto> tbasg123TipohabilDto = tbasg123TipohabilService.getTipoHabil(cdgoTipohab);

			if (tbasg123TipohabilDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg123TipohabilDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoHabil []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
