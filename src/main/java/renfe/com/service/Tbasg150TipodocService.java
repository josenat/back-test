package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg150TipodocDto;

public interface Tbasg150TipodocService {

	public List<Tbasg150TipodocDto> getAllTbasg150Tipodoc(Tbasg150TipodocDto filter);

	public Tbasg150TipodocDto findByCdgoTipodoc(Integer cdgoTipodoc);

	public Tbasg150TipodocDto createTbasg150Tipodoc(Tbasg150TipodocDto tbasg150TipodocDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg150TipodocDto updateTbasg150Tipodoc(Integer cdgoTipodoc, Tbasg150TipodocDto tbasg150TipodocDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg150Tipodoc(Integer cdgoTipodoc);

	public List<Tbasg150TipodocDto> findByCdgoTipodocIn(List<Integer> cdgoTipodoc);

	public List<Tbasg150TipodocDto> getDescTipoDocumento(String cdgoTipodoc);

	public List<Tbasg150TipodocDto> getTipoDocListByCodigo();

	public List<Tbasg150TipodocDto> getTipoDocCount();

}
