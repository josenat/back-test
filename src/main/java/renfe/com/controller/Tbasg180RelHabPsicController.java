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

import renfe.com.model.dto.Tbasg180RelHabPsicDto;
import renfe.com.service.Tbasg180RelHabPsicService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg180RelHabPsic")
public class Tbasg180RelHabPsicController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg180RelHabPsicService tbasg180RelHabPsicService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg180RelHabPsicDto>> getAllTbasg180RelHabPsic(Tbasg180RelHabPsicDto filter) {
		return new ResponseEntity<>(tbasg180RelHabPsicService.getAllTbasg180RelHabPsic(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoPsicamb}/{cdgoTipohab}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoPsicamb") Integer cdgoPsicamb,
			@PathVariable("cdgoTipohab") Integer cdgoTipohab) {
		Tbasg180RelHabPsicDto tbasg180RelHabPsicData = tbasg180RelHabPsicService
				.findByCdgoPsicambCdgoTipohab(cdgoPsicamb, cdgoTipohab);

		if (tbasg180RelHabPsicData != null) {
			return new ResponseEntity<>(tbasg180RelHabPsicData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg180RelHabPsicDto> createTbasg180RelHabPsic(
			@RequestBody Tbasg180RelHabPsicDto tbasg180RelHabPsicDto) {
		try {
			return new ResponseEntity<>(tbasg180RelHabPsicService.createTbasg180RelHabPsic(tbasg180RelHabPsicDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg180RelHabPsic {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoPsicamb}/{cdgoTipohab}")
	public ResponseEntity<Tbasg180RelHabPsicDto> updateTbasg180RelHabPsic(
			@PathVariable("cdgoPsicamb") Integer cdgoPsicamb, @PathVariable("cdgoTipohab") Integer cdgoTipohab,
			@RequestBody Tbasg180RelHabPsicDto tbasg180RelHabPsicDto) {
		try {
			Tbasg180RelHabPsicDto tbasg180RelHabPsicData = tbasg180RelHabPsicService
					.updateTbasg180RelHabPsic(cdgoPsicamb, cdgoTipohab, tbasg180RelHabPsicDto);
			if (tbasg180RelHabPsicData != null) {
				return new ResponseEntity<>(tbasg180RelHabPsicData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg180RelHabPsic []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoPsicamb}/{cdgoTipohab}")
	public ResponseEntity<HttpStatus> deleteTbasg180RelHabPsic(@PathVariable("cdgoPsicamb") Integer cdgoPsicamb,
			@PathVariable("cdgoTipohab") Integer cdgoTipohab) {
		try {
			tbasg180RelHabPsicService.deleteTbasg180RelHabPsic(cdgoPsicamb, cdgoTipohab);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg180RelHabPsic []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg180RelHabPsicDto>> findByCdgoPsicambCdgoTipohabIn(List<Integer> cdgoPsicamb,
			List<Integer> cdgoTipohab) {
		try {
			List<Tbasg180RelHabPsicDto> tbasg180RelHabPsicDto = tbasg180RelHabPsicService
					.findByCdgoPsicambCdgoTipohabIn(cdgoPsicamb, cdgoTipohab);

			if (tbasg180RelHabPsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg180RelHabPsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoPsicambCdgoTipohabIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-rel-hab-psic")
	public ResponseEntity<List<Tbasg180RelHabPsicDto>> getRelHabPsic() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg180RelHabPsicDto> tbasg180RelHabPsicDto = tbasg180RelHabPsicService.getRelHabPsic();

			if (tbasg180RelHabPsicDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg180RelHabPsicDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getRelHabPsic []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
