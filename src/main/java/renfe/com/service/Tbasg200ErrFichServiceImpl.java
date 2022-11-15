package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import renfe.com.dto.GetErrListParam;
import renfe.com.model.dto.Tbasg200ErrFichDto;
import renfe.com.model.dto.Tbasg202ErrActivDto;
import renfe.com.model.dto.Tbasg203ErrInactDto;
import renfe.com.model.entity.Tbasg200ErrFich;
import renfe.com.model.entity.Tbasg202ErrActiv;
import renfe.com.model.entity.Tbasg203ErrInact;
import renfe.com.repository.Tbasg200ErrFichRepository;
import renfe.com.repository.Tbasg202ErrActivRepository;

@Transactional
@Service
public class Tbasg200ErrFichServiceImpl implements Tbasg200ErrFichService {

	@Autowired
	protected Logger logger;
	
	@Autowired
	private Tbasg200ErrFichRepository tbasg200ErrFichRepository;
	
	public Tbasg200ErrFichDto toDto(Tbasg200ErrFich orig) {

		Tbasg200ErrFichDto dest = new Tbasg200ErrFichDto();
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}
	
	public List<Tbasg200ErrFichDto> toDtos(List<Tbasg200ErrFich> orig) {

		List<Tbasg200ErrFichDto> dest = new ArrayList<>();
		if (orig == null) {
			return dest;
		}
		orig.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}

	@Override
	public List<Tbasg200ErrFichDto> getErrFichList(GetErrListParam filter) {
		
		return toDtos(tbasg200ErrFichRepository.getErrFichList(filter));
	}

	@Override
	public List<Tbasg200ErrFichDto> getErrFich(Integer cdgoError) {
		return toDtos(tbasg200ErrFichRepository.getErrFich(cdgoError));
	}

}
