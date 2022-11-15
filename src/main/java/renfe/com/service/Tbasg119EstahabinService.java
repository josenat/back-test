package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg119EstahabinDto;
import renfe.com.model.entity.Tbasg119Estahabin;

public interface Tbasg119EstahabinService {

	public List<Tbasg119EstahabinDto> getAllTbasg119Estahabin(Tbasg119EstahabinDto filter);

	public Tbasg119EstahabinDto findByCdgoAlchabinfCdgoEstadoFchaEstado(Integer cdgoAlchabinf, Integer cdgoEstado,
			String fchaEstado);

	public Tbasg119EstahabinDto createTbasg119Estahabin(Tbasg119EstahabinDto tbasg119EstahabinDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg119EstahabinDto updateTbasg119Estahabin(Integer cdgoAlchabinf, Integer cdgoEstado, String fchaEstado,
			Tbasg119EstahabinDto tbasg119EstahabinDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg119Estahabin(Integer cdgoAlchabinf, Integer cdgoEstado, String fchaEstado);

	public List<Tbasg119EstahabinDto> findByCdgoAlchabinfCdgoEstadoFchaEstadoIn(List<Integer> cdgoAlchabinf,
			List<Integer> cdgoEstado, List<String> fchaEstado);

	public List<Tbasg119EstahabinDto> findEstaHabInByCdgoAlc(String cdgoAlchabinf);

	public int insertEstaHabIn(Integer cdgoAlchabinf, Integer cdgoEstado, String desgUsuact, String mrcaActivo);

}
