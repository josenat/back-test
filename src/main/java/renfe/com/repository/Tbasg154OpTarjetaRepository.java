package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg154OpTarjeta;
import renfe.com.model.entity.Tbasg154OpTarjetaPK;

public interface Tbasg154OpTarjetaRepository
		extends JpaRepository<Tbasg154OpTarjeta, Tbasg154OpTarjetaPK>, Tbasg154OpTarjetaRepositoryCustom {

	// Optional<Tbasg154OpTarjeta> findByTbasg154optarjetapk(Tbasg154OpTarjetaPK
	// tbasg154optarjetapk);
	public Optional<Tbasg154OpTarjeta> findById(Tbasg154OpTarjetaPK tbasg154optarjetapk);

	public List<Tbasg154OpTarjeta> findByTbasg154optarjetapkIn(Collection<Tbasg154OpTarjetaPK> tbasg154optarjetapk);
}
