package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg256Alcovm;

public interface Tbasg256AlcovmRepository
		extends JpaRepository<Tbasg256Alcovm, Integer>, Tbasg256AlcovmRepositoryCustom {

	// Optional<Tbasg256Alcovm> findByCdgoAlcovm(Integer cdgoAlcovm);
	public Optional<Tbasg256Alcovm> findByCdgoAlcovm(Integer cdgoAlcovm);

	public List<Tbasg256Alcovm> findByCdgoAlcovmIn(Collection<Integer> cdgoAlcovm);
}
