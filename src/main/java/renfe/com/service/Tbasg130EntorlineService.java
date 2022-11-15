package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetEntorLineListAscendenteCDGO_ENTORNODTO;
import renfe.com.model.dto.Tbasg130EntorlineDto;
import renfe.com.model.entity.Tbasg130Entorline;

public interface Tbasg130EntorlineService {

	public List<Tbasg130EntorlineDto> getAllTbasg130Entorline(Tbasg130EntorlineDto filter);

	public Tbasg130EntorlineDto findByCdgoDestinoCdgoEntornoCdgoLineaCdgoOrigen(String cdgoDestino, Integer cdgoEntorno,
			String cdgoLinea, String cdgoOrigen);

	public Tbasg130EntorlineDto createTbasg130Entorline(Tbasg130EntorlineDto tbasg130EntorlineDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg130EntorlineDto updateTbasg130Entorline(String cdgoDestino, Integer cdgoEntorno, String cdgoLinea,
			String cdgoOrigen, Tbasg130EntorlineDto tbasg130EntorlineDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg130Entorline(String cdgoDestino, Integer cdgoEntorno, String cdgoLinea, String cdgoOrigen);

	public List<Tbasg130EntorlineDto> findByCdgoDestinoCdgoEntornoCdgoLineaCdgoOrigenIn(List<String> cdgoDestino,
			List<Integer> cdgoEntorno, List<String> cdgoLinea, List<String> cdgoOrigen);

	public List<Tbasg130EntorlineDto> getEntorLineCount();

	public List<Tbasg130EntorlineDto> getEntorLineCountCDGO_ENTORNO(String cdgoEntorno);

	public List<GetEntorLineListAscendenteCDGO_ENTORNODTO> getEntorLineListAscendenteCDGO_ENTORNO(String cdgoEntorno);

	public List<Tbasg130EntorlineDto> getEntorLineListDescendenteCDGO_ENTORNO(String cdgoEntorno);

	public List<Tbasg130EntorlineDto> getEntorLine(String cdgoEntorno, String cdgoLinea, String cdgoOrigen,
			String cdgoDestino);

	public List<Tbasg130EntorlineDto> getEntorLineListActive(String cdgoEntorno);

	public List<Tbasg130EntorlineDto> getEntorLineListDynamic(String cdgoEntorno);

	public int insertEntorLine(Tbasg130Entorline bean);

	public int reactiveEntorLine(Tbasg130Entorline bean);

	public int desactiveEntorLine(Tbasg130Entorline bean);

	public int deleteEntorLine();

	public int deleteTramoLineaEntorno();

	public List<Tbasg130EntorlineDto> getTramosEntorno(String cdgoEntorno);

	public List<Tbasg130EntorlineDto> getTramosEntornos(String cdgoEntorno);

}
