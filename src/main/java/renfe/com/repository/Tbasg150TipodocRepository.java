package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg150Tipodoc;

public interface Tbasg150TipodocRepository
		extends JpaRepository<Tbasg150Tipodoc, Integer>, Tbasg150TipodocRepositoryCustom {

	// Optional<Tbasg150Tipodoc> findByCdgoTipodoc(Integer cdgoTipodoc);
	public Optional<Tbasg150Tipodoc> findByCdgoTipodoc(Integer cdgoTipodoc);

	public List<Tbasg150Tipodoc> findByCdgoTipodocIn(Collection<Integer> cdgoTipodoc);
}
