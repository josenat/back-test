package renfe.com.repository;

import java.util.List;

import renfe.com.model.dto.Tbasg122InstruDto;
import renfe.com.model.entity.Tbasg122Instru;

public interface Tbasg122InstruRepositoryCustom {

	public List<Tbasg122InstruDto> getIntruForName(String desgApell1);

	public List<Tbasg122Instru> getInstru(String cdgoNif);

	public List<Tbasg122Instru> getInstruListRegistroAscendente();

	public List<Tbasg122Instru> getInstruListRegistroDescendente();

	public List<Tbasg122Instru> getInstruListAscendenteDESG_APELL1();
	
	public List<Tbasg122Instru> getInstruListAscendente();

	public List<Tbasg122Instru> getInstruListDescendenteDESG_APELL1();

	public List<Tbasg122Instru> getInstruListAscendenteCDGO_NIF();

	public List<Tbasg122Instru> getInstruListDescendenteCDGO_NIF();

	public List<Tbasg122Instru> getInstruActiveListAscendenteDESG_APELL1();

	public List<Tbasg122Instru> getInstruActiveListDescendenteDESG_APELL1();

	public List<Tbasg122Instru> getInstruActiveListAscendenteCDGO_NIF();

	public List<Tbasg122Instru> getInstruActiveListDescendenteCDGO_NIF();

	public List<Tbasg122Instru> getInstruCount();

	public List<Tbasg122Instru> getInstruActiveListNombre();

	public List<Tbasg122Instru> getInstruActiveListApe1Ape2Nom();
	
	public List<Tbasg122Instru> getExamiActiveListApe1Ape2Nom();

	public List<Tbasg122Instru> getInstruActiveListMrcaInstru();

	public List<Tbasg122Instru> getExaminActiveListMrcaExamin();

	public List<Tbasg122Instru> existeInstruDNI(String cdgoNif);

	public int insertInstru(Tbasg122Instru bean);

	public int updateInstru(Tbasg122Instru bean);
	
	public int estadoInstru(Tbasg122Instru bean);

	public int unDeleteInstru(Tbasg122Instru bean);

	public List<Tbasg122InstruDto> getTrainerExaminerStatus(String cdgoNif);

}
