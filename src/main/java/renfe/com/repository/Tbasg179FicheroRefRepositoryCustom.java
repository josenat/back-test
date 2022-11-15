package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg179FicheroRef;

public interface Tbasg179FicheroRefRepositoryCustom {

	public List<Tbasg179FicheroRef> getFicheroRefList();

	public List<Tbasg179FicheroRef> getFicheroRefListByFecha();

	public List<Tbasg179FicheroRef> getFicheroRefListByFechaAsc();

}
