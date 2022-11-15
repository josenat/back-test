package renfe.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import renfe.com.model.entity.Tbasg199DatConf;

public interface Tbasg199DatConfRepository extends JpaRepository<Tbasg199DatConf, Integer>, Tbasg199DatConfRepositoryCustom {

	public List<Tbasg199DatConf> SQL_LOAD_VALUES(String nombre);

}
