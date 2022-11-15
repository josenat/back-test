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

import renfe.com.model.dto.Tbasg269SegurDto;
import renfe.com.model.entity.Tbasg269Segur;
import renfe.com.service.Tbasg269SegurService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg269Segur")
public class Tbasg269SegurController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg269SegurService tbasg269SegurService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg269SegurDto>> getAllTbasg269Segur(Tbasg269SegurDto filter) {
		return new ResponseEntity<>(tbasg269SegurService.getAllTbasg269Segur(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoSeguridad}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoSeguridad") Integer cdgoSeguridad) {
		Tbasg269SegurDto tbasg269SegurData = tbasg269SegurService.findByCdgoSeguridad(cdgoSeguridad);

		if (tbasg269SegurData != null) {
			return new ResponseEntity<>(tbasg269SegurData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg269SegurDto> createTbasg269Segur(@RequestBody Tbasg269SegurDto tbasg269SegurDto) {
		try {
			return new ResponseEntity<>(tbasg269SegurService.createTbasg269Segur(tbasg269SegurDto), HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg269Segur {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoSeguridad}")
	public ResponseEntity<Tbasg269SegurDto> updateTbasg269Segur(@PathVariable("cdgoSeguridad") Integer cdgo,
			@RequestBody Tbasg269SegurDto body) {
		try {
			Tbasg269SegurDto tbasg269SegurData = tbasg269SegurService.updateTbasg269Segur(cdgo, body);
			if (tbasg269SegurData != null) {
				return new ResponseEntity<>(tbasg269SegurData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg269Segur []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoSeguridad}")
	public ResponseEntity<HttpStatus> deleteTbasg269Segur(@PathVariable("cdgoSeguridad") Integer cdgoSeguridad) {
		try {
			tbasg269SegurService.deleteTbasg269Segur(cdgoSeguridad);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg269Segur []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg269SegurDto>> findByCdgoSeguridadIn(List<Integer> cdgoSeguridad) {
		try {
			List<Tbasg269SegurDto> tbasg269SegurDto = tbasg269SegurService.findByCdgoSeguridadIn(cdgoSeguridad);

			if (tbasg269SegurDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg269SegurDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoSeguridadIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-seguridad-l-o-p-d")
	public ResponseEntity<?> insertSeguridadLOPD(Tbasg269Segur bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg269SegurDto = tbasg269SegurService.insertSeguridadLOPD(bean);
			return new ResponseEntity<>(tbasg269SegurDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertSeguridadLOPD []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
