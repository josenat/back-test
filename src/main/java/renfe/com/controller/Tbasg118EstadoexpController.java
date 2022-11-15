package renfe.com.controller;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

import renfe.com.dto.CountGetTramosDTO;
import renfe.com.dto.GetEstadosMasExpDTO;
import renfe.com.dto.GetFechaExpFiltradaDTO;
import renfe.com.dto.GetFechaOtorgamientoDTO;
import renfe.com.dto.GetMaxEntornosExpCodListDTO;
import renfe.com.dto.GetMaxEntornosExpListCodigosDTO;
import renfe.com.dto.GetMaxEstaHabInListDTO;
import renfe.com.dto.GetTramoListByCdgoExpDTO;
import renfe.com.dto.GetTramosOrderByCodLineaDTO;
import renfe.com.dto.ParamCountGetTramos;
import renfe.com.model.dto.GetExpedientesPersonaCursoListDTO;

import renfe.com.model.dto.Tbasg118EstadoexpDto;
import renfe.com.model.entity.Tbasg118Estadoexp;
import renfe.com.pdf.beans.OrdenActivacionBean;
import renfe.com.pdf.beans.OrdenSuspensionBean;
import renfe.com.pdf.core.DownloadPdf;
import renfe.com.service.Tbasg118EstadoexpService;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
@RequestMapping("asg/api/tbasg118Estadoexp")
public class Tbasg118EstadoexpController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg118EstadoexpService tbasg118EstadoexpService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg118EstadoexpDto>> getAllTbasg118Estadoexp(Tbasg118EstadoexpDto filter) {
		return new ResponseEntity<>(tbasg118EstadoexpService.getAllTbasg118Estadoexp(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoEstado}/{cdgoExpedient}/{fchaEstado}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoEstado") Integer cdgoEstado,
			@PathVariable("cdgoExpedient") Integer cdgoExpedient, @PathVariable("fchaEstado") Date fchaEstado) {
		Tbasg118EstadoexpDto tbasg118EstadoexpData = tbasg118EstadoexpService
				.findByCdgoEstadoCdgoExpedientFchaEstado(cdgoEstado, cdgoExpedient, fchaEstado);

		if (tbasg118EstadoexpData != null) {
			return new ResponseEntity<>(tbasg118EstadoexpData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg118EstadoexpDto> createTbasg118Estadoexp(
			@RequestBody Tbasg118EstadoexpDto tbasg118EstadoexpDto) {
		try {
			return new ResponseEntity<>(tbasg118EstadoexpService.createTbasg118Estadoexp(tbasg118EstadoexpDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg118Estadoexp {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoEstado}/{cdgoExpedient}/{fchaEstado}")
	public ResponseEntity<Tbasg118EstadoexpDto> updateTbasg118Estadoexp(@PathVariable("cdgoEstado") Integer cdgoEstado,
			@PathVariable("cdgoExpedient") Integer cdgoExpedient, @PathVariable("fchaEstado") Date fchaEstado,
			@RequestBody Tbasg118EstadoexpDto tbasg118EstadoexpDto) {
		try {
			Tbasg118EstadoexpDto tbasg118EstadoexpData = tbasg118EstadoexpService.updateTbasg118Estadoexp(cdgoEstado,
					cdgoExpedient, fchaEstado, tbasg118EstadoexpDto);
			if (tbasg118EstadoexpData != null) {
				return new ResponseEntity<>(tbasg118EstadoexpData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg118Estadoexp []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoEstado}/{cdgoExpedient}/{fchaEstado}")
	public ResponseEntity<HttpStatus> deleteTbasg118Estadoexp(@PathVariable("cdgoEstado") Integer cdgoEstado,
			@PathVariable("cdgoExpedient") Integer cdgoExpedient, @PathVariable("fchaEstado") Date fchaEstado) {
		try {
			tbasg118EstadoexpService.deleteTbasg118Estadoexp(cdgoEstado, cdgoExpedient, fchaEstado);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg118Estadoexp []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg118EstadoexpDto>> findByCdgoEstadoCdgoExpedientFchaEstadoIn(
			List<Integer> cdgoEstado, List<Integer> cdgoExpedient, List<Date> fchaEstado) {
		try {
			List<Tbasg118EstadoexpDto> tbasg118EstadoexpDto = tbasg118EstadoexpService
					.findByCdgoEstadoCdgoExpedientFchaEstadoIn(cdgoEstado, cdgoExpedient, fchaEstado);

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoEstadoCdgoExpedientFchaEstadoIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tramos-exp-infr")
	public ResponseEntity<List<Tbasg118EstadoexpDto>> getTramosExpInfr(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg118EstadoexpDto> tbasg118EstadoexpDto = tbasg118EstadoexpService.getTramosExpInfr(cdgoExpedient);

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTramosExpInfr []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tramos-exp-infr-with-out-state")
	public ResponseEntity<List<Tbasg118EstadoexpDto>> getTramosExpInfrWithOutState(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg118EstadoexpDto> tbasg118EstadoexpDto = tbasg118EstadoexpService
					.getTramosExpInfrWithOutState(cdgoExpedient);

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTramosExpInfrWithOutState []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-max-esta-hab-in-list")
	public ResponseEntity<List<GetMaxEstaHabInListDTO>> getMaxEstaHabInList(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<GetMaxEstaHabInListDTO> tbasg118EstadoexpDto = tbasg118EstadoexpService
					.getMaxEstaHabInList(cdgoExpedient);

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getMaxEstaHabInList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-estado-exp-by-cdgo-exp")
	public ResponseEntity<List<Tbasg118EstadoexpDto>> findEstadoExpByCdgoExp(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg118EstadoexpDto> tbasg118EstadoexpDto = tbasg118EstadoexpService
					.findEstadoExpByCdgoExp(cdgoExpedient);

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findEstadoExpByCdgoExp []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-fecha-suspension-reactivacion-exp-by-cdgo-exp")
	public ResponseEntity<List<Tbasg118EstadoexpDto>> findFechaSuspensionReactivacionExpByCdgoExp(
			String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg118EstadoexpDto> tbasg118EstadoexpDto = tbasg118EstadoexpService
					.findFechaSuspensionReactivacionExpByCdgoExp(cdgoExpedient);

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findFechaSuspensionReactivacionExpByCdgoExp []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-todos-estados-exps-susp-sancion-by-cdgo-exp")
	public ResponseEntity<List<Tbasg118EstadoexpDto>> findTodosEstadosExpsSuspSancionByCdgoExp(Integer cdgoExpediente) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg118EstadoexpDto> tbasg118EstadoexpDto = tbasg118EstadoexpService
					.findTodosEstadosExpsSuspSancionByCdgoExp(cdgoExpediente);

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findTodosEstadosExpsSuspSancionByCdgoExp []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-estados-mas-exp")
	public ResponseEntity<List<GetEstadosMasExpDTO>> getEstadosMasExp(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<GetEstadosMasExpDTO> tbasg118EstadoexpDto = tbasg118EstadoexpService.getEstadosMasExp(cdgoExpedient);

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstadosExp []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estados-exp")
	public ResponseEntity<List<Tbasg118EstadoexpDto>> getEstadosExp(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg118EstadoexpDto> tbasg118EstadoexpDto = tbasg118EstadoexpService.getEstadosExp(cdgoExpedient);

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstadosExp []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estados-exp-max-fecha")
	public ResponseEntity<List<Tbasg118EstadoexpDto>> getEstadosExpMaxFecha(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg118EstadoexpDto> tbasg118EstadoexpDto = tbasg118EstadoexpService
					.getEstadosExpMaxFecha(cdgoExpedient);

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstadosExpMaxFecha []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estados-exps-max-fecha")
	public ResponseEntity<List<Tbasg118EstadoexpDto>> getEstadosExpsMaxFecha(List expedients) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg118EstadoexpDto> tbasg118EstadoexpDto = tbasg118EstadoexpService.getEstadosExpsMaxFecha(expedients);

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstadosExpsMaxFecha []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estados-exp-max-fecha-todo")
	public ResponseEntity<List<Tbasg118EstadoexpDto>> getEstadosExpMaxFechaTodo(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg118EstadoexpDto> tbasg118EstadoexpDto = tbasg118EstadoexpService
					.getEstadosExpMaxFechaTodo(cdgoExpedient);

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstadosExpMaxFechaTodo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estados-exps-todos-max-fecha")
	public ResponseEntity<List<Tbasg118EstadoexpDto>> getEstadosExpsTodosMaxFecha() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg118EstadoexpDto> tbasg118EstadoexpDto = tbasg118EstadoexpService.getEstadosExpsTodosMaxFecha();

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstadosExpsTodosMaxFecha []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estado-exp-list")
	public ResponseEntity<List<Tbasg118EstadoexpDto>> getEstadoExpList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg118EstadoexpDto> tbasg118EstadoexpDto = tbasg118EstadoexpService.getEstadoExpList();

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstadoExpList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional
	@GetMapping("/insert-estado-exp")
	public ResponseEntity<?> insertEstadoExp(Integer cdgoExpediente, Integer cdgoEstado, String desgUsuact, String mrcaActivo) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg118EstadoexpDto = tbasg118EstadoexpService.insertEstadoExp(cdgoExpediente, cdgoEstado, desgUsuact, mrcaActivo);
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertEstadoExp []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-estado-expediente")
	public ResponseEntity<?> updateEstadoExpediente(Tbasg118Estadoexp bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg118EstadoexpDto = tbasg118EstadoexpService.updateEstadoExpediente(bean);
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateEstadoExpediente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-expedientes-persona-curso-list")
	public ResponseEntity<List<GetExpedientesPersonaCursoListDTO>> getExpedientesPersonaCursoList() {
		// Generated from a SELECT found in an XML
		try {
			List<GetExpedientesPersonaCursoListDTO> tbasg118EstadoexpDto = tbasg118EstadoexpService.getExpedientesPersonaCursoList();

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExpedientesPersonaCursoList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-max-entornos-exp-list-codigos")
	public ResponseEntity<List<GetMaxEntornosExpListCodigosDTO>> getMaxEntornosExpListCodigos(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<GetMaxEntornosExpListCodigosDTO> tbasg118EstadoexpDto = tbasg118EstadoexpService.getMaxEntornosExpListCodigos(cdgoExpedient);

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getMaxEntornosExpListCodigos []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-max-entornos-exp-cod-list")
	public ResponseEntity<List<GetMaxEntornosExpCodListDTO>> getMaxEntornosExpCodList(Integer cdgoExpediente, Integer cdgoEstado) {
		// Generated from a SELECT found in an XML
		try {
			List<GetMaxEntornosExpCodListDTO> tbasg118EstadoexpDto = tbasg118EstadoexpService.getMaxEntornosExpCodList(cdgoExpediente,cdgoEstado);

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getMaxEntornosExpCodList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fecha-otorgamiento")
	public ResponseEntity<List<GetFechaOtorgamientoDTO>> getFechaOtorgamiento(Integer cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<GetFechaOtorgamientoDTO> tbasg118EstadoexpDto = tbasg118EstadoexpService
					.getFechaOtorgamiento(cdgoExpedient);

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFechaOtorgamiento []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tramo-list-bycdgo-exp")
	public ResponseEntity<List<GetTramoListByCdgoExpDTO>> getTramoListByCdgoExp(Integer cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<GetTramoListByCdgoExpDTO> tbasg118EstadoexpDto = tbasg118EstadoexpService
					.getTramoListByCdgoExp(cdgoExpedient);

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTramoListByCdgoExp []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fechas-otorgamiento")
	public ResponseEntity<List<Tbasg118EstadoexpDto>> getFechasOtorgamiento(List<Integer> cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg118EstadoexpDto> tbasg118EstadoexpDto = tbasg118EstadoexpService.getFechasOtorgamiento(cdgoExpedient);

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFechasOtorgamiento []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fecha-exp-filtrada")
	public ResponseEntity<?> getFechaExpFiltrada(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<GetFechaExpFiltradaDTO> tbasg118EstadoexpDto = tbasg118EstadoexpService.getFechaExpFiltrada(cdgoPersona);

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFechaExpFiltrada []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-tramos-order-by-cod-linea")
	public ResponseEntity<List<GetTramosOrderByCodLineaDTO>> getTramosOrderByCodLinea(List<Integer> cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<GetTramosOrderByCodLineaDTO> tbasg118EstadoexpDto = tbasg118EstadoexpService.getTramosOrderByCodLinea(cdgoExpedient);

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFechaExpFiltrada []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-fechas-otorgamiento-pb")
	public ResponseEntity<List<GetTramosOrderByCodLineaDTO>> getFechasOtorgamientoPB(List<Integer> cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<GetTramosOrderByCodLineaDTO> tbasg118EstadoexpDto = tbasg118EstadoexpService.getFechasOtorgamientoPB(cdgoExpedient);

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFechaExpFiltrada []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-count-get-tramos")
	public ResponseEntity<List<CountGetTramosDTO>> countGetTramos(ParamCountGetTramos filtro) {
		// Generated from a SELECT found in an XML
		try {
			List<CountGetTramosDTO> tbasg118EstadoexpDto = tbasg118EstadoexpService.countGetTramos(filtro);

			if (tbasg118EstadoexpDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg118EstadoexpDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFechaExpFiltrada []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/get-generar-pdf-suspension")
	public void getGenerarPdfSuspension(@RequestBody OrdenSuspensionBean suspensionData, HttpServletResponse response) {		
		try {			
			logger.debug("-----> getGenerarPdfSuspension {}", suspensionData);

			DownloadPdf downloadPdf = new DownloadPdf();							
			downloadPdf.ordenSuspension(suspensionData, response);
		
		} catch (Exception e) {
			logger.debug("getGenerarPdfSuspension []", e);
			logger.debug("ERROR {}",e);
		}
	}

	@PostMapping("/get-generar-pdf-activacion")
	public void getGenerarPdfActivacion(@RequestBody OrdenActivacionBean activationData, HttpServletResponse response) {		
		try {						
			logger.debug("-----> getGenerarPdfActivacion {}", activationData);

			DownloadPdf downloadPdf = new DownloadPdf();							
			downloadPdf.ordenActivacion(activationData, response);
		
		} catch (Exception e) {
			logger.debug("getGenerarPdfActivacion []", e);
			logger.debug("ERROR {}",e);
		}
	}	

}
