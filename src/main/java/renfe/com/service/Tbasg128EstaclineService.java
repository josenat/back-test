package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg128EstaclineDto;
import renfe.com.model.entity.Tbasg128Estacline;

public interface Tbasg128EstaclineService {

	public List<Tbasg128EstaclineDto> getAllTbasg128Estacline(Tbasg128EstaclineDto filter);

	public Tbasg128EstaclineDto findByCdgoEstacionCdgoLinea(String cdgoEstacion, String cdgoLinea);

	public Tbasg128EstaclineDto createTbasg128Estacline(Tbasg128EstaclineDto tbasg128EstaclineDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg128EstaclineDto updateTbasg128Estacline(String cdgoEstacion, String cdgoLinea,
			Tbasg128EstaclineDto tbasg128EstaclineDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg128Estacline(String cdgoEstacion, String cdgoLinea);

	public List<Tbasg128EstaclineDto> findByCdgoEstacionCdgoLineaIn(List<String> cdgoEstacion, List<String> cdgoLinea);

	public List<Tbasg128EstaclineDto> getDatosLinea(String cdgoEstacion, String cdgoAcredita);

	public List<Tbasg128EstaclineDto> getDescTipoAmbitoEstacionLinea(String cdgoEstacion);

	public List<Tbasg128EstaclineDto> getOrdenByLineasEstacionesList(/** FIXME revisar tipo */
	Object cdgoLinea, /** FIXME revisar tipo */
	Object cdgoOrden, /** FIXME revisar tipo */
	Object cdgoOrden_1);

	public List<Tbasg128EstaclineDto> getOrdenByEstacion(/** FIXME revisar tipo */
	Object cdgoLinea, /** FIXME revisar tipo */
	Object cdgoEstacion);

	public List<Tbasg128EstaclineDto> getEntorLineOrdenOrigenDestino(String cdgoEntorno, String cdgoLinea);

	public List<Tbasg128EstaclineDto> getEstacLineList();

	public List<Tbasg128EstaclineDto> getEstacLineCount();

	public List<Tbasg128EstaclineDto> getEstacLineCountByLine(String cdgoLinea);

	public List<Tbasg128EstaclineDto> getEstacLineCountByEstacion(String cdgoEstacion);

	public List<Tbasg128EstaclineDto> getEstacLineListAscendente();
	
	public List<Tbasg128EstaclineDto> getEstacLineListAscCdgoLinea(String cdgoLinea);

	public List<Tbasg128EstaclineDto> getEstacLineListDescendente();

	public List<Tbasg128EstaclineDto> getEstacLineActiveListAscendente();

	public List<Tbasg128EstaclineDto> getEstacLineActiveListDescendente();

	public List<Tbasg128EstaclineDto> getEstacLineMax(String cdgoLinea);

	public List<Tbasg128EstaclineDto> getEstacLineMin(String cdgoLinea);
	
	public List<Tbasg128EstaclineDto> getEstacLineNombre(String cdgoLinea);

	public List<Tbasg128EstaclineDto> getEstacLineMaxByOrden(String cdgoLinea);

	public List<Tbasg128EstaclineDto> getEstacLineMinByOrden(String cdgoLinea);

	public List<Tbasg128EstaclineDto> getEstacLineListByLineDesc(String cdgoLinea);

	public List<Tbasg128EstaclineDto> getEstacLine(String cdgoEstacion, String cdgoLinea);

	public List<Tbasg128EstaclineDto> getEstacLineTramoByPKAsc(String cdgoLinea, String cdgoOrigen, String cdgoDestino);

	public List<Tbasg128EstaclineDto> getEstacLineListByLineAsc(String cdgoLinea);

	public List<Tbasg128EstaclineDto> getEstacLineListByEstacionAsc(String cdgoEstacion);

	public List<Tbasg128EstaclineDto> getEstacLineListByEstacionDesc(String cdgoEstacion);

	public List<Tbasg128EstaclineDto> getEstacLineListActive();

	public int insertEstacLine(Tbasg128Estacline bean);

	public int updateEstacLine(Tbasg128Estacline bean);
	
	public int updateEstacLineCdgoOrden(Tbasg128Estacline bean);
	
	public int estadoEstacLine(Tbasg128Estacline bean);

	public int deleteEstacLine(Tbasg128Estacline bean);

}
