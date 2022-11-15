package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg194DocInfrArtActiva;

public interface Tbasg194DocInfrArtActivaRepositoryCustom {

	public List<Tbasg194DocInfrArtActiva> getDocInfrArtActivaList();

	public List<Tbasg194DocInfrArtActiva> getDocInfrArtActivaByCdgoArticulo(String cdgoArticulo);

}
