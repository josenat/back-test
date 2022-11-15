package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import renfe.com.dto.GetUsuarioExternoListAscendenteDTO;
import renfe.com.model.dto.Tbasg220UsuariosExternosDto;
import renfe.com.model.entity.Tbasg220UsuariosExternos;
import renfe.com.repository.Tbasg220UsuariosExternosRepository;

@Transactional
@Service
public class Tbasg220UsuariosExternosServiceImpl implements Tbasg220UsuariosExternosService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg220UsuariosExternosRepository tbasg220UsuariosExternosRepository;

	public List<Tbasg220UsuariosExternosDto> getAllTbasg220UsuariosExternos(Tbasg220UsuariosExternosDto filter) {

		logger.info("getAllTbasg220UsuariosExternos " + filter);
		if (filter == null) {
			return this.toDtos(tbasg220UsuariosExternosRepository.findAll());
		}
		return this.toDtos(tbasg220UsuariosExternosRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg220UsuariosExternosDto findByT220CdgoUsuExt(Integer t220CdgoUsuExt) {

		Optional<Tbasg220UsuariosExternos> tbasg220UsuariosExternosData = tbasg220UsuariosExternosRepository
				.findByT220CdgoUsuExt(t220CdgoUsuExt);

		if (tbasg220UsuariosExternosData.isPresent()) {
			return toDto(tbasg220UsuariosExternosData.get());
		}
		return null;
	}

	public Tbasg220UsuariosExternosDto createTbasg220UsuariosExternos(
			Tbasg220UsuariosExternosDto tbasg220UsuariosExternosDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg220UsuariosExternos dbTbasg220UsuariosExternos = new Tbasg220UsuariosExternos();
		BeanUtils.copyProperties(dbTbasg220UsuariosExternos, tbasg220UsuariosExternosDto);
		Tbasg220UsuariosExternos _tbasg220UsuariosExternos = tbasg220UsuariosExternosRepository
				.save(dbTbasg220UsuariosExternos);
		return toDto(_tbasg220UsuariosExternos);
	}

	public Tbasg220UsuariosExternosDto updateTbasg220UsuariosExternos(Integer t220CdgoUsuExt,
			Tbasg220UsuariosExternosDto tbasg220UsuariosExternosDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg220UsuariosExternos> tbasg220UsuariosExternosData = tbasg220UsuariosExternosRepository
				.findById(t220CdgoUsuExt);

		if (tbasg220UsuariosExternosData.isPresent()) {
			Tbasg220UsuariosExternos dbTbasg220UsuariosExternos = tbasg220UsuariosExternosData.get();
			BeanUtils.copyProperties(dbTbasg220UsuariosExternos, tbasg220UsuariosExternosDto);
			return toDto(tbasg220UsuariosExternosRepository.save(dbTbasg220UsuariosExternos));
		}
		return null;
	}

	public int deleteTbasg220UsuariosExternos(Integer t220CdgoUsuExt) {

		tbasg220UsuariosExternosRepository.deleteById(t220CdgoUsuExt);
		return 1;
	}

	public List<Tbasg220UsuariosExternosDto> findByT220CdgoUsuExtIn(List<Integer> t220CdgoUsuExt) {

		List<Tbasg220UsuariosExternos> tbasg220UsuariosExternoss = tbasg220UsuariosExternosRepository
				.findByT220CdgoUsuExtIn(t220CdgoUsuExt);

		return toDtos(tbasg220UsuariosExternoss);
	}

	public List<Tbasg220UsuariosExternosDto> getUsuarioExternoCount() {
		return toDtos(tbasg220UsuariosExternosRepository.getUsuarioExternoCount());
	}

	public List<Tbasg220UsuariosExternosDto> getEmpresaDeUsuarioCount(String t220CdgoUsuario) {
		return toDtos(tbasg220UsuariosExternosRepository.getEmpresaDeUsuarioCount(t220CdgoUsuario));
	}

	public List<GetUsuarioExternoListAscendenteDTO> getUsuarioExternoListAscendente() {
		return tbasg220UsuariosExternosRepository.getUsuarioExternoListAscendente();
	}

	public List<Tbasg220UsuariosExternosDto> getUsuarioExternoListDescendente() {
		return toDtos(tbasg220UsuariosExternosRepository.getUsuarioExternoListDescendente());
	}

	public List<Tbasg220UsuariosExternosDto> getUsuarioExternoListActiveAscendente() {
		return toDtos(tbasg220UsuariosExternosRepository.getUsuarioExternoListActiveAscendente());
	}

	public List<Tbasg220UsuariosExternosDto> getUsuarioExternoListActiveDescendente() {
		return toDtos(tbasg220UsuariosExternosRepository.getUsuarioExternoListActiveDescendente());
	}

	public List<Tbasg220UsuariosExternosDto> getUsuarioExterno(String t220CdgoUsuExt) {
		return toDtos(tbasg220UsuariosExternosRepository.getUsuarioExterno(t220CdgoUsuExt));
	}

	public List<Tbasg220UsuariosExternosDto> getEmpresasDeUsuario(String t220CdgoUsuario) {
		return toDtos(tbasg220UsuariosExternosRepository.getEmpresasDeUsuario(t220CdgoUsuario));
	}

	public int insertUsuarioExterno(Tbasg220UsuariosExternos bean) {
		return tbasg220UsuariosExternosRepository.insertUsuarioExterno(bean);
	}

	public int updateUsuarioExterno(Tbasg220UsuariosExternos bean) {
		return tbasg220UsuariosExternosRepository.updateUsuarioExterno(bean);
	}
	
	public int estadoUsuarioExterno(Tbasg220UsuariosExternos bean) {
		return tbasg220UsuariosExternosRepository.estadoUsuarioExterno(bean);
	}

	public Tbasg220UsuariosExternosDto toDto(Tbasg220UsuariosExternos orig) {

		Tbasg220UsuariosExternosDto dest = new Tbasg220UsuariosExternosDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg220UsuariosExternos toEntity(Tbasg220UsuariosExternosDto orig) {

		Tbasg220UsuariosExternos dest = new Tbasg220UsuariosExternos();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg220UsuariosExternosDto> toDtos(List<Tbasg220UsuariosExternos> orig) {

		List<Tbasg220UsuariosExternosDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg220UsuariosExternos> toEntities(List<Tbasg220UsuariosExternosDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg220UsuariosExternos> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
