package renfe.com.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import renfe.com.model.entity.Tbasg105Areactivi;

public interface Tbasg105AreactiviRepository extends JpaRepository<Tbasg105Areactivi, Integer>, Tbasg105AreactiviRepositoryCustom {


    Optional<Tbasg105Areactivi> findByCdgoAreact(Integer cdgoAreact);

	public List<Tbasg105Areactivi> findByCdgoAreactIn(Collection<Integer> cdgoAreact);

	public List<Tbasg105Areactivi> getAllAreAct();

}


//public interface Tbasg105AreactiviRepository
//extends JpaRepository<Tbasg105Areactivi, Integer>, Tbasg105AreactiviRepositoryCustom {
//
//// Optional<Tbasg105Areactivi> findByCdgoAreact(Integer cdgoAreact);
//public Optional<Tbasg105Areactivi> findByCdgoAreact(Integer cdgoAreact);
//
//public List<Tbasg105Areactivi> findByCdgoAreactIn(Collection<Integer> cdgoAreact);
//
//@Query(nativeQuery = true, value = "SELECT DISTINCT S.CDGO_SOCIEDAD		FROM PASG.TBASG105_AREACTIVI A INNER JOIN PASG.TBASG261_SOCIEDADES S ON A.CDGO_SOCIEDAD = S.CDGO_SOCIEDAD "
//	+ "AND A.MRCA_ACTIVO='S'	ORDER BY S.CDGO_SOCIEDAD")
//public List<Tbasg105Areactivi.OnlyCodSociDTO> getCodSociByCodAreaActiv();
//}