package renfe.com.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.transaction.Transactional;



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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import renfe.com.dto.DataGetExpedientesPersonaListDTO;
import renfe.com.dto.GetEstadoListDTO;
import renfe.com.dto.GetExpByCdgoPersonaAndCdgoExpedientDTO;
import renfe.com.dto.GetExpeTipoValidezReciclajeDTO;
import renfe.com.dto.GetExpedientesPersonaDTO;
import renfe.com.dto.GetExpedientesPersonaLtDTO;
import renfe.com.dto.GetExpedientesPersonaParam;
import renfe.com.dto.GetFechaFinValidezDTO;
import renfe.com.dto.GetFindFchaExpedienteOtorgadoParaAotDTO;
import renfe.com.dto.GetfindFchaHabilitacionParaAotDTO;
import renfe.com.dto.ParamExpedientesPersonaListDTO;
import renfe.com.dto.SetMaxEstadoHabilitaList;

import renfe.com.model.dto.Tbasg104ExpedientDto;
import renfe.com.model.dto.Tbasg260HabilifuncDto;
import renfe.com.model.entity.Tbasg104Expedient;
import renfe.com.model.entity.Tbasg106Provincia;
import renfe.com.model.entity.Tbasg260Habilifunc;
import renfe.com.pdf.core.DownloadPdf;
import renfe.com.service.Tbasg104ExpedientService;

import renfe.com.service.Tbasg260HabilifuncService;
import renfe.com.service.Tbasg104ExpedientServiceImpl;
import renfe.com.util.DownloadPdfCts;


