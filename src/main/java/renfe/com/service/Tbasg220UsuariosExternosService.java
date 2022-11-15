package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.dto.GetUsuarioExternoListAscendenteDTO;
import renfe.com.model.dto.Tbasg220UsuariosExternosDto;
import renfe.com.model.entity.Tbasg220UsuariosExternos;

public interface Tbasg220UsuariosExternosService {

	public List<Tbasg220UsuariosExternosDto> getAllTbasg220UsuariosExternos(Tbasg220UsuariosExternosDto filter);

	public Tbasg220UsuariosExternosDto findByT220CdgoUsuExt(Integer t220CdgoUsuExt);

	public Tbasg220UsuariosExternosDto createTbasg220UsuariosExternos(
			Tbasg220UsuariosExternosDto tbasg220UsuariosExternosDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg220UsuariosExternosDto updateTbasg220UsuariosExternos(Integer t220CdgoUsuExt,
			Tbasg220UsuariosExternosDto tbasg220UsuariosExternosDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg220UsuariosExternos(Integer t220CdgoUsuExt);

	public List<Tbasg220UsuariosExternosDto> findByT220CdgoUsuExtIn(List<Integer> t220CdgoUsuExt);

	public List<Tbasg220UsuariosExternosDto> getUsuarioExternoCount();

	public List<Tbasg220UsuariosExternosDto> getEmpresaDeUsuarioCount(String t220CdgoUsuario);

	public List<GetUsuarioExternoListAscendenteDTO> getUsuarioExternoListAscendente();

	public List<Tbasg220UsuariosExternosDto> getUsuarioExternoListDescendente();

	public List<Tbasg220UsuariosExternosDto> getUsuarioExternoListActiveAscendente();

	public List<Tbasg220UsuariosExternosDto> getUsuarioExternoListActiveDescendente();

	public List<Tbasg220UsuariosExternosDto> getUsuarioExterno(String t220CdgoUsuExt);

	public List<Tbasg220UsuariosExternosDto> getEmpresasDeUsuario(String t220CdgoUsuario);

	public int insertUsuarioExterno(Tbasg220UsuariosExternos bean);

	public int updateUsuarioExterno(Tbasg220UsuariosExternos bean);
	
	public int estadoUsuarioExterno(Tbasg220UsuariosExternos bean);

}
