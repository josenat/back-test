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

import renfe.com.model.dto.Tbasg125EmpresaDto;
import renfe.com.model.entity.Tbasg125Empresa;
import renfe.com.repository.Tbasg125EmpresaRepository;

@Transactional
@Service
public class Tbasg125EmpresaServiceImpl implements Tbasg125EmpresaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg125EmpresaRepository tbasg125EmpresaRepository;

	public List<Tbasg125EmpresaDto> getAllTbasg125Empresa(Tbasg125EmpresaDto filter) {

		logger.info("getAllTbasg125Empresa " + filter);
		if (filter == null) {
			return this.toDtos(tbasg125EmpresaRepository.findAll());
		}
		return this.toDtos(tbasg125EmpresaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg125EmpresaDto findByCdgoEmpresa(Integer cdgoEmpresa) {

		Optional<Tbasg125Empresa> tbasg125EmpresaData = tbasg125EmpresaRepository.findByCdgoEmpresa(cdgoEmpresa);

		if (tbasg125EmpresaData.isPresent()) {
			return toDto(tbasg125EmpresaData.get());
		}
		return null;
	}

	public Tbasg125EmpresaDto createTbasg125Empresa(Tbasg125EmpresaDto tbasg125EmpresaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg125Empresa dbTbasg125Empresa = new Tbasg125Empresa();
		BeanUtils.copyProperties(dbTbasg125Empresa, tbasg125EmpresaDto);
		Tbasg125Empresa _tbasg125Empresa = tbasg125EmpresaRepository.save(dbTbasg125Empresa);
		return toDto(_tbasg125Empresa);
	}

	public Tbasg125EmpresaDto updateTbasg125Empresa(Integer cdgoEmpresa, Tbasg125EmpresaDto tbasg125EmpresaDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg125Empresa> tbasg125EmpresaData = tbasg125EmpresaRepository.findById(cdgoEmpresa);

		if (tbasg125EmpresaData.isPresent()) {
			Tbasg125Empresa dbTbasg125Empresa = tbasg125EmpresaData.get();
			BeanUtils.copyProperties(dbTbasg125Empresa, tbasg125EmpresaDto);
			return toDto(tbasg125EmpresaRepository.save(dbTbasg125Empresa));
		}
		return null;
	}

	public int deleteTbasg125Empresa(Integer cdgoEmpresa) {

		tbasg125EmpresaRepository.deleteById(cdgoEmpresa);
		return 1;
	}

	public List<Tbasg125EmpresaDto> findByCdgoEmpresaIn(List<Integer> cdgoEmpresa) {

		List<Tbasg125Empresa> tbasg125Empresas = tbasg125EmpresaRepository.findByCdgoEmpresaIn(cdgoEmpresa);

		return toDtos(tbasg125Empresas);
	}

	public List<Tbasg125EmpresaDto> getEmpresaCount() {
		return toDtos(tbasg125EmpresaRepository.getEmpresaCount());
	}

	public List<Tbasg125EmpresaDto> getEmpresaViewListAscendente() {
		return toDtos(tbasg125EmpresaRepository.getEmpresaViewListAscendente());
	}

	public List<Tbasg125EmpresaDto> getEmpresaViewListDescendente() {
		return toDtos(tbasg125EmpresaRepository.getEmpresaViewListDescendente());
	}

	public List<Tbasg125EmpresaDto> getEmpresaViewListAscendenteEMPRESA() {
		return toDtos(tbasg125EmpresaRepository.getEmpresaViewListAscendenteEMPRESA());
	}

	public List<Tbasg125EmpresaDto> getEmpresaViewListDescendenteEMPRESA() {
		return toDtos(tbasg125EmpresaRepository.getEmpresaViewListDescendenteEMPRESA());
	}

	public List<Tbasg125EmpresaDto> getEmpresaListAscendente() {
		return toDtos(tbasg125EmpresaRepository.getEmpresaListAscendente());
	}

	public List<Tbasg125EmpresaDto> getEmpresaListDescendente() {
		return toDtos(tbasg125EmpresaRepository.getEmpresaListDescendente());
	}

	public List<Tbasg125EmpresaDto> getEmpresa(Integer cdgoEmpresa) {
		return toDtos(tbasg125EmpresaRepository.getEmpresa(cdgoEmpresa));
	}

	public List<Tbasg125EmpresaDto> getEmpresaCif(String desgCif) {
		return toDtos(tbasg125EmpresaRepository.getEmpresaCif(desgCif));
	}

	public List<Tbasg125EmpresaDto> getEmpresaCifInactive(String desgCif) {
		return toDtos(tbasg125EmpresaRepository.getEmpresaCifInactive(desgCif));
	}

	public List<Tbasg125EmpresaDto> getEmpresaViewListActive() {
		return toDtos(tbasg125EmpresaRepository.getEmpresaViewListActive());
	}

	public List<Tbasg125EmpresaDto> getEmpresaComboListActive() {
		return toDtos(tbasg125EmpresaRepository.getEmpresaComboListActive());
	}

	public int insertEmpresa(Tbasg125Empresa bean) {
		return tbasg125EmpresaRepository.insertEmpresa(bean);
	}

	public int updateEmpresa(Tbasg125Empresa bean) {
		return tbasg125EmpresaRepository.updateEmpresa(bean);
	}
	
	public int deleteEmpresa(Tbasg125Empresa bean) {
		return tbasg125EmpresaRepository.deleteEmpresa(bean);
	}
	
	public int reactiveEmpresa(Tbasg125Empresa bean) {
		return tbasg125EmpresaRepository.reactiveEmpresa(bean);
	}


	public int unDeleteEmpresa(Tbasg125Empresa bean) {
		return tbasg125EmpresaRepository.unDeleteEmpresa(bean);
	}

	public Tbasg125EmpresaDto toDto(Tbasg125Empresa orig) {

		Tbasg125EmpresaDto dest = new Tbasg125EmpresaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg125Empresa toEntity(Tbasg125EmpresaDto orig) {

		Tbasg125Empresa dest = new Tbasg125Empresa();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg125EmpresaDto> toDtos(List<Tbasg125Empresa> orig) {

		List<Tbasg125EmpresaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg125Empresa> toEntities(List<Tbasg125EmpresaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg125Empresa> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
