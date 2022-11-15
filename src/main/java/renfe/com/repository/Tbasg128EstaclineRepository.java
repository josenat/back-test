package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg128Estacline;
import renfe.com.model.entity.Tbasg128EstaclinePK;

public interface Tbasg128EstaclineRepository
		extends JpaRepository<Tbasg128Estacline, Tbasg128EstaclinePK>, Tbasg128EstaclineRepositoryCustom {

	// Optional<Tbasg128Estacline> findByTbasg128estaclinepk(Tbasg128EstaclinePK
	// tbasg128estaclinepk);
	public Optional<Tbasg128Estacline> findById(Tbasg128EstaclinePK tbasg128estaclinepk);

	public List<Tbasg128Estacline> findByTbasg128estaclinepkIn(Collection<Tbasg128EstaclinePK> tbasg128estaclinepk);
}
