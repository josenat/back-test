package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg194DocInfrArtActiva;

public interface Tbasg194DocInfrArtActivaRepository
		extends JpaRepository<Tbasg194DocInfrArtActiva, Integer>, Tbasg194DocInfrArtActivaRepositoryCustom {

	// Optional<Tbasg194DocInfrArtActiva> findByCdgoArticulo(Integer cdgoArticulo);
	public Optional<Tbasg194DocInfrArtActiva> findByCdgoArticulo(Integer cdgoArticulo);

	public List<Tbasg194DocInfrArtActiva> findByCdgoArticuloIn(Collection<Integer> cdgoArticulo);
}
