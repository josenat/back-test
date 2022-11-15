package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg136Estudio;

public interface Tbasg136EstudioRepository
		extends JpaRepository<Tbasg136Estudio, Integer>, Tbasg136EstudioRepositoryCustom {

	// Optional<Tbasg136Estudio> findByCdgoEstudio(Integer cdgoEstudio);
	public Optional<Tbasg136Estudio> findByCdgoEstudio(Integer cdgoEstudio);

	public List<Tbasg136Estudio> findByCdgoEstudioIn(Collection<Integer> cdgoEstudio);
}
