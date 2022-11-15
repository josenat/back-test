package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg114Gradoinci;

public interface Tbasg114GradoinciRepositoryCustom {

	public List<Tbasg114Gradoinci> getGradoInciCount();

	public List<Tbasg114Gradoinci> getGradoInciActiveCount();

	public List<Tbasg114Gradoinci> getGradoInciListAscendente();

	public List<Tbasg114Gradoinci> getGradoInciListDescendente();

	public List<Tbasg114Gradoinci> getGradoInciActiveListAscendente();

	public List<Tbasg114Gradoinci> getGradoInciActiveListDescendente();

	public List<Tbasg114Gradoinci> getGradoInci(String cdgoGrado);

	public int insertGradoInci(Tbasg114Gradoinci bean);

	public int updateGradoInci(Tbasg114Gradoinci bean);
	
	public int estadoGradoInci(Tbasg114Gradoinci bean);

}
