package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg178Secuencia;

public interface Tbasg178SecuenciaRepositoryCustom {

	public List<Tbasg178Secuencia> getSequence(String entityName);

	public int updateSequence(Tbasg178Secuencia bean);

}
