package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg137Especiali;

public interface Tbasg137EspecialiRepository
		extends JpaRepository<Tbasg137Especiali, Integer>, Tbasg137EspecialiRepositoryCustom {

	// Optional<Tbasg137Especiali> findByCdgoEspec(Integer cdgoEspec);
	public Optional<Tbasg137Especiali> findByCdgoEspec(Integer cdgoEspec);

	public List<Tbasg137Especiali> findByCdgoEspecIn(Collection<Integer> cdgoEspec);
}
