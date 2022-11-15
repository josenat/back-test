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

import renfe.com.model.dto.Tbasg112TipoinfraDto;
import renfe.com.model.entity.Tbasg112Tipoinfra;
import renfe.com.service.Tbasg112TipoinfraService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg112Tipoinfra")
public class Tbasg112TipoinfraController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg112TipoinfraService tbasg112TipoinfraService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg112TipoinfraDto>> getAllTbasg112Tipoinfra(Tbasg112TipoinfraDto filter) {
		return new ResponseEntity<>(tbasg112TipoinfraService.getAllTbasg112Tipoinfra(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoTipinfr}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoTipinfr") Integer cdgoTipinfr) {
		Tbasg112TipoinfraDto tbasg112TipoinfraData = tbasg112TipoinfraService.findByCdgoTipinfr(cdgoTipinfr);

		if (tbasg112TipoinfraData != null) {
			return new ResponseEntity<>(tbasg112TipoinfraData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg112TipoinfraDto> createTbasg112Tipoinfra(
			@RequestBody Tbasg112TipoinfraDto tbasg112TipoinfraDto) {
		try {
			return new ResponseEntity<>(tbasg112TipoinfraService.createTbasg112Tipoinfra(tbasg112TipoinfraDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg112Tipoinfra {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoTipinfr}")
	public ResponseEntity<Tbasg112TipoinfraDto> updateTbasg112Tipoinfra(@PathVariable("cdgoTipinfr") Integer cdgo,
			@RequestBody Tbasg112TipoinfraDto body) {
		try {
			Tbasg112TipoinfraDto tbasg112TipoinfraData = tbasg112TipoinfraService.updateTbasg112Tipoinfra(cdgo, body);
			if (tbasg112TipoinfraData != null) {
				return new ResponseEntity<>(tbasg112TipoinfraData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg112Tipoinfra []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoTipinfr}")
	public ResponseEntity<HttpStatus> deleteTbasg112Tipoinfra(@PathVariable("cdgoTipinfr") Integer cdgoTipinfr) {
		try {
			tbasg112TipoinfraService.deleteTbasg112Tipoinfra(cdgoTipinfr);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg112Tipoinfra []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg112TipoinfraDto>> findByCdgoTipinfrIn(List<Integer> cdgoTipinfr) {
		try {
			List<Tbasg112TipoinfraDto> tbasg112TipoinfraDto = tbasg112TipoinfraService.findByCdgoTipinfrIn(cdgoTipinfr);

			if (tbasg112TipoinfraDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg112TipoinfraDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoTipinfrIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-infra-count")
	public ResponseEntity<?> getTipoInfraCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg112TipoinfraDto> tbasg112TipoinfraDto = tbasg112TipoinfraService.getTipoInfraCount();

			if (tbasg112TipoinfraDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg112TipoinfraDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoInfraCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-infra-active-count")
	public ResponseEntity<?> getTipoInfraActiveCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg112TipoinfraDto> tbasg112TipoinfraDto = tbasg112TipoinfraService.getTipoInfraActiveCount();

			if (tbasg112TipoinfraDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg112TipoinfraDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoInfraActiveCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-infra-list-ascendente")
	public ResponseEntity<List<Tbasg112TipoinfraDto>> getTipoInfraListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg112TipoinfraDto> tbasg112TipoinfraDto = tbasg112TipoinfraService.getTipoInfraListAscendente();

			if (tbasg112TipoinfraDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg112TipoinfraDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoInfraListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-infra-list-descendente")
	public ResponseEntity<List<Tbasg112TipoinfraDto>> getTipoInfraListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg112TipoinfraDto> tbasg112TipoinfraDto = tbasg112TipoinfraService.getTipoInfraListDescendente();

			if (tbasg112TipoinfraDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg112TipoinfraDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoInfraListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-infra-active-list-ascendente")
	public ResponseEntity<List<Tbasg112TipoinfraDto>> getTipoInfraActiveListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg112TipoinfraDto> tbasg112TipoinfraDto = tbasg112TipoinfraService
					.getTipoInfraActiveListAscendente();

			if (tbasg112TipoinfraDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg112TipoinfraDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoInfraActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-infra-active-list-descendente")
	public ResponseEntity<List<Tbasg112TipoinfraDto>> getTipoInfraActiveListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg112TipoinfraDto> tbasg112TipoinfraDto = tbasg112TipoinfraService
					.getTipoInfraActiveListDescendente();

			if (tbasg112TipoinfraDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg112TipoinfraDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoInfraActiveListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tipo-infra")
	public ResponseEntity<List<Tbasg112TipoinfraDto>> getTipoInfra(String cdgoTipinfr) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg112TipoinfraDto> tbasg112TipoinfraDto = tbasg112TipoinfraService.getTipoInfra(cdgoTipinfr);

			if (tbasg112TipoinfraDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg112TipoinfraDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTipoInfra []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-tipo-infra")
	public ResponseEntity<?> insertTipoInfra(@RequestBody Tbasg112Tipoinfra bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg112TipoinfraDto = tbasg112TipoinfraService.insertTipoInfra(bean);
			return new ResponseEntity<>(tbasg112TipoinfraDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertTipoInfra []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-tipo-infra")
	public ResponseEntity<?> updateTipoInfra(@RequestBody Tbasg112Tipoinfra bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg112TipoinfraDto = tbasg112TipoinfraService.updateTipoInfra(bean);
			return new ResponseEntity<>(tbasg112TipoinfraDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateTipoInfra []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-tipo-infra")
	public ResponseEntity<?> estadoTipoInfra(@RequestBody Tbasg112Tipoinfra bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg112TipoinfraDto = tbasg112TipoinfraService.estadoTipoInfra(bean);
			return new ResponseEntity<>(tbasg112TipoinfraDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoTipoInfra []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
