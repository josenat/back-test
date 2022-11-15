package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg145Alchaesta;

public interface Tbasg145AlchaestaRepositoryCustom {

	public List<Tbasg145Alchaesta> getAlcHaEstaCount(/** FIXME revisar tipo */
	Object cdgoEntorno);

	public List<Tbasg145Alchaesta> getAlcHaEsta(String cdgoAlchabinf, String cdgoLinea, String cdgoOrigen,
			String cdgoDestino);

	public int insertAlcHaEsta(Tbasg145Alchaesta bean);

	public int deleteAlcHaEsta(Tbasg145Alchaesta bean);

	public int deleteAlcHaEstaByAlchabinf(Tbasg145Alchaesta bean);

}
