package renfe.com.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import renfe.com.dto.GetActaFormaDTO;
import renfe.com.dto.GetActasPersonaOrderByCdgoActaFormDTO;
import renfe.com.dto.GetCdgoActaFormByTitUltimoDTO;
import renfe.com.dto.GetActaformaResultDTO;
import renfe.com.model.dto.Tbasg121ActaformaDto;
import renfe.com.model.entity.Tbasg121Actaforma;
import renfe.com.service.Tbasg121ActaformaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg121Actaforma")
public class Tbasg121ActaformaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg121ActaformaService tbasg121ActaformaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg121ActaformaDto>> getAllTbasg121Actaforma(Tbasg121ActaformaDto filter) {
		return new ResponseEntity<>(tbasg121ActaformaService.getAllTbasg121Actaforma(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoActaform}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoActaform") Integer cdgoActaform) {
		Tbasg121ActaformaDto tbasg121ActaformaData = tbasg121ActaformaService.findByCdgoActaform(cdgoActaform);

		if (tbasg121ActaformaData != null) {
			return new ResponseEntity<>(tbasg121ActaformaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg121ActaformaDto> createTbasg121Actaforma(
			@RequestBody Tbasg121ActaformaDto tbasg121ActaformaDto) {
		try {
			return new ResponseEntity<>(tbasg121ActaformaService.createTbasg121Actaforma(tbasg121ActaformaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg121Actaforma {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoActaform}")
	public ResponseEntity<Tbasg121ActaformaDto> updateTbasg121Actaforma(@PathVariable("cdgoActaform") Integer cdgo,
			@RequestBody Tbasg121ActaformaDto body) {
		try {
			Tbasg121ActaformaDto tbasg121ActaformaData = tbasg121ActaformaService.updateTbasg121Actaforma(cdgo, body);
			if (tbasg121ActaformaData != null) {
				return new ResponseEntity<>(tbasg121ActaformaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg121Actaforma []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoActaform}")
	public ResponseEntity<HttpStatus> deleteTbasg121Actaforma(@PathVariable("cdgoActaform") Integer cdgoActaform) {
		try {
			tbasg121ActaformaService.deleteTbasg121Actaforma(cdgoActaform);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg121Actaforma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg121ActaformaDto>> findByCdgoActaformIn(List<Integer> cdgoActaform) {
		try {
			List<Tbasg121ActaformaDto> tbasg121ActaformaDto = tbasg121ActaformaService
					.findByCdgoActaformIn(cdgoActaform);

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoActaformIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-expired-acta-forma")
	public ResponseEntity<List<Tbasg121ActaformaDto>> getExpiredActaForma(String fchaCurso) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg121ActaformaDto> tbasg121ActaformaDto = tbasg121ActaformaService.getExpiredActaForma(fchaCurso);

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExpiredActaForma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-no-expired-acta-forma-by-cdgo-expedient")
	public ResponseEntity<List<Tbasg121ActaformaDto>> getNoExpiredActaFormaByCdgoExpedient(String cdgoExpedient,
			String fchaCurso) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg121ActaformaDto> tbasg121ActaformaDto = tbasg121ActaformaService
					.getNoExpiredActaFormaByCdgoExpedient(cdgoExpedient, fchaCurso);

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getNoExpiredActaFormaByCdgoExpedient []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-no-expired-acta-forma-by-cdgo-tit")
	public ResponseEntity<List<Tbasg121ActaformaDto>> getNoExpiredActaFormaByCdgoTit(String cdgoTit, String fchaCurso) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg121ActaformaDto> tbasg121ActaformaDto = tbasg121ActaformaService
					.getNoExpiredActaFormaByCdgoTit(cdgoTit, fchaCurso);

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getNoExpiredActaFormaByCdgoTit []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-actas-persona-order-by-cdgo-acta-form")
	public ResponseEntity<List<GetActasPersonaOrderByCdgoActaFormDTO>> getActasPersonaOrderByCdgoActaForm(Integer cdgoPersona, Integer cdgoExpediente) {
		// Generated from a SELECT found in an XML
		try {
			List<GetActasPersonaOrderByCdgoActaFormDTO> tbasg121ActaformaDto = tbasg121ActaformaService.getActasPersonaOrderByCdgoActaForm(cdgoPersona, cdgoExpediente);

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActaForma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-acta-forma")
	public ResponseEntity<List<Tbasg121ActaformaDto>> getActaForma(String cdgoActaform) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg121ActaformaDto> tbasg121ActaformaDto = tbasg121ActaformaService.getActaForma(cdgoActaform);

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActaForma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-acta-forma-by-cod")
	public ResponseEntity<List<Tbasg121ActaformaDto>> getActaFormaByCod(String cdgoActaform) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg121ActaformaDto> tbasg121ActaformaDto = tbasg121ActaformaService.getActaFormaByCod(cdgoActaform);

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActaFormaByCod []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-actas-forma-by-cods")
	public ResponseEntity<List<Tbasg121ActaformaDto>> getActasFormaByCods() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg121ActaformaDto> tbasg121ActaformaDto = tbasg121ActaformaService.getActasFormaByCods();

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActasFormaByCods []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-acta-forma-list")
	public ResponseEntity<List<Tbasg121ActaformaDto>> getActaFormaList() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg121ActaformaDto> tbasg121ActaformaDto = tbasg121ActaformaService.getActaFormaList();

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActaFormaList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-acta-forma-expediente")
	public ResponseEntity<List<Tbasg121ActaformaDto>> getActaFormaExpediente(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg121ActaformaDto> tbasg121ActaformaDto = tbasg121ActaformaService
					.getActaFormaExpediente(cdgoExpedient);

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActaFormaExpediente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-historic-acta-forma-persona")
	public ResponseEntity<List<GetActaFormaDTO>> getHistoricActaFormaPersona(Integer cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<GetActaFormaDTO> tbasg121ActaformaDto = tbasg121ActaformaService.getHistoricActaFormaPersona(cdgoExpedient);

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActaFormaExpediente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-last-acta-forma")
	public ResponseEntity<List<GetActaFormaDTO>> getLastActaForma(Integer cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<GetActaFormaDTO> tbasg121ActaformaDto = tbasg121ActaformaService
					.getLastActaForma(cdgoExpedient);

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getLastActaForma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-acta-forma-count")
	public ResponseEntity<?> getActaFormaCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg121ActaformaDto> tbasg121ActaformaDto = tbasg121ActaformaService.getActaFormaCount();

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActaFormaCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-actas-expediente")
	public ResponseEntity<List<Tbasg121ActaformaDto>> getActasExpediente(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg121ActaformaDto> tbasg121ActaformaDto = tbasg121ActaformaService
					.getActasExpediente(cdgoExpedient);

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActasExpediente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cdgo-acta-form-by-exp-ultimo")
	public ResponseEntity<?> getCdgoActaFormByExpUltimo(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg121ActaformaDto> tbasg121ActaformaDto = tbasg121ActaformaService
					.getCdgoActaFormByExpUltimo(cdgoExpedient);

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCdgoActaFormByExpUltimo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cdgos-actas-forms-by-exps-ultimo")
	public ResponseEntity<List<Tbasg121ActaformaDto>> getCdgosActasFormsByExpsUltimo() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg121ActaformaDto> tbasg121ActaformaDto = tbasg121ActaformaService.getCdgosActasFormsByExpsUltimo();

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCdgosActasFormsByExpsUltimo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-acta-forma-by-exp")
	public ResponseEntity<List<Tbasg121ActaformaDto>> getActaFormaByExp(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg121ActaformaDto> tbasg121ActaformaDto = tbasg121ActaformaService.getActaFormaByExp(cdgoExpedient);

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActaFormaByExp []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-acta-forma-by-tit")
	public ResponseEntity<List<Tbasg121ActaformaDto>> getActaFormaByTit(String cdgoTit) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg121ActaformaDto> tbasg121ActaformaDto = tbasg121ActaformaService.getActaFormaByTit(cdgoTit);

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getActaFormaByTit []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-exist-acta-expediente")
	public ResponseEntity<?> getExistActaExpediente(String cdgoActaform, String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg121ActaformaDto> tbasg121ActaformaDto = tbasg121ActaformaService
					.getExistActaExpediente(cdgoActaform, cdgoExpedient);

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExistActaExpediente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-exist-acta-acreditacion")
	public ResponseEntity<?> getExistActaAcreditacion(String cdgoActaform, String cdgoAcredita) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg121ActaformaDto> tbasg121ActaformaDto = tbasg121ActaformaService
					.getExistActaAcreditacion(cdgoActaform, cdgoAcredita);

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExistActaAcreditacion []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-exist-acta-acre")
	public ResponseEntity<?> getExistActaAcre(Tbasg121Actaforma bean) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg121ActaformaDto> tbasg121ActaformaDto = tbasg121ActaformaService.getExistActaAcre(bean);

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExistActaAcre []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cdgo-acta-form-by-tit-ultimo")
	public ResponseEntity<?> getCdgoActaFormByTitUltimo(Integer cdgoTit) {
		// Generated from a SELECT found in an XML
		try {
			List<GetCdgoActaFormByTitUltimoDTO> tbasg121ActaformaDto = tbasg121ActaformaService
					.getCdgoActaFormByTitUltimo(cdgoTit);

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCdgoActaFormByTitUltimo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/insert-acta-forma")
	public ResponseEntity<Integer> insertActaForma(@RequestBody Tbasg121Actaforma bean) { 
        ResponseEntity<Integer> result = new ResponseEntity<Integer>(0, HttpStatus.OK);
        		
		try {
			int tbasg121ActaformaDto = tbasg121ActaformaService.insertActaForma(bean);
			result = new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("insertActaForma []", e);
		}

		return result;
	}

	@Transactional
	@GetMapping("/update-acta-forma")
	public ResponseEntity<?> updateActaForma(String cdgoCurso,String descCurso, String descObserva, Integer cdgoCentrofor, String descUsuact, String mrcaActivo, Integer cdgoActaform) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg121ActaformaDto = tbasg121ActaformaService.updateActaForma(cdgoCurso,descCurso,descObserva,cdgoCentrofor,descUsuact,mrcaActivo,cdgoActaform);
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateActaForma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-acta-forma-mantenimiento")
	public ResponseEntity<?> updateActaFormaMantenimiento(Tbasg121Actaforma bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg121ActaformaDto = tbasg121ActaformaService.updateActaFormaMantenimiento(bean);
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateActaFormaMantenimiento []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional
	@GetMapping("/inactive-by-cdgo-acta-forma")
	public ResponseEntity<?> inactiveByCdgoActaForma(String usuAct, Integer cdgoActaform) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg121ActaformaDto = tbasg121ActaformaService.inactiveByCdgoActaForma(usuAct, cdgoActaform);
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("inactiveByCdgoActaForma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-acta-forma")
	public ResponseEntity<?> deleteActaForma(Tbasg121Actaforma bean) {
		// Generated from a DELETE found in an XML
		try {
			int tbasg121ActaformaDto = tbasg121ActaformaService.deleteActaForma(bean);
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteActaForma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-cdgo-acta-fcha-curso-list")
	public ResponseEntity<List<Tbasg121ActaformaDto>> getCdgoActaFchaCursoList(String cdgoExpedient) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg121ActaformaDto> tbasg121ActaformaDto = tbasg121ActaformaService
					.getCdgoActaFchaCursoList(cdgoExpedient);

			if (tbasg121ActaformaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg121ActaformaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getCdgoActaFchaCursoList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
