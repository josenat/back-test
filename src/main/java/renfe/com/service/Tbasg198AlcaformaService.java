package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg198AlcaformaDto;
import renfe.com.model.entity.Tbasg198Alcaforma;

public interface Tbasg198AlcaformaService {

	public List<Tbasg198AlcaformaDto> getAllTbasg198Alcaforma(Tbasg198AlcaformaDto filter);

	public Tbasg198AlcaformaDto findByCdgoDestinoCdgoLineaCdgoOrigenCdgoSolicitud(String cdgoDestino, String cdgoLinea,
			String cdgoOrigen, Integer cdgoSolicitud);

	public Tbasg198AlcaformaDto createTbasg198Alcaforma(Tbasg198AlcaformaDto tbasg198AlcaformaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg198AlcaformaDto updateTbasg198Alcaforma(String cdgoDestino, String cdgoLinea, String cdgoOrigen,
			Integer cdgoSolicitud, Tbasg198AlcaformaDto tbasg198AlcaformaDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg198Alcaforma(String cdgoDestino, String cdgoLinea, String cdgoOrigen, Integer cdgoSolicitud);

	public List<Tbasg198AlcaformaDto> findByCdgoDestinoCdgoLineaCdgoOrigenCdgoSolicitudIn(List<String> cdgoDestino,
			List<String> cdgoLinea, List<String> cdgoOrigen, List<Integer> cdgoSolicitud);

	public int insertAlcaForma(Tbasg198Alcaforma bean);

	public int deleteAlcaForma(Tbasg198Alcaforma bean);

}
