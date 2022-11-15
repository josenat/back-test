package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg266EstadoAcre;
import renfe.com.model.entity.Tbasg266EstadoAcrePK;

public interface Tbasg266EstadoAcreRepository
		extends JpaRepository<Tbasg266EstadoAcre, Tbasg266EstadoAcrePK>, Tbasg266EstadoAcreRepositoryCustom {

	// Optional<Tbasg266EstadoAcre> findByTbasg266estadoacrepk(Tbasg266EstadoAcrePK
	// tbasg266estadoacrepk);
	public Optional<Tbasg266EstadoAcre> findById(Tbasg266EstadoAcrePK tbasg266estadoacrepk);

	public List<Tbasg266EstadoAcre> findByTbasg266estadoacrepkIn(Collection<Tbasg266EstadoAcrePK> tbasg266estadoacrepk);
}
