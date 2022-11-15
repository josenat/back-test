package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg180RelHabPsicDto;

public interface Tbasg180RelHabPsicService {

	public List<Tbasg180RelHabPsicDto> getAllTbasg180RelHabPsic(Tbasg180RelHabPsicDto filter);

	public Tbasg180RelHabPsicDto findByCdgoPsicambCdgoTipohab(Integer cdgoPsicamb, Integer cdgoTipohab);

	public Tbasg180RelHabPsicDto createTbasg180RelHabPsic(Tbasg180RelHabPsicDto tbasg180RelHabPsicDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg180RelHabPsicDto updateTbasg180RelHabPsic(Integer cdgoPsicamb, Integer cdgoTipohab,
			Tbasg180RelHabPsicDto tbasg180RelHabPsicDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg180RelHabPsic(Integer cdgoPsicamb, Integer cdgoTipohab);

	public List<Tbasg180RelHabPsicDto> findByCdgoPsicambCdgoTipohabIn(List<Integer> cdgoPsicamb,
			List<Integer> cdgoTipohab);

	public List<Tbasg180RelHabPsicDto> getRelHabPsic();

}
