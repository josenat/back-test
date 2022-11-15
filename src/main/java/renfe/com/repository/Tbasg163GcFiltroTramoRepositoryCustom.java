package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg163GcFiltroTramo;

public interface Tbasg163GcFiltroTramoRepositoryCustom {

	public List<Tbasg163GcFiltroTramo> getGcFiltrosTramoListActive(String cdgoConsulta);

	public List<Tbasg163GcFiltroTramo> getGcFiltroTramo(String cdgoFiltroTramo);

	public int insertGcFiltroTramo(Tbasg163GcFiltroTramo bean);

	public int deleteGcFiltrosTramo(Tbasg163GcFiltroTramo bean);

}
