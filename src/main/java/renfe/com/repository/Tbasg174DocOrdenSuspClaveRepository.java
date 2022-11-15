package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg174DocOrdenSuspClave;

public interface Tbasg174DocOrdenSuspClaveRepository
		extends JpaRepository<Tbasg174DocOrdenSuspClave, Integer>, Tbasg174DocOrdenSuspClaveRepositoryCustom {

	// Optional<Tbasg174DocOrdenSuspClave> findByCdgoClave(Integer cdgoClave);
	public Optional<Tbasg174DocOrdenSuspClave> findByCdgoClave(Integer cdgoClave);

	public List<Tbasg174DocOrdenSuspClave> findByCdgoClaveIn(Collection<Integer> cdgoClave);
}
