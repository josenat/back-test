package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetPersempParametersDTO;
import renfe.com.model.entity.Tbasg152Persemp;

public interface Tbasg152PersempRepositoryCustom {

	public List<Tbasg152Persemp> getPersonaEmpresa(String cdgoPersona);

	public List<Tbasg152Persemp> getPersonaEmpresaListMantenimiento(String cdgoPersona);

	public int insertPersonaEmpresa(GetPersempParametersDTO bean);

	public int updatePersonaEmpresa(GetPersempParametersDTO bean);

	public int deletePersonaEmpresaMantenimiento(Tbasg152Persemp bean);

	public int updatePersonaEmpresaMantenimiento(Tbasg152Persemp bean);

}
