package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg183BajaEstacion;
import renfe.com.model.entity.Tbasg183BajaEstacionPK;

public interface Tbasg183BajaEstacionRepository
		extends JpaRepository<Tbasg183BajaEstacion, Tbasg183BajaEstacionPK>, Tbasg183BajaEstacionRepositoryCustom {

	// Optional<Tbasg183BajaEstacion>
	// findByTbasg183bajaestacionpk(Tbasg183BajaEstacionPK tbasg183bajaestacionpk);
	public Optional<Tbasg183BajaEstacion> findById(Tbasg183BajaEstacionPK tbasg183bajaestacionpk);

	public List<Tbasg183BajaEstacion> findByTbasg183bajaestacionpkIn(
			Collection<Tbasg183BajaEstacionPK> tbasg183bajaestacionpk);
}
