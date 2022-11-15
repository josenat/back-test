package renfe.com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import renfe.com.dto.GetErrListParam;
import renfe.com.model.dto.Tbasg200ErrFichDto;
import renfe.com.service.Tbasg200ErrFichService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg200ErrFich")
public class Tbasg200ErrFichController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg200ErrFichService tbasg200ErrFichService;
	
	@GetMapping("/get-err-fich-list")
	public ResponseEntity<List<Tbasg200ErrFichDto>> getErrFichList(GetErrListParam filter) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg200ErrFichDto> tbasg200ErrFichDto = tbasg200ErrFichService.getErrFichList(filter);

			if (tbasg200ErrFichDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg200ErrFichDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getErrFichList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-err-fich")
	public ResponseEntity<List<Tbasg200ErrFichDto>> getErrFich(Integer cdgoError) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg200ErrFichDto> tbasg200ErrFichDto = tbasg200ErrFichService.getErrFich(cdgoError);

			if (tbasg200ErrFichDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg200ErrFichDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getErrFich []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
