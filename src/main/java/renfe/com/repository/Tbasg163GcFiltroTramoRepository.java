package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg163GcFiltroTramo;

public interface Tbasg163GcFiltroTramoRepository
		extends JpaRepository<Tbasg163GcFiltroTramo, Integer>, Tbasg163GcFiltroTramoRepositoryCustom {

	// Optional<Tbasg163GcFiltroTramo> findByCdgoFiltroTramo(Integer
	// cdgoFiltroTramo);
	public Optional<Tbasg163GcFiltroTramo> findByCdgoFiltroTramo(Integer cdgoFiltroTramo);

	public List<Tbasg163GcFiltroTramo> findByCdgoFiltroTramoIn(Collection<Integer> cdgoFiltroTramo);
}
