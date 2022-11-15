package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg258SocPersona;

public interface Tbasg258SocPersonaRepository
		extends JpaRepository<Tbasg258SocPersona, Integer>, Tbasg258SocPersonaRepositoryCustom {

	// Optional<Tbasg258SocPersona> findByIdSocpersona(Integer idSocpersona);
	public Optional<Tbasg258SocPersona> findByIdSocpersona(Integer idSocpersona);

	public List<Tbasg258SocPersona> findByIdSocpersonaIn(Collection<Integer> idSocpersona);
}
