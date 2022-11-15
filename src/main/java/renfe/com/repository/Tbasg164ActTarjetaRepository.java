package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg164ActTarjeta;

public interface Tbasg164ActTarjetaRepository
		extends JpaRepository<Tbasg164ActTarjeta, String>, Tbasg164ActTarjetaRepositoryCustom {

	// Optional<Tbasg164ActTarjeta> findByCdgoNumserie(String cdgoNumserie);
	public Optional<Tbasg164ActTarjeta> findByCdgoNumserie(String cdgoNumserie);

	public List<Tbasg164ActTarjeta> findByCdgoNumserieIn(Collection<String> cdgoNumserie);
}
