package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg177DocOrdenActiDatoDto;
import renfe.com.model.entity.Tbasg177DocOrdenActiDato;

public interface Tbasg177DocOrdenActiDatoService {

	public List<Tbasg177DocOrdenActiDatoDto> getAllTbasg177DocOrdenActiDato(Tbasg177DocOrdenActiDatoDto filter);

	public Tbasg177DocOrdenActiDatoDto findByCdgoClaveCdgoReferenciadoc(Integer cdgoClave, Integer cdgoReferenciadoc);

	public Tbasg177DocOrdenActiDatoDto createTbasg177DocOrdenActiDato(
			Tbasg177DocOrdenActiDatoDto tbasg177DocOrdenActiDatoDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg177DocOrdenActiDatoDto updateTbasg177DocOrdenActiDato(Integer cdgoClave, Integer cdgoReferenciadoc,
			Tbasg177DocOrdenActiDatoDto tbasg177DocOrdenActiDatoDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg177DocOrdenActiDato(Integer cdgoClave, Integer cdgoReferenciadoc);

	public List<Tbasg177DocOrdenActiDatoDto> findByCdgoClaveCdgoReferenciadocIn(List<Integer> cdgoClave,
			List<Integer> cdgoReferenciadoc);

	public List<Tbasg177DocOrdenActiDatoDto> getDocOrdenActiDatoActiveList(String cdgoReferenciadoc);

	public List<Tbasg177DocOrdenActiDatoDto> getDocOrdenActiDatoList(String cdgoReferenciadoc);

	public List<Tbasg177DocOrdenActiDatoDto> getDocOrdenActiDato(String cdgoReferenciadoc, String cdgoClave);

	public int insertDocOrdenActiDato(Tbasg177DocOrdenActiDato bean);

	public int updateDocOrdenActiDato(Tbasg177DocOrdenActiDato bean);

}
