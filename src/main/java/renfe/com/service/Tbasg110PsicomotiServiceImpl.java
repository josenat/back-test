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

import renfe.com.model.dto.Tbasg110PsicomotiDto;
import renfe.com.model.entity.Tbasg110Psicomoti;
import renfe.com.repository.Tbasg110PsicomotiRepository;

@Transactional
@Service
public class Tbasg110PsicomotiServiceImpl implements Tbasg110PsicomotiService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg110PsicomotiRepository tbasg110PsicomotiRepository;

	public List<Tbasg110PsicomotiDto> getAllTbasg110Psicomoti(Tbasg110PsicomotiDto filter) {

		logger.info("getAllTbasg110Psicomoti " + filter);
		if (filter == null) {
			return this.toDtos(tbasg110PsicomotiRepository.findAll());
		}
		return this.toDtos(tbasg110PsicomotiRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg110PsicomotiDto findByCdgoMotivo(Integer cdgoMotivo) {

		Optional<Tbasg110Psicomoti> tbasg110PsicomotiData = tbasg110PsicomotiRepository.findByCdgoMotivo(cdgoMotivo);

		if (tbasg110PsicomotiData.isPresent()) {
			return toDto(tbasg110PsicomotiData.get());
		}
		return null;
	}

	public Tbasg110PsicomotiDto createTbasg110Psicomoti(Tbasg110PsicomotiDto tbasg110PsicomotiDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg110Psicomoti dbTbasg110Psicomoti = new Tbasg110Psicomoti();
		BeanUtils.copyProperties(dbTbasg110Psicomoti, tbasg110PsicomotiDto);
		Tbasg110Psicomoti _tbasg110Psicomoti = tbasg110PsicomotiRepository.save(dbTbasg110Psicomoti);
		return toDto(_tbasg110Psicomoti);
	}

	public Tbasg110PsicomotiDto updateTbasg110Psicomoti(Integer cdgoMotivo, Tbasg110PsicomotiDto tbasg110PsicomotiDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg110Psicomoti> tbasg110PsicomotiData = tbasg110PsicomotiRepository.findById(cdgoMotivo);

		if (tbasg110PsicomotiData.isPresent()) {
			Tbasg110Psicomoti dbTbasg110Psicomoti = tbasg110PsicomotiData.get();
			BeanUtils.copyProperties(dbTbasg110Psicomoti, tbasg110PsicomotiDto);
			return toDto(tbasg110PsicomotiRepository.save(dbTbasg110Psicomoti));
		}
		return null;
	}

	public int deleteTbasg110Psicomoti(Integer cdgoMotivo) {

		tbasg110PsicomotiRepository.deleteById(cdgoMotivo);
		return 1;
	}

	public List<Tbasg110PsicomotiDto> findByCdgoMotivoIn(List<Integer> cdgoMotivo) {

		List<Tbasg110Psicomoti> tbasg110Psicomotis = tbasg110PsicomotiRepository.findByCdgoMotivoIn(cdgoMotivo);

		return toDtos(tbasg110Psicomotis);
	}

	public List<Tbasg110PsicomotiDto> getPsicoMotiCount() {
		return toDtos(tbasg110PsicomotiRepository.getPsicoMotiCount());
	}

	public List<Tbasg110PsicomotiDto> getPsicoMotiListAscendente() {
		return toDtos(tbasg110PsicomotiRepository.getPsicoMotiListAscendente());
	}

	public List<Tbasg110PsicomotiDto> getPsicoMotiListDescendente() {
		return toDtos(tbasg110PsicomotiRepository.getPsicoMotiListDescendente());
	}

	public List<Tbasg110PsicomotiDto> getPsicoMotiActiveListAscendente() {
		return toDtos(tbasg110PsicomotiRepository.getPsicoMotiActiveListAscendente());
	}

	public List<Tbasg110PsicomotiDto> getPsicoMotiActiveListDescendente() {
		return toDtos(tbasg110PsicomotiRepository.getPsicoMotiActiveListDescendente());
	}

	public List<Tbasg110PsicomotiDto> getPsicoMoti(Integer cdgoMotivo) {
		return toDtos(tbasg110PsicomotiRepository.getPsicoMoti(cdgoMotivo));
	}

	public int insertPsicoMoti(Tbasg110Psicomoti bean) {
		return tbasg110PsicomotiRepository.insertPsicoMoti(bean);
	}

	public int updatePsicoMoti(Tbasg110Psicomoti bean) {
		return tbasg110PsicomotiRepository.updatePsicoMoti(bean);
	}
	
	public int estadoPsicoMoti(Tbasg110Psicomoti bean) {
		return tbasg110PsicomotiRepository.estadoPsicoMoti(bean);
	}

	public Tbasg110PsicomotiDto toDto(Tbasg110Psicomoti orig) {

		Tbasg110PsicomotiDto dest = new Tbasg110PsicomotiDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg110Psicomoti toEntity(Tbasg110PsicomotiDto orig) {

		Tbasg110Psicomoti dest = new Tbasg110Psicomoti();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg110PsicomotiDto> toDtos(List<Tbasg110Psicomoti> orig) {

		List<Tbasg110PsicomotiDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg110Psicomoti> toEntities(List<Tbasg110PsicomotiDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg110Psicomoti> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
