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

import renfe.com.model.dto.Tbasg109PsicoambiDto;
import renfe.com.model.entity.Tbasg109Psicoambi;
import renfe.com.repository.Tbasg109PsicoambiRepository;

@Transactional
@Service
public class Tbasg109PsicoambiServiceImpl implements Tbasg109PsicoambiService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg109PsicoambiRepository tbasg109PsicoambiRepository;

	public List<Tbasg109PsicoambiDto> getAllTbasg109Psicoambi(Tbasg109PsicoambiDto filter) {

		logger.info("getAllTbasg109Psicoambi " + filter);
		if (filter == null) {
			return this.toDtos(tbasg109PsicoambiRepository.findAll());
		}
		return this.toDtos(tbasg109PsicoambiRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg109PsicoambiDto findByCdgoPsicamb(Integer cdgoPsicamb) {

		Optional<Tbasg109Psicoambi> tbasg109PsicoambiData = tbasg109PsicoambiRepository.findByCdgoPsicamb(cdgoPsicamb);

		if (tbasg109PsicoambiData.isPresent()) {
			return toDto(tbasg109PsicoambiData.get());
		}
		return null;
	}

	public Tbasg109PsicoambiDto createTbasg109Psicoambi(Tbasg109PsicoambiDto tbasg109PsicoambiDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg109Psicoambi dbTbasg109Psicoambi = new Tbasg109Psicoambi();
		BeanUtils.copyProperties(dbTbasg109Psicoambi, tbasg109PsicoambiDto);
		Tbasg109Psicoambi _tbasg109Psicoambi = tbasg109PsicoambiRepository.save(dbTbasg109Psicoambi);
		return toDto(_tbasg109Psicoambi);
	}

	public Tbasg109PsicoambiDto updateTbasg109Psicoambi(Integer cdgoPsicamb, Tbasg109PsicoambiDto tbasg109PsicoambiDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg109Psicoambi> tbasg109PsicoambiData = tbasg109PsicoambiRepository.findById(cdgoPsicamb);

		if (tbasg109PsicoambiData.isPresent()) {
			Tbasg109Psicoambi dbTbasg109Psicoambi = tbasg109PsicoambiData.get();
			BeanUtils.copyProperties(dbTbasg109Psicoambi, tbasg109PsicoambiDto);
			return toDto(tbasg109PsicoambiRepository.save(dbTbasg109Psicoambi));
		}
		return null;
	}

	public int deleteTbasg109Psicoambi(Integer cdgoPsicamb) {

		tbasg109PsicoambiRepository.deleteById(cdgoPsicamb);
		return 1;
	}

	public List<Tbasg109PsicoambiDto> findByCdgoPsicambIn(List<Integer> cdgoPsicamb) {

		List<Tbasg109Psicoambi> tbasg109Psicoambis = tbasg109PsicoambiRepository.findByCdgoPsicambIn(cdgoPsicamb);

		return toDtos(tbasg109Psicoambis);
	}

	public List<Tbasg109PsicoambiDto> getPsicoAmbiListCount() {
		return toDtos(tbasg109PsicoambiRepository.getPsicoAmbiListCount());
	}

	public List<Tbasg109PsicoambiDto> getPsicoAmbiListAscendente() {
		return toDtos(tbasg109PsicoambiRepository.getPsicoAmbiListAscendente());
	}

	public List<Tbasg109PsicoambiDto> getPsicoAmbiListDescendente() {
		return toDtos(tbasg109PsicoambiRepository.getPsicoAmbiListDescendente());
	}

	public List<Tbasg109PsicoambiDto> getPsicoAmbiActiveListAscendente() {
		return toDtos(tbasg109PsicoambiRepository.getPsicoAmbiActiveListAscendente());
	}
	
	public List<Tbasg109PsicoambiDto> getPsicoAmbiActiveListAscendente1() {
		return toDtos(tbasg109PsicoambiRepository.getPsicoAmbiActiveListAscendente1());
	}
	
	public List<Tbasg109PsicoambiDto> getPsicoAmbiActiveListAscendente2() {
		return toDtos(tbasg109PsicoambiRepository.getPsicoAmbiActiveListAscendente2());
	}

	public List<Tbasg109PsicoambiDto> getPsicoAmbiActiveListDescendente() {
		return toDtos(tbasg109PsicoambiRepository.getPsicoAmbiActiveListDescendente());
	}

	public List<Tbasg109PsicoambiDto> getPsicoAmbi(Integer cdgoPsicamb) {
		return toDtos(tbasg109PsicoambiRepository.getPsicoAmbi(cdgoPsicamb));
	}

	public int insertPsicoAmbi(Tbasg109Psicoambi bean) {
		return tbasg109PsicoambiRepository.insertPsicoAmbi(bean);
	}

	public int updatePsicoAmbi(Tbasg109Psicoambi bean) {
		return tbasg109PsicoambiRepository.updatePsicoAmbi(bean);
	}
	
	public int estadoPsicoAmbi(Tbasg109Psicoambi bean) {
		return tbasg109PsicoambiRepository.estadoPsicoAmbi(bean);
	}

	public Tbasg109PsicoambiDto toDto(Tbasg109Psicoambi orig) {

		Tbasg109PsicoambiDto dest = new Tbasg109PsicoambiDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg109Psicoambi toEntity(Tbasg109PsicoambiDto orig) {

		Tbasg109Psicoambi dest = new Tbasg109Psicoambi();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg109PsicoambiDto> toDtos(List<Tbasg109Psicoambi> orig) {

		List<Tbasg109PsicoambiDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg109Psicoambi> toEntities(List<Tbasg109PsicoambiDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg109Psicoambi> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
