package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg266EstadoAcre;

public interface Tbasg266EstadoAcreRepositoryCustom {

	public int insertEstadoAcreditacion(Tbasg266EstadoAcre bean);

	public int updateEstadoAcreditacion(Tbasg266EstadoAcre bean);

	public List<Tbasg266EstadoAcre> getEstadosAcreditaMaxFecha();

	public List<Tbasg266EstadoAcre> getEstadosAcreditaTodosMaxFecha();

	public int insertEstadoAcre(Tbasg266EstadoAcre bean);

	public int updateEstadoAcreditacionMantenimiento(Tbasg266EstadoAcre bean);

}
