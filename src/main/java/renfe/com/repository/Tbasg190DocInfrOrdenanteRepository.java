package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg190DocInfrOrdenante;

public interface Tbasg190DocInfrOrdenanteRepository
		extends JpaRepository<Tbasg190DocInfrOrdenante, Integer>, Tbasg190DocInfrOrdenanteRepositoryCustom {

	// Optional<Tbasg190DocInfrOrdenante> findByCdgoOrdenante(Integer
	// cdgoOrdenante);
	public Optional<Tbasg190DocInfrOrdenante> findByCdgoOrdenante(Integer cdgoOrdenante);

	public List<Tbasg190DocInfrOrdenante> findByCdgoOrdenanteIn(Collection<Integer> cdgoOrdenante);
}
