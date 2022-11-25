package renfe.com.repository;

import java.util.List;
import java.util.Map;

import renfe.com.model.entity.Tbasg123Tipohabil;

public interface Tbasg123TipohabilRepositoryCustom {

	public List<Tbasg123Tipohabil> getTipoHabilList();

	public List<Tbasg123Tipohabil> getTipoHabilListCombo();

	public List<Tbasg123Tipohabil> getTipoHabil(String cdgoTipohab);
	
	public List<Tbasg123Tipohabil> getTipoHabList(Map cdgoTipohab);

}