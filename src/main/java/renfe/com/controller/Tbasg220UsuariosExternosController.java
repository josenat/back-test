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

import renfe.com.dto.GetUsuarioExternoListAscendenteDTO;
import renfe.com.model.dto.Tbasg220UsuariosExternosDto;
import renfe.com.model.entity.Tbasg220UsuariosExternos;
import renfe.com.service.Tbasg220UsuariosExternosService;

@CrossOrigin
@RestController
@RequestMapping("asg/api/tbasg220UsuariosExternos")
public class Tbasg220UsuariosExternosController {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg220UsuariosExternosService tbasg220UsuariosExternosService;

	@GetMapping("")
	public ResponseEntity<List<Tbasg220UsuariosExternosDto>> getAllTbasg220UsuariosExternos(
			Tbasg220UsuariosExternosDto filter) {
		return new ResponseEntity<>(tbasg220UsuariosExternosService.getAllTbasg220UsuariosExternos(filter),
				HttpStatus.OK);
	}

	@GetMapping("/{t220CdgoUsuExt}")
	public ResponseEntity<?> findByCdgoExpediente(@PathVariable("t220CdgoUsuExt") Integer t220CdgoUsuExt) {
		Tbasg220UsuariosExternosDto tbasg220UsuariosExternosData = tbasg220UsuariosExternosService
				.findByT220CdgoUsuExt(t220CdgoUsuExt);

		if (tbasg220UsuariosExternosData != null) {
			return new ResponseEntity<>(tbasg220UsuariosExternosData, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tbasg220UsuariosExternosDto> createTbasg220UsuariosExternos(
			@RequestBody Tbasg220UsuariosExternosDto tbasg220UsuariosExternosDto) {
		try {
			return new ResponseEntity<>(
					tbasg220UsuariosExternosService.createTbasg220UsuariosExternos(tbasg220UsuariosExternosDto),
					HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("createTbasg220UsuariosExternos {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{t220CdgoUsuExt}")
	public ResponseEntity<Tbasg220UsuariosExternosDto> updateTbasg220UsuariosExternos(
			@PathVariable("t220CdgoUsuExt") Integer t220CdgoUsuExt,
			@RequestBody Tbasg220UsuariosExternosDto tbasg220UsuariosExternosDto) {
		try {
			Tbasg220UsuariosExternosDto tbasg220UsuariosExternosData = tbasg220UsuariosExternosService
					.updateTbasg220UsuariosExternos(t220CdgoUsuExt, tbasg220UsuariosExternosDto);
			if (tbasg220UsuariosExternosData != null) {
				return new ResponseEntity<>(tbasg220UsuariosExternosData, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("updateTbasg220UsuariosExternos []", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{t220CdgoUsuExt}")
	public ResponseEntity<HttpStatus> deleteTbasg220UsuariosExternos(
			@PathVariable("t220CdgoUsuExt") Integer t220CdgoUsuExt) {
		try {
			tbasg220UsuariosExternosService.deleteTbasg220UsuariosExternos(t220CdgoUsuExt);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("deleteTbasg220UsuariosExternos []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<Tbasg220UsuariosExternosDto>> findByT220CdgoUsuExtIn(List<Integer> t220CdgoUsuExt) {
		try {
			List<Tbasg220UsuariosExternosDto> tbasg220UsuariosExternosDto = tbasg220UsuariosExternosService
					.findByT220CdgoUsuExtIn(t220CdgoUsuExt);

			if (tbasg220UsuariosExternosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg220UsuariosExternosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("findByT220CdgoUsuExtIn {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-usuario-externo-count")
	public ResponseEntity<?> getUsuarioExternoCount() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg220UsuariosExternosDto> tbasg220UsuariosExternosDto = tbasg220UsuariosExternosService
					.getUsuarioExternoCount();

			if (tbasg220UsuariosExternosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg220UsuariosExternosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getUsuarioExternoCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-empresa-de-usuario-count")
	public ResponseEntity<?> getEmpresaDeUsuarioCount(String t220CdgoUsuario) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg220UsuariosExternosDto> tbasg220UsuariosExternosDto = tbasg220UsuariosExternosService
					.getEmpresaDeUsuarioCount(t220CdgoUsuario);

			if (tbasg220UsuariosExternosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg220UsuariosExternosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEmpresaDeUsuarioCount []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-usuario-externo-list-ascendente")
	public ResponseEntity<List<GetUsuarioExternoListAscendenteDTO>> getUsuarioExternoListAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<GetUsuarioExternoListAscendenteDTO> tbasg220UsuariosExternosDto = tbasg220UsuariosExternosService
					.getUsuarioExternoListAscendente();

			if (tbasg220UsuariosExternosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg220UsuariosExternosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getUsuarioExternoListAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-usuario-externo-list-descendente")
	public ResponseEntity<List<Tbasg220UsuariosExternosDto>> getUsuarioExternoListDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg220UsuariosExternosDto> tbasg220UsuariosExternosDto = tbasg220UsuariosExternosService
					.getUsuarioExternoListDescendente();

			if (tbasg220UsuariosExternosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg220UsuariosExternosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getUsuarioExternoListDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-usuario-externo-list-active-ascendente")
	public ResponseEntity<List<Tbasg220UsuariosExternosDto>> getUsuarioExternoListActiveAscendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg220UsuariosExternosDto> tbasg220UsuariosExternosDto = tbasg220UsuariosExternosService
					.getUsuarioExternoListActiveAscendente();

			if (tbasg220UsuariosExternosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg220UsuariosExternosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getUsuarioExternoListActiveAscendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-usuario-externo-list-active-descendente")
	public ResponseEntity<List<Tbasg220UsuariosExternosDto>> getUsuarioExternoListActiveDescendente() {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg220UsuariosExternosDto> tbasg220UsuariosExternosDto = tbasg220UsuariosExternosService
					.getUsuarioExternoListActiveDescendente();

			if (tbasg220UsuariosExternosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg220UsuariosExternosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getUsuarioExternoListActiveDescendente []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-usuario-externo")
	public ResponseEntity<List<Tbasg220UsuariosExternosDto>> getUsuarioExterno(String t220CdgoUsuExt) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg220UsuariosExternosDto> tbasg220UsuariosExternosDto = tbasg220UsuariosExternosService
					.getUsuarioExterno(t220CdgoUsuExt);

			if (tbasg220UsuariosExternosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg220UsuariosExternosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getUsuarioExterno []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-empresas-de-usuario")
	public ResponseEntity<List<Tbasg220UsuariosExternosDto>> getEmpresasDeUsuario(String t220CdgoUsuario) {
		// Generated from a SELECT found in an XML
		try {
			List<Tbasg220UsuariosExternosDto> tbasg220UsuariosExternosDto = tbasg220UsuariosExternosService
					.getEmpresasDeUsuario(t220CdgoUsuario);

			if (tbasg220UsuariosExternosDto.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tbasg220UsuariosExternosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getEmpresasDeUsuario []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert-usuario-externo")
	public ResponseEntity<?> insertUsuarioExterno(@RequestBody Tbasg220UsuariosExternos bean) {
		// Generated from a INSERT found in an XML
		try {
			int tbasg220UsuariosExternosDto = tbasg220UsuariosExternosService.insertUsuarioExterno(bean);
			return new ResponseEntity<>(tbasg220UsuariosExternosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("insertUsuarioExterno []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update-usuario-externo")
	public ResponseEntity<?> updateUsuarioExterno(@RequestBody Tbasg220UsuariosExternos bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg220UsuariosExternosDto = tbasg220UsuariosExternosService.updateUsuarioExterno(bean);
			return new ResponseEntity<>(tbasg220UsuariosExternosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("updateUsuarioExterno []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/estado-usuario-externo")
	public ResponseEntity<?> estadoUsuarioExterno(@RequestBody Tbasg220UsuariosExternos bean) {
		// Generated from a UPDATE found in an XML
		try {
			int tbasg220UsuariosExternosDto = tbasg220UsuariosExternosService.estadoUsuarioExterno(bean);
			return new ResponseEntity<>(tbasg220UsuariosExternosDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("estadoUsuarioExterno []", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
