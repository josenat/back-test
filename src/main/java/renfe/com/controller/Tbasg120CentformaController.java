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

import renfe.com.dto.GetCentFormaListAscCentHgadoDTO;
import renfe.com.model.dto.Tbasg120CentformaDto;
import renfe.com.model.entity.Tbasg120Centforma;
import renfe.com.service.Tbasg120CentformaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg120Centforma")
public class Tbasg120CentformaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg120CentformaService tbasg120CentformaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg120CentformaDto>> getAllTbasg120Centforma(Tbasg120CentformaDto filter) {
		return new ResponseEntity<>(tbasg120CentformaService.getAllTbasg120Centforma(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoCentrofor}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoCentrofor") Integer cdgoCentrofor) {
		Tbasg120CentformaDto tbasg120CentformaData = tbasg120CentformaService.findByCdgoCentrofor(cdgoCentrofor);

		if (tbasg120CentformaData != null) {
			return new ResponseEntity<>(tbasg120CentformaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg120CentformaDto> createTbasg120Centforma(
			@RequestBody Tbasg120CentformaDto tbasg120CentformaDto) {
		try {
			return new ResponseEntity<>(tbasg120CentformaService.createTbasg120Centforma(tbasg120CentformaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg120Centforma {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoCentrofor}")
	public ResponseEntity<Tbasg120CentformaDto> updateTbasg120Centforma(@PathVariable("cdgoCentrofor") Integer cdgo,
			@RequestBody Tbasg120CentformaDto body) {
		try {
			Tbasg120CentformaDto tbasg120CentformaData = tbasg120CentformaService.updateTbasg120Centforma(cdgo, body);
			if (tbasg120CentformaData != null) {
				return new ResponseEntity<>(tbasg120CentformaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg120Centforma []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoCentrofor}")
	public ResponseEntity<HttpStatus> deleteTbasg120Centforma(@PathVariable("cdgoCentrofor") Integer cdgoCentrofor) {
		try {
			tbasg120CentformaService.deleteTbasg120Centforma(cdgoCentrofor);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg120Centforma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg120CentformaDto>> findByCdgoCentroforIn(List<Integer> cdgoCentrofor) {
		try {
			List<Tbasg120CentformaDto> tbasg120CentformaDto = tbasg120CentformaService
					.findByCdgoCentroforIn(cdgoCentrofor);

			if (tbasg120CentformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg120CentformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoCentroforIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-centro-for-name")
	public ResponseEntity<List<Tbasg120CentformaDto>> getCentroForName(String desgNombre) {
		try {

			logger.debug("---> NombreCentro: {}", desgNombre);

			List<Tbasg120CentformaDto> tbasg120CentformaDto = tbasg120CentformaService.getCentroForName(desgNombre);
			return new ResponseEntity<>(tbasg120CentformaDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("getCentroForName []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-forma-count")
	public ResponseEntity<?> getCentFormaCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg120CentformaDto> tbasg120CentformaDto = tbasg120CentformaService.getCentFormaCount();

			if (tbasg120CentformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg120CentformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentFormaCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-forma-view-count")
	public ResponseEntity<?> getCentFormaViewCount(String cdgoCenthgado) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg120CentformaDto> tbasg120CentformaDto = tbasg120CentformaService
					.getCentFormaViewCount(cdgoCenthgado);

			if (tbasg120CentformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg120CentformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentFormaViewCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-forma-list-ascendente")
	public ResponseEntity<List<Tbasg120CentformaDto>> getCentFormaListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg120CentformaDto> tbasg120CentformaDto = tbasg120CentformaService.getCentFormaListAscendente();

			if (tbasg120CentformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg120CentformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentFormaListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-cent-forma-list-asc-cent-hgado")
	public ResponseEntity<List<GetCentFormaListAscCentHgadoDTO>> getCentFormaListAscCentHgado(Integer cdgoCenthgado) {
		// Generated from a SELECT found in an XML
		try {
			List<GetCentFormaListAscCentHgadoDTO> tbasg120CentformaDto = tbasg120CentformaService.getCentFormaListAscCentHgado(cdgoCenthgado);

			if (tbasg120CentformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg120CentformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentFormaListAscCentHgado []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-forma-list-descendente")
	public ResponseEntity<List<Tbasg120CentformaDto>> getCentFormaListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg120CentformaDto> tbasg120CentformaDto = tbasg120CentformaService.getCentFormaListDescendente();

			if (tbasg120CentformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg120CentformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentFormaListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-forma-active-list-ascendente")
	public ResponseEntity<List<Tbasg120CentformaDto>> getCentFormaActiveListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg120CentformaDto> tbasg120CentformaDto = tbasg120CentformaService
					.getCentFormaActiveListAscendente();

			if (tbasg120CentformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg120CentformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentFormaActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-forma-active-list-descendente")
	public ResponseEntity<List<Tbasg120CentformaDto>> getCentFormaActiveListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg120CentformaDto> tbasg120CentformaDto = tbasg120CentformaService
					.getCentFormaActiveListDescendente();

			if (tbasg120CentformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg120CentformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentFormaActiveListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-forma")
	public ResponseEntity<List<Tbasg120CentformaDto>> getCentForma(String cdgoCentrofor) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg120CentformaDto> tbasg120CentformaDto = tbasg120CentformaService.getCentForma(cdgoCentrofor);

			if (tbasg120CentformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg120CentformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentForma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-forma-list-ascendente-view-c-d-g-o_-c-e-n-t-f-o-r-m-a")
	public ResponseEntity<List<Tbasg120CentformaDto>> getCentFormaListAscendenteViewCDGO_CENTFORMA(
			String cdgoCenthgado) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg120CentformaDto> tbasg120CentformaDto = tbasg120CentformaService
					.getCentFormaListAscendenteViewCDGO_CENTFORMA(cdgoCenthgado);

			if (tbasg120CentformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg120CentformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentFormaListAscendenteViewCDGO_CENTFORMA []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-forma-list-descendente-view-c-d-g-o_-c-e-n-t-f-o-r-m-a")
	public ResponseEntity<List<Tbasg120CentformaDto>> getCentFormaListDescendenteViewCDGO_CENTFORMA(
			String cdgoCenthgado) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg120CentformaDto> tbasg120CentformaDto = tbasg120CentformaService
					.getCentFormaListDescendenteViewCDGO_CENTFORMA(cdgoCenthgado);

			if (tbasg120CentformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg120CentformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentFormaListDescendenteViewCDGO_CENTFORMA []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-forma-active-list-ascendente-view-c-d-g-o_-c-e-n-t-f-o-r-m-a")
	public ResponseEntity<List<Tbasg120CentformaDto>> getCentFormaActiveListAscendenteViewCDGO_CENTFORMA(
			String cdgoCenthgado) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg120CentformaDto> tbasg120CentformaDto = tbasg120CentformaService
					.getCentFormaActiveListAscendenteViewCDGO_CENTFORMA(cdgoCenthgado);

			if (tbasg120CentformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg120CentformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentFormaActiveListAscendenteViewCDGO_CENTFORMA []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cent-forma-active-list-descendente-view-c-d-g-o_-c-e-n-t-f-o-r-m-a")
	public ResponseEntity<List<Tbasg120CentformaDto>> getCentFormaActiveListDescendenteViewCDGO_CENTFORMA(
			String cdgoCenthgado) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg120CentformaDto> tbasg120CentformaDto = tbasg120CentformaService
					.getCentFormaActiveListDescendenteViewCDGO_CENTFORMA(cdgoCenthgado);

			if (tbasg120CentformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg120CentformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCentFormaActiveListDescendenteViewCDGO_CENTFORMA []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-cent-forma")
	public ResponseEntity<?> insertCentForma(@RequestBody Tbasg120Centforma bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg120CentformaDto = tbasg120CentformaService.insertCentForma(bean);
			return new ResponseEntity<>(tbasg120CentformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertCentForma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-cent-forma")
	public ResponseEntity<?> updateCentForma(@RequestBody Tbasg120Centforma bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg120CentformaDto = tbasg120CentformaService.updateCentForma(bean);
			return new ResponseEntity<>(tbasg120CentformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateCentForma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-cent-forma")
	public ResponseEntity<?> estadoCentForma(@RequestBody Tbasg120Centforma bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg120CentformaDto = tbasg120CentformaService.estadoCentForma(bean);
			return new ResponseEntity<>(tbasg120CentformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateCentForma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-cent-forma-by-cent-hgado")
	public ResponseEntity<?> deleteCentFormaByCentHgado(Tbasg120Centforma bean) {
		// Generated from a DELETE found in an XML
		try {
			int tbasg120CentformaDto = tbasg120CentformaService.deleteCentFormaByCentHgado(bean);
			return new ResponseEntity<>(tbasg120CentformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteCentFormaByCentHgado []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
