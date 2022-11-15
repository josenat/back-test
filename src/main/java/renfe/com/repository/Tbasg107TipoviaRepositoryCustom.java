package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg107Tipovia;

public interface Tbasg107TipoviaRepositoryCustom {

	public List<Tbasg107Tipovia> getTipoVia(String cdgoTipovia);

	public List<Tbasg107Tipovia> getTipoViaListAscendente();

	public List<Tbasg107Tipovia> getTipoViaListDescendente();

	public List<Tbasg107Tipovia> getTipoViaActiveListAscendente();

	public List<Tbasg107Tipovia> getTipoViaActiveListDescendente();

	public List<Tbasg107Tipovia> getTipoViaCount();

	public int insertTipoVia(Tbasg107Tipovia bean);

	public int updateTipoVia(Tbasg107Tipovia bean);
	
	public int estadoTipoVia(Tbasg107Tipovia bean);

}
