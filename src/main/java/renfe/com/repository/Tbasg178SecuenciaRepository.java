package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg178Secuencia;

public interface Tbasg178SecuenciaRepository
		extends JpaRepository<Tbasg178Secuencia, String>, Tbasg178SecuenciaRepositoryCustom {

	// Optional<Tbasg178Secuencia> findByEntityName(String entityName);
	public Optional<Tbasg178Secuencia> findByEntityName(String entityName);

	public List<Tbasg178Secuencia> findByEntityNameIn(Collection<String> entityName);
}
