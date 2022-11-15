package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg144Nivacceso;

public interface Tbasg144NivaccesoRepository
		extends JpaRepository<Tbasg144Nivacceso, String>, Tbasg144NivaccesoRepositoryCustom {

	// Optional<Tbasg144Nivacceso> findByCdgoNivel(String cdgoNivel);
	public Optional<Tbasg144Nivacceso> findByCdgoNivel(String cdgoNivel);

	public List<Tbasg144Nivacceso> findByCdgoNivelIn(Collection<String> cdgoNivel);
}
