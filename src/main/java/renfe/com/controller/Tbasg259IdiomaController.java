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

import renfe.com.model.dto.Tbasg259IdiomaDto;
import renfe.com.service.Tbasg259IdiomaService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg259Idioma")
public class Tbasg259IdiomaController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg259IdiomaService tbasg259IdiomaService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg259IdiomaDto>> getAllTbasg259Idioma(Tbasg259IdiomaDto filter) {
		return new ResponseEntity<>(tbasg259IdiomaService.getAllTbasg259Idioma(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoIdioma}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoIdioma") String cdgoIdioma) {
		Tbasg259IdiomaDto tbasg259IdiomaData = tbasg259IdiomaService.findByCdgoIdioma(cdgoIdioma);

		if (tbasg259IdiomaData != null) {
			return new ResponseEntity<>(tbasg259IdiomaData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg259IdiomaDto> createTbasg259Idioma(@RequestBody Tbasg259IdiomaDto tbasg259IdiomaDto) {
		try {
			return new ResponseEntity<>(tbasg259IdiomaService.createTbasg259Idioma(tbasg259IdiomaDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg259Idioma {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoIdioma}")
	public ResponseEntity<Tbasg259IdiomaDto> updateTbasg259Idioma(@PathVariable("cdgoIdioma") String cdgoIdioma,
			@RequestBody Tbasg259IdiomaDto tbasg259IdiomaDto) {
		try {
			Tbasg259IdiomaDto tbasg259IdiomaData = tbasg259IdiomaService.updateTbasg259Idioma(cdgoIdioma,
					tbasg259IdiomaDto);
			if (tbasg259IdiomaData != null) {
				return new ResponseEntity<>(tbasg259IdiomaData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg259Idioma []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoIdioma}")
	public ResponseEntity<HttpStatus> deleteTbasg259Idioma(@PathVariable("cdgoIdioma") String cdgoIdioma) {
		try {
			tbasg259IdiomaService.deleteTbasg259Idioma(cdgoIdioma);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg259Idioma []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg259IdiomaDto>> findByCdgoIdiomaIn(List<String> cdgoIdioma) {
		try {
			List<Tbasg259IdiomaDto> tbasg259IdiomaDto = tbasg259IdiomaService.findByCdgoIdiomaIn(cdgoIdioma);

			if (tbasg259IdiomaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg259IdiomaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoIdiomaIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-lista-idiomas")
	public ResponseEntity<List<Tbasg259IdiomaDto>> getListaIdiomas() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg259IdiomaDto> tbasg259IdiomaDto = tbasg259IdiomaService.getListaIdiomas();

			if (tbasg259IdiomaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg259IdiomaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getListaIdiomas []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-lista-idiomas-activos")
	public ResponseEntity<List<Tbasg259IdiomaDto>> getListaIdiomasActivos() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg259IdiomaDto> tbasg259IdiomaDto = tbasg259IdiomaService.getListaIdiomasActivos();

			if (tbasg259IdiomaDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg259IdiomaDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getListaIdiomas []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
