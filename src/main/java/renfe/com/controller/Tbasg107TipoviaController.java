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

import renfe.com.model.dto.Tbasg107TipoviaDto;
import renfe.com.model.entity.Tbasg107Tipovia;
import renfe.com.service.Tbasg107TipoviaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg107Tipovia")
public class Tbasg107TipoviaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg107TipoviaService tbasg107TipoviaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg107TipoviaDto>> getAllTbasg107Tipovia(Tbasg107TipoviaDto filter) {
		return new ResponseEntity<>(tbasg107TipoviaService.getAllTbasg107Tipovia(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoTipovia}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoTipovia") Integer cdgoTipovia) {
		Tbasg107TipoviaDto tbasg107TipoviaData = tbasg107TipoviaService.findByCdgoTipovia(cdgoTipovia);

		if (tbasg107TipoviaData != null) {
			return new ResponseEntity<>(tbasg107TipoviaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg107TipoviaDto> createTbasg107Tipovia(
			@RequestBody Tbasg107TipoviaDto tbasg107TipoviaDto) {
		try {
			return new ResponseEntity<>(tbasg107TipoviaService.createTbasg107Tipovia(tbasg107TipoviaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg107Tipovia {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoTipovia}")
	public ResponseEntity<Tbasg107TipoviaDto> updateTbasg107Tipovia(@PathVariable("cdgoTipovia") Integer cdgo,
			@RequestBody Tbasg107TipoviaDto body) {
		try {
			Tbasg107TipoviaDto tbasg107TipoviaData = tbasg107TipoviaService.updateTbasg107Tipovia(cdgo, body);
			if (tbasg107TipoviaData != null) {
				return new ResponseEntity<>(tbasg107TipoviaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg107Tipovia []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoTipovia}")
	public ResponseEntity<HttpStatus> deleteTbasg107Tipovia(@PathVariable("cdgoTipovia") Integer cdgoTipovia) {
		try {
			tbasg107TipoviaService.deleteTbasg107Tipovia(cdgoTipovia);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg107Tipovia []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg107TipoviaDto>> findByCdgoTipoviaIn(List<Integer> cdgoTipovia) {
		try {
			List<Tbasg107TipoviaDto> tbasg107TipoviaDto = tbasg107TipoviaService.findByCdgoTipoviaIn(cdgoTipovia);

			if (tbasg107TipoviaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg107TipoviaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoTipoviaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-via")
	public ResponseEntity<List<Tbasg107TipoviaDto>> getTipoVia(String cdgoTipovia) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg107TipoviaDto> tbasg107TipoviaDto = tbasg107TipoviaService.getTipoVia(cdgoTipovia);

			if (tbasg107TipoviaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg107TipoviaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoVia []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-via-list-ascendente")
	public ResponseEntity<List<Tbasg107TipoviaDto>> getTipoViaListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg107TipoviaDto> tbasg107TipoviaDto = tbasg107TipoviaService.getTipoViaListAscendente();

			if (tbasg107TipoviaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg107TipoviaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoViaListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-via-list-descendente")
	public ResponseEntity<List<Tbasg107TipoviaDto>> getTipoViaListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg107TipoviaDto> tbasg107TipoviaDto = tbasg107TipoviaService.getTipoViaListDescendente();

			if (tbasg107TipoviaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg107TipoviaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoViaListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-via-active-list-ascendente")
	public ResponseEntity<List<Tbasg107TipoviaDto>> getTipoViaActiveListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg107TipoviaDto> tbasg107TipoviaDto = tbasg107TipoviaService.getTipoViaActiveListAscendente();

			if (tbasg107TipoviaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg107TipoviaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoViaActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-via-active-list-descendente")
	public ResponseEntity<List<Tbasg107TipoviaDto>> getTipoViaActiveListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg107TipoviaDto> tbasg107TipoviaDto = tbasg107TipoviaService.getTipoViaActiveListDescendente();

			if (tbasg107TipoviaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg107TipoviaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoViaActiveListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-via-count")
	public ResponseEntity<?> getTipoViaCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg107TipoviaDto> tbasg107TipoviaDto = tbasg107TipoviaService.getTipoViaCount();

			if (tbasg107TipoviaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg107TipoviaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoViaCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-tipo-via")
	public ResponseEntity<?> insertTipoVia(@RequestBody Tbasg107Tipovia bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg107TipoviaDto = tbasg107TipoviaService.insertTipoVia(bean);
			return new ResponseEntity<>(tbasg107TipoviaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertTipoVia []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-tipo-via")
	public ResponseEntity<?> updateTipoVia(@RequestBody Tbasg107Tipovia bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg107TipoviaDto = tbasg107TipoviaService.updateTipoVia(bean);
			return new ResponseEntity<>(tbasg107TipoviaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateTipoVia []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-tipo-via")
	public ResponseEntity<?> estadoTipoVia(@RequestBody Tbasg107Tipovia bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg107TipoviaDto = tbasg107TipoviaService.estadoTipoVia(bean);
			return new ResponseEntity<>(tbasg107TipoviaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoTipoVia []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
