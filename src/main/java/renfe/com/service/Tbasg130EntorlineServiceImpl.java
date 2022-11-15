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

import renfe.com.dto.GetEntorLineListAscendenteCDGO_ENTORNODTO;
import renfe.com.model.dto.Tbasg130EntorlineDto;
import renfe.com.model.entity.Tbasg130Entorline;
import renfe.com.model.entity.Tbasg130EntorlinePK;
import renfe.com.repository.Tbasg130EntorlineRepository;

@Service
public class Tbasg130EntorlineServiceImpl implements Tbasg130EntorlineService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg130EntorlineRepository tbasg130EntorlineRepository;

	public List<Tbasg130EntorlineDto> getAllTbasg130Entorline(Tbasg130EntorlineDto filter) {

		logger.info("getAllTbasg130Entorline " + filter);
		if (filter == null) {
			return this.toDtos(tbasg130EntorlineRepository.findAll());
		}
		return this.toDtos(tbasg130EntorlineRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg130EntorlineDto findByCdgoDestinoCdgoEntornoCdgoLineaCdgoOrigen(String cdgoDestino, Integer cdgoEntorno,
			String cdgoLinea, String cdgoOrigen) {
		Tbasg130EntorlinePK pk = new Tbasg130EntorlinePK();
		pk.setCdgoDestino(cdgoDestino);
		pk.setCdgoEntorno(cdgoEntorno);
		pk.setCdgoLinea(cdgoLinea);
		pk.setCdgoOrigen(cdgoOrigen);
		Optional<Tbasg130Entorline> tbasg130EntorlineData = tbasg130EntorlineRepository.findById(pk);

		if (tbasg130EntorlineData.isPresent()) {
			return toDto(tbasg130EntorlineData.get());
		}
		return null;
	}

	public Tbasg130EntorlineDto createTbasg130Entorline(Tbasg130EntorlineDto tbasg130EntorlineDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg130Entorline dbTbasg130Entorline = new Tbasg130Entorline();
		BeanUtils.copyProperties(dbTbasg130Entorline, tbasg130EntorlineDto);
		Tbasg130Entorline _tbasg130Entorline = tbasg130EntorlineRepository.save(dbTbasg130Entorline);
		return toDto(_tbasg130Entorline);
	}

	public Tbasg130EntorlineDto updateTbasg130Entorline(String cdgoDestino, Integer cdgoEntorno, String cdgoLinea,
			String cdgoOrigen, Tbasg130EntorlineDto tbasg130EntorlineDto)
			throws IllegalAccessException, InvocationTargetException {
		Tbasg130EntorlinePK pk = new Tbasg130EntorlinePK();
		pk.setCdgoDestino(cdgoDestino);
		pk.setCdgoEntorno(cdgoEntorno);
		pk.setCdgoLinea(cdgoLinea);
		pk.setCdgoOrigen(cdgoOrigen);
		Optional<Tbasg130Entorline> tbasg130EntorlineData = tbasg130EntorlineRepository.findById(pk);

		if (tbasg130EntorlineData.isPresent()) {
			Tbasg130Entorline dbTbasg130Entorline = tbasg130EntorlineData.get();
			BeanUtils.copyProperties(dbTbasg130Entorline, tbasg130EntorlineDto);
			return toDto(tbasg130EntorlineRepository.save(dbTbasg130Entorline));
		}
		return null;
	}

	public int deleteTbasg130Entorline(String cdgoDestino, Integer cdgoEntorno, String cdgoLinea, String cdgoOrigen) {
		Tbasg130EntorlinePK pk = new Tbasg130EntorlinePK();
		pk.setCdgoDestino(cdgoDestino);
		pk.setCdgoEntorno(cdgoEntorno);
		pk.setCdgoLinea(cdgoLinea);
		pk.setCdgoOrigen(cdgoOrigen);
		tbasg130EntorlineRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg130EntorlineDto> findByCdgoDestinoCdgoEntornoCdgoLineaCdgoOrigenIn(List<String> cdgoDestino,
			List<Integer> cdgoEntorno, List<String> cdgoLinea, List<String> cdgoOrigen) {
		List<Tbasg130EntorlinePK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoDestino.size(); i++) {
			Tbasg130EntorlinePK newPk = new Tbasg130EntorlinePK();
			newPk.setCdgoDestino(cdgoDestino.get(i));
			newPk.setCdgoEntorno(cdgoEntorno.get(i));
			newPk.setCdgoLinea(cdgoLinea.get(i));
			newPk.setCdgoOrigen(cdgoOrigen.get(i));
			pks.add(newPk);
		}
		List<Tbasg130Entorline> tbasg130Entorlines = tbasg130EntorlineRepository.findByTbasg130entorlinepkIn(pks);

		return toDtos(tbasg130Entorlines);
	}

	public List<Tbasg130EntorlineDto> getEntorLineCount() {
		return toDtos(tbasg130EntorlineRepository.getEntorLineCount());
	}

	public List<Tbasg130EntorlineDto> getEntorLineCountCDGO_ENTORNO(String cdgoEntorno) {
		return toDtos(tbasg130EntorlineRepository.getEntorLineCountCDGO_ENTORNO(cdgoEntorno));
	}

	public List<GetEntorLineListAscendenteCDGO_ENTORNODTO> getEntorLineListAscendenteCDGO_ENTORNO(String cdgoEntorno) {
		return tbasg130EntorlineRepository.getEntorLineListAscendenteCDGO_ENTORNO(cdgoEntorno);
	}

	public List<Tbasg130EntorlineDto> getEntorLineListDescendenteCDGO_ENTORNO(String cdgoEntorno) {
		return toDtos(tbasg130EntorlineRepository.getEntorLineListDescendenteCDGO_ENTORNO(cdgoEntorno));
	}

	public List<Tbasg130EntorlineDto> getEntorLine(String cdgoEntorno, String cdgoLinea, String cdgoOrigen,
			String cdgoDestino) {
		return toDtos(tbasg130EntorlineRepository.getEntorLine(cdgoEntorno, cdgoLinea, cdgoOrigen, cdgoDestino));
	}

	public List<Tbasg130EntorlineDto> getEntorLineListActive(String cdgoEntorno) {
		return toDtos(tbasg130EntorlineRepository.getEntorLineListActive(cdgoEntorno));
	}

	public List<Tbasg130EntorlineDto> getEntorLineListDynamic(String cdgoEntorno) {
		return toDtos(tbasg130EntorlineRepository.getEntorLineListDynamic(cdgoEntorno));
	}

	public int insertEntorLine(Tbasg130Entorline bean) {
		return tbasg130EntorlineRepository.insertEntorLine(bean);
	}

	public int reactiveEntorLine(Tbasg130Entorline bean) {
		return tbasg130EntorlineRepository.reactiveEntorLine(bean);
	}

	public int desactiveEntorLine(Tbasg130Entorline bean) {
		return tbasg130EntorlineRepository.desactiveEntorLine(bean);
	}

	public int deleteEntorLine() {
		return tbasg130EntorlineRepository.deleteEntorLine();
	}

	public int deleteTramoLineaEntorno() {
		return tbasg130EntorlineRepository.deleteTramoLineaEntorno();
	}

	public List<Tbasg130EntorlineDto> getTramosEntorno(String cdgoEntorno) {
		return toDtos(tbasg130EntorlineRepository.getTramosEntorno(cdgoEntorno));
	}

	public List<Tbasg130EntorlineDto> getTramosEntornos(String cdgoEntorno) {
		return toDtos(tbasg130EntorlineRepository.getTramosEntornos(cdgoEntorno));
	}

	public Tbasg130EntorlineDto toDto(Tbasg130Entorline orig) {

		Tbasg130EntorlineDto dest = new Tbasg130EntorlineDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			if(dest!=null && orig!=null) {
				dest.setCdgoDestino(orig.getTbasg130entorlinepk().getCdgoDestino());
				dest.setCdgoEntorno(orig.getTbasg130entorlinepk().getCdgoEntorno());
				dest.setCdgoLinea(orig.getTbasg130entorlinepk().getCdgoLinea());
				dest.setCdgoOrigen(orig.getTbasg130entorlinepk().getCdgoOrigen());
			}
		}
		return dest;
	}

	public Tbasg130Entorline toEntity(Tbasg130EntorlineDto orig) {

		Tbasg130Entorline dest = new Tbasg130Entorline();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg130EntorlineDto> toDtos(List<Tbasg130Entorline> orig) {

		List<Tbasg130EntorlineDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg130Entorline> toEntities(List<Tbasg130EntorlineDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg130Entorline> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
