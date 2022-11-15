package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg157FormacComplemen;
import renfe.com.model.entity.Tbasg157FormacComplemenPK;

public interface Tbasg157FormacComplemenRepository extends
		JpaRepository<Tbasg157FormacComplemen, Tbasg157FormacComplemenPK>, Tbasg157FormacComplemenRepositoryCustom {

	// Optional<Tbasg157FormacComplemen>
	// findByTbasg157formaccomplemenpk(Tbasg157FormacComplemenPK
	// tbasg157formaccomplemenpk);
	public Optional<Tbasg157FormacComplemen> findById(Tbasg157FormacComplemenPK tbasg157formaccomplemenpk);

	public List<Tbasg157FormacComplemen> findByTbasg157formaccomplemenpkIn(
			Collection<Tbasg157FormacComplemenPK> tbasg157formaccomplemenpk);
}
