package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg193DocInfrArtSuspen;

public interface Tbasg193DocInfrArtSuspenRepositoryCustom {

	public List<Tbasg193DocInfrArtSuspen> getDocInfrArtSuspenList();

	public List<Tbasg193DocInfrArtSuspen> getDocInfrArtSuspenByCdgoArticulo(String cdgoArticulo);

}
