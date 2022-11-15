package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg144Nivacceso;

public interface Tbasg144NivaccesoRepositoryCustom {

	//public List<Tbasg144Nivacceso> getNivAccesoCount();
	
	 Long getNivAccesoCount();

	public List<Tbasg144Nivacceso> getNivAccesoAll();

}
