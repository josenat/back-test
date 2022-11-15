package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg143Centhgado;

public interface Tbasg143CenthgadoRepository
		extends JpaRepository<Tbasg143Centhgado, Integer>, Tbasg143CenthgadoRepositoryCustom {

	// Optional<Tbasg143Centhgado> findByCdgoCenthgado(Integer cdgoCenthgado);
	public Optional<Tbasg143Centhgado> findByCdgoCenthgado(Integer cdgoCenthgado);

	public List<Tbasg143Centhgado> findByCdgoCenthgadoIn(Collection<Integer> cdgoCenthgado);
}
