package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg134Nacion;

public interface Tbasg134NacionRepository
		extends JpaRepository<Tbasg134Nacion, Integer>, Tbasg134NacionRepositoryCustom {

	// Optional<Tbasg134Nacion> findByCdgoNacion(Integer cdgoNacion);
	public Optional<Tbasg134Nacion> findByCdgoNacion(Integer cdgoNacion);

	public List<Tbasg134Nacion> findByCdgoNacionIn(Collection<Integer> cdgoNacion);
}
