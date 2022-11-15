package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.dto.GetActasPersonaOrderByCdgoActaFormDTO;
import renfe.com.model.entity.Tbasg121Actaforma;

public interface Tbasg121ActaformaRepository
		extends JpaRepository<Tbasg121Actaforma, Integer>, Tbasg121ActaformaRepositoryCustom {

	// Optional<Tbasg121Actaforma> findByCdgoActaform(Integer cdgoActaform);
	public Optional<Tbasg121Actaforma> findByCdgoActaform(Integer cdgoActaform);

	public List<Tbasg121Actaforma> findByCdgoActaformIn(Collection<Integer> cdgoActaform);

}
