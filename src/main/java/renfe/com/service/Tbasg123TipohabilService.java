package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import renfe.com.model.dto.Tbasg123TipohabilDto;

public interface Tbasg123TipohabilService {

	public List<Tbasg123TipohabilDto> getAllTbasg123Tipohabil(Tbasg123TipohabilDto filter);

	public Tbasg123TipohabilDto findByCdgoTipohab(Integer cdgoTipohab);

	public Tbasg123TipohabilDto createTbasg123Tipohabil(Tbasg123TipohabilDto tbasg123TipohabilDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg123TipohabilDto updateTbasg123Tipohabil(Integer cdgoTipohab, Tbasg123TipohabilDto tbasg123TipohabilDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg123Tipohabil(Integer cdgoTipohab);

	public List<Tbasg123TipohabilDto> findByCdgoTipohabIn(List<Integer> cdgoTipohab);

	public List<Tbasg123TipohabilDto> getTipoHabilList();

	public List<Tbasg123TipohabilDto> getTipoHabilListCombo();

	public List<Tbasg123TipohabilDto> getTipoHabil(String cdgoTipohab);
	
	public List<Tbasg123TipohabilDto> getTipoHabList(Map cdgoTipohab);

}

