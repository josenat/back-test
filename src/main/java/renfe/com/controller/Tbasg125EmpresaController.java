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

import renfe.com.model.dto.Tbasg125EmpresaDto;
import renfe.com.model.entity.Tbasg125Empresa;
import renfe.com.service.Tbasg125EmpresaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg125Empresa")
public class Tbasg125EmpresaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg125EmpresaService tbasg125EmpresaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg125EmpresaDto>> getAllTbasg125Empresa(Tbasg125EmpresaDto filter) {
		return new ResponseEntity<>(tbasg125EmpresaService.getAllTbasg125Empresa(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoEmpresa}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoEmpresa") Integer cdgoEmpresa) {
		Tbasg125EmpresaDto tbasg125EmpresaData = tbasg125EmpresaService.findByCdgoEmpresa(cdgoEmpresa);

		if (tbasg125EmpresaData != null) {
			return new ResponseEntity<>(tbasg125EmpresaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg125EmpresaDto> createTbasg125Empresa(
			@RequestBody Tbasg125EmpresaDto tbasg125EmpresaDto) {
		try {
			return new ResponseEntity<>(tbasg125EmpresaService.createTbasg125Empresa(tbasg125EmpresaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg125Empresa {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoEmpresa}")
	public ResponseEntity<Tbasg125EmpresaDto> updateTbasg125Empresa(@PathVariable("cdgoEmpresa") Integer cdgo,
			@RequestBody Tbasg125EmpresaDto body) {
		try {
			Tbasg125EmpresaDto tbasg125EmpresaData = tbasg125EmpresaService.updateTbasg125Empresa(cdgo, body);
			if (tbasg125EmpresaData != null) {
				return new ResponseEntity<>(tbasg125EmpresaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg125Empresa []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoEmpresa}")
	public ResponseEntity<HttpStatus> deleteTbasg125Empresa(@PathVariable("cdgoEmpresa") Integer cdgoEmpresa) {
		try {
			tbasg125EmpresaService.deleteTbasg125Empresa(cdgoEmpresa);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg125Empresa []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg125EmpresaDto>> findByCdgoEmpresaIn(List<Integer> cdgoEmpresa) {
		try {
			List<Tbasg125EmpresaDto> tbasg125EmpresaDto = tbasg125EmpresaService.findByCdgoEmpresaIn(cdgoEmpresa);

			if (tbasg125EmpresaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg125EmpresaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoEmpresaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-empresa-count")
	public ResponseEntity<?> getEmpresaCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg125EmpresaDto> tbasg125EmpresaDto = tbasg125EmpresaService.getEmpresaCount();

			if (tbasg125EmpresaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg125EmpresaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEmpresaCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-empresa-view-list-ascendente")
	public ResponseEntity<List<Tbasg125EmpresaDto>> getEmpresaViewListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg125EmpresaDto> tbasg125EmpresaDto = tbasg125EmpresaService.getEmpresaViewListAscendente();

			if (tbasg125EmpresaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg125EmpresaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEmpresaViewListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-empresa-view-list-descendente")
	public ResponseEntity<List<Tbasg125EmpresaDto>> getEmpresaViewListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg125EmpresaDto> tbasg125EmpresaDto = tbasg125EmpresaService.getEmpresaViewListDescendente();

			if (tbasg125EmpresaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg125EmpresaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEmpresaViewListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-empresa-view-list-ascendente-e-m-p-r-e-s-a")
	public ResponseEntity<List<Tbasg125EmpresaDto>> getEmpresaViewListAscendenteEMPRESA() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg125EmpresaDto> tbasg125EmpresaDto = tbasg125EmpresaService.getEmpresaViewListAscendenteEMPRESA();

			if (tbasg125EmpresaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg125EmpresaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEmpresaViewListAscendenteEMPRESA []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-empresa-view-list-descendente-e-m-p-r-e-s-a")
	public ResponseEntity<List<Tbasg125EmpresaDto>> getEmpresaViewListDescendenteEMPRESA() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg125EmpresaDto> tbasg125EmpresaDto = tbasg125EmpresaService.getEmpresaViewListDescendenteEMPRESA();

			if (tbasg125EmpresaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg125EmpresaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEmpresaViewListDescendenteEMPRESA []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-empresa-list-ascendente")
	public ResponseEntity<List<Tbasg125EmpresaDto>> getEmpresaListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg125EmpresaDto> tbasg125EmpresaDto = tbasg125EmpresaService.getEmpresaListAscendente();

			if (tbasg125EmpresaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg125EmpresaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEmpresaListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-empresa-list-descendente")
	public ResponseEntity<List<Tbasg125EmpresaDto>> getEmpresaListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg125EmpresaDto> tbasg125EmpresaDto = tbasg125EmpresaService.getEmpresaListDescendente();

			if (tbasg125EmpresaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg125EmpresaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEmpresaListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-empresa")
	public ResponseEntity<List<Tbasg125EmpresaDto>> getEmpresa(Integer cdgoEmpresa) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg125EmpresaDto> tbasg125EmpresaDto = tbasg125EmpresaService.getEmpresa(cdgoEmpresa);

			if (tbasg125EmpresaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg125EmpresaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEmpresa []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-empresa-cif")
	public ResponseEntity<List<Tbasg125EmpresaDto>> getEmpresaCif(String desgCif) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg125EmpresaDto> tbasg125EmpresaDto = tbasg125EmpresaService.getEmpresaCif(desgCif);

			if (tbasg125EmpresaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg125EmpresaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEmpresaCif []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-empresa-cif-inactive")
	public ResponseEntity<List<Tbasg125EmpresaDto>> getEmpresaCifInactive(String desgCif) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg125EmpresaDto> tbasg125EmpresaDto = tbasg125EmpresaService.getEmpresaCifInactive(desgCif);

			if (tbasg125EmpresaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg125EmpresaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEmpresaCifInactive []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-empresa-view-list-active")
	public ResponseEntity<List<Tbasg125EmpresaDto>> getEmpresaViewListActive() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg125EmpresaDto> tbasg125EmpresaDto = tbasg125EmpresaService.getEmpresaViewListActive();

			if (tbasg125EmpresaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg125EmpresaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEmpresaViewListActive []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-empresa-combo-list-active")
	public ResponseEntity<List<Tbasg125EmpresaDto>> getEmpresaComboListActive() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg125EmpresaDto> tbasg125EmpresaDto = tbasg125EmpresaService.getEmpresaComboListActive();

			if (tbasg125EmpresaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg125EmpresaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEmpresaComboListActive []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-empresa")
	public ResponseEntity<?> insertEmpresa(@RequestBody Tbasg125Empresa bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg125EmpresaDto = tbasg125EmpresaService.insertEmpresa(bean);
			return new ResponseEntity<>(tbasg125EmpresaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertEmpresa []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-empresa")
	public ResponseEntity<?> updateEmpresa(@RequestBody Tbasg125Empresa bean) {
		try {
			int tbasg125EmpresaDto = tbasg125EmpresaService.updateEmpresa(bean);
			return new ResponseEntity<>(tbasg125EmpresaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateEmpresa []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/delete-empresa")
	public ResponseEntity<?> deleteEmpresa(@RequestBody Tbasg125Empresa bean) {
		try {
			int tbasg125EmpresaDto = tbasg125EmpresaService.deleteEmpresa(bean);
			return new ResponseEntity<>(tbasg125EmpresaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteEmpresa []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/reactive-empresa")
	public ResponseEntity<?> reactiveEmpresa(@RequestBody Tbasg125Empresa bean) {
		try {
			int tbasg125EmpresaDto = tbasg125EmpresaService.reactiveEmpresa(bean);
			return new ResponseEntity<>(tbasg125EmpresaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("reactiveEmpresa []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/un-delete-empresa")
	public ResponseEntity<?> unDeleteEmpresa(Tbasg125Empresa bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg125EmpresaDto = tbasg125EmpresaService.unDeleteEmpresa(bean);
			return new ResponseEntity<>(tbasg125EmpresaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("unDeleteEmpresa []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
