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

import renfe.com.dto.GetCentMedicListAscCentHgadoDTO;
import renfe.com.model.dto.Tbasg108CentmedicDto;
import renfe.com.model.entity.Tbasg108Centmedic;
import renfe.com.service.Tbasg108CentmedicService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg108Centmedic")
public class Tbasg108CentmedicController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg108CentmedicService tbasg108CentmedicService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg108CentmedicDto>> getAllTbasg108Centmedic(Tbasg108CentmedicDto filter) {
		return new ResponseEntity<>(tbasg108CentmedicService.getAllTbasg108Centmedic(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoCenmed}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoCenmed") Integer cdgoCenmed) {
		Tbasg108CentmedicDto tbasg108CentmedicData = tbasg108CentmedicService.findByCdgoCenmed(cdgoCenmed);

		if (tbasg108CentmedicData != null) {
			return new ResponseEntity<>(tbasg108CentmedicData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg108CentmedicDto> createTbasg108Centmedic(
			@RequestBody Tbasg108CentmedicDto tbasg108CentmedicDto) {
		try {
			return new ResponseEntity<>(tbasg108CentmedicService.createTbasg108Centmedic(tbasg108CentmedicDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg108Centmedic {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoCenmed}")
	public ResponseEntity<Tbasg108CentmedicDto> updateTbasg108Centmedic(@PathVariable("cdgoCenmed") Integer cdgo,
			@RequestBody Tbasg108CentmedicDto body) {
		try {
			Tbasg108CentmedicDto tbasg108CentmedicData = tbasg108CentmedicService.updateTbasg108Centmedic(cdgo, body);
			if (tbasg108CentmedicData != null) {
				return new ResponseEntity<>(tbasg108CentmedicData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg108Centmedic []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoCenmed}")
	public ResponseEntity<HttpStatus> deleteTbasg108Centmedic(@PathVariable("cdgoCenmed") Integer cdgoCenmed) {
		try {
			tbasg108CentmedicService.deleteTbasg108Centmedic(cdgoCenmed);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg108Centmedic []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg108CentmedicDto>> findByCdgoCenmedIn(List<Integer> cdgoCenmed) {
		try {
			List<Tbasg108CentmedicDto> tbasg108CentmedicDto = tbasg108CentmedicService.findByCdgoCenmedIn(cdgoCenmed);

			if (tbasg108CentmedicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg108CentmedicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoCenmedIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-medic-count")
	public ResponseEntity<?> getCentMedicCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg108CentmedicDto> tbasg108CentmedicDto = tbasg108CentmedicService.getCentMedicCount();

			if (tbasg108CentmedicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg108CentmedicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentMedicCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-medic-view-count")
	public ResponseEntity<?> getCentMedicViewCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg108CentmedicDto> tbasg108CentmedicDto = tbasg108CentmedicService.getCentMedicViewCount();

			if (tbasg108CentmedicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg108CentmedicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentMedicViewCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-medic-list-asc-cent-hgado")
	public ResponseEntity<List<GetCentMedicListAscCentHgadoDTO>> getCentMedicListAscCentHgado(Integer cdgoCenthgado) {
		// Generated from a SELECT found in an XML
		try {
			List<GetCentMedicListAscCentHgadoDTO> tbasg108CentmedicDto = tbasg108CentmedicService.getCentMedicListAscCentHgado(cdgoCenthgado);

			if (tbasg108CentmedicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg108CentmedicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentMedicListAscCentHgado []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-cent-medic-list-ascendente")
	public ResponseEntity<List<Tbasg108CentmedicDto>> getCentMedicListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg108CentmedicDto> tbasg108CentmedicDto = tbasg108CentmedicService.getCentMedicListAscendente();

			if (tbasg108CentmedicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg108CentmedicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentMedicListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-medic-list-descendente")
	public ResponseEntity<List<Tbasg108CentmedicDto>> getCentMedicListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg108CentmedicDto> tbasg108CentmedicDto = tbasg108CentmedicService.getCentMedicListDescendente();

			if (tbasg108CentmedicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg108CentmedicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentMedicListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-medic-active-list-ascendente")
	public ResponseEntity<List<Tbasg108CentmedicDto>> getCentMedicActiveListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg108CentmedicDto> tbasg108CentmedicDto = tbasg108CentmedicService
					.getCentMedicActiveListAscendente();

			if (tbasg108CentmedicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg108CentmedicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentMedicActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-medic-active-list-descendente")
	public ResponseEntity<List<Tbasg108CentmedicDto>> getCentMedicActiveListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg108CentmedicDto> tbasg108CentmedicDto = tbasg108CentmedicService
					.getCentMedicActiveListDescendente();

			if (tbasg108CentmedicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg108CentmedicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentMedicActiveListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-medic")
	public ResponseEntity<List<Tbasg108CentmedicDto>> getCentMedic(Integer cdgoCenmed) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg108CentmedicDto> tbasg108CentmedicDto = tbasg108CentmedicService.getCentMedic(cdgoCenmed);

			if (tbasg108CentmedicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg108CentmedicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentMedic []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-medic-active-list-ascendente-view-c-d-g-o_-c-e-n-t-m-e-d-i-c")
	public ResponseEntity<List<Tbasg108CentmedicDto>> getCentMedicActiveListAscendenteViewCDGO_CENTMEDIC(
			String cdgoCenthgado) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg108CentmedicDto> tbasg108CentmedicDto = tbasg108CentmedicService
					.getCentMedicActiveListAscendenteViewCDGO_CENTMEDIC(cdgoCenthgado);

			if (tbasg108CentmedicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg108CentmedicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentMedicActiveListAscendenteViewCDGO_CENTMEDIC []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-medic-active-list-descendente-view-c-d-g-o_-c-e-n-t-m-e-d-i-c")
	public ResponseEntity<List<Tbasg108CentmedicDto>> getCentMedicActiveListDescendenteViewCDGO_CENTMEDIC(
			String cdgoCenthgado) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg108CentmedicDto> tbasg108CentmedicDto = tbasg108CentmedicService
					.getCentMedicActiveListDescendenteViewCDGO_CENTMEDIC(cdgoCenthgado);

			if (tbasg108CentmedicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg108CentmedicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentMedicActiveListDescendenteViewCDGO_CENTMEDIC []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-medic-list-ascendente-view-c-d-g-o_-c-e-n-t-m-e-d-i-c")
	public ResponseEntity<List<Tbasg108CentmedicDto>> getCentMedicListAscendenteViewCDGO_CENTMEDIC(
			String cdgoCenthgado) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg108CentmedicDto> tbasg108CentmedicDto = tbasg108CentmedicService
					.getCentMedicListAscendenteViewCDGO_CENTMEDIC(cdgoCenthgado);

			if (tbasg108CentmedicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg108CentmedicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentMedicListAscendenteViewCDGO_CENTMEDIC []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-medic-list-descendente-view-c-d-g-o_-c-e-n-t-m-e-d-i-c")
	public ResponseEntity<List<Tbasg108CentmedicDto>> getCentMedicListDescendenteViewCDGO_CENTMEDIC(
			String cdgoCenthgado) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg108CentmedicDto> tbasg108CentmedicDto = tbasg108CentmedicService
					.getCentMedicListDescendenteViewCDGO_CENTMEDIC(cdgoCenthgado);

			if (tbasg108CentmedicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg108CentmedicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentMedicListDescendenteViewCDGO_CENTMEDIC []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-cent-medic")
	public ResponseEntity<?> insertCentMedic(@RequestBody Tbasg108Centmedic bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg108CentmedicDto = tbasg108CentmedicService.insertCentMedic(bean);
			return new ResponseEntity<>(tbasg108CentmedicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertCentMedic []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-cent-medic")
	public ResponseEntity<?> updateCentMedic(@RequestBody Tbasg108Centmedic bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg108CentmedicDto = tbasg108CentmedicService.updateCentMedic(bean);
			return new ResponseEntity<>(tbasg108CentmedicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateCentMedic []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/estado-cent-medic")
	public ResponseEntity<?> estadoCentMedic(@RequestBody Tbasg108Centmedic bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg108CentmedicDto = tbasg108CentmedicService.estadoCentMedic(bean);
			return new ResponseEntity<>(tbasg108CentmedicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoCentMedic []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/delete-cent-medic-by-cent-hgado")
	public ResponseEntity<?> deleteCentMedicByCentHgado(Tbasg108Centmedic bean) {
		// Generated from a DELETE found in an XML
		try {
			int tbasg108CentmedicDto = tbasg108CentmedicService.deleteCentMedicByCentHgado(bean);
			return new ResponseEntity<>(tbasg108CentmedicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteCentMedicByCentHgado []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
