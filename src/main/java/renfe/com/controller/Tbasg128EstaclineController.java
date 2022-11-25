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

import renfe.com.model.dto.Tbasg128EstaclineDto;
import renfe.com.model.entity.Tbasg128Estacline;
import renfe.com.service.Tbasg128EstaclineService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg128Estacline")
public class Tbasg128EstaclineController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg128EstaclineService tbasg128EstaclineService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg128EstaclineDto>> getAllTbasg128Estacline(Tbasg128EstaclineDto filter) {
		return new ResponseEntity<>(tbasg128EstaclineService.getAllTbasg128Estacline(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoEstacion}/{cdgoLinea}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoEstacion") String cdgoEstacion,
			@PathVariable("cdgoLinea") String cdgoLinea) {
		Tbasg128EstaclineDto tbasg128EstaclineData = tbasg128EstaclineService.findByCdgoEstacionCdgoLinea(cdgoEstacion,
				cdgoLinea);

		if (tbasg128EstaclineData != null) {
			return new ResponseEntity<>(tbasg128EstaclineData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg128EstaclineDto> createTbasg128Estacline(
			@RequestBody Tbasg128EstaclineDto tbasg128EstaclineDto) {
		try {
			return new ResponseEntity<>(tbasg128EstaclineService.createTbasg128Estacline(tbasg128EstaclineDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg128Estacline {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoEstacion}/{cdgoLinea}")
	public ResponseEntity<Tbasg128EstaclineDto> updateTbasg128Estacline(
			@PathVariable("cdgoEstacion") String cdgoEstacion, @PathVariable("cdgoLinea") String cdgoLinea,
			@RequestBody Tbasg128EstaclineDto tbasg128EstaclineDto) {
		try {
			Tbasg128EstaclineDto tbasg128EstaclineData = tbasg128EstaclineService.updateTbasg128Estacline(cdgoEstacion,
					cdgoLinea, tbasg128EstaclineDto);
			if (tbasg128EstaclineData != null) {
				return new ResponseEntity<>(tbasg128EstaclineData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg128Estacline []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoEstacion}/{cdgoLinea}")
	public ResponseEntity<HttpStatus> deleteTbasg128Estacline(@PathVariable("cdgoEstacion") String cdgoEstacion,
			@PathVariable("cdgoLinea") String cdgoLinea) {
		try {
			tbasg128EstaclineService.deleteTbasg128Estacline(cdgoEstacion, cdgoLinea);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg128Estacline []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg128EstaclineDto>> findByCdgoEstacionCdgoLineaIn(List<String> cdgoEstacion,
			List<String> cdgoLinea) {
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService
					.findByCdgoEstacionCdgoLineaIn(cdgoEstacion, cdgoLinea);

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoEstacionCdgoLineaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-datos-linea")
	public ResponseEntity<List<Tbasg128EstaclineDto>> getDatosLinea(String cdgoEstacion, String cdgoAcredita) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService.getDatosLinea(cdgoEstacion,
					cdgoAcredita);

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDatosLinea []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-desc-tipo-ambito-estacion-linea")
	public ResponseEntity<?> getDescTipoAmbitoEstacionLinea(String cdgoEstacion) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService
					.getDescTipoAmbitoEstacionLinea(cdgoEstacion);

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDescTipoAmbitoEstacionLinea []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-orden-by-lineas-estaciones-list")
	public ResponseEntity<List<Tbasg128EstaclineDto>> getOrdenByLineasEstacionesList(/** FIXME revisar tipo */
	Object cdgoLinea, /** FIXME revisar tipo */
	Object cdgoOrden, /** FIXME revisar tipo */
	Object cdgoOrden_2) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService
					.getOrdenByLineasEstacionesList(cdgoLinea, cdgoOrden, cdgoOrden_2);

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getOrdenByLineasEstacionesList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-orden-by-estacion")
	public ResponseEntity<?> getOrdenByEstacion(/** FIXME revisar tipo */
	Object cdgoLinea, /** FIXME revisar tipo */
	Object cdgoEstacion) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService.getOrdenByEstacion(cdgoLinea,
					cdgoEstacion);

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getOrdenByEstacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-entor-line-orden-origen-destino")
	public ResponseEntity<List<Tbasg128EstaclineDto>> getEntorLineOrdenOrigenDestino(String cdgoEntorno,
			String cdgoLinea) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService
					.getEntorLineOrdenOrigenDestino(cdgoEntorno, cdgoLinea);

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEntorLineOrdenOrigenDestino []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estac-line-list")
	public ResponseEntity<List<Tbasg128EstaclineDto>> getEstacLineList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService.getEstacLineList();

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstacLineList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estac-line-count")
	public ResponseEntity<?> getEstacLineCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService.getEstacLineCount();

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstacLineCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estac-line-count-by-line")
	public ResponseEntity<?> getEstacLineCountByLine(String cdgoLinea) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService
					.getEstacLineCountByLine(cdgoLinea);

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstacLineCountByLine []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estac-line-count-by-estacion")
	public ResponseEntity<?> getEstacLineCountByEstacion(String cdgoEstacion) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService
					.getEstacLineCountByEstacion(cdgoEstacion);

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstacLineCountByEstacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estac-line-list-ascendente")
	public ResponseEntity<List<Tbasg128EstaclineDto>> getEstacLineListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService.getEstacLineListAscendente();

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstacLineListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-estac-line-list-asc-cdgo-linea")
	public ResponseEntity<List<Tbasg128EstaclineDto>> getEstacLineListAscCdgoLinea(String cdgoLinea) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService.getEstacLineListAscCdgoLinea(cdgoLinea);

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstacLineListAscCdgoLinea []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estac-line-list-descendente")
	public ResponseEntity<List<Tbasg128EstaclineDto>> getEstacLineListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService.getEstacLineListDescendente();

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstacLineListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estac-line-active-list-ascendente")
	public ResponseEntity<List<Tbasg128EstaclineDto>> getEstacLineActiveListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService
					.getEstacLineActiveListAscendente();

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstacLineActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estac-line-active-list-descendente")
	public ResponseEntity<List<Tbasg128EstaclineDto>> getEstacLineActiveListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService
					.getEstacLineActiveListDescendente();

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstacLineActiveListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estac-line-max")
	public ResponseEntity<List<Tbasg128EstaclineDto>> getEstacLineMax(String cdgoLinea) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService.getEstacLineMax(cdgoLinea);

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstacLineMax []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-estac-line-nombre")
	public ResponseEntity<List<Tbasg128EstaclineDto>> getEstacLineNombre(String cdgoLinea) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService.getEstacLineNombre(cdgoLinea);

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstacLineNombre []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estac-line-min")
	public ResponseEntity<List<Tbasg128EstaclineDto>> getEstacLineMin(String cdgoLinea) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService.getEstacLineMin(cdgoLinea);

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstacLineMin []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estac-line-max-by-orden")
	public ResponseEntity<?> getEstacLineMaxByOrden(String cdgoLinea) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService
					.getEstacLineMaxByOrden(cdgoLinea);

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstacLineMaxByOrden []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estac-line-min-by-orden")
	public ResponseEntity<?> getEstacLineMinByOrden(String cdgoLinea) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService
					.getEstacLineMinByOrden(cdgoLinea);

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstacLineMinByOrden []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estac-line-list-by-line-desc")
	public ResponseEntity<List<Tbasg128EstaclineDto>> getEstacLineListByLineDesc(String cdgoLinea) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService
					.getEstacLineListByLineDesc(cdgoLinea);

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstacLineListByLineDesc []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estac-line")
	public ResponseEntity<List<Tbasg128EstaclineDto>> getEstacLine(String cdgoEstacion, String cdgoLinea) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService.getEstacLine(cdgoEstacion,
					cdgoLinea);

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstacLine []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estac-line-tramo-by-p-k-asc")
	public ResponseEntity<List<Tbasg128EstaclineDto>> getEstacLineTramoByPKAsc(String cdgoLinea, String cdgoOrigen, String cdgoDestino) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService
					.getEstacLineTramoByPKAsc(cdgoLinea, cdgoOrigen, cdgoDestino);

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstacLineTramoByPKAsc []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estac-line-list-by-line-asc")
	public ResponseEntity<List<Tbasg128EstaclineDto>> getEstacLineListByLineAsc(String cdgoLinea) {
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService.getEstacLineListByLineAsc(cdgoLinea);
			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("getEstacLineListByLineAsc []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estac-line-list-by-estacion-asc")
	public ResponseEntity<List<Tbasg128EstaclineDto>> getEstacLineListByEstacionAsc(String cdgoEstacion) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService
					.getEstacLineListByEstacionAsc(cdgoEstacion);

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstacLineListByEstacionAsc []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estac-line-list-by-estacion-desc")
	public ResponseEntity<List<Tbasg128EstaclineDto>> getEstacLineListByEstacionDesc(String cdgoEstacion) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService
					.getEstacLineListByEstacionDesc(cdgoEstacion);

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstacLineListByEstacionDesc []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estac-line-list-active")
	public ResponseEntity<List<Tbasg128EstaclineDto>> getEstacLineListActive() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg128EstaclineDto> tbasg128EstaclineDto = tbasg128EstaclineService.getEstacLineListActive();

			if (tbasg128EstaclineDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstacLineListActive []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-estac-line")
	public ResponseEntity<?> insertEstacLine(@RequestBody Tbasg128Estacline bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg128EstaclineDto = tbasg128EstaclineService.insertEstacLine(bean);
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertEstacLine []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-estac-line")
	public ResponseEntity<?> updateEstacLine(@RequestBody Tbasg128Estacline bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg128EstaclineDto = tbasg128EstaclineService.updateEstacLine(bean);
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateEstacLine []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update-estac-line-cdgo-orden")
	public ResponseEntity<?> updateEstacLineCdgoOrden(@RequestBody Tbasg128Estacline bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg128EstaclineDto = tbasg128EstaclineService.updateEstacLineCdgoOrden(bean);
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateEstacLineCdgoOrden []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-estac-line")
	public ResponseEntity<?> estadoEstacLine(@RequestBody Tbasg128Estacline bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg128EstaclineDto = tbasg128EstaclineService.estadoEstacLine(bean);
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoEstacLine []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-estac-line")
	public ResponseEntity<?> deleteEstacLine(Tbasg128Estacline bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg128EstaclineDto = tbasg128EstaclineService.deleteEstacLine(bean);
			return new ResponseEntity<>(tbasg128EstaclineDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteEstacLine []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
