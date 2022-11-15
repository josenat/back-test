package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg256AlcovmDto;
import renfe.com.model.entity.Tbasg256Alcovm;

public interface Tbasg256AlcovmService {

	public List<Tbasg256AlcovmDto> getAllTbasg256Alcovm(Tbasg256AlcovmDto filter);

	public Tbasg256AlcovmDto findByCdgoAlcovm(Integer cdgoAlcovm);

	public Tbasg256AlcovmDto createTbasg256Alcovm(Tbasg256AlcovmDto tbasg256AlcovmDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg256AlcovmDto updateTbasg256Alcovm(Integer cdgoAlcovm, Tbasg256AlcovmDto tbasg256AlcovmDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg256Alcovm(Integer cdgoAlcovm);

	public List<Tbasg256AlcovmDto> findByCdgoAlcovmIn(List<Integer> cdgoAlcovm);

	public List<Tbasg256AlcovmDto> getAlcancesOVMCount();

	public List<Tbasg256AlcovmDto> getAlcancesOVMListAscendente();

	public List<Tbasg256AlcovmDto> getAlcancesOVMListDescendente();

	public List<Tbasg256AlcovmDto> getAlcancesOVMActiveList();

	public List<Tbasg256AlcovmDto> getAlcancesOVM(String cdgoAlcovm);

	public int insertAlcancesOVM(Tbasg256Alcovm bean);

	public int updateAlcancesOVM(Tbasg256Alcovm bean);

	public int deleteAlcancesOVM(Tbasg256Alcovm bean);

}

