package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg175DocOrdenSuspDato;
import renfe.com.model.entity.Tbasg175DocOrdenSuspDatoPK;

public interface Tbasg175DocOrdenSuspDatoRepository extends
		JpaRepository<Tbasg175DocOrdenSuspDato, Tbasg175DocOrdenSuspDatoPK>, Tbasg175DocOrdenSuspDatoRepositoryCustom {

	// Optional<Tbasg175DocOrdenSuspDato>
	// findByTbasg175docordensuspdatopk(Tbasg175DocOrdenSuspDatoPK
	// tbasg175docordensuspdatopk);
	public Optional<Tbasg175DocOrdenSuspDato> findById(Tbasg175DocOrdenSuspDatoPK tbasg175docordensuspdatopk);

	public List<Tbasg175DocOrdenSuspDato> findByTbasg175docordensuspdatopkIn(
			Collection<Tbasg175DocOrdenSuspDatoPK> tbasg175docordensuspdatopk);
}
