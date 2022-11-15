package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import renfe.com.dto.GetPersempParametersDTO;
import renfe.com.model.dto.Tbasg152PersempDto;
import renfe.com.model.entity.Tbasg152Persemp;
import renfe.com.model.entity.Tbasg152PersempPK;
import renfe.com.repository.Tbasg152PersempRepository;

@Service
public class Tbasg152PersempServiceImpl implements Tbasg152PersempService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg152PersempRepository tbasg152PersempRepository;

	public List<Tbasg152PersempDto> getAllTbasg152Persemp(Tbasg152PersempDto filter) {

		logger.info("getAllTbasg152Persemp " + filter);
		if (filter == null) {
			return this.toDtos(tbasg152PersempRepository.findAll());
		}
		return this.toDtos(tbasg152PersempRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg152PersempDto findByCdgoEmpresaCdgoPersona(Integer cdgoEmpresa, Integer cdgoPersona) {
		Tbasg152PersempPK pk = new Tbasg152PersempPK();
		pk.setCdgoEmpresa(cdgoEmpresa);
		pk.setCdgoPersona(cdgoPersona);
		Optional<Tbasg152Persemp> tbasg152PersempData = tbasg152PersempRepository.findById(pk);

		if (tbasg152PersempData.isPresent()) {
			return toDto(tbasg152PersempData.get());
		}
		return null;
	}

	public Tbasg152PersempDto createTbasg152Persemp(Tbasg152PersempDto tbasg152PersempDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg152Persemp dbTbasg152Persemp = new Tbasg152Persemp();
		BeanUtils.copyProperties(dbTbasg152Persemp, tbasg152PersempDto);
		Tbasg152Persemp _tbasg152Persemp = tbasg152PersempRepository.save(dbTbasg152Persemp);
		return toDto(_tbasg152Persemp);
	}

	public Tbasg152PersempDto updateTbasg152Persemp(Integer cdgoEmpresa, Integer cdgoPersona,
			Tbasg152PersempDto tbasg152PersempDto) throws IllegalAccessException, InvocationTargetException {
		Tbasg152PersempPK pk = new Tbasg152PersempPK();
		pk.setCdgoEmpresa(cdgoEmpresa);
		pk.setCdgoPersona(cdgoPersona);
		Optional<Tbasg152Persemp> tbasg152PersempData = tbasg152PersempRepository.findById(pk);

		if (tbasg152PersempData.isPresent()) {
			Tbasg152Persemp dbTbasg152Persemp = tbasg152PersempData.get();
			BeanUtils.copyProperties(dbTbasg152Persemp, tbasg152PersempDto);
			return toDto(tbasg152PersempRepository.save(dbTbasg152Persemp));
		}
		return null;
	}

	public int deleteTbasg152Persemp(Integer cdgoEmpresa, Integer cdgoPersona) {
		Tbasg152PersempPK pk = new Tbasg152PersempPK();
		pk.setCdgoEmpresa(cdgoEmpresa);
		pk.setCdgoPersona(cdgoPersona);
		tbasg152PersempRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg152PersempDto> findByCdgoEmpresaCdgoPersonaIn(List<Integer> cdgoEmpresa,
			List<Integer> cdgoPersona) {
		List<Tbasg152PersempPK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoEmpresa.size(); i++) {
			Tbasg152PersempPK newPk = new Tbasg152PersempPK();
			newPk.setCdgoEmpresa(cdgoEmpresa.get(i));
			newPk.setCdgoPersona(cdgoPersona.get(i));
			pks.add(newPk);
		}
		List<Tbasg152Persemp> tbasg152Persemps = tbasg152PersempRepository.findByTbasg152persemppkIn(pks);

		return toDtos(tbasg152Persemps);
	}

	public List<Tbasg152PersempDto> getPersonaEmpresa(String cdgoPersona) {
		List<Tbasg152Persemp> x = tbasg152PersempRepository.getPersonaEmpresa(cdgoPersona);
		List<Tbasg152PersempDto> y = toDtos(x);
		
		int i = 0;
		
		for( Tbasg152Persemp z:x) {
			y.get(i).setCdgoPersona(z.getTbasg152persemppk().getCdgoPersona());
			y.get(i).setCdgoEmpresa(z.getTbasg152persemppk().getCdgoEmpresa());
			i++;
		}	
		return y;
	}

	public List<Tbasg152PersempDto> getPersonaEmpresaListMantenimiento(String cdgoPersona) {
		return toDtos(tbasg152PersempRepository.getPersonaEmpresaListMantenimiento(cdgoPersona));
	}

	public int insertPersonaEmpresa(GetPersempParametersDTO bean) {
		return tbasg152PersempRepository.insertPersonaEmpresa(bean);
	}

	public int updatePersonaEmpresa(GetPersempParametersDTO bean) {
		return tbasg152PersempRepository.updatePersonaEmpresa(bean);
	}

	public int deletePersonaEmpresaMantenimiento(Tbasg152Persemp bean) {
		return tbasg152PersempRepository.deletePersonaEmpresaMantenimiento(bean);
	}

	public int updatePersonaEmpresaMantenimiento(Tbasg152Persemp bean) {
		return tbasg152PersempRepository.updatePersonaEmpresaMantenimiento(bean);
	}

	public Tbasg152PersempDto toDto(Tbasg152Persemp orig) {

		Tbasg152PersempDto dest = new Tbasg152PersempDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg152Persemp toEntity(Tbasg152PersempDto orig) {

		Tbasg152Persemp dest = new Tbasg152Persemp();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg152PersempDto> toDtos(List<Tbasg152Persemp> orig) {

		List<Tbasg152PersempDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg152Persemp> toEntities(List<Tbasg152PersempDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg152Persemp> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
