package renfe.com.repository;

import java.util.List;

import renfe.com.model.entity.Tbasg230DestinatariosEmail;

public interface Tbasg230DestinatariosEmailRepositoryCustom {

	public List<Tbasg230DestinatariosEmail> getDestinatariosEmailCount();

	public List<Tbasg230DestinatariosEmail> getDestinatarioDireccionCount(String desgDireccionEmail);

	public List<Tbasg230DestinatariosEmail> getDestinatariosEmailListAscendente();

	public List<Tbasg230DestinatariosEmail> getDestinatariosEmailListDescendente();

	public List<Tbasg230DestinatariosEmail> getDestinatariosEmailListActiveAscendente();

	public List<Tbasg230DestinatariosEmail> getDestinatariosEmailListActiveDescendente();

	public List<Tbasg230DestinatariosEmail> getDestinatariosEmail(String desgDireccionEmail);

	public int insertDestinatariosEmail(Tbasg230DestinatariosEmail bean);

	public int updateDestinatarioEmail(Tbasg230DestinatariosEmail bean);
	
	public int estadoDestinatarioEmail(Tbasg230DestinatariosEmail bean);

	public int updateDestinatarioEmailAreaNull(Tbasg230DestinatariosEmail bean);

}
