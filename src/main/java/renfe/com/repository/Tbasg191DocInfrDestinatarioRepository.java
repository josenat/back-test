package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg191DocInfrDestinatario;

public interface Tbasg191DocInfrDestinatarioRepository
		extends JpaRepository<Tbasg191DocInfrDestinatario, Integer>, Tbasg191DocInfrDestinatarioRepositoryCustom {

	// Optional<Tbasg191DocInfrDestinatario> findByCdgoDestinatario(Integer
	// cdgoDestinatario);
	public Optional<Tbasg191DocInfrDestinatario> findByCdgoDestinatario(Integer cdgoDestinatario);

	public List<Tbasg191DocInfrDestinatario> findByCdgoDestinatarioIn(Collection<Integer> cdgoDestinatario);
}
