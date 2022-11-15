package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg137Especiali;

public interface Tbasg137EspecialiRepositoryCustom {

	public List<Tbasg137Especiali> getEspecialiCount();

	public List<Tbasg137Especiali> getEspecialiListAscendente(); 
	
	public List<Tbasg137Especiali> getEspecialiList();

	public List<Tbasg137Especiali> getEspecialiListDescendente();

	public List<Tbasg137Especiali> getEspeciali(Integer cdgoEspec);

	public List<Tbasg137Especiali> getAlcanceEspeciali(Integer cdgoEspec);
	
	public List<Tbasg137Especiali> getEspecialiNombre(String cdgoEspec);

	public List<Tbasg137Especiali> getEspecialiActiveList();

	public int insertEspeciali(Tbasg137Especiali bean);

	public int updateEspeciali(Tbasg137Especiali bean);
	
	public int estadoEspeciali(Tbasg137Especiali bean);

}