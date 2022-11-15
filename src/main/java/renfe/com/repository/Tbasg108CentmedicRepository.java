package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg108Centmedic;

public interface Tbasg108CentmedicRepository
		extends JpaRepository<Tbasg108Centmedic, Integer>, Tbasg108CentmedicRepositoryCustom {

	// Optional<Tbasg108Centmedic> findByCdgoCenmed(Integer cdgoCenmed);
	public Optional<Tbasg108Centmedic> findByCdgoCenmed(Integer cdgoCenmed);

	public List<Tbasg108Centmedic> findByCdgoCenmedIn(Collection<Integer> cdgoCenmed);
}
