package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg120Centforma;

public interface Tbasg120CentformaRepository
		extends JpaRepository<Tbasg120Centforma, Integer>, Tbasg120CentformaRepositoryCustom {

	// Optional<Tbasg120Centforma> findByCdgoCentrofor(Integer cdgoCentrofor);
	public Optional<Tbasg120Centforma> findByCdgoCentrofor(Integer cdgoCentrofor);

	public List<Tbasg120Centforma> findByCdgoCentroforIn(Collection<Integer> cdgoCentrofor);
}
