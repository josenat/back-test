package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg169TipoAnotacion;

public interface Tbasg169TipoAnotacionRepository
		extends JpaRepository<Tbasg169TipoAnotacion, String>, Tbasg169TipoAnotacionRepositoryCustom {

	// Optional<Tbasg169TipoAnotacion> findByCdgoTipoanotacion(String
	// cdgoTipoanotacion);
	public Optional<Tbasg169TipoAnotacion> findByCdgoTipoanotacion(String cdgoTipoanotacion);

	public List<Tbasg169TipoAnotacion> findByCdgoTipoanotacionIn(Collection<String> cdgoTipoanotacion);
}
