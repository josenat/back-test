package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg122Instru;

public interface Tbasg122InstruRepository
		extends JpaRepository<Tbasg122Instru, String>, Tbasg122InstruRepositoryCustom {

	// Optional<Tbasg122Instru> findByCdgoNif(String cdgoNif);
	public Optional<Tbasg122Instru> findByCdgoNif(String cdgoNif);

	public List<Tbasg122Instru> findByCdgoNifIn(Collection<String> cdgoNif);

	public List<Tbasg122Instru> getExamiActiveListApe1Ape2Nom();
}
