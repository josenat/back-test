package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import renfe.com.model.entity.Tbasg100Persona;

public interface Tbasg100PersonaRepository extends JpaRepository<Tbasg100Persona, Integer>, Tbasg100PersonaRepositoryCustom {
	// Optional<Tbasg100Persona> findByCdgoPersona(Integer cdgoPersona);
	public Optional<Tbasg100Persona> findByCdgoPersona(Integer cdgoPersona);

	public List<Tbasg100Persona> findByCdgoPersonaIn(Collection<Integer> cdgoPersona);

}
