package renfe.com.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import renfe.com.model.dto.Tbasg230DestinatariosEmailDto;
import renfe.com.model.entity.Tbasg230DestinatariosEmail;

public interface Tbasg230DestinatariosEmailService {

	public List<Tbasg230DestinatariosEmailDto> getAllTbasg230DestinatariosEmail(Tbasg230DestinatariosEmailDto filter);

	public Tbasg230DestinatariosEmailDto findByDesgDireccionEmail(String desgDireccionEmail);

	public Tbasg230DestinatariosEmailDto createTbasg230DestinatariosEmail(
			Tbasg230DestinatariosEmailDto tbasg230DestinatariosEmailDto)
			throws IllegalAccessException, InvocationTargetException;

	public Tbasg230DestinatariosEmailDto updateTbasg230DestinatariosEmail(String desgDireccionEmail,
			Tbasg230DestinatariosEmailDto tbasg230DestinatariosEmailDto)
			throws IllegalAccessException, InvocationTargetException;

	public int deleteTbasg230DestinatariosEmail(String desgDireccionEmail);

	public List<Tbasg230DestinatariosEmailDto> findByDesgDireccionEmailIn(List<String> desgDireccionEmail);

	public List<Tbasg230DestinatariosEmailDto> getDestinatariosEmailCount();

	public List<Tbasg230DestinatariosEmailDto> getDestinatarioDireccionCount(String desgDireccionEmail);

	public List<Tbasg230DestinatariosEmailDto> getDestinatariosEmailListAscendente();

	public List<Tbasg230DestinatariosEmailDto> getDestinatariosEmailListDescendente();

	public List<Tbasg230DestinatariosEmailDto> getDestinatariosEmailListActiveAscendente();

	public List<Tbasg230DestinatariosEmailDto> getDestinatariosEmailListActiveDescendente();

	public List<Tbasg230DestinatariosEmailDto> getDestinatariosEmail(String desgDireccionEmail);

	public int insertDestinatariosEmail(Tbasg230DestinatariosEmail bean);

	public int updateDestinatarioEmail(Tbasg230DestinatariosEmail bean);
	
	public int estadoDestinatarioEmail(Tbasg230DestinatariosEmail bean);

	public int updateDestinatarioEmailAreaNull(Tbasg230DestinatariosEmail bean);

}
