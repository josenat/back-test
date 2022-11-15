package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetPersempParametersDTO;
import renfe.com.model.dto.Tbasg152PersempDto;
import renfe.com.model.entity.Tbasg152Persemp;

public interface Tbasg152PersempService {

	public List<Tbasg152PersempDto> getAllTbasg152Persemp(Tbasg152PersempDto filter);

	public Tbasg152PersempDto findByCdgoEmpresaCdgoPersona(Integer cdgoEmpresa, Integer cdgoPersona);

	public Tbasg152PersempDto createTbasg152Persemp(Tbasg152PersempDto tbasg152PersempDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg152PersempDto updateTbasg152Persemp(Integer cdgoEmpresa, Integer cdgoPersona,
			Tbasg152PersempDto tbasg152PersempDto) throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg152Persemp(Integer cdgoEmpresa, Integer cdgoPersona);

	public List<Tbasg152PersempDto> findByCdgoEmpresaCdgoPersonaIn(List<Integer> cdgoEmpresa,
			List<Integer> cdgoPersona);

	public List<Tbasg152PersempDto> getPersonaEmpresa(String cdgoPersona);

	public List<Tbasg152PersempDto> getPersonaEmpresaListMantenimiento(String cdgoPersona);

	public int insertPersonaEmpresa(GetPersempParametersDTO bean);

	public int updatePersonaEmpresa(GetPersempParametersDTO bean);

	public int deletePersonaEmpresaMantenimiento(Tbasg152Persemp bean);

	public int updatePersonaEmpresaMantenimiento(Tbasg152Persemp bean);

}
