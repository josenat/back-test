package renfe.com.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import renfe.com.ConfigProperties;
import renfe.com.dto.GetActasActivasPersonaDTO;
import renfe.com.dto.GetActasNoActivasPersonaDTO;
import renfe.com.dto.GetDatosPersonaAcreditaDTO;
import renfe.com.dto.GetExpStatusFilterParametersDTO;

import renfe.com.dto.GetFechaProxRecicTitConDTO;
import renfe.com.dto.GetFechaProxRecicTitConNoMarcaDTO;
import renfe.com.dto.GetFindPersonaAltasBajasDTO;

import renfe.com.dto.GetMaxEstadoExpListDTO;
import renfe.com.dto.GetPerByEstadoListResultDTO;

import renfe.com.dto.GetTituloConListAuxDTO;

import renfe.com.dto.ParamExpedientesPersonaListDTO;
import renfe.com.dto.SetExpedientesPersonaListDTO;
import renfe.com.model.dto.ActasPersonaDto;
import renfe.com.model.dto.RequisitosMinimosDto;
import renfe.com.model.dto.ResponseConsultPersonalDTO;
import renfe.com.model.dto.ResponseLoadCombosDTO;
import renfe.com.model.dto.Tbasg100PersonaDto;

import renfe.com.model.dto.Tbasg260HabilifuncDto;
import renfe.com.model.dto.Tbasg905OrganizationChartDto;
import renfe.com.model.dto.Tbasg105AreactiviDto;

import renfe.com.model.entity.Tbasg100Persona;
import renfe.com.model.entity.Tbasg105Areactivi;
import renfe.com.pdf.core.DownloadPdf;
import renfe.com.service.Tbasg100PersonaService;
import renfe.com.service.Tbasg101CertpsicService;
import renfe.com.service.Tbasg102TituloconService;
import renfe.com.service.Tbasg104ExpedientService;
import renfe.com.service.Tbasg105AreactiviService;
import renfe.com.service.Tbasg106ProvinciaService;
import renfe.com.service.Tbasg107TipoviaService;
import renfe.com.service.Tbasg108CentmedicService;
import renfe.com.service.Tbasg109PsicoambiService;
import renfe.com.service.Tbasg110PsicomotiService;
import renfe.com.service.Tbasg111FacultatiService;
import renfe.com.service.Tbasg115CalificacService;
import renfe.com.service.Tbasg116EstadosService;
import renfe.com.service.Tbasg120CentformaService;
import renfe.com.service.Tbasg122InstruService;
import renfe.com.service.Tbasg125EmpresaService;
import renfe.com.service.Tbasg134NacionService;
import renfe.com.service.Tbasg135CargoService;
import renfe.com.service.Tbasg136EstudioService;
import renfe.com.service.Tbasg150TipodocService;
import renfe.com.service.Tbasg152PersempService;
import renfe.com.service.Tbasg157FormacComplemenService;
import renfe.com.service.Tbasg220UsuariosExternosService;
import renfe.com.service.Tbasg230DestinatariosEmailService;
import renfe.com.service.Tbasg267ExpedAcredService;
import renfe.com.dto.GetMaxEstadoHabilitaListDTO;
import renfe.com.dto.GetMaxEstadoProxRevListDTO;
import renfe.com.dto.GetPerByEstadoListResultDTO;
import renfe.com.dto.GetPersonaCertificadosIdiomasListDTO;
import renfe.com.dto.GetPersonaEmpresaInformeDTO;
import renfe.com.dto.GetPersonaEstadoListDTO;
import renfe.com.dto.GetPersonaResultDTO;
import renfe.com.dto.SetMaxEstadoHabilitaList;
import renfe.com.dto.SetPersonaCertificadosIdiomasList;
import renfe.com.dto.SetPersonaEstadoList;
import renfe.com.dto.setMaxEstadoProxRevList;


@RestController
@CrossOrigin
@RequestMapping( "/asg/api/tbasg100Persona")
public class Tbasg100PersonaController {

	protected final Logger logger;

	private final Tbasg100PersonaService tbasg100PersonaService;

	public Tbasg100PersonaController(Logger logger, Tbasg100PersonaService tbasg100PersonaService) {
		this.logger = logger;
		this.tbasg100PersonaService = tbasg100PersonaService;
	}

