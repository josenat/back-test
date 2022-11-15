package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg170VehiculoOvm;

public interface Tbasg170VehiculoOvmRepository
		extends JpaRepository<Tbasg170VehiculoOvm, Integer>, Tbasg170VehiculoOvmRepositoryCustom {

	// Optional<Tbasg170VehiculoOvm> findByCdgoVehiculo(Integer cdgoVehiculo);
	public Optional<Tbasg170VehiculoOvm> findByCdgoVehiculo(Integer cdgoVehiculo);

	public List<Tbasg170VehiculoOvm> findByCdgoVehiculoIn(Collection<Integer> cdgoVehiculo);
}
