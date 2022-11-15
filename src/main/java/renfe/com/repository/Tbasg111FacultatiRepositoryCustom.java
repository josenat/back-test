package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg111Facultati;

public interface Tbasg111FacultatiRepositoryCustom {

	public List<Tbasg111Facultati> getFacultati(Integer cdgoFacult);

	public List<Tbasg111Facultati> getFacultatiByNumColegiado(String desgNumcolegiado);

	public List<Tbasg111Facultati> getFacultatiListAscendente();

	public List<Tbasg111Facultati> getFacultatiListDescendente();

	public List<Tbasg111Facultati> getFacultatiViewListAscendente();

	public List<Tbasg111Facultati> getFacultatiViewListDescendente();

	public List<Tbasg111Facultati> getFacultatiActiveListAscendente();

	public List<Tbasg111Facultati> getFacultatiActiveListAscendenteApe1Ape2Nom();

	public List<Tbasg111Facultati> getFacultatiActiveListDescendente();

	public List<Tbasg111Facultati> getFacultatiCount();

	public int insertFacultati(Tbasg111Facultati bean);

	public int updateFacultati(Tbasg111Facultati bean);
	
	public int estadoFacultati(Tbasg111Facultati bean);

}
