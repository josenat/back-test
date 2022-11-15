package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg259Idioma;

public interface Tbasg259IdiomaRepository
		extends JpaRepository<Tbasg259Idioma, String>, Tbasg259IdiomaRepositoryCustom {

	// Optional<Tbasg259Idioma> findByCdgoIdioma(String cdgoIdioma);
	public Optional<Tbasg259Idioma> findByCdgoIdioma(String cdgoIdioma);

	public List<Tbasg259Idioma> findByCdgoIdiomaIn(Collection<String> cdgoIdioma);
}
