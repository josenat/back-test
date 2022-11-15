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

import renfe.com.model.dto.Tbasg161GcResultadoDto;
import renfe.com.model.entity.Tbasg161GcResultado;
import renfe.com.model.entity.Tbasg161GcResultadoPK;
import renfe.com.repository.Tbasg161GcResultadoRepository;

@Service
public class Tbasg161GcResultadoServiceImpl implements Tbasg161GcResultadoService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg161GcResultadoRepository tbasg161GcResultadoRepository;

	public List<Tbasg161GcResultadoDto> getAllTbasg161GcResultado(Tbasg161GcResultadoDto filter) {

		logger.info("getAllTbasg161GcResultado " + filter);
		if (filter == null) {
			return this.toDtos(tbasg161GcResultadoRepository.findAll());
		}
		return this.toDtos(tbasg161GcResultadoRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg161GcResultadoDto findByCdgoCategoriaCdgoConceptoCdgoConsulta(String cdgoCategoria, String cdgoConcepto,
			Integer cdgoConsulta) {
		Tbasg161GcResultadoPK pk = new Tbasg161GcResultadoPK();
		pk.setCdgoCategoria(cdgoCategoria);
		pk.setCdgoConcepto(cdgoConcepto);
		pk.setCdgoConsulta(cdgoConsulta);
		Optional<Tbasg161GcResultado> tbasg161GcResultadoData = tbasg161GcResultadoRepository.findById(pk);

		if (tbasg161GcResultadoData.isPresent()) {
			return toDto(tbasg161GcResultadoData.get());
		}
		return null;
	}

	public Tbasg161GcResultadoDto createTbasg161GcResultado(Tbasg161GcResultadoDto tbasg161GcResultadoDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg161GcResultado dbTbasg161GcResultado = new Tbasg161GcResultado();
		BeanUtils.copyProperties(dbTbasg161GcResultado, tbasg161GcResultadoDto);
		Tbasg161GcResultado _tbasg161GcResultado = tbasg161GcResultadoRepository.save(dbTbasg161GcResultado);
		return toDto(_tbasg161GcResultado);
	}

	public Tbasg161GcResultadoDto updateTbasg161GcResultado(String cdgoCategoria, String cdgoConcepto,
			Integer cdgoConsulta, Tbasg161GcResultadoDto tbasg161GcResultadoDto)
			throws IllegalAccessException, InvocationTargetException {
		Tbasg161GcResultadoPK pk = new Tbasg161GcResultadoPK();
		pk.setCdgoCategoria(cdgoCategoria);
		pk.setCdgoConcepto(cdgoConcepto);
		pk.setCdgoConsulta(cdgoConsulta);
		Optional<Tbasg161GcResultado> tbasg161GcResultadoData = tbasg161GcResultadoRepository.findById(pk);

		if (tbasg161GcResultadoData.isPresent()) {
			Tbasg161GcResultado dbTbasg161GcResultado = tbasg161GcResultadoData.get();
			BeanUtils.copyProperties(dbTbasg161GcResultado, tbasg161GcResultadoDto);
			return toDto(tbasg161GcResultadoRepository.save(dbTbasg161GcResultado));
		}
		return null;
	}

	public int deleteTbasg161GcResultado(String cdgoCategoria, String cdgoConcepto, Integer cdgoConsulta) {
		Tbasg161GcResultadoPK pk = new Tbasg161GcResultadoPK();
		pk.setCdgoCategoria(cdgoCategoria);
		pk.setCdgoConcepto(cdgoConcepto);
		pk.setCdgoConsulta(cdgoConsulta);
		tbasg161GcResultadoRepository.deleteById(pk);
		return 1;
	}

	public List<Tbasg161GcResultadoDto> findByCdgoCategoriaCdgoConceptoCdgoConsultaIn(List<String> cdgoCategoria,
			List<String> cdgoConcepto, List<Integer> cdgoConsulta) {
		List<Tbasg161GcResultadoPK> pks = new ArrayList<>();
		for (int i = 0; i < cdgoCategoria.size(); i++) {
			Tbasg161GcResultadoPK newPk = new Tbasg161GcResultadoPK();
			newPk.setCdgoCategoria(cdgoCategoria.get(i));
			newPk.setCdgoConcepto(cdgoConcepto.get(i));
			newPk.setCdgoConsulta(cdgoConsulta.get(i));
			pks.add(newPk);
		}
		List<Tbasg161GcResultado> tbasg161GcResultados = tbasg161GcResultadoRepository
				.findByTbasg161gcresultadopkIn(pks);

		return toDtos(tbasg161GcResultados);
	}

	public List<Tbasg161GcResultadoDto> getGcResultadosListActive(String cdgoConsulta) {
		return toDtos(tbasg161GcResultadoRepository.getGcResultadosListActive(cdgoConsulta));
	}

	public List<Tbasg161GcResultadoDto> getGcResultado(String cdgoConsulta, String cdgoCategoria, String cdgoConcepto) {
		return toDtos(tbasg161GcResultadoRepository.getGcResultado(cdgoConsulta, cdgoCategoria, cdgoConcepto));
	}

	public int insertGcResultado(Tbasg161GcResultado bean) {
		return tbasg161GcResultadoRepository.insertGcResultado(bean);
	}

	public int updateGcResultado(Tbasg161GcResultado bean) {
		return tbasg161GcResultadoRepository.updateGcResultado(bean);
	}

	public int deleteGcResultadosConsulta(Tbasg161GcResultado bean) {
		return tbasg161GcResultadoRepository.deleteGcResultadosConsulta(bean);
	}

	public Tbasg161GcResultadoDto toDto(Tbasg161GcResultado orig) {

		Tbasg161GcResultadoDto dest = new Tbasg161GcResultadoDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg161GcResultado toEntity(Tbasg161GcResultadoDto orig) {

		Tbasg161GcResultado dest = new Tbasg161GcResultado();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg161GcResultadoDto> toDtos(List<Tbasg161GcResultado> orig) {

		List<Tbasg161GcResultadoDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg161GcResultado> toEntities(List<Tbasg161GcResultadoDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg161GcResultado> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
