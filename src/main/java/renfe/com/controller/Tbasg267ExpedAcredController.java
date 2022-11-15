package renfe.com.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import renfe.com.dto.GetDatosAcreditacionesDTO;
import renfe.com.dto.GetExpeAcreTipoValidezReciclajeDTO;
import renfe.com.dto.GetfindListAcreditaByCdgoPerDTO;
import renfe.com.model.dto.Tbasg265AmbitoLineaDto;
import renfe.com.model.dto.Tbasg267ExpedAcredDto;
import renfe.com.model.dto.Tbasg267PlanningAccredDTO;
import renfe.com.model.dto.Tbasg267PlanningAccredParamDTO;
import renfe.com.model.entity.Tbasg201ErrSalud;
import renfe.com.model.entity.Tbasg267ExpedAcred;
import renfe.com.pdf.core.DownloadPdf;
import renfe.com.service.Tbasg267ExpedAcredService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg267ExpedAcred")
public class Tbasg267ExpedAcredController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg267ExpedAcredService tbasg267ExpedAcredService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg267ExpedAcredDto>> getAllTbasg267ExpedAcred(Tbasg267ExpedAcredDto filter) {
		return new ResponseEntity<>(tbasg267ExpedAcredService.getAllTbasg267ExpedAcred(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoAcredita}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoAcredita") Integer cdgoAcredita) {
		Tbasg267ExpedAcredDto tbasg267ExpedAcredData = tbasg267ExpedAcredService.findByCdgoAcredita(cdgoAcredita);

		if (tbasg267ExpedAcredData != null) {
			return new ResponseEntity<>(tbasg267ExpedAcredData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg267ExpedAcredDto> createTbasg267ExpedAcred(
			@RequestBody Tbasg267ExpedAcredDto tbasg267ExpedAcredDto) {
		try {
			return new ResponseEntity<>(tbasg267ExpedAcredService.createTbasg267ExpedAcred(tbasg267ExpedAcredDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg267ExpedAcred {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoAcredita}")
	public ResponseEntity<Tbasg267ExpedAcredDto> updateTbasg267ExpedAcred(@PathVariable("cdgoAcredita") Integer cdgo,
			@RequestBody Tbasg267ExpedAcredDto body) {
		try {
			Tbasg267ExpedAcredDto tbasg267ExpedAcredData = tbasg267ExpedAcredService.updateTbasg267ExpedAcred(cdgo,
					body);
			if (tbasg267ExpedAcredData != null) {
				return new ResponseEntity<>(tbasg267ExpedAcredData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg267ExpedAcred []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoAcredita}")
	public ResponseEntity<HttpStatus> deleteTbasg267ExpedAcred(@PathVariable("cdgoAcredita") Integer cdgoAcredita) {
		try {
			tbasg267ExpedAcredService.deleteTbasg267ExpedAcred(cdgoAcredita);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg267ExpedAcred []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg267ExpedAcredDto>> findByCdgoAcreditaIn(List<Integer> cdgoAcredita) {
		try {
			List<Tbasg267ExpedAcredDto> tbasg267ExpedAcredDto = tbasg267ExpedAcredService
					.findByCdgoAcreditaIn(cdgoAcredita);

			if (tbasg267ExpedAcredDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg267ExpedAcredDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoAcreditaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-datos-acreditaciones")
	public ResponseEntity<List<GetDatosAcreditacionesDTO>> getDatosAcreditaciones(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<GetDatosAcreditacionesDTO> tbasg267ExpedAcredDto = tbasg267ExpedAcredService
					.getDatosAcreditaciones(cdgoPersona);

			if (tbasg267ExpedAcredDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg267ExpedAcredDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDatosAcreditaciones []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-expe-acre-tipo-validez-reciclaje")
	public ResponseEntity<List<GetExpeAcreTipoValidezReciclajeDTO>> getExpeAcreTipoValidezReciclaje(Integer cdgoAcredita) {
		// Generated from a SELECT found in an XML
		try {
			List<GetExpeAcreTipoValidezReciclajeDTO> tbasg267ExpedAcredDto = tbasg267ExpedAcredService
					.getExpeAcreTipoValidezReciclaje(cdgoAcredita);

			if (tbasg267ExpedAcredDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg267ExpedAcredDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExpeAcreTipoValidezReciclaje []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-list-acredita-by-cdgo-per")
	public ResponseEntity<List<GetfindListAcreditaByCdgoPerDTO>> findListAcreditaByCdgoPer(Integer cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<GetfindListAcreditaByCdgoPerDTO> tbasg267ExpedAcredDto = tbasg267ExpedAcredService
					.findListAcreditaByCdgoPer(cdgoPersona);

			if (tbasg267ExpedAcredDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg267ExpedAcredDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findListAcreditaByCdgoPer []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/find-data-planificacion-acreditaciones")
	public ResponseEntity<List<Tbasg267PlanningAccredDTO>> findDataPlanificacionAcreditaciones(@RequestBody Tbasg267PlanningAccredParamDTO bean) {
		try {
			logger.debug("--> isShowFit: {}", bean.getIsShowFit());

			List<Tbasg267PlanningAccredDTO> tbasg267ExpedAcredDto = tbasg267ExpedAcredService.findDataPlanificacionAcreditaciones(bean);
			return new ResponseEntity<>(tbasg267ExpedAcredDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("findDataPlanificacionAcreditaciones []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-acreditaciones-persona-list")
	public ResponseEntity<List<Tbasg267ExpedAcredDto>> getAcreditacionesPersonaList(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg267ExpedAcredDto> tbasg267ExpedAcredDto = tbasg267ExpedAcredService
					.getAcreditacionesPersonaList(cdgoPersona);

			if (tbasg267ExpedAcredDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg267ExpedAcredDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAcreditacionesPersonaList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-acreditaciones-persona-list-count")
	public ResponseEntity<?> getAcreditacionesPersonaListCount(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg267ExpedAcredDto> tbasg267ExpedAcredDto = tbasg267ExpedAcredService
					.getAcreditacionesPersonaListCount(cdgoPersona);

			if (tbasg267ExpedAcredDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg267ExpedAcredDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAcreditacionesPersonaListCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-acreditacion")
	public ResponseEntity<List<Tbasg267ExpedAcredDto>> getAcreditacion(String cdgoAcredita) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg267ExpedAcredDto> tbasg267ExpedAcredDto = tbasg267ExpedAcredService.getAcreditacion(cdgoAcredita);

			if (tbasg267ExpedAcredDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg267ExpedAcredDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAcreditacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-acreditaciones-de-la-persona")
	public ResponseEntity<List<Tbasg267ExpedAcredDto>> getAcreditacionesDeLaPersona(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg267ExpedAcredDto> tbasg267ExpedAcredDto = tbasg267ExpedAcredService
					.getAcreditacionesDeLaPersona(cdgoPersona);

			if (tbasg267ExpedAcredDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg267ExpedAcredDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAcreditacionesDeLaPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-ultima-acreditacion")
	public ResponseEntity<List<Tbasg267ExpedAcredDto>> getUltimaAcreditacion() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg267ExpedAcredDto> tbasg265AmbitoLineaDto = tbasg267ExpedAcredService
					.getUltimaAcreditacion();

			if (tbasg265AmbitoLineaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg265AmbitoLineaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getListaAmbitoLineasActiv []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-acreditacion")
	public ResponseEntity<?> insertAcreditacion(@RequestBody Tbasg267ExpedAcred bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg267ExpedAcredDto = tbasg267ExpedAcredService.insertAcreditacion(bean);
			return new ResponseEntity<>(tbasg267ExpedAcredDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertAcreditacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-acreditacion-mantenimiento")
	public ResponseEntity<?> updateAcreditacionMantenimiento(@RequestBody GetDatosAcreditacionesDTO bean) {
		try {
			int tbasg267ExpedAcredDto = tbasg267ExpedAcredService.updateAcreditacionMantenimiento(bean);
			return new ResponseEntity<>(tbasg267ExpedAcredDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("updateAcreditacionMantenimiento []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-expe-acred-val-persona")
	public ResponseEntity<List<Tbasg267ExpedAcredDto>> getExpeAcredValPersona(Integer cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg267ExpedAcredDto> tbasg267ExpedAcredDto = tbasg267ExpedAcredService
					.getExpeAcredValPersona(cdgoPersona);

			if (tbasg267ExpedAcredDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg267ExpedAcredDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExpeAcredValPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-expe-cdgo-acredita")
	public ResponseEntity<List<Tbasg267ExpedAcredDto>> getExpeCdgoAcredita(Integer cdgoAcredita) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg267ExpedAcredDto> tbasg267ExpedAcredDto = tbasg267ExpedAcredService
					.getExpeCdgoAcredita(cdgoAcredita);

			if (tbasg267ExpedAcredDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg267ExpedAcredDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExpeAcredValPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-acre-persona-object")
	public ResponseEntity<List<Tbasg267ExpedAcredDto>> getAcrePersonaObject(String cdgoAcredita) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg267ExpedAcredDto> tbasg267ExpedAcredDto = tbasg267ExpedAcredService
					.getAcrePersonaObject(cdgoAcredita);

			if (tbasg267ExpedAcredDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg267ExpedAcredDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAcrePersonaObject []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update-acreditacion")
	public ResponseEntity<?> updateAcreditacion(@RequestBody Tbasg267ExpedAcred bean) {
		
		try {
			int tbasg267ExpedAcredDto = tbasg267ExpedAcredService.updateAcreditacion(bean);
			return new ResponseEntity<>(tbasg267ExpedAcredDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateAcreditacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-generar-pdf-acreditaciones")
	public void getGenerarPdfCertCompl(Integer cdgoPersona, HttpServletResponse response) {

		try {

			Object tbasg267ExpedAcredDto = tbasg267ExpedAcredService.getAcreditacionesActionDoExecute(cdgoPersona);

			DownloadPdf downloadPdf = new DownloadPdf();
			downloadPdf.generaPDFAcreditaciones(response, tbasg267ExpedAcredDto);

		} catch (Exception e) {
			logger.debug("getGenerarPdfAcreditaciones []", e);
			logger.debug("ERRORRR {}", e);
		}
	}

}
