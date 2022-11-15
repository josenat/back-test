package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg197Formacion;

public interface Tbasg197FormacionRepository
		extends JpaRepository<Tbasg197Formacion, Integer>, Tbasg197FormacionRepositoryCustom {

	// Optional<Tbasg197Formacion> findByCdgoSolicitud(Integer cdgoSolicitud);
	public Optional<Tbasg197Formacion> findByCdgoSolicitud(Integer cdgoSolicitud);

	public List<Tbasg197Formacion> findByCdgoSolicitudIn(Collection<Integer> cdgoSolicitud);
}
