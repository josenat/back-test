package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg106Provincia;

public interface Tbasg106ProvinciaRepository
		extends JpaRepository<Tbasg106Provincia, Integer>, Tbasg106ProvinciaRepositoryCustom {

	// Optional<Tbasg106Provincia> findByCdgoProvincia(Integer cdgoProvincia);
	public Optional<Tbasg106Provincia> findByCdgoProvincia(Integer cdgoProvincia);

	public List<Tbasg106Provincia> findByCdgoProvinciaIn(Collection<Integer> cdgoProvincia);
}
