package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg107TipoviaDto;
import renfe.com.model.entity.Tbasg107Tipovia;

public interface Tbasg107TipoviaService {

	public List<Tbasg107TipoviaDto> getAllTbasg107Tipovia(Tbasg107TipoviaDto filter);

	public Tbasg107TipoviaDto findByCdgoTipovia(Integer cdgoTipovia);

	public Tbasg107TipoviaDto createTbasg107Tipovia(Tbasg107TipoviaDto tbasg107TipoviaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg107TipoviaDto updateTbasg107Tipovia(Integer cdgoTipovia, Tbasg107TipoviaDto tbasg107TipoviaDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg107Tipovia(Integer cdgoTipovia);

	public List<Tbasg107TipoviaDto> findByCdgoTipoviaIn(List<Integer> cdgoTipovia);

	public List<Tbasg107TipoviaDto> getTipoVia(String cdgoTipovia);

	public List<Tbasg107TipoviaDto> getTipoViaListAscendente();

	public List<Tbasg107TipoviaDto> getTipoViaListDescendente();

	public List<Tbasg107TipoviaDto> getTipoViaActiveListAscendente();

	public List<Tbasg107TipoviaDto> getTipoViaActiveListDescendente();

	public List<Tbasg107TipoviaDto> getTipoViaCount();

	public int insertTipoVia(Tbasg107Tipovia bean);

	public int updateTipoVia(Tbasg107Tipovia bean);
	
	public int estadoTipoVia(Tbasg107Tipovia bean);

}
