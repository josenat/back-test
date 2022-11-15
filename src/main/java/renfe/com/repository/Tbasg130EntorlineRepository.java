package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg130Entorline;
import renfe.com.model.entity.Tbasg130EntorlinePK;

public interface Tbasg130EntorlineRepository
		extends JpaRepository<Tbasg130Entorline, Tbasg130EntorlinePK>, Tbasg130EntorlineRepositoryCustom {

	// Optional<Tbasg130Entorline> findByTbasg130entorlinepk(Tbasg130EntorlinePK
	// tbasg130entorlinepk);
	public Optional<Tbasg130Entorline> findById(Tbasg130EntorlinePK tbasg130entorlinepk);

	public List<Tbasg130Entorline> findByTbasg130entorlinepkIn(Collection<Tbasg130EntorlinePK> tbasg130entorlinepk);
}
