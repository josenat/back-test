package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg161GcResultado;

public interface Tbasg161GcResultadoRepositoryCustom {

	public List<Tbasg161GcResultado> getGcResultadosListActive(String cdgoConsulta);

	public List<Tbasg161GcResultado> getGcResultado(String cdgoConsulta, String cdgoCategoria, String cdgoConcepto);

	public int insertGcResultado(Tbasg161GcResultado bean);

	public int updateGcResultado(Tbasg161GcResultado bean);

	public int deleteGcResultadosConsulta(Tbasg161GcResultado bean);

}
