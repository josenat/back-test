package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg112Tipoinfra;

public interface Tbasg112TipoinfraRepository
		extends JpaRepository<Tbasg112Tipoinfra, Integer>, Tbasg112TipoinfraRepositoryCustom {

	// Optional<Tbasg112Tipoinfra> findByCdgoTipinfr(Integer cdgoTipinfr);
	public Optional<Tbasg112Tipoinfra> findByCdgoTipinfr(Integer cdgoTipinfr);

	public List<Tbasg112Tipoinfra> findByCdgoTipinfrIn(Collection<Integer> cdgoTipinfr);
}
