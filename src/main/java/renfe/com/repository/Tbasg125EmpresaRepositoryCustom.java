package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg125Empresa;

public interface Tbasg125EmpresaRepositoryCustom {

	public List<Tbasg125Empresa> getEmpresaCount();

	public List<Tbasg125Empresa> getEmpresaViewListAscendente();

	public List<Tbasg125Empresa> getEmpresaViewListDescendente();

	public List<Tbasg125Empresa> getEmpresaViewListAscendenteEMPRESA();

	public List<Tbasg125Empresa> getEmpresaViewListDescendenteEMPRESA();

	public List<Tbasg125Empresa> getEmpresaListAscendente();

	public List<Tbasg125Empresa> getEmpresaListDescendente();

	public List<Tbasg125Empresa> getEmpresa(Integer cdgoEmpresa);

	public List<Tbasg125Empresa> getEmpresaCif(String desgCif);

	public List<Tbasg125Empresa> getEmpresaCifInactive(String desgCif);

	public List<Tbasg125Empresa> getEmpresaViewListActive();

	public List<Tbasg125Empresa> getEmpresaComboListActive();

	public int insertEmpresa(Tbasg125Empresa bean);

	public int updateEmpresa(Tbasg125Empresa bean);
	
	public int deleteEmpresa(Tbasg125Empresa bean);
	
	public int reactiveEmpresa(Tbasg125Empresa bean);

	public int unDeleteEmpresa(Tbasg125Empresa bean);

}
