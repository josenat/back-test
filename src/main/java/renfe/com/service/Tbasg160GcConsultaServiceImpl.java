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

import renfe.com.model.dto.Tbasg160GcConsultaDto;
import renfe.com.model.entity.Tbasg160GcConsulta;
import renfe.com.repository.Tbasg160GcConsultaRepository;

@Service
public class Tbasg160GcConsultaServiceImpl implements Tbasg160GcConsultaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg160GcConsultaRepository tbasg160GcConsultaRepository;

	public List<Tbasg160GcConsultaDto> getAllTbasg160GcConsulta(Tbasg160GcConsultaDto filter) {

		logger.info("getAllTbasg160GcConsulta " + filter);
		if (filter == null) {
			return this.toDtos(tbasg160GcConsultaRepository.findAll());
		}
		return this.toDtos(tbasg160GcConsultaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg160GcConsultaDto findByCdgoConsulta(Integer cdgoConsulta) {

		Optional<Tbasg160GcConsulta> tbasg160GcConsultaData = tbasg160GcConsultaRepository
				.findByCdgoConsulta(cdgoConsulta);

		if (tbasg160GcConsultaData.isPresent()) {
			return toDto(tbasg160GcConsultaData.get());
		}
		return null;
	}

	public Tbasg160GcConsultaDto createTbasg160GcConsulta(Tbasg160GcConsultaDto tbasg160GcConsultaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg160GcConsulta dbTbasg160GcConsulta = new Tbasg160GcConsulta();
		BeanUtils.copyProperties(dbTbasg160GcConsulta, tbasg160GcConsultaDto);
		Tbasg160GcConsulta _tbasg160GcConsulta = tbasg160GcConsultaRepository.save(dbTbasg160GcConsulta);
		return toDto(_tbasg160GcConsulta);
	}

	public Tbasg160GcConsultaDto updateTbasg160GcConsulta(Integer cdgoConsulta,
			Tbasg160GcConsultaDto tbasg160GcConsultaDto) throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg160GcConsulta> tbasg160GcConsultaData = tbasg160GcConsultaRepository.findById(cdgoConsulta);

		if (tbasg160GcConsultaData.isPresent()) {
			Tbasg160GcConsulta dbTbasg160GcConsulta = tbasg160GcConsultaData.get();
			BeanUtils.copyProperties(dbTbasg160GcConsulta, tbasg160GcConsultaDto);
			return toDto(tbasg160GcConsultaRepository.save(dbTbasg160GcConsulta));
		}
		return null;
	}

	public int deleteTbasg160GcConsulta(Integer cdgoConsulta) {

		tbasg160GcConsultaRepository.deleteById(cdgoConsulta);
		return 1;
	}

	public List<Tbasg160GcConsultaDto> findByCdgoConsultaIn(List<Integer> cdgoConsulta) {

		List<Tbasg160GcConsulta> tbasg160GcConsultas = tbasg160GcConsultaRepository.findByCdgoConsultaIn(cdgoConsulta);

		return toDtos(tbasg160GcConsultas);
	}

	public List<Tbasg160GcConsultaDto> getGcConsultasListActive(String desgUsuario) {
		return toDtos(tbasg160GcConsultaRepository.getGcConsultasListActive(desgUsuario));
	}

	public List<Tbasg160GcConsultaDto> getGcConsulta(String cdgoConsulta) {
		return toDtos(tbasg160GcConsultaRepository.getGcConsulta(cdgoConsulta));
	}

	public int insertGcConsulta(Tbasg160GcConsulta bean) {
		return tbasg160GcConsultaRepository.insertGcConsulta(bean);
	}

	public int updateGcConsulta(Tbasg160GcConsulta bean) {
		return tbasg160GcConsultaRepository.updateGcConsulta(bean);
	}

	public int deleteGcConsulta(Tbasg160GcConsulta bean) {
		return tbasg160GcConsultaRepository.deleteGcConsulta(bean);
	}

	public Tbasg160GcConsultaDto toDto(Tbasg160GcConsulta orig) {

		Tbasg160GcConsultaDto dest = new Tbasg160GcConsultaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg160GcConsulta toEntity(Tbasg160GcConsultaDto orig) {

		Tbasg160GcConsulta dest = new Tbasg160GcConsulta();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg160GcConsultaDto> toDtos(List<Tbasg160GcConsulta> orig) {

		List<Tbasg160GcConsultaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg160GcConsulta> toEntities(List<Tbasg160GcConsultaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg160GcConsulta> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