	@Autowired
	private Tbasg107TipoviaService tbasg107TipoviaService;
	@Autowired
	private Tbasg106ProvinciaService tbasg106ProvinciaService;
	@Autowired
	private Tbasg135CargoService tbasg135CargoService;
	@Autowired
	private Tbasg125EmpresaService tbasg125EmpresaService;
	@Autowired
	private Tbasg136EstudioService tbasg136EstudioService;
	@Autowired
	private Tbasg134NacionService tbasg134NacionService;
	@Autowired
	private Tbasg115CalificacService tbasg115CalificacService;
	@Autowired
	private Tbasg110PsicomotiService tbasg110PsicomotiService;
	@Autowired
	private Tbasg109PsicoambiService tbasg109PsicoambiService;
	@Autowired
	private Tbasg108CentmedicService tbasg108CentmedicService;
	@Autowired
	private Tbasg111FacultatiService tbasg111FacultatiService;
	@Autowired
	private Tbasg122InstruService tbasg122InstruService;
	@Autowired
	private Tbasg120CentformaService tbasg120CentformaService;
	@Autowired
	private Tbasg150TipodocService tbasg150TipodocService;
	@Autowired
	private Tbasg220UsuariosExternosService tbasg220UsuariosExternosService;
	@Autowired
	private Tbasg230DestinatariosEmailService tbasg230DestinatariosEmailService;
	@Autowired
	private Tbasg116EstadosService tbasg116EstadosService;
	@Autowired
	private Tbasg105AreactiviService tbasg105AreactiviService;
	@Autowired
	private Tbasg267ExpedAcredService tbasg267ExpedAcredService;
	@Autowired
	private Tbasg157FormacComplemenService tbasg157FormacComplemenService;
	@Autowired
	private Tbasg104ExpedientService tbasg104ExpedientService;

	@Autowired
	private Tbasg102TituloconService tbasg102TituloconService;

	@Autowired
	private Tbasg101CertpsicService tbasg101CertpsicService;

	@Autowired
	private Tbasg152PersempService tbasg152PersempService;

