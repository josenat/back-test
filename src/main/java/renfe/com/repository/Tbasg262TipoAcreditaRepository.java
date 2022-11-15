package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg262TipoAcredita;

public interface Tbasg262TipoAcreditaRepository
		extends JpaRepository<Tbasg262TipoAcredita, String>, Tbasg262TipoAcreditaRepositoryCustom {

	// Optional<Tbasg262TipoAcredita> findByCdgoTipoacr(String cdgoTipoacr);
	public Optional<Tbasg262TipoAcredita> findByCdgoTipoacr(String cdgoTipoacr);

	public List<Tbasg262TipoAcredita> findByCdgoTipoacrIn(Collection<String> cdgoTipoacr);
}
