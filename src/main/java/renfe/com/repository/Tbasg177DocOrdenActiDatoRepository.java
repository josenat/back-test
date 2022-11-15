package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg177DocOrdenActiDato;
import renfe.com.model.entity.Tbasg177DocOrdenActiDatoPK;

public interface Tbasg177DocOrdenActiDatoRepository extends
		JpaRepository<Tbasg177DocOrdenActiDato, Tbasg177DocOrdenActiDatoPK>, Tbasg177DocOrdenActiDatoRepositoryCustom {

	// Optional<Tbasg177DocOrdenActiDato>
	// findByTbasg177docordenactidatopk(Tbasg177DocOrdenActiDatoPK
	// tbasg177docordenactidatopk);
	public Optional<Tbasg177DocOrdenActiDato> findById(Tbasg177DocOrdenActiDatoPK tbasg177docordenactidatopk);

	public List<Tbasg177DocOrdenActiDato> findByTbasg177docordenactidatopkIn(
			Collection<Tbasg177DocOrdenActiDatoPK> tbasg177docordenactidatopk);
}
