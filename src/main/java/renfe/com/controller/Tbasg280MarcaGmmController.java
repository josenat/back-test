package renfe.com.controller;

import java.sql.Date;
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

import renfe.com.model.dto.Tbasg280MarcaGmmDto;
import renfe.com.model.entity.Tbasg280MarcaGmm;
import renfe.com.service.Tbasg280MarcaGmmService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg280MarcaGmm")
public class Tbasg280MarcaGmmController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg280MarcaGmmService tbasg280MarcaGmmService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg280MarcaGmmDto>> getAllTbasg280MarcaGmm(Tbasg280MarcaGmmDto filter) {
		return new ResponseEntity<>(tbasg280MarcaGmmService.getAllTbasg280MarcaGmm(filter), HttpStatus.OK);
	}

	@GetMapping("/{desgMatricula}/{fchaAct}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("desgMatricula") String desgMatricula,
			@PathVariable("fchaAct") Date fchaAct) {
		Tbasg280MarcaGmmDto tbasg280MarcaGmmData = tbasg280MarcaGmmService.findByDesgMatriculaFchaAct(desgMatricula,
				fchaAct);

		if (tbasg280MarcaGmmData != null) {
			return new ResponseEntity<>(tbasg280MarcaGmmData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg280MarcaGmmDto> createTbasg280MarcaGmm(
			@RequestBody Tbasg280MarcaGmmDto tbasg280MarcaGmmDto) {
		try {
			return new ResponseEntity<>(tbasg280MarcaGmmService.createTbasg280MarcaGmm(tbasg280MarcaGmmDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg280MarcaGmm {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{desgMatricula}/{fchaAct}")
	public ResponseEntity<Tbasg280MarcaGmmDto> updateTbasg280MarcaGmm(
			@PathVariable("desgMatricula") String desgMatricula, @PathVariable("fchaAct") Date fchaAct,
			@RequestBody Tbasg280MarcaGmmDto tbasg280MarcaGmmDto) {
		try {
			Tbasg280MarcaGmmDto tbasg280MarcaGmmData = tbasg280MarcaGmmService.updateTbasg280MarcaGmm(desgMatricula,
					fchaAct, tbasg280MarcaGmmDto);
			if (tbasg280MarcaGmmData != null) {
				return new ResponseEntity<>(tbasg280MarcaGmmData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg280MarcaGmm []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{desgMatricula}/{fchaAct}")
	public ResponseEntity<HttpStatus> deleteTbasg280MarcaGmm(@PathVariable("desgMatricula") String desgMatricula,
			@PathVariable("fchaAct") Date fchaAct) {
		try {
			tbasg280MarcaGmmService.deleteTbasg280MarcaGmm(desgMatricula, fchaAct);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg280MarcaGmm []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg280MarcaGmmDto>> findByDesgMatriculaFchaActIn(List<String> desgMatricula,
			List<Date> fchaAct) {
		try {
			List<Tbasg280MarcaGmmDto> tbasg280MarcaGmmDto = tbasg280MarcaGmmService
					.findByDesgMatriculaFchaActIn(desgMatricula, fchaAct);

			if (tbasg280MarcaGmmDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg280MarcaGmmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByDesgMatriculaFchaActIn {}", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-a-s-g280")
	public ResponseEntity<List<Tbasg280MarcaGmmDto>> getASG280(String desgMatricula) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg280MarcaGmmDto> tbasg280MarcaGmm = tbasg280MarcaGmmService.getASG280(desgMatricula);

			if (tbasg280MarcaGmm.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg280MarcaGmm, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getASG280 []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional
	@GetMapping("/insert-fichero-a-s-g280")
	public ResponseEntity<?> insertFicheroASG280(Tbasg280MarcaGmm bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg280MarcaGmmDto = tbasg280MarcaGmmService.insertFicheroASG280(bean);
			return new ResponseEntity<>(tbasg280MarcaGmmDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertFicheroASG280 []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
