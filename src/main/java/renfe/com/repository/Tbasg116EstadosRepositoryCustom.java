package renfe.com.repository;

import java.util.List;

import renfe.com.model.dto.Tbasg116EstadosDto;
import renfe.com.model.entity.Tbasg116Estados;

public interface Tbasg116EstadosRepositoryCustom {

	public List<Tbasg116Estados> getEstadosList();
	public List<Tbasg116Estados> getEstadosHabilitacionListActive();

	public List<Tbasg116Estados> getEstadosConduccionListActive();
	public List<Tbasg116Estados> getEstadosListActive();

	public List<Tbasg116Estados> getActiveStatusListForDriving();
	public List<Tbasg116Estados> getEstado(Integer cdgoEstado);

}
