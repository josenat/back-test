package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg173DatoPlantDoc;

public interface Tbasg173DatoPlantDocRepositoryCustom {

	public List<Tbasg173DatoPlantDoc> getDatoPlantDocActiveList(String cdgoDocumento);

}
