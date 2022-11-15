package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg176DocOrdenActiClaveDto;

public interface Tbasg176DocOrdenActiClaveService {

	public List<Tbasg176DocOrdenActiClaveDto> getAllTbasg176DocOrdenActiClave(Tbasg176DocOrdenActiClaveDto filter);

	public Tbasg176DocOrdenActiClaveDto findByCdgoClave(Integer cdgoClave);

	public Tbasg176DocOrdenActiClaveDto createTbasg176DocOrdenActiClave(
			Tbasg176DocOrdenActiClaveDto tbasg176DocOrdenActiClaveDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg176DocOrdenActiClaveDto updateTbasg176DocOrdenActiClave(Integer cdgoClave,
			Tbasg176DocOrdenActiClaveDto tbasg176DocOrdenActiClaveDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg176DocOrdenActiClave(Integer cdgoClave);

	public List<Tbasg176DocOrdenActiClaveDto> findByCdgoClaveIn(List<Integer> cdgoClave);

	public List<Tbasg176DocOrdenActiClaveDto> getDocOrdenActiClaveActiveList();

}
