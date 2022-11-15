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

import renfe.com.dto.GetErrSaludDTO;
import renfe.com.dto.GetErrListParam;
import renfe.com.model.dto.Tbasg201ErrSaludDto;
import renfe.com.model.entity.Tbasg201ErrSalud;
import renfe.com.repository.Tbasg201ErrSaludRepository;

@Transactional
@Service
public class Tbasg201ErrSaludServiceImpl implements Tbasg201ErrSaludService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg201ErrSaludRepository tbasg201ErrSaludRepository;

	public List<Tbasg201ErrSaludDto> getAllTbasg201ErrSalud(Tbasg201ErrSaludDto filter) {

		logger.info("getAllTbasg201ErrSalud " + filter);
		if (filter == null) {
			return this.toDtos(tbasg201ErrSaludRepository.findAll());
		}
		return this.toDtos(tbasg201ErrSaludRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg201ErrSaludDto findByCdgoError(Integer cdgoError) {

		Optional<Tbasg201ErrSalud> tbasg201ErrSaludData = tbasg201ErrSaludRepository.findByCdgoError(cdgoError);

		if (tbasg201ErrSaludData.isPresent()) {
			return toDto(tbasg201ErrSaludData.get());
		}
		return null;
	}

	public Tbasg201ErrSaludDto createTbasg201ErrSalud(Tbasg201ErrSaludDto tbasg201ErrSaludDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg201ErrSalud dbTbasg201ErrSalud = new Tbasg201ErrSalud();
		BeanUtils.copyProperties(dbTbasg201ErrSalud, tbasg201ErrSaludDto);
		Tbasg201ErrSalud _tbasg201ErrSalud = tbasg201ErrSaludRepository.save(dbTbasg201ErrSalud);
		return toDto(_tbasg201ErrSalud);
	}

	public Tbasg201ErrSaludDto updateTbasg201ErrSalud(Integer cdgoError, Tbasg201ErrSaludDto tbasg201ErrSaludDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg201ErrSalud> tbasg201ErrSaludData = tbasg201ErrSaludRepository.findById(cdgoError);

		if (tbasg201ErrSaludData.isPresent()) {
			Tbasg201ErrSalud dbTbasg201ErrSalud = tbasg201ErrSaludData.get();
			BeanUtils.copyProperties(dbTbasg201ErrSalud, tbasg201ErrSaludDto);
			return toDto(tbasg201ErrSaludRepository.save(dbTbasg201ErrSalud));
		}
		return null;
	}

	public int deleteTbasg201ErrSalud(Integer cdgoError) {

		tbasg201ErrSaludRepository.deleteById(cdgoError);
		return 1;
	}

	public List<Tbasg201ErrSaludDto> findByCdgoErrorIn(List<Integer> cdgoError) {

		List<Tbasg201ErrSalud> tbasg201ErrSaluds = tbasg201ErrSaludRepository.findByCdgoErrorIn(cdgoError);

		return toDtos(tbasg201ErrSaluds);
	}

	public List<Tbasg201ErrSaludDto> getErrSaludList(GetErrListParam filter) {
		return toDtos(tbasg201ErrSaludRepository.getErrSaludList(filter));
	}

	public List<GetErrSaludDTO> getErrSalud(Integer cdgoError) {
		return tbasg201ErrSaludRepository.getErrSalud(cdgoError);
	}

	public int updateErrSalud(Tbasg201ErrSalud bean) {
		return tbasg201ErrSaludRepository.updateErrSalud(bean);
	}

	public int deleteErrSalud(Integer cdgoError) {
		return tbasg201ErrSaludRepository.deleteErrSalud(cdgoError);
	}

	public Tbasg201ErrSaludDto toDto(Tbasg201ErrSalud orig) {

		Tbasg201ErrSaludDto dest = new Tbasg201ErrSaludDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg201ErrSalud toEntity(Tbasg201ErrSaludDto orig) {

		Tbasg201ErrSalud dest = new Tbasg201ErrSalud();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg201ErrSaludDto> toDtos(List<Tbasg201ErrSalud> orig) {

		List<Tbasg201ErrSaludDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg201ErrSalud> toEntities(List<Tbasg201ErrSaludDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg201ErrSalud> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
