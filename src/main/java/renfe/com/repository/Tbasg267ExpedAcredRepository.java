package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg267ExpedAcred;

public interface Tbasg267ExpedAcredRepository
		extends JpaRepository<Tbasg267ExpedAcred, Integer>, Tbasg267ExpedAcredRepositoryCustom {

	// Optional<Tbasg267ExpedAcred> findByCdgoAcredita(Integer cdgoAcredita);
	public Optional<Tbasg267ExpedAcred> findByCdgoAcredita(Integer cdgoAcredita);

	public List<Tbasg267ExpedAcred> findByCdgoAcreditaIn(Collection<Integer> cdgoAcredita);
}
