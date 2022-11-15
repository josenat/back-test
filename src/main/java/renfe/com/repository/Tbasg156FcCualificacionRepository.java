package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg156FcCualificacion;

public interface Tbasg156FcCualificacionRepository
		extends JpaRepository<Tbasg156FcCualificacion, Integer>, Tbasg156FcCualificacionRepositoryCustom {

	// Optional<Tbasg156FcCualificacion> findByCdgoCualificacion(Integer
	// cdgoCualificacion);
	public Optional<Tbasg156FcCualificacion> findByCdgoCualificacion(Integer cdgoCualificacion);

	public List<Tbasg156FcCualificacion> findByCdgoCualificacionIn(Collection<Integer> cdgoCualificacion);
}
