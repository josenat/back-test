package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg101Certpsic;

public interface Tbasg101CertpsicRepository
		extends JpaRepository<Tbasg101Certpsic, Integer>, Tbasg101CertpsicRepositoryCustom {

	// Optional<Tbasg101Certpsic> findByCdgoCertpsic(Integer cdgoCertpsic);
	public Optional<Tbasg101Certpsic> findByCdgoCertpsic(Integer cdgoCertpsic);

	public List<Tbasg101Certpsic> findByCdgoCertpsicIn(Collection<Integer> cdgoCertpsic);
}

