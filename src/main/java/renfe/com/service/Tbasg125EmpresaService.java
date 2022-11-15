package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg125EmpresaDto;
import renfe.com.model.entity.Tbasg125Empresa;

public interface Tbasg125EmpresaService {

	public List<Tbasg125EmpresaDto> getAllTbasg125Empresa(Tbasg125EmpresaDto filter);

	public Tbasg125EmpresaDto findByCdgoEmpresa(Integer cdgoEmpresa);

	public Tbasg125EmpresaDto createTbasg125Empresa(Tbasg125EmpresaDto tbasg125EmpresaDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg125EmpresaDto updateTbasg125Empresa(Integer cdgoEmpresa, Tbasg125EmpresaDto tbasg125EmpresaDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg125Empresa(Integer cdgoEmpresa);

	public List<Tbasg125EmpresaDto> findByCdgoEmpresaIn(List<Integer> cdgoEmpresa);

	public List<Tbasg125EmpresaDto> getEmpresaCount();

	public List<Tbasg125EmpresaDto> getEmpresaViewListAscendente();

	public List<Tbasg125EmpresaDto> getEmpresaViewListDescendente();

	public List<Tbasg125EmpresaDto> getEmpresaViewListAscendenteEMPRESA();

	public List<Tbasg125EmpresaDto> getEmpresaViewListDescendenteEMPRESA();

	public List<Tbasg125EmpresaDto> getEmpresaListAscendente();

	public List<Tbasg125EmpresaDto> getEmpresaListDescendente();

	public List<Tbasg125EmpresaDto> getEmpresa(Integer cdgoEmpresa);

	public List<Tbasg125EmpresaDto> getEmpresaCif(String desgCif);

	public List<Tbasg125EmpresaDto> getEmpresaCifInactive(String desgCif);

	public List<Tbasg125EmpresaDto> getEmpresaViewListActive();

	public List<Tbasg125EmpresaDto> getEmpresaComboListActive();

	public int insertEmpresa(Tbasg125Empresa bean);

	public int updateEmpresa(Tbasg125Empresa bean);
	
	public int deleteEmpresa(Tbasg125Empresa bean);

	public int reactiveEmpresa(Tbasg125Empresa bean);

	public int unDeleteEmpresa(Tbasg125Empresa bean);

}
