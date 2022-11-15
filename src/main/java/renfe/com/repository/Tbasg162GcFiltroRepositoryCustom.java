package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg162GcFiltro;

public interface Tbasg162GcFiltroRepositoryCustom {

	public List<Tbasg162GcFiltro> getGcFiltrosListActive(String cdgoConsulta);

	public List<Tbasg162GcFiltro> getGcFiltrosList(String cdgoConsulta);

	public List<Tbasg162GcFiltro> getGcFiltro(String cdgoFiltro);

	public int insertGcFiltro(Tbasg162GcFiltro bean);

	public int updateGcFiltro(Tbasg162GcFiltro bean);

	public int deleteGcFiltroLogico(Tbasg162GcFiltro bean);

	public int deleteGcFiltrosConsulta(Tbasg162GcFiltro bean);

}
