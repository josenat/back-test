package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg133Serie;

public interface Tbasg133SerieRepository extends JpaRepository<Tbasg133Serie, String>, Tbasg133SerieRepositoryCustom {

	// Optional<Tbasg133Serie> findByCdgoSerie(String cdgoSerie);
	public Optional<Tbasg133Serie> findByCdgoSerie(String cdgoSerie);

	public List<Tbasg133Serie> findByCdgoSerieIn(Collection<String> cdgoSerie);
}
