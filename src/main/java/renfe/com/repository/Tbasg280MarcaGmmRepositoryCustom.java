package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg280MarcaGmm;

public interface Tbasg280MarcaGmmRepositoryCustom {

	public List<Tbasg280MarcaGmm> getASG280(String desgMatricula);

	public int insertFicheroASG280(Tbasg280MarcaGmm bean);

}
