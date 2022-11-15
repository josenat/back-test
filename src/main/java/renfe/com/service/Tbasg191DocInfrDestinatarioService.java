package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg191DocInfrDestinatarioDto;

public interface Tbasg191DocInfrDestinatarioService {

	public List<Tbasg191DocInfrDestinatarioDto> getAllTbasg191DocInfrDestinatario(
			Tbasg191DocInfrDestinatarioDto filter);

	public Tbasg191DocInfrDestinatarioDto findByCdgoDestinatario(Integer cdgoDestinatario);

	public Tbasg191DocInfrDestinatarioDto createTbasg191DocInfrDestinatario(
			Tbasg191DocInfrDestinatarioDto tbasg191DocInfrDestinatarioDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg191DocInfrDestinatarioDto updateTbasg191DocInfrDestinatario(Integer cdgoDestinatario,
			Tbasg191DocInfrDestinatarioDto tbasg191DocInfrDestinatarioDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg191DocInfrDestinatario(Integer cdgoDestinatario);

	public List<Tbasg191DocInfrDestinatarioDto> findByCdgoDestinatarioIn(List<Integer> cdgoDestinatario);

	public List<Tbasg191DocInfrDestinatarioDto> getDocInfrDestinatarioList();

	public List<Tbasg191DocInfrDestinatarioDto> getDocInfrDestinatarioByCdgoDestinatario(String cdgoDestinatario);

}
