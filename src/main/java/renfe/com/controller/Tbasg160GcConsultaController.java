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

import renfe.com.model.dto.Tbasg160GcConsultaDto;
import renfe.com.model.entity.Tbasg160GcConsulta;
import renfe.com.service.Tbasg160GcConsultaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg160GcConsulta")
public class Tbasg160GcConsultaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg160GcConsultaService tbasg160GcConsultaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg160GcConsultaDto>> getAllTbasg160GcConsulta(Tbasg160GcConsultaDto filter) {
		return new ResponseEntity<>(tbasg160GcConsultaService.getAllTbasg160GcConsulta(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoConsulta}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoConsulta") Integer cdgoConsulta) {
		Tbasg160GcConsultaDto tbasg160GcConsultaData = tbasg160GcConsultaService.findByCdgoConsulta(cdgoConsulta);

		if (tbasg160GcConsultaData != null) {
			return new ResponseEntity<>(tbasg160GcConsultaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg160GcConsultaDto> createTbasg160GcConsulta(
			@RequestBody Tbasg160GcConsultaDto tbasg160GcConsultaDto) {
		try {
			return new ResponseEntity<>(tbasg160GcConsultaService.createTbasg160GcConsulta(tbasg160GcConsultaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg160GcConsulta {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoConsulta}")
	public ResponseEntity<Tbasg160GcConsultaDto> updateTbasg160GcConsulta(@PathVariable("cdgoConsulta") Integer cdgo,
			@RequestBody Tbasg160GcConsultaDto body) {
		try {
			Tbasg160GcConsultaDto tbasg160GcConsultaData = tbasg160GcConsultaService.updateTbasg160GcConsulta(cdgo,
					body);
			if (tbasg160GcConsultaData != null) {
				return new ResponseEntity<>(tbasg160GcConsultaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg160GcConsulta []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoConsulta}")
	public ResponseEntity<HttpStatus> deleteTbasg160GcConsulta(@PathVariable("cdgoConsulta") Integer cdgoConsulta) {
		try {
			tbasg160GcConsultaService.deleteTbasg160GcConsulta(cdgoConsulta);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg160GcConsulta []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg160GcConsultaDto>> findByCdgoConsultaIn(List<Integer> cdgoConsulta) {
		try {
			List<Tbasg160GcConsultaDto> tbasg160GcConsultaDto = tbasg160GcConsultaService
					.findByCdgoConsultaIn(cdgoConsulta);

			if (tbasg160GcConsultaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg160GcConsultaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoConsultaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-gc-consultas-list-active")
	public ResponseEntity<List<Tbasg160GcConsultaDto>> getGcConsultasListActive(String desgUsuario) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg160GcConsultaDto> tbasg160GcConsultaDto = tbasg160GcConsultaService
					.getGcConsultasListActive(desgUsuario);

			if (tbasg160GcConsultaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg160GcConsultaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getGcConsultasListActive []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-gc-consulta")
	public ResponseEntity<List<Tbasg160GcConsultaDto>> getGcConsulta(String cdgoConsulta) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg160GcConsultaDto> tbasg160GcConsultaDto = tbasg160GcConsultaService.getGcConsulta(cdgoConsulta);

			if (tbasg160GcConsultaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg160GcConsultaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getGcConsulta []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-gc-consulta")
	public ResponseEntity<?> insertGcConsulta(Tbasg160GcConsulta bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg160GcConsultaDto = tbasg160GcConsultaService.insertGcConsulta(bean);
			return new ResponseEntity<>(tbasg160GcConsultaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertGcConsulta []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update-gc-consulta")
	public ResponseEntity<?> updateGcConsulta(Tbasg160GcConsulta bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg160GcConsultaDto = tbasg160GcConsultaService.updateGcConsulta(bean);
			return new ResponseEntity<>(tbasg160GcConsultaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateGcConsulta []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/delete-gc-consulta")
	public ResponseEntity<?> deleteGcConsulta(Tbasg160GcConsulta bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg160GcConsultaDto = tbasg160GcConsultaService.deleteGcConsulta(bean);
			return new ResponseEntity<>(tbasg160GcConsultaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("deleteGcConsulta []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
