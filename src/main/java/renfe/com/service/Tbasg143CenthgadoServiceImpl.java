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

import renfe.com.dto.GetCentHgadoListAscendenteDTO;
import renfe.com.model.dto.Tbasg143CenthgadoDto;
import renfe.com.model.entity.Tbasg143Centhgado;
import renfe.com.repository.Tbasg143CenthgadoRepository;

@Transactional
@Service
public class Tbasg143CenthgadoServiceImpl implements Tbasg143CenthgadoService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg143CenthgadoRepository tbasg143CenthgadoRepository;

	public List<Tbasg143CenthgadoDto> getAllTbasg143Centhgado(Tbasg143CenthgadoDto filter) {

		logger.info("getAllTbasg143Centhgado " + filter);
		if (filter == null) {
			return this.toDtos(tbasg143CenthgadoRepository.findAll());
		}
		return this.toDtos(tbasg143CenthgadoRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg143CenthgadoDto findByCdgoCenthgado(Integer cdgoCenthgado) {

		Optional<Tbasg143Centhgado> tbasg143CenthgadoData = tbasg143CenthgadoRepository
				.findByCdgoCenthgado(cdgoCenthgado);

		if (tbasg143CenthgadoData.isPresent()) {
			return toDto(tbasg143CenthgadoData.get());
		}
		return null;
	}

	public Tbasg143CenthgadoDto createTbasg143Centhgado(Tbasg143CenthgadoDto tbasg143CenthgadoDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg143Centhgado dbTbasg143Centhgado = new Tbasg143Centhgado();
		BeanUtils.copyProperties(dbTbasg143Centhgado, tbasg143CenthgadoDto);
		Tbasg143Centhgado _tbasg143Centhgado = tbasg143CenthgadoRepository.save(dbTbasg143Centhgado);
		return toDto(_tbasg143Centhgado);
	}

	public Tbasg143CenthgadoDto updateTbasg143Centhgado(Integer cdgoCenthgado,
			Tbasg143CenthgadoDto tbasg143CenthgadoDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg143Centhgado> tbasg143CenthgadoData = tbasg143CenthgadoRepository.findById(cdgoCenthgado);

		if (tbasg143CenthgadoData.isPresent()) {
			Tbasg143Centhgado dbTbasg143Centhgado = tbasg143CenthgadoData.get();
			BeanUtils.copyProperties(dbTbasg143Centhgado, tbasg143CenthgadoDto);
			return toDto(tbasg143CenthgadoRepository.save(dbTbasg143Centhgado));
		}
		return null;
	}

	public int deleteTbasg143Centhgado(Integer cdgoCenthgado) {

		tbasg143CenthgadoRepository.deleteById(cdgoCenthgado);
		return 1;
	}

	public List<Tbasg143CenthgadoDto> findByCdgoCenthgadoIn(List<Integer> cdgoCenthgado) {

		List<Tbasg143Centhgado> tbasg143Centhgados = tbasg143CenthgadoRepository.findByCdgoCenthgadoIn(cdgoCenthgado);

		return toDtos(tbasg143Centhgados);
	}

	public List<Tbasg143CenthgadoDto> getCentHgado(String cdgoCenthgado) {
		return toDtos(tbasg143CenthgadoRepository.getCentHgado(cdgoCenthgado));
	}

	public List<Tbasg143CenthgadoDto> getActiveCentHgado(String cdgoCenthgado) {
		return toDtos(tbasg143CenthgadoRepository.getActiveCentHgado(cdgoCenthgado));
	}

	public List<Tbasg143CenthgadoDto> getCentHgadoByCIF(String desgCif) {
		return toDtos(tbasg143CenthgadoRepository.getCentHgadoByCIF(desgCif));
	}

	public List<Tbasg143CenthgadoDto> getCentHgadoCount() {
		return toDtos(tbasg143CenthgadoRepository.getCentHgadoCount());
	}

	public List<Tbasg143CenthgadoDto> findByCdgoCentFor(String cdgoCentrofor) {
		return toDtos(tbasg143CenthgadoRepository.findByCdgoCentFor(cdgoCentrofor));
	}

	public List<Tbasg143CenthgadoDto> findByCdgoCentMed(String cdgoCenmed) {
		return toDtos(tbasg143CenthgadoRepository.findByCdgoCentMed(cdgoCenmed));
	}

	public List<GetCentHgadoListAscendenteDTO> getCentHgadoListAscendente() {
		return tbasg143CenthgadoRepository.getCentHgadoListAscendente();
	}

	public List<Tbasg143CenthgadoDto> getCentHgadoListDescendente() {
		return toDtos(tbasg143CenthgadoRepository.getCentHgadoListDescendente());
	}

	public List<Tbasg143CenthgadoDto> getCentHgadoActiveListAscendente() {
		return toDtos(tbasg143CenthgadoRepository.getCentHgadoActiveListAscendente());
	}

	public int insertCentHgado(Tbasg143Centhgado bean) {
		return tbasg143CenthgadoRepository.insertCentHgado(bean);
	}

	public int updateCentHgado(Tbasg143Centhgado bean) {
		return tbasg143CenthgadoRepository.updateCentHgado(bean);
	}
	
	public int estadoCentHgado(Tbasg143Centhgado bean) {
		return tbasg143CenthgadoRepository.estadoCentHgado(bean);
	}

	public int reactivateCentHgado(Tbasg143Centhgado bean) {
		return tbasg143CenthgadoRepository.reactivateCentHgado(bean);
	}

	public Tbasg143CenthgadoDto toDto(Tbasg143Centhgado orig) {

		Tbasg143CenthgadoDto dest = new Tbasg143CenthgadoDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg143Centhgado toEntity(Tbasg143CenthgadoDto orig) {

		Tbasg143Centhgado dest = new Tbasg143Centhgado();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg143CenthgadoDto> toDtos(List<Tbasg143Centhgado> orig) {

		List<Tbasg143CenthgadoDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg143Centhgado> toEntities(List<Tbasg143CenthgadoDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg143Centhgado> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
