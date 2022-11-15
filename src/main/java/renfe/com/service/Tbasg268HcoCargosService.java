package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.List;

import renfe.com.model.dto.Tbasg268HcoCargosDto;
import renfe.com.model.entity.Tbasg268HcoCargos;

public interface Tbasg268HcoCargosService {

	public List<Tbasg268HcoCargosDto> getAllTbasg268HcoCargos(Tbasg268HcoCargosDto filter);

	public Tbasg268HcoCargosDto findByCdgoPersonaFchaInicio(String cdgoPersona, Date fchaInicio);

	public Tbasg268HcoCargosDto createTbasg268HcoCargos(Tbasg268HcoCargosDto tbasg268HcoCargosDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg268HcoCargosDto updateTbasg268HcoCargos(String cdgoPersona, Date fchaInicio,
			Tbasg268HcoCargosDto tbasg268HcoCargosDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg268HcoCargos(String cdgoPersona, Date fchaInicio);

	public List<Tbasg268HcoCargosDto> findByCdgoPersonaFchaInicioIn(List<String> cdgoPersona, List<Date> fchaInicio);

	public List<Tbasg268HcoCargosDto> findByCdgoPersona(String cdgoPersona);

	public List<Tbasg268HcoCargosDto> findByCdgoPersonaCargo(String cdgoPersona);

	public List<Tbasg268HcoCargosDto> findCdgoCargoBeginningK(String cdgoPersona);

	public int insertHstoCargos(String cdgoPersona, Date fchaInicio, Date fchaFin, String desgUsuact, String cdgoCargo);

	public int updateHstoCargos(String cdgoCargo, Date fchaFin, String desgUsuact, String cdgoPersona, Date fchaInicio);

	public int deleteHstoCargos(Tbasg268HcoCargos bean);

}
