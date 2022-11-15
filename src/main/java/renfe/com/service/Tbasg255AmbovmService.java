package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg255AmbovmDto;
import renfe.com.model.entity.Tbasg255Ambovm;

public interface Tbasg255AmbovmService {

	public List<Tbasg255AmbovmDto> getAllTbasg255Ambovm(Tbasg255AmbovmDto filter);

	public Tbasg255AmbovmDto findByCdgoAmbovm(Integer cdgoAmbovm);

	public Tbasg255AmbovmDto createTbasg255Ambovm(Tbasg255AmbovmDto tbasg255AmbovmDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg255AmbovmDto updateTbasg255Ambovm(Integer cdgoAmbovm, Tbasg255AmbovmDto tbasg255AmbovmDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg255Ambovm(Integer cdgoAmbovm);

	public List<Tbasg255AmbovmDto> findByCdgoAmbovmIn(List<Integer> cdgoAmbovm);

	public List<Tbasg255AmbovmDto> getAmbitosOVMCount();

	public List<Tbasg255AmbovmDto> getAmbitosOVMListAscendente();

	public List<Tbasg255AmbovmDto> getAmbitosOVMListDescendente();

	public List<Tbasg255AmbovmDto> getAmbitosOVMActiveList();

	public List<Tbasg255AmbovmDto> getAmbitosOVM(String cdgoAmbovm);

	public int insertAmbitosOVM(Tbasg255Ambovm bean);

	public int updateAmbitosOVM(Tbasg255Ambovm bean);

	public int deleteAmbitosOVM(Tbasg255Ambovm bean);

}
