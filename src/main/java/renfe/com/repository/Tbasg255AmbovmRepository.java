package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg255Ambovm;

public interface Tbasg255AmbovmRepository
		extends JpaRepository<Tbasg255Ambovm, Integer>, Tbasg255AmbovmRepositoryCustom {

	// Optional<Tbasg255Ambovm> findByCdgoAmbovm(Integer cdgoAmbovm);
	public Optional<Tbasg255Ambovm> findByCdgoAmbovm(Integer cdgoAmbovm);

	public List<Tbasg255Ambovm> findByCdgoAmbovmIn(Collection<Integer> cdgoAmbovm);
}
