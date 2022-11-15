package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg165TipoOpTarjeta;

public interface Tbasg165TipoOpTarjetaRepository
		extends JpaRepository<Tbasg165TipoOpTarjeta, String>, Tbasg165TipoOpTarjetaRepositoryCustom {

	// Optional<Tbasg165TipoOpTarjeta> findByCdgoOperacion(String cdgoOperacion);
	public Optional<Tbasg165TipoOpTarjeta> findByCdgoOperacion(String cdgoOperacion);

	public List<Tbasg165TipoOpTarjeta> findByCdgoOperacionIn(Collection<String> cdgoOperacion);
}
