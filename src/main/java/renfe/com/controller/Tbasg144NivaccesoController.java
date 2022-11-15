package renfe.com.controller;

import java.nio.file.LinkOption;
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

import renfe.com.model.dto.Tbasg144NivaccesoDto;
import renfe.com.service.Tbasg144NivaccesoService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg144Nivacceso")
public class Tbasg144NivaccesoController {

    @Autowired
    protected Logger logger;

    @Autowired
    private Tbasg144NivaccesoService tbasg144NivaccesoService;

    @GetMapping("")
    public ResponseEntity<List<Tbasg144NivaccesoDto>> getAllTbasg144Nivacceso(Tbasg144NivaccesoDto filter) {
        return new ResponseEntity<>(tbasg144NivaccesoService.getAllTbasg144Nivacceso(filter), HttpStatus.OK);
    }

    @GetMapping("/{cdgoNivel}")
    public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoNivel") String cdgoNivel) {
        Tbasg144NivaccesoDto tbasg144NivaccesoData = tbasg144NivaccesoService.findByCdgoNivel(cdgoNivel);

        if (tbasg144NivaccesoData != null) {
            return new ResponseEntity<>(tbasg144NivaccesoData, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Tbasg144NivaccesoDto> createTbasg144Nivacceso(@RequestBody Tbasg144NivaccesoDto tbasg144NivaccesoDto) {
        try {
            return new ResponseEntity<>(tbasg144NivaccesoService.createTbasg144Nivacceso(tbasg144NivaccesoDto), HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("createTbasg144Nivacceso {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{cdgoNivel}")
    public ResponseEntity<Tbasg144NivaccesoDto> updateTbasg144Nivacceso(@PathVariable("cdgoNivel") String cdgoNivel, @RequestBody Tbasg144NivaccesoDto tbasg144NivaccesoDto) {
        try {
            Tbasg144NivaccesoDto tbasg144NivaccesoData = tbasg144NivaccesoService.updateTbasg144Nivacceso(cdgoNivel, tbasg144NivaccesoDto);
            if (tbasg144NivaccesoData != null) {
                return new ResponseEntity<>(tbasg144NivaccesoData, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("updateTbasg144Nivacceso []", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{cdgoNivel}")
    public ResponseEntity<HttpStatus> deleteTbasg144Nivacceso(@PathVariable("cdgoNivel") String cdgoNivel) {
        try {
            tbasg144NivaccesoService.deleteTbasg144Nivacceso(cdgoNivel);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.error("deleteTbasg144Nivacceso []", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Tbasg144NivaccesoDto>> findByCdgoNivelIn(List<String> cdgoNivel) {
        try {
            List<Tbasg144NivaccesoDto> tbasg144NivaccesoDto = tbasg144NivaccesoService.findByCdgoNivelIn(cdgoNivel);

            if (tbasg144NivaccesoDto.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tbasg144NivaccesoDto, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("findByCdgoNivelIn {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@GetMapping("/get-niv-acceso-count")
	public ResponseEntity<?> getNivAccesoCount() {
		// Generated from a SELECT found in an XML
		try {
			//List<Tbasg144NivaccesoDto> tbasg144NivaccesoDto = tbasg144NivaccesoService.getNivAccesoCount();
			Long tbasg144NivaccesoDto = tbasg144NivaccesoService.getNivAccesoCount();
			/*if (tbasg144NivaccesoDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}*/
			return new ResponseEntity<>(tbasg144NivaccesoDto, HttpStatus.OK);

        } catch (Exception e) {
            logger.error("getNivAccesoCount []", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-niv-acceso-all")
    public ResponseEntity<?> getNivAccesoAll() {
        // Generated from a SELECT found in an XML
        try {
            List<Tbasg144NivaccesoDto> tbasg144NivaccesoDto = tbasg144NivaccesoService.getNivAccesoAll();

            if (tbasg144NivaccesoDto.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tbasg144NivaccesoDto, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("getNivAccesoAll []", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
