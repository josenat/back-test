package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg175DocOrdenSuspDatoDto;
import renfe.com.model.entity.Tbasg175DocOrdenSuspDato;

public interface Tbasg175DocOrdenSuspDatoService {

	public List<Tbasg175DocOrdenSuspDatoDto> getAllTbasg175DocOrdenSuspDato(Tbasg175DocOrdenSuspDatoDto filter);

	public Tbasg175DocOrdenSuspDatoDto findByCdgoClaveCdgoReferenciadoc(Integer cdgoClave, Integer cdgoReferenciadoc);

	public Tbasg175DocOrdenSuspDatoDto createTbasg175DocOrdenSuspDato(
			Tbasg175DocOrdenSuspDatoDto tbasg175DocOrdenSuspDatoDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg175DocOrdenSuspDatoDto updateTbasg175DocOrdenSuspDato(Integer cdgoClave, Integer cdgoReferenciadoc,
			Tbasg175DocOrdenSuspDatoDto tbasg175DocOrdenSuspDatoDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg175DocOrdenSuspDato(Integer cdgoClave, Integer cdgoReferenciadoc);

	public List<Tbasg175DocOrdenSuspDatoDto> findByCdgoClaveCdgoReferenciadocIn(List<Integer> cdgoClave,
			List<Integer> cdgoReferenciadoc);

	public List<Tbasg175DocOrdenSuspDatoDto> getDocOrdenSuspDatoActiveList(String cdgoReferenciadoc);

	public List<Tbasg175DocOrdenSuspDatoDto> getDocOrdenSuspDatoList(String cdgoReferenciadoc);

	public List<Tbasg175DocOrdenSuspDatoDto> getDocOrdenSuspDato(String cdgoReferenciadoc, String cdgoClave);

	public int insertDocOrdenSuspDato(Tbasg175DocOrdenSuspDato bean);

	public int updateDocOrdenSuspDato(Tbasg175DocOrdenSuspDato bean);

}
