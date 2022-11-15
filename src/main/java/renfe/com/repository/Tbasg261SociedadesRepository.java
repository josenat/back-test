package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg261Sociedades;

public interface Tbasg261SociedadesRepository
		extends JpaRepository<Tbasg261Sociedades, String>, Tbasg261SociedadesRepositoryCustom {

	// Optional<Tbasg261Sociedades> findByCdgoSociedad(String cdgoSociedad);
	public Optional<Tbasg261Sociedades> findByCdgoSociedad(String cdgoSociedad);

	public List<Tbasg261Sociedades> findByCdgoSociedadIn(Collection<String> cdgoSociedad);
}
