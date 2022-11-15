package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg160GcConsulta;

public interface Tbasg160GcConsultaRepositoryCustom {

	public List<Tbasg160GcConsulta> getGcConsultasListActive(String desgUsuario);

	public List<Tbasg160GcConsulta> getGcConsulta(String cdgoConsulta);

	public int insertGcConsulta(Tbasg160GcConsulta bean);

	public int updateGcConsulta(Tbasg160GcConsulta bean);

	public int deleteGcConsulta(Tbasg160GcConsulta bean);

}
