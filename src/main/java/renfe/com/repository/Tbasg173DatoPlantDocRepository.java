package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg173DatoPlantDoc;
import renfe.com.model.entity.Tbasg173DatoPlantDocPK;

public interface Tbasg173DatoPlantDocRepository
		extends JpaRepository<Tbasg173DatoPlantDoc, Tbasg173DatoPlantDocPK>, Tbasg173DatoPlantDocRepositoryCustom {

	// Optional<Tbasg173DatoPlantDoc>
	// findByTbasg173datoplantdocpk(Tbasg173DatoPlantDocPK tbasg173datoplantdocpk);
	public Optional<Tbasg173DatoPlantDoc> findById(Tbasg173DatoPlantDocPK tbasg173datoplantdocpk);

	public List<Tbasg173DatoPlantDoc> findByTbasg173datoplantdocpkIn(
			Collection<Tbasg173DatoPlantDocPK> tbasg173datoplantdocpk);
}
