package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg110Psicomoti;

public interface Tbasg110PsicomotiRepository
		extends JpaRepository<Tbasg110Psicomoti, Integer>, Tbasg110PsicomotiRepositoryCustom {

	// Optional<Tbasg110Psicomoti> findByCdgoMotivo(Integer cdgoMotivo);
	public Optional<Tbasg110Psicomoti> findByCdgoMotivo(Integer cdgoMotivo);

	public List<Tbasg110Psicomoti> findByCdgoMotivoIn(Collection<Integer> cdgoMotivo);
}
