package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg182AltaEstacion;
import renfe.com.model.entity.Tbasg182AltaEstacionPK;

public interface Tbasg182AltaEstacionRepository
		extends JpaRepository<Tbasg182AltaEstacion, Tbasg182AltaEstacionPK>, Tbasg182AltaEstacionRepositoryCustom {

	// Optional<Tbasg182AltaEstacion>
	// findByTbasg182altaestacionpk(Tbasg182AltaEstacionPK tbasg182altaestacionpk);
	public Optional<Tbasg182AltaEstacion> findById(Tbasg182AltaEstacionPK tbasg182altaestacionpk);

	public List<Tbasg182AltaEstacion> findByTbasg182altaestacionpkIn(
			Collection<Tbasg182AltaEstacionPK> tbasg182altaestacionpk);
}
