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

import renfe.com.model.dto.Tbasg110PsicomotiDto;
import renfe.com.model.entity.Tbasg110Psicomoti;
import renfe.com.service.Tbasg110PsicomotiService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg110Psicomoti")
public class Tbasg110PsicomotiController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg110PsicomotiService tbasg110PsicomotiService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg110PsicomotiDto>> getAllTbasg110Psicomoti(Tbasg110PsicomotiDto filter) {
		return new ResponseEntity<>(tbasg110PsicomotiService.getAllTbasg110Psicomoti(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoMotivo}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoMotivo") Integer cdgoMotivo) {
		Tbasg110PsicomotiDto tbasg110PsicomotiData = tbasg110PsicomotiService.findByCdgoMotivo(cdgoMotivo);

		if (tbasg110PsicomotiData != null) {
			return new ResponseEntity<>(tbasg110PsicomotiData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg110PsicomotiDto> createTbasg110Psicomoti(
			@RequestBody Tbasg110PsicomotiDto tbasg110PsicomotiDto) {
		try {
			return new ResponseEntity<>(tbasg110PsicomotiService.createTbasg110Psicomoti(tbasg110PsicomotiDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg110Psicomoti {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoMotivo}")
	public ResponseEntity<Tbasg110PsicomotiDto> updateTbasg110Psicomoti(@PathVariable("cdgoMotivo") Integer cdgo,
			@RequestBody Tbasg110PsicomotiDto body) {
		try {
			Tbasg110PsicomotiDto tbasg110PsicomotiData = tbasg110PsicomotiService.updateTbasg110Psicomoti(cdgo, body);
			if (tbasg110PsicomotiData != null) {
				return new ResponseEntity<>(tbasg110PsicomotiData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg110Psicomoti []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoMotivo}")
	public ResponseEntity<HttpStatus> deleteTbasg110Psicomoti(@PathVariable("cdgoMotivo") Integer cdgoMotivo) {
		try {
			tbasg110PsicomotiService.deleteTbasg110Psicomoti(cdgoMotivo);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg110Psicomoti []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg110PsicomotiDto>> findByCdgoMotivoIn(List<Integer> cdgoMotivo) {
		try {
			List<Tbasg110PsicomotiDto> tbasg110PsicomotiDto = tbasg110PsicomotiService.findByCdgoMotivoIn(cdgoMotivo);

			if (tbasg110PsicomotiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg110PsicomotiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoMotivoIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-psico-moti-count")
	public ResponseEntity<?> getPsicoMotiCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg110PsicomotiDto> tbasg110PsicomotiDto = tbasg110PsicomotiService.getPsicoMotiCount();

			if (tbasg110PsicomotiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg110PsicomotiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPsicoMotiCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-psico-moti-list-ascendente")
	public ResponseEntity<List<Tbasg110PsicomotiDto>> getPsicoMotiListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg110PsicomotiDto> tbasg110PsicomotiDto = tbasg110PsicomotiService.getPsicoMotiListAscendente();

			if (tbasg110PsicomotiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg110PsicomotiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPsicoMotiListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-psico-moti-list-descendente")
	public ResponseEntity<List<Tbasg110PsicomotiDto>> getPsicoMotiListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg110PsicomotiDto> tbasg110PsicomotiDto = tbasg110PsicomotiService.getPsicoMotiListDescendente();

			if (tbasg110PsicomotiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg110PsicomotiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPsicoMotiListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-psico-moti-active-list-ascendente")
	public ResponseEntity<List<Tbasg110PsicomotiDto>> getPsicoMotiActiveListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg110PsicomotiDto> tbasg110PsicomotiDto = tbasg110PsicomotiService
					.getPsicoMotiActiveListAscendente();

			if (tbasg110PsicomotiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg110PsicomotiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPsicoMotiActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-psico-moti-active-list-descendente")
	public ResponseEntity<List<Tbasg110PsicomotiDto>> getPsicoMotiActiveListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg110PsicomotiDto> tbasg110PsicomotiDto = tbasg110PsicomotiService
					.getPsicoMotiActiveListDescendente();

			if (tbasg110PsicomotiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg110PsicomotiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPsicoMotiActiveListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-psico-moti")
	public ResponseEntity<List<Tbasg110PsicomotiDto>> getPsicoMoti(Integer cdgoMotivo) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg110PsicomotiDto> tbasg110PsicomotiDto = tbasg110PsicomotiService.getPsicoMoti(cdgoMotivo);

			if (tbasg110PsicomotiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg110PsicomotiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPsicoMoti []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-psico-moti")
	public ResponseEntity<?> insertPsicoMoti(@RequestBody Tbasg110Psicomoti bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg110PsicomotiDto = tbasg110PsicomotiService.insertPsicoMoti(bean);
			return new ResponseEntity<>(tbasg110PsicomotiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertPsicoMoti []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-psico-moti")
	public ResponseEntity<?> updatePsicoMoti(@RequestBody Tbasg110Psicomoti bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg110PsicomotiDto = tbasg110PsicomotiService.updatePsicoMoti(bean);
			return new ResponseEntity<>(tbasg110PsicomotiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updatePsicoMoti []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-psico-moti")
	public ResponseEntity<?> estadoPsicoMoti(@RequestBody Tbasg110Psicomoti bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg110PsicomotiDto = tbasg110PsicomotiService.estadoPsicoMoti(bean);
			return new ResponseEntity<>(tbasg110PsicomotiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoPsicoMoti []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
