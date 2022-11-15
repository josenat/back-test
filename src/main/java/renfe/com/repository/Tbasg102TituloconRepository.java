package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg102Titulocon;

public interface Tbasg102TituloconRepository
		extends JpaRepository<Tbasg102Titulocon, Integer>, Tbasg102TituloconRepositoryCustom {

	// Optional<Tbasg102Titulocon> findByCdgoTit(Integer cdgoTit);
	public Optional<Tbasg102Titulocon> findByCdgoTit(Integer cdgoTit);

	public List<Tbasg102Titulocon> findByCdgoTitIn(Collection<Integer> cdgoTit);
}
