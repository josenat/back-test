package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import renfe.com.model.dto.Tbasg199DatConfADto;
import renfe.com.model.entity.Tbasg199DatConf;
import renfe.com.repository.Tbasg199DatConfRepository;

@Service
public class Tbasg199DatConfServiceImpl implements Tbasg199DatConfService {
	@Autowired
	private Tbasg199DatConfRepository tbasg199DatConfRepository;

	public List<Tbasg199DatConf> SQL_LOAD_VALUES(String nombre){
		return toDtos(tbasg199DatConfRepository.SQL_LOAD_VALUES(nombre));
	}
	
	public Tbasg199DatConf toDto(Tbasg199DatConf origItem) {

		Tbasg199DatConf dest = new Tbasg199DatConf();
		try {
			BeanUtils.copyProperties(dest, origItem);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return dest;
	}
	
	public List<Tbasg199DatConf> toDtos(List<Tbasg199DatConf> list) {

		List<Tbasg199DatConf> dest = new ArrayList<>();
		if (list == null) {
			return dest;
		}
		list.forEach(origItem -> {
			dest.add(this.toDto(origItem));
		});
		return dest;
	}
}

