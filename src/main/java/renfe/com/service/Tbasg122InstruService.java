package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg122InstruDto;
import renfe.com.model.entity.Tbasg122Instru;

public interface Tbasg122InstruService {

	public List<Tbasg122InstruDto> getAllTbasg122Instru(Tbasg122InstruDto filter);

	public Tbasg122InstruDto findByCdgoNif(String cdgoNif);

	public Tbasg122InstruDto createTbasg122Instru(Tbasg122InstruDto tbasg122InstruDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg122InstruDto updateTbasg122Instru(String cdgoNif, Tbasg122InstruDto tbasg122InstruDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg122Instru(String cdgoNif);

	public List<Tbasg122InstruDto> findByCdgoNifIn(List<String> cdgoNif);

	public List<Tbasg122InstruDto> getIntruForName(String desgApell1);

	public List<Tbasg122InstruDto> getInstru(String cdgoNif);

	public List<Tbasg122InstruDto> getInstruListRegistroAscendente();

	public List<Tbasg122InstruDto> getInstruListRegistroDescendente();

	public List<Tbasg122InstruDto> getInstruListAscendenteDESG_APELL1();
	
	public List<Tbasg122InstruDto> getInstruListAscendente();

	public List<Tbasg122InstruDto> getInstruListDescendenteDESG_APELL1();

	public List<Tbasg122InstruDto> getInstruListAscendenteCDGO_NIF();

	public List<Tbasg122InstruDto> getInstruListDescendenteCDGO_NIF();

	public List<Tbasg122InstruDto> getInstruActiveListAscendenteDESG_APELL1();

	public List<Tbasg122InstruDto> getInstruActiveListDescendenteDESG_APELL1();

	public List<Tbasg122InstruDto> getInstruActiveListAscendenteCDGO_NIF();

	public List<Tbasg122InstruDto> getInstruActiveListDescendenteCDGO_NIF();

	public List<Tbasg122InstruDto> getInstruCount();

	public List<Tbasg122InstruDto> getInstruActiveListNombre();

	public List<Tbasg122InstruDto> getInstruActiveListApe1Ape2Nom();
	
	public List<Tbasg122InstruDto> getExamiActiveListApe1Ape2Nom();

	public List<Tbasg122InstruDto> getInstruActiveListMrcaInstru();

	public List<Tbasg122InstruDto> getExaminActiveListMrcaExamin();

	public List<Tbasg122InstruDto> existeInstruDNI(String cdgoNif);

	public int insertInstru(Tbasg122Instru bean);

	public int updateInstru(Tbasg122Instru bean);
	
	public int estadoInstru(Tbasg122Instru bean);

	public int unDeleteInstru(Tbasg122Instru bean);
	
	public Tbasg122InstruDto entityToDto(Tbasg122Instru entity);

	public List<Tbasg122InstruDto> getTrainerExaminerStatus(String cdgoNif);

}
