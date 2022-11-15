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

import renfe.com.model.dto.Tbasg122InstruDto;
import renfe.com.model.entity.Tbasg122Instru;
import renfe.com.service.Tbasg122InstruService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg122Instru")
public class Tbasg122InstruController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg122InstruService tbasg122InstruService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg122InstruDto>> getAllTbasg122Instru(Tbasg122InstruDto filter) {
		return new ResponseEntity<>(tbasg122InstruService.getAllTbasg122Instru(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoNif}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoNif") String cdgoNif) {
		Tbasg122InstruDto tbasg122InstruData = tbasg122InstruService.findByCdgoNif(cdgoNif);

		if (tbasg122InstruData != null) {
			return new ResponseEntity<>(tbasg122InstruData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg122InstruDto> createTbasg122Instru(@RequestBody Tbasg122InstruDto tbasg122InstruDto) {
		try {
			return new ResponseEntity<>(tbasg122InstruService.createTbasg122Instru(tbasg122InstruDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg122Instru {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoNif}")
	public ResponseEntity<Tbasg122InstruDto> updateTbasg122Instru(@PathVariable("cdgoNif") String cdgoNif,
			@RequestBody Tbasg122InstruDto tbasg122InstruDto) {
		try {
			Tbasg122InstruDto tbasg122InstruData = tbasg122InstruService.updateTbasg122Instru(cdgoNif,
					tbasg122InstruDto);
			if (tbasg122InstruData != null) {
				return new ResponseEntity<>(tbasg122InstruData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg122Instru []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoNif}")
	public ResponseEntity<HttpStatus> deleteTbasg122Instru(@PathVariable("cdgoNif") String cdgoNif) {
		try {
			tbasg122InstruService.deleteTbasg122Instru(cdgoNif);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg122Instru []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg122InstruDto>> findByCdgoNifIn(List<String> cdgoNif) {
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService.findByCdgoNifIn(cdgoNif);

			if (tbasg122InstruDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoNifIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-intru-for-name")
	public ResponseEntity<List<Tbasg122InstruDto>> getIntruForName(String desgApell1) {
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService.getIntruForName(desgApell1); 
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("getIntruForName []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-instru")
	public ResponseEntity<List<Tbasg122InstruDto>> getInstru(String cdgoNif) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService.getInstru(cdgoNif);

			if (tbasg122InstruDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInstru []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-instru-list-registro-ascendente")
	public ResponseEntity<?> getInstruListRegistroAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService.getInstruListRegistroAscendente();

			if (tbasg122InstruDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInstruListRegistroAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-instru-list-registro-descendente")
	public ResponseEntity<?> getInstruListRegistroDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService.getInstruListRegistroDescendente();

			if (tbasg122InstruDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInstruListRegistroDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-instru-list-ascendente-d-e-s-g_-a-p-e-l-l1")
	public ResponseEntity<List<Tbasg122InstruDto>> getInstruListAscendenteDESG_APELL1() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService.getInstruListAscendenteDESG_APELL1();

			if (tbasg122InstruDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInstruListAscendenteDESG_APELL1 []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-instru-list-ascendente")
	public ResponseEntity<List<Tbasg122InstruDto>> getInstruListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService.getInstruListAscendente();

			if (tbasg122InstruDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInstruListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-instru-list-descendente-d-e-s-g_-a-p-e-l-l1")
	public ResponseEntity<List<Tbasg122InstruDto>> getInstruListDescendenteDESG_APELL1() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService.getInstruListDescendenteDESG_APELL1();

			if (tbasg122InstruDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInstruListDescendenteDESG_APELL1 []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-instru-list-ascendente-c-d-g-o_-n-i-f")
	public ResponseEntity<List<Tbasg122InstruDto>> getInstruListAscendenteCDGO_NIF() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService.getInstruListAscendenteCDGO_NIF();

			if (tbasg122InstruDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInstruListAscendenteCDGO_NIF []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-instru-list-descendente-c-d-g-o_-n-i-f")
	public ResponseEntity<List<Tbasg122InstruDto>> getInstruListDescendenteCDGO_NIF() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService.getInstruListDescendenteCDGO_NIF();

			if (tbasg122InstruDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInstruListDescendenteCDGO_NIF []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-instru-active-list-ascendente-d-e-s-g_-a-p-e-l-l1")
	public ResponseEntity<List<Tbasg122InstruDto>> getInstruActiveListAscendenteDESG_APELL1() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService
					.getInstruActiveListAscendenteDESG_APELL1();

			if (tbasg122InstruDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInstruActiveListAscendenteDESG_APELL1 []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-instru-active-list-descendente-d-e-s-g_-a-p-e-l-l1")
	public ResponseEntity<List<Tbasg122InstruDto>> getInstruActiveListDescendenteDESG_APELL1() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService
					.getInstruActiveListDescendenteDESG_APELL1();

			if (tbasg122InstruDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInstruActiveListDescendenteDESG_APELL1 []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-instru-active-list-ascendente-c-d-g-o_-n-i-f")
	public ResponseEntity<List<Tbasg122InstruDto>> getInstruActiveListAscendenteCDGO_NIF() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService.getInstruActiveListAscendenteCDGO_NIF();

			if (tbasg122InstruDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInstruActiveListAscendenteCDGO_NIF []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-instru-active-list-descendente-c-d-g-o_-n-i-f")
	public ResponseEntity<List<Tbasg122InstruDto>> getInstruActiveListDescendenteCDGO_NIF() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService.getInstruActiveListDescendenteCDGO_NIF();

			if (tbasg122InstruDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInstruActiveListDescendenteCDGO_NIF []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-instru-count")
	public ResponseEntity<?> getInstruCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService.getInstruCount();

			if (tbasg122InstruDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInstruCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-instru-active-list-nombre")
	public ResponseEntity<List<Tbasg122InstruDto>> getInstruActiveListNombre() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService.getInstruActiveListNombre();

			if (tbasg122InstruDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInstruActiveListNombre []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-instru-active-list-ape1-ape2-nom")
	public ResponseEntity<List<Tbasg122InstruDto>> getInstruActiveListApe1Ape2Nom() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService.getInstruActiveListApe1Ape2Nom();

			if (tbasg122InstruDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInstruActiveListApe1Ape2Nom []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-exami-active-list-ape1-ape2-nom")
	public ResponseEntity<List<Tbasg122InstruDto>> getExamiActiveListApe1Ape2Nom() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService.getExamiActiveListApe1Ape2Nom();

			if (tbasg122InstruDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInstruActiveListApe1Ape2Nom []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-instru-active-list-mrca-instru")
	public ResponseEntity<List<Tbasg122InstruDto>> getInstruActiveListMrcaInstru() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService.getInstruActiveListMrcaInstru();

			if (tbasg122InstruDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getInstruActiveListMrcaInstru []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-examin-active-list-mrca-examin")
	public ResponseEntity<List<Tbasg122InstruDto>> getExaminActiveListMrcaExamin() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService.getExaminActiveListMrcaExamin();

			if (tbasg122InstruDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getExaminActiveListMrcaExamin []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/existe-instru-d-n-i")
	public ResponseEntity<?> existeInstruDNI(String cdgoNif) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService.existeInstruDNI(cdgoNif);

			if (tbasg122InstruDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("existeInstruDNI []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-instru")
	public ResponseEntity<?> insertInstru(@RequestBody Tbasg122Instru bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg122InstruDto = tbasg122InstruService.insertInstru(bean);
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertInstru []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-instru")
	public ResponseEntity<?> updateInstru(@RequestBody Tbasg122Instru bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg122InstruDto = tbasg122InstruService.updateInstru(bean);
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateInstru []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-instru")
	public ResponseEntity<?> estadoInstru(@RequestBody Tbasg122Instru bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg122InstruDto = tbasg122InstruService.estadoInstru(bean);
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoInstru []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/un-delete-instru")
	public ResponseEntity<?> unDeleteInstru(Tbasg122Instru bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg122InstruDto = tbasg122InstruService.unDeleteInstru(bean);
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("unDeleteInstru []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-trainer-examiner-status")
	public ResponseEntity<?> getTrainerExaminerStatus(String cdgoNif) {
		try {
			List<Tbasg122InstruDto> tbasg122InstruDto = tbasg122InstruService.getTrainerExaminerStatus(cdgoNif);
			return new ResponseEntity<>(tbasg122InstruDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("getTrainerExaminerStatus []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
