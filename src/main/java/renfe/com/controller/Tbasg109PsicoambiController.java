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

import renfe.com.model.dto.Tbasg109PsicoambiDto;
import renfe.com.model.entity.Tbasg109Psicoambi;
import renfe.com.service.Tbasg109PsicoambiService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg109Psicoambi")
public class Tbasg109PsicoambiController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg109PsicoambiService tbasg109PsicoambiService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg109PsicoambiDto>> getAllTbasg109Psicoambi(Tbasg109PsicoambiDto filter) {
		return new ResponseEntity<>(tbasg109PsicoambiService.getAllTbasg109Psicoambi(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoPsicamb}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoPsicamb") Integer cdgoPsicamb) {
		Tbasg109PsicoambiDto tbasg109PsicoambiData = tbasg109PsicoambiService.findByCdgoPsicamb(cdgoPsicamb);

		if (tbasg109PsicoambiData != null) {
			return new ResponseEntity<>(tbasg109PsicoambiData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg109PsicoambiDto> createTbasg109Psicoambi(
			@RequestBody Tbasg109PsicoambiDto tbasg109PsicoambiDto) {
		try {
			return new ResponseEntity<>(tbasg109PsicoambiService.createTbasg109Psicoambi(tbasg109PsicoambiDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg109Psicoambi {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoPsicamb}")
	public ResponseEntity<Tbasg109PsicoambiDto> updateTbasg109Psicoambi(@PathVariable("cdgoPsicamb") Integer cdgo,
			@RequestBody Tbasg109PsicoambiDto body) {
		try {
			Tbasg109PsicoambiDto tbasg109PsicoambiData = tbasg109PsicoambiService.updateTbasg109Psicoambi(cdgo, body);
			if (tbasg109PsicoambiData != null) {
				return new ResponseEntity<>(tbasg109PsicoambiData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg109Psicoambi []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoPsicamb}")
	public ResponseEntity<HttpStatus> deleteTbasg109Psicoambi(@PathVariable("cdgoPsicamb") Integer cdgoPsicamb) {
		try {
			tbasg109PsicoambiService.deleteTbasg109Psicoambi(cdgoPsicamb);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg109Psicoambi []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg109PsicoambiDto>> findByCdgoPsicambIn(List<Integer> cdgoPsicamb) {
		try {
			List<Tbasg109PsicoambiDto> tbasg109PsicoambiDto = tbasg109PsicoambiService.findByCdgoPsicambIn(cdgoPsicamb);

			if (tbasg109PsicoambiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg109PsicoambiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoPsicambIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-psico-ambi-list-count")
	public ResponseEntity<?> getPsicoAmbiListCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg109PsicoambiDto> tbasg109PsicoambiDto = tbasg109PsicoambiService.getPsicoAmbiListCount();

			if (tbasg109PsicoambiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg109PsicoambiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPsicoAmbiListCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-psico-ambi-list-ascendente")
	public ResponseEntity<List<Tbasg109PsicoambiDto>> getPsicoAmbiListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg109PsicoambiDto> tbasg109PsicoambiDto = tbasg109PsicoambiService.getPsicoAmbiListAscendente();

			if (tbasg109PsicoambiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg109PsicoambiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPsicoAmbiListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-psico-ambi-list-descendente")
	public ResponseEntity<List<Tbasg109PsicoambiDto>> getPsicoAmbiListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg109PsicoambiDto> tbasg109PsicoambiDto = tbasg109PsicoambiService.getPsicoAmbiListDescendente();

			if (tbasg109PsicoambiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg109PsicoambiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPsicoAmbiListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//Esta
	@GetMapping("/get-psico-ambi-active-list-ascendente")
	public ResponseEntity<List<Tbasg109PsicoambiDto>> getPsicoAmbiActiveListAscendente1() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg109PsicoambiDto> tbasg109PsicoambiDto = tbasg109PsicoambiService
					.getPsicoAmbiActiveListAscendente();

			if (tbasg109PsicoambiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg109PsicoambiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPsicoAmbiActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-psico-ambi-active-list-ascendente1")
	public ResponseEntity<List<Tbasg109PsicoambiDto>> getPsicoAmbiActiveListAscendente2() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg109PsicoambiDto> tbasg109PsicoambiDto = tbasg109PsicoambiService
					.getPsicoAmbiActiveListAscendente1();

			if (tbasg109PsicoambiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg109PsicoambiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPsicoAmbiActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-psico-ambi-active-list-ascendente2")
	public ResponseEntity<List<Tbasg109PsicoambiDto>> getPsicoAmbiActiveListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg109PsicoambiDto> tbasg109PsicoambiDto = tbasg109PsicoambiService
					.getPsicoAmbiActiveListAscendente2();

			if (tbasg109PsicoambiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg109PsicoambiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPsicoAmbiActiveListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-psico-ambi-active-list-descendente")
	public ResponseEntity<List<Tbasg109PsicoambiDto>> getPsicoAmbiActiveListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg109PsicoambiDto> tbasg109PsicoambiDto = tbasg109PsicoambiService
					.getPsicoAmbiActiveListDescendente();

			if (tbasg109PsicoambiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg109PsicoambiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPsicoAmbiActiveListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-psico-ambi")
	public ResponseEntity<List<Tbasg109PsicoambiDto>> getPsicoAmbi(Integer cdgoPsicamb) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg109PsicoambiDto> tbasg109PsicoambiDto = tbasg109PsicoambiService.getPsicoAmbi(cdgoPsicamb);

			if (tbasg109PsicoambiDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg109PsicoambiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getPsicoAmbi []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-psico-ambi")
	public ResponseEntity<?> insertPsicoAmbi(@RequestBody Tbasg109Psicoambi bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg109PsicoambiDto = tbasg109PsicoambiService.insertPsicoAmbi(bean);
			return new ResponseEntity<>(tbasg109PsicoambiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertPsicoAmbi []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-psico-ambi")
	public ResponseEntity<?> updatePsicoAmbi(@RequestBody Tbasg109Psicoambi bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg109PsicoambiDto = tbasg109PsicoambiService.updatePsicoAmbi(bean);
			return new ResponseEntity<>(tbasg109PsicoambiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updatePsicoAmbi []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-psico-ambi")
	public ResponseEntity<?> estadoPsicoAmbi(@RequestBody Tbasg109Psicoambi bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg109PsicoambiDto = tbasg109PsicoambiService.estadoPsicoAmbi(bean);
			return new ResponseEntity<>(tbasg109PsicoambiDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoPsicoAmbi []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
