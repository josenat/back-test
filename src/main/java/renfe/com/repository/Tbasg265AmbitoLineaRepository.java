package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg265AmbitoLinea;

public interface Tbasg265AmbitoLineaRepository
		extends JpaRepository<Tbasg265AmbitoLinea, String>, Tbasg265AmbitoLineaRepositoryCustom {

	// Optional<Tbasg265AmbitoLinea> findByCdgoLinea(String cdgoLinea);
	public Optional<Tbasg265AmbitoLinea> findByCdgoLinea(String cdgoLinea);

	public List<Tbasg265AmbitoLinea> findByCdgoLineaIn(Collection<String> cdgoLinea);
}
