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

import renfe.com.dto.GetFormacionComplementariaPersonaListResultDTO;

import renfe.com.dto.InsertFormaccomplemenParamDTO;
import renfe.com.model.dto.Tbasg152PersempDto;
import renfe.com.model.dto.Tbasg157FormacComplemenDto;
import renfe.com.model.entity.Tbasg152Persemp;
import renfe.com.model.entity.Tbasg157FormacComplemen;
import renfe.com.model.entity.Tbasg157FormacComplemenPK;
import renfe.com.repository.Tbasg157FormacComplemenRepository;

@Transactional
@Service
public class Tbasg157FormacComplemenServiceImpl implements Tbasg157FormacComplemenService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg157FormacComplemenRepository tbasg157FormacComplemenRepository;

	public List<Tbasg157FormacComplemenDto> getAllTbasg157FormacComplemen(Tbasg157FormacComplemenDto filter) {

		logger.info("getAllTbasg157FormacComplemen " + filter);
		if (filter == null) {
			return this.toDtos(tbasg157FormacComplemenRepository.findAll());
		}
		return this.toDtos(tbasg157FormacComplemenRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg157FormacComplemenDto findByCdgoCategoriaCdgoCualificacionCdgoPersona(Integer cdgoCategoria,
			Integer cdgoCualificacion, Integer cdgoPersona) {
		Tbasg157FormacComplemenPK pk = new Tbasg157FormacComplemenPK();
		pk.setCdgoCategoria(cdgoCategoria);
		pk.setCdgoCualificacion(cdgoCualificacion);
		pk.setCdgoPersona(cdgoPersona);
		Optional<Tbasg157FormacComplemen> tbasg157FormacComplemenData = tbasg157FormacComplemenRepository.findById(pk);

		if (tbasg157FormacComplemenData.isPresent()) {
			return toDto(tbasg157FormacComplemenData.get());
		}
		return null;
	}

	public Tbasg157FormacComplemenDto createTbasg157FormacComplemen(
			Tbasg157FormacComplemenDto tbasg157FormacComplemenDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg157FormacComplemen dbTbasg157FormacComplemen = new Tbasg157FormacComplemen();
		BeanUtils.copyProperties(dbTbasg157FormacComplemen, tbasg157FormacComplemenDto);
		Tbasg157FormacComplemen _tbasg157FormacComplemen = tbasg157FormacComplemenRepository
				.save(dbTbasg157FormacComplemen);
		return toDto(_tbasg157FormacComplemen);
	}

	public Tbasg157FormacComplemenDto updateTbasg157FormacComplemen(Integer cdgoCategoria, Integer cdgoCualificacion,
			Integer cdgoPersona, Tbasg157FormacComplemenDto tbasg157FormacComplemenDto)
			throws IllegalAccessException, InvocationTargetException {
		Tbasg157FormacComplemenPK pk = new Tbasg157FormacComplemenPK();
		pk.setCdgoCategoria(cdgoCategoria);
		pk.setCdgoCualificacion(cdgoCualificacion);
		pk.setCdgoPersona(cdgoPersona);
		Optional<Tbasg157FormacComplemen> tbasg157FormacComplemenData = tbasg157FormacComplemenRepository.findById(pk);

		if (tbasg157FormacComplemenData.isPresent()) {
			Tbasg157FormacComplemen dbTbasg157FormacComplemen = tbasg157FormacComplemenData.get();
			BeanUtils.copyProperties(dbTbasg157FormacComplemen, tbasg157FormacComplemenDto);
			return toDto(tbasg157FormacComplemenRepository.save(dbTbasg157FormacComplemen));
		}
		return null;
	}

	public int deleteTbasg157FormacComplemen(Integer cdgoCategoria, Integer cdgoCualificacion, Integer cdgoPersona) {
		Tbasg157FormacComplemenPK pk = new Tbasg157FormacComplemenPK();
		pk.setCdgoCategoria(cdgoCategoria);
		pk.setCdgoCualificacion(cdgoCualificacion);
		pk.setCdgoPersona(cdgoPersona);
		tbasg157FormacComplemenRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg157FormacComplemenDto> findByCdgoCategoriaCdgoCualificacionCdgoPersonaIn(
			List<Integer> cdgoCategoria, List<Integer> cdgoCualificacion, List<Integer> cdgoPersona) {
		List<Tbasg157FormacComplemenPK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoCategoria.size(); i++) {
			Tbasg157FormacComplemenPK newPk = new Tbasg157FormacComplemenPK();
			newPk.setCdgoCategoria(cdgoCategoria.get(i));
			newPk.setCdgoCualificacion(cdgoCualificacion.get(i));
			newPk.setCdgoPersona(cdgoPersona.get(i));
			pks.add(newPk);
		}
		List<Tbasg157FormacComplemen> tbasg157FormacComplemens = tbasg157FormacComplemenRepository
				.findByTbasg157formaccomplemenpkIn(pks);

		return toDtos(tbasg157FormacComplemens);
	}

	public List<GetFormacionComplementariaPersonaListResultDTO> getFormacComplemenPersonaList(Integer cdgoPersona, Integer cdgoCategoria, Integer cdgoCualificacion) {
		//return toDtos(tbasg157FormacComplemenRepository.getFormacComplemenPersonaList(cdgoPersona));
		return tbasg157FormacComplemenRepository.getFormacComplemenPersonaList(cdgoPersona,cdgoCategoria,cdgoCualificacion);
	}
	
	public List<Tbasg157FormacComplemenDto> getFormaComplemenPersona(Integer cdgoPersona) {
		List<Tbasg157FormacComplemen> x = tbasg157FormacComplemenRepository.getFormaComplemenPersona(cdgoPersona);
		List<Tbasg157FormacComplemenDto> y = toDtos(x);
		
		int i = 0;
		
		for( Tbasg157FormacComplemen z:x) {
			y.get(i).setCdgoPersona(z.getTbasg157formaccomplemenpk().getCdgoPersona());
			y.get(i).setCdgoCategoria(z.getTbasg157formaccomplemenpk().getCdgoCategoria());
			y.get(i).setCdgoCualificacion(z.getTbasg157formaccomplemenpk().getCdgoCualificacion());
			i++;
		}	
		return y;
	}

	public int insertFormacComplemen(InsertFormaccomplemenParamDTO bean) {
		return tbasg157FormacComplemenRepository.insertFormacComplemen(bean);
	}

	public int updateFormacComplemen(Tbasg157FormacComplemen bean) {
		return tbasg157FormacComplemenRepository.updateFormacComplemen(bean);
	}

	public int deleteFormacComplemen(Integer cdgoPersona, Integer cdgoCategoria, Integer cdgoCualificacion) {
		return tbasg157FormacComplemenRepository.deleteFormacComplemen(cdgoPersona, cdgoCategoria, cdgoCualificacion);
	}

	public Tbasg157FormacComplemenDto toDto(Tbasg157FormacComplemen orig) {

		Tbasg157FormacComplemenDto dest = new Tbasg157FormacComplemenDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg157FormacComplemen toEntity(Tbasg157FormacComplemenDto orig) {

		Tbasg157FormacComplemen dest = new Tbasg157FormacComplemen();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg157FormacComplemenDto> toDtos(List<Tbasg157FormacComplemen> orig) {

		List<Tbasg157FormacComplemenDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg157FormacComplemen> toEntities(List<Tbasg157FormacComplemenDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg157FormacComplemen> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}

}
