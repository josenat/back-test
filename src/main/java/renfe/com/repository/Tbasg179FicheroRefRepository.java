package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg179FicheroRef;

public interface Tbasg179FicheroRefRepository
		extends JpaRepository<Tbasg179FicheroRef, Integer>, Tbasg179FicheroRefRepositoryCustom {

	// Optional<Tbasg179FicheroRef> findByCdgoFichero(Integer cdgoFichero);
	public Optional<Tbasg179FicheroRef> findByCdgoFichero(Integer cdgoFichero);

	public List<Tbasg179FicheroRef> findByCdgoFicheroIn(Collection<Integer> cdgoFichero);
}
