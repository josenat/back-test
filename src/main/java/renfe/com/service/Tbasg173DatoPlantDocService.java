package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg173DatoPlantDocDto;

public interface Tbasg173DatoPlantDocService {

	public List<Tbasg173DatoPlantDocDto> getAllTbasg173DatoPlantDoc(Tbasg173DatoPlantDocDto filter);

	public Tbasg173DatoPlantDocDto findByCdgoClaveCdgoDocumento(String cdgoClave, Integer cdgoDocumento);

	public Tbasg173DatoPlantDocDto createTbasg173DatoPlantDoc(Tbasg173DatoPlantDocDto tbasg173DatoPlantDocDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg173DatoPlantDocDto updateTbasg173DatoPlantDoc(String cdgoClave, Integer cdgoDocumento,
			Tbasg173DatoPlantDocDto tbasg173DatoPlantDocDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg173DatoPlantDoc(String cdgoClave, Integer cdgoDocumento);

	public List<Tbasg173DatoPlantDocDto> findByCdgoClaveCdgoDocumentoIn(List<String> cdgoClave,
			List<Integer> cdgoDocumento);

	public List<Tbasg173DatoPlantDocDto> getDatoPlantDocActiveList(String cdgoDocumento);

}
