package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg176DocOrdenActiClave;

public interface Tbasg176DocOrdenActiClaveRepository
		extends JpaRepository<Tbasg176DocOrdenActiClave, Integer>, Tbasg176DocOrdenActiClaveRepositoryCustom {

	// Optional<Tbasg176DocOrdenActiClave> findByCdgoClave(Integer cdgoClave);
	public Optional<Tbasg176DocOrdenActiClave> findByCdgoClave(Integer cdgoClave);

	public List<Tbasg176DocOrdenActiClave> findByCdgoClaveIn(Collection<Integer> cdgoClave);
}
