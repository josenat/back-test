package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg124Ambitos;

public interface Tbasg124AmbitosRepository
		extends JpaRepository<Tbasg124Ambitos, Integer>, Tbasg124AmbitosRepositoryCustom {

	// Optional<Tbasg124Ambitos> findByCdgoAmbitos(Integer cdgoAmbitos);
	public Optional<Tbasg124Ambitos> findByCdgoAmbitos(Integer cdgoAmbitos);

	public List<Tbasg124Ambitos> findByCdgoAmbitosIn(Collection<Integer> cdgoAmbitos);
}
