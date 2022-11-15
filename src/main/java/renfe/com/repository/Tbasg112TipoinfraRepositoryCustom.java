package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg112Tipoinfra;

public interface Tbasg112TipoinfraRepositoryCustom {

	public List<Tbasg112Tipoinfra> getTipoInfraCount();

	public List<Tbasg112Tipoinfra> getTipoInfraActiveCount();

	public List<Tbasg112Tipoinfra> getTipoInfraListAscendente();

	public List<Tbasg112Tipoinfra> getTipoInfraListDescendente();

	public List<Tbasg112Tipoinfra> getTipoInfraActiveListAscendente();

	public List<Tbasg112Tipoinfra> getTipoInfraActiveListDescendente();

	public List<Tbasg112Tipoinfra> getTipoInfra(String cdgoTipinfr);

	public int insertTipoInfra(Tbasg112Tipoinfra bean);

	public int updateTipoInfra(Tbasg112Tipoinfra bean);
	
	public int estadoTipoInfra(Tbasg112Tipoinfra bean);

}
