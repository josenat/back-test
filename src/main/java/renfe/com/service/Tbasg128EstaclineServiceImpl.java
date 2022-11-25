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

import renfe.com.model.dto.Tbasg128EstaclineDto;
import renfe.com.model.entity.Tbasg128Estacline;
import renfe.com.model.entity.Tbasg128EstaclinePK;
import renfe.com.model.entity.Tbasg152Persemp;
import renfe.com.repository.Tbasg128EstaclineRepository;

@Transactional
@Service
public class Tbasg128EstaclineServiceImpl implements Tbasg128EstaclineService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg128EstaclineRepository tbasg128EstaclineRepository;

	public List<Tbasg128EstaclineDto> getAllTbasg128Estacline(Tbasg128EstaclineDto filter) {

		logger.info("getAllTbasg128Estacline " + filter);
		if (filter == null) {
			return this.toDtos(tbasg128EstaclineRepository.findAll());
		}
		return this.toDtos(tbasg128EstaclineRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg128EstaclineDto findByCdgoEstacionCdgoLinea(String cdgoEstacion, String cdgoLinea) {
		Tbasg128EstaclinePK pk = new Tbasg128EstaclinePK();
		pk.setCdgoEstacion(cdgoEstacion);
		pk.setCdgoLinea(cdgoLinea);
		Optional<Tbasg128Estacline> tbasg128EstaclineData = tbasg128EstaclineRepository.findById(pk);

		if (tbasg128EstaclineData.isPresent()) {
			return toDto(tbasg128EstaclineData.get());
		}
		return null;
	}

	public Tbasg128EstaclineDto createTbasg128Estacline(Tbasg128EstaclineDto tbasg128EstaclineDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg128Estacline dbTbasg128Estacline = new Tbasg128Estacline();
		BeanUtils.copyProperties(dbTbasg128Estacline, tbasg128EstaclineDto);
		Tbasg128Estacline _tbasg128Estacline = tbasg128EstaclineRepository.save(dbTbasg128Estacline);
		return toDto(_tbasg128Estacline);
	}

	public Tbasg128EstaclineDto updateTbasg128Estacline(String cdgoEstacion, String cdgoLinea,
			Tbasg128EstaclineDto tbasg128EstaclineDto) throws IllegalAccessException, InvocationTargetException {
		Tbasg128EstaclinePK pk = new Tbasg128EstaclinePK();
		pk.setCdgoEstacion(cdgoEstacion);
		pk.setCdgoLinea(cdgoLinea);
		Optional<Tbasg128Estacline> tbasg128EstaclineData = tbasg128EstaclineRepository.findById(pk);

		if (tbasg128EstaclineData.isPresent()) {
			Tbasg128Estacline dbTbasg128Estacline = tbasg128EstaclineData.get();
			BeanUtils.copyProperties(dbTbasg128Estacline, tbasg128EstaclineDto);
			return toDto(tbasg128EstaclineRepository.save(dbTbasg128Estacline));
		}
		return null;
	}

	public int deleteTbasg128Estacline(String cdgoEstacion, String cdgoLinea) {
		Tbasg128EstaclinePK pk = new Tbasg128EstaclinePK();
		pk.setCdgoEstacion(cdgoEstacion);
		pk.setCdgoLinea(cdgoLinea);
		tbasg128EstaclineRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg128EstaclineDto> findByCdgoEstacionCdgoLineaIn(List<String> cdgoEstacion, List<String> cdgoLinea) {
		List<Tbasg128EstaclinePK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoEstacion.size(); i++) {
			Tbasg128EstaclinePK newPk = new Tbasg128EstaclinePK();
			newPk.setCdgoEstacion(cdgoEstacion.get(i));
			newPk.setCdgoLinea(cdgoLinea.get(i));
			pks.add(newPk);
		}
		List<Tbasg128Estacline> tbasg128Estaclines = tbasg128EstaclineRepository.findByTbasg128estaclinepkIn(pks);

		return toDtos(tbasg128Estaclines);
	}

	public List<Tbasg128EstaclineDto> getDatosLinea(String cdgoEstacion, String cdgoAcredita) {
		return toDtos(tbasg128EstaclineRepository.getDatosLinea(cdgoEstacion, cdgoAcredita));
	}

	public List<Tbasg128EstaclineDto> getDescTipoAmbitoEstacionLinea(String cdgoEstacion) {
		return toDtos(tbasg128EstaclineRepository.getDescTipoAmbitoEstacionLinea(cdgoEstacion));
	}

	public List<Tbasg128EstaclineDto> getOrdenByLineasEstacionesList(/** FIXME revisar tipo */
	Object cdgoLinea, /** FIXME revisar tipo */
	Object cdgoOrden, /** FIXME revisar tipo */
	Object cdgoOrden_1) {
		return toDtos(tbasg128EstaclineRepository.getOrdenByLineasEstacionesList(cdgoLinea, cdgoOrden, cdgoOrden));
	}

	public List<Tbasg128EstaclineDto> getOrdenByEstacion(/** FIXME revisar tipo */
	Object cdgoLinea, /** FIXME revisar tipo */
	Object cdgoEstacion) {
		return toDtos(tbasg128EstaclineRepository.getOrdenByEstacion(cdgoLinea, cdgoEstacion));
	}

	public List<Tbasg128EstaclineDto> getEntorLineOrdenOrigenDestino(String cdgoEntorno, String cdgoLinea) {
		return toDtos(tbasg128EstaclineRepository.getEntorLineOrdenOrigenDestino(cdgoEntorno, cdgoLinea));
	}

	public List<Tbasg128EstaclineDto> getEstacLineList() {
		return toDtos(tbasg128EstaclineRepository.getEstacLineList());
	}

	public List<Tbasg128EstaclineDto> getEstacLineCount() {
		return toDtos(tbasg128EstaclineRepository.getEstacLineCount());
	}

	public List<Tbasg128EstaclineDto> getEstacLineCountByLine(String cdgoLinea) {
		return toDtos(tbasg128EstaclineRepository.getEstacLineCountByLine(cdgoLinea));
	}

	public List<Tbasg128EstaclineDto> getEstacLineCountByEstacion(String cdgoEstacion) {
		return toDtos(tbasg128EstaclineRepository.getEstacLineCountByEstacion(cdgoEstacion));
	}

	public List<Tbasg128EstaclineDto> getEstacLineListAscendente() {
		return tbasg128EstaclineRepository.getEstacLineListAscendente();
	}
	
	public List<Tbasg128EstaclineDto> getEstacLineListAscCdgoLinea(String cdgoLinea) {
		return tbasg128EstaclineRepository.getEstacLineListAscCdgoLinea(cdgoLinea);
	}

	public List<Tbasg128EstaclineDto> getEstacLineListDescendente() {
		return toDtos(tbasg128EstaclineRepository.getEstacLineListDescendente());
	}

	public List<Tbasg128EstaclineDto> getEstacLineActiveListAscendente() {
		return toDtos(tbasg128EstaclineRepository.getEstacLineActiveListAscendente());
	}

	public List<Tbasg128EstaclineDto> getEstacLineActiveListDescendente() {
		return toDtos(tbasg128EstaclineRepository.getEstacLineActiveListDescendente());
	}

	public List<Tbasg128EstaclineDto> getEstacLineMax(String cdgoLinea) {
		//return toDtos(tbasg128EstaclineRepository.getEstacLineMax(cdgoLinea));
		
		List<Tbasg128Estacline> x = tbasg128EstaclineRepository.getEstacLineMax(cdgoLinea);
		List<Tbasg128EstaclineDto> y = toDtos(x);
		
		int i = 0;
		
		for( Tbasg128Estacline z:x) {
			y.get(i).setCdgoLinea(z.getTbasg128estaclinepk().getCdgoLinea());
			y.get(i).setCdgoEstacion(z.getTbasg128estaclinepk().getCdgoEstacion());
			i++;
		}	
		return y;
		
	}

	public List<Tbasg128EstaclineDto> getEstacLineMin(String cdgoLinea) {
		//return toDtos(tbasg128EstaclineRepository.getEstacLineMin(cdgoLinea));
		
		List<Tbasg128Estacline> x = tbasg128EstaclineRepository.getEstacLineMin(cdgoLinea);
		List<Tbasg128EstaclineDto> y = toDtos(x);
		
		int i = 0;
		
		for( Tbasg128Estacline z:x) {
			y.get(i).setCdgoLinea(z.getTbasg128estaclinepk().getCdgoLinea());
			y.get(i).setCdgoEstacion(z.getTbasg128estaclinepk().getCdgoEstacion());
			i++;
		}	
		return y;
	}

	public List<Tbasg128EstaclineDto> getEstacLineMaxByOrden(String cdgoLinea) {
		return toDtos(tbasg128EstaclineRepository.getEstacLineMaxByOrden(cdgoLinea));
	}

	public List<Tbasg128EstaclineDto> getEstacLineMinByOrden(String cdgoLinea) {
		return toDtos(tbasg128EstaclineRepository.getEstacLineMinByOrden(cdgoLinea));
	}

	public List<Tbasg128EstaclineDto> getEstacLineListByLineDesc(String cdgoLinea) {
		return toDtos(tbasg128EstaclineRepository.getEstacLineListByLineDesc(cdgoLinea));
	}

	public List<Tbasg128EstaclineDto> getEstacLine(String cdgoEstacion, String cdgoLinea) {
		return toDtos(tbasg128EstaclineRepository.getEstacLine(cdgoEstacion, cdgoLinea));
	}

	public List<Tbasg128EstaclineDto> getEstacLineTramoByPKAsc(String cdgoLinea, String cdgoOrigen, String cdgoDestino) {
		//return toDtos(tbasg128EstaclineRepository.getEstacLineTramoByPKAsc(cdgoLinea, cdgoOrigen, cdgoDestino));
		List<Tbasg128Estacline> x = tbasg128EstaclineRepository.getEstacLineTramoByPKAsc(cdgoLinea, cdgoOrigen, cdgoDestino);
		List<Tbasg128EstaclineDto> y = toDtos(x);
		
		int i = 0;
		
		for( Tbasg128Estacline z:x) {
			y.get(i).setCdgoLinea(z.getTbasg128estaclinepk().getCdgoLinea());
			y.get(i).setCdgoEstacion(z.getTbasg128estaclinepk().getCdgoEstacion());
			i++;
		}	
		return y;
	}
	
	public List<Tbasg128EstaclineDto> getEstacLineNombre(String cdgoLinea) {
		
		List<Tbasg128Estacline> x = tbasg128EstaclineRepository.getEstacLineNombre(cdgoLinea);
		List<Tbasg128EstaclineDto> y = toDtos(x);
		
		int i = 0;
		
		for( Tbasg128Estacline z:x) {
			y.get(i).setCdgoLinea(z.getTbasg128estaclinepk().getCdgoLinea());
			i++;
		}	
		return y;
		
	}

	public List<Tbasg128EstaclineDto> getEstacLineListByLineAsc(String cdgoLinea) {
		return tbasg128EstaclineRepository.getEstacLineListByLineAsc(cdgoLinea);
	}

	public List<Tbasg128EstaclineDto> getEstacLineListByEstacionAsc(String cdgoEstacion) {
		return toDtos(tbasg128EstaclineRepository.getEstacLineListByEstacionAsc(cdgoEstacion));
	}

	public List<Tbasg128EstaclineDto> getEstacLineListByEstacionDesc(String cdgoEstacion) {
		return toDtos(tbasg128EstaclineRepository.getEstacLineListByEstacionDesc(cdgoEstacion));
	}

	public List<Tbasg128EstaclineDto> getEstacLineListActive() {
		
		List<Tbasg128Estacline> x = tbasg128EstaclineRepository.getEstacLineListActive();
		List<Tbasg128EstaclineDto> y = toDtos(x);
		
		int i = 0;
		
		for( Tbasg128Estacline z:x) {
			y.get(i).setCdgoEstacion(z.getTbasg128estaclinepk().getCdgoEstacion());
			i++;
		}	
		return y;
	}

	public int insertEstacLine(Tbasg128Estacline bean) {
		return tbasg128EstaclineRepository.insertEstacLine(bean);
	}

	public int updateEstacLine(Tbasg128Estacline bean) {
		return tbasg128EstaclineRepository.updateEstacLine(bean);
	}
	
	public int updateEstacLineCdgoOrden(Tbasg128Estacline bean) {
		return tbasg128EstaclineRepository.updateEstacLineCdgoOrden(bean);
	}
	
	public int estadoEstacLine(Tbasg128Estacline bean) {
		return tbasg128EstaclineRepository.estadoEstacLine(bean);
	}

	public int deleteEstacLine(Tbasg128Estacline bean) {
		return tbasg128EstaclineRepository.deleteEstacLine(bean);
	}

	public Tbasg128EstaclineDto toDto(Tbasg128Estacline orig) {

		Tbasg128EstaclineDto dest = new Tbasg128EstaclineDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg128Estacline toEntity(Tbasg128EstaclineDto orig) {

		Tbasg128Estacline dest = new Tbasg128Estacline();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg128EstaclineDto> toDtos(List<Tbasg128Estacline> orig) {

		List<Tbasg128EstaclineDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg128Estacline> toEntities(List<Tbasg128EstaclineDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg128Estacline> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}

