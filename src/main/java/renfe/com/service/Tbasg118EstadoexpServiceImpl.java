package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import renfe.com.dto.CountGetTramosDTO;
import renfe.com.dto.GetEstadosMasExpDTO;
import renfe.com.dto.GetFechaExpFiltradaDTO;
import renfe.com.dto.GetFechaOtorgamientoDTO;
import renfe.com.dto.GetMaxEntornosExpCodListDTO;
import renfe.com.dto.GetMaxEntornosExpListCodigosDTO;
import renfe.com.dto.GetMaxEstaHabInListDTO;
import renfe.com.dto.GetTramoListByCdgoExpDTO;
import renfe.com.dto.GetTramosOrderByCodLineaDTO;
import renfe.com.dto.ParamCountGetTramos;
import renfe.com.model.dto.GetExpedientesPersonaCursoListDTO;

import renfe.com.model.dto.Tbasg118EstadoexpDto;
import renfe.com.model.dto.Tbasg152PersempDto;
import renfe.com.model.entity.Tbasg118Estadoexp;
import renfe.com.model.entity.Tbasg118EstadoexpPK;
import renfe.com.model.entity.Tbasg152Persemp;
import renfe.com.repository.Tbasg118EstadoexpRepository;

@Service
public class Tbasg118EstadoexpServiceImpl implements Tbasg118EstadoexpService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg118EstadoexpRepository tbasg118EstadoexpRepository;

	public List<Tbasg118EstadoexpDto> getAllTbasg118Estadoexp(Tbasg118EstadoexpDto filter) {

		logger.info("getAllTbasg118Estadoexp " + filter);
		if (filter == null) {
			return this.toDtos(tbasg118EstadoexpRepository.findAll());
		}
		return this.toDtos(tbasg118EstadoexpRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg118EstadoexpDto findByCdgoEstadoCdgoExpedientFchaEstado(Integer cdgoEstado, Integer cdgoExpedient,
			Date fchaEstado) {
		Tbasg118EstadoexpPK pk = new Tbasg118EstadoexpPK();
		pk.setCdgoEstado(cdgoEstado);
		pk.setCdgoExpedient(cdgoExpedient);
		pk.setFchaEstado(fchaEstado);
		Optional<Tbasg118Estadoexp> tbasg118EstadoexpData = tbasg118EstadoexpRepository.findById(pk);

		if (tbasg118EstadoexpData.isPresent()) {
			return toDto(tbasg118EstadoexpData.get());
		}
		return null;
	}

	public Tbasg118EstadoexpDto createTbasg118Estadoexp(Tbasg118EstadoexpDto tbasg118EstadoexpDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg118Estadoexp dbTbasg118Estadoexp = new Tbasg118Estadoexp();
		BeanUtils.copyProperties(dbTbasg118Estadoexp, tbasg118EstadoexpDto);
		Tbasg118Estadoexp _tbasg118Estadoexp = tbasg118EstadoexpRepository.save(dbTbasg118Estadoexp);
		return toDto(_tbasg118Estadoexp);
	}

	public Tbasg118EstadoexpDto updateTbasg118Estadoexp(Integer cdgoEstado, Integer cdgoExpedient, Date fchaEstado,
			Tbasg118EstadoexpDto tbasg118EstadoexpDto) throws IllegalAccessException, InvocationTargetException {
		Tbasg118EstadoexpPK pk = new Tbasg118EstadoexpPK();
		pk.setCdgoEstado(cdgoEstado);
		pk.setCdgoExpedient(cdgoExpedient);
		pk.setFchaEstado(fchaEstado);
		Optional<Tbasg118Estadoexp> tbasg118EstadoexpData = tbasg118EstadoexpRepository.findById(pk);

		if (tbasg118EstadoexpData.isPresent()) {
			Tbasg118Estadoexp dbTbasg118Estadoexp = tbasg118EstadoexpData.get();
			BeanUtils.copyProperties(dbTbasg118Estadoexp, tbasg118EstadoexpDto);
			return toDto(tbasg118EstadoexpRepository.save(dbTbasg118Estadoexp));
		}
		return null;
	}

	public int deleteTbasg118Estadoexp(Integer cdgoEstado, Integer cdgoExpedient, Date fchaEstado) {
		Tbasg118EstadoexpPK pk = new Tbasg118EstadoexpPK();
		pk.setCdgoEstado(cdgoEstado);
		pk.setCdgoExpedient(cdgoExpedient);
		pk.setFchaEstado(fchaEstado);
		tbasg118EstadoexpRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg118EstadoexpDto> findByCdgoEstadoCdgoExpedientFchaEstadoIn(List<Integer> cdgoEstado,
			List<Integer> cdgoExpedient, List<Date> fchaEstado) {
		List<Tbasg118EstadoexpPK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoEstado.size(); i++) {
			Tbasg118EstadoexpPK newPk = new Tbasg118EstadoexpPK();
			newPk.setCdgoEstado(cdgoEstado.get(i));
			newPk.setCdgoExpedient(cdgoExpedient.get(i));
			newPk.setFchaEstado(fchaEstado.get(i));
			pks.add(newPk);
		}
		List<Tbasg118Estadoexp> tbasg118Estadoexps = tbasg118EstadoexpRepository.findByTbasg118estadoexppkIn(pks);

		return toDtos(tbasg118Estadoexps);
	}

	public List<Tbasg118EstadoexpDto> getTramosExpInfr(String cdgoExpedient) {
		return toDtos(tbasg118EstadoexpRepository.getTramosExpInfr(cdgoExpedient));
	}

	public List<Tbasg118EstadoexpDto> getTramosExpInfrWithOutState(String cdgoExpedient) {
		return toDtos(tbasg118EstadoexpRepository.getTramosExpInfrWithOutState(cdgoExpedient));
	}

	public List<GetMaxEstaHabInListDTO> getMaxEstaHabInList(String cdgoExpedient) {
		return tbasg118EstadoexpRepository.getMaxEstaHabInList(cdgoExpedient);
	}

	public List<Tbasg118EstadoexpDto> findEstadoExpByCdgoExp(String cdgoExpedient) {
		return toDtos(tbasg118EstadoexpRepository.findEstadoExpByCdgoExp(cdgoExpedient));
	}

	public List<Tbasg118EstadoexpDto> findFechaSuspensionReactivacionExpByCdgoExp(String cdgoExpedient) {
		return toDtos(tbasg118EstadoexpRepository.findFechaSuspensionReactivacionExpByCdgoExp(cdgoExpedient));
	}

	public List<Tbasg118EstadoexpDto> findTodosEstadosExpsSuspSancionByCdgoExp(Integer cdgoExpediente) {
		return toDtos(tbasg118EstadoexpRepository.findTodosEstadosExpsSuspSancionByCdgoExp(cdgoExpediente));
	}

	
	public List<GetEstadosMasExpDTO> getEstadosMasExp(String cdgoExpedient) {
		return tbasg118EstadoexpRepository.getEstadosMasExp(cdgoExpedient);
	}
	
	public List<Tbasg118EstadoexpDto> getEstadosExp(String cdgoExpedient) {
		return toDtos(tbasg118EstadoexpRepository.getEstadosExp(cdgoExpedient));
	}

	public List<Tbasg118EstadoexpDto> getEstadosExpMaxFecha(String cdgoExpedient) {
		return toDtos(tbasg118EstadoexpRepository.getEstadosExpMaxFecha(cdgoExpedient));
	}

	public List<Tbasg118EstadoexpDto> getEstadosExpsMaxFecha(List expedientes) {
		return toDtos(tbasg118EstadoexpRepository.getEstadosExpsMaxFecha(expedientes));
	}


	public List<Tbasg118EstadoexpDto> getEstadosExpMaxFechaTodo(String cdgoExpedient) {
		return toDtos(tbasg118EstadoexpRepository.getEstadosExpMaxFechaTodo(cdgoExpedient));
	}

	public List<Tbasg118EstadoexpDto> getEstadosExpsTodosMaxFecha() {
		return toDtos(tbasg118EstadoexpRepository.getEstadosExpsTodosMaxFecha());
	}

	public List<Tbasg118EstadoexpDto> getEstadoExpList() {
		return toDtos(tbasg118EstadoexpRepository.getEstadoExpList());
	}

	public int insertEstadoExp(Integer cdgoExpediente, Integer cdgoEstado, String desgUsuact, String mrcaActivo) {
		return tbasg118EstadoexpRepository.insertEstadoExp(cdgoExpediente, cdgoEstado, desgUsuact, mrcaActivo);
	}

	public int updateEstadoExpediente(Tbasg118Estadoexp bean) {
		return tbasg118EstadoexpRepository.updateEstadoExpediente(bean);
	}

	public List<GetExpedientesPersonaCursoListDTO> getExpedientesPersonaCursoList() {
		return tbasg118EstadoexpRepository.getExpedientesPersonaCursoList();
	}

	public List<GetMaxEntornosExpListCodigosDTO> getMaxEntornosExpListCodigos(String cdgoExpedient) {
		//return toDtos(tbasg118EstadoexpRepository.getMaxEntornosExpListCodigos(cdgoExpedient));
		return tbasg118EstadoexpRepository.getMaxEntornosExpListCodigos(cdgoExpedient);
	}

	public List<GetMaxEntornosExpCodListDTO> getMaxEntornosExpCodList(Integer cdgoExpediente, Integer cdgoEstado) {
		//return toDtos(tbasg118EstadoexpRepository.getMaxEntornosExpCodList());
		return tbasg118EstadoexpRepository.getMaxEntornosExpCodList(cdgoExpediente,cdgoEstado);
	}

	public List<GetFechaOtorgamientoDTO> getFechaOtorgamiento(Integer cdgoExpedient) {
		//return toDtos(tbasg118EstadoexpRepository.getFechaOtorgamiento(cdgoExpedient));
		return tbasg118EstadoexpRepository.getFechaOtorgamiento(cdgoExpedient);
	}

	public List<GetTramoListByCdgoExpDTO> getTramoListByCdgoExp(Integer cdgoExpedient) {

		return tbasg118EstadoexpRepository.getTramoListByCdgoExp(cdgoExpedient);
	}

	public List<Tbasg118EstadoexpDto> getFechasOtorgamiento(List<Integer> cdgoExpedient) {
		//return toDtos(tbasg118EstadoexpRepository.getFechasOtorgamiento());
		List<Tbasg118Estadoexp> x = tbasg118EstadoexpRepository.getFechasOtorgamiento(cdgoExpedient);
		List<Tbasg118EstadoexpDto> y = toDtos(x);
		
		int i = 0;
		
		for( Tbasg118Estadoexp z:x) {
			y.get(i).setCdgoExpedient(z.getTbasg118estadoexppk().getCdgoExpedient());
			i++;
		}	
		return y;
	}

	public List<GetFechaExpFiltradaDTO> getFechaExpFiltrada(String cdgoPersona) {
		//return toDtos(tbasg118EstadoexpRepository.getFechaExpFiltrada());
		return tbasg118EstadoexpRepository.getFechaExpFiltrada(cdgoPersona);
	}

	public Tbasg118EstadoexpDto toDto(Tbasg118Estadoexp orig) {

		Tbasg118EstadoexpDto dest = new Tbasg118EstadoexpDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}finally {
			if(dest!=null && orig != null) {
				dest.setCdgoEstado(orig.getTbasg118estadoexppk().getCdgoEstado());
				dest.setCdgoExpedient(orig.getTbasg118estadoexppk().getCdgoExpedient());
			}
		}

		return dest;
	}

	public Tbasg118Estadoexp toEntity(Tbasg118EstadoexpDto orig) {

		Tbasg118Estadoexp dest = new Tbasg118Estadoexp();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg118EstadoexpDto> toDtos(List<Tbasg118Estadoexp> orig) {

		List<Tbasg118EstadoexpDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg118Estadoexp> toEntities(List<Tbasg118EstadoexpDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg118Estadoexp> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}

	@Override
	public List<GetTramosOrderByCodLineaDTO> getTramosOrderByCodLinea(List<Integer> cdgoExpedient) {
		return tbasg118EstadoexpRepository.getTramosOrderByCodLinea(cdgoExpedient);
	}

	@Override
	public List<GetTramosOrderByCodLineaDTO> getFechasOtorgamientoPB(List<Integer> cdgoExpedient) {
		return tbasg118EstadoexpRepository.getFechasOtorgamientoPB(cdgoExpedient);
	}

	@Override
	public List<CountGetTramosDTO> countGetTramos(ParamCountGetTramos filtro) {
		return tbasg118EstadoexpRepository.countGetTramos(filtro);
	}

}