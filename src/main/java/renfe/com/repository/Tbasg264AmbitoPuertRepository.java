package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg264AmbitoPuert;

public interface Tbasg264AmbitoPuertRepository
		extends JpaRepository<Tbasg264AmbitoPuert, String>, Tbasg264AmbitoPuertRepositoryCustom {

	// Optional<Tbasg264AmbitoPuert> findByCdgoPuerto(String cdgoPuerto);
	public Optional<Tbasg264AmbitoPuert> findByCdgoPuerto(String cdgoPuerto);

	public List<Tbasg264AmbitoPuert> findByCdgoPuertoIn(Collection<String> cdgoPuerto);
}
