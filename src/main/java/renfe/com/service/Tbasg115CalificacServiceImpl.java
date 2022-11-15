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

import renfe.com.model.dto.Tbasg115CalificacDto;
import renfe.com.model.entity.Tbasg115Calificac;
import renfe.com.repository.Tbasg115CalificacRepository;

@Transactional
@Service
public class Tbasg115CalificacServiceImpl implements Tbasg115CalificacService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg115CalificacRepository tbasg115CalificacRepository;

	public List<Tbasg115CalificacDto> getAllTbasg115Calificac(Tbasg115CalificacDto filter) {

		logger.info("getAllTbasg115Calificac " + filter);
		if (filter == null) {
			return this.toDtos(tbasg115CalificacRepository.findAll());
		}
		return this.toDtos(tbasg115CalificacRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg115CalificacDto findByCdgoCalifi(Integer cdgoCalifi) {

		Optional<Tbasg115Calificac> tbasg115CalificacData = tbasg115CalificacRepository.findByCdgoCalifi(cdgoCalifi);

		if (tbasg115CalificacData.isPresent()) {
			return toDto(tbasg115CalificacData.get());
		}
		return null;
	}

	public Tbasg115CalificacDto createTbasg115Calificac(Tbasg115CalificacDto tbasg115CalificacDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg115Calificac dbTbasg115Calificac = new Tbasg115Calificac();
		BeanUtils.copyProperties(dbTbasg115Calificac, tbasg115CalificacDto);
		Tbasg115Calificac _tbasg115Calificac = tbasg115CalificacRepository.save(dbTbasg115Calificac);
		return toDto(_tbasg115Calificac);
	}

	public Tbasg115CalificacDto updateTbasg115Calificac(Integer cdgoCalifi, Tbasg115CalificacDto tbasg115CalificacDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg115Calificac> tbasg115CalificacData = tbasg115CalificacRepository.findById(cdgoCalifi);

		if (tbasg115CalificacData.isPresent()) {
			Tbasg115Calificac dbTbasg115Calificac = tbasg115CalificacData.get();
			BeanUtils.copyProperties(dbTbasg115Calificac, tbasg115CalificacDto);
			return toDto(tbasg115CalificacRepository.save(dbTbasg115Calificac));
		}
		return null;
	}

	public int deleteTbasg115Calificac(Integer cdgoCalifi) {

		tbasg115CalificacRepository.deleteById(cdgoCalifi);
		return 1;
	}

	public List<Tbasg115CalificacDto> findByCdgoCalifiIn(List<Integer> cdgoCalifi) {

		List<Tbasg115Calificac> tbasg115Calificacs = tbasg115CalificacRepository.findByCdgoCalifiIn(cdgoCalifi);

		return toDtos(tbasg115Calificacs);
	}

	public List<Tbasg115CalificacDto> getCalificacCount() {
		return toDtos(tbasg115CalificacRepository.getCalificacCount());
	}

	public List<Tbasg115CalificacDto> getCalificacListAscendente() {
		return toDtos(tbasg115CalificacRepository.getCalificacListAscendente());
	}
	
	public List<Tbasg115CalificacDto> getCalificacActiveListAscendenteRevision() {
		return toDtos(tbasg115CalificacRepository.getCalificacActiveListAscendenteRevision());
	}

	public List<Tbasg115CalificacDto> getCalificacListDescendente() {
		return toDtos(tbasg115CalificacRepository.getCalificacListDescendente());
	}

	public List<Tbasg115CalificacDto> getCalificacActiveListAscendente() {
		return toDtos(tbasg115CalificacRepository.getCalificacActiveListAscendente());
	}

	public List<Tbasg115CalificacDto> getCalificacActiveListDescendente() {
		return toDtos(tbasg115CalificacRepository.getCalificacActiveListDescendente());
	}

	public List<Tbasg115CalificacDto> getCalificac(Integer cdgoCalifi) {
		return toDtos(tbasg115CalificacRepository.getCalificac(cdgoCalifi));
	}

	public int insertCalificac(Tbasg115Calificac bean) {
		return tbasg115CalificacRepository.insertCalificac(bean);
	}

	public int updateCalificac(Tbasg115Calificac bean) {
		return tbasg115CalificacRepository.updateCalificac(bean);
	}
	
	public int estadoCalificac(Tbasg115Calificac bean) {
		return tbasg115CalificacRepository.estadoCalificac(bean);
	}

	public Tbasg115CalificacDto toDto(Tbasg115Calificac orig) {

		Tbasg115CalificacDto dest = new Tbasg115CalificacDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg115Calificac toEntity(Tbasg115CalificacDto orig) {

		Tbasg115Calificac dest = new Tbasg115Calificac();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg115CalificacDto> toDtos(List<Tbasg115Calificac> orig) {

		List<Tbasg115CalificacDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg115Calificac> toEntities(List<Tbasg115CalificacDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg115Calificac> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
