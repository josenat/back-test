package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg256Alcovm;

public interface Tbasg256AlcovmRepositoryCustom {

	public List<Tbasg256Alcovm> getAlcancesOVMCount();

	public List<Tbasg256Alcovm> getAlcancesOVMListAscendente();

	public List<Tbasg256Alcovm> getAlcancesOVMListDescendente();

	public List<Tbasg256Alcovm> getAlcancesOVMActiveList();

	public List<Tbasg256Alcovm> getAlcancesOVM(String cdgoAlcovm);

	public int insertAlcancesOVM(Tbasg256Alcovm bean);

	public int updateAlcancesOVM(Tbasg256Alcovm bean);

	public int deleteAlcancesOVM(Tbasg256Alcovm bean);

}
