package renfe.com.repository;

import java.util.List;

import renfe.com.model.dto.Tbasg128EstaclineDto;
import renfe.com.model.entity.Tbasg128Estacline;

public interface Tbasg128EstaclineRepositoryCustom {

	public List<Tbasg128Estacline> getDatosLinea(String cdgoEstacion, String cdgoAcredita);

	public List<Tbasg128Estacline> getDescTipoAmbitoEstacionLinea(String cdgoEstacion);

	public List<Tbasg128Estacline> getOrdenByLineasEstacionesList(/** FIXME revisar tipo */
	Object cdgoLinea, /** FIXME revisar tipo */
	Object cdgoOrden, /** FIXME revisar tipo */
	Object cdgoOrden_1);

	public List<Tbasg128Estacline> getOrdenByEstacion(/** FIXME revisar tipo */
	Object cdgoLinea, /** FIXME revisar tipo */
	Object cdgoEstacion);

	public List<Tbasg128Estacline> getEntorLineOrdenOrigenDestino(String cdgoEntorno, String cdgoLinea);

	public List<Tbasg128Estacline> getEstacLineList();

	public List<Tbasg128Estacline> getEstacLineCount();

	public List<Tbasg128Estacline> getEstacLineCountByLine(String cdgoLinea);

	public List<Tbasg128Estacline> getEstacLineCountByEstacion(String cdgoEstacion);

	public List<Tbasg128EstaclineDto> getEstacLineListAscendente();
	
	public List<Tbasg128EstaclineDto> getEstacLineListAscCdgoLinea(String cdgoLinea);

	public List<Tbasg128Estacline> getEstacLineListDescendente();

	public List<Tbasg128Estacline> getEstacLineActiveListAscendente();

	public List<Tbasg128Estacline> getEstacLineActiveListDescendente();

	public List<Tbasg128Estacline> getEstacLineMax(String cdgoLinea);

	public List<Tbasg128Estacline> getEstacLineMin(String cdgoLinea);
	
	public List<Tbasg128Estacline> getEstacLineNombre(String cdgoLinea);

	public List<Tbasg128Estacline> getEstacLineMaxByOrden(String cdgoLinea);

	public List<Tbasg128Estacline> getEstacLineMinByOrden(String cdgoLinea);

	public List<Tbasg128Estacline> getEstacLineListByLineDesc(String cdgoLinea);

	public List<Tbasg128Estacline> getEstacLine(String cdgoEstacion, String cdgoLinea);

	public List<Tbasg128Estacline> getEstacLineTramoByPKAsc(String cdgoLinea, String cdgoOrigen, String cdgoDestino);

	public List<Tbasg128Estacline> getEstacLineListByLineAsc(String cdgoLinea);

	public List<Tbasg128Estacline> getEstacLineListByEstacionAsc(String cdgoEstacion);

	public List<Tbasg128Estacline> getEstacLineListByEstacionDesc(String cdgoEstacion);

	public List<Tbasg128Estacline> getEstacLineListActive();

	public int insertEstacLine(Tbasg128Estacline bean);

	public int updateEstacLine(Tbasg128Estacline bean);
	
	public int estadoEstacLine(Tbasg128Estacline bean);

	public int deleteEstacLine(Tbasg128Estacline bean);

}
