package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg141Areter;

public interface Tbasg141AreterRepository
		extends JpaRepository<Tbasg141Areter, Integer>, Tbasg141AreterRepositoryCustom {

	// Optional<Tbasg141Areter> findByCdgoAreter(Integer cdgoAreter);
	public Optional<Tbasg141Areter> findByCdgoAreter(Integer cdgoAreter);

	public List<Tbasg141Areter> findByCdgoAreterIn(Collection<Integer> cdgoAreter);
}
