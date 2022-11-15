package renfe.com.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import renfe.com.dto.GetFindTituloConByCdgoPersonaActivo;
import renfe.com.dto.GetMaxEstadoTitCondBySociedadesListDTO;
import renfe.com.dto.GetMaxEstadoTitCondListAllDTO;
import renfe.com.dto.GetTituloConPersonaUltimoDTO;
import renfe.com.dto.SetMaxEstadoTitCondBySociedadesList;
import renfe.com.dto.SetMaxEstadoTitCondListAll;
import renfe.com.model.dto.Tbasg102TituloconDto;
import renfe.com.model.entity.Tbasg102Titulocon;
import renfe.com.service.Tbasg102TituloconService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("asg/api/tbasg102Titulocon")
public class Tbasg102TituloconController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg102TituloconService tbasg102TituloconService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg102TituloconDto>> getAllTbasg102Titulocon(Tbasg102TituloconDto filter) {
		return new ResponseEntity<>(tbasg102TituloconService.getAllTbasg102Titulocon(filter), HttpStatus.OK);
	}

	@GetMapping("/{cdgoTit}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("cdgoTit") Integer cdgoTit) {
		Tbasg102TituloconDto tbasg102TituloconData = tbasg102TituloconService.findByCdgoTit(cdgoTit);

		if (tbasg102TituloconData != null) {
			return new ResponseEntity<>(tbasg102TituloconData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg102TituloconDto> createTbasg102Titulocon(
			@RequestBody Tbasg102TituloconDto tbasg102TituloconDto) {
		try {
			return new ResponseEntity<>(tbasg102TituloconService.createTbasg102Titulocon(tbasg102TituloconDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg102Titulocon {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{cdgoTit}")
	public ResponseEntity<Tbasg102TituloconDto> updateTbasg102Titulocon(@PathVariable("cdgoTit") Integer cdgo,
			@RequestBody Tbasg102TituloconDto body) {
		try {
			Tbasg102TituloconDto tbasg102TituloconData = tbasg102TituloconService.updateTbasg102Titulocon(cdgo, body);
			if (tbasg102TituloconData != null) {
				return new ResponseEntity<>(tbasg102TituloconData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg102Titulocon []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{cdgoTit}")
	public ResponseEntity<HttpStatus> deleteTbasg102Titulocon(@PathVariable("cdgoTit") Integer cdgoTit) {
		try {
			tbasg102TituloconService.deleteTbasg102Titulocon(cdgoTit);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg102Titulocon []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg102TituloconDto>> findByCdgoTitIn(List<Integer> cdgoTit) {
		try {
			List<Tbasg102TituloconDto> tbasg102TituloconDto = tbasg102TituloconService.findByCdgoTitIn(cdgoTit);

			if (tbasg102TituloconDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg102TituloconDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByCdgoTitIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/check-reciclaje-titulo-cond")
	public ResponseEntity<List<Tbasg102TituloconDto>> checkReciclajeTituloCond(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg102TituloconDto> tbasg102TituloconDto = tbasg102TituloconService
					.checkReciclajeTituloCond(cdgoPersona);

			if (tbasg102TituloconDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg102TituloconDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("checkReciclajeTituloCond []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-max-estado-tit-cond-list-all")
	public ResponseEntity<List<GetMaxEstadoTitCondListAllDTO>> getMaxEstadoTitCondListAll(SetMaxEstadoTitCondListAll mapPending) {
		// Generated from a SELECT found in an XML
		try {
			List<GetMaxEstadoTitCondListAllDTO> tbasg102TituloconDto = tbasg102TituloconService.getMaxEstadoTitCondListAll(mapPending);

			if (tbasg102TituloconDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg102TituloconDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getMaxEstadoTitCondListAll []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-max-estado-tit-cond-by-sociedades-list")
	public ResponseEntity<List<GetMaxEstadoTitCondBySociedadesListDTO>> getMaxEstadoTitCondBySociedadesList(SetMaxEstadoTitCondBySociedadesList mapPending) {
		// Generated from a SELECT found in an XML
		try {
			List<GetMaxEstadoTitCondBySociedadesListDTO> tbasg102TituloconDto = tbasg102TituloconService.getMaxEstadoTitCondBySociedadesList(mapPending);

			if (tbasg102TituloconDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg102TituloconDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getMaxEstadoTitCondBySociedadesList []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-titulo-con")
	public ResponseEntity<List<Tbasg102TituloconDto>> getTituloCon(String cdgoTit) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg102TituloconDto> tbasg102TituloconDto = tbasg102TituloconService.getTituloCon(cdgoTit);

			if (tbasg102TituloconDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg102TituloconDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTituloCon []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-titulo-con-active-by-titulo")
	public ResponseEntity<List<Tbasg102TituloconDto>> getTituloConActiveByTitulo(String cdgoTit) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg102TituloconDto> tbasg102TituloconDto = tbasg102TituloconService
					.getTituloConActiveByTitulo(cdgoTit);

			if (tbasg102TituloconDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg102TituloconDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTituloConActiveByTitulo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/check-titulo-to-insert")
	public ResponseEntity<List<Tbasg102TituloconDto>> checkTituloToInsert(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg102TituloconDto> tbasg102TituloconDto = tbasg102TituloconService.checkTituloToInsert(cdgoPersona);

			if (tbasg102TituloconDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg102TituloconDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("checkTituloToInsert []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-titulo-con-persona")
	public ResponseEntity<List<Tbasg102TituloconDto>> getTituloConPersona(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg102TituloconDto> tbasg102TituloconDto = tbasg102TituloconService.getTituloConPersona(cdgoPersona);

			if (tbasg102TituloconDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg102TituloconDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTituloConPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find-titulo-con-by-cdgo-persona-activo")
	public ResponseEntity<List<GetFindTituloConByCdgoPersonaActivo>> findTituloConByCdgoPersonaActivo(Integer cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<GetFindTituloConByCdgoPersonaActivo> tbasg102TituloconDto = tbasg102TituloconService
					.findTituloConByCdgoPersonaActivo(cdgoPersona);

			if (tbasg102TituloconDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg102TituloconDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findTituloConByCdgoPersonaActivo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-titulo-cond-activo-vigente-by-persona")
	public ResponseEntity<List<Tbasg102TituloconDto>> getTituloCondActivoVigenteByPersona(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg102TituloconDto> tbasg102TituloconDto = tbasg102TituloconService
					.getTituloCondActivoVigenteByPersona(cdgoPersona);

			if (tbasg102TituloconDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg102TituloconDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTituloCondActivoVigenteByPersona []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-titulo-cond-activo-vigente-by-titulo")
	public ResponseEntity<List<Tbasg102TituloconDto>> getTituloCondActivoVigenteByTitulo(String cdgoTit) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg102TituloconDto> tbasg102TituloconDto = tbasg102TituloconService
					.getTituloCondActivoVigenteByTitulo(cdgoTit);

			if (tbasg102TituloconDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg102TituloconDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTituloCondActivoVigenteByTitulo []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insert-titulo-con")
	public ResponseEntity<?> insertTituloCon(Tbasg102Titulocon bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg102TituloconDto = tbasg102TituloconService.insertTituloCon(bean);
			return new ResponseEntity<>(tbasg102TituloconDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertTituloCon []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-titulo-con")	
	public ResponseEntity<Integer> updateTituloCon(@RequestBody Tbasg102TituloconDto bean) {
		try {

			int tbasg102TituloconDto = tbasg102TituloconService.updateTituloCon(bean);

			return new ResponseEntity<>(tbasg102TituloconDto, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("updateTituloCon []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-titulo-con-persona-ultimo")
	public ResponseEntity<List<Tbasg102TituloconDto>> getTituloConPersonaUltimo(String cdgoPersona) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg102TituloconDto> tbasg102TituloconDto = tbasg102TituloconService.getTituloConPersonaUltimo(cdgoPersona);

			if (tbasg102TituloconDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg102TituloconDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getTituloCon []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
