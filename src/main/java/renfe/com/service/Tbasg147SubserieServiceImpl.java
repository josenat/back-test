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

import renfe.com.dto.GetSubSerieListAscCdgoSerieDTO;
import renfe.com.model.dto.Tbasg147SubserieDto;
import renfe.com.model.entity.Tbasg147Subserie;
import renfe.com.model.entity.Tbasg147SubseriePK;
import renfe.com.repository.Tbasg147SubserieRepository;

@Transactional
@Service
public class Tbasg147SubserieServiceImpl implements Tbasg147SubserieService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg147SubserieRepository tbasg147SubserieRepository;

	public List<Tbasg147SubserieDto> getAllTbasg147Subserie(Tbasg147SubserieDto filter) {

		logger.info("getAllTbasg147Subserie " + filter);
		if (filter == null) {
			return this.toDtos(tbasg147SubserieRepository.findAll());
		}
		return this.toDtos(tbasg147SubserieRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg147SubserieDto findByCdgoSerieCdgoSubserie(String cdgoSerie, String cdgoSubserie) {
		Tbasg147SubseriePK pk = new Tbasg147SubseriePK();
		pk.setCdgoSerie(cdgoSerie);
		pk.setCdgoSubserie(cdgoSubserie);
		Optional<Tbasg147Subserie> tbasg147SubserieData = tbasg147SubserieRepository.findById(pk);

		if (tbasg147SubserieData.isPresent()) {
			return toDto(tbasg147SubserieData.get());
		}
		return null;
	}

	public Tbasg147SubserieDto createTbasg147Subserie(Tbasg147SubserieDto tbasg147SubserieDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg147Subserie dbTbasg147Subserie = new Tbasg147Subserie();
		BeanUtils.copyProperties(dbTbasg147Subserie, tbasg147SubserieDto);
		Tbasg147Subserie _tbasg147Subserie = tbasg147SubserieRepository.save(dbTbasg147Subserie);
		return toDto(_tbasg147Subserie);
	}

	public Tbasg147SubserieDto updateTbasg147Subserie(String cdgoSerie, String cdgoSubserie,
			Tbasg147SubserieDto tbasg147SubserieDto) throws IllegalAccessException, InvocationTargetException {
		Tbasg147SubseriePK pk = new Tbasg147SubseriePK();
		pk.setCdgoSerie(cdgoSerie);
		pk.setCdgoSubserie(cdgoSubserie);
		Optional<Tbasg147Subserie> tbasg147SubserieData = tbasg147SubserieRepository.findById(pk);

		if (tbasg147SubserieData.isPresent()) {
			Tbasg147Subserie dbTbasg147Subserie = tbasg147SubserieData.get();
			BeanUtils.copyProperties(dbTbasg147Subserie, tbasg147SubserieDto);
			return toDto(tbasg147SubserieRepository.save(dbTbasg147Subserie));
		}
		return null;
	}

	public int deleteTbasg147Subserie(String cdgoSerie, String cdgoSubserie) {
		Tbasg147SubseriePK pk = new Tbasg147SubseriePK();
		pk.setCdgoSerie(cdgoSerie);
		pk.setCdgoSubserie(cdgoSubserie);
		tbasg147SubserieRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg147SubserieDto> findByCdgoSerieCdgoSubserieIn(List<String> cdgoSerie, List<String> cdgoSubserie) {
		List<Tbasg147SubseriePK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoSerie.size(); i++) {
			Tbasg147SubseriePK newPk = new Tbasg147SubseriePK();
			newPk.setCdgoSerie(cdgoSerie.get(i));
			newPk.setCdgoSubserie(cdgoSubserie.get(i));
			pks.add(newPk);
		}
		List<Tbasg147Subserie> tbasg147Subseries = tbasg147SubserieRepository.findByTbasg147subseriepkIn(pks);

		return toDtos(tbasg147Subseries);
	}

	public List<Tbasg147SubserieDto> getSubSerie(String cdgoSerie, String cdgoSubserie) {
		return toDtos(tbasg147SubserieRepository.getSubSerie(cdgoSerie, cdgoSubserie));
	}

	public List<Tbasg147SubserieDto> getSubSerieListAscendente() {
		return tbasg147SubserieRepository.getSubSerieListAscendente();
	}

	public List<Tbasg147SubserieDto> getSubSerieListDescendente() {
		return toDtos(tbasg147SubserieRepository.getSubSerieListDescendente());
	}

	public List<Tbasg147SubserieDto> getSubSerieListAscendenteView() {
		return toDtos(tbasg147SubserieRepository.getSubSerieListAscendenteView());
	}

	public List<Tbasg147SubserieDto> getSubSerieListDescendenteView() {
		return toDtos(tbasg147SubserieRepository.getSubSerieListDescendenteView());
	}

	public List<GetSubSerieListAscCdgoSerieDTO> getSubSerieListAscendenteViewCDGO_SUBSERIE(String cdgoSerie) {
		return tbasg147SubserieRepository.getSubSerieListAscendenteViewCDGO_SUBSERIE(cdgoSerie);
	}

	public List<Tbasg147SubserieDto> getSubSerieListDescendenteViewCDGO_SUBSERIE(String cdgoSerie) {
		return toDtos(tbasg147SubserieRepository.getSubSerieListDescendenteViewCDGO_SUBSERIE(cdgoSerie));
	}

	public List<Tbasg147SubserieDto> getSubSerieCount() {
		return toDtos(tbasg147SubserieRepository.getSubSerieCount());
	}

	public List<Tbasg147SubserieDto> getSubSerieViewCount(String cdgoSerie) {
		return toDtos(tbasg147SubserieRepository.getSubSerieViewCount(cdgoSerie));
	}

	public List<Tbasg147SubserieDto> getSubSerieListActive() {
		return tbasg147SubserieRepository.getSubSerieListActive();
	}

	public int insertSubSerie(Tbasg147Subserie bean) {
		return tbasg147SubserieRepository.insertSubSerie(bean);
	}

	public int updateSubSerie(Tbasg147Subserie bean) {
		return tbasg147SubserieRepository.updateSubSerie(bean);
	}

	public int estadoSubSerie(Tbasg147Subserie bean) {
		return tbasg147SubserieRepository.estadoSubSerie(bean);
	}
	
	public int deleteSubSerie(Tbasg147Subserie bean) {
		return tbasg147SubserieRepository.deleteSubSerie(bean);
	}

	public int reactiveSubSerie(Tbasg147Subserie bean) {
		return tbasg147SubserieRepository.reactiveSubSerie(bean);
	}

	public Tbasg147SubserieDto toDto(Tbasg147Subserie orig) {

		Tbasg147SubserieDto dest = new Tbasg147SubserieDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg147Subserie toEntity(Tbasg147SubserieDto orig) {

		Tbasg147Subserie dest = new Tbasg147Subserie();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg147SubserieDto> toDtos(List<Tbasg147Subserie> orig) {

		List<Tbasg147SubserieDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg147Subserie> toEntities(List<Tbasg147SubserieDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg147Subserie> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
