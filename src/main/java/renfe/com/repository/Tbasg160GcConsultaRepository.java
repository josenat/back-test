package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg160GcConsulta;

public interface Tbasg160GcConsultaRepository
		extends JpaRepository<Tbasg160GcConsulta, Integer>, Tbasg160GcConsultaRepositoryCustom {

	// Optional<Tbasg160GcConsulta> findByCdgoConsulta(Integer cdgoConsulta);
	public Optional<Tbasg160GcConsulta> findByCdgoConsulta(Integer cdgoConsulta);

	public List<Tbasg160GcConsulta> findByCdgoConsultaIn(Collection<Integer> cdgoConsulta);
}
