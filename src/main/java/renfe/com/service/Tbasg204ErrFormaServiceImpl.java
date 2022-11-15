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

import renfe.com.dto.GetErrFormaDTO;
import renfe.com.dto.GetErrListParam;
import renfe.com.model.dto.Tbasg204ErrFormaDto;
import renfe.com.model.entity.Tbasg204ErrForma;
import renfe.com.repository.Tbasg204ErrFormaRepository;

@Transactional
@Service
public class Tbasg204ErrFormaServiceImpl implements Tbasg204ErrFormaService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg204ErrFormaRepository tbasg204ErrFormaRepository;

	public List<Tbasg204ErrFormaDto> getAllTbasg204ErrForma(Tbasg204ErrFormaDto filter) {

		logger.info("getAllTbasg204ErrForma " + filter);
		if (filter == null) {
			return this.toDtos(tbasg204ErrFormaRepository.findAll());
		}
		return this.toDtos(tbasg204ErrFormaRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg204ErrFormaDto findByCdgoError(Integer cdgoError) {

		Optional<Tbasg204ErrForma> tbasg204ErrFormaData = tbasg204ErrFormaRepository.findByCdgoError(cdgoError);

		if (tbasg204ErrFormaData.isPresent()) {
			return toDto(tbasg204ErrFormaData.get());
		}
		return null;
	}

	public Tbasg204ErrFormaDto createTbasg204ErrForma(Tbasg204ErrFormaDto tbasg204ErrFormaDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg204ErrForma dbTbasg204ErrForma = new Tbasg204ErrForma();
		BeanUtils.copyProperties(dbTbasg204ErrForma, tbasg204ErrFormaDto);
		Tbasg204ErrForma _tbasg204ErrForma = tbasg204ErrFormaRepository.save(dbTbasg204ErrForma);
		return toDto(_tbasg204ErrForma);
	}

	public Tbasg204ErrFormaDto updateTbasg204ErrForma(Integer cdgoError, Tbasg204ErrFormaDto tbasg204ErrFormaDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg204ErrForma> tbasg204ErrFormaData = tbasg204ErrFormaRepository.findById(cdgoError);

		if (tbasg204ErrFormaData.isPresent()) {
			Tbasg204ErrForma dbTbasg204ErrForma = tbasg204ErrFormaData.get();
			BeanUtils.copyProperties(dbTbasg204ErrForma, tbasg204ErrFormaDto);
			return toDto(tbasg204ErrFormaRepository.save(dbTbasg204ErrForma));
		}
		return null;
	}

	public int deleteTbasg204ErrForma(Integer cdgoError) {

		tbasg204ErrFormaRepository.deleteById(cdgoError);
		return 1;
	}

	public List<Tbasg204ErrFormaDto> findByCdgoErrorIn(List<Integer> cdgoError) {

		List<Tbasg204ErrForma> tbasg204ErrFormas = tbasg204ErrFormaRepository.findByCdgoErrorIn(cdgoError);

		return toDtos(tbasg204ErrFormas);
	}

	public List<Tbasg204ErrFormaDto> getErrFormaList(GetErrListParam filter) {
		return toDtos(tbasg204ErrFormaRepository.getErrFormaList(filter));
	}

	public List<Tbasg204ErrFormaDto> getErrFormaList2() {
		return toDtos(tbasg204ErrFormaRepository.getErrFormaList2());
	}

	public List<GetErrFormaDTO> getErrForma(Integer cdgoError) {
		return tbasg204ErrFormaRepository.getErrForma(cdgoError);
	}

	public int updateErrForma(Tbasg204ErrForma bean) {
		return tbasg204ErrFormaRepository.updateErrForma(bean);
	}

	public int deleteErrForma(Integer cdgoError) {
		return tbasg204ErrFormaRepository.deleteErrForma(cdgoError);
	}

	public Tbasg204ErrFormaDto toDto(Tbasg204ErrForma orig) {

		Tbasg204ErrFormaDto dest = new Tbasg204ErrFormaDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg204ErrForma toEntity(Tbasg204ErrFormaDto orig) {

		Tbasg204ErrForma dest = new Tbasg204ErrForma();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg204ErrFormaDto> toDtos(List<Tbasg204ErrForma> orig) {

		List<Tbasg204ErrFormaDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg204ErrForma> toEntities(List<Tbasg204ErrFormaDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg204ErrForma> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}

}
