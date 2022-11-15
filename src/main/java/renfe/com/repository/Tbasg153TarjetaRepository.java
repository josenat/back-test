package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg153Tarjeta;

public interface Tbasg153TarjetaRepository
		extends JpaRepository<Tbasg153Tarjeta, String>, Tbasg153TarjetaRepositoryCustom {

	// Optional<Tbasg153Tarjeta> findByCdgoNumserie(String cdgoNumserie);
	public Optional<Tbasg153Tarjeta> findByCdgoNumserie(String cdgoNumserie);

	public List<Tbasg153Tarjeta> findByCdgoNumserieIn(Collection<String> cdgoNumserie);
}
