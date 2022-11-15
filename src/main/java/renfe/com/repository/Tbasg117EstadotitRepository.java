package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg117Estadotit;
import renfe.com.model.entity.Tbasg117EstadotitPK;

public interface Tbasg117EstadotitRepository
		extends JpaRepository<Tbasg117Estadotit, Tbasg117EstadotitPK>, Tbasg117EstadotitRepositoryCustom {

	// Optional<Tbasg117Estadotit> findByTbasg117estadotitpk(Tbasg117EstadotitPK
	// tbasg117estadotitpk);
	public Optional<Tbasg117Estadotit> findById(Tbasg117EstadotitPK tbasg117estadotitpk);

	public List<Tbasg117Estadotit> findByTbasg117estadotitpkIn(Collection<Tbasg117EstadotitPK> tbasg117estadotitpk);
}
