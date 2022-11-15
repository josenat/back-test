package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg263TipoEstado;

public interface Tbasg263TipoEstadoRepository
		extends JpaRepository<Tbasg263TipoEstado, String>, Tbasg263TipoEstadoRepositoryCustom {

	// Optional<Tbasg263TipoEstado> findByCdgoEstado(String cdgoEstado);
	public Optional<Tbasg263TipoEstado> findByCdgoEstado(String cdgoEstado);

	public List<Tbasg263TipoEstado> findByCdgoEstadoIn(Collection<String> cdgoEstado);
}
