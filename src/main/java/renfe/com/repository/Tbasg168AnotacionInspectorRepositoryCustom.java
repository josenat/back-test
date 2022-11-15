package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg168AnotacionInspector;

public interface Tbasg168AnotacionInspectorRepositoryCustom {

	public List<Tbasg168AnotacionInspector> getAnotacionInspectorList();

	public List<Tbasg168AnotacionInspector> getAnotacionInspectorListCount();

	public List<Tbasg168AnotacionInspector> getAnotacionInspectorByCdgoAnotacion(String cdgoAnotacion);

}
