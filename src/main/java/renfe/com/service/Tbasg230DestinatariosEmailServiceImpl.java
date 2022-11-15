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

import renfe.com.model.dto.Tbasg230DestinatariosEmailDto;
import renfe.com.model.entity.Tbasg230DestinatariosEmail;
import renfe.com.repository.Tbasg230DestinatariosEmailRepository;

@Transactional
@Service
public class Tbasg230DestinatariosEmailServiceImpl implements Tbasg230DestinatariosEmailService {

	@Autowired
	protected Logger logger;

	@Autowired
	private Tbasg230DestinatariosEmailRepository tbasg230DestinatariosEmailRepository;

	public List<Tbasg230DestinatariosEmailDto> getAllTbasg230DestinatariosEmail(Tbasg230DestinatariosEmailDto filter) {

		logger.info("getAllTbasg230DestinatariosEmail " + filter);
		if (filter == null) {
			return this.toDtos(tbasg230DestinatariosEmailRepository.findAll());
		}
		return this.toDtos(tbasg230DestinatariosEmailRepository.findAll(Example.of(toEntity(filter))));
	}

	public Tbasg230DestinatariosEmailDto findByDesgDireccionEmail(String desgDireccionEmail) {

		Optional<Tbasg230DestinatariosEmail> tbasg230DestinatariosEmailData = tbasg230DestinatariosEmailRepository
				.findByDesgDireccionEmail(desgDireccionEmail);

		if (tbasg230DestinatariosEmailData.isPresent()) {
			return toDto(tbasg230DestinatariosEmailData.get());
		}
		return null;
	}

	public Tbasg230DestinatariosEmailDto createTbasg230DestinatariosEmail(
			Tbasg230DestinatariosEmailDto tbasg230DestinatariosEmailDto)
			throws IllegalAccessException, InvocationTargetException {

		Tbasg230DestinatariosEmail dbTbasg230DestinatariosEmail = new Tbasg230DestinatariosEmail();
		BeanUtils.copyProperties(dbTbasg230DestinatariosEmail, tbasg230DestinatariosEmailDto);
		Tbasg230DestinatariosEmail _tbasg230DestinatariosEmail = tbasg230DestinatariosEmailRepository
				.save(dbTbasg230DestinatariosEmail);
		return toDto(_tbasg230DestinatariosEmail);
	}

	public Tbasg230DestinatariosEmailDto updateTbasg230DestinatariosEmail(String desgDireccionEmail,
			Tbasg230DestinatariosEmailDto tbasg230DestinatariosEmailDto)
			throws IllegalAccessException, InvocationTargetException {

		Optional<Tbasg230DestinatariosEmail> tbasg230DestinatariosEmailData = tbasg230DestinatariosEmailRepository
				.findById(desgDireccionEmail);

		if (tbasg230DestinatariosEmailData.isPresent()) {
			Tbasg230DestinatariosEmail dbTbasg230DestinatariosEmail = tbasg230DestinatariosEmailData.get();
			BeanUtils.copyProperties(dbTbasg230DestinatariosEmail, tbasg230DestinatariosEmailDto);
			return toDto(tbasg230DestinatariosEmailRepository.save(dbTbasg230DestinatariosEmail));
		}
		return null;
	}

	public int deleteTbasg230DestinatariosEmail(String desgDireccionEmail) {

		tbasg230DestinatariosEmailRepository.deleteById(desgDireccionEmail);
		return 1;
	}

	public List<Tbasg230DestinatariosEmailDto> findByDesgDireccionEmailIn(List<String> desgDireccionEmail) {

		List<Tbasg230DestinatariosEmail> tbasg230DestinatariosEmails = tbasg230DestinatariosEmailRepository
				.findByDesgDireccionEmailIn(desgDireccionEmail);

		return toDtos(tbasg230DestinatariosEmails);
	}

	public List<Tbasg230DestinatariosEmailDto> getDestinatariosEmailCount() {
		return toDtos(tbasg230DestinatariosEmailRepository.getDestinatariosEmailCount());
	}

	public List<Tbasg230DestinatariosEmailDto> getDestinatarioDireccionCount(String desgDireccionEmail) {
		return toDtos(tbasg230DestinatariosEmailRepository.getDestinatarioDireccionCount(desgDireccionEmail));
	}

	public List<Tbasg230DestinatariosEmailDto> getDestinatariosEmailListAscendente() {
		return toDtos(tbasg230DestinatariosEmailRepository.getDestinatariosEmailListAscendente());
	}

	public List<Tbasg230DestinatariosEmailDto> getDestinatariosEmailListDescendente() {
		return toDtos(tbasg230DestinatariosEmailRepository.getDestinatariosEmailListDescendente());
	}

	public List<Tbasg230DestinatariosEmailDto> getDestinatariosEmailListActiveAscendente() {
		return toDtos(tbasg230DestinatariosEmailRepository.getDestinatariosEmailListActiveAscendente());
	}

	public List<Tbasg230DestinatariosEmailDto> getDestinatariosEmailListActiveDescendente() {
		return toDtos(tbasg230DestinatariosEmailRepository.getDestinatariosEmailListActiveDescendente());
	}

	public List<Tbasg230DestinatariosEmailDto> getDestinatariosEmail(String desgDireccionEmail) {
		return toDtos(tbasg230DestinatariosEmailRepository.getDestinatariosEmail(desgDireccionEmail));
	}

	public int insertDestinatariosEmail(Tbasg230DestinatariosEmail bean) {
		return tbasg230DestinatariosEmailRepository.insertDestinatariosEmail(bean);
	}

	public int updateDestinatarioEmail(Tbasg230DestinatariosEmail bean) {
		return tbasg230DestinatariosEmailRepository.updateDestinatarioEmail(bean);
	}
	
	public int estadoDestinatarioEmail(Tbasg230DestinatariosEmail bean) {
		return tbasg230DestinatariosEmailRepository.estadoDestinatarioEmail(bean);
	}

	public int updateDestinatarioEmailAreaNull(Tbasg230DestinatariosEmail bean) {
		return tbasg230DestinatariosEmailRepository.updateDestinatarioEmailAreaNull(bean);
	}

	public Tbasg230DestinatariosEmailDto toDto(Tbasg230DestinatariosEmail orig) {

		Tbasg230DestinatariosEmailDto dest = new Tbasg230DestinatariosEmailDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public Tbasg230DestinatariosEmail toEntity(Tbasg230DestinatariosEmailDto orig) {

		Tbasg230DestinatariosEmail dest = new Tbasg230DestinatariosEmail();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}

	public List<Tbasg230DestinatariosEmailDto> toDtos(List<Tbasg230DestinatariosEmail> orig) {

		List<Tbasg230DestinatariosEmailDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	public List<Tbasg230DestinatariosEmail> toEntities(List<Tbasg230DestinatariosEmailDto> orig)
			throws IllegalAccessException, InvocationTargetException {

		List<Tbasg230DestinatariosEmail> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toEntity(origItem));
		});
		return dest;
	}
}
