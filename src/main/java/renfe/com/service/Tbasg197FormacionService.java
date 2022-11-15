package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg197FormacionDto;
import renfe.com.model.entity.Tbasg197Formacion;

public interface Tbasg197FormacionService {

	public List<Tbasg197FormacionDto> getAllTbasg197Formacion(Tbasg197FormacionDto filter);

	public Tbasg197FormacionDto findByCdgoSolicitud(Integer cdgoSolicitud);

	public Tbasg197FormacionDto createTbasg197Formacion(Tbasg197FormacionDto tbasg197FormacionDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg197FormacionDto updateTbasg197Formacion(Integer cdgoSolicitud,
			Tbasg197FormacionDto tbasg197FormacionDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg197Formacion(Integer cdgoSolicitud);

	public List<Tbasg197FormacionDto> findByCdgoSolicitudIn(List<Integer> cdgoSolicitud);

	public List<Tbasg197FormacionDto> getAlcaForma(String cdgoSolicitud);

	public List<Tbasg197FormacionDto> getFormacionByDniNif(String desgNifpas);

	public List<Tbasg197FormacionDto> getFormacionExpediente(Integer cdgoExpedient);

	public List<Tbasg197FormacionDto> getMaxFormacionExpediente(String cdgoExpedient);

	public List<Tbasg197FormacionDto> getReciclajeExpediente(Integer cdgoExpedient);

	public List<Tbasg197FormacionDto> getReciclajeTituloCond(String cdgoTit);

	public List<Tbasg197FormacionDto> getFormacionValores();

	public int insertFormacion(Tbasg197Formacion bean);

	public int deleteFormacion(Integer cdgoSolicitud);

}