	@Autowired
	DownloadPdf downloadPdf;

	
	@GetMapping("")
	public ResponseEntity<List<Tbasg100PersonaDto>> getAllTbasg100Persona(Tbasg100PersonaDto filter) {
		return new ResponseEntity<>(tbasg100PersonaService.getAllTbasg100Persona(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoPersona}")
	public ResponseEntity<Tbasg100PersonaDto> findByCdgoExpediente(@PathVariable("cdgoPersona") Integer cdgoPersona) {
		Tbasg100PersonaDto tbasg100PersonaData = tbasg100PersonaService.findByCdgoPersona(cdgoPersona);

		if (tbasg100PersonaData != null) {
			return new ResponseEntity<>(tbasg100PersonaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg100PersonaDto> createTbasg100Persona(
			@RequestBody Tbasg100PersonaDto tbasg100PersonaDto) {
		try {
			return new ResponseEntity<>(tbasg100PersonaService.createTbasg100Persona(tbasg100PersonaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg100Persona {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoPersona}")
	public ResponseEntity<Tbasg100PersonaDto> updateTbasg100Persona(@PathVariable("cdgoPersona") Integer cdgo,
			@RequestBody Tbasg100PersonaDto body) {
		try {
			Tbasg100PersonaDto tbasg100PersonaData = tbasg100PersonaService.updateTbasg100Persona(cdgo, body);
			if (tbasg100PersonaData != null) {
				return new ResponseEntity<>(tbasg100PersonaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg100Persona []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoPersona}")
	public ResponseEntity<HttpStatus> deleteTbasg100Persona(@PathVariable("cdgoPersona") Integer cdgoPersona) {
		try {
			tbasg100PersonaService.deleteTbasg100Persona(cdgoPersona);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg100Persona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-generar-pdf-altas-bajas-fichero-ref")
	public void getGenerarPdfAltasBajasFicheroRef(@RequestParam List<Integer> codigos, String fecDesde, String fecHasta, String alta, String baja,  HttpServletResponse response) {

		try {
			logger.info("object0 {}, object1 {}, object2 {}, object3 {}, ",codigos, fecDesde, fecHasta, response);
			response.setContentType("application/pdf");

			//String currentDateTime = dateFormatter.format(new Date());
			//String currentDateTime = new Date(0, 0, 0).toString();
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
//			Date dateFechaDesde = formatter.parse(fecDesde);  
//			Date dateFechaHasta = formatter.parse(fecHasta);
			String headerKey = "Content-Disposition";
			String headerValue = "attachment; filename=Pdf_Altas_Bajas_FicheroREF.pdf";
			response.setHeader(headerKey, headerValue);

	        Object listadoPersonas = tbasg100PersonaService.getPdfAltasBajasFicheroRefDoExecute(codigos, fecDesde, fecHasta, alta, baja);
			downloadPdf.informeAltaBaja(response, listadoPersonas, fecDesde, fecHasta);
		} catch (Exception e) {
			logger.debug("getGenerarPdfAltasBajasFicheroRef []", e);
			logger.debug("ERRORRR {}",e);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg100PersonaDto>> findByCdgoPersonaIn(List<Integer> cdgoPersona) {
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.findByCdgoPersonaIn(cdgoPersona);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoPersonaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-acreditaciones-caducadas")
	public ResponseEntity<List<Tbasg100PersonaDto>> getAcreditacionesCaducadas() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.getAcreditacionesCaducadas();

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getAcreditacionesCaducadas []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-actas-persona")
	public ResponseEntity<List<ActasPersonaDto>> getActasPersona(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<ActasPersonaDto> tbasg100PersonaDto = tbasg100PersonaService.getActasPersona(cdgoPersona);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActasPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-actas-persona-order-by-cdgo-acta-form")
	public ResponseEntity<List<Tbasg100PersonaDto>> getActasPersonaOrderByCdgoActaForm(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService
					.getActasPersonaOrderByCdgoActaForm(cdgoPersona);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActasPersonaOrderByCdgoActaForm []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/get-titulo-conlistaux")
	public ResponseEntity<List<GetTituloConListAuxDTO>> getTituloConListAux(Integer cdgoPersona) {

		// Generated from a SELECT found in an XML
		try {

			List<GetTituloConListAuxDTO> tbasg100PersonaDto = tbasg100PersonaService.getTituloConListAux(cdgoPersona);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTituloConListAux []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-actas-activas-persona")
	public ResponseEntity<List<GetActasActivasPersonaDTO>> getActasActivasPersona(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {

			List<GetActasActivasPersonaDTO> tbasg100PersonaDto = tbasg100PersonaService.getActasActivasPersona(cdgoPersona);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActasActivasPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-actas-no-activas-persona")
	public ResponseEntity<List<GetActasNoActivasPersonaDTO>> getActasNoActivasPersona(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<GetActasNoActivasPersonaDTO> tbasg100PersonaDto = tbasg100PersonaService.getActasNoActivasPersona(cdgoPersona);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActasNoActivasPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-examin-for-name")
	public ResponseEntity<List<Tbasg100PersonaDto>> getExaminForName(String desgApell1) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.getExaminForName(desgApell1);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExaminForName []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/get-max-estado-exp-list")
	public ResponseEntity<List<GetMaxEstadoExpListDTO>> getMaxEstadoExpList(@RequestBody GetExpStatusFilterParametersDTO filter) {

		try {
			List<GetMaxEstadoExpListDTO> tbasg100PersonaDto = tbasg100PersonaService.getMaxEstadoExpList(filter);
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("getMaxEstadoExpList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	

	@GetMapping("/get-report-list")
	public ResponseEntity<List<Tbasg100PersonaDto>> getReportList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.getReportList();

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getReportList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-per-by-estado-list")
	public ResponseEntity<List<GetPerByEstadoListResultDTO>> getPerByEstadoList() {
		// Generated from a SELECT found in an XML
		try {
			List<GetPerByEstadoListResultDTO> tbasg100PersonaDto = tbasg100PersonaService.getPerByEstadoList();

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPerByEstadoList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-report-historico-list")
	public ResponseEntity<List<Tbasg100PersonaDto>> getReportHistoricoList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.getReportHistoricoList();

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getReportHistoricoList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-maq-by-tramos-list")
	public ResponseEntity<List<Tbasg100PersonaDto>> getMaqByTramosList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.getMaqByTramosList();

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getMaqByTramosList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fecha-prox-recic-tit-con")
	public ResponseEntity<List<GetFechaProxRecicTitConDTO>> getFechaProxRecicTitCon(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<GetFechaProxRecicTitConDTO> tbasg100PersonaDto = tbasg100PersonaService.getFechaProxRecicTitCon(cdgoPersona);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFechaProxRecicTitCon []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fecha-prox-recic-tit-con-no-marca")
	public ResponseEntity<List<GetFechaProxRecicTitConNoMarcaDTO>> getFechaProxRecicTitConNoMarca(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<GetFechaProxRecicTitConNoMarcaDTO> tbasg100PersonaDto = tbasg100PersonaService
					.getFechaProxRecicTitConNoMarca(cdgoPersona);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFechaProxRecicTitConNoMarca []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-fecha-prox-recic-tit-con-no-marca-s")
	public ResponseEntity<List<GetFechaProxRecicTitConNoMarcaDTO>> getFechaProxRecicTitConNoMarcaS(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<GetFechaProxRecicTitConNoMarcaDTO> tbasg100PersonaDto = tbasg100PersonaService
					.getFechaProxRecicTitConNoMarcaS(cdgoPersona);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getFechaProxRecicTitConNoMarcaS []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-persona-examinador")
	public ResponseEntity<List<Tbasg100PersonaDto>> getPersonaExaminador(String cdgoNif) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.getPersonaExaminador(cdgoNif);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPersonaExaminador []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-persona-instructor")
	public ResponseEntity<List<Tbasg100PersonaDto>> getPersonaInstructor(String cdgoNif) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.getPersonaInstructor(cdgoNif);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPersonaInstructor []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-persona-estado-list")
	public ResponseEntity<List<GetPersonaEstadoListDTO>> getPersonaEstadoList(SetPersonaEstadoList mapPending) {
		// Generated from a SELECT found in an XML
		try {
			List<GetPersonaEstadoListDTO> tbasg100PersonaDto = tbasg100PersonaService.getPersonaEstadoList(mapPending);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPersonaEstadoList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-max-estado-habilita-count")
	public ResponseEntity<List<Tbasg100PersonaDto>> getMaxEstadoHabilitaCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.getMaxEstadoHabilitaCount();

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getMaxEstadoHabilitaCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-max-estado-prox-rev-list-count")
	public ResponseEntity<List<Tbasg100PersonaDto>> getMaxEstadoProxRevListCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.getMaxEstadoProxRevListCount();

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getMaxEstadoProxRevListCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-Max-Estado-Prox-Rev-List")
	public ResponseEntity<List<GetMaxEstadoProxRevListDTO>> getMaxEstadoProxRevList(setMaxEstadoProxRevList mapPending) {
		// Generated from a SELECT found in an XML
		try {
			List<GetMaxEstadoProxRevListDTO> tbasg100PersonaDto = tbasg100PersonaService.getMaxEstadoProxRevList(mapPending);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getMaxEstadoProxRevList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-persona-certificados-idiomas-list")
	public ResponseEntity<List<GetPersonaCertificadosIdiomasListDTO>> getPersonaCertificadosIdiomasList(SetPersonaCertificadosIdiomasList mapPending) {
		// Generated from a SELECT found in an XML
		try {
			List<GetPersonaCertificadosIdiomasListDTO> tbasg100PersonaDto = tbasg100PersonaService.getPersonaCertificadosIdiomasList(mapPending);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPersonaCertificadosIdiomasList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/get-persona-all-list")
	public ResponseEntity<List<Tbasg100PersonaDto>> getPersonaAllList(SetExpedientesPersonaListDTO filter) {

		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.getPersonaAllList(filter);
			System.out.println("Tamaño de la lista " + tbasg100PersonaDto.size());
			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPersonaAllList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-persona-by-sociedades-list")
	public ResponseEntity<List<Tbasg100PersonaDto>> getPersonaBySociedadesList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.getPersonaBySociedadesList();
			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPersonaBySociedadesList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//here
	@GetMapping("/get-persona")
	public ResponseEntity<List<Tbasg100PersonaDto>> getPersona(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.getPersona(cdgoPersona);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

		
	private ResponseLoadCombosDTO cargaCombos() {

		ResponseLoadCombosDTO combo = new ResponseLoadCombosDTO();

		try {
			combo.setGetTipoViaActiveListAscendente(tbasg107TipoviaService.getTipoViaActiveListAscendente());
			combo.setGetProvinciaListActiveAscendente(tbasg106ProvinciaService.getProvinciaListActiveAscendente());
			combo.setGetCargoActiveListAscendente(tbasg135CargoService.getCargoActiveListAscendente());
			combo.setGetEmpresaViewListActive(tbasg125EmpresaService.getEmpresaViewListActive());
			combo.setGetEstudioActiveListAscendente(tbasg136EstudioService.getEstudioActiveListAscendente());
			combo.setGetNacionActiveListAscendente(tbasg134NacionService.getNacionActiveListAscendente());
			combo.setGetCalificacActiveListAscendente(tbasg115CalificacService.getCalificacActiveListAscendente());
			combo.setGetPsicoMotiActiveListAscendente(tbasg110PsicomotiService.getPsicoMotiActiveListAscendente());
			combo.setGetPsicoAmbiActiveListAscendente(tbasg109PsicoambiService.getPsicoAmbiActiveListAscendente());
			combo.setGetCentMedicActiveListAscendente(tbasg108CentmedicService.getCentMedicActiveListAscendente());
			combo.setGetFacultatiActiveListAscendenteApe1Ape2Nom(tbasg111FacultatiService.getFacultatiActiveListAscendenteApe1Ape2Nom());
			combo.setGetInstruActiveListNombre(tbasg122InstruService.getInstruActiveListNombre());
			combo.setGetCentFormaActiveListAscendente(tbasg120CentformaService.getCentFormaActiveListAscendente());
			combo.setGetTipoDocListByCodigo(tbasg150TipodocService.getTipoDocListByCodigo());
			combo.setGetUsuarioExternoListActiveAscendente(tbasg220UsuariosExternosService.getUsuarioExternoListActiveAscendente());
			combo.setGetDestinatariosEmailListActiveAscendente(tbasg230DestinatariosEmailService.getDestinatariosEmailListActiveAscendente());
			combo.setGetEstadosListActive(tbasg116EstadosService.getEstadosListActive());
			combo.setGetAreActiviListAscendenteSelectedByLevel(tbasg105AreactiviService.getAreActiviListAscendenteSelectedByLevel());
			
		} catch (Exception e) {
			logger.error("getCargaCombos []", e);
		}
		return combo;
	}

	@GetMapping("/get-general-person-combos")
	public ResponseEntity<ResponseConsultPersonalDTO> getGeneralPersonCombos() {
		ResponseConsultPersonalDTO response = new ResponseConsultPersonalDTO();
		try {
			// Cargamos todos los combos
			response.setResponseLoadCombosDTO(cargaCombos());
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("getGeneralPersonCombos []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	

	/**
	 * Carga la ventana de consulta de Persona.
	 * 
	 * @param cdgoPersona
	 * @return
	 */

	@GetMapping("/consult-personal")
	public ResponseEntity<ResponseConsultPersonalDTO> consultPersonal(String cdgoPersona) {
		ResponseConsultPersonalDTO response = new ResponseConsultPersonalDTO();
		try {

			// Cargar el objeto Persona
			response.setGetpersona(tbasg100PersonaService.getPersona(cdgoPersona));
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("getConsultPersonal []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-driving-license-data")
	public ResponseEntity<ResponseConsultPersonalDTO> getDrivingLicenseData(String cdgoPersona) {
		ResponseConsultPersonalDTO response = new ResponseConsultPersonalDTO();
		try {
			// Cargar el título de conducción
			response.setGetTituloConPersonaUltimo(tbasg102TituloconService.getTituloConPersonaUltimo(cdgoPersona));
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("getDrivingLicenseData []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	

	@GetMapping("/get-psychotechnical-certificate")
	public ResponseEntity<ResponseConsultPersonalDTO> getPsychotechnicalCertificate(String cdgoPersona) {
		ResponseConsultPersonalDTO response = new ResponseConsultPersonalDTO();
		try {
			// Cargar certificado psicotécnico
			response.setGetCertPsicWithMaxFchaRec(tbasg101CertpsicService.getCertPsicWithMaxFchaRec(cdgoPersona));
			response.setGetCertPsicPersonaInactivosList(tbasg101CertpsicService.getCertPsicPersonaInactivosList(cdgoPersona));

			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("getDrivingLicenseData []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}	

	@GetMapping("/get-person-training")
	public ResponseEntity<ResponseConsultPersonalDTO> getPersonTraining(String cdgoPersona) {
		ResponseConsultPersonalDTO response = new ResponseConsultPersonalDTO();
		try {
			// Cargar formacion e historico formacion
			response.setGetActasActivasPersona(tbasg100PersonaService.getActasActivasPersona(cdgoPersona));
			response.setGetActasNoActivasPersona(tbasg100PersonaService.getActasNoActivasPersona(cdgoPersona));

			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("getPersonTraining []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
		
	@GetMapping("/get-person-expedient")
	public ResponseEntity<ResponseConsultPersonalDTO> getPersonExpedient(String cdgoPersona) {
		ResponseConsultPersonalDTO response = new ResponseConsultPersonalDTO();
		try {
			// Cargar expedientes
			ParamExpedientesPersonaListDTO filtro = new ParamExpedientesPersonaListDTO();
			filtro.setCdgoPersona(Integer.valueOf(cdgoPersona));			
			response.setGetExpedientesPersonaList(tbasg104ExpedientService.getExpedientesPersonaList(filtro));

			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("getPersonExpedient []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-additional-personal-training")

	public ResponseEntity<ResponseConsultPersonalDTO> getAdditionalPersonalTraining(Integer cdgoPersona, Integer cdgoCategoria, Integer cdgoCualificacion) {
		ResponseConsultPersonalDTO response = new ResponseConsultPersonalDTO();
		try {
			// Cargar formacion complementaria
			response.setGetFormacionComplementariaPersonaListResult(tbasg157FormacComplemenService.getFormacComplemenPersonaList(cdgoPersona,cdgoCategoria,cdgoCualificacion));

			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("getAdditionalPersonalTraining []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}		

	@GetMapping("/get-person-accreditations")
	public ResponseEntity<ResponseConsultPersonalDTO> getPersonAccreditations(String cdgoPersona) {
		ResponseConsultPersonalDTO response = new ResponseConsultPersonalDTO();
		try {
			// Cargar acreditaciones
			response.setGetDatosAcreditaciones(tbasg267ExpedAcredService.getDatosAcreditaciones(cdgoPersona));
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("getPersonAccreditations []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}		
	
	@GetMapping("/get-person-company")
	public ResponseEntity<ResponseConsultPersonalDTO> getPersonCompany(String cdgoPersona) {
		ResponseConsultPersonalDTO response = new ResponseConsultPersonalDTO();
		try {
			// Cargar persona empresa
			response.setGetPersonaEmpresa(tbasg152PersempService.getPersonaEmpresa(cdgoPersona));
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("getPersonCompany []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}		

	@GetMapping("/ge-cdgo-persona")
	public ResponseEntity<List<Tbasg100PersonaDto>> geCdgoPersona(String desgNifpas) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.geCdgoPersona(desgNifpas);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("geCdgoPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-dias-i-l-t")
	public ResponseEntity<List<Tbasg100PersonaDto>> getDiasILT(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.getDiasILT(cdgoPersona);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDiasILT []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	@GetMapping("/get-cdgo-persona-matricula")
	public ResponseEntity<List<Tbasg100PersonaDto>> getCdgoPersonaMatricula(String desgMatricula) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.getCdgoPersonaMatricula(desgMatricula);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCdgoPersonaMatricula []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/existe-persona-d-n-i")
	public ResponseEntity<List<Tbasg100PersonaDto>> existePersonaDNI(String desgNifpas) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.existePersonaDNI(desgNifpas);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("existePersonaDNI []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/existe-persona-r-e-n-f-e-d-n-i")
	public ResponseEntity<List<Tbasg100PersonaDto>> existePersonaRENFEDNI(String desgNifpas) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.existePersonaRENFEDNI(desgNifpas);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("existePersonaRENFEDNI []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-persona-altas")
	public ResponseEntity<List<GetFindPersonaAltasBajasDTO>> findPersonaAltas(@RequestParam List<Integer> codigos, String fecDesde, String fecHasta) {
		// Generated from a SELECT found in an XML
		try {
			List<GetFindPersonaAltasBajasDTO> tbasg100PersonaDto = tbasg100PersonaService.findPersonaAltas(codigos, fecDesde, fecHasta);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findPersonaAltas []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-persona-bajas")
	public ResponseEntity<List<GetFindPersonaAltasBajasDTO>> findPersonaBajas(@RequestParam List<Integer> codigos, String fecDesde, String fecHasta) {
		// Generated from a SELECT found in an XML
		try {
			List<GetFindPersonaAltasBajasDTO> tbasg100PersonaDto = tbasg100PersonaService.findPersonaBajas(codigos, fecDesde, fecHasta);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findPersonaBajas []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-datos-persona-acredita")
	public ResponseEntity<List<GetDatosPersonaAcreditaDTO>> getDatosPersonaAcredita(Integer cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<GetDatosPersonaAcreditaDTO> tbasg100PersonaDto = tbasg100PersonaService.getDatosPersonaAcredita(cdgoPersona);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDatosPersonaAcredita []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-persona-formador")
	public ResponseEntity<List<Tbasg100PersonaDto>> getPersonaFormador(String desgNifpas) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.getPersonaFormador(desgNifpas);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPersonaFormador []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-dni")
	public ResponseEntity<List<Tbasg100PersonaDto>> getDni(String desgMatricula) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.getDni(desgMatricula);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getDni []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*@PostMapping("/insert-persona")
	public ResponseEntity<Tbasg100Persona> insertPersona(@RequestBody Tbasg100Persona bean) {
		// Generated from a INSERT found in an XML
		try {
			//int tbasg100PersonaDto = tbasg100PersonaService.insertPersona(bean);
			return new ResponseEntity<>(tbasg100PersonaService.insertPersona(bean), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
	
	@PostMapping("/insert-persona")
	public ResponseEntity<?> insertPersona(@RequestBody Tbasg100Persona bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg100PersonaDto = tbasg100PersonaService.insertPersona(bean);
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-personal-act/{rol}/{proceso}")
	public ResponseEntity<Integer> updatePersonalAct(@PathVariable("rol") String rol, @PathVariable("proceso") String proceso, @RequestBody Tbasg100Persona bean) {
		String cdgoPersona = (String.valueOf(bean.getCdgoPersona())).trim();
		
		// Control de rol para confirmaciones y otorgamientos
		if (!checkProcessRolForUpdate(rol, proceso)) {
			logger.debug("-------> No checkProcessRolForUpdate {} - {}", rol, proceso);
			consultPersonal(cdgoPersona);

		} else {
			try {
				logger.debug("-------> Yes checkProcessRolForUpdate {}", bean);
				Integer tbasg100PersonaDto = tbasg100PersonaService.updatePersonalAct(bean);
				return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);

			} catch (Exception e) {
				logger.error("updatePersonalAct []", e);
			}
		}

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}


	/**
	 * Comprobación del rol para un proceso. Determina si puede o no realizar
	 * modificacion de personal. En caso de que no pueda, se debería enviar al
	 * proceso de consulta
	 *
	 * @param rol
	 *     Rol a consultar el permiso
	 * @param proceso
	 *     Código de proceso sobre el que se realiza la accion
	 * @return true si el rol puede modificar personal para el proceso indicado
	 *     false en caso contrario
	 */
	private boolean checkProcessRolForUpdate(String rol, String proceso) {
		if ((proceso.equals("90") || proceso.equals("92") || proceso.equals("93") || proceso.equals("94") || proceso.equals("9B")) && !rol.equals("AD")) {
			return false;
		}
		return true;
	}

	@GetMapping("/update-persona-mantenimiento")
	public ResponseEntity<Integer> updatePersonaMantenimiento(Tbasg100Persona bean) {
		// Generated from a UPDATE found in an XML
		try {
			Integer tbasg100PersonaDto = tbasg100PersonaService.updatePersonaMantenimiento(bean);
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updatePersonaMantenimiento []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/delete-persona")
	public ResponseEntity<?> deletePersona(@RequestBody Tbasg100Persona bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg100PersonaDto = tbasg100PersonaService.deletePersona(bean);
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deletePersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-req-minimos-persona-act")
	public ResponseEntity<Integer> updateReqMinimosPersonaAct(@RequestBody RequisitosMinimosDto bean) {
		try {			
			logger.debug("---> updateReqMinimosPersonaAct: {}", bean.getDesgEstudiequiv());

			int result = tbasg100PersonaService.updateReqMinimosPersonaAct(bean);
			return new ResponseEntity<>(result, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("updateReqMinimosPersonaAct []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-persona-empresa-informe")
	public ResponseEntity<List<GetPersonaEmpresaInformeDTO>> getPersonaEmpresaInforme(Integer cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<GetPersonaEmpresaInformeDTO> tbasg100PersonaDto = tbasg100PersonaService.getPersonaEmpresaInforme(cdgoPersona);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPersonaEmpresaInforme []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-titulo-con-list")
	public ResponseEntity<List<Tbasg100PersonaDto>> getTituloConList(String cdgoEstado, String cdgoEstado_1,
			String cdgoEstado_2, String cdgoEstado_3, String cdgoEstado_4) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.getTituloConList(cdgoEstado,
					cdgoEstado_1, cdgoEstado_2, cdgoEstado_3, cdgoEstado_4);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTituloConList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-titulo-con-list-count")
	public ResponseEntity<List<Tbasg100PersonaDto>> getTituloConListCount(String cdgoEstado, String cdgoEstado_1,
			String cdgoEstado_2, String cdgoEstado_3, String cdgoEstado_4) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService.getTituloConListCount(cdgoEstado,
					cdgoEstado, cdgoEstado, cdgoEstado, cdgoEstado);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTituloConListCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-titulo-con-list-count-por-estado")
	public ResponseEntity<List<Tbasg100PersonaDto>> getTituloConListCountPorEstado(String cdgoEstado,
			String cdgoEstado_1, String cdgoEstado_2, String cdgoEstado_3, String cdgoEstado_4) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg100PersonaDto> tbasg100PersonaDto = tbasg100PersonaService
					.getTituloConListCountPorEstado(cdgoEstado, cdgoEstado, cdgoEstado, cdgoEstado, cdgoEstado);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTituloConListCountPorEstado []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-max-estado-habilita-list")
	public ResponseEntity<List<GetMaxEstadoHabilitaListDTO>> getAreActiviListByAreTerList(SetMaxEstadoHabilitaList mapPending) {
		// Generated from a SELECT found in an XML
		try {

			System.out.println(mapPending);
			List<GetMaxEstadoHabilitaListDTO> tbasg100PersonaDto = tbasg100PersonaService.getMaxEstadoHabilitaList(mapPending);

			if (tbasg100PersonaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg100PersonaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("GetMaxEstadoHabilitaList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-leer-json")
	public ResponseEntity<JSONObject> getLeerJson(String tabla) {

		try {
			JSONObject jsonObject = tbasg100PersonaService.getLeerJson(tabla);

			if (jsonObject == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(jsonObject, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getLeerJson []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

	@GetMapping("/get-organizational-chart-list")
	public ResponseEntity<List<Tbasg905OrganizationChartDto>> getOrganizationalChart(Integer level, String id) {
		try { 
			logger.debug("---> getOrganizationalChart level: {}", level);
			logger.debug("---> getOrganizationalChart id: {}", id);

			List<Tbasg905OrganizationChartDto> tbasg905OrganizationChartDto = tbasg100PersonaService.getOrganizationalChart(level, id);
			return new ResponseEntity<>(tbasg905OrganizationChartDto, HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error("getOrganizationalChart []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * RequestBody: [ ["1234", "S"] ]
	 */
	@PutMapping("/update-revision-status")
	public ResponseEntity<Integer> updateRevisionStatus(@RequestBody List<List<String>> expedientCodeList) {
		try { 
			for (List<String> item : expedientCodeList) {
				logger.debug("--> "+ item.get(0) +": "+ item.get(1));
			}
			
			int result = tbasg100PersonaService.updateRevisionStatus(expedientCodeList);
			return new ResponseEntity<>(result, HttpStatus.OK);	
	
			//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		} catch (Exception e) {
			logger.error("updateRevisionStatus []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	@GetMapping("/get-generar-pdf-dossier-personal")
	public void getGenerarPDFDossierPersonal(String cdgoPersona, HttpServletResponse response) {

		try {
			response.setContentType("application/pdf");
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
			String currentDateTime = dateFormatter.format(new java.util.Date());
			Integer cdgoPersonaInt = Integer.parseInt(cdgoPersona);
			System.out.println(cdgoPersonaInt); // output = 25

			String headerKey = "Content-Disposition";
			String headerValue = "attachment; filename=dossierPersonal_" + currentDateTime + ".pdf";
			response.setHeader(headerKey, headerValue);

			HttpServletRequest request = null;
			downloadPdf.dossierPersonal(cdgoPersonaInt, response);
			// downloadPdf.certificadoComplementario(cdgoIdioma, response,
			// tbasg104ExpedientDto);
			logger.debug("Fin del controlador");
		} catch (Exception e) {
			logger.debug("getGenerarPDFDossierPersonal []", e);
			logger.debug("ERRORR {}", e);
		}
	}

}
