package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.List;

import renfe.com.model.dto.Tbasg258SocPersonaDto;
import renfe.com.model.entity.Tbasg258SocPersona;

public interface Tbasg258SocPersonaService {

	public List<Tbasg258SocPersonaDto> getAllTbasg258SocPersona(Tbasg258SocPersonaDto filter);

	public Tbasg258SocPersonaDto findByIdSocpersona(Integer idSocpersona);

	public Tbasg258SocPersonaDto createTbasg258SocPersona(Tbasg258SocPersonaDto tbasg258SocPersonaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg258SocPersonaDto updateTbasg258SocPersona(Integer idSocpersona,
			Tbasg258SocPersonaDto tbasg258SocPersonaDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg258SocPersona(Integer idSocpersona);

	public List<Tbasg258SocPersonaDto> findByIdSocpersonaIn(List<Integer> idSocpersona);

	public List<Tbasg258SocPersonaDto> findByCdgoPersona(Integer cdgoPersona);

	public List<Tbasg258SocPersonaDto> findByCdgoPersonaActivo(String cdgoPersona);

	public List<Tbasg258SocPersonaDto> findByCdgoPersonaInActivo(String cdgoPersona);

	public int insertSocPersona(Integer cdgoPersona, String cdgoSociedad, Date fechAlta, Date fechBaja);

	public int updateSocPersona(Integer idSocPersona, String cdgoSociedad, Date fechAlta, Date fechBaja);

}
