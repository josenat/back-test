package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg109Psicoambi;

public interface Tbasg109PsicoambiRepository
		extends JpaRepository<Tbasg109Psicoambi, Integer>, Tbasg109PsicoambiRepositoryCustom {

	// Optional<Tbasg109Psicoambi> findByCdgoPsicamb(Integer cdgoPsicamb);
	public Optional<Tbasg109Psicoambi> findByCdgoPsicamb(Integer cdgoPsicamb);

	public List<Tbasg109Psicoambi> findByCdgoPsicambIn(Collection<Integer> cdgoPsicamb);
}
