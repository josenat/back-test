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

import renfe.com.model.dto.Tbasg117EstadotitDto;
import renfe.com.model.entity.Tbasg117Estadotit;
import renfe.com.model.entity.Tbasg117EstadotitPK;
import renfe.com.repository.Tbasg117EstadotitRepository;

@Service
public class Tbasg117EstadotitServiceImpl implements Tbasg117EstadotitService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg117EstadotitRepository tbasg117EstadotitRepository;

	public List<Tbasg117EstadotitDto> getAllTbasg117Estadotit(Tbasg117EstadotitDto filter) {

		logger.info("getAllTbasg117Estadotit " + filter);
		if (filter == null) {
			return this.toDtos(tbasg117EstadotitRepository.findAll());
		}
		return this.toDtos(tbasg117EstadotitRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg117EstadotitDto findByCdgoEstadoCdgoTitFchaEstado(Integer cdgoEstado, Integer cdgoTit,
			String fchaEstado) {
		Tbasg117EstadotitPK pk = new Tbasg117EstadotitPK();
		pk.setCdgoEstado(cdgoEstado);
		pk.setCdgoTit(cdgoTit);
		pk.setFchaEstado(fchaEstado);
		Optional<Tbasg117Estadotit> tbasg117EstadotitData = tbasg117EstadotitRepository.findById(pk);

		if (tbasg117EstadotitData.isPresent()) {
			return toDto(tbasg117EstadotitData.get());
		}
		return null;
	}

	public Tbasg117EstadotitDto createTbasg117Estadotit(Tbasg117EstadotitDto tbasg117EstadotitDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg117Estadotit dbTbasg117Estadotit = new Tbasg117Estadotit();
		BeanUtils.copyProperties(dbTbasg117Estadotit, tbasg117EstadotitDto);
		Tbasg117Estadotit _tbasg117Estadotit = tbasg117EstadotitRepository.save(dbTbasg117Estadotit);
		return toDto(_tbasg117Estadotit);
	}

	public Tbasg117EstadotitDto updateTbasg117Estadotit(Integer cdgoEstado, Integer cdgoTit, String fchaEstado,
			Tbasg117EstadotitDto tbasg117EstadotitDto) throws IllegalAccessException, InvocationTargetException {
		Tbasg117EstadotitPK pk = new Tbasg117EstadotitPK();
		pk.setCdgoEstado(cdgoEstado);
		pk.setCdgoTit(cdgoTit);
		pk.setFchaEstado(fchaEstado);
		Optional<Tbasg117Estadotit> tbasg117EstadotitData = tbasg117EstadotitRepository.findById(pk);

		if (tbasg117EstadotitData.isPresent()) {
			Tbasg117Estadotit dbTbasg117Estadotit = tbasg117EstadotitData.get();
			BeanUtils.copyProperties(dbTbasg117Estadotit, tbasg117EstadotitDto);
			return toDto(tbasg117EstadotitRepository.save(dbTbasg117Estadotit));
		}
		return null;
	}

	public int deleteTbasg117Estadotit(Integer cdgoEstado, Integer cdgoTit, String fchaEstado) {
		Tbasg117EstadotitPK pk = new Tbasg117EstadotitPK();
		pk.setCdgoEstado(cdgoEstado);
		pk.setCdgoTit(cdgoTit);
		pk.setFchaEstado(fchaEstado);
		tbasg117EstadotitRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg117EstadotitDto> findByCdgoEstadoCdgoTitFchaEstadoIn(List<Integer> cdgoEstado,
			List<Integer> cdgoTit, List<String> fchaEstado) {
		List<Tbasg117EstadotitPK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoEstado.size(); i++) {
			Tbasg117EstadotitPK newPk = new Tbasg117EstadotitPK();
			newPk.setCdgoEstado(cdgoEstado.get(i));
			newPk.setCdgoTit(cdgoTit.get(i));
			newPk.setFchaEstado(fchaEstado.get(i));
			pks.add(newPk);
		}
		List<Tbasg117Estadotit> tbasg117Estadotits = tbasg117EstadotitRepository.findByTbasg117estadotitpkIn(pks);

		return toDtos(tbasg117Estadotits);
	}

	public List<Tbasg117EstadotitDto> findEstadoTitByCdgoTit(String cdgoTit) {
		return toDtos(tbasg117EstadotitRepository.findEstadoTitByCdgoTit(cdgoTit));
	}

	public List<Tbasg117EstadotitDto> getEstadoTitList() {
		return toDtos(tbasg117EstadotitRepository.getEstadoTitList());
	}

	public List<Tbasg117EstadotitDto> getEstadoTitUltimo(String cdgoTit) {
		return toDtos(tbasg117EstadotitRepository.getEstadoTitUltimo(cdgoTit));
	}

	public List<Tbasg117EstadotitDto> getEstadoTit(String cdgoTit) {
		return tbasg117EstadotitRepository.getEstadoTit(cdgoTit);
	}	

	public List<Tbasg117EstadotitDto> existeEstadoTit(String cdgoTit, String cdgoEstado) {
		return toDtos(tbasg117EstadotitRepository.existeEstadoTit(cdgoTit, cdgoEstado));
	}

	public int insertEstadoTit(Tbasg117Estadotit bean) {
		return tbasg117EstadotitRepository.insertEstadoTit(bean);
	}

	public int insertEstadoTitSinFecha(Tbasg117Estadotit bean) {
		return tbasg117EstadotitRepository.insertEstadoTitSinFecha(bean);
	}

	public int updateEstadoTit(Tbasg117Estadotit bean) {
		return tbasg117EstadotitRepository.updateEstadoTit(bean);
	}

	public int desactivateEstadoTit(Tbasg117Estadotit bean) {
		return tbasg117EstadotitRepository.deactivateEstadoTit(bean);
	}

	public Tbasg117EstadotitDto toDto(Tbasg117Estadotit orig) {

		Tbasg117EstadotitDto dest = new Tbasg117EstadotitDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			if(dest!=null && orig!=null){
				dest.setCdgoEstado(orig.getTbasg117estadotitpk().getCdgoEstado());
				dest.setCdgoTit(orig.getTbasg117estadotitpk().getCdgoTit());
				dest.setFchaEstado(orig.getTbasg117estadotitpk().getFchaEstado());
			}
		}
		return dest;
	}

	public Tbasg117Estadotit toEntity(Tbasg117EstadotitDto orig) {

		Tbasg117Estadotit dest = new Tbasg117Estadotit();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg117EstadotitDto> toDtos(List<Tbasg117Estadotit> orig) {

		List<Tbasg117EstadotitDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg117Estadotit> toEntities(List<Tbasg117EstadotitDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg117Estadotit> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
