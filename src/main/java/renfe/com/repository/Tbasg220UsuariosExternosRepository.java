package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg220UsuariosExternos;

public interface Tbasg220UsuariosExternosRepository
		extends JpaRepository<Tbasg220UsuariosExternos, Integer>, Tbasg220UsuariosExternosRepositoryCustom {

	// Optional<Tbasg220UsuariosExternos> findByT220CdgoUsuExt(Integer
	// t220CdgoUsuExt);
	public Optional<Tbasg220UsuariosExternos> findByT220CdgoUsuExt(Integer t220CdgoUsuExt);

	public List<Tbasg220UsuariosExternos> findByT220CdgoUsuExtIn(Collection<Integer> t220CdgoUsuExt);
}
