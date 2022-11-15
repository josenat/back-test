package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg181BajaLinea;

public interface Tbasg181BajaLineaRepository
		extends JpaRepository<Tbasg181BajaLinea, String>, Tbasg181BajaLineaRepositoryCustom {

	// Optional<Tbasg181BajaLinea> findByCdgoLinea(String cdgoLinea);
	public Optional<Tbasg181BajaLinea> findByCdgoLinea(String cdgoLinea);

	public List<Tbasg181BajaLinea> findByCdgoLineaIn(Collection<String> cdgoLinea);
}