@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg104Expedient")
public class Tbasg104ExpedientController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg104ExpedientService tbasg104ExpedientService;
	
	@Autowired
	private Tbasg260HabilifuncService tbasg260HabilifuncService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg104ExpedientDto>> getAllTbasg104Expedient(Tbasg104ExpedientDto filter) {
		return new ResponseEntity<>(tbasg104ExpedientService.getAllTbasg104Expedient(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoExpedient}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoExpedient") Integer cdgoExpedient) {
		Tbasg104ExpedientDto tbasg104ExpedientData = tbasg104ExpedientService.findByCdgoExpedient(cdgoExpedient);

		if (tbasg104ExpedientData != null) {
			return new ResponseEntity<>(tbasg104ExpedientData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg104ExpedientDto> createTbasg104Expedient(
			@RequestBody Tbasg104ExpedientDto tbasg104ExpedientDto) {
		try {
			return new ResponseEntity<>(tbasg104ExpedientService.createTbasg104Expedient(tbasg104ExpedientDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg104Expedient {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoExpedient}")
	public ResponseEntity<Tbasg104ExpedientDto> updateTbasg104Expedient(@PathVariable("cdgoExpedient") Integer cdgo,
			@RequestBody Tbasg104ExpedientDto body) {
		try {
			Tbasg104ExpedientDto tbasg104ExpedientData = tbasg104ExpedientService.updateTbasg104Expedient(cdgo, body);
			if (tbasg104ExpedientData != null) {
				return new ResponseEntity<>(tbasg104ExpedientData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg104Expedient []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoExpedient}")
	public ResponseEntity<HttpStatus> deleteTbasg104Expedient(@PathVariable("cdgoExpedient") Integer cdgoExpedient) {
		try {
			tbasg104ExpedientService.deleteTbasg104Expedient(cdgoExpedient);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg104Expedient []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg104ExpedientDto>> findByCdgoExpedientIn(List<Integer> cdgoExpedient) {
		try {
			List<Tbasg104ExpedientDto> tbasg104ExpedientDto = tbasg104ExpedientService
					.findByCdgoExpedientIn(cdgoExpedient);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoExpedientIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tramos-persona")
	public ResponseEntity<List<Tbasg104ExpedientDto>> getTramosPersona(String cdgoPersona, String cdgoEmpresa,
			String cdgoTipohab, String cdgoEntorno) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg104ExpedientDto> tbasg104ExpedientDto = tbasg104ExpedientService.getTramosPersona(cdgoPersona,
					cdgoEmpresa, cdgoTipohab, cdgoEntorno);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTramosPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-tramos-persona-sin-tramo")
	public ResponseEntity<List<Tbasg104ExpedientDto>> getTramosPersonaSinTramo(String cdgoPersona, String cdgoEmpresa,
			String cdgoTipohab, String cdgoEntorno) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg104ExpedientDto> tbasg104ExpedientDto = tbasg104ExpedientService
					.getTramosPersonaSinTramo(cdgoPersona, cdgoEmpresa, cdgoTipohab, cdgoEntorno);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTramosPersonaSinTramo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fcha-prox-rev-list")
	public ResponseEntity<?> getFchaProxRevList(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg104ExpedientDto> tbasg104ExpedientDto = tbasg104ExpedientService
					.getFchaProxRevList(cdgoExpedient);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFchaProxRevList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fcha-prox-curso-list")
	public ResponseEntity<?> getFchaProxCursoList(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg104ExpedientDto> tbasg104ExpedientDto = tbasg104ExpedientService
					.getFchaProxCursoList(cdgoExpedient);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFchaProxCursoList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-max-estado-exp-list-count")
	public ResponseEntity<?> getMaxEstadoExpListCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg104ExpedientDto> tbasg104ExpedientDto = tbasg104ExpedientService.getMaxEstadoExpListCount();

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getMaxEstadoExpListCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-previous-estado-exp-list")
	public ResponseEntity<?> getPreviousEstadoExpList(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg104ExpedientDto> tbasg104ExpedientDto = tbasg104ExpedientService
					.getPreviousEstadoExpList(cdgoExpedient);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPreviousEstadoExpList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-exp-persona-object")
	public ResponseEntity<List<Tbasg104ExpedientDto>> getExpPersonaObject(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg104ExpedientDto> tbasg104ExpedientDto = tbasg104ExpedientService
					.getExpPersonaObject(cdgoExpedient);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExpPersonaObject []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-historicos-estados-exp")
	public ResponseEntity<List<Tbasg104ExpedientDto>> getHistoricosEstadosExp(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg104ExpedientDto> tbasg104ExpedientDto = tbasg104ExpedientService
					.getHistoricosEstadosExp(cdgoExpedient);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getHistoricosEstadosExp []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-maq-by-lineas-estaciones-list")
	public ResponseEntity<List<Tbasg104ExpedientDto>> getMaqByLineasEstacionesList(/** FIXME revisar tipo */
	Object cdgoLinea) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg104ExpedientDto> tbasg104ExpedientDto = tbasg104ExpedientService
					.getMaqByLineasEstacionesList(cdgoLinea);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getMaqByLineasEstacionesList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cdgo-persona-by-exp")
	public ResponseEntity<?> getCdgoPersonaByExp(Integer cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg104ExpedientDto> tbasg104ExpedientDto = tbasg104ExpedientService
					.getCdgoPersonaByExp(cdgoExpedient);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCdgoPersonaByExp []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-expediente")
	public ResponseEntity<List<Tbasg104ExpedientDto>> getExpediente(Integer cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg104ExpedientDto> tbasg104ExpedientDto = tbasg104ExpedientService.getExpediente(cdgoExpedient);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExpediente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-expe-tipo-validez-reciclaje")
	public ResponseEntity<List<GetExpeTipoValidezReciclajeDTO>> getExpeTipoValidezReciclaje(Integer cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<GetExpeTipoValidezReciclajeDTO> tbasg104ExpedientDto = tbasg104ExpedientService
					.getExpeTipoValidezReciclaje(cdgoExpedient);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExpeTipoValidezReciclaje []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-expedientes-by-cdgo-exp")
	public ResponseEntity<List<Tbasg104ExpedientDto>> getExpedientesByCdgoExp(List<Integer> cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg104ExpedientDto> tbasg104ExpedientDto = tbasg104ExpedientService.getExpedientesByCdgoExp(cdgoExpedient);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExpedientesByCdgoExp []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-expedientes-by-cdgoPersona-cdgoExpediente")
	public ResponseEntity<List<GetExpByCdgoPersonaAndCdgoExpedientDTO>> getExpByCdgoPersonaAndCdgoExpedient(Integer cdgoPersona, Integer cdgoExpediente) {
		// Generated from a SELECT found in an XML
		try {
			List<GetExpByCdgoPersonaAndCdgoExpedientDTO> tbasg104ExpedientDto = tbasg104ExpedientService.getExpByCdgoPersonaAndCdgoExpedient(cdgoPersona, cdgoExpediente);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExpedientesPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-expedientes-persona")
	public ResponseEntity<List<Tbasg104ExpedientDto>> getExpedientesPersona(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg104ExpedientDto> tbasg104ExpedientDto = tbasg104ExpedientService
					.getExpedientesPersona(cdgoPersona);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExpedientesPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-expedientes-persona-todo")
	public ResponseEntity<List<Tbasg104ExpedientDto>> getExpedientesPersonaTodo(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg104ExpedientDto> tbasg104ExpedientDto = tbasg104ExpedientService
					.getExpedientesPersonaTodo(cdgoPersona);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExpedientesPersonaTodo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-expedientes-persona-list")

	public ResponseEntity<List<DataGetExpedientesPersonaListDTO>> getExpedientesPersonaList(
			ParamExpedientesPersonaListDTO filtro) {

		// Generated from a SELECT found in an XML
		try {
			List<DataGetExpedientesPersonaListDTO> tbasg104ExpedientDto = tbasg104ExpedientService
					.getExpedientesPersonaList(filtro);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExpedientesPersonaList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-expedientes-persona-list-filtro")

	public ResponseEntity<List<DataGetExpedientesPersonaListDTO>> getExpedientesFiltro(
			ParamExpedientesPersonaListDTO filtro) {

		// Generated from a SELECT found in an XML
		try {
			List<DataGetExpedientesPersonaListDTO> tbasg104ExpedientDto = tbasg104ExpedientService
					.getExpedientesFiltro(filtro);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExpedientesFiltro []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-expedientes-persona-list-count")
	public ResponseEntity<?> getExpedientesPersonaListCount(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg104ExpedientDto> tbasg104ExpedientDto = tbasg104ExpedientService
					.getExpedientesPersonaListCount(cdgoPersona);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExpedientesPersonaListCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/get-exist-habilitacion")
	public ResponseEntity<Integer> getExistHabilitacion(@RequestBody Tbasg104ExpedientDto bean) {
		try {
			int result = tbasg104ExpedientService.getExistHabilitacion(bean);
			return new ResponseEntity<>(result, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("getExistHabilitacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-expedientes-persona-param")
	public ResponseEntity<List<GetExpedientesPersonaDTO>> getExpedientesPersonaParam(GetExpedientesPersonaParam filter) {
		// Generated from a SELECT found in an XML
		try {
			List<GetExpedientesPersonaDTO> tbasg104ExpedientDto = tbasg104ExpedientService.getExpedientesPersonaParam(filter);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExpedientesPersonaParam []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-expedientes-persona-list-cod")
	public ResponseEntity<List<GetExpedientesPersonaLtDTO>> getExpedientesPersonaListCod(String cdgoPersona, Integer cdgoEstado) {
		// Generated from a SELECT found in an XML
		try {
			List<GetExpedientesPersonaLtDTO> tbasg104ExpedientDto = tbasg104ExpedientService.getExpedientesPersonaListCod(cdgoPersona, cdgoEstado);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExpedientesPersonaListCod []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-expedientes-persona-list-cod-user-baja")
	public ResponseEntity<List<GetExpedientesPersonaLtDTO>> getExpedientesPersonaListCodUserBaja(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<GetExpedientesPersonaLtDTO> tbasg104ExpedientDto = tbasg104ExpedientService
					.getExpedientesPersonaListCodUserBaja(cdgoPersona);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExpedientesPersonaListCodUserBaja []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-expedient-by-cdgo-persona-and-tipo-hab")
	public ResponseEntity<List<Tbasg104ExpedientDto>> findExpedientByCdgoPersonaAndTipoHab(String cdgoPersona, @RequestParam List<Integer>listaCodigosHab) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg104ExpedientDto> tbasg104ExpedientDto = tbasg104ExpedientService
					.findExpedientByCdgoPersonaAndTipoHab(cdgoPersona,listaCodigosHab);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findExpedientByCdgoPersonaAndTipoHab []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-fcha-expediente-para-a-o-t")
	public ResponseEntity<List<GetFindFchaExpedienteOtorgadoParaAotDTO>> findFchaExpedienteParaAOT(Integer cdgoPersona, Integer cdgoTipohab,
			Integer cdgoAlcanceot) {
		// Generated from a SELECT found in an XML
		try {
			List<GetFindFchaExpedienteOtorgadoParaAotDTO> tbasg104ExpedientDto = tbasg104ExpedientService
					.findFchaExpedienteParaAOT(cdgoPersona, cdgoTipohab, cdgoAlcanceot);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findFchaExpedienteParaAOT []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-fcha-expediente-otorgado-para-a-o-t")
	public ResponseEntity<List<GetFindFchaExpedienteOtorgadoParaAotDTO>> findFchaExpedienteOtorgadoParaAOT(Integer cdgoPersona,
			Integer cdgoTipohab, Integer cdgoAlcanceot) {
		// Generated from a SELECT found in an XML
		try {
			List<GetFindFchaExpedienteOtorgadoParaAotDTO> tbasg104ExpedientDto = tbasg104ExpedientService
					.findFchaExpedienteOtorgadoParaAOT(cdgoPersona, cdgoTipohab, cdgoAlcanceot);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findFchaExpedienteOtorgadoParaAOT []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-fcha-habilitacion-para-a-o-t")
	public ResponseEntity<?> findFchaHabilitacionParaAOT(Integer cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<GetfindFchaHabilitacionParaAotDTO> tbasg104ExpedientDto = tbasg104ExpedientService
					.findFchaHabilitacionParaAOT(cdgoExpedient);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findFchaHabilitacionParaAOT []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-fcha-fin-validez")
	public ResponseEntity<List<GetFechaFinValidezDTO>> getFechaFinValidez(Integer cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<GetFechaFinValidezDTO> tbasg104ExpedientDto = tbasg104ExpedientService
					.getFechaFinValidez(cdgoExpedient);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFechaFinValidez []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-fcha-fin-validez2")
	public ResponseEntity<List<GetFechaFinValidezDTO>> getFechaFinValidez2(Integer cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<GetFechaFinValidezDTO> tbasg104ExpedientDto = tbasg104ExpedientService
					.getFechaFinValidez2(cdgoExpedient);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFechaFinValidez2 []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-fcha-fin-validez3")
	public ResponseEntity<List<GetFechaFinValidezDTO>> getFechaFinValidez3(Integer cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<GetFechaFinValidezDTO> tbasg104ExpedientDto = tbasg104ExpedientService
					.getFechaFinValidez3(cdgoExpedient);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFechaFinValidez3 []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-expedient-by-cdgo-persona-and-linea")
	public ResponseEntity<List<Tbasg104ExpedientDto>> findExpedientByCdgoPersonaAndLinea(String cdgoPersona,
			String cdgoTipohab) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg104ExpedientDto> tbasg104ExpedientDto = tbasg104ExpedientService
					.findExpedientByCdgoPersonaAndLinea(cdgoPersona, cdgoTipohab);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findExpedientByCdgoPersonaAndLinea []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-observa-ext")
	public ResponseEntity<List<Tbasg104ExpedientDto>> getObservaExt(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg104ExpedientDto> tbasg104ExpedientDto = tbasg104ExpedientService.getObservaExt(cdgoPersona);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getObservaExt []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-expediente")
	public ResponseEntity<Integer> insertExpediente(@RequestBody Tbasg104ExpedientDto bean) {
		try {
			int tbasg104ExpedientDto = tbasg104ExpedientService.insertExpediente(bean);
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("insertExpediente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	@GetMapping("/update-expedient-ext")
	public ResponseEntity<?> updateExpedientExt(String descObservaExt, String descObserva, Character marcaActivo, String descUsuact, Integer cdgoPersona, Integer cdgoExpediente) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg104ExpedientDto = tbasg104ExpedientService.updateExpedientExt(descObservaExt, descObserva, marcaActivo, descUsuact, cdgoPersona, cdgoExpediente);
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateExpedient []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-expedient")
	public ResponseEntity<Integer> updateExpedient(@RequestBody Tbasg104ExpedientDto bean) {
		try {
			int tbasg104ExpedientDto = tbasg104ExpedientService.updateExpedient(bean);
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("updateExpedient []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-expedient-mantenimiento")
	public ResponseEntity<?> updateExpedientMantenimiento(Tbasg104Expedient bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg104ExpedientDto = tbasg104ExpedientService.updateExpedientMantenimiento(bean);
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateExpedientMantenimiento []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-expedient-b")
	public ResponseEntity<?> updateExpedientB(Tbasg104Expedient bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg104ExpedientDto = tbasg104ExpedientService.updateExpedientB(bean);
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateExpedientB []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/delete-expedient")
	public ResponseEntity<?> deleteExpedient(@RequestBody Tbasg104Expedient bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg104ExpedientDto = tbasg104ExpedientService.deleteExpedient(bean);
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteExpedient []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update-empresa-expedient")
	public ResponseEntity<?> updateEmpresaExpedient(@RequestBody Tbasg104Expedient bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg104ExpedientDto = tbasg104ExpedientService.updateEmpresaExpedient(bean);
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateEmpresaExpedient []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-max-estado-exp-count")
	public ResponseEntity<?> getMaxEstadoExpCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg104ExpedientDto> tbasg104ExpedientDto = tbasg104ExpedientService.getMaxEstadoExpCount();

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getMaxEstadoExpCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-estado-list")
	public ResponseEntity<List<GetEstadoListDTO>> getEstadoList(SetMaxEstadoHabilitaList mapPending) {
		// Generated from a SELECT found in an XML
		try {
			List<GetEstadoListDTO> tbasg104ExpedientDto = tbasg104ExpedientService.getEstadoList(mapPending);

			if (tbasg104ExpedientDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg104ExpedientDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEstadoList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-generar-pdf-cert-compl")
	public void getGenerarPdfCertCompl(String cdgoPersona, String cdgoIdioma, HttpServletResponse response) {

		try {

			Object tbasg104ExpedientDto = tbasg104ExpedientService
					.getCertificadoComplementarioActionDoExecute(cdgoPersona);

			DownloadPdf downloadPdf = new DownloadPdf();

			downloadPdf.certificadoComplementario(cdgoIdioma, response, tbasg104ExpedientDto);

		} catch (Exception e) {
			logger.debug("getGenerarPdfCertCompl []", e);
			logger.debug("ERRORRR {}", e);
		}
	}

	@GetMapping("/get-generar-pdf-cert-compl-aot")
	public void getGenerarPdfCertComplAot(String cdgoPersona, String cdgoIdioma, String cdgoTipoHabi, HttpServletResponse response) {

		try {

			//  Tengo que recuperar el idioma y los tipos de habilitacion

			String[] valores = cdgoTipoHabi.split("\\$");
			int num = valores.length;
			logger.debug("valores {} ", valores.length);

			List<Integer> listHabilitaciones = new ArrayList();

			int[] intArray = new int[num];
			for(int x=0;x<num;x++)
			{
				intArray[x] = Integer.valueOf(valores[x]);
				listHabilitaciones.add(intArray[x]);
			}

			//Consumo servicio para llenar lista
			List<Tbasg260HabilifuncDto> listaFunciones = tbasg260HabilifuncService.getFuncionesAsocHabil(listHabilitaciones, cdgoIdioma);

			Object tbasg104ExpedientDto = tbasg104ExpedientService.getCertificadoComplementarioAOTActionDoExecute(Integer.valueOf(cdgoPersona));

			DownloadPdf downloadPdf = new DownloadPdf();

			downloadPdf.certificadoComplementarioAOT(cdgoIdioma,cdgoTipoHabi, response, tbasg104ExpedientDto, listaFunciones);

		} catch (Exception e) {
			logger.debug("getGenerarPdfCertCompl []", e);
			logger.debug("ERRORRR {}",e);
		}
	}

	@GetMapping("/get-generar-pdf-habilitacion-estado")
	public void getGenerarPdfHabiEstado(String cdgoPersona, Integer cdgoDoc, Integer cdgoEstado, HttpServletResponse response) {

		try {

			Object tbasg104ExpedientDto = tbasg104ExpedientService.GetHabilitacionEstadoActionDoExecute(cdgoPersona,cdgoEstado);

			DownloadPdf downloadPdf = new DownloadPdf();

			downloadPdf.habilitacionEstado(response, tbasg104ExpedientDto);

		} catch (Exception e) {
			logger.debug("getGenerarPdfCertCompl []", e);
			logger.debug("ERRORRR {}",e);
		}
	}


}
