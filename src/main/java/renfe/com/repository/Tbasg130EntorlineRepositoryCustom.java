package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetEntorLineListAscendenteCDGO_ENTORNODTO;
import renfe.com.model.entity.Tbasg130Entorline;

public interface Tbasg130EntorlineRepositoryCustom {

	public List<Tbasg130Entorline> getEntorLineCount();

	public List<Tbasg130Entorline> getEntorLineCountCDGO_ENTORNO(String cdgoEntorno);

	public List<GetEntorLineListAscendenteCDGO_ENTORNODTO> getEntorLineListAscendenteCDGO_ENTORNO(String cdgoEntorno);

	public List<Tbasg130Entorline> getEntorLineListDescendenteCDGO_ENTORNO(String cdgoEntorno);

	public List<Tbasg130Entorline> getEntorLine(String cdgoEntorno, String cdgoLinea, String cdgoOrigen,
			String cdgoDestino);

	public List<Tbasg130Entorline> getEntorLineListActive(String cdgoEntorno);

	public List<Tbasg130Entorline> getEntorLineListDynamic(String cdgoEntorno);

	public int insertEntorLine(Tbasg130Entorline bean);

	public int reactiveEntorLine(Tbasg130Entorline bean);

	public int desactiveEntorLine(Tbasg130Entorline bean);

	public int deleteEntorLine();

	public int deleteTramoLineaEntorno();

	public List<Tbasg130Entorline> getTramosEntorno(String cdgoEntorno);

	public List<Tbasg130Entorline> getTramosEntornos(String cdgoEntorno);

}
