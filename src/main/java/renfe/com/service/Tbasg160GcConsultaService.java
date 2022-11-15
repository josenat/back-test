package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg160GcConsultaDto;
import renfe.com.model.entity.Tbasg160GcConsulta;

public interface Tbasg160GcConsultaService {

	public List<Tbasg160GcConsultaDto> getAllTbasg160GcConsulta(Tbasg160GcConsultaDto filter);

	public Tbasg160GcConsultaDto findByCdgoConsulta(Integer cdgoConsulta);

	public Tbasg160GcConsultaDto createTbasg160GcConsulta(Tbasg160GcConsultaDto tbasg160GcConsultaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg160GcConsultaDto updateTbasg160GcConsulta(Integer cdgoConsulta,
			Tbasg160GcConsultaDto tbasg160GcConsultaDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg160GcConsulta(Integer cdgoConsulta);

	public List<Tbasg160GcConsultaDto> findByCdgoConsultaIn(List<Integer> cdgoConsulta);

	public List<Tbasg160GcConsultaDto> getGcConsultasListActive(String desgUsuario);

	public List<Tbasg160GcConsultaDto> getGcConsulta(String cdgoConsulta);

	public int insertGcConsulta(Tbasg160GcConsulta bean);

	public int updateGcConsulta(Tbasg160GcConsulta bean);

	public int deleteGcConsulta(Tbasg160GcConsulta bean);

}
