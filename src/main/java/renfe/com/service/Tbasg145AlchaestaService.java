package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg145AlchaestaDto;
import renfe.com.model.entity.Tbasg145Alchaesta;

public interface Tbasg145AlchaestaService {

	public List<Tbasg145AlchaestaDto> getAllTbasg145Alchaesta(Tbasg145AlchaestaDto filter);

	public Tbasg145AlchaestaDto findByCdgoAlchabinfCdgoDestinoCdgoLineaCdgoOrigen(Integer cdgoAlchabinf,
			String cdgoDestino, String cdgoLinea, String cdgoOrigen);

	public Tbasg145AlchaestaDto createTbasg145Alchaesta(Tbasg145AlchaestaDto tbasg145AlchaestaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg145AlchaestaDto updateTbasg145Alchaesta(Integer cdgoAlchabinf, String cdgoDestino, String cdgoLinea,
			String cdgoOrigen, Tbasg145AlchaestaDto tbasg145AlchaestaDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg145Alchaesta(Integer cdgoAlchabinf, String cdgoDestino, String cdgoLinea, String cdgoOrigen);

	public List<Tbasg145AlchaestaDto> findByCdgoAlchabinfCdgoDestinoCdgoLineaCdgoOrigenIn(List<Integer> cdgoAlchabinf,
			List<String> cdgoDestino, List<String> cdgoLinea, List<String> cdgoOrigen);

	public List<Tbasg145AlchaestaDto> getAlcHaEstaCount(/** FIXME revisar tipo */
	Object cdgoEntorno);

	public List<Tbasg145AlchaestaDto> getAlcHaEsta(String cdgoAlchabinf, String cdgoLinea, String cdgoOrigen,
			String cdgoDestino);

	public int insertAlcHaEsta(Tbasg145AlchaestaDto bean);

	public int deleteAlcHaEsta(Tbasg145Alchaesta bean);

	public int deleteAlcHaEstaByAlchabinf(Tbasg145Alchaesta bean);

}
