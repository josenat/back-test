package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg140TidepenciDto;
import renfe.com.model.entity.Tbasg140Tidepenci;

public interface Tbasg140TidepenciService {

	public List<Tbasg140TidepenciDto> getAllTbasg140Tidepenci(Tbasg140TidepenciDto filter);

	public Tbasg140TidepenciDto findByCdgoTipodep(Integer cdgoTipodep);

	public Tbasg140TidepenciDto createTbasg140Tidepenci(Tbasg140TidepenciDto tbasg140TidepenciDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg140TidepenciDto updateTbasg140Tidepenci(Integer cdgoTipodep, Tbasg140TidepenciDto tbasg140TidepenciDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg140Tidepenci(Integer cdgoTipodep);

	public List<Tbasg140TidepenciDto> findByCdgoTipodepIn(List<Integer> cdgoTipodep);

	public List<Tbasg140TidepenciDto> getTiDepenciCount();

	public List<Tbasg140TidepenciDto> getTiDepenciListAscendente();

	public List<Tbasg140TidepenciDto> getTiDepenciListDescendente();

	public List<Tbasg140TidepenciDto> getTiDepenciListActiveAscendente();

	public List<Tbasg140TidepenciDto> getTiDepenciListActiveDescendente();

	public List<Tbasg140TidepenciDto> getTiDepenci(String cdgoTipodep);

	public int insertTiDepenci(Tbasg140Tidepenci bean);

	public int updateTiDepenci(Tbasg140Tidepenci bean);

	public int deleteTiDepenci(Tbasg140Tidepenci bean);

}
