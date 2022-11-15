package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg174DocOrdenSuspClaveDto;

public interface Tbasg174DocOrdenSuspClaveService {

	public List<Tbasg174DocOrdenSuspClaveDto> getAllTbasg174DocOrdenSuspClave(Tbasg174DocOrdenSuspClaveDto filter);

	public Tbasg174DocOrdenSuspClaveDto findByCdgoClave(Integer cdgoClave);

	public Tbasg174DocOrdenSuspClaveDto createTbasg174DocOrdenSuspClave(
			Tbasg174DocOrdenSuspClaveDto tbasg174DocOrdenSuspClaveDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg174DocOrdenSuspClaveDto updateTbasg174DocOrdenSuspClave(Integer cdgoClave,
			Tbasg174DocOrdenSuspClaveDto tbasg174DocOrdenSuspClaveDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg174DocOrdenSuspClave(Integer cdgoClave);

	public List<Tbasg174DocOrdenSuspClaveDto> findByCdgoClaveIn(List<Integer> cdgoClave);

	public List<Tbasg174DocOrdenSuspClaveDto> getDocOrdenSuspClaveActiveList();

}
