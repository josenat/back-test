package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg132Centcont;

public interface Tbasg132CentcontRepository
		extends JpaRepository<Tbasg132Centcont, String>, Tbasg132CentcontRepositoryCustom {

	// Optional<Tbasg132Centcont> findByCdgoCentcont(String cdgoCentcont);
	public Optional<Tbasg132Centcont> findByCdgoCentcont(String cdgoCentcont);

	public List<Tbasg132Centcont> findByCdgoCentcontIn(Collection<String> cdgoCentcont);
}
