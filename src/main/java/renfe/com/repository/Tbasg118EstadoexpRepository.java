package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg118Estadoexp;
import renfe.com.model.entity.Tbasg118EstadoexpPK;

public interface Tbasg118EstadoexpRepository
		extends JpaRepository<Tbasg118Estadoexp, Tbasg118EstadoexpPK>, Tbasg118EstadoexpRepositoryCustom {

	// Optional<Tbasg118Estadoexp> findByTbasg118estadoexppk(Tbasg118EstadoexpPK
	// tbasg118estadoexppk);
	public Optional<Tbasg118Estadoexp> findById(Tbasg118EstadoexpPK tbasg118estadoexppk);

	public List<Tbasg118Estadoexp> findByTbasg118estadoexppkIn(Collection<Tbasg118EstadoexpPK> tbasg118estadoexppk);
}
