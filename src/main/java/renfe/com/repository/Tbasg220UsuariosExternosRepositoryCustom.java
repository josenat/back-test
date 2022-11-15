package renfe.com.repository;

import java.util.List;

import renfe.com.dto.GetUsuarioExternoListAscendenteDTO;
import renfe.com.model.entity.Tbasg220UsuariosExternos;

public interface Tbasg220UsuariosExternosRepositoryCustom {

	public List<Tbasg220UsuariosExternos> getUsuarioExternoCount();

	public List<Tbasg220UsuariosExternos> getEmpresaDeUsuarioCount(String t220CdgoUsuario);

	public List<GetUsuarioExternoListAscendenteDTO> getUsuarioExternoListAscendente();

	public List<Tbasg220UsuariosExternos> getUsuarioExternoListDescendente();

	public List<Tbasg220UsuariosExternos> getUsuarioExternoListActiveAscendente();

	public List<Tbasg220UsuariosExternos> getUsuarioExternoListActiveDescendente();

	public List<Tbasg220UsuariosExternos> getUsuarioExterno(String t220CdgoUsuExt);

	public List<Tbasg220UsuariosExternos> getEmpresasDeUsuario(String t220CdgoUsuario);

	public int insertUsuarioExterno(Tbasg220UsuariosExternos bean);

	public int updateUsuarioExterno(Tbasg220UsuariosExternos bean);
	
	public int estadoUsuarioExterno(Tbasg220UsuariosExternos bean);

}
