package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg145Alchaesta;
import renfe.com.model.entity.Tbasg145AlchaestaPK;

public interface Tbasg145AlchaestaRepository
		extends JpaRepository<Tbasg145Alchaesta, Tbasg145AlchaestaPK>, Tbasg145AlchaestaRepositoryCustom {

	// Optional<Tbasg145Alchaesta> findByTbasg145alchaestapk(Tbasg145AlchaestaPK
	// tbasg145alchaestapk);
	public Optional<Tbasg145Alchaesta> findById(Tbasg145AlchaestaPK tbasg145alchaestapk);

	public List<Tbasg145Alchaesta> findByTbasg145alchaestapkIn(Collection<Tbasg145AlchaestaPK> tbasg145alchaestapk);
}
