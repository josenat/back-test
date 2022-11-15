package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg135Cargo;

public interface Tbasg135CargoRepository extends JpaRepository<Tbasg135Cargo, String>, Tbasg135CargoRepositoryCustom {

	// Optional<Tbasg135Cargo> findByCdgoCargo(String cdgoCargo);
	public Optional<Tbasg135Cargo> findByCdgoCargo(String cdgoCargo);

	public List<Tbasg135Cargo> findByCdgoCargoIn(Collection<String> cdgoCargo);

}
